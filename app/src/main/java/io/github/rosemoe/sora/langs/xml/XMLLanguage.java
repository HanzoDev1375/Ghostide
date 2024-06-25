package io.github.rosemoe.sora.langs.xml;

import Ninja.coder.Ghostemane.code.config.JacksonFormatter;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.langs.internal.MyCharacter;
import io.github.rosemoe.sora.text.TextUtils;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLLanguage implements EditorLanguage {
    private final XMLAnalyzer analyzer = new XMLAnalyzer();
    private int tabSize = 4;

    public static String formatXMLString(String unformattedXml) {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document document = builder.parse(new InputSource(new StringReader(unformattedXml)));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.CDATA_SECTION_ELEMENTS, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));

            return writer.toString();
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }

    @Override
    public CodeAnalyzer getAnalyzer() {
        return analyzer;
    }

    @Override
    public int getIndentAdvance(String content) {
        try {
            XMLLexer lexer = new XMLLexer(CharStreams.fromReader(new StringReader(content)));
            Token token;
            int advance = 0;
            while (((token = lexer.nextToken()) != null && token.getType() != token.EOF)) {
                switch (token.getType()) {
                    case XMLLexer.OPEN:
                        //	case XMLLexer.XMLDeclOpen:
                        advance++;
                        break;
                    case XMLLexer.SLASH:
                    case XMLLexer.SLASH_CLOSE:
                        advance--;
                        break;
                }
            }
            advance = Math.max(0, advance);
            return advance * 4;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean useTab() {
        return true;
    }

    @Override
    public AutoCompleteProvider getAutoCompleteProvider() {
        return new XMLAutoComplete();
    }

    public int getTabSize() {
        return useTab() ? tabSize : 1;
    }

    public void setTabSize(int tabSize) {
        this.tabSize = tabSize;
    }

    public boolean isSyntaxCheckEnable() {
        return analyzer.isSyntaxCheckEnable();
    }

    public void setSyntaxCheckEnable(boolean syntaxCheckEnable) {
        analyzer.setSyntaxCheckEnable(syntaxCheckEnable);
    }

    @Override
    public CharSequence format(CharSequence ch) {
        var item = ch.toString();
        JacksonFormatter jformat = new JacksonFormatter();

//    if (item.contains("<vector xmlns:android")) {
//      return formatXMLString(ch.toString());
//    } else if (item.contains("<?xml version")) {
//      Log.e("AndroidXml", "Android Xml not Format code");
//      return jformat.formatXml(item);
//    } else {
//
//    }
        return jformat.formatXml(ch.toString());
    }

    private String formatXml(String xml) {
        Document doc = Jsoup.parse(xml, "", Parser.xmlParser());
        Document.OutputSettings outputSettings = doc.outputSettings();

        outputSettings.syntax(Document.OutputSettings.Syntax.xml);
        outputSettings.indentAmount(2);
        outputSettings.prettyPrint(true);

        return doc.outerHtml();
    }

    @Override
    public boolean isAutoCompleteChar(char ch) {
        // isDigit -> required to complete tags which may contain a number
        // For example -> h1, h2, h3, h4...
        // Better solution?
        return Character.isLetter(ch)
                || Character.isDigit(ch)
                || MyCharacter.isJavaIdentifierPart(ch)
                || ch == '<'
                || ch == '/'
                || ch == ':'
                || ch == '.'
                || ch == '!'
                || ch == '<'
                || ch == '?'
                || ch == '#'
                || ch == '(';
    }

    @Override
    public SymbolPairMatch getSymbolPairs() {
        return new SymbolPairMatch.DefaultSymbolPairs();
    }

    @Override
    public NewlineHandler[] getNewlineHandlers() {
        return new NewlineHandler[]{
                new StartTagHandler(), new EndTagHandler(), new EndTagAttributeHandler()
        };
    }

    private class EndTagHandler implements NewlineHandler {

        @Override
        public boolean matchesRequirement(String beforeText, String afterText) {
            String trim = beforeText.trim();
            if (!trim.startsWith("<")) {
                return false;
            }
            if (!trim.endsWith(">")) {
                return false;
            }
            return afterText.trim().startsWith("</");
        }

        @Override
        public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
            int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
            String middle;
            StringBuilder sb = new StringBuilder();
            sb.append('\n');
            sb.append(TextUtils.createIndent(count + tabSize, tabSize, useTab()));
            sb.append('\n');
            sb.append(middle = TextUtils.createIndent(count, tabSize, useTab()));
            return new HandleResult(sb, middle.length() + 1);
        }
    }

    private class EndTagAttributeHandler implements NewlineHandler {

        @Override
        public boolean matchesRequirement(String beforeText, String afterText) {
            return beforeText.trim().endsWith(">") && afterText.trim().startsWith("</");
        }

        @Override
        public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
            int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
            String middle;
            StringBuilder sb = new StringBuilder();
            sb.append('\n');
            sb.append(TextUtils.createIndent(count, tabSize, useTab()));
            sb.append('\n');
            sb.append(middle = TextUtils.createIndent(count - tabSize, tabSize, useTab()));
            return new HandleResult(sb, middle.length() + 1);
        }
    }

    private class StartTagHandler implements NewlineHandler {

        @Override
        public boolean matchesRequirement(String beforeText, String afterText) {
            String trim = beforeText.trim();
            return trim.startsWith("<") && !trim.endsWith(">");
        }

        @Override
        public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
            int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
            String text;
            StringBuilder sb =
                    new StringBuilder()
                            .append("\n")
                            .append(TextUtils.createIndent(count + tabSize, tabSize, useTab()));
            return new HandleResult(sb, 0);
        }
    }
}
