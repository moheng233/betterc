package site.moheng.betterc.ast;

import lombok.NonNull;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jetbrains.annotations.NotNull;

public interface ASTActualNode<T extends ParserRuleContext> extends ASTNode {
    @NonNull
    @NotNull
    T context();
}
