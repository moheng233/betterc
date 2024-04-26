package site.moheng.betterc.symbol.variable;

import site.moheng.betterc.symbol.type.BCInterfaceSymbol;
import site.moheng.betterc.symbol.type.BCTypeSymbol;

public interface BCVariableSymbol {
    String getName();

    BCTypeSymbol getType();

    String getMappingName();

    default boolean isStruct() {
        return getType() instanceof BCTypeSymbol;
    }

    default boolean isInterface() {
        return getType() instanceof BCInterfaceSymbol;
    }
}
