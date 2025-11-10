package ir.ninjacoder.ghostide.core.activities;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mcal.uidesigner.XmlLayoutDesignActivity;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimerTask;

import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorAutoCompleteWindow;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.core.G4Compiler;
import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.JavaCcComplierImpl;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.activities.BaseCompat;
import ir.ninjacoder.ghostide.core.activities.HtmlRunerActivity;
import ir.ninjacoder.ghostide.core.activities.JsonViewerActivity;
import ir.ninjacoder.ghostide.core.activities.ShellCodeActivity;
import ir.ninjacoder.ghostide.core.adapter.SyspiarAdapter;
import ir.ninjacoder.ghostide.core.adapter.ToolbarListFileAdapter;
import ir.ninjacoder.ghostide.core.pl.PluginChildRegistry;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.KeySet;
import ir.ninjacoder.ghostide.core.utils.ThemeUtils;
import ir.ninjacoder.ghostide.core.databinding.Antcomp8lerBinding;
import ir.ninjacoder.ghostide.core.enums.CompilerModel;
import ir.ninjacoder.ghostide.core.enums.Mode;
import ir.ninjacoder.ghostide.core.layoutmanager.LogCatBottomSheet;
import ir.ninjacoder.ghostide.core.marco.CodeSnap;
import ir.ninjacoder.ghostide.core.marco.ColorView;
import ir.ninjacoder.ghostide.core.marco.FactoryCodeError;
import ir.ninjacoder.ghostide.core.marco.GhostWebEditorSearch;
import ir.ninjacoder.ghostide.core.marco.KotlinCompilerImpl;
import ir.ninjacoder.ghostide.core.marco.WallpaperParallaxEffect;
import ir.ninjacoder.ghostide.core.model.EditorViewModel;
import ir.ninjacoder.ghostide.core.navigator.EditorRoaderFile;
import ir.ninjacoder.ghostide.core.pl.PluginLoaderImpl;
import ir.ninjacoder.ghostide.core.project.JavaCompilerBeta;
import ir.ninjacoder.ghostide.core.project.ProjectManager;
import ir.ninjacoder.ghostide.core.tasks.FileChangeReceiver;
import ir.ninjacoder.ghostide.core.tasks.SecurePrefs;
import ir.ninjacoder.ghostide.core.tasks.app.SassForAndroid;
import ir.ninjacoder.ghostide.core.terminal.TerminalActivity;
import ir.ninjacoder.ghostide.core.utils.CompilerUtils;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import ir.ninjacoder.ghostide.core.widget.BlurImage;
import ir.ninjacoder.ghostide.core.widget.ExrtaFab;
import ir.ninjacoder.prograsssheet.VideoSurfaceView;
import ir.ninjacoder.prograsssheet.listchild.Child;

public class CodeEditorActivity extends BaseCompat {

  public final int REQ_CD_SETPASZAMINE = 101;
  protected EditorAutoCompleteWindow window;
  protected ExrtaFab _fab;
  private WallpaperParallaxEffect effect;
  private CoordinatorLayout Coordinator;
  private HashMap<String, Object> imap = new HashMap<>();
  private final String code = "";
  private ThemeUtils themeForJson2;
  private double itemPosRemoved = 0;
  private final String GetTab = "";
  private double ic = 1;
  private ArrayList<HashMap<String, Object>> tabs_listmap = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> staticSymbiolPiare = new ArrayList<>();
  private final ArrayList<String> string = new ArrayList<>();
  private final ArrayList<String> list = new ArrayList<>();
  private LinearLayout multytab;
  private FrameLayout FrameLayout01, editorparser;
  private LinearLayout newLayoutSymbolBar;
  private LinearLayout CustomToolbar;
  private ProgressBar progressbar1;
  private RecyclerView dir;
  private TextView titleauthor;
  private ImageView image, redo, undo, menupopnew, iconAuthor, codesnapimg;
  private LinearLayout FrameLayout02;
  private LinearLayout linear3, getColorPass;
  private ProgressBar proanjctor;
  private LinearLayout barSymoble;
  private ImageView imageview1, imageloadereditor, avatargithubuser;
  private RecyclerView syspiar;
  private final Intent intentaddFile = new Intent();
  private final Intent htmlrus = new Intent();
  private SharedPreferences word, line, shp, qo, savecursor;
  private AlertDialog.Builder myDialog;
  private final Intent res = new Intent();
  private TimerTask ask;
  private AlertDialog.Builder di;
  private final Intent jsonview = new Intent();
  private final Intent getmd = new Intent();
  private Vibrator vb;
  private SharedPreferences getvb;
  private final Intent further = new Intent();
  private SharedPreferences re;
  private SharedPreferences war;
  private SharedPreferences setfont;
  private SharedPreferences ru;
  private final ObjectAnimator objectAnim = new ObjectAnimator();
  private SharedPreferences tabimageview;
  private PowerMenu mmenucog;
  private PowerMenu mmenuitempos;
  private final Intent icon = new Intent();
  private PowerMenu pvr;
  private final Intent fontHelper = new Intent();
  private final Intent setPaszamine = new Intent(Intent.ACTION_GET_CONTENT);
  private SharedPreferences pss;
  private SharedPreferences sve;
  private TabLayout tablayouteditor;
  private SharedPreferences getinitdir;
  private SharedPreferences mthemepost;
  private ImageView ghostIcon;
  private SharedPreferences shSizePx;
  private PowerMenu jelper;
  private SharedPreferences t;
  private SharedPreferences thememanagersoft;
  private SharedPreferences sf;
  private GhostWebEditorSearch ghost_searchs;
  private int tabPos = -1;
  private EditorViewModel modelEditor;
  private String path;
  private boolean isSvg = false;
  private IdeEditor editor;
  private VideoSurfaceView mvideo;
  private boolean isFileChangeDialogShowing = false;
  private List<Child> listChild = new ArrayList<>();
  private String currentFileType = "";

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    getWindow().setAllowReturnTransitionOverlap(true);
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.codeeditor);
    initialize(_savedInstanceState);
    initializeLogic();
  }

  private void initialize(Bundle _savedInstanceState) {

    _fab = findViewById(R.id._fab);
    getColorPass = findViewById(R.id.getColorPass);
    Coordinator = findViewById(R.id.Coordinator);
    multytab = findViewById(R.id.multytab);
    FrameLayout01 = findViewById(R.id.FrameLayout01);
    newLayoutSymbolBar = findViewById(R.id.newLayoutSymbolBar);
    CustomToolbar = findViewById(R.id.CustomToolbar);
    progressbar1 = findViewById(R.id.progressbar1);
    dir = findViewById(R.id.dir);
    avatargithubuser = findViewById(R.id.avatargithubuser);
    titleauthor = findViewById(R.id.titleauthor);
    image = findViewById(R.id.image);
    redo = findViewById(R.id.redo);
    undo = findViewById(R.id.undo);
    codesnapimg = findViewById(R.id.codesnapimg);
    tablayouteditor = findViewById(R.id.tablayouteditor);
    menupopnew = findViewById(R.id.menupopnew);
    FrameLayout02 = findViewById(R.id.FrameLayout02);
    linear3 = findViewById(R.id.linear3);
    proanjctor = findViewById(R.id.proanjctor);
    barSymoble = findViewById(R.id.barSymoble);
    imageview1 = findViewById(R.id.imageview1);
    ghost_searchs = findViewById(R.id.editor_ser);
    ghost_searchs.hide();
    editor = findViewById(R.id.editor);
    syspiar = findViewById(R.id.syspiar);
    mvideo = findViewById(R.id.videoback);
    savecursor = getSharedPreferences("editor", MODE_PRIVATE);
    word = getSharedPreferences("word", MODE_PRIVATE);
    line = getSharedPreferences("line", MODE_PRIVATE);
    shp = getSharedPreferences("shp", MODE_PRIVATE);
    qo = getSharedPreferences("qo", MODE_PRIVATE);
    myDialog = new AlertDialog.Builder(this);
    di = new AlertDialog.Builder(this);
    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    getvb = getSharedPreferences("getvb", Activity.MODE_PRIVATE);
    re = getSharedPreferences("re", Activity.MODE_PRIVATE);
    war = getSharedPreferences("war", Activity.MODE_PRIVATE);
    setfont = getSharedPreferences("setfont", Activity.MODE_PRIVATE);

    ru = getSharedPreferences("ru", Activity.MODE_PRIVATE);
    tabimageview = getSharedPreferences("tabimageview", Activity.MODE_PRIVATE);
    setPaszamine.setType("image/*");
    setPaszamine.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
    pss = getSharedPreferences("pss", Activity.MODE_PRIVATE);
    sve = getSharedPreferences("sve", Activity.MODE_PRIVATE);
    getinitdir = getSharedPreferences("getinitdir", Activity.MODE_PRIVATE);
    mthemepost = getSharedPreferences("mthemepost", Activity.MODE_PRIVATE);
    shSizePx = getSharedPreferences("shSizePx", Activity.MODE_PRIVATE);
    t = getSharedPreferences("t", Activity.MODE_PRIVATE);
    thememanagersoft = getSharedPreferences("thememanagersoft", Activity.MODE_PRIVATE);
    sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
    iconAuthor = findViewById(R.id.iconAuthor);
    imageloadereditor = findViewById(R.id.imageloadereditor);
    modelEditor = new ViewModelProvider(this).get(EditorViewModel.class);
    themeForJson2 = new ThemeUtils();
    ghostIcon = findViewById(R.id.icon_backgroundghost);
    var mRootView = getWindow().getDecorView();
    syspiar.setVisibility(View.GONE);
    var userview = new SecurePrefs(this);
    Glide.with(this)
        .load(userview.getAvatarUrl())
        .circleCrop()
        .error(R.drawable.app_icon)
        .into(avatargithubuser);
    ghostIcon.animate().scaleX(1.0f).scaleY(1.0f).setDuration(1000).start();
    mRootView
        .getViewTreeObserver()
        .addOnGlobalLayoutListener(
            new ViewTreeObserver.OnGlobalLayoutListener() {
              @Override
              public void onGlobalLayout() {
                Rect r = new Rect();
                mRootView.getWindowVisibleDisplayFrame(r);
                int screenHeight = mRootView.getRootView().getHeight();
                int keypadHeight = screenHeight - r.bottom;

                final float scale = getResources().getDisplayMetrics().density;

                int shortAnimationDuration =
                    getResources().getInteger(android.R.integer.config_shortAnimTime);

                if (keypadHeight > screenHeight * 0.15) {
                  float minScale = 1.0f;
                  ghostIcon.animate().scaleX(minScale).scaleY(minScale).setDuration(1000).start();

                  ObjectUtils.showViewWithAnimation(syspiar);

                } else {
                  var max = 1.4f;
                  ghostIcon
                      .animate()
                      .scaleX(Math.max(max, 1))
                      .scaleY(Math.max(max, 1))
                      .setDuration(1000)
                      .start();

                  ObjectUtils.hideViewWithAnimation(syspiar, _fab);
                }
              }
            });

    ghost_searchs.bindEditor(editor);
    ghost_searchs.setCallBack(
        new GhostWebEditorSearch.onViewChange() {

          @Override
          public void onViewShow() {
            if (_fab.getVisibility() == View.VISIBLE) {
              _fab.hide();
            }
          }

          @Override
          public void onViewHide() {
            if (_fab.getVisibility() == View.GONE) {
              _fab.show();
            }
          }
        });

    image.setOnClickListener(
        (it) -> {
          if (ic == 1) {
            image.setImageResource(R.drawable.noeye);
            editor.setEditable(false);
            ic--;
          } else {
            editor.setEditable(true);
            image.setImageResource(R.drawable.okeye);
            ic++;
          }
        });
    getOnBackPressedDispatcher()
        .addCallback(
            this,
            new OnBackPressedCallback(true) {

              @Override
              public void handleOnBackPressed() {
                ObjectUtils.setSaveOprator(
                    tabs_listmap, editor, tablayouteditor, CodeEditorActivity.this);
              }
            });
    redo.setOnClickListener(
        (v) -> {
          editor.AutoRedo();
        });

    undo.setOnClickListener(
        (it) -> {
          editor.AutoUndo();
        });

    menupopnew.setOnClickListener(
        (___) -> {
          setManagerpanel(menupopnew);
        });

    imageview1.setOnClickListener(
        (it) -> {
          barSymoble.setVisibility(View.GONE);
          _fab.setVisibility(View.VISIBLE);
        });

    _fab.setOnClickListener(
        (it) -> {
          FabFileRuner();
        });
    codesnapimg.setOnClickListener(
        v -> {
          new CodeSnap(CodeEditorActivity.this, getTabPathCode(), editor);
        });

    List<Child> editorPluginChildren = PluginChildRegistry.getCodeEditorChildren();
    for (Child child : editorPluginChildren) {
      listChild.add(child); // یا متد مربوطه
    }
  }

  public void addChild(Child child) {
    listChild.add(child);
  }

  String getTabPathCode() {
    int selectedTabPosition = tablayouteditor.getSelectedTabPosition();
    if (selectedTabPosition >= 0 && selectedTabPosition < tabs_listmap.size()) {
      return tabs_listmap.get(selectedTabPosition).get("path").toString();
    }
    return "";
  }

  private void initializeLogic() {
    proanjctor.setVisibility(View.GONE);
    barSymoble.setVisibility(View.VISIBLE);
    setWallpaperParallaxEffect();
    imap = new HashMap<>();

    if (FileUtil.isExistFile(thememanagersoft.getString("themes", ""))) {
      if (thememanagersoft.contains("themes")) {
        imap =
            new Gson()
                .fromJson(
                    FileUtil.readFile(thememanagersoft.getString("themes", "")),
                    new TypeToken<HashMap<String, Object>>() {}.getType());
      }
    } else {
      imap =
          new Gson()
              .fromJson(
                  ThemeUtils.themeAsString(),
                  new TypeToken<HashMap<String, Object>>() {}.getType());
    }

    editor.setKeyboardOperation(
        new CodeEditor.OnKeyboardOperation() {
          @Override
          public void Tab() {}

          @Override
          public void Space() {}

          @Override
          public void Removed() {}

          @Override
          public void Enter() {}
        });
    if (sf.contains("sd100")) {
      if (sf.getInt("sd100", 1) == 1) {
        editor.setCompletionWndPositionMode(CodeEditor.WINDOW_POS_MODE_AUTO);
      } else if (sf.getInt("sd100", 1) == 2) {
        editor.setCompletionWndPositionMode(CodeEditor.WINDOW_POS_MODE_FOLLOW_CURSOR_ALWAYS);
      } else if (sf.getInt("sd100", 1) == 3) {
        editor.setCompletionWndPositionMode(CodeEditor.WINDOW_POS_MODE_FULL_WIDTH_ALWAYS);
      }
    }

    if (getvb.contains("chars")) {
      editor.setCustomCharName(getvb.getString("chars", ""));
    }

    var projectz = new ProjectManager();
    projectz.setProjectName(getIntent().getStringExtra("root"));
    editor.subscribeEvent(
        ContentChangeEvent.class,
        (event, subscribe) -> {
          var cu = event.getEditor().getCursor();
          var iscode = new FactoryCodeError(editor, iconAuthor, tablayouteditor);
          int selectedTabPosition = tablayouteditor.getSelectedTabPosition();
          if (selectedTabPosition >= 0 && selectedTabPosition < tabs_listmap.size()) {
            ObjectUtils.addStarToTab(selectedTabPosition, tablayouteditor);
          }
          new Handler(Looper.getMainLooper())
              .postDelayed(
                  () -> {
                    iscode.run();
                  },
                  3000);
        });

    if (sve.contains("getAutoSave")) {
      if (sve.getString("getAutoSave", "").equals("true")) {
        FileChangeReceiver.stopWatching();
        editor.subscribeEvent(
            ContentChangeEvent.class,
            (event, subscribe) -> {
              try {
                FileChangeReceiver.stopWatching();
                int selectedTabPosition = tablayouteditor.getSelectedTabPosition();
                if (selectedTabPosition >= 0 && selectedTabPosition < tabs_listmap.size()) {
                  String selectedFilePath =
                      tabs_listmap.get(selectedTabPosition).get("path").toString();
                  String fileContent = editor.getText().toString();
                  FileUtil.writeFile(selectedFilePath, fileContent);
                  ObjectUtils.removedStarToTab(selectedTabPosition, tablayouteditor);
                }
              } catch (Exception e) {
                DataUtil.showMessage(getApplicationContext(), "Error not File saved!");
              }
            });
      } else {
        int selectedTabPosition = tablayouteditor.getSelectedTabPosition();
        if (selectedTabPosition >= 0 && selectedTabPosition < tabs_listmap.size()) {
          String selectedFilePath = tabs_listmap.get(selectedTabPosition).get("path").toString();
          String fileContent = editor.getText().toString();
          FileUtil.writeFile(selectedFilePath, fileContent);
          ObjectUtils.removedStarToTab(selectedTabPosition, tablayouteditor);
          FileChangeReceiver.startWatching(
              CodeEditorActivity.this,
              selectedFilePath,
              (filePath) -> {
                FileChangeReceiver.showFileChangedDialog(
                    CodeEditorActivity.this,
                    filePath,
                    () -> {
                      setCodeEditorFileReader(filePath);
                    });
              });
        }
      }
    }
    Symbloinit();
    ReloadFileInPos();
    if (shp.contains("pos_path")) {
      if (!shp.getString("pos_path", "").equals("")) {
        setCodeEditorFileReader(shp.getString("pos_path", ""));
      }
    }
    FileUtil.writeFile(
        "/storage/emulated/0/GhostWebIDE/ninjacoder/openFile.json", shp.getString("path", ""));

    progressbar1.setVisibility(View.GONE);
    if (re.getString("f380", "").equals("true")) {
      editor.setNonPrintablePaintingFlags(CodeEditor.FLAG_DRAW_LINE_SEPARATOR);
    }

    getWindow()
        .setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

    themeForJson2.setThemeCodeEditor(editor, imap, false, this);
    themeForJson2.addTextColor(
        titleauthor, KeySet.syombolbartextcolor, Color.parseColor("#FFFFA0FB"), this, imap);
    themeForJson2.addImageColor(undo, this, KeySet.imagecolor, imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.addImageColor(redo, this, KeySet.imagecolor, imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.addImageColor(
        image, this, KeySet.imagecolor, imap, Color.parseColor("#ff94e7ff"));

    themeForJson2.setStatusNavColor(this, imap, KeySet.navstatusbar, Coordinator, getColorPass);
    themeForJson2.addImageColor(
        menupopnew, this, KeySet.imagecolor, imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.setFabBackground(_fab, imap);
    AnimUtils.ClickAnimation(menupopnew);
    tablayouteditor.setSelectedTabIndicatorColor(
        imap.containsKey(KeySet.tabback)
            ? Color.parseColor(imap.get(KeySet.tabback).toString())
            : MaterialColors.getColor(tablayouteditor, ObjectUtils.Back));
    tablayouteditor.setTabTextColors(
        ColorStateList.valueOf(
            imap.containsKey(KeySet.tabtextcolor)
                ? Color.parseColor(imap.get(KeySet.tabtextcolor).toString())
                : MaterialColors.getColor(tablayouteditor, ObjectUtils.TvColor)));

    AnimUtils.ClickAnimation(undo);
    AnimUtils.ClickAnimation(redo);

    AnimUtils.Worker(_fab);
    editor
        .getColorScheme()
        .setColor(EditorColorScheme.MATCHED_TEXT_BACKGROUND, Color.parseColor("#75800F31"));

    if (setfont.contains("mfont")) {
      if (!FileUtil.isFile(setfont.getString("mfont", ""))) {
        editor.setTypefaceText(Typeface.createFromAsset(getAssets(), "ghostfont.ttf"));
        editor.setTypefaceLineNumber(Typeface.createFromAsset(getAssets(), "ghostfont.ttf"));
        DataUtil.showMessage(getApplicationContext(), "Custom Font Not Found");
        titleauthor.setTypeface(
            Typeface.createFromAsset(getAssets(), "fonts/ghostfont.ttf"), Typeface.NORMAL);

      } else {
        setFontEditorFromFile(setfont.getString("mfont", ""));
        titleauthor.setTypeface(Typeface.createFromFile(new File(setfont.getString("mfont", ""))));
      }
    } else {
      editor.setTypefaceText(Typeface.createFromAsset(getAssets(), "ghostfont.ttf"));
      editor.setTypefaceLineNumber(Typeface.createFromAsset(getAssets(), "ghostfont.ttf"));
      titleauthor.setTypeface(
          Typeface.createFromAsset(getAssets(), "fonts/ghostfont.ttf"), Typeface.NORMAL);
    }
    var data = thememanagersoft.contains("br") ? thememanagersoft.getFloat("br", 2) : 3;
    mvideo.setLifecycle(getLifecycle());
    if (getvb.getString("dir", "").endsWith(".mp4")) {
      mvideo.setPath(getvb.getString("dir", ""));
      mvideo.setVisibility(View.VISIBLE);
    } else {
      mvideo.setVisibility(View.GONE);
      mvideo.releasePlayer();
    }
    BlurImage.setBlurInWallpaperMobile(this, data, ghostIcon);
    getColorPass.setBackgroundColor(Color.parseColor(imap.get("backgroundcolorlinear").toString()));
    if (getinitdir.contains("mdir")) {
      if (getinitdir.getString("mdir", "").equals("true")) {
        dir.setVisibility(View.GONE);
      } else {
        dir.setVisibility(View.VISIBLE);
      }
    }
    if (imap.containsKey("tabback")) {
      if (Build.VERSION.SDK_INT >= 21) {
        proanjctor
            .getIndeterminateDrawable()
            .setColorFilter(
                Color.parseColor(imap.get("tabback").toString()), PorterDuff.Mode.SRC_IN);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        progressbar1
            .getIndeterminateDrawable()
            .setColorFilter(
                Color.parseColor(imap.get("tabback").toString()), PorterDuff.Mode.SRC_IN);
      }
    } else {
      if (Build.VERSION.SDK_INT >= 21) {
        proanjctor.getIndeterminateDrawable().setColorFilter(0xFFFFB689, PorterDuff.Mode.SRC_IN);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        progressbar1.getIndeterminateDrawable().setColorFilter(0xFFFFB689, PorterDuff.Mode.SRC_IN);
      }
    }
    AnimUtils.ClickAnimation(image);
    if (mthemepost.getString("mytheme", "").equals("true")) {
      EdgeToEdge.enable(this);
    } else {
    }
  }

  private void updateFileTypeForCurrentTab() {
    int selectedTabPosition = tablayouteditor.getSelectedTabPosition();
    if (selectedTabPosition >= 0 && selectedTabPosition < tabs_listmap.size()) {
      String filePath = tabs_listmap.get(selectedTabPosition).get("path").toString();
      String extension = filePath.substring(filePath.lastIndexOf("."));
      this.currentFileType = extension;

      // ریلود پلاگین‌ها برای تب جدید
      new PluginLoaderImpl().runInCodeEditor(editor, CodeEditorActivity.this, extension);
    }
  }

  void setManagerpanel(final View _view) {
    pvr =
        new PowerMenu.Builder(CodeEditorActivity.this)
            .addItem(new PowerMenuItem("Search Text", false, R.drawable.textsearch))
            .addItem(new PowerMenuItem("Color", false, R.drawable.color))
            .addItem(new PowerMenuItem("Log cat", false, R.drawable.codeformat))
            .addItem(new PowerMenuItem("Save", false, R.drawable.save))
            .addItem(new PowerMenuItem("Code nave", false, R.drawable.setsavefileall))
            .setIsMaterial(true)
            .build();
    pvr.setSelectedMenuColor(0xFFFDA893);
    pvr.setIconPadding(8);
    pvr.setIconSize(30);
    pvr.setAutoDismiss(true);
    pvr.showAsDropDown(_view);
    pvr.setAnimation(MenuAnimation.ELASTIC_CENTER);
    pvr.setMenuRadius(20f);
    pvr.setSelectedEffect(true);
    pvr.setShowBackground(false);
    pvr.setDividerHeight(2);
    pvr.setTextSize(14);

    themeForJson2.subPowerMenu(pvr, imap);
    pvr.setOnMenuItemClickListener(
        new OnMenuItemClickListener<PowerMenuItem>() {
          @Override
          public void onItemClick(int position, PowerMenuItem item) {
            switch (position) {
              case 0:
                {
                  ghost_searchs.showAndHide();
                  break;
                }

              case 1:
                {
                  ColorPickerDialogBuilder.with(CodeEditorActivity.this)
                      .setTitle("Set Color")
                      .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                      .showColorPreview(true)
                      .showColorEdit(true)
                      .density(22)
                      .showColorEdit(true)
                      .setOnColorSelectedListener(
                          new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {}
                          })
                      .setPositiveButton(
                          "انتخاب",
                          new ColorPickerClickListener() {
                            @Override
                            public void onClick(
                                DialogInterface dialog, int selectedColor, Integer[] allColors) {
                              String rgs = Integer.toHexString(selectedColor);
                              try {

                                setSymbols("#".concat(rgs.replace("#ff", "#")));
                              } catch (Exception exception) {
                                exception.printStackTrace();
                              }
                            }
                          })
                      .setNegativeButton(
                          "لغو",
                          new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                              DataUtil.showMessage(getApplicationContext(), "لغو شد");
                            }
                          })
                      .build()
                      .show();

                  break;
                }
              case 2:
                {
                  var sheet = new LogCatBottomSheet(CodeEditorActivity.this);
                  sheet.run();
                  break;
                }
              case 3:
                {
                  saveFileByIo();
                  int selectedTabPosition = tablayouteditor.getSelectedTabPosition();
                  if (selectedTabPosition >= 0 && selectedTabPosition < tabs_listmap.size()) {
                    ObjectUtils.removedStarToTab(selectedTabPosition, tablayouteditor);
                  }
                  break;
                }

              case 4:
                {
                  var colorview = new ColorView();
                  colorview.runJavaAsSmail(
                      CodeEditorActivity.this, shp.getString("pos_path", ""), editor);
                  break;
                }
            }
          }
        });
  }

  void saveFileByIo() {

    FileChangeReceiver.stopWatching();

    if (editor.getTextAsString().isEmpty()) {
      DataUtil.showMessage(getApplicationContext(), getString(R.string.errorEmptyFile));
    } else {
      try {
        isFileChangeDialogShowing = false;
        int selectedTabPosition = tablayouteditor.getSelectedTabPosition();
        if (selectedTabPosition >= 0 && selectedTabPosition < tabs_listmap.size()) {
          String selectedFilePath = tabs_listmap.get(selectedTabPosition).get("path").toString();
          Toast.makeText(this, selectedFilePath, 2).show();
          String fileContent = editor.getText().toString();
          ObjectUtils.runAndPostInTime(
              () -> {
                FileChangeReceiver.startWatching(
                    CodeEditorActivity.this,
                    selectedFilePath,
                    (filePath) -> {
                      FileChangeReceiver.showFileChangedDialog(
                          CodeEditorActivity.this,
                          filePath,
                          () -> {
                            setCodeEditorFileReader(filePath);
                          });
                    });
              },
              3000);
          if (selectedFilePath.endsWith(".class")) {
            FileUtil.writeFile(selectedFilePath.replace(".class", ".java"), fileContent);
          } else FileUtil.writeFile(selectedFilePath, fileContent);
        }
      } catch (Exception e) {
        DataUtil.showMessage(getApplicationContext(), "Error not File saved!");
      }
    }
  }

  void setCodeEditorFileReader(String _path) {
    String extension = _path.substring(_path.lastIndexOf("."));
    this.currentFileType = extension;
    
    new PluginLoaderImpl().runInCodeEditor(editor, CodeEditorActivity.this, extension);
    new Handler()
        .postDelayed(
            () -> {
              EditorRoaderFile.RuningTask(editor, _fab, _path, proanjctor, listChild);
            },
            200);
  }

  void setClosetab(int _position, ArrayList<HashMap<String, Object>> _data) {
    if (FileUtil.isExistFile(_data.get(_position).get("path").toString())) {
      _data.remove((_position));
      if (_data.isEmpty()) {
        editor.setText("");
        _data.clear();
        shp.edit().remove("pos_path").apply();
        shp.edit().remove("path").apply();
        finish();
      } else {
        if ((_position == 0) && (_data.size() > 1)) {
          shp.edit().putString("pos_path", _data.get(_position + 1).get("path").toString()).apply();
          shp.edit().putString("positionTabs", String.valueOf((long) (_position + 1))).apply();
          setCodeEditorFileReader(_data.get(_position + 1).get("path").toString());
        } else {
          if ((_position == 0) && (_data.size() == 1)) {
            shp.edit().putString("pos_path", _data.get(0).get("path").toString()).apply();
            setCodeEditorFileReader(_data.get(0).get("path").toString());
            editor.setText("");
          } else {
            shp.edit()
                .putString("pos_path", _data.get(_position - 1).get("path").toString())
                .apply();
            shp.edit().putString("positionTabs", String.valueOf((long) (_position - 1))).apply();
            setCodeEditorFileReader(_data.get(_position - 1).get("path").toString());
          }
        }
      }
      shp.edit().putString("path", new Gson().toJson(_data)).apply();
    } else {
      _data.remove(_position);
      if (_data.isEmpty()) {
        _data.clear();
        shp.edit().remove("pos_path").apply();
        shp.edit().remove("path").apply();
        finish();
      } else {
        if ((_position == 0) && (_data.size() > 1)) {
          shp.edit().putString("pos_path", _data.get(_position + 1).get("path").toString()).apply();
          shp.edit().putString("positionTabs", String.valueOf((long) (_position + 1))).apply();
        } else {
          if ((_position == 0) && (_data.size() == 1)) {
            shp.edit().putString("pos_path", _data.get(0).get("path").toString()).apply();
          } else {
            shp.edit()
                .putString("pos_path", _data.get(_position - 1).get("path").toString())
                .apply();
            shp.edit().putString("positionTabs", String.valueOf((long) (_position - 1))).apply();
          }
        }
      }
      shp.edit().putString("path", new Gson().toJson(_data)).apply();
    }
  }

  void ReloadFileInPos() {
    if (shp.contains("path")) {
      if (!shp.getString("path", "").equals("")) {
        tabs_listmap =
            new Gson()
                .fromJson(
                    shp.getString("path", ""),
                    new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());

        tabs_listmap.forEach(
            it -> {
              path =
                  it.containsKey("path") && it.get("path") != null ? it.get("path").toString() : "";
              boolean fileExists = FileUtil.isExistFile(path);
              it.put("exists", fileExists);
              String tabText = Uri.parse(path).getLastPathSegment();
              if (FileUtil.isExistFile(path)) {
                tablayouteditor.addTab(tablayouteditor.newTab().setText(tabText));
                isFileChangeDialogShowing = true;
                if (isFileChangeDialogShowing)
                  FileChangeReceiver.startWatching(
                      CodeEditorActivity.this,
                      path,
                      (filePath) -> {
                        FileChangeReceiver.showFileChangedDialog(
                            CodeEditorActivity.this,
                            filePath,
                            () -> {
                              // کد برای بارگذاری مجدد فایل
                              setCodeEditorFileReader(filePath);
                            });
                      });

              } else {
                tablayouteditor.addTab(
                    tablayouteditor.newTab().setText("File not found" + tabText));
              }
            });
        setDistreeView();
        tablayouteditor.addOnTabSelectedListener(
            new TabLayout.OnTabSelectedListener() {

              @Override
              public void onTabReselected(TabLayout.Tab tabs) {
                int pos = tabs.getPosition();

                try {
                  PowerMenu powers =
                      new PowerMenu.Builder(CodeEditorActivity.this)
                          .addItem(new PowerMenuItem("close"))
                          .addItem(new PowerMenuItem("close other"))
                          .addItem(new PowerMenuItem("close all"))
                          .setIsMaterial(true)
                          .setShowBackground(false)
                          .setAutoDismiss(true)
                          .setMenuColor(
                              imap.containsKey(KeySet.menuPosBackground)
                                  ? Color.parseColor(imap.get(KeySet.menuPosBackground).toString())
                                  : MaterialColors.getColor(
                                      CodeEditorActivity.this, ObjectUtils.Back, 0))
                          .setTextColor(
                              imap.containsKey(KeySet.menuPosTextColor)
                                  ? Color.parseColor(imap.get(KeySet.menuPosTextColor).toString())
                                  : MaterialColors.getColor(
                                      CodeEditorActivity.this, ObjectUtils.TvColor, 0))
                          .setMenuRadius(15)
                          .setAnimation(MenuAnimation.FADE)
                          .build();
                  powers.setOnMenuItemClickListener(
                      (ii, c) -> {
                        switch (ii) {
                          case 0:
                            if (pos >= 0 && pos < tabs_listmap.size()) {
                              tablayouteditor.removeTabAt(pos);
                              setClosetab(pos, tabs_listmap);
                            }
                            break;

                          case 1:
                            for (int i = tabs_listmap.size() - 1; i >= 0; i--) {
                              if (i != pos) {
                                tablayouteditor.removeTabAt(i);
                                tabs_listmap.remove(i);
                              }
                            }
                            setCloseother();
                            break;

                          case 2:
                            tablayouteditor.removeAllTabs();
                            setCloseall();
                            break;
                        }
                      });
                  powers.showAsDropDown(tabs.view);
                } catch (Exception e) {

                  e.printStackTrace();
                }
              }

              @Override
              public void onTabSelected(TabLayout.Tab tabs) {
                int pos = tabs.getPosition();
                if (pos >= 0 && pos < tabs_listmap.size()) {
                  String filePath = tabs_listmap.get(pos).get("path").toString();
                  boolean fileExists =
                      (boolean) tabs_listmap.get(pos).getOrDefault("exists", false);
                  if (!fileExists) {
                    showFileNotFoundDialog(pos, filePath);
                  } else {
                    updateFileTypeForCurrentTab();
                    setCodeEditorFileReader(filePath);
                  }
                }
                setDistreeView();
              }

              @Override
              public void onTabUnselected(TabLayout.Tab tabs) {}
            });
      }
    }

    if (FileUtil.isExistFile(shp.getString("pos_path", ""))) {
      setCodeEditorFileReader(shp.getString("pos_path", ""));
      if (tablayouteditor.getTabCount() > 0) {
        int savedPosition =
            (int) Math.floor(Double.parseDouble(shp.getString("positionTabs", "0")));
        TabLayout.Tab savedTab = tablayouteditor.getTabAt(savedPosition);
        if (tablayouteditor.getSelectedTabPosition() != savedPosition) {
          tablayouteditor.selectTab(tablayouteditor.getTabAt(savedPosition), true);
          tablayouteditor.post(() -> tablayouteditor.setScrollPosition(savedPosition, 0f, true));
        }
      }
    }
  }

  private void showFileNotFoundDialog(int position, String filePath) {
    new MaterialAlertDialogBuilder(this)
        .setTitle("File not found ")
        .setMessage("file " + Uri.parse(filePath).getLastPathSegment() + " وجود ندارد")
        .setPositiveButton(
            "close tab",
            (dialog, which) -> {
              tablayouteditor.removeTabAt(position);
              tabs_listmap.remove(position);
              setCloseother();
            })
        .setNegativeButton(
            "tryit",
            (dialog, which) -> {
              boolean existsNow = FileUtil.isExistFile(filePath);
              tabs_listmap.get(position).put("exists", existsNow);

              if (existsNow) {
                TabLayout.Tab tab = tablayouteditor.getTabAt(position);
                if (tab != null) {
                  tab.setText(Uri.parse(filePath).getLastPathSegment());
                  setCodeEditorFileReader(filePath);
                }
              }
            })
        .setNeutralButton("close dialog", null)
        .show();
  }

  public void setSymbols(String input) {
    var channel = editor.createNewSymbolChannel();
    channel.insertSymbol(input, input.length());
  }

  void setFontEditorFromFile(final String _files) {
    editor.setTypefaceText(Typeface.createFromFile(new File(_files)));
    editor.setTypefaceLineNumber(Typeface.createFromFile(new File(_files)));
  }

  void Symbloinit() {
    try {
      InputStream inputstream5 = getAssets().open("symbol.json");
      staticSymbiolPiare =
          new Gson()
              .fromJson(
                  DataUtil.copyFromInputStream(inputstream5),
                  new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
      SyspiarAdapter syspiarAdapter =
          new SyspiarAdapter(
              staticSymbiolPiare,
              new SyspiarAdapter.OnTabView() {
                @Override
                public void TAB(String tab) {
                  setSymbols(tab);
                }

                @Override
                public void POST(String post) {
                  setSymbols(post);
                }
              },
              editor);

      syspiar.setAdapter(syspiarAdapter);
      syspiar.setLayoutManager(
          new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    } catch (Exception e) {
      DataUtil.showMessage(getApplicationContext(), e.toString());
    }
  }

  void setCloseall() {
    tabs_listmap.clear();
    shp.edit().remove("pos_path").apply();
    shp.edit().remove("positionTabs").apply();

    shp.edit().putString("path", new Gson().toJson(tabs_listmap)).apply();
    FileUtil.deleteFile("/storage/emulated/0/GhostWebIDE/ninjacoder/openFile.json");
    finish();
  }

  void setCloseother() {
    tabs_listmap.clear();
    {
      HashMap<String, Object> _item = new HashMap<>();
      _item.put("path", shp.getString("pos_path", ""));
      tabs_listmap.add(_item);
    }

    shp.edit().putString("positionTabs", "0").apply();
    FileUtil.writeFile(
        "/storage/emulated/0/GhostWebIDE/ninjacoder/openFile.json", shp.getString("pos_path", ""));
    shp.edit().putString("path", new Gson().toJson(tabs_listmap)).apply();
  }

  public List<String> spiltIntoBreadcrumbItems(String filePath) {
    String separator = "/";
    String[] items = filePath.split(separator);
    List<String> filteredItems = new ArrayList<>();
    for (String item : items) {
      if (!item.trim().isEmpty()) {
        filteredItems.add(item);
      }
    }
    if (filteredItems.size() >= 3
        && filteredItems.get(0).equals("storage")
        && filteredItems.get(1).equals("emulated")
        && filteredItems.get(2).equals("0")) {
      List<String> combinedItems = new ArrayList<>();
      combinedItems.add("home");
      combinedItems.addAll(filteredItems.subList(3, filteredItems.size()));
      return combinedItems;
    }
    return filteredItems;
  }

  void setDistreeView() {
    List<String> pospath = spiltIntoBreadcrumbItems(shp.getString("pos_path", ""));

    var adps =
        new ToolbarListFileAdapter(
            pospath,
            this,
            new ToolbarListFileAdapter.CallBack() {

              @Override
              public void GoToDir(View view) {}

              @Override
              public void GoToTreeFile(View view) {}
            });

    dir.setAdapter(adps);
    dir.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    dir.smoothScrollToPosition(pospath.size());
  }

  void FabFileRuner() {
    try {
      FileChangeReceiver.stopWatching();

      int selectedTabPosition = tablayouteditor.getSelectedTabPosition();
      if (selectedTabPosition >= 0 && selectedTabPosition < tabs_listmap.size()) {
        String selectedFilePath = tabs_listmap.get(selectedTabPosition).get("path").toString();
        Toast.makeText(this, selectedFilePath, 2).show();
        String fileContent = editor.getText().toString();
        ObjectUtils.removedStarToTab(selectedTabPosition, tablayouteditor);
        FileUtil.writeFile(selectedFilePath, fileContent);
        ObjectUtils.runAndPostInTime(
            () -> {
              FileChangeReceiver.startWatching(
                  CodeEditorActivity.this,
                  selectedFilePath,
                  (filePath) -> {
                    FileChangeReceiver.showFileChangedDialog(
                        CodeEditorActivity.this,
                        filePath,
                        () -> {
                          setCodeEditorFileReader(filePath);
                        });
                  });
            },
            3000);
        if (selectedFilePath.contains(".html")) {
          if (ru.getBoolean("live", false)) {
            var it = new CompilerUtils(selectedFilePath, Mode.WEB, CodeEditorActivity.this);
          } else {
            htmlrus.setClass(getApplicationContext(), HtmlRunerActivity.class);
            htmlrus.putExtra("run", selectedFilePath);
            htmlrus.putExtra("runs", Uri.parse(selectedFilePath).getLastPathSegment());
            File file = new File(selectedFilePath);
            if (file.exists()) {
              String phpz = file.getParent();
              htmlrus.putExtra("root", phpz);
              Toast.makeText(getApplicationContext(), phpz, Toast.LENGTH_SHORT).show();
            }
            loadAnim(htmlrus);
          }
        } else if (selectedFilePath.contains(".json")) {
          jsonview.setClass(getApplicationContext(), JsonViewerActivity.class);
          jsonview.putExtra("g", selectedFilePath);
          loadAnim(jsonview);
        } else if (selectedFilePath.contains(".jsx")) {
          SassForAndroid.runObjectWeb(editor, selectedFilePath, CompilerModel.JSX);
        } else if (selectedFilePath.contains(".js")) {
          getmd.setClass(getApplicationContext(), JsRunerActivity.class);
          getmd.putExtra("sendCode", selectedFilePath);
          loadAnim(getmd);
        } else if (selectedFilePath.contains(".sh")) {
          res.setClass(getApplicationContext(), ShellCodeActivity.class);
          res.putExtra("sh", selectedFilePath);
          loadAnim(res);
        } else if (selectedFilePath.contains(".svg")) {
          htmlrus.setClass(getApplicationContext(), HtmlRunerActivity.class);
          htmlrus.putExtra("run", selectedFilePath);
          loadAnim(htmlrus);
        } else if (selectedFilePath.contains(".md")) {
          getmd.setClass(getApplicationContext(), MdCodeViewActivity.class);
          getmd.putExtra("v", selectedFilePath);
          loadAnim(getmd);
        } else if (selectedFilePath.contains(".py")) {
          getmd.setClass(getApplicationContext(), TerminalActivity.class);
          getmd.putExtra("path", selectedFilePath);
          loadAnim(getmd);
        } else if (selectedFilePath.contains(".g4")) {
          setAntlr4Compiler(selectedFilePath);
        } else if (selectedFilePath.contains(".php")) {
          getmd.setClass(getApplicationContext(), TerminalActivity.class);
          getmd.putExtra("phpcode", selectedFilePath);
          loadAnim(getmd);
        } else if (selectedFilePath.contains(".scss") || selectedFilePath.contains(".sass")) {
          SassForAndroid.run(CodeEditorActivity.this, selectedFilePath, selectedFilePath);
        } else if (selectedFilePath.contains(".java")) {
          JavaCompilerBeta.run(CodeEditorActivity.this, new File(selectedFilePath));
        } else if (selectedFilePath.contains(".xml")) {
          Intent intent = new Intent(CodeEditorActivity.this, XmlLayoutDesignActivity.class);
          intent.putExtra(XmlLayoutDesignActivity.EXTRA_FILE, selectedFilePath);
          intent.putExtra(XmlLayoutDesignActivity.EXTRA_LANGUAGE, "xml");
          intent.putExtra(XmlLayoutDesignActivity.EXTRA_DEMO, false);
          intent.putExtra(XmlLayoutDesignActivity.EXTRA_STANDALONE, false);
          intent.putExtra(XmlLayoutDesignActivity.EXTRA_TRAINER, false);
          loadAnim(intent);

        } else if (selectedFilePath.contains(".jj")) {
          var file = new File(selectedFilePath);
          JavaCcComplierImpl.main(file.toString(), file.getParent() + "/");
        } else if (selectedFilePath.contains(".kt")) {

          new KotlinCompilerImpl(CodeEditorActivity.this, selectedFilePath, editor);
        } else if (selectedFilePath.contains(".ts")) {
          SassForAndroid.runObjectWeb(editor, selectedFilePath, CompilerModel.TYPESRCIPT);
        } else if (selectedFilePath.contains(".less")) {
          SassForAndroid.runObjectWeb(editor, selectedFilePath, CompilerModel.LESS);
        } else if (selectedFilePath.contains(".dart")) {
          res.setClass(getApplicationContext(), TerminalActivity.class);
          res.putExtra("dart", selectedFilePath);
          loadAnim(res);
        }
      } else {

        Toast.makeText(this, "تب انتخاب‌شده معتبر نیست", Toast.LENGTH_SHORT).show();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  void setAntlr4Compiler(String path) {
    final var bottomSheetDialog = new BottomSheetDialog(this);

    Antcomp8lerBinding bind = Antcomp8lerBinding.inflate(getLayoutInflater());
    bottomSheetDialog.setContentView(bind.getRoot());
    File file = new File(path);
    bind.edpath.setText(file.getParent());
    bind.btnrun.setOnClickListener(
        (noy) -> {
          G4Compiler.compile(
              shp.getString("pos_path", ""),
              bind.edpath.getText().toString(),
              bind.etpa.getText().toString());
          bottomSheetDialog.dismiss();
        });
    bottomSheetDialog.show();
  }

  void setWallpaperParallaxEffect() {

    effect = new WallpaperParallaxEffect(this);
    effect.setCallback(
        (offsetX, offsetY, angle) -> {
          float progress = 1.0f;
          Coordinator.setTranslationX(offsetX * progress);
          Coordinator.setTranslationY(offsetY * progress);
        });

    effect.setEnabled(thememanagersoft.contains("effect"));
  }

  @Override
  public boolean onKeyDown(int data, KeyEvent key) {

    if (key.isAltPressed() || key.isCtrlPressed()) {
      switch (data) {
        case KeyEvent.KEYCODE_S:
          saveFileByIo();
          return true;
      }
    }

    return super.onKeyDown(data, key);
  }
}
