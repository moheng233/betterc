package site.moheng.betterc.ast.mapping;

import lombok.NonNull;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.ASTTypeDeclarationNode;

public record MappingPrimitiveDeclarationNode(
        @NonNull BCParser.ImportDeclartionContext context,
        String name
) implements ASTTypeDeclarationNode {
}
