package ir.ninjacoder.ghostide.editor;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import io.github.rosemoe.sora.event.ClickEvent;
import io.github.rosemoe.sora.event.LongPressEvent;
import io.github.rosemoe.sora.text.ContentLine;
import io.github.rosemoe.sora.text.ICUUtils;
import io.github.rosemoe.sora.util.IntPair;
import io.github.rosemoe.sora.event.SelectionChangeEvent;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.IdeEditor;

public class EditorUtil {

  public static void selectWord(IdeEditor editor, int line, int column) {
    // Find word edges
    int startLine = line, endLine = line;
    ContentLine lineObj = editor.getText().getLine(line);
    long edges = ICUUtils.getWordEdges(lineObj, column);
    int startColumn = IntPair.getFirst(edges);
    int endColumn = IntPair.getSecond(edges);
    if (startColumn == endColumn) {
      if (startColumn > 0) {
        startColumn--;
      } else if (endColumn < lineObj.length()) {
        endColumn++;
      } else {
        if (line > 0) {
          int lastColumn = editor.getText().getColumnCount(line - 1);
          startLine = line - 1;
          startColumn = lastColumn;
        } else if (line < editor.getLineCount() - 1) {
          endLine = line + 1;
          endColumn = 0;
        }
      }
    }
    editor.setSelectionRegion(startLine, startColumn, endLine, endColumn);
  }

  public static boolean isWhitespace(CharSequence charSequence) {
    for (int i = 0; i < charSequence.length(); i++) {
      char c = charSequence.charAt(i);
      if (!Character.isWhitespace(c)) {
        return false;
      }
    }
    return true;
  }

  public static void setClick(IdeEditor editor) {
    editor.getTextActionWindow().dismiss();

    editor.subscribeEvent(
        ClickEvent.class,
        (event, unsubscribe) -> {
          var cursor = editor.getCursor();
          if (cursor.isSelected()) {
            int index = editor.getText().getCharIndex(event.getLine(), event.getColumn());
            int cursorLeft = cursor.getLeft();
            int cursorRight = cursor.getRight();
            if (!isWhitespace(editor.getText().charAt(index) + "")
                && index >= cursorLeft
                && index <= cursorRight) {
              editor.showSoftInput();
              event.intercept();
            }
          }
        });

    editor.subscribeEvent(
        LongPressEvent.class,
        (event, unsubscribe) -> {
          event.intercept();
          var cursor = editor.getCursor();
          if (cursor.isSelected()) {
            int index = editor.getText().getCharIndex(event.getLine(), event.getColumn());
            int cursorLeft = cursor.getLeft();
            int cursorRight = cursor.getRight();
            char c = editor.getText().charAt(index);
            if (Character.isWhitespace(c)) {
              editor.setSelection(event.getLine(), event.getColumn());
            } else if (index < cursorLeft || index > cursorRight) {
              selectWord(editor, event.getLine(), event.getColumn());
            }
          } else {
            char c = editor.getText().charAt(event.getIndex());
            if (!Character.isWhitespace(c)) {
              selectWord(editor, event.getLine(), event.getColumn());
            } else {
              editor.setSelection(event.getLine(), event.getColumn());
            }
          }
          editor.getTextActionWindow().show();
        });
  }

  @Deprecated
  public static void savecursor(IdeEditor editor, Context ct, SharedPreferences sh) {
    Log.e("sub", "sub");
  }

  @Deprecated
  public static void restorecursor(IdeEditor editor, Context ct, SharedPreferences sh) {
    Log.e("sub", "sub");
  }

  
}
