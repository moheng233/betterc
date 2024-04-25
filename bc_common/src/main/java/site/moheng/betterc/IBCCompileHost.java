package site.moheng.betterc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import site.moheng.betterc.antlr.BCLexer;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.error.BCSyntaxError;
import site.moheng.betterc.symbol.BCLibrarySymbol;

public class IBCCompileHost {
  HashMap<BCLibrarySymbol, String> contentMap = new HashMap<>();
  HashMap<BCLibrarySymbol, BCParser.ProgramContext> compileCache = new HashMap<>();

  public void set(BCLibrarySymbol library, String text) {
    contentMap.put(library, text);
    compileCache.remove(library);
  }

  public void compile(BCLibrarySymbol library) {
    final var lexer = new BCLexer(CharStreams.fromString(contentMap.get(library)));
    final var parser = new BCParser(new CommonTokenStream(lexer));
    parser.removeErrorListeners();

    final List<BCSyntaxError> errors = new ArrayList<>();

    parser.addErrorListener(new BaseErrorListener() {
      @Override
      public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                              int charPositionInLine, String msg, RecognitionException e) {
        super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
        errors.add(BCSyntaxError.of(line, charPositionInLine, msg, e));
      }
    });

    parser.program();

  }
}
