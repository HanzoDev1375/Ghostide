package ir.ninjacoder.ghostide.tasks.app;

import android.widget.Toast;
import com.inet.lib.less.Less;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.enums.CompilerModel;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.utils.FileUtil;
import ir.ninjacoder.ghostide.utils.ThemeUtils;
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
import java.net.URL;
import com.caoccao.javet.swc4j.options.Swc4jTranspileOptions;
import com.caoccao.javet.swc4j.enums.Swc4jMediaType;
import com.caoccao.javet.swc4j.enums.Swc4jSourceMapOption;
import com.caoccao.javet.swc4j.outputs.Swc4jTranspileOutput;
import com.caoccao.javet.swc4j.Swc4j;
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
      // b.append(compiler.getVersion().toString()).append("\n");
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

  public static void runObjectWeb(IdeEditor input, String output, CompilerModel model) {
    try {

      String code = input.getText().toString();
      URL specifier = new URL("file:///storage/emulated/0/Apktool_M/hsi.js");
      if (model == CompilerModel.JSX) {
        Swc4jTranspileOptions options =
            new Swc4jTranspileOptions()
                .setSpecifier(specifier)
                .setTransformJsx(true)
                .setSourceMap(Swc4jSourceMapOption.None)
                .setMediaType(Swc4jMediaType.Jsx)
                .setCaptureAst(true);

        Swc4jTranspileOutput outputs = new Swc4j().transpile(code, options);
        // Print the transpiled code.

        FileUtil.writeFile(output.replace(".jsx", ".js"), outputs.getCode());

      } else if (model == CompilerModel.TSX) {
        Swc4jTranspileOptions options =
            new Swc4jTranspileOptions()
                .setSpecifier(specifier)
                .setTransformJsx(true)
                .setSourceMap(Swc4jSourceMapOption.None)
                .setMediaType(Swc4jMediaType.Tsx)
                .setCaptureAst(true);

        Swc4jTranspileOutput outputs = new Swc4j().transpile(code, options);
        // Print the transpiled code.
        FileUtil.writeFile(output.replace(".tsx", ".js"), outputs.getCode());

      } else if (model == CompilerModel.TYPESRCIPT) {
        Swc4jTranspileOptions options =
            new Swc4jTranspileOptions()
                .setSpecifier(specifier)
                .setTransformJsx(true)
                .setSourceMap(Swc4jSourceMapOption.None)
                .setMediaType(Swc4jMediaType.TypeScript)
                .setCaptureAst(true);

        Swc4jTranspileOutput outputs = new Swc4j().transpile(code, options);
        // Print the transpiled code.

        FileUtil.writeFile(output.replace(".ts", ".js"), outputs.getCode());
      } else if (model == CompilerModel.NODEJS) {
        Swc4jTranspileOptions options =
            new Swc4jTranspileOptions()
                .setSpecifier(specifier)
                .setTransformJsx(true)
                .setSourceMap(Swc4jSourceMapOption.None)
                .setMediaType(Swc4jMediaType.JavaScript)
                .setCaptureAst(true);

        Swc4jTranspileOutput outputs = new Swc4j().transpile(code, options);
        // Print the transpiled code.

        FileUtil.writeFile(output.replace(".js", ".nodecompile.js"), outputs.getCode());
      } else if (model == CompilerModel.LESS) {
        FileUtil.writeFile(output.replace(".less", ".css"), getLessCode(input.getTextAsString()));
      }
    } catch (Exception err) {

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
      var theme = new ThemeUtils();
      theme.setThemeCodeEditor(tv, imap, true, (Activity) context);
      ObjectUtils.runOnUiThread(
          () -> {
            if (input.contains(".sass")) {
              FileUtil.writeFile(output.replace(".sass", ".css"), cssContent);
              Toast.makeText(context, "File saved: " + output.replace(".sass ", ".css"), 1).show();
            } else if (output.contains(".scss")) {
              Toast.makeText(context, "File saved: " + output.replace(".scss ", ".css"), 1).show();
              FileUtil.writeFile(output.replace(".scss", ".css"), cssContent);
            }
          });

      sheet.show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static String getLessCode(String code) {
    return Less.compile(null, code, true);
  }
}
