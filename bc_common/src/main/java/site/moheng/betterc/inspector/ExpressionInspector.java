package site.moheng.betterc.inspector;

import lombok.AllArgsConstructor;
import site.moheng.betterc.antlr.BCBaseListener;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.type.BCMappingTypeSymbol;

@AllArgsConstructor
public class ExpressionInspector extends BCBaseListener implements IPartInspector {

    public final InspectorContext ctx;

    @Override
    public InspectorContext getContext() {
        return ctx;
    }

    @Override
    public void exitNotExpression(BCParser.NotExpressionContext ctx) {
        final var type = getContext().getType(ctx.right, BCMappingTypeSymbol.BOOLEAN);
        getContext().symbols.put(ctx, BCMappingTypeSymbol.BOOLEAN);
    }

    @Override
    public void exitCombinatorialLogicExpression(BCParser.CombinatorialLogicExpressionContext ctx) {
        final var left = getContext().getType(ctx.left, BCMappingTypeSymbol.BOOLEAN);
        final var right = getContext().getType(ctx.right, BCMappingTypeSymbol.BOOLEAN);

        getContext().symbols.put(ctx, BCMappingTypeSymbol.BOOLEAN);
    }

    @Override
    public void exitLiteralExpression(BCParser.LiteralExpressionContext ctx) {
        final var type = getContext().symbols.get(ctx.literal());
        getContext().symbols.put(ctx, type);
    }
}
