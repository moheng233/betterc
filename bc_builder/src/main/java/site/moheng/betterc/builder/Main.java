package site.moheng.betterc.builder;

import picocli.CommandLine;

@CommandLine.Command(name = "bcc", subcommands = {CommandLine.HelpCommand.class, BCPackage.class})
public class Main {
    public static void main(String[] args) {
        System.exit(new CommandLine(new Main()).execute(args));
    }
}
