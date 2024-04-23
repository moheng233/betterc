package site.moheng.betterc;

import org.ainslec.picocog.PicoWriter;
import org.jetbrains.annotations.NotNull;

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

    public String formatTypeExpr(@NotNull TypeExprContext typeExpr) {
        return switch (typeExpr) {
            case TypeLiteralExpressionContext literal:
                yield literal.type.getText();
            case TypeGenericsExpressionContext generics:
                yield generics.type.getText();
            default:
                throw new IllegalStateException("Unexpected value: " + typeExpr);
        };
    }

    public void writeImport(@NotNull ImportDeclartionContext context) {

    }

    public void writeStruct(@NotNull StructDeclarationContext context) {
        writer.writeln_r("typedef struct " + formatSymbol(context.name) + "{");

        for (final var field : context.fields) {
            writer.writeln(formatTypeExpr(field.type) + " " + formatSymbol(field.name) + ";");
        }

        writer.writeln_l("} " + formatSymbol(context.name));
    }

    public void write(@NotNull ProgramContext parser) {
        for (final var importItem : parser.imports) {
            writeImport(importItem);
        }

        for (final var structItem : parser.structs) {
            writeStruct(structItem);
        }
    }
}
