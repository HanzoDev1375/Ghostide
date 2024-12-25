package ir.ninjacoder.ghostide.keyboard;

import ir.ninjacoder.ghostide.R;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.preference.PreferenceManager;
import java.lang.reflect.Field;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyboardSamsung extends InputMethodService
    implements KeyboardView.OnKeyboardActionListener {

  int i = 1;
  int swipeLeft;
  int swipeRight;
  int swipeDown;
  int swipeUp;
  AudioManager mAudioManager;
  boolean mCapsLock;
  long mLastShiftTime;
  boolean mCapsR;
  GradientDrawable.Orientation orientation;
  private Keyboard_View KV;
  private LinearLayout LL;
  private MyKeyboard english,
      persian,
      persian_shift,
      number,
      sim_en_1,
      sim_en_2,
      sim_fa_1,
      sim_fa_2;
  private SharedPreferences sharedPref;
  private int Theme;

  static int getIntFromString(String val, int defVal) {
    Matcher num = Pattern.compile("(\\d+).*").matcher(val);
    if (!num.matches()) return defVal;
    return Integer.parseInt(num.group(1));
  }

  static int getPrefInt(SharedPreferences prefs, String prefName, int defVal) {
    String prefVal = prefs.getString(prefName, Integer.toString(defVal));
    return getIntFromString(prefVal, defVal);
  }

  public static void setDefaultFont(
      Context context, String staticTypefaceFieldName, String fontAssetName) {
    final Typeface regular = Typeface.createFromAsset(context.getAssets(), fontAssetName);
    replaceFont(staticTypefaceFieldName, regular);
  }

  protected static void replaceFont(String staticTypefaceFieldName, final Typeface newTypeface) {
    try {
      final Field staticField = Typeface.class.getDeclaredField(staticTypefaceFieldName);
      staticField.setAccessible(true);
      staticField.set(null, newTypeface);
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public void Save() {
    SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
    Theme = Integer.parseInt(shared.getString("Theme", "5"));
    swipeDown = Integer.parseInt(shared.getString("swipeDown", "1"));
    swipeLeft = Integer.parseInt(shared.getString("swipeLeft", "1"));
    swipeRight = Integer.parseInt(shared.getString("swipeRight", "1"));
    swipeUp = Integer.parseInt(shared.getString("swipeUp", "1"));
    mCapsR = shared.getBoolean("mcapsr", false);
  }

  public void safahat_dark() {
    if (PreferenceManager.getDefaultSharedPreferences(getBaseContext())
        .getBoolean("Number", true)) {
      english = new MyKeyboard(this, R.xml.english_a);
      persian = new MyKeyboard(this, R.xml.persian_a);
      persian_shift = new MyKeyboard(this, R.xml.persian_shift_a);
      sim_en_1 = new MyKeyboard(this, R.xml.sim_en_1_a);
      sim_en_2 = new MyKeyboard(this, R.xml.sim_en_2_a);
      sim_fa_1 = new MyKeyboard(this, R.xml.sim_fa_1_a);
      sim_fa_2 = new MyKeyboard(this, R.xml.sim_fa_2_a);
    } else {
      english = new MyKeyboard(this, R.xml.english_b);
      persian = new MyKeyboard(this, R.xml.persian_b);
      persian_shift = new MyKeyboard(this, R.xml.persian_shift_b);
      sim_en_1 = new MyKeyboard(this, R.xml.sim_en_1_b);
      sim_en_2 = new MyKeyboard(this, R.xml.sim_en_2_b);
      sim_fa_1 = new MyKeyboard(this, R.xml.sim_fa_1_b);
      sim_fa_2 = new MyKeyboard(this, R.xml.sim_fa_2_b);
    }
    number = new MyKeyboard(this, R.xml.number);
  }

  public void safahat_light() {
    if (PreferenceManager.getDefaultSharedPreferences(getBaseContext())
        .getBoolean("Number", true)) {
      english = new MyKeyboard(this, R.xml.english_a_dark);
      persian = new MyKeyboard(this, R.xml.persian_a_dark);
      persian_shift = new MyKeyboard(this, R.xml.persian_shift_a_dark);
      sim_en_1 = new MyKeyboard(this, R.xml.sim_en_1_a_dark);
      sim_en_2 = new MyKeyboard(this, R.xml.sim_en_2_a_dark);
      sim_fa_1 = new MyKeyboard(this, R.xml.sim_fa_1_a_dark);
      sim_fa_2 = new MyKeyboard(this, R.xml.sim_fa_2_a_dark);
    } else {
      english = new MyKeyboard(this, R.xml.english_b_dark);
      persian = new MyKeyboard(this, R.xml.persian_b_dark);
      persian_shift = new MyKeyboard(this, R.xml.persian_shift_b_dark);
      sim_en_1 = new MyKeyboard(this, R.xml.sim_en_1_b_dark);
      sim_en_2 = new MyKeyboard(this, R.xml.sim_en_2_b_dark);
      sim_fa_1 = new MyKeyboard(this, R.xml.sim_fa_1_b_dark);
      sim_fa_2 = new MyKeyboard(this, R.xml.sim_fa_2_b_dark);
    }
    number = new MyKeyboard(this, R.xml.number_dark);
  }

  @Override
  public View onCreateInputView() {
    Save();
    if (Theme == 1) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_bright, null);
      safahat_light();
    } else if (Theme == 2) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_full_bright, null);
      safahat_light();
    } else if (Theme == 3) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_dark, null);
      safahat_dark();
    } else if (Theme == 4) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_full_dark, null);
      safahat_dark();
    } else if (Theme == 5) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_yellow, null);
      safahat_light();
    } else if (Theme == 6) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_black1, null);
      safahat_dark();
    } else if (Theme == 7) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_black2, null);
      safahat_dark();
    } else if (Theme == 8) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_blue, null);
      safahat_dark();
    } else if (Theme == 9) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_boyish, null);
      safahat_light();
    } else if (Theme == 10) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_girly, null);
      safahat_dark();
    } else if (Theme == 11) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_black_glass, null);
      safahat_light();
    } else if (Theme == 12) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_white_glass, null);
      safahat_dark();
    } else if (Theme == 13) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_ninja, null);
      safahat_dark();
    } else if (Theme == 14) {
      LL = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_google, null);
      safahat_dark();
    }

    sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

    KV = LL.findViewById(R.id.KeyboardView);
    KV.setOnKeyboardActionListener((KeyboardView.OnKeyboardActionListener) this);
    safhe();
    KV.setOnKeyboardActionListener(this);

    Background();
    Font();

    if (PreferenceManager.getDefaultSharedPreferences(getBaseContext())
        .getBoolean("Preview", true)) {
      KV.setPreviewEnabled(true);
    } else {
      KV.setPreviewEnabled(false);
    }

    if (PreferenceManager.getDefaultSharedPreferences(getBaseContext())
        .getBoolean("Toolbar", true)) {
      return LL;
    }
    return KV;
  }

  public void onStartInputView(EditorInfo editorInfo, boolean z) {
    super.onStartInputView(editorInfo, z);
    switch (editorInfo.inputType & 15) {
      case 1:
        safhe();
        return;
      case 2:
        SetKeyboard(number);
        return;
      case 3:
        SetKeyboard(number);
        return;
      case 4:
        SetKeyboard(number);
        return;
      default:
        return;
    }
  }

  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (event.getRepeatCount() == 0 && KV != null && KV.handleBack()) {
      return true;
    }
    return super.onKeyDown(keyCode, event);
  }

  @Override
  public void onKey(int primaryCode, int[] keyCodes) {
    InputConnection ic = getCurrentInputConnection();
    MyKeyboard current = (MyKeyboard) KV.getKeyboard();
    if (PreferenceManager.getDefaultSharedPreferences(getBaseContext())
        .getBoolean("Vibrator", true)) {
      Vibrator_b(primaryCode);
    } else {

    }
    switch (primaryCode) {
      case -1382:
        if (current == persian) {
          current = english;
          i = 2;
        } else if (current == persian_shift) {
          current = english;
          i = 2;
        } else if (current == sim_en_1) {
          current = english;
        } else if (current == sim_en_2) {
          current = english;
        } else if (current == english) {
          current = persian;
          i = 1;
        } else if (current == sim_fa_1) {
          current = persian;
        } else if (current == sim_fa_2) {
          current = persian;
        }
        SetKeyboard(current);
        return;
      case 1382:
        if (current == persian) {
          current = sim_fa_1;
        } else if (current == persian_shift) {
          current = sim_fa_1;
        } else if (current == english) {
          current = sim_en_1;
        }
        SetKeyboard(current);
        return;
      case -1005:
        if (current == sim_en_1) {
          current = sim_en_2;
        } else if (current == sim_en_2) {
          current = sim_en_1;
        } else if (current == sim_fa_1) {
          current = sim_fa_2;
        } else if (current == sim_fa_2) {
          current = sim_fa_1;
        }
        SetKeyboard(current);
        return;
      case 1005:
        if (current == persian) {
          current = persian_shift;
          SetKeyboard(current);
        } else if (current == persian_shift) {
          current = persian;
          SetKeyboard(current);
        } else {
          SetKeyboard(english);
        }
        return;

      case -1:
        if (KV.getKeyboard() != english) {
          return;
        }
        if (mCapsR) {
          Toast.makeText(
                  this,
                  "هنگامی که تایپ مختلط فعال است,کلید شیفت بی اثر است.\nبرای غیر فعال کردن این حال کلید شیفت را فشار دهید و نگه دارید.",
                  1)
              .show();
        } else {
          if (KV != null && english == KV.getKeyboard()) {
            checkToggleCapsLock();
            KeyboardView keyboardView = KV;
            boolean z = (mCapsLock || !KV.isShifted()) ? true : false;
            keyboardView.setShifted(z);
          }
        }
        return;
      case -2020:
        SharedPreferences.Editor editor =
            PreferenceManager.getDefaultSharedPreferences(this).edit();
        if (this.mCapsR) {
          editor.putBoolean("mcapsr", false);
          editor.apply();
          Toast.makeText(this, "تایپ مختلط غیر فعال شد.", 0).show();
        } else {
          editor.putBoolean("mcapsr", true);
          editor.apply();
          Toast.makeText(this, "تایپ مختلط فعال شد.", 0).show();
        }
        Save();
        break;

      case -5:
        sendDownUpKeyEvents(KeyEvent.KEYCODE_DEL);
        break;

      case 10:
        EditorInfo curEditor = getCurrentInputEditorInfo();
        switch (curEditor.imeOptions & EditorInfo.IME_MASK_ACTION) {
          case EditorInfo.IME_ACTION_GO:
            getCurrentInputConnection().performEditorAction(EditorInfo.IME_ACTION_GO);
            break;
          case EditorInfo.IME_ACTION_NEXT:
            getCurrentInputConnection().performEditorAction(EditorInfo.IME_ACTION_NEXT);
            break;
          case EditorInfo.IME_ACTION_NONE:
            getCurrentInputConnection().performEditorAction(EditorInfo.IME_ACTION_NONE);
            break;
          case EditorInfo.IME_ACTION_PREVIOUS:
            getCurrentInputConnection().performEditorAction(EditorInfo.IME_ACTION_PREVIOUS);
            break;
          case EditorInfo.IME_ACTION_SEARCH:
            getCurrentInputConnection().performEditorAction(EditorInfo.IME_ACTION_SEARCH);
            break;
          case EditorInfo.IME_ACTION_SEND:
            getCurrentInputConnection().performEditorAction(EditorInfo.IME_ACTION_SEND);
            break;
          case EditorInfo.IME_ACTION_UNSPECIFIED:
            getCurrentInputConnection().performEditorAction(EditorInfo.IME_ACTION_UNSPECIFIED);
            break;
          default:
            ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
            break;
        }
        return;

      case -805:
        Toast.makeText(this, "کاری از رامین", 0).show();
        break;
      case 1401:
        sendDownUpKeyEvents(KeyEvent.KEYCODE_PASTE);
        break;
      case 1532:
        SetKeyboard(persian);
        ic.commitText("۰", 1);
        return;
      case 1633:
        SetKeyboard(persian);
        ic.commitText("۱", 1);
        return;
      case 1634:
        SetKeyboard(persian);
        ic.commitText("۲", 1);
        return;
      case 1635:
        SetKeyboard(persian);
        ic.commitText("۳", 1);
        return;
      case 1780:
        SetKeyboard(persian);
        ic.commitText("۴", 1);
        return;
      case 1781:
        SetKeyboard(persian);
        ic.commitText("۵", 1);
        return;
      case 1782:
        SetKeyboard(persian);
        ic.commitText("۶", 1);
        return;
      case 1639:
        SetKeyboard(persian);
        ic.commitText("۷", 1);
        return;
      case 1640:
        SetKeyboard(persian);
        ic.commitText("۸", 1);
        return;
      case 1641:
        SetKeyboard(persian);
        ic.commitText("۹", 1);
        return;

      case 1569:
        SetKeyboard(persian);
        ic.commitText("ء", 1);
        return;
      case 1570:
        SetKeyboard(persian);
        ic.commitText("آ", 1);
        return;
      case 1574:
        SetKeyboard(persian);
        ic.commitText("ئ", 1);
        return;
      case 1578:
        SetKeyboard(persian);
        ic.commitText("ت", 1);
        return;
      case 1580:
        SetKeyboard(persian);
        ic.commitText("ج", 1);
        return;
      case 1581:
        SetKeyboard(persian);
        ic.commitText("ح", 1);
        return;
      case 1582:
        SetKeyboard(persian);
        ic.commitText("خ", 1);
        return;
      case 1584:
        SetKeyboard(persian);
        ic.commitText("ذ", 1);
        return;
      case 1585:
        SetKeyboard(persian);
        ic.commitText("ر", 1);
        return;
      case 1590:
        SetKeyboard(persian);
        ic.commitText("ض", 1);
        return;
      case 1592:
        SetKeyboard(persian);
        ic.commitText("ظ", 1);
        return;
      case 1594:
        SetKeyboard(persian);
        ic.commitText("غ", 1);
        return;
      case 1601:
        SetKeyboard(persian);
        ic.commitText("ف", 1);
        return;
      case 1602:
        SetKeyboard(persian);
        ic.commitText("ق", 1);
        return;
      case 1605:
        SetKeyboard(persian);
        ic.commitText("م", 1);
        return;
      case 1606:
        SetKeyboard(persian);
        ic.commitText("ن", 1);
        return;
      case 1607:
        SetKeyboard(persian);
        ic.commitText("ه", 1);
        return;
      case 1608:
        SetKeyboard(persian);
        ic.commitText("و", 1);
        return;
      case 1611:
        SetKeyboard(persian);
        ic.commitText("ً", 1);
        return;
      case 1614:
        SetKeyboard(persian);
        ic.commitText("َ", 1);
        return;
      case 1615:
        SetKeyboard(persian);
        ic.commitText("ُ", 1);
        return;
      case 1616:
        SetKeyboard(persian);
        ic.commitText("ِ", 1);
        return;
      case 1617:
        SetKeyboard(persian);
        ic.commitText("ّ", 1);
        return;

      case 1662:
        SetKeyboard(persian);
        ic.commitText("پ", 1);
        return;
      case 1670:
        SetKeyboard(persian);
        ic.commitText("چ", 1);
        return;
      case 1688:
        SetKeyboard(persian);
        ic.commitText("ژ", 1);
        return;
      case 1705:
        SetKeyboard(persian);
        ic.commitText("ک", 1);
        return;
      case -46:
        SetKeyboard(persian);
        ic.commitText(".", 1);
        return;

      default:
        if (isWordSeparator(primaryCode)) {
          if (new StringBuilder().length() > 0) {
            commitTyped(getCurrentInputConnection());
          }
          updateShiftKeyState(getCurrentInputEditorInfo());
        }
        handleCharacter(primaryCode, keyCodes);
    }
  }

  private void handleCharacter(int primaryCode, int[] keyCodes) {
    if (isInputViewShown() && KV.isShifted()) {
      primaryCode = Character.toUpperCase(primaryCode);
    }
    if (false) {
      new StringBuilder().append((char) primaryCode);
      getCurrentInputConnection().setComposingText(new StringBuilder(), 1);
      updateShiftKeyState(getCurrentInputEditorInfo());
      return;
    }
    getCurrentInputConnection().commitText(String.valueOf((char) primaryCode), 1);
    updateShiftKeyState(getCurrentInputEditorInfo());
  }

  private void checkToggleCapsLock() {
    long now = System.currentTimeMillis();
    if (mLastShiftTime + ((long) 500) > now) {
      mCapsLock = mCapsLock ? false : true;
      mLastShiftTime = 0;
      return;
    }
    mLastShiftTime = now;
  }

  public void mCapser() {
    boolean[] Shift = {true, false, true, false};
    if (english == KV.getKeyboard()) {
      boolean caps = Shift[new Random().nextInt(2)];
      KV.setShifted(caps);
    }
  }

  private void updateShiftKeyState(EditorInfo attr) {
    if (attr != null && KV != null && english == KV.getKeyboard()) {
      int caps = 0;
      EditorInfo ei = getCurrentInputEditorInfo();
      if (!(ei == null || ei.inputType == 0)) {
        caps = getCurrentInputConnection().getCursorCapsMode(attr.inputType);
      }
      KeyboardView keyboardView = KV;
      boolean z = (mCapsLock || caps != 0) ? true : false;
      keyboardView.setShifted(z);
    }
  }

  private void commitTyped(InputConnection inputConnection) {
    if (new StringBuilder().length() > 0) {
      inputConnection.commitText(new StringBuilder(), 1);
      new StringBuilder().setLength(1);
    }
  }

  private String getWordSeparators() {
    String mWordSeparators = getResources().getString(R.string.word_separators);
    return mWordSeparators;
  }

  public boolean isWordSeparator(int code) {
    return getWordSeparators().contains(String.valueOf((char) code));
  }

  private void safhe() {
    String SetKeyboard =
        PreferenceManager.getDefaultSharedPreferences(this).getString("SetKeyboard", "2");
    if (SetKeyboard.equals("1")) {
      SetKeyboard(persian);
    } else if (SetKeyboard.equals("2")) {
      if (i == 1) {
        SetKeyboard(persian);
      } else {
        SetKeyboard(english);
      }
    } else if (SetKeyboard.equals("3")) {
      SetKeyboard(english);
    }
  }

  @Override
  public void onText(CharSequence text) {
    InputConnection ic = getCurrentInputConnection();
    if (ic != null) {
      ic.beginBatchEdit();
      if (new StringBuilder().length() > 0) {
        commitTyped(ic);
      }
      ic.commitText(text, 0);
      ic.endBatchEdit();
      updateShiftKeyState(getCurrentInputEditorInfo());
    }
  }

  @Override
  public void onPress(int primaryCode) {
    if (mCapsR
        && primaryCode != 0
        && primaryCode != -1
        && primaryCode != -5
        && primaryCode != -6363
        && primaryCode != -2) {
      mCapser();
    }
    if (PreferenceManager.getDefaultSharedPreferences(getBaseContext())
        .getBoolean("Vibrator", true)) {
      Vibrator_a(primaryCode);
    } else {

    }
    int keyFX;
    mAudioManager = (AudioManager) getSystemService("audio");
    if (PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getBoolean("Sound", true)) {
      switch (primaryCode) {
        case -5:
          keyFX = 7;
          break;
        case 10:
          keyFX = 8;
          break;
        case 32:
          keyFX = 6;
          break;
        default:
          keyFX = 5;
          break;
      }
      mAudioManager.playSoundEffect(keyFX, 1.0f);
    } else {

    }
  }

  public void Vibrator_a(int primaryCode) {
    ((Vibrator) getBaseContext().getSystemService("vibrator"))
        .vibrate(getPrefInt(sharedPref, "Vibrator_1", 10));
  }

  public void Vibrator_b(int primaryCode) {
    ((Vibrator) getBaseContext().getSystemService("vibrator"))
        .vibrate(getPrefInt(sharedPref, "Vibrator_2", 10));
  }

  @Override
  public void onRelease(int primaryCode) {}

  @Override
  public void swipeLeft() {
    Swiper(swipeLeft);
  }

  @Override
  public void swipeRight() {
    Swiper(swipeRight);
  }

  @Override
  public void swipeDown() {
    Swiper(swipeDown);
  }

  @Override
  public void swipeUp() {
    Swiper(swipeUp);
  }

  public void Swiper(int input) {
    if (input == 1) {
      return;
    }
    if (input == 2) {
      Typer(".");
    } else if (input == 3) {
      sendDownUpKeyEvents(KeyEvent.KEYCODE_ENTER);
    } else if (input == 4) {
      sendDownUpKeyEvents(KeyEvent.KEYCODE_SPACE);
    } else if (input == 5) {
      sendDownUpKeyEvents(KeyEvent.KEYCODE_DEL);
    } else if (input == 6) {
      commitTyped(getCurrentInputConnection());
      requestHideSelf(0);
      KV.closing();
    } else if (input == 7) {
      Typer("؟");
    } else if (input == 8) {
      MyKeyboard current = (MyKeyboard) KV.getKeyboard();
      if (current == persian) {
        current = english;
        i = 2;
      } else if (current == persian_shift) {
        current = english;
        i = 2;
      } else if (current == sim_en_1) {
        current = english;
      } else if (current == sim_en_2) {
        current = english;
      } else if (current == english) {
        current = persian;
        i = 1;
      } else if (current == sim_fa_1) {
        current = persian;
      } else if (current == sim_fa_2) {
        current = persian;
      }
      SetKeyboard(current);
    }
  }

  public void Typer(String in) {
    getCurrentInputConnection().commitText(in, 1);
  }

  private void SetKeyboard(MyKeyboard keyboard) {
    KV.setKeyboard(keyboard);
  }

  public void Font() {
    String Font = PreferenceManager.getDefaultSharedPreferences(this).getString("Font", "1");
    if (Font.equals("1")) {

    } else if (Font.equals("2")) {
      setDefaultFont(this, "DEFAULT", "font/BKoodkBd.ttf");
    } else if (Font.equals("3")) {
      setDefaultFont(this, "DEFAULT", "font/BYekan.ttf");
    } else if (Font.equals("4")) {
      setDefaultFont(this, "DEFAULT", "font/DastNevis.ttf");
    } else if (Font.equals("5")) {
      setDefaultFont(this, "DEFAULT", "font/irsans.ttf");
    } else if (Font.equals("6")) {
      setDefaultFont(this, "DEFAULT", "font/naskh.ttf");
    } else if (Font.equals("7")) {
      setDefaultFont(this, "DEFAULT", "font/tabssom.ttf");
    }
  }

  public void Background() {

    int Value1 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor1", "0"))
            .intValue();
    int Value2 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor2", "0"))
            .intValue();
    int Value3 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor3", "0"))
            .intValue();
    int Value4 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor4", "0"))
            .intValue();
    int Value5 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor5", "0"))
            .intValue();
    int Value6 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor6", "0"))
            .intValue();
    int Value7 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor7", "0"))
            .intValue();
    int Value8 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor8", "0"))
            .intValue();
    int Value9 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor9", "0"))
            .intValue();
    int Value10 =
        Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(this)
                    .getString("gradientColor10", "0"))
            .intValue();

    String Background =
        PreferenceManager.getDefaultSharedPreferences(this).getString("Background", "asli");
    String Model =
        PreferenceManager.getDefaultSharedPreferences(this).getString("Model", "takrang");
    String HalatMovazi =
        PreferenceManager.getDefaultSharedPreferences(this).getString("HalatMovazi", "amod");
    String HalatDavaran =
        PreferenceManager.getDefaultSharedPreferences(this).getString("HalatDavaran", "pain");
    String Tedad = PreferenceManager.getDefaultSharedPreferences(this).getString("Tedad", "rang2");

    if (Background.equals("asli")) {

    } else if (Background.equals("waliper")) {
      Drawable drawable = WallpaperManager.getInstance(this).getDrawable();
      KV.setBackgroundDrawable(drawable);

    } else if (Background.equals("gallary")) {
      Drawable bitmapDrawable =
          new BitmapDrawable(
              PreferenceManager.getDefaultSharedPreferences(this).getString("background", "0"));
      KV.setBackgroundDrawable(bitmapDrawable);

    } else if (Background.equals("rang")) {

      if (Model.equals("takrang")) {
        KV.setBackgroundColor(Value1);

      } else if (Model.equals("movazirang")) {
        if (HalatMovazi.equals("amod")) {
          if (Tedad.equals("rang2")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, new int[] {Value1, Value2});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang3")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, new int[] {Value1, Value2, Value3});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang4")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {Value1, Value2, Value3, Value4});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang5")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {Value1, Value2, Value3, Value4, Value5});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang6")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang7")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang8")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang9")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {
                      Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9
                    });
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang10")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {
                      Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9,
                      Value10
                    });
            KV.setBackgroundDrawable(drawable);
          }
        } else if (HalatMovazi.equals("dar45")) {
          if (Tedad.equals("rang2")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR, new int[] {Value1, Value2});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang3")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR, new int[] {Value1, Value2, Value3});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang4")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR, new int[] {Value1, Value2, Value3, Value4});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang5")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[] {Value1, Value2, Value3, Value4, Value5});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang6")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang7")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang8")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang9")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[] {
                      Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9
                    });
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang10")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[] {
                      Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9,
                      Value10
                    });
            KV.setBackgroundDrawable(drawable);
          }
        } else if (HalatMovazi.equals("ofogh")) {
          if (Tedad.equals("rang2")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, new int[] {Value1, Value2});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang3")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, new int[] {Value1, Value2, Value3});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang4")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {Value1, Value2, Value3, Value4});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang5")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {Value1, Value2, Value3, Value4, Value5});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang6")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang7")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang8")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8});
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang9")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {
                      Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9
                    });
            KV.setBackgroundDrawable(drawable);
          } else if (Tedad.equals("rang10")) {
            GradientDrawable drawable =
                new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {
                      Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9,
                      Value10
                    });
            KV.setBackgroundDrawable(drawable);
          }
        }

      } else if (Model.equals("davaranrang")) {
        if (HalatDavaran.equals("pain")) {
          if (Tedad.equals("rang2")) {
            int[] iArr = new int[] {Value1, Value2};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 1.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang3")) {
            int[] iArr = new int[] {Value1, Value2, Value3};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 1.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang4")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 1.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang5")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 1.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang6")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 1.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang7")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 1.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang8")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 1.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang9")) {
            int[] iArr =
                new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 1.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang10")) {
            int[] iArr =
                new int[] {
                  Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9, Value10
                };
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 1.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          }

        } else if (HalatDavaran.equals("center")) {
          if (Tedad.equals("rang2")) {
            int[] iArr = new int[] {Value1, Value2};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 0.5f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang3")) {
            int[] iArr = new int[] {Value1, Value2, Value3};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 0.5f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang4")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 0.5f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang5")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 0.5f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang6")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 0.5f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang7")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 0.5f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang8")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 0.5f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang9")) {
            int[] iArr =
                new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 0.5f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang10")) {
            int[] iArr =
                new int[] {
                  Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9, Value10
                };
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, 0.5f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          }

        } else if (HalatDavaran.equals("ups")) {
          if (Tedad.equals("rang2")) {
            int[] iArr = new int[] {Value1, Value2};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, -0.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang3")) {
            int[] iArr = new int[] {Value1, Value2, Value3};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, -0.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang4")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, -0.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang5")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, -0.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang6")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, -0.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang7")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, -0.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang8")) {
            int[] iArr = new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, -0.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang9")) {
            int[] iArr =
                new int[] {Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9};
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, -0.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          } else if (Tedad.equals("rang10")) {
            int[] iArr =
                new int[] {
                  Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9, Value10
                };
            GradientDrawable drawable = new GradientDrawable(orientation, iArr);
            drawable.setGradientCenter(0.5f, -0.1f);
            KV.setBackgroundDrawable(drawable);
            drawable.setGradientType(2);
          }
        }
      }
    }
  }
}
