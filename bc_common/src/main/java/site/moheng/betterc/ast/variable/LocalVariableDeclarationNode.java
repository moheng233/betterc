package site.moheng.betterc.ast.variable;

import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.ASTActualNode;
import site.moheng.betterc.ast.ASTStatementNode;
import site.moheng.betterc.ast.ASTTypeExpressionNode;
import site.moheng.betterc.ast.ASTVariableDeclaration;

public record LocalVariableDeclarationNode(
        BCParser.VariableDeclarationStatementContext context,
        String name,
        ASTTypeExpressionNode type
) implements ASTVariableDeclaration, ASTStatementNode, ASTActualNode<BCParser.VariableDeclarationStatementContext> {
}
