package ir.ninjacoder.ghostide.markdown.langs;

import androidx.annotation.NonNull;
import io.noties.prism4j.Prism4j;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;
import static io.noties.prism4j.Prism4j.grammar;
import static io.noties.prism4j.Prism4j.pattern;
import static io.noties.prism4j.Prism4j.token;

public class JsonMd {
  @NonNull
  public static Prism4j.Grammar create(@NonNull Prism4j prism4j) {
    return grammar(
        "json",
        token(
            "property",
            pattern(compile("\"(?:\\\\.|[^\\\\\"\\r\\n])*\"(?=\\s*:)", CASE_INSENSITIVE))),
        token("string", pattern(compile("\"(?:\\\\.|[^\\\\\"\\r\\n])*\"(?!\\s*:)"), false, true)),
        token(
            "number",
            pattern(
                compile("\\b0x[\\dA-Fa-f]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?"))),
        token("punctuation", pattern(compile("[{}\\[\\]\\);,]"))),
        token("operator", pattern(compile(":"))),
        token("boolean", pattern(compile("\\b(?:true|false)\\b", CASE_INSENSITIVE))),
        token("null", pattern(compile("\\bnull\\b", CASE_INSENSITIVE))));
  }
}
