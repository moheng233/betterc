package site.moheng.betterc.ast.ref;

import org.jetbrains.annotations.Nullable;
import site.moheng.betterc.ast.ASTNode;
import site.moheng.betterc.ast.InterfaceDeclarationNode;

public record InterfaceRefNode(
        ASTNode parent,
        @Nullable InterfaceDeclarationNode ref
) implements TypeRefNode<InterfaceDeclarationNode> {
}
