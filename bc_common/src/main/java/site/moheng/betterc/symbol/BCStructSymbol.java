package site.moheng.betterc.symbol;

import java.util.List;
import lombok.Value;
import lombok.With;

@Value(staticConstructor = "of")
public class BCStructSymbol implements IBCTypeSymbol {
  BCLibrarySymbol library;
  String name;
  @With
  List<BCStructFieldSymbol> fields;
}
