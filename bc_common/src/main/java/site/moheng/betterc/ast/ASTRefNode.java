package site.moheng.betterc.ast;

import org.jetbrains.annotations.Nullable;

public interface ASTRefNode<T extends ASTNode> extends ASTNode {
    @Nullable
    T ref();
}
