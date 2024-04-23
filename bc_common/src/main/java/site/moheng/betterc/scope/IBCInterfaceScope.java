package site.moheng.betterc.scope;

import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.BCInterfaceSymbol;

import java.util.List;

public interface IBCInterfaceScope extends IBCScope {
    List<BCInterfaceSymbol> getInterfaces();

    BCInterfaceSymbol findInterface(BCParser.StructDeclarationContext name);

    BCInterfaceSymbol findInterface(BCParser.AccessSymbolContext access);
}
