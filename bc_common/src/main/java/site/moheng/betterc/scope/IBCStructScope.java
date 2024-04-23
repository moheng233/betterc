package site.moheng.betterc.scope;

import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.BCStructSymbol;

import java.util.List;

public interface IBCStructScope extends IBCScope {
    List<BCStructSymbol> getStructs();

    BCStructSymbol findStruct(BCParser.StructDeclarationContext name);

    BCStructSymbol findStruct(BCParser.AccessSymbolContext access);
}
