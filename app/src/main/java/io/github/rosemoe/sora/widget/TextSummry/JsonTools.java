package io.github.rosemoe.sora.widget.TextSummry;

import android.content.Context;
import android.view.View;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.Transilt;
import ir.ninjacoder.ghostide.IdeEditor;

public class JsonTools {

  public static void run(IdeEditor editor, View v, Context x) {
    Transilt.StartbyJsonObject((CodeEditor) editor, "translate");
  }
}
