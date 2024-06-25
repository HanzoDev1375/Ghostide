package Ninja.coder.Ghostemane.code.utils;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HtmlFormatter {

    /**
     * Created by: Ninja coder
     */
    public static String xmlFormat(String xml) {
        try {
            XmlPullParser xpp = XmlPullParserFactory.newInstance().newPullParser();
            StringReader reader = new StringReader(xml);
            xpp.setInput(reader);

            int currentTagPos = xpp.getEventType();
            while (currentTagPos != XmlPullParser.START_DOCUMENT) {
                currentTagPos = xpp.next();
            }
            // accumulated tags
            ArrayList<XmlTagHolder> tags = new ArrayList<>();
            // formated xml string
            StringBuilder sb = new StringBuilder();
            // accumulated indent
            String indent = "";
            // get next tag (current tag is START_DOCUMENT)
            currentTagPos = xpp.next();
            // irritate tags if not END_DOCUMENT
            while (currentTagPos != XmlPullParser.END_DOCUMENT) {
                // reference to the last tag
                int currentTagHolderPos = (tags.size() == 0) ? 0 : tags.size() - 1;
                XmlTagHolder currentTag = (tags.size() == 0) ? null : tags.get(currentTagHolderPos);
                if (currentTagPos == XmlPullParser.END_TAG) {
                    // decrease indent
                    indent = indent.substring(1);
                    // check if current tag has children(s), close it.
                    if (!currentTag.isEmpty && !currentTag.hasText) {
                        sb.append("\n" + currentTag.indent + "</" + currentTag.tagName + ">");
                        //	sb.append("\n" + currentTag.indent + "}" + currentTag.tagName + "{");
                    }
                    // remove last tag from the list
                    tags.remove(currentTagHolderPos);
                } else if (currentTagPos == XmlPullParser.START_TAG) {
                    // get tag properties
                    final String tagName = xpp.getName();
                    final int attrCount = xpp.getAttributeCount();
                    final boolean isEmpty = xpp.isEmptyElementTag();
                    // create new tag holder
                    tags.add(new XmlTagHolder(tagName, attrCount, isEmpty, indent));
                    // append the new tag
                    if (!sb.toString().equals(""))
                        sb.append("\n");
                    sb.append(indent + "<" + tagName);
                    //sb.append(indent + "{" + tagName);
                    indent = indent + "	";
                    // if attributes > 0, create new line and append them
                    if (attrCount > 1) {
                        for (int i = 0; i < attrCount; ++i) {
                            sb.append("\n");
                            final String attrName = xpp.getAttributeName(i);
                            final String attrValue = xpp.getAttributeValue(i);
                            sb.append(indent + attrName + "=\"" + attrValue + "\"");
                        }
                    } else if (attrCount == 1) {
                        sb.append(" ");
                        sb.append(xpp.getAttributeName(0) + "=\"" + xpp.getAttributeValue(0) + "\"");
                    }
                    // close Tag Name properly
                    if (isEmpty) {
                        sb.append("/>");

                    } else
                        sb.append(">");

                } else if (currentTagPos == XmlPullParser.TEXT) {
                    if (!xpp.getText().trim().equals("")) {
                        tags.get(currentTagHolderPos).setHasText();
                        sb.append(xpp.getText());
                        sb.append("</" + tags.get(currentTagHolderPos).tagName + ">");
                        //	sb.append("}" + tags.get(currentTagHolderPos).tagName + "{");
                    }
                } else if (currentTagPos == XmlPullParser.COMMENT) {
                    sb.append("\n");
                    sb.append("<!--" + xpp.getText() + "-->");
                    sb.append("/*" + xpp.getText() + "*/");
                    sb.append("//" + xpp.getText());
                }

                //	Add formater css

                currentTagPos = xpp.next();
            }

            reader.close();
            return sb.toString();
        } catch (Exception e) {
            return xml;
        }
    }

    public static String javaFormat(String text) {
        return formattingProcess(Arrays.stream(text.split("\n")).map(s -> s.trim()).collect(Collectors.joining("\n")));
    }

    /**
     * Credit: Sketchware
     */
    private static void a(StringBuilder content, int indents) {
        for (int i = 0; i < indents; i++) {
            content.append('\t');
        }
    }

    private static String formattingProcess(final String s) {
        final StringBuilder sb = new StringBuilder(4096);
        final char[] charArray = s.toCharArray();
        final int length = charArray.length;
        int i = 0;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        while (i < length) {
            final char c = charArray[i];
            int n10 = 0;
            int n11 = 0;
            Label_0094:
            {
                Label_0082:
                {
                    //n = 1 if it's a one line comment
                    if (n != 0) {
                        if (c == '\n') {
                            sb.append(c);
                            a(sb, n4);
                            n = 0;
                        } else {
                            sb.append(c);
                        }
                    } //check end of multiple lines comment
                    else if (n2 != 0) {
                        if (c == '*') {
                            final int n7 = i + 1;
                            final char c2 = charArray[n7];
                            if (c2 == '/') {
                                sb.append(c);
                                sb.append(c2);
                                n2 = 0;
                                i = n7;
                                break Label_0082;
                            }
                        }
                        sb.append(c);
                        //commit
                        if (c == '\n')
                            a(sb, n4);
                    } else if (n3 != 0) {
                        sb.append(c);
                        n3 = 0;
                    } else if (c == '\\') {
                        sb.append(c);
                        n3 = 1;
                    } else if (n5 != 0) {
                        if (c == '\'') {
                            sb.append(c);
                            n5 = 0;
                        } else {
                            sb.append(c);
                        }
                    } else if (n6 != 0) {
                        if (c == '\"') {
                            sb.append(c);
                            n6 = 0;
                        } else {
                            sb.append(c);
                        }
                    } else {
                        //check start of comments
                        if (c == '/') {
                            final int n8 = i + 1;
                            final char c3 = charArray[n8];
                            //start of one line comment
                            if (c3 == '/') {
                                sb.append(c);
                                sb.append(c3);
                                n = 1;
                                i = n8;
                                break Label_0082;
                            }
                            //start of multiple lines comment
                            if (c3 == '*') {
                                sb.append(c);
                                sb.append(c3);
                                n2 = 1;
                                i = n8;
                                break Label_0082;
                            }
                        }
                        if (c != '\n') {
                            if (c == '\'') {
                                n5 = 1;
                            }
                            int n9;
                            if (c == '\"') {
                                n9 = 1;
                            } else {
                                n9 = n6;
                            }
                            if (c == '{') {
                                ++n4;
                            }
                            n10 = n4;
                            if (c == '}') {
                                n10 = --n4;
                                if (sb.charAt(sb.length() - 1) == '\t') {
                                    sb.deleteCharAt(sb.length() - 1);
                                    n10 = n4;
                                }
                            }
                            sb.append(c);
                            n11 = n9;
                            break Label_0094;
                        }
                        sb.append(c);
                        a(sb, n4);
                    }
                }
                final int n12 = n6;
                n10 = n4;
                n11 = n12;
            }
            ++i;
            final int n13 = n10;
            n6 = n11;
            n4 = n13;
        }
        return sb.toString();
    }

    private static class XmlTagHolder {
        public String tagName;
        public int attrCount;
        public boolean isEmpty;
        public String indent;
        public boolean hasText = false;

        public XmlTagHolder(String name, int count, boolean empty, String ind) {
            tagName = name;
            attrCount = count;
            isEmpty = empty;
            indent = ind;
        }

        public void setHasText() {
            hasText = true;
        }
    }
}
