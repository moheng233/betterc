package site.moheng.betterc;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Pattern;


public final class URIHelper {
    final static Pattern pattern = Pattern.compile("^((?<namespace>([^/:])+):)?(?<path>(\\/([^/]+))+)");

    public static @Nullable URIHelper.URIResult match(String uri) {
        final var matcher = pattern.matcher(uri);
        if (matcher.matches()) {
            return new URIResult(matcher.group("namespace"), matcher.group("path"));
        }
        return null;
    }

    public record URIResult(
            @Nullable String namespace,
            @NonNull String path
    ) {

    }
}
