package Ninja.coder.Ghostemane.code.keyboard;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.activities.BaseCompat;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

public class Theme extends BaseCompat {
  public static int[] ThumbId =
      new int[] {
        Integer.valueOf(R.mipmap.theme_1).intValue(),
        Integer.valueOf(R.mipmap.theme_2).intValue(),
        Integer.valueOf(R.mipmap.theme_3).intValue(),
        Integer.valueOf(R.mipmap.theme_4).intValue(),
        Integer.valueOf(R.mipmap.theme_5).intValue(),
        Integer.valueOf(R.mipmap.theme_6).intValue(),
        Integer.valueOf(R.mipmap.theme_7).intValue(),
        Integer.valueOf(R.mipmap.theme_8).intValue(),
        Integer.valueOf(R.mipmap.theme_9).intValue(),
        Integer.valueOf(R.mipmap.theme_10).intValue(),
        Integer.valueOf(R.mipmap.theme_11).intValue(),
        Integer.valueOf(R.mipmap.theme_12).intValue(),
        Integer.valueOf(R.mipmap.mazole).intValue(),
        Integer.valueOf(R.mipmap.mazole).intValue()
      };
  protected static int SDKINT = Build.VERSION.SDK_INT;
  protected static int SDKVERSION = Build.VERSION_CODES.LOLLIPOP;
  protected static String color = "#FF2B2122";
  private GridView gridView;
  private Toolbar toolbar;
  private AppBarLayout _app_bar;
  private CoordinatorLayout _coordinator;

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.theme_activity);
    toolbar = findViewById(R.id.keyboardsetThemeAc);
    _app_bar = findViewById(R.id._app_bar);
    _coordinator = findViewById(R.id._coordinator);
    setSupportActionBar(toolbar);
    setTitle("Select theme keyboard");

    //	getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF281D1B"));
    gridView = (GridView) findViewById(R.id.grid);
    gridView.setAdapter(new GridAdapter(this, ThumbId));
    gridView.setNumColumns((int) 3);
    gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
    gridView.setOnItemClickListener(
        new OnItemClickListener() {
          public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            switch (position) {
              case 0:
                saveTheme("Theme", "1");
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                finish();
                return;
              case 1:
                saveTheme("Theme", "2");
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                finish();
                return;
              case 2:
                saveTheme("Theme", "3");
                finish();
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                return;
              case 3:
                saveTheme("Theme", "4");
                finish();
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                return;
              case 4:
                saveTheme("Theme", "5");
                finish();
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                return;
              case 5:
                saveTheme("Theme", "6");
                finish();
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                return;
              case 6:
                saveTheme("Theme", "7");
                finish();
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                return;
              case 7:
                saveTheme("Theme", "8");
                finish();
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                return;
              case 8:
                saveTheme("Theme", "9");
                finish();
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                return;
              case 9:
                saveTheme("Theme", "10");
                finish();
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                return;
              case 10:
                saveTheme("Theme", "11");
                finish();
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                return;
              case 11:
                saveTheme("Theme", "12");
                finish();
                finish();
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                return;
              case 12:
                saveTheme("Theme", "13");
                finish();
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                break;
              case 13:
                saveTheme("Theme", "14");
                finish();
                Toast.makeText(Theme.this, "تم کیبورد تغییر کرد.", 0).show();
                break;
              default:
                return;
            }
          }
        });
  }

  public void saveTheme(String str, String str2) {
    SharedPreferences.Editor ed = PreferenceManager.getDefaultSharedPreferences(this).edit();
    ed.putString(str, str2);
    ed.apply();
  }
}
