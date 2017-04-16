grammar language;

prog
	: declarations* statements* functions*
	;

declarations
	: (declaration ';')
	;

declaration
	: TYPE assignment
	| TYPE identifier
	| arraytype identifier
	| arraytype assignment
	| assignment
	;

arraytype
	: TYPE '[' ']'
	;

identifier
	: Word
	;

statements
	: statement
	;

statement
	: declaration
	| expression
	| compoundstatement
	| printstatement
	;

//boolexpression
//	: term (operator term)*
//	| term
//	;

compoundstatement
	: iteration
	| selection
	| jump
	;

selection
	: 'if' '(' expression ')'  '{' statements* '}'
	| 'if' '(' expression ')'  '{' statements* '}' 'else' '{' declarations* statements* '}'
	;

iteration
	: 'while' '(' expression ')' '{' statements* '}'
	| 'for' '(' assignment ';' expression ';' expression ')' '{' statements* '}'
	;

functioncall
	: identifier '(' (identifier | expression) (',' (identifier | expression))* ')'
	// identifier '(' TYPE identifier (',' TYPE identifier)* ')'
	//| identifier '(' 'void' identifier (',' TYPE identifier)* ')'
	//| identifier '(' 'void' identifier (',' expression)* ')'
	;

//functionparams
//	: expression (',' expression)
//	;

functions
	: function
	;

function
	: TYPE identifier '(' (TYPE identifier)* ')' '{' declarations* statements* '}' compoundstatement*
	| 'void' identifier '(' (TYPE identifier)* ')' '{' declarations* statements* '}' compoundstatement*
	;

assignment
	: identifier '=' expression
	;

/*postfix
	: INT '++'
	| INT '--'
	;
*/

expression
	: term (operator expression)
	| term
	| '(' expression ')'
	;

term
	: functioncall
	| identifier
	| INT
	| BOOL
	| DNA
	| RNA
	| CODON
	| PROTEIN
	;

jump
	: 'break' ';'
	| 'return' expression ';'
	;

printstatement
	: 'Print' '(' identifier ')'
	;

/*
logicaloperator
	: EQEQ
	| LT
	| GT
	| LTEQ
	| GTEQ
	| AND
	| OR
	;

arithmeticoperator
	: PLUS
	| MINUS
	| MUL
	| DIV
	| MOD
	;
*/
operator
	: PLUS
	| MINUS
	| MUL
	| DIV
	| MOD
	| EQEQ
	| LT
	| GT
	| LTEQ
	| GTEQ
	| AND
	| OR
	;


//*******************
//		Lexer		|
//*******************

TYPE
	: 'dna'
	| 'rna'
	| 'codon'
	| 'protein'
	| 'int'
	| 'bool'
	;

BOOL
	: 'true'
	| 'false'
	;

INT
	: /*('-')?*/ Digit+
	;

DNA
	: DNAsym+
	;

RNA
	: RNAsym+
	;

DNAsym
	: 'A'
	| 'T'
	| 'G'
	| 'C'
	;

RNAsym
	: 'A'
	| 'U'
	| 'G'
	| 'C'
	;

CODON
	: '(' DNAsym ',' DNAsym ',' DNAsym ')'
	| '(' RNAsym ',' RNAsym ',' RNAsym ')'
	;

PROTEIN
	: AMINOACIDSINGLE+
	| AMINOACIDTRIPLE+
	;

AMINOACIDSINGLE
	: '"' 'A' '"'
	| '"' 'C' '"'
	| '"' 'D' '"'
	| '"' 'E' '"'
	| '"' 'F' '"'
	| '"' 'G' '"'
	| '"' 'H' '"'
	| '"' 'I' '"'
	| '"' 'K' '"'
	| '"' 'L' '"'
	| '"' 'M' '"'
	| '"' 'N' '"'
	| '"' 'P' '"'
	| '"' 'Q' '"'
	| '"' 'R' '"'
	| '"' 'S' '"'
	| '"' 'T' '"'
	| '"' 'V' '"'
	| '"' 'W' '"'
	| '"' 'Y' '"'
	;

AMINOACIDTRIPLE
	: '"' 'Ala' '"'
	| '"' 'Cys' '"'
	| '"' 'Asp' '"'
	| '"' 'Glu' '"'
	| '"' 'Phe' '"'
	| '"' 'Gly' '"'
	| '"' 'His' '"'
	| '"' 'Ile' '"'
	| '"' 'Lys' '"'
	| '"' 'Leu' '"'
	| '"' 'Met' '"'
	| '"' 'Asn' '"'
	| '"' 'Pro' '"'
	| '"' 'Gln' '"'
	| '"' 'Arg' '"'
	| '"' 'Ser' '"'
	| '"' 'Thr' '"'
	| '"' 'Val' '"'
	| '"' 'Trp' '"'
	| '"' 'Tyr' '"'
	;

fragment
Digit
	: [0-9]
	;

Word
	: [a-zA-Z_][a-zA-Z_0-9]*
	;

WS
   : [ \r\n\t] -> skip
   ;

LCURLY  : '{' ;
LPAREN  : '(' ;
LBRACK  : '[' ;
RCURLY  : '}' ;
RPAREN  : ')' ;
RBRACK  : ']' ;
COMMA   : ',' ;
COLON   : ':' ;
SEMI    : ';' ;
LT      : '<' ;
GT      : '>' ;
LTEQ    : '<=';
GTEQ    : '>=';
UNDERSCORE : '_' ;
BANG    : '!' ;
AND     : '&' ;
MINUS   : '-' ;
EQUAL   : '=' ;
EQEQ	: '==';
OR      : '|' ;
DIV     : '/' ;
PLUS    : '+' ;
MUL     : '*' ;
MOD		: '%' ;
