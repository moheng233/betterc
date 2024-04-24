package site.moheng.betterc.symbol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BCLibrarySymbolTest {

    @Test
    void getNamespace() {
        assertEquals(BCLibrarySymbol.GLOBAL.getNamespace(), "global");
        assertEquals(BCLibrarySymbol.STD.getNamespace(), "bc");
    }

    @Test
    void getPath() {
        assertEquals(BCLibrarySymbol.GLOBAL.getPath(), "");
        assertEquals(BCLibrarySymbol.STD.getPath(), "std");
    }
}