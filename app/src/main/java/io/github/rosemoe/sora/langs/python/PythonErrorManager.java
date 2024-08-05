package io.github.rosemoe.sora.langs.python;

import Ninja.coder.Ghostemane.code.IdeEditor;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.util.Log;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import java.io.IOException;
import java.io.StringReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

// Basic syntax analyzer with Python3
public class PythonErrorManager implements CodeAnalyzer {

  protected IdeEditor editor;

  public PythonErrorManager(IdeEditor editor) {
    this.editor = editor;
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
              try {
                ThreadUtils.runOnUiThread(
                    () -> {
                      var menu = new PowerMenu.Builder(editor.getContext()).build();

                      menu.addItem(
                          new PowerMenuItem(
                              "Error at line "
                                  + lines
                                  + ", column "
                                  + col
                                  + ": "
                                  + node.getText()));
                      menu.setShowBackground(false);
                      menu.setMenuColor(10);
                      menu.setBackgroundColor(MaterialColors.getColor(editor, ColorAndroid12.Back));
                      menu.setAutoDismiss(true);
                      menu.setTextColor(MaterialColors.getColor(editor, ColorAndroid12.TvColor));

                      menu.showAsAnchorLeftBottom(editor);
                    });
              } catch (Exception err) {

              }
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
    } catch (IOException err) {
      Log.e("Error to paser", err.getLocalizedMessage());
    }
  }

  private void logError(String message) {
    System.err.println(message); // Replace with your logging mechanism
  }
}
