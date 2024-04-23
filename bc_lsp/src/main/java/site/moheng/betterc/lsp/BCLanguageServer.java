package site.moheng.betterc.lsp;

import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.services.LanguageServer;

import java.util.concurrent.CompletableFuture;

public class BCLanguageServer implements LanguageServer {
    @Override
    public CompletableFuture<InitializeResult> initialize(InitializeParams params) {
        return null;
    }

    @Override
    public CompletableFuture<Object> shutdown() {
        return null;
    }

    @Override
    public void exit() {

    }

    @Override
    public BCTextDocumentService getTextDocumentService() {
        return null;
    }

    @Override
    public BCWorkspaceService getWorkspaceService() {
        return null;
    }
}
