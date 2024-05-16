// $antlr-format alignTrailingComments true, columnLimit 150, minEmptyLines 1, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine false, allowShortBlocksOnASingleLine true, alignSemicolons hanging, alignColons hanging

grammar BC;

@header {
package site.moheng.betterc.antlr;
}

LAMBDA : '=>' ;
AND : '&&' ;
OR : '||' ;
ASSIGN : '=' ;
DOT : '.' ;
PLUS : '+' ;
LESS : '-' ;
TIMES : '*' ;
DIVIDE : '/' ;
NOT : '!' ;
EQ : '==' ;
NE : '!=' ;
GT : '>' ;
GE : '>=' ;
LT : '<' ;
LE : '<=' ;
COMMA : ',' ;
COLON : ':' ;
SEMI : ';' ;
LPAREN : '(' ;
RPAREN : ')' ;
LCURLY : '{' ;
RCURLY : '}' ;

IMPORT : 'import' ;
SHOW : 'show' ;
HIDE : 'hide' ;
NEW : 'new' ;
AS : 'as' ;
PUBLIC : 'public' ;
PRIVATE : 'private' ;
STATIC : 'static' ;
VAR : 'var' ;
CONST : 'const' ;
RETURN : 'return' ;
IF : 'if' ;
ELSE : 'else' ;
FOR : 'for' ;
IN : 'in' ;
MATCH : 'match' ;
INTERFACE : 'interface' | 'inter' ;
STRUCT : 'struct' ;
IMPLEMENT : 'implement' | 'impl' ;
EXTENDS : 'extends' ;

TRUE : 'true' ;
FALSE : 'false' ;
fragment DIGIT : [0-9] ;
INT : DIGIT+ ;
FLOAT : DIGIT+ DOT DIGIT+ ;
STRING: '"' .*? '"' ;
ID: [a-zA-Z_][a-zA-Z_0-9]*;

LINE_COMMENT : '//' .*? '\r'? '\n' -> channel(HIDDEN);
COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;
WS: [ \t\n\r\f]+ -> skip ;

program
    : imports+=importDeclartion* (
          methods+=methodDeclaration
        | interfaces+=interfaceDeclaration
        | structs+=structDeclaration
        | implements+=implementDeclaration
    )* EOF ;

importDeclartion: IMPORT uri=STRING (SHOW ID (',' ID)*)? (HIDE ID (',' ID)*)* (AS ID)? SEMI;

interfaceMethodField : returnValue=typeExpression name=ID '(' (args+=uniArgDef (COMMA args+=uniArgDef)*)? ')' SEMI ;
interfaceDeclaration : INTERFACE name=ID (EXTENDS extends+=typeExpression ( ',' extends+=typeExpression)*)? '{' vars+=interfaceMethodField* '}';

structField
    : type=typeExpression name=ID SEMI
    ;
structDeclaration
    : STRUCT name=ID (IMPLEMENT implementations+=typeExpression (',' implementations+=typeExpression)*)?
    '{'
        fields+=structField*
    '}' ;

implementDeclaration
    : IMPLEMENT struct=typeExpression ( FOR interface=typeExpression )?
    '{'
        methods+=methodDeclaration*
    '}';

methodDeclaration : returnValue=typeExpression name=ID '(' (args+=uniArgDef (COMMA args+=uniArgDef)*)? ')' body=bodyDeclaration ;
bodyDeclaration: '{' statements+=statement* '}' ;

statement
    : const=CONST? ( VAR | type=typeExpression ) name=ID ASSIGN value=expression SEMI #VariableDeclarationStatement
    | IF '(' conditions+=expression ')' body+=bodyDeclaration ( ELSE IF '(' conditions+=expression ')' body+=bodyDeclaration)* ( ELSE body+=bodyDeclaration )?  #IfStatement
    | FOR '(' cycle=( CONST | VAR ) name=ID (':' type=typeExpression)? IN value=expression ')' body=bodyDeclaration #ForInStatement
    | RETURN value=expression SEMI #ReturnStatement
    | value=expression SEMI #ExpressionStatement
    | bodyDeclaration #BodyStatement
    ;

uniArgDef : (type=typeExpression | VAR) name=ID ;

typeUniArgDef : type=typeExpression name=ID? ;

typeExpression
    : type=ID #TypeAccessExpression
    | '(' (args+=typeUniArgDef (COMMA args+=typeUniArgDef)*)? ')' '=>' return=typeExpression #TypeMethodExpression
    | type=typeExpression '<' generics+=typeExpression (COMMA generics+=typeExpression )* '>' #TypeGenericsExpression
    ;


expression
    : left=expression '(' (args+=expression (COMMA args+=expression)*)? ')' #CallExpression
    | left=expression ASSIGN expression #VariableAssignmentExpression
    | oper=NOT right=expression #NotExpression
    | left=expression oper=AS type=typeExpression #AsExpression
    | left=expression (oper=AND | oper=OR) right=expression #CombinatorialLogicExpression
    | left=expression (oper=EQ | oper=NE | oper=LT | oper=LE | oper=GE | oper=GT) right=expression #ComparativeLogicExpression
    | left=expression (oper=TIMES | oper=DIVIDE) right=expression #MathsExpression
    | left=expression (oper=PLUS | oper=LESS) right=expression #MathsExpression
    | '(' left=expression ')' #ParenExpression
    | left=expression DOT right=ID #PropertyAccessExpression
    | left=ID #VariableAccessExpression
    | value=INT #IntLiteralExpression
    | value=FLOAT #FloatLiteralExpression
    | value=(TRUE | FALSE) #BooleanLiteralExpression
    | value=STRING #StringLiteralExpression
    | returnValue=typeExpression '(' (args+=uniArgDef (COMMA args+=uniArgDef)*)? ')' '=>' body=bodyDeclaration #ClosureExpression
    ;
