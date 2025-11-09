package io.github.rosemoe.sora.langs.markdown;

import android.util.Log;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class MarkDownCodeAnalyzer implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      var lexer = new MarkdownLexer(stream);

      Token token;
      int lastLine = 1;

      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null || token.getType() == MarkdownLexer.EOF) {
          lastLine = token != null ? token.getLine() - 1 : lastLine;
          break;
        }

        int line = token.getLine() - 1;
        int column = token.getCharPositionInLine();
        String text = token.getText();

        // Skip whitespace and line breaks
        if (token.getType() == MarkdownLexer.WHITESPACE
            || token.getType() == MarkdownLexer.LINE_BREAK) {
          result.addNormalIfNull();
          continue;
        }

        // Apply coloring based on token type
        switch (token.getType()) {
            // Headings
          case MarkdownLexer.H1:
          case MarkdownLexer.H2:
          case MarkdownLexer.H3:
          case MarkdownLexer.H4:
          case MarkdownLexer.H5:
          case MarkdownLexer.H6:
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_NAME);
            break;

            // Code blocks and inline code
          case MarkdownLexer.CODE_BLOCK:
          case MarkdownLexer.INLINE_CODE:
          case MarkdownLexer.CODE_BLOCK_CONTENT:
          case MarkdownLexer.INLINE_CODE_CONTENT:
            result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
            break;

            // Lists
          case MarkdownLexer.ORDERED_LIST:
          case MarkdownLexer.UNORDERED_LIST:
          case MarkdownLexer.TASK_LIST:
          case MarkdownLexer.TASK_LIST_DONE:
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            break;

            // Links and images
          case MarkdownLexer.L_BRACKET:
          case MarkdownLexer.R_BRACKET:
          case MarkdownLexer.L_PAREN:
          case MarkdownLexer.R_PAREN:
          case MarkdownLexer.BANG:
            result.addIfNeeded(line, column, EditorColorScheme.FUNCTION_NAME);
            break;

          case MarkdownLexer.URL:
          case MarkdownLexer.AUTO_URL:
            result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
            break;

            // Formatting
          case MarkdownLexer.BOLD:
          case MarkdownLexer.ITALIC:
          case MarkdownLexer.STRIKETHROUGH:
            result.addIfNeeded(line, column, EditorColorScheme.javafield);
            break;

            // HTML
          case MarkdownLexer.HTML_TAG_OPEN:
          case MarkdownLexer.HTML_TAG_NAME:
          case MarkdownLexer.HTML_TAG_CLOSE:
            result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
            break;

          case MarkdownLexer.HTML_ATTRIBUTE_NAME:
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_NAME);
            break;

          case MarkdownLexer.HTML_ATTRIBUTE_VALUE:
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
            break;

            // Tables
          case MarkdownLexer.PIPE:
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            break;

            // Blockquotes
          case MarkdownLexer.BLOCKQUOTE:
          
            result.addIfNeeded(line, column, EditorColorScheme.javafield);
            break;

            // Horizontal rule
          case MarkdownLexer.HR:
            result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
            break;

            // Default text
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
        }
      }

      result.determine(lastLine);

    } catch (IOException e) {
      e.printStackTrace();
      Log.e("MarkdownAnalyzer", "Error analyzing markdown: " + e.getMessage());
    }
  }
}
