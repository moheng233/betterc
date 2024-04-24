package site.moheng.betterc.scope;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.IBCTypeSymbol;

import java.util.Map;
import java.util.Set;

/// TODO
public class BCLibraryScope implements IBCTypeScope {
    private final BidiMap<ParserRuleContext, IBCTypeSymbol> typeSymbolMap;

    public BCLibraryScope(Map<ParserRuleContext, IBCTypeSymbol> map) {
        typeSymbolMap = new DualHashBidiMap<>(map);
    }

    @Override
    public Set<IBCTypeSymbol> getTypes() {
        return typeSymbolMap.values();
    }

    @Override
    public IBCTypeSymbol findType(BCParser.StructDeclarationContext name) {
        return null;
    }

    @Override
    public IBCTypeSymbol findType(BCParser.AccessSymbolContext access) {
        return null;
    }
}
