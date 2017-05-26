grammar Language;

prog
	: declarations* functions* statements* EOF
	;

declarations
	: declaration SEMI
	;

declaration
	: (type=TYPE | arrtype=arraytype) assignment  #dclAssign
	| (type=TYPE | arrtype=arraytype) identifier  #declareVariable
	;

arraytype
	: TYPE LBRACK expression RBRACK
	;

//maybe add a #
identifier
	: Word
	| Word
	;

statements
	: statement
	;


block
    : declarations* statements*
    ;

//redefining block, because of formal parameters for functiondeclarations is in wrong scope
/*
block
    : declarations* statements*
    |
    ;
*/

statement
	: assignment SEMI        #assign
	| compoundstatement     #compoundstmt
	| expression SEMI        #expr
	| printstatement        #printstmt
	;

compoundstatement
	: iteration
	| selection
	| jump
	;

selection
	: 'if' LPAREN predicate=expression RPAREN  LCURLY block RCURLY                                          #if
	| 'if' LPAREN predicate=expression RPAREN  LCURLY block RCURLY 'else' LCURLY block RCURLY                     #ifelse
	;

iteration
	: 'while' LPAREN predicate=expression RPAREN LCURLY block RCURLY                                                    #while
	| 'for' LPAREN iterator=assignment SEMI predicate=expression SEMI increment=assignment RPAREN LCURLY block RCURLY     #for
	;

functions
	: functiondeclaration
	;

functiondeclaration
	:
	TYPE funcname=identifier LPAREN declaration (COMMA declaration)* RPAREN LCURLY block RCURLY
	//| 'void' funcname=identifier '(' declaration (',' declaration)* ')' '{' block '}'
	;

assignment
	: left=identifier op='=' right=expression
	;

expression
    : LPAREN expression RPAREN                              #parensExp
    | left=expression 'as' TYPE                             #convertExp  //this is a conversion of whatever the value of the expression is, to some type
    | <assoc=right> op=NOT expression                       #unaryExp    //I think this one is now right associative, not sure how to check if correct
    | left=expression op=CONTAINS right=expression          #binaryExp
    |  (op=(POSITION|COUNT) left=expression 'in' right=expression | op=REMOVE  left=expression 'from' right=expression) #binaryExp
    | left=expression op=(MUL|DIV|MOD) right=expression     #binaryExp
    | left=expression op=(ADD|SUB) right=expression         #binaryExp
    | left=expression op=(LT|GT|LTEQ|GTEQ) right=expression #binaryExp
    | left=expression op=(EQEQ|NOTEQ) right=expression      #binaryExp
    | left=expression op=AND  right=expression              #binaryExp
    | left=expression op=OR right=expression                #binaryExp
    | functioncall                                          #functioncallExp
    | first=expression LBRACK second=expression RBRACK                #getExp
    | identifier                                 #variableExp
    | INT                                        #numberExp
    | BOOL                                       #boolExp
    | DNA                                        #dnaExp
    | RNA                                        #rnaExp
    | CODON                                      #codonExp
    | PROTEIN                                    #proteinExp
    ;

functioncall
	: op=(COMPLEMENTARY|REVERSE|LENGTH)  LPAREN expression RPAREN        #complementary
	|funcname=identifier LPAREN (expression) (COMMA (expression))* RPAREN  #funccall
	;

jump
	: 'break' SEMI                   #break
	| 'return' expression SEMI      #return
	;

printstatement
    :'Print' LPAREN expression? RPAREN SEMI                              #print
    |'Print' LPAREN expression COMMA expression RPAREN SEMI                #print
	|'Print' LPAREN expression COMMA expression COMMA expression RPAREN SEMI   #print
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
	: '"'AMINOACIDSINGLE+'"'
	| '"'AMINOACIDTRIPLE+'"'
	;

AMINOACIDSINGLE
	: 'A'
	| 'C'
	| 'D'
	| 'E'
	| 'F'
	| 'G'
	| 'H'
	| 'I'
	| 'K'
	| 'L'
	| 'M'
	| 'N'
	| 'P'
	| 'Q'
	| 'R'
	| 'S'
	| 'T'
	| 'V'
	| 'W'
	| 'Y'
	;

AMINOACIDTRIPLE
	: 'Ala'
	| 'Cys'
	| 'Asp'
	| 'Glu'
	| 'Phe'
	| 'Gly'
	| 'His'
	| 'Ile'
	| 'Lys'
	| 'Leu'
	| 'Met'
	| 'Asn'
	| 'Pro'
	| 'Gln'
	| 'Arg'
	| 'Ser'
	| 'Thr'
	| 'Val'
	| 'Trp'
	| 'Tyr'
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
CONTAINS: ' contains ';
COMPLEMENTARY    : 'comp:';
REVERSE          : 'rev:';
LENGTH           : 'len:';
POSITION         : 'position of ';
COUNT            : 'count ';
REMOVE           : 'remove ';