package site.moheng.betterc;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.IterativeParseTreeWalker;
import org.junit.jupiter.api.Test;
import site.moheng.betterc.antlr.BCLexer;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.diagnostic.SyntaxDiagnostic;
import site.moheng.betterc.inspector.InspectorContext;
import site.moheng.betterc.inspector.TypePreProcessingInspector;
import site.moheng.betterc.symbol.BCLibrarySymbol;
import site.moheng.betterc.symbol.SymbolTable;

class BCInspectorTest {
    public BCParser.ProgramContext compile(String src, InspectorContext inspector) {
        final var lexer = new BCLexer(CharStreams.fromString(src));
        final var parser = new BCParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();

        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                                    int charPositionInLine, String msg, RecognitionException e) {
                super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
                inspector.addDiagnostic(SyntaxDiagnostic.of(line, charPositionInLine, msg, e));
            }
        });

        return parser.program();
    }

    @Test
    void testLiteral() {
        final var inspector = new InspectorContext();
        final var table = new SymbolTable();
        final var library = new BCLibrarySymbol("test", "test.bc");
        final var typeInspector = new TypePreProcessingInspector(inspector, table, library);

        final String source = """
                void main(List<T> args) {
                    int a = 1;
                    boolean b = true;
                }
                """;

        final var program = compile(source, inspector);
        IterativeParseTreeWalker walker = new IterativeParseTreeWalker();
        walker.walk(typeInspector, program);

        for (final var message : inspector.diagnostics) {
            System.out.println(message.getMessage());
        }
    }
}