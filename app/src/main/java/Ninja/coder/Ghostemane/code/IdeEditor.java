package Ninja.coder.Ghostemane.code;

import Ninja.coder.Ghostemane.code.config.LOG;
import Ninja.coder.Ghostemane.code.interfaces.CallBackErrorManager;
import Ninja.coder.Ghostemane.code.marco.CommentList;
import Ninja.coder.Ghostemane.code.marco.editorface.IEditor;
import Ninja.coder.Ghostemane.code.widget.SymbolInputView;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import io.github.rosemoe.sora.text.Content;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.animation.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.langs.xml.XMLLanguage;
import io.github.rosemoe.sora.langs.xml.XMLLexer;
import java.io.StringReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import java.util.ArrayList;
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
  public static final String EDITOR_LEFT_LINE_KEY = "line";
  public static final String EDITOR_LEFT_COLUMN_KEY = "column";
  public static final String EDITOR_RIGHT_LINE_KEY = "rightLine";
  public static final String EDITOR_RIGHT_COLUMN_KEY = "rightColumn";

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
            | FLAG_GHOSTWEB
            | FLAG_DRAW_WHITESPACE_FOR_EMPTY_LINE);
    subscribeEvent(ContentChangeEvent.class, ((event, unsubscribe) -> handleContentChange(event)));
    return this;
  }

  public void setFadein() {}

  public void setFadeOut() {}

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
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 20f).build());
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

  private void handleContentChange(@NonNull ContentChangeEvent event) {

    if (event.getAction() == ContentChangeEvent.ACTION_INSERT) {
      final var editor = event.getEditor();
      final var content = event.getChangedText();
      final var endLine = event.getChangeEnd().line;
      final var endColumn = event.getChangeEnd().column;
      if (getEditorLanguage() instanceof XMLLanguage) {
        boolean isOpen = false;
        try {
          isOpen = editor.getText().charAt(editor.getCursor().getLeft() - 2) == '<';
        } catch (Throwable th) {
        }

        if (isOpen && "/".contentEquals(content)) {
          closeCurrentTag(editor.getText().toString(), endLine, endColumn);
        }
      }
    }
  }

  private void closeCurrentTag(String text, int line, int col) {
    try {
      XMLLexer lexer = new XMLLexer(CharStreams.fromReader(new StringReader(text)));
      Token token;
      boolean wasSlash = false, wasOpen = false;
      ArrayList<String> currentNames = new ArrayList<>();
      while (((token = lexer.nextToken()) != null && token.getType() != token.EOF)) {
        final int type = token.getType();
        if (type == XMLLexer.OPEN) {
          wasOpen = true;
        } else if (type == XMLLexer.Name) {
          if (wasOpen && wasSlash && currentNames.size() > 0) {
            currentNames.remove(0);
          } else if (wasOpen) {
            currentNames.add(0, token.getText());
            wasOpen = false;
          }

        } else if (type == XMLLexer.OPEN_SLASH) {
          int l = token.getLine() - 1;
          int c = token.getCharPositionInLine();
          if (l == line && c == col) {
            break;
          } else if (currentNames.size() > 0) {
            currentNames.remove(0);
          }
        } else if (type == XMLLexer.SLASH_CLOSE || type == XMLLexer.SPECIAL_CLOSE) {
          if (currentNames.size() > 0 && token.getText().trim().endsWith("/>")) {
            currentNames.remove(0);
          }
        } else if (type == XMLLexer.SLASH) {
          wasSlash = true;
        } else {
          wasOpen = wasSlash = false;
        }
      }

      if (currentNames.size() > 0) {
        getText().insert(line, col + 2, currentNames.get(0));
      }
    } catch (Throwable th) {
      LOG.error("Unable to close current tag", th.getLocalizedMessage());
    }
  }

  public void restoreState(@NonNull Bundle savedInstanceState) {

    try {
      if (savedInstanceState != null) {

        int leftLine = savedInstanceState.getInt(EDITOR_LEFT_LINE_KEY, 0);
        int leftColumn = savedInstanceState.getInt(EDITOR_LEFT_COLUMN_KEY, 0);
        int rightLine = savedInstanceState.getInt(EDITOR_RIGHT_LINE_KEY, 0);
        int rightColumn = savedInstanceState.getInt(EDITOR_RIGHT_COLUMN_KEY, 0);

        Content text = getText();
        if (leftLine > text.getLineCount() || rightLine > text.getLineCount()) {
          return;
        }
        if (leftLine != rightLine && leftColumn != rightColumn) {
          setSelectionRegion(leftLine, leftColumn, rightLine, rightColumn, true);
        } else {
          setSelection(leftLine, leftColumn);
        }
      }
    } catch (Exception err) {
      Log.e("EditorBindError ", err.getLocalizedMessage());
    }
  }

  public int getLineCountes() {
    return getLineCount();
  }

  public String formatLine() {
    return String.format("%s...%s", 1, getLineCount());
  }
}
