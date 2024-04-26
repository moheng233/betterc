package site.moheng.betterc.scope;

import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.variable.BCVariableSymbol;

import java.util.List;

public interface IBCVariableScope extends IBCScope {
    List<BCVariableSymbol> getVariable();

    BCVariableSymbol findVariable(BCParser.VariableExpressionContext name);

    BCVariableSymbol findVariable(BCParser.AccessSymbolContext access);
}
