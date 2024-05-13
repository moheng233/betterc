package site.moheng.betterc.symbol.variable;

import site.moheng.betterc.symbol.type.BCInterfaceSymbol;
import site.moheng.betterc.symbol.type.BCTypeSymbol;

public interface BCVariableSymbol {
    String name();

    BCTypeSymbol type();

    String mappingName();

    default boolean isStruct() {
        return type() != null;
    }

    default boolean isInterface() {
        return type() instanceof BCInterfaceSymbol;
    }
}
