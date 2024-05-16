package site.moheng.betterc.lsp;

import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.services.TextDocumentService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BCTextDocumentService implements TextDocumentService {

    @Override
    public void didOpen(final DidOpenTextDocumentParams params) {

    }

    @Override
    public void didChange(final DidChangeTextDocumentParams params) {

    }

    @Override
    public void didClose(final DidCloseTextDocumentParams params) {

    }

    @Override
    public void didSave(final DidSaveTextDocumentParams params) {

    }

    @Override
    public CompletableFuture<Either<SemanticTokens, SemanticTokensDelta>> semanticTokensFullDelta(final SemanticTokensDeltaParams params) {
        return TextDocumentService.super.semanticTokensFullDelta(params);
    }

    @Override
    public CompletableFuture<List<Either<SymbolInformation, DocumentSymbol>>> documentSymbol(final DocumentSymbolParams params) {
        return TextDocumentService.super.documentSymbol(params);
    }
}
