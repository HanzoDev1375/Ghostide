package ir.ninjacoder.ghostide.core.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.ThreadUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.benf.cfr.reader.api.CfrDriver;
import org.benf.cfr.reader.api.OutputSinkFactory;
import org.benf.cfr.reader.api.SinkReturns;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.rosemoe.sora.event.ContentChangeEvent;
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
import io.github.rosemoe.sora.langs.Javacc.JavaccLang;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;

import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.ThemeUtils;

public class EditorFragment extends Fragment {

    private IdeEditor editor;
    private String filePath;
    private HashMap<String, Object> themeMap;
    private OnEditorListener editorListener;
    private ImageView iconAuthor;
    private ProgressBar proanjctor;
    private boolean isTextChanged = false;

    private SharedPreferences svePref, setfont;
    private boolean isAutoSaveEnabled = false;

    // Listener جدید برای تنظیمات UI مثل StickyScroll و MiniMap
    private SharedPreferences.OnSharedPreferenceChangeListener uiPrefListener;

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
                themeMap = new Gson().fromJson(themeJson, new TypeToken<
                                HashMap<String, Object>>() {}.getType());
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
                    ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editor, container, false);
        editor = view.findViewById(R.id.editor);
        iconAuthor = view.findViewById(R.id.iconAuthor);
        proanjctor = view.findViewById(R.id.proanjctor);
        setupEditor();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupInstantAutoSave();
    }

    private void setupInstantAutoSave() {
        if (getActivity() == null) return;

        svePref = getActivity().getSharedPreferences("sve", Context.MODE_PRIVATE);
        setfont = getActivity().getSharedPreferences("setfont", Context.MODE_PRIVATE);

        isAutoSaveEnabled = svePref.getString("getAutoSave", "").equals("true");
        svePref.registerOnSharedPreferenceChangeListener(autoSavePrefListener);

        // اعمال تنظیمات اولیه UI
        applyUiSettings();

        // گوش دادن به تغییرات تنظیمات مربوط به UI
        uiPrefListener = (sharedPreferences, key) -> {
            if ("seek".equals(key) || "minimap".equals(key)) {
                applyUiSettings();
            }
        };
        setfont.registerOnSharedPreferenceChangeListener(uiPrefListener);
    }

    /** اعمال تنظیمات StickyScroll و MiniMap به ادیتور */
    private void applyUiSettings() {
        if (editor == null) return;

        boolean stickyEnabled = setfont.getBoolean("seek", false);
        boolean miniMapEnabled = setfont.getBoolean("minimap", false);

        editor.setStickyScrollEnabled(stickyEnabled);
        editor.setMiniMapEnabled(miniMapEnabled);
    }

    private SharedPreferences.OnSharedPreferenceChangeListener autoSavePrefListener = (sp, key) -> {
        if (key.equals("getAutoSave")) {
            isAutoSaveEnabled = sp.getString("getAutoSave", "").equals("true");
        }
    };

    private void instantSaveIfEnabled() {
        if (isAutoSaveEnabled && filePath != null && editor != null) {
            String content = editor.getText().toString();
            FileUtil.writeFile(filePath, content);
        }
    }

    private void setupEditor() {
        if (themeMap == null) {
            themeMap = new Gson().fromJson(ThemeUtils.themeAsString(), new TypeToken<
                            HashMap<String, Object>>() {}.getType());
        }

        ThemeUtils themeForJson2 = new ThemeUtils();
        themeForJson2.setThemeCodeEditor(editor, themeMap, false, requireActivity());
        setupFont();

        editor.setKeyboardOperation(new IdeEditor.OnKeyboardOperation() {
            @Override
            public void Enter() {}

            @Override
            public void Removed() {}

            @Override
            public void Space() {}

            @Override
            public void Tab() {}
        });

        editor.getColorScheme().setColor(EditorColorScheme.MATCHED_TEXT_BACKGROUND, Color.parseColor("#75800F31"));

        if (filePath != null && !filePath.isEmpty()) {
            if (filePath.endsWith(".class")) {
                showProgress(true);
                ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<String>() {
                    @Override
                    public void onFail(Throwable arg0) {
                        super.onFail(arg0);
                        showProgress(false);
                        if (getActivity() != null) {
                            getActivity().runOnUiThread(() -> {
                                editor.setText("خطا در دیکامپایل: " + arg0.getMessage());
                            });
                        }
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        showProgress(false);
                        if (getActivity() != null) {
                            getActivity().runOnUiThread(() -> {
                                editor.setText(arg0);
                                editor.setEditorLanguage(new JavaLanguage(editor));
                            });
                        }
                    }

                    @Override
                    public String doInBackground() {
                        return decompileClass(new File(filePath));
                    }
                });
            } else {
                detectLanguage(filePath);
                loadFileContent(filePath);
            }
        }

        editor.subscribeEvent(ContentChangeEvent.class, (event, subscribe) -> {
            if (event.getAction() != ContentChangeEvent.ACTION_SET_NEW_TEXT) {
                if (!isTextChanged) {
                    isTextChanged = true;
                    if (editorListener != null) {
                        editorListener.onTextChanged(filePath, true);
                    }
                }
                instantSaveIfEnabled();
            }
        });

        editor.setPinLineNumber(true);
        editor.setDividerMargin(3.9f);

        if (editorListener != null) {
            editorListener.onEditorReady(this, editor);
        }
    }

    private void setupFont() {
        var setfont = requireActivity().getSharedPreferences("setfont", android.content.Context.MODE_PRIVATE);
        if (setfont.contains("mfont")) {
            String fontPath = setfont.getString("mfont", "");
            if (!FileUtil.isFile(fontPath)) {
                editor.setTypefaceText(Typeface.createFromAsset(requireActivity().getAssets(), "ghostfont.ttf"));
                editor.setTypefaceLineNumber(Typeface.createFromAsset(requireActivity().getAssets(), "ghostfont.ttf"));
            } else {
                editor.setTypefaceText(Typeface.createFromFile(new File(fontPath)));
                editor.setTypefaceLineNumber(Typeface.createFromFile(new File(fontPath)));
            }
        } else {
            editor.setTypefaceText(Typeface.createFromAsset(requireActivity().getAssets(), "ghostfont.ttf"));
            editor.setTypefaceLineNumber(Typeface.createFromAsset(requireActivity().getAssets(), "ghostfont.ttf"));
        }
        if (setfont.contains("fontsize")) {
            editor.setTextSize(setfont.getFloat("fontsize", 16));
        }
    }

    private void detectLanguage(String path) {
        if (path.endsWith(".css")) {
            editor.setEditorLanguage(new CSS3Language(editor));
        } else if (path.endsWith(".py")) {
            editor.setEditorLanguage(new PythonLang(editor));
        } else if (path.endsWith(".cpp") || path.endsWith(".cxx") || path.endsWith(".cc") || path.endsWith(".c++") || path.endsWith(".h") || path.endsWith(".hpp") || path.endsWith(".hxx") || path.endsWith(".hh") || path.endsWith(".inl") || path.endsWith(".tcc") || path.endsWith(".ipp")) {
            editor.setEditorLanguage(new CppLanguage());
        } else if (path.endsWith(".html") || path.endsWith(".htm") || path.endsWith(".xhtml") || path.endsWith(".shtml") || path.endsWith(".shtm")) {
            editor.setEditorLanguage(new HTMLLanguage(editor));
        } else if (path.endsWith(".js")) {
            editor.setEditorLanguage(new JavaScriptLanguage((CodeEditor) editor));
        } else if (path.endsWith(".scss")) {
            var it = new SassLangCompat();
            it.setSassMod(false);
            editor.setEditorLanguage(it);
        } else if (path.endsWith(".c")) {
            editor.setEditorLanguage(new UniversalLanguage(new CDescription()));
        } else if (path.endsWith(".json")) {
            editor.setEditorLanguage(new JsonLanguage((CodeEditor) editor));
        } else if (path.endsWith(".java")) {
            editor.setEditorLanguage(new JavaLanguage(editor));
        } else if (path.endsWith(".cs")) {
            editor.setEditorLanguage(new CSharpLanguage());
        } else if (path.endsWith(".xml")) {
            XMLLanguage xmlLanguage = new XMLLanguage();
            xmlLanguage.setSyntaxCheckEnable(true);
            editor.setEditorLanguage(xmlLanguage);
        } else if (path.endsWith(".ghost")) {
            editor.setEditorLanguage(new ghostlangs());
        } else if (path.endsWith(".ninja")) {
            editor.setEditorLanguage(new NinjaLang());
        } else if (path.endsWith(".sh")) {
            editor.setEditorLanguage(new UniversalLanguage(new ShellDescription()));
        } else if (path.endsWith(".svg")) {
            editor.setEditorLanguage(new SvgLang(editor));
        } else if (path.endsWith(".md")) {
            editor.setEditorLanguage(new MarkDownLang());
        } else if (path.endsWith(".php")) {
            editor.setEditorLanguage(new PHPLanguage(editor));
        } else if (path.endsWith(".go")) {
            editor.setEditorLanguage(new UniversalLanguage(new GoDescription()));
        } else if (path.endsWith(".swift")) {
            editor.setEditorLanguage(new UniversalLanguage(new SwiftDescription()));
        } else if (path.endsWith(".rb") || path.endsWith(".rbw")) {
            editor.setEditorLanguage(new UniversalLanguage(new RubyDescription()));
        } else if (path.endsWith(".dart")) {
            editor.setEditorLanguage(new DartLang());
        } else if (path.endsWith(".kt")) {
            editor.setEditorLanguage(new KotlinLanguage());
        } else if (path.endsWith(".groovy") || path.endsWith(".gradle")) {
            editor.setEditorLanguage(new GroovyLanguage());
        } else if (path.endsWith(".smali")) {
            editor.setEditorLanguage(new SMLang());
        } else if (path.endsWith(".g4")) {
            editor.setEditorLanguage(new ANTLRV4Lang());
        } else if (path.endsWith(".ts") || path.endsWith(".tsx")) {
            editor.setEditorLanguage(new TsLang(editor));
        } else if (path.endsWith(".properties")) {
            editor.setEditorLanguage(new Propertieslangs());
        } else if (path.endsWith(".sql")) {
            editor.setEditorLanguage(new MySqlLang());
        } else if (path.endsWith(".jj")) {
            editor.setEditorLanguage(new JavaccLang(editor));
        } else if (path.endsWith(".frag")) {
            editor.setEditorLanguage(new GLSLLang());
        } else if (path.endsWith(".sass")) {
            var scssLang = new SassLangCompat();
            scssLang.setSassMod(true);
            editor.setEditorLanguage(scssLang);
        } else if (path.endsWith(".yml")) {
            editor.setEditorLanguage(new YmlLang());
        } else if (path.endsWith(".jsx") || path.endsWith(".tsx")) {
            editor.setEditorLanguage(new JavaScriptJsxLanguage());
        } else if (path.endsWith(".less")) {
            editor.setEditorLanguage(new LessLang((CodeEditor) editor));
        } else if (path.endsWith(".rs")) {
            editor.setEditorLanguage(new RustLang(editor));
        } else if (path.endsWith(".zig")) {
            editor.setEditorLanguage(new ZigLanguage(editor));
        } else if (path.endsWith(".lua")) {
            editor.setEditorLanguage(new LuaLang());
        }
    }

    private void loadFileContent(String path) {
        try {
            String content = FileUtil.readFile(path);
            editor.setText(content);
        } catch (Throwable e) {
            editor.setText("خطا در خواندن فایل: " + e.toString());
        }
    }

    public void saveFile() {
        if (filePath != null && editor != null) {
            String content = editor.getText().toString();
            FileUtil.writeFile(filePath, content);
            isTextChanged = false;
        }
    }

    public void saveFileIfNeeded() {
        if (isTextChanged && filePath != null && editor != null) {
            String content = editor.getText().toString();
            FileUtil.writeFile(filePath, content);
            isTextChanged = false;
        }
    }

    @Nullable
    public String getFilePath() {
        return filePath;
    }

    @NonNull
    public IdeEditor getEditor() {
        return editor;
    }

    @NonNull
    public ImageView geticonAuthor() {
        return iconAuthor;
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

    private static String decompileClass(File classFile) {
        final StringBuilder result = new StringBuilder();

        if (!classFile.exists()) {
            return "فایل یافت نشد!";
        }

        try {
            CfrDriver driver = new CfrDriver.Builder()
                    .withOutputSink(new OutputSinkFactory() {
                        @Override
                        public List<SinkClass> getSupportedSinks(SinkType sinkType, Collection<
                                        SinkClass> collection) {
                            return Collections.singletonList(SinkClass.DECOMPILED);
                        }

                        @Override
                        public <T> Sink<T> getSink(SinkType sinkType, SinkClass sinkClass) {
                            return value -> {
                                if (value instanceof SinkReturns.Decompiled) {
                                    String code = ((SinkReturns.Decompiled) value).getJava();
                                    result.append(code).append("\n");
                                }
                            };
                        }
                    })
                    .withOptions(Map.of(
                            "showversion", "false",
                            "comments", "false",
                            "decodefinally", "true"))
                    .build();

            driver.analyse(Collections.singletonList(classFile.getAbsolutePath()));
            return result.toString().replace("Decompiled with CFR", "").replaceAll("\\*\\s+\\.", "");

        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (svePref != null) {
            svePref.unregisterOnSharedPreferenceChangeListener(autoSavePrefListener);
        }
        // حذف Listener جدید برای جلوگیری از نشت حافظه
        if (setfont != null && uiPrefListener != null) {
            setfont.unregisterOnSharedPreferenceChangeListener(uiPrefListener);
        }
    }
}