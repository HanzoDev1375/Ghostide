package io.github.rosemoe.sora.langs.ninjalang.server;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class ServerHot {
  public static String clazz = " ";
  public static String[] imports = {
    "import ninja.os.*",
    "import ninja.os.lang.Compiler.*",
    "public class Main{  \n \n public Test(){} \n}",
    "import ninja.io.File".concat(className(clazz)).trim(),
    "import ninja.List.*",
    "import kt.ktCompat" + "user".concat(clazz),
    "import ninja.python.*"
  };
  public static String[] as = {"from ", "Int", "Double", "Void", "Task", "Sparator"};
  public static String[] color = {"red", "blue", "green"};
  public static String[] keys = {
    "absolute",
    "abstract",
    "all",
    "and",
    "and_then",
    "array",
    "as",
    "asm",
    "attribute",
    "begin",
    "bindable",
    "case",
    "class",
    "const",
    "constructor",
    "destructor",
    "div",
    "do",
    "do",
    "else",
    "end",
    "except",
    "export",
    "exports",
    "external",
    "far",
    "file",
    "finalization",
    "finally",
    "for",
    "forward",
    "goto",
    "if",
    "implementation",
    "import",
    "in",
    "inherited",
    "initialization",
    "interface",
    "interrupt",
    "is",
    "label",
    "library",
    "mod",
    "module",
    "name",
    "near",
    "nil",
    "not",
    "object",
    "of",
    "only",
    "operator",
    "or",
    "or_else",
    "otherwise",
    "packed",
    "pow",
    "private",
    "program",
    "property",
    "protected",
    "public",
    "published",
    "qualified",
    "record",
    "repeat",
    "resident",
    "restricted",
    "segment",
    "set",
    "shl",
    "shr",
    "then",
    "to",
    "try",
    "type",
    "unit",
    "until",
    "uses",
    "value",
    "var",
    "view",
    "virtual",
    "while",
    "with",
    "xor",
    "identifier",
    "msg",
    "praperty",
    "exec",
    "except",
    "baseException",
    "import",
    "from",
    "system",
    "printor",
    "out",
    "cin",
    "cout",
    "lambda",
    "z",
    "qar",
    "var",
    "vel",
    "val",
    "synchronized",
    "int32",
    "int64",
    "extends",
    "sealed",
    "TypeView",
    "void",
    "permits","runAsUi" //runAdUi adding ninja lang 1.2.1
  };

  public static List<String> normalKeyWord() {
    List<String> list = new ArrayList<>();
    for (var user : keys) {
      list.add(user);
    }
    return list;
  }

  public static String className(String key) {
    return key;
  }

  public static int colors(String colors) {
    switch (colors) {
      case "red":
        return Color.RED;
      case "blue":
        return Color.BLUE;
      case "green":
        return Color.GREEN;
      default:
        return 0;
    }
  }
}
