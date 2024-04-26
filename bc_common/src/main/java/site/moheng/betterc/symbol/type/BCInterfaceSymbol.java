package site.moheng.betterc.symbol.type;

import lombok.Value;
import site.moheng.betterc.symbol.BCLibrarySymbol;

import java.util.List;

@Value(staticConstructor = "of")
public class BCInterfaceSymbol implements BCTypeSymbol {
    BCLibrarySymbol library;
    String name;
    List<BCMethodSymbol> methods;

    @Override
    public String getMappingName() {
        return "";
    }
}
