package site.moheng.betterc.ast;

import org.jetbrains.annotations.Nullable;
import site.moheng.betterc.ast.ref.InterfaceRefNode;
import site.moheng.betterc.ast.ref.StructRefNode;

public record ImplementDeclarationNode(
        StructRefNode struct,
        @Nullable InterfaceRefNode forInterface
) implements ASTNode, ASTScopeNode {
}
