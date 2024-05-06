@import site.moheng.betterc.writer.BCHeaderWriterContext
@import static site.moheng.betterc.antlr.BCParser.*

@param ProgramContext program
@param BCHeaderWriterContext context

#program once

@for(final var importItem : program.imports)

@endfor

@for(final var structItem : program.structs)
    struct ${context.formatSymbol(structItem.name)};
@endfor

@for(final var methodItem : program.methods)

@endfor

@for(final var structItem : program.structs)
    struct ${context.formatSymbol(structItem.name)} {
    @for(final var field : structItem.fields)
        ${context.formatTypeExpr(field.type)} ${field.name.getText()};
    @endfor
    }
@endfor