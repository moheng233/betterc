package site.moheng.betterc.symbol.variable;

import lombok.Value;
import site.moheng.betterc.symbol.BCLibrarySymbol;
import site.moheng.betterc.symbol.type.BCTypeSymbol;

@Value(staticConstructor = "of")
public class BCGlobalVariableSymbol implements BCVariableSymbol {
    BCLibrarySymbol library;
    BCTypeSymbol type;
    String name;

    @Override
    public String getMappingName() {
        return library.getSymbolPrefixName() + name;
    }
}
