package site.moheng.betterc.scope;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.antlr.v4.runtime.Token;
import site.moheng.betterc.symbol.IBCTypeSymbol;

public interface IBCTypeScope extends IBCScope {
  Set<IBCTypeSymbol> getTypes();

  /**
   * @param token 需要联想的未完成的Token
   * @param type  正在联想的符号类型
   * @param <T>   符号类型
   * @return 被联想的符号列表
   */
  <T extends IBCTypeSymbol> List<T> completion(Token token, Class<T> type);

  Optional<IBCTypeSymbol> find(Token token);
}
