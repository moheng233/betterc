package site.moheng.betterc;

import site.moheng.betterc.antlr.BCBaseListener;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.inspector.InspectorContext;

public class BCInspector extends BCBaseListener {
    public InspectorContext ctx = new InspectorContext();

    @Override
    public void enterProgram(final BCParser.ProgramContext ctx) {
        super.enterProgram(ctx);
    }

    @Override
    public void exitProgram(final BCParser.ProgramContext ctx) {
        super.exitProgram(ctx);
    }

    public InspectorContext getContext() {
        return ctx;
    }
}
