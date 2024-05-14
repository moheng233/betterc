package site.moheng.betterc.ast;

import org.jetbrains.annotations.Nullable;

public record ImportNode(
        String namespace,
        String path,
        @Nullable String as
) implements ASTNode {

}
