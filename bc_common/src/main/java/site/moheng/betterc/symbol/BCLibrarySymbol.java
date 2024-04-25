package site.moheng.betterc.symbol;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Value
@AllArgsConstructor(staticName = "of")
public class BCLibrarySymbol {
  public static final BCLibrarySymbol STD = BCLibrarySymbol.of("bc:std");
  public static final BCLibrarySymbol GLOBAL = BCLibrarySymbol.of("global");

  String uri;

  public @NotNull String getNamespace() {
    if (Objects.equals(uri, "global")) {
      return "global";
    }
    if (uri.contains(":")) {
      return uri.substring(0, uri.lastIndexOf(':'));
    }
    return "";
  }

  public @NotNull String getPath() {
    if (Objects.equals(uri, "global")) {
      return "";
    }
    if (uri.contains(":")) {
      return uri.substring(uri.lastIndexOf(':') + 1);
    }

    return uri;
  }
}
