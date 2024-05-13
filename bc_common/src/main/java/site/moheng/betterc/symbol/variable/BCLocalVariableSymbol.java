package site.moheng.betterc.symbol.variable;

import site.moheng.betterc.symbol.type.BCTypeSymbol;


public record BCLocalVariableSymbol(BCTypeSymbol type, String name) implements BCVariableSymbol {

    @Override
    public String mappingName() {
        return name;
    }
}
