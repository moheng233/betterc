package site.moheng.betterc.provider;

import org.jetbrains.annotations.NotNull;
import site.moheng.betterc.symbol.BCMethodSymbol;
import site.moheng.betterc.symbol.BCTypeSymbol;
import site.moheng.betterc.symbol.IBCTypeSymbol;

import static site.moheng.betterc.antlr.BCParser.*;

public class BCTypeProvider {
    public IBCTypeSymbol getType(@NotNull ExpressionContext expression) {
        return switch (expression) {
            case NotExpressionContext ignored -> BCTypeSymbol.BOOLEAN;
            case CombinatorialLogicExpressionContext ignored -> BCTypeSymbol.BOOLEAN;
            case ComparativeLogicExpressionContext ignored -> BCTypeSymbol.BOOLEAN;
            case MathsExpressionContext context -> getType(context);
            case VariableExpressionContext context -> getType(context.accessSymbol());
            case LiteralExpressionContext context -> getType(context.literal());
            default -> throw new IllegalStateException("Unexpected value: " + expression);
        };
    }

    public BCMethodSymbol getType(@NotNull MethodDeclarationContext method) {
        /// TODO
        return null;
    }

    public IBCTypeSymbol getType(@NotNull AccessSymbolContext symbol) {
        /// TODO
        return null;
    }

    public IBCTypeSymbol getType(@NotNull MathsExpressionContext expression) {
        /// TODO
        return null;
    }

    public IBCTypeSymbol getType(@NotNull LiteralContext literal) {
        return switch (literal) {
            case BooleanLiteralContext ignored -> BCTypeSymbol.BOOLEAN;
            case IntLiteralContext ignored -> BCTypeSymbol.INT;
            case FloatLiteralContext ignored -> BCTypeSymbol.FLOAT;
            case StringLiteralContext ignored -> BCTypeSymbol.STRING;
            default -> throw new IllegalStateException("Unexpected value: " + literal);
        };
    }
}
