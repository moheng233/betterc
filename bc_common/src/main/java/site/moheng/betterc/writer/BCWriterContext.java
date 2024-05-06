package site.moheng.betterc.writer;

import org.jetbrains.annotations.NotNull;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.BCLibrarySymbol;

public abstract class BCWriterContext {
    final BCLibrarySymbol library;

    protected BCWriterContext(BCLibrarySymbol library) {
        this.library = library;
    }

    public String formatSymbol(@NotNull BCParser.SymbolContext symbol) {
        return library.getSymbolPrefixName() + "_" + symbol.getText();
    }

    public String formatTypeLiteral(@NotNull BCParser.TypeLiteralContext typeLiteral) {
        return formatTypeLiteral(BCLibrarySymbol.GLOBAL, typeLiteral);
    }

    public String formatTypeLiteral(@NotNull BCLibrarySymbol library,
                                    @NotNull BCParser.TypeLiteralContext typeLiteral) {
        return switch (typeLiteral) {
            case BCParser.SymbolTypeLiteralContext literal:
                yield "literal";
            default:
                throw new IllegalStateException("Unexpected value: " + typeLiteral);
        };
    }

    public String formatTypeExpr(@NotNull BCParser.TypeExprContext typeExpr) {
        return switch (typeExpr) {
            case BCParser.TypeLiteralExpressionContext literal:
                yield formatTypeLiteral(literal.type);
            case BCParser.TypeGenericsExpressionContext generics:
                yield formatTypeExpr(generics.type) + "_" +
                        String.join("_", generics.generics.stream().map(this::formatTypeExpr).toList());
            default:
                throw new IllegalStateException("Unexpected value: " + typeExpr);
        };
    }
}
