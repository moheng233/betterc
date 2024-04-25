package site.moheng.betterc.symbol;

import java.util.List;
import lombok.Value;
import lombok.With;

@Value(staticConstructor = "of")
public class BCMethodSymbol implements IBCTypeSymbol {
  String name;
  @With
  IBCTypeSymbol returnValue;
  @With
  List<BCMethodArgSymbol> args;
}
