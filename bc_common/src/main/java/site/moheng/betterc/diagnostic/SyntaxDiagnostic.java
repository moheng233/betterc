package site.moheng.betterc.diagnostic;

import lombok.Value;
import org.antlr.v4.runtime.RecognitionException;

@Value(staticConstructor = "of")
public class SyntaxDiagnostic implements DiagnosticMessage {
    int line;
    int charPositionInLine;

    String msg;
    RecognitionException exception;

    @Override
    public DiagnosticLevel getDiagnosticLevel() {
        return DiagnosticLevel.ERROR;
    }

    @Override
    public String getMessage() {
        return STR."[\{line}:\{charPositionInLine}] \{msg}";
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
