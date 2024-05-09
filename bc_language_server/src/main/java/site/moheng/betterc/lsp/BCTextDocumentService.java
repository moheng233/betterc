package site.moheng.betterc.lsp;

import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.services.TextDocumentService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BCTextDocumentService implements TextDocumentService {
    @Override
    public void didOpen(DidOpenTextDocumentParams params) {

    }

    @Override
    public void didChange(DidChangeTextDocumentParams params) {

    }

    @Override
    public void didClose(DidCloseTextDocumentParams params) {

    }

    @Override
    public void didSave(DidSaveTextDocumentParams params) {

    }

    @Override
    public CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(final CompletionParams position) {
        return TextDocumentService.super.completion(position);
    }
}
