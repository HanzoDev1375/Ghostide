package Ninja.coder.Ghostemane.code.tasks.app;

import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import Ninja.coder.Ghostemane.code.utils.SetThemeForJson;
import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import de.larsgrefer.sass.embedded.CompileSuccess;
import de.larsgrefer.sass.embedded.android.AndroidSassCompilerFactory;
import io.github.rosemoe.sora.langs.desc.SCSSDescription;
import io.github.rosemoe.sora.langs.universal.UniversalLanguage;
import io.github.rosemoe.sora.widget.CodeEditor;

import java.io.File;
import java.util.HashMap;

public class SassForAndroid {
  private static HashMap<String, Object> imap = new HashMap<>();

  public static String CompileForStringScss(String input, Context context) {
    try (var compiler = AndroidSassCompilerFactory.bundled(context)) {
      CompileSuccess sb = compiler.compileScssString(input);
      return sb.getCss();
    } catch (Exception err) {
      return err.getLocalizedMessage();
    }
  }

  public static String CompilerForFile(File input, Context context) {
    try (var compiler = AndroidSassCompilerFactory.bundled(context)) {
      CompileSuccess sb = compiler.compileFile(input);
      StringBuilder b = new StringBuilder();
      b.append(compiler.getVersion().toString()).append("\n");
      b.append(sb.getCss()).append("\n");
      return b.toString();
    } catch (Exception err) {
      return err.getLocalizedMessage();
    }
  }

  public static void CompileForStringSass(String input, String output, Context context) {
    try (var compiler = AndroidSassCompilerFactory.bundled(context)) {
      CompileSuccess sb = compiler.compileSassString(input);
      output = sb.getCss();
    } catch (Exception err) {
      err.printStackTrace();
    }
  }

  public static void run(Context context, String input, String output) {
    try {
      String cssContent = CompilerForFile(new File(input), context);
      var sheet = new BottomSheetDialog(context);
      var tv = new CodeEditor(context);
      LinearLayout.LayoutParams param =
          new LinearLayout.LayoutParams(
              LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
      tv.setLayoutParams(param);
      param.rightMargin = 3;
      param.leftMargin = 3;
      tv.setPadding(9, 9, 9, 9);
      sheet.setContentView(tv);
      tv.post(() -> tv.setText(cssContent));

      tv.setEditorLanguage(new UniversalLanguage(new SCSSDescription()));
      tv.setKeyboardOperation(
          new CodeEditor.OnKeyboardOperation() {

            @Override
            public void Enter() {}

            @Override
            public void Removed() {}

            @Override
            public void Tab() {}

            @Override
            public void Space() {}
          });
      tv.setLigatureEnabled(true);
      tv.setHighlightCurrentBlock(false);
      tv.setHighlightCurrentLine(false);
      tv.setAutoCompletionOnComposing(false);
      tv.setLineInfoTextSize(20f);
      tv.setBlockLineEnabled(true);
      tv.setLineNumberEnabled(false);
      imap = new HashMap<>();
      try {
        imap =
            new Gson()
                .fromJson(
                    FileUtil.readFile("storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost"),
                    new TypeToken<HashMap<String, Object>>() {}.getType());
      } catch (Exception err) {
        err.printStackTrace();
      }
      var theme = new SetThemeForJson();
      theme.setThemeCodeEditor(tv, imap, true, (Activity) context);
      ColorAndroid12.runOnUiThread(
          () -> {
            if (input.contains(".sass")) {
              FileUtil.writeFile(output.replace(".sass", ".css"), cssContent);
            } else if (output.contains(".scss")) {
              FileUtil.writeFile(output.replace(".scss", ".css"), cssContent);
            }
          });

      sheet.show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
