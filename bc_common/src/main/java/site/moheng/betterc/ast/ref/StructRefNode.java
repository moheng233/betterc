package site.moheng.betterc.ast.ref;

import org.jetbrains.annotations.Nullable;
import site.moheng.betterc.ast.ASTNode;
import site.moheng.betterc.ast.StructDeclarationNode;

public record StructRefNode(
        ASTNode parent,
        @Nullable StructDeclarationNode ref
) implements TypeRefNode<StructDeclarationNode> {
}
