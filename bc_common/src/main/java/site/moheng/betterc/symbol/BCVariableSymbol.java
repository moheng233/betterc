package site.moheng.betterc.symbol;

import lombok.Value;

@Value(staticConstructor = "of")
public class BCVariableSymbol {
  String name;
  IBCTypeSymbol type;
}
