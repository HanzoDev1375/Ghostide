package io.github.rosemoe.sora.langs.xml.analyzer;

import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;

import java.util.List;

public class Utils {
  public static int[] setErrorSpan(TextAnalyzeResult colors, int line, int column) {
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
            //    span.style = EditorColorScheme.PROBLEM_ERROR;
            // last.style = EditorColorScheme.PROBLEM_ERROR;
            end[1] = last.column;
            break;
          }
        }
        if (i == spans.size() - 1 && span.column <= column - 1) {
          span.problemFlags = Span.FLAG_ERROR;
          //    span.style = EditorColorScheme.PROBLEM_ERROR;
          end[1] = span.column;
          break;
        }
        last = span;
      }
    }

    return end;
  }

  public static int[] setWaringSpan(TextAnalyzeResult colors, int line, int column) {
    return setWaringSpan(colors, line, column, EditorColorScheme.PROBLEM_WARNING);
  }

  public static int[] setWaringSpan(TextAnalyzeResult colors, int line, int column, int mcolor) {
    int lineCount = colors.getSpanMap().size();
    int realLine = line - 1;
    List<Span> spans = colors.getSpanMap().get(Math.min(realLine, lineCount - 1));

    int[] end = new int[2];
    end[0] = Math.min(realLine, lineCount - 1);

    if (realLine >= lineCount) {
      Span span = Span.obtain(0, mcolor);
      span.problemFlags = Span.FLAG_WARNING;
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
             span.style = mcolor;
             last.style = mcolor;
            end[1] = last.column;
            break;
          }
        }
        if (i == spans.size() - 1 && span.column <= column - 1) {
          span.problemFlags = Span.FLAG_WARNING;
           span.style = mcolor;
          end[1] = span.column;
          break;
        }
        last = span;
      }
    }

    return end;
  }
  
  public static int[]setSpanEFO(TextAnalyzeResult colors, int line, int column, int coloruser){
    return setSpanEFO(colors,line,column,coloruser,false,false);
  }

  public static int[] setSpanEFO(TextAnalyzeResult colors, int line, int column, int coloruser,boolean isbold,boolean isitalic) {
    int lineCount = colors.getSpanMap().size();
    int realLine = line - 1;
    List<Span> spans = colors.getSpanMap().get(Math.min(realLine, lineCount - 1));

    int[] end = new int[2];
    end[0] = Math.min(realLine, lineCount - 1);

    if (realLine >= lineCount) {
      Span span = Span.obtain(0, TextStyle.makeStyle(coloruser,0,isbold,isitalic,false));
      span.problemFlags = 0;
      
      colors.add(realLine, span);
      end[0]++;
    } else {
      Span last = null;
      for (int i = 0; i < spans.size(); i++) {
        Span span = spans.get(i);
        span.setDrawminiText("Test");
        if (last != null) {
          if (last.column <= column - 1 && span.column >= column - 1) {
            span.problemFlags = 0;
            last.problemFlags = 0;
            span.style = coloruser;
            last.style = coloruser;
            end[1] = last.column;
            break;
          }
        }
        if (i == spans.size() - 1 && span.column <= column - 1) {
          span.problemFlags = 0;
          span.style = coloruser;
          end[1] = span.column;
          break;
        }
        last = span;
      }
    }

    return end;
  }

  public static void getSpan(TextAnalyzeResult colors, int line, int column, int color) {
    Span span = Span.obtain(column, TextStyle.makeStyle(color));
    colors.add(line, span);
  }
}
