package site.moheng.betterc.scope;

import org.antlr.v4.runtime.Token;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import site.moheng.betterc.symbol.type.BCTypeSymbol;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/// TODO
public final class BCLibraryScope implements IBCTypeScope {
    private final BidiMap<Token, BCTypeSymbol> typeSymbolMap;

    public BCLibraryScope(final Map<Token, BCTypeSymbol> map) {
        typeSymbolMap = new DualHashBidiMap<>(map);
    }

    @Override
    public Set<BCTypeSymbol> getTypes() {
        return typeSymbolMap.values();
    }

    @Override
    public <T extends BCTypeSymbol> List<T> completion(final String token, final Class<T> type) {
        return typeSymbolMap
                .entrySet()
                .stream()
                .filter(e -> e.getKey().getClass() == type)
                .filter(e -> e.getKey().getText().contains(token))
                .map(e -> (T) e.getValue())
                .toList();
    }

    @Override
    public Optional<BCTypeSymbol> find(final Token token) {
        return Optional.ofNullable(typeSymbolMap.get(token));
    }
}
