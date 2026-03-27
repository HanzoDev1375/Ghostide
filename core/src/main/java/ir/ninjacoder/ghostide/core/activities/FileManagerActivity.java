/**
 * Comment by ghost ide
 *
 * @author: Ninjacoder
 */
package ir.ninjacoder.ghostide.core.activities;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.*;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;

import android.view.MenuItem;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hzy.lib7z.Z7Extractor;
import com.ninjacoder.jgit.GitClone;
import com.ninjacoder.jgit.GsonToClass;
import com.ninjacoder.jgit.apk.ApkUtilData;
import com.ninjacoder.jgit.childer.LayoutBinder;
import com.ninjacoder.jgit.childer.TextFind;
import com.ninjacoder.jgit.childer.TextFindListener;
import com.ninjacoder.jgit.search.SearchCallBack;
import ir.ninjacoder.ghostide.core.NetworkChangeReceiver;
import ir.ninjacoder.ghostide.core.adapter.ToolbarListFileAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import ir.ninjacoder.ghostide.core.appupdate.UpadteAppView;
import ir.ninjacoder.ghostide.core.config.IconRes;
import ir.ninjacoder.ghostide.core.editor.PluginCompressorPgb;
import ir.ninjacoder.ghostide.core.editor.PluginExtractor;
import ir.ninjacoder.ghostide.core.editor.PluginextractorFace;
import ir.ninjacoder.ghostide.core.enums.FileConentChange;
import ir.ninjacoder.ghostide.core.git.GithubProfileImpl;
import ir.ninjacoder.ghostide.core.git.JgitHelperImpl;
import ir.ninjacoder.ghostide.core.marco.binder.ThemeChkerErrorBinder;
import ir.ninjacoder.ghostide.core.marco.binder.bindchilder.GhostToast;
import ir.ninjacoder.ghostide.core.marco.search.SearchBarImpl;
import ir.ninjacoder.ghostide.core.model.filemanager.FileManagerModel;
import ir.ninjacoder.ghostide.core.model.filemanager.FileState;
import ir.ninjacoder.ghostide.core.mult.MultiSelectionActionView;
import ir.ninjacoder.ghostide.core.mult.MultiSelectionAction;
import androidx.core.content.FileProvider;
import ir.ninjacoder.ghostide.core.mult.MultiSelectionManager;
import ir.ninjacoder.prograsssheet.GTheme;
import ir.ninjacoder.prograsssheet.view.RenameDialogFragmentImpl;
import net.lingala.zip4j.ZipFile;
import ir.ninjacoder.ghostide.core.utils.GhostFileUtilImpl;
import ir.ninjacoder.ghostide.core.widget.*;
import ir.ninjacoder.prograsssheet.search.GlobalSearchBottomSheet;
import ir.ninjacoder.prograsssheet.view.ParticleDisintegrationView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ir.ninjacoder.ghostide.PluginManager.IntentHelper;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.store.StoreAcitvity;
import ir.ninjacoder.ghostide.core.adapter.FileManagerAd;
import ir.ninjacoder.ghostide.core.adapter.ViewType;
import ir.ninjacoder.ghostide.core.compressor.TarGzExtractor;
import ir.ninjacoder.ghostide.core.compressor.XmlToSvg;
import ir.ninjacoder.ghostide.core.compressor.ZxExtractor;
import ir.ninjacoder.ghostide.core.marco.AS;
import ir.ninjacoder.ghostide.core.marco.ApkInstaller;
import ir.ninjacoder.ghostide.core.marco.ColorView;
import ir.ninjacoder.ghostide.core.marco.FileShareManager;
import ir.ninjacoder.ghostide.core.marco.FileTree;
import ir.ninjacoder.ghostide.core.marco.FtpDownloader;
import ir.ninjacoder.ghostide.core.marco.HsiZip;
import ir.ninjacoder.ghostide.core.marco.JadxDecompiler;
import ir.ninjacoder.ghostide.core.marco.NinjaMacroFileUtil;
import ir.ninjacoder.ghostide.core.pl.PluginChildRegistry;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.databin.FileMaker;
import ir.ninjacoder.ghostide.core.databinding.FiledirBinding;
import ir.ninjacoder.ghostide.core.filehelper.CreatorModule;
import ir.ninjacoder.ghostide.core.filehelper.FactoryModelProject;
import ir.ninjacoder.ghostide.core.git.GitListSheet;
import ir.ninjacoder.ghostide.core.interfaces.FileCallBack;
import ir.ninjacoder.ghostide.core.marco.binder.BindJpegWall;
import ir.ninjacoder.ghostide.core.marco.binder.BinderRecyclerview1;
import ir.ninjacoder.ghostide.core.marco.editorface.ClassNodePaserImpl;
import ir.ninjacoder.ghostide.core.model.IconShop;
import ir.ninjacoder.ghostide.core.model.ListSheet;
import ir.ninjacoder.ghostide.core.model.ZipFileShow;
import ir.ninjacoder.ghostide.core.model.dataobject.ShortcutInfoImpl;
import ir.ninjacoder.ghostide.core.pl.PluginLoaderImpl;
import ir.ninjacoder.ghostide.core.project.ProjectMaker;
import ir.ninjacoder.ghostide.core.recyclerview.RecyclerViewHelper;
import ir.ninjacoder.ghostide.core.services.FileEventUser;
import ir.ninjacoder.ghostide.core.tasks.FileWatcher;
import ir.ninjacoder.ghostide.core.tasks.FileWatcherService;
import ir.ninjacoder.ghostide.core.tasks.FileWatcherServiceConnection;
import ir.ninjacoder.ghostide.core.terminal.TerminalActivity;
import ir.ninjacoder.ghostide.core.utils.DialogUtil;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import ir.ninjacoder.ghostide.core.utils.VectorHelper;
import ir.ninjacoder.ghostide.core.widget.GhostWebMaterialDialog;
import ir.ninjacoder.ghostide.core.widget.component.fastscrollcompat.FastScrollerBuilder;
import ir.ninjacoder.prograsssheet.MusicSheet;
import ir.ninjacoder.prograsssheet.listchild.Child;
import ninja.coder.appuploader.data.SnippetManagerImpl;
import ninjacoder.ghostide.androidtools.r8.android.R8Tools;
import storage.sdcard.SdCardUtil;
import ir.ninjacoder.ghostide.core.layoutmanager.NavigationViewCompnet;

public class FileManagerActivity extends BaseCompat
    implements FileManagerAd.onClick,
        FileWatcher.OnFileChangeListener,
        FileManagerAd.OnFileOperationStateChangeListener,
        NetworkChangeReceiver.CallBackNetWork {

  public String Folder = "";
  protected SdCardUtil externalspace;
  protected AlertDialog maindialogPrfex;
  protected FastScrollerBuilder fast;
  protected FileEventUser user;
  private String staticstring = "";
  private FileManagerAd fileListItem;
  private String CreateFolder = "";
  private String GetTab = "";
  private String tab = "";
  private int n = 0;
  private ProjectMaker projectMaker;
  private double positionTabs = 0;
  protected SharedPreferences gridMode;
  private boolean staticStorage = false;
  private String version = "";
  private double post = 0;
  private int newpos = 0;
  private FiledirBinding bind;
  private List<String> list = new ArrayList<>();
  private List<String> folderList = new ArrayList<>();
  private List<String> fileList = new ArrayList<>();
  private List<FileManagerModel> fileModels = new ArrayList<>();
  private List<FileManagerModel> filteredFileModels = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> newlistmap = new ArrayList<>();
  private ArrayList<String> pv = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> upfile = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> projectdata = new ArrayList<>();
  private Intent intentgetSettings = new Intent();
  private SharedPreferences shp;
  private Intent activitiy = new Intent();
  private ProgressDialog unzip;
  private SharedPreferences soglo;
  private SharedPreferences np;
  private SharedPreferences dismoveFile;
  private ProgressDialog prodel;
  private ProgressDialog proveg;
  private Intent getabout = new Intent();
  private Intent void10 = new Intent();
  private SharedPreferences sd;
  private SharedPreferences delfile;
  private ProgressDialog copydir;
  private ProgressDialog copypath;
  private Intent getJavaLayoutManager = new Intent();
  private SharedPreferences zipCuntishen;
  private Intent govirwFilm = new Intent();
  private SharedPreferences war;
  private SearchBarImpl searchbarimpl;
  private Intent finalintentpostfont = new Intent();
  private Intent intentgetLogCat = new Intent();
  private SharedPreferences tmp;
  private Intent musicShow = new Intent();
  private SharedPreferences base;
  private SharedPreferences save_path;
  private SharedPreferences materialYou;
  private SharedPreferences book;
  private ArrayList<HashMap<String, Object>> a = new ArrayList<>();
  private HashMap<String, Object> mapz32 = new HashMap<>();
  private GridLayoutManager gridLayoutManager;
  private SharedPreferences sharedPreferences;
  private FileWatcherServiceConnection fileEventRelay;
  private boolean isFileWatcherBound = false;
  private ShortcutInfoImpl sh;
  private ExecutorService executor;
  private View mview;
  private List<Child> listchild = new ArrayList<>();
  private boolean fileWatcherBindingRequested = false, isMultiSelectionMode = false;
  private NetworkChangeReceiver networkChangeReceiver;
  private MultiSelectionActionView multiSelectionView;
  private View.OnClickListener fabOriginalClickListener;
  private List<String> copyPaths = new ArrayList<>();
  private boolean isCopyMode = true;

  private int currentPosition = 0;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    bind = FiledirBinding.inflate(LayoutInflater.from(this));
    ViewCompat.setOnApplyWindowInsetsListener(
        bind.getRoot(),
        (v, insets) -> {
          Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
          v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
          return insets;
        });

    setContentView(bind.getRoot());
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

    gridLayoutManager = new GridLayoutManager(this, 1);
    if (gridLayoutManager != null) {
      bind.recyclerview2.setLayoutManager(gridLayoutManager);
    }
    gridMode = getSharedPreferences("gride", Activity.MODE_PRIVATE);
    fileListItem = new FileManagerAd(FileManagerActivity.this, this, listchild);
    fileModels = new ArrayList<>();
    filteredFileModels = new ArrayList<>();
    bind.recyclerview2.setAdapter(fileListItem);

    fileListItem.submitList(new ArrayList<>(fileModels));
    fileListItem.setOnFileOperationStateChangeListener(this);
    shp = getSharedPreferences("shp", Activity.MODE_PRIVATE);
    soglo = getSharedPreferences("soglo", Activity.MODE_PRIVATE);
    np = getSharedPreferences("np", Activity.MODE_PRIVATE);
    dismoveFile = getSharedPreferences("DismoveFile", Activity.MODE_PRIVATE);
    sd = getSharedPreferences("sd", Activity.MODE_PRIVATE);
    delfile = getSharedPreferences("delfile", Activity.MODE_PRIVATE);
    zipCuntishen = getSharedPreferences("zipCuntishen", Activity.MODE_PRIVATE);
    war = getSharedPreferences("war", Activity.MODE_PRIVATE);
    tmp = getSharedPreferences("tmp", Activity.MODE_PRIVATE);
    base = getSharedPreferences("base", Activity.MODE_PRIVATE);
    save_path = getSharedPreferences("save_path", Activity.MODE_PRIVATE);
    materialYou = getSharedPreferences("materialYou", Activity.MODE_PRIVATE);
    executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    book = getSharedPreferences(FileBookmarkActivity.keybookmark, Activity.MODE_PRIVATE);
    sh = new ShortcutInfoImpl(FileManagerActivity.this, Folder);
    new PluginLoaderImpl().runInFileManager(this);
    networkChangeReceiver = new NetworkChangeReceiver(this);
    IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
    this.registerReceiver(networkChangeReceiver, filter);
    multiSelectionView = bind.multiSelectionActions;
    if (multiSelectionView != null) {
      setupMultiSelection();

      if (fileListItem != null && fileListItem.getSelectionManager() != null) {
        fileListItem
            .getSelectionManager()
            .setOnSelectionChangedListener(
                (selectedCount, isSelectionMode) -> {
                  runOnUiThread(
                      () -> {
                        Log.d(
                            "MultiSelection",
                            "Listener: selectedCount="
                                + selectedCount
                                + ", isSelectionMode="
                                + isSelectionMode);
                        if (fileListItem.isMultiSelectionEnabled() && selectedCount > 0) {
                          if (multiSelectionView != null) {
                            multiSelectionView.setSelectedCount(selectedCount);
                            if (!multiSelectionView.isShowing()) {
                              multiSelectionView.show();
                            }
                          }
                        } else {
                          if (multiSelectionView != null && multiSelectionView.isShowing()) {
                            multiSelectionView.hide();
                          }
                        }
                      });
                });
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
      getWindow().setNavigationBarColor(MaterialColors.getColor(this, ObjectUtils.Back, 0));
    if (Build.VERSION.SDK_INT >= 21)
      getWindow()
          .setStatusBarColor(
              MaterialColors.getColor(this, ObjectUtils.colorSurfaceContainerHigh, 0));
    getWindow()
        .getDecorView()
        .setBackgroundColor(
            MaterialColors.getColor(this, ObjectUtils.colorSurfaceContainerHigh, 0));

    bind.searchbar.setCallBack(
        new SearchCallBack() {
          @Override
          public void onTextChange(String text) {
            if (fileListItem != null) {
              fileListItem.filter(text);
            }
          }

          @Override
          public void onafterTextChanged(Editable edit, String code) {
            if (edit.toString().isEmpty()) {
              fileListItem.clearFilter();
            }
          }
        });
    if (getIntent().hasExtra("filePath")) {
      String filePath = getIntent().getStringExtra("filePath");
      if (filePath != null && new File(filePath).exists()) {
        Folder = filePath;
        reLoadFile();
      } else {
        DataUtil.showMessage(this, "خطا: مسیر فایل نامعتبر است!");
      }
    }
    bind.viewChild.setVisibility(View.GONE);
    searchbarimpl = new SearchBarImpl(bind.searchbar, bind.searchfiledir);
    bind.searchfiledir.setOnClickListener(
        v -> {
          searchbarimpl.bindSearch();
        });
    BackPressed();
    TypeChange();
    ThemeChaker();
    setupSearchModeMenu();
    mview = findViewById(R.id.view_filedir);
    GithubProfileImpl.bindByActivity(bind.githubusernametv, bind.githubavataric);
    bind.opendraw.setOnClickListener(
        c -> {
          bind.Drawer.open();
        });
    LayoutBinder.of(mview, ObjectUtils.Back);
    var helper =
        new RecyclerViewHelper(
            bind.recyclerview2,
            new RecyclerViewHelper.CallBackHelper() {

              @Override
              public void CallBackLeft(int pos) {
                if (pos >= 0 && pos < fileModels.size()) {
                  FileManagerModel mmap = fileModels.get(pos);
                  fileListItem.updateItem(pos, mmap);
                  MakeZipFileFromThread(pos);
                }
              }

              @Override
              public void CallBackRight(int pos) {
                if (pos >= 0 && pos < fileModels.size()) {
                  FileManagerModel mmap = fileModels.get(pos);
                  fileListItem.updateItem(pos, mmap);
                  removedFiles(pos);
                }
              }
            });

    projectMaker =
        new ProjectMaker(
            Folder,
            FileManagerActivity.this,
            () -> {
              reLoadFile();
            });
    // setDistreeView();

    List<Child> pluginChildren = PluginChildRegistry.getFileManagerChildren();
    for (Child child : pluginChildren) {
      addChild(child);
    }
  }

  public FileManagerAd getFileManagerAd() {
    return fileListItem;
  }

  private int getOriginalPosition(int filteredPosition) {
    if (fileListItem != null) {
      return fileListItem.getOriginalPosition(filteredPosition);
    }
    return -1;
  }

  private void setupMultiSelection() {
    if (multiSelectionView == null) return;

    multiSelectionView.removeAllActions();
    multiSelectionView.addAction(MultiSelectionAction.COPY);
    multiSelectionView.addAction(MultiSelectionAction.MOVE);
    multiSelectionView.addAction(MultiSelectionAction.DELETE);
    multiSelectionView.addAction(MultiSelectionAction.SHARE);
    // multiSelectionView.addAction(MultiSelectionAction.ZIP);
    multiSelectionView.addAction(MultiSelectionAction.RENAME);
    // MORE حذف شد چون خودت داری

    multiSelectionView.setOnActionClickListener(
        new MultiSelectionActionView.OnActionClickListener() {
          @Override
          public void onActionClick(MultiSelectionAction action) {
            performMultiSelectionAction(action);
          }

          @Override
          public void onCloseClick() {
            exitMultiSelectionMode();
          }

          @Override
          public void onSelectAllClick(boolean isChecked) {
            if (fileListItem != null && fileListItem.getSelectionManager() != null) {
              if (isChecked) {
                // انتخاب همه
                fileListItem.getSelectionManager().selectAll(fileModels.size());
              } else {
                isMultiSelectionMode = true;
                fileListItem.getSelectionManager().selectAll(0);
                // fileListItem.getSelectionManager().clearSelection();
                // if (!multiSelectionView.isShowing()) {
                // multiSelectionView.show();
                // }
              }
              fileListItem.notifyDataSetChanged();

              int count = fileListItem.getSelectionManager().getSelectedCount();
              if (count > 0) {
                multiSelectionView.setSelectedCount(count);
              } // else {
              // exitMultiSelectionMode();
              // }
            }
          }
        });
  }

  @Override
  public void onStateChanged(FileConentChange newState) {
    runOnUiThread(
        () -> {
          var fabState = newState;
          for (var entry : fileListItem.getFileContentStatesMap().entrySet()) {
            if (entry.getValue() != FileConentChange.NONE) {
              fabState = entry.getValue();
              break;
            }
          }
          bind.fabAdd.setIconResource(fabState.getValue());
          ObjectUtils.setFab(bind.fabAdd);
        });
  }

  void TypeChange() {
    if (gridMode.contains("gride")) {
      setViewType(ViewType.GRID);
    } else {
      setViewType(ViewType.ROW);
    }
  }

  public void enterMultiSelectionMode(int count) {
    if (isMultiSelectionMode) return;
    isMultiSelectionMode = true;
    if (multiSelectionView != null) {
      multiSelectionView.setSelectedCount(count);
      multiSelectionView.show();
    }
  }

  public void exitMultiSelectionMode() {
    Log.d("MultiSelection", "exitMultiSelectionMode called");

    if (!isMultiSelectionMode) {
      Log.d("MultiSelection", "Already not in multi selection mode");
      return;
    }

    isMultiSelectionMode = false;

    if (fileListItem != null) {
      fileListItem.enableMultiSelection(false);
    }

    if (multiSelectionView != null && multiSelectionView.isShowing()) {
      multiSelectionView.hide();
    }
    Log.d("MultiSelection", "Exit completed");
  }

  private void performMultiSelectionAction(MultiSelectionAction action) {
    List<String> selectedPaths =
        fileListItem.getSelectionManager().getSelectedPaths(fileListItem.getAllFilesList());

    if (selectedPaths.isEmpty()) {
      exitMultiSelectionMode();
      return;
    }
    if (action == MultiSelectionAction.COPY) {
      if (fileListItem != null) {
        fileListItem.getSelectionManager().clearSelection();
      }
      isMultiSelectionMode = true;
      copySelectedFiles(selectedPaths);
      return;
    } else if (action == MultiSelectionAction.MOVE) {
      if (fileListItem != null) {
        fileListItem.getSelectionManager().clearSelection();
      }
      isMultiSelectionMode = true;
      moveSelectedFiles(selectedPaths);
      return;
    } else {
      exitMultiSelectionMode();
    }

    switch (action) {
      case DELETE:
        deleteSelectedFiles(selectedPaths);
        break;
      case SHARE:
        shareSelectedFiles(selectedPaths);
        break;
      case MORE:
        // zipSelectedFiles(selectedPaths);
        break;
      case RENAME:
        if (selectedPaths.size() == 1) {
          int pos = fileListItem.getSelectionManager().getSelectedPositions().get(0);
          setRenameFile(pos);
        } else {
          Toast.makeText(this, "فقط یک فایل میتونه تغییر نام بده", Toast.LENGTH_SHORT).show();
        }
        break;
    }
  }

  private void copySelectedFiles(List<String> paths) {
    copyPaths.clear();
    copyPaths.addAll(paths);
    isCopyMode = true;
    Toast.makeText(this, paths.size() + " فایل برای انتقال ذخیره شد", Toast.LENGTH_SHORT).show();
    multiSelectionView.setActionCopyLayout(
        "past",
        R.drawable.paste_white,
        it -> {
          fileListItem.getSelectionManager().clearSelection();
          if (fileListItem != null) {
            fileListItem.enableMultiSelection(false);
          }
          if (Folder == null || Folder.isEmpty()) {
            Toast.makeText(it.getContext(), "مسیر مقصد نامعتبر است", Toast.LENGTH_SHORT).show();
            return;
          }
          if (copyPaths.isEmpty()) {
            Toast.makeText(it.getContext(), "هیچ فایلی انتخاب نشده است", Toast.LENGTH_SHORT).show();
            return;
          }
          for (String path : copyPaths) {
            FileUtil.moveFileOrDirByGhostide(
                path,
                Folder,
                new FileUtil.OnFileChangeCall() {
                  @Override
                  public void onFileDone() {
                    reLoadFile();
                    multiSelectionView.setResetActionCopyLayout();
                  }

                  @Override
                  public void onFileError(String error) {
                    multiSelectionView.setResetActionCopyLayout();
                  }
                },
                true,
                it.getContext());
          }
          copyPaths.clear();
          isMultiSelectionMode = false;
        });
  }

  private void moveSelectedFiles(List<String> paths) {
    copyPaths.clear();
    copyPaths.addAll(paths);
    isCopyMode = false;

    Toast.makeText(this, paths.size() + " فایل برای انتقال ذخیره شد", Toast.LENGTH_SHORT).show();
    multiSelectionView.setActionMoveLayout(
        "past",
        R.drawable.paste_white,
        it -> {
          fileListItem.getSelectionManager().clearSelection();
          if (fileListItem != null) {
            fileListItem.enableMultiSelection(false);
          }
          if (Folder == null || Folder.isEmpty()) {
            Toast.makeText(it.getContext(), "مسیر مقصد نامعتبر است", Toast.LENGTH_SHORT).show();
            return;
          }

          if (copyPaths.isEmpty()) {
            Toast.makeText(it.getContext(), "هیچ فایلی انتخاب نشده است", Toast.LENGTH_SHORT).show();
            return;
          }

          for (String path : copyPaths) {
            FileUtil.moveFileOrDirByGhostide(
                path,
                Folder,
                new FileUtil.OnFileChangeCall() {
                  @Override
                  public void onFileDone() {
                    reLoadFile();
                    multiSelectionView.setResetActionMoveLayout();
                  }

                  @Override
                  public void onFileError(String error) {
                    multiSelectionView.setResetActionMoveLayout();
                  }
                },
                false,
                it.getContext());
          }

          copyPaths.clear();
          isMultiSelectionMode = false;
        });
  }

  private void deleteSelectedFiles(List<String> paths) {
    new MaterialAlertDialogBuilder(this)
        .setTitle("حذف فایل ها")
        .setMessage("آیا از حذف " + paths.size() + " فایل اطمینان دارید؟")
        .setPositiveButton(
            "حذف",
            (d, i) -> {
              new AsyncTask<Void, Void, Boolean>() {
                @Override
                protected Boolean doInBackground(Void... voids) {
                  for (String path : paths) {
                    FileUtil.deleteFile(path);
                  }
                  return true;
                }

                @Override
                protected void onPostExecute(Boolean result) {
                  multiSelectionView.showProgress(false);
                  reLoadFile();
                  Toast.makeText(
                          FileManagerActivity.this,
                          paths.size() + " فایل حذف شد",
                          Toast.LENGTH_SHORT)
                      .show();
                  exitMultiSelectionMode();
                }
              }.execute();
            })
        .setNegativeButton("انصراف", null)
        .show();
  }

  private void shareSelectedFiles(List<String> paths) {
    ArrayList<Uri> uris = new ArrayList<>();
    for (String path : paths) {
      File file = new File(path);
      Uri uri = FileProvider.getUriForFile(this, getPackageName() + ".provider", file);
      uris.add(uri);
    }

    Intent shareIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
    shareIntent.setType("*/*");
    shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    startActivity(Intent.createChooser(shareIntent, "اشتراک گذاری"));

    exitMultiSelectionMode();
  }

  private void zipSelectedFilesAsync(List<String> paths) {
    String zipName = "archive_" + System.currentTimeMillis() + ".zip";
    String zipPath = Folder + "/" + zipName;

    multiSelectionView.showProgress(true);

    new AsyncTask<Void, Integer, Boolean>() {
      private String errorMessage = "";

      @Override
      protected void onPreExecute() {
        Toast.makeText(
                FileManagerActivity.this,
                "در حال فشرده سازی " + paths.size() + " فایل...",
                Toast.LENGTH_SHORT)
            .show();
      }

      @Override
      protected Boolean doInBackground(Void... params) {
        try {
          ZipFile zipFile = new ZipFile(zipPath);
          int total = paths.size();
          int current = 0;

          for (String path : paths) {
            File file = new File(path);
            if (file.isDirectory()) {
              zipFile.addFolder(file);
            } else {
              zipFile.addFile(file);
            }
            current++;
            publishProgress(current, total);
          }
          return true;
        } catch (Exception e) {
          errorMessage = e.getMessage();
          return false;
        }
      }

      @Override
      protected void onProgressUpdate(Integer... values) {

        Log.d("ZIP", "Progress: " + values[0] + "/" + values[1]);
      }

      @Override
      protected void onPostExecute(Boolean success) {
        multiSelectionView.showProgress(false);

        if (success) {
          Toast.makeText(
                  FileManagerActivity.this, "فشرده سازی انجام شد: " + zipName, Toast.LENGTH_SHORT)
              .show();
          reLoadFile();
        } else {
          Toast.makeText(FileManagerActivity.this, "خطا: " + errorMessage, Toast.LENGTH_SHORT)
              .show();
        }

        exitMultiSelectionMode();
      }
    }.execute();
  }

  public ExrtaFab getFab() {
    return bind.fabAdd;
  }

  public NavigationViewCompnet getNav() {
    return bind.navs;
  }

  @Override
  public void ConnectionIS() {
    appUpdate();
  }

  @Override
  public void ConnectionNOT() {}

  private void setupSearchModeMenu() {
    bind.searchbar.setShowAvatar(true);
    bind.searchbar.showAvatarByGlideRes(R.drawable.ic_more_vert_white);
    bind.searchbar.setAvatarOnClickListener(
        v -> {
          var popup = new PopupMenu(this, v);
          var menu = popup.getMenu();
          var item1 = menu.add(0, 1, 0, getString(R.string.search_normal)).setCheckable(true);
          var item2 = menu.add(0, 2, 0, getString(R.string.search_regex)).setCheckable(true);
          var item3 = menu.add(0, 3, 0, getString(R.string.search_regex_case)).setCheckable(true);
          var item4 =
              menu.add(0, 4, 0, getString(R.string.search_regex_multiline)).setCheckable(true);
          var item5 = menu.add(0, 5, 0, getString(R.string.search_regex_dotall)).setCheckable(true);
          menu.setQwertyMode(true);

          var currentMode = fileListItem.getCurrentSearchMode();
          MenuItem checkedItem = null;
          switch (currentMode) {
            case NORMAL:
              checkedItem = item1;
              break;
            case REGEX:
              checkedItem = item2;
              break;
            case REGEX_CASE_INSENSITIVE:
              checkedItem = item3;
              break;
            case REGEX_MULTILINE:
              checkedItem = item4;
              break;
            case REGEX_DOTALL:
              checkedItem = item5;
              break;
            default:
              checkedItem = item1;
              break;
          }

          if (checkedItem != null) {
            checkedItem.setChecked(true);
          }

          popup.setOnMenuItemClickListener(
              item -> {
                FileManagerAd.SearchMode newMode;

                switch (item.getItemId()) {
                  case 1:
                    newMode = FileManagerAd.SearchMode.NORMAL;
                    break;
                  case 2:
                    newMode = FileManagerAd.SearchMode.REGEX;
                    break;
                  case 3:
                    newMode = FileManagerAd.SearchMode.REGEX_CASE_INSENSITIVE;
                    break;
                  case 4:
                    newMode = FileManagerAd.SearchMode.REGEX_MULTILINE;
                    break;
                  case 5:
                    newMode = FileManagerAd.SearchMode.REGEX_DOTALL;
                    break;
                  default:
                    newMode = FileManagerAd.SearchMode.NORMAL;
                    break;
                }

                fileListItem.setSearchMode(newMode);
                List<MenuItem> menus = Arrays.asList(item1, item2, item3, item4, item5);
                menus.forEach(i -> i.setChecked(i == item));

                var searchText = bind.searchbar.getText();
                if (!TextUtils.isEmpty(searchText)) {
                  fileListItem.filter(searchText.toString());
                }

                return true;
              });

          popup.show();
        });
  }

  private void bindFileWatcherService(File file) {
    if (fileEventRelay != null && fileEventRelay.isConnected()) {
      fileEventRelay.setFileToWatch(file);
      return;
    }

    if (fileEventRelay != null) {
      unbindFileWatcherService();
    }

    fileEventRelay = new FileWatcherServiceConnection(this);
    fileEventRelay.setFileToWatch(file);
    Intent intent = new Intent(this, FileWatcherService.class);

    try {
      startForegroundService(intent);
      fileWatcherBindingRequested = true;

      if (bindService(intent, fileEventRelay, Context.BIND_IMPORTANT)) {
        Log.d("TAG", "Binding to FileWatcherService requested");
      } else {
        fileWatcherBindingRequested = false;
        Log.e("TAG", "Failed to bind to FileWatcherService");
      }
    } catch (SecurityException e) {
      fileWatcherBindingRequested = false;
      Log.e("TAG", "Security exception binding to service", e);
    }
  }

  private void unbindFileWatcherService() {
    if (fileEventRelay != null) {
      if (fileEventRelay.isConnected() || !fileWatcherBindingRequested) {
        fileEventRelay.removeListenerFromService();
        unbindService(fileEventRelay);
      }
      fileEventRelay = null;
    }
    fileWatcherBindingRequested = false;
  }

  @Override
  public void onFileChanged(int event, String path) {}

  public String getSavePathByStringPrfns() {
    return save_path.getString("path", "");
  }

  public String getFolder() {
    return Folder;
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
    bindFileWatcherService(new File(save_path.getString("path", "")));
    Log.w("FilePath", save_path.getString("path", ""));
  }

  void setViewType(ViewType viewType) {
    if (fileListItem != null) {
      fileListItem.setViewType(viewType);
      if (viewType == ViewType.GRID) {
        gridLayoutManager.setSpanCount(2);
      } else {

        gridLayoutManager.setSpanCount(1);
        fast = new FastScrollerBuilder(bind.recyclerview2);
        fast.useMd2Style();
        fast.build();
      }
    }
  }

  private void initStartApp() {
    getWindow()
        .setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    unzip = new ProgressDialog(FileManagerActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    prodel = new ProgressDialog(FileManagerActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    proveg = new ProgressDialog(FileManagerActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    copydir =
        new ProgressDialog(FileManagerActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    copypath =
        new ProgressDialog(FileManagerActivity.this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    GradientDrawable u = new GradientDrawable();
    u.setColor(MaterialColors.getColor(this, ObjectUtils.Back, 0));
    u.setCornerRadius(25);
    u.setStroke(1, MaterialColors.getColor(this, ObjectUtils.TvColor, 0));
    externalspace = new SdCardUtil(this);
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
    sharedPreferences = getSharedPreferences("fileSp", Context.MODE_PRIVATE);
    RefreshTabs();

    AnimUtils.Worker(bind.fabAdd);

    FileConentChange currentState = FileConentChange.NONE;
    String currentFilePath = null;

    for (var entry : fileListItem.getFileContentStatesMap().entrySet()) {
      if (entry.getValue() != FileConentChange.NONE) {
        currentState = entry.getValue();
        currentFilePath = entry.getKey();
        break;
      }
    }

    GhostFileUtilImpl.changeIconFab(bind.fabAdd, currentState);
    ObjectUtils.setFab(bind.fabAdd);

    bind.fabAdd.setOnClickListener(
        v -> {
          FileConentChange fabState = FileConentChange.NONE;
          String filePath = null;

          for (var entry : fileListItem.getFileContentStatesMap().entrySet()) {
            if (entry.getValue() != FileConentChange.NONE) {
              fabState = entry.getValue();
              filePath = entry.getKey();
              break;
            }
          }

          switch (fabState) {
            case COPYING:
            case MOVEING:
              if (filePath != null) {
                GhostFileUtilImpl.impl(fabState, Folder, filePath, FileManagerActivity.this);
              }

              fileListItem.getFileContentStatesMap().clear();
              fileListItem.notifyDataSetChanged();

              bind.fabAdd.setIconResource(FileConentChange.NONE.getValue());
              ObjectUtils.setFab(bind.fabAdd);
              break;
            case NONE:
              DialogItemSheet();
              break;
          }
        });

    bind.navs.bindView(bind.Drawer);
    bind.navs
        .getMenu()
        .add(0, 1, 0, getString(R.string.menu_sandisk_card))
        .setIcon(R.drawable.drawer_item12);
    bind.navs
        .getMenu()
        .add(0, 2, 0, getString(R.string.menu_java_code))
        .setIcon(R.drawable.drawer_item14);
    bind.navs
        .getMenu()
        .add(0, 3, 0, getString(R.string.menu_terminal))
        .setIcon(R.drawable.drawer_item13);

    bind.navs
        .getMenu()
        .add(0, 4, 0, getString(R.string.menu_settings))
        .setIcon(R.drawable.drawer_item15);
    bind.navs
        .getMenu()
        .add(0, 5, 0, getString(R.string.menu_logcat_reader))
        .setIcon(R.drawable.drawer_item6);
    bind.navs.getMenu().add(0, 6, 0, getString(R.string.menu_icon_shop)).setIcon(R.drawable.icshop);
    bind.navs
        .getMenu()
        .add(0, 7, 0, getString(R.string.menu_update_app))
        .setIcon(R.drawable.drawer_item8);
    bind.navs
        .getMenu()
        .add(0, 8, 0, getString(R.string.menu_plugins_manager))
        .setIcon(R.drawable.drawer_item5);
    bind.navs
        .getMenu()
        .add(0, 9, 0, getString(R.string.menu_backup_theme))
        .setIcon(R.drawable.drawer_item7);
    bind.navs
        .getMenu()
        .add(0, 10, 0, getString(R.string.menu_bookmarks_beta))
        .setIcon(R.drawable.drawer_item4);
    bind.navs
        .getMenu()
        .add(0, 11, 0, getString(R.string.menu_apk_manager))
        .setIcon(R.drawable.drawer_item3);
    bind.navs
        .getMenu()
        .add(0, 12, 0, getString(R.string.menu_about))
        .setIcon(R.drawable.drawer_item11);
    bind.navs.getMenu().add(0, 14, 0, getString(R.string.menu_store)).setIcon(R.drawable.shop_24);
    bind.navs
        .getMenu()
        .add(0, 13, 0, getString(R.string.menu_exit))
        .setIcon(R.drawable.drawer_item1);

    DrowerHandler();
  }

  public void BackPressed() {
    getOnBackPressedDispatcher()
        .addCallback(
            this,
            new OnBackPressedCallback(true) {

              @Override
              public void handleOnBackPressed() {
                if (externalspace.hasRealRemovableSdCarde()) {
                  if (Folder.equals(FileUtil.getExternalStorageDir())
                      || Folder.equals(externalspace.getExtSdPath())) {
                    finishAffinity();
                  } else {
                    Folder = Folder.substring(0, Folder.lastIndexOf("/"));
                    reLoadFile();
                  }
                } else {
                  if (Folder.equals(FileUtil.getExternalStorageDir())) {
                    finishAffinity();
                  } else {
                    Folder = Folder.substring(0, Folder.lastIndexOf("/"));
                    reLoadFile();
                  }
                }
                bind.searchbar.setText("");
                fileListItem.clearFilter();
              }
            });
  }

  @Override
  public void onResume() {
    super.onResume();
    RefreshTabs();
    TypeChange();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    unbindFileWatcherService();
    stopService(new Intent(this, FileWatcherService.class));
    if (executor != null) {
      executor.shutdown();
    }
    this.unregisterReceiver(networkChangeReceiver);
  }

  public void reLoadFile(boolean isSortFile) {
    bind.recyclerview2.setVisibility(View.GONE);
    bind.filedirBar.setVisibility(View.VISIBLE);

    executor.execute(
        () -> {
          try {
            save_path.edit().putString("path", Folder).apply();
            list.clear();
            fileModels.clear();
            folderList.clear();
            fileList.clear();
            FileUtil.listDir(Folder, list);
            Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
            GetTab = Folder;

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

            for (String item : list) {
              if (FileUtil.isDirectory(item)) {
                folderList.add(item);
              } else {
                fileList.add(item);
              }
            }

            List<FileManagerModel> folderItems = new ArrayList<>();
            for (String item : folderList) {
              FileManagerModel _item = new FileManagerModel(item, FileState.NORMAL);
              folderItems.add(_item);
            }

            List<FileManagerModel> fileItems = new ArrayList<>();
            for (String item : fileList) {
              FileManagerModel _item = new FileManagerModel(item, FileState.NORMAL);
              fileItems.add(_item);
            }
            fileModels.clear();
            fileModels.addAll(folderItems);
            fileModels.addAll(fileItems);

          } catch (Exception e) {
            runOnUiThread(
                () -> DataUtil.showMessage(getApplicationContext(), "Error: " + e.toString()));
          }
          runOnUiThread(
              () -> {
                bind.recyclerview2.setVisibility(View.VISIBLE);
                bind.filedirBar.setVisibility(View.GONE);
                fileListItem.clearFilter();
                // setDistreeView();
                fileListItem.submitList(new ArrayList<>(fileModels));
                if (fileModels.isEmpty()) {
                  bind.emptyview.show();
                } else {
                  bind.emptyview.hide();
                }
              });
        });
  }

  public void reLoadFile() {
    reLoadFile(true);
  }

  public void updateList() {
    if (fileListItem != null && bind != null && bind.recyclerview2 != null) {
      runOnUiThread(
          () -> {
            fileListItem.submitList(new ArrayList<>(fileModels));
            String currentText = bind.searchbar.getText().toString();
            if (currentText != null && !currentText.isEmpty()) {
              fileListItem.filter(currentText);
            }
          });
    }
  }

  void FolderMaker() {
    var dialog =
        new GhostWebMaterialDialog(FileManagerActivity.this)
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
          editor.setHint("Name Folder");
          top.setCounterMaxLength(200);
          top.setEndIconTintMode(PorterDuff.Mode.MULTIPLY);
          top.setEndIconDrawable(R.drawable.close);
          top.setEndIconOnClickListener(
              v -> {
                editor.setText("");
              });
          positive.setOnClickListener(
              (__) -> {
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
                            Toast.makeText(getApplicationContext(), content, 2).show();
                            if (bind.recyclerview2 != null) {
                              reLoadFile();
                            }
                          }

                          @Override
                          public void onError(String e) {
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
                public void afterTextChanged(Editable _param1) {}
              });
        });
    dialog.show();
  }

  private int findFilePositionByPath(String filePath) {
    for (int i = 0; i < fileModels.size(); i++) {
      if (fileModels.get(i).getFilePath().equals(filePath)) {
        return i;
      }
    }
    return -1;
  }

  private void removeFileFromLists(String filePath) {
    for (int i = 0; i < fileModels.size(); i++) {
      if (fileModels.get(i).getFilePath().equals(filePath)) {
        fileModels.remove(i);
        break;
      }
    }
    fileListItem.removeItemByPath(filePath);

    runOnUiThread(
        () -> {
          if (fileModels.isEmpty()) {
            if (!bind.emptyview.isShowing()) {
              bind.emptyview.show();
            }
          } else {
            if (bind.emptyview.isShowing()) {
              bind.emptyview.hide();
            }
          }
        });
  }

  private void updateFileInLists(String oldPath, String newPath) {
    for (int i = 0; i < fileModels.size(); i++) {
      FileManagerModel item = fileModels.get(i);
      if (item.getFilePath().equals(oldPath)) {
        item.setFilePath(newPath);
        fileModels.set(i, item);
        fileListItem.updateItem(i, item);
        break;
      }
    }
  }

  void setDistreeView(int pos) {
    // var model = fileListItem.getItem(pos);
    // if (model == null) return;
    // String path = model.getFilePath();
    // List<String> items = spiltIntoBreadcrumbItems(path);

    // ToolbarListFileAdapter adapter =
    // new ToolbarListFileAdapter(
    // items,
    // this,
    // new ToolbarListFileAdapter.CallBack() {
    // @Override
    // public void GoToDir(View view, int pos, String dirs) {
    // if ("/storage/emulated/".equals(dirs)) {
    // return;
    // }
    // if (FileUtil.isDirectory(dirs)) {
    // setFolder(dirs);
    // reLoadFile();
    // } else {
    // GhostToast.showWarning(FileManagerActivity.this, "This not Directory");
    // }
    // }

    // @Override
    // public void GoToTreeFile(View view, int pos, String dir) {}
    // });

    // bind.treerv.setAdapter(adapter);
    // bind.treerv.setLayoutManager(
    // new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    // bind.treerv.smoothScrollToPosition(items.size());
  }

  List<String> spiltIntoBreadcrumbItems(String filePath) {
    String separator = "/";
    String[] items = filePath.split(separator);
    List<String> fullPaths = new ArrayList<>();
    StringBuilder currentPath = new StringBuilder();

    for (String item : items) {
      if (!item.trim().isEmpty()) {
        if (currentPath.length() > 0) {
          currentPath.append(separator);
        }
        currentPath.append(item);
        fullPaths.add(currentPath.toString());
      }
    }

    return fullPaths;
  }

  @Override
  public void onChildFile(int pos) {
    // TODO: Implement this method
    setDistreeView(pos);
  }

  @Override
  public void onClick(View view, int pos) {
    if (fileListItem.isMultiSelectionEnabled()) {
      return;
    }
    FileManagerModel item = fileListItem.getItem(pos);
    if (item == null) return;
    currentPosition = pos;

    String path = item.getFilePath();
    staticstring = path;

    fileListItem.clearFilter();
    bind.searchbar.setText("");

    if (FileUtil.isDirectory(path)) {
      Folder = path;
      setDistreeView(pos);
      reLoadFile();
      return;
    }
    int realPos = findFilePositionByPath(path);
    if (realPos != -1) {
      _dataOnClickItemList(realPos);
    }
  }

  @Override
  public void onLongClick(View view, int pos) {
    Log.d("MultiSelection", "onLongClick called at position: " + pos);
  }

  public void removedFiles(int _pos) {
    if (_pos < 0 || _pos >= fileModels.size()) {
      Log.e("FileManager", "Invalid position in removedFiles: " + _pos);
      return;
    }

    String filePath = fileModels.get(_pos).getFilePath();
    String fileName = new File(filePath).getName();

    var di = new DialogUtil(FileManagerActivity.this);
    di.setTitle("Removed?");
    di.setMessage("Are you sure you want to " + fileName);
    di.setNeutralButton("no", null);
    di.setPositiveButton(
        "yes",
        (p1, d2) -> {
          new AsyncTask<String, String, String>() {
            @Override
            protected void onPreExecute() {
              prodel.setTitle("deleting...");
              prodel.setMessage("deleting " + fileName);
              prodel.setCancelable(false);
              prodel.setCanceledOnTouchOutside(false);
              prodel.show();
            }

            @Override
            protected String doInBackground(String... params) {
              String path = params[0];
              FileUtil.deleteFile(path);
              return path;
            }

            @Override
            protected void onPostExecute(String deletedPath) {
              prodel.dismiss();
              removeFileFromLists(deletedPath);
              runOnUiThread(
                  () -> {
                    if (fileModels.isEmpty()) {
                      if (!bind.emptyview.isShowing()) {
                        bind.emptyview.show();
                      }
                    } else {
                      if (bind.emptyview.isShowing()) {
                        bind.emptyview.hide();
                      }
                    }
                  });

              Toast.makeText(
                      getApplicationContext(), "This file has been deleted", Toast.LENGTH_SHORT)
                  .show();
            }
          }.execute(filePath);
        });
    di.build();
  }

  public void setRenameFile(int _pos) {
    int position = _pos;
    if (position < 0 || position >= fileModels.size()) {
      Log.e("FileManager", "Invalid position in setRenameFile: " + position);
      return;
    }

    String currentPath = fileModels.get(position).getFilePath();
    String currentName = new File(currentPath).getName();
    RenameDialogFragmentImpl.impl(
        currentName,
        this,
        newName -> {
          File oldFile = new File(currentPath);
          File parentDir = oldFile.getParentFile();

          if (parentDir != null) {
            File newFile = new File(parentDir, newName);
            if (oldFile.renameTo(newFile)) {

              updateFileInLists(currentPath, newFile.getAbsolutePath());

              if (fileListItem != null) {
                fileListItem.highlightRename(newFile.getAbsolutePath());
              }
              Toast.makeText(
                      getApplicationContext(), "Name changed successfully", Toast.LENGTH_SHORT)
                  .show();
            } else {

              Toast.makeText(getApplicationContext(), "Error to Rename", Toast.LENGTH_SHORT).show();
            }
          }
        });
  }

  private void FileMaker() {
    var folders = new FileMaker(this);
    folders.setFolderName(Folder);
    folders.setCallBack(
        new FileCallBack() {
          @Override
          public void onDoneMakeFile(String filePath) {
            DataUtil.showMessage(FileManagerActivity.this, "File created successfully!");
            JgitHelperImpl.run(Folder, FileManagerActivity.this);

            runOnUiThread(
                () -> {
                  addNewFileToList(filePath);
                  int newPosition = findFilePositionByPath(filePath);
                  if (newPosition != -1) {
                    bind.recyclerview2.smoothScrollToPosition(newPosition);
                  }
                });
          }

          @Override
          public void onError(String error) {
            DataUtil.showMessage(FileManagerActivity.this, "Error: " + error);
          }
        });
  }

  void RefreshTabs() {
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
      List<FileManagerModel> _listmodel1,
      List<HashMap<String, Object>> _listmap2) {

    FileManagerModel model = _listmodel1.get(_position);
    tab = model.getFilePath();
    shp.edit().putString("pos_path", model.getFilePath()).apply();

    if (_listmap2.isEmpty()) {
      positionTabs = 0;
      activitiy.setClass(getApplicationContext(), CodeEditorActivity.class);
      {
        HashMap<String, Object> _item = new HashMap<>();
        _item.put(_key, model.getFilePath());
        _listmap2.add(_item);
      }
      shp.edit().putString(_key, new Gson().toJson(_listmap2)).commit();
      shp.edit().putString("positionTabs", String.valueOf((long) (positionTabs))).commit();
      loadAnim(activitiy);
    } else {
      n = 0;
      while (true) {
        if (_listmap2.get((int) n).get(_key).toString().contains(tab)) {
          activitiy.setClass(getApplicationContext(), CodeEditorActivity.class);
          shp.edit().putString("positionTabs", String.valueOf((long) (n))).commit();
          loadAnim(activitiy);
          break;
        } else {
          if (n == (_listmap2.size() - 1)) {
            activitiy.setClass(getApplicationContext(), CodeEditorActivity.class);
            {
              HashMap<String, Object> _item = new HashMap<>();
              _item.put(_key, model.getFilePath());
              _listmap2.add(_item);
            }
            shp.edit().putString(_key, new Gson().toJson(_listmap2)).commit();
            shp.edit()
                .putString("positionTabs", String.valueOf((long) (_listmap2.size() - 1)))
                .commit();
            activitiy.putExtra("htmlcode", model.getFilePath());
            activitiy.putExtra("htmlfile", Uri.parse(model.getFilePath()).getLastPathSegment());
            File file = new File(model.getFilePath());
            activitiy.putExtra("root", file.getParent());
            loadAnim(activitiy);
            break;
          }
        }
        n++;
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
    var di = new DialogUtil(FileManagerActivity.this);
    di.setTitle(tit);
    di.setMessage(msg);
    di.setNeutralButton(
        "view",
        (p, d) -> {
          ZipFileShow.showAsDialog(
              FileManagerActivity.this, fileModels.get(_pos).getFilePath(), _path + "/");
        });
    di.setPositiveButton(
        "unzip",
        (p1, d2) -> {
          UnZipDataFromDir(_path, Folder);
        });
    di.build();
  }

  void setFontView(List<FileManagerModel> list, int _pos) {
    String paths = list.get(_pos).getFilePath();
    if (paths.endsWith(".ttf") || paths.endsWith(".otf")) {
      finalintentpostfont.setClass(getApplicationContext(), FontViewActivity.class);
      finalintentpostfont.putExtra("font", paths);
      loadAnim(finalintentpostfont);
    }
  }

  void setThemeInstallByPath(int pos) {
    String path = fileModels.get(pos).getFilePath();
    if (path.endsWith(".aa") || path.endsWith(".AA")) {
      if (FileUtil.isFile("/storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost")) {
        var di = new MaterialAlertDialogBuilder(FileManagerActivity.this);
        di.setTitle(R.string.themewarning);
        di.setMessage(R.string.themewaringmassge);
        di.setNeutralButton(
            android.R.string.ok,
            (p, d) -> {
              try {
                new net.lingala.zip4j.ZipFile(path)
                    .extractAll("/storage/emulated/0/GhostWebIDE/theme/");
              } catch (net.lingala.zip4j.exception.ZipException e) {
                showMessage(e.toString());
              }
              reLoadFile();
              DataUtil.showMessage(getApplicationContext(), "done!");
            });
        di.setPositiveButton(android.R.string.cancel, null);
        di.show();
      } else {
        try {
          new net.lingala.zip4j.ZipFile(path).extractAll("/storage/emulated/0/GhostWebIDE/theme/");
        } catch (net.lingala.zip4j.exception.ZipException e) {
          showMessage(e.toString());
        }
        reLoadFile();
        DataUtil.showMessage(getApplicationContext(), "done");
      }
    }
  }

  public void showMessage(String a) {
    Toast.makeText(getApplicationContext(), a, 2).show();
  }

  private void setJarDecompiler() {
    androidx.appcompat.app.AlertDialog dialog =
        new GhostWebMaterialDialog(FileManagerActivity.this)
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
              (__) -> {
                if (output.getText().toString().isEmpty()) {
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
                SendDataFromCodeEditor(newpos, "path", fileModels, newlistmap);
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
                    fileModels.get((int) newpos).getFilePath(),
                    fileModels.get((int) newpos).getFilePath().replace(".svg", ".png"));
                sh.getDismiss(true);
                break;
              }
          }
        });
  }

  void loadVector(int newpos) {
    var sh = new ListSheet();
    sh.setSheetDialog(this);
    sh.addItem("Show in Editor", 0);
    sh.addItem("Cast to Xml", 0);
    sh.setOnItemClickLabe(
        (pos333) -> {
          switch (pos333) {
            case 0:
              {
                SendDataFromCodeEditor(newpos, "path", fileModels, newlistmap);
                sh.getDismiss(true);
                break;
              }
            case 1:
              {
                new XmlToSvg(
                    this,
                    fileModels.get((int) newpos).getFilePath(),
                    () -> {
                      reLoadFile();
                    },
                    Folder);
                sh.getDismiss(true);
                break;
              }
          }
        });
  }

  public void addChild(Child child) {
    listchild.add(child);
  }

  public void _dataOnClickItemList(int _pos) {
    newpos = _pos;

    if (staticstring.endsWith(".snippet")) {
      new SnippetManagerImpl(new File(staticstring), this);
      return;
    }

    for (var id : listchild) {
      if (staticstring.endsWith(id.getTypeExz())) {
        SendDataFromCodeEditor(newpos, "path", fileModels, newlistmap);
        return;
      }
    }

    Map<String, Runnable> specialHandlers = new HashMap<>();
    if (staticstring.endsWith(".pgb")) {
      Log.d("FileManager", "Processing PGB file: " + staticstring);
      try {
        new PluginExtractor(
            new PluginextractorFace() {
              @Override
              public void onPluginExtractorDone() {
                runOnUiThread(
                    () -> {
                      Toast.makeText(
                              FileManagerActivity.this,
                              "پلاگین با موفقیت نصب شد",
                              Toast.LENGTH_SHORT)
                          .show();
                      reLoadFile();
                    });
              }

              @Override
              public void onPluginExtractorError() {
                runOnUiThread(
                    () -> {
                      Toast.makeText(
                              FileManagerActivity.this, "خطا در نصب پلاگین", Toast.LENGTH_SHORT)
                          .show();
                    });
              }
            },
            staticstring,
            FileManagerActivity.this);
      } catch (Exception e) {
        Log.e("FileManager", "Error creating PluginExtractor: " + e.getMessage());
        e.printStackTrace();
        Toast.makeText(this, "خطا: " + e.getMessage(), Toast.LENGTH_SHORT).show();
      }
      return;
    }
    specialHandlers.put(".ghost", () -> loadThemeGhost());
    specialHandlers.put(".dex", () -> loadjadx());
    specialHandlers.put(
        ".gtheme",
        () -> {
          GTheme.install(
              FileManagerActivity.this,
              staticstring,
              () -> {
                reLoadFile();
              });
        });

    specialHandlers.put(
        ".jar",
        () -> {
          var di = new DialogUtil(FileManagerActivity.this);
          di.setTitle("Please select one of the following options");
          di.setMessage(
              "Note that to change the JAR to DeX, the appropriate option may take a few minutes to change or decompile, or even this will not be done.");
          di.setCancelable(false);
          di.setNeutralButton("Dicompile", (p, d) -> setJarDecompiler());
          di.setNegativeButton(
              "jar to dex",
              (p3, d3) -> {
                R8Tools tools = new R8Tools();
                tools.onlyCompile(
                    staticstring.trim(),
                    GetTab.trim(),
                    26,
                    FileManagerActivity.this,
                    () -> reLoadFile());
              });
          di.build();
        });

    specialHandlers.put(
        ".mp3",
        () -> {
          var musicsheet = new MusicSheet(this, staticstring);
          musicsheet.show();
          musicsheet.playMusic();
        });

    specialHandlers.put(".apk", () -> apkShowDataRoom());

    specialHandlers.put(
        ".pdf",
        () -> {
          getabout.setClass(getApplicationContext(), PdfViewNewActivity.class);
          getabout.putExtra("pdf", staticstring);
          getabout.putExtra("t", Uri.parse(staticstring).getLastPathSegment());
          loadAnim(getabout);
        });

    specialHandlers.put(".svg", () -> loadsvg(newpos));
    specialHandlers.put(".xml", () -> loadVector(newpos));

    Map<String, Runnable> archiveHandlers = new LinkedHashMap<>();
    archiveHandlers.put(".tar.gz", () -> setTarExs(staticstring, Folder));
    archiveHandlers.put(".tar.xz", () -> setTarExz(staticstring, Folder));
    archiveHandlers.put(".7z", () -> setSevenUnzipByPath(staticstring, Folder));
    archiveHandlers.put(".zip", () -> InstallTakesZip(newpos, staticstring));
    archiveHandlers.put(".project", () -> InstallTakesProject(newpos, staticstring));

    Set<String> codeEditorExtensions =
        new HashSet<>(
            Arrays.asList(
                ".txt",
                ".log",
                ".java",
                ".kt",
                ".kotlin",
                ".scala",
                ".cpp",
                ".cc",
                ".cxx",
                ".c++",
                ".h",
                ".hpp",
                ".hxx",
                ".hh",
                ".inl",
                ".tcc",
                ".ipp",
                ".c",
                ".cs",
                ".go",
                ".rs",
                ".zig",
                ".frag",
                ".py",
                ".py3",
                ".pyw",
                ".pyi",
                ".js",
                ".mjs",
                ".cjs",
                ".jsx",
                ".ts",
                ".tsx",
                ".php",
                ".rb",
                ".rbw",
                ".lua",
                ".swift",
                ".dart",
                ".r",
                ".jl",
                ".html",
                ".htm",
                ".xhtml",
                ".shtml",
                ".shtm",
                ".css",
                ".scss",
                ".sass",
                ".less",
                ".json",
                ".xml",
                ".yaml",
                ".yml",
                ".toml",
                ".ini",
                ".cfg",
                ".conf",
                ".properties",
                ".gradle",
                ".gradle.kts",
                ".groovy",
                ".g4",
                ".jj",
                ".smali",
                ".class",
                ".dex",
                ".ninja",
                ".mk",
                ".cmake",
                ".md",
                ".markdown",
                ".rst",
                ".adoc",
                ".sh",
                ".bash",
                ".zsh",
                ".fish",
                ".ps1",
                ".bat",
                ".cmd",
                ".ghost",
                ".svg"));

    for (var entry : specialHandlers.entrySet()) {
      if (staticstring.endsWith(entry.getKey())) {
        entry.getValue().run();
        return;
      }
    }

    for (var entry : archiveHandlers.entrySet()) {
      if (staticstring.endsWith(entry.getKey())) {
        entry.getValue().run();
        return;
      }
    }

    if (BinderRecyclerview1.TaskVideo(staticstring)) {
      govirwFilm.setClass(getApplicationContext(), VideoViewsActivity.class);
      govirwFilm.putExtra("getPath", staticstring);
      govirwFilm.putExtra("getTitle", Uri.parse(staticstring).getLastPathSegment());
      loadAnim(govirwFilm);
      return;
    }

    if (codeEditorExtensions.stream().anyMatch(staticstring::endsWith)) {
      SendDataFromCodeEditor(newpos, "path", fileModels, newlistmap);
      return;
    }

    var bindjpegWall = new BindJpegWall();
    bindjpegWall.bind(staticstring, this);
    setFontView(fileModels, newpos);
    setThemeInstallByPath(newpos);
  }

  void loadThemeGhost() {
    ThemeChkerErrorBinder.showSheet(
        staticstring,
        this,
        () -> {
          var sheet = new ListSheet();
          sheet.setSheetDialog(FileManagerActivity.this);
          sheet.addItem("OpenThemeEditor");
          sheet.addItem("OpenCodeEditor");
          sheet.addItem("applyTheme");
          sheet.setOnItemClickLabe(
              pos -> {
                switch (pos) {
                  case 0:
                    {
                      var it = new Intent();
                      it.setClass(getApplicationContext(), ThemePreviewActivity.class);
                      it.putExtra("keyitem", staticstring);
                      loadAnim(it);
                      sheet.getDismiss(true);
                      break;
                    }
                  case 1:
                    {
                      SendDataFromCodeEditor(newpos, "path", fileModels, newlistmap);
                      sheet.getDismiss(true);
                      break;
                    }
                  case 2:
                    {
                      SharedPreferences themePrefs =
                          getSharedPreferences("thememanagersoft", MODE_PRIVATE);
                      themePrefs.edit().putString("themes", staticstring).apply();
                      Toast.makeText(getApplicationContext(), themePrefs.getString("themes", ""), 2)
                          .show();
                      sheet.getDismiss(true);
                      break;
                    }
                }
              });
        });
  }

  void MakeZipFileFromThread(int pos) {
    MakeZipFileFromThread(pos, "Add project?", "Do you want to build a project?", ".project");
  }

  public void MakeZipFileFromThreads(int pos) {
    MakeZipFileFromThread(pos, "Make ZipFile", "Add Zip?", ".zip");
  }

  public void setFolder(String Folder) {
    this.Folder = Folder;
  }

  void MakeZipFileFromThread(int _number, String title, String massges, String format) {
    var di = new DialogUtil(this);
    di.setTitle(title);
    di.setMessage(massges);
    di.setPositiveButton(
        "ok",
        (p1, d2) -> {
          var copydir = new ProgressDialog(this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
          copydir.setCanceledOnTouchOutside(false);
          copydir.setTitle("Loading...");
          copydir.setCancelable(false);
          copydir.show();
          Thread thread =
              new Thread(
                  () -> {
                    if (FileUtil.isDirectory(fileModels.get(_number).getFilePath())) {
                      try {
                        String originalFilePath = fileModels.get(_number).getFilePath();
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
                        String originalFilePath = fileModels.get(_number).getFilePath();
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
                          reLoadFile(false);
                          copydir.dismiss();
                        });
                  });
          thread.start();
        });
    di.setNeutralButton("no", null);
    di.build();
  }

  public void VectorImageShow(final String _input, final String _output) {
    VectorHelper.iconPath = _input;
    VectorHelper.projectResourceDirectory = _output;
    VectorHelper.v(
        FileManagerActivity.this,
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
                reLoadFile(false);
              }

              @Override
              public void onError() {}
            });
    task.execute(_input, _output);
  }

  public void apkShowDataRoom() {
    String pathToFile = staticstring;
    var packageManager = getPackageManager();
    var packageInfo = packageManager.getPackageArchiveInfo(pathToFile, 0);
    var applicationInfo = packageInfo.applicationInfo;
    var icon = applicationInfo.loadIcon(packageManager);
    var appName = applicationInfo.loadLabel(packageManager).toString();
    var apkdata = new ApkUtilData(this);
    var builder = new MaterialAlertDialogBuilder(this);
    builder.setTitle(appName);
    builder.setIcon(icon);
    builder.setMessage(apkdata.getFormattedAppInfo(staticstring));
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
              FileManagerActivity.this);
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
                  loadAnim(mintent);
                });
            cbuilder.setNegativeButton("No", null);
            cbuilder.show();
          } else {
            String apkPath = staticstring;
            ApkInstaller apkInstaller =
                new ApkInstaller(FileManagerActivity.this, new File(apkPath));
            apkInstaller.execute();
          }
        });
    builder.setNegativeButton(
        "decompiler",
        (d, c) -> {
          loadjadx();
        });
    builder.show();
  }

  void loadjadx() {
    new JadxDecompiler(
        this,
        staticstring,
        Folder + "/",
        (it) -> {
          reLoadFile();
        });
  }

  public void setTarExs(final String _in, final String _ou) {
    var extra =
        new TarGzExtractor(
            this,
            () -> {
              reLoadFile(false);
            });

    extra.extract(new File(_in), new File(_ou));
  }

  public void setTarExz(final String _in, final String _ou) {
    var zippos =
        new ZxExtractor(
            this,
            () -> {
              reLoadFile(false);
            });
    zippos.extract(new File(_in), new File(_ou));
  }

  public void setSevenUnzipByPath(String inputFile, String outFilePath) {

    try {
      AlertDialog dialog =
          new MaterialAlertDialogBuilder(this)
              .setTitle("Loading...")
              .setPositiveButton("Done", null)
              .setCancelable(false)
              .create();
      dialog.show();
      new Thread(
              new Runnable() {

                @Override
                public void run() {
                  Z7Extractor.extractFile(
                      inputFile,
                      outFilePath,
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

  void setFTPDownloader() {
    androidx.appcompat.app.AlertDialog dialog =
        new GhostWebMaterialDialog(FileManagerActivity.this)
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
              (__) -> {
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
                                    R.string.filecreator,
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

  private void setSanDisk() {
    runOnUiThread(
        new Runnable() {

          @Override
          public void run() {
            if (staticStorage) {
              staticStorage = false;
              Folder = FileUtil.getExternalStorageDir();
              DataUtil.showMessage(getApplicationContext(), FileUtil.getExternalStorageDir());
              reLoadFile();

              bind.Drawer.closeDrawer(GravityCompat.START);
            } else {
              staticStorage = true;
              if (externalspace.hasRealRemovableSdCarde()) {
                Folder = externalspace.getExtSdPath();
                DataUtil.showMessage(getApplicationContext(), externalspace.getExtSdPath());
              } else {
                DataUtil.showMessage(getApplicationContext(), getString(R.string.sdcarderror));
              }
              reLoadFile();
              bind.Drawer.closeDrawer(GravityCompat.START);
            }
          }
        });
  }

  public void DrowerHandler() {
    bind.navs.bringToFront();
    bind.navs.setClick(
        (item) -> {
          bind.navs.setCheckedItem(item.getItemId());
          switch (item.getItemId()) {
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
                loadAnim(getJavaLayoutManager);
                break;
              }
            case 3:
              {
                void10.setClass(getApplicationContext(), TerminalActivity.class);
                loadAnim(void10);
                break;
              }
            case 4:
              {
                intentgetSettings.setClass(getApplicationContext(), SettingAppActivity.class);
                loadAnim(intentgetSettings);
                break;
              }
            case 5:
              {
                intentgetLogCat.setClass(getApplicationContext(), LogCatViewActivity.class);
                loadAnim(intentgetLogCat);
                break;
              }
            case 6:
              {
                var icon = new IconShop(FileManagerActivity.this);
                break;
              }
            case 7:
              {
                appUpdate();
                break;
              }
            case 8:
              {
                intentgetLogCat.setClass(getApplicationContext(), PluginManagerActivity.class);
                loadAnim(intentgetLogCat);
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
                loadAnim(intentgetLogCat);

                break;
              }
            case 11:
              {
                var b = new Intent();
                b.setClass(getApplicationContext(), ApkViewActivity.class);
                loadAnim(b);
                break;
              }
            case 12:
              {
                getabout.setClass(getApplicationContext(), AboutActivity.class);
                loadAnim(getabout);
                break;
              }
            case 13:
              {
                finishAffinity();
                break;
              }
            case 14:
              {
                loadAnim(new Intent(getApplicationContext(), StoreAcitvity.class));

                break;
              }
          }
          return false;
        });
  }

  void setBackupTheme() {
    if (FileUtil.isFile("/storage/emulated/0/GhostWebIDE/theme/theme.AA")) {
    } else {
      try {
        var zip4 =
            new net.lingala.zip4j.ZipFile(
                new File(
                    "/storage/emulated/0/GhostWebIDE/" + DataUtil.getRandom(1, 200) + "theme.AA"));
        List<File> filesToAdd = new ArrayList<>();
        var iconPath = getFilesDir().getAbsoluteFile() + "/icon.png";
        filesToAdd.add(new File(iconPath));
        filesToAdd.add(new File("/sdcard/GhostWebIDE/theme/GhostThemeapp.ghost"));
        zip4.addFiles(filesToAdd);
        DataUtil.showMessage(getApplicationContext(), "done");
      } catch (net.lingala.zip4j.exception.ZipException e) {
      }
    }
  }

  void appUpdate() {
    var updateversion =
        new UpadteAppView(
            this,
            bind.downloder,
            bind.fabAdd,
            () -> {
              reLoadFile();
            });
    updateversion.init();
  }

  private ListSheet sh1;

  public ListSheet getDialogItemSheet() {
    return sh1;
  }

  void DialogItemSheet() {
    sh1 = new ListSheet();

    sh1.setSheetDialog(this);
    sh1.addItem(getString(R.string.make_folder), R.drawable.create_new_folder_24px);
    sh1.addItem(getString(R.string.make_file), R.drawable.ic_file_24px);
    sh1.addItem(getString(R.string.make_project), R.drawable.extension_24px);
    sh1.addItem(getString(R.string.ftpdownloader), R.drawable.ic_ftp_24px);
    sh1.addItem(getString(R.string.search_file), R.drawable.document_search_24px);
    sh1.addItem(getString(R.string.folder_tree), R.drawable.folder_tree_24px);
    sh1.addItem(getString(R.string.file_tree), R.drawable.file_tree_24px);
    sh1.addItem(getString(R.string.git_clone), R.drawable.git);
    sh1.addItem(getString(R.string.android_module), R.drawable.sdk_24px);
    sh1.addItem(getString(R.string.git_tools), R.drawable.git);
    sh1.addItem(getString(R.string.gson_to_class), R.drawable.file_json_24px);
    sh1.addItem(getString(R.string.pastjavacode), R.drawable.ic_material_java);
    sh1.addItem(getString(R.string.globalsearch), R.drawable.document_search_24px);
    sh1.setOnItemClickLabe(
        (pos333) -> {
          switch (pos333) {
            case 0:
              {
                FolderMaker();
                sh1.getDismiss(true);
                break;
              }
            case 1:
              {
                FileMaker();
                sh1.getDismiss(true);
                break;
              }
            case 2:
              {
                new FactoryModelProject(
                    FileManagerActivity.this,
                    Folder,
                    () -> {
                      reLoadFile();
                    });
                sh1.getDismiss(true);
                break;
              }
            case 3:
              {
                setFTPDownloader();
                sh1.getDismiss(true);
                break;
              }
            case 4:
              {
                var find =
                    new TextFind(
                        new TextFindListener() {

                          @Override
                          public void onComplete() {
                            reLoadFile();
                          }

                          @Override
                          public void onError(String errorMessage) {}
                        },
                        this,
                        Folder);
                sh1.getDismiss(true);
                break;
              }
            case 5:
              {
                var di1 = new GhostWebMaterialDialog(FileManagerActivity.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogview =
                    getLayoutInflater().inflate(R.layout.makefolder, viewGroup, false);
                EditText editor = dialogview.findViewById(R.id.editor);
                di1.setTitle("Folder Tree");
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
                sh1.getDismiss(true);
                break;
              }
            case 6:
              {
                var di = new GhostWebMaterialDialog(FileManagerActivity.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogview1 =
                    getLayoutInflater().inflate(R.layout.makefolder, viewGroup, false);
                EditText editor = dialogview1.findViewById(R.id.editor);
                di.setTitle("File Tree");
                di.setMessage("Name file");
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
                sh1.getDismiss(true);
                break;
              }
            case 7:
              {
                setDialogGitDownload();
                sh1.getDismiss(true);
                break;
              }
            case 8:
              {
                new CreatorModule(
                    FileManagerActivity.this,
                    Folder,
                    () -> {
                      reLoadFile();
                    });
                sh1.getDismiss(true);
                break;
              }
            case 9:
              {
                GitListSheet task = new GitListSheet(new File(Folder), FileManagerActivity.this);
                sh1.getDismiss(true);
                break;
              }
            case 10:
              {
                var jsonToJava =
                    new GsonToClass(
                        FileManagerActivity.this,
                        Folder,
                        () -> {
                          reLoadFile();
                        });
                jsonToJava.run();
                sh1.getDismiss(true);
                break;
              }
            case 11:
              {
                var nodeChild =
                    new ClassNodePaserImpl(
                        Folder,
                        FileManagerActivity.this,
                        () -> {
                          reLoadFile();
                        },
                        null);
                sh1.getDismiss(true);
                nodeChild.setMode(ClassNodePaserImpl.ModeUser.DIALOG);
                break;
              }
            case 12:
              {
                GlobalSearchBottomSheet bottomSheet = new GlobalSearchBottomSheet();
                bottomSheet.setPathInput(Folder);
                bottomSheet.setIcon(IconRes.get(Folder));
                bottomSheet.setOnItemClickListener(
                    filePath -> {
                      File file = new File(filePath);
                      if (file.isDirectory()) {
                        Folder = filePath;
                        reLoadFile();
                      } else {
                        staticstring = filePath;
                        fileListItem.highlightFile(filePath);
                        for (int i = 0; i < fileModels.size(); i++) {
                          if (fileModels.get(i).getFilePath().equals(filePath)) {
                            bind.recyclerview2.smoothScrollToPosition(i);
                            _dataOnClickItemList(i);
                            return;
                          }
                        }
                        String parent = file.getParent();
                        if (parent != null && !parent.equals(Folder)) {
                          Folder = parent;
                          reLoadFile();
                          new Handler()
                              .postDelayed(
                                  () -> {
                                    for (int i = 0; i < fileModels.size(); i++) {
                                      if (fileModels.get(i).getFilePath().equals(filePath)) {
                                        fileListItem.highlightFile(filePath);
                                        bind.recyclerview2.smoothScrollToPosition(i);
                                        _dataOnClickItemList(i);
                                        break;
                                      }
                                    }
                                  },
                                  500);
                        }
                      }
                    });
                bottomSheet.show(getSupportFragmentManager(), "global_search");
                sh1.getDismiss(true);
                break;
              }
          }
        });
  }

  void setItemSheetOld(int _position, View _view) {

    var sheet = new ListSheet();
    sheet.setSheetDialog(this);
    sheet.addItem("add toZip", R.drawable.zip_box);
    sheet.addItem("share", R.drawable.share);
    sheet.addItem("Add to Project", R.drawable.unzip);
    sheet.addItem("Rename", R.drawable.rename);
    sheet.addItem("ReomvedFile", R.drawable.delete);
    sheet.addItem("AddBookMark", R.drawable.ic_bookmark_white);
    sheet.addItem("RenameJavaCode?", R.drawable.ic_material_java);
    sheet.addItem("Shortcut", R.drawable.share);
    sheet.addItem(getString(R.string.pastjavacode), R.drawable.extension_24px);
    sheet.setOnItemClickLabe(
        (pos_) -> {
          switch (pos_) {
            case 0:
              {
                MakeZipFileFromThreads(_position);
                sheet.getDismiss(true);
                break;
              }
            case 1:
              {
                sheet.getDismiss(true);
                break;
              }
            case 2:
              {
                MakeZipFileFromThreads(_position);
                sheet.getDismiss(true);
                break;
              }
            case 3:
              {
                setRenameFile(_position);
                sheet.getDismiss(true);
                break;
              }
            case 4:
              {
                removedFiles(_position);
                sheet.getDismiss(true);
                break;
              }
            case 5:
              {
                bookmark(_position);
                sheet.getDismiss(true);
                break;
              }
            case 6:
              {
                ColorView.renameJavaFileImpl(
                    FileManagerActivity.this,
                    fileModels.get(_position).getFilePath(),
                    Folder,
                    () -> {
                      reLoadFile();
                    });
                sheet.getDismiss(true);
                break;
              }
            case 7:
              {
                sh.createFileShortcut(0, fileModels.get(_position).getFilePath(), () -> {});
                sheet.getDismiss(true);
                break;
              }

            case 8:
              {
                var plugin =
                    new PluginCompressorPgb(
                        new PluginextractorFace() {

                          @Override
                          public void onPluginExtractorDone() {
                            reLoadFile();
                          }

                          @Override
                          public void onPluginExtractorError() {}
                        },
                        FileManagerActivity.this,
                        fileModels.get(_position).getFilePath());
                sheet.getDismiss(true);
                break;
              }
          }
        });
  }

  public void setDialogGitDownload() {
    GitClone mygit = new GitClone();
    mygit.clone(Folder, this);
    mygit.setCall(
        () -> {
          reLoadFile();
        });
  }

  public void bookmark(int position) {
    a =
        new Gson()
            .fromJson(
                book.getString(FileBookmarkActivity.keybookmark, "[]"),
                new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
    mapz32 = new HashMap<>();
    mapz32.put("list", fileModels.get(position).getFilePath());
    a.add(mapz32);
    book.edit().putString(FileBookmarkActivity.keybookmark, new Gson().toJson(a)).apply();
    showMessage("Added!");
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (event.isCtrlPressed()) {
      switch (keyCode) {
        case KeyEvent.KEYCODE_S:
          loadAnim(new Intent(getApplicationContext(), SettingAppActivity.class));
          return true;
        case KeyEvent.KEYCODE_F:
          FolderMaker();
          return true;
        case KeyEvent.KEYCODE_F1:
          FileMaker();
          return true;
        case KeyEvent.KEYCODE_G:
          setDialogGitDownload();
          return true;
        case KeyEvent.KEYCODE_D:
          if (!bind.Drawer.isOpen()) {
            bind.Drawer.open();
          }
          return true;
        case KeyEvent.KEYCODE_J:
          var jsonToJava =
              new GsonToClass(
                  FileManagerActivity.this,
                  Folder,
                  () -> {
                    reLoadFile();
                  });
          jsonToJava.run();
          return true;
        case KeyEvent.KEYCODE_T:
          loadAnim(new Intent(getApplicationContext(), TerminalActivity.class));
          return true;
        case KeyEvent.KEYCODE_A:
          loadAnim(new Intent(getApplicationContext(), ApkViewActivity.class));
          return true;
        case KeyEvent.KEYCODE_ESCAPE:
          BackPressed();
          return true;
      }
    }
    return super.onKeyDown(keyCode, event);
  }

  private void addNewFileToList(String filePath) {
    FileManagerModel newItem = new FileManagerModel(filePath, FileState.ADD);
    fileModels.add(newItem);
    Collections.sort(
        fileModels,
        (o1, o2) -> {
          String path1 = o1.getFilePath();
          String path2 = o2.getFilePath();
          boolean isDir1 = FileUtil.isDirectory(path1);
          boolean isDir2 = FileUtil.isDirectory(path2);

          if (isDir1 && !isDir2) return -1;
          if (!isDir1 && isDir2) return 1;
          return path1.compareToIgnoreCase(path2);
        });

    fileListItem.addNewFile(newItem);
    runOnUiThread(
        () -> {
          if (fileModels.isEmpty()) {
            if (!bind.emptyview.isShowing()) {
              bind.emptyview.show();
            }
          } else {
            if (bind.emptyview.isShowing()) {
              bind.emptyview.hide();
            }
          }
        });
  }
}
