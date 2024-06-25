package io.github.rosemoe.sora.widget;

import android.graphics.Color;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HtmlHelper {
    public static String code(String html) {
        switch (html) {
            case "a":
                return "Creates a hyperlink to other web pages, files, locations within the same page, email addresses, or any other URL.";
            case "abbr":
                return "Represents an abbreviation and optionally provides a full description for it.";
            case "address":
                return "Indicates that the enclosed HTML provides contact information for a person or people, or for an organization.";
            case "area":
                return "Defines a hot-spot region on an image, and optionally associates it with a hypertext link.";
            case "article":
                return "Represents a self-contained composition in a document, page, application, or site, which is intended to be independently distributable or reusable (e.";
            case "aside":
                return "Represents a portion of a document whose content is only indirectly related to the document's main content.";
            case "audio":
                return "Used to embed sound content in documents.";
            case "b":
                return "Represents a span of text stylistically different from normal text, without conveying any special importance or relevance, and that is typically rendered in boldface.";
            case "base":
                return "Specifies the base URL to use for all relative URLs contained within a document.";
            case "bdi":
                return "Isolates a span of text that might be formatted in a different direction from other text outside it.";
            case "bdo":
                return "Used to override the current directionality of text.";
            case "big":
                return "The big element is obsolete. Avoid using it and update existing code if possible.";
            case "blockquote":
                return "Indicates that the enclosed text is an extended quotation.";
            case "body":
                return "Represents the content of an HTML document.";
            case "br":
                return "Produces a line break in text (carriage-return).";
            case "button":
                return "Represents a clickable button, which can be used in forms, or anywhere in a document that needs simple, standard button functionality.";
            case "canvas":
                return "Use the HTML canvas element with either the canvas scripting API or the WebGL API to draw graphics and animations.";
            case "caption":
                return "Represents the title of a table.";
            case "cite":
                return "Represents a reference to a creative work.";
            case "code":
                return "Displays its contents styled in a fashion intended to indicate that the text is a short fragment of computer code.";
            case "col":
                return "Defines a column within a table and is used for defining common semantics on all common cells.";
            case "colgroup":
                return "Defines a group of columns within a table.";
            case "command":
                return "The command element is obsolete. Avoid using it and update existing code if possible.";
            case "datalist":
                return "Contains a set of option elements that represent the values available for other controls.";
            case "dd":
                return "Provides the details about or the definition of the preceding term (dt) in a description list (dl).";
            case "del":
                return "Represents a range of text that has been deleted from a document.";
            case "details":
                return "Used as a disclosure widget from which the user can retrieve additional information.";
            case "dfn":
                return "Represents the defining instance of a term.";
            case "dialog":
                return "Represents a dialog box or other interactive component, such as an inspector or window.";
            case "div":
                return "The generic container for flow content and does not inherently represent anything.";
            case "dl":
                return "Represents a description list.";
            case "dt":
                return "Specifies a term in a description or definition list, and as such must be used inside a dl element.";
            case "em":
                return "Marks text that has stress emphasis.";
            case "embed":
                return "Embeds external content at the specified point in the document.";
            case "fieldset":
                return "Used to group several controls as well as labels (label) within a web form.";
            case "figcaption":
                return "Represents a caption or a legend associated with a figure or an illustration described by the rest of the data of the figure element which is its immediate ancestor.";
            case "figure":
                return "Represents self-contained content, frequently with a caption (figcaption), and is typically referenced as a single unit.";
            case "footer":
                return "Represents a footer for its nearest sectioning content or sectioning root element.";
            case "from":
                return "Represents a document section that contains interactive controls to submit information to a web server.";
            case "h1":
                return "The HTML h1 – h6 elements represent six levels of section headings.";
            case "h2":
                return "The HTML h1 – h6 elements represent six levels of section headings.";
            case "h3":
                return "The HTML h1 – h6 elements represent six levels of section headings.";
            case "h4":
                return "The HTML h1 – h6 elements represent six levels of section headings.";
            case "h5":
                return "The HTML h1 – h6 elements represent six levels of section headings.";
            case "h6":
                return "The HTML h1 – h6 elements represent six levels of section headings.";
            case "head":
                return "Provides general information (metadata) about the document, including its title and links to its scripts and style sheets.";
            case "header":
                return "Represents introductory content, typically a group of introductory or navigational aids.";
            case "hgroup":
                return "Represents a multi-level heading for a section of a document.";
            case "hr":
                return "Represents a thematic break between paragraph-level elements (for example, a change of scene in a story, or a shift of topic with a section); historically, this has been presented as a horizontal rule or line.";
            case "html":
                return "Represents the root (top-level element) of an HTML document, so it is also referred to as the root element.";
            case "i":
                return "Represents a range of text that is set off from the normal text for some reason, for example, technical terms, foreign language phrases, or fictional character thoughts.";
            case "iframe":
                return "Represents a nested browsing context, effectively embedding another HTML page into the current page.";
            case "input":
                return "Used to create interactive controls for web-based forms in order to accept data from the user.";
            case "img":
                return "Embeds an image into the document.";
            case "ins":
                return "Represents a range of text that has been added to a document.";
            case "kbd":
                return "Represents user input and produces an inline element displayed in the browser's default monospace font.";
            case "keygen":
                return "The keygen element is deprecated. Avoid using it and update existing code if possible.";
            case "label":
                return "Represents a caption for an item in a user interface.";
            case "legend":
                return "Represents a caption for the content of its parent fieldset.";
            case "li":
                return "Used to represent an item in a list.";
            case "link":
                return "Specifies relationships between the current document and an external resource.";
            case "main":
                return "Represents the main content of the body of a document, portion of a document, or application.";
            case "map":
                return "Used with area elements to define an image map (a clickable link area).";
            case "mark":
                return "Represents highlighted text, i.";
            case "marquee":
                return "The marquee element is obsolete. Avoid using it and update existing code if possible.";
            case "menu":
                return "Represents a group of commands that a user can perform or activate.";
            case "meta":
                return "Represents metadata that cannot be represented by other HTML meta-related elements, like base, link, script, style or title.";
            case "meter":
                return "Represents either a scalar value within a known range or a fractional value.";
            case "nav":
                return "Represents a section of a page whose purpose is to provide navigation links, either within the current document or to other documents.";
            case "noscript":
                return "Defines a section of HTML to be inserted if a script type on the page is unsupported or if scripting is currently turned off in the browser.";
            case "object":
                return "Represents an external resource, which can be treated as an image, a nested browsing context, or a resource to be handled by a plugin.";
            case "ol":
                return "Represents an ordered list of items, typically rendered as a numbered list.";
            case "optgroup":
                return "Creates a grouping of options within a select element.";
            case "option":
                return "Used to define an item contained in a select, an optgroup, or a datalist element.";
            case "output":
                return "Represents the result of a calculation or user action.";
            case "p":
                return "Represents a paragraph of text.";
            case "param":
                return "Defines parameters for an object element.";
            case "pre":
                return "Represents preformatted text which is to be presented exactly as written in the HTML file.";
            case "progress":
                return "Displays an indicator showing the completion progress of a task, typically displayed as a progress bar.";
            case "q":
                return "Indicates that the enclosed text is a short inline quotation.";
            case "rp":
                return "The HTML Ruby Fallback Parenthesis (rp) element is used to provide fall-back parentheses for browsers that do not support display of ruby annotations using the ruby element.";
            case "rt":
                return "The HTML Ruby Text (rt) element specifies the ruby text component of a ruby annotation, which is used to provide pronunciation, translation, or transliteration information for East Asian typography.";
            case "ruby":
                return "Represents a ruby annotation.";
            case "samp":
                return "An element intended to identify sample output from a computer program.";
            case "script":
                return "Used to embed or reference executable code; this is typically used to embed or refer to JavaScript code.";
            case "section":
                return "Represents a standalone section — which doesn't have a more specific semantic element to represent it — contained within an HTML document.";
            case "select":
                return "Represents a control that provides a menu of options:";
            case "small":
                return "Makes the text font size one size smaller (for example, from large to medium, or from small to x-small) down to the browser's minimum font size.";
            case "source":
                return "Specifies multiple media resources for the picture, the audio element, or the video element.";
            case "span":
                return "A generic inline container for phrasing content, which does not inherently represent anything.";
            case "strong":
                return "Gives text strong importance and is typically displayed in bold.";
            case "style":
                return "Contains style information for a document, or part of a document.";
            case "sub":
                return "Defines a span of text that should be displayed, for typographic reasons, lower, and often smaller, than the main span of text.";
            case "summary":
                return "Used as a summary, caption, or legend for the content of a details element.";
            case "sup":
                return "Defines a span of text that should be displayed, for typographic reasons, higher, and often smaller, than the main span of text.";
            case "table":
                return "Represents tabular data — that is, information presented in a two-dimensional table comprised of rows and columns of cells containing data.";
            case "tbody":
                return "Groups one or more tr elements as the body of a table element.";
            case "td":
                return "Defines a cell of a table that contains data.";
            case "template":
                return "A mechanism for holding client-side content that is not to be rendered when a page is loaded but may subsequently be instantiated during runtime using JavaScript.";
            case "textarea":
                return "Represents a multi-line plain-text editing control.";
            case "tfoot":
                return "Defines a set of rows summarizing the columns of the table.";
            case "th":
                return "Defines a cell as header of a group of table cells.";
            case "thead":
                return "Defines a set of rows defining the head of the columns of the table.";
            case "time":
                return "Represents either a time on a 24-hour clock or a precise date in the Gregorian calendar (with optional time and timezone information).";
            case "title":
                return "Defines the title of the document, shown in a browser's title bar or on the page's tab.";
            case "tr":
                return "Specifies that the markup contained inside the tr block comprises one row of a table, inside which the th and td elements create header and data cells, respectively, within the row.";
            case "track":
                return "Used as a child of the media elements audio and video.";
            case "tt":
                return "The tt element is obsolete. Avoid using it and update existing code if possible.";
            case "ul":
                return "Represents an unordered list of items, typically rendered as a bulleted list.";
            case "var":
                return "Represents a variable in a mathematical expression or a programming context.";
            case "video":
                return "Use the HTML video element to embed video content in a document.";
            case "wbr":
                return "Represents a word break opportunity—a position within text where the browser may optionally break a line, though its line-breaking rules would not otherwise create a break at that location.";
            default:
                return "";
        }
    }

    public static Map<String, String> colorsCss() {
        Map<String, String> map = new HashMap<>();
        map.put("aliceblue", "#F0F8FF");
        map.put("black", "#000000");
        return map;
    }

    public static int cssColor(String listColor) {
        switch (listColor) {
            case "aliceblue":
                return Color.parseColor("#F0F8FF");
            case "antiquewhite":
                return Color.parseColor("#FAEBD7");
            case "aquamarine":
                return Color.parseColor("#7FFFD4");
            case "azure":
                return Color.parseColor("#F0FFFF");
            case "beige":
                return Color.parseColor("#F5F5DC");
            case "bisque":
                return Color.parseColor("#FFE4C4");
            case "black":
                return Color.parseColor("#000000");
            case "blanchedalmond":
                return Color.parseColor("#FFEBCD");
            case "blue":
                return Color.parseColor("#FF0062FF");
            case "blueviolet":
                return Color.parseColor("#8A2BE2");
            case "brown":
                return Color.parseColor("#A52A2A");
            case "burlywood":
                return Color.parseColor("#DEB887");
            case "cadetblue":
                return Color.parseColor("#5F9EA0");
            case "chartreuse":
                return Color.parseColor("#7FFF00");
            case "chocolate":
                return Color.parseColor("#D2691E");
            case "coral":
                return Color.parseColor("#FF7F50");
            case "cornflowerblue":
                return Color.parseColor("#6495ED");

            case "cornsilk":
                return Color.parseColor("#FFF8DC");
            case "crimson":
                return Color.parseColor("#DC143C");
            case "cyan":
                return Color.parseColor("#00FFFF");
            case "darkblue":
                return Color.parseColor("#00008B");
            case "darkcyan":
                return Color.parseColor("#008B8B");
            case "darkgoldenrod":
                return Color.parseColor("#B8860B");
            case "darkgrey":
                return Color.parseColor("#A9A9A9");
            case "darkgreen":
                return Color.parseColor("#006400");
            case "darkkhaki":
                return Color.parseColor("#BDB76B");
            case "darkmagenta":
                return Color.parseColor("#8B008B");
            case "darkolivegreen":
                return Color.parseColor("#556B2F");
            case "darkorange":
                return Color.parseColor("#FF8C00");
            case "darkorchid":
                return Color.parseColor("#9932CC");
            case "darkred":
                return Color.parseColor("#8B0000");
            case "darksalmon":
                return Color.parseColor("#E9967A");
            case "darkseagreen":
                return Color.parseColor("#8FBC8F");
            case "darkslateblue":
                return Color.parseColor("#483D8B");
            case "darkslategray":
            case "darkslategrey":
                return Color.parseColor("#2F4F4F");
            case "darkturquoise":
                return Color.parseColor("#00CED1");
            case "darkviolet":
                return Color.parseColor("#9400D3");
            case "deeppink":
                return Color.parseColor("#FF1493");
            case "deepskyblue":
                return Color.parseColor("#00BFFF");
            case "dimgray":
            case "dimgrey":
                return Color.parseColor("#696969");
            case "dodgerblue":
                return Color.parseColor("#1E90FF");
            case "firebrick":
                return Color.parseColor("#B22222");
            case "floralwhite":
                return Color.parseColor("#FFFAF0");
            case "forestgreen":
                return Color.parseColor("#228B22");
            case "fuchsia":
                return Color.parseColor("#FF00FF");
            case "gainsboro":
                return Color.parseColor("#DCDCDC");
            case "ghostwhite":
                return Color.parseColor("#F8F8FF");
            case "gold":
                return Color.parseColor("#FFD700");
            case "goldenrod":
                return Color.parseColor("#DAA520");
            case "grey":
                return Color.parseColor("#808080");
            case "green":
                return Color.parseColor("#008000");
            case "greenyellow":
                return Color.parseColor("#ADFF2F");
            case "honeydew":
                return Color.parseColor("#F0FFF0");
            case "hotpink":
                return Color.parseColor("#FF69B4");
            case "indianred":
                return Color.parseColor("#CD5C5C");
            case "indigo":
                return Color.parseColor("#4B0082");
            case "ivory":
                return Color.parseColor("#FFFFF0");
            case "khaki":
                return Color.parseColor("#F0E68C");
            case "lavender":
                return Color.parseColor("#E6E6FA");
            case "lavenderblush":
                return Color.parseColor("#FFF0F5");
            case "lawngreen":
                return Color.parseColor("#7CFC00");
            case "lemonchiffon":
                return Color.parseColor("#FFFACD");
            case "lightblue":
                return Color.parseColor("#ADD8E6");
            case "lightcoral":
                return Color.parseColor("#F08080");
            case "lightcyan":
                return Color.parseColor("#E0FFFF");
            case "lightgoldenrodyellow":
                return Color.parseColor("#FAFAD2");
            case "lightgray":
            case "lightgrey":
                return Color.parseColor("#D3D3D3");
            case "lightgreen":
                return Color.parseColor("#90EE90");
            case "lightpink":
                return Color.parseColor("#FFB6C1");
            case "lightsalmon":
                return Color.parseColor("#FFA07A");
            case "lightseagreen":
                return Color.parseColor("#20B2AA");
            case "lightskyblue":
                return Color.parseColor("#87CEFA");
            case "lightslategray":
            case "lightslategrey":
                return Color.parseColor("#778899");
            case "lightsteelblue":
                return Color.parseColor("#B0C4DE");
            case "lightyellow":
                return Color.parseColor("#FFFFE0");
            case "lime":
                return Color.parseColor("#00FF00");
            case "limegreen":
                return Color.parseColor("#32CD32");
            case "linen":
                return Color.parseColor("#FAF0E6");
            case "magenta":
                return Color.parseColor("#FF00FF");
            case "maroon":
                return Color.parseColor("#800000");
            case "mediumaquamarine":
                return Color.parseColor("#66CDAA");
            case "mediumblue":
                return Color.parseColor("#0000CD");
            case "mediumorchid":
                return Color.parseColor("#BA55D3");
            case "mediumpurple":
                return Color.parseColor("#9370DB");
            case "mediumseagreen":
                return Color.parseColor("#3CB371");
            case "mediumslateblue":
                return Color.parseColor("#7B68EE");
            case "mediumspringgreen":
                return Color.parseColor("#00FA9A");
            case "mediumturquoise":
                return Color.parseColor("#48D1CC");
            case "mediumvioletred":
                return Color.parseColor("#C71585");
            case "midnightblue":
                return Color.parseColor("#191970");
            case "mintcream":
                return Color.parseColor("#F5FFFA");
            case "mistyrose":
                return Color.parseColor("#FFE4E1");
            case "moccasin":
                return Color.parseColor("#FFE4B5");
            case "navajowhite":
                return Color.parseColor("#FFDEAD");
            case "navy":
                return Color.parseColor("#000080");
            case "oldlace":
                return Color.parseColor("#FDF5E6");
            case "olivedrab":
                return Color.parseColor("#6B8E23");
            case "orange":
                return Color.parseColor("#FFA500");
            case "orangered":
                return Color.parseColor("#FF4500");
            case "orchid":
                return Color.parseColor("#DA70D6");
            case "palegoldenrod":
                return Color.parseColor("#EEE8AA");
            case "palegreen":
                return Color.parseColor("#98FB98");
            case "paleturquoise":
                return Color.parseColor("#AFEEEE");
            case "palevioletred":
                return Color.parseColor("#DB7093");
            case "papayawhip":
                return Color.parseColor("#FFEFD5");
            case "peachpuff":
                return Color.parseColor("#FFDAB9");
            case "peru":
                return Color.parseColor("#CD853F");
            case "pink":
                return Color.parseColor("#FFC0CB");
            case "plum":
                return Color.parseColor("#DDA0DD");
            case "powderblue":
                return Color.parseColor("#B0E0E6");
            case "purple":
                return Color.parseColor("#800080");
            case "rosybrown":
                return Color.parseColor("#BC8F8F");
            case "royalblue":
                return Color.parseColor("#4169E1");
            case "saddlebrown":
                return Color.parseColor("#8B4513");
            case "salmon":
                return Color.parseColor("#FA8072");
            case "sandybrown":
                return Color.parseColor("#F4A460");
            case "seagreen":
                return Color.parseColor("#2E8B57");
            case "seashell":
                return Color.parseColor("#FFF5EE");
            case "sienna":
                return Color.parseColor("#A0522D");
            case "silver":
                return Color.parseColor("#C0C0C0");
            case "skyblue":
                return Color.parseColor("#87CEEB");
            case "slateblue":
                return Color.parseColor("#6A5ACD");
            case "slategrey":
                return Color.parseColor("#708090");
            case "snow":
                return Color.parseColor("#FFFAFA");
            case "springgreen":
                return Color.parseColor("#00FF7F");
            case "steelblue":
                return Color.parseColor("#4682B4");
            case "tan":
                return Color.parseColor("#D2B48C");
            case "teal":
                return Color.parseColor("#008080");
            case "thistle":
                return Color.parseColor("#D8BFD8");
            case "tomato":
                return Color.parseColor("#FF6347");
            case "turquoise":
                return Color.parseColor("#40E0D0");
            case "violet":
                return Color.parseColor("#EE82EE");
            case "wheat":
                return Color.parseColor("#F5DEB3");
            case "white":
                return Color.parseColor("#FFFFFF");
            case "whitesmoke":
                return Color.parseColor("#F5F5F5");
            case "yellow":
                return Color.parseColor("#FFFF00");
            case "yellowgreen":
                return Color.parseColor("#9ACD32");
            case "red":
                return Color.parseColor("#f00000");
            default:
                return Color.parseColor("#00000000");
        }
    }

    public static String getHelpPhp(String str) {
        switch (str) {
            case "echo":
                return "کلمه کلیدی echo برای چاپ متن و مقادیر در صفحه استفاده می‌شود.";
            case "if":
                return "کلمه کلیدی if برای بررسی یک شرط و اجرای بلاک کد مربوطه استفاده می‌شود.";
            case "else":
                return "کلمه کلیدی else برای اجرای کدی در صورتی که شرط if ارائه شده صحیح نباشد، استفاده می‌شود.";
            case "while":
                return "کلمه کلیدی while برای اجرای بلاک کدی تا زمانی که شرط مشخص شده درست باشد، استفاده می‌شود.";
            case "for":
                return "کلمه کلیدی for برای اجرای بلاک کدی بر اساس یک شمارنده و تکرار تعدادی از بارها استفاده می‌شود.";
            case "function":
                return "کلمه کلیدی function برای تعریف یک تابع در PHP استفاده می‌شود.";
            case "if-else":
                return "کلمه کلیدی if-else برای اجرای بلاک کدی در صورتی که شرط if ارائه شده صحیح نباشد و همچنین در صورتی که شرط else ارائه شده صحیح نباشد، استفاده می‌شود.";
            case "switch":
                return "کلمه کلیدی switch برای ایجاد یک بخش بررسی چند وضعیتی استفاده می‌شود.";
            case "return":
                return "کلمه کلیدی return برای بازگشت یک مقدار از تابع استفاده می‌شود.";
            case "break":
                return "کلمه کلیدی break برای خروج از یک حلقه یا سوییچ استفاده می‌شود.";
            case "continue":
                return "کلمه کلیدی continue برای ادامه اجرای حلقه استفاده می‌شود و به تکرار بعدی می‌رود.";
            case "foreach":
                return "کلمه کلیدی foreach برای تکرار و پیمایش اجزای یک آرایه یا شیء استفاده می‌شود.";
            case "class":
                return "کلمه کلیدی class برای تعریف یک کلاس در PHP استفاده می‌شود.";
            case "new":
                return "کلمه کلیدی new برای ایجاد یک شیء از یک کلاس مشخص استفاده می‌شود.";
            case "private":
                return "کلمه کلیدی private برای تعیین دسترسی خصوصی به عناصر کلاس استفاده می‌شود.";
            case "public":
                return "کلمه کلیدی public برای تعیین دسترسی عمومی به عناصر کلاس استفاده می‌شود.";
            // دیگر کلمات کلیدی...
            default:
                return "ناشناخته";
        }
    }

    public static int ColorRandomUtils() {
        Random random = new Random();
        return Color.rgb(random.nextInt(252), random.nextInt(240), random.nextInt(255));
    }
}
