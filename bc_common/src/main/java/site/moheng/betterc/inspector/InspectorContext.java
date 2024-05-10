package site.moheng.betterc.inspector;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import site.moheng.betterc.diagnostic.DiagnosticMessage;
import site.moheng.betterc.diagnostic.IncompatibleTypesDiagnostic;
import site.moheng.betterc.provider.BCTypeProvider;
import site.moheng.betterc.symbol.type.BCTypeSymbol;

import java.util.ArrayList;
import java.util.List;

public class InspectorContext {
    public ParseTreeProperty<BCTypeSymbol> symbols = new ParseTreeProperty<>();
    public List<DiagnosticMessage> diagnostics = new ArrayList<>();

    public BCTypeProvider typeProvider = new BCTypeProvider();

    public void addDiagnostic(DiagnosticMessage diagnostic) {
        diagnostics.add(diagnostic);
    }

    public BCTypeSymbol getType(ParserRuleContext ctx) {
        final var type = symbols.get(ctx);
        if (type == null) {
            return BCTypeSymbol.UNKNOWN;
        }
        return type;
    }

    public BCTypeSymbol getType(ParserRuleContext ctx, BCTypeSymbol expect) {
        final var type = getType(ctx);
        final var compatible = type.compatible(expect);
        if (compatible.isUnknown()) {
            addDiagnostic(
                    IncompatibleTypesDiagnostic.of(ctx, null, type, expect)
            );
        }
        return compatible;
    }
}
