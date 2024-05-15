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

symbol: id=ID ;

typeAccessRef : id=ID;
variableAccessRef: id = ID #SimpleVariableRef
    | parent=typeAccessRef '::' id=ID #StaticVariableRef
    | parent=variableAccessRef DOT id=ID #StructureVariableRef;

importDeclartion: IMPORT uri=STRING (SHOW symbol (',' symbol)*)? (HIDE symbol (',' symbol)*)* (AS symbol)? SEMI;

interfaceMethodField : returnValue=typeExpr name=symbol '(' (args+=uniArgDef (COMMA args+=uniArgDef)*)? ')' SEMI ;
interfaceDeclaration : INTERFACE name=symbol (EXTENDS extends+=typeAccessRef ( ',' extends+=typeAccessRef)*)? '{' vars+=interfaceMethodField* '}';

structField
    : static=STATIC? count=CONST? type=typeExpr name=symbol ASSIGN value=expression SEMI
    ;
structDeclaration
    : STRUCT name=symbol (IMPLEMENT implementations+=typeAccessRef (',' implementations+=typeAccessRef)*)?
    '{'
        fields+=structField*
    '}' ;

implementMethod
    :  methodDeclaration SEMI
    ;

implementDeclaration
    : IMPLEMENT struct=typeAccessRef ( FOR interface=typeAccessRef )?
    '{'
        methods+=implementMethod*
    '}';

methodDeclaration : returnValue=typeExpr name=symbol '(' (args+=uniArgDef (COMMA args+=uniArgDef)*)? ')' body=bodyDeclaration ;
bodyDeclaration: '{' statements+=statement* '}' ;

statement
    : const=CONST? ( VAR | type=typeExpr ) name=symbol ASSIGN value=expression SEMI #VariableDeclarationStatement
    | IF '(' conditions+=expression ')' body+=bodyDeclaration ( ELSE IF '(' conditions+=expression ')' body+=bodyDeclaration)* ( ELSE body+=bodyDeclaration )?  #IfStatement
    | FOR '(' cycle=( CONST | VAR ) name=symbol (':' type=typeExpr)? IN value=expression ')' body=bodyDeclaration #ForInStatement
    | RETURN value=expression SEMI #ReturnStatement
    | value=expression SEMI #ExpressionStatement
    | bodyDeclaration #BodyStatement
    ;

uniArgDef : (type=typeExpr | VAR) name=symbol ;

typeUniArgDef : type=typeExpr name=symbol? ;

typeLiteral
    : '(' (args+=typeUniArgDef (COMMA args+=typeUniArgDef)*)? ')' '=>' return=typeExpr #MethodTypeLiteral
    | type=typeAccessRef #TypeRef
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
    : left=expression '(' (args+=expression (COMMA args+=expression)*)? ')' #CallExpression
    | left=variableAccessRef ASSIGN expression #VariableAssignment
    | oper=NOT right=expression #NotExpression
    | left=expression oper=AS type=typeExpr #AsExpression
    | left=expression (oper=AND | oper=OR) right=expression #CombinatorialLogicExpression
    | left=expression (oper=EQ | oper=NE | oper=LT | oper=LE | oper=GE | oper=GT) right=expression #ComparativeLogicExpression
    | left=expression (oper=TIMES | oper=DIVIDE) right=expression #MathsExpression
    | left=expression (oper=PLUS | oper=LESS) right=expression #MathsExpression
    | left=variableAccessRef #VariableExpression
    | left=literal #LiteralExpression
    | '(' left=expression ')' #ParenExpression
    | returnValue=typeExpr '(' (args+=uniArgDef (COMMA args+=uniArgDef)*)? ')' '=>' body=bodyDeclaration #ClosureExpression
    ;
