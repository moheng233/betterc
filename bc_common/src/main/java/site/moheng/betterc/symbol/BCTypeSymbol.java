package site.moheng.betterc.symbol;

import lombok.Value;

@Value(staticConstructor = "of")
public class BCTypeSymbol implements IBCTypeSymbol {
    static public final BCTypeSymbol VOID = BCTypeSymbol.of(BCLibrarySymbol.GLOBAL, "void");
    static public final BCTypeSymbol BOOLEAN = BCTypeSymbol.of(BCLibrarySymbol.GLOBAL, "boolean");
    static public final BCTypeSymbol INT = BCTypeSymbol.of(BCLibrarySymbol.GLOBAL, "int");
    static public final BCTypeSymbol FLOAT = BCTypeSymbol.of(BCLibrarySymbol.GLOBAL, "float");
    static public final BCTypeSymbol STRING = BCTypeSymbol.of(BCLibrarySymbol.GLOBAL, "string");

    BCLibrarySymbol library;
    String name;
}


