/**
 * Define a grammar called RIFBLD
 */
grammar RIFBLD;

@header{
	package iakbari.ruletranslator.parsers;
}
//Rule Language:

r: document EOF;
/*
notes: 
//import and rule are reserved keywords in ANTLR so I changed them to import1 and rule1
// I replaced expr and atom with uniterm in the formulae above
//member and frame rules should have space between # and -> signs in the input rules
//respectively. Otherwise the grammar will issue and error. However, it is working fine for
// subclass ## and equal = . I don't know why. I guess it adds - to the previous token (constant) :/
*/   
  
  
  document       : irimeta? 'Document' '(' base? prefix* import1* group? ')'	;
  //document       :  'Document' '(' base? prefix*  ')'	;
  base           : 'Base'  '(' ANGLEBRACKIRI ')'	;
 
  prefix         : 'Prefix'  '(' NCName ANGLEBRACKIRI ')'	;
 
  //import1         : irimeta? 'Import' '(' LOCATOR PROFILE? ')'	;
  //LOCATOR        : ANGLEBRACKIRI	;
  //PROFILE        : ANGLEBRACKIRI	;
   
  import1        : irimeta? 'Import' '(' angle angle? ')'	;
  angle			 : ANGLEBRACKIRI ;
  group          : irimeta? 'Group' '(' (rule1 | group)* ')'	;
  rule1          : (irimeta? 'Forall' Var+ '(' clause ')') 		#forall		// # sign creates separate enter/exit methods for that alternative e.g. enterForall/exitForall 
  					| clause	#fact	//fact is incorrect and another word should be used. cause this can be implies (a rif-bld rule) according to the next parser rule.
  						;				
  clause         : implies | atomic		;
  implies        : irimeta? (atomic | 'And' '(' atomic* ')') ':-' formula	;
  
  



//-----------------------------------------------------------------
//Condition Language:
  formula        : irimeta? 'And' '(' formula* ')' 			#andFormula 
  			 	   | irimeta? 'Or' '(' formula* ')' 		#orFormula
  			 	   | irimeta? 'Exists' Var+ '(' formula ')' #existsFormula
  			 	   | atomic 								#atomicFormula
  			 	   | irimeta? 'External' '(' uniterm ')'	#externalFormula
  			 	 ;
 
 //-----------------------------------------------------------------
   
  atomic         : irimeta? ( equal | member | subclass | uniterm | frame)	;
  
  
  equal          : term '=' term	;
  member         : term '#' term	;
  //member : Var '#' Const ;
  subclass       : term '##' term	;
 
  //-----------------------------------------------------------------
  //Annotations:
  irimeta        : '(*' IRICONST? (frame | 'And' '(' frame* ')')? '*)'	;
  
  frame          : term '[' (term '->' term)* ']'	;
  term			: irimeta? ( const1 | Var | uniterm | list | 'External' '(' uniterm ')')	;
 
  list           : 'List' '(' term* ')' | 'List' '(' term+ '|' term ')'	;
  uniterm        : const1 ('(' (term* | (NCName '->' term)*) ')')	;
  
  //--------------------------LEXER RULES ---------------------------------------
  
  Var            : '?' (NCName | (PN_CHARS_BASE)*) ; 
  
  //IRICONST		 : '"' IRI '"^^' 'rif:iri' ;
  //IRI			 : ('http' | 'https'|'ftp'|'file')':'[-a-zA-Z0-9+&@#/%?=~_|!:,.;]* [-a-zA-Z0-9+&@#/%=~_|]	;
  //iriconst 		 : IRICONST	;
  IRICONST		 : '"'  ('http' | 'https'|'ftp'|'file') ':' [-a-zA-Z0-9+&@#/%?=~_|!:,.;]* [-a-zA-Z0-9+&@#/%=~_|] '"^^' 'rif:iri' ;
  			
  //-----------------------------------------------------------------  
  //Const          : UNICODESTRING '^^' SYMSPACE | CONSTSHORT	;
  //SYMSPACE       : ANGLEBRACKIRI | CURIE	;
  const1           : IRICONST | UNICODESTRING '^^' symspace | constshort	;
  //SYMSPACE       : ANGLEBRACKIRI | CURIE	;
  
  //IRI			 : "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"	;
 
  //-----------------------------------------------------------------
  /*  changed to the grammar below it
  CONSTSHORT      : ANGLEBRACKIRI              // shortcut for "..."^^rif:iri
                  | CURIE                      // shortcut for "..."^^rif:iri
                  | '"' UNICODESTRING '"'      // shortcut for "..."^^xs:string
                  | NumericLiteral             // shortcut for "..."^^xs:integer,xs:decimal,xs:double
                  | '_' NCName                   // shortcut for "..."^^rif:local
                  | '"' UNICODESTRING '"' '@' LANGTAG         ;    // shortcut for "...@..."^^rdf:PlainLiteral
  */  
  constshort      : ANGLEBRACKIRI              // shortcut for "..."^^rif:iri
                  | CURIE                      // shortcut for "..."^^rif:iri
                  | UNICODESTRING
                  | UNICODE   
                  | NCName                     // shortcut for "..."^^rif:local 
                  | NumericLiteral        ;    // shortcut for "..."^^xs:integer,xs:decimal,xs:double
  UNICODE		  : UNICODESTRING '@' ([a-z][a-z]('-'[a-z0-9]+)*) ;	
  //I used N3_STRING from N3 grammar as UNICODESTRING 
  //UNICODESTRING	  :  (.|[\s\S])*? ;
   UNICODESTRING   :  '"' (~["\r\n\\] | ECHAR | UCHAR)* '"' ; //#x22#x5C#xA#xD   
  fragment UCHAR           : '\\u' HEX HEX HEX HEX | '\\U' HEX HEX HEX HEX HEX HEX HEX HEX ; //unicode 
  fragment ECHAR           : '\'[tbnrf]' ;	//escape chars	
  fragment HEX		  	  : [0-9] | [A-F] | [a-f] ; 
  symspace		  : ANGLEBRACKIRI | CURIE ;
  //----------------------------------------------------------------- 
  //ANGLEBRACKIRI : IRI_REF	;
  //IRI_REF 	  :   	'<' ([^<>"{}|^`\]-[#x00-#x20])* '>'	; 
  //ANGLEBRACKIRI	  :   	'<' ~([<>"{}|^`\]|[#x00-#x20])* '>'	;
  //I had to make ANGLEBRACKIRI as a paser rule. otherwise I had problems with import1, Base and Profile rules
  //anglebrackiri   : ANGLEBRACKIRI ;
  ANGLEBRACKIRI	  :   	'<' ~('<'|'>'|'\"'|'{'|'}'|'^'|'`'|'\\'|[\u0000-\u0020])* '>';
  //-----------------------------------------------------------------
  //-----------------------------------------------------------------
  NCName		  :		(PN_CHARS_BASE | '_') 	(PN_CHARS_BASE | '_' | '-' | [0-9] | [#x00B7] | [#x0300-#x036F] | [#x203F-#x2040] )*	;
 
 
  //CURIE           : 	PNAME_LN | PNAME_NS	;
  //PNAME_LN 		  :   	PNAME_NS PN_LOCAL ;
  //CURIE			  : 	PNAME_NS PN_LOCAL? ;
  CURIE			  : 	 (PN_CHARS_BASE ((PN_CHARS_BASE | '_' | '-' | [0-9] | [#x00B7] | [#x0300-#x036F] | [#x203F-#x2040]|'.')* (PN_CHARS_BASE | '_' | '-' | [0-9] | [#x00B7] | [#x0300-#x036F] | [#x203F-#x2040]))?)? ':' (( PN_CHARS_BASE | '_' | [0-9] ) ((PN_CHARS_BASE | '_' | '-' | [0-9] | [#x00B7] | [#x0300-#x036F] | [#x203F-#x2040]|'.')* (PN_CHARS_BASE | '_' | '-' | [0-9] | [#x00B7] | [#x0300-#x036F] | [#x203F-#x2040]))?)? ;
   
  //PN_CHARS 	  	  :   	PN_CHARS_U | '-' | [0-9] | [#x00B7] | [#x0300-#x036F] | [#x203F-#x2040] ;
  //PN_CHARS_U 	  :   	PN_CHARS_BASE | '_'	;
  // PN_CHARS_BASE is same as BARENAME in N3 
  fragment PN_CHARS_BASE   :   	[A-Z] | [a-z] | [#x00C0-#x00D6] | [#x00D8-#x00F6] | [#x00F8-#x02FF] | [#x0370-#x037D] | [#x037F-#x1FFF] | [#x200C-#x200D] | [#x2070-#x218F] | [#x2C00-#x2FEF] | [#x3001-#xD7FF] | [#xF900-#xFDCF] | [#xFDF0-#xFFFD] | [#x10000-#xEFFFF]	;
  
  
  //-----------------------------------------------------------------
 /*
  NCName	   	  :   	NCNameStartChar NCNameChar*		; // An XML Name, minus the ":" 
  //NCNameChar	  :   	NameChar - ':'	;
  NCNameChar	  :   	[A-Z] | '_' | [a-z] | [#xC0-#xD6] | [#xD8-#xF6] | [#xF8-#x2FF] | [#x370-#x37D] | [#x37F-#x1FFF] | [#x200C-#x200D] | [#x2070-#x218F] | [#x2C00-#x2FEF] | [#x3001-#xD7FF] | [#xF900-#xFDCF] | [#xFDF0-#xFFFD] | [#x10000-#xEFFFF]	
  						| '-' | '.' | [0-9] | [#xB7] | [#x0300-#x036F] | [#x203F-#x2040]	;
  //NCNameStartChar :   	NameStartChar - ':'	;
  NCNameStartChar :   	[A-Z] | '_' | [a-z] | [#xC0-#xD6] | [#xD8-#xF6] | [#xF8-#x2FF] | [#x370-#x37D] | [#x37F-#x1FFF] | [#x200C-#x200D] | [#x2070-#x218F] | [#x2C00-#x2FEF] | [#x3001-#xD7FF] | [#xF900-#xFDCF] | [#xFDF0-#xFFFD] | [#x10000-#xEFFFF]	;
  NameChar	  	  :   	NameStartChar | '-' | '.' | [0-9] | [#xB7] | [#x0300-#x036F] | [#x203F-#x2040]	;
  NameStartChar	  :   	':' | [A-Z] | '_' | [a-z] | [#xC0-#xD6] | [#xD8-#xF6] | [#xF8-#x2FF] | [#x370-#x37D] | [#x37F-#x1FFF] | [#x200C-#x200D] | [#x2070-#x218F] | [#x2C00-#x2FEF] | [#x3001-#xD7FF] | [#xF900-#xFDCF] | [#xFDF0-#xFFFD] | [#x10000-#xEFFFF]	;
  */
  //NCName	   	  :   	NCNameStartChar NCNameChar*		; // An XML Name, minus the ":" 
  //NCNameStartChar :		[A-Z] | '_' | [a-z] | [#xC0-#xD6] | [#xD8-#xF6] | [#xF8-#x2FF] | [#x370-#x37D] | [#x37F-#x1FFF] | [#x200C-#x200D] | [#x2070-#x218F] | [#x2C00-#x2FEF] | [#x3001-#xD7FF] | [#xF900-#xFDCF] | [#xFDF0-#xFFFD] | [#x10000-#xEFFFF]	;
 // NCNameChar	  :		NCNameStartChar | '-' | '.' | [0-9] | [#xB7] | [#x0300-#x036F] | [#x203F-#x2040]	;
 // NCName		  :		([A-Z] | '_' | [a-z] | [#xC0-#xD6] | [#xD8-#xF6] | [#xF8-#x2FF] | [#x370-#x37D] | [#x37F-#x1FFF] | [#x200C-#x200D] | [#x2070-#x218F] | [#x2C00-#x2FEF] | [#x3001-#xD7FF] | [#xF900-#xFDCF] | [#xFDF0-#xFFFD] | [#x10000-#xEFFFF])	
  	//					([A-Z] | '_' | [a-z] | [#xC0-#xD6] | [#xD8-#xF6] | [#xF8-#x2FF] | [#x370-#x37D] | [#x37F-#x1FFF] | [#x200C-#x200D] | [#x2070-#x218F] | [#x2C00-#x2FEF] | [#x3001-#xD7FF] | [#xF900-#xFDCF] | [#xFDF0-#xFFFD] | [#x10000-#xEFFFF]
  		//					| '-' | '.' | [0-9] | [#xB7] | [#x0300-#x036F] | [#x203F-#x2040])*	;
 
  //-----------------------------------------------------------------
 //I changed the following grammar  to the NumericLiteral borrowed from  N3 Grammar
 /*
  NumericLiteral   			  :   	NumericLiteralUnsigned | NumericLiteralPositive | NumericLiteralNegative	;
  NumericLiteralUnsigned 	  :   	INTEGER | DECIMAL | DOUBLE	;
  NumericLiteralPositive 	  :   	INTEGER_POSITIVE | DECIMAL_POSITIVE | DOUBLE_POSITIVE	;
  NumericLiteralNegative 	  :   	INTEGER_NEGATIVE | DECIMAL_NEGATIVE | DOUBLE_NEGATIVE	;
  INTEGER 	 		  :   	[0-9]+	;
  DECIMAL 	  		  :   	[0-9]+ '.' [0-9]* | '.' [0-9]+	;
  DOUBLE 	 		  :   	[0-9]+ '.' [0-9]* EXPONENT | '.' ([0-9])+ EXPONENT | ([0-9])+ EXPONENT	;
  INTEGER_POSITIVE 	  :   	'+' INTEGER	;
  DECIMAL_POSITIVE 	  :   	'+' DECIMAL	;
  DOUBLE_POSITIVE 	  :   	'+' DOUBLE	;
  INTEGER_NEGATIVE 	  :   	'-' INTEGER	;
  DECIMAL_NEGATIVE 	  :   	'-' DECIMAL	;
  DOUBLE_NEGATIVE 	  :   	'-' DOUBLE	;
  EXPONENT 	  		  :   	[eE] [+-]? [0-9]+	;
 */
 NumericLiteral: DECIMAL 	|	DOUBLE |	INTEGER ; //|	RATIONAL;

//RATIONAL : INTEGER  '/'  UNSIGNEDINT ;
fragment DECIMAL : INTEGER '.' [0-9]* ;
fragment DOUBLE : INTEGER ('.' UNSIGNEDINT)? ([eE][-+]?INTEGER) ;
fragment INTEGER : [-+]? UNSIGNEDINT ;
fragment UNSIGNEDINT : [0-9]+;
//-------------------------------------------------------------------  

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

//comment
//COMMENT : '//' .*? ('\n' | '\r' | '\n\r') -> skip ;
//MLCOMMENT: 	'/*' (~('*'))* '*/' -> skip ;

