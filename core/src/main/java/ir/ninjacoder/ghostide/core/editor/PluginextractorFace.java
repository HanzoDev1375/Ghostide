package ir.ninjacoder.ghostide.core.editor;

import androidx.annotation.MainThread;

public interface PluginextractorFace {
  @MainThread
  void onPluginExtractorDone();

  @MainThread
  void onPluginExtractorError();
}
