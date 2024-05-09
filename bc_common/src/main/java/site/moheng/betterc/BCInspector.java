package site.moheng.betterc;

import lombok.experimental.Delegate;
import site.moheng.betterc.antlr.BCBaseListener;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.inspector.ExpressionInspector;
import site.moheng.betterc.inspector.IPartInspector;
import site.moheng.betterc.inspector.InspectorContext;
import site.moheng.betterc.inspector.LiteralInspector;

public class BCInspector extends BCBaseListener implements IPartInspector {
    public InspectorContext ctx = new InspectorContext();

    @Delegate(types = ExpressionInspector.class) private final ExpressionInspector expressionInspector = new ExpressionInspector(ctx);
    @Delegate(types = LiteralInspector.class) private final LiteralInspector literalInspector = new LiteralInspector(ctx);

    @Override
    public void enterProgram(final BCParser.ProgramContext ctx) {
        super.enterProgram(ctx);
    }

    @Override
    public void exitProgram(final BCParser.ProgramContext ctx) {
        super.exitProgram(ctx);
    }

    @Override
    public InspectorContext getContext() {
        return ctx;
    }
}
