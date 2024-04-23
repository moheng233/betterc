package site.moheng.betterc.scope;

import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.BCStructSymbol;

import java.util.List;

public interface IBCMethodScope extends IBCScope {
    List<BCStructSymbol> getMethod();

    BCStructSymbol findMethod(BCParser.MethodDeclarationContext name);

    BCStructSymbol findMethod(BCParser.AccessSymbolContext access);
}
