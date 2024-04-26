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
    )* EOF ;

symbol: id=ID ;
accessSymbol : id+=ID ('.' id+=ID)* ;

importDeclartion: IMPORT uri=STRING (SHOW symbol (',' symbol)*)? (HIDE symbol (',' symbol)*)* (AS symbol)? SEMI;

interfaceMethodField : returnValue=typeExpr name=symbol '(' (args+=uniArgDef (COMMA args+=uniArgDef)*)? ')' SEMI ;
interfaceDeclaration : INTERFACE name=symbol (EXTENDS extends+=accessSymbol ( ',' extends+=accessSymbol)*)? '{' vars+=interfaceMethodField* '}';

structField
    : static=STATIC? count=CONST? type=typeExpr name=symbol ASSIGN value=expression SEMI
    ;
structMethod
    :  methodDeclaration SEMI
    ;
structDeclaration
    : STRUCT name=symbol IMPLEMENT (implementations+=accessSymbol (',' implementations+=accessSymbol)*)?
    '{'
        fields+=structField*
        methods+=structMethod*
    '}' ;

methodDeclaration : returnValue=typeExpr name=symbol '(' (args+=uniArgDef (COMMA args+=uniArgDef)*)? ')' body=bodyStat ;
bodyStat: '{' statements+=statement* '}' ;

statement
    : cycle=( CONST | VAR ) name=symbol (':' type=typeExpr)? ASSIGN value=expression SEMI #VariableDeclarationStatement
    | IF '(' conditions+=expression ')' body+=bodyStat ( ELSE IF '(' conditions+=expression ')' body+=bodyStat)* ( ELSE body+=bodyStat )?  #IfStatement
    | FOR '(' cycle=( CONST | VAR ) name=symbol (':' type=typeExpr)? IN value=expression ')' body=bodyStat #ForInStatement
    | RETURN value=expression SEMI #ReturnStatement
    | value=expression SEMI #ExpressionStatement
    | bodyStat #BodyStatement
    ;

uniArgDef : (type=typeExpr | VAR) name=symbol ;

typeUniArgDef : type=typeExpr name=symbol? ;

typeLiteral
    : '(' (args+=typeUniArgDef (COMMA args+=typeUniArgDef)*)? ')' '=>' return=typeExpr #MethodTypeLiteral
    | type=accessSymbol #SymbolTypeLiteral
    ;

typeExpr
    : type=typeLiteral #TypeLiteralExpression
    | type=typeExpr '<' generics+=typeExpr (COMMA generics+=typeExpr )* '>' #TypeGenericsExpression
    ;

literal
    : value=INT #IntLiteral
    | value=FLOAT #FloatLiteral
    | value=(TRUE | FALSE) #BooleanLiteral
    | value=STRING #StringLiteral
    ;

expression
    : left=expression '(' args+=expression (COMMA args+=expression)* ')' #CallExpression
    | left=accessSymbol ASSIGN expression #VariableAssignment
    | oper=NOT right=expression #NotExpression
    | left=expression oper=AS type=typeExpr #AsExpression
    | left=expression (oper=AND | oper=OR) right=expression #CombinatorialLogicExpression
    | left=expression (oper=EQ | oper=NE | oper=LT | oper=LE | oper=GE | oper=GT) right=expression #ComparativeLogicExpression
    | left=expression (oper=TIMES | oper=DIVIDE | oper=PLUS | oper=LESS) right=expression #MathsExpression
    | accessSymbol #VariableExpression
    | literal #LiteralExpression
    | '(' right=expression ')' #ParenExpression
    | returnValue=typeExpr '(' (args+=uniArgDef (COMMA args+=uniArgDef)*)? ')' '=>' body=bodyStat #ClosureExpression
    ;
