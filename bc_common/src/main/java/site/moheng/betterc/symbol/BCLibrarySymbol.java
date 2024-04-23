package site.moheng.betterc.symbol;

import java.util.List;

public record BCLibrarySymbol(String uri, List<BCLibrarySymbol> imports) {
    public static final BCLibrarySymbol STD = new BCLibrarySymbol("bc:std", List.of());
    public static final BCLibrarySymbol GLOBAL = new BCLibrarySymbol("global", List.of());

}
