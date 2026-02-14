package io.github.rosemoe.sora.widget;

import android.app.ProgressDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.Toast;
import android.util.Log;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import io.github.rosemoe.sora.text.Content;
import io.github.rosemoe.sora.text.Cursor;
import io.github.rosemoe.sora.text.CharPosition;
import io.github.rosemoe.sora.event.PublishSearchResultEvent;

/**
 * Search text in editor
 *
 * @author Rose
 */
@SuppressWarnings("deprecated")
public class EditorSearcher {

  private final CodeEditor mEditor;
  protected String mSearchText;
  private static final String TAG = "EditorSearcher";

  EditorSearcher(CodeEditor editor) {
    mEditor = editor;
  }

  private void checkState() {
    if (mSearchText == null) {
      throw new IllegalStateException("search text has not been set");
    }
  }

  // متد شمارش نتایج
  private int countMatches(String text, boolean isRegex) {
    if (text == null || text.isEmpty()) {
      return 0;
    }

    int count = 0;
    Content content = mEditor.getText();

    try {
      if (isRegex) {
        Pattern pattern = Pattern.compile(text);
        String fullText = content.toString();
        Matcher matcher = pattern.matcher(fullText);
        while (matcher.find()) {
          count++;
        }
      } else {
        String searchText = text;
        String fullText = content.toString();
        int index = 0;
        while ((index = fullText.indexOf(searchText, index)) != -1) {
          count++;
          index += searchText.length();
        }
      }
    } catch (PatternSyntaxException e) {
      Log.e(TAG, "Invalid regex: " + e.getMessage());
    } catch (Exception e) {
      Log.e(TAG, "Error counting matches: " + e.getMessage());
    }

    return count;
  }

  private void dispatchSearchResult(boolean isRegex) {
    int matchCount = countMatches(mSearchText, isRegex);
    mEditor.dispatchEvent(new PublishSearchResultEvent(mEditor, matchCount, mSearchText, isRegex));
  }

  public void search(String text) {
    search(text, false);
  }

  public void search(String text, boolean isRegex) {
    if (text == null || text.length() == 0) {
      mSearchText = null;
      mEditor.postInvalidate();
      dispatchSearchResult(isRegex);
      return;
    }

    mSearchText = text;
    dispatchSearchResult(isRegex);
    mEditor.postInvalidate();
  }

  public void searchWithRegex(String regex) {
    if (regex == null || regex.length() == 0) {
      mSearchText = null;
      mEditor.postInvalidate();
      dispatchSearchResult(true);
      return;
    }

    mSearchText = regex;
    dispatchSearchResult(true);
    mEditor.postInvalidate();
  }
  
  public boolean replaceThisWithRegex(String newText) {
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

      try {
        Pattern pattern = Pattern.compile(mSearchText);
        Matcher matcher = pattern.matcher(selectedText);

        if (matcher.matches() || matcher.find()) {
          cursor.onCommitText(newText);
          mEditor.hideAutoCompleteWindow();
          gotoNextWithRegex();
          dispatchSearchResult(true);
          return true;
        }
      } catch (PatternSyntaxException e) {
        Toast.makeText(mEditor.getContext(), "Invalid regex: " + e.getMessage(), Toast.LENGTH_SHORT)
            .show();
      }
    }
    gotoNextWithRegex();
    return false;
  }

  public void replaceAllWithRegex(final String newText) {
    checkState();

    ProgressDialog progressDialog =
        new ProgressDialog(mEditor.getContext(), ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    progressDialog.setTitle("Replacing with Regex...");
    progressDialog.setMessage("Editor is now replacing texts using regex");
    progressDialog.getWindow().setBackgroundDrawable(fb());
    progressDialog.setCanceledOnTouchOutside(false);
    progressDialog.setCancelable(false);
    progressDialog.show();

    final String searchPattern = mSearchText;

    new Thread() {
      @Override
      public void run() {
        String result = null;
        Exception ex = null;

        try {
          Pattern pattern = Pattern.compile(searchPattern);
          String fullText = mEditor.getText().toString();
          Matcher matcher = pattern.matcher(fullText);
          result = matcher.replaceAll(newText);
        } catch (PatternSyntaxException e) {
          ex = e;
        } catch (Exception e) {
          e.printStackTrace();
          ex = e;
        }

        final Exception error = ex;
        final String newContent = result;

        mEditor.post(
            () -> {
              if (newContent == null) {
                Toast.makeText(
                        mEditor.getContext(),
                        "Regex error: " + (error != null ? error.getMessage() : "Unknown"),
                        Toast.LENGTH_LONG)
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
                        newContent);

                mEditor.setSelectionAround(line, column);
                mEditor.invalidate();

                mSearchText = searchPattern;
                dispatchSearchResult(true);

                Toast.makeText(
                        mEditor.getContext(),
                        "Replaced all matches using regex",
                        Toast.LENGTH_SHORT)
                    .show();
              }
              progressDialog.cancel();
            });
      }
    }.start();
  }

  public void gotoNext() {
    gotoNext(false);
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
        dispatchSearchResult(false);
        return;
      }
      column = 0;
    }

    if (tip) {
      Toast.makeText(mEditor.getContext(), "Not found in this direction", Toast.LENGTH_SHORT)
          .show();
    }
    dispatchSearchResult(false);
  }

  // متد gotoNext برای حالت regex
  public void gotoNextWithRegex() {
    checkState();
    Content text = mEditor.getText();
    Cursor cursor = text.getCursor();
    int currentPos = cursor.getRight();

    try {
      Pattern pattern = Pattern.compile(mSearchText);
      String fullText = text.toString();
      Matcher matcher = pattern.matcher(fullText);

      if (matcher.find(currentPos)) {
        CharPosition start = text.getIndexer().getCharPosition(matcher.start());
        CharPosition end = text.getIndexer().getCharPosition(matcher.end());
        mEditor.setSelectionRegion(start.line, start.column, end.line, end.column);
        dispatchSearchResult(true);
        return;
      }

      // از اول جستجو کن
      matcher.reset();
      if (matcher.find()) {
        CharPosition start = text.getIndexer().getCharPosition(matcher.start());
        CharPosition end = text.getIndexer().getCharPosition(matcher.end());
        mEditor.setSelectionRegion(start.line, start.column, end.line, end.column);
        Toast.makeText(
                mEditor.getContext(), "Reached end, continuing from start", Toast.LENGTH_SHORT)
            .show();
        dispatchSearchResult(true);
        return;
      }

      Toast.makeText(mEditor.getContext(), "No matches found", Toast.LENGTH_SHORT).show();
      dispatchSearchResult(true);

    } catch (PatternSyntaxException e) {
      Toast.makeText(mEditor.getContext(), "Invalid regex: " + e.getMessage(), Toast.LENGTH_SHORT)
          .show();
    }
  }

  // متد gotoLast برای حالت عادی
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
        dispatchSearchResult(false);
        return;
      }
      column = i - 1 >= 0 ? text.getColumnCount(i - 1) : 0;
    }

    Toast.makeText(mEditor.getContext(), "Not found in this direction", Toast.LENGTH_SHORT).show();
    dispatchSearchResult(false);
  }

  // متد gotoLast برای حالت regex
  public void gotoLastWithRegex() {
    checkState();
    Content text = mEditor.getText();
    Cursor cursor = text.getCursor();
    int currentPos = cursor.getLeft();

    try {
      Pattern pattern = Pattern.compile(mSearchText);
      String fullText = text.toString();
      Matcher matcher = pattern.matcher(fullText);

      int lastMatchBeforeCursor = -1;
      int lastMatchEnd = -1;

      // پیدا کردن آخرین match قبل از موقعیت فعلی
      while (matcher.find()) {
        if (matcher.start() < currentPos) {
          lastMatchBeforeCursor = matcher.start();
          lastMatchEnd = matcher.end();
        } else {
          break;
        }
      }

      if (lastMatchBeforeCursor != -1) {
        CharPosition start = text.getIndexer().getCharPosition(lastMatchBeforeCursor);
        CharPosition end = text.getIndexer().getCharPosition(lastMatchEnd);
        mEditor.setSelectionRegion(start.line, start.column, end.line, end.column);
        dispatchSearchResult(true);
        return;
      }

      // اگه قبلی نبود، آخرین match کل متن رو پیدا کن
      matcher.reset();
      int lastStart = -1;
      int lastEnd = -1;
      while (matcher.find()) {
        lastStart = matcher.start();
        lastEnd = matcher.end();
      }

      if (lastStart != -1) {
        CharPosition start = text.getIndexer().getCharPosition(lastStart);
        CharPosition end = text.getIndexer().getCharPosition(lastEnd);
        mEditor.setSelectionRegion(start.line, start.column, end.line, end.column);
        Toast.makeText(
                mEditor.getContext(), "Reached start, continuing from end", Toast.LENGTH_SHORT)
            .show();
        dispatchSearchResult(true);
      } else {
        Toast.makeText(mEditor.getContext(), "No matches found", Toast.LENGTH_SHORT).show();
        dispatchSearchResult(true);
      }

    } catch (PatternSyntaxException e) {
      Toast.makeText(mEditor.getContext(), "Invalid regex: " + e.getMessage(), Toast.LENGTH_SHORT)
          .show();
    }
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
        dispatchSearchResult(false);
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
    progressDialog.setTitle("Replacing...");
    progressDialog.setMessage("Editor is now replacing texts");
    progressDialog.getWindow().setBackgroundDrawable(fb());
    progressDialog.setCanceledOnTouchOutside(false);
    progressDialog.setCancelable(false);
    progressDialog.show();

    final String searchText = mSearchText;

    new Thread() {
      @Override
      public void run() {
        String result = null;
        Exception ex = null;

        try {
          result = mEditor.getText().toString().replace(searchText, newText);
        } catch (Exception e) {
          e.printStackTrace();
          ex = e;
        }

        final Exception error = ex;
        final String newContent = result;

        mEditor.post(
            () -> {
              if (newContent == null) {
                Toast.makeText(mEditor.getContext(), String.valueOf(error), Toast.LENGTH_SHORT)
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
                        newContent);

                mEditor.setSelectionAround(line, column);
                mEditor.invalidate();

                mSearchText = searchText;
                dispatchSearchResult(false);
              }
              progressDialog.cancel();
            });
      }
    }.start();
  }

  public void stopSearch() {
    mSearchText = null;
    mEditor.postInvalidate();
    dispatchSearchResult(false);
  }

  public int getMatchCount() {
    return countMatches(mSearchText, false);
  }

  public int getMatchCountWithRegex() {
    return countMatches(mSearchText, true);
  }

  private GradientDrawable fb() {
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setColor(ColorStateList.valueOf(Color.parseColor("#FF291E1C")));
    gradientDrawable.setStroke(1, ColorStateList.valueOf(Color.parseColor("#FFFFAF7A")));
    gradientDrawable.setShape(GradientDrawable.LINE);
    return gradientDrawable;
  }
}
