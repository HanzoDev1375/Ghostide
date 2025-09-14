package ir.ninjacoder.ghostide.activities;

import io.github.rosemoe.sora.widget.power.PowerModeEffectManager;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.adapter.ListAppIconAd;
import ir.ninjacoder.ghostide.config.AppIconManager;
import ir.ninjacoder.ghostide.config.PrfnsUtil;
import ir.ninjacoder.ghostide.enums.EffectTypeManager;
import ir.ninjacoder.ghostide.enums.ErudaThemeManager;
import ir.ninjacoder.ghostide.enums.ErudaThemes;
import ir.ninjacoder.ghostide.git.GitHubProfileView;
import java.util.Arrays;
import ir.ninjacoder.ghostide.filehelper.IconCursorImpl;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.widget.GhostWebMaterialDialog;
import android.animation.ObjectAnimator;
import android.app.Activity;

import android.app.WallpaperManager;
import android.content.*;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.*;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import com.quickersilver.themeengine.ThemeChooserDialogBuilder;
import com.quickersilver.themeengine.ThemeEngine;
import com.quickersilver.themeengine.ThemeMode;
import ir.ninjacoder.prograsssheet.LayoutSheetEditText;
import ir.ninjacoder.prograsssheet.perfence.PerfenceLayoutSubTitle;
import ir.ninjacoder.prograsssheet.perfence.PreferenceSwitchGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SettingAppActivity extends BaseCompat {

  private Timer _timer = new Timer();

  private MaterialToolbar _toolbar;
  private AppBarLayout _app_bar;
  private CoordinatorLayout _coordinator;
  private boolean boolea = false;
  private boolean mbool01 = false;
  private boolean mbool02 = false;
  private boolean mbool03 = false;
  private boolean mbool04 = false;
  private static ThemeEngine themeEngine;
  private ArrayList<String> string = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> mp = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> c2 = new ArrayList<>();
  private List<HashMap<String, Object>> map = new ArrayList<>();
  private NestedScrollView bar;
  private RecyclerView rvsetting;
  private Intent intent = new Intent();
  private PreferenceSwitchGroup materialYous,
      effect,
      grids,
      walpapersystem,
      deftheme,
      autoSaveText,
      codeAZ,
      livemodel,
      breaklevelmodel;
  private ObjectAnimator mdownObjectAnimator = new ObjectAnimator();
  private TimerTask timer;
  private SharedPreferences getvb,
      war,
      setfont,
      ru,
      getDrak,
      sve,
      materialYou,
      thememanagersoft,
      sf,
      gridMode,
      Analyzercod,
      iconSpash;
  private PerfenceLayoutSubTitle themecustom, blurmod, windowsize, erudathemes, jointogithub;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.settingapp);
    initialize(_savedInstanceState);
    PrfnsUtil.init(this);
  }

  public int colors() {
    return MaterialColors.getColor(
        getWindow().getDecorView(), com.google.android.material.R.attr.colorOnSurface, 0);
  }

  private void initialize(Bundle _savedInstanceState) {
    _app_bar = findViewById(R.id._app_bar);
    _coordinator = findViewById(R.id._coordinator);
    _toolbar = findViewById(R.id._toolbar);
    themecustom = findViewById(R.id.themecustom);
    blurmod = findViewById(R.id.blurmod);
    windowsize = findViewById(R.id.windowsize);
    setSupportActionBar(_toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    _toolbar.setNavigationOnClickListener(
        (i) -> {
          onBackPressed();
        });
    themeEngine = ThemeEngine.getInstance(this);
    themeEngine.setThemeMode(ThemeMode.DARK);
    themeEngine.applyToActivity(this);
    bar = findViewById(R.id.bar);
    jointogithub = findViewById(R.id.jointogithub);
    breaklevelmodel = findViewById(R.id.breaklevelmodel);
    erudathemes = findViewById(R.id.erudathemes);
    getvb = getSharedPreferences("getvb", Activity.MODE_PRIVATE);
    getDrak = getSharedPreferences("getDrak", Activity.MODE_PRIVATE);
    war = getSharedPreferences("war", Activity.MODE_PRIVATE);
    setfont = getSharedPreferences("setfont", Activity.MODE_PRIVATE);
    ru = getSharedPreferences("ru", Activity.MODE_PRIVATE);
    sve = getSharedPreferences("sve", Activity.MODE_PRIVATE);

    materialYou = getSharedPreferences("materialYou", Activity.MODE_PRIVATE);
    thememanagersoft = getSharedPreferences("thememanagersoft", Activity.MODE_PRIVATE);
    sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
    gridMode = getSharedPreferences("gride", Activity.MODE_PRIVATE);
    Analyzercod = getSharedPreferences("Analyzercod", MODE_PRIVATE);
    iconSpash = getSharedPreferences("iconSpash", MODE_PRIVATE);
    materialYous = findViewById(R.id.MaterialYou);
    grids = findViewById(R.id.gridmod);
    effect = findViewById(R.id.effect);
    walpapersystem = findViewById(R.id.walpapers);
    deftheme = findViewById(R.id.deftheme);
    autoSaveText = findViewById(R.id.autoSaveText);
    rvsetting = findViewById(R.id.rvsetting);
    codeAZ = findViewById(R.id.codeAZ);
    codeAZ.setTitle(getString(R.string.codeaztitles));
    codeAZ.setDescription(getString(R.string.codeazsubtitle));
    materialYous.setTitle(getString(R.string.materialyoutitle));
    materialYous.setDescription(getString(R.string.materialyousubtitle));
    effect.setTitle(getString(R.string.effect_title));
    effect.setDescription(getString(R.string.effect_description));
    grids.setTitle(getString(R.string.grids_title));
    grids.setDescription(getString(R.string.grids_description));
    walpapersystem.setTitle(getString(R.string.walpapersystem_title));
    walpapersystem.setDescription(getString(R.string.walpapersystem_description));
    deftheme.setTitle(getString(R.string.deftheme_title));
    deftheme.setDescription(getString(R.string.deftheme_description));
    livemodel = findViewById(R.id.liveModel);
    livemodel.setTitle(getString(R.string.sheetlive));
    livemodel.setDescription(getString(R.string.sheetsub));
    autoSaveText.setTitle(getString(R.string.autoSaveText_title));
    autoSaveText.setDescription(getString(R.string.autoSaveText_description));
    breaklevelmodel.setTitle("BreakLevelModel");
    breaklevelmodel.setDescription("setBreakLevelModel Live Style");
    erudathemes.setTitle("Eruda theme");
    erudathemes.setDescription("Custom theme Eruda");
    jointogithub.setTitle("Github login");
    jointogithub.setDescription("Try to join in github for show lego and user name etc..");
    _toolbar.setOnApplyWindowInsetsListener(
        new View.OnApplyWindowInsetsListener() {
          @Override
          public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
            v.setPadding(
                insets.getSystemWindowInsetLeft(), insets.getSystemWindowInsetTop(),
                insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
            return insets;
          }
        });
    windowsize.setDescription(getString(R.string.customwindowsdesc));
    windowsize.setTitle(getString(R.string.customwindows));

    themecustom.setTitle(getString(R.string.customthemetitle));
    themecustom.setDescription(getString(R.string.customthemesub));
    blurmod.setTitle(getString(R.string.customblursizesubtitle));
    blurmod.setDescription(getString(R.string.customblursizetitle));
    themecustom.setOnClickListener(
        v -> {
          customDataRow(
              "Custom Theme", "Select Theme in format .ghost", "themes", thememanagersoft);
        });
    erudathemes.setOnClickListener(
        v -> {
          showthemeeruda();
        });
    blurmod.setOnClickListener(c -> _blursize());
    windowsize.setOnClickListener(
        v -> {
          var di = new GhostWebMaterialDialog(SettingAppActivity.this);
          ViewGroup viewGroup = findViewById(android.R.id.content);
          View dialogview = getLayoutInflater().inflate(R.layout.lifesacel, viewGroup, false);
          RadioButton r1 = dialogview.findViewById(R.id.r1);
          RadioButton r2 = dialogview.findViewById(R.id.r2);
          RadioButton r3 = dialogview.findViewById(R.id.r3);
          di.setPositiveButton(
              "OK",
              (p1, d2) -> {
                int selectedValue = 1;
                r1.setOnCheckedChangeListener(
                    (cdmnull, isCh) -> {
                      if (sf.getInt("sd100", 1) == 1) {
                        sf.edit().putInt("sd100", 1).apply();

                      } else {
                        sf.edit().remove("sd100");
                      }
                    });
                r2.setOnCheckedChangeListener(
                    (cdmnull, isCh) -> {
                      if (sf.getInt("sd100", 1) == 2) {
                        sf.edit().putInt("sd100", 2).apply();

                      } else {
                        sf.edit().remove("sd100");
                      }
                    });
                r3.setOnCheckedChangeListener(
                    (cdmnull, isCh) -> {
                      if (sf.getInt("sd100", 1) == 3) {
                        sf.edit().putInt("sd100", 3).apply();

                      } else {
                        sf.edit().remove("sd100");
                      }
                    });

                if (r1.isChecked()) {
                  selectedValue = 1;
                } else if (r2.isChecked()) {
                  selectedValue = 2;
                } else if (r3.isChecked()) {
                  selectedValue = 3;
                }

                sf.edit().putInt("sd100", selectedValue).apply();
              });
          if (sf.getInt("sd100", 1) == 1) {
            r1.setChecked(true);
            r2.setChecked(false);
            r3.setChecked(false);
          } else if (sf.getInt("sd100", 1) == 2) {
            r2.setChecked(true);
            r1.setChecked(false);
            r3.setChecked(false);
          } else if (sf.getInt("sd100", 1) == 3) {
            r3.setChecked(true);
            r1.setChecked(false);
            r2.setChecked(false);
          } else {
            r2.setChecked(false);
            r1.setChecked(false);
            r3.setChecked(false);
          }
          di.setView(dialogview);
          di.show();
        });
    thememanagersoft.registerOnSharedPreferenceChangeListener(
        new SharedPreferences.OnSharedPreferenceChangeListener() {

          @Override
          public void onSharedPreferenceChanged(SharedPreferences sh, String key) {
            if (key.equals("thememanagersoft")) {
              String datapost = sh.getString("thememanagersoft", "");
              if (datapost.equals("ok")) {
                Wall();
              } else NoWall();
            }
          }
        });
    thememanagersoft.unregisterOnSharedPreferenceChangeListener(
        new SharedPreferences.OnSharedPreferenceChangeListener() {

          @Override
          public void onSharedPreferenceChanged(SharedPreferences sh, String key) {
            if (key.equals("thememanagersoft")) {
              String datapost = sh.getString("thememanagersoft", "");
              if (datapost.equals("no")) {
              } else Wall();
            }
          }
        });
    walpapersystem.setSwitchChangedListener(
        (btn, is) -> {
          if (is) {
            thememanagersoft.edit().putString("thememanagersoft", "ok").apply();
          } else {
            thememanagersoft.edit().putString("thememanagersoft", "no").apply();
          }
        });
    codeAZ.setSwitchChangedListener(
        (btn, i) -> {
          Analyzercod.edit().putBoolean("Analyzercod", i).apply();
        });

    grids.setSwitchChangedListener(
        (cc, is) -> {
          if (is) {
            gridMode.edit().putString("gride", "true").apply();
          } else {
            gridMode.edit().remove("gride").apply();
          }
        });
    effect.setSwitchChangedListener(
        (vv, is) -> {
          if (is) {
            thememanagersoft.edit().putString("effect", "true").apply();
          } else {
            thememanagersoft.edit().remove("effect").apply();
          }
        });
    deftheme.setSwitchChangedListener(
        (vv, is) -> {
          if (is) {
            ru.edit().putString("rup", "true").commit();
          } else {
            ru.edit().remove("rup").commit();
          }
        });
    autoSaveText.setSwitchChangedListener(
        (vv, cc) -> {
          if (cc) {
            sve.edit().putString("getAutoSave", "true").commit();
          } else {
            sve.edit().remove("getAutoSave").commit();
          }
        });

    materialYous.setSwitchChangedListener(
        (bin, is) -> {
          if (is) {
            materialYou.edit().putString("materialYou", "true").apply();
            themeEngine.setDynamicTheme(true);

          } else {
            materialYou.edit().remove("materialYou").apply();
            themeEngine.setDynamicTheme(false);
          }
        });

    livemodel.setSwitchChangedListener(
        (bin, is) -> {
          if (is) {
            ru.edit().putBoolean("live", true).apply();
          } else {
            ru.edit().putBoolean("live", false).apply();
          }
        });
    breaklevelmodel.setSwitchChangedListener(
        (bin, is) -> {
          if (is) GhostIdeAppLoader.getPrefManager().edit().putBoolean("breaks", true).apply();
          else GhostIdeAppLoader.getPrefManager().edit().putBoolean("breaks", false).apply();
        });
    jointogithub.setOnClickListener(
        v -> {
          var msheet = new LayoutSheetEditText(this);
          msheet.show();
          msheet.setokClick(
              i -> {
                var git = new GitHubProfileView(this);
                git.verifyToken(msheet.getText());
                msheet.dismiss();
              });
        });

    StartLuncherApp();
  }

  private void StartLuncherApp() {
    _seechackswich();

    if (war.contains("val")) {

      Drawable drawable = WallpaperManager.getInstance(SettingAppActivity.this).getDrawable();
      if (drawable != null) {
        bar.setBackground(drawable);
      }
    }
    ColorList(getApplicationContext(), getWindow().getDecorView());
  }

  protected void ColorList(Context context, View v) {
    try {
      if ((v instanceof ViewGroup)) {
        ViewGroup vg = (ViewGroup) v;
        for (int i = 0; i < vg.getChildCount(); i++) {
          View child = vg.getChildAt(i);
          ColorList(context, child);
        }
      } else {
        if ((v instanceof ImageView)) {
          ObjectUtils.setColorFilter(((ImageView) v));
        } else if ((v instanceof TextView)) {
          ObjectUtils.setTextColor((TextView) v);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void ColorListTv(Context context, View v) {
    try {
      if ((v instanceof ViewGroup)) {
        ViewGroup vg = (ViewGroup) v;
        for (int i = 0; i < vg.getChildCount(); i++) {
          View child = vg.getChildAt(i);
          ColorList(context, child);
        }
      } else {
        if ((v instanceof TextView)) {
          ObjectUtils.setTextColor(((TextView) v));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void _seechackswich() {
    if (ru.contains("rup")) {
      deftheme.setValue(true);
    }
    if (sve.contains("getAutoSave")) {
      autoSaveText.setValue(true);
    }
    if (materialYou.contains("materialYou")) {
      materialYous.setValue(true);
    } else materialYous.setValue(false);

    if (thememanagersoft.contains("effect")) {
      effect.setValue(true);
    }
    if (thememanagersoft.getString("thememanagersoft", "").equals("ok")) {
      walpapersystem.setValue(true);
    } else {
      walpapersystem.setValue(false);
    }
    if (ru.getBoolean("live", false) == true) {
      livemodel.setValue(true);
    } else livemodel.setValue(false);

    if (GhostIdeAppLoader.getPrefManager().getBoolean("breaks", false) == true) {
      breaklevelmodel.setValue(true);
    } else breaklevelmodel.setValue(false);

    if (Analyzercod.getBoolean("Analyzercod", false) == true) codeAZ.setValue(true);
    else codeAZ.setValue(false);

    List<String> fb = new ArrayList<>();
    fb.add("");
    fb.add("");
    fb.add("");
    fb.add("");
    fb.add("");
    fb.add("");
    fb.add("");
    fb.add("");
    fb.add("");
    grids.setValue(gridMode.contains("gride"));
    rvsetting.setAdapter(new Recyclerview2Adapter(fb));
    rvsetting.setLayoutManager(new LinearLayoutManager(this));
  }

  public void _blursize() {
    var di = new GhostWebMaterialDialog(SettingAppActivity.this);
    ViewGroup viewGroup = findViewById(android.R.id.content);
    View dialogview =
        getLayoutInflater().inflate(R.layout.layout_editor_size_blur, viewGroup, false);
    ir.ninjacoder.ghostide.layoutmanager.SliderCompat slider = dialogview.findViewById(R.id.slider);
    di.setTitle("Blur Size");
    di.setMessage("Set Number 1~25");
    if (thememanagersoft != null) {

      slider.setValue(thememanagersoft.getFloat("br", 1));
    }
    di.setNeutralButton(
        android.R.string.ok,
        (p, d) -> {
          thememanagersoft.edit().putFloat("br", slider.getValue()).apply();
        });
    di.setView(dialogview);
    di.show();
  }

  public void showMessage(String _s) {
    Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
  }

  private void initIconColors() {
    var dialog = new MaterialAlertDialogBuilder(this);
    dialog.setTitle(getString(R.string.select_icon_app));
    dialog.setPositiveButton(android.R.string.cancel, null);
    dialog.setMessage(getString(R.string.set_custom_icon_message));
    var list = new ListView(this);
    list.setLayoutParams(
        new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
    dialog.setView(list);
    list.setDividerHeight(0);
    list.setDivider(new ColorDrawable(Color.TRANSPARENT));
    list.setOnItemClickListener(
        new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
            final int _position = _param3;
            var myicon = new AppIconManager(SettingAppActivity.this, _position);
            myicon.setIconManager();
            int iconput = 0;
            switch (_position) {
              case 0:
                iconput = 0;
                break;
              case 1:
                iconput = 1;
                break;
              case 2:
                iconput = 2;
                break;
              case 3:
                iconput = 3;
                break;
              case 4:
                iconput = 4;
                break;
              case 5:
                iconput = 5;
                break;
              case 6:
                iconput = 6;
                break;
              case 7:
                iconput = 7;
                break;
              case 8:
                iconput = 8;
                break;
              case 9:
                iconput = 9;
                break;
              case 10:
                iconput = 10;
                break;
              case 11:
                iconput = 11;
                break;
            }
            iconSpash.edit().putInt("iconSpash", iconput).apply();
          }
        });
    map.clear();
    for (int c = 0; c < 12; c++) {
      {
        HashMap<String, Object> item = new HashMap<>();
        item.put("key", "");
        map.add(item);
      }
    }
    list.setAdapter(new ListAppIconAd(map));
    ((BaseAdapter) list.getAdapter()).notifyDataSetChanged();
    dialog.show();
  }

  public class Recyclerview2Adapter extends RecyclerView.Adapter<Recyclerview2Adapter.ViewHolder> {

    List<String> bind;

    public Recyclerview2Adapter(List<String> bind) {
      this.bind = bind;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater _inflater = getLayoutInflater();
      View _v = _inflater.inflate(R.layout.mp2, null);
      RecyclerView.LayoutParams _lp =
          new RecyclerView.LayoutParams(
              ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
      _v.setLayoutParams(_lp);
      return new ViewHolder(_v);
    }

    @Override
    public void onBindViewHolder(ViewHolder _holder, final int _position) {
      View _view = _holder.itemView;

      final LinearLayout text = _view.findViewById(R.id.text);
      final TextView textview1 = _view.findViewById(R.id.textview1);
      final ImageView imageview1 = _view.findViewById(R.id.imageview1);
      String api = bind.get(_position);

      ObjectUtils.setColorFilter(imageview1);
      ObjectUtils.setTextColor(textview1);

      if (_position == 0) {
        textview1.setText(R.string.Customize_font);
        imageview1.setImageResource(R.drawable.mfont);
        _view.setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View _view) {
                customDataRow(
                    "Custom Font Editor", "type dir font .ttf format... ", "mfont", setfont);
              }
            });
      }
      if (_position == 1) {
        _view.setOnClickListener(
            c -> {
              initIconColors();
            });
        textview1.setText(getString(R.string.custom_icons));
        imageview1.setImageResource(R.drawable.keyboardlisnertalluserpost_3);
      }
      if (_position == 2) {
        _view.setOnClickListener(_riee_ -> terminalTheme());
        textview1.setText(getString(R.string.termthemes));
        imageview1.setImageResource(R.drawable.ic_material_settings);
      }
      if (_position == 3) {
        _view.setOnClickListener(_ddd_ -> CustomPythonCode());
        textview1.setText(getString(R.string.scriptcustom));
        imageview1.setImageResource(R.drawable.ic_material_console);
      }
      if (_position == 4) {
        textview1.setText(getString(R.string.customthemeapp));
        imageview1.setImageResource(R.drawable.ghosttheme);
        _view.setOnClickListener(
            _dddrr_ -> {
              ThemeChooserDialogBuilder dialog =
                  new ThemeChooserDialogBuilder(SettingAppActivity.this);
              dialog.setPositiveButton(
                  "OK",
                  (position, theme) -> {
                    GhostIdeAppLoader.getThemeEngine().setStaticTheme(theme);
                    themeEngine.setStaticTheme(theme);
                    ((GhostIdeAppLoader) getApplicationContext()).onThemeChange();
                    recreate();
                    finishAffinity();
                  });
              dialog.setNegativeButton("Cancel");
              dialog.setNeutralButton(
                  "Default",
                  (param1, param2) -> {
                    themeEngine.resetTheme();
                    GhostIdeAppLoader.getThemeEngine().resetTheme();
                    ((GhostIdeAppLoader) getApplicationContext()).onThemeChange();
                    recreate();
                  });
              dialog.create().show();
            });
      }
      if (_position == 5) {
        textview1.setText(getString(R.string.customchareditor));
        _view.setOnClickListener(v -> getCustomChar());
        imageview1.setImageResource(0);
      }
      if (_position == 6) {
        textview1.setText(getString(R.string.cursoreditoricon));
        _view.setOnClickListener(
            g -> {
              new IconCursorImpl(SettingAppActivity.this);
            });
        imageview1.setImageResource(0);
      }
      if (_position == 7) {
        textview1.setText(getString(R.string.backgroundimageeditor));
        _view.setOnClickListener(v -> getVideoBackground());
        imageview1.setImageResource(0);
      }
      if (_position == 8) {
        textview1.setText(getString(R.string.backgroundimageeditor));
        _view.setOnClickListener(v -> showEF());
        imageview1.setImageResource(0);
      }
    }

    @Override
    public int getItemCount() {
      return bind.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      public ViewHolder(View v) {
        super(v);
      }
    }
  }

  void terminalTheme() {
    datarow(
        getString(R.string.custom_theme_terminal),
        getString(R.string.select_property_theme),
        "themes");
  }

  void CustomPythonCode() {
    datarow(
        getString(R.string.custom_python_code), getString(R.string.type_python_script), "Script");
  }

  void getCustomChar() {
    datarow(getString(R.string.custom_char_editor), getString(R.string.select_char_name), "chars");
  }

  void getVideoBackground() {
    datarow(
        getString(R.string.custom_image_background), getString(R.string.select_dir_image), "dir");
  }

  void datarow(String title, String hint, String key) {
    var sheet = new LayoutSheetEditText(this);
    sheet.setTitle(title);
    var input = sheet.getInputLayout();
    var edit = input.getEditText();
    sheet.setText(getvb.getString(key, ""));
    input.setHint(hint);
    sheet.setokClick(
        v -> {
          getvb.edit().putString(key, sheet.getText()).apply();
          sheet.dismiss();
          Toast.makeText(
                  getApplicationContext(),
                  key + " : ".concat(sheet.getText().trim().concat("Done!")),
                  2)
              .show();
        });
    sheet.setnoClick(
        v -> {
          getvb.edit().remove(key).apply();
          sheet.dismiss();
        });
    sheet.show();
  }

  void customDataRow(String title, String hint, String key, SharedPreferences prf) {
    var sheet = new LayoutSheetEditText(this);
    sheet.setTitle(title);
    var input = sheet.getInputLayout();
    var edit = input.getEditText();
    sheet.setText(prf.getString(key, ""));
    input.setHint(hint);
    sheet.setokClick(
        v -> {
          prf.edit().putString(key, sheet.getText()).apply();
          sheet.dismiss();
          Toast.makeText(
                  getApplicationContext(),
                  key + " : ".concat(sheet.getText().trim().concat("Done!")),
                  2)
              .show();
        });
    sheet.setnoClick(
        v -> {
          prf.edit().remove(key).apply();
          sheet.dismiss();
        });
    sheet.show();
  }

  void showthemeeruda() {
    ErudaThemes currentTheme = ErudaThemeManager.getCurrentTheme(this);
    String[] themeNames = ErudaThemes.getAllThemeNames();
    int currentIndex = Arrays.asList(themeNames).indexOf(currentTheme.getThemeName());

    new MaterialAlertDialogBuilder(this)
        .setTitle("select theme eruda")
        .setSingleChoiceItems(
            themeNames,
            currentIndex,
            (dialog, which) -> {
              ErudaThemes selectedTheme = ErudaThemes.values()[which];
              ErudaThemeManager.saveTheme(SettingAppActivity.this, selectedTheme);
            })
        .setNegativeButton(android.R.string.ok, null)
        .show();
  }

  void showEF() {
    PowerModeEffectManager.EffectType currentEffect = EffectTypeManager.getCurrentTheme(this);
    String[] effectNames = PowerModeEffectManager.EffectType.getAllName();

    int currentIndex = -1;
    for (int i = 0; i < PowerModeEffectManager.EffectType.values().length; i++) {
      if (PowerModeEffectManager.EffectType.values()[i] == currentEffect) {
        currentIndex = i;
        break;
      }
    }

    new MaterialAlertDialogBuilder(this)
        .setTitle("Select Effect Type")
        .setSingleChoiceItems(
            effectNames,
            currentIndex,
            (dialog, which) -> {
              PowerModeEffectManager.EffectType selectedEffect =
                  PowerModeEffectManager.EffectType.values()[which];
              EffectTypeManager.saveTheme(SettingAppActivity.this, selectedEffect);
            })
        .setPositiveButton(
            android.R.string.ok,
            (dialog, which) -> {
              dialog.dismiss();
            })
        .show();
  }
}
