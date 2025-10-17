package ir.ninjacoder.ghostide.markdown.langs;

import androidx.annotation.NonNull;
import io.noties.prism4j.Prism4j;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;
import static io.noties.prism4j.Prism4j.*;

public class CssGrammar {

  @NonNull
  public static Prism4j.Grammar create(@NonNull Prism4j prism4j) {
    return grammar(
        "css",
        token("comment", pattern(compile("(//.*)|(/\\*[\\s\\S]*?\\*/)"), true)),
        token("selector", pattern(compile("[^{}\\s][^{}]*(?=\\s*\\{)"))),
        token("property", pattern(compile("[-_a-z][-_a-z0-9]*(?=\\s*:)", CASE_INSENSITIVE))),
        token(
            "string",
            pattern(
                compile("(\")(?:\\\\.|[^\\\\\"\\r\\n])*?(\")|(')(?:\\\\.|[^\\\\'\\r\\n])*?(')"),
                true,
                true)),
        token("important", pattern(compile("!important\\b", CASE_INSENSITIVE))),
        token("punctuation", pattern(compile("[{}();:,]"))),
        token("number", pattern(compile("\\b\\d+(?:\\.\\d+)?(?:%|[a-z]+)?\\b", CASE_INSENSITIVE))),
        token("color", pattern(compile("#[a-f0-9]+\\b", CASE_INSENSITIVE))),
        token("function", pattern(compile("[-a-z0-9]+(?=\\()", CASE_INSENSITIVE))),
        token("atrule", pattern(compile("@[^;\\s]+(?:\\s+[^;\\s]+)?(?=\\s*\\{)"))),
        token(
            "url",
            pattern(compile("url\\((?:\"([^\"]*)\"|'([^']*)'|([^\"')]))\\)", CASE_INSENSITIVE))));
  }
}
