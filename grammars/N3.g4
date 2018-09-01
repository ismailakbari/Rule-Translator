/**
 * Define a grammar called N3
 */
grammar N3;

@header{
	package iakbari.ruletranslator.parsers;
}

//boolean is missing

r  : g0 g1 g2 n3_statements_optional EOF;         // match keyword hello followed by an identifier
//PART 1 HEADERS : DECLARATION, UNIVERSAL AND EXISTENTIAL------------------------------------

/*
g0:	 // empty 
	|		 n3_declaration g0
	;
	
the following rule re-structure g0 rule definition	
*/
g0: (n3_declaration)*	
	;
	
n3_declaration:	 '@prefix' PREFIX N3_EXPLICITURI '.'
	|		 	 '@keywords' g8
	|		 	 '@base' N3_EXPLICITURI '.'
	;
	
g8:	 '.'
	|		 BARENAME g11
	;

g11:	 '.'
	|		 ',' BARENAME g11
	;	

g1:	 /* empty */
	|		 n3_universal g1
	;
n3_universal:	 '@forAll' g6
	;
g6:	 '.'
	|		 n3_symbol g9
	;
g9:	 '.'
	|		 ',' n3_symbol g9
	;

g2:	 /* empty */
	|		 n3_existential g2
	;
//n3_existential:	 '@forSome' g7
n3_existential:	 '@forSome' g6
	;
/*
g7:	 '.'
	|		 n3_symbol g10
	;
	
g10:	 '.'
	|		 ',' n3_symbol g10
	;	
*/	
	
//PART 2 N3_STATEMENTS_OPTIONAL-------------------------------------------
	
n3_statements_optional:	 // empty 
	|		 n3_statement '.' n3_statements_optional
	;
/*
the following rule re-structure n3_statements_optional rule definition:	
n3_statements_optional:  (n3_statement '.')* 
	;
*/
n3_statement:	 n3_subject n3_propertylist
	;	
	
n3_subject:	 n3_path
	;
	
n3_path:	 n3_node n3_pathtail
	;
	
n3_node:	 n3_symbol
	|		 '{' n3_formulacontent '}'
	|		 N3_VARIABLE
	|		 N3_NUMERICLITERAL
	|		 n3_literal
	|		 '[' n3_propertylist ']'
	|		 '(' n3_pathlist ')'
	|		 '@this'
	;
	
n3_pathtail:	 /* empty */
	|		 '!' n3_path
	|		 '^' n3_path
	;

n3_formulacontent:	 /* empty */
	|		 g3 g4 g5 n3_statementlist
	;


g3:	 /* empty */
	|		 n3_declaration g3
	;

g4:	 /* empty */
	|		 n3_universal g4
	;

g5:	 /* empty */
	|		 n3_existential g5
	;

n3_statementlist:	 /* empty */
	|		 n3_statement n3_statementtail
	;

n3_statementtail:	 /* empty */
	|		 '.' n3_statementlist
	;

/*
n3_propertylist:	 //empty
	|		 n3_verb n3_object n3_objecttail n3_propertylisttail
	;	
	
the following rule re-structure n3_propertylist rule definition
n3_objecttail : | ',' n3_object n3_objecttail	;
is equal to

n3_objecttail = (',' n3_object)*
so 
n3_object n3_objecttail equals to
n3_object (',' n3_object)*

also
n3_propertylisttail : |';' n3_propertylist ;
so 
n3_propertylist:	 //empty
	|		 n3_verb n3_object (',' n3_object)* (';' n3_propertylist)?

	;
*/
n3_propertylist:	 //empty
	|		 n3_verb n3_object n3_objecttail (';' n3_propertylist)?
	;
	
n3_verb:	 n3_path
	|		 '@has' n3_path
	|		 '@is' n3_path '@of'
	|		 '@a'
	|		 '='
	|		 '=>'
	|		 '<='
	;	
	
n3_object:	 n3_path
	;
	
n3_objecttail:	 //empty
	|		 ',' n3_object n3_objecttail
	;
/*	
n3_propertylisttail:	 // empty 
	|		 ';' n3_propertylist
	;
*/	
n3_pathlist:	 /* empty */
	|		 n3_path n3_pathlist
	;	
	
	
	
	
	
	
	
	
	
	
//--------------------------------------TOKENS------------------------------------------------

n3_symbol:	 N3_EXPLICITURI
	|		 n3_qname   // N3_QNAME is replaced by PREFIX? BARENAME
	;

n3_qname : PREFIX? BARENAME
	;
n3_literal:	 N3_STRING n3_dtlang?
	;
	
n3_dtlang:	 N3_LANGCODE		//N3_DTLAG CAN BE EMPTY. TO REMOVE THE WARNING GIVEN A ? IS ADDED AFTER 'N3_DTLANG' IN N3_LITERAL
	|		 '^^' n3_symbol
	;	
//NUMBERS
N3_NUMERICLITERAL: DECIMAL 	|	DOUBLE |	INTEGER |	RATIONAL;

RATIONAL : INTEGER  '/'  UNSIGNEDINT ;
DECIMAL : INTEGER '.' [0-9]* ;
DOUBLE : INTEGER ('.'UNSIGNEDINT)? ([eE][-+]?INTEGER) ;
INTEGER : [-+]? UNSIGNEDINT ;
UNSIGNEDINT : [0-9]+;






//N3_LANGCODE :  [a-z]+('-'[a-z0-9]+)* ; because it has collision with BARENAME I changed it to the following :
N3_LANGCODE :  '@' [a-z][a-z]('-'[a-z0-9]+)* ;	

N3_STRING :  ('"""')(.|[\s\S])*? ('"""')  
	|		 ('"')(.|[\s\S])*? ('"') 
	;
	
//N3_QNAME : PREFIX? BARENAME ;
//PREFIX : ([A-Z_a-z\u00c0-\u00d6\u00d8-\u00f6\u00f8-\u02ff\u0370-\u037d\u037f-\u1fff\u200c-\u200d\u2070-\u218f\u2c00-\u2fef\u3001-\ud7ff\uf900-\ufdcf\ufdf0-\ufffd\U00010000-\U000effff][\\-0-9A-Z_a-z\u00b7\u00c0-\u00d6\u00d8-\u00f6\u00f8-\u037d\u037f-\u1fff\u200c-\u200d\u203f-\u2040\u2070-\u218f\u2c00-\u2fef\u3001-\ud7ff\uf900-\ufdcf\ufdf0-\ufffd\U00010000-\U000effff]*)? ':' ;
N3_VARIABLE : '?' BARENAME ;
//PREFIX : [a-z]':' ;

PREFIX : (BARENAME)? ':' ; //should be before BARENAME
BARENAME :  [A-Z_a-z\u00c0-\u00d6\u00d8-\u00f6\u00f8-\u02ff\u0370-\u037d\u037f-\u1fff\u200c-\u200d\u2070-\u218f\u2c00-\u2fef\u3001-\ud7ff\uf900-\ufdcf\ufdf0-\ufffd\U00010000-\U000effff] [\\-0-9A-Z_a-z\u00b7\u00c0-\u00d6\u00d8-\u00f6\u00f8-\u037d\u037f-\u1fff\u200c-\u200d\u203f-\u2040\u2070-\u218f\u2c00-\u2fef\u3001-\ud7ff\uf900-\ufdcf\ufdf0-\ufffd\U00010000-\U000effff]* ;

N3_EXPLICITURI: '<' .*? '>';   // N3_EXPLICITURI :: <[^>]*>

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

//comment
COMMENT : '#' .*? ('\n' | '\r') -> skip ;
