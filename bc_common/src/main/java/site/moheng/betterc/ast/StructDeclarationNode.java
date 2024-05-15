package site.moheng.betterc.ast;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import site.moheng.betterc.antlr.BCParser;

import java.util.Set;

@Builder
public record StructDeclarationNode(
        @NonNull BCParser.StructDeclarationContext context,
        String name,
        @Singular Set<StructFieldDeclarationNode> fields,
        @Singular Set<StructFieldDeclarationNode> staticFields
) implements ASTNode, ASTTypeDeclarationNode, ASTScopeNode, ASTActualNode<BCParser.StructDeclarationContext> {
}
