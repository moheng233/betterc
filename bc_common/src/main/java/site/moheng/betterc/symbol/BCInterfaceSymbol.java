package site.moheng.betterc.symbol;

import java.util.List;

public record BCInterfaceSymbol(BCLibrarySymbol library,
                                String name,
                                List<BCMethodSymbol> methods) implements IBCTypeSymbol {

}
