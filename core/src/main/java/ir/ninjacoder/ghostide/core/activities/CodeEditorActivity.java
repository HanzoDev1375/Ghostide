package ir.ninjacoder.ghostide.core.activities;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.WindowManager;
import androidx.activity.OnBackPressedCallback;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.core.databinding.Antcomp8lerBinding;
import ir.ninjacoder.ghostide.core.G4Compiler;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import ir.ninjacoder.ghostide.core.enums.CompilerModel;
import ir.ninjacoder.ghostide.core.marco.binder.bindchilder.GhostToast;
import ir.ninjacoder.ghostide.core.navigator.EditorRoaderFile;
import ir.ninjacoder.ghostide.core.tasks.TaskItemCodeEditor;
import ir.ninjacoder.ghostide.core.tasks.app.SassForAndroid;
import ir.ninjacoder.ghostide.core.utils.ScalePageTransformer;
import ir.ninjacoder.ghostide.core.widget.ImageViewAnimation;
import ir.ninjacoder.ghostide.core.widget.component.RegexComponent;
import ir.ninjacoder.prograsssheet.fileinfo.FileInfoState;
import ir.ninjacoder.prograsssheet.listchild.ChildAdapter;
import com.mcal.uidesigner.XmlLayoutDesignActivity;
import java.io.FileOutputStream;
import android.provider.OpenableColumns;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.adapter.EditorPagerAdapter;
import ir.ninjacoder.ghostide.core.adapter.SyspiarAdapter;
import ir.ninjacoder.ghostide.core.adapter.ToolbarListFileAdapter;
import ir.ninjacoder.ghostide.core.enums.Mode;
import ir.ninjacoder.ghostide.core.fragments.EditorFragment;
import ir.ninjacoder.ghostide.core.git.GithubProfileImpl;
import ir.ninjacoder.ghostide.core.layoutmanager.LogCatBottomSheet;
import ir.ninjacoder.ghostide.core.marco.CodeSnap;
import ir.ninjacoder.ghostide.core.marco.ColorView;
import ir.ninjacoder.ghostide.core.marco.GhostWebEditorSearch;
import ir.ninjacoder.ghostide.core.marco.KotlinCompilerImpl;
import ir.ninjacoder.ghostide.core.marco.WallpaperParallaxEffect;
import ir.ninjacoder.ghostide.core.model.CodeEditorModel;
import ir.ninjacoder.ghostide.core.model.EditorViewModel;
import ir.ninjacoder.ghostide.core.pl.PluginChildRegistry;
import ir.ninjacoder.ghostide.core.pl.PluginLoader;
import ir.ninjacoder.ghostide.core.project.JavaCompilerBeta;
import ir.ninjacoder.ghostide.core.tasks.FileChangeReceiver;
import ir.ninjacoder.ghostide.core.terminal.TerminalActivity;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;
import ir.ninjacoder.ghostide.core.utils.CompilerUtils;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.KeySet;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import ir.ninjacoder.ghostide.core.utils.ThemeUtils;
import ir.ninjacoder.ghostide.core.widget.BlurImage;
import ir.ninjacoder.ghostide.core.widget.ExrtaFab;
import ir.ninjacoder.prograsssheet.VideoSurfaceView;
import ir.ninjacoder.prograsssheet.listchild.Child;
import ir.ninjacoder.prograsssheet.listchild.ChildIconEditorManager;

public class CodeEditorActivity extends BaseCompat
    implements EditorPagerAdapter.OnEditorPageListener {

  public final int REQ_CD_SETPASZAMINE = 101;

  protected ExrtaFab _fab;
  private WallpaperParallaxEffect effect;
  private CoordinatorLayout Coordinator;
  private HashMap<String, Object> imap = new HashMap<>();
  private ThemeUtils themeForJson2;

  private double ic = 1;
  private ArrayList<CodeEditorModel> tabsList = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> staticSymbiolPiare = new ArrayList<>();

  private LinearLayout multytab;
  private LinearLayout newLayoutSymbolBar;
  private LinearLayout CustomToolbar;
  private ProgressBar progressbar1;
  private RecyclerView dir, rvmenueditor;
  private TextView titleauthor;
  private ImageView image, redo, undo, menupopnew;
  private ImageViewAnimation codesnapimg, setting;
  private LinearLayout linear3, getColorPass;
  private LinearLayout barSymoble;
  private ImageView imageview1, avatargithubuser;
  private RecyclerView syspiar;
  private ImageView ghostIcon;
  private VideoSurfaceView mvideo;
  private IdeEditor codeEditorCurrent;
  private GhostWebEditorSearch ghost_searchs;

  private SharedPreferences word, line, shp, qo, savecursor, getvb, re, war, setfont, ru;
  private SharedPreferences tabimageview, pss, sve, getinitdir, mthemepost, shSizePx, t;
  private SharedPreferences thememanagersoft, sf;
  private Vibrator vb;

  private TabLayout tablayouteditor;
  private ViewPager2 viewPager;
  private EditorPagerAdapter pagerAdapter;
  private EditorViewModel modelEditor;
  private List<ChildIconEditorManager> aars = new ArrayList<>();
  private List<Child> listChild = new ArrayList<>();
  private PluginLoader pluginLoader;
  private String currentFileType = "";
  private PowerMenu pvr;
  private TabLayoutMediator tabMediator;
  private int currentPosition = 0;
  private Handler mainHandler = new Handler(Looper.getMainLooper());
  boolean anyFileSaved = false;

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
    newLayoutSymbolBar = findViewById(R.id.newLayoutSymbolBar);
    CustomToolbar = findViewById(R.id.CustomToolbar);
    progressbar1 = findViewById(R.id.progressbar1);
    dir = findViewById(R.id.dir);
    avatargithubuser = findViewById(R.id.avatargithubuser);
    titleauthor = findViewById(R.id.titleauthor);
    image = findViewById(R.id.image);
    redo = findViewById(R.id.redo);
    undo = findViewById(R.id.undo);
    setting = findViewById(R.id.setting);
    codesnapimg = findViewById(R.id.codesnapimg);
    tablayouteditor = findViewById(R.id.tablayouteditor);
    menupopnew = findViewById(R.id.menupopnew);
    linear3 = findViewById(R.id.linear3);
    barSymoble = findViewById(R.id.barSymoble);
    imageview1 = findViewById(R.id.imageview1);
    ghost_searchs = findViewById(R.id.editor_ser);
    rvmenueditor = findViewById(R.id.rvmenueditor);
    viewPager = findViewById(R.id.viewPager);
    syspiar = findViewById(R.id.syspiar);
    mvideo = findViewById(R.id.videoback);
    ghostIcon = findViewById(R.id.icon_backgroundghost);
    savecursor = getSharedPreferences("editor", MODE_PRIVATE);
    word = getSharedPreferences("word", MODE_PRIVATE);
    line = getSharedPreferences("line", MODE_PRIVATE);
    shp = getSharedPreferences("shp", MODE_PRIVATE);
    qo = getSharedPreferences("qo", MODE_PRIVATE);
    vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    getvb = getSharedPreferences("getvb", Activity.MODE_PRIVATE);
    re = getSharedPreferences("re", Activity.MODE_PRIVATE);
    war = getSharedPreferences("war", Activity.MODE_PRIVATE);
    setfont = getSharedPreferences("setfont", Activity.MODE_PRIVATE);
    ru = getSharedPreferences("ru", Activity.MODE_PRIVATE);
    tabimageview = getSharedPreferences("tabimageview", Activity.MODE_PRIVATE);
    pss = getSharedPreferences("pss", Activity.MODE_PRIVATE);
    sve = getSharedPreferences("sve", Activity.MODE_PRIVATE);
    getinitdir = getSharedPreferences("getinitdir", Activity.MODE_PRIVATE);
    mthemepost = getSharedPreferences("mthemepost", Activity.MODE_PRIVATE);
    shSizePx = getSharedPreferences("shSizePx", Activity.MODE_PRIVATE);
    t = getSharedPreferences("t", Activity.MODE_PRIVATE);
    thememanagersoft = getSharedPreferences("thememanagersoft", Activity.MODE_PRIVATE);
    sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
    pluginLoader = new PluginLoader();
    modelEditor = new ViewModelProvider(this).get(EditorViewModel.class);
    themeForJson2 = new ThemeUtils();
    ghost_searchs.hide();
    syspiar.setVisibility(View.GONE);
    rvmenueditor.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
    rvmenueditor.setAdapter(new ChildAdapter(aars));

    handleIncomingIntent(getIntent());
  }

  private void initializeLogic() {
    progressbar1.setVisibility(View.GONE);
    barSymoble.setVisibility(View.VISIBLE);
    setWallpaperParallaxEffect();
    loadTheme();
    setupEdgeToEdgeAndFab();
    getWindow()
        .setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    pagerAdapter = new EditorPagerAdapter(this, imap, this);
    viewPager.setAdapter(pagerAdapter);
    viewPager.setOffscreenPageLimit(3);
    viewPager.registerOnPageChangeCallback(
        new ViewPager2.OnPageChangeCallback() {
          @Override
          public void onPageSelected(int position) {
            super.onPageSelected(position);
            currentPosition = position;
            updateCurrentFileType(position);
            setDistreeView();
            if (position < tabsList.size()) {
              String path = tabsList.get(position).getPath();
              shp.edit().putString("pos_path", path).apply();
              shp.edit().putString("positionTabs", String.valueOf(position)).apply();
            }
          }
        });

    viewPager.setUserInputEnabled(false);
    setupTabLayoutMediator();

    setupTabListeners();
    setupToolbar();
    setupSymbolBar();
    loadSavedTabs();

    GithubProfileImpl.bindByActivity(titleauthor, avatargithubuser);
    AnimUtils.rotateBySetting(setting, this);
    AnimUtils.ClickAnimation(menupopnew);
    AnimUtils.ClickAnimation(undo);
    AnimUtils.ClickAnimation(redo);
    AnimUtils.ClickAnimation(image);
    AnimUtils.Worker(_fab);

    setupKeyboardListener();
    setupVideoBackground();
    setupFileWatching();
    setupKeyboardListeners();
    List<Child> editorPluginChildren = PluginChildRegistry.getCodeEditorChildren();
    listChild.addAll(editorPluginChildren);
    setupSearchBarCallback();
    bindEditorToSearchBar();
    viewPager.setPageTransformer(new ScalePageTransformer());
  }

  private interface EditorAction {
    void execute(IdeEditor editor);
  }

  private void setupTabLayoutMediator() {
    if (tabMediator != null) {
      tabMediator.detach();
    }

    tabMediator =
        new TabLayoutMediator(
            tablayouteditor,
            viewPager,
            (tab, position) -> {
              if (position < tabsList.size()) {
                CodeEditorModel model = tabsList.get(position);
                String tabText = new File(model.getPath()).getName();
                TabLayout.Tab customTab = createAnimatedTab(tabText, model.getPinmod());
                tab.setCustomView(customTab.getCustomView());
              }
            });

    tabMediator.attach();
  }

  private void executeOnEditor(int position, EditorAction action) {
    executeOnEditor(position, action, null);
  }

  private void executeOnEditor(int position, EditorAction action, String actionName) {
    EditorFragment fragment = pagerAdapter.getFragmentAt(position);

    if (fragment != null && fragment.isAdded() && fragment.getEditor() != null) {
      action.execute(fragment.getEditor());
    } else {
      String finalActionName = actionName != null ? actionName : "عملیات";

      mainHandler.postDelayed(
          () -> {
            EditorFragment delayedFragment = pagerAdapter.getFragmentAt(position);
            if (delayedFragment != null
                && delayedFragment.isAdded()
                && delayedFragment.getEditor() != null) {
              action.execute(delayedFragment.getEditor());
            } else {
              Toast.makeText(this, "خطا: ادیتور آماده نیست", Toast.LENGTH_SHORT).show();
            }
          },
          300);
    }
  }

  private void loadTheme() {
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

    themeForJson2.addTextColor(
        titleauthor, KeySet.syombolbartextcolor, Color.parseColor("#FFFFA0FB"), this, imap);
    themeForJson2.addImageColor(undo, this, KeySet.imagecolor, imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.addImageColor(redo, this, KeySet.imagecolor, imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.addImageColor(
        setting, this, KeySet.imagecolor, imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.addImageColor(
        codesnapimg, this, KeySet.imagecolor, imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.addImageColor(
        image, this, KeySet.imagecolor, imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.setStatusNavColor(this, imap, KeySet.navstatusbar, Coordinator, getColorPass);
    themeForJson2.addImageColor(
        menupopnew, this, KeySet.imagecolor, imap, Color.parseColor("#ff94e7ff"));
    themeForJson2.setFabBackground(_fab, imap);

    tablayouteditor.setSelectedTabIndicatorColor(
        imap.containsKey(KeySet.tabback)
            ? Color.parseColor(imap.get(KeySet.tabback).toString())
            : MaterialColors.getColor(tablayouteditor, ObjectUtils.colorPrimary));

    tablayouteditor.setTabTextColors(
        ColorStateList.valueOf(
            imap.containsKey(KeySet.tabtextcolor)
                ? Color.parseColor(imap.get(KeySet.tabtextcolor).toString())
                : MaterialColors.getColor(tablayouteditor, android.R.attr.textColor)));

    getColorPass.setBackgroundColor(Color.parseColor(imap.get("backgroundcolorlinear").toString()));

    if (imap.containsKey("tabback") && Build.VERSION.SDK_INT >= 21) {
      progressbar1
          .getIndeterminateDrawable()
          .setColorFilter(Color.parseColor(imap.get("tabback").toString()), PorterDuff.Mode.SRC_IN);
    }
    if (pagerAdapter != null) {
      pagerAdapter.updateTheme(imap);
    }
  }

  private TabLayout.Tab createAnimatedTab(String tabText, boolean isPinned) {
    View tabView = getLayoutInflater().inflate(R.layout.tab_custom_layout, null);
    LottieAnimationView animationView = tabView.findViewById(R.id.animation_view);
    TextView textView = tabView.findViewById(R.id.text_view);
    textView.setText(tabText);
    int textColor =
        imap.containsKey(KeySet.tabtextcolor)
            ? Color.parseColor(imap.get(KeySet.tabtextcolor).toString())
            : MaterialColors.getColor(tablayouteditor, android.R.attr.textColor);
    textView.setTextColor(textColor);

    if (isPinned) {
      animationView.setVisibility(View.VISIBLE);
      animationView.setAnimation(R.raw.ic_pin);
      SimpleColorFilter filter = new SimpleColorFilter(textColor);
      animationView.addValueCallback(
          new KeyPath("**"), LottieProperty.COLOR_FILTER, new LottieValueCallback<>(filter));
      animationView.playAnimation();
      animationView.setProgress(1f);
    } else {
      animationView.setVisibility(View.GONE);
    }

    TabLayout.Tab tab = tablayouteditor.newTab();
    tab.setCustomView(tabView);
    return tab;
  }

  private void setupTabListeners() {
    tablayouteditor.addOnTabSelectedListener(
        new TabLayout.OnTabSelectedListener() {
          @Override
          public void onTabSelected(TabLayout.Tab tab) {
            if (tab.getPosition() != viewPager.getCurrentItem()) {
              viewPager.setCurrentItem(tab.getPosition(), true); // true برای انیمیشن
            }
          }

          @Override
          public void onTabUnselected(TabLayout.Tab tab) {}

          @Override
          public void onTabReselected(TabLayout.Tab tab) {
            showTabContextMenu(tab.getPosition());
          }
        });

    viewPager.registerOnPageChangeCallback(
        new ViewPager2.OnPageChangeCallback() {
          @Override
          public void onPageSelected(int position) {
            super.onPageSelected(position);
            TabLayout.Tab tab = tablayouteditor.getTabAt(position);
            if (tab != null && !tab.isSelected()) {
              tab.select();
            }
          }

          @Override
          public void onPageScrollStateChanged(int state) {
            if (state == ViewPager2.SCROLL_STATE_IDLE) {
              tablayouteditor.requestLayout();
            }
          }
        });
  }

  private void showTabContextMenu(int position) {
    if (position >= tabsList.size()) return;
    if (getEditor().getTextActionWindow().isShowing()) getEditor().getTextActionWindow().dismiss();

    CodeEditorModel model = tabsList.get(position);
    PowerMenu powers =
        new PowerMenu.Builder(this)
            .addItem(new PowerMenuItem("close"))
            .addItem(new PowerMenuItem("close other"))
            .addItem(new PowerMenuItem("close all"))
            .addItem(new PowerMenuItem(model.getPinmod() ? "unpin" : "pin"))
            .addItem(new PowerMenuItem("info file"))
            .setIsMaterial(true)
            .setShowBackground(false)
            .setAutoDismiss(true)
            .setMenuColor(
                imap.containsKey(KeySet.menuPosBackground)
                    ? Color.parseColor(imap.get(KeySet.menuPosBackground).toString())
                    : MaterialColors.getColor(
                        this, com.google.android.material.R.attr.colorSurface, 0))
            .setTextColor(
                imap.containsKey(KeySet.menuPosTextColor)
                    ? Color.parseColor(imap.get(KeySet.menuPosTextColor).toString())
                    : MaterialColors.getColor(this, android.R.attr.textColor, 0))
            .setMenuRadius(15)
            .setAnimation(MenuAnimation.FADE)
            .build();

    powers.setOnMenuItemClickListener(
        (ii, c) -> {
          switch (ii) {
            case 0:
              if (!model.getPinmod()) {
                closeTab(position);
              } else {
                Toast.makeText(this, "این تب پین شده است", Toast.LENGTH_SHORT).show();
              }
              break;
            case 1:
              closeOtherTabs(position);
              break;
            case 2:
              closeAllTabs();
              break;
            case 3:
              togglePinTab(position);
              break;
            case 4:
              var info = new FileInfoState();
              info.logFileInfo(model.getPath(), this);
              break;
          }
        });
    powers.showAsDropDown(tablayouteditor.getTabAt(position).view);
  }

  private void closeTab(int position) {
    if (position >= 0 && position < tabsList.size()) {
      tabsList.remove(position);
      pagerAdapter.setTabs(tabsList);
      shp.edit().putString("path", new Gson().toJson(tabsList)).apply();
      setupTabLayoutMediator();
      if (tabsList.isEmpty()) {
        finish();
      } else {
        int newPos = Math.min(position, tabsList.size() - 1);
        viewPager.setCurrentItem(newPos);
      }
    }
  }

  private void closeOtherTabs(int position) {
    CodeEditorModel current = tabsList.get(position);
    ArrayList<CodeEditorModel> newList = new ArrayList<>();
    newList.add(current);

    for (int i = 0; i < tabsList.size(); i++) {
      if (i != position && tabsList.get(i).getPinmod()) {
        newList.add(tabsList.get(i));
      }
    }
    setupTabLayoutMediator();
    tabsList = newList;
    pagerAdapter.setTabs(tabsList);
    shp.edit().putString("path", new Gson().toJson(tabsList)).apply();
    viewPager.setCurrentItem(0);
  }

  private void closeAllTabs() {
    ArrayList<CodeEditorModel> pinnedTabs = new ArrayList<>();
    for (CodeEditorModel model : tabsList) {
      if (model.getPinmod()) {
        pinnedTabs.add(model);
      }
    }

    tabsList = pinnedTabs;
    pagerAdapter.setTabs(tabsList);
    shp.edit().putString("path", new Gson().toJson(tabsList)).apply();

    if (tabsList.isEmpty()) {
      finish();
    } else {
      viewPager.setCurrentItem(0);
    }
  }

  private void togglePinTab(int position) {
    CodeEditorModel model = tabsList.get(position);
    model.setPinmod(!model.getPinmod());

    TabLayout.Tab tab = tablayouteditor.getTabAt(position);
    if (tab != null && tab.getCustomView() != null) {
      View tabView = tab.getCustomView();
      int textColor =
          imap.containsKey(KeySet.tabtextcolor)
              ? Color.parseColor(imap.get(KeySet.tabtextcolor).toString())
              : MaterialColors.getColor(tablayouteditor, android.R.attr.textColor);
      LottieAnimationView animationView = tabView.findViewById(R.id.animation_view);
      SimpleColorFilter filter = new SimpleColorFilter(textColor);
      animationView.addValueCallback(
          new KeyPath("**"), LottieProperty.COLOR_FILTER, new LottieValueCallback<>(filter));
      if (model.getPinmod()) {
        animationView.setVisibility(View.VISIBLE);
        animationView.setAnimation(R.raw.ic_pin);
        animationView.playAnimation();
      } else {
        animationView.setAnimation(R.raw.ic_unpin);
        animationView.playAnimation();
        animationView.addValueCallback(
            new KeyPath("**"), LottieProperty.COLOR_FILTER, new LottieValueCallback<>(filter));
        animationView.addAnimatorListener(
            new Animator.AnimatorListener() {
              @Override
              public void onAnimationCancel(Animator arg0) {}

              @Override
              public void onAnimationEnd(Animator arg0) {
                animationView.setVisibility(View.GONE);
              }

              @Override
              public void onAnimationRepeat(Animator arg0) {}

              @Override
              public void onAnimationStart(Animator arg0) {}
            });
      }
    }

    shp.edit().putString("path", new Gson().toJson(tabsList)).apply();
    Toast.makeText(this, model.getPinmod() ? "تب پین شد" : "پین برداشته شد", Toast.LENGTH_SHORT)
        .show();
  }

  private void setupToolbar() {
    image.setOnClickListener(
        it -> {
          executeOnEditor(
              currentPosition,
              editor -> {
                if (ic == 1) {
                  image.setImageResource(R.drawable.noeye);
                  editor.setEditable(false);
                  ic--;
                } else {
                  editor.setEditable(true);
                  image.setImageResource(R.drawable.okeye);
                  ic++;
                }
              },
              "تغییر حالت ویرایش");
        });
    executeOnEditor(
        currentPosition,
        editor -> {
          new RegexComponent()
              .bindListFile(
                  editor,
                  (f) -> {
                    File file = new File(getCurrentFilePath());
                    String result =
                        file.getParentFile().getAbsolutePath() + "/" + f.replace("./", "");
                    if (result.endsWith(".js")) openFile(result);
                  });
        },
        "");

    redo.setOnClickListener(
        v -> {
          executeOnEditor(
              currentPosition,
              editor -> {
                editor.AutoRedo();
              },
              "Redo");
        });

    undo.setOnClickListener(
        v -> {
          executeOnEditor(
              currentPosition,
              editor -> {
                editor.AutoUndo();
              },
              "Undo");
        });

    menupopnew.setOnClickListener(this::showMainMenu);

    imageview1.setOnClickListener(
        it -> {
          barSymoble.setVisibility(View.GONE);
          _fab.setVisibility(View.VISIBLE);
        });

    _fab.setOnClickListener(it -> fabFileRunner());

    codesnapimg.setOnClickByAnim(
        v -> {
          if (currentPosition >= 0 && currentPosition < tabsList.size()) {
            String filePath = tabsList.get(currentPosition).getPath();
            GhostToast.showSuccess(this, "### Loading..");

            mainHandler.postDelayed(
                () -> {
                  executeOnEditor(
                      currentPosition,
                      editor -> {
                        if (editor.getCursor().isSelected())
                          new CodeSnap(CodeEditorActivity.this, filePath, editor);
                        else GhostToast.showSuccess(this, "### Not SelectText");
                      },
                      "CodeSnap");
                },
                300);
          }
        });

    getOnBackPressedDispatcher()
        .addCallback(
            this,
            new OnBackPressedCallback(true) {
              @Override
              public void handleOnBackPressed() {
                checkUnsavedChangesAndExit();
              }
            });
  }

  private void showMainMenu(View view) {
    pvr =
        new PowerMenu.Builder(this)
            .addItem(new PowerMenuItem("Search", false))
            .addItem(new PowerMenuItem("Color Picker", false))
            .addItem(new PowerMenuItem("Log Cat", false))
            .addItem(new PowerMenuItem("Save Current", false))
            .addItem(new PowerMenuItem("Save All", false))
            .addItem(new PowerMenuItem("Code Navigator", false))
            .setIsMaterial(true)
            .build();

    pvr.setIconPadding(8);
    pvr.setIconSize(30);
    pvr.setAutoDismiss(true);
    pvr.setAnimation(MenuAnimation.ELASTIC_CENTER);
    pvr.setMenuRadius(20f);
    pvr.setSelectedEffect(true);
    pvr.setShowBackground(false);
    pvr.setDividerHeight(2);
    pvr.setTextSize(14);
    themeForJson2.subPowerMenu(pvr, imap);
    pvr.setOnMenuItemClickListener(
        (position, item) -> {
          switch (position) {
            case 0:
              ghost_searchs.showAndHide();
              break;
            case 1:
              showColorPicker();
              break;
            case 2:
              new LogCatBottomSheet(this).run();
              break;
            case 3:
              saveCurrentFile();
              break;
            case 4:
              saveAllFilesWithConfirmation();
              break;
            case 5:
              if (currentPosition < tabsList.size()) {
                executeOnEditor(
                    currentPosition,
                    editor -> {
                      new ColorView()
                          .runJavaAsSmail(
                              CodeEditorActivity.this,
                              tabsList.get(currentPosition).getPath(),
                              editor);
                    },
                    "Code Navigator");
              }
              break;
          }
        });
    pvr.showAsDropDown(view);
  }

  private void showColorPicker() {
    ColorPickerDialogBuilder.with(this)
        .setTitle("Set Color")
        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
        .showColorPreview(true)
        .showColorEdit(true)
        .density(22)
        .setPositiveButton(
            "انتخاب",
            (dialog, selectedColor, allColors) -> {
              String rgs = Integer.toHexString(selectedColor);
              insertSymbol("#".concat(rgs.replace("#ff", "#")));
            })
        .setNegativeButton("لغو", null)
        .build()
        .show();
  }

  private void insertSymbol(String symbol) {
    executeOnEditor(
        currentPosition,
        editor -> {
          var channel = editor.createNewSymbolChannel();
          channel.insertSymbol(symbol, symbol.length());
        },
        "درج نماد");
  }

  private void saveCurrentFile() {
    executeOnEditor(
        currentPosition,
        editor -> {
          EditorFragment fragment = pagerAdapter.getFragmentAt(currentPosition);
          if (fragment != null) {
            fragment.saveFile();
            runOnUiThread(
                () -> {
                  Toast.makeText(this, "ذخیره شد", Toast.LENGTH_SHORT).show();

                  if (currentPosition < tabsList.size()) {
                    ObjectUtils.removedStarToTab(currentPosition, tablayouteditor);
                    tabsList.get(currentPosition).setTextchange(false);
                  }
                });
          }
        },
        "ذخیره فایل");
  }

  private void setupSymbolBar() {
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
                  insertSymbol(tab);
                }

                @Override
                public void POST(String post) {
                  insertSymbol(post);
                }
              },
              null);

      syspiar.setAdapter(syspiarAdapter);
      syspiar.setLayoutManager(
          new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    } catch (Exception e) {
      DataUtil.showMessage(this, e.toString());
    }
  }

  private void loadSavedTabs() {
    if (shp.contains("path") && !shp.getString("path", "").isEmpty()) {
      tabsList =
          new Gson()
              .fromJson(
                  shp.getString("path", ""),
                  new TypeToken<ArrayList<CodeEditorModel>>() {}.getType());
    } else {
      tabsList = new ArrayList<>();
    }
    if (tabsList.isEmpty()) {
      String defaultPath = "/storage/emulated/0/GhostWebIDE/newfile.txt";
      tabsList.add(new CodeEditorModel("newfile.txt", defaultPath, "0", false, false));
    }

    pagerAdapter.setTabs(tabsList);

    int savedPosition = 0;
    if (shp.contains("positionTabs")) {
      savedPosition = Integer.parseInt(shp.getString("positionTabs", "0"));
    }

    if (savedPosition < tabsList.size()) {
      viewPager.setCurrentItem(savedPosition);
    }
  }

  private void updateCurrentFileType(int position) {
    if (position >= 0 && position < tabsList.size()) {
      String filePath = tabsList.get(position).getPath();
      int dotIndex = filePath.lastIndexOf('.');
      currentFileType = (dotIndex > 0) ? filePath.substring(dotIndex) : "";

      executeOnEditor(
          position,
          editor -> {
            pluginLoader
                .setEditor((CodeEditor) editor)
                .setCodeEditorActivity(CodeEditorActivity.this)
                .setFileType(currentFileType)
                .reloadAllPlugins("/storage/emulated/0/GhostWebIDE/plugins/config.json");
          });
    }
  }

  private void setupKeyboardListener() {
    View rootView = getWindow().getDecorView();
    rootView
        .getViewTreeObserver()
        .addOnGlobalLayoutListener(
            () -> {
              Rect r = new Rect();
              rootView.getWindowVisibleDisplayFrame(r);
              int screenHeight = rootView.getRootView().getHeight();
              int keypadHeight = screenHeight - r.bottom;
              if (keypadHeight > screenHeight * 0.15) {
                ghostIcon.animate().scaleX(1.5f).scaleY(1.5f).setDuration(1000).start();
                ObjectUtils.showViewWithAnimation(syspiar);
              } else {
                ghostIcon.animate().scaleX(1.0f).scaleY(1.0f).setDuration(1000).start();
                ObjectUtils.hideViewWithAnimation(syspiar, _fab);
              }
            });
  }

  private void setupVideoBackground() {
    float blurData = thememanagersoft.contains("br") ? thememanagersoft.getFloat("br", 2) : 3;
    mvideo.setLifecycle(getLifecycle());

    if (getvb.getString("dir", "").endsWith(".mp4")) {
      mvideo.setPath(getvb.getString("dir", ""));
      mvideo.setVisibility(View.VISIBLE);
    } else {
      mvideo.setVisibility(View.GONE);
      mvideo.releasePlayer();
    }

    BlurImage.handleFallback(this, ghostIcon);
  }

  private void setupFileWatching() {
    if (getinitdir.contains("mdir")) {
      dir.setVisibility(getinitdir.getString("mdir", "").equals("true") ? View.GONE : View.VISIBLE);
    }

    if (sve.contains("getAutoSave") && sve.getString("getAutoSave", "").equals("true")) {
      FileChangeReceiver.stopWatching();
    }
  }

  private void setWallpaperParallaxEffect() {
    effect = new WallpaperParallaxEffect(this);
    effect.setCallback(
        (offsetX, offsetY, angle) -> {
          ghostIcon.setTranslationX(offsetX);
          ghostIcon.setTranslationY(offsetY);
        });
    effect.setEnabled(thememanagersoft.contains("effect"));
  }

  private void fabFileRunner() {
    if (currentPosition >= tabsList.size()) return;

    String filePath = tabsList.get(currentPosition).getPath();

    executeOnEditor(
        currentPosition,
        editor -> {
          EditorFragment fragment = pagerAdapter.getFragmentAt(currentPosition);
          if (fragment != null) {
            fragment.saveFile();
          }

          runOnUiThread(
              () -> {
                if (filePath.endsWith(".html")) {
                  runHtmlFile(filePath);
                } else if (filePath.endsWith(".java")) {
                  JavaCompilerBeta.run(this, new File(filePath));
                } else if (filePath.endsWith(".xml")) {
                  runXmlFile(filePath);
                } else if (filePath.endsWith(".js")) {
                  SassForAndroid.runObjectWeb(getEditor(), filePath, CompilerModel.NODEJS);
                } else if (filePath.endsWith(".kt")) {
                  new KotlinCompilerImpl(this, filePath, editor);
                } else if (filePath.endsWith(".php")
                    || filePath.endsWith(".py")
                    || filePath.endsWith(".dart")) {
                  runTerminalFile(filePath);
                } else if (filePath.endsWith(".g4")) {
                  setAntlr4Compiler(filePath);
                } else if (filePath.endsWith(".less")) {
                  SassForAndroid.runObjectWeb(getEditor(), filePath, CompilerModel.LESS);
                } else if (filePath.endsWith(".ts")) {
                  SassForAndroid.runObjectWeb(getEditor(), filePath, CompilerModel.TYPESRCIPT);
                } else if (filePath.endsWith(".jsx")) {
                  SassForAndroid.runObjectWeb(getEditor(), filePath, CompilerModel.JSX);
                } else if (filePath.endsWith(".tsx")) {
                  SassForAndroid.runObjectWeb(getEditor(), filePath, CompilerModel.TSX);
                } else if (filePath.endsWith(".sass") || filePath.endsWith(".scss")) {
                  SassForAndroid.run(this, shp.getString("pos_path", ""), filePath);
                } else if (filePath.endsWith(".md")) {
                  Intent intent = new Intent(this, MdCodeViewActivity.class);
                  intent.putExtra(MdCodeViewActivity.REQCODE, filePath);
                  loadAnim(intent);
                }
              });
        },
        "اجرای فایل");
  }

  private void runHtmlFile(String path) {
    if (ru.getBoolean("live", false)) {
      new CompilerUtils(path, Mode.WEB, this);
    } else {
      Intent intent = new Intent(this, HtmlRunerActivity.class);
      intent.putExtra("run", path);
      intent.putExtra("root", new File(path).getParent());
      loadAnim(intent);
    }
  }

  private void runXmlFile(String path) {
    Intent intent = new Intent(CodeEditorActivity.this, XmlLayoutDesignActivity.class);
    intent.putExtra(XmlLayoutDesignActivity.EXTRA_FILE, path);
    intent.putExtra(XmlLayoutDesignActivity.EXTRA_LANGUAGE, "xml");
    intent.putExtra(XmlLayoutDesignActivity.EXTRA_DEMO, false);
    intent.putExtra(XmlLayoutDesignActivity.EXTRA_STANDALONE, false);
    intent.putExtra(XmlLayoutDesignActivity.EXTRA_TRAINER, false);
    loadAnim(intent);
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

  private void runTerminalFile(String path) {
    Intent intent = new Intent(this, TerminalActivity.class);
    if (path.endsWith(".php")) {
      intent.putExtra("phpcode", path);
    } else if (path.endsWith(".py")) {
      intent.putExtra("path", path);
    } else if (path.endsWith(".dart")) {
      intent.putExtra("dart", path);
    }
    loadAnim(intent);
  }

  private void checkUnsavedChangesAndExit() {
    boolean hasUnsaved = false;
    for (int i = 0; i < tabsList.size(); i++) {
      EditorFragment frag = pagerAdapter.getFragmentAt(i);
      if (frag != null && frag.isTextChanged()) {
        hasUnsaved = true;
        break;
      }
    }

    if (hasUnsaved) {
      new MaterialAlertDialogBuilder(this)
          .setTitle("Save Changes")
          .setMessage("You have unsaved changes. Would you like to save them?")
          .setPositiveButton(
              "Save All",
              (d, w) -> {
                saveAllFiles(); // استفاده از saveAllFiles به جای
                // pagerAdapter.saveAllFiles()
                finish();
              })
          .setNegativeButton("Discard", (d, w) -> finish())
          .setNeutralButton("Cancel", null)
          .show();
    } else {
      finish();
    }
  }

  @Override
  public void onEditorCreated(int position, EditorFragment fragment) {
    if (position < tabsList.size()) {
      String path = tabsList.get(position).getPath();
      if (path != null && !path.equals(fragment.getFilePath())) {
        fragment = EditorFragment.newInstance(path, new Gson().toJson(imap));
      }
    }
  }

  @Override
  public void onTextChanged(int position, String path, boolean changed) {
    if (position < tabsList.size()) {
      tabsList.get(position).setTextchange(changed);
      if (changed) {
        ObjectUtils.addStarToTab(position, tablayouteditor);
      } else {
        ObjectUtils.removedStarToTab(position, tablayouteditor);
      }
    }
  }

  @Override
  public void onErrorDetected(int position, String error) {
    if (progressbar1 != null) {
      progressbar1.setVisibility(View.VISIBLE);
      mainHandler.postDelayed(() -> progressbar1.setVisibility(View.GONE), 2000);
    }
  }

  public void openFile(String filePath) {
    if (!FileUtil.isExistFile(filePath)) return;

    for (int i = 0; i < tabsList.size(); i++) {
      if (tabsList.get(i).getPath().equals(filePath)) {
        viewPager.setCurrentItem(i);
        return;
      }
    }

    String fileName = new File(filePath).getName();
    CodeEditorModel newTab =
        new CodeEditorModel(fileName, filePath, String.valueOf(tabsList.size()), false, false);
    tabsList.add(newTab);

    pagerAdapter.setTabs(tabsList);
    viewPager.setCurrentItem(tabsList.size() - 1);
    setupTabLayoutMediator();
    shp.edit().putString("path", new Gson().toJson(tabsList)).apply();
  }

  private void handleIncomingIntent(Intent intent) {
    if (intent == null || intent.getAction() == null) return;

    if (Intent.ACTION_VIEW.equals(intent.getAction())) {
      Uri uri = intent.getData();
      if (uri != null) {
        String path = getRealPathFromUri(uri);
        if (path != null) {
          new Handler().post(() -> openFile(path));
        }
      }
    }
  }

  private String getRealPathFromUri(Uri uri) {
    String filePath = null;

    if (uri == null) return null;

    try {
      if ("file".equals(uri.getScheme())) {
        filePath = uri.getPath();
      } else if ("content".equals(uri.getScheme())) {
        String[] projection = {MediaStore.MediaColumns.DATA};
        Cursor cursor = null;
        try {
          cursor = getContentResolver().query(uri, projection, null, null, null);
          if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            filePath = cursor.getString(columnIndex);
          }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          if (cursor != null) {
            cursor.close();
          }
        }

        if (filePath == null) {
          filePath = copyFileFromContentUri(uri);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      DataUtil.showMessage(this, "خطا در باز کردن فایل: " + e.getMessage());
    }

    return filePath;
  }

  private String copyFileFromContentUri(Uri uri) {
    String filePath = null;
    InputStream inputStream = null;
    FileOutputStream outputStream = null;

    try {
      inputStream = getContentResolver().openInputStream(uri);
      if (inputStream == null) return null;

      String fileName = "temp_file";
      Cursor cursor = getContentResolver().query(uri, null, null, null, null);
      if (cursor != null && cursor.moveToFirst()) {
        int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
        if (nameIndex != -1) {
          fileName = cursor.getString(nameIndex);
        }
        cursor.close();
      }

      File tempDir = new File("/storage/emulated/0/GhostWebIDE/temp/");
      if (!tempDir.exists()) {
        tempDir.mkdirs();
      }

      File outputFile = new File(tempDir, fileName);
      outputStream = new FileOutputStream(outputFile);

      byte[] buffer = new byte[4096];
      int bytesRead;
      while ((bytesRead = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, bytesRead);
      }

      filePath = outputFile.getAbsolutePath();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (inputStream != null) inputStream.close();
        if (outputStream != null) outputStream.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return filePath;
  }

  public void setDistreeView() {
    if (currentPosition >= tabsList.size()) return;

    String path = tabsList.get(currentPosition).getPath();
    List<String> items = spiltIntoBreadcrumbItems(path);

    ToolbarListFileAdapter adapter =
        new ToolbarListFileAdapter(
            items,
            this,
            new ToolbarListFileAdapter.CallBack() {
              @Override
              public void GoToDir(View view, int pos, String dirs) {
                TaskItemCodeEditor.bind(CodeEditorActivity.this, dirs, view);
              }

              @Override
              public void GoToTreeFile(View view, int pos, String dir) {}
            });

    dir.setAdapter(adapter);
    dir.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    dir.smoothScrollToPosition(items.size());
    adapter.bindColor(
        Color.parseColor(imap.get(KeySet.menuPosBackground).toString()),
        Color.parseColor(imap.get(KeySet.menuPosTextColor).toString()),
        Color.parseColor(imap.get(KeySet.tabback).toString()),
        Color.parseColor(imap.get(KeySet.tabtextcolor).toString()));
  }

  public IdeEditor getCurrentEditor() {
    EditorFragment fragment = pagerAdapter.getFragmentAt(currentPosition);
    return fragment != null ? fragment.getEditor() : null;
  }

  public String getCurrentFilePath() {
    return currentPosition < tabsList.size() ? tabsList.get(currentPosition).getPath() : "";
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (event.isCtrlPressed()) {
      if (keyCode == KeyEvent.KEYCODE_S) {
        if (event.isShiftPressed()) {
          saveAllFilesWithConfirmation();
        } else {
          saveCurrentFile();
        }
        return true;
      }
    }
    return super.onKeyDown(keyCode, event);
  }

  private void setupSearchBarCallback() {
    ghost_searchs.setCallBack(
        new GhostWebEditorSearch.onViewChange() {
          @Override
          public void onViewShow() {

            runOnUiThread(
                () -> {
                  barSymoble.setVisibility(View.GONE);
                  _fab.hide();
                });
          }

          @Override
          public void onViewHide() {

            runOnUiThread(
                () -> {
                  barSymoble.setVisibility(View.VISIBLE);
                  _fab.show();
                });
          }
        });
  }

  private void bindEditorToSearchBar() {
    mainHandler.postDelayed(
        () -> {
          EditorFragment fragment = pagerAdapter.getFragmentAt(currentPosition);
          if (fragment != null && fragment.getEditor() != null) {
            ghost_searchs.bindEditor(fragment.getEditor());
            if (fragment.getEditor().getTextActionWindow().isShowing()) {
              fragment.getEditor().getTextActionWindow().dismiss();
            }
          }
        },
        300);
    viewPager.registerOnPageChangeCallback(
        new ViewPager2.OnPageChangeCallback() {
          @Override
          public void onPageSelected(int position) {
            super.onPageSelected(position);
            mainHandler.postDelayed(
                () -> {
                  EditorFragment fragment = pagerAdapter.getFragmentAt(position);
                  if (fragment != null && fragment.getEditor() != null) {
                    if (!fragment.getEditor().getTextActionWindow().isShowing()) {
                      fragment.getEditor().getTextActionWindow().dismiss();
                    }
                    EditorRoaderFile.RuningTask(_fab, getPathBytab(), listChild);
                    ghost_searchs.bindEditor(fragment.getEditor());
                  }
                },
                200);
          }
        });
  }

  public void addChild(Child child) {
    listChild.add(child);
  }

  public void addChildManagerEditor(ChildIconEditorManager model) {
    aars.add(model);
  }

  public String getTabPathCode() {
    int selectedTabPosition = tablayouteditor.getSelectedTabPosition();
    if (selectedTabPosition >= 0 && selectedTabPosition < tabsList.size()) {
      return tabsList.get(selectedTabPosition).getPath();
    }
    return "";
  }

  public IdeEditor getEditor() {
    executeOnEditor(
        currentPosition,
        editor -> {
          codeEditorCurrent = editor;
        });

    if (codeEditorCurrent != null) {
      return codeEditorCurrent;
    }
    return null;
  }

  private ImageView geticonAuthor() {
    EditorFragment fragment = pagerAdapter.getFragmentAt(currentPosition);
    if (fragment != null) {
      return fragment.geticonAuthor();
    }
    return null;
  }

  public String getPathBytab() {
    int selectedTabPosition = tablayouteditor.getSelectedTabPosition();
    if (selectedTabPosition >= 0 && selectedTabPosition < tabsList.size()) {
      return tabsList.get(selectedTabPosition).getPath();
    }
    return "";
  }

  public TabLayout getEditorTabLayout() {
    return tablayouteditor;
  }

  public List<ChildIconEditorManager> getChildIconEditorManager() {
    return aars;
  }

  public String getcurrentFileType() {
    return currentFileType;
  }

  public void forceRefreshRecycler() {
    try {
      if (rvmenueditor != null) {
        rvmenueditor.post(
            () -> {
              rvmenueditor.getAdapter().notifyDataSetChanged();
              rvmenueditor.invalidate();
              rvmenueditor.requestLayout();
            });
      }
    } catch (Exception e) {
      // خطا نادیده گرفته شود
    }
  }

  public List<String> spiltIntoBreadcrumbItems(String filePath) {
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

  /** Save all opened files */
  private void saveAllFiles() {

    for (int i = 0; i < tabsList.size(); i++) {
      EditorFragment fragment = pagerAdapter.getFragmentAt(i);
      if (fragment != null && fragment.isAdded()) {
        if (fragment.isTextChanged()) {
          fragment.saveFileIfNeeded();
          anyFileSaved = true;
          tabsList.get(i).setTextchange(false);
        }
      }
    }

    runOnUiThread(
        () -> {
          for (int i = 0; i < tabsList.size(); i++) {
            ObjectUtils.removedStarToTab(i, tablayouteditor);
          }

          if (anyFileSaved) {
            Toast.makeText(this, "All files saved successfully", Toast.LENGTH_SHORT).show();
          } else {
            Toast.makeText(this, "No changes to save", Toast.LENGTH_SHORT).show();
          }
        });
  }

  /** Save all files with confirmation dialog */
  private void saveAllFilesWithConfirmation() {
    int unsavedCount = 0;

    for (int i = 0; i < tabsList.size(); i++) {
      EditorFragment fragment = pagerAdapter.getFragmentAt(i);
      if (fragment != null && fragment.isAdded() && fragment.isTextChanged()) {
        unsavedCount++;
      }
    }

    if (unsavedCount == 0) {
      Toast.makeText(this, "No unsaved changes", Toast.LENGTH_SHORT).show();
      return;
    }

    new MaterialAlertDialogBuilder(this)
        .setTitle("Save All Files")
        .setMessage(unsavedCount + " file(s) have unsaved changes. Save all?")
        .setPositiveButton(
            "Save All",
            (d, w) -> {
              saveAllFiles();
            })
        .setNegativeButton("Cancel", null)
        .show();
  }

  /** Save pinned files only */
  private void savePinnedFiles() {
    boolean anyPinnedSaved = false;

    for (int i = 0; i < tabsList.size(); i++) {
      CodeEditorModel model = tabsList.get(i);
      if (model.getPinmod()) {
        EditorFragment fragment = pagerAdapter.getFragmentAt(i);
        if (fragment != null && fragment.isAdded() && fragment.isTextChanged()) {
          fragment.saveFileIfNeeded();
          model.setTextchange(false);
          anyPinnedSaved = true;
          ObjectUtils.removedStarToTab(i, tablayouteditor);
        }
      }
    }

    if (anyPinnedSaved) {
      Toast.makeText(this, "Pinned files saved", Toast.LENGTH_SHORT).show();
    } else {
      Toast.makeText(this, "No pinned files with changes", Toast.LENGTH_SHORT).show();
    }
  }

  /** Get count of unsaved files */
  private int getUnsavedFilesCount() {
    int count = 0;
    for (int i = 0; i < tabsList.size(); i++) {
      EditorFragment fragment = pagerAdapter.getFragmentAt(i);
      if (fragment != null && fragment.isAdded() && fragment.isTextChanged()) {
        count++;
      }
    }
    return count;
  }

  private void setupEdgeToEdgeAndFab() {

    setupWindowForKeyboard(getWindow());
    // transparentNavigationBar(getWindow());

    getWindow()
        .getDecorView()
        .post(
            () -> {
              adjustFabPosition();
              setupKeyboardListener();
            });
  }

  private void setupWindowForKeyboard(Window window) {
    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
  }

  private void adjustFabPosition() {
    if (_fab == null) return;

    CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) _fab.getLayoutParams();

    int marginBottom = dpToPx(42);
    int marginTop = dpToPx(26);
    int marginHorizontal = dpToPx(16);

    params.setMargins(marginHorizontal, marginTop, marginHorizontal, marginBottom);
    _fab.post(() -> _fab.setLayoutParams(params));

    if (_fab.getVisibility() != View.VISIBLE) {
      _fab.setVisibility(View.VISIBLE);
    }
  }

  private void setupKeyboardListeners() {
    if (getvb.contains("dir")) {
      if (!getvb.getString("dir", "").isEmpty()) {
        View rootView = getWindow().getDecorView();

        ViewCompat.setOnApplyWindowInsetsListener(
            rootView,
            (v, insets) -> {
              Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
              Insets ime = insets.getInsets(WindowInsetsCompat.Type.ime());

              if (_fab != null) {
                CoordinatorLayout.LayoutParams params =
                    (CoordinatorLayout.LayoutParams) _fab.getLayoutParams();

                if (ime.bottom > 0) {
                  int keyboardHeight = ime.bottom - systemBars.bottom;
                  int extraSpace = dpToPx(60);
                  params.bottomMargin = dpToPx(42) + keyboardHeight + extraSpace;
                } else {
                  params.bottomMargin = dpToPx(42);
                }

                _fab.post(() -> _fab.setLayoutParams(params));
              }

              return insets;
            });
      }
    }
  }

  private void transparentNavigationBar(Window window) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      window.setNavigationBarContrastEnforced(false);
    }
    window.setNavigationBarColor(Color.TRANSPARENT);
  }

  private int dpToPx(int dp) {
    return (int)
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
  }
}
