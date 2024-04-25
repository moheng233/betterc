package site.moheng.betterc.lsp;

import org.eclipse.lsp4j.launch.LSPLauncher;

public class Main {
    public static void main(String[] args) {
        final var launcher = LSPLauncher.createServerLauncher(new BCLanguageServer(), System.in, System.out);
        launcher.startListening();
    }
}
