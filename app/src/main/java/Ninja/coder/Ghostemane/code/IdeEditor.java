package Ninja.coder.Ghostemane.code;

import Ninja.coder.Ghostemane.code.interfaces.CallBackErrorManager;
import Ninja.coder.Ghostemane.code.marco.CommentList;
import Ninja.coder.Ghostemane.code.marco.editorface.IEditor;
import Ninja.coder.Ghostemane.code.widget.SymbolInputView;
import Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat.FastScrollerBuilder;
import Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat.Md2PopupBackground;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.*;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.text.FormatThread;
import io.github.rosemoe.sora.util.KeyboardUtils;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import io.github.rosemoe.sora.widget.SymbolChannel;

import io.github.rosemoe.sora.widget.tooltip.ToolTipHelper;
import java.io.File;
import java.util.regex.Pattern;

public class IdeEditor extends CodeEditor implements IEditor {

  private static String A = "Made by ninja coder";
  protected CallBackErrorManager call;
  private String accumulatedText = "";
  private boolean isDisableSoftKbdIfHardKbdAvailable;
  private boolean isDisableSoftKbdOnHardKbd;
  private boolean isSoftKbdEnabled;
  private CommentList listitem;
  private ToolTipHelper toolTipHelper;
  

  // for test
  private Pattern URL_PATTERN =
      Pattern.compile(
          "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)");
  // test
  private SymbolInputView mSymbolInputView;

  public IdeEditor(Context context) {
    super(context);
  }

  public IdeEditor(Context context, AttributeSet set) {
    super(context, set);

    init();
  }

  public IdeEditor(Context context, AttributeSet set, int def) {
    super(context, set, def);

    init();
  }

  public IdeEditor init() {
    setTabWidth(4);
    listitem = new CommentList();
    setScrollBarSize(3);
    setLigatureEnabled(true);
    showSoftInput();
    setLineInfoTextSize(18f);
    setScalable(true);
    setCursorWidth(4.0f);
    

    
    setNonPrintablePaintingFlags(
        FLAG_DRAW_WHITESPACE_LEADING
            | FLAG_DRAW_WHITESPACE_INNER
            | FLAG_DRAW_WHITESPACE_FOR_EMPTY_LINE);

    // getTextAnalyzeResult
    subscribeEvent(
        ContentChangeEvent.class,
        (event, subscribe) -> {
          /// Code for saving file
          if (!(event.getAction() == ContentChangeEvent.ACTION_SET_NEW_TEXT)) {
            if (accumulatedText.contains(listitem.stopSearch)) {
              getSearcher().stopSearch();
              accumulatedText = "";
            } else if (accumulatedText.contains(listitem.showPopWindows)) {
              getTextActionWindow().show();
              accumulatedText = "";
            } else if (accumulatedText.contains(listitem.showColorPi)) {
              ColorPickerDialogBuilder.with(getContext())
                  .setTitle("SetColor")
                  .density(20)
                  .showColorEdit(true)
                  .setOnColorSelectedListener(
                      new OnColorSelectedListener() {
                        @Override
                        public void onColorSelected(int selectedColor) {}
                      })
                  .setPositiveButton(
                      "Ok",
                      new ColorPickerClickListener() {
                        @Override
                        public void onClick(
                            DialogInterface dialog, int selectedColor, Integer[] allColors) {
                          String rgs = Integer.toHexString(selectedColor);
                          SymbolChannel sys = createNewSymbolChannel();
                          sys.insertSymbol("#" + rgs.replace("####", "#"), 1);
                        }
                      })
                  .setNegativeButton(
                      "No",
                      new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {}
                      })
                  .build()
                  .show();
              accumulatedText = "";
            } else {

            }
          }
        });

    return this;
  }

  public void setFadein() {
    Animation fadein = new AlphaAnimation(0, 1);
    fadein.setInterpolator(new DecelerateInterpolator());
    fadein.setDuration(1000L);
    AnimationSet set = new AnimationSet(false);
    set.addAnimation(fadein);
    startAnimation(set);
  }

  public void setFadeOut() {
    Animation fadeout = new AlphaAnimation(1, 0);
    fadeout.setInterpolator(new AccelerateInterpolator());
    fadeout.setDuration(1000L);
    AnimationSet set = new AnimationSet(false);
    set.addAnimation(fadeout);
    startAnimation(set);
  }

  public void AutoRedo() {
    if (canRedo()) {
      redo();
    } else {
      Dialog("Redo Manager", "Not Found Data");
    }
  }

  public void AutoUndo() {
    if (canUndo()) {
      undo();
    } else {
      Dialog("Undo Manager", "Not Found Data");
    }
  }

  public void appendText(String rgs) {
    SymbolChannel sys = createNewSymbolChannel();
    sys.insertSymbol(rgs, (int) 1);
  }

  private void Dialog(CharSequence title, CharSequence massges) {
    new MaterialAlertDialogBuilder(getContext())
        .setTitle(title)
        .setMessage(massges)
        .setPositiveButton("ok", null)
        .setBackground(colorAcsentDialog())
        .show();
  }

  public void left() {
    moveSelectionLeft();
  }

  public void right() {
    moveSelectionRight();
  }

  public void down() {
    moveSelectionDown();
  }

  public void up() {
    moveSelectionUp();
  }

  public void ThreadFormater(EditorLanguage language, OnFormatLinsner linsner) {
    if (formatCodeAsync()) {
      FormatThread threads =
          new FormatThread(
              getText().toString(),
              language,
              new FormatThread.FormatResultReceiver() {
                @Override
                public void onFormatFail(Throwable t) {
                  linsner.FormaterError(t);
                }

                @Override
                public void onFormatSucceed(CharSequence originalText, CharSequence newText) {
                  linsner.Formter(originalText, newText, language);
                }
              });
    }
  }

  public void TEXT(TextView textView, String data, Result result, View fab) {
    subscribeEvent(
        ContentChangeEvent.class,
        (event, subscribe) -> {
          /// Code for saving file

          result.onTextEnd(data);
        });
  }

  public String code() {
    return getText().toString();
  }

  public String appendText(String textLevelone, String tex2) {
    StringBuilder builder = new StringBuilder();
    builder.append(textLevelone).append('\n');
    builder.append(code()).append(tex2);

    return builder.toString();
  }

  protected MaterialShapeDrawable colorAcsentDialog() {
    MaterialShapeDrawable materialShapeDrawable =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.CUT, 20f).build());
    EditorColorScheme editorColorScheme = getColorScheme();
    materialShapeDrawable.setFillColor(
        ColorStateList.valueOf(editorColorScheme.getColor(EditorColorScheme.AUTO_COMP_PANEL_BG)));
    materialShapeDrawable.setStroke(
        2f,
        ColorStateList.valueOf(
            editorColorScheme.getColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER)));
    return materialShapeDrawable;
  }

  public IdeEditor setAllTypeFace(Typeface face) {
    setTypefaceLineNumber(face);
    setTypefaceText(face);

    return this;
  }

  @Override
  @Nullable
  public File getFile() {
    // TODO: Implement this method
    return null;
  }

  public void setDisableSoftKbdIfHardKbdAvai(boolean isDisabled) {
    if (isDisableSoftKbdIfHardKbdAvailable() == isDisabled) {

      return;
    }
    this.isDisableSoftKbdOnHardKbd = isDisabled;
    hideSoftInput();
    restartInput();
  }

  public boolean isDisableSoftKbdIfHardKbdAvailable() {
    return isDisableSoftKbdOnHardKbd;
  }

  protected boolean checkSoftInputEnabled() {
    if (isDisableSoftKbdIfHardKbdAvailable()
        && KeyboardUtils.isHardKeyboardConnected(getContext())) {
      return false;
    }
    return isSoftKeyboardEnabled();
  }

  public boolean isSoftKeyboardEnabled() {
    return this.isSoftKbdEnabled;
  }

  public void setSoftKeyboardEnabled(boolean isEnabled) {
    if (isSoftKeyboardEnabled() == isEnabled) {

      return;
    }

    this.isSoftKbdEnabled = isEnabled;
    hideSoftInput();
    restartInput();
  }

  public void subscribeContentChangeEvent(Runnable runnable) {
    subscribeEvent(
        ContentChangeEvent.class,
        (event, subscribe) -> {
          switch (event.getAction()) {
            case ContentChangeEvent.ACTION_INSERT:
            case ContentChangeEvent.ACTION_DELETE:
            case ContentChangeEvent.ACTION_SET_NEW_TEXT:
              new Handler(Looper.getMainLooper()).postDelayed(runnable, 10);
              break;
          }
        });
  }

  public void setErrorCallBack(CallBackErrorManager callBack) {
    this.call = callBack;
  }

  public interface Result {
    void onTextEnd(String data);
  }

  public interface OnFormatLinsner {
    public void Formter(CharSequence oldText, CharSequence newText, EditorLanguage language);

    public void FormaterError(Throwable throwable);
  }

  public static interface DoubleClickListener {
    void onSingleClick(final View view);

    void onDoubleClick(final View view);
  }

  public static class DoubleClick implements View.OnClickListener {

    private final Handler mHandler = new Handler();
    private final DoubleClickListener doubleClickListener;
    private long DOUBLE_CLICK_INTERVAL;
    private int clicks;
    private boolean isBusy = false;

    public DoubleClick(final DoubleClickListener doubleClickListener) {
      this(doubleClickListener, 200L);
      DOUBLE_CLICK_INTERVAL = 200L; // default time to wait the second click.
    }

    public DoubleClick(
        final DoubleClickListener doubleClickListener, final long DOUBLE_CLICK_INTERVAL) {
      this.doubleClickListener = doubleClickListener;
      this.DOUBLE_CLICK_INTERVAL =
          DOUBLE_CLICK_INTERVAL; // developer specified time to wait the second click.
    }

    @Override
    public void onClick(final View view) {

      if (!isBusy) {
        //  Prevent multiple click in this short time
        isBusy = true;

        // Increase clicks count
        clicks++;

        mHandler.postDelayed(
            new Runnable() {
              public final void run() {

                if (clicks >= 2) { // Double tap.
                  doubleClickListener.onDoubleClick(view);
                }

                if (clicks == 1) { // Single tap
                  doubleClickListener.onSingleClick(view);
                }

                // we need to  restore clicks count
                clicks = 0;
              }
            },
            DOUBLE_CLICK_INTERVAL);
        isBusy = false;
      }
    }
  }
}
