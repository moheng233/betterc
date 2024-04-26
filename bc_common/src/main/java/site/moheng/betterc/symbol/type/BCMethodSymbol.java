package site.moheng.betterc.symbol.type;

import java.util.List;

public interface BCMethodSymbol extends BCTypeSymbol {
    BCTypeSymbol getReturnValue();

    List<BCMethodArgSymbol> getArgs();
}
