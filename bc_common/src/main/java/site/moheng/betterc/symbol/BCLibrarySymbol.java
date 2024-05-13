package site.moheng.betterc.symbol;

import com.googlecode.cqengine.attribute.Attribute;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.googlecode.cqengine.query.QueryFactory.attribute;


public record BCLibrarySymbol(String namespace, String path) {
    public static final BCLibrarySymbol STD = BCLibrarySymbol.of("bc", "std");
    public static final BCLibrarySymbol GLOBAL = BCLibrarySymbol.of("global");

    public static final Attribute<BCLibrarySymbol, String> FULL_NAME = attribute(BCLibrarySymbol.class, String.class, "full_name", BCLibrarySymbol::fullName);
    public static final Attribute<BCLibrarySymbol, String> NAMESPACE = attribute(BCLibrarySymbol.class, String.class, "namespace", BCLibrarySymbol::namespace);
    public static final Attribute<BCLibrarySymbol, String> PATH = attribute(BCLibrarySymbol.class, String.class, "path", BCLibrarySymbol::path);

    @Contract("_, _ -> new")
    public static @NotNull BCLibrarySymbol of(final String namespace, final String... path) {
        return BCLibrarySymbol.of(namespace, Paths.get("", path));
    }


    @Contract("_, _ -> new")
    public static @NotNull BCLibrarySymbol of(final @NotNull String namespace, final @NotNull Path path) {
        final var npath = path.normalize();
        final String[] splice_path = new String[npath.getNameCount()];

        for (int i = 0; i < npath.getNameCount(); i++) {
            splice_path[i] = npath.getName(i).toString();
        }

        return new BCLibrarySymbol(namespace, String.join("/", splice_path));
    }

    public @NotNull String fullName() {
        return namespace() + ":" + path();
    }

    public @NotNull String symbolPrefixName() {
        return namespace().toLowerCase() + "_" + String.join("_", path) + "_";
    }
}
