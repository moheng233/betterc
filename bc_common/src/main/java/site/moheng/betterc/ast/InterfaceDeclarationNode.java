package site.moheng.betterc.ast;

import lombok.NonNull;
import site.moheng.betterc.antlr.BCParser;

public record InterfaceDeclarationNode(
        @NonNull BCParser.InterfaceDeclarationContext context,
        @NonNull String name
) implements ASTNode, ASTTypeDeclarationNode, ASTActualNode<BCParser.InterfaceDeclarationContext> {
    public static InterfaceDeclarationNode from(ASTBuilderContext util, @NonNull BCParser.InterfaceDeclarationContext context) {
        final var name = context.name.getText();
        return new InterfaceDeclarationNode(context, name);
    }
}
