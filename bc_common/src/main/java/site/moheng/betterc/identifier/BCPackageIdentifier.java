package site.moheng.betterc.identifier;

public record BCPackageIdentifier(String packageName) implements BCIdentifier {
    @Override
    public String getFQN() {
        return STR."\{packageName}:";
    }
}
