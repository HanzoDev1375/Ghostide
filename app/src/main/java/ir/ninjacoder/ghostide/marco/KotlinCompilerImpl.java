package ir.ninjacoder.ghostide.marco;

import android.content.Context;
import ir.ninjacoder.ghostide.IdeEditor;
import ninjacoder.ghostide.androidtools.r8.android.KotlinCompiler;
import ir.ninjacoder.prograsssheet.LayoutSheetEditText;

public class KotlinCompilerImpl {

  private Context c;
  private String filePath;
  private KotlinCompiler com;
  private IdeEditor editor;

  public KotlinCompilerImpl(Context c, String filePath, IdeEditor editor) {
    this.c = c;
    this.filePath = filePath;
    this.editor = editor;

    init();
  }

  void init() {
    LayoutSheetEditText et = new LayoutSheetEditText(c);
    et.getInputLayout().getEditText().setSingleLine(false);

    com =
        new KotlinCompiler(
            et.getInputLayout().getEditText(),
            c,
            () -> {
              et.show();
              et.setokClick(v -> et.dismiss());
              et.setnoClick(v -> et.dismiss());
              et.setTitle("Result");
              et.setText("");
              et.applyClickableSpans(
                  (ll) -> {
                    et.dismiss();
                    editor.jumpToLine(ll);
                  });

              et.setSaveText(false);
              
            });

    com.compile(filePath);
  }
}
