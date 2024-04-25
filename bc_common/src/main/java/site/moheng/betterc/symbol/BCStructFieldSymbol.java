package site.moheng.betterc.symbol;

import lombok.Value;
import lombok.With;

@Value(staticConstructor = "of")
public class BCStructFieldSymbol implements IBCTypeSymbol {
  String name;
  @With
  IBCTypeSymbol type;
}