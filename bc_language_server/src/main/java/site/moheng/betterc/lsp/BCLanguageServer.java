package site.moheng.betterc.lsp;

import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.TextDocumentSyncKind;
import org.eclipse.lsp4j.services.LanguageServer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public final class BCLanguageServer implements LanguageServer {
    @Override
    public @NotNull CompletableFuture<InitializeResult> initialize(InitializeParams params) {
        final var capabilities = new ServerCapabilities();
        capabilities.setTextDocumentSync(TextDocumentSyncKind.Incremental);

        final var result = new InitializeResult(capabilities);

        return CompletableFuture.completedFuture(result);
    }

    @Override
    public @NotNull CompletableFuture<Object> shutdown() {
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public void exit() {

    }

    @Contract(value = " -> new", pure = true)
    @Override
    public @NotNull BCTextDocumentService getTextDocumentService() {
        return new BCTextDocumentService();
    }

    @Contract(value = " -> new", pure = true)
    @Override
    public @NotNull BCWorkspaceService getWorkspaceService() {
        return new BCWorkspaceService();
    }
}
