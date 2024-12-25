package ir.ninjacoder.ghostide.keyboard;

import ir.ninjacoder.ghostide.ApplicationLoader;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.inputmethodservice.Keyboard;
import androidx.preference.PreferenceManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyKeyboard extends Keyboard {

  public MyKeyboard(Context context, int xmlLayoutResId) {
    super(context, xmlLayoutResId);
  }

  static int getIntFromString(String val, int defVal) {
    Matcher num = Pattern.compile("(\\d+).*").matcher(val);
    if (!num.matches()) return defVal;
    return Integer.parseInt(num.group(1));
  }

  static int getPrefInt(SharedPreferences prefs, String prefName, int defVal) {
    String prefVal = prefs.getString(prefName, Integer.toString(defVal));
    return getIntFromString(prefVal, defVal);
  }

  public Key createKeyFromXml(
      Resources resources, Row row, int i, int i2, XmlResourceParser xmlResourceParser) {

    Key key = new Key(resources, row, i, i2, xmlResourceParser);
    SharedPreferences sharedPref =
        PreferenceManager.getDefaultSharedPreferences(ApplicationLoader.getContext());

    row.verticalGap = getPrefInt(sharedPref, "Vertical", 1);

    int ramin = ApplicationLoader.getContext().getResources().getConfiguration().orientation;
    if (ramin == Configuration.ORIENTATION_LANDSCAPE) {
      if (PreferenceManager.getDefaultSharedPreferences(ApplicationLoader.getContext())
          .getBoolean("Height", true)) {
        row.defaultHeight = getPrefInt(sharedPref, "Height_2", 70);
        key.height = getPrefInt(sharedPref, "Height_2", 70);
      } else {

      }
    } else {
      if (PreferenceManager.getDefaultSharedPreferences(ApplicationLoader.getContext())
          .getBoolean("Height", true)) {
        row.defaultHeight = getPrefInt(sharedPref, "Height_1", 110);
        key.height = getPrefInt(sharedPref, "Height_1", 110);
      } else {

      }
    }

    return new MyKeyboards(resources, row, i, i2, xmlResourceParser);
  }

  public static class MyKeyboards extends Key {
    int[] a = new int[] {16842915};
    int[] b = new int[] {16842919, 16842915};
    int[] c = new int[] {16842919, 16842915};
    int[] d = new int[] {16842919};
    int[] e = new int[] {16842919, 16842911};
    int[] f = new int[] {16842919, 16842911, 16842912};
    int[] g = new int[] {16842911};
    int[] h = new int[] {16842911, 16842912};

    public MyKeyboards(
        Resources resources, Row row, int i, int i2, XmlResourceParser xmlResourceParser) {
      super(resources, row, i, i2, xmlResourceParser);
    }

    public int[] getCurrentDrawableState() {
      if (this.on) {
        if (this.pressed) {
          return this.f;
        }
        return this.h;
      } else if (this.sticky) {
        if (this.pressed) {
          return this.e;
        }
        return this.g;
      } else if (this.modifier) {
        if (this.pressed) {
          return this.b;
        }
        return this.a;
      } else if (this.pressed) {
        return this.d;
      } else {
        return (int[]) null;
      }
    }
  }
}
