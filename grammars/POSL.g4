/**
 * Define a grammar called POSL
 */
grammar POSL;

@header{
	package iakbari.ruletranslator.parsers;
}

/*
options {
    language  = 'java'; 
    // currently using python for testing - this can be changed to any other language that
    // ANTLR supports (altough any actions that are embedded in the grammar will need to 
    // be changed to reflect the language change                     
 
   exportVocab=My;
   k = 3; // 3 tokens of look ahead is required to be able to disambiguate the first two possibilities for the ps rule (pos vs slots).
}
*/

//rulebase:
r:
    (clause)* ;
// Currently a rulebase is defined as 0 or more clauses followed by an end of file charater
// This will likely be expanded in the future to allow for modules

clause:
    atom (IMP atoms)? PERIOD;
// A clause is one atom (the head), optionally followed by the head body separator (:-) and a list 
// of one or more atoms for the body of a rule, followed by a period to end the clause. 
    
atoms:
    atom (COMMA atom)*;
// Defines a list of 1 or more atom - this is 1 atom followed by 0 or more
// repeats of a comma and atom.

atom:
	rel LPAREN oid? (ps)?  RPAREN ;
	//Ismail : In ANTLR v4, gated semantic predicates, { ... }?=>, are no longer available
	// as well as syntactic predicates, ( ... )=>, because the parsing
	// algorithm used in v4 can resolve the ambiguities (there is no need for such predicates anymore). 
    //rel LPAREN (oid => oid | ) (ps)?  RPAREN ;
    // must use backtracking to handle oids - it will first attempt to parse the oid - 
    // if that is successful then it will parse it for real - otherwise it expects nothing in the oid position 
    // an optional parameter list
    
// This defines an atom - this is a relation name, followed by a left parenthesis "(", an optional oid 
// (this must be handled using backtracking instead of the ? operator to make the grammar disambigious)
// an optional parameter list (positional/slotted combination) and a closing right parenthesis ")".

ps:	
      pos (prest)? (SEMI slots)? (srest)? #pos_alt // # sign causes parser to create separate method for that alternative 
      // In this case the parameter list starts with 1 or more positional terms
      // this can optionally be followed by a positional rest parameter, 
      // slotted parameters (separated by a semi-colon (;)), and/or a 
      // slotted rest parameter
    | slots 
        // In this case the parameter list starts with 1 or more slotted parameters
        // there are two sub cases for this rule
        ( 
            (prest (SEMI slots)?)? (srest)? 
            // The first sub-case handles when there are no positional parameters;
            // there can optionally be a positional rest (and then optionally more 
            // slotted parameters) followed by an optional slotted rest parameter.
            | SEMI pos (prest)? (SEMI slots)? (srest)? 
            // The second sub-case handles when tere are positional parameters;
            // first there is a semi-colon then one or more positional parameters,
            // optionally followed by a positional rest parameter, more slotted 
            // parameters, and/or a slotted rest parameter 
        ) #slots_alt
    | prest (SEMI slots)? (srest)? #prest_alt
    // In this case the parameter list starts witha  positional rest parameter
    // It can optionally be followed by slotted parameters and a slotted rest
    | srest #srest_alt
    // The final case is having just a slotted rest parameter
    | atom #atom_alt
    //atom added by Ismail: positional argument can be an atom too e.g.: naf(hello(name)). check 
    // NBBizKBRules.posl clause #5.
    ;
//This is the definition of a slotted/positional argument list combination
// There are several options that describe all valid combinations; the most
// common forms would be the first option and the second option (with 2nd sub-case).

oid:
     term HAT;
// this is an oid; which is defined as a term followed by the hat symbol (^)
// this may be expanded in the future to allow for multiple oids
// While any term can be used, typically inds, variables, or skolems are used

prest:
    PIPE (var | posplex);
// this is a positional rest term - this is a pipe character (|) followed by
// a variable, or a plex that only has positional arguments

srest:
    BANG (var | slotplex);
// this is a slotted rest term - this is a bang charater (!) followed by 
// a variable, or a plex that only has slotted arguments

posplex:
    LBRACK (pos)? (prest)? RBRACK;
// this is a sepcial version of plex that only allows positional terms (this is
// used for the definition of a positional rest).

slotplex:
    LBRACK (slots)? (srest)? RBRACK;
// this is a special version of plex that only allows slotted terms (this is used
// for the definition of slotted rest).

pos:
    term (COMMA term)*; 
// Defines a list of 1 or more positional parameters - this is 1 term followed by 0 
// or more repeats of a comma and term.

slots:
    slot (SEMI slot)*;
// Defines a list of 1 or more slotted parameters - this is 1 slot followed by 0 
// or more repeats of a semi-colon and slot.

slot:
    role ARROW term;
// A slot is defined as being a role name, followed by an arrow (->)
// and any term

term:
      ind
    | var
    | cterm
    | skolem
    | plex
    ;
// A term can be either an ind, var, cterm, skolem, or plex

cterm:
    ctor LBRACK (ps)? RBRACK (COLON type)?;
// A complex term (cterm) is defined as being a constructor name, a
// left bracket ([), an optional list of arguments (can be positional, 
// slotted, or a mixture), followed by a right bracket (]). This can
// optionally be followed by a colon (:) and a type name.

plex:
    LBRACK (ps)? RBRACK;
// A plex is defined as a being a left bracket ([), an optional list
// of arguments (can be positional, slotted, or a mixture), followed 
// by a right bracket (]).

ctor:
    symbol;
    
rel:
    symbol;

role:
    symbol;

type: 
    symbol;
// currently ctor, rel, role, and type are all defined as being a 
// symbol;  these are separated to allow customization of their 
// definitions and the creation of separate actions as necessary. 

ind:
    (symbol (uri)? | uri) (COLON type)?; 
// an ind can be a symbolic name, a uri, or both combined
// this allows for URI grounding (not yet supported in OO jDREW)
// this can optionally be followed by a colon (:) and a type name
        
skolem:
    USCORE (symbol)? (COLON type)?;
// A skolem is defined as being an underscore (_), optionally
// followed by a symbol for a named skolem. This can optionally
// be followed by a colon (:) and a type name

var:
    QMARK (symbol)? (COLON type)?;
// A variable is defined as being a question mark, optionally 
// followed by a symbol for the variable name. This can optionally
// be followed by a colon (:) and a type name

symbol:
      SYMBOL | QSYMBOL;
// a regular symbol in the language can be either a regular Lexar
// symbol, or a quoted lexar symbol

uri:
    URI;
/*
class POSLLexer2 extends Lexer;
options {
   exportVocab=My;
   k=2;
}
*/
PIPE:	'|';
BANG:	'!';
HAT:	'^';
COLON:	':';
SEMI:	';';
LBRACK: '[';
RBRACK: ']';
LPAREN: '(';
RPAREN: ')';
QMARK: '?';
COMMA: ',';
PERIOD: '.';
LBRACE: '{';
RBRACE: '}';
USCORE: '_';

IMP: ':-'; // the symbol that separates the head and body of a rule
ARROW: '->'; // the symbol that separates a role name from the value of a slot

URI:	'<' ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|':'|'/'|'.'|'?'|'&'|'%'|'#'|'-')+ '>';
// this should be replaced with a better URI definition so that it meets the IETF
// standards for URI naming

SYMBOL:  ('-')? ('a'..'z'|'A'..'Z'|'0'..'9'|'$') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'.'|'$')*; 
QSYMBOL: '\"' (~('\"'))* '\"';
// non-quoted symbols must start with a letter or number (or a -, this is to support 
// negative numbers nicely, the first character after the - must still be a letter,
// number, underscore or dollar sign ($) - characters after the first can be a letter, 
// number, _ (underscore), $ (dollar sign) or . (period). any symbol that doesn't meet 
// this criteria must placed in quotation marks (") currently there is no escape symbol, 
// so it is not possible to have a symbol that contains special characters or a quotation 
// mark (")


COMMENT:
	'%' (~('\n'))*  -> skip ;
    //'%' (~('\n'))* { $skip };  
// Single-line comments are denoted by % - the remainder of the line is ignored

MLCOMMENT:
	'/%' (~('%'))* '%/' -> skip ;
    //'/%' (~('%'))* '%/' { $skip };
// Multi line comments are denoted by /% .... %/ - the comment body cannot contain the % character

WS:
	(' '
	| '\t'
	| '\r' '\n' 
	| '\n'      
	)
	-> skip
	;

/*
WS:
	(' '
	| '\t'
	| '\r' '\n' { $newline }
	| '\n'      { $newline }
	)
	{ $skip }
	;
	 
*/
// Skip all white space - make sure that newlines are counted properly 
// so that the lines are reported correctly in error messages if needed.
