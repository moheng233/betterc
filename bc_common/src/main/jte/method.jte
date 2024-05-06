@import static site.moheng.betterc.antlr.BCParser.*
@import site.moheng.betterc.writer.BCHeaderWriterContext
@param MethodDeclarationContext method
@param BCHeaderWriterContext context
@param boolean hasBody

${context.formatTypeExpr(method.returnValue)} ${context.formatSymbol(method.name)}(
${String.join(",", method.args.stream().map(
            arg -> context.formatTypeExpr(arg.type) + " " + context.formatSymbol(arg.name)
        ).toList())}
)
@if(hasBody)
    {

    }
@else
    ;
@endif
