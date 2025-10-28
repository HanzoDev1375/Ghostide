package lsp4custom.com.ninjacoder.customhtmllsp.lexer;

import io.github.rosemoe.sora.text.TextAnalyzeResult;
import ir.ninjacoder.codesnap.antlr4.kotlin.KotlinLexer;

public class LexerStyleModel {
  /// بعدا روی این کار میکنم مانند کد زیر
  /**
   * fun main(){ val model = 9 println("hello{model}") //مدل باید رنگ جدا بگیره رنگ همان بعد #val }
   */
  public static void makeStyleLexer(
      int line, int col, TextAnalyzeResult result, int pretoken, KotlinLexer lexer) {}
}
