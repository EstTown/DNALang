grammar Language;

prog
	: (declarations | statements | functions)*
	;

declarations
	: declaration ';'
	;

declaration
	: (type=TYPE | arrtype=arraytype) assignment  #dclAssign
	| (type=TYPE | arrtype=arraytype) identifier  #declareVariable
	//| assignment                      #assign //this is moved to statement
	;

arraytype
	: TYPE '[' ']'
	;

identifier
	: Word
	;

statements
	: statement     //#stmts
	;

/*
statement
	: assignment            //#assign
	| compoundstatement     //#compoundstmt
	| expression ';'        //#expr
	| printstatement        //#printstmt
	;
*/
//So I need a block. According to abstract syntax, a block can be declarations and statements
block
    : declarations* statements*
    ;

statement
	: assignment ';'        #assign
	| compoundstatement     #compoundstmt
	| expression ';'        #expr
	| printstatement        #printstmt
	;

compoundstatement
	: iteration
	| selection
	| jump
	;

/*
selection
	: 'if' '(' predicate=expression ')'  '{' declarations* statements* '}'                                          #if
	| 'if' '(' predicate=expression ')'  '{' declarations* statements* '}' 'else' '{' declarations* statements* '}' #ifelse
	;
*/
//rewriting selection with blocks
selection
	: 'if' '(' predicate=expression ')'  '{' block '}'                                          #if
	| 'if' '(' predicate=expression ')'  '{' block '}' 'else' '{' block '}'                     #ifelse
	;

/*
iteration
	: 'while' '(' predicate=expression ')' '{'declarations* statements* '}'                                                    #while
	| 'for' '(' iterator=assignment ';' predicate=expression ';' increment=assignment ')' '{' declarations* statements* '}'    #for
	;
*/
//rewriting iteration with blocks
iteration
	: 'while' '(' predicate=expression ')' '{' block '}'                                                    #while
	| 'for' '(' iterator=assignment ';' predicate=expression ';' increment=assignment ')' '{' block '}'     #for
	;


functions
	: functiondeclaration
	;

/*
function
	: TYPE identifier '(' TYPE identifier (',' TYPE identifier)* ')' '{' declarations* statements* jump'}'
	| 'void' identifier '(' TYPE identifier (','TYPE identifier)* ')' '{' declarations* statements* '}'
	;
*/
//rewriting function
functiondeclaration
	: TYPE funcname=identifier '(' declaration (',' declaration)* ')' '{' declarations* statements* jump'}'
	| 'void' funcname=identifier '(' declaration (',' declaration)* ')' '{' declarations* statements* '}'
	;



assignment
	: left=identifier op='=' right=expression //';' cannot have semi-colon here, because it ruins for loops
	;


/*
expression
	: term (operator expression)    #termExp
	| term                          #singleTerm
	| '(' expression ')'            #parensExp
	;
*/

//rewriting expression
    /*
expression
    : LPAREN expression RPAREN                   //#parensExp
    | <assoc=right> NOT expression               //#unaryExp    //I think this one is now right associative, not sure how to check if correct
    | left=expression op=(MUL|DIV|MOD) right=expression     //#binaryExp
    | left=expression op=(ADD|SUB) right=expression         //#binaryExp
    | left=expression op=(LT|GT|LTEQ|GTEQ) right=expression //#binaryExp
    | left=expression op=(EQEQ|NOTEQ) right=expression      //#binaryExp
    | left=expression AND  right=expression                 //#binaryExp
    | left=expression OR right=expression                   //#binaryExp
    | functioncall                               //#functionallExp
    | identifier                                 //#variableExp
    | INT                                        //#numberExp
    | BOOL                                       //#boolExp
    | DNA                                        //#dnaExp
    | RNA                                        //#rnaExp
    | CODON                                      //#codonExp
    | PROTEIN                                    //#proteinExp
    ;
    */

expression
    : LPAREN expression RPAREN                              #parensExp
    | <assoc=right> op=NOT expression                       #unaryExp    //I think this one is now right associative, not sure how to check if correct
    | left=expression op=(MUL|DIV|MOD) right=expression     #binaryExp
    | left=expression op=(ADD|SUB) right=expression         #binaryExp
    | left=expression op=(LT|GT|LTEQ|GTEQ) right=expression #binaryExp
    | left=expression op=(EQEQ|NOTEQ) right=expression      #binaryExp
    | left=expression op=AND  right=expression              #binaryExp
    | left=expression op=OR right=expression                #binaryExp
    | functioncall                               #functioncallExp
    | identifier                                 #variableExp
    | INT                                        #numberExp
    | BOOL                                       #boolExp
    | DNA                                        #dnaExp
    | RNA                                        #rnaExp
    | CODON                                      #codonExp
    | PROTEIN                                    #proteinExp
    ;

functioncall
	: funcname=identifier '(' (expression) (',' (expression))* ')'
	;
/*
functioncall
	: funcname=identifier '(' (identifier | expression) (',' (identifier | expression))* ')'
	;
	//expression can already be rewritten as identifier, so why even have identifier?
*/
/*
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
*/

jump
	: 'break' ';'                   #break
	| 'return' expression ';'       #return
	;

printstatement
	: 'Print' '(' left=identifier ')' ';'   #print
	;


/*
operator
    : MUL
    | DIV
    | ADD
    | SUB
    | LT
    | GT
    | LTEQ
    | GTEQ
    | AND
    | OR
    ;

*/

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

/*
Word
	: ([a-z]|[A-Z_])[a-zA-Z_0-9]*
	;
*/

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
NOT    : '!' ;
AND     : '&&' ;
SUB     : '-' ;
EQUAL   : '=' ;
EQEQ	: '==';
NOTEQ   : '!=';
OR      : '||' ;
DIV     : '/' ;
ADD     : '+' ;
MUL     : '*' ;
MOD		: '%' ;
