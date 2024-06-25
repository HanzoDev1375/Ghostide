package Ninja.coder.Ghostemane.code.keyboard;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.Keyboard.Key;
import android.inputmethodservice.KeyboardView;
import android.preference.PreferenceManager;
import android.util.AttributeSet;

import com.google.android.material.color.MaterialColors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Keyboard_View extends KeyboardView {

  String Theme = "";

  public Keyboard_View(Context context, AttributeSet attrs) {
    super(context, attrs);
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

  public void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    Paint paint2 = new Paint();
    paint2.setAntiAlias(true);
    paint2.setSubpixelText(true);
    paint2.setTextAlign(Paint.Align.CENTER);
    paint2.setAlpha(255);

    String Font =
        PreferenceManager.getDefaultSharedPreferences(getContext()).getString("Font", "1");
    if (Font.equals("1")) {

    } else if (Font.equals("2")) {
      paint2.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "font/BKoodkBd.ttf"));
    } else if (Font.equals("3")) {
      paint2.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "font/BYekan.ttf"));
    } else if (Font.equals("4")) {
      paint2.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "font/DastNevis.ttf"));
    } else if (Font.equals("5")) {
      paint2.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "font/irsans.ttf"));
    } else if (Font.equals("6")) {
      paint2.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "font/naskh.ttf"));
    } else if (Font.equals("7")) {
      paint2.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "font/tabssom.ttf"));
    } else if (Font.equals("8")) {
      paint2.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "font/ghostfont.ttf"));
    }

    Theme = PreferenceManager.getDefaultSharedPreferences(getContext()).getString("Theme", "5");

    if (Theme.equals("1")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));
    } else if (Theme.equals("2")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));
    } else if (Theme.equals("3")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));
    } else if (Theme.equals("4")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));;
    } else if (Theme.equals("5")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));
    } else if (Theme.equals("6")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));
    } else if (Theme.equals("7")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));
    } else if (Theme.equals("8")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));
    } else if (Theme.equals("9")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));
    } else if (Theme.equals("10")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));
    } else if (Theme.equals("11")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));
    } else if (Theme.equals("12")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));
    } else if (Theme.equals("13")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));
    } else if (Theme.equals("14")) {
      paint2.setColor(MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0));
    }
    paint2.setTextSize(
        getPrefInt(PreferenceManager.getDefaultSharedPreferences(getContext()), "TextSize2", 20));

    for (Key key : getKeyboard().getKeys()) {
      if (key.codes[0] == 1588) {
        canvas.drawText(
            "َ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1587) {
        canvas.drawText(
            "ُ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1740) {
        canvas.drawText(
            "ئ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1576) {
        canvas.drawText(
            "ّ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1604) {
        canvas.drawText(
            "ِ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1575) {
        canvas.drawText(
            "آ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1591) {
        canvas.drawText(
            "ظ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1586) {
        canvas.drawText(
            "ژ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1583) {
        canvas.drawText(
            "ذ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1711) {
        canvas.drawText(
            "ء",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1614) {
        canvas.drawText(
            "َ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1615) {
        canvas.drawText(
            "ُ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1574) {
        canvas.drawText(
            "ئ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1617) {
        canvas.drawText(
            "ّ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1616) {
        canvas.drawText(
            "ِ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1570) {
        canvas.drawText(
            "آ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1592) {
        canvas.drawText(
            "ظ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1688) {
        canvas.drawText(
            "ژ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1584) {
        canvas.drawText(
            "ذ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1569) {
        canvas.drawText(
            "ء",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1589) {
        canvas.drawText(
            "ض",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1590) {
        canvas.drawText(
            "ض",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1579) {
        canvas.drawText(
            "ً",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1611) {
        canvas.drawText(
            "ً",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1593) {
        canvas.drawText(
            "غ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 1594) {
        canvas.drawText(
            "غ",
            (float) (key.x + ((key.width / 7) * 2)),
            (float) ((key.y + (key.height / 3)) + (key.height / 16)),
            paint2);
      }
      if (key.codes[0] == 10) {
        if (Theme.equals("13")) {
          drawKeyBackground(R.drawable.enter_key, canvas, key);
        }
        if (Theme.equals("14")) {
          drawKeyBackground(R.drawable.keyenter, canvas, key);
        }
      }
      // number(اعداد))
      if (key.codes[0] == 1382) {
        if (Theme.equals("14")) {
          drawKeyBackground(R.drawable.getnumber, canvas, key);
        }
      }
      /// حذف
      if (key.codes[0] == -5) {

        if (Theme.equals("14")) {
          drawKeyBackground(R.drawable.getdel, canvas, key);
        }
      }
      // شیفت
      if (key.codes[0] == -1) {

        if (Theme.equals("14")) {
          drawKeyBackground(R.drawable.getshift, canvas, key);
        }
      }
    }
  }

  public boolean onLongPress(Key key) {
    if (key.codes[0] == -1) {
      getOnKeyboardActionListener().onKey(-2020, null);
      return true;

    } else if (key.codes[0] == 990153) {
      getOnKeyboardActionListener().onKey(-2778, null);
      return true;

    } else {
      draw(new Canvas());
      return super.onLongPress(key);
    }
  }

  private void drawKeyBackground(int drawableId, Canvas canvas, Keyboard.Key key) {
    Drawable npd = getContext().getResources().getDrawable(drawableId);
    int[] drawableState = key.getCurrentDrawableState();
    if (key.codes[0] != 0) {
      npd.setState(drawableState);
    }
    npd.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
    npd.draw(canvas);
  }
}
