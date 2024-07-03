package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.G4Compiler;
import Ninja.coder.Ghostemane.code.IdeEditor;
import Ninja.coder.Ghostemane.code.PluginManager.flashbar.FlashBarUtils;
import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.RequestNetwork;
import Ninja.coder.Ghostemane.code.adapter.SyspiarAdapter;
import Ninja.coder.Ghostemane.code.adapter.ToolbarListFileAdapter;
import Ninja.coder.Ghostemane.code.config.CommonFactoryData;
import Ninja.coder.Ghostemane.code.databinding.Antcomp8lerBinding;
import Ninja.coder.Ghostemane.code.layoutmanager.LogCatBottomSheet;
import Ninja.coder.Ghostemane.code.marco.ColorView;
import Ninja.coder.Ghostemane.code.marco.GhostWebEditorSearch;
import Ninja.coder.Ghostemane.code.marco.NinjaMacroFileUtil;
import Ninja.coder.Ghostemane.code.marco.WallpaperParallaxEffect;
import Ninja.coder.Ghostemane.code.marco.ideColors.IdeColorCompat;
import Ninja.coder.Ghostemane.code.navigator.EditorHelperColor;
import Ninja.coder.Ghostemane.code.project.JavaCompilerBeta;
import Ninja.coder.Ghostemane.code.project.ProjectManager;
import Ninja.coder.Ghostemane.code.tasks.app.SassForAndroid;
import Ninja.coder.Ghostemane.code.terminal.TerminalActivity;
import Ninja.coder.Ghostemane.code.utils.*;
import Ninja.coder.Ghostemane.code.widget.BlurImage;
import Ninja.coder.Ghostemane.code.widget.ExrtaFab;
import Ninja.coder.Ghostemane.code.widget.GhostWebMaterialDialog;
import Ninja.coder.Ghostemane.code.widget.PraramnetLayoutNinja;
import android.Manifest;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.*;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
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
import com.sdsmdg.harjot.vectormaster.VectorMasterView;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.text.Content;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeEditorActivity extends AppCompatActivity {

  public static String POSTMANPATH = "";

  private static final String EDITOR_LEFT_LINE_KEY = "line";
  private static final String EDITOR_LEFT_COLUMN_KEY = "column";
  private static final String EDITOR_RIGHT_LINE_KEY = "rightLine";
  private static final String EDITOR_RIGHT_COLUMN_KEY = "rightColumn";
  public final int REQ_CD_SETPASZAMINE = 101;
  protected Sound sound;
  protected EditorAutoCompleteWindow window;
  protected ExrtaFab _fab; // /By ninja coder big man main
  private final Timer _timer = new Timer();
  private WallpaperParallaxEffect effect;
  private CoordinatorLayout _coordinator;
  private String currentWord = "";
  private HashMap<String, Object> imap = new HashMap<>();
  private double n = 0;
  private boolean home = false;
  private final String code = "";
  private double click2var = 0;
  private double pos10 = 0;

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

  private final ArrayList<HashMap<String, Object>> dexter = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> tabs_listmap = new ArrayList<>();
  private final ArrayList<String> indifier = new ArrayList<>();
  private final ArrayList<HashMap<String, Object>> tags = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> staticSymbiolPiare = new ArrayList<>();
  private final ArrayList<String> string = new ArrayList<>();
  private final ArrayList<HashMap<String, Object>> map = new ArrayList<>();
  private final ArrayList<HashMap<String, Object>> treeviewmap = new ArrayList<>();
  private final ArrayList<String> hsistr3000 = new ArrayList<>();
  private final ArrayList<HashMap<String, Object>> hsimap3000 = new ArrayList<>();
  private final ArrayList<String> list = new ArrayList<>();
  private final ArrayList<String> folderList = new ArrayList<>();
  private final ArrayList<String> fileList = new ArrayList<>();
  private final ArrayList<HashMap<String, Object>> files = new ArrayList<>();
  private PraramnetLayoutNinja Mainlinear;
  private LinearLayout multytab;
  private FrameLayout FrameLayout01;
  private LinearLayout newLayoutSymbolBar;
  private LinearLayout CustomToolbar;
  private ProgressBar progressbar1;

  private RecyclerView recyclerview1;
  private RecyclerView dir;
  private LinearLayout divar;
  private LinearLayout linear1;
  private LinearLayout linear2;
  private BadgeView badgeview3;
  private TextView tvtitle;
  private TextView typeVl;
  private ImageView image;
  private ImageView redo;
  private ImageView undo;
  private ImageView menupopnew;
  private IdeEditor editor;
  private LinearLayout FrameLayout02;
  private LinearLayout linear3;
  private ProgressBar proanjctor;
  private LinearLayout barSymoble;
  private LinearLayout linear5;
  private ImageView imageview1;
  private LinearLayout linear6;

  private LinearLayout divardown;
  private RecyclerView syspiar;

  private final Intent intentaddFile = new Intent();
  private final Intent htmlrus = new Intent();
  private SharedPreferences word;
  private SharedPreferences line;
  private SharedPreferences shp;
  private SharedPreferences qo;
  private RequestNetwork constreust;
  private RequestNetwork.RequestListener _constreust_request_listener;
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
  private SharedPreferences kos;
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

  private SharedPreferences shSizePx;
  private PowerMenu jelper;
  private SharedPreferences t;
  private SharedPreferences thememanagersoft;
  private SharedPreferences sf;
  private LiveViewerDialogFragmentActivity liveViewerDialogFragmentActivityN;
  private FragmentManager LiveviewebDialogFragmentActivityFM;
  private GhostWebEditorSearch ghost_searchs;
  private int tabPos = -1;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.codeeditor);
    initialize(_savedInstanceState);

    if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_DENIED
        || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_DENIED) {
      ActivityCompat.requestPermissions(
          this,
          new String[] {
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
          },
          1000);
    } else {
      initializeLogic();
    }
  }

  @Override
  public void onRequestPermissionsResult(
      int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == 1000) {
      initializeLogic();
    }
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

    _coordinator = findViewById(R.id._coordinator);
    _fab = findViewById(R.id._fab);
    _coordinator = findViewById(R.id._coordinator);
    Mainlinear = findViewById(R.id.Mainlinear);
    multytab = findViewById(R.id.multytab);
    FrameLayout01 = findViewById(R.id.FrameLayout01);
    newLayoutSymbolBar = findViewById(R.id.newLayoutSymbolBar);
    CustomToolbar = findViewById(R.id.CustomToolbar);
    progressbar1 = findViewById(R.id.progressbar1);

    recyclerview1 = findViewById(R.id.recyclerview1);
    dir = findViewById(R.id.dir);
    divar = findViewById(R.id.divar);

    linear1 = findViewById(R.id.linear1);
    linear2 = findViewById(R.id.linear2);
    badgeview3 = findViewById(R.id.badgeview3);
    tvtitle = findViewById(R.id.tvtitle);
    typeVl = findViewById(R.id.typeVl);
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
    constreust = new RequestNetwork(this);
    myDialog = new AlertDialog.Builder(this);
    di = new AlertDialog.Builder(this);
    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    getvb = getSharedPreferences("getvb", Activity.MODE_PRIVATE);
    re = getSharedPreferences("re", Activity.MODE_PRIVATE);
    war = getSharedPreferences("war", Activity.MODE_PRIVATE);
    kos = getSharedPreferences("kos", Activity.MODE_PRIVATE);
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
    ghost_searchs.bindEditor(editor);
    ghost_searchs.setCallBack(
        new GhostWebEditorSearch.onViewChange() {

          @Override
          public void onViewShow() {
            if (_fab.isShow()) {
              _fab.hide();
            }
          }

          @Override
          public void onViewHide() {
            if (_fab.isHide()) {
              _fab.show();
            }
          }
        });

    image.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            if (ic == 1) {
              image.setImageResource(R.drawable.noeye);
              editor.setEditable(false);
              ic--;
            } else {
              editor.setEditable(true);
              image.setImageResource(R.drawable.okeye);
              ic++;
            }
          }
        });

    redo.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            editor.AutoRedo();
          }
        });

    undo.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            editor.AutoUndo();
          }
        });

    menupopnew.setOnClickListener(
        (___) -> {
          _managerpanel(menupopnew);
        });

    imageview1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            barSymoble.setVisibility(View.GONE);
            _fab.setVisibility(View.VISIBLE);
          }
        });

    _fab.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            FabFileRuner();
          }
        });

    _constreust_request_listener =
        new RequestNetwork.RequestListener() {
          @Override
          public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
            final String _tag = _param1;
            final String _response = _param2;
            final HashMap<String, Object> _responseHeaders = _param3;
          }

          @Override
          public void onErrorResponse(String _param1, String _param2) {
            final String _tag = _param1;
            final String _message = _param2;
          }
        };
  }

  private void initializeLogic() {
    proanjctor.setVisibility(View.GONE);
    barSymoble.setVisibility(View.VISIBLE);
    _vi();
    POSTMANPATH = shp.getString("pos_path", "");
    _fab.shrink();
    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ab);
    animation.start();
    editor.setAnimation(animation);
    editor.setFadein();
    soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
    n1 = soundPool.load(getApplicationContext(), R.raw.typenormal, 1);
    n2 = soundPool.load(getApplicationContext(), R.raw.typeremoved, 1);
    n3 = soundPool.load(getApplicationContext(), R.raw.ddoc, 1);
    n4 = soundPool.load(getApplicationContext(), R.raw.typespace, 1);
    editor.setLnTip("L->");
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

    var editorHelperColor = new EditorHelperColor(editor, badgeview3);
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
            Toast.makeText(getApplicationContext(), "This Tab", Toast.LENGTH_SHORT).show();
          }

          @Override
          public void Space() {
            Toast.makeText(getApplicationContext(), "This Space", Toast.LENGTH_SHORT).show();
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

    var projectz = new ProjectManager();
    projectz.setProjectName(getIntent().getStringExtra("root"));
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
    if (FileUtil.isExistFile(pss.getString("getWallpaparSazen1000", ""))) {
      BlurImage.Start(
          getWindow().getDecorView(),
          CodeEditorActivity.this,
          pss.getString("getWallpaparSazen1000", ""),
          thememanagersoft.contains("br") ? thememanagersoft.getFloat("br", 2) : 3);
    } else {
      if (imap.containsKey("BackgroundColorLinear")) {
        getWindow()
            .getDecorView()
            .setBackgroundColor(Color.parseColor(imap.get("BackgroundColorLinear").toString()));
      } else {
        getWindow().getDecorView().setBackgroundColor(0xFF2B2120);
      }
    }
    Symbloinit();
    ReloadFileInPos();
    if (shp.contains("pos_path")) {
      if (!shp.getString("pos_path", "").equals("")) {
        _codeEditor(shp.getString("pos_path", ""));
      }
    }
    FileUtil.writeFile(
        "/storage/emulated/0/GhostWebIDE/ninjacoder/openFile.json", shp.getString("path", ""));

    progressbar1.setVisibility(View.GONE);

    badgeview3.setBadgeBackground(Color.TRANSPARENT);
    badgeview3.setBadgeCount("");
    _EditorSummery();
    imap = new HashMap<>();

    if (FileUtil.isExistFile(thememanagersoft.getString("themes", ""))) {
      if (thememanagersoft.contains("themes")) {
        imap =
            new Gson()
                .fromJson(
                    FileUtil.readFile(thememanagersoft.getString("themes", "")),
                    new TypeToken<HashMap<String, Object>>() {}.getType());
      } else {
        if (FileUtil.isExistFile("storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost")) {
          imap =
              new Gson()
                  .fromJson(
                      FileUtil.readFile("storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost"),
                      new TypeToken<HashMap<String, Object>>() {}.getType());
        } else {
          imap =
              new Gson()
                  .fromJson(
                      "{\n  \"ToolbarTextColor\": \"#ffff1750\",\n  \"BLOCK_LINE_CURRENT\": \"#ff28ffae\",\n  \"LINE_DIVIDER\": \"#1d000000\",\n  \"SyombolBarTextColor\": \"#ffff005b\",\n  \"HTML_TAG\": \"#ff1bffdd\",\n  \"FabColorStroker\": \"#ffc9ffd0\",\n  \"LINE_NUMBER\": \"#ff0dedff\",\n  \"KEYWORD\": \"#ff00d9ff\",\n  \"AUTO_COMP_PANEL_CORNER\": \"#ffffa1af\",\n  \"SELECTION_HANDLE\": \"#ff2a6373\",\n  \"TabImageColorFilter\": \"#ffbcffff\",\n  \"AUTO_COMP_PANEL_BG\": \"#ff0b1a32\",\n  \"COMMENT\": \"#626262\",\n  \"ToolbarColor\": \"#ff050d19\",\n  \"IDENTIFIER_NAME\": \"#fff0be4b\",\n  \"DisplayTextColorTab\": \"#fffad7ff\",\n  \"NON_PRINTABLE_CHAR\": \"#ff6b90ff\",\n  \"SELECTION_INSERT\": \"#ff2a6373\",\n  \"Ninja\": \"#ffddaeff\",\n  \"TEXTCOLORHDER\": \"#ff522012\",\n  \"TabTextColor\": \"#ffc9eaff\",\n  \"BLOCK_LINE\": \"#ff5effaa\",\n  \"MenuBackground\": \"#ff0a1320\",\n  \"LITERAL\": \"#ffbcf5ff\",\n  \"FabBackgroundColorColor\": \"#ff021020\",\n  \"ATTRIBUTE_VALUE\": \"#ffa6ffa1\",\n  \"TabBack\": \"#ff1e5e71\",\n  \"TEXTCOLORFORGRAND\": \"#424242\",\n  \"ImageColor\": \"#ffa1f1ff\",\n  \"TEXT_NORMAL\": \"#ffffffff\",\n  \"ATTRIBUTE_NAME\": \"#ffa1e3ff\",\n  \"print\": \"#ffecffa1\",\n  \"OPERATOR\": \"#ff43ffd5\",\n  \"CURRENT_LINE\": \"#20171717\",\n  \"WHOLE_BACKGROUND\": \"#02FFFFFF\",\n  \"BackgroundColorLinear\": \"#ff050d19\",\n  \"FabImageColor\": \"#ffbce1ff\",\n  \"LINE_NUMBER_BACKGROUND\": \"#00FFFFFF\",\n  \"TEXTCOLORIGOR\": \"#ff500001\",\n  \"TEXTCOLORINIER\": \"#ff402811\"\n}",
                      new TypeToken<HashMap<String, Object>>() {}.getType());
        }
      }
    } else {
      imap =
          new Gson()
              .fromJson(
                  FileUtil.readFile("storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost"),
                  new TypeToken<HashMap<String, Object>>() {}.getType());
    }

    getWindow()
        .setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    _coderuner();

    editor.setLineNumberAlign(Paint.Align.CENTER);

    SetThemeForJson themeForJson2 = new SetThemeForJson();
    themeForJson2.setThemeCodeEditor(editor, imap, false, this);
    themeForJson2.addTextColor(
        tvtitle, "SyombolBarTextColor", Color.parseColor("#FFFFA0FB"), this, imap);
    themeForJson2.addTextColor(
        typeVl, "SyombolBarTextColor", Color.parseColor("#FFFFA0FB"), this, imap);
    themeForJson2.AddthemetoSattos(this, imap);
    themeForJson2.addBackground(this, imap, "ToolbarColor", CustomToolbar, 0xFF281B26);
    themeForJson2.addBackground(this, imap, "BackgroundColorLinear", Mainlinear, 0xFF281B26);
    themeForJson2.addBackground(this, imap, "TabImageColorFilter", divar, Color.RED);
    themeForJson2.addBackground(this, imap, "TabImageColorFilter", divardown, Color.RED);
    // divardown
    themeForJson2.addImageColor(undo, this, "ImageColor", imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.addImageColor(redo, this, "ImageColor", imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.addImageColor(image, this, "ImageColor", imap, Color.parseColor("#ff94e7ff"));

    themeForJson2.addImageColor(
        menupopnew, this, "ImageColor", imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.mfabcolor(this, _fab, imap);
    themeForJson2.mfab2(this, _fab, imap);
    AnimUtils.ClickAnimation(menupopnew);

    AnimUtils.ClickAnimation(undo);
    AnimUtils.ClickAnimation(redo);
    if (ru.contains("rup")) {

      ///   MapObjectData.setMatetialThemeCodeEditor(editor);
      ColorAndroid12.tryToRunThemeMaterial(editor);
      CustomToolbar.setBackgroundColor(0xFF201B16);
      Mainlinear.setBackgroundColor(0xFF201B16);
      redo.setColorFilter(0xFFFFDCBD, PorterDuff.Mode.MULTIPLY);
      undo.setColorFilter(0xFFFFDCBD, PorterDuff.Mode.MULTIPLY);
      menupopnew.setColorFilter(0xFFEEEEEE, PorterDuff.Mode.MULTIPLY);
      image.setColorFilter(0xFFFFB689, PorterDuff.Mode.MULTIPLY);
      tvtitle.setTextColor(0xFFFDA893);
      typeVl.setTextColor(0xFFFDA893);
      _fab.setBackgroundTintList(ColorStateList.valueOf(0xFF2B2122));
      _fab.setStrokeColor(ColorStateList.valueOf(0xFFFDB69A));
      _fab.setStrokeWidth(1);
      _fab.setIconTint(ColorStateList.valueOf(0xFFFDB69A));
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
    tvtitle.setText("GWI");
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
        tvtitle.setTypeface(
            Typeface.createFromAsset(getAssets(), "fonts/ghostfont.ttf"), Typeface.NORMAL);
        typeVl.setTypeface(
            Typeface.createFromAsset(getAssets(), "fonts/ghostfont.ttf"), Typeface.NORMAL);

      } else {
        _editorsetfontfromfile(setfont.getString("mfont", ""));
        tvtitle.setTypeface(Typeface.createFromFile(new File(setfont.getString("mfont", ""))));
        typeVl.setTypeface(Typeface.createFromFile(new File(setfont.getString("mfont", ""))));
      }
    } else {
      editor.setTypefaceText(Typeface.createFromAsset(getAssets(), "ghostfont.ttf"));
      editor.setTypefaceLineNumber(Typeface.createFromAsset(getAssets(), "ghostfont.ttf"));
      tvtitle.setTypeface(
          Typeface.createFromAsset(getAssets(), "fonts/ghostfont.ttf"), Typeface.NORMAL);
      typeVl.setTypeface(
          Typeface.createFromAsset(getAssets(), "fonts/ghostfont.ttf"), Typeface.NORMAL);
    }
    editor.setAutoCompletionEnabled(!auto.contains("mauto"));
    _fab.setIconResource(R.drawable.play);
    home = true;
    if (getinitdir.contains("mdir")) {
      if (getinitdir.getString("mdir", "").equals("true")) {
        dir.setVisibility(View.GONE);
      } else {
        dir.setVisibility(View.VISIBLE);
      }
    }
    if (imap.containsKey("TabBack")) {
      if (Build.VERSION.SDK_INT >= 21) {
        proanjctor
            .getIndeterminateDrawable()
            .setColorFilter(
                Color.parseColor(imap.get("TabBack").toString()), PorterDuff.Mode.SRC_IN);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        progressbar1
            .getIndeterminateDrawable()
            .setColorFilter(
                Color.parseColor(imap.get("TabBack").toString()), PorterDuff.Mode.SRC_IN);
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
      if (imap.containsKey("BackgroundColorLinear")) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
          Window ninjacoder = this.getWindow();
          ninjacoder.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
          ninjacoder.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

          ninjacoder.setStatusBarColor(
              Color.parseColor(imap.get("BackgroundColorLinear").toString()));
          ninjacoder.setNavigationBarColor(
              Color.parseColor(imap.get("BackgroundColorLinear").toString()));
        }
      } else {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
          Window ninjacoder = this.getWindow();
          ninjacoder.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
          ninjacoder.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

          ninjacoder.setStatusBarColor(Color.parseColor("#FF2B2122"));
          ninjacoder.setNavigationBarColor(Color.parseColor("#FF2B2122"));
        }
      }
    }
  }

  @Override
  protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
    super.onActivityResult(_requestCode, _resultCode, _data);

    switch (_requestCode) {
      case REQ_CD_SETPASZAMINE:
        if (_resultCode == Activity.RESULT_OK) {
          ArrayList<String> _filePath = new ArrayList<>();
          if (_data != null) {
            if (_data.getClipData() != null) {
              for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
                ClipData.Item _item = _data.getClipData().getItemAt(_index);
                _filePath.add(
                    FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
              }
            } else {
              _filePath.add(
                  FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
            }
          }
          if (_filePath.get(0).endsWith(".jpeg")
              || (_filePath.get(0).endsWith(".jpg")
                  || (_filePath.get(0).endsWith(".png")
                      || (_filePath.get(0).endsWith(".webp")
                          || _filePath.get(0).endsWith(".mp4"))))) {
            pss.edit().putString("getWallpaparSazen1000", _filePath.get(0)).apply();
            BlurImage.Start(
                getWindow().getDecorView(),
                CodeEditorActivity.this,
                pss.getString("getWallpaparSazen1000", ""),
                thememanagersoft.contains("br") ? thememanagersoft.getFloat("br", 2) : 3);
          } else {
            var dialogpost = new MaterialAlertDialogBuilder(CodeEditorActivity.this);
            dialogpost.setTitle("Error!");
            dialogpost.setMessage("Please Set in Format(png,jpeg,jpg)");
            dialogpost.setPositiveButton("ok", (mp1, md2) -> {});
            androidx.appcompat.app.AlertDialog dialogJanator = dialogpost.show();
            final View setview = dialogJanator.getWindow().getDecorView();
            setview.setScaleX(0f);
            setview.setScaleY(0f);
            final ObjectAnimator alertAnim = new ObjectAnimator();
            final ObjectAnimator alertAnim1 = new ObjectAnimator();
            alertAnim.setTarget(setview);
            alertAnim.setPropertyName("scaleX");
            alertAnim.setFloatValues((float) (1));
            alertAnim.setDuration(250);
            alertAnim.start();
            alertAnim1.setTarget(setview);
            alertAnim1.setPropertyName("scaleY");
            alertAnim1.setFloatValues((float) (1));
            alertAnim1.setDuration(250);
            alertAnim1.start();
            dialogJanator.show();
          }
        } else {
          var di = new GhostWebMaterialDialog(CodeEditorActivity.this);
          di.setTitle("Error");
          di.setMessage("Not Image Set From Wallpaper ");
          di.setNeutralButton("ok", (p, d) -> {});

          di.show();
        }
        break;
      default:
        break;
    }
  }

  private void restoreState(@NonNull Bundle savedInstanceState) {
    int leftLine = savedInstanceState.getInt(EDITOR_LEFT_LINE_KEY, 0);
    int leftColumn = savedInstanceState.getInt(EDITOR_LEFT_COLUMN_KEY, 0);
    int rightLine = savedInstanceState.getInt(EDITOR_RIGHT_LINE_KEY, 0);
    int rightColumn = savedInstanceState.getInt(EDITOR_RIGHT_COLUMN_KEY, 0);

    Content text = editor.getText();
    if (leftLine > text.getLineCount() || rightLine > text.getLineCount()) {
      return;
    }
    if (leftLine != rightLine && leftColumn != rightColumn) {
      editor.setSelectionRegion(leftLine, leftColumn, rightLine, rightColumn, true);
    } else {
      editor.setSelection(leftLine, leftColumn);
    }
  }

  @Override
  protected void onRestoreInstanceState(Bundle arg0) {
    super.onRestoreInstanceState(arg0);
    // TODO: Implement this method
    restoreState(arg0);
  }

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);

    Cursor cursor = editor.getCursor();
    outState.putInt(EDITOR_LEFT_LINE_KEY, cursor.getLeftLine());
    outState.putInt(EDITOR_LEFT_COLUMN_KEY, cursor.getLeftColumn());
    outState.putInt(EDITOR_RIGHT_LINE_KEY, cursor.getRightLine());
    outState.putInt(EDITOR_RIGHT_COLUMN_KEY, cursor.getRightColumn());
  }

  public void _coderuner() {
    editor.setColorScheme(new io.github.rosemoe.sora.widget.EditorColorScheme());

    if (shp.getString("path", "").contains(".html")) {
      _fab.show();
    } else {
      if (shp.getString("path", "").contains(".py")) {
        _fab.hide();
      } else {
        if (shp.getString("path", "").contains(".js")) {
          _fab.show();
        } else {
          if (shp.getString("path", "").contains(".css")) {
            _fab.hide();
          } else {

          }
        }
      }
    }
  }

  public void _managerpanel(final View _view) {
    pvr =
        new PowerMenu.Builder(CodeEditorActivity.this)
            .addItem(new PowerMenuItem("جستجو", false, R.drawable.textsearch))
            .addItem(new PowerMenuItem("رنگ", false, R.drawable.color))
            .addItem(new PowerMenuItem("Log cat", false, R.drawable.codeformat))
            .addItem(new PowerMenuItem("ذخیره", false, R.drawable.save))
            .addItem(new PowerMenuItem("ذخیره همه", false, R.drawable.setsavefileall))
            .addItem(new PowerMenuItem("Code nave", false, R.drawable.setsavefileall))
            .addItem(new PowerMenuItem("Test"))
            .addItem(new PowerMenuItem("پس زمینه", false, R.drawable.keyboardlisnertalluserpost_3))
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
    if (ru.contains("rup")) {
      pvr.setIconColor(0xFFFDA893);
      pvr.setDivider(new ColorDrawable(0xFFEEEEEE));
      pvr.setMenuColor(0xFF2B2121);
      pvr.setTextColor(0xFFEEEEEE);
    } else {
      if (imap.containsKey("ImageColor")) {
        pvr.setIconColor(Color.parseColor(imap.get("ImageColor").toString()));
        pvr.setDivider(new ColorDrawable(Color.parseColor(imap.get("ImageColor").toString())));
      } else {
        pvr.setDivider(new ColorDrawable(0xFFEEEEEE));
        pvr.setIconColor(0xFFFDA893);
      }
      if (imap.containsKey("MenuBackground")) {
        pvr.setMenuColor(Color.parseColor(imap.get("MenuBackground").toString()));
      } else {
        pvr.setMenuColor(0xFF2B2121);
      }
      if (imap.containsKey("TEXT_NORMAL")) {
        pvr.setTextColor(Color.parseColor(imap.get("TEXT_NORMAL").toString()));
      } else {
        pvr.setTextColor(0xFFEEEEEE);
      }
    }
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
                      .setTitle("لطفا رنگ را انتخاب کنید")
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

                                _sysba("#".concat(rgs.replace("#ff", "#")));
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
                  if (editor.getText().toString().isEmpty()) {
                    DataUtil.showMessage(getApplicationContext(), "خطا متن خالی نمیشود ذخیره شود");
                  } else {
                    try {
                      if (shp.contains("pos_path")) {
                        if (!shp.getString("pos_path", "").equals("")) {
                          FileUtil.writeFile(
                              shp.getString("pos_path", ""), editor.getText().toString());
                          var bar = new FlashBarUtils(CodeEditorActivity.this);
                          bar.setCustomMassges("File saved by " + shp.getString("pos_path", ""));
                        } else {
                          DataUtil.showMessage(getApplicationContext(), "Error not File saved!");
                        }
                      }
                    } catch (Exception e) {
                      DataUtil.showMessage(getApplicationContext(), "Error not File saved!");
                    }
                  }
                  break;
                }
              case 4:
                {
                  _AllSaveFile(_coordinator);
                  var bar = new FlashBarUtils(CodeEditorActivity.this);
                  bar.setCustomMassges("All File saved by " + shp.getString("pos_path", ""));
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
                  var test = new CommonFactoryData(CodeEditorActivity.this, editor);
                  var file = new File(shp.getString("pos_path", ""));
                  test.setlistFile(file.getParentFile().toString());
                  Toast.makeText(CodeEditorActivity.this, file.getParentFile().toString(), 2)
                      .show();
                  break;
                }
              case 7:
                {
                  Intent myintent =
                      new Intent(
                          Intent.ACTION_PICK,
                          android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                  startActivityForResult(myintent, REQ_CD_SETPASZAMINE);
                  break;
                }
            }
          }
        });
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

  public void _codeEditor(final String _path) {
    Ninja.coder.Ghostemane.code.navigator.EditorRoaderFile.RuningTask(
        editor, _fab, _path, proanjctor);
  }

  public void _close_tab(final double _position, final ArrayList<HashMap<String, Object>> _data) {
    if (FileUtil.isExistFile(_data.get((int) _position).get("path").toString())) {
      _data.remove((int) (_position));
      if (_data.isEmpty()) {
        editor.setText("");
        _data.clear();
        shp.edit().remove("pos_path").apply();
        shp.edit().remove("path").apply();
        n = 0;
        finish();
      } else {
        if ((_position == 0) && (_data.size() > 1)) {
          shp.edit()
              .putString("pos_path", _data.get((int) _position + 1).get("path").toString())
              .apply();
          shp.edit().putString("positionTabs", String.valueOf((long) (_position + 1))).apply();
          _codeEditor(_data.get((int) _position + 1).get("path").toString());
        } else {
          if ((_position == 0) && (_data.size() == 1)) {
            shp.edit().putString("pos_path", _data.get(0).get("path").toString()).apply();
            _codeEditor(_data.get(0).get("path").toString());
            editor.setText("");
          } else {
            shp.edit()
                .putString("pos_path", _data.get((int) _position - 1).get("path").toString())
                .apply();
            shp.edit().putString("positionTabs", String.valueOf((long) (_position - 1))).apply();
            _codeEditor(_data.get((int) _position - 1).get("path").toString());
          }
        }
      }
      shp.edit().putString("path", new Gson().toJson(_data)).apply();
    } else {
      _data.remove((int) (_position));
      if (_data.isEmpty()) {
        _data.clear();
        shp.edit().remove("pos_path").apply();
        shp.edit().remove("path").apply();
        finish();
      } else {
        if ((_position == 0) && (_data.size() > 1)) {
          shp.edit()
              .putString("pos_path", _data.get((int) _position + 1).get("path").toString())
              .apply();
          shp.edit().putString("positionTabs", String.valueOf((long) (_position + 1))).apply();
        } else {
          if ((_position == 0) && (_data.size() == 1)) {
            shp.edit().putString("pos_path", _data.get(0).get("path").toString()).apply();
          } else {
            shp.edit()
                .putString("pos_path", _data.get((int) _position - 1).get("path").toString())
                .apply();
            shp.edit().putString("positionTabs", String.valueOf((long) (_position - 1))).apply();
          }
        }
      }
      shp.edit().putString("path", new Gson().toJson(_data)).apply();
    }
  }

  public void _Anim(final View _codeEditor) {
    android.view.animation.Animation animation = new android.view.animation.AlphaAnimation(0, 1);
    animation.setDuration(300);
    _codeEditor.setAnimation(animation);
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

  public void _viber() {
    if (getvb.getString("HsiGamer", "").equals("true")) {
      vb.vibrate(59);
    } else {
      if (getvb.getString("HsiGamer", "").equals("false")) {

      } else {

      }
    }
  }

  public void ClickItemChildAnimation(View view) {
    var fade_in =
        new ScaleAnimation(
            0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
    fade_in.setDuration(300);
    fade_in.setFillAfter(true);
    view.startAnimation(fade_in);
  }

  public void _EditorSummery() {

    if (re.getString("f380", "").equals("true")) {
      editor.setNonPrintablePaintingFlags(CodeEditor.FLAG_DRAW_LINE_SEPARATOR);
    }
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
      _codeEditor(shp.getString("pos_path", ""));
      ((LinearLayoutManager) recyclerview1.getLayoutManager())
          .scrollToPositionWithOffset(
              (int) Math.floor(Double.parseDouble(shp.getString("positionTabs", ""))), 0);
    }
  }

  public void _sysba(final String _input) {
    io.github.rosemoe.sora.widget.SymbolChannel channel = editor.createNewSymbolChannel();
    channel.insertSymbol(_input, _input.length());
  }

  public void _tabsize(final double _tab) {
    editor.setTabWidth((int) _tab);
  }

  public void _editorsetfontfromfile(final String _files) {
    editor.setTypefaceText(Typeface.createFromFile(new File(_files)));
    editor.setTypefaceLineNumber(Typeface.createFromFile(new File(_files)));
  }

  public void _fragmentdatapost() {
    liveViewerDialogFragmentActivityN = new LiveViewerDialogFragmentActivity();
    liveViewerDialogFragmentActivityN.show(getSupportFragmentManager(), "1");
  }

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
                  _sysba(tab);
                }

                @Override
                public void POST(String post) {
                  _sysba(post);
                }
              });

      syspiar.setAdapter(syspiarAdapter);
      syspiar.setLayoutManager(
          new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    } catch (Exception e) {
      DataUtil.showMessage(getApplicationContext(), e.toString());
    }
  }

  public void _closeall() {
    tabs_listmap.clear();
    shp.edit().remove("pos_path").apply();
    shp.edit().remove("positionTabs").apply();
    recyclerview1.getAdapter().notifyDataSetChanged();
    shp.edit().putString("path", new Gson().toJson(tabs_listmap)).apply();
    FileUtil.deleteFile("/storage/emulated/0/GhostWebIDE/ninjacoder/openFile.json");
    finish();
  }

  public void _closeother() {
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

  public void _powerMenuLisner(
      final View _v, final ArrayList<HashMap<String, Object>> _map, final double _pos) {
    itemPosRemoved = _pos;
    mmenuitempos =
        new PowerMenu.Builder(CodeEditorActivity.this)
            .addItem(new PowerMenuItem("close this"))
            .addItem(new PowerMenuItem("close other"))
            .addItem(new PowerMenuItem("close all"))
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
      if (imap.containsKey("MenuBackground")) {
        mmenuitempos.setMenuColor(Color.parseColor(imap.get("MenuBackground").toString()));
      } else {
        mmenuitempos.setMenuColor(0xFF2B2121);
      }
      if (imap.containsKey("ImageColor")) {
        mmenuitempos.setDivider(
            new ColorDrawable(Color.parseColor(imap.get("ImageColor").toString())));
      } else {
        mmenuitempos.setDivider(new ColorDrawable(0xFFEEEEEE));
      }
      if (imap.containsKey("TEXT_NORMAL")) {
        mmenuitempos.setTextColor(Color.parseColor(imap.get("TEXT_NORMAL").toString()));
      } else {
        mmenuitempos.setTextColor(0xFFEEEEEE);
      }
    }
    mmenuitempos.setOnMenuItemClickListener(
        new OnMenuItemClickListener<PowerMenuItem>() {
          @Override
          public void onItemClick(int position, PowerMenuItem item) {
            switch (position) {
              case ((int) 0):
                {
                  _close_tab(_pos, _map);
                  recyclerview1.getAdapter().notifyDataSetChanged();
                  click2var = 0;
                  n = 0;
                  _distreeview();
                  tabPos = 0;
                  mmenuitempos.dismiss();
                  break;
                }
              case ((int) 1):
                {
                  _closeother();
                  recyclerview1.getAdapter().notifyItemRemoved((int) itemPosRemoved);
                  click2var = 0;
                  _distreeview();
                  tabPos = 0;
                  mmenuitempos.dismiss();
                  break;
                }
              case ((int) 2):
                {
                  _closeall();
                  recyclerview1.getAdapter().notifyItemRemoved((int) itemPosRemoved);
                  click2var = 0;
                  _distreeview();
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
      combinedItems.add("Src");
      combinedItems.addAll(filteredItems.subList(3, filteredItems.size()));
      return combinedItems;
    }
    return filteredItems;
  }

  public void _distreeview() {
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

  public void _winterFileinpath(final String _path, final String _dir) {
    NinjaMacroFileUtil.createFile(
        _path,
        _dir,
        new NinjaMacroFileUtil.OnFileOperationListener() {
          @Override
          public void onSuccess(String content) {
            // محتوای فایل با موفقیت خوانده شد
            Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onError(String e) {
            // خطایی در هنگام خواندن فایل رخ داده است
            Toast.makeText(getApplicationContext(), e, Toast.LENGTH_SHORT).show();
          }
        });
  }

  public void _save() {
    if (shp.contains("pos_path")) {
      if (!shp.getString("pos_path", "").equals("")) {
        _winterFileinpath(shp.getString("pos_path", ""), editor.getText().toString());
      } else {

      }
    }
  }

  public void FabFileRuner() {
    try {
      try {
        if (shp.contains("pos_path")) {
          if (!shp.getString("pos_path", "").equals("")) {
            FileUtil.writeFile(shp.getString("pos_path", ""), editor.getText().toString());
            var bar = new FlashBarUtils(this);
            bar.setCustomMassges("File saved by " + shp.getString("pos_path", ""));
          } else {

          }
        }
      } catch (Exception e) {
        DataUtil.showMessage(getApplicationContext(), e.toString());
      }
      if (shp.getString("pos_path", "").contains(".html")) {
        if (moalaqfragment.contains("mpost")) {
          _fragmentdatapost();
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
                        _g4compiler();

                      } else {
                        if (shp.getString("pos_path", "").contains(".php")) {
                          getmd.setClass(getApplicationContext(), TerminalActivity.class);
                          getmd.putExtra("phpcode", shp.getString("pos_path", ""));
                          startActivity(getmd);
                        } else if (shp.getString("pos_path", "").contains(".scss")
                            || shp.getString("pos_path", "").contains(".sass")) {
                          //                          getmd.setClass(getApplicationContext(),
                          // TerminalActivity.class);
                          //                          getmd.putExtra("sass",
                          // shp.getString("pos_path", ""));
                          //                          startActivity(getmd);
                          SassForAndroid.run(
                              CodeEditorActivity.this,
                              shp.getString("pos_path", ""),
                              shp.getString("pos_path", ""));

                        } else if (shp.getString("pos_path", "").contains(".java")) {

                          JavaCompilerBeta.run(
                              CodeEditorActivity.this, editor.getText().toString());
                        } else if (shp.getString("pos_path", "").contains(".xml")) {

                          if (editor.getText().toString().startsWith("<vector")) {
                            var vectorShow = new VectorMasterView(CodeEditorActivity.this);
                            var file = new File(shp.getString("pos_path", ""));
                            var par =
                                new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.MATCH_PARENT);
                            vectorShow.setLayoutParams(par);
                            if (vectorShow.isVector()) {
                              vectorShow.setVectorFile(file);
                            }
                            var sheet = new BottomSheetDialog(CodeEditorActivity.this);
                            sheet.setContentView(vectorShow);
                            if (sheet != null) {
                              sheet.show();
                            }
                          } else if (editor.getText().toString().startsWith("<?xml")) {
                            XmlLayoutDesignActivity.show(
                                CodeEditorActivity.this,
                                "xml",
                                shp.getString("pos_path", ""),
                                false,
                                false);
                          } else {
                            XmlLayoutDesignActivity.show(
                                CodeEditorActivity.this,
                                "xml",
                                shp.getString("pos_path", ""),
                                false,
                                false);
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
      }
    } catch (Exception ex) {
      final AlertDialog.Builder malterDialog = new AlertDialog.Builder(CodeEditorActivity.this);
      StringBuffer sb = new StringBuffer(500);
      StackTraceElement[] st = ex.getStackTrace();
      sb.append(ex.getClass().getName() + ": " + ex.getMessage() + "\n");
      for (int iii = 0; iii < st.length; iii++) {
        sb.append("\t at ⟶" + st[iii].toString() + "\n");
      }

      final LinearLayout lin = new LinearLayout(getApplicationContext());

      lin.setPadding(8, 8, 8, 8);

      final TextView txt = new TextView(getApplicationContext());

      txt.setPadding(8, 8, 8, 8);

      txt.setTextIsSelectable(true);

      lin.addView(txt);

      txt.setText(sb.toString());

      {
        SpannableString spannableString = new SpannableString(txt.getText().toString());
        Matcher matcher = Pattern.compile("(^(.*)|(?<=:)\\d+)").matcher(txt.getText().toString());

        while (matcher.find()) {

          spannableString.setSpan(
              new ForegroundColorSpan(0xFFB71C1C),
              matcher.start(),
              matcher.end(),
              Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
          spannableString.setSpan(new StyleSpan(1), matcher.start(), matcher.end(), 33);
        }

        txt.setText(spannableString);
      }
      malterDialog.setView(lin);
      malterDialog.show();
    }
  }

  public void _AllSaveFile(final View _v) {

    try {
      if ((_v instanceof ViewGroup viewGroup)) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
          View child = viewGroup.getChildAt(i);
          _AllSaveFile(child);
        }
      } else {
        if ((_v instanceof CodeEditor)) {
          if (_v != null) {
            try {
              if (shp.contains("pos_path")) {
                if (!shp.getString("pos_path", "").equals("")) {
                  FileUtil.writeFile(
                      shp.getString("pos_path", ""), ((CodeEditor) _v).getText().toString());
                  if (imap.containsKey("MenuBackground")) {
                    //	alert.setAlertBackgroundColor(Color.parseColor(imap.get("MenuBackground").toString()));
                  } else {
                    //	alert.setAlertBackgroundColor(Color.BLUE);
                  }
                  if (imap.containsKey("TabTextColor")) {
                    //	alert.getText().setTextColor(Color.parseColor(imap.get("TabTextColor").toString()));
                    // alert.getTitle().setTextColor(Color.parseColor(imap.get("TabTextColor").toString()));
                  } else {
                    // alert.getTitle().setTextColor(Color.YELLOW);
                    //	alert.getText().setTextColor(Color.RED);
                  }
                  //	alert.getTitle().setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ghostfont.ttf"), 0);
                  //	alert.getText().setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ghostfont.ttf"), 0);
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

  public void _g4compiler() {
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

  public void _vi() {

    effect = new WallpaperParallaxEffect(this);
    effect.setCallback(
        new WallpaperParallaxEffect.Callback() {
          @Override
          public void onOffsetsChanged(int offsetX, int offsetY, float angle) {
            float progress = 1.0f;
            _coordinator.setTranslationX(offsetX * progress);
            _coordinator.setTranslationY(offsetY * progress);
          }
        });

    effect.setEnabled(thememanagersoft.contains("effect"));
  }

  public interface DoubleClickListener {
    void onSingleClick(final View view);

    void onDoubleClick(final View view);
  }

  public static class DoubleClick implements View.OnClickListener {

    private final Handler mHandler = new Handler();
    private final DoubleClickListener doubleClickListener;
    private long DOUBLE_CLICK_INTERVAL;
    private int clicks;
    private boolean isBusy = false;

    public DoubleClick(final DoubleClickListener doubleClickListener) {
      this(doubleClickListener, 200L);
      DOUBLE_CLICK_INTERVAL = 200L; // default time to wait the second click.
    }

    public DoubleClick(
        final DoubleClickListener doubleClickListener, final long DOUBLE_CLICK_INTERVAL) {
      this.doubleClickListener = doubleClickListener;
      this.DOUBLE_CLICK_INTERVAL =
          DOUBLE_CLICK_INTERVAL; // developer specified time to wait the second click.
    }

    @Override
    public void onClick(final View view) {

      if (!isBusy) {
        //  Prevent multiple click in this short time
        isBusy = true;

        // Increase clicks count
        clicks++;

        mHandler.postDelayed(
            new Runnable() {
              public void run() {

                if (clicks >= 2) { // Double tap.
                  doubleClickListener.onDoubleClick(view);
                }

                if (clicks == 1) { // Single tap
                  doubleClickListener.onSingleClick(view);
                }

                // we need to  restore clicks count
                clicks = 0;
              }
            },
            DOUBLE_CLICK_INTERVAL);
        isBusy = false;
      }
    }
  }

  public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {

    ArrayList<HashMap<String, Object>> _data;

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

      final LinearLayout linear1 = _view.findViewById(R.id.linear1);
      final LinearLayout linear5 = _view.findViewById(R.id.linear5);
      final LinearLayout selector = _view.findViewById(R.id.selector);
      final ImageView imageview2 = _view.findViewById(R.id.imageview2);
      final TextView textview1 = _view.findViewById(R.id.textview1);

      pos10 = _position;
      RecyclerView.LayoutParams _lp =
          new RecyclerView.LayoutParams(
              ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
      _view.setLayoutParams(_lp);
      if (tabimageview.contains("mtab")) {
        imageview2.setVisibility(View.GONE);
      }

      if (_data.isEmpty()) {

      } else {
        var ideColors = new IdeColorCompat(editor);
        ideColors.Colors(selector, textview1);
        datas = Uri.parse(_data.get(_position).get("path").toString()).getLastPathSegment();
        textview1.setText(
            Uri.parse(_data.get(_position).get("path").toString()).getLastPathSegment());

        if (FileUtil.isDirectory(_data.get(_position).get("path").toString())) {

          imageview2.setImageResource(R.drawable.file);
        } else if (FileUtil.isExistFile(_data.get(_position).get("path").toString())) {

        } else {
          textview1.setText(
              "FileNotFound*"
                  .concat(
                      Uri.parse(_data.get(_position).get("path").toString()).getLastPathSegment()));
        }
        if (_data.get(_position).get("path").toString().equals(shp.getString("pos_path", ""))) {

          selector.setVisibility(View.VISIBLE);
          _distreeview();
          ClickItemChildAnimation(editor);
          n = 0;
          if (imap.containsKey("TabTextColor")) {
            textview1.setTextColor(Color.parseColor(imap.get("TabTextColor").toString()));
          } else {
            textview1.setTextColor(Color.parseColor("#f4ffc6bc"));
          }
          if (ru.contains("rup")) {
            textview1.setTextColor(0xFFFDA893);
          } else {
            if (imap.containsKey("TabTextColor")) {
              textview1.setTextColor(Color.parseColor(imap.get("TabTextColor").toString()));
            } else {
              textview1.setTextColor(Color.parseColor("#f4ffc6bc"));
            }
          }
        } else {
          selector.setVisibility(View.GONE);
          n = 0;
          _distreeview();
          ClickItemChildAnimation(editor);
          if (imap.containsKey("DisplayTextColorTab")) {
            textview1.setTextColor(Color.parseColor(imap.get("DisplayTextColorTab").toString()));
          } else {
            textview1.setTextColor(Color.parseColor("#ffc9fff2"));
          }
          if (ru.contains("rup")) {
            textview1.setTextColor(0xFFEEEEEE);
          } else {
            if (imap.containsKey("DisplayTextColorTab")) {
              textview1.setTextColor(Color.parseColor(imap.get("DisplayTextColorTab").toString()));
            } else {
              textview1.setTextColor(Color.parseColor("#ffc9fff2"));
            }
          }
        }
        if (tabPos == _position) {

          _powerMenuLisner(linear5, _data, _position);
        } else
          linear5.setOnClickListener(
              new DoubleClick(
                  new DoubleClickListener() {
                    @Override
                    public void onSingleClick(View view) {

                      // Single tap here.
                      if (FileUtil.isExistFile(_data.get(_position).get("path").toString())) {
                        _codeEditor(_data.get(_position).get("path").toString());
                        shp.edit()
                            .putString("positionTabs", String.valueOf((long) (_position)))
                            .apply();
                        shp.edit()
                            .putString("pos_path", _data.get(_position).get("path").toString())
                            .apply();
                        ClickItemChildAnimation(editor);
                        _distreeview();
                        notifyDataSetChanged();
                        if (FileUtil.isExistFile(_data.get(_position).get("path").toString())) {
                          _codeEditor(_data.get(_position).get("path").toString());
                          if (_data
                              .get(_position)
                              .get("path")
                              .toString()
                              .equals(shp.getString("pos_path", ""))) {
                            if (imap.containsKey("TabTextColor")) {
                              textview1.setTextColor(
                                  Color.parseColor(imap.get("TabTextColor").toString()));
                            } else {
                              textview1.setTextColor(Color.parseColor("#f4ffc6bc"));
                            }
                            if (ru.contains("rup")) {
                              textview1.setTextColor(0xFFFDA893);
                            } else {
                              if (imap.containsKey("TabTextColor")) {
                                textview1.setTextColor(
                                    Color.parseColor(imap.get("TabTextColor").toString()));
                              } else {
                                textview1.setTextColor(Color.parseColor("#f4ffc6bc"));
                              }
                            }
                            selector.setVisibility(View.VISIBLE);
                            n = 0;
                            _distreeview();
                          } else {
                            selector.setVisibility(View.GONE);
                            if (imap.containsKey("DisplayTextColorTab")) {
                              textview1.setTextColor(
                                  Color.parseColor(imap.get("DisplayTextColorTab").toString()));
                            } else {
                              textview1.setTextColor(Color.parseColor("#ffc9fff2"));
                            }
                            if (ru.contains("rup")) {
                              textview1.setTextColor(0xFFEEEEEE);
                            } else {
                              if (imap.containsKey("DisplayTextColorTab")) {
                                textview1.setTextColor(
                                    Color.parseColor(imap.get("DisplayTextColorTab").toString()));
                              } else {
                                textview1.setTextColor(Color.parseColor("#ffc9fff2"));
                              }
                            }

                            ClickItemChildAnimation(editor);
                            _distreeview();
                            n = 0;
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
                              _close_tab(_position, _data);
                              _distreeview();
                              notifyItemRemoved(_position);
                            });
                        di.show();
                      }
                    }

                    @Override
                    public void onDoubleClick(View view) {

                      // Double tap here.
                      _powerMenuLisner(linear5, _data, _position);
                    }
                  }));

        linear5.setOnLongClickListener(
            new View.OnLongClickListener() {
              @Override
              public boolean onLongClick(View _view) {
                _powerMenuLisner(linear5, _data, _position);
                return true;
              }
            });
        if (imap.containsKey("TabBack")) {
          _Ripple_Drawable(linear5, imap.get("TabBack").toString());
        } else {
          _Ripple_Drawable(linear5, "#ffd1aeff");
        }
        if (ru.contains("rup")) {
          _Ripple_Drawable(linear5, "#ffd1aeff");
        } else {
          if (imap.containsKey("TabBack")) {
            _Ripple_Drawable(linear5, imap.get("TabBack").toString());
          } else {
            _Ripple_Drawable(linear5, "#ffd1aeff");
          }
        }
        shp.edit().putString("path", new Gson().toJson(_data)).apply();
      }
      _Anim(selector);
      if (setfont.contains("mfont")) {
        if (!FileUtil.isFile(setfont.getString("mfont", ""))) {
          DataUtil.showMessage(getApplicationContext(), "Custom Font Not Found");
          textview1.setTypeface(
              Typeface.createFromAsset(getAssets(), "fonts/ghostfont.ttf"), Typeface.NORMAL);
        } else {
          textview1.setTypeface(Typeface.createFromFile(new File(setfont.getString("mfont", ""))));
        }
      } else {
        textview1.setTypeface(
            Typeface.createFromAsset(getAssets(), "fonts/ghostfont.ttf"), Typeface.NORMAL);
      }
    }

    @Override
    public int getItemCount() {
      return _data.size();
    }

    boolean isSize() {
      for (int i = _data.size() - 1; i >= 0; i--) {
        return true;
      }
      return false;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      public ViewHolder(View v) {
        super(v);
      }
    }
  }
}
