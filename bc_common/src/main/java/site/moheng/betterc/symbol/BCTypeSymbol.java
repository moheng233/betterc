package site.moheng.betterc.symbol;

public record BCTypeSymbol(BCLibrarySymbol library, String name) implements IBCTypeSymbol {
    static public final BCTypeSymbol VOID = new BCTypeSymbol(BCLibrarySymbol.GLOBAL, "void");
    static public final BCTypeSymbol BOOLEAN = new BCTypeSymbol(BCLibrarySymbol.GLOBAL, "boolean");
    static public final BCTypeSymbol INT = new BCTypeSymbol(BCLibrarySymbol.GLOBAL, "int");
    static public final BCTypeSymbol FLOAT = new BCTypeSymbol(BCLibrarySymbol.GLOBAL, "float");
    static public final BCTypeSymbol STRING = new BCTypeSymbol(BCLibrarySymbol.GLOBAL, "string");
}

