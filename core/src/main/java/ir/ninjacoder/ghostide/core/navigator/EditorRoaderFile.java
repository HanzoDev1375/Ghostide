package ir.ninjacoder.ghostide.core.navigator;

import android.widget.ProgressBar;

import com.blankj.utilcode.util.ThreadUtils;

import org.benf.cfr.reader.api.CfrDriver;
import org.benf.cfr.reader.api.OutputSinkFactory;
import org.benf.cfr.reader.api.SinkReturns;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import io.github.rosemoe.sora.langs.Javacc.JavaccLang;
import io.github.rosemoe.sora.langs.antlrlang.ANTLRV4Lang;
import io.github.rosemoe.sora.langs.cpp.CppLanguage;
import io.github.rosemoe.sora.langs.csharp.CSharpLanguage;
import io.github.rosemoe.sora.langs.css3.CSS3Language;
import io.github.rosemoe.sora.langs.dart.DartLang;
import io.github.rosemoe.sora.langs.desc.CDescription;
import io.github.rosemoe.sora.langs.desc.GoDescription;
import io.github.rosemoe.sora.langs.desc.RubyDescription;
import io.github.rosemoe.sora.langs.desc.ShellDescription;
import io.github.rosemoe.sora.langs.desc.SwiftDescription;
import io.github.rosemoe.sora.langs.ghostthemelang.ghostlang.ghostlangs;
import io.github.rosemoe.sora.langs.glsllang.GLSLLang;
import io.github.rosemoe.sora.langs.groovy.lang.GroovyLanguage;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.langs.javascript.JavaScriptLanguage;
import io.github.rosemoe.sora.langs.json.JsonLanguage;
import io.github.rosemoe.sora.langs.jsx.JavaScriptJsxLanguage;
import io.github.rosemoe.sora.langs.kotlin.KotlinLanguage;
import io.github.rosemoe.sora.langs.less.LessLang;
import io.github.rosemoe.sora.langs.lua.LuaLang;
import io.github.rosemoe.sora.langs.markdown.MarkDownLang;
import io.github.rosemoe.sora.langs.ninjalang.NinjaLang;
import io.github.rosemoe.sora.langs.php.PHPLanguage;
import io.github.rosemoe.sora.langs.properties.Propertieslangs;
import io.github.rosemoe.sora.langs.python.PythonLang;
import io.github.rosemoe.sora.langs.rust.RustLang;
import io.github.rosemoe.sora.langs.sass.SassLangCompat;
import io.github.rosemoe.sora.langs.smali.SMLang;
import io.github.rosemoe.sora.langs.sql.MySqlLang;
import io.github.rosemoe.sora.langs.svg.SvgLang;
import io.github.rosemoe.sora.langs.typescript.TsLang;
import io.github.rosemoe.sora.langs.universal.UniversalLanguage;
import io.github.rosemoe.sora.langs.xml.XMLLanguage;
import io.github.rosemoe.sora.langs.yml.YmlLang;
import io.github.rosemoe.sora.langs.zig.ZigLanguage;
import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.utils.FileCompatApi28;
import ir.ninjacoder.ghostide.core.widget.ExrtaFab;

/*
 * <p> this class Work Reload is Lang files  </p>
 * <p> code by ninja coder </p>
 */

public class EditorRoaderFile {

  public static void RuningTask(IdeEditor editor, ExrtaFab fab, String path, ProgressBar bar) {

    if (path.endsWith(".css")) {
      // this html lexer using as html css3 js and sass and scass
      var CSS = new CSS3Language(editor);
      editor.setEditorLanguage(CSS);
      ReadFileCompat(editor, path, bar);
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".py")) {
      editor.setEditorLanguage(new PythonLang(editor));
      ReadFileCompat(editor, path, bar);
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".cpp")
        || path.endsWith(".cxx")
        || path.endsWith(".cc")
        || path.endsWith(".h")
        || path.endsWith(".hpp")) {
      editor.setEditorLanguage(new CppLanguage());
      fab.postDelayed(fab::hide, 400);
      ReadFileCompat(editor, path, bar);
    } else if (path.endsWith(".html")) {
      var htmllang = new HTMLLanguage(editor);
      editor.setEditorLanguage(htmllang);
      ReadFileCompat(editor, path, bar);
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".js")) {
      editor.setEditorLanguage(new JavaScriptLanguage());
      ReadFileCompat(editor, path, bar);
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".scss")) {
      ReadFileCompat(editor, path, bar);
      var it = new SassLangCompat();
      it.setSassMod(false);
      editor.setEditorLanguage(it);
      fab.postDelayed(fab::show, 300);
    } else if (path.endsWith(".c")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new UniversalLanguage(new CDescription()));
    } else if (path.endsWith(".json")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new JsonLanguage((CodeEditor) editor));
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".java")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new JavaLanguage(editor));
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".cs")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new CSharpLanguage());
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".xml")) {
      ReadFileCompat(editor, path, bar);
      //	editor.setEditorLanguage(new io.github.rosemoe.sora.langs.xml.XMLLanguage());
      XMLLanguage xmlLanguage = new XMLLanguage();
      xmlLanguage.setSyntaxCheckEnable(true);
      editor.setEditorLanguage(xmlLanguage);
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".ghost")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new ghostlangs());
    } else if (path.endsWith(".ninja")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new NinjaLang());
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".sh")) {
      ReadFileCompat(editor, path, bar);
      fab.postDelayed(fab::show, 400);
      editor.setEditorLanguage(new UniversalLanguage(new ShellDescription()));
    } else if (path.endsWith(".svg")) {
      ReadFileCompat(editor, path, bar);
      fab.postDelayed(fab::show, 400);
      var htmllang = new SvgLang(editor);
      editor.setEditorLanguage(htmllang);
    } else if (path.endsWith(".md")) {
      ReadFileCompat(editor, path, bar);
      fab.postDelayed(fab::show, 400);
      editor.setEditorLanguage(new MarkDownLang());
    } else if (path.endsWith(".php")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new PHPLanguage(editor));
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".go")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new UniversalLanguage(new GoDescription()));
    } else if (path.endsWith(".txt")) {
      ReadFileCompat(editor, path, bar);
    } else if (path.endsWith(".swift")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new UniversalLanguage(new SwiftDescription()));
    } else if (path.endsWith(".rb") || path.endsWith(".rbw")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new UniversalLanguage(new RubyDescription()));
    } else if (path.endsWith(".dart")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new DartLang());
    } else if (path.endsWith(".kt")) {
      ReadFileCompat(editor, path, bar);
      fab.postDelayed(fab::show, 400);
      editor.setEditorLanguage(new KotlinLanguage());
    } else if (path.endsWith(".groovy") || path.endsWith(".gradle")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new GroovyLanguage());
    } else if (path.endsWith(".smali")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new SMLang());
    } else if (path.endsWith(".g4")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new ANTLRV4Lang());
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".ts") || path.endsWith(".tsx")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new TsLang(editor));
    } else if (path.endsWith(".properties")) {
      fab.hide();
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new Propertieslangs());
    } else if (path.endsWith(".sql")) {
      fab.hide();
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new MySqlLang());
    } else if (path.endsWith(".jj")) {

      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new JavaccLang(editor));
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".frag")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new GLSLLang());
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".sass")) {
      var scssLang = new SassLangCompat();
      scssLang.setSassMod(true);
      editor.setEditorLanguage(scssLang);
      fab.postDelayed(fab::show, 400);
      ReadFileCompat(editor, path, bar);
    } else if (path.endsWith(".class")) {
      editor.setEditorLanguage(new JavaLanguage(editor));
      fab.postDelayed(fab::hide, 400);
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
              return decompileClass(new File(path));
            }
          });

    } else if (path.endsWith(".yml")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new YmlLang());
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".jsx") || path.endsWith(".tsx")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new JavaScriptJsxLanguage());
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".less")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new LessLang((CodeEditor) editor));
      fab.postDelayed(fab::show, 400);
    } else if (path.endsWith(".rs")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new RustLang(editor));
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".zig")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new ZigLanguage(editor));
      fab.postDelayed(fab::hide, 400);
    } else if (path.endsWith(".lua")) {
      ReadFileCompat(editor, path, bar);
      editor.setEditorLanguage(new LuaLang());
      fab.postDelayed(fab::hide, 400);
    } else {
      ReadFileCompat(editor, path, bar);
      fab.postDelayed(fab::hide, 400);
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
