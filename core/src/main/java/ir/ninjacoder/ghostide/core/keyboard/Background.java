package ir.ninjacoder.ghostide.core.keyboard;

import android.animation.ObjectAnimator;
import android.app.WallpaperManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.activities.BaseCompat;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class Background extends BaseCompat {

  public int Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9, Value10;
  public Drawable drawable, bitmapDrawable, as;
  public String Background, Model, HalatMovazi, HalatDavaran, Tedad;
  protected RadioButton asli,
      waliper,
      gallary,
      rang,
      takrang,
      davaranrang,
      movazirang,
      ofogh,
      dar45,
      amod,
      pain,
      center,
      ups;
  protected Button entekhab,
      color1,
      color2,
      color3,
      color4,
      color5,
      color6,
      color7,
      color8,
      color9,
      color10;
  protected ImageView view, g1;
  protected LinearLayout gall,
      lay_color,
      liner,
      linerm,
      liner1,
      liner2,
      liner3,
      liner4,
      liner5,
      liner6,
      liner7,
      liner8,
      liner9,
      liner10;
  protected TextView txtcolor,
      ent,
      tvcolor1,
      ttxxtt,
      tvcolor2,
      txtmehvar,
      tvcolor3,
      tvcolor4,
      tvcolor5,
      tvcolor6,
      tvcolor7,
      tvcolor8,
      tvcolor9,
      tvcolor10,
      path;
  protected CardView card;
  protected CheckBox rang3, rang4, rang5, rang6, rang7, rang8, rang9, rang10;
  GradientDrawable.Orientation orientation;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.background);

    drawable = WallpaperManager.getInstance(this).getDrawable();
    bitmapDrawable =
        new BitmapDrawable(
            PreferenceManager.getDefaultSharedPreferences(this).getString("background", "0"));

    txtcolor = (TextView) findViewById(R.id.backgroundkeyTextView);
    ent = (TextView) findViewById(R.id.texentekhab);
    tvcolor1 = (TextView) findViewById(R.id.tv_color1);
    ttxxtt = (TextView) findViewById(R.id.ttxxtt);
    tvcolor2 = (TextView) findViewById(R.id.tv_color2);
    txtmehvar = (TextView) findViewById(R.id.txtmehvar);
    tvcolor3 = (TextView) findViewById(R.id.tv_color3);
    tvcolor4 = (TextView) findViewById(R.id.tv_color4);
    tvcolor5 = (TextView) findViewById(R.id.tv_color5);
    tvcolor6 = (TextView) findViewById(R.id.tv_color6);
    tvcolor7 = (TextView) findViewById(R.id.tv_color7);
    tvcolor8 = (TextView) findViewById(R.id.tv_color8);
    tvcolor9 = (TextView) findViewById(R.id.tv_color9);
    tvcolor10 = (TextView) findViewById(R.id.tv_color10);
    path = (TextView) findViewById(R.id.pathtext);
    path.setText("عکسی انتخاب نشده");

    gall = (LinearLayout) findViewById(R.id.lay_gallery);
    lay_color = (LinearLayout) findViewById(R.id.lay_color);
    liner = (LinearLayout) findViewById(R.id.lay_set_liner);
    linerm = (LinearLayout) findViewById(R.id.lay_set_circle);
    liner3 = (LinearLayout) findViewById(R.id.color_3);
    liner4 = (LinearLayout) findViewById(R.id.color_4);
    liner5 = (LinearLayout) findViewById(R.id.color_5);
    liner6 = (LinearLayout) findViewById(R.id.color_6);
    liner7 = (LinearLayout) findViewById(R.id.color_7);
    liner8 = (LinearLayout) findViewById(R.id.color_8);
    liner9 = (LinearLayout) findViewById(R.id.color_9);
    liner10 = (LinearLayout) findViewById(R.id.color_10);
    liner1 = (LinearLayout) findViewById(R.id.color_1);
    liner2 = (LinearLayout) findViewById(R.id.color_2);

    view = (ImageView) findViewById(R.id.dw_viewer);
    g1 = (ImageView) findViewById(R.id.dw_gal);

    entekhab = (Button) findViewById(R.id.btgallery);
    color1 = (Button) findViewById(R.id.cp_color1);
    color2 = (Button) findViewById(R.id.cp_color2);
    color3 = (Button) findViewById(R.id.cp_color3);
    color4 = (Button) findViewById(R.id.cp_color4);
    color5 = (Button) findViewById(R.id.cp_color5);
    color6 = (Button) findViewById(R.id.cp_color6);
    color7 = (Button) findViewById(R.id.cp_color7);
    color8 = (Button) findViewById(R.id.cp_color8);
    color9 = (Button) findViewById(R.id.cp_color9);
    color10 = (Button) findViewById(R.id.cp_color10);

    asli = (RadioButton) findViewById(R.id.asli);
    waliper = (RadioButton) findViewById(R.id.waliper);
    gallary = (RadioButton) findViewById(R.id.gallary);
    rang = (RadioButton) findViewById(R.id.rang);
    takrang = (RadioButton) findViewById(R.id.takrang);
    movazirang = (RadioButton) findViewById(R.id.movazirang);
    davaranrang = (RadioButton) findViewById(R.id.davaranrang);
    ofogh = (RadioButton) findViewById(R.id.ofogh);
    dar45 = (RadioButton) findViewById(R.id.dar45);
    amod = (RadioButton) findViewById(R.id.amod);
    pain = (RadioButton) findViewById(R.id.pain);
    center = (RadioButton) findViewById(R.id.center);
    ups = (RadioButton) findViewById(R.id.ups);

    rang3 = (CheckBox) findViewById(R.id.rang3);
    rang4 = (CheckBox) findViewById(R.id.rang4);
    rang5 = (CheckBox) findViewById(R.id.rang5);
    rang6 = (CheckBox) findViewById(R.id.rang6);
    rang7 = (CheckBox) findViewById(R.id.rang7);
    rang8 = (CheckBox) findViewById(R.id.rang8);
    rang9 = (CheckBox) findViewById(R.id.rang9);
    rang10 = (CheckBox) findViewById(R.id.rang10);
    card = (CardView) findViewById(R.id.card);
    // card.setCardBackground(ColorStateList.valueOf(Color.TRANSPARENT));
    card.setCardBackgroundColor(Color.TRANSPARENT);
    card.setRadius((float) 30);
    card.setElevation((float) 0);
    rang3
        .getButtonDrawable()
        .setColorFilter(
            MaterialColors.getColor(rang3, ObjectUtils.TvColor), PorterDuff.Mode.SRC_IN);
    rang4
        .getButtonDrawable()
        .setColorFilter(
            MaterialColors.getColor(rang4, ObjectUtils.TvColor), PorterDuff.Mode.SRC_IN);
    rang5
        .getButtonDrawable()
        .setColorFilter(
            MaterialColors.getColor(rang5, ObjectUtils.TvColor), PorterDuff.Mode.SRC_IN);
    rang6
        .getButtonDrawable()
        .setColorFilter(
            MaterialColors.getColor(rang6, ObjectUtils.TvColor), PorterDuff.Mode.SRC_IN);
    rang7
        .getButtonDrawable()
        .setColorFilter(
            MaterialColors.getColor(rang7, ObjectUtils.TvColor), PorterDuff.Mode.SRC_IN);
    rang8
        .getButtonDrawable()
        .setColorFilter(
            MaterialColors.getColor(rang8, ObjectUtils.TvColor), PorterDuff.Mode.SRC_IN);
    rang9
        .getButtonDrawable()
        .setColorFilter(
            MaterialColors.getColor(rang9, ObjectUtils.TvColor), PorterDuff.Mode.SRC_IN);
    rang10
        .getButtonDrawable()
        .setColorFilter(
            MaterialColors.getColor(rang10, ObjectUtils.TvColor), PorterDuff.Mode.SRC_IN);

    Background =
        PreferenceManager.getDefaultSharedPreferences(this).getString("Background", "asli");
    Model = PreferenceManager.getDefaultSharedPreferences(this).getString("Model", "takrang");
    HalatMovazi =
        PreferenceManager.getDefaultSharedPreferences(this).getString("HalatMovazi", "amod");
    HalatDavaran =
        PreferenceManager.getDefaultSharedPreferences(this).getString("HalatDavaran", "ups");
    Tedad = PreferenceManager.getDefaultSharedPreferences(this).getString("Tedad", "rang2");
    ButtonBackGround(color1);
    ButtonBackGround(color2);
    ButtonBackGround(color3);
    ButtonBackGround(color4);
    ButtonBackGround(color5);
    ButtonBackGround(color6);
    ButtonBackGround(color7);
    ButtonBackGround(color8);
    ButtonBackGround(color9);
    ButtonBackGround(color10);
    ButtonBackGround(entekhab);

    if (Background.equals("asli")) {
      asli.setChecked(true);
      Background_asli();
    } else if (Background.equals("waliper")) {
      waliper.setChecked(true);
      Background_waliper();
    } else if (Background.equals("gallary")) {
      gallary.setChecked(true);
      Background_gallary();
    } else if (Background.equals("rang")) {
      rang.setChecked(true);
      Background_rang();
    }
    if (Model.equals("takrang")) {
      takrang.setChecked(true);
      Model_takrang();
    } else if (Model.equals("movazirang")) {
      movazirang.setChecked(true);
      Model_movazirang();
    } else if (Model.equals("davaranrang")) {
      davaranrang.setChecked(true);
      Model_davaranrang();
    }
    if (HalatMovazi.equals("amod")) {
      amod.setChecked(true);
    } else if (HalatMovazi.equals("dar45")) {
      dar45.setChecked(true);
    } else if (HalatMovazi.equals("ofogh")) {
      ofogh.setChecked(true);
    }

    if (HalatDavaran.equals("pain")) {
      pain.setChecked(true);
    } else if (HalatDavaran.equals("center")) {
      center.setChecked(true);
    } else if (HalatDavaran.equals("ups")) {
      ups.setChecked(true);
    }

    if (Tedad.equals("rang3")) {
      rang3.setChecked(true);
      Tedad_3();
    } else if (Tedad.equals("rang4")) {
      rang4.setChecked(true);
      Tedad_4();
    } else if (Tedad.equals("rang5")) {
      rang5.setChecked(true);
      Tedad_5();
    } else if (Tedad.equals("rang6")) {
      rang6.setChecked(true);
      Tedad_6();
    } else if (Tedad.equals("rang7")) {
      rang7.setChecked(true);
      Tedad_7();
    } else if (Tedad.equals("rang8")) {
      rang8.setChecked(true);
      Tedad_8();
    } else if (Tedad.equals("rang9")) {
      rang9.setChecked(true);
      Tedad_9();
    } else if (Tedad.equals("rang10")) {
      rang10.setChecked(true);
      Tedad_10();
    }

    Back_Tedad();

    asli.setOnClickListener(
        (p1) -> {
          if (asli.isChecked()) {
            Save("Background", "asli");
          }
          Background_asli();
          Back_Tedad();
        });

    waliper.setOnClickListener(
        (p1) -> {
          if (waliper.isChecked()) {
            Save("Background", "waliper");
          }
          Background_waliper();
          Back_Tedad();
        });

    gallary.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (gallary.isChecked()) {
              Save("Background", "gallary");
            }
            Background_gallary();
            Back_Tedad();
          }
        });

    rang.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (rang.isChecked()) {
              Save("Background", "rang");
            }
            Background_rang();
            Back_Tedad();
          }
        });

    takrang.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (takrang.isChecked()) {
              Save("Model", "takrang");
            }
            Model_takrang();
            Back_Tedad();
          }
        });

    movazirang.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (movazirang.isChecked()) {
              Save("Model", "movazirang");
              Model_movazirang();
            }
            Back_Tedad();
          }
        });

    davaranrang.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (davaranrang.isChecked()) {
              Save("Model", "davaranrang");
              Model_davaranrang();
            }
            Back_Tedad();
          }
        });

    ofogh.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (ofogh.isChecked()) {
              Save("HalatMovazi", "ofogh");
            }
            Back_Tedad();
          }
        });

    dar45.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (dar45.isChecked()) {
              Save("HalatMovazi", "dar45");
            }
            Back_Tedad();
          }
        });

    amod.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (amod.isChecked()) {
              Save("HalatMovazi", "amod");
            }
            Back_Tedad();
          }
        });

    pain.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (pain.isChecked()) {
              Save("HalatDavaran", "pain");
            }
            Back_Tedad();
          }
        });

    center.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (center.isChecked()) {
              Save("HalatDavaran", "center");
            }
            Back_Tedad();
          }
        });

    ups.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (ups.isChecked()) {
              Save("HalatDavaran", "ups");
            }
            Back_Tedad();
          }
        });

    rang3.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (rang3.isChecked()) {
              Save("Tedad", "rang3");
            } else {
              Save("Tedad", "rang2");
            }
            Tedad_3();
            Back_Tedad();
          }
        });

    rang4.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (rang4.isChecked()) {
              Save("Tedad", "rang4");
            } else {
              Save("Tedad", "rang3");
            }
            Tedad_4();
            Back_Tedad();
          }
        });

    rang5.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (rang5.isChecked()) {
              Save("Tedad", "rang5");
            } else {
              Save("Tedad", "rang4");
            }
            Tedad_5();
            Back_Tedad();
          }
        });

    rang6.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (rang6.isChecked()) {
              Save("Tedad", "rang6");
            } else {
              Save("Tedad", "rang5");
            }
            Tedad_6();
            Back_Tedad();
          }
        });

    rang7.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (rang7.isChecked()) {
              Save("Tedad", "rang7");
            } else {
              Save("Tedad", "rang6");
            }
            Tedad_7();
            Back_Tedad();
          }
        });

    rang8.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (rang8.isChecked()) {
              Save("Tedad", "rang8");
            } else {
              Save("Tedad", "rang7");
            }
            Tedad_8();
            Back_Tedad();
          }
        });

    rang9.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (rang9.isChecked()) {
              Save("Tedad", "rang9");
            } else {
              Save("Tedad", "rang8");
            }
            Tedad_9();
            Back_Tedad();
          }
        });

    rang10.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View p1) {
            if (rang10.isChecked()) {
              Save("Tedad", "rang10");
            } else {
              Save("Tedad", "rang9");
            }
            Tedad_10();
            Back_Tedad();
          }
        });

    entekhab.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            startActivityForResult(
                new Intent(
                    "android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI),
                1);
          }
        });

    color1.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            ColorPicker1();
          }
        });

    color2.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            ColorPicker2();
            Back_Tedad();
          }
        });

    color3.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            ColorPicker3();
          }
        });

    color4.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            ColorPicker4();
          }
        });

    color5.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            ColorPicker5();
          }
        });

    color6.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            ColorPicker6();
          }
        });

    color7.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            ColorPicker7();
          }
        });

    color8.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            ColorPicker8();
          }
        });

    color9.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            ColorPicker9();
          }
        });

    color10.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            ColorPicker10();
          }
        });
  }

  private void Background_asli() {
    view.setVisibility(View.VISIBLE);
    gall.setVisibility(View.GONE);
    lay_color.setVisibility(View.GONE);
    txtcolor.setVisibility(View.GONE);
    takrang.setVisibility(View.GONE);
    movazirang.setVisibility(View.GONE);
    davaranrang.setVisibility(View.GONE);
    ent.setVisibility(View.GONE);
    color1.setVisibility(View.GONE);
    tvcolor1.setVisibility(View.GONE);
    liner.setVisibility(View.GONE);
    ttxxtt.setVisibility(View.GONE);
    ofogh.setVisibility(View.GONE);
    dar45.setVisibility(View.GONE);
    amod.setVisibility(View.GONE);
    color2.setVisibility(View.GONE);
    tvcolor2.setVisibility(View.GONE);
    linerm.setVisibility(View.GONE);
    txtmehvar.setVisibility(View.GONE);
    pain.setVisibility(View.GONE);
    center.setVisibility(View.GONE);
    ups.setVisibility(View.GONE);
    liner3.setVisibility(View.GONE);
    color3.setVisibility(View.GONE);
    tvcolor3.setVisibility(View.GONE);
    rang3.setVisibility(View.GONE);
    liner4.setVisibility(View.GONE);
    color4.setVisibility(View.GONE);
    tvcolor4.setVisibility(View.GONE);
    rang4.setVisibility(View.GONE);
    liner5.setVisibility(View.GONE);
    color5.setVisibility(View.GONE);
    tvcolor5.setVisibility(View.GONE);
    rang5.setVisibility(View.GONE);
    liner6.setVisibility(View.GONE);
    color6.setVisibility(View.GONE);
    tvcolor6.setVisibility(View.GONE);
    rang6.setVisibility(View.GONE);
    liner7.setVisibility(View.GONE);
    color7.setVisibility(View.GONE);
    tvcolor7.setVisibility(View.GONE);
    rang7.setVisibility(View.GONE);
    liner8.setVisibility(View.GONE);
    color8.setVisibility(View.GONE);
    tvcolor8.setVisibility(View.GONE);
    rang8.setVisibility(View.GONE);
    liner9.setVisibility(View.GONE);
    color9.setVisibility(View.GONE);
    tvcolor9.setVisibility(View.GONE);
    rang9.setVisibility(View.GONE);
    liner10.setVisibility(View.GONE);
    color10.setVisibility(View.GONE);
    tvcolor10.setVisibility(View.GONE);
    rang10.setVisibility(View.GONE);
    liner1.setVisibility(View.GONE);
    liner2.setVisibility(View.GONE);
    g1.setVisibility(View.GONE);
    path.setVisibility(View.GONE);
  }

  private void Background_waliper() {
    view.setVisibility(View.VISIBLE);
    gall.setVisibility(View.GONE);
    lay_color.setVisibility(View.GONE);
    txtcolor.setVisibility(View.GONE);
    takrang.setVisibility(View.GONE);
    movazirang.setVisibility(View.GONE);
    davaranrang.setVisibility(View.GONE);
    ent.setVisibility(View.GONE);
    color1.setVisibility(View.GONE);
    tvcolor1.setVisibility(View.GONE);
    liner.setVisibility(View.GONE);
    ttxxtt.setVisibility(View.GONE);
    ofogh.setVisibility(View.GONE);
    dar45.setVisibility(View.GONE);
    amod.setVisibility(View.GONE);
    color2.setVisibility(View.GONE);
    tvcolor2.setVisibility(View.GONE);
    linerm.setVisibility(View.GONE);
    txtmehvar.setVisibility(View.GONE);
    pain.setVisibility(View.GONE);
    center.setVisibility(View.GONE);
    ups.setVisibility(View.GONE);
    liner3.setVisibility(View.GONE);
    color3.setVisibility(View.GONE);
    tvcolor3.setVisibility(View.GONE);
    rang3.setVisibility(View.GONE);
    liner4.setVisibility(View.GONE);
    color4.setVisibility(View.GONE);
    tvcolor4.setVisibility(View.GONE);
    rang4.setVisibility(View.GONE);
    liner5.setVisibility(View.GONE);
    color5.setVisibility(View.GONE);
    tvcolor5.setVisibility(View.GONE);
    rang5.setVisibility(View.GONE);
    liner6.setVisibility(View.GONE);
    color6.setVisibility(View.GONE);
    tvcolor6.setVisibility(View.GONE);
    rang6.setVisibility(View.GONE);
    liner7.setVisibility(View.GONE);
    color7.setVisibility(View.GONE);
    tvcolor7.setVisibility(View.GONE);
    rang7.setVisibility(View.GONE);
    liner8.setVisibility(View.GONE);
    color8.setVisibility(View.GONE);
    tvcolor8.setVisibility(View.GONE);
    rang8.setVisibility(View.GONE);
    liner9.setVisibility(View.GONE);
    color9.setVisibility(View.GONE);
    tvcolor9.setVisibility(View.GONE);
    rang9.setVisibility(View.GONE);
    liner10.setVisibility(View.GONE);
    color10.setVisibility(View.GONE);
    tvcolor10.setVisibility(View.GONE);
    rang10.setVisibility(View.GONE);
    liner1.setVisibility(View.GONE);
    liner2.setVisibility(View.GONE);
    g1.setVisibility(View.GONE);
    path.setVisibility(View.GONE);
  }

  public void Background_gallary() {
    gall.setVisibility(View.VISIBLE);
    entekhab.setVisibility(View.VISIBLE);
    view.setVisibility(View.GONE);
    g1.setVisibility(View.VISIBLE);
    path.setVisibility(View.VISIBLE);
    lay_color.setVisibility(View.GONE);
    txtcolor.setVisibility(View.GONE);
    takrang.setVisibility(View.GONE);
    movazirang.setVisibility(View.GONE);
    davaranrang.setVisibility(View.GONE);
    ent.setVisibility(View.GONE);
    liner1.setVisibility(View.GONE);
    color1.setVisibility(View.GONE);
    tvcolor1.setVisibility(View.GONE);

    ttxxtt.setVisibility(View.GONE);
    liner.setVisibility(View.GONE);
    ofogh.setVisibility(View.GONE);
    dar45.setVisibility(View.GONE);
    amod.setVisibility(View.GONE);

    txtmehvar.setVisibility(View.GONE);
    linerm.setVisibility(View.GONE);
    pain.setVisibility(View.GONE);
    center.setVisibility(View.GONE);
    ups.setVisibility(View.GONE);

    liner2.setVisibility(View.GONE);
    color2.setVisibility(View.GONE);
    tvcolor2.setVisibility(View.GONE);

    liner3.setVisibility(View.GONE);
    color3.setVisibility(View.GONE);
    tvcolor3.setVisibility(View.GONE);
    rang3.setVisibility(View.GONE);
    liner4.setVisibility(View.GONE);
    color4.setVisibility(View.GONE);
    tvcolor4.setVisibility(View.GONE);
    rang4.setVisibility(View.GONE);
    liner5.setVisibility(View.GONE);
    color5.setVisibility(View.GONE);
    tvcolor5.setVisibility(View.GONE);
    rang5.setVisibility(View.GONE);
    liner6.setVisibility(View.GONE);
    color6.setVisibility(View.GONE);
    tvcolor6.setVisibility(View.GONE);
    rang6.setVisibility(View.GONE);
    liner7.setVisibility(View.GONE);
    color7.setVisibility(View.GONE);
    tvcolor7.setVisibility(View.GONE);
    rang7.setVisibility(View.GONE);
    liner8.setVisibility(View.GONE);
    color8.setVisibility(View.GONE);
    tvcolor8.setVisibility(View.GONE);
    rang8.setVisibility(View.GONE);
    liner9.setVisibility(View.GONE);
    color9.setVisibility(View.GONE);
    tvcolor9.setVisibility(View.GONE);
    rang9.setVisibility(View.GONE);
    liner10.setVisibility(View.GONE);
    color10.setVisibility(View.GONE);
    tvcolor10.setVisibility(View.GONE);
    rang10.setVisibility(View.GONE);
  }

  public void Background_rang() {
    entekhab.setVisibility(View.GONE);
    gall.setVisibility(View.GONE);
    g1.setVisibility(View.GONE);
    path.setVisibility(View.GONE);
    view.setVisibility(View.VISIBLE);
    lay_color.setVisibility(View.VISIBLE);
    txtcolor.setVisibility(View.VISIBLE);
    takrang.setVisibility(View.VISIBLE);
    movazirang.setVisibility(View.VISIBLE);
    davaranrang.setVisibility(View.VISIBLE);
    ent.setVisibility(View.VISIBLE);
    liner1.setVisibility(View.VISIBLE);
    color1.setVisibility(View.VISIBLE);
    tvcolor1.setVisibility(View.VISIBLE);

    if (takrang.isChecked()) {
      Model_takrang();
    }
    if (movazirang.isChecked()) {
      Model_movazirang();
    }
    if (davaranrang.isChecked()) {
      Model_davaranrang();
    }
  }

  public void Model_takrang() {

    ttxxtt.setVisibility(View.GONE);
    liner.setVisibility(View.GONE);
    ofogh.setVisibility(View.GONE);
    dar45.setVisibility(View.GONE);
    amod.setVisibility(View.GONE);

    txtmehvar.setVisibility(View.GONE);
    linerm.setVisibility(View.GONE);
    pain.setVisibility(View.GONE);
    center.setVisibility(View.GONE);
    ups.setVisibility(View.GONE);

    liner2.setVisibility(View.GONE);
    color2.setVisibility(View.GONE);
    tvcolor2.setVisibility(View.GONE);

    liner3.setVisibility(View.GONE);
    color3.setVisibility(View.GONE);
    tvcolor3.setVisibility(View.GONE);
    rang3.setVisibility(View.GONE);
    liner4.setVisibility(View.GONE);
    color4.setVisibility(View.GONE);
    tvcolor4.setVisibility(View.GONE);
    rang4.setVisibility(View.GONE);
    liner5.setVisibility(View.GONE);
    color5.setVisibility(View.GONE);
    tvcolor5.setVisibility(View.GONE);
    rang5.setVisibility(View.GONE);
    liner6.setVisibility(View.GONE);
    color6.setVisibility(View.GONE);
    tvcolor6.setVisibility(View.GONE);
    rang6.setVisibility(View.GONE);
    liner7.setVisibility(View.GONE);
    color7.setVisibility(View.GONE);
    tvcolor7.setVisibility(View.GONE);
    rang7.setVisibility(View.GONE);
    liner8.setVisibility(View.GONE);
    color8.setVisibility(View.GONE);
    tvcolor8.setVisibility(View.GONE);
    rang8.setVisibility(View.GONE);
    liner9.setVisibility(View.GONE);
    color9.setVisibility(View.GONE);
    tvcolor9.setVisibility(View.GONE);
    rang9.setVisibility(View.GONE);
    liner10.setVisibility(View.GONE);
    color10.setVisibility(View.GONE);
    tvcolor10.setVisibility(View.GONE);
    rang10.setVisibility(View.GONE);
  }

  public void Model_movazirang() {
    txtmehvar.setVisibility(View.GONE);
    linerm.setVisibility(View.GONE);
    pain.setVisibility(View.GONE);
    center.setVisibility(View.GONE);
    ups.setVisibility(View.GONE);

    ttxxtt.setVisibility(View.VISIBLE);
    liner.setVisibility(View.VISIBLE);
    ofogh.setVisibility(View.VISIBLE);
    dar45.setVisibility(View.VISIBLE);
    amod.setVisibility(View.VISIBLE);

    liner2.setVisibility(View.VISIBLE);
    color2.setVisibility(View.VISIBLE);
    tvcolor2.setVisibility(View.VISIBLE);

    liner3.setVisibility(View.VISIBLE);
    color3.setVisibility(View.VISIBLE);
    tvcolor3.setVisibility(View.VISIBLE);
    rang3.setVisibility(View.VISIBLE);
    liner4.setVisibility(View.VISIBLE);
    color4.setVisibility(View.VISIBLE);
    tvcolor4.setVisibility(View.VISIBLE);
    rang4.setVisibility(View.VISIBLE);
    liner5.setVisibility(View.VISIBLE);
    color5.setVisibility(View.VISIBLE);
    tvcolor5.setVisibility(View.VISIBLE);
    rang5.setVisibility(View.VISIBLE);
    liner6.setVisibility(View.VISIBLE);
    color6.setVisibility(View.VISIBLE);
    tvcolor6.setVisibility(View.VISIBLE);
    rang6.setVisibility(View.VISIBLE);
    liner7.setVisibility(View.VISIBLE);
    color7.setVisibility(View.VISIBLE);
    tvcolor7.setVisibility(View.VISIBLE);
    rang7.setVisibility(View.VISIBLE);
    liner8.setVisibility(View.VISIBLE);
    color8.setVisibility(View.VISIBLE);
    tvcolor8.setVisibility(View.VISIBLE);
    rang8.setVisibility(View.VISIBLE);
    liner9.setVisibility(View.VISIBLE);
    color9.setVisibility(View.VISIBLE);
    tvcolor9.setVisibility(View.VISIBLE);
    rang9.setVisibility(View.VISIBLE);
    liner10.setVisibility(View.VISIBLE);
    color10.setVisibility(View.VISIBLE);
    tvcolor10.setVisibility(View.VISIBLE);
    rang10.setVisibility(View.VISIBLE);
  }

  public void Model_davaranrang() {
    ttxxtt.setVisibility(View.GONE);
    liner.setVisibility(View.GONE);
    ofogh.setVisibility(View.GONE);
    dar45.setVisibility(View.GONE);
    amod.setVisibility(View.GONE);

    txtmehvar.setVisibility(View.VISIBLE);
    linerm.setVisibility(View.VISIBLE);
    pain.setVisibility(View.VISIBLE);
    center.setVisibility(View.VISIBLE);
    ups.setVisibility(View.VISIBLE);

    liner2.setVisibility(View.VISIBLE);
    color2.setVisibility(View.VISIBLE);
    tvcolor2.setVisibility(View.VISIBLE);

    liner3.setVisibility(View.VISIBLE);
    color3.setVisibility(View.VISIBLE);
    tvcolor3.setVisibility(View.VISIBLE);
    rang3.setVisibility(View.VISIBLE);
    liner4.setVisibility(View.VISIBLE);
    color4.setVisibility(View.VISIBLE);
    tvcolor4.setVisibility(View.VISIBLE);
    rang4.setVisibility(View.VISIBLE);
    liner5.setVisibility(View.VISIBLE);
    color5.setVisibility(View.VISIBLE);
    tvcolor5.setVisibility(View.VISIBLE);
    rang5.setVisibility(View.VISIBLE);
    liner6.setVisibility(View.VISIBLE);
    color6.setVisibility(View.VISIBLE);
    tvcolor6.setVisibility(View.VISIBLE);
    rang6.setVisibility(View.VISIBLE);
    liner7.setVisibility(View.VISIBLE);
    color7.setVisibility(View.VISIBLE);
    tvcolor7.setVisibility(View.VISIBLE);
    rang7.setVisibility(View.VISIBLE);
    liner8.setVisibility(View.VISIBLE);
    color8.setVisibility(View.VISIBLE);
    tvcolor8.setVisibility(View.VISIBLE);
    rang8.setVisibility(View.VISIBLE);
    liner9.setVisibility(View.VISIBLE);
    color9.setVisibility(View.VISIBLE);
    tvcolor9.setVisibility(View.VISIBLE);
    rang9.setVisibility(View.VISIBLE);
    liner10.setVisibility(View.VISIBLE);
    color10.setVisibility(View.VISIBLE);
    tvcolor10.setVisibility(View.VISIBLE);
    rang10.setVisibility(View.VISIBLE);
  }

  public void Tedad_3() {
    if (rang3.isChecked()) {
      color3.setEnabled(true);
      color4.setEnabled(false);
      color5.setEnabled(false);
      color6.setEnabled(false);
      color7.setEnabled(false);
      color8.setEnabled(false);
      color9.setEnabled(false);
      color10.setEnabled(false);
      liner4.setVisibility(View.VISIBLE);
      color4.setVisibility(View.VISIBLE);
      tvcolor4.setVisibility(View.VISIBLE);
      rang4.setVisibility(View.VISIBLE);
    } else {
      rang10.setChecked(false);
      rang9.setChecked(false);
      rang8.setChecked(false);
      rang7.setChecked(false);
      rang6.setChecked(false);
      rang5.setChecked(false);
      rang4.setChecked(false);

      color3.setEnabled(false);
      color4.setEnabled(false);
      color5.setEnabled(false);
      color6.setEnabled(false);
      color7.setEnabled(false);
      color8.setEnabled(false);
      color9.setEnabled(false);
      color10.setEnabled(false);
    }
  }

  public void Tedad_4() {
    if (rang4.isChecked()) {
      rang3.setChecked(true);

      color4.setEnabled(true);
      color3.setEnabled(true);
      color5.setEnabled(false);
      color6.setEnabled(false);
      color7.setEnabled(false);
      color8.setEnabled(false);
      color9.setEnabled(false);
      color10.setEnabled(false);
    } else {
      rang10.setChecked(false);
      rang9.setChecked(false);
      rang8.setChecked(false);
      rang7.setChecked(false);
      rang6.setChecked(false);
      rang5.setChecked(false);

      color3.setEnabled(true);
      color4.setEnabled(false);
      color5.setEnabled(false);
      color6.setEnabled(false);
      color7.setEnabled(false);
      color8.setEnabled(false);
      color9.setEnabled(false);
      color10.setEnabled(false);
      liner4.setVisibility(View.GONE);
      color4.setVisibility(View.GONE);
      tvcolor4.setVisibility(View.GONE);
      rang4.setVisibility(View.GONE);
    }
  }

  public void Tedad_5() {
    if (rang5.isChecked()) {
      rang4.setChecked(true);
      rang3.setChecked(true);

      color5.setEnabled(true);
      color4.setEnabled(true);
      color3.setEnabled(true);
      color6.setEnabled(false);
      color7.setEnabled(false);
      color8.setEnabled(false);
      color9.setEnabled(false);
      color10.setEnabled(false);
    } else {
      rang10.setChecked(false);
      rang9.setChecked(false);
      rang8.setChecked(false);
      rang7.setChecked(false);
      rang6.setChecked(false);

      color3.setEnabled(true);
      color4.setEnabled(true);
      color5.setEnabled(false);
      color6.setEnabled(false);
      color7.setEnabled(false);
      color8.setEnabled(false);
      color9.setEnabled(false);
      color10.setEnabled(false);
    }
  }

  public void Tedad_6() {
    if (rang6.isChecked()) {
      rang5.setChecked(true);
      rang4.setChecked(true);
      rang3.setChecked(true);

      color6.setEnabled(true);
      color5.setEnabled(true);
      color4.setEnabled(true);
      color3.setEnabled(true);
      color7.setEnabled(false);
      color8.setEnabled(false);
      color9.setEnabled(false);
      color10.setEnabled(false);
    } else {
      rang10.setChecked(false);
      rang9.setChecked(false);
      rang8.setChecked(false);
      rang7.setChecked(false);

      color3.setEnabled(true);
      color6.setEnabled(false);
      color7.setEnabled(false);
      color8.setEnabled(false);
      color9.setEnabled(false);
      color10.setEnabled(false);
    }
  }

  public void Tedad_7() {
    if (rang7.isChecked()) {
      rang6.setChecked(true);
      rang5.setChecked(true);
      rang4.setChecked(true);
      rang3.setChecked(true);

      color7.setEnabled(true);
      color6.setEnabled(true);
      color5.setEnabled(true);
      color4.setEnabled(true);
      color3.setEnabled(true);
      color8.setEnabled(false);
      color9.setEnabled(false);
      color10.setEnabled(false);
    } else {
      rang10.setChecked(false);
      rang9.setChecked(false);
      rang8.setChecked(false);

      color7.setEnabled(false);
      color8.setEnabled(false);
      color9.setEnabled(false);
      color10.setEnabled(false);
    }
  }

  public void Tedad_8() {
    if (rang8.isChecked()) {
      rang7.setChecked(true);
      rang6.setChecked(true);
      rang5.setChecked(true);
      rang4.setChecked(true);
      rang3.setChecked(true);

      color8.setEnabled(true);
      color7.setEnabled(true);
      color6.setEnabled(true);
      color5.setEnabled(true);
      color4.setEnabled(true);
      color3.setEnabled(true);
      color9.setEnabled(false);
      color10.setEnabled(false);
    } else {
      rang10.setChecked(false);
      rang9.setChecked(false);

      color8.setEnabled(false);
      color9.setEnabled(false);
      color10.setEnabled(false);
    }
  }

  public void Tedad_9() {
    if (rang9.isChecked()) {
      rang8.setChecked(true);
      rang7.setChecked(true);
      rang6.setChecked(true);
      rang5.setChecked(true);
      rang4.setChecked(true);
      rang3.setChecked(true);

      color9.setEnabled(true);
      color8.setEnabled(true);
      color7.setEnabled(true);
      color6.setEnabled(true);
      color5.setEnabled(true);
      color4.setEnabled(true);
      color3.setEnabled(true);
      color10.setEnabled(false);
    } else {
      rang10.setChecked(false);

      color9.setEnabled(false);
      color10.setEnabled(false);
    }
  }

  public void Tedad_10() {
    if (rang10.isChecked()) {
      rang9.setChecked(true);
      rang8.setChecked(true);
      rang7.setChecked(true);
      rang6.setChecked(true);
      rang5.setChecked(true);
      rang4.setChecked(true);
      rang3.setChecked(true);

      color10.setEnabled(true);
      color9.setEnabled(true);
      color8.setEnabled(true);
      color7.setEnabled(true);
      color6.setEnabled(true);
      color5.setEnabled(true);
      color4.setEnabled(true);
      color3.setEnabled(true);

    } else {
      color10.setEnabled(false);
    }
  }

  public void Back_Tedad() {

    Value1 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor1", "0"))
            .intValue();
    Value2 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor2", "0"))
            .intValue();
    Value3 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor3", "0"))
            .intValue();
    Value4 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor4", "0"))
            .intValue();
    Value5 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor5", "0"))
            .intValue();
    Value6 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor6", "0"))
            .intValue();
    Value7 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor7", "0"))
            .intValue();
    Value8 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor8", "0"))
            .intValue();
    Value9 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor9", "0"))
            .intValue();
    Value10 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor10", "0"))
            .intValue();

    if (asli.isChecked()) {
      view.setBackgroundResource(R.color.mahv);
    }
    if (waliper.isChecked()) {
      view.setBackgroundDrawable(drawable);
    }
    if (gallary.isChecked()) {
      g1.setBackgroundDrawable(bitmapDrawable);
    }
    if (rang.isChecked()) {

      if (takrang.isChecked()) {
        view.setBackgroundColor(Value1);
      }

      if (movazirang.isChecked()) {

        if (amod.isChecked()) {

          if (rang3.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, new int[] {Value1, Value2, Value3});
            view.setBackgroundDrawable(drawablecolor);
          } else {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, new int[] {Value1, Value2});
            view.setBackgroundDrawable(drawablecolor);
          }
          if (rang4.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {Value1, Value2, Value3, Value4});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang5.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {Value1, Value2, Value3, Value4, Value5});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang6.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang7.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang8.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang9.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {
                      Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9
                    });
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang10.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {
                      Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9,
                      Value10
                    });
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
        }
        if (dar45.isChecked()) {

          if (rang3.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR, new int[] {Value1, Value2, Value3});
            view.setBackgroundDrawable(drawablecolor);
          } else {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR, new int[] {Value1, Value2});
            view.setBackgroundDrawable(drawablecolor);
          }
          if (rang4.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR, new int[] {Value1, Value2, Value3, Value4});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang5.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[] {Value1, Value2, Value3, Value4, Value5});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang6.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang7.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang8.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang9.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[] {
                      Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9
                    });
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang10.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[] {
                      Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9,
                      Value10
                    });
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
        }
        if (ofogh.isChecked()) {

          if (rang3.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, new int[] {Value1, Value2, Value3});
            view.setBackgroundDrawable(drawablecolor);
          } else {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, new int[] {Value1, Value2});
            view.setBackgroundDrawable(drawablecolor);
          }
          if (rang4.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {Value1, Value2, Value3, Value4});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang5.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {Value1, Value2, Value3, Value4, Value5});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang6.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang7.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang8.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8});
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang9.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {
                      Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9
                    });
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
          if (rang10.isChecked()) {
            GradientDrawable drawablecolor =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {
                      Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9,
                      Value10
                    });
            view.setBackgroundDrawable(drawablecolor);
          } else {

          }
        }
      }
      if (davaranrang.isChecked()) {
        if (ups.isChecked()) {

          if (rang3.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, -0.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {
            int[] iArr = new int[] {Value1, Value2};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, -0.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          }
          if (rang4.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, -0.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang5.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, -0.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang6.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, -0.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang7.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, -0.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang8.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, -0.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang9.isChecked()) {
            int[] iArr =
                new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, -0.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang10.isChecked()) {
            int[] iArr =
                new int[] {
                  Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9, Value10
                };
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, -0.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
        }
        if (center.isChecked()) {

          if (rang3.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 0.5f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {
            int[] iArr = new int[] {Value1, Value2};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 0.5f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          }
          if (rang4.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 0.5f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang5.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 0.5f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang6.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 0.5f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang7.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 0.5f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang8.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 0.5f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang9.isChecked()) {
            int[] iArr =
                new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 0.5f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang10.isChecked()) {
            int[] iArr =
                new int[] {
                  Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9, Value10
                };
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 0.5f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
        }
        if (pain.isChecked()) {

          if (rang3.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 1.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {
            int[] iArr = new int[] {Value1, Value2};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 1.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          }
          if (rang4.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 1.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang5.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 1.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang6.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 1.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang7.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 1.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang8.isChecked()) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 1.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang9.isChecked()) {
            int[] iArr =
                new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9};
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 1.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
          if (rang10.isChecked()) {
            int[] iArr =
                new int[] {
                  Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9, Value10
                };
            GradientDrawable drawablecolor = new GradientDrawable(orientation, iArr);
            drawablecolor.setGradientCenter(0.5f, 1.1f);
            view.setBackgroundDrawable(drawablecolor);
            drawablecolor.setGradientType(2);
          } else {

          }
        }
      }
    }
  }

  public void Back_ColorPicker() {
    Back_Tedad();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    try {
      if (requestCode == 1 && resultCode == -1 && data != null) {
        String[] filePathColumn = new String[] {"_data"};
        Cursor cursor =
            getContentResolver().query(data.getData(), filePathColumn, null, null, null);
        cursor.moveToFirst();
        String imgDecodableString = cursor.getString(cursor.getColumnIndex(filePathColumn[0]));
        Save("background", imgDecodableString);
        path.setText("عکس انتخاب شده");
        g1.setImageURI(data.getData());
        cursor.close();
        return;
      }
      Toast.makeText(this, "شما تصویری انتخاب نکردید.", 1).show();
    } catch (Exception e) {
      Toast.makeText(this, "مجددا سعی نمایید.", 1).show();
    }
  }

  public void ColorPicker1() {
    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(this);
    GradientDrawable gg = new GradientDrawable();
    gg.setColor(0xFF1F1B1C);
    gg.setStroke(1, 0xFFFBA993);
    gg.setCornerRadius(30f);
    dialog.setBackground(gg);
    LayoutInflater inflater = getLayoutInflater();
    final View view = inflater.inflate(R.layout.view_demo, null);
    dialog.setView(view);
    final ColorPickerView picker = (ColorPickerView) view.findViewById(R.id.colorPicker);
    picker.setColor(0xffff0000);

    dialog.setPositiveButton(
        "OK",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Save("gradientColor1", String.valueOf(picker.getColor()));
            Back_ColorPicker();
          }
        });
    dialog.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {}
        });

    dialog.show();
  }

  public void ColorPicker2() {
    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(this);
    GradientDrawable gg = new GradientDrawable();
    gg.setColor(0xFF1F1B1C);
    gg.setCornerRadius(30f);
    gg.setStroke(1, 0xFFFBA993);
    dialog.setBackground(gg);
    LayoutInflater inflater = getLayoutInflater();
    final View view = inflater.inflate(R.layout.view_demo, null);
    dialog.setView(view);
    final ColorPickerView picker = (ColorPickerView) view.findViewById(R.id.colorPicker);
    picker.setColor(0xffff0000);

    dialog.setPositiveButton(
        "OK",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Save("gradientColor2", String.valueOf(picker.getColor()));
            Back_ColorPicker();
          }
        });
    dialog.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {}
        });

    dialog.show();
  }

  public void ColorPicker3() {
    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(this);
    GradientDrawable gg = new GradientDrawable();
    gg.setColor(0xFF1F1B1C);
    gg.setStroke(1, 0xFFFBA993);
    gg.setCornerRadius(30f);
    dialog.setBackground(gg);
    LayoutInflater inflater = getLayoutInflater();
    final View view = inflater.inflate(R.layout.view_demo, null);
    dialog.setView(view);
    final ColorPickerView picker = (ColorPickerView) view.findViewById(R.id.colorPicker);
    picker.setColor(0xffff0000);

    dialog.setPositiveButton(
        "OK",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Save("gradientColor3", String.valueOf(picker.getColor()));
            Back_ColorPicker();
          }
        });
    dialog.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {}
        });

    dialog.show();
  }

  public void ColorPicker4() {
    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(this);
    GradientDrawable gg = new GradientDrawable();
    gg.setColor(0xFF1F1B1C);
    gg.setStroke(1, 0xFFFBA993);
    gg.setCornerRadius(30f);
    dialog.setBackground(gg);
    LayoutInflater inflater = getLayoutInflater();
    final View view = inflater.inflate(R.layout.view_demo, null);
    dialog.setView(view);
    final ColorPickerView picker = (ColorPickerView) view.findViewById(R.id.colorPicker);
    picker.setColor(0xffff0000);

    dialog.setPositiveButton(
        "OK",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Save("gradientColor4", String.valueOf(picker.getColor()));
            Back_ColorPicker();
          }
        });
    dialog.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {}
        });

    dialog.show();
  }

  public void ColorPicker5() {
    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(this);
    GradientDrawable gg = new GradientDrawable();
    gg.setColor(0xFF1F1B1C);
    gg.setStroke(1, 0xFFFBA993);
    gg.setCornerRadius(30f);
    dialog.setBackground(gg);
    LayoutInflater inflater = getLayoutInflater();
    final View view = inflater.inflate(R.layout.view_demo, null);
    dialog.setView(view);
    final ColorPickerView picker = (ColorPickerView) view.findViewById(R.id.colorPicker);
    picker.setColor(0xffff0000);

    dialog.setPositiveButton(
        "OK",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Save("gradientColor5", String.valueOf(picker.getColor()));
            Back_ColorPicker();
          }
        });
    dialog.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {}
        });

    dialog.show();
  }

  public void ColorPicker6() {
    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(this);
    GradientDrawable gg = new GradientDrawable();
    gg.setColor(0xFF1F1B1C);
    gg.setStroke(1, 0xFFFBA993);
    gg.setCornerRadius(30f);
    dialog.setBackground(gg);
    LayoutInflater inflater = getLayoutInflater();
    final View view = inflater.inflate(R.layout.view_demo, null);
    dialog.setView(view);
    final ColorPickerView picker = (ColorPickerView) view.findViewById(R.id.colorPicker);
    picker.setColor(0xffff0000);

    dialog.setPositiveButton(
        "OK",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Save("gradientColor6", String.valueOf(picker.getColor()));
            Back_ColorPicker();
          }
        });
    dialog.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {}
        });

    dialog.show();
  }

  public void ColorPicker7() {
    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(this);
    GradientDrawable gg = new GradientDrawable();
    gg.setColor(0xFF1F1B1C);
    gg.setStroke(1, 0xFFFBA993);
    gg.setCornerRadius(30f);
    dialog.setBackground(gg);
    LayoutInflater inflater = getLayoutInflater();
    final View view = inflater.inflate(R.layout.view_demo, null);
    dialog.setView(view);
    final ColorPickerView picker = (ColorPickerView) view.findViewById(R.id.colorPicker);
    picker.setColor(0xffff0000);

    dialog.setPositiveButton(
        "OK",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Save("gradientColor7", String.valueOf(picker.getColor()));
            Back_ColorPicker();
          }
        });
    dialog.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {}
        });

    dialog.show();
  }

  public void ColorPicker8() {
    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(this);
    GradientDrawable gg = new GradientDrawable();
    gg.setColor(0xFF1F1B1C);
    gg.setStroke(1, 0xFFFBA993);
    gg.setCornerRadius(30f);
    dialog.setBackground(gg);
    LayoutInflater inflater = getLayoutInflater();
    final View view = inflater.inflate(R.layout.view_demo, null);
    dialog.setView(view);
    final ColorPickerView picker = (ColorPickerView) view.findViewById(R.id.colorPicker);
    picker.setColor(0xffff0000);

    dialog.setPositiveButton(
        "OK",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Save("gradientColor8", String.valueOf(picker.getColor()));
            Back_ColorPicker();
          }
        });
    dialog.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {}
        });

    dialog.show();
  }

  public void ColorPicker9() {
    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(this);
    GradientDrawable gg2 = new GradientDrawable();
    gg2.setColor(0xFF1F1B1C);
    gg2.setStroke(1, 0xFFFBA993);
    gg2.setCornerRadius(30f);
    dialog.setBackground(gg2);
    LayoutInflater inflater = getLayoutInflater();
    final View view = inflater.inflate(R.layout.view_demo, null);
    dialog.setView(view);
    final ColorPickerView picker = (ColorPickerView) view.findViewById(R.id.colorPicker);
    picker.setColor(0xffff0000);

    dialog.setPositiveButton(
        "OK",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Save("gradientColor9", String.valueOf(picker.getColor()));
            Back_ColorPicker();
          }
        });
    dialog.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {}
        });

    dialog.show();
  }

  public void ColorPicker10() {
    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(this);
    GradientDrawable gg = new GradientDrawable();
    gg.setColor(0xFF1F1B1C);
    gg.setStroke(1, 0xFFFBA993);
    gg.setCornerRadius(30f);
    dialog.setBackground(gg);
    LayoutInflater inflater = getLayoutInflater();
    final View view = inflater.inflate(R.layout.view_demo, null);
    dialog.setView(view);
    final ColorPickerView picker = (ColorPickerView) view.findViewById(R.id.colorPicker);
    picker.setColor(0xffff0000);

    dialog.setPositiveButton(
        "OK",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Save("gradientColor10", String.valueOf(picker.getColor()));
            Back_ColorPicker();
          }
        });
    dialog.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {}
        });

    dialog.show();
  }

  public void Save(String key, String value) {
    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
    editor.putString(key, value);
    editor.commit();
  }

  protected void ButtonBackGround(final Button b) {
    GradientDrawable gra = new GradientDrawable();
    gra.setColor(ColorStateList.valueOf(Color.parseColor("#FFFFB49D")));
    gra.setCornerRadius((float) 25);
    b.setBackgroundDrawable(gra);

    b.setOnTouchListener(
        new View.OnTouchListener() {
          @Override
          public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
              case MotionEvent.ACTION_DOWN:
                {
                  ObjectAnimator scaleX = new ObjectAnimator();
                  scaleX.setTarget(b);
                  scaleX.setPropertyName("scaleX");
                  scaleX.setFloatValues(0.9f);
                  scaleX.setDuration((int) 5);
                  scaleX.start();

                  ObjectAnimator scaleY = new ObjectAnimator();
                  scaleY.setTarget(b);
                  scaleY.setPropertyName("scaleY");
                  scaleY.setFloatValues(0.9f);
                  scaleY.setDuration((int) 5);
                  scaleY.start();
                  break;
                }
              case MotionEvent.ACTION_UP:
                {
                  ObjectAnimator scaleX = new ObjectAnimator();
                  scaleX.setTarget(b);
                  scaleX.setPropertyName("scaleX");
                  scaleX.setFloatValues((float) 1);
                  scaleX.setDuration((int) 5);
                  scaleX.start();

                  ObjectAnimator scaleY = new ObjectAnimator();
                  scaleY.setTarget(b);
                  scaleY.setPropertyName("scaleY");
                  scaleY.setFloatValues((float) 1);
                  scaleY.setDuration((int) 5);
                  scaleY.start();

                  break;
                }
            }
            return false;
          }
        });
  }
}
