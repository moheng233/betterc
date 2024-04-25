package site.moheng.betterc.symbol;

import java.util.List;
import lombok.Value;

@Value(staticConstructor = "of")
public class BCInterfaceSymbol implements IBCTypeSymbol {
  BCLibrarySymbol library;
  String name;
  List<BCMethodSymbol> methods;
}
