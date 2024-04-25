package site.moheng.betterc.jetbrains_plugin;

import com.intellij.openapi.application.PreloadingActivity;
import org.wso2.lsp4intellij.IntellijLanguageClient;
import site.moheng.betterc.jetbrains_plugin.server_definition.BetterCServerDefinition;

public class BetterCPreloadingActivity extends PreloadingActivity {

  @Override
  public void preload() {
    super.preload();
    IntellijLanguageClient.addServerDefinition(new BetterCServerDefinition());
  }
}
