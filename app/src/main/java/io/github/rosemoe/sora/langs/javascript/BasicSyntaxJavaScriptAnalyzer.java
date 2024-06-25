package io.github.rosemoe.sora.langs.javascript;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.LineNumberCalculator;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;

import java.io.StringReader;

import java.util.List;

import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;
import org.mozilla.javascript.Parser;

/** Basic syntax analyzer with JavaScript using Rhino parser. */
public class BasicSyntaxJavaScriptAnalyzer implements CodeAnalyzer {
  private int line = 0;
  private int colum = 0;

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult colors,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    LineNumberCalculator lineNumber = new LineNumberCalculator(content);
    lineNumber.update(content.length());
    int errLine = 0;
    int errColumn = 0;
    while (true) {

      if (lineNumber.getLine() + 1 == line && lineNumber.getColumn() == colum) {
        break;
      }

      CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
      ErrorReporter errorReporter =
          new ErrorReporter() {
            @Override
            public void warning(
                String message, String sourceName, int line, String lineSource, int lineOffset) {
              // Handle warnings if needed
              int[] waring = setWaringSpan(colors, line, lineOffset);
            }

            @Override
            public void error(
                String message, String sourceName, int line, String lineSource, int lineOffset) {
              line = line;
              colum = lineOffset;
              int[] end = setErrorSpan(colors, line, lineOffset);
            }

            @Override
            public EvaluatorException runtimeError(
                String message, String sourceName, int line, String lineSource, int lineOffset) {
              // Handle runtime errors if needed
              return null;
            }
          };
      Parser parser = new Parser(compilerEnvirons, errorReporter);
      String sourceName = "JavaScript";
      try {
        parser.parse(content.toString(), sourceName, 1);
      } catch (EvaluatorException e) {

      }
    }
  }

  public int[] setErrorSpan(TextAnalyzeResult colors, int line, int column) {
    int lineCount = colors.getSpanMap().size();
    int realLine = line - 1;
    List<Span> spans = colors.getSpanMap().get(Math.min(realLine, lineCount - 1));

    int[] end = new int[2];
    end[0] = Math.min(realLine, lineCount - 1);

    if (realLine >= lineCount) {
      Span span = Span.obtain(0, EditorColorScheme.PROBLEM_ERROR);
      span.problemFlags = Span.FLAG_ERROR;
      colors.add(realLine, span);
      end[0]++;
    } else {
      Span last = null;
      for (int i = 0; i < spans.size(); i++) {
        Span span = spans.get(i);
        if (last != null) {
          if (last.column <= column - 1 && span.column >= column - 1) {
            span.problemFlags = Span.FLAG_ERROR;
            last.problemFlags = Span.FLAG_ERROR;
            span.style = EditorColorScheme.PROBLEM_ERROR;
            last.style = EditorColorScheme.PROBLEM_ERROR;
            end[1] = last.column;
            break;
          }
        }
        if (i == spans.size() - 1 && span.column <= column - 1) {
          span.problemFlags = Span.FLAG_ERROR;
          span.style = EditorColorScheme.PROBLEM_ERROR;
          end[1] = span.column;
          break;
        }
        last = span;
      }
    }

    return end;
  }

  public int[] setWaringSpan(TextAnalyzeResult colors, int line, int column) {
    int lineCount = colors.getSpanMap().size();
    int realLine = line - 1;
    List<Span> spans = colors.getSpanMap().get(Math.min(realLine, lineCount - 1));

    int[] end = new int[2];
    end[0] = Math.min(realLine, lineCount - 1);

    if (realLine >= lineCount) {
      Span span = Span.obtain(0, EditorColorScheme.PROBLEM_WARNING);
      span.problemFlags = Span.FLAG_ERROR;
      colors.add(realLine, span);
      end[0]++;
    } else {
      Span last = null;
      for (int i = 0; i < spans.size(); i++) {
        Span span = spans.get(i);
        if (last != null) {
          if (last.column <= column - 1 && span.column >= column - 1) {
            span.problemFlags = Span.FLAG_WARNING;
            last.problemFlags = Span.FLAG_WARNING;
            span.style = EditorColorScheme.PROBLEM_WARNING;
            last.style = EditorColorScheme.PROBLEM_WARNING;
            end[1] = last.column;
            break;
          }
        }
        if (i == spans.size() - 1 && span.column <= column - 1) {
          span.problemFlags = Span.FLAG_WARNING;
          span.style = EditorColorScheme.PROBLEM_WARNING;
          end[1] = span.column;
          break;
        }
        last = span;
      }
    }

    return end;
  }
}
