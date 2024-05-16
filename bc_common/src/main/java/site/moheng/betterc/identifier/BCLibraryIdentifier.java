package site.moheng.betterc.identifier;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record BCLibraryIdentifier(
        BCPackageIdentifier packageName,
        String libraryPath
) implements BCIdentifier {

    @Contract("_, _ -> new")
    public static @NotNull BCLibraryIdentifier with(String packageName, String libraryPath) {
        return new BCLibraryIdentifier(new BCPackageIdentifier(packageName), libraryPath);
    }

    @Override
    @Contract(pure = true)
    public @NotNull String getFQN() {
        return packageName.getFQN() + libraryPath;
    }
}
