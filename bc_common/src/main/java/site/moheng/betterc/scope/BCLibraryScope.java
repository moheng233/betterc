package site.moheng.betterc.scope;

import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.symbol.BCInterfaceSymbol;
import site.moheng.betterc.symbol.BCStructSymbol;

import java.util.List;

/// TODO
public class BCLibraryScope implements IBCMethodScope, IBCInterfaceScope, IBCStructScope {
    @Override
    public List<BCInterfaceSymbol> getInterfaces() {
        return List.of();
    }

    @Override
    public BCInterfaceSymbol findInterface(BCParser.StructDeclarationContext name) {
        return null;
    }

    @Override
    public BCInterfaceSymbol findInterface(BCParser.AccessSymbolContext access) {
        return null;
    }

    @Override
    public List<BCStructSymbol> getMethod() {
        return List.of();
    }

    @Override
    public BCStructSymbol findMethod(BCParser.MethodDeclarationContext name) {
        return null;
    }

    @Override
    public BCStructSymbol findMethod(BCParser.AccessSymbolContext access) {
        return null;
    }

    @Override
    public List<BCStructSymbol> getStructs() {
        return List.of();
    }

    @Override
    public BCStructSymbol findStruct(BCParser.StructDeclarationContext name) {
        return null;
    }

    @Override
    public BCStructSymbol findStruct(BCParser.AccessSymbolContext access) {
        return null;
    }
}
