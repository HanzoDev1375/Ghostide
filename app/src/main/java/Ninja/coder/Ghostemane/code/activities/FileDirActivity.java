package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.PluginManager.IntentHelper;
import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.RequestNetwork;
import Ninja.coder.Ghostemane.code.RequestNetworkController;
import Ninja.coder.Ghostemane.code.adapter.FileManagerAd;
import Ninja.coder.Ghostemane.code.adapter.ToolbarListFileAdapter;
import Ninja.coder.Ghostemane.code.adapter.ViewType;
import Ninja.coder.Ghostemane.code.compressor.TarGzExtractor;
import Ninja.coder.Ghostemane.code.compressor.ZxExtractor;
import Ninja.coder.Ghostemane.code.databin.FileMaker;
import Ninja.coder.Ghostemane.code.filehelper.CreatorModule;
import Ninja.coder.Ghostemane.code.filehelper.FactoryModelProject;
import Ninja.coder.Ghostemane.code.folder.FileIconHelper;
import Ninja.coder.Ghostemane.code.git.GitListSheet;
import Ninja.coder.Ghostemane.code.interfaces.FileCallBack;
import Ninja.coder.Ghostemane.code.layoutmanager.EmptyRecyclerView;
import Ninja.coder.Ghostemane.code.layoutmanager.NavigationViewCompnet;
import Ninja.coder.Ghostemane.code.marco.*;
import Ninja.coder.Ghostemane.code.model.IconShop;
import Ninja.coder.Ghostemane.code.model.ListSheet;
import Ninja.coder.Ghostemane.code.model.ZipFileShow;
import Ninja.coder.Ghostemane.code.project.ProjectMaker;
import Ninja.coder.Ghostemane.code.recyclerview.RecyclerViewHelper;
import Ninja.coder.Ghostemane.code.services.FileEventUser;
import Ninja.coder.Ghostemane.code.services.MediaListenerService;
import Ninja.coder.Ghostemane.code.terminal.TerminalActivity;
import Ninja.coder.Ghostemane.code.utils.*;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.utils.DialogUtil;
import Ninja.coder.Ghostemane.code.utils.VectorHelper;
import Ninja.coder.Ghostemane.code.widget.GhostWebMaterialDialog;
import Ninja.coder.Ghostemane.code.widget.PraramnetLayoutNinja;
import Ninja.coder.Ghostemane.code.widget.component.SwbData;
import Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat.FastScrollerBuilder;
import android.Manifest;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import Ninja.coder.Ghostemane.code.PluginManager.FilePostBroadcastReceiver;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hzy.lib7z.Z7Extractor;
import com.ninjacoder.jgit.GsonToClass;
import com.skydoves.powermenu.PowerMenu;
import java.util.stream.Collectors;
import ninjacoder.ghostide.androidtools.r8.android.R8Tools;
import storage.sdcard.SdCardUtil;

import java.io.File;
import java.util.*;

public class FileDirActivity extends BaseCompat
    implements FileManagerAd.onClick, ToolbarListFileAdapter.CallBack {

  protected static final String SHARED_PREFS_KEY = "scroll_position";
  protected static final String ITEM_POSITION_KEY = "item_position";
  public static String POSNINJACODERMAIN = "";
  public String Folder = "";
  protected SdCardUtil sd_stor;
  protected ProgressDialog progressDialog;
  protected AlertDialog maindialogPrfex;
  protected NavigationViewCompnet navs;
  protected SharedPreferences mSharedPreferences;
  protected FastScrollerBuilder fast;
  protected FileEventUser user;
  private Timer _timer = new Timer();
  private ExtendedFloatingActionButton fabAdd;
  private Toolbar _toolbar;
  private AppBarLayout _app_bar;
  private CoordinatorLayout _coordinator;
  private DrawerLayout _drawer;
  private double index = 0;
  private String Token = "";
  private String staticstring = "";
  private double gotoback = 0;
  private FileManagerAd fileListItem;
  private String CreateFolder = "";
  private String mainfile = "";
  private String GetTab = "";
  private String tab = "";
  private double n = 0;
  private ProjectMaker projectMaker;
  private double positionTabs = 0;
  protected SharedPreferences gridMode;
  private boolean Chack = false;
  private boolean isCopyAndMoved = false;
  private double conter = 0;
  private boolean isAllSet = false;
  private boolean staticStorage = false;
  private String version = "";
  private double post = 0;
  private String arm = "";
  private int newpos = 0;
  private String MColors = "";
  private int lastPos = 0;
  private List<String> list = new ArrayList<>();
  private List<String> folderList = new ArrayList<>();
  private List<String> fileList = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> files = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> newlistmap = new ArrayList<>();
  private ArrayList<String> pv = new ArrayList<>();
  private ArrayList<String> zip = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> upfile = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
  private ArrayList<String> str1 = new ArrayList<>();
  private ArrayList<String> str2 = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> projectdata = new ArrayList<>();
  private ArrayList<Double> cache = new ArrayList<>();
  private PraramnetLayoutNinja paramentLayout_fileDir;
  private LinearLayout CensractorListView1;
  private SwipeRefreshLayout swiperefreshlayout1;
  private RecyclerView recyclerview1;
  private EmptyRecyclerView recyclerview2;
  private Intent myketint = new Intent();
  private Intent intgetTheme = new Intent();
  private Intent intentgetSettings = new Intent();
  private SharedPreferences shp;
  private Intent activitiy = new Intent();
  private ProgressDialog progressDilaog;
  private ProgressDialog unzip;
  private ToolbarListFileAdapter adps;
  private SharedPreferences soglo;
  private SharedPreferences np;
  private ProgressDialog mprodialog;
  private SharedPreferences dismoveFile;
  private ProgressDialog prodel;
  private ProgressDialog proveg;
  private Intent getabout = new Intent();
  private Intent void10 = new Intent();
  private SharedPreferences sd;
  private SharedPreferences delfile;
  private ProgressDialog copydir;
  private ProgressDialog copypath;
  private MediaPlayer m;
  private TimerTask vvv12;
  private Intent getJavaLayoutManager = new Intent();
  private SharedPreferences zipCuntishen;
  private Intent govirwFilm = new Intent();
  private TimerTask ask;
  private SharedPreferences war;
  private RequestNetwork CheckNewVersion;
  private RequestNetwork.RequestListener UpdateCheck;
  private Intent finalintentpostfont = new Intent();
  private Intent intentgetLogCat = new Intent();
  private SharedPreferences tmp;
  private PowerMenu mmenuitempos;
  private PowerMenu mmenuVector;
  private ObjectAnimator one = new ObjectAnimator();
  private ObjectAnimator thow = new ObjectAnimator();
  private TimerTask MtimerPost;
  private ObjectAnimator mobjectOnTaskStart = new ObjectAnimator();
  private ObjectAnimator MobjectTaskEnd = new ObjectAnimator();
  private Intent musicShow = new Intent();
  private SharedPreferences base;
  private SharedPreferences save_path;
  private SharedPreferences materialYou;
  private SharedPreferences book;
  private ArrayList<HashMap<String, Object>> a = new ArrayList<>();
  private HashMap<String, Object> mapz32 = new HashMap<>();
  private HichemSoftFileUtil utils;
  private GridLayoutManager gridLayoutManager;
  private SharedPreferences sharedPreferences;
  private CircularProgressIndicator filedir_bar;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.filedir);
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
      initStartApp();
    }
  }

  @Override
  public void onRequestPermissionsResult(
      int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == 1000) {
      initStartApp();
    }
  }

  private void initialize(Bundle _savedInstanceState) {
    navs = findViewById(R.id.navs);
    startService(new Intent(getApplicationContext(), MediaListenerService.class));
    // from protected NavigationViewCompnet navs;

    mSharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
    _app_bar = findViewById(R.id._app_bar);
    _coordinator = findViewById(R.id._coordinator);
    _toolbar = findViewById(R.id._toolbar);
    setSupportActionBar(_toolbar);
    gridLayoutManager = new GridLayoutManager(this, 1);
    gridMode = getSharedPreferences("gride", Activity.MODE_PRIVATE);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    _drawer = findViewById(R.id._drawer);
    ActionBarDrawerToggle _toggle =
        new ActionBarDrawerToggle(
            FileDirActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
    _drawer.addDrawerListener(_toggle);
    _toggle.syncState();

    paramentLayout_fileDir = findViewById(R.id.paramentLayout_fileDir);
    CensractorListView1 = findViewById(R.id.CensractorListView1);

    swiperefreshlayout1 = findViewById(R.id.swiperefreshlayout1);

    recyclerview1 = findViewById(R.id.recyclerview1);
    recyclerview2 = findViewById(R.id.recyclerview2);
    fileListItem = new FileManagerAd(files, FileDirActivity.this, this);
    shp = getSharedPreferences("shp", Activity.MODE_PRIVATE);
    soglo = getSharedPreferences("soglo", Activity.MODE_PRIVATE);
    np = getSharedPreferences("np", Activity.MODE_PRIVATE);
    dismoveFile = getSharedPreferences("DismoveFile", Activity.MODE_PRIVATE);
    sd = getSharedPreferences("sd", Activity.MODE_PRIVATE);
    delfile = getSharedPreferences("delfile", Activity.MODE_PRIVATE);
    zipCuntishen = getSharedPreferences("zipCuntishen", Activity.MODE_PRIVATE);
    war = getSharedPreferences("war", Activity.MODE_PRIVATE);
    CheckNewVersion = new RequestNetwork(this);
    tmp = getSharedPreferences("tmp", Activity.MODE_PRIVATE);
    base = getSharedPreferences("base", Activity.MODE_PRIVATE);
    save_path = getSharedPreferences("save_path", Activity.MODE_PRIVATE);
    materialYou = getSharedPreferences("materialYou", Activity.MODE_PRIVATE);
    filedir_bar = findViewById(R.id.filedir_bar);
    book = getSharedPreferences("hsipsot4444", Activity.MODE_PRIVATE);
    WindowsMath(_drawer, _coordinator);
    var vie = LayoutInflater.from(this).inflate(R.layout.recyclerview_emptyview, null, false);
    recyclerview2.setEmptyView(vie);
    BackPressed();
    if (gridMode.contains("gride")) {
      setViewType(ViewType.GRID);
    } else {
      setViewType(ViewType.ROW);
    }
    ThemeChaker();

    var helper =
        new RecyclerViewHelper(
            recyclerview2,
            new RecyclerViewHelper.CallBackHelper() {

              @Override
              public void CallBackLeft(int pos) {
                MakeZipFileFromThread((int) pos);
                recyclerview2.getAdapter().notifyDataSetChanged();
              }

              @Override
              public void CallBackRight(int pos) {
                _delFileCustom(pos);
                recyclerview2.getAdapter().notifyDataSetChanged();
              }
            });
    swiperefreshlayout1.setOnRefreshListener(
        new SwipeRefreshLayout.OnRefreshListener() {
          @Override
          public void onRefresh() {
            recyclerview2.getAdapter().notifyDataSetChanged();
            swiperefreshlayout1.setRefreshing(false);
          }
        });

    recyclerview2.addOnScrollListener(
        new RecyclerView.OnScrollListener() {
          @Override
          public void onScrollStateChanged(RecyclerView recyclerView, int _scrollState) {
            super.onScrollStateChanged(recyclerView, _scrollState);
          }

          @Override
          public void onScrolled(RecyclerView recyclerView, int _offsetX, int _offsetY) {
            super.onScrolled(recyclerView, _offsetX, _offsetY);
            if (_offsetY > 2) {
              fabAdd.shrink();
            } else if (_offsetY < -2) {
              fabAdd.extend();
            }
          }
        });

    UpdateCheck =
        new RequestNetwork.RequestListener() {
          @Override
          public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
            final String _tag = _param1;
            final String _response = _param2;
            final HashMap<String, Object> _responseHeaders = _param3;
            try {
              upfile =
                  new Gson()
                      .fromJson(
                          _response,
                          new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
            } catch (Exception e) {

            }
            if (!upfile.get((int) 0).get("Version").toString().equals(version)) {
              /// AddDialog
              var di = new GhostWebMaterialDialog(FileDirActivity.this);
              di.setTitle(upfile.get((int) 0).get("Title").toString());
              di.setMessage(upfile.get((int) 0).get("Massges").toString());
              di.setCancelable(false);
              di.setNeutralButton(
                  "Update",
                  (p, d) -> {
                    void10.setAction(Intent.ACTION_VIEW);
                    void10.setData(Uri.parse(upfile.get((int) 0).get("Link").toString()));
                    startActivity(void10);
                    finishAffinity();
                  });
              di.setPositiveButton("Ask Later", null);

              di.show();

            } else {
              /// Empty
            }
          }

          @Override
          public void onErrorResponse(String _param1, String _param2) {}
        };
    projectMaker =
        new ProjectMaker(
            Folder,
            FileDirActivity.this,
            () -> {
              reLoadFile();
            });
  }

  @Override
  public void onClick(View view, int pos) {
    staticstring = files.get((int) pos).get("path").toString();
    if (FileUtil.isDirectory(staticstring)) {
      Folder = staticstring;
      reLoadFile();
    } else _dataOnClickItemList(pos);
  }

  void savePath() {
    if (save_path.contains("path")) {
      if (FileUtil.isExistFile(save_path.getString("path", ""))) {
        Folder = save_path.getString("path", "");
        reLoadFile();
      } else {
        Folder = FileUtil.getExternalStorageDir();
        reLoadFile();
      }
    } else {
      Folder = FileUtil.getExternalStorageDir();
      reLoadFile();
    }
    IntentHelper.getFilePath = Folder;
  }

  public void setViewType(ViewType viewType) {
    if (fileListItem != null) {
      fileListItem.setViewType(viewType);
      if (viewType == ViewType.GRID) {
        gridLayoutManager.setSpanCount(2);
        recyclerview2.setAdapter(fileListItem);
      } else {
        recyclerview2.setAdapter(fileListItem);
        gridLayoutManager.setSpanCount(1);
        fast = new FastScrollerBuilder(recyclerview2);
        fast.useMd2Style();
        fast.build();
      }
    }
  }

  public void sendFilePathToReceiver(String filePath) {
    FilePostBroadcastReceiver files = new FilePostBroadcastReceiver();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("Ninja.coder.code.Ghostemane.SEND_FILE_PATH");
    registerReceiver(files, intentFilter);
  }

  private void initStartApp() {

    getWindow()
        .setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    CheckNewVersion.startRequestNetwork(
        RequestNetworkController.GET,
        "https://raw.githubusercontent.com/HanzoDev1375/HanzoDev1375/main/log.json",
        "",
        UpdateCheck);
    if (war.contains("val")) {}

    var progress_m = new com.zip4j.progress.ProgressMonitor();

    try {
      var pInfo =
          getApplicationContext()
              .getPackageManager()
              .getPackageInfo(getApplicationContext().getPackageName(), 0);
      version = pInfo.versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException e) {
      showMessage(e.toString());
    }
    // new FastScrollerBuilder(recyclerview2).useMd2Style().build();

    progressDilaog =
        new ProgressDialog(FileDirActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    unzip = new ProgressDialog(FileDirActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    mprodialog = new ProgressDialog(FileDirActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    prodel = new ProgressDialog(FileDirActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    proveg = new ProgressDialog(FileDirActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    copydir = new ProgressDialog(FileDirActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    copypath = new ProgressDialog(FileDirActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    GradientDrawable u = new GradientDrawable();
    u.setColor(0xFF2B2122);
    u.setCornerRadius(25);
    u.setStroke(1, 0xFFF8B09A);

    paramentLayout_fileDir.setLayoutParams(
        new LinearLayout.LayoutParams(
            DataUtil.getDisplayWidthPixels(getApplicationContext()),
            DataUtil.getDisplayHeightPixels(getApplicationContext())));

    sd_stor = new SdCardUtil(this);

    if (getIntent().hasExtra("bookmarkDir")) {
      Folder = getIntent().getStringExtra("bookmarkDir");
      reLoadFile();
    } else {
      savePath();
    }
    user = new FileEventUser();
    user.setCallBack(
        () -> {
          Toast.makeText(getApplicationContext(), "File changed", Toast.LENGTH_LONG).show();
        });

    startService(new Intent(this, FileEventUser.class));
    getSupportActionBar().hide();
    sharedPreferences = getSharedPreferences("fileSp", Context.MODE_PRIVATE);
    utils = new HichemSoftFileUtil(sharedPreferences, FileDirActivity.this).loadData();
    utils.requestPermissionAllFilesAccess(); // if not allowed
    RefreshTabs();
    FileManagerUtils fileManagerUtils = new FileManagerUtils(this);

    fabAdd = findViewById(R.id.fabAdd);

    AnimUtils.Worker(fabAdd);

    fabAdd.setText("Create");
    fabAdd.setIconResource(R.drawable.create);
    ColorAndroid12.setFab(fabAdd);
    fabAdd.setOnClickListener(
        v -> {
          DialogItemSheet();
        });
    navs.getMenu().add(0, 1, 0, "SanDisk Card").setIcon(R.drawable.drawer_item12);
    navs.getMenu().add(0, 2, 0, "Java code").setIcon(R.drawable.drawer_item14);
    navs.getMenu().add(0, 3, 0, "Terminal").setIcon(R.drawable.drawer_item13);
    navs.getMenu().add(0, 4, 0, "Settings").setIcon(R.drawable.drawer_item15);
    navs.getMenu().add(0, 5, 0, "LogCat Reader").setIcon(R.drawable.drawer_item6);
    navs.getMenu().add(0, 6, 0, "Icon Shop").setIcon(R.drawable.icshop);
    navs.getMenu().add(0, 7, 0, "Learn").setIcon(R.drawable.drawer_item10);
    navs.getMenu().add(0, 8, 0, "Update App").setIcon(R.drawable.drawer_item8);
    navs.getMenu().add(0, 9, 0, "Plugins Manager").setIcon(R.drawable.drawer_item5);
    navs.getMenu().add(0, 10, 0, "Backup Theme").setIcon(R.drawable.drawer_item7);
    navs.getMenu().add(0, 11, 0, "Bookmarks (Beta)").setIcon(R.drawable.drawer_item4);
    navs.getMenu().add(0, 12, 0, "Apk Manager").setIcon(R.drawable.drawer_item3);
    navs.getMenu().add(0, 13, 0, "About").setIcon(R.drawable.drawer_item11);
    navs.getMenu().add(0, 14, 0, "Leave").setIcon(R.drawable.drawer_item1);
    DrowerHandler();
  }

  public void FilterFile() {

    var view = LayoutInflater.from(this).inflate(R.layout.reminderlist, null, false);
    var dialog = new DialogUtil(this);
    dialog.setTitle("Filter List");
    dialog.setPositiveButton("close", null);
    dialog.setView(view);
    if (dialog != null) {
      dialog.build();
    }

    TextInputEditText et = view.findViewById(R.id.ed_filter);
    TextInputLayout layout = view.findViewById(R.id.input);
    layout.setEndIconVisible(false);
    layout.setEndIconMinSize(10);
    layout.setEndIconScaleType(ImageView.ScaleType.CENTER_INSIDE);
    layout.setEndIconDrawable(R.drawable.deletear);
    layout.setEndIconOnClickListener(v -> et.getText().clear());
    sendFilePathToReceiver(Folder);

    et.addTextChangedListener(
        new TextWatcher() {

          @Override
          public void onTextChanged(CharSequence ser, int arg1, int arg2, int arg3) {

            ThreadUtils.runOnUiThread(
                () -> {
                  fileListItem.search(ser.toString());
                  recyclerview2.setAdapter(fileListItem);
                });
          }

          @Override
          public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

          @Override
          public void afterTextChanged(Editable arg0) {}
        });
  }

  public void BackPressed() {
    getOnBackPressedDispatcher()
        .addCallback(
            this,
            new OnBackPressedCallback(true) {
              @Override
              public void handleOnBackPressed() {
                if (sd_stor.hasRealRemovableSdCarde()) {
                  if (Folder.equals(FileUtil.getExternalStorageDir())
                      || Folder.equals(sd_stor.getExtSdPath())) {
                    gotoback++;
                    if (gotoback == 3) {
                      Chack = false;
                      finish();
                    }
                  } else {

                    Folder = Folder.substring((int) (0), (int) (Folder.lastIndexOf("/")));
                    reLoadFile();
                  }
                } else {
                  if (Folder.equals(FileUtil.getExternalStorageDir())) {
                    gotoback++;
                    if (gotoback == 3) {
                      Chack = false;
                      finish();
                    }
                  } else {
                    Folder = Folder.substring((int) (0), (int) (Folder.lastIndexOf("/")));
                    reLoadFile();
                  }
                }
              }
            });
  }

  @Override
  public void onResume() {
    super.onResume();
    RefreshTabs();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    // TODO: Implement this method
    stopService(new Intent(this, MediaListenerService.class));
  }

  public void reLoadFile(boolean isSortFile) {
    recyclerview2.setVisibility(View.GONE);
    filedir_bar.setVisibility(View.VISIBLE);

    new Thread(
            () -> {
              save_path.edit().putString("path", Folder).apply();

              list.clear();
              files.clear();
              folderList.clear();
              fileList.clear();
              FileUtil.listDir(Folder, list);
              Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
              GetTab = Folder;
              index = 0;
              if (isSortFile) {
                Collections.sort(
                    list,
                    (f1, f2) -> {
                      if (f1 == f2) return 0;
                      if (FileUtil.isDirectory(f1) && FileUtil.isFile(f2)) return -1;
                      if (FileUtil.isFile(f1) && FileUtil.isDirectory(f2)) return 1;
                      return f1.compareToIgnoreCase(f2);
                    });
              }

              list.forEach(
                  item -> {
                    if (FileUtil.isDirectory(item)) {
                      folderList.add(item);
                    } else {
                      fileList.add(item);
                    }
                  });

              List<HashMap<String, Object>> folderItems =
                  folderList.stream()
                      .map(
                          item -> {
                            HashMap<String, Object> _item = new HashMap<>();
                            _item.put("path", item);
                            return _item;
                          })
                      .filter(
                          item -> {
                            String path = (String) item.get("path");
                            return !path.isEmpty() && !new File(path).isHidden();
                          })
                      .collect(Collectors.toList());

              files.addAll(folderItems);
              fileList.forEach(
                  item -> {
                    HashMap<String, Object> _item = new HashMap<>();
                    _item.put("path", item);
                    files.add(_item);
                  });
              try {

              } catch (Exception e) {
                runOnUiThread(
                    () ->
                        DataUtil.showMessage(getApplicationContext(), "Error to " + e.toString()));
              }

              runOnUiThread(
                  () -> {
                    recyclerview2.setVisibility(View.VISIBLE);
                    filedir_bar.setVisibility(View.GONE);
                    recyclerview2.setAdapter(fileListItem);
                    ListSheet.bind(recyclerview2, Folder);
                    if (gridLayoutManager != null) {
                      recyclerview2.setLayoutManager(gridLayoutManager);
                    }
                  });
            })
        .start();

    _distreeview();
  }

  void reLoadFile() {
    reLoadFile(true);
  }

  public void FolderMaker() {
    androidx.appcompat.app.AlertDialog dialog =
        new GhostWebMaterialDialog(FileDirActivity.this)
            .setView(R.layout.makefolder)
            .setTitle("Folder")
            .setMessage("make folder")
            .setCancelable(true)
            .setPositiveButton("make", null)
            .setNegativeButton(android.R.string.cancel, null)
            .create();
    dialog.setOnShowListener(
        (var) -> {
          TextInputLayout top = dialog.findViewById(R.id.top);
          EditText editor = dialog.findViewById(R.id.editor);
          Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          if (editor.getText().toString().isEmpty()) {
            positive.setEnabled(false);
          } else {
            positive.setEnabled(true);
          }
          top.setCounterEnabled(true);
          editor.setHint("Type Name Folder");
          top.setCounterMaxLength(200);
          top.setEndIconTintMode(PorterDuff.Mode.MULTIPLY);
          top.setEndIconDrawable(R.drawable.close);
          top.setEndIconOnClickListener(
              v -> {
                editor.setText("");
              });

          positive.setOnClickListener(
              (vftrororocjj) -> {
                DataUtil.hideKeyboard(getApplicationContext());
                if (editor.getText().toString().isEmpty()) {
                  top.setError("return type Error \n");
                } else {
                  CreateFolder = editor.getText().toString();
                  try {
                    NinjaMacroFileUtil.createDirectory(
                        Folder.concat("/".concat(CreateFolder.concat("/"))),
                        new NinjaMacroFileUtil.OnFileOperationListener() {
                          @Override
                          public void onSuccess(String content) {
                            // محتوای فایل با موفقیت خوانده شد
                            Toast.makeText(getApplicationContext(), content, 2).show();

                            if (recyclerview2 != null) {
                              reLoadFile();
                              recyclerview2.getAdapter().notifyItemChanged(files.size());
                            }
                          }

                          @Override
                          public void onError(String e) {
                            // خطایی در هنگام خواندن فایل رخ داده است
                            Toast.makeText(getApplicationContext(), e, 2).show();
                          }
                        });

                  } catch (Exception e) {

                  }
                }
                dialog.dismiss();
              });
          editor.addTextChangedListener(
              new android.text.TextWatcher() {
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
    alertAnim.setDuration((int) (250));
    alertAnim.start();
    alertAnim1.setTarget(view);
    alertAnim1.setPropertyName("scaleY");
    alertAnim1.setFloatValues((float) (1));
    alertAnim1.setDuration((int) (250));
    alertAnim1.start();
    dialog.show();
  }

  public void FileMaker() {

    var folders = new FileMaker(this);
    folders.setFolderName(Folder);
    folders.setCallBack(
        new FileCallBack() {

          @Override
          public void onDoneMakeFile(String toast) {
            reLoadFile();
          }

          @Override
          public void onError(String error) {}
        });
  }

  public void _Ripple_Drawable(final View _view, final String _c) {
    android.content.res.ColorStateList clr =
        new android.content.res.ColorStateList(
            new int[][] {new int[] {}}, new int[] {Color.parseColor(_c)});
    android.graphics.drawable.RippleDrawable ripdr =
        new android.graphics.drawable.RippleDrawable(clr, null, null);
    _view.setBackground(ripdr);
  }

  public void RefreshTabs() {
    if (shp.contains("path")) {
      if (!shp.getString("path", "").equals("")) {
        newlistmap =
            new Gson()
                .fromJson(
                    shp.getString("path", ""),
                    new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
      }
    }
  }

  public void SendDataFromCodeEditor(
      int _position,
      String _key,
      List<HashMap<String, Object>> _listmap1,
      List<HashMap<String, Object>> _listmap2) {
    tab = _listmap1.get((int) _position).get(_key).toString();
    shp.edit().putString("pos_path", _listmap1.get((int) _position).get(_key).toString()).commit();
    if (_listmap2.isEmpty()) {
      positionTabs = 0;
      activitiy.setClass(getApplicationContext(), CodeEditorActivity.class);
      {
        HashMap<String, Object> _item = new HashMap<>();
        _item.put(_key, _listmap1.get((int) _position).get(_key).toString());
        _listmap2.add(_item);
      }

      shp.edit().putString(_key, new Gson().toJson(_listmap2)).commit();
      shp.edit().putString("positionTabs", String.valueOf((long) (positionTabs))).commit();
      startActivity(activitiy);
    } else {
      n = 0;
      while (true) {
        if (_listmap2.get((int) n).get(_key).toString().contains(tab)) {
          activitiy.setClass(getApplicationContext(), CodeEditorActivity.class);
          shp.edit().putString("positionTabs", String.valueOf((long) (n))).commit();
          startActivity(activitiy);
          break;
        } else {
          if (n == (_listmap2.size() - 1)) {
            activitiy.setClass(getApplicationContext(), CodeEditorActivity.class);
            {
              HashMap<String, Object> _item = new HashMap<>();
              _item.put(_key, _listmap1.get((int) _position).get(_key).toString());
              _listmap2.add(_item);
            }

            shp.edit().putString(_key, new Gson().toJson(_listmap2)).commit();
            shp.edit()
                .putString("positionTabs", String.valueOf((long) (_listmap2.size() - 1)))
                .commit();
            activitiy.putExtra("htmlcode", _listmap1.get((int) _position).get(_key).toString());
            activitiy.putExtra(
                "htmlfile",
                Uri.parse(_listmap1.get((int) _position).get(_key).toString())
                    .getLastPathSegment());
            File file = new File(_listmap1.get((int) _position).get(_key).toString());
            activitiy.putExtra("root", file.getParent());
            startActivity(activitiy);
            break;
          }
        }
        n++;
      }
    }
  }

  public void _distreeview() {

    List<String> pospath = spiltIntoBreadcrumbItems(Folder);

    adps = new ToolbarListFileAdapter(pospath, FileDirActivity.this, this);

    recyclerview1.setAdapter(adps);
    recyclerview1.setLayoutManager(
        new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    recyclerview1.smoothScrollToPosition(pospath.size());
  }

  @Override
  public void GoToDir(View view) {}

  @Override
  public void GoToTreeFile(View view) {
    ColorView.setPath(
        Folder,
        this,
        (ps) -> {
          Folder = ps;
          reLoadFile();
        },
        view);
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
      combinedItems.add(Build.MANUFACTURER + " " + Build.MODEL);
      combinedItems.addAll(filteredItems.subList(3, filteredItems.size()));
      return combinedItems;
    }
    return filteredItems;
  }

  @Override
  protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
    super.onActivityResult(_requestCode, _resultCode, _data);
    if (_resultCode == Activity.RESULT_OK) {
      if (_data != null) {
        utils.persistFolder(_data);
      }
    }
  }

  public void InstallTakesZip(int pos, String path) {
    InstallTakes(pos, path, "UnZip", "UnZip File?");
  }

  public void InstallTakesProject(int pos, String path) {
    InstallTakes(pos, path, "Install", "Install Project?");
  }

  void InstallTakes(int _pos, String _path, String tit, String msg) {
    var di = new DialogUtil(FileDirActivity.this);

    di.setTitle(tit);
    di.setMessage(msg);
    di.setNeutralButton(
        "مشاهده",
        (p, d) -> {
          ZipFileShow.showAsDialog(FileDirActivity.this, _path);
        });
    di.setPositiveButton(
        "استخراج",
        (p1, d2) -> {
          UnZipDataFromDir(_path, Folder);
        });
    di.build();
  }

  public void _fontpost(
      final ArrayList<HashMap<String, Object>> _map, final String _path, final double _pos) {
    if (_map.get((int) _pos).get(_path).toString().endsWith(".ttf")
        || _map.get((int) _pos).get(_path).toString().endsWith(".otf")) {
      finalintentpostfont.setClass(getApplicationContext(), FontViewActivity.class);
      finalintentpostfont.putExtra("font", _map.get((int) _pos).get(_path).toString());
      startActivity(finalintentpostfont);
    }
  }

  public void _themeinstall(
      final ArrayList<HashMap<String, Object>> _list, final double _pos, final String _str) {
    if (_list.get((int) _pos).get(_str).toString().endsWith(".aa")
        || _list.get((int) _pos).get(_str).toString().endsWith(".AA")) {
      if (FileUtil.isFile("/storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost")) {
        var di = new MaterialAlertDialogBuilder(FileDirActivity.this);

        di.setTitle("هشدار");
        di.setMessage("این فایل تم در حافظه شما موجود است آیا میخواهید این تم را جایگزین کنید؟");
        di.setNeutralButton(
            "بله",
            (p, d) -> {
              try {

                new net.lingala.zip4j.ZipFile(_list.get((int) _pos).get(_str).toString())
                    .extractAll("/storage/emulated/0/GhostWebIDE/");

              } catch (net.lingala.zip4j.exception.ZipException e) {
                showMessage(e.toString());
              }

              reLoadFile();
              DataUtil.showMessage(getApplicationContext(), "انجام شد");
            });
        di.setPositiveButton("خیر", (p1, d2) -> {});

        di.show();

      } else {
        try {

          new net.lingala.zip4j.ZipFile(_list.get((int) _pos).get(_str).toString())
              .extractAll("/storage/emulated/0/GhostWebIDE/");

        } catch (net.lingala.zip4j.exception.ZipException e) {
          showMessage(e.toString());
        }
        reLoadFile();
        DataUtil.showMessage(getApplicationContext(), "انجام شد");
      }
    }
  }

  public void showMessage(String a) {
    Toast.makeText(getApplicationContext(), a, 2).show();
  }

  public void _dicomplier() {
    androidx.appcompat.app.AlertDialog dialog =
        new GhostWebMaterialDialog(FileDirActivity.this)
            .setView(R.layout.classjardicompiler)
            .setTitle("Dicompiler ")
            .setMessage("")
            .setCancelable(true)
            .setPositiveButton("run", null)
            .setNegativeButton(android.R.string.cancel, null)
            .create();
    dialog.setOnShowListener(
        (var) -> {
          EditText input = dialog.findViewById(R.id.input);

          EditText output = dialog.findViewById(R.id.output);

          com.google.android.material.textfield.TextInputLayout tvin =
              dialog.findViewById(R.id.tvin);

          com.google.android.material.textfield.TextInputLayout tvou =
              dialog.findViewById(R.id.tvou);

          ProgressBar pros = dialog.findViewById(R.id.pros);

          input.setText(staticstring);
          pros.setVisibility(View.GONE);
          output.setText(GetTab);
          Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          positive.setOnClickListener(
              (vftrororocjj) -> {
                if (output.getText().toString().isEmpty()) {
                  DataUtil.showMessage(getApplicationContext(), "خروجی نمیتواند خالی باشد");
                } else {
                  new AsyncTask<String, String, String>() {
                    @Override
                    protected void onPreExecute() {
                      input.setEnabled(false);
                      output.setEnabled(false);
                      pros.setEnabled(true);
                      pros.setVisibility(View.VISIBLE);
                      tvin.setEnabled(false);
                      tvou.setEnabled(false);
                      tvou.setEnabled(false);
                      positive.setEnabled(false);
                    }

                    @Override
                    protected String doInBackground(String... params) {
                      String _param = params[0];
                      pv.clear();
                      pv.add(input.getText().toString());
                      pv.add("--extraclasspath");
                      pv.add("/storage/emulated/0/GhostWebIDE/android/android.jar");
                      pv.add("--outputdir");
                      pv.add(output.getText().toString());
                      try {
                        org.benf.cfr.reader.Main.main(pv.toArray(new String[0]));
                      } catch (Exception e) {

                        runOnUiThread(
                            new Runnable() {
                              @Override
                              public void run() {
                                DataUtil.showMessage(getApplicationContext(), e.toString());
                              }
                            });
                      }
                      return "";
                    }

                    @Override
                    protected void onPostExecute(String _result) {
                      tvin.setEnabled(true);
                      tvou.setEnabled(true);
                      input.setEnabled(true);
                      output.setEnabled(true);
                      pros.setEnabled(true);
                      pros.setVisibility(View.GONE);
                      positive.setEnabled(true);
                      reLoadFile();
                      dialog.dismiss();
                    }
                  }.execute("");
                }
              });
        });

    dialog.show();
  }

  public void _rename(final double _pos) {

    AlertDialog dialog =
        new GhostWebMaterialDialog(FileDirActivity.this)
            .setView(R.layout.ranme)
            .setTitle("Rename")
            .setMessage("type new name ")
            .setCancelable(false)
            .setPositiveButton("Ok", null)
            .setNegativeButton(android.R.string.cancel, null)
            .create();
    dialog.setOnShowListener(
        (var) -> {
          EditText editor = dialog.findViewById(R.id.editor);
          editor.setTextSize(16);
          editor.setTextColor(MaterialColors.getColor(editor, ColorAndroid12.colorOnSurface, 0));

          Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          editor.setText(
              Uri.parse(files.get((int) _pos).get("path").toString()).getLastPathSegment());
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
                {
                  java.io.File dYx4Y =
                      new java.io.File(files.get((int) _pos).get("path").toString());
                  java.io.File e5Cyk =
                      new java.io.File(Folder.concat("/".concat(editor.getText().toString())));
                  dYx4Y.renameTo(e5Cyk);
                }
                dialog.dismiss();
                reLoadFile();
              });
        });

    dialog.show();
  }

  public void _delFileCustom(int _pos) {
    var di = new DialogUtil(FileDirActivity.this);

    di.setTitle("Romved File");
    di.setMessage("romved ".concat(files.get(_pos).get("path").toString().concat(" your mobile?")));
    di.setNeutralButton("no", (p, d) -> {});

    di.setPositiveButton(
        "ok",
        (p1, d2) -> {
          new AsyncTask<String, String, String>() {
            @Override
            protected void onPreExecute() {
              prodel.setTitle("Romving ...");
              prodel.setMessage(
                  "removing ".concat(files.get(_pos).get("path").toString().concat(" now")));
              prodel.setCancelable(false);
              prodel.setCanceledOnTouchOutside(false);
              prodel.show();
            }

            @Override
            protected String doInBackground(String... params) {
              String _param = params[0];
              FileUtil.deleteFile(files.get(_pos).get("path").toString());

              return "";
            }

            @Override
            protected void onPostExecute(String _result) {
              prodel.dismiss();
              reLoadFile();
            }
          }.execute("");
        });

    di.build();
  }

  void loadsvg(int newpos) {
    var sh = new ListSheet();
    sh.setSheetDialog(this);
    sh.addItem("Show in Editor", 0);
    sh.addItem("Cast to Vector", 0);
    sh.addItem("Cast To png", 0);
    sh.setOnItemClickLabe(
        (pos333) -> {
          switch (pos333) {
            case 0:
              {
                SendDataFromCodeEditor(newpos, "path", files, newlistmap);
                sh.getDismiss(true);
                break;
              }
            case 1:
              {
                VectorImageShow(staticstring, GetTab.concat("/"));
                sh.getDismiss(true);
                break;
              }
            case 2:
              {
                projectMaker.setSvgToPngConvert(
                    files.get((int) newpos).get("path").toString(),
                    files.get((int) newpos).get("path").toString().replace(".svg", ".png"));

                sh.getDismiss(true);
                break;
              }
          }
        });
  }

  public void _dataOnClickItemList(int _pos) {
    newpos = _pos;
    if (staticstring.endsWith(".txt") || staticstring.endsWith(".log")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".go")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".css")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".php")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".js")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".html")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".dart")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".kt")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".swift")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".rb")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".rbw")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".c")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".scss") || staticstring.endsWith(".sass")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".cs")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".java")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".json")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".cpp")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".py")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".ghost")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".xml")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".ninja")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".md")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".sh")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".smali")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".groovy") || staticstring.endsWith(".gradle")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".g4")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".ts")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".properties")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".sql")) {
      SendDataFromCodeEditor(newpos, "path", files, newlistmap);
    }
    if (staticstring.endsWith(".svg")) {
      loadsvg(newpos);
    }
    if (staticstring.endsWith(".jar")) {
      var di = new DialogUtil(FileDirActivity.this);

      di.setTitle("لطفا یکی از گزینه های زیر را انتخاب کنید");
      di.setMessage(
          "توجه داشته باشید که برای تغییر jar به dex گزینه مناسب را انتخاب کنید ممکن است تغییرات و یا دیکامپایل کردن چند دقیقه طول بکشد یا حتی این عمل انجام نشود");
      di.setCancelable(false);

      di.setNeutralButton(
          "Dicompile",
          (p, d) -> {
            _dicomplier();
          });
      di.setNegativeButton(
          "jar to dex",
          (p3, d3) -> {
            R8Tools tools = new R8Tools();
            tools.onlyCompile(
                staticstring.trim(),
                GetTab.trim(),
                26,
                FileDirActivity.this,
                () -> {
                  reLoadFile();
                });
          });

      di.build();
    }
    if (staticstring.endsWith(".mp3")) {
      musicShow.setClass(getApplicationContext(), MusicPlayerActivity.class);
      musicShow.putExtra("Path", staticstring);
      musicShow.putExtra("Title", Uri.parse(staticstring).getLastPathSegment());
      startActivity(musicShow);
    }
    if (staticstring.endsWith(".mp4")) {
      govirwFilm.setClass(getApplicationContext(), VideoViewsActivity.class);
      govirwFilm.putExtra("getPath", staticstring);
      govirwFilm.putExtra("getTitle", Uri.parse(staticstring).getLastPathSegment());
      startActivity(govirwFilm);
    }
    if (staticstring.endsWith(".apk")) {
      apkShowDataRoom();
    }
    if (staticstring.endsWith(".pdf")) {
      getabout.setClass(getApplicationContext(), PdfViewNewActivity.class);
      getabout.putExtra("pdf", staticstring);
      getabout.putExtra("t", Uri.parse(staticstring).getLastPathSegment());
      startActivity(getabout);
    }
    if (staticstring.endsWith(".tar.gz")) {
      _targz(staticstring, Folder);
    }
    if (staticstring.endsWith(".tar.xz")) {
      _tarzx(staticstring, Folder);
    }
    if (staticstring.endsWith(".7z")) {
      _sevenUnZip(staticstring, Folder);
    }
    if (staticstring.endsWith(".swb")) {
      var myswb = new SwbData(this);
      myswb.init(staticstring);
    }
    if (staticstring.endsWith(".zip")) {
      InstallTakesZip(newpos, staticstring);
    }
    if (staticstring.endsWith(".project")) {
      InstallTakesProject(newpos, staticstring);
    }
    if (staticstring.endsWith(".png")) {
      getabout.setClass(getApplicationContext(), SetHomeWallpActivity.class);
      getabout.putExtra("img", staticstring);
      startActivity(getabout);
    }
    _fontpost(files, "path", newpos);
    _themeinstall(files, newpos, "path");
  }

  public void MakeZipFileFromThread(int pos) {
    MakeZipFileFromThread(pos, "Add project?", "ایا میخواهید یک پروژه بسازید؟", ".project");
  }

  public void MakeZipFileFromThreads(int pos) {
    MakeZipFileFromThread(pos, "Make ZipFile", "Add Zip ?", ".zip");
  }

  void MakeZipFileFromThread(int _number, String title, String massges, String format) {
    var di = new DialogUtil(this);

    di.setTitle(title);
    di.setMessage(massges);
    di.setPositiveButton(
        "بله",
        (p1, d2) -> {
          var copydir = new ProgressDialog(this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
          copydir.setCanceledOnTouchOutside(false);
          copydir.setTitle("Loading...");
          copydir.setCancelable(false);
          copydir.show();

          Thread thread =
              new Thread(
                  () -> {
                    if (FileUtil.isDirectory(files.get(_number).get("path").toString())) {
                      try {
                        String originalFilePath = files.get(_number).get("path").toString();
                        String outputFilePath =
                            Folder.concat("/")
                                .concat(
                                    Uri.parse(originalFilePath)
                                        .getLastPathSegment()
                                        .concat(format));
                        new net.lingala.zip4j.ZipFile(outputFilePath)
                            .addFolder(new File(originalFilePath));
                      } catch (Exception e) {
                        runOnUiThread(() -> showMessage(e.toString()));
                      }
                    } else {
                      try {
                        String originalFilePath = files.get(_number).get("path").toString();
                        String outputFilePath =
                            Folder.concat("/")
                                .concat(
                                    Uri.parse(originalFilePath)
                                        .getLastPathSegment()
                                        .replaceAll("\\.\\w+$", "")
                                        .concat(format));
                        new net.lingala.zip4j.ZipFile(outputFilePath)
                            .addFile(new java.io.File(originalFilePath));
                      } catch (Exception e) {
                        runOnUiThread(() -> showMessage(e.toString()));
                      }
                    }

                    runOnUiThread(
                        () -> {
                          reLoadFile();
                          copydir.dismiss();
                        });
                  });
          thread.start();
        });

    di.setNeutralButton("خیر", null);

    di.build();
  }

  public void _projectinit() {
    var maindialogPrfex = new DialogUtil(FileDirActivity.this);
    maindialogPrfex.setView(R.layout.projectinitre);
    maindialogPrfex.setTitle("Make project");
    maindialogPrfex.setCancelable(true);
    maindialogPrfex.setPositiveButton("make", null);
    maindialogPrfex.setNegativeButton(android.R.string.cancel, null);

    maindialogPrfex.setOnShowListener(
        (var) -> {
          RecyclerView post = maindialogPrfex.getAlertDialog().findViewById(R.id.post);
          Button positive = maindialogPrfex.getButton(DialogInterface.BUTTON_POSITIVE);
          projectdata.clear();
          for (int _repeat20 = 0; _repeat20 < (int) (4); _repeat20++) {
            {
              HashMap<String, Object> _item = new HashMap<>();
              _item.put("dontsetMe", "");
              projectdata.add(_item);
            }
          }
          // post.setAdapter(new RecyclerviewCppAdapter(projectdata));
          post.setLayoutManager(new GridLayoutManager(FileDirActivity.this, (int) 2));
          positive.setOnClickListener(
              (vftrororocjj) -> {
                maindialogPrfex.dismiss();
              });
        });
    maindialogPrfex.build();
  }

  public void VectorImageShow(final String _input, final String _output) {
    VectorHelper.iconPath = _input;
    VectorHelper.projectResourceDirectory = _output;
    VectorHelper.v(
        FileDirActivity.this,
        () -> {
          reLoadFile();
        });
  }

  public void UnZipDataFromDir(String _input, String _output) {
    var task =
        new HsiZip(
            this,
            new HsiZip.OnCallBack() {

              @Override
              public void onResult() {
                reLoadFile();
              }

              @Override
              public void onError() {}
            });
    task.execute(_input, _output);
  }

  public void apkShowDataRoom() {
    String pathToFile = staticstring;
    PackageManager packageManager = getPackageManager();
    PackageInfo packageInfo = packageManager.getPackageArchiveInfo(pathToFile, 0);
    // ساختن متن برای نمایش در دیالوگ
    StringBuilder sb = new StringBuilder();
    sb.append("Package Name: ").append(packageInfo.packageName).append("\n");
    sb.append("Version Name: ").append(packageInfo.versionName).append("\n");
    sb.append("Version Code: ").append(packageInfo.versionCode).append("\n");

    // دریافت نام API با استفاده از minSdkVersion
    int minSdkVersion = packageInfo.applicationInfo.minSdkVersion;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      sb.append("Min SDK Version: ")
          .append(minSdkVersion)
          .append(" (")
          .append(Build.VERSION_CODES.class.getFields()[minSdkVersion].getName())
          .append(")\n");
    } else {
      sb.append("Min SDK Version: ").append(minSdkVersion).append("\n");
    }
    // دریافت آیکون برنامه و نام برنامه
    var applicationInfo = packageInfo.applicationInfo;
    var icon = applicationInfo.loadIcon(packageManager);
    var appName = applicationInfo.loadLabel(packageManager).toString();
    // ساخت دیالوگ با MaterialAlertDialogBuilder و نمایش آیکون و نام برنامه در آن
    var builder = new MaterialAlertDialogBuilder(this);
    builder.setTitle(appName);
    builder.setIcon(icon);
    builder.setMessage(sb.toString());
    builder.setPositiveButton(
        "ApkSigner",
        (dd, fff) -> {
          AS.runs(
              staticstring,
              new AS.CallBack() {
                @Override
                public void end() {
                  reLoadFile();
                  Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
                }
              },
              FileDirActivity.this);
        });
    builder.setNeutralButton(
        "install",
        (p, d) -> {
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
              && !getPackageManager().canRequestPackageInstalls()) {
            var cbuilder = new MaterialAlertDialogBuilder(this);
            cbuilder.setTitle("Application request to install app");
            cbuilder.setMessage("To install the application requires permission.");
            cbuilder.setPositiveButton(
                "Request",
                (cc, fdd) -> {
                  Intent mintent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
                  mintent.setData(Uri.parse("package:" + getPackageName()));
                  startActivity(mintent);
                });
            cbuilder.setNegativeButton("No", null);
            cbuilder.show();
          } else {
            String apkPath = staticstring;
            ApkInstaller apkInstaller = new ApkInstaller(FileDirActivity.this, new File(apkPath));
            apkInstaller.execute();
          }
        });

    builder.show();
  }

  public void _targz(final String _in, final String _ou) {
    var extra =
        new TarGzExtractor(
            this,
            () -> {
              reLoadFile();
            });
    // input    //out
    extra.extract(new File(_in), new File(_ou));
  }

  public void _tarzx(final String _in, final String _ou) {
    var zippos =
        new ZxExtractor(
            this,
            () -> {
              reLoadFile();
            });
    zippos.extract(new File(_in), new File(_ou));
  }

  public void _sevenUnZip(final String _in, final String _ou) {
    // Z7Extractor.extractFile()
    try {
      AlertDialog dialog =
          new MaterialAlertDialogBuilder(this)
              .setTitle("Loading...")
              .setMessage("")
              .setPositiveButton("Done", null)
              .setCancelable(false)
              .create();
      dialog.show();
      new Thread(
              new Runnable() {
                @Override
                public void run() {

                  Z7Extractor.extractFile(
                      _in,
                      _ou,
                      new com.hzy.lib7z.IExtractCallback() {
                        @Override
                        public void onProgress(final String name, final long size) {
                          runOnUiThread(
                              () -> {
                                dialog.setMessage(name);
                              });
                        }

                        @Override
                        public void onError(int errorCode, final String error) {
                          runOnUiThread(
                              () -> {
                                dialog.setMessage("CodeError " + errorCode + "Error " + error);
                              });
                        }

                        @Override
                        public void onSucceed() {
                          runOnUiThread(
                              () -> {
                                if (dialog != null) dialog.dismiss();
                              });
                        }

                        @Override
                        public void onStart() {
                          runOnUiThread(
                              () -> {
                                dialog.setMessage("Starting...");
                              });
                        }

                        @Override
                        public void onGetFileNum(int size) {}
                      });
                }
              })
          .start();
    } catch (Exception E) {
      Toast.makeText(getApplicationContext(), E.getMessage(), 2).show();
    }
  }

  public void _ftpinstall() {
    androidx.appcompat.app.AlertDialog dialog =
        new GhostWebMaterialDialog(FileDirActivity.this)
            .setView(R.layout.layout_ftp_filedir_download)
            .setTitle("Ftp Downloader")
            .setCancelable(false)
            .setPositiveButton("download", null)
            .setNegativeButton(android.R.string.cancel, null)
            .create();
    dialog.setOnShowListener(
        (var) -> {
          Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          EditText ftpserver = dialog.findViewById(R.id.ftpserver);

          EditText ftpport = dialog.findViewById(R.id.ftpport);

          EditText ftpusername = dialog.findViewById(R.id.ftpusername);

          EditText ftppass = dialog.findViewById(R.id.ftppass);

          EditText ftpLocalRemote = dialog.findViewById(R.id.ftpLocalRemote);

          ProgressBar bar = dialog.findViewById(R.id.bar);

          LinearLayout mlinear1 = dialog.findViewById(R.id.mlinear1);

          bar.setVisibility(View.GONE);
          positive.setOnClickListener(
              (vftrororocjj) -> {
                mlinear1.setVisibility(View.GONE);
                if (ftpserver.getText().toString().isEmpty()
                    || ftpusername.getText().toString().isEmpty()
                    || ftpusername.getText().toString().isEmpty()
                    || ftppass.getText().toString().isEmpty()
                    || ftpLocalRemote.getText().toString().isEmpty()) {
                  Toast.makeText(getApplicationContext(), "فیلد خالی است", 2).show();
                }
                int ab = Integer.parseInt(ftpLocalRemote.getText().toString());
                if (ab == 0) return;

                mlinear1.setVisibility(View.GONE);
                FtpDownloader downloader =
                    new FtpDownloader(
                        ftpserver.getText().toString(),
                        ab,
                        ftpusername.getText().toString(),
                        ftppass.getText().toString(),
                        ftpLocalRemote.getText().toString(),
                        Folder,
                        new FtpDownloader.ProgressListener() {
                          @Override
                          public void onProgressUpdate(int percent) {

                            bar.setProgress(percent);
                          }

                          @Override
                          public void onError(String message) {

                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT)
                                .show();
                          }

                          @Override
                          public void onDownloadFinished() {

                            Toast.makeText(
                                    getApplicationContext(),
                                    "فایل با موفقیت دانلود شد.",
                                    Toast.LENGTH_SHORT)
                                .show();
                            dialog.dismiss();
                            reLoadFile();
                          }
                        });

                downloader.start();
              });
        });
    dialog.show();
  }
  
  private void setSanDisk(){
  runOnUiThread(
                    new Runnable() {
                      @Override
                      public void run() {

                        if (staticStorage) {
                          staticStorage = false;
                          Folder = FileUtil.getExternalStorageDir();
                          DataUtil.showMessage(
                              getApplicationContext(), FileUtil.getExternalStorageDir());
                          reLoadFile();
                          _drawer.closeDrawer(GravityCompat.START);
                        } else {
                          staticStorage = true;
                          if (sd_stor.hasRealRemovableSdCarde()) {
                            Folder = sd_stor.getExtSdPath();
                            DataUtil.showMessage(getApplicationContext(), sd_stor.getExtSdPath());
                          } else {
                            DataUtil.showMessage(
                                getApplicationContext(), "مموری کارت پیدا نشد متاسفم");
                          }
                          reLoadFile();
                          _drawer.closeDrawer(GravityCompat.START);
                        }
                      }
                    });
  } 

  public void DrowerHandler() {
    navs.bringToFront();
    navs.setClick(
        (item) -> {
          navs.setCheckedItem(item.getItemId());
          switch ((int) item.getItemId()) {
            case 1:
              {
                setSanDisk(); 
                break;
              }

            case 2:
              {
                getJavaLayoutManager.setClass(
                    getApplicationContext(), JavaManagerLayoutActivity.class);
                getJavaLayoutManager.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(getJavaLayoutManager);
                break;
              }
            case 3:
              {
                void10.setClass(getApplicationContext(), TerminalActivity.class);
                startActivity(void10);
                break;
              }
            case 4:
              {
                intentgetSettings.setClass(getApplicationContext(), SettingAppActivity.class);
                startActivity(intentgetSettings);
                break;
              }
            case 5:
              {
                intentgetLogCat.setClass(getApplicationContext(), LogCatViewActivity.class);
                startActivity(intentgetLogCat);
                break;
              }
            case 6:
              {
                var icon = new IconShop(FileDirActivity.this);
                break;
              }
            case 7:
              {
                if (DataUtil.isConnected(getApplicationContext())) {
                  CheckNewVersion.startRequestNetwork(
                      RequestNetworkController.GET,
                      "https://raw.githubusercontent.com/HanzoDev1375/HanzoDev1375/main/log.json",
                      "v",
                      UpdateCheck);
                } else {
                  DataUtil.showMessage(getApplicationContext(), "اینترنت خاموش است");
                }
                break;
              }
            case 8:
              {
                intentgetLogCat.setClass(getApplicationContext(), PluginManagerActivity.class);
                startActivity(intentgetLogCat);
                break;
              }
            case 9:
              {
                setBackupTheme();
                break;
              }

            case 10:
              {
                intentgetLogCat.setClass(getApplicationContext(), FileBookmarkActivity.class);
                startActivity(intentgetLogCat);
                break;
              }

            case 11:
              {
                var b = new Intent();
                b.setClass(getApplicationContext(), ApkViewActivity.class);
                startActivity(b);

                break;
              }
            case 12:
              {
                getabout.setClass(getApplicationContext(), AboutActivity.class);
                startActivity(getabout);
                break;
              }

            case 13:
              {
                finishAffinity();
                break;
              }
          }
          return false;
        });
  }

  public void setBackupTheme() {
    if (FileUtil.isFile("/storage/emulated/0/GhostWebIDE/theme/theme.AA")) {
      var di = new GhostWebMaterialDialog(FileDirActivity.this);
      di.setTitle("هشدار");
      di.setMessage("این فایل در مسیر شما وجود دارد ایا میخواهید این فایل را جایگزین کنید؟");
      di.setNeutralButton(
          android.R.string.ok,
          (p, d) -> {
            try {

              net.lingala.zip4j.ZipFile zip4 =
                  new net.lingala.zip4j.ZipFile(
                      new File(
                          "/storage/emulated/0/GhostWebIDE/"
                              + DataUtil.getRandom(1, 200)
                              + "theme.AA"));

              ArrayList filesToAdd = new ArrayList<>();
              var iconPath = getFilesDir().getAbsoluteFile() + "/icon.png";
              filesToAdd.add(new File(iconPath));
              filesToAdd.add(new File("/sdcard/GhostWebIDE/theme/GhostThemeapp.ghost"));

              zip4.addFiles(filesToAdd);
              DataUtil.showMessage(getApplicationContext(), "انجام شد در پوشه برنامه");

            } catch (net.lingala.zip4j.exception.ZipException e) {

            }
          });
      di.setPositiveButton("خیر", (p1, d2) -> {});

      di.show();
    } else {
      try {

        net.lingala.zip4j.ZipFile zip4 =
            new net.lingala.zip4j.ZipFile(
                new File(
                    "/storage/emulated/0/GhostWebIDE/" + DataUtil.getRandom(1, 200) + "theme.AA"));

        List<File> filesToAdd = new ArrayList<>();
        var iconPath = getFilesDir().getAbsoluteFile() + "/icon.png";
        filesToAdd.add(new File(iconPath));
        filesToAdd.add(new File("/sdcard/GhostWebIDE/theme/GhostThemeapp.ghost"));

        zip4.addFiles(filesToAdd);
        DataUtil.showMessage(getApplicationContext(), "انجام شد در پوشه برنامه");

      } catch (net.lingala.zip4j.exception.ZipException e) {

      }
    }
  }

  public void DialogItemSheet() {

    var sh = new ListSheet();
    var fileHelper = new FileIconHelper(Folder);
    sh.setSheetDialog(this);

    sh.addItem("MakeFolder", R.drawable.folder);
    sh.addItem("MakeFile", R.drawable.folders_0_5);
    sh.addItem("MakeProject", R.drawable.textfile);
    sh.addItem("FTP", R.drawable.iconmode);
    sh.addItem("SearchFile(beta)", R.drawable.imgsearch);
    sh.addItem("Folder Tree", R.drawable.foldermultipleplus);
    sh.addItem("FileTree", R.drawable.filemultiple);
    sh.addItem("Git Clone", R.drawable.git);
    sh.addItem("Android module", R.drawable.mdapk);
    sh.addItem("Git Tools", R.drawable.git);
    sh.addItem("Gson to Class", R.drawable.ic_material_folder_json);
    sh.setOnItemClickLabe(
        (pos333) -> {
          switch (pos333) {
            case 0:
              {
                FolderMaker();
                sh.getDismiss(true);
                break;
              }
            case 1:
              {
                FileMaker();
                sh.getDismiss(true);
                break;
              }
            case 2:
              {
                var modl =
                    new FactoryModelProject(
                        FileDirActivity.this,
                        Folder,
                        () -> {
                          reLoadFile();
                        });
                sh.getDismiss(true);
                break;
              }
            case 3:
              {
                _ftpinstall();
                sh.getDismiss(true);
                break;
              }
            case 4:
              {
                FilterFile();
                sh.getDismiss(true);
                break;
              }
            case 5:
              {
                var di1 = new GhostWebMaterialDialog(FileDirActivity.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogview =
                    getLayoutInflater().inflate(R.layout.makefolder, viewGroup, false);
                EditText editor = dialogview.findViewById(R.id.editor);
                di1.setTitle("File Tree");
                di1.setMessage("Type Name Folder + name Ninja.ninja.app.txt");
                di1.setNeutralButton(
                    "make",
                    (p, d) -> {
                      FileTree.FolderTree(
                          Folder + "/" + editor.getText().toString(),
                          new FileTree.Event() {
                            @Override
                            public void StartEvent() {}

                            @Override
                            public void FinishEvent() {
                              reLoadFile();
                            }

                            @Override
                            public void ErrorEvent(Throwable t) {}

                            @Override
                            public void WorkTotalEvent(int a) {}
                          });
                    });
                di1.setNegativeButton("dismiss", (p3, d3) -> {});

                di1.setView(dialogview);
                di1.show();
                sh.getDismiss(true);
                break;
              }
            case 6:
              {
                var di = new GhostWebMaterialDialog(FileDirActivity.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogview1 =
                    getLayoutInflater().inflate(R.layout.makefolder, viewGroup, false);
                EditText editor = dialogview1.findViewById(R.id.editor);
                di.setTitle("Fike Tree");
                di.setMessage("Type Name Folder + name Ninja.ninja.app.txt");
                di.setNeutralButton(
                    "make",
                    (p, d) -> {
                      FileTree.FilesTree(
                          Folder + "/" + editor.getText().toString(),
                          new FileTree.Event() {
                            @Override
                            public void StartEvent() {}

                            @Override
                            public void FinishEvent() {
                              reLoadFile();
                            }

                            @Override
                            public void ErrorEvent(Throwable t) {}

                            @Override
                            public void WorkTotalEvent(int a) {}
                          });
                    });
                di.setNegativeButton("dismiss", (p3, d3) -> {});

                di.setView(dialogview1);
                di.show();
                sh.getDismiss(true);
                break;
              }
            case 7:
              {
                _dialoggits();
                sh.getDismiss(true);
                break;
              }
            case 8:
              {
                CreatorModule cvt =
                    new CreatorModule(
                        FileDirActivity.this,
                        Folder,
                        () -> {
                          reLoadFile();
                        });
                sh.getDismiss(true);
                break;
              }
            case 9:
              {
                GitListSheet task = new GitListSheet(new File(Folder), FileDirActivity.this);
                sh.getDismiss(true);
                break;
              }
            case 10:
              {
                var jsonToJava =
                    new GsonToClass(
                        FileDirActivity.this,
                        Folder,
                        () -> {
                          reLoadFile();
                        });
                jsonToJava.run();
                sh.getDismiss(true);
                break;
              }
          }
        });
  }

  public void _newItemSheet(int _position, final View _view) {
    final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog =
        new com.google.android.material.bottomsheet.BottomSheetDialog(FileDirActivity.this);

    View bottomSheetView;
    bottomSheetView = getLayoutInflater().inflate(R.layout.layout_dir_sheet, null);
    bottomSheetDialog.setContentView(bottomSheetView);

    LinearLayout re = (LinearLayout) bottomSheetView.findViewById(R.id.re);
    LinearLayout del = (LinearLayout) bottomSheetView.findViewById(R.id.del);
    LinearLayout pr = (LinearLayout) bottomSheetView.findViewById(R.id.pr);
    LinearLayout sh = (LinearLayout) bottomSheetView.findViewById(R.id.sh);
    LinearLayout zp = (LinearLayout) bottomSheetView.findViewById(R.id.zp);
    LinearLayout mark = (LinearLayout) bottomSheetView.findViewById(R.id.mark);
    re.setOnClickListener(
        new View.OnClickListener() {
          public void onClick(View v) {

            bottomSheetDialog.dismiss();
            _rename(_position);
          }
        });
    del.setOnClickListener(
        new View.OnClickListener() {
          public void onClick(View v) {

            _delFileCustom(_position);
            bottomSheetDialog.dismiss();
          }
        });
    pr.setOnClickListener(
        new View.OnClickListener() {
          public void onClick(View v) {

            MakeZipFileFromThread(_position);
            bottomSheetDialog.dismiss();
          }
        });
    sh.setOnClickListener(
        new View.OnClickListener() {
          public void onClick(View v) {

            var fileShareManager = new FileShareManager(FileDirActivity.this);
            File file = new File(files.get((int) _position).get("path").toString());
            try {
              fileShareManager.shareFile(file);
            } catch (Exception e) {
              e.printStackTrace();
            }

            bottomSheetDialog.dismiss();
          }
        });
    zp.setOnClickListener(
        new View.OnClickListener() {
          public void onClick(View v) {

            MakeZipFileFromThreads(_position);
            bottomSheetDialog.dismiss();
          }
        });
    mark.setOnClickListener(
        new View.OnClickListener() {
          public void onClick(View v) {

            if (book.getString("hsipsot4444", "").equals("")) {
              book.edit().putString("hsipsot4444", "[]").apply();
            } else {
              a =
                  new Gson()
                      .fromJson(
                          book.getString("hsipsot4444", ""),
                          new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
              mapz32 = new HashMap<>();
              mapz32.put("list", files.get((int) _position).get("path").toString());
              a.add(mapz32);
              book.edit().putString("hsipsot4444", new Gson().toJson(a)).apply();
              showMessage("Added!");
            }
            bottomSheetDialog.dismiss();
          }
        });
    bottomSheetDialog.show();
  }

  public void _dialog() {
    int position =
        ((GridLayoutManager) recyclerview2.getLayoutManager()).findFirstVisibleItemPosition();
    var di = new GhostWebMaterialDialog(FileDirActivity.this);
    di.setTitle("File Maket ");
    di.setIcon(R.drawable.file);
    di.setMessage("File maket open file?");
    di.setNeutralButton(
        "open",
        (p, d) -> {
          _dataOnClickItemList(lastPos);
        });
    di.setPositiveButton("no", (p1, d2) -> {});

    di.show();
  }

  public void _dialoggits() {
    // FileDirActivity.this
    AlertDialog di =
        new MaterialAlertDialogBuilder(FileDirActivity.this)
            .setPositiveButton("clone", (w, r) -> {})
            .setView(R.layout.layout_gitclone)
            .setCancelable(false)
            .setNegativeButton(android.R.string.cancel, null)
            .create();
    di.setTitle("Git Clone");
    di.setMessage("Match Link Repository like in Download ");

    di.setOnShowListener(
        cc -> {
          EditText et = di.findViewById(R.id.et);
          TextInputLayout input = di.findViewById(R.id.input);
          ProgressBar bar = di.findViewById(R.id.bar);
          TextView tv = di.findViewById(R.id.tv);
          LinearLayout helper = di.findViewById(R.id.helper);
          helper.setVisibility(View.GONE);
          input.setBoxCornerRadii(20, 20, 20, 20);
          Button button = di.getButton(DialogInterface.BUTTON_POSITIVE);
          button.setOnClickListener(
              c1010108829 -> {
                CloneRepository cloneRepository = new CloneRepository();
                cloneRepository.setDirectory(new File(Folder));
                if (et != null) {
                  cloneRepository.setUrl(et.getText().toString());
                }

                cloneRepository.cloneRp(
                    new CloneRepository.OnGitChange() {
                      @Override
                      public void Start() {
                        runOnUiThread(() -> tv.setText("Start"));
                      }

                      @Override
                      public void BindTask(String string, int i) {
                        runOnUiThread(
                            () -> {
                              bar.setMax(i);
                              tv.setText(string);
                              helper.setVisibility(View.VISIBLE);
                              input.setVisibility(View.GONE);
                            });
                      }

                      @Override
                      public void UploadData(int upload) {
                        runOnUiThread(
                            () -> {
                              bar.setProgress(upload);
                            });
                      }

                      @Override
                      public void EndTask() {
                        runOnUiThread(
                            () -> {
                              bar.setProgress(0);
                              tv.setText("end");
                              helper.setVisibility(View.GONE);
                              input.setVisibility(View.VISIBLE);
                              reLoadFile(false);
                              di.dismiss();
                            });
                      }
                    });
              });
        });

    di.show();
  }

  @Override
  public void onLongClick(View view, int pos) {
    _newItemSheet(pos, view);
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (event.isCtrlPressed()) {
      switch (keyCode) {
        case KeyEvent.KEYCODE_S:
          // open settings
          startActivity(new Intent(getApplicationContext(), SettingAppActivity.class));
          return true;
        case KeyEvent.KEYCODE_F:
          /// open dialog make folder
          FolderMaker();
          return true;
        case KeyEvent.KEYCODE_F1:
          FileMaker();
          return true;
        case KeyEvent.KEYCODE_G:
          // git
          _dialoggits();
          return true;
        case KeyEvent.KEYCODE_D:
          // open drawer
          if (!_drawer.isOpen()) {
            _drawer.open();
          }
          return true;
        case KeyEvent.KEYCODE_J:
          // open gson to java
          var jsonToJava =
              new GsonToClass(
                  FileDirActivity.this,
                  Folder,
                  () -> {
                    reLoadFile();
                  });
          jsonToJava.run();
          return true;
        case KeyEvent.KEYCODE_T:
          // open terminal
          startActivity(new Intent(getApplicationContext(), TerminalActivity.class));
          return true;
        case KeyEvent.KEYCODE_A:
          // open apk manager;
          startActivity(new Intent(getApplicationContext(), ApkViewActivity.class));
          return true;
        case KeyEvent.KEYCODE_ESCAPE:
          BackPressed();
          return true;
      }
    }
    return super.onKeyDown(keyCode, event);
  }
}
