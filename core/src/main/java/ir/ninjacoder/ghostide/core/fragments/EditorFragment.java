package ir.ninjacoder.ghostide.core.fragments;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.github.rosemoe.sora.langs.css3.CSS3Language;
import io.github.rosemoe.sora.langs.python.PythonLang;
import io.github.rosemoe.sora.langs.cpp.CppLanguage;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.langs.javascript.JavaScriptLanguage;
import io.github.rosemoe.sora.langs.sass.SassLangCompat;
import io.github.rosemoe.sora.langs.universal.UniversalLanguage;
import io.github.rosemoe.sora.langs.desc.CDescription;
import io.github.rosemoe.sora.langs.json.JsonLanguage;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.langs.csharp.CSharpLanguage;
import io.github.rosemoe.sora.langs.xml.XMLLanguage;
import io.github.rosemoe.sora.langs.ghostthemelang.ghostlang.ghostlangs;
import io.github.rosemoe.sora.langs.ninjalang.NinjaLang;
import io.github.rosemoe.sora.langs.desc.ShellDescription;
import io.github.rosemoe.sora.langs.svg.SvgLang;
import io.github.rosemoe.sora.langs.markdown.MarkDownLang;
import io.github.rosemoe.sora.langs.php.PHPLanguage;
import io.github.rosemoe.sora.langs.desc.GoDescription;
import io.github.rosemoe.sora.langs.desc.SwiftDescription;
import io.github.rosemoe.sora.langs.desc.RubyDescription;
import io.github.rosemoe.sora.langs.dart.DartLang;
import io.github.rosemoe.sora.langs.kotlin.KotlinLanguage;
import io.github.rosemoe.sora.langs.groovy.lang.GroovyLanguage;
import io.github.rosemoe.sora.langs.smali.SMLang;
import io.github.rosemoe.sora.langs.antlrlang.ANTLRV4Lang;
import io.github.rosemoe.sora.langs.typescript.TsLang;
import io.github.rosemoe.sora.langs.properties.Propertieslangs;
import io.github.rosemoe.sora.langs.sql.MySqlLang;
import io.github.rosemoe.sora.langs.Javacc.JavaccLang;
import io.github.rosemoe.sora.langs.glsllang.GLSLLang;
import com.blankj.utilcode.util.ThreadUtils;
import io.github.rosemoe.sora.langs.yml.YmlLang;
import io.github.rosemoe.sora.langs.jsx.JavaScriptJsxLanguage;
import io.github.rosemoe.sora.langs.less.LessLang;
import io.github.rosemoe.sora.langs.rust.RustLang;
import io.github.rosemoe.sora.langs.zig.ZigLanguage;
import io.github.rosemoe.sora.langs.lua.LuaLang;
import org.benf.cfr.reader.api.CfrDriver;
import org.benf.cfr.reader.api.OutputSinkFactory;
import java.io.File;
import java.util.HashMap;

import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.marco.FactoryCodeError;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.ThemeUtils;
import java.util.*;
import org.benf.cfr.reader.api.SinkReturns;

public class EditorFragment extends Fragment {

  private IdeEditor editor;
  private String filePath;
  private HashMap<String, Object> themeMap;
  private OnEditorListener editorListener;
  private ImageView iconAuthor;
  private ProgressBar proanjctor;
  private boolean isTextChanged = false;

  public interface OnEditorListener {
    void onEditorReady(EditorFragment fragment, IdeEditor editor);

    void onTextChanged(String path, boolean changed);

    void onErrorDetected(String error);
  }

  public static EditorFragment newInstance(String path, String themeJson) {
    EditorFragment fragment = new EditorFragment();
    Bundle args = new Bundle();
    args.putString("file_path", path);
    args.putString("theme_json", themeJson);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      filePath = getArguments().getString("file_path");
      String themeJson = getArguments().getString("theme_json");
      if (themeJson != null) {
        themeMap =
            new Gson().fromJson(themeJson, new TypeToken<HashMap<String, Object>>() {}.getType());
      }
    }
  }

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_editor, container, false);
    editor = view.findViewById(R.id.editor);
    iconAuthor = view.findViewById(R.id.iconAuthor);
    proanjctor = view.findViewById(R.id.proanjctor);
    setupEditor();
    return view;
  }

  private void setupEditor() {
    if (themeMap == null) {
      themeMap =
          new Gson()
              .fromJson(
                  ThemeUtils.themeAsString(),
                  new TypeToken<HashMap<String, Object>>() {}.getType());
    }

    // اعمال تم
    ThemeUtils themeForJson2 = new ThemeUtils();
    themeForJson2.setThemeCodeEditor(editor, themeMap, false, requireActivity());
    setupFont();
    editor.setKeyboardOperation(
        new IdeEditor.OnKeyboardOperation() {

          @Override
          public void Enter() {}

          @Override
          public void Removed() {}

          @Override
          public void Space() {}

          @Override
          public void Tab() {}
        });
    editor
        .getColorScheme()
        .setColor(EditorColorScheme.MATCHED_TEXT_BACKGROUND, Color.parseColor("#75800F31"));

    // لیسنر تغییرات متن
    editor.subscribeEvent(
        ContentChangeEvent.class,
        (event, subscribe) -> {
          isTextChanged = true;
          if (editorListener != null) {
            editorListener.onTextChanged(filePath, true);
          }

          // چک کردن خطا بعد از 3 ثانیه
          new android.os.Handler(android.os.Looper.getMainLooper())
              .postDelayed(
                  () -> {
                    FactoryCodeError errorChecker = new FactoryCodeError(editor, iconAuthor, null);
                    errorChecker.run();
                  },
                  3000);
        });

    if (editorListener != null) {
      editorListener.onEditorReady(this, editor);
    }
    RuningTask(filePath);
  }

  private void setupFont() {
    var setfont =
        requireActivity().getSharedPreferences("setfont", android.content.Context.MODE_PRIVATE);
    if (setfont.contains("mfont")) {
      String fontPath = setfont.getString("mfont", "");
      if (!FileUtil.isFile(fontPath)) {
        editor.setTypefaceText(
            Typeface.createFromAsset(requireActivity().getAssets(), "ghostfont.ttf"));
        editor.setTypefaceLineNumber(
            Typeface.createFromAsset(requireActivity().getAssets(), "ghostfont.ttf"));
      } else {
        editor.setTypefaceText(Typeface.createFromFile(new File(fontPath)));
        editor.setTypefaceLineNumber(Typeface.createFromFile(new File(fontPath)));
      }
    } else {
      editor.setTypefaceText(
          Typeface.createFromAsset(requireActivity().getAssets(), "ghostfont.ttf"));
      editor.setTypefaceLineNumber(
          Typeface.createFromAsset(requireActivity().getAssets(), "ghostfont.ttf"));
    }
  }

  public void saveFile() {
    if (filePath != null && editor != null) {
      String content = editor.getText().toString();
      FileUtil.writeFile(filePath, content);
      isTextChanged = false;
    }
  }

  public String getFilePath() {
    return filePath;
  }

  public IdeEditor getEditor() {
    return editor;
  }

  public boolean isTextChanged() {
    return isTextChanged;
  }

  public void setEditorListener(OnEditorListener listener) {
    this.editorListener = listener;
  }

  public void showProgress(boolean show) {
    if (proanjctor != null) {
      proanjctor.setVisibility(show ? View.VISIBLE : View.GONE);
    }
  }

  public void updateTheme(HashMap<String, Object> newTheme) {
    this.themeMap = newTheme;
    if (editor != null) {
      ThemeUtils themeForJson2 = new ThemeUtils();
      themeForJson2.setThemeCodeEditor(editor, themeMap, false, requireActivity());
    }
  }

  void RuningTask(String path) {

    if (path.endsWith(".css")) {
      // this html lexer using as html css3 js and sass and scass
      var CSS = new CSS3Language(editor);
      editor.setEditorLanguage(CSS);
      ReadFileCompat(path);

    } else if (path.endsWith(".py")) {
      editor.setEditorLanguage(new PythonLang(editor));
      ReadFileCompat(path);

    } else if (path.endsWith(".cpp")
        || path.endsWith(".cxx")
        || path.endsWith(".cc")
        || path.endsWith(".h")
        || path.endsWith(".hpp")) {
      editor.setEditorLanguage(new CppLanguage());

      ReadFileCompat(path);
    } else if (path.endsWith(".html")) {
      var htmllang = new HTMLLanguage(editor);
      editor.setEditorLanguage(htmllang);
      ReadFileCompat(path);

    } else if (path.endsWith(".js")) {
      editor.setEditorLanguage(new JavaScriptLanguage((CodeEditor) editor));
      ReadFileCompat(path);

    } else if (path.endsWith(".scss")) {
      ReadFileCompat(path);
      var it = new SassLangCompat();
      it.setSassMod(false);
      editor.setEditorLanguage(it);
    } else if (path.endsWith(".c")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new UniversalLanguage(new CDescription()));
    } else if (path.endsWith(".json")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new JsonLanguage((CodeEditor) editor));

    } else if (path.endsWith(".java")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new JavaLanguage(editor));

    } else if (path.endsWith(".cs")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new CSharpLanguage());

    } else if (path.endsWith(".xml")) {
      ReadFileCompat(path);
      XMLLanguage xmlLanguage = new XMLLanguage();
      xmlLanguage.setSyntaxCheckEnable(true);
      editor.setEditorLanguage(xmlLanguage);

    } else if (path.endsWith(".ghost")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new ghostlangs());
    } else if (path.endsWith(".ninja")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new NinjaLang());

    } else if (path.endsWith(".sh")) {
      ReadFileCompat(path);

      editor.setEditorLanguage(new UniversalLanguage(new ShellDescription()));
    } else if (path.endsWith(".svg")) {
      ReadFileCompat(path);

      var htmllang = new SvgLang(editor);
      editor.setEditorLanguage(htmllang);
    } else if (path.endsWith(".md")) {
      ReadFileCompat(path);

      editor.setEditorLanguage(new MarkDownLang());
    } else if (path.endsWith(".php")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new PHPLanguage(editor));

    } else if (path.endsWith(".go")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new UniversalLanguage(new GoDescription()));
    } else if (path.endsWith(".txt")) {
      ReadFileCompat(path);
    } else if (path.endsWith(".swift")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new UniversalLanguage(new SwiftDescription()));
    } else if (path.endsWith(".rb") || path.endsWith(".rbw")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new UniversalLanguage(new RubyDescription()));
    } else if (path.endsWith(".dart")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new DartLang());
    } else if (path.endsWith(".kt")) {
      ReadFileCompat(path);

      editor.setEditorLanguage(new KotlinLanguage());
    } else if (path.endsWith(".groovy") || path.endsWith(".gradle")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new GroovyLanguage());
    } else if (path.endsWith(".smali")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new SMLang());
    } else if (path.endsWith(".g4")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new ANTLRV4Lang());

    } else if (path.endsWith(".ts") || path.endsWith(".tsx")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new TsLang(editor));
    } else if (path.endsWith(".properties")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new Propertieslangs());
    } else if (path.endsWith(".sql")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new MySqlLang());
    } else if (path.endsWith(".jj")) {

      ReadFileCompat(path);
      editor.setEditorLanguage(new JavaccLang(editor));

    } else if (path.endsWith(".frag")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new GLSLLang());

    } else if (path.endsWith(".sass")) {
      var scssLang = new SassLangCompat();
      scssLang.setSassMod(true);
      editor.setEditorLanguage(scssLang);

      ReadFileCompat(path);
    } else if (path.endsWith(".class")) {
      editor.setEditorLanguage(new JavaLanguage(editor));

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
      ReadFileCompat(path);
      editor.setEditorLanguage(new YmlLang());

    } else if (path.endsWith(".jsx") || path.endsWith(".tsx")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new JavaScriptJsxLanguage());

    } else if (path.endsWith(".less")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new LessLang((CodeEditor) editor));
    } else if (path.endsWith(".rs")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new RustLang(editor));
    } else if (path.endsWith(".zig")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new ZigLanguage(editor));
    } else if (path.endsWith(".lua")) {
      ReadFileCompat(path);
      editor.setEditorLanguage(new LuaLang());
    } else {
      ReadFileCompat(path);
    }
  }

  protected void ReadFileCompat(String path) {
    try {
      editor.setText(FileUtil.readFile(path));
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
