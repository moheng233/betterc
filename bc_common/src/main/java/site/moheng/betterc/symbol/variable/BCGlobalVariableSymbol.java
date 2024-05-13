package site.moheng.betterc.symbol.variable;

import site.moheng.betterc.symbol.BCLibrarySymbol;
import site.moheng.betterc.symbol.type.BCTypeSymbol;

public record BCGlobalVariableSymbol(BCLibrarySymbol library,
                                     BCTypeSymbol type,
                                     String name) implements BCVariableSymbol {
    @Override
    public String mappingName() {
        return library.symbolPrefixName() + name;
    }
}
