package ir.ninjacoder.ghostide.navigator;

import com.blankj.utilcode.util.ThreadUtils;
import io.github.rosemoe.sora.langs.glsllang.GLSLLang;
import io.github.rosemoe.sora.langs.jsx.JavaScriptJsxLanguage;
import io.github.rosemoe.sora.langs.yml.YmlLang;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.utils.FileCompatApi28;
import ir.ninjacoder.ghostide.utils.FileUtil;
import ir.ninjacoder.ghostide.widget.ExrtaFab;
import android.widget.ProgressBar;
import io.github.rosemoe.sora.langs.Javacc.JavaccLang;
import io.github.rosemoe.sora.langs.antlrlang.ANTLRV4Lang;
import io.github.rosemoe.sora.langs.cpp.CppLanguage;
import io.github.rosemoe.sora.langs.csharp.CSharpLanguage;
import io.github.rosemoe.sora.langs.json.JsonLanguage;
import io.github.rosemoe.sora.langs.dart.DartLang;
import io.github.rosemoe.sora.langs.kotlin.KotlinLanguage;
import io.github.rosemoe.sora.langs.groovy.lang.GroovyLanguage;
import io.github.rosemoe.sora.langs.php.PHPLanguage;
import io.github.rosemoe.sora.langs.typescript.TsLang;
import io.github.rosemoe.sora.langs.css3.CSS3Language;
import io.github.rosemoe.sora.langs.desc.*;
import io.github.rosemoe.sora.langs.ghostthemelang.ghostlang.ghostlangs;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.langs.javascript.JavaScriptLanguage;
import io.github.rosemoe.sora.langs.markdown.MarkDownLang;
import io.github.rosemoe.sora.langs.ninjalang.NinjaLang;
import io.github.rosemoe.sora.langs.properties.Propertieslangs;
import io.github.rosemoe.sora.langs.python.PythonLang;
import io.github.rosemoe.sora.langs.sass.SassLangCompat;
import io.github.rosemoe.sora.langs.smali.SMLang;
import io.github.rosemoe.sora.langs.sql.MySqlLang;
import io.github.rosemoe.sora.langs.svg.SvgLang;
import io.github.rosemoe.sora.langs.universal.UniversalLanguage;
import io.github.rosemoe.sora.langs.xml.XMLLanguage;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import org.benf.cfr.reader.api.CfrDriver;
import org.benf.cfr.reader.api.OutputSinkFactory;
import org.benf.cfr.reader.api.SinkReturns;

/*
 * <p> this class Work Reload is Lang files  </p>
 * <p> code by ninja coder </p>
 */

public class EditorRoaderFile {

  public static void RuningTask(IdeEditor editor, ExrtaFab _fab, String _path, ProgressBar bar) {

    if (_path.endsWith(".css")) {
      // this html lexer using as html css3 js and sass and scass
      var CSS = new CSS3Language(editor);
      editor.setEditorLanguage(CSS);
      ReadFileCompat(editor, _path, bar);
    } else if (_path.endsWith(".py")) {
      editor.setEditorLanguage(new PythonLang(editor));
      ReadFileCompat(editor, _path, bar);
      _fab.postDelayed(_fab::show, 400);
    } else if (_path.endsWith(".cpp")
        || _path.endsWith(".cxx")
        || _path.endsWith(".cc")
        || _path.endsWith(".h")
        || _path.endsWith(".hpp")) {
      editor.setEditorLanguage(new CppLanguage());
      _fab.postDelayed(_fab::show, 400);
      ReadFileCompat(editor, _path, bar);
    } else if (_path.endsWith(".html")) {
      var htmllang = new HTMLLanguage(editor);
      editor.setEditorLanguage(htmllang);
      ReadFileCompat(editor, _path, bar);
      _fab.postDelayed(_fab::show, 400);
    } else if (_path.endsWith(".js")) {
      editor.setEditorLanguage(new JavaScriptLanguage());
      ReadFileCompat(editor, _path, bar);
      _fab.postDelayed(_fab::show, 400);
    } else if (_path.endsWith(".scss")) {
      ReadFileCompat(editor, _path, bar);
      var it = new SassLangCompat();
      it.setSassMod(false);
      editor.setEditorLanguage(it);
      _fab.postDelayed(_fab::show, 300);
    } else if (_path.endsWith(".c")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new UniversalLanguage(new CDescription()));
    } else if (_path.endsWith(".json")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new JsonLanguage());
      _fab.postDelayed(_fab::show, 400);
    } else if (_path.endsWith(".java")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new JavaLanguage(editor));
      _fab.postDelayed(_fab::show, 400);
    } else if (_path.endsWith(".cs")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new CSharpLanguage());
    } else if (_path.endsWith(".xml")) {
      ReadFileCompat(editor, _path, bar);
      //	editor.setEditorLanguage(new io.github.rosemoe.sora.langs.xml.XMLLanguage());
      XMLLanguage xmlLanguage = new XMLLanguage();
      xmlLanguage.setSyntaxCheckEnable(true);
      editor.setEditorLanguage(xmlLanguage);
      _fab.postDelayed(_fab::show, 400);
    } else if (_path.endsWith(".ghost")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new ghostlangs());
    } else if (_path.endsWith(".ninja")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new NinjaLang());
    } else if (_path.endsWith(".sh")) {
      ReadFileCompat(editor, _path, bar);
      _fab.postDelayed(_fab::show, 400);
      editor.setEditorLanguage(new UniversalLanguage(new ShellDescription()));
    } else if (_path.endsWith(".svg")) {
      ReadFileCompat(editor, _path, bar);
      //  ic.setVisibility(View.VISIBLE);
      //  GlideCompat.LoadSvg(_path, ic);
      _fab.postDelayed(_fab::show, 400);
      var htmllang = new SvgLang(editor);
      editor.setEditorLanguage(htmllang);
    } else if (_path.endsWith(".md")) {
      ReadFileCompat(editor, _path, bar);
      _fab.postDelayed(_fab::show, 400);
      editor.setEditorLanguage(new MarkDownLang());
    } else if (_path.endsWith(".php")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new PHPLanguage(editor));
      _fab.postDelayed(_fab::show, 400);
    } else if (_path.endsWith(".go")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new UniversalLanguage(new GoDescription()));
    } else if (_path.endsWith(".txt")) {
      ReadFileCompat(editor, _path, bar);
    } else if (_path.endsWith(".swift")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new UniversalLanguage(new SwiftDescription()));
    } else if (_path.endsWith(".rb") || _path.endsWith(".rbw")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new UniversalLanguage(new RubyDescription()));
    } else if (_path.endsWith(".dart")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new DartLang());
    } else if (_path.endsWith(".kt")) {
      ReadFileCompat(editor, _path, bar);
      _fab.postDelayed(_fab::show, 400);
      editor.setEditorLanguage(new KotlinLanguage());
    } else if (_path.endsWith(".groovy") || _path.endsWith(".gradle")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new GroovyLanguage());
    } else if (_path.endsWith("jdjeje")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new UniversalLanguage(new CppDescription()));
    } else if (_path.endsWith(".smali")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new SMLang());
    } else if (_path.endsWith(".g4")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new ANTLRV4Lang());
      _fab.postDelayed(_fab::show, 400);
    } else if (_path.endsWith(".ts")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new TsLang(editor));
    } else if (_path.endsWith(".properties")) {
      _fab.hide();
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new Propertieslangs());
    } else if (_path.endsWith(".sql")) {
      _fab.hide();
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new MySqlLang());
    } else if (_path.endsWith(".jj")) {

      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new JavaccLang(editor));
      _fab.postDelayed(_fab::show, 400);
    } else if (_path.endsWith(".frag")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new GLSLLang());
      _fab.postDelayed(_fab::hide, 400);
    } else if (_path.endsWith(".sass")) {
      var scssLang = new SassLangCompat();
      scssLang.setSassMod(true);
      editor.setEditorLanguage(scssLang);
      _fab.postDelayed(_fab::show, 400);
      ReadFileCompat(editor, _path, bar);
    } else if (_path.endsWith(".class")) {
      editor.setEditorLanguage(new JavaLanguage(editor));
      _fab.postDelayed(_fab::hide, 400);
      ThreadUtils.executeByIo(
          new ThreadUtils.SimpleTask<String>() {

            @Override
            public void onFail(Throwable arg0) {
              super.onFail(arg0);
            }

            @Override
            public void onSuccess(String arg0) {
              editor.setText(arg0);
            }

            @Override
            public void onCancel() {
              super.onCancel();
            }

            @Override
            public String doInBackground() {
              return decompileClass(new File(_path));
            }
          });

    } else if (_path.endsWith(".yml")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new YmlLang());
      _fab.postDelayed(_fab::hide, 400);
    } else if (_path.endsWith(".jsx")) {
      ReadFileCompat(editor, _path, bar);
      editor.setEditorLanguage(new JavaScriptJsxLanguage());
      _fab.postDelayed(_fab::hide, 400);
    } else {
      ReadFileCompat(editor, _path, bar);
      _fab.postDelayed(_fab::hide, 400);
    }
  }

  protected static void ReadFileCompat(CodeEditor editor, String path, ProgressBar bar) {
    try {
      FileCompatApi28.readFile(path, bar, editor);
    } catch (Throwable e) {
      editor.setText(e.toString());
    }
  }

  private static String decompileClass(File classFile) {
    final StringBuilder result = new StringBuilder();

    if (!classFile.exists()) {
      return "فایل یافت نشد!";
    }

    try {
      CfrDriver driver =
          new CfrDriver.Builder()
              .withOutputSink(
                  new OutputSinkFactory() {
                    @Override
                    public List<SinkClass> getSupportedSinks(
                        SinkType sinkType, Collection<SinkClass> collection) {
                      return Collections.singletonList(SinkClass.DECOMPILED);
                    }

                    @Override
                    public <T> Sink<T> getSink(SinkType sinkType, SinkClass sinkClass) {
                      return value -> {
                        if (value instanceof SinkReturns.Decompiled) {
                          String code = ((SinkReturns.Decompiled) value).getJava();
                          result.append(code).append("\n"); // اضافه کردن خط جدید
                        }
                      };
                    }
                  })
              .withOptions(
                  Map.of(
                      "showversion", "false",
                      "comments", "false",
                      "decodefinally", "true" // اضافه کردن برای بهبود خروجی
                      ))
              .build();

      driver.analyse(Collections.singletonList(classFile.getAbsolutePath()));

      return result.toString().replace("Decompiled with CFR", "").replaceAll("\\*\\s+\\.", "");

    } catch (Exception e) {
      return e.getLocalizedMessage();
    }
  }
}
