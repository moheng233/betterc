package site.moheng.betterc.symbol.type;

import lombok.Value;
import lombok.With;
import site.moheng.betterc.symbol.BCLibrarySymbol;

import java.util.List;

/**
 * 在BetterC中实现的接口体类型
 */
@Value(staticConstructor = "of")
public class BCStructSymbol implements BCTypeSymbol {
    BCLibrarySymbol library;
    String name;
    @With List<BCInterfaceSymbol> implementations;

    @Override
    public String getMappingName() {
        return library.symbolPrefixName() + name;
    }
}
