package site.moheng.betterc.builder;

import org.antlr.v4.runtime.*;
import site.moheng.betterc.antlr.BCLexer;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.diagnostic.SyntaxDiagnostic;
import site.moheng.betterc.symbol.BCLibrarySymbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BCCompileHost {
    HashMap<BCLibrarySymbol, String> contentMap = new HashMap<>();
    HashMap<BCLibrarySymbol, BCParser.ProgramContext> compileCache = new HashMap<>();

    public BCParser.ProgramContext get(BCLibrarySymbol library) {
        return null;
    }

    public void compile(BCLibrarySymbol library) {
        final var lexer = new BCLexer(CharStreams.fromString(contentMap.get(library)));
        final var parser = new BCParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();

        final List<SyntaxDiagnostic> errors = new ArrayList<>();

        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                                    int charPositionInLine, String msg, RecognitionException e) {
                super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
                errors.add(SyntaxDiagnostic.of(line, charPositionInLine, msg, e));
            }
        });

        parser.program();
    }
}
