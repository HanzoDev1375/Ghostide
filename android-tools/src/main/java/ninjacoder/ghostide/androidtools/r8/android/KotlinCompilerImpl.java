package ninjacoder.ghostide.androidtools.r8.android;

import android.content.Context;
import ir.ninjacoder.prograsssheet.LayoutSheetEditText;

public class KotlinCompilerImpl {

  private Context c;
  private String filePath;
  private KotlinCompiler com;

  public KotlinCompilerImpl(Context c, String filePath) {
    this.c = c;
    this.filePath = filePath;

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
              et.setSaveText(false);
            });
    com.compile(filePath);
  }
}
