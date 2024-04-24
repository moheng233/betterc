package site.moheng.betterc.symbol;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public record BCLibrarySymbol(String uri, List<BCLibrarySymbol> imports) {
    public static final BCLibrarySymbol STD = new BCLibrarySymbol("bc:std", List.of());
    public static final BCLibrarySymbol GLOBAL = new BCLibrarySymbol("global", List.of());

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
