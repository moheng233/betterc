package site.moheng.betterc.symbol;

import java.util.List;

public record BCMethodSymbol(BCLibrarySymbol library,
                             String name,
                             IBCTypeSymbol returnValue,
                             List<BCMethodArgSymbol> args) implements IBCTypeSymbol {
}
