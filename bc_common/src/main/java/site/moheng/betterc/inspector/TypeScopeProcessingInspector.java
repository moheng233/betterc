package site.moheng.betterc.inspector;

import lombok.AllArgsConstructor;
import site.moheng.betterc.antlr.BCBaseListener;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.type.BCMappingTypeSymbol;

@AllArgsConstructor
public class TypeScopeProcessingInspector extends BCBaseListener {
    public final InspectorContext inspector;

    @Override
    public void exitNotExpression(BCParser.NotExpressionContext ctx) {
        final var type = inspector.getType(ctx.right, BCMappingTypeSymbol.BOOLEAN);
        inspector.symbols.put(ctx, BCMappingTypeSymbol.BOOLEAN);
    }

    @Override
    public void exitCombinatorialLogicExpression(BCParser.CombinatorialLogicExpressionContext ctx) {
        final var left = inspector.getType(ctx.left, BCMappingTypeSymbol.BOOLEAN);
        final var right = inspector.getType(ctx.right, BCMappingTypeSymbol.BOOLEAN);

        inspector.symbols.put(ctx, BCMappingTypeSymbol.BOOLEAN);
    }
}
