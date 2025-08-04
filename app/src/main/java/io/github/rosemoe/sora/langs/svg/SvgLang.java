package io.github.rosemoe.sora.langs.svg;

import com.ninjacoder.jgit.childer.CharParser;
import io.github.rosemoe.sora.langs.html.HTMLLexer;
import ir.ninjacoder.ghostide.IdeEditor;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.langs.html.HTMLAnalyzerCompat;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import java.io.StringReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Parser;

public class SvgLang implements EditorLanguage {

  private IdeEditor editor;

  public SvgLang(IdeEditor editor) {
    this.editor = editor;
  }

  @Override
  public CharSequence format(CharSequence text) {
    return formatSvg(text.toString());
  }

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new HTMLAnalyzerCompat(editor);
  }

  @Override
  public AutoCompleteProvider getAutoCompleteProvider() {
    return null;
  }

  @Override
  public int getIndentAdvance(String content) {
    try {
      HTMLLexer lexer = new HTMLLexer(CharStreams.fromReader(new StringReader(content)));
      Token token;
      int advance = 0;
      while (((token = lexer.nextToken()) != null && token.getType() != token.EOF)) {
        switch (token.getType()) {
          case HTMLLexer.LBRACE:
            advance++;
            break;
        }
      }
      advance = Math.max(0, advance);
      return advance * 2;
    } catch (Throwable e) {

    }
    return 0;
  }

  @Override
  public NewlineHandler[] getNewlineHandlers() {
    return null;
  }

  @Override
  public SymbolPairMatch getSymbolPairs() {
    return new SymbolPairMatch.DefaultSymbolPairs();
  }

  @Override
  public boolean isAutoCompleteChar(char ch) {
    return CharParser.parserChar(ch);
  }

  @Override
  public boolean useTab() {
    return true;
  }

  private String formatSvg(String html) {
    Document doc = Jsoup.parse(html, "", Parser.xmlParser());
    Document.OutputSettings settings = new Document.OutputSettings();
    settings.prettyPrint(true);
    settings.indentAmount(2);
    settings.escapeMode(Entities.EscapeMode.xhtml);
    settings.syntax(Document.OutputSettings.Syntax.xml);
    doc.outputSettings(settings);
    var svg = doc.selectFirst("svg");
    if (svg != null) {
      return svg.outerHtml();
    }
    return html;
  }
}
