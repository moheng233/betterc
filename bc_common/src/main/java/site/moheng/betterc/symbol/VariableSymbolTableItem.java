package site.moheng.betterc.symbol;

import com.googlecode.cqengine.attribute.Attribute;
import org.antlr.v4.runtime.ParserRuleContext;
import site.moheng.betterc.symbol.variable.BCVariableSymbol;

import static com.googlecode.cqengine.query.QueryFactory.attribute;

public record VariableSymbolTableItem(String name,
                                      BCLibrarySymbol library,
                                      BCVariableSymbol symbol,
                                      ParserRuleContext scope,
                                      ParserRuleContext context) {

    public static final Attribute<VariableSymbolTableItem, String> NAME = attribute(VariableSymbolTableItem.class, String.class, "name", VariableSymbolTableItem::name);
    public static final Attribute<VariableSymbolTableItem, BCLibrarySymbol> LIBRARY = attribute(VariableSymbolTableItem.class, BCLibrarySymbol.class, "library", VariableSymbolTableItem::library);
    public static final Attribute<VariableSymbolTableItem, BCVariableSymbol> SYMBOL = attribute(VariableSymbolTableItem.class, BCVariableSymbol.class, "symbol", VariableSymbolTableItem::symbol);
    public static final Attribute<VariableSymbolTableItem, ParserRuleContext> SCOPE = attribute(VariableSymbolTableItem.class, ParserRuleContext.class, "scope", VariableSymbolTableItem::scope);
    public static final Attribute<VariableSymbolTableItem, ParserRuleContext> CONTEXT = attribute(VariableSymbolTableItem.class, ParserRuleContext.class, "context", VariableSymbolTableItem::context);

}
