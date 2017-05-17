grammar Language;

prog
	: declarations* functions* statements*
	;

declarations
	: declaration ';'
	;

declaration
	: (type=TYPE | arrtype=arraytype) assignment  #dclAssign
	| (type=TYPE | arrtype=arraytype) identifier  #declareVariable
	;

arraytype
	: TYPE '['expression']'
	;

//maybe add a #
identifier
	: Word
	| Word'['expression']'
	;

statements
	: statement
	;

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

selection
	: 'if' '(' predicate=expression ')'  '{' block '}'                                          #if
	| 'if' '(' predicate=expression ')'  '{' block '}' 'else' '{' block '}'                     #ifelse
	;

iteration
	: 'while' '(' predicate=expression ')' '{' block '}'                                                    #while
	| 'for' '(' iterator=assignment ';' predicate=expression ';' increment=assignment ')' '{' block '}'     #for
	;

functions
	: functiondeclaration
	;

functiondeclaration
	: TYPE funcname=identifier '(' declaration (',' declaration)* ')' '{' block '}'
	| 'void' funcname=identifier '(' declaration (',' declaration)* ')' '{' block '}'
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
	: op=(COMPLEMENTARY|REVERSE|LENGTH)  '(' expression ')'        #complementary
	|funcname=identifier '(' (expression) (',' (expression))* ')'  #funccall
	;

jump
	: 'break' ';'                   #break
	| 'return' expression ';'       #return
	;

printstatement
	: 'Print' '(' left=expression ')' ';'   #print
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
CONTAINS: 'contains:';
COMPLEMENTARY    : 'comp:';
REVERSE          : 'rev:';
LENGTH           : 'len:';
POSITION         : 'position of ';
COUNT            : 'count ';
REMOVE           : 'remove ';