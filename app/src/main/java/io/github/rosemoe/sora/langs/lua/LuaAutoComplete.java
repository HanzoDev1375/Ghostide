package io.github.rosemoe.sora.langs.lua;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.langs.internal.Identifiers;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import java.util.ArrayList;
import java.util.List;

public class LuaAutoComplete implements AutoCompleteProvider {

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
    List<CompletionItem> list = new ArrayList<>();
    String[] builtInFunctions = {
      "print",
      "type",
      "tostring",
      "tonumber",
      "getmetatable",
      "setmetatable",
      "rawget",
      "rawset",
      "rawequal",
      "pairs",
      "ipairs",
      "next",
      "assert",
      "error",
      "pcall",
      "xpcall",
      "select",
      "load",
      "loadstring",
      "loadfile",
      "dofile",
      "require",
      "module",
      "collectgarbage",
      "getfenv",
      "setfenv",
      "string",
      "table",
      "math",
      "io",
      "os",
      "debug",
      "coroutine",
      "package"
    };

    for (String kw : builtInFunctions) {
      if (kw.contains(prefix)) {
        list.add(new CompletionItem(kw, "LuaKeyword"));
      }
    }
    Object extra = analyzeResult.getExtra();
    if (extra instanceof Identifiers) {
      Identifiers userIdentifiers = (Identifiers) extra;
      for (String word : userIdentifiers.getIdentifiers()) {
        if (word.contains(prefix)) {
          list.add(new CompletionItem(word, "ABC"));
        }
      }
    }

    return list;
  }
}
