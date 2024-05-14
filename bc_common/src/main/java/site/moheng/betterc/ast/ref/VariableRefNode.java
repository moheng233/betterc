package site.moheng.betterc.ast.ref;

import org.jetbrains.annotations.Nullable;
import site.moheng.betterc.ast.ASTExpressionNode;
import site.moheng.betterc.ast.ASTNode;
import site.moheng.betterc.ast.ASTRefNode;
import site.moheng.betterc.ast.ASTVariableDeclaration;

public record VariableRefNode(
        ASTNode parent,
        @Nullable ASTVariableDeclaration ref
) implements ASTRefNode<ASTVariableDeclaration>, ASTExpressionNode {
}
