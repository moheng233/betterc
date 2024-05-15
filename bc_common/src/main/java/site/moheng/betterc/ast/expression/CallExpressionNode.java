package site.moheng.betterc.ast.expression;

import lombok.NonNull;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.ASTActualNode;
import site.moheng.betterc.ast.ASTExpressionNode;

public record CallExpressionNode(
        @NonNull BCParser.CallExpressionContext context
) implements ASTExpressionNode, ASTActualNode<BCParser.CallExpressionContext> {
}
