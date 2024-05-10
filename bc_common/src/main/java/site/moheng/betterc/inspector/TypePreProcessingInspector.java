package site.moheng.betterc.inspector;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.Nullable;
import site.moheng.betterc.antlr.BCBaseListener;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.type.BCMappingTypeSymbol;

/**
 * 对于类型的前处理诊断
 * 仅处理字面量值的类型传递
 */
@AllArgsConstructor
public class TypePreProcessingInspector extends BCBaseListener {
    public final InspectorContext inspector;
    @Nullable public BCParser.ProgramContext program;
    @Nullable public BCParser.InterfaceDeclarationContext interfaceDeclaration;
    @Nullable public BCParser.StructDeclarationContext structDeclaration;
    @Nullable public BCParser.MethodDeclarationContext methodDeclaration;

    @Override
    public void enterProgram(final BCParser.ProgramContext ctx) {
        program = ctx;
        super.enterProgram(ctx);
    }

    @Override
    public void exitProgram(final BCParser.ProgramContext ctx) {
        program = null;
        super.exitProgram(ctx);
    }

    @Override
    public void enterStructDeclaration(final BCParser.StructDeclarationContext ctx) {
        structDeclaration = ctx;
        super.enterStructDeclaration(ctx);
    }

    @Override
    public void exitStructDeclaration(final BCParser.StructDeclarationContext ctx) {
        structDeclaration = null;
        super.exitStructDeclaration(ctx);
    }

    @Override
    public void exitLiteralExpression(BCParser.LiteralExpressionContext ctx) {
        final var type = inspector.symbols.get(ctx.literal());
        inspector.symbols.put(ctx, type);
    }

    @Override
    public void exitIntLiteral(final BCParser.IntLiteralContext ctx) {
        inspector.symbols.put(ctx, BCMappingTypeSymbol.INT);
    }

    @Override
    public void exitFloatLiteral(final BCParser.FloatLiteralContext ctx) {
        inspector.symbols.put(ctx, BCMappingTypeSymbol.FLOAT);
    }

    @Override
    public void exitBooleanLiteral(final BCParser.BooleanLiteralContext ctx) {
        inspector.symbols.put(ctx, BCMappingTypeSymbol.BOOLEAN);
    }
}
