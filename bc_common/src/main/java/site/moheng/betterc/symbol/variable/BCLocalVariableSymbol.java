package site.moheng.betterc.symbol.variable;

import lombok.Value;
import site.moheng.betterc.symbol.type.BCTypeSymbol;

@Value(staticConstructor = "of")
public class BCLocalVariableSymbol implements BCVariableSymbol {
    BCTypeSymbol type;
    String name;

    @Override
    public String getMappingName() {
        return name;
    }
}
