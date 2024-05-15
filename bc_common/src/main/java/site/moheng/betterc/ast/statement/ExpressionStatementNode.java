package site.moheng.betterc.ast.statement;

import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.ASTActualNode;
import site.moheng.betterc.ast.ASTExpressionNode;

public record ExpressionStatementNode(
        BCParser.ExpressionStatementContext context,
        ASTExpressionNode expression
) implements ASTExpressionNode, ASTActualNode<BCParser.ExpressionStatementContext> {
}
