package site.moheng.betterc.ast;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import site.moheng.betterc.URIHelper;
import site.moheng.betterc.antlr.BCParser;

public record ImportNode(
        @NonNull BCParser.ImportDeclartionContext context,
        @Nullable String namespace,
        @NonNull String path,
        @Nullable String as
) implements ASTNode, ASTActualNode<BCParser.ImportDeclartionContext> {

    public static @Nullable ImportNode from(@NotNull BCParser.ImportDeclartionContext context) {
        final var result = URIHelper.match(context.uri.getText());
        if (result instanceof URIHelper.URIResult(String namespace, String path)) {
            return new ImportNode(context, namespace, path, null);
        }
        return null;
    }
}
