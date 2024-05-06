package site.moheng.betterc.scope;

import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.variable.BCVariableSymbol;

import java.util.List;
import java.util.Optional;

public interface IBCVariableScope extends IBCScope {
    List<BCVariableSymbol> getVariable();

    Optional<BCVariableSymbol> findVariable(BCParser.VariableExpressionContext name);

    Optional<BCVariableSymbol> findVariable(BCParser.AccessSymbolContext access);
}
