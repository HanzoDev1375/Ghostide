package io.github.rosemoe.sora.langs.kotlin.jum;

import java.util.Arrays;

public class KtJu {

  public static boolean isStaticKtAttr(String text) {
    return text.equals("let")
        || text.equals("apply")
        || text.equals("aslo")
        || text.equals("using");
  }

  public static boolean isKtAttr(String text) {
    return text.equals("launch") || text.equals("run");
  }

  public static boolean ktStd(String text) {
    String[] ktStdFunctions = {
      "arrayOf", "listOf", "mutableListOf", "mutableMapOf",
      "setOf", "mutableSetOf", "mapOf", "emptyList",
      "emptySet", "emptyMap", "sequenceOf"
    };
    return Arrays.asList(ktStdFunctions).contains(text);
  }

  public static boolean ktcoroutine(String text) {
    String[] ktCoroutine = {
      "delay", "withContext", "async", "coroutineScope", "supervisorScope", "runBlocking", "launch"
    };
    return Arrays.asList(ktCoroutine).contains(text);
  }
}
