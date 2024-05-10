package site.moheng.betterc.diagnostic;

public interface DiagnosticMessage {
    int getLine();

    int getCharPositionInLine();

    DiagnosticLevel getDiagnosticLevel();

    String getMessage();

    enum DiagnosticLevel {
        ERROR, WARN, INFO, DEBUG, TRACE;
    }
}
