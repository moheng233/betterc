package site.moheng.betterc.scope;

import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.IBCTypeSymbol;

import java.util.Set;

public interface IBCTypeScope extends IBCScope {
    Set<IBCTypeSymbol> getTypes();

    IBCTypeSymbol findType(BCParser.StructDeclarationContext name);

    IBCTypeSymbol findType(BCParser.AccessSymbolContext access);
}
