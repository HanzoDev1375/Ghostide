package ir.ninjacoder.ghostide.activities;

import ir.ninjacoder.ghostide.G4Compiler;
import ir.ninjacoder.ghostide.IdeEditor;

import ir.ninjacoder.ghostide.JavaCcComplierImpl;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.RequestNetwork;
import ir.ninjacoder.ghostide.adapter.SyspiarAdapter;
import ir.ninjacoder.ghostide.adapter.ToolbarListFileAdapter;
import ir.ninjacoder.ghostide.config.CommonFactoryData;
import ir.ninjacoder.ghostide.config.JavaToGsonHelper;
import ir.ninjacoder.ghostide.config.MenuColorView;
import ir.ninjacoder.ghostide.databinding.Antcomp8lerBinding;
import ir.ninjacoder.ghostide.enums.Mode;
import ir.ninjacoder.ghostide.folder.FileIconHelper;
import ir.ninjacoder.ghostide.interfaces.OnClickFileSlideSheetCallBack;
import ir.ninjacoder.ghostide.layoutmanager.LogCatBottomSheet;
import ir.ninjacoder.ghostide.marco.CharUtil;
import ir.ninjacoder.ghostide.marco.ColorView;
import ir.ninjacoder.ghostide.marco.FactoryCodeError;
import ir.ninjacoder.ghostide.marco.GhostWebEditorSearch;
import ir.ninjacoder.ghostide.marco.WallpaperParallaxEffect;
import ir.ninjacoder.ghostide.marco.ideColors.IdeColorCompat;
import ir.ninjacoder.ghostide.model.EditorViewModel;
import ir.ninjacoder.ghostide.navigator.EditorHelperColor;
import ir.ninjacoder.ghostide.navigator.EditorRoaderFile;
import ir.ninjacoder.ghostide.project.JavaCompilerBeta;
import ir.ninjacoder.ghostide.project.ProjectManager;
import ir.ninjacoder.ghostide.tasks.app.SassForAndroid;
import ir.ninjacoder.ghostide.terminal.TerminalActivity;
import ir.ninjacoder.ghostide.utils.*;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.utils.CompilerUtils;
import ir.ninjacoder.ghostide.utils.DataUtil;
import ir.ninjacoder.ghostide.widget.BlurImage;
import ir.ninjacoder.ghostide.widget.ExrtaFab;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.*;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.TypedValue;
import android.view.*;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.EditorInfo;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.allenliu.badgeview.BadgeView;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mcal.uidesigner.XmlLayoutDesignActivity;
import com.ninjacoder.jgit.fileslide.OnItemCallBacks;
import com.ninjacoder.jgit.fileslide.SildeFileManger;
import com.ninjacoder.jgit.fileslide.SlideModel;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.event.ColorSchemeUpdateEvent;
import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.text.Cursor;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorAutoCompleteWindow;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import ninja.coder.appuploader.utils.ShapeUtils;
import ninja.coder.appuploader.utils.ShapeName;

public class CodeEditorActivity extends AppCompatActivity {

  public final int REQ_CD_SETPASZAMINE = 101;
  protected Sound sound;
  protected EditorAutoCompleteWindow window;
  protected ExrtaFab _fab; // /By ninja coder big man main
  private WallpaperParallaxEffect effect;
  private CoordinatorLayout Coordinator;

  private HashMap<String, Object> imap = new HashMap<>();
  private double n = 0;

  private final String code = "";
  private double click2var = 0;
  private double pos10 = 0;
  private ThemeUtils themeForJson2;
  private double n1 = 0;
  private double n2 = 0;
  private double n3 = 0;
  private double n4 = 0;
  private String datas = "";
  private double itemPosRemoved = 0;
  private final String GetTab = "";
  private final double index = 0;
  private double ic = 0;
  private final String vasteh = "";

  private ArrayList<HashMap<String, Object>> tabs_listmap = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> staticSymbiolPiare = new ArrayList<>();
  private final ArrayList<String> string = new ArrayList<>();
  private final ArrayList<String> list = new ArrayList<>();
  private LinearLayout multytab;
  private FrameLayout FrameLayout01;
  private LinearLayout newLayoutSymbolBar;
  private LinearLayout CustomToolbar;
  private ProgressBar progressbar1;
  
  private RecyclerView recyclerview1;
  private RecyclerView dir;
  private LinearLayout divar;

  private LinearLayout linear2;
  private BadgeView badgeview3;
  private TextView titleauthor;
  private ImageView image, redo, undo, menupopnew, iconAuthor;
  private IdeEditor editor;
  private LinearLayout FrameLayout02;
  private LinearLayout linear3;
  private ProgressBar proanjctor;
  private LinearLayout barSymoble;
  private LinearLayout linear5;
  private ImageView imageview1, imageloadereditor;
  private LinearLayout linear6;

  private LinearLayout divardown;
  private RecyclerView syspiar;

  private final Intent intentaddFile = new Intent();
  private final Intent htmlrus = new Intent();
  private SharedPreferences word;
  private SharedPreferences line;
  private SharedPreferences shp;
  private SharedPreferences qo;
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
  private SharedPreferences tab100;
  private SharedPreferences setfont;
  private SharedPreferences atx;
  private SharedPreferences ru;
  private final ObjectAnimator objectAnim = new ObjectAnimator();
  private SharedPreferences auto;
  private SharedPreferences tabimageview;
  private SharedPreferences moalaqfragment;
  private PowerMenu mmenucog;
  private PowerMenu mmenuitempos;
  private final Intent icon = new Intent();
  private PowerMenu pvr;
  private final Intent fontHelper = new Intent();
  private final Intent setPaszamine = new Intent(Intent.ACTION_GET_CONTENT);
  private SharedPreferences pss;
  private SharedPreferences sve;

  private SoundPool soundPool;
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
  private String Paths;
  private boolean isSvg = false;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.codeeditor);
    initialize(_savedInstanceState);
    initializeLogic();
  }

  private boolean isJsonError(String string) {
    HashMap<String, Object> map = new HashMap<>();
    ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
    try {
      map = new Gson().fromJson(string, new TypeToken<HashMap<String, Object>>() {}.getType());
      return true;
    } catch (Exception e0) {
      try {
        listmap =
            new Gson()
                .fromJson(string, new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
        return true;
      } catch (Exception e1) {
        return false;
      }
    }
  }

  private void initialize(Bundle _savedInstanceState) {

    Coordinator = findViewById(R.id.Coordinator);
    _fab = findViewById(R.id._fab);
    Coordinator = findViewById(R.id.Coordinator);
    multytab = findViewById(R.id.multytab);
    FrameLayout01 = findViewById(R.id.FrameLayout01);
    newLayoutSymbolBar = findViewById(R.id.newLayoutSymbolBar);
    CustomToolbar = findViewById(R.id.CustomToolbar);
    progressbar1 = findViewById(R.id.progressbar1);

    recyclerview1 = findViewById(R.id.recyclerview1);
    dir = findViewById(R.id.dir);
    divar = findViewById(R.id.divar);
    linear2 = findViewById(R.id.linear2);
    badgeview3 = findViewById(R.id.badgeview3);
    titleauthor = findViewById(R.id.titleauthor);
    image = findViewById(R.id.image);
    redo = findViewById(R.id.redo);
    undo = findViewById(R.id.undo);

    menupopnew = findViewById(R.id.menupopnew);
    editor = findViewById(R.id.editor);
    FrameLayout02 = findViewById(R.id.FrameLayout02);
    linear3 = findViewById(R.id.linear3);
    proanjctor = findViewById(R.id.proanjctor);
    barSymoble = findViewById(R.id.barSymoble);
    linear5 = findViewById(R.id.linear5);
    imageview1 = findViewById(R.id.imageview1);
    linear6 = findViewById(R.id.linear6);
    divardown = findViewById(R.id.divardown);
    ghost_searchs = findViewById(R.id.editor_ser);
    ghost_searchs.hide();
    syspiar = findViewById(R.id.syspiar);
    word = getSharedPreferences("word", Activity.MODE_PRIVATE);
    line = getSharedPreferences("line", Activity.MODE_PRIVATE);
    shp = getSharedPreferences("shp", Activity.MODE_PRIVATE);
    qo = getSharedPreferences("qo", Activity.MODE_PRIVATE);
    myDialog = new AlertDialog.Builder(this);
    di = new AlertDialog.Builder(this);
    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    getvb = getSharedPreferences("getvb", Activity.MODE_PRIVATE);
    re = getSharedPreferences("re", Activity.MODE_PRIVATE);
    war = getSharedPreferences("war", Activity.MODE_PRIVATE);
    tab100 = getSharedPreferences("tab100", Activity.MODE_PRIVATE);
    setfont = getSharedPreferences("setfont", Activity.MODE_PRIVATE);
    atx = getSharedPreferences("atx", Activity.MODE_PRIVATE);
    ru = getSharedPreferences("ru", Activity.MODE_PRIVATE);
    auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
    tabimageview = getSharedPreferences("tabimageview", Activity.MODE_PRIVATE);
    moalaqfragment = getSharedPreferences("moalaqfragment", Activity.MODE_PRIVATE);
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
    editor.restoreState(_savedInstanceState);
    themeForJson2 = new ThemeUtils();
    recyclerview1.addOnScrollListener(
        new RecyclerView.OnScrollListener() {
          @Override
          public void onScrollStateChanged(RecyclerView recyclerView, int _scrollState) {
            super.onScrollStateChanged(recyclerView, _scrollState);
          }

          @Override
          public void onScrolled(RecyclerView recyclerView, int _offsetX, int _offsetY) {
            super.onScrolled(recyclerView, _offsetX, _offsetY);
            if (_offsetX > (tabs_listmap.size() + 1)) {
              ClickItemChildAnimation(getWindow().getDecorView());
              ClickItemChildAnimation(editor);
              ClickItemChildAnimation(multytab);
              ClickItemChildAnimation(newLayoutSymbolBar);
              ClickItemChildAnimation(_fab);
            } else {
              ClickItemChildAnimation(editor);
              ClickItemChildAnimation(multytab);
              ClickItemChildAnimation(newLayoutSymbolBar);
              ClickItemChildAnimation(_fab);
              ClickItemChildAnimation(getWindow().getDecorView());
            }
          }
        });
    ghostIcon = findViewById(R.id.icon_backgroundghost);
    var mRootView = getWindow().getDecorView();
    syspiar.setVisibility(View.GONE);

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

                // Define the animation duration
                final float scale = getResources().getDisplayMetrics().density;

                int shortAnimationDuration =
                    getResources().getInteger(android.R.integer.config_shortAnimTime);

                if (keypadHeight > screenHeight * 0.15) {
                  // Increase the scale
                  var max = 1.4f;
                  ghostIcon
                      .animate()
                      .scaleX(Math.max(max, 1))
                      .scaleY(Math.max(max, 1))
                      .translationX(max / 2)
                      .translationY(max * max - 1)
                      .x(Math.max(max / 5, 6))
                      .y(Math.min(max * max, 6))
                      .setDuration(1000)
                      .start();
                  ObjectUtils.showViewWithAnimation(syspiar);

                } else {
                  // Decrease the scale
                  float minScale = 1.0f;
                  ghostIcon
                      .animate()
                      .scaleX(minScale)
                      .scaleY(minScale)
                      .translationX(minScale)
                      .translationY(minScale)
                      .x(minScale)
                      .y(minScale)
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
          _managerpanel(menupopnew);
        });

    imageview1.setOnClickListener(
        (it) -> {
          barSymoble.setVisibility(View.GONE);
          _fab.setVisibility(View.VISIBLE);
        });

    _fab.setOnClickListener(
        (it) -> {
          FabFileRuner();
          new JavaToGsonHelper(editor.getText().toString());
        });
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

    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ab);
    animation.start();
    editor.setAnimation(animation);
    editor.setFadein();
    soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
    n1 = soundPool.load(getApplicationContext(), R.raw.typenormal, 1);
    n2 = soundPool.load(getApplicationContext(), R.raw.typeremoved, 1);
    n3 = soundPool.load(getApplicationContext(), R.raw.ddoc, 1);
    n4 = soundPool.load(getApplicationContext(), R.raw.typespace, 1);
    editor.setFirstLineNumberAlwaysVisible(true);
    editor.setOverScrollEnabled(true);

    editor.setInputType(
        EditorInfo.TYPE_TEXT_FLAG_NO_SUGGESTIONS
            | EditorInfo.TYPE_CLASS_TEXT
            | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE
            | EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      editor.setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_NO);
    }
    editor.setText(modelEditor.getText());

    var editorHelperColor = new EditorHelperColor(editor, badgeview3);

    badgeview3.setOnClickListener(
        __ -> {
          var data = new CommonFactoryData(CodeEditorActivity.this, editor);
          var file = new File(shp.getString("pos_path", ""));
          data.setlistFile(file.getParentFile().toString());
          Toast.makeText(CodeEditorActivity.this, file.getParentFile().toString(), 2).show();
          data.setOnClickFileSlideSheetCallBack(
              new OnClickFileSlideSheetCallBack() {

                @Override
                public void onClickEvent(ArrayList<HashMap<String, Object>> map, int pos) {
                  map =
                      new Gson()
                          .fromJson(
                              shp.getString("path", ""),
                              new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
                  recyclerview1.setAdapter(new Recyclerview1Adapter(map));
                  recyclerview1.setLayoutManager(
                      new LinearLayoutManager(
                          CodeEditorActivity.this, LinearLayoutManager.HORIZONTAL, false));
                  setCodeEditorFileReader(shp.getString("pos_path", ""));
                  ((LinearLayoutManager) recyclerview1.getLayoutManager())
                      .scrollToPositionWithOffset(pos, 0);
                }

                @Override
                public void onLongClick(ArrayList<HashMap<String, Object>> map, int pos) {}
              });
        });

    var size =
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            2,
            getApplicationContext().getResources().getDisplayMetrics());
    editor.setDividerWidth(size);
    editor.setKeyboardOperation(
        new CodeEditor.OnKeyboardOperation() {
          @Override
          public void Tab() {
            //  Toast.makeText(getApplicationContext(), "This Tab", Toast.LENGTH_SHORT).show();
          }

          @Override
          public void Space() {
            // Toast.makeText(getApplicationContext(), "This Space", Toast.LENGTH_SHORT).show();
          }

          @Override
          public void Removed() {
            // Toast.makeText(getApplicationContext(),"This Key Del",2).show();
            n1 = soundPool.load(getApplicationContext(), R.raw.typenormal, 1);
          }

          @Override
          public void Enter() {
            n2 = soundPool.play(2, 1.0f, 1.0f, 1, 0, 1.0f);
            if (editor.getEditorLanguage() instanceof HTMLLanguage) {
              editor.formatCodeAsync();
            }

            //	Toast.makeText(getApplicationContext(),"This Key Enter",2).show();
          }
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

    editor.setLigatureEnabled(true);
    editor.setHighlightCurrentBlock(true);
    editor.setHighlightCurrentLine(false);
    editor.setAutoCompletionOnComposing(false);
    editor.setLineInfoTextSize(20f);
    editor.setBlockLineEnabled(true);

    if (getvb.contains("chars")) {
      editor.setCustomCharName(getvb.getString("chars", ""));
    }

    var projectz = new ProjectManager();
    projectz.setProjectName(getIntent().getStringExtra("root"));
    editor.subscribeEvent(
        ContentChangeEvent.class,
        (event, subscribe) -> {
          modelEditor.setText(event.getEditor().getText().toString());
          var cu = event.getEditor().getCursor();
          modelEditor.setCursor(cu.getLeftLine() + cu.getLeftColumn());
          var myChar = new CharUtil(editor.getText().toString(), titleauthor);
          var iscode = new FactoryCodeError(editor, iconAuthor);
          undo.setEnabled(editor.canUndo());
          redo.setEnabled(editor.canRedo());
          
          iscode.run();
        });

    if (sve.contains("getAutoSave")) {
      if (sve.getString("getAutoSave", "").equals("true")) {
        editor.subscribeEvent(
            ContentChangeEvent.class,
            (event, subscribe) -> {
              
              /// Code for saving file
              FileUtil.writeFile(shp.getString("pos_path", ""), editor.getText().toString());
            });
      } else {

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

    badgeview3.setBadgeBackground(Color.TRANSPARENT);
    badgeview3.setBadgeCount("");
    if (re.getString("f380", "").equals("true")) {
      editor.setNonPrintablePaintingFlags(CodeEditor.FLAG_DRAW_LINE_SEPARATOR);
    }

    getWindow()
        .setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

    editor.setLineNumberAlign(Paint.Align.CENTER);
    themeForJson2.setThemeCodeEditor(editor, imap, false, this);
    themeForJson2.addTextColor(
        titleauthor, "SyombolBarTextColor", Color.parseColor("#FFFFA0FB"), this, imap);
    themeForJson2.AddthemetoSattos(this, imap);
    themeForJson2.addBackground(this, imap, "tabimagecolorfilter", divar, Color.RED);
    themeForJson2.addBackground(this, imap, "tabimagecolorfilter", divardown, Color.RED);
    // divardown
    themeForJson2.addImageColor(undo, this, "imagecolor", imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.addImageColor(redo, this, "imagecolor", imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.addImageColor(image, this, "imagecolor", imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.addImageColor(
        menupopnew, this, "imagecolor", imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.setFabBackground(_fab, imap);
    themeForJson2.setFabColorHint(_fab, imap);
    AnimUtils.ClickAnimation(menupopnew);

    AnimUtils.ClickAnimation(undo);
    AnimUtils.ClickAnimation(redo);
    if (ru.contains("rup")) {
      ObjectUtils.tryToRunThemeMaterial(editor);
      CustomToolbar.setBackgroundColor(0xFF201B16);

      redo.setColorFilter(0xFFFFDCBD, PorterDuff.Mode.MULTIPLY);
      undo.setColorFilter(0xFFFFDCBD, PorterDuff.Mode.MULTIPLY);
      menupopnew.setColorFilter(0xFFEEEEEE, PorterDuff.Mode.MULTIPLY);
      image.setColorFilter(0xFFFFB689, PorterDuff.Mode.MULTIPLY);
      titleauthor.setTextColor(0xFFFDA893);
      if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
        Window ninjacoder = this.getWindow();
        ninjacoder.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ninjacoder.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        ninjacoder.setStatusBarColor(Color.parseColor("#FF2B2122"));
        ninjacoder.setNavigationBarColor(Color.parseColor("#FF2B2122"));
      }
      divardown.setBackgroundColor(0xFFC4A68A);
      divar.setBackgroundColor(0xFFC4A68A);
    } else {

    }
    _sttingpp();
    _Animwork(_fab);
    _Anim01(editor);
    editor
        .getColorScheme()
        .setColor(EditorColorScheme.MATCHED_TEXT_BACKGROUND, Color.parseColor("#75800F31"));
    // editor.setColorScheme(editor.getColorScheme().setColor(EditorColorScheme.red,Color.RED));
    editor.getColorScheme().setColor(EditorColorScheme.red, Color.parseColor("#FF710000"));

    if (tab100.contains("mpcnullgogo")) {
      try {
        _tabsize(Double.parseDouble(tab100.getString("mpcnullgogo", "")));
      } catch (Exception e) {
        DataUtil.showMessage(getApplicationContext(), "error");
      }
    }
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
    BlurImage.setBlurInWallpaperMobile(this, data, ghostIcon);
    var layout = findViewById(R.id.getColorPass);
    layout.setBackgroundColor(Color.parseColor(imap.get("backgroundcolorlinear").toString()));
    var i = layout.getBackground();
    ColorDrawable colorDrawable = (ColorDrawable) i;
    int color = colorDrawable.getColor();
    getWindow().setNavigationBarColor(color);
    getWindow().setStatusBarColor(color);
    editor.setAutoCompletionEnabled(!auto.contains("mauto"));
    //   _fab.setIconResource(R.drawable.play);

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

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    try {
      if (outState != null) {
        Cursor cursor = editor.getCursor();
        outState.putInt(IdeEditor.EDITOR_LEFT_LINE_KEY, cursor.getLeftLine());
        outState.putInt(IdeEditor.EDITOR_LEFT_COLUMN_KEY, cursor.getLeftColumn());
        outState.putInt(IdeEditor.EDITOR_RIGHT_LINE_KEY, cursor.getRightLine());
        outState.putInt(IdeEditor.EDITOR_RIGHT_COLUMN_KEY, cursor.getRightColumn());
      }
    } catch (Exception err) {

    }
  }

  public void _managerpanel(final View _view) {
    pvr =
        new PowerMenu.Builder(CodeEditorActivity.this)
            .addItem(new PowerMenuItem("Search Text", false, R.drawable.textsearch))
            .addItem(new PowerMenuItem("Color", false, R.drawable.color))
            .addItem(new PowerMenuItem("Log cat", false, R.drawable.codeformat))
            .addItem(new PowerMenuItem("Save", false, R.drawable.save))
            .addItem(new PowerMenuItem("Save All (Beta)", false, R.drawable.setsavefileall))
            .addItem(new PowerMenuItem("Code nave", false, R.drawable.setsavefileall))
            .addItem(new PowerMenuItem("Reload Color"))
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
                      // .initialColor(getColor(R.color.Ninja))
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
                  
                  break;
                }
              case 4:
                {
                  setAllSaveFile(Coordinator);
                  
                  break;
                }
              case 5:
                {
                  var colorview = new ColorView();
                  colorview.runJavaAsSmail(
                      CodeEditorActivity.this, shp.getString("pos_path", ""), editor);
                  break;
                }

              case 6:
                {
                  editor.subscribeEvent(
                      ColorSchemeUpdateEvent.class,
                      (it, rr) -> {
                        editor.setColorScheme(it.getColorScheme());
                      });
                  break;
                }
            }
          }
        });
  }

  void saveFileByIo() {
    if (editor.getText().toString().isEmpty()) {
      DataUtil.showMessage(getApplicationContext(), getString(R.string.errorEmptyFile));
    } else {
      try {
        if (shp.contains("pos_path")) {
          if (!shp.getString("pos_path", "").equals("")) {
            FileUtil.writeFile(shp.getString("pos_path", ""), editor.getText().toString());

          } else {
            DataUtil.showMessage(getApplicationContext(), "Error not File saved!");
          }
        }
      } catch (Exception e) {
        DataUtil.showMessage(getApplicationContext(), "Error not File saved!");
      }
    }
  }

  public void _sttingpp() {
    //// get word app for my app lol
    if (line.getString("getline", "").equals("true")) {
      editor.setPinLineNumber(true);
    } else {
      if (line.getString("getline", "").equals("false")) {
        editor.setPinLineNumber(false);
      } else {

      }
    }
  }

  public void _Ripple_Drawable(final View _view, final String _c) {
    android.content.res.ColorStateList clr =
        new android.content.res.ColorStateList(
            new int[][] {new int[] {}}, new int[] {Color.parseColor(_c)});
    android.graphics.drawable.RippleDrawable ripdr =
        new android.graphics.drawable.RippleDrawable(clr, null, null);
    _view.setBackground(ripdr);
  }

  public void setCodeEditorFileReader(String _path) {
    EditorRoaderFile.RuningTask(editor, _fab, _path, proanjctor);
  }

  public void setClosetab(int _position, final ArrayList<HashMap<String, Object>> _data) {
    if (FileUtil.isExistFile(_data.get(_position).get("path").toString())) {
      _data.remove((_position));
      if (_data.isEmpty()) {
        editor.setText("");
        _data.clear();
        shp.edit().remove("pos_path").apply();
        shp.edit().remove("path").apply();
        n = 0;
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

  public void _Anim(final View setCodeEditorFileReader) {
    android.view.animation.Animation animation = new android.view.animation.AlphaAnimation(0, 1);
    animation.setDuration(300);
    setCodeEditorFileReader.setAnimation(animation);
  }

  public void _Bounce(final View _view) {
    AnimUtils.Bounce(_view);
  }

  public void _Anim01(final View _view) {
    AnimUtils.Amin01(_view);
  }

  public void _Animwork(final View _view) {
    AnimUtils.Worker(_view);
  }

  public void _Anim04(final View _view) {
    AnimUtils.Amin04(_view, this);
  }

  public void ClickItemChildAnimation(View view) {
    var fade_in =
        new ScaleAnimation(
            0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
    fade_in.setDuration(300);
    fade_in.setFillAfter(true);
    view.startAnimation(fade_in);
  }

  public void ReloadFileInPos() {
    if (shp.contains("path")) {
      if (!shp.getString("path", "").equals("")) {
        tabs_listmap =
            new Gson()
                .fromJson(
                    shp.getString("path", ""),
                    new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
        recyclerview1.setAdapter(new Recyclerview1Adapter(tabs_listmap));
        recyclerview1.setLayoutManager(
            new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
      }
    }
    if (FileUtil.isExistFile(shp.getString("pos_path", ""))) {
      setCodeEditorFileReader(shp.getString("pos_path", ""));
      ((LinearLayoutManager) recyclerview1.getLayoutManager())
          .scrollToPositionWithOffset(
              (int) Math.floor(Double.parseDouble(shp.getString("positionTabs", ""))), 0);
    }
  }

  public void setSymbols(String input) {
    var channel = editor.createNewSymbolChannel();
    channel.insertSymbol(input, input.length());
  }

  public void _tabsize(final double _tab) {
    editor.setTabWidth((int) _tab);
  }

  public void setFontEditorFromFile(final String _files) {
    editor.setTypefaceText(Typeface.createFromFile(new File(_files)));
    editor.setTypefaceLineNumber(Typeface.createFromFile(new File(_files)));
  }

  @Deprecated
  public void setLiveShowFragment() {}

  public void Symbloinit() {
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

  public void setCloseall() {
    tabs_listmap.clear();
    shp.edit().remove("pos_path").apply();
    shp.edit().remove("positionTabs").apply();
    recyclerview1.getAdapter().notifyDataSetChanged();
    shp.edit().putString("path", new Gson().toJson(tabs_listmap)).apply();
    FileUtil.deleteFile("/storage/emulated/0/GhostWebIDE/ninjacoder/openFile.json");
    finish();
  }

  public void setCloseother() {
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
    recyclerview1.getAdapter().notifyDataSetChanged();
  }

  public void setPowerMenuCallBack(
      final View _v, final ArrayList<HashMap<String, Object>> _map, int _pos) {
    itemPosRemoved = _pos;

    mmenuitempos =
        new PowerMenu.Builder(CodeEditorActivity.this)
            .addItem(new PowerMenuItem("close this"))
            .addItem(new PowerMenuItem("close other"))
            .addItem(new PowerMenuItem("close all"))
            .setIsMaterial(true)
            .build();
    mmenuitempos.setAnimation(MenuAnimation.ELASTIC_CENTER);
    mmenuitempos.setMenuRadius(30f);
    mmenuitempos.setShowBackground(false);
    mmenuitempos.setSelectedEffect(true);
    mmenuitempos.setAutoDismiss(false);
    mmenuitempos.showAsDropDown(_v);

    mmenuitempos.setTextTypeface(
        Typeface.create(
            Typeface.createFromAsset(getAssets(), "fonts/ghostfont.ttf"), Typeface.NORMAL));
    if (ru.contains("rup")) {
      mmenuitempos.setMenuColor(0xFF2B2121);
      mmenuitempos.setTextColor(0xFFEEEEEE);
      mmenuitempos.setDivider(new ColorDrawable(0xFFEEEEEE));
    } else {
      if (imap.containsKey("menubackground")) {
        mmenuitempos.setMenuColor(Color.parseColor(imap.get("menubackground").toString()));
      } else {
        mmenuitempos.setMenuColor(0xFF2B2121);
      }
      if (imap.containsKey("imagecolor")) {
        mmenuitempos.setDivider(
            new ColorDrawable(Color.parseColor(imap.get("imagecolor").toString())));
      } else {
        mmenuitempos.setDivider(new ColorDrawable(0xFFEEEEEE));
      }
      if (imap.containsKey("text_normal")) {
        mmenuitempos.setTextColor(Color.parseColor(imap.get("text_normal").toString()));
      } else {
        mmenuitempos.setTextColor(0xFFEEEEEE);
      }
    }
    mmenuitempos.setOnMenuItemClickListener(
        new OnMenuItemClickListener<PowerMenuItem>() {
          @Override
          public void onItemClick(int position, PowerMenuItem item) {
            switch (position) {
              case 0:
                {
                  setClosetab(_pos, _map);
                  recyclerview1.getAdapter().notifyDataSetChanged();
                  click2var = 0;
                  n = 0;
                  setDistreeView();
                  tabPos = 0;
                  mmenuitempos.dismiss();
                  break;
                }
              case 1:
                {
                  setCloseother();
                  recyclerview1.getAdapter().notifyItemRemoved((int) itemPosRemoved);
                  click2var = 0;
                  setDistreeView();
                  tabPos = 0;
                  mmenuitempos.dismiss();
                  break;
                }
              case 2:
                {
                  setCloseall();
                  recyclerview1.getAdapter().notifyItemRemoved((int) itemPosRemoved);
                  click2var = 0;
                  setDistreeView();
                  tabPos = 0;
                  mmenuitempos.dismiss();
                  break;
                }
            }
          }
        });
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

  public void setDistreeView() {
    List<String> pospath = spiltIntoBreadcrumbItems(shp.getString("pos_path", ""));

    var adps =
        new ToolbarListFileAdapter(
            pospath,
            this,
            new ToolbarListFileAdapter.CallBack() {

              @Override
              public void GoToDir(View view) {
                // LongClick
              }

              @Override
              public void GoToTreeFile(View view) {
                // onClick
              }
            });

    dir.setAdapter(adps);
    dir.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    dir.smoothScrollToPosition(pospath.size());
  }

  public void FabFileRuner() {
    try {
      try {
        if (shp.contains("pos_path")) {
          if (!shp.getString("pos_path", "").equals("")) {
            FileUtil.writeFile(shp.getString("pos_path", ""), editor.getText().toString());

          } else {

          }
        }
      } catch (Exception e) {
        DataUtil.showMessage(getApplicationContext(), e.toString());
      }

      if (shp.getString("pos_path", "").contains(".html")) {
        if (ru.getBoolean("live", false) == true) {
          var it =
              new CompilerUtils(shp.getString("pos_path", ""), Mode.WEB, CodeEditorActivity.this);
        } else {
          htmlrus.setClass(getApplicationContext(), HtmlRunerActivity.class);
          htmlrus.putExtra("run", shp.getString("pos_path", ""));
          htmlrus.putExtra("runs", Uri.parse(shp.getString("pos_path", "")).getLastPathSegment());
          File file = new File(shp.getString("pos_path", ""));
          if (file.exists()) {
            String phpz = file.getParent();
            htmlrus.putExtra("root", phpz);
            Toast.makeText(getApplicationContext(), phpz, Toast.LENGTH_SHORT).show();
          }

          startActivity(htmlrus);
        }
      } else {
        if (shp.getString("pos_path", "").contains(".json")) {
          jsonview.setClass(getApplicationContext(), JsonViewerActivity.class);
          jsonview.putExtra("g", editor.getText().toString());
          startActivity(jsonview);

        } else {
          if (shp.getString("pos_path", "").contains(".js")) {
            getmd.setClass(getApplicationContext(), JsRunerActivity.class);
            getmd.putExtra("sendCode", editor.getText().toString().trim());
            startActivity(getmd);
          } else {
            if (shp.getString("pos_path", "").contains(".sh")) {
              res.setClass(getApplicationContext(), ShellCodeActivity.class);
              res.putExtra("sh", editor.getText().toString().trim());
              startActivity(res);
            } else {
              if (shp.getString("pos_path", "").contains(".svg")) {
                htmlrus.setClass(getApplicationContext(), HtmlRunerActivity.class);
                htmlrus.putExtra("run", shp.getString("pos_path", ""));
                startActivity(htmlrus);
              } else {
                if (shp.getString("pos_path", "").contains(".md")) {
                  getmd.setClass(getApplicationContext(), MdCodeViewActivity.class);
                  getmd.putExtra("v", shp.getString("pos_path", ""));
                  startActivity(getmd);
                } else {
                  if (shp.getString("pos_path", "").contains(".notDpr")) {
                    getmd.setClass(getApplicationContext(), TerminalActivity.class);
                    getmd.putExtra("pathCpp", shp.getString("pos_path", ""));
                    startActivity(getmd);
                  } else {
                    if (shp.getString("pos_path", "").contains(".py")) {
                      getmd.setClass(getApplicationContext(), TerminalActivity.class);
                      getmd.putExtra("path", shp.getString("pos_path", ""));
                      startActivity(getmd);
                    } else {
                      if (shp.getString("pos_path", "").contains(".g4")) {
                        setAntlr4Compiler();

                      } else {
                        if (shp.getString("pos_path", "").contains(".php")) {
                          getmd.setClass(getApplicationContext(), TerminalActivity.class);
                          getmd.putExtra("phpcode", shp.getString("pos_path", ""));
                          startActivity(getmd);
                        } else if (shp.getString("pos_path", "").contains(".scss")
                            || shp.getString("pos_path", "").contains(".sass")) {

                          SassForAndroid.run(
                              CodeEditorActivity.this,
                              shp.getString("pos_path", ""),
                              shp.getString("pos_path", ""));

                        } else if (shp.getString("pos_path", "").contains(".java")) {

                          JavaCompilerBeta.run(
                              CodeEditorActivity.this, editor.getText().toString());
                        } else if (shp.getString("pos_path", "").contains(".xml")) {
                          XmlLayoutDesignActivity.show(
                              CodeEditorActivity.this,
                              "xml",
                              shp.getString("pos_path", ""),
                              false,
                              false);
                        } else if (shp.getString("pos_path", "").contains(".jj")) {
                          var file = new File(shp.getString("pos_path", ""));
                          JavaCcComplierImpl.main(file.toString(), file.getParent() + "/");
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    } catch (Exception ex) {
    }
  }

  public void setAllSaveFile(final View _v) {

    try {
      if ((_v instanceof ViewGroup viewGroup)) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
          View child = viewGroup.getChildAt(i);
          setAllSaveFile(child);
        }
      } else {
        if ((_v instanceof CodeEditor)) {
          if (_v != null) {
            try {
              if (shp.contains("pos_path")) {
                if (!shp.getString("pos_path", "").equals("")) {
                  FileUtil.writeFile(
                      shp.getString("pos_path", ""), ((CodeEditor) _v).getText().toString());
                } else {
                  DataUtil.showMessage(getApplicationContext(), "Error not File saved!");
                }
              }
            } catch (Exception e) {
              DataUtil.showMessage(getApplicationContext(), "Error not File saved!");
            }
          }

        } else {
          throw new RuntimeException("CanYouAdd CodeEditor??");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void setAntlr4Compiler() {
    final var bottomSheetDialog = new BottomSheetDialog(this);

    Antcomp8lerBinding bind = Antcomp8lerBinding.inflate(getLayoutInflater());
    bottomSheetDialog.setContentView(bind.getRoot());
    File file = new File(shp.getString("pos_path", ""));
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

  public void setWallpaperParallaxEffect() {

    effect = new WallpaperParallaxEffect(this);
    effect.setCallback(
        new WallpaperParallaxEffect.Callback() {
          @Override
          public void onOffsetsChanged(int offsetX, int offsetY, float angle) {
            float progress = 1.0f;
            Coordinator.setTranslationX(offsetX * progress);
            Coordinator.setTranslationY(offsetY * progress);
          }
        });

    effect.setEnabled(thememanagersoft.contains("effect"));
  }

  public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {

    private ArrayList<HashMap<String, Object>> _data;
    private int currentTabIndex = 0;
    private String dataChange = "";

    public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
      _data = _arr;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater _inflater = getLayoutInflater();
      View _v = _inflater.inflate(R.layout.newlist, null);
      RecyclerView.LayoutParams _lp =
          new RecyclerView.LayoutParams(
              ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
      _v.setLayoutParams(_lp);
      return new ViewHolder(_v);
    }

    @Override
    public void onBindViewHolder(
        ViewHolder _holder, @SuppressLint("RecyclerView") final int _position) {
      View _view = _holder.itemView;
       LinearLayout linear1 = _view.findViewById(R.id.linear1);
       LinearLayout linear5 = _view.findViewById(R.id.linear5);
       LinearLayout selector = _view.findViewById(R.id.selector);
       ImageView imageview2 = _view.findViewById(R.id.imageview2);
       TextView textview1 = _view.findViewById(R.id.textview1);
      pos10 = _position;
      RecyclerView.LayoutParams _lp =
          new RecyclerView.LayoutParams(
              ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
      _view.setLayoutParams(_lp);
      var pathFileindir = _data.get(_position).get("path").toString();
      dataChange = Uri.parse(_data.get(_position).get("path").toString()).getLastPathSegment();

      if (_data.isEmpty()) {
      } else {
        var ideColors = new IdeColorCompat(editor);

        ideColors.setIconLang(pathFileindir, imageview2);
        ShapeUtils shap = new ShapeUtils();
        int colorTab =
            imap.containsKey("tabback")
                ? Color.parseColor(imap.get("tabback").toString())
                : Color.parseColor("#1C1C1C");
        int colorTabText =
            imap.containsKey("displaytextcolortab")
                ? Color.parseColor(imap.get("displaytextcolortab").toString())
                : Color.parseColor("#1C1C1C");

        textview1.setTextColor(colorTabText);
        selector.setBackground(shap.getCustomShape(colorTab, ShapeName.LINEROUND));
        textview1.setText(dataChange);

        if (FileUtil.isDirectory(pathFileindir)) {

        } else if (FileUtil.isExistFile(_data.get(_position).get("path").toString())) {

        } else {
          textview1.setText(
              "FileNotFound*"
                  .concat(
                      Uri.parse(_data.get(_position).get("path").toString()).getLastPathSegment()));
        }

        if (_data.get(_position).get("path").toString().equals(shp.getString("pos_path", ""))) {

          selector.setVisibility(View.VISIBLE);
          setDistreeView();
          ClickItemChildAnimation(editor);
          n = 0;
        } else {
          selector.setVisibility(View.GONE);
          n = 0;
          setDistreeView();
          ClickItemChildAnimation(editor);
        }
        linear5.setOnClickListener(
            v -> {
              var dataInsert = _data.get(_position).get("path").toString();

              // Single tap here.
              if (FileUtil.isExistFile(dataInsert)) {

                shp.edit().putString("positionTabs", String.valueOf((long) (_position))).apply();
                shp.edit().putString("pos_path", dataInsert).apply();
                setDistreeView();
                notifyDataSetChanged();
                if (FileUtil.isExistFile(dataInsert)) {
                  setCodeEditorFileReader(dataInsert);

                  if (dataInsert.equals(shp.getString("pos_path", ""))) {
                    selector.setVisibility(View.VISIBLE);

                    if (currentTabIndex == _position) {
                      setPowerMenuCallBack(linear5, _data, _position);
                    } else {
                      currentTabIndex = _position;
                      setCodeEditorFileReader(dataInsert);
                    }

                    //  DataUtil.showMessage(v.getContext(), String.valueOf(_position));

                  } else {
                    selector.setVisibility(View.GONE);
                    setDistreeView();
                  }
                } else {
                  selector.setVisibility(View.GONE);
                }

              } else {
                var di = new MaterialAlertDialogBuilder(CodeEditorActivity.this);
                di.setTitle("File not Found!");
                di.setCancelable(false);
                di.setNeutralButton(
                    "Romved!",
                    (p, d) -> {
                      setClosetab(_position, _data);
                      setDistreeView();
                      notifyItemRemoved(_position);
                    });
                di.show();
              }
            });
        shp.edit().putString("path", new Gson().toJson(_data)).apply();
      }
      _Anim(selector);
    }

    @Override
    public int getItemCount() {
      return _data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      public ViewHolder(View v) {
        super(v);
      }
    }
  }

  @Override
  public boolean onKeyDown(int data, KeyEvent key) {
    // TODO: Implement this method
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
