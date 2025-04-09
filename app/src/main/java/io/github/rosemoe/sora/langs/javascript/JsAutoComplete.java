package io.github.rosemoe.sora.langs.javascript;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.text.TextAnalyzeResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import lsp4custom.com.ninjacoder.customhtmllsp.CodeSnippet;

public class JsAutoComplete implements AutoCompleteProvider {

  private String[] mKeywords;
  private boolean mKeywordsAreLowCase;

  public void setKeywords(String[] keywords) {
    mKeywords = keywords;
    mKeywordsAreLowCase = false;
  }

  @Override
  public List<CompletionItem> getAutoCompleteItems(
      String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
    List<CompletionItem> keywords = new ArrayList<>();
    final String[] keywordArray = mKeywords;
    final boolean lowCase = mKeywordsAreLowCase;

    String match = prefix;
    if (keywordArray != null) {
      for (String kw : keywordArray) {
        if (kw.startsWith(match)) {
          keywords.add(new CompletionItem(kw, "Js key"));
        }
      }
    }
    Collections.sort(keywords, CompletionItem.COMPARATOR_BY_NAME);
    Object extra = analyzeResult.getExtra();
    Identifiers userIdentifiers = (extra instanceof Identifiers) ? (Identifiers) extra : null;
    if (userIdentifiers != null) {
      List<CompletionItem> words = new ArrayList<>();
      for (String word : userIdentifiers.getIdentifiers()) {
        if (word.startsWith(match)) {
          words.add(new CompletionItem(word, "Identifier"));
        }
      }
      Collections.sort(words, CompletionItem.COMPARATOR_BY_NAME);
      String run =
          """
    {
        "consoleLog": {
            "description": "Console log",
            "prefix": "cl",
            "body": "console.log('message');"
        },
        "function": {
            "description": "Regular function",
            "prefix": "fn",
            "body": "function name() {\\n  // code here\\n}"
        },
        "arrowFunction": {
            "description": "Arrow function",
            "prefix": "af",
            "body": "const name = () => {\\n  // code here\\n};"
        },
        "ifStatement": {
            "description": "If statement",
            "prefix": "if",
            "body": "if (condition) {\\n  // code here\\n}"
        },
        "ifElse": {
            "description": "If-else statement",
            "prefix": "ife",
            "body": "if (condition) {\\n  // code if true\\n} else {\\n  // code if false\\n}"
        },
        "forLoop": {
            "description": "For loop",
            "prefix": "for",
            "body": "for (let i = 0; i < length; i++) {\\n  // code here\\n}"
        },
        "forEachLoop": {
            "description": "ForEach loop",
            "prefix": "fe",
            "body": "array.forEach(item => {\\n  // code here\\n});"
        },
        "whileLoop": {
            "description": "While loop",
            "prefix": "while",
            "body": "while (condition) {\\n  // code here\\n}"
        },
        "tryCatch": {
            "description": "Try-catch block",
            "prefix": "try",
            "body": "try {\\n  // code here\\n} catch (error) {\\n  console.error(error);\\n}"
        },
        "setTimeout": {
            "description": "Set timeout",
            "prefix": "st",
            "body": "setTimeout(() => {\\n  // code here\\n}, delay);"
        },
        "setInterval": {
            "description": "Set interval",
            "prefix": "si",
            "body": "setInterval(() => {\\n  // code here\\n}, interval);"
        },
        "eventListener": {
            "description": "Event listener",
            "prefix": "el",
            "body": "element.addEventListener('event', () => {\\n  // code here\\n});"
        },
        "ajaxGet": {
            "description": "AJAX GET request",
            "prefix": "ajax",
            "body": "fetch('url')\\n  .then(response => response.json())\\n  .then(data => console.log(data))\\n  .catch(error => console.error(error));"
        },
        "class": {
            "description": "JavaScript class",
            "prefix": "class",
            "body": "class ClassName {\\n  constructor() {\\n    // code here\\n  }\\n  \\n  methodName() {\\n    // code here\\n  }\\n}"
        },
        "export": {
            "description": "Export module",
            "prefix": "exp",
            "body": "export default name;"
        },
        "import": {
            "description": "Import module",
            "prefix": "imp",
            "body": "import name from 'module';"
        },
        "promise": {
            "description": "Promise",
            "prefix": "prom",
            "body": "new Promise((resolve, reject) => {\\n  // code here\\n  if (success) {\\n    resolve(value);\\n  } else {\\n    reject(error);\\n  }\\n});"
        },
        "asyncFunction": {
            "description": "Async function",
            "prefix": "async",
            "body": "async function name() {\\n  try {\\n    const result = await someAsyncCall();\\n    return result;\\n  } catch (error) {\\n    console.error(error);\\n  }\\n}"
        },
        "object": {
            "description": "Object literal",
            "prefix": "obj",
            "body": "const objectName = {\\n  property1: value1,\\n  property2: value2,\\n  method1() {\\n    // code here\\n  }\\n};"
        },
        "arrayMethods": {
            "description": "Common array methods",
            "prefix": "arr",
            "body": "// map\\nconst newArray = array.map(item => item.property);\\n\\n// filter\\nconst filteredArray = array.filter(item => item.condition);\\n\\n// reduce\\nconst total = array.reduce((sum, item) => sum + item.value, 0);"
        }
    }
    """;
      keywords.addAll(CodeSnippet.runasList(prefix, run));
      keywords.addAll(words);
    }
    return keywords;
  }

  public static class Identifiers {

    private static final Object SIGN = new Object();
    private final List<String> identifiers = new ArrayList<>();
    private HashMap<String, Object> cache;

    public void addIdentifier(String identifier) {
      if (cache == null) {
        throw new IllegalStateException("begin() has not been called");
      }
      if (cache.put(identifier, SIGN) == SIGN) {
        return;
      }
      identifiers.add(identifier);
    }

    public void begin() {
      cache = new HashMap<>();
    }

    public void finish() {
      cache.clear();
      cache = null;
    }

    public List<String> getIdentifiers() {
      return identifiers;
    }
  }
}
