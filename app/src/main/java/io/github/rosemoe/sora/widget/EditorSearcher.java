package io.github.rosemoe.sora.widget;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import io.github.rosemoe.sora.widget.CodeEditor;
import android.app.ProgressDialog;
import android.widget.Toast;
import io.github.rosemoe.sora.text.Content;
import io.github.rosemoe.sora.text.Cursor;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Search text in editor
 *
 * @author Rose
 */
@SuppressWarnings("deprecated")
public class EditorSearcher {

  private final CodeEditor mEditor;
  protected String mSearchText;

  EditorSearcher(CodeEditor editor) {
    mEditor = editor;
  }

  private void checkState() {
    if (mSearchText == null) {
      throw new IllegalStateException("search text has not been set");
    }
  }

  public void search(String text, boolean isRegex) {
    if (text != null && text.length() == 0) {
      text = null;
    }
    if (isRegex) {
      Pattern pattern = Pattern.compile(mSearchText);
      Matcher math = pattern.matcher(text);
      List<MatchResult> result = math.results().toList();
      for (var i : result) {
        text = i.group();
      }
    }

    mSearchText = text;
    mEditor.postInvalidate();
  }

  public void search(String txt) {
    search(txt, false);
  }

  @SuppressWarnings("UnusedReturnValue")
  public boolean replaceThis(String newText) {
    checkState();
    Content text = mEditor.getText();
    Cursor cursor = text.getCursor();
    if (cursor.isSelected()) {
      String selectedText =
          text.subContent(
                  cursor.getLeftLine(),
                  cursor.getLeftColumn(),
                  cursor.getRightLine(),
                  cursor.getRightColumn())
              .toString();
      if (selectedText.equals(mSearchText)) {
        cursor.onCommitText(newText);
        mEditor.hideAutoCompleteWindow();
        gotoNext(false);
        return true;
      }
    }
    gotoNext(false);
    return false;
  }

  public void replaceAll(final String newText) {
    checkState();
    ProgressDialog progressDialog =
        new ProgressDialog(mEditor.getContext(), ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    progressDialog.setTitle("Replaceing..");
    progressDialog.setMessage("Editor is now replacing texts");
    progressDialog.getWindow().setBackgroundDrawable(fb());
    progressDialog.setCanceledOnTouchOutside(false);
    progressDialog.setCancelable(false);
    progressDialog.show();
    //	 ProgressDialog.show(mEditor.getContext(), "Replacing", "Editor is now replacing texts,
    // please wait", true, false);
    final String searchText = mSearchText;
    new Thread() {

      @Override
      public void run() {
        String text = null;
        Exception ex = null;
        try {
          text = mEditor.getText().toString().replace(searchText, newText);
        } catch (Exception e) {
          e.printStackTrace();
          ex = e;
        }
        final Exception ex2 = ex;
        final String text2 = text;
        mEditor.post(
            () -> {
              if (text2 == null) {
                Toast.makeText(mEditor.getContext(), String.valueOf(ex2), Toast.LENGTH_SHORT)
                    .show();
              } else {
                int line = mEditor.getCursor().getLeftLine();
                int column = mEditor.getCursor().getLeftColumn();
                mEditor
                    .getText()
                    .replace(
                        0,
                        0,
                        mEditor.getLineCount() - 1,
                        mEditor.getText().getColumnCount(mEditor.getLineCount() - 1),
                        text2);
                mEditor.setSelectionAround(line, column);
                mEditor.invalidate();
              }
              progressDialog.cancel();
            });
      }
    }.start();
  }

  public void gotoNext() {
    gotoNext(true);
  }

  private void gotoNext(boolean tip) {
    checkState();
    Content text = mEditor.getText();
    Cursor cursor = text.getCursor();
    int line = cursor.getRightLine();
    int column = cursor.getRightColumn();
    for (int i = line; i < text.getLineCount(); i++) {
      int idx =
          column >= text.getColumnCount(i) ? -1 : text.getLine(i).indexOf(mSearchText, column);
      if (idx != -1) {
        mEditor.setSelectionRegion(i, idx, i, idx + mSearchText.length());
        return;
      }
      column = 0;
    }
    if (tip) {
      Toast.makeText(mEditor.getContext(), "Not found in this direction", Toast.LENGTH_SHORT)
          .show();
      mEditor.jumpToLine(0);
    }
  }

  public void gotoLast() {
    checkState();
    Content text = mEditor.getText();
    Cursor cursor = text.getCursor();
    int line = cursor.getLeftLine();
    int column = cursor.getLeftColumn();
    for (int i = line; i >= 0; i--) {
      int idx = column - 1 < 0 ? -1 : text.getLine(i).lastIndexOf(mSearchText, column - 1);
      if (idx != -1) {
        mEditor.setSelectionRegion(i, idx, i, idx + mSearchText.length());
        return;
      }
      column = i - 1 >= 0 ? text.getColumnCount(i - 1) : 0;
    }
    Toast.makeText(mEditor.getContext(), "Not found in this direction", Toast.LENGTH_SHORT).show();
  }

  public void stopSearch() {
    search(null);
  }

  private GradientDrawable fb() {
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setColor(ColorStateList.valueOf(Color.parseColor("#FF291E1C")));
    gradientDrawable.setStroke(1, ColorStateList.valueOf(Color.parseColor("#FFFFAF7A")));
    gradientDrawable.setShape(GradientDrawable.LINE);
    return gradientDrawable;
  }

  public void searchWithRegex(String regex) {
    if (regex != null && regex.length() == 0) {
      regex = null;
    }
    mSearchText = regex;
    mEditor.postInvalidate();
  }

  private boolean findNextMatchWithRegex(boolean tip) {
    checkState();
    Content text = mEditor.getText();
    Cursor cursor = text.getCursor();
    int line = cursor.getRightLine();
    int column = cursor.getRightColumn();

    Pattern pattern = Pattern.compile(mSearchText);

    for (int i = line; i < text.getLineCount(); i++) {
      Matcher matcher =
          pattern.matcher(text.subContent(i, 0, i, text.getColumnCount(i)).toString());
      if (matcher.find(column)) {
        mEditor.setSelectionRegion(i, matcher.start(), i, matcher.end());
        return true;
      }
      column = 0;
    }

    if (tip) {
      Toast.makeText(mEditor.getContext(), "Not found in this direction", Toast.LENGTH_SHORT)
          .show();
      mEditor.jumpToLine(0);
    }

    return false;
  }

  public void gotoNextWithRegex() {
    findNextMatchWithRegex(true);
  }
}
