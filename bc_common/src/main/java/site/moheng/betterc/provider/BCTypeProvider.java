package site.moheng.betterc.provider;

import org.jetbrains.annotations.NotNull;
import site.moheng.betterc.symbol.BCLibrarySymbol;
import site.moheng.betterc.symbol.type.*;

import static site.moheng.betterc.antlr.BCParser.*;

public class BCTypeProvider {
    public BCTypeSymbol getType(@NotNull ExpressionContext expression) {
        return switch (expression) {
            case NotExpressionContext ignored -> BCMappingTypeSymbol.BOOLEAN;
            case CombinatorialLogicExpressionContext ignored -> BCMappingTypeSymbol.BOOLEAN;
            case ComparativeLogicExpressionContext ignored -> BCMappingTypeSymbol.BOOLEAN;
            case MathsExpressionContext context -> getType(context);
            case VariableExpressionContext context -> getType(context.accessSymbol());
            case LiteralExpressionContext context -> getType(context.literal());
            default -> throw new IllegalStateException("Unexpected value: " + expression);
        };
    }

    public BCLibrarySymbol getType(String packageName, String path) {
//    return BCLibrarySymbol.of(packageName + ":" + path);
        return null;
    }


    public BCStructFieldSymbol getType(@NotNull BCLibrarySymbol library,
                                       @NotNull StructFieldContext field) {
        return null;
    }

    public BCStructSymbol getType(@NotNull BCLibrarySymbol library,
                                  @NotNull StructDeclarationContext declaration) {
//        return BCStructSymbol.of(library, declaration.name.id.getText(),
//                declaration.fields.stream().map((field) -> getType(library, field)).toList());
        return null;
    }

    public BCMethodSymbol getType(@NotNull MethodDeclarationContext method) {
        /// TODO
        return null;
    }

    public BCTypeSymbol getType(@NotNull AccessSymbolContext symbol) {
        /// TODO
        return null;
    }

    public BCTypeSymbol getType(@NotNull MathsExpressionContext expression) {
        /// TODO
        return null;
    }

    public BCTypeSymbol getType(@NotNull LiteralContext literal) {
        return switch (literal) {
            case BooleanLiteralContext ignored -> BCMappingTypeSymbol.BOOLEAN;
            case IntLiteralContext ignored -> BCMappingTypeSymbol.INT;
            case FloatLiteralContext ignored -> BCMappingTypeSymbol.FLOAT;
            default -> throw new IllegalStateException("Unexpected value: " + literal);
        };
    }
}
