package site.moheng.betterc.scope;

import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.apache.commons.collections4.BidiMap;
import site.moheng.betterc.symbol.type.BCInterfaceSymbol;
import site.moheng.betterc.symbol.type.BCMethodSymbol;
import site.moheng.betterc.symbol.type.BCStructSymbol;
import site.moheng.betterc.symbol.type.BCTypeSymbol;
import site.moheng.betterc.symbol.variable.BCVariableSymbol;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/// TODO
@AllArgsConstructor
public final class BCLibraryScope implements IBCTypeScope {
    private final BidiMap<String, BCVariableSymbol> variables;
    private final BidiMap<String, BCInterfaceSymbol> interfaces;
    private final BidiMap<String, BCStructSymbol> structs;
    private final BidiMap<String, BCMethodSymbol> methods;

    @Override
    public Set<BCTypeSymbol> getTypes() {
        // TODO:
        return null;
    }

    @Override
    public <T extends BCTypeSymbol> List<T> completion(final String token, final Class<T> type) {
        // TODO:
        return null;
    }

    @Override
    public Optional<BCTypeSymbol> find(final Token token) {
        return Optional.empty();
    }
}
