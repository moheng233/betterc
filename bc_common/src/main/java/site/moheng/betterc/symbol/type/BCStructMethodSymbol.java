package site.moheng.betterc.symbol.type;

import lombok.Value;

import java.util.List;


@Value(staticConstructor = "of")
public class BCStructMethodSymbol implements BCMethodSymbol {
    BCTypeSymbol returnValue;
    String name;
    List<BCMethodArgSymbol> args;

    @Override
    public String getMappingName() {
        return name;
    }
}
