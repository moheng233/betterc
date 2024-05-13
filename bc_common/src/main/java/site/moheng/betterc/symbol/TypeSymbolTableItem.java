package site.moheng.betterc.symbol;

import com.googlecode.cqengine.attribute.Attribute;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jetbrains.annotations.Nullable;
import site.moheng.betterc.symbol.type.BCTypeSymbol;

import static com.googlecode.cqengine.query.QueryFactory.attribute;
import static com.googlecode.cqengine.query.QueryFactory.nullableAttribute;

public record TypeSymbolTableItem(
        String name,
        BCLibrarySymbol library,
        @Nullable BCTypeSymbol symbol,
        ParserRuleContext scope,
        ParserRuleContext context
) {
    public static final Attribute<TypeSymbolTableItem, String> NAME = attribute(TypeSymbolTableItem.class, String.class, "name", TypeSymbolTableItem::name);
    public static final Attribute<TypeSymbolTableItem, BCLibrarySymbol> LIBRARY = attribute(TypeSymbolTableItem.class, BCLibrarySymbol.class, "library", TypeSymbolTableItem::library);
    public static final Attribute<TypeSymbolTableItem, BCTypeSymbol> SYMBOL = nullableAttribute(TypeSymbolTableItem.class, BCTypeSymbol.class, "symbol", TypeSymbolTableItem::symbol);
    public static final Attribute<TypeSymbolTableItem, ParserRuleContext> SCOPE = attribute(TypeSymbolTableItem.class, ParserRuleContext.class, "scope", TypeSymbolTableItem::scope);
    public static final Attribute<TypeSymbolTableItem, ParserRuleContext> CONTEXT = attribute(TypeSymbolTableItem.class, ParserRuleContext.class, "context", TypeSymbolTableItem::context);
}
