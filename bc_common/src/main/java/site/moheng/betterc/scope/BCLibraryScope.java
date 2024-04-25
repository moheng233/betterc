package site.moheng.betterc.scope;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.antlr.v4.runtime.Token;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import site.moheng.betterc.symbol.IBCTypeSymbol;

/// TODO
public class BCLibraryScope implements IBCTypeScope {
  private final BidiMap<Token, IBCTypeSymbol> typeSymbolMap;

  public BCLibraryScope(Map<Token, IBCTypeSymbol> map) {
    typeSymbolMap = new DualHashBidiMap<>(map);
  }

  @Override
  public Set<IBCTypeSymbol> getTypes() {
    return typeSymbolMap.values();
  }

  @Override
  public <T extends IBCTypeSymbol> List<T> completion(Token token, Class<T> type) {
    return typeSymbolMap
        .entrySet()
        .stream()
        .filter(e -> e.getKey().getClass() == type)
        .filter(e -> e.getKey().getText().contains(token.getText()))
        .map(e -> (T) e.getValue())
        .toList();
  }

  @Override
  public Optional<IBCTypeSymbol> find(Token token) {
    return Optional.ofNullable(typeSymbolMap.get(token));
  }
}
