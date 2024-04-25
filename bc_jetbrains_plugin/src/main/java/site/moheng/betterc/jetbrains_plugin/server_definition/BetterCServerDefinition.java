package site.moheng.betterc.jetbrains_plugin.server_definition;

import java.util.Collections;
import org.wso2.lsp4intellij.client.connection.StreamConnectionProvider;
import org.wso2.lsp4intellij.client.languageserver.serverdefinition.LanguageServerDefinition;
import site.moheng.betterc.jetbrains_plugin.connection.BetterCConnectionProvider;

public class BetterCServerDefinition extends LanguageServerDefinition {
  public BetterCServerDefinition() {
    super();
    this.ext = "bc";
    this.languageIds = Collections.singletonMap(this.ext, "BetterC");
  }

  @Override
  public StreamConnectionProvider createConnectionProvider(String workingDir) {
    return new BetterCConnectionProvider();
  }
}
