package site.moheng.betterc.writer;

import org.ainslec.picocog.PicoWriter;
import org.jetbrains.annotations.NotNull;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.BCLibrarySymbol;

public class BCHeaderWriter extends BCWriter {
    final PicoWriter writer = new PicoWriter();

    protected BCHeaderWriter(BCLibrarySymbol library) {
        super(library);
    }


    public void writeImport(@NotNull BCLibrarySymbol library,
                            @NotNull BCParser.ImportDeclartionContext context) {

    }

    public PicoWriter writeStruct(@NotNull BCLibrarySymbol library,
                                  @NotNull BCParser.StructDeclarationContext context) {
        final var writer = new PicoWriter();

        writer.writeln_r("typedef struct ${formatSymbol(context.name)} {");

        for (final var field : context.fields) {
            writer.writeln(formatTypeExpr(field.type) + " " + formatSymbol(field.name) + ";");
        }

        writer.writeln_l("} " + formatSymbol(context.name));

        return writer;
    }

    public void write(@NotNull BCLibrarySymbol library, @NotNull BCParser.ProgramContext parser) {
        for (final var importItem : parser.imports) {
            writeImport(library, importItem);
        }

        for (final var structItem : parser.structs) {
            writer.writeln(writeStruct(library, structItem));
        }
    }
}
