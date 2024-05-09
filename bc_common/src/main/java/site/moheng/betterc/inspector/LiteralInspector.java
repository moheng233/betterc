package site.moheng.betterc.inspector;

import lombok.AllArgsConstructor;
import site.moheng.betterc.antlr.BCBaseListener;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.type.BCMappingTypeSymbol;

@AllArgsConstructor
public class LiteralInspector extends BCBaseListener implements IPartInspector {
    public final InspectorContext ctx;

    @Override
    public void exitIntLiteral(final BCParser.IntLiteralContext ctx) {
        getContext().symbols.put(ctx, BCMappingTypeSymbol.INT);
    }

    @Override
    public void exitFloatLiteral(final BCParser.FloatLiteralContext ctx) {
        getContext().symbols.put(ctx, BCMappingTypeSymbol.FLOAT);
    }

    @Override
    public void exitBooleanLiteral(final BCParser.BooleanLiteralContext ctx) {
        getContext().symbols.put(ctx, BCMappingTypeSymbol.BOOLEAN);
    }

    @Override
    public InspectorContext getContext() {
        return ctx;
    }
}
