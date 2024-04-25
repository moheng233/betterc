package site.moheng.betterc.jetbrains_plugin.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
import org.eclipse.lsp4j.launch.LSPLauncher;
import org.eclipse.lsp4j.services.LanguageClient;
import org.wso2.lsp4intellij.client.connection.StreamConnectionProvider;
import site.moheng.betterc.lsp.BCLanguageServer;

public class BetterCConnectionProvider implements StreamConnectionProvider {
  final PipedInputStream serverInputStream = new PipedInputStream();
  final PipedOutputStream serverOutputStream = new PipedOutputStream();

  final PipedInputStream input;
  final PipedOutputStream output;

  final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
  final Launcher<LanguageClient> launcher;

  public BetterCConnectionProvider() {
    this.input = new PipedInputStream();
    this.output = new PipedOutputStream();
    this.launcher = LSPLauncher.createServerLauncher(new BCLanguageServer(), serverInputStream,
        serverOutputStream, executor, this::wrapper);
  }

  @Override
  public void start() throws IOException {
    input.connect(serverOutputStream);
    output.connect(serverInputStream);
    launcher.startListening();
  }

  public MessageConsumer wrapper(MessageConsumer message) {
    return message;
  }

  @Override
  public InputStream getInputStream() {
    return input;
  }

  @Override
  public OutputStream getOutputStream() {
    return output;
  }

  @Override
  public void stop() {
    try {
      input.close();
      output.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
