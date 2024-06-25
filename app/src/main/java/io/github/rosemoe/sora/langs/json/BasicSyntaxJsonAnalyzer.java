package io.github.rosemoe.sora.langs.json;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.LineNumberCalculator;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Basic syntax analyzer with Gson You can get multiple syntax errors. But only the first one is
 * accurate, and the others are not necessarily accurate
 */
public class BasicSyntaxJsonAnalyzer implements CodeAnalyzer {
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
          if (
              xmlPullParser.getText().contains("{") && xmlPullParser.getText().contains("}") ) {
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
          int[] end = Utils.setErrorSpan(colors, errLine, errColumn);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
