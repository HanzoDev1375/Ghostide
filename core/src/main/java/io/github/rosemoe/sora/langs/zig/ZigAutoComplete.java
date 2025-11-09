package io.github.rosemoe.sora.langs.zig;

import java.util.ArrayList;
import java.util.List;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.langs.internal.Identifiers;
import io.github.rosemoe.sora.text.TextAnalyzeResult;

public class ZigAutoComplete implements AutoCompleteProvider {

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
    List<CompletionItem> list = new ArrayList<>();
    String[] zigKeywordsAndBuiltins = {
      "align",
      "and",
      "anyframe",
      "anytype",
      "asm",
      "async",
      "await",
      "break",
      "catch",
      "comptime",
      "const",
      "continue",
      "defer",
      "else",
      "enum",
      "errdefer",
      "error",
      "export",
      "extern",
      "fn",
      "for",
      "if",
      "inline",
      "noalias",
      "nosuspend",
      "null",
      "or",
      "orelse",
      "packed",
      "pub",
      "resume",
      "return",
      "linksection",
      "struct",
      "suspend",
      "switch",
      "test",
      "threadlocal",
      "try",
      "undefined",
      "union",
      "unreachable",
      "usingnamespace",
      "var",
      "volatile",
      "while",
      "std",
      "io",
      "mem",
      "fmt",
      "array",
      "arrayList",
      "hash_map",
      "assert",
      "testing",
      "heap",
      "page_allocator",
      "log",
      "debug",
      "warning",
      "err",
      "info"
    };

    for (String kw : zigKeywordsAndBuiltins) {
      if (kw.startsWith(prefix)) {
        list.add(new CompletionItem(kw, "ZigKeyword"));
      }
    }

    Object extra = analyzeResult.getExtra();
    if (extra instanceof Identifiers) {
      Identifiers userIdentifiers = (Identifiers) extra;
      for (String word : userIdentifiers.getIdentifiers()) {
        if (word.startsWith(prefix)) {
          list.add(new CompletionItem(word, "ABC"));
        }
      }
    }

    return list;
  }
}
