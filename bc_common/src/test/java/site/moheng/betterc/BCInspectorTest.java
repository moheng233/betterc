package site.moheng.betterc;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.IterativeParseTreeWalker;
import org.junit.jupiter.api.Test;
import site.moheng.betterc.antlr.BCLexer;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.diagnostic.SyntaxDiagnostic;

import java.util.ArrayList;
import java.util.List;

class BCInspectorTest {
    public BCParser.ProgramContext compile(String src) {
        final var lexer = new BCLexer(CharStreams.fromString(src));
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

        return parser.program();
    }

    @Test
    void testLiteral() {
        final var inspector = new BCInspector();
        final String source = """
                void main() {
                    var a = ! 1;
                }
                """;

        final var program = compile(source);
        IterativeParseTreeWalker walker = new IterativeParseTreeWalker();
        walker.walk(inspector, program);
    }
}