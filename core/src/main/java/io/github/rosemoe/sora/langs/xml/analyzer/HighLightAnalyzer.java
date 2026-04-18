package io.github.rosemoe.sora.langs.xml.analyzer;

import android.graphics.Color;
import android.os.Handler;
import androidx.core.graphics.ColorUtils;
import ir.ninjacoder.ghostide.core.marco.RegexUtilCompat;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;
import java.io.IOException;
import java.io.StringReader;
import java.util.Stack;
import io.github.rosemoe.sora.data.BlockLine;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.XMLAutoComplete;
import io.github.rosemoe.sora.langs.xml.XMLLexer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;

/**
 * For highlight and code block line.
 *
 * <p>Note:Android Studio xml highlight style.
 */
public class HighLightAnalyzer implements CodeAnalyzer {
  private final Handler handler = new Handler();
  long delay = 1000L;
  long lastTime;
  CompileRunnable runnable = new CompileRunnable();
  private int lastLine;

  public int getLastLine() {
    return lastLine;
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult colors,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      XMLAutoComplete auto = new XMLAutoComplete();
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      XMLLexer lexer = new XMLLexer(stream);
      Token token, preToken = null, prePreToken = null;
      boolean first = true;
      lastLine = 1;
      int line, column, prev = 0;

      Stack<BlockLine> stack = new Stack<>();
      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == XMLLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        column = token.getCharPositionInLine();
        lastLine = line;

        switch (token.getType()) {
          case XMLLexer.SEA_WS:
          case XMLLexer.S:
            if (first) colors.addNormalIfNull();
            break;
            // <?xml
          case XMLLexer.XMLDeclOpen:
            // <?
            colors.addIfNeeded(line, column, EditorColorScheme.htmltag);
            // xml
            colors.addIfNeeded(line, column + 2, EditorColorScheme.htmlattr);
            break;
          case XMLLexer.EQUALS:
            colors.addIfNeeded(line, column, EditorColorScheme.htmlblocknormal);
            break;
          case XMLLexer.STRING:
          case XMLLexer.CharRef:
            {
              if (RegexUtilCompat.RegexSelect(
                  "(\\#[a-zA-F0-9]{8})|(\\#[a-zA-F0-9]{6})|(\\#[a-zA-F0-9]{3})", token.getText())) {

                String colorString = token.getText();
                if (colorString.length() == 4) {
                  String red = colorString.substring(1, 2);
                  String green = colorString.substring(2, 3);
                  String blue = colorString.substring(3, 4);
                  colorString = "#" + red + red + green + green + blue + blue;
                }

                try {
                  int color = Color.parseColor(colorString);
                  colors.addIfNeeded(line, column, EditorColorScheme.LITERAL);
                  if (ColorUtils.calculateLuminance(color) > 0.5) {
                    Span span =
                        Span.obtain(
                            column,
                            TextStyle.makeStyle(
                                EditorColorScheme.black, 0, false, false, false, false, true));
                    if (span != null) {
                      span.setBackgroundColorMy(color);
                      colors.add(line, span);
                    }
                  } else {
                    Span span =
                        Span.obtain(
                            column,
                            TextStyle.makeStyle(
                                EditorColorScheme.TEXT_NORMAL,
                                0,
                                false,
                                false,
                                false,
                                false,
                                true));
                    if (span != null) {
                      span.setBackgroundColorMy(color);
                      colors.add(line, span);
                    }
                  }

                  Span middle = Span.obtain(column + colorString.length(), EditorColorScheme.LITERAL);
                  middle.setBackgroundColorMy(Color.TRANSPARENT);
                  colors.add(line, middle);

                  Span end =
                      Span.obtain(
                          column + colorString.length(),
                          TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
                  end.setBackgroundColorMy(Color.TRANSPARENT);
                  colors.add(line, end);
                  break;
                } catch (Exception ignore) {
                  ignore.printStackTrace();
                }
              } else {
                colors.addIfNeeded(line, column, forString());
              }

              colors.addIfNeeded(line, column, EditorColorScheme.LITERAL);
              break;
            }

            // />
          case XMLLexer.SLASH_CLOSE:
          case XMLLexer.OPEN_SLASH:
            colors.addIfNeeded(line, column, EditorColorScheme.htmlblockhash);
            // set block line end position
            if (!stack.isEmpty()) {
              BlockLine block = stack.pop();
              block.endLine = line;
              block.endColumn = column;
              if (block.startLine != block.endLine) {
                if (preToken.getLine() == token.getLine()) block.toBottomOfEndLine = true;
                colors.addBlockLine(block);
              }
            }
            break;
            // /
          case XMLLexer.SLASH:
            colors.addIfNeeded(line, column, EditorColorScheme.htmlblockhash);
            // When we get "/", check the previous token.
            // If we get '<',set block line end position
            if (preToken != null && preToken.getType() == XMLLexer.OPEN) {
              if (!stack.isEmpty()) {
                BlockLine block = stack.pop();
                block.endLine = preToken.getLine() - 1;
                block.endColumn = preToken.getCharPositionInLine();
                if (block.startLine != block.endLine) {
                  if (prePreToken.getLine() == preToken.getLine()) block.toBottomOfEndLine = true;
                  colors.addBlockLine(block);
                }
              }
            }
            break;
          case XMLLexer.Name:
            String text = token.getText();
            // for name in </name>
            if (preToken != null && preToken.getType() == XMLLexer.SLASH) {
              colors.addIfNeeded(line, column, EditorColorScheme.htmlblockhash);
            }
            // for name in <name...
            // code block start
            else if (preToken != null && preToken.getType() == XMLLexer.OPEN) {
              colors.addIfNeeded(line, column, EditorColorScheme.htmlblockhash);
              BlockLine block = new BlockLine();
              block.startLine = preToken.getLine() - 1;
              block.startColumn = preToken.getCharPositionInLine(); // -1 for '<'
              stack.push(block);
            }
            // android studio style
            else if (text.startsWith("xmlns:")) {
              colors.addIfNeeded(line, column, EditorColorScheme.htmlstr);
              if (text.length() > "xmlns:".length()) {
                colors.addIfNeeded(line, column + "xmlns:".length(), EditorColorScheme.htmlstr);
              }
            } else {
              // for 'a:b:c' style,we high light all before the last ':' as namespace
              // (namespace:namespace:...):(the last one)
              // Color scheme name may be strange.
              if (text.contains(":")) {
                int index = text.lastIndexOf(':');
                colors.addIfNeeded(line, column, EditorColorScheme.jsfun);
                if (index != text.length() - 1)
                  colors.addIfNeeded(line, column + index + 1, EditorColorScheme.jsattr);
              }
            }
            if (preToken != null
                && preToken.getType() == XMLLexer.SLASH_CLOSE
                && preToken != null
                && preToken.getType() == XMLLexer.OPEN_SLASH) {
              colors.addIfNeeded(line, column, EditorColorScheme.htmltag);
            }
            break;
          case XMLLexer.COMMENT:
            colors.addIfNeeded(line, column, EditorColorScheme.COMMENT);
            break;
          case XMLLexer.OPEN:
            {
              colors.addIfNeeded(line, column, EditorColorScheme.htmltag);
              break;
            }
          case XMLLexer.CLOSE:
            colors.addIfNeeded(line, column, EditorColorScheme.htmltag);
            break;
          default:
            colors.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
        }

        if (preToken != null) {
          prePreToken = preToken;
        }
        if (token.getType() != XMLLexer.SEA_WS && token.getType() != XMLLexer.S) {
          preToken = token;
        }

        first = false;
      }
      compile(colors);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void compile(TextAnalyzeResult colors) {
    handler.removeCallbacks(runnable);
    lastTime = System.currentTimeMillis();
    runnable.setColors(colors);
    handler.postDelayed(runnable, delay);
  }

  private class CompileRunnable implements Runnable {

    private TextAnalyzeResult colors;

    public CompileRunnable() {}

    public void setColors(TextAnalyzeResult colors) {
      this.colors = colors;
    }

    @Override
    public void run() {
      if (colors == null) {
        return;
      }
      if (System.currentTimeMillis() < (lastTime - 500)) {
        return;
      }
    }
  }

  long forString() {
    return TextStyle.makeStyle(EditorColorScheme.htmlstr, 0, true, false, false);
  }
}
