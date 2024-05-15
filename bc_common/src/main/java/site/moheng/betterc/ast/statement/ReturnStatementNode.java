package site.moheng.betterc.ast.statement;

import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.ASTActualNode;
import site.moheng.betterc.ast.ASTExpressionNode;
import site.moheng.betterc.ast.ASTStatementNode;

public record ReturnStatementNode(
        BCParser.ReturnStatementContext context,
        ASTExpressionNode expression
) implements ASTStatementNode, ASTActualNode<BCParser.ReturnStatementContext> {
}
