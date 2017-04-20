grammar Language;

prog
	: declarations* statements* functions*
	;

declarations
	: (declaration ';')
	;

declaration
	: (TYPE | arraytype) assignment     #dclAssign
	| (TYPE | arraytype) identifier     #dcl
	| assignment      +                  #assign
	;

arraytype
	: TYPE '[' ']'
	;

identifier
	: Word                              #id
	;

statements
	: statement
	;

statement
	: declaration
	| compoundstatement
	| expression
	| printstatement
	;


compoundstatement
	: iteration
	| selection
	| jump
	;

selection
	: 'if' '(' expression ')'  '{' declarations* statements* '}'                                            #if
	| 'if' '(' expression ')'  '{' declarations* statements* '}' 'else' '{' declarations* statements* '}'   #ifelse
	;

iteration
	: 'while' '(' expression ')' '{' statements* '}'                                #while
	| 'for' '(' assignment ';' expression ';' expression ')' '{' statements* '}'    #for
	;

functioncall
	: identifier '(' (identifier | expression) (',' (identifier | expression))* ')' #funcCall
	;

functions
	: function
	;

function
	: TYPE identifier '(' (TYPE identifier)* ')' '{' declarations* statements* '}' compoundstatement*   #func
	| 'void' identifier '(' (TYPE identifier)* ')' '{' declarations* statements* '}' compoundstatement* #voidfunc
	;

assignment
	: identifier '=' expression
	;

expression
	: term (operator expression)    #termExp
	| term                          #singleTerm
	| '(' expression ')'            #parensExp
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
	: 'break' ';'                   #break
	| 'return' expression ';'       #return
	;

printstatement
	: 'Print' '(' identifier ')'    #print
	;

operator
	: ADD
	| SUB
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
SUB     : '-' ;
EQUAL   : '=' ;
EQEQ	: '==';
OR      : '|' ;
DIV     : '/' ;
ADD     : '+' ;
MUL     : '*' ;
MOD		: '%' ;
