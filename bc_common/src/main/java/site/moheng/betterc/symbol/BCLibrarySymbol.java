package site.moheng.betterc.symbol;

import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.nio.file.Paths;

@Value
public class BCLibrarySymbol {
    public static final BCLibrarySymbol STD = BCLibrarySymbol.of("bc", "std");
    public static final BCLibrarySymbol GLOBAL = BCLibrarySymbol.of("global");

    String namespace;
    String[] path;

    private BCLibrarySymbol(String namespace, String[] path) {
        this.namespace = namespace;
        this.path = path;
    }

    public static @NotNull BCLibrarySymbol of(String namespace, String... path) {
        return BCLibrarySymbol.of(namespace, Paths.get("", path));
    }

    @Contract("_, _ -> new")
    public static @NotNull BCLibrarySymbol of(final @NotNull String namespace, final @NotNull Path path) {
        final var npath = path.normalize();
        final String[] splice_path = new String[npath.getNameCount()];

        for (int i = 0; i < npath.getNameCount(); i++) {
            splice_path[i] = npath.getName(i).toString();
        }

        return new BCLibrarySymbol(namespace, splice_path);
    }

    public @NotNull String getSymbolPrefixName() {
        return getNamespace().toLowerCase() + "_" + String.join("_", path) + "_";
    }

}
