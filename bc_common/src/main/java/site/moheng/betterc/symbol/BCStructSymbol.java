package site.moheng.betterc.symbol;

import java.util.List;

public record BCStructSymbol(BCLibrarySymbol library,
                             String name,
                             List<BCStructFieldSymbol> fields) implements IBCTypeSymbol {


}
