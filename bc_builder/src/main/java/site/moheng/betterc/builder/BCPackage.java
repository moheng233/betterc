package site.moheng.betterc.builder;

import picocli.CommandLine;

@CommandLine.Command(name = "package")
public class BCPackage {
    public BCPackage() {

    }

    @CommandLine.Command()
    public int add(
            @CommandLine.Parameters(paramLabel = "name") String[] names) {
        return 0;
    }
}
