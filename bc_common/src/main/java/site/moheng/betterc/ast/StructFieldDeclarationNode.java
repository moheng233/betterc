package site.moheng.betterc.ast;

import lombok.NonNull;
import site.moheng.betterc.antlr.BCParser;

public record StructFieldDeclarationNode(
        @NonNull BCParser.StructFieldContext context,
        String name,
        ASTTypeExpressionNode type
) implements ASTNodeHasNamed, ASTActualNode<BCParser.StructFieldContext> {
}
