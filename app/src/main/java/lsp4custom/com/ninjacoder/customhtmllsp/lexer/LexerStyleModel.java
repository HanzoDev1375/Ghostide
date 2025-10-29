package lsp4custom.com.ninjacoder.customhtmllsp.lexer;

import io.github.rosemoe.sora.langs.internal.CodeHighlighter;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import io.github.rosemoe.sora.langs.kotlin.jum.KotlinLexer;

public class LexerStyleModel {
  /// بعدا روی این کار میکنم مانند کد زیر
  /**
   * fun main(){ val model = 9 println("hello{model}") //مدل باید رنگ جدا بگیره رنگ همان بعد #val }
   */
  public static void makeStyleLexer(
      int line, int col, TextAnalyzeResult result, int pretoken, KotlinLexer lexer, String code) {
    var normalcolor = EditorColorScheme.jsfun;
    if (pretoken == KotlinLexer.VAL
        || pretoken == KotlinLexer.VAR
        || pretoken == KotlinLexer.VARARG) {
      normalcolor = EditorColorScheme.javatype;
    } else if (lexer._input.LA(2) == ':') {
      normalcolor = EditorColorScheme.tscolormatch1;
    }
    CodeHighlighter.highlightFStringkt(code, line, col, result, normalcolor);
  }
}
