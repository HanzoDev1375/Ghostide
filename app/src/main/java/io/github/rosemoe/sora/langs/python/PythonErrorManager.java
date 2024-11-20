package io.github.rosemoe.sora.langs.python;

import Ninja.coder.Ghostemane.code.IdeEditor;
import Ninja.coder.Ghostemane.code.utils.ObjectUtils;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

// Basic syntax analyzer with Python3
public class PythonErrorManager implements CodeAnalyzer {

  protected IdeEditor editor;
  protected List<String> errorMassges;

  public PythonErrorManager(IdeEditor editor) {
    this.editor = editor;
    errorMassges = new ArrayList<>();
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult colors,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {

    try {
      PythonLexer lexer =
          new PythonLexer(CharStreams.fromReader(new StringReader(content.toString())));
      CommonTokenStream stream = new CommonTokenStream(lexer);
      PythonParser parser = new PythonParser(stream);
      ParseTree grammarSpecContext = parser.file_input();
      // Listener for handling errors
      PythonParserBaseListener listener =
          new PythonParserBaseListener() {
            @Override
            public void visitErrorNode(ErrorNode node) {
              int lines = node.getSymbol().getLine();
              int col = node.getSymbol().getCharPositionInLine();
              int[] error = Utils.setErrorSpan(colors, lines, col);
              logError("Error at line " + lines + ", column " + col + ": " + node.getText());
              errorMassges.add(
                  "Error at line " + lines + ", column " + col + ": " + node.getText());
            }

            @Override
            public void visitTerminal(TerminalNode node) {
              int lines = node.getSymbol().getLine();
              int col = node.getSymbol().getCharPositionInLine();
              var builder = new StringBuilder();
              builder.append("line ").append(lines).append('\n');
              builder.append("col ").append(col).append('\n');
              builder.append("Text ").append(node.getSymbol().getText()).append("\n");
              logError(builder.toString());
            }
          };
      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(listener, grammarSpecContext);
      // Additional processing if needed...
      if (!errorMassges.isEmpty()) {
        try {
          ThreadUtils.runOnUiThread(() -> showmenu(editor));
        } catch (Exception err) {
          Log.w("ErrorPowerMenuNotShow ", err.getLocalizedMessage());
        }
      }
    } catch (IOException err) {
      Log.e("Error to paser", err.getLocalizedMessage());
    }
  }

  private void logError(String message) {
    System.err.println(message); // Replace with your logging mechanism
  }

  void showmenu(IdeEditor editor) {
    /// show editor in select in Cursor
    if (editor.getCursor().isSelected()) {

      var menu = new PowerMenu.Builder(editor.getContext()).setIsMaterial(true).build();
      for (var it : errorMassges) {
        menu.addItem(new PowerMenuItem(it + " Click to Dissmiss "));
      }
      menu.setShowBackground(false);
      var handler = new Handler(Looper.getMainLooper());
      handler.postDelayed(
          () -> {
            menu.dismiss();
          },
          2000);
      menu.setAnimation(MenuAnimation.FADE);
      menu.setMenuRadius(20f);
      menu.setMenuColor(MaterialColors.getColor(editor.getContext(), ObjectUtils.Back, 0));
      menu.setTextColor(
          MaterialColors.getColor(editor.getContext(), ObjectUtils.ColorAConNormal, 0));
      int top;
      var cursor = editor.getCursor();
      if (cursor.isSelected()) {
        var leftRect = editor.getLeftHandleDescriptor().position;
        var rightRect = editor.getRightHandleDescriptor().position;
        int top1 = selectTop(leftRect);
        int top2 = selectTop(rightRect);
        top = Math.min(top1, top2);
      } else {
        top = selectTop(editor.getInsertHandleDescriptor().position);
      }

      top = Math.max(0, Math.min(top, editor.getHeight() - 5));
      float handleLeftX =
          editor.getOffset(editor.getCursor().getLeftLine(), editor.getCursor().getLeftColumn());
      float handleRightX =
          editor.getOffset(editor.getCursor().getRightLine(), editor.getCursor().getRightColumn());
      int panelX = (int) ((handleLeftX + handleRightX) / 2f);
      menu.showAtLocation(editor, panelX, top);
    }
  }

  private int selectTop(RectF rect) {
    int rowHeight = editor.getRowHeight();
    if (rect.top - rowHeight * 3 / 2F > editor.getHeight()) {
      return (int) (rect.top - rowHeight * 3 / 2 - editor.getHeight());
    } else {
      return (int) (rect.bottom + rowHeight / 2);
    }
  }
}
