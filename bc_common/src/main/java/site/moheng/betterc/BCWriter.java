package site.moheng.betterc;

import org.ainslec.picocog.PicoWriter;
import org.jetbrains.annotations.NotNull;
import site.moheng.betterc.symbol.BCLibrarySymbol;

import static site.moheng.betterc.antlr.BCParser.*;

public class BCWriter {
    final PicoWriter writer = new PicoWriter();
    BCPacker packer;
    BCChecker checker;

    BCWriter(BCPacker packer, BCChecker checker) {
        this.packer = packer;
        this.checker = checker;
    }

    public String formatSymbol(@NotNull SymbolContext symbol) {
        return symbol.getText();
    }

    public String formatTypeLiteral(@NotNull TypeLiteralContext typeLiteral) {
        return formatTypeLiteral(BCLibrarySymbol.GLOBAL, typeLiteral);
    }

    public String formatTypeLiteral(@NotNull BCLibrarySymbol library, @NotNull TypeLiteralContext typeLiteral) {
        return switch (typeLiteral) {
            case VoidTypeLiteralContext ignored:
                yield "void";
            case SymbolTypeLiteralContext literal:
                yield "literal";
            default:
                throw new IllegalStateException("Unexpected value: " + typeLiteral);
        };
    }

    public String formatTypeExpr(@NotNull TypeExprContext typeExpr) {
        return switch (typeExpr) {
            case TypeLiteralExpressionContext literal:
                yield formatTypeLiteral(literal.type);
            case TypeGenericsExpressionContext generics:
                yield formatTypeExpr(generics.type) + "_" + String.join("_", generics.generics.stream().map(this::formatTypeExpr).toList());
            default:
                throw new IllegalStateException("Unexpected value: " + typeExpr);
        };
    }

    public void writeImport(@NotNull BCLibrarySymbol library, @NotNull ImportDeclartionContext context) {

    }

    public void writeStruct(@NotNull BCLibrarySymbol library, @NotNull StructDeclarationContext context) {
        writer.writeln_r("typedef struct " + formatSymbol(context.name) + "{");

        for (final var field : context.fields) {
            writer.writeln(formatTypeExpr(field.type) + " " + formatSymbol(field.name) + ";");
        }

        writer.writeln_l("} " + formatSymbol(context.name));
    }

    public void write(@NotNull BCLibrarySymbol library, @NotNull ProgramContext parser) {
        for (final var importItem : parser.imports) {
            writeImport(library, importItem);
        }

        for (final var structItem : parser.structs) {
            writeStruct(library, structItem);
        }
    }
}
