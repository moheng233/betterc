package site.moheng.betterc.ast;

import lombok.NonNull;
import site.moheng.betterc.antlr.BCParser;

public record InterfaceDeclarationNode(
        @NonNull BCParser.InterfaceDeclarationContext context,
        @NonNull String name
) implements ASTNode, ASTTypeDeclarationNode, ASTActualNode<BCParser.InterfaceDeclarationContext> {
}
