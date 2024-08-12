package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.ApplicationLoader;
import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.adapter.ListAppIconAd;
import Ninja.coder.Ghostemane.code.config.AppIconManager;
import Ninja.coder.Ghostemane.code.config.SwitchMaterialPrf;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.utils.DataUtil;
import Ninja.coder.Ghostemane.code.widget.GhostWebMaterialDialog;
import Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat.FastScrollNestedScrollView;
import Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat.FastScrollerBuilder;
import android.animation.ObjectAnimator;
import android.app.Activity;

import android.app.WallpaperManager;
import android.content.*;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import com.google.android.material.textfield.TextInputLayout;
import com.ninjacoder.jgit.childer.LayoutChilder;
import com.quickersilver.themeengine.ThemeChooserDialogBuilder;
import com.quickersilver.themeengine.ThemeEngine;
import com.quickersilver.themeengine.ThemeMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SettingAppActivity extends BaseCompat {

  private Timer _timer = new Timer();

  private Toolbar _toolbar;
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
  private FastScrollNestedScrollView bar;
  private RecyclerView rvsetting;
  private Intent intent = new Intent();
  private SwitchMaterialPrf materialYous, effect, grids, walpapersystem, deftheme, autoSaveText;
  private ObjectAnimator mdownObjectAnimator = new ObjectAnimator();
  private SharedPreferences mt300;
  private TimerTask timer;
  private SharedPreferences lb,
      word,
      line,
      mfs,
      getvb,
      getDark,
      re,
      war,
      tab100,
      setfont,
      atx,
      ru,
      tmp,
      auto,
      tabimageview,
      getDrak,
      moalaqfragment,
      sve,
      getinitdir,
      mthemepost,
      shSizePx,
      setac,
      materialYou,
      thememanagersoft,
      sf,
      gridMode;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.settingapp);
    initialize(_savedInstanceState);
  }

  public int colors() {
    return MaterialColors.getColor(
        getWindow().getDecorView(), com.google.android.material.R.attr.colorOnSurface, 0);
  }

  private void initialize(Bundle _savedInstanceState) {
    _app_bar = findViewById(R.id._app_bar);
    _coordinator = findViewById(R.id._coordinator);
    _toolbar = findViewById(R.id._toolbar);
    setSupportActionBar(_toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    _toolbar.setNavigationOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _v) {
            onBackPressed();
          }
        });
    themeEngine = ThemeEngine.getInstance(this);
    themeEngine.setThemeMode(ThemeMode.DARK);
    themeEngine.applyToActivity(this);
    bar = findViewById(R.id.bar);

    word = getSharedPreferences("word", Activity.MODE_PRIVATE);
    line = getSharedPreferences("line", Activity.MODE_PRIVATE);
    mfs = getSharedPreferences("mfs", Activity.MODE_PRIVATE);
    getvb = getSharedPreferences("getvb", Activity.MODE_PRIVATE);
    getDrak = getSharedPreferences("getDrak", Activity.MODE_PRIVATE);
    re = getSharedPreferences("re", Activity.MODE_PRIVATE);
    war = getSharedPreferences("war", Activity.MODE_PRIVATE);
    tab100 = getSharedPreferences("tab100", Activity.MODE_PRIVATE);
    setfont = getSharedPreferences("setfont", Activity.MODE_PRIVATE);
    atx = getSharedPreferences("atx", Activity.MODE_PRIVATE);
    ru = getSharedPreferences("ru", Activity.MODE_PRIVATE);
    tmp = getSharedPreferences("tmp", Activity.MODE_PRIVATE);
    auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
    tabimageview = getSharedPreferences("tabimageview", Activity.MODE_PRIVATE);
    moalaqfragment = getSharedPreferences("moalaqfragment", Activity.MODE_PRIVATE);
    mt300 = getSharedPreferences("mt300", Activity.MODE_PRIVATE);
    lb = getSharedPreferences("lb", Activity.MODE_PRIVATE);
    sve = getSharedPreferences("sve", Activity.MODE_PRIVATE);
    getinitdir = getSharedPreferences("getinitdir", Activity.MODE_PRIVATE);
    mthemepost = getSharedPreferences("mthemepost", Activity.MODE_PRIVATE);
    shSizePx = getSharedPreferences("shSizePx", Activity.MODE_PRIVATE);
    setac = getSharedPreferences("setac", Activity.MODE_PRIVATE);
    materialYou = getSharedPreferences("materialYou", Activity.MODE_PRIVATE);
    thememanagersoft = getSharedPreferences("thememanagersoft", Activity.MODE_PRIVATE);
    sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
    gridMode = getSharedPreferences("gride", Activity.MODE_PRIVATE);
    materialYous = findViewById(R.id.MaterialYou);
    grids = findViewById(R.id.gridmod);
    effect = findViewById(R.id.effect);
    walpapersystem = findViewById(R.id.walpapers);
    deftheme = findViewById(R.id.deftheme);
    autoSaveText = findViewById(R.id.autoSaveText);
    rvsetting = findViewById(R.id.rvsetting);
    materialYous.setTitle("MaterialYou");
    materialYous.setDescription("Enable dynamic colors automatically and Try a Best Color expirence");
    effect.setTitle("Beautiful effect");
    effect.setDescription("By activating this option, the background will have a small vibration");
    grids.setTitle("Grid Mode ");
    grids.setDescription(
        "This option is for those who are tired of the normal mode and want to have a better experience ");
    walpapersystem.setTitle("Get SystemWallpaper ");
    walpapersystem.setDescription("With this option, you can get the system background");
    deftheme.setTitle("Default theme ");
    deftheme.setDescription(
        "By activating this option, the program theme is not read from Json by default");

    autoSaveText.setTitle("Auto Save");
    autoSaveText.setDescription(
        "You do not need to click the save button with the auto save activation.");
    
    

    findViewById(R.id.customtheme)
        .setOnClickListener(
            (v) -> {
              intent.setClass(getApplicationContext(), InjectorColorActivity.class);
              intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
              startActivity(intent);
            });

    findViewById(R.id.keyboardsettings)
        .setOnClickListener(
            (c) -> {
              intent.setClass(getApplicationContext(), ResultActivity.class);
              startActivity(intent);
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
    findViewById(R.id.blursize)
        .setOnClickListener(
            c -> {
              _blursize();
            });

    findViewById(R.id.themefile)
        .setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View _view) {
                androidx.appcompat.app.AlertDialog dialog =
                    new GhostWebMaterialDialog(SettingAppActivity.this)
                        .setView(R.layout.fontsetlector)
                        .setTitle("Custom Theme")
                        .setMessage("Select Theme in format .ghost")
                        .setCancelable(true)
                        .setPositiveButton("ok", null)
                        .setNegativeButton(android.R.string.cancel, null)
                        .setNeutralButton("پیشفرض", null)
                        .create();
                dialog.setOnShowListener(
                    (var) -> {
                      Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
                      Button np = dialog.getButton(android.content.DialogInterface.BUTTON_NEUTRAL);
                      com.google.android.material.textfield.TextInputLayout input =
                          dialog.findViewById(R.id.input);

                      EditText edit = dialog.findViewById(R.id.edit);

                      final Handler handler = new Handler();
                      handler.postDelayed(
                          new Runnable() {
                            @Override
                            public void run() {
                              if (thememanagersoft.contains("themes")
                                  && !thememanagersoft.getString("themes", "").equals("")) {
                                edit.setText(thememanagersoft.getString("themes", ""));
                              }
                            }
                          },
                          100);
                      edit.setHint("Set .ghost file");
                      ColorAndroid12.setTextColor(edit);
                      if (edit.getText().toString().isEmpty()) {
                        positive.setEnabled(false);
                      } else {
                        positive.setEnabled(true);
                      }
                      positive.setOnClickListener(
                          (vftrororocjj) -> {
                            thememanagersoft
                                .edit()
                                .putString("themes", edit.getText().toString())
                                .commit();
                            dialog.dismiss();
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Theme : "
                                        .concat(
                                            edit.getText().toString().trim().concat(" اعمال شد")),
                                    2)
                                .show();
                          });
                      edit.addTextChangedListener(
                          new android.text.TextWatcher() {
                            @Override
                            public void onTextChanged(
                                CharSequence _param1, int _param2, int _param3, int _param4) {
                              final String _charSeq = _param1.toString();

                              if (edit.getText().toString().isEmpty()
                                  && edit.getText().toString().endsWith("")) {
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
                      np.setOnClickListener(
                          (vftrororocjj) -> {
                            thememanagersoft.edit().remove("themes").commit();
                            DataUtil.showMessage(getApplicationContext(), "تم پیشفرض اعمال شد");
                            dialog.dismiss();
                          });
                      if (thememanagersoft.contains("themes")
                          && thememanagersoft.getString("themes", "").equals("")) {
                        edit.setText(thememanagersoft.getString("themes", ""));
                      }
                    });
                final View view = dialog.getWindow().getDecorView();
                dialog
                    .getWindow()
                    .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
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
            });

    findViewById(R.id.customwindows)
        .setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View _view) {
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
        StartLuncherApp(); 
  }

  private void StartLuncherApp() {
    _seechackswich();

    var fastScrollerBuilder = new FastScrollerBuilder(bar);
    fastScrollerBuilder.useMd2Style();
    fastScrollerBuilder.setPadding(3, 3, 3, 3);
    fastScrollerBuilder.build();

    if (war.contains("val")) {

      Drawable drawable = WallpaperManager.getInstance(SettingAppActivity.this).getDrawable();
      if (drawable != null) {
        bar.setBackgroundDrawable(drawable);
      }
    }

    ColorList(getApplicationContext(), getWindow().getDecorView());

    _toolbar.setBackgroundColor(Color.TRANSPARENT);
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
          ColorAndroid12.setColorFilter(((ImageView) v));
        } else if ((v instanceof TextView)) {
          ColorAndroid12.setTextColor((TextView) v);
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
          ColorAndroid12.setTextColor(((TextView) v));
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
    
    ColorAndroid12.setToolbarinit(_toolbar);
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

    List<String> fb = new ArrayList<>();
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
    Ninja.coder.Ghostemane.code.layoutmanager.SliderCompat slider =
        dialogview.findViewById(R.id.slider);
    di.setTitle("Blur Size");
    di.setMessage("Set Number 1~25");
    if (thememanagersoft != null) {

      slider.setValue(thememanagersoft.getFloat("br", 1));
    }
    di.setNeutralButton(
        "ok",
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
    dialog.setTitle("Select icon app");
    dialog.setPositiveButton(android.R.string.cancel, null);
    dialog.setMessage("You can set Custom icon from app");
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
          }
        });
    map.clear();
    for (int c = 0; c < 9; c++) {
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

      ColorAndroid12.setColorFilter(imageview1);
      ColorAndroid12.setTextColor(textview1);

      if (_position == 0) {
        textview1.setText(R.string.Customize_font);
        imageview1.setImageResource(R.drawable.mfont);
        _view.setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View _view) {
                androidx.appcompat.app.AlertDialog dialog =
                    new GhostWebMaterialDialog(SettingAppActivity.this)
                        .setView(R.layout.fontsetlector)
                        .setTitle("فونت شخصی")
                        .setMessage(
                            "لطفا دقت کنید که حتمان باید فرمت فونت .ttf باشد در غیر این صورت با خطا برنامه متوجه میشوید")
                        .setCancelable(true)
                        .setPositiveButton("تایید", null)
                        .setNegativeButton(android.R.string.cancel, null)
                        .setNeutralButton("پیشفرض", null)
                        .create();
                dialog.setOnShowListener(
                    (var) -> {
                      Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
                      Button np = dialog.getButton(android.content.DialogInterface.BUTTON_NEUTRAL);
                      com.google.android.material.textfield.TextInputLayout input =
                          dialog.findViewById(R.id.input);

                      EditText edit = dialog.findViewById(R.id.edit);

                      final Handler handler = new Handler(Looper.getMainLooper());
                      handler.postDelayed(
                          new Runnable() {
                            @Override
                            public void run() {
                              if (setfont.contains("mfont")
                                  && !setfont.getString("mfont", "").equals("")) {
                                edit.setText(setfont.getString("mfont", ""));
                              }
                            }
                          },
                          100);

                      if (edit.getText().toString().isEmpty()) {
                        positive.setEnabled(false);
                      } else {
                        positive.setEnabled(true);
                      }
                      positive.setOnClickListener(
                          (vftrororocjj) -> {
                            setfont.edit().putString("mfont", edit.getText().toString()).commit();
                            dialog.dismiss();
                          });
                      edit.addTextChangedListener(
                          new android.text.TextWatcher() {
                            @Override
                            public void onTextChanged(
                                CharSequence _param1, int _param2, int _param3, int _param4) {
                              final String _charSeq = _param1.toString();

                              if (edit.getText().toString().isEmpty()) {
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
                      np.setOnClickListener(
                          (vftrororocjj) -> {
                            setfont.edit().remove("mfont").commit();
                            dialog.dismiss();
                            DataUtil.showMessage(getApplicationContext(), "فونت پیشفرض اعمال شد");
                          });
                      if (setfont.contains("mfont") && setfont.getString("mfont", "").equals("")) {
                        edit.setText(setfont.getString("mfont", ""));
                      }
                    });
                final View view = dialog.getWindow().getDecorView();
                dialog
                    .getWindow()
                    .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
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
            });
      }
      if (_position == 1) {
        _view.setOnClickListener(
            c -> {
              initIconColors();
            });
        textview1.setText("Custom icon");
        imageview1.setImageResource(R.drawable.keyboardlisnertalluserpost_3);
      }
      if (_position == 2) {
        _view.setOnClickListener(_riee_ -> terminalTheme());
        textview1.setText("Terminal Theme");
        imageview1.setImageResource(R.drawable.ic_material_settings);
      }
      if (_position == 3) {
        _view.setOnClickListener(_ddd_ -> CustomPythonCode());
        textview1.setText("Custom Script");
        imageview1.setImageResource(R.drawable.ic_material_console);
      }
      if (_position == 4) {
        textview1.setText("Custom Theme (new)");
        imageview1.setImageResource(R.drawable.ghosttheme);
        _view.setOnClickListener(
            _dddrr_ -> {
              ThemeChooserDialogBuilder dialog =
                  new ThemeChooserDialogBuilder(SettingAppActivity.this);
              dialog.setPositiveButton(
                  "OK",
                  (position, theme) -> {
                    ApplicationLoader.getThemeEngine().setStaticTheme(theme);
                    themeEngine.setStaticTheme(theme);
                    ((ApplicationLoader) getApplicationContext()).onThemeChange();
                    recreate();
                    finishAffinity();
                  });
              dialog.setNegativeButton("Cancel");
              dialog.setNeutralButton(
                  "Default",
                  (param1, param2) -> {
                    themeEngine.resetTheme();
                    ApplicationLoader.getThemeEngine().resetTheme();
                    ((ApplicationLoader) getApplicationContext()).onThemeChange();
                    recreate();
                  });
              dialog.create().show();
            });
      }
      if(_position == 5) {
      	textview1.setText("Custom Char editor");
          _view.setOnClickListener(v -> getCustomChar());
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

    AlertDialog dialog =
        new GhostWebMaterialDialog(SettingAppActivity.this)
            .setView(R.layout.fontsetlector)
            .setTitle("Custom Theme Terminal ")
            .setMessage("Choose a theme in Property Format")
            .setCancelable(true)
            .setPositiveButton("ok", null)
            .setNegativeButton(android.R.string.cancel, null)
            .setNeutralButton("پیشفرض", null)
            .create();
    dialog.setOnShowListener(
        (var) -> {
          Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          Button np = dialog.getButton(DialogInterface.BUTTON_NEUTRAL);
          TextInputLayout input = dialog.findViewById(R.id.input);

          EditText edit = dialog.findViewById(R.id.edit);

          final Handler handler = new Handler(Looper.getMainLooper());
          handler.postDelayed(
              new Runnable() {
                @Override
                public void run() {
                  if (getvb.contains("themes") && !getvb.getString("themes", "").equals("")) {
                    edit.setText(getvb.getString("themes", ""));
                  }
                }
              },
              100);
          input.setHint("Select Property theme");
          ColorAndroid12.setTextColor(edit);
          if (edit.getText().toString().isEmpty()) {
            positive.setEnabled(false);
          } else {
            positive.setEnabled(true);
          }
          positive.setOnClickListener(
              (vftrororocjj) -> {
                getvb.edit().putString("themes", edit.getText().toString()).apply();
                dialog.dismiss();
                Toast.makeText(
                        getApplicationContext(),
                        "Theme : ".concat(edit.getText().toString().trim().concat(" اعمال شد")),
                        2)
                    .show();
              });
          edit.addTextChangedListener(
              new TextWatcher() {
                @Override
                public void onTextChanged(
                    CharSequence _param1, int _param2, int _param3, int _param4) {

                  if (edit.getText().toString().isEmpty()
                      && edit.getText().toString().endsWith("")) {
                    positive.setEnabled(false);
                  } else {
                    positive.setEnabled(true);
                  }
                }

                @Override
                public void beforeTextChanged(
                    CharSequence _param1, int _param2, int _param3, int _param4) {}

                @Override
                public void afterTextChanged(Editable p) {}
              });
          np.setOnClickListener(
              (vftrororocjj) -> {
                getvb.edit().remove("themes").apply();
                DataUtil.showMessage(getApplicationContext(), "تم پیشفرض اعمال شد");
                dialog.dismiss();
              });
          if (getvb.contains("themes") && getvb.getString("themes", "").equals("")) {
            edit.setText(getvb.getString("themes", ""));
          }
        });

    dialog.show();
  }

  void CustomPythonCode() {
    AlertDialog dialog =
        new GhostWebMaterialDialog(SettingAppActivity.this)
            .setView(R.layout.fontsetlector)
             .setPositiveButton(android.R.string.ok, null)
            .setNeutralButton(android.R.string.cancel, null)
            .setCancelable(true)
            .setPositiveButton("ok", null)
            .setNeutralButton("پیشفرض", null)
            .create();
    dialog.setOnShowListener(
        (var) -> {
          Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          Button np = dialog.getButton(DialogInterface.BUTTON_NEUTRAL);
          TextInputLayout input = dialog.findViewById(R.id.input);

          EditText edit = dialog.findViewById(R.id.edit);

          final Handler handler = new Handler(Looper.getMainLooper());
          handler.postDelayed(
              new Runnable() {
                @Override
                public void run() {
                  if (getvb.contains("Script") && !getvb.getString("Script", "").equals("")) {
                    edit.setText(getvb.getString("Script", ""));
                  }
                }
              },
              100);
          input.setHint("Select Property theme");
          ColorAndroid12.setTextColor(edit);
          if (edit.getText().toString().isEmpty()) {
            positive.setEnabled(false);
          } else {
            positive.setEnabled(true);
          }
          positive.setOnClickListener(
              (vftrororocjj) -> {
                getvb.edit().putString("Script", edit.getText().toString()).apply();
                dialog.dismiss();
                Toast.makeText(
                        getApplicationContext(),
                        "Script : ".concat(edit.getText().toString().trim().concat(" اعمال شد")),
                        2)
                    .show();
              });
          edit.addTextChangedListener(
              new TextWatcher() {
                @Override
                public void onTextChanged(
                    CharSequence _param1, int _param2, int _param3, int _param4) {

                  if (edit.getText().toString().isEmpty()
                      && edit.getText().toString().endsWith("")) {
                    positive.setEnabled(false);
                  } else {
                    positive.setEnabled(true);
                  }
                }

                @Override
                public void beforeTextChanged(
                    CharSequence _param1, int _param2, int _param3, int _param4) {}

                @Override
                public void afterTextChanged(Editable p) {}
              });
          np.setOnClickListener(
              (vftrororocjj) -> {
                getvb.edit().remove("Script").apply();
                DataUtil.showMessage(getApplicationContext(), "کاستوم اسکریپت اعمال شد ");
                dialog.dismiss();
              });
          if (getvb.contains("Script") && getvb.getString("Script", "").equals("")) {
            edit.setText(getvb.getString("Script", ""));
          }
        });

    dialog.show();
  }
  
  void getCustomChar(){
    AlertDialog dialog =
        new GhostWebMaterialDialog(SettingAppActivity.this)
            .setView(R.layout.fontsetlector)
            .setTitle("Custom Char Editor")
            .setMessage("Select Char ")
            .setCancelable(true)
            .setPositiveButton(android.R.string.ok, null)
            .setNeutralButton(android.R.string.cancel, null)
            .create();
    dialog.setOnShowListener(
        (var) -> {
          Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
          Button np = dialog.getButton(DialogInterface.BUTTON_NEUTRAL);
          TextInputLayout input = dialog.findViewById(R.id.input);
          EditText edit = dialog.findViewById(R.id.edit);
          final Handler handler = new Handler(Looper.getMainLooper());
          handler.postDelayed(
              new Runnable() {
                @Override
                public void run() {
                  if (getvb.contains("chars") && !getvb.getString("chars", "").equals("")) {
                    edit.setText(getvb.getString("chars", ""));
                  }
                }
              },
              100);
          input.setHint("Select Char name Like 👻");
          ColorAndroid12.setTextColor(edit);
          if (edit.getText().toString().isEmpty()) {
            positive.setEnabled(false);
          } else {
            positive.setEnabled(true);
          }
          positive.setOnClickListener(
              (__) -> {
                getvb.edit().putString("chars", edit.getText().toString()).apply();
                dialog.dismiss();
                Toast.makeText(
                        getApplicationContext(),
                        "chars : ".concat(edit.getText().toString().trim().concat(" اعمال شد")),
                        2)
                    .show();
              });
          edit.addTextChangedListener(
              new TextWatcher() {
                @Override
                public void onTextChanged(
                    CharSequence _param1, int _param2, int _param3, int _param4) {

                  if (edit.getText().toString().isEmpty()
                      && edit.getText().toString().endsWith("")) {
                    positive.setEnabled(false);
                  } else {
                    positive.setEnabled(true);
                  }
                }

                @Override
                public void beforeTextChanged(
                    CharSequence _param1, int _param2, int _param3, int _param4) {}

                @Override
                public void afterTextChanged(Editable p) {}
              });
          np.setOnClickListener(
              (vftrororocjj) -> {
                getvb.edit().remove("chars").apply();
                DataUtil.showMessage(getApplicationContext(), "کاستوم کارکتر اعمال شد ");
                dialog.dismiss();
              });
          if (getvb.contains("chars") && getvb.getString("chars", "").equals("")) {
            edit.setText(getvb.getString("chars", ""));
          }
        });

    dialog.show();
  }
}
