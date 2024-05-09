package site.moheng.betterc.host;

import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.BCLibrarySymbol;

public interface ICompileHost {
    BCParser.ProgramContext get(BCLibrarySymbol library);
}
