package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.ApplicationLoader;
import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.activities.SettingAppActivity;
import Ninja.coder.Ghostemane.code.adapter.ListAppIconAd;
import Ninja.coder.Ghostemane.code.config.AppIconManager;
import Ninja.coder.Ghostemane.code.model.LoadTheme;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.utils.DataUtil;
import Ninja.coder.Ghostemane.code.utils.ViewUtils;
import Ninja.coder.Ghostemane.code.widget.GhostWebMaterialDialog;
import Ninja.coder.Ghostemane.code.widget.PraramnetLayoutNinja;
import Ninja.coder.Ghostemane.code.widget.SwitchCompatX;
import Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat.FastScrollNestedScrollView;
import Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat.FastScrollerBuilder;
import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;

import android.app.WallpaperManager;
import android.content.*;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.materialswitch.MaterialSwitch;

import com.google.android.material.textfield.TextInputLayout;
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
  private PraramnetLayoutNinja linear1;
  private LinearLayout linear2;
  private LinearLayout linear3;
  private LinearLayout pubilc;
  private LinearLayout linear22;
  private LinearLayout linear14;
  private LinearLayout linear10;
  private LinearLayout linear11;
  private LinearLayout themes;
  private LinearLayout stingkeyboard;
  private LinearLayout keyboard;
  private LinearLayout linear21;
  private TextView textview9;
  private ImageView imageview1;
  private ImageView arrow05;
  private TextView textview10;
  private ImageView imageview7;
  private TextView tvtheme;
  private ImageView imgtheme;
  private ImageView arrow04;
  private TextView textview13;
  private ImageView imageview8;
  private TextView textview14;
  private ImageView imageview3;
  private ImageView arrow03;
  private TextView textview1;
  private ImageView imageview9;
  private TextView tvword;
  private MaterialCheckBox checkbox1;
  private LinearLayout datapost;
  private LinearLayout linear32;
  private LinearLayout linear37;
  private LinearLayout linear33;
  private MaterialSwitch addsabet;
  private LinearLayout linear38;
  private MaterialSwitch vibreh;
  private LinearLayout add;
  private LinearLayout reminderadditem;
  private LinearLayout linear25;
  private LinearLayout size;
  private ImageView arrow02;
  private TextView textview20;
  private ImageView imageview11;
  private LinearLayout linear29;
  private LinearLayout linear67;
  private LinearLayout linear93;
  private LinearLayout linear28;
  private MaterialSwitch sw;
  private LinearLayout linear68;
  private LinearLayout linear70;
  private MaterialSwitch molaq;
  private LinearLayout linear95;
  private MaterialSwitch switchobtical;
  private LinearLayout linear27;
  private LinearLayout autotext;
  private ImageView arrow01;
  private TextView textview6;
  private ImageView imageview10;
  private LinearLayout rose;
  private RecyclerView recyclerview2;
  private LinearLayout linear42;
  private LinearLayout linear47;
  private LinearLayout linear52;
  private LinearLayout linear57;
  private LinearLayout linear71;
  private LinearLayout linear75;
  private LinearLayout linear79;
  private LinearLayout linear83;
  private LinearLayout linear84;
  private LinearLayout linear88;
  private LinearLayout getThemeUtils;
  private LinearLayout atctm;
  private LinearLayout linear92;
  private LinearLayout linear43;
  private LinearLayout linear45;
  private MaterialSwitch autotextComple, terminalColors, wallmodes;
  private LinearLayout linear48;
  private LinearLayout linear49;
  private LinearLayout linear50;
  private TextView textview25;
  private LinearLayout backtab;
  private SwitchCompatX tab;
  private LinearLayout linear53;
  private LinearLayout linear55;
  private MaterialSwitch lineeditor;
  private LinearLayout linear58;
  private LinearLayout linear60;
  private MaterialSwitch themesabet;
  private LinearLayout linear72;
  private LinearLayout linear74;
  private MaterialSwitch msaveandexit;
  private LinearLayout linear76;
  private LinearLayout linear78;
  private MaterialSwitch dirfilesswitch, treecolors, grmode;
  private LinearLayout linear80;
  private LinearLayout linear82;
  private MaterialSwitch themeinstall;
  private TextView textview33;
  private ImageView imageview12;
  private LinearLayout linear85;
  private LinearLayout linear87;
  private MaterialSwitch switchac;
  private LinearLayout linear89;
  private LinearLayout linear91;
  private MaterialSwitch switchmaterialYou;
  private TextView customTheme;
  private TextView textview36;
  private TextView textview37;
  private TextView textview15;
  private MaterialCheckBox checkbox9;

  private Intent intent = new Intent();

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
      kos,
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

    if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        == PackageManager.PERMISSION_DENIED) {
      ActivityCompat.requestPermissions(
          this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
    } else {
      StartLuncherApp();
    }
  }

  @Override
  public void onRequestPermissionsResult(
      int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == 1000) {
      StartLuncherApp();
    }
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
    linear1 = findViewById(R.id.linear1);
    linear2 = findViewById(R.id.linear2);
    linear3 = findViewById(R.id.linear3);
    grmode = findViewById(R.id.grmode);
    pubilc = findViewById(R.id.pubilc);
    linear22 = findViewById(R.id.linear22);
    linear14 = findViewById(R.id.linear14);
    linear10 = findViewById(R.id.linear10);
    linear11 = findViewById(R.id.linear11);
    themes = findViewById(R.id.themes);
    stingkeyboard = findViewById(R.id.stingkeyboard);
    keyboard = findViewById(R.id.keyboard);
    linear21 = findViewById(R.id.linear21);
    textview9 = findViewById(R.id.textview9);
    imageview1 = findViewById(R.id.imageview1);
    arrow05 = findViewById(R.id.arrow05);
    textview10 = findViewById(R.id.textview10);
    imageview7 = findViewById(R.id.imageview7);
    tvtheme = findViewById(R.id.tvtheme);
    imgtheme = findViewById(R.id.imgtheme);
    arrow04 = findViewById(R.id.arrow04);
    textview13 = findViewById(R.id.textview13);
    imageview8 = findViewById(R.id.imageview8);
    textview14 = findViewById(R.id.textview14);
    imageview3 = findViewById(R.id.imageview3);
    arrow03 = findViewById(R.id.arrow03);
    textview1 = findViewById(R.id.textview1);
    imageview9 = findViewById(R.id.imageview9);
    tvword = findViewById(R.id.tvword);
    checkbox1 = findViewById(R.id.checkbox1);
    datapost = findViewById(R.id.datapost);
    linear32 = findViewById(R.id.linear32);
    linear37 = findViewById(R.id.linear37);
    linear33 = findViewById(R.id.linear33);
    addsabet = findViewById(R.id.addsabet);
    linear38 = findViewById(R.id.linear38);
    vibreh = findViewById(R.id.vibreh);
    add = findViewById(R.id.add);
    reminderadditem = findViewById(R.id.reminderadditem);
    linear25 = findViewById(R.id.linear25);
    size = findViewById(R.id.size);
    arrow02 = findViewById(R.id.arrow02);
    textview20 = findViewById(R.id.textview20);
    imageview11 = findViewById(R.id.imageview11);
    linear29 = findViewById(R.id.linear29);
    linear67 = findViewById(R.id.linear67);
    linear93 = findViewById(R.id.linear93);
    linear28 = findViewById(R.id.linear28);
    sw = findViewById(R.id.sw);
    linear68 = findViewById(R.id.linear68);
    linear70 = findViewById(R.id.linear70);
    molaq = findViewById(R.id.molaq);
    linear95 = findViewById(R.id.linear95);
    switchobtical = findViewById(R.id.switchobtical);
    linear27 = findViewById(R.id.linear27);
    autotext = findViewById(R.id.autotext);
    arrow01 = findViewById(R.id.arrow01);
    textview6 = findViewById(R.id.textview6);
    imageview10 = findViewById(R.id.imageview10);
    rose = findViewById(R.id.rose);
    recyclerview2 = findViewById(R.id.recyclerview2);
    linear42 = findViewById(R.id.linear42);
    linear47 = findViewById(R.id.linear47);
    linear52 = findViewById(R.id.linear52);
    linear57 = findViewById(R.id.linear57);
    linear71 = findViewById(R.id.linear71);
    linear75 = findViewById(R.id.linear75);
    linear79 = findViewById(R.id.linear79);
    linear83 = findViewById(R.id.linear83);
    linear84 = findViewById(R.id.linear84);
    linear88 = findViewById(R.id.linear88);
    getThemeUtils = findViewById(R.id.getThemeUtils);
    atctm = findViewById(R.id.atctm);
    linear92 = findViewById(R.id.linear92);
    linear43 = findViewById(R.id.linear43);
    linear45 = findViewById(R.id.linear45);
    autotextComple = findViewById(R.id.autotextComple);
    linear48 = findViewById(R.id.linear48);
    linear49 = findViewById(R.id.linear49);
    linear50 = findViewById(R.id.linear50);
    textview25 = findViewById(R.id.textview25);
    backtab = findViewById(R.id.backtab);
    tab = findViewById(R.id.tab);
    linear53 = findViewById(R.id.linear53);
    linear55 = findViewById(R.id.linear55);
    lineeditor = findViewById(R.id.lineeditor);
    linear58 = findViewById(R.id.linear58);
    linear60 = findViewById(R.id.linear60);
    themesabet = findViewById(R.id.themesabet);
    linear72 = findViewById(R.id.linear72);
    linear74 = findViewById(R.id.linear74);
    msaveandexit = findViewById(R.id.msaveandexit);
    linear76 = findViewById(R.id.linear76);
    linear78 = findViewById(R.id.linear78);
    dirfilesswitch = findViewById(R.id.dirfilesswitch);
    linear80 = findViewById(R.id.linear80);
    linear82 = findViewById(R.id.linear82);
    themeinstall = findViewById(R.id.themeinstall);
    textview33 = findViewById(R.id.textview33);
    imageview12 = findViewById(R.id.imageview12);
    linear85 = findViewById(R.id.linear85);
    linear87 = findViewById(R.id.linear87);
    switchac = findViewById(R.id.switchac);
    linear89 = findViewById(R.id.linear89);
    linear91 = findViewById(R.id.linear91);
    switchmaterialYou = findViewById(R.id.switchmaterialYou);
    customTheme = findViewById(R.id.customTheme);
    textview36 = findViewById(R.id.textview36);
    textview37 = findViewById(R.id.textview37);
    textview15 = findViewById(R.id.textview15);
    checkbox9 = findViewById(R.id.checkbox9);
    treecolors = findViewById(R.id.treecolors);
    wallmodes = findViewById(R.id.wallmodes);
    word = getSharedPreferences("word", Activity.MODE_PRIVATE);
    line = getSharedPreferences("line", Activity.MODE_PRIVATE);
    mfs = getSharedPreferences("mfs", Activity.MODE_PRIVATE);
    getvb = getSharedPreferences("getvb", Activity.MODE_PRIVATE);
    getDrak = getSharedPreferences("getDrak", Activity.MODE_PRIVATE);
    re = getSharedPreferences("re", Activity.MODE_PRIVATE);
    war = getSharedPreferences("war", Activity.MODE_PRIVATE);
    kos = getSharedPreferences("kos", Activity.MODE_PRIVATE);
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
    terminalColors = findViewById(R.id.terminalColors);
    themes.setOnClickListener(
        (v) -> {
          //          intent.setClass(getApplicationContext(), AnjctorcolorActivity.class);
          //          startActivity(intent);
          var theme = new LoadTheme();
          theme.runinSheet(v.getContext());
        });

    keyboard.setOnClickListener(
        (c) -> {
          intent.setClass(getApplicationContext(), ResultActivity.class);
          startActivity(intent);
        });

    imageview1.setOnClickListener(
        (c) -> {
          finish();
        });

    arrow05.setOnClickListener(
        (v) -> {
          ViewUtils.installLazy(themes);
          if (!mbool01) {
            mbool01 = true;
            arrow05.animate().rotation((float) 0).setDuration((int) 300);
          } else {
            mbool01 = false;
            arrow05.animate().rotation((float) -180).setDuration((int) 300);
          }
        });

    tvtheme.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            intent.setClass(getApplicationContext(), InjectorColorActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
          }
        });

    arrow04.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            if (!mbool02) {
              mbool02 = true;
              arrow04.animate().rotation((float) 0).setDuration((int) 300);
            } else {
              mbool02 = false;

              arrow04.animate().rotation((float) -180).setDuration((int) 300);
            }
            ViewUtils.installLazy(keyboard);
          }
        });

    arrow03.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            if (!mbool03) {
              mbool03 = true;
              arrow03.animate().rotation((float) 0).setDuration((int) 300);
            } else {
              mbool03 = false;
              arrow03.animate().rotation((float) -180).setDuration((int) 300);
            }
            ViewUtils.installLazy(datapost);
          }
        });

    checkbox1.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              word.edit().putString("getword", "true").apply();

            } else {
              word.edit().putString("getword", "false").apply();
            }
          }
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
    wallmodes.setOnCheckedChangeListener(
        (btn, is) -> {
          if (is) {
            thememanagersoft.edit().putString("thememanagersoft", "ok").apply();
          } else {
            thememanagersoft.edit().putString("thememanagersoft", "no").apply();
          }
        });

    addsabet.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            /// ثابت کردن عدد
            if (_isChecked) {
              line.edit().putString("getline", "true").apply();
            } else {
              line.edit().remove("getline").apply();
            }
          }
        });
    terminalColors.setOnCheckedChangeListener(
        (btn, _isChecked) -> {
          if (_isChecked) {
            getvb.edit().putString("wall", "true").apply();
          } else {
            getvb.edit().remove("wall").apply();
          }
        });
    treecolors.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            /// لرزش
            if (_isChecked) {
              getvb.edit().putString("HsiGamer", "true").apply();
            } else {
              getvb.edit().remove("HsiGamer").apply();
            }
          }
        });
    grmode.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              gridMode.edit().putString("gride", "true").apply();
            } else {
              gridMode.edit().remove("gride").apply();
            }
          }
        });

    vibreh.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            /// لرزش
            if (_isChecked) {
              getvb.edit().putString("HsiGamer", "true").apply();
            } else {
              getvb.edit().remove("HsiGamer").apply();
            }
          }
        });

    arrow02.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            if (!mbool04) {
              mbool04 = true;
              arrow02.animate().rotation((float) 0).setDuration((int) 300);
            } else {
              mbool04 = false;
              arrow02.animate().rotation((float) -180).setDuration((int) 300);
            }
            ViewUtils.installLazy(size);
          }
        });

    sw.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              tmp.edit().putString("settmp", "true").apply();
            } else {
              tmp.edit().remove("settmp").apply();
            }
          }
        });

    molaq.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              moalaqfragment.edit().putString("mpost", "true").apply();
            } else {
              moalaqfragment.edit().remove("mpost").apply();
            }
          }
        });

    switchobtical.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              thememanagersoft.edit().putString("effect", "true").apply();
            } else {
              thememanagersoft.edit().remove("effect").apply();
            }
          }
        });

    arrow01.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            if (!boolea) {
              boolea = true;
              arrow01.animate().rotation((float) 0).setDuration((int) 300);
            } else {
              boolea = false;
              arrow01.animate().rotation((float) -180).setDuration((int) 300);
            }
            ViewUtils.installLazy(rose);
            ViewUtils.installLazy(recyclerview2);
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
          }
        });

    linear83.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            _blursize();
          }
        });

    getThemeUtils.setOnClickListener(
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
                                    .concat(edit.getText().toString().trim().concat(" اعمال شد")),
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

    atctm.setOnClickListener(
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

    linear92.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            _blursize();
          }
        });

    autotextComple.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              auto.edit().putString("mauto", "true").commit();
            } else {
              auto.edit().remove("mauto").commit();
            }
          }
        });

    tab.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              backtab.setBackground(
                  new GradientDrawable() {
                    public GradientDrawable getIns(int a, int b) {
                      this.setCornerRadius(a);
                      this.setColor(b);
                      return this;
                    }
                  }.getIns((int) 100, 0xFFFFDCBD));
              tabimageview.edit().putString("mtab", "true").commit();
            } else {
              tabimageview.edit().remove("mtab").commit();
              backtab.setBackground(
                  new GradientDrawable() {
                    public GradientDrawable getIns(int a, int b, int c, int d) {
                      this.setCornerRadius(a);
                      this.setStroke(b, c);
                      this.setColor(d);
                      return this;
                    }
                  }.getIns((int) 100, (int) 2, 0xFFFFDCBD, 0xFF201B16));
            }
          }
        });

    lineeditor.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              re.edit().putString("f380", "true").commit();
            } else {
              re.edit().remove("f380").commit();
            }
          }
        });

    themesabet.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              ru.edit().putString("rup", "true").commit();
            } else {
              ru.edit().remove("rup").commit();
            }
          }
        });

    msaveandexit.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              sve.edit().putString("getAutoSave", "true").commit();
            } else {
              sve.edit().remove("getAutoSave").commit();
            }
          }
        });

    dirfilesswitch.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              getinitdir.edit().putString("mdir", "true").commit();
            } else {
              getinitdir.edit().remove("mdir").commit();
            }
          }
        });

    themeinstall.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              mthemepost.edit().putString("mytheme", "true").commit();
            } else {
              mthemepost.edit().remove("mytheme").commit();
            }
          }
        });

    switchac.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              setac.edit().putString("ac", "true").commit();
            } else {
              setac.edit().remove("ac").commit();
            }
          }
        });

    switchmaterialYou.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {
              materialYou.edit().putString("materialYou", "true").apply();
              themeEngine.setDynamicTheme(true);

            } else {
              materialYou.edit().remove("materialYou").apply();
              themeEngine.setDynamicTheme(false);
            }
          }
        });

    checkbox9.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
            final boolean _isChecked = _param2;
            if (_isChecked) {

              kos.edit().putString("vop", "true").commit();
            } else {
              kos.edit().putString("vop", "false").commit();
            }
          }
        });
  }

  private void StartLuncherApp() {
    _seechackswich();
    string.add("4");
    string.add("6");
    string.add("8");
    string.add("16");
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
    setFitWindows(linear1);

    ViewUtils.collapse(datapost);
    ViewUtils.collapse(keyboard);
    ViewUtils.collapse(size);
    ViewUtils.collapse(rose);
    ViewUtils.collapse(themes);
    ViewUtils.collapse(recyclerview2);
    ColorList(getApplicationContext(), getWindow().getDecorView());

    _toolbar.setBackgroundColor(Color.TRANSPARENT);
    ColorAndroid12.setTextColor(textview37);
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
    ColorAndroid12.setTextColor(customTheme);
    if (getvb.contains("wall")) {
      terminalColors.setChecked(true);
    }
    if (word.getString("getword", "").equals("true")) {
      checkbox1.setChecked(true);
    } else {
      checkbox1.setChecked(false);
    }
    if (kos.getString("vop", "").equals("true")) {
      checkbox9.setChecked(true);
    } else {
      checkbox9.setChecked(false);
    }
    if (tmp.contains("settmp")) {
      sw.setChecked(true);
    } else {
      sw.setChecked(false);
    }
    if (line.contains("getline")) {
      addsabet.setChecked(true);
    } else {
      addsabet.setChecked(false);
    }
    if (getvb.contains("HsiGamer")) {
      vibreh.setChecked(true);
      treecolors.setChecked(true);
    } else {
      vibreh.setChecked(false);
      treecolors.setChecked(false);
    }
    if (moalaqfragment.contains("mpost")) {
      molaq.setChecked(true);
    }
    if (auto.contains("mauto")) {
      autotextComple.setChecked(true);
    } else {
      autotextComple.setChecked(false);
    }
    if (tabimageview.contains("mtab")) {
      tab.setChecked(true);
    }
    if (re.contains("f380")) {
      lineeditor.setChecked(true);
    }
    if (ru.contains("rup")) {
      themesabet.setChecked(true);
    }
    if (sve.contains("getAutoSave")) {
      msaveandexit.setChecked(true);
    }
    if (getinitdir.contains("mdir")) {
      dirfilesswitch.setChecked(true);
    }
    if (mthemepost.contains("mytheme")) {
      themeinstall.setChecked(true);
    }
    ColorAndroid12.setToolbarinit(_toolbar);
    if (setac.contains("ac")) {
      switchac.setChecked(true);
    }
    if (materialYou.contains("materialYou")) {
      switchmaterialYou.setChecked(true);
    } else switchmaterialYou.setChecked(false);

    if (thememanagersoft.contains("effect")) {
      switchobtical.setChecked(true);
    }
    if (thememanagersoft.getString("thememanagersoft", "").equals("ok")) {
      wallmodes.setChecked(true);
    } else {
      wallmodes.setChecked(false);
    }

    List<String> fb = new ArrayList<>();
    fb.add("");
    fb.add("");
    fb.add("");
    fb.add("");
    fb.add("");
    grmode.setChecked(gridMode.contains("gride"));
    recyclerview2.setAdapter(new Recyclerview2Adapter(fb));
    recyclerview2.setLayoutManager(new LinearLayoutManager(this));
  }

  public void _editortabsize(final String _post) {
    if (_post.equals("4")) {
      tab100.edit().putString("mpcnullgogo", "4").commit();
    } else {
      if (_post.equals("6")) {
        tab100.edit().putString("mpcnullgogo", "6").commit();
      } else {
        if (_post.equals("8")) {
          tab100.edit().putString("mpcnullgogo", "8").commit();
        } else {
          if (_post.equals("16")) {
            tab100.edit().putString("mpcnullgogo", "16").commit();
          }
        }
      }
    }
  }

  public void _animdown(final ImageView _mimg) {
    mdownObjectAnimator.setTarget(_mimg);
    mdownObjectAnimator.setPropertyName("rotation");
    mdownObjectAnimator.setFloatValues((float) (0));
    mdownObjectAnimator.setFloatValues((float) (0), (float) (180));
    mdownObjectAnimator.setRepeatMode(ValueAnimator.RESTART);
    mdownObjectAnimator.start();
  }

  public void _animup(final View _mimg) {
    mdownObjectAnimator.setTarget(_mimg);
    mdownObjectAnimator.setPropertyName("rotation");
    mdownObjectAnimator.setFloatValues((float) (180));
    mdownObjectAnimator.setFloatValues((float) (180), (float) (0));
    mdownObjectAnimator.setRepeatMode(ValueAnimator.RESTART);
    mdownObjectAnimator.start();
  }

  public void _startAnim(final Switch _v) {
    ObjectAnimator scaleX = new ObjectAnimator();
    scaleX.setTarget(_v);
    scaleX.setPropertyName("scaleX");
    scaleX.setFloatValues((float) 1);
    scaleX.setDuration((int) 5);
    scaleX.start();
    ObjectAnimator scaleY = new ObjectAnimator();
    scaleY.setTarget(_v);
    scaleY.setPropertyName("scaleY");
    scaleY.setFloatValues((float) 1);
    scaleY.setDuration((int) 5);
    scaleY.start();
  }

  public void _endAnim(final Switch _v) {
    ObjectAnimator scaleX = new ObjectAnimator();
    scaleX.setTarget(_v);
    scaleX.setPropertyName("scaleX");
    scaleX.setFloatValues(0.7f);
    scaleX.setDuration((int) 5);
    scaleX.start();

    ObjectAnimator scaleY = new ObjectAnimator();
    scaleY.setTarget(_v);
    scaleY.setPropertyName("scaleY");
    scaleY.setFloatValues(0.7f);
    scaleY.setDuration((int) 5);
    scaleY.start();
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
    for (int c = 0; c < (int) (8); c++) {
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
            .setTitle("Custom Python script")
            .setMessage("Select Python script")
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
}
