package site.moheng.betterc.symbol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BCLibrarySymbolTest {


    @Test
    void getSymbolPrefixName() {
        assertEquals(BCLibrarySymbol.GLOBAL.getSymbolPrefixName(), "global__");
        assertEquals(BCLibrarySymbol.STD.getSymbolPrefixName(), "bc_std_");
        assertEquals(BCLibrarySymbol.of("bc", "test", "test1").getSymbolPrefixName(), "bc_test_test1_");
    }
}