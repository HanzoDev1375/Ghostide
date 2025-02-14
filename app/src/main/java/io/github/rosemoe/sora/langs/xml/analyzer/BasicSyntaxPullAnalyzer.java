package io.github.rosemoe.sora.langs.xml.analyzer;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.LineNumberCalculator;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

/**
 * Basic syntax analyzer with PULL You can get multiple syntax errors. But only the first one is
 * accurate, and the others are not necessarily accurate Note:If you want '&lt;test&gt;
 * &lt;/test&gt;' but type '&lt;test&gt; /test&gt;'. According to the rules, it will not prompt
 * errors. '/test>' is treated as TEXT.
 */
public class BasicSyntaxPullAnalyzer implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult colors,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      XmlPullParserFactory fact = XmlPullParserFactory.newInstance();
      fact.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
      XmlPullParser xmlPullParser = fact.newPullParser();

      LineNumberCalculator calculator = new LineNumberCalculator(content);
      calculator.update(content.length());
      int errLine = 0;
      int errColumn = 0;
      xmlPullParser.setInput(
          new StringReader(content.toString()) {
            @Override
            public String toString() {
              return "xml";
            }
          });
      xmlPullParser.getEventType();
      while (true) {
        try {
          if (calculator.getLine() + 1 == xmlPullParser.getLineNumber()
              && calculator.getColumn() + 1 == xmlPullParser.getColumnNumber()) {
            break;
          }
          if (xmlPullParser.getEventType() == XmlPullParser.END_DOCUMENT
              && xmlPullParser.getText().contains(">")) {
            xmlPullParser.nextTag();
          } else {
            xmlPullParser.next();
          }
        } catch (XmlPullParserException e) {
          if (errLine == xmlPullParser.getLineNumber()
              && errColumn == xmlPullParser.getColumnNumber()) {
            break;
          }
          errLine = xmlPullParser.getLineNumber();
          errColumn = xmlPullParser.getColumnNumber();
          ///   int[] end = Utils.setErrorSpan(colors, errLine, errColumn);
          Utils.setSpanFlagError(colors, errLine);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
