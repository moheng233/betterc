package site.moheng.betterc.diagnostic;

import lombok.Value;
import org.antlr.v4.runtime.RecognitionException;

@Value(staticConstructor = "of")
public class SyntaxDiagnostic implements DiagnosticMessage {
    int line;
    int charPositionInLine;

    String msg;
    RecognitionException exception;
}
