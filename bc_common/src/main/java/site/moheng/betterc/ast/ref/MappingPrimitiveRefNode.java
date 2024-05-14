package site.moheng.betterc.ast.ref;

import org.jetbrains.annotations.Nullable;
import site.moheng.betterc.ast.ASTNode;
import site.moheng.betterc.ast.mapping.MappingPrimitiveDeclarationNode;

public record MappingPrimitiveRefNode(
        ASTNode parent,
        @Nullable MappingPrimitiveDeclarationNode ref
) implements TypeRefNode<MappingPrimitiveDeclarationNode> {
}
