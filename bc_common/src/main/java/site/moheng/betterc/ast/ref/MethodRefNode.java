package site.moheng.betterc.ast.ref;

import org.jetbrains.annotations.Nullable;
import site.moheng.betterc.ast.ASTMethodDeclarationNode;
import site.moheng.betterc.ast.ASTNode;

public record MethodRefNode(
        ASTNode parent,
        @Nullable ASTMethodDeclarationNode ref
) implements TypeRefNode<ASTMethodDeclarationNode> {
}
