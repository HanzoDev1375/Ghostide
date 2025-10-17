package ir.ninjacoder.ghostide.markdown.langs;

import androidx.annotation.NonNull;
import io.noties.prism4j.Prism4j;

import static io.noties.prism4j.Prism4j.*;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;

public class WebGrammer {

  @NonNull
  public static Prism4j.Grammar create(@NonNull Prism4j prism4j) {
    return grammar(
        "html",
        token("comment", pattern(compile("<!--[\\s\\S]*?-->|(//.*)|(/\\*[\\s\\S]*?\\*/)"))),
        token("doctype", pattern(compile("<!DOCTYPE[^>]+>", CASE_INSENSITIVE))),
        token("cdata", pattern(compile("<!\\[CDATA\\[[\\s\\S]*?\\]\\]>"))),

        // HTML Tags
        token(
            "tag",
            pattern(
                compile(
                    "</?(?!\\d)[^\\s>/$=]+(?:\\s+[^\\s>/=]+(?:\\s*=\\s*(?:\"[^\"]*\"|'[^']*'|[^\\s'\">=]+))?)*\\s*/?>"))),
        token("tag-name", pattern(compile("^</?[^\\s>/$=]+"))),
        token("attr-name", pattern(compile("\\b([\\w-]+)(?=\\s*=)"))),
        token("attr-value", pattern(compile("=\\s*(\"[^\"]*\"|'[^']*'|[^\\s>]+)"))),
        token("entity", pattern(compile("&#?[a-z0-9]+;", CASE_INSENSITIVE))),

        // Strings (برای همه زبان‌ها)
        token("string", pattern(compile("([\"'`])(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"))),

        // JavaScript Keywords
        token(
            "js-keyword",
            pattern(
                compile(
                    "\\b(var|let|const|function|return|if|else|for|while|do|switch|case|break|continue|default|try|catch|finally|throw|new|typeof|instanceof|void|delete|in|of|yield|await|async|export|import|from|as|class|extends|super|this|static)\\b"))),

        // CSS Keywords
        token(
            "css-keyword",
            pattern(
                compile("\\b(!important|url|var|calc|rgb|rgba|hsl|hsla)\\b", CASE_INSENSITIVE))),

        // Common Keywords
        token(
            "keyword",
            pattern(
                compile(
                    "\\b(true|false|null|undefined|import|export|from|as|class|extends|super|this|static)\\b"))),

        // Classes & IDs
        token("class-name", pattern(compile("\\b[A-Z][A-Za-z0-9_]*\\b"))),

        // Booleans & Null
        token("boolean", pattern(compile("\\b(true|false)\\b"))),
        token("null", pattern(compile("\\b(null|undefined)\\b"))),

        // Numbers
        token(
            "number",
            pattern(
                compile(
                    "\\b0x[\\dA-Fa-f]+\\b|(?:\\b\\d+(?:\\.\\d*)?|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?(?:px|em|rem|%|s|ms)?\\b"))),

        // Functions
        token("function", pattern(compile("\\b\\w+(?=\\s*\\()"))),

        // Operators
        token("operator", pattern(compile("--|\\+\\+|&&|\\|\\||>>>?|<<|[-+*/%&|^=!<>]=?|\\?|:"))),

        // Punctuation
        token("punctuation", pattern(compile("[{}\\[\\];(),.:]"))),

        // CSS Selectors
        token("selector", pattern(compile("[^{}\\s][^{}]*(?=\\s*\\{)"))),

        // CSS Properties
        token("property", pattern(compile("\\b([-a-z]+)(?=\\s*:)", CASE_INSENSITIVE))),

        // CSS Important
        token("important", pattern(compile("!important\\b", CASE_INSENSITIVE))),

        // Colors
        token("color", pattern(compile("#[a-f0-9]{3,8}\\b", CASE_INSENSITIVE))),

        // CSS At-rules
        token("at-rule", pattern(compile("@[\\w-]+\\b", CASE_INSENSITIVE))),

        // CSS Units
        token(
            "unit",
            pattern(
                compile(
                    "\\b(px|em|rem|%|vh|vw|vmin|vmax|s|ms|deg|rad|grad|turn)\\b",
                    CASE_INSENSITIVE))));
  }
}
