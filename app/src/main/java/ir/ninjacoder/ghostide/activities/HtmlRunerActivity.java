package ir.ninjacoder.ghostide.activities;

import android.transition.Explode;
import com.google.common.reflect.TypeToken;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.ServerHost;
import ir.ninjacoder.ghostide.databinding.HtmlrunerBinding;
import ir.ninjacoder.ghostide.enums.ErudaThemeManager;
import ir.ninjacoder.ghostide.enums.ErudaThemes;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.utils.FileUtil;
import ir.ninjacoder.ghostide.utils.ThemeUtils;
import ir.ninjacoder.ghostide.widget.GhostWebMaterialDialog;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.*;
import android.webkit.*;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.webkit.WebSettingsCompat;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.Gson;
import io.github.rosemoe.sora.langs.loglang.LogLang;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HtmlRunerActivity extends BaseCompat {
  protected ArrayList<HashMap<String, Object>> listLogJs = new ArrayList<>();
  protected ServerHost host;
  private boolean boolean10 = false;
  private String param = "";
  private String Doc = "";
  private String Doc2 = "";
  private SharedPreferences qo;
  private Intent send = new Intent();
  private boolean isInspectEnabled = false;
  private boolean isShowingDialog = false;
  private SharedPreferences saveThemeEruda;
  private ErudaThemes theme;
  protected HtmlrunerBinding bin;
  private String js;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    getWindow().setAllowEnterTransitionOverlap(true);
    getWindow().setExitTransition(new Explode());
    getWindow().setEnterTransition(new Explode());
    getWindow().setReenterTransition(new Explode());
    super.onCreate(savedInstanceState);
    bin = HtmlrunerBinding.inflate(getLayoutInflater());
    setContentView(bin.getRoot());
    findAndMatchIdInview();
    installToRun();
  }

  private void findAndMatchIdInview() {

    setSupportActionBar(bin.Toolbar);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    bin.Toolbar.setNavigationOnClickListener(
        (v) -> {
          finish();
        });
    qo = getSharedPreferences("qo", Activity.MODE_PRIVATE);
    databind();
    saveThemeEruda = getSharedPreferences("it", MODE_PRIVATE);
    theme = getThemes();
    reloadConsoleJs();

    bin.web.setWebChromeClient(
        new WebChromeClient() {
          @Override
          public void onProgressChanged(WebView view, int progresss) {
            bin.progressbar1.setVisibility(progresss == 100 ? View.GONE : View.VISIBLE);
            bin.progressbar1.setProgressCompat(progresss, true);
          }

          @Override
          public boolean onJsTimeout() {
            return super.onJsTimeout();
          }

          @Override
          public boolean onJsBeforeUnload(
              WebView arg0, String arg1, String arg2, JsResult jsresult) {
            var dialog = new MaterialAlertDialogBuilder(HtmlRunerActivity.this);
            dialog.setTitle("Exit");
            dialog.setMessage("Confrim to exit ?");
            dialog.setPositiveButton(
                android.R.string.ok,
                (c, cs) -> {
                  jsresult.confirm();
                });
            dialog.setNegativeButton(
                android.R.string.cancel,
                (_gg, r) -> {
                  jsresult.cancel();
                });
            dialog.show();
            return true;
          }

          @Override
          public void onCloseWindow(WebView arg0) {
            super.onCloseWindow(arg0);
          }
        });
    bin.web.setWebViewClient(
        new WebViewClient() {
          @Override
          public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
            final String _url = _param2;

            super.onPageStarted(_param1, _param2, _param3);
          }

          @Override
          public void onPageFinished(WebView _param1, String _param2) {
            final String _url = _param2;
            reloadConsoleJs();
            setTitle(bin.web.getTitle() == "about:blank" ? "Error" : bin.web.getTitle());

            getSupportActionBar()
                .setSubtitle(bin.web.getUrl() == "about:blank" ? "Preview" : bin.web.getUrl());
            if (isInspectEnabled) {
              startInspectMode(bin.web);
            }
            bin.progressbar1.setVisibility(View.GONE);
            bin.web.addJavascriptInterface(
                new Object() {

                  @JavascriptInterface
                  public void setInspectEnabled(boolean enabled) {
                    isInspectEnabled = enabled;
                    runOnUiThread(
                        new Runnable() {
                          @Override
                          public void run() {
                            if (enabled) {
                              startInspectMode(bin.web);
                            }
                          }
                        });
                  }

                  @JavascriptInterface
                  public void onElementClicked(String html) {

                    runOnUiThread(
                        new Runnable() {
                          @Override
                          public void run() {
                            if (!isShowingDialog) {
                              isShowingDialog = true;
                              MaterialAlertDialogBuilder dialog =
                                  new MaterialAlertDialogBuilder(HtmlRunerActivity.this);
                              dialog.setTitle("inspect");
                              // dialog.setMessage(html);
                              var tvs = new TextView(HtmlRunerActivity.this);
                              LinearLayout.LayoutParams layout =
                                  new LinearLayout.LayoutParams(
                                      LinearLayout.LayoutParams.MATCH_PARENT,
                                      LinearLayout.LayoutParams.MATCH_PARENT);
                              layout.leftMargin = 3;
                              layout.rightMargin = 3;
                              // tvs.setGravity(Gravity.CENTER_HORIZONTAL |
                              // Gravity.CENTER_HORIZONTAL);
                              tvs.setLayoutParams(layout);
                              tvs.setTextIsSelectable(true);
                              tvs.setText(html);
                              tvs.setTextColor(
                                  ColorStateList.valueOf(
                                      MaterialColors.getColor(tvs, ObjectUtils.TvColor, 0)));
                              tvs.setPadding(8, 8, 8, 8);
                              dialog.setCancelable(false);
                              dialog.setView(tvs);
                              dialog.setPositiveButton(
                                  android.R.string.ok,
                                  new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                      isShowingDialog = false;
                                    }
                                  });
                              dialog.show();
                            }
                          }
                        });
                  }
                },
                "android");
            super.onPageFinished(_param1, _param2);
          }
        });

    bin.Toolbar.setOverflowIcon(getDrawable(R.drawable.border_color));
    bin.Fab.setIconResource(R.drawable.cog);

    bin.Fab.setOnClickListener(
        vv -> {
          var di = new MaterialAlertDialogBuilder(HtmlRunerActivity.this);

          di.setTitle("Choose your appreciable");
          di.setMessage("Please select one of the following options");
          di.setPositiveButton(
              "Search",
              (p1, d2) -> {
                _searchData();
              });
          di.setNeutralButton(
              "host",
              (p, d) -> {
                hosts();
              });
          AlertDialog dialog = di.show();
          final View view = dialog.getWindow().getDecorView();
          view.setScaleX(0f);
          view.setScaleY(0f);
          dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
          final ObjectAnimator alertAnim = new ObjectAnimator();
          final ObjectAnimator alertAnim1 = new ObjectAnimator();
          alertAnim.setTarget(view);
          alertAnim.setPropertyName("scaleX");
          alertAnim.setFloatValues((float) (1));
          alertAnim.setDuration((250));
          alertAnim.start();
          alertAnim1.setTarget(view);
          alertAnim1.setPropertyName("scaleY");
          alertAnim1.setFloatValues((float) (1));
          alertAnim1.setDuration((250));
          alertAnim1.start();
          dialog.show();
        });
  }

  private void installToRun() {
    //   bin.web.setCustomDialog();
    bin.Toolbar.setNavigationIcon(R.drawable.arrow_back);
    initWebView();
    ObjectUtils.setToolbarinit(bin.Toolbar);
    if (getIntent().hasExtra("run")) {
      bin.web.loadUrl("file:///".concat(getIntent().getStringExtra("run")));
    }
  }

  void hosts() {
    String path = getIntent().getStringExtra("run");
    host =
        new ServerHost(
            8080,
            (String) path.subSequence(0, path.lastIndexOf("/")),
            path.substring(path.lastIndexOf("/") + 1));
    host.startServer();
    String initialUrl = host.getLocalIpAddress();
    Intent openInBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse(initialUrl));
    startActivity(openInBrowser);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.webview_menu, menu);

    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    menu.findItem(R.id.drakmod).setVisible(Build.VERSION.SDK_INT >= 29 ? true : false);
    return super.onPrepareOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.back) {
      if (bin.web.canGoBack()) {
        bin.web.goBack();
      } else {
        Toasts("Can't go back...");
      }
    } else if (id == R.id.forward) {
      if (bin.web.canGoForward()) {
        bin.web.goForward();
      } else {
        Toasts("Can't go Forward");
      }
    } else if (id == R.id.zooming) {
      bin.web.getSettings().setSupportZoom(!item.isChecked());
      bin.web.getSettings().setBuiltInZoomControls(!item.isChecked());
      item.setChecked(!item.isChecked());
    } else if (id == R.id.desktop_mode) {
      setDesktopMode(!item.isChecked());
      item.setChecked(!item.isChecked());
    } else if (id == R.id.refresh) {
      bin.web.reload();
    } else if (id == R.id.reloader) {
      reloadConsoleJs();
    } else if (id == R.id.drakmod) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        bin.web.getSettings().setAlgorithmicDarkeningAllowed(!item.isChecked());
      }
      item.setChecked(!item.isChecked());
      WebSettingsCompat.setForceDark(
          bin.web.getSettings(),
          item.isChecked() ? WebSettingsCompat.FORCE_DARK_ON : WebSettingsCompat.FORCE_DARK_OFF);
    } else if (id == R.id.exits) {
      finish();
    } else if (id == R.id.injector) {
      bin.web.reload();
      if (!item.isChecked()) {
        isInspectEnabled = true;
      } else {
        isInspectEnabled = false;
      }
      item.setChecked(!item.isChecked());
    } else if (id == R.id.consolefromsheet) {
      JsConsoleBeta();
    }
    return true;
  }

  private void Toasts(String t) {

    Toast toast = Toast.makeText(getApplicationContext(), t, 2);
    toast.setDuration(Toast.LENGTH_SHORT);
    toast.setGravity(Gravity.BOTTOM, Gravity.CENTER_HORIZONTAL, Gravity.BOTTOM);
    toast.show();
  }

  public void setDesktopMode(boolean _isChecked) {
    bin.web.loadUrl(
        "javascript:!function(e){var t,n,o;window.innerWidth>=window.innerHeight||(t=1024/innerWidth,(n=document.querySelector(\"meta[name=viewport]\"))||((n=document.createElement(\"meta\")).name=\"viewport\",document.head.appenChild(n)),e?(o=window.innerHeight*t,sessionStorage.setItem(\"__old_viewport_content\",n.content),n.content=\"width=1024, height=\"+o):(o=sessionStorage.__old_viewport_content)&&(n.content=o))}("
            + _isChecked
            + ");");
    var webSettings = bin.web.getSettings();
    webSettings.setUseWideViewPort(_isChecked);
    webSettings.setLoadWithOverviewMode(_isChecked);
    webSettings.setSupportZoom(_isChecked);
    webSettings.setBuiltInZoomControls(_isChecked);
  }

   void _searchData() {
    AlertDialog dialog =
        new GhostWebMaterialDialog(HtmlRunerActivity.this)
            .setView(R.layout.webview_search)
            .setTitle("Search KeyWord")
            .setCancelable(false)
            .setPositiveButton("Search Text", null)
            .setNegativeButton(android.R.string.cancel, null)
            .create();
    dialog.setOnShowListener(
        (var) -> {
          Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

          EditText editor = dialog.findViewById(R.id.editor);
          if (editor.getText().toString().isEmpty()) {
            positive.setEnabled(false);
          } else {
            positive.setEnabled(true);
          }

          editor.addTextChangedListener(
              new TextWatcher() {
                @Override
                public void onTextChanged(
                    CharSequence _param1, int _param2, int _param3, int _param4) {
                  final String _charSeq = _param1.toString();

                  if (editor.getText().toString().isEmpty()) {
                    positive.setEnabled(false);
                  } else {
                    positive.setEnabled(true);
                  }
                }

                @Override
                public void beforeTextChanged(
                    CharSequence _param1, int _param2, int _param3, int _param4) {}

                @Override
                public void afterTextChanged(android.text.Editable _param1) {}
              });
          positive.setOnClickListener(
              (vftrororocjj) -> {
                bin.web.findAll(editor.getText().toString());
                if (editor.getText().toString().isEmpty()) {
                  positive.setEnabled(false);
                } else {
                  positive.setEnabled(true);
                }
                dialog.dismiss();
              });
        });
    final View view = dialog.getWindow().getDecorView();
    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    view.setScaleX(0f);
    view.setScaleY(0f);
    final ObjectAnimator alertAnim = new ObjectAnimator();
    final ObjectAnimator alertAnim1 = new ObjectAnimator();
    alertAnim.setTarget(view);
    alertAnim.setPropertyName("scaleX");
    alertAnim.setFloatValues((float) (1));
    alertAnim.setDuration((250));
    alertAnim.start();
    alertAnim1.setTarget(view);
    alertAnim1.setPropertyName("scaleY");
    alertAnim1.setFloatValues((float) (1));
    alertAnim1.setDuration(250);
    alertAnim1.start();
    dialog.show();
  }

  public void showMessage(String _s) {
    Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
  }

  void reloadConsoleJs() {
    String erudaPath = "file:///android_asset/eruda.js";
    ErudaThemes theme = ErudaThemeManager.getCurrentTheme(this);
    Map<String, String> mapcolor =
        new Gson()
            .fromJson(
                FileUtil.readFile("/storage/emulated/0/GhostWebIDE/theme/erudatheme.json"),
                new TypeToken<Map<String, String>>() {}.getType());
    boolean isThemeFile =
        FileUtil.isExistFile("/storage/emulated/0/GhostWebIDE/theme/erudatheme.json");
    if (theme == ErudaThemes.GHOST) {
      if (isThemeFile)
        js =
            "(function(){"
                + "var script = document.createElement('script');"
                + "script.src = '"
                + erudaPath
                + "';"
                + "document.body.appendChild(script);"
                + "eruda.init({"
                + "    defaults: {"
                + "        displaySize: 77,"
                + "        transparency: 1,"
                + "    }"
                + "});"
                + "eruda.util.evalCss.setTheme({"
                + "    consoleWarnBackground: '"
                + mapcolor.get("erudaconsoleWarnBackground")
                + "',"
                + "    consoleWarnForeground: '"
                + mapcolor.get("erudaconsoleWarnForeground")
                + "',"
                + "    consoleWarnBorder: '"
                + mapcolor.get("erudaconsoleWarnBorder")
                + "',"
                + "    consoleErrorBackground: '"
                + mapcolor.get("erudaconsoleErrorBackground")
                + "',"
                + "    consoleErrorForeground: '"
                + mapcolor.get("erudaconsoleErrorForeground")
                + "',"
                + "    consoleErrorBorder: '"
                + mapcolor.get("erudaconsoleErrorBorder")
                + "',"
                + "    light: '"
                + mapcolor.get("erudalight")
                + "',"
                + "    dark: '"
                + mapcolor.get("erudadark")
                + "',"
                + "    darkerBackground: '"
                + mapcolor.get("erudadarkerBackground")
                + "',"
                + "    background: '"
                + mapcolor.get("erudabackground")
                + "',"
                + "    foreground: '"
                + mapcolor.get("erudaforeground")
                + "',"
                + "    selectForeground: '"
                + mapcolor.get("erudaselectForeground")
                + "',"
                + "    accent: '"
                + mapcolor.get("erudaaccent")
                + "',"
                + "    highlight: '"
                + mapcolor.get("erudahighlight")
                + "',"
                + "    border: '"
                + mapcolor.get("erudaborder")
                + "',"
                + "    primary: '"
                + mapcolor.get("erudaprimary")
                + "',"
                + "    contrast: '"
                + mapcolor.get("erudacontrast")
                + "',"
                + "    varColor: '"
                + mapcolor.get("erudavarColor")
                + "',"
                + "    stringColor: '"
                + mapcolor.get("erudastringColor")
                + "',"
                + "    keywordColor: '"
                + mapcolor.get("erudakeywordColor")
                + "',"
                + "    numberColor: '"
                + mapcolor.get("erudanumberColor")
                + "',"
                + "    operatorColor: '"
                + mapcolor.get("erudaoperatorColor")
                + "',"
                + "    linkColor: '"
                + mapcolor.get("erudalinkColor")
                + "',"
                + "    textColor: '"
                + mapcolor.get("erudatextColor")
                + "',"
                + "    tagNameColor: '"
                + mapcolor.get("erudatagNameColor")
                + "',"
                + "    functionColor: '"
                + mapcolor.get("erudafunctionColor")
                + "',"
                + "    attributeNameColor: '"
                + mapcolor.get("erudaattributeNameColor")
                + "',"
                + "    commentColor: '"
                + mapcolor.get("erudacommentColor")
                + "',"
                + "    cssProperty: '"
                + mapcolor.get("erudacssProperty")
                + "'"
                + "});"
                + "})();";
    } else if (theme == ErudaThemes.MATERIALTHEMES) {
      js = ObjectUtils.loadErudaMaterial3(bin.web);
    } else {
      js =
          "(function(){"
              + "var script = document.createElement('script');"
              + "script.src = '"
              + erudaPath
              + "';"
              + "document.body.appendChild(script);"
              + "eruda.init({"
              + "    defaults: {"
              + "        displaySize: 77,"
              + "        transparency: 1,"
              + "        theme: '"
              + theme.getThemeName()
              + "'"
              + "    }"
              + "});"
              + "})();";
    }

    bin.web.post(() -> bin.web.loadUrl("javascript:" + js));
  }

  public void initWebView() {
    bin.web.getSettings().setAllowContentAccess(true);
    bin.web.getSettings().setAllowFileAccess(true);
    bin.web.getSettings().setJavaScriptEnabled(true);
    bin.web.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    bin.web.getSettings().setSupportZoom(true);
    //    bin.web.getSettings().setBuiltInZoomControls(true);
  }

  public void startInspectMode(WebView _webview) {
    _webview.loadUrl(
        "javascript:(function() { "
            + "function addClickListener(element) {"
            + "    element.addEventListener('click', function() {"
            + "        window.android.onElementClicked(element.outerHTML);"
            + "    });"
            + "}"
            + "let elements = document.getElementsByTagName('*');"
            + "for (let i = 0; i < elements.length; i++) {"
            + "    addClickListener(elements[i]);"
            + "}"
            + "})();");
  }

  public void JsConsoleBeta() {
    BottomSheetDialog sheet = new BottomSheetDialog(this);
    var view = LayoutInflater.from(this).inflate(R.layout.z_layout_rv, null, false);
    CodeEditor editor = view.findViewById(R.id.rv_layout);
    HashMap<String, Object> imap = new HashMap<>();
    imap =
        new Gson()
            .fromJson(
                FileUtil.readFile("storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost"),
                new TypeToken<HashMap<String, Object>>() {}.getType());
    ThemeUtils themeForJson2 = new ThemeUtils();
    themeForJson2.setThemeCodeEditor(editor, imap, false, this);
    sheet.setContentView(view);
    sheet.show();
    bin.web.reload();
    try {
      bin.web.setWebChromeClient(
          new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {

              String str = "";
              String level = "";
              String src = consoleMessage.sourceId();

              switch (consoleMessage.messageLevel()) {
                case DEBUG:
                  level = "DEBUG";
                  break;
                case ERROR:
                  level = "ERROR";
                  break;
                case LOG:
                  level = "LOG";
                  break;
                case TIP:
                  level = "TIP";
                  break;
                case WARNING:
                  level = "WARNING";
                  break;
              }
              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
              String time = dtf.format(LocalDateTime.now());

              str += level + " -> " + consoleMessage.message() + "(" + time + ")" + "\n";

              editor.setSelection(
                  editor.getText().getLineCount() - 1,
                  editor.getText().getColumnCount(editor.getText().getLineCount() - 1));
              // editor.setColorScheme(new SchemeDarcula());
              editor.setLineNumberEnabled(false);
              editor.setEditable(false);
              editor.insertText(str, 1);
              editor.setPadding(8, 8, 8, 8);
              editor.setEditorLanguage(new LogLang());
              editor.setTypefaceText(Typeface.createFromAsset(getAssets(), "fonts/ghostfont.ttf"));
              return super.onConsoleMessage(consoleMessage);
            }
          });

    } catch (Exception err) {

    }
  }

  void databind() {
    if (Build.VERSION.SDK_INT >= 19) {
      bin.web.setLayerType(View.LAYER_TYPE_HARDWARE, null);
      bin.web.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
    }
    if (Build.VERSION.SDK_INT >= 17) {
      bin.web.getSettings().setMediaPlaybackRequiresUserGesture(false);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      bin.web.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
    }
  }

  @Override
  public boolean onKeyDown(int data, KeyEvent key) {
    if (key.isAltPressed() || key.isCtrlPressed()) {
      switch (data) {
        case KeyEvent.KEYCODE_H:
          hosts();
          return true;
        case KeyEvent.KEYCODE_S:
          _searchData();
          return true;
        case KeyEvent.KEYCODE_R:
          reloadConsoleJs();
          return true;
        case KeyEvent.KEYCODE_B:
          if (bin.web.canGoBack()) {
            bin.web.goBack();
          } else {
            Toasts("Can't go back...");
          }
          return true;
        case KeyEvent.KEYCODE_F:
          if (bin.web.canGoForward()) {
            bin.web.goForward();
          } else {
            Toasts("Can't go Forward");
          }
          return true;
      }
    }
    return super.onKeyDown(data, key);
  }

  private ErudaThemes getThemes() {
    return ErudaThemes.valueOf(saveThemeEruda.getString("it", ErudaThemes.DARK.name()));
  }
}
