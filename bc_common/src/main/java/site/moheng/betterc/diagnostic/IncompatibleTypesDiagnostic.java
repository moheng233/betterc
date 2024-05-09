package site.moheng.betterc.diagnostic;

import lombok.Value;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jetbrains.annotations.Nullable;
import site.moheng.betterc.symbol.type.BCTypeSymbol;

@Value(staticConstructor = "of")
public class IncompatibleTypesDiagnostic implements DiagnosticMessage {
    ParserRuleContext sourceNode;
    @Nullable ParserRuleContext needNode;

    BCTypeSymbol sourceType;
    BCTypeSymbol needType;

    @Override
    public int getLine() {
        return sourceNode.start.getLine();
    }

    @Override
    public int getCharPositionInLine() {
        return sourceNode.start.getCharPositionInLine();
    }
}
