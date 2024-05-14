package site.moheng.betterc.inspector;

import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.ParserRuleContext;
import site.moheng.betterc.antlr.BCBaseListener;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.diagnostic.IncompatibleTypesDiagnostic;
import site.moheng.betterc.symbol.BCLibrarySymbol;
import site.moheng.betterc.symbol.SymbolTable;
import site.moheng.betterc.symbol.type.*;

import java.util.List;
import java.util.Stack;

/**
 * 对于类型的前处理诊断
 * 仅处理字面量值的类型传递
 */
@AllArgsConstructor
public class TypePreProcessingInspector extends BCBaseListener {
    public final InspectorContext inspector;
    public final SymbolTable table;
    public final BCLibrarySymbol library;

    public final Stack<ParserRuleContext> scoopStack = new Stack<>();

    @Override
    public void enterProgram(final BCParser.ProgramContext ctx) {
        scoopStack.push(ctx);
        super.enterProgram(ctx);
    }

    @Override
    public void exitProgram(final BCParser.ProgramContext ctx) {
        scoopStack.pop();
        super.exitProgram(ctx);
    }

    @Override
    public void exitMethodDeclaration(final BCParser.MethodDeclarationContext ctx) {
        final var name = ctx.name.getText();
        final var type = BCStructMethodSymbol.of(inspector.getType(ctx.returnValue), name,
                ctx.args.stream().map(arg -> BCMethodArgSymbol.of(arg.name.id.getText(), inspector.getType(arg.type))).toList()
        );
        final var method = table.addTypeSymbol(name, library, type, scoopStack.peek(), ctx);
        super.exitMethodDeclaration(ctx);
    }

    @Override
    public void enterStructDeclaration(final BCParser.StructDeclarationContext ctx) {
        final var name = ctx.name.getText();
        final var type = BCStructSymbol.of(library, name, List.of());
        final var struct = table.addTypeSymbol(name, library, type, scoopStack.peek(), ctx);
        scoopStack.push(ctx);
        super.enterStructDeclaration(ctx);
    }

    @Override
    public void exitStructField(final BCParser.StructFieldContext ctx) {
        final var name = ctx.name.getText();
        final var type = BCStructFieldSymbol.of(name, inspector.getType(ctx.type));
        final var field = table.addTypeSymbol(name, library, type, scoopStack.peek(), ctx);
        super.enterStructField(ctx);
    }

    @Override
    public void exitStructDeclaration(final BCParser.StructDeclarationContext ctx) {
        scoopStack.pop();
        super.exitStructDeclaration(ctx);
    }

    @Override
    public void enterBodyDeclaration(final BCParser.BodyDeclarationContext ctx) {
        scoopStack.push(ctx);
        super.enterBodyDeclaration(ctx);
    }

    @Override
    public void exitVariableDeclarationStatement(final BCParser.VariableDeclarationStatementContext ctx) {
        BCTypeSymbol type;
        if (ctx.type == null) {
            type = inspector.getType(ctx.value);
        } else {
            type = inspector.getType(ctx.type);
            BCTypeSymbol variable_type = inspector.getType(ctx.value);

            if (type.compatible(variable_type) == BCTypeSymbol.UNKNOWN) {
                inspector.addDiagnostic(
                        IncompatibleTypesDiagnostic.of(ctx.value, ctx.type, variable_type, type)
                );
            }
        }
        table.addLocalVariable(ctx.name.getText(), library, type, scoopStack.peek(), ctx);
        super.exitVariableDeclarationStatement(ctx);
    }

    @Override
    public void exitBodyDeclaration(final BCParser.BodyDeclarationContext ctx) {
        scoopStack.pop();
        super.exitBodyDeclaration(ctx);
    }

    @Override
    public void exitTypeRef(final BCParser.TypeRefContext ctx) {
        inspector.symbols.put(ctx, switch (ctx.type.id.getText()) {
            case "int" -> BCMappingTypeSymbol.INT;
            case "float" -> BCMappingTypeSymbol.FLOAT;
            case "boolean" -> BCMappingTypeSymbol.BOOLEAN;
            default -> BCTypeSymbol.UNKNOWN;
        });
        super.exitTypeRef(ctx);
    }

    @Override
    public void exitTypeLiteralExpression(final BCParser.TypeLiteralExpressionContext ctx) {
        inspector.symbols.put(ctx, inspector.getType(ctx.type));
        super.exitTypeLiteralExpression(ctx);
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
