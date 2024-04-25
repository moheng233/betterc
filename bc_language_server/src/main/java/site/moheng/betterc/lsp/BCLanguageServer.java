package site.moheng.betterc.lsp;

import java.util.concurrent.CompletableFuture;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.TextDocumentSyncKind;
import org.eclipse.lsp4j.services.LanguageServer;

public class BCLanguageServer implements LanguageServer {
  @Override
  public CompletableFuture<InitializeResult> initialize(InitializeParams params) {
    final var capabilities = new ServerCapabilities();
    capabilities.setTextDocumentSync(TextDocumentSyncKind.Incremental);

    final var result = new InitializeResult(capabilities);

    return CompletableFuture.completedFuture(result);
  }

  @Override
  public CompletableFuture<Object> shutdown() {
    return CompletableFuture.completedFuture(null);
  }

  @Override
  public void exit() {

  }

  @Override
  public BCTextDocumentService getTextDocumentService() {
    return new BCTextDocumentService();
  }

  @Override
  public BCWorkspaceService getWorkspaceService() {
    return new BCWorkspaceService();
  }
}
