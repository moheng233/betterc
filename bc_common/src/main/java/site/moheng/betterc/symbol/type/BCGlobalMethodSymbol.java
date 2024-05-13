package site.moheng.betterc.symbol.type;

import lombok.Value;
import site.moheng.betterc.symbol.BCLibrarySymbol;

import java.util.List;

@Value(staticConstructor = "of")
public class BCGlobalMethodSymbol implements BCMethodSymbol {
    BCLibrarySymbol library;
    BCTypeSymbol returnValue;
    String name;
    List<BCMethodArgSymbol> args;

    @Override
    public String getMappingName() {
        return library.symbolPrefixName() + name;
    }
}
