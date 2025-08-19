package lsp4custom.com.ninjacoder.customhtmllsp;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.rosemoe.sora.data.CompletionItem;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.util.Optional;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CodeSnippet {
  public String jsonPath;

  public CodeSnippet(String jsonPath) {
    this.jsonPath = jsonPath;
  }

  public static List<CompletionItem> getJar(String pre) {
    List<CompletionItem> completionItems = new ArrayList<>();

    try {
      var input = GhostIdeAppLoader.getContext().getAssets().open("class_info.json");
      JsonArray jsonArray = JsonParser.parseReader(new InputStreamReader(input)).getAsJsonArray();

      for (JsonElement element : jsonArray) {
        JsonObject jsonObj = element.getAsJsonObject();
        CompletionItem item = new CompletionItem();
        item.label = jsonObj.get("class_name").getAsString();
        item.desc = jsonObj.get("full_package").getAsString();
        item.commit = jsonObj.get("class_name").getAsString();
        completionItems.add(item);
      }
      if (pre != null && !pre.isEmpty()) {
        completionItems =
            completionItems.stream()
                .filter(item -> item.label.startsWith(pre))
                .collect(Collectors.toList());
      }

      return completionItems;

    } catch (Exception err) {
      err.printStackTrace();
      return new ArrayList<>();
    }
  }

  public static List<CompletionItem> getPythonMethod(String pre) {
    List<CompletionItem> completionItems = new ArrayList<>();

    try {
      var input = GhostIdeAppLoader.getContext().getAssets().open("methods.json");
      JsonArray jsonArray = JsonParser.parseReader(new InputStreamReader(input)).getAsJsonArray();

      for (JsonElement element : jsonArray) {
        JsonObject jsonObj = element.getAsJsonObject();
        CompletionItem item = new CompletionItem();
        item.label = jsonObj.get("name").getAsString();
        item.desc = jsonObj.get("doc").getAsString();
        item.commit = jsonObj.get("name").getAsString();
        completionItems.add(item);
      }
      if (pre != null && !pre.isEmpty()) {
        completionItems =
            completionItems.stream()
                .filter(item -> item.label.startsWith(pre))
                .collect(Collectors.toList());
      }

      return completionItems;

    } catch (Exception err) {
      err.printStackTrace();
      return new ArrayList<>();
    }
  }

  public static List<CompletionItem> getCssShortcuts(String pre) {
    List<CompletionItem> results = new ArrayList<>();

    try {
      InputStream input = GhostIdeAppLoader.getContext().getAssets().open("shortcss.json");
      JsonArray jsonArray = JsonParser.parseReader(new InputStreamReader(input)).getAsJsonArray();
      Map<String, String> shortcutMap = new HashMap<>();
      for (JsonElement element : jsonArray) {
        JsonObject obj = element.getAsJsonObject();
        String key = obj.get("csskey").getAsString().trim();
        String value = obj.get("cssvalue").getAsString().trim();
        shortcutMap.put(key, value);
      }

      // پردازش ورودی مثل "pos:f+pos:a"
      if (pre != null && !pre.isEmpty()) {
        String[] keys = pre.split("\\+");
        StringBuilder combinedCss = new StringBuilder();

        for (String key : keys) {
          if (shortcutMap.containsKey(key.trim())) {
            combinedCss.append(shortcutMap.get(key.trim()));
          }
        }
        if (combinedCss.length() > 0) {
          CompletionItem item =
              new CompletionItem(combinedCss.toString(), "CssShort", combinedCss.toString());
          item.cursorOffset(item.commit.length() - 1);
          results.add(item);
        }
      }

      return results;

    } catch (Exception e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  public static List<CompletionItem> runasList(String language, String prefix) {
    String jsonPath = SnippetConfig.getPathForLanguage(language);
    if (jsonPath == null) {
      return new ArrayList<>();
    }

    try {
      File snippetFile = new File(jsonPath);
      JsonObject jsonObject = JsonParser.parseReader(new FileReader(snippetFile)).getAsJsonObject();
      Set<Map.Entry<String, JsonElement>> jsonEntries = jsonObject.entrySet();

      return jsonEntries.stream()
          .map(
              entry -> {
                JsonObject jsonObj = entry.getValue().getAsJsonObject();
                CompletionItem snippet = new CompletionItem();
                snippet.desc = jsonObj.get("description").getAsString();
                snippet.label = jsonObj.get("prefix").getAsString();

                JsonElement bodyElement = jsonObj.get("body");
                if (bodyElement != null && !bodyElement.isJsonNull()) {
                  String bodyStr;
                  if (bodyElement.isJsonArray()) {
                    JsonArray bodyArray = bodyElement.getAsJsonArray();
                    StringBuilder bodyBuilder = new StringBuilder();
                    for (JsonElement line : bodyArray) {
                      if (!line.isJsonNull()) {
                        String lineStr = line.getAsString();
                       
                        if (lineStr.contains("${")) {
                          lineStr = lineStr.replaceAll("\\$\\{[^}]*:(.*?)\\}", "$1");
                        }
                        bodyBuilder.append(lineStr).append("\n");
                      }
                    }
                    bodyStr = bodyBuilder.toString();
                  } else {
                    bodyStr = bodyElement.getAsString();
                    if (bodyStr.contains("${")) {
                      bodyStr = bodyStr.replaceAll("\\$\\{[^}]*:(.*?)\\}", "$1");
                    }
                  }
                  snippet.commit = bodyStr;
                  snippet.cursorOffset(snippet.commit.length() - 1);
                } else {
                  snippet.commit = "";
                }

                return snippet;
              })
          .filter(item -> item.label.startsWith(prefix))
          .collect(Collectors.toList());
    } catch (Exception e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  public static void configureSymbolSolver(String sourcePath) {
    TypeSolver typeSolver =
        new CombinedTypeSolver(
            new ReflectionTypeSolver(), new JavaParserTypeSolver(new File(sourcePath)));
    JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);
    StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);
  }

  public static List<CompletionItem> analyzeCodeCompletion(String sourcePath, String userCode) {
    List<CompletionItem> result = new ArrayList<>();

    if (userCode == null || userCode.isEmpty() || sourcePath == null) {
      return result;
    }

    try {
      // تنظیم SymbolSolver
      CombinedTypeSolver typeSolver = new CombinedTypeSolver();
      typeSolver.add(new ReflectionTypeSolver());
      typeSolver.add(new JavaParserTypeSolver(new File(sourcePath)));
      JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);
      ParserConfiguration config = new ParserConfiguration().setSymbolResolver(symbolSolver);
      JavaParser parser = new JavaParser(config);

      int lastDot = userCode.lastIndexOf(".");
      if (lastDot > 0) {
        String varExpr = userCode.substring(0, lastDot).trim();
        String fakeCode =
            "import java.io.*;\n"
                + "public class Dummy {\n"
                + "    public void test() {\n"
                + "        File file = new File(\"\");\n"
                + "        "
                + varExpr
                + ";\n"
                + // فقط برای parse شدن
                "    }\n"
                + "}";

        Optional<CompilationUnit> cuOpt = parser.parse(fakeCode).getResult();
        if (cuOpt.isEmpty()) return result;

        CompilationUnit cu = cuOpt.get();
        Optional<VariableDeclarator> varOpt =
            cu.findAll(VariableDeclarator.class).stream()
                .filter(v -> varExpr.contains(v.getNameAsString()))
                .findFirst();

        if (varOpt.isPresent()) {
          ResolvedType type = varOpt.get().resolve().getType();
          String fullClass = type.describe(); // مثلا java.io.File
          result.addAll(getMethodsForClassFromSourceSafe(sourcePath, fullClass, parser));
        }
      } else {
        // وقتی فقط prefix کلاس هست مثلاً: "Str"
        String[] words = userCode.split("[^a-zA-Z0-9_]");
        String prefix = words.length > 0 ? words[words.length - 1] : "";
        if (!prefix.isEmpty()) {
          result.addAll(getClassesSafe(sourcePath, prefix, parser));
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return result;
  }

  private static String resolveVariableTypeWithSymbolSolver(String code, String varName) {
    try {
      CompilationUnit cu = StaticJavaParser.parse(code);
      Optional<VariableDeclarator> varOpt =
          cu.findAll(VariableDeclarator.class).stream()
              .filter(v -> v.getNameAsString().equals(varName))
              .findFirst();

      if (varOpt.isPresent()) {
        ResolvedType type = varOpt.get().resolve().getType();
        return type.describe(); // مثل: java.io.File
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private static String extractVariableNameBeforeDot(String text) {
    String[] parts = text.split("[^a-zA-Z0-9_]");
    return parts.length > 0 ? parts[parts.length - 1] : "";
  }

  public static List<CompletionItem> getListFile(String currentPath, String prefix) {
    return PathCompleter.getPathCompletions(currentPath, prefix);
  }

  private static List<CompletionItem> getMethodsForClassFromSourceSafe(
      String sourcePath, String fqcn, JavaParser parser) {
    List<CompletionItem> methods = new ArrayList<>();
    String className = fqcn.substring(fqcn.lastIndexOf('.') + 1);

    File dir = new File(sourcePath);
    File[] javaFiles = dir.listFiles((d, name) -> name.endsWith(".java"));

    if (javaFiles == null) return methods;

    for (File file : javaFiles) {
      try {
        Optional<CompilationUnit> cuOpt = parser.parse(file).getResult();
        if (cuOpt.isEmpty()) continue;

        CompilationUnit cu = cuOpt.get();

        cu.findAll(ClassOrInterfaceDeclaration.class).stream()
            .filter(c -> c.getNameAsString().equals(className))
            .findFirst()
            .ifPresent(
                c ->
                    c.getMethods()
                        .forEach(
                            method -> {
                              CompletionItem item = new CompletionItem();
                              item.label = method.getNameAsString();
                              item.commit = method.getNameAsString() + "()";
                              item.desc = "method";
                              methods.add(item);
                            }));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return methods;
  }

  private static List<CompletionItem> getClassesSafe(
      String sourcePath, String prefix, JavaParser parser) {
    List<CompletionItem> classes = new ArrayList<>();

    File dir = new File(sourcePath);
    File[] javaFiles = dir.listFiles((d, name) -> name.endsWith(".java"));

    if (javaFiles == null) return classes;

    for (File file : javaFiles) {
      try {
        Optional<CompilationUnit> cuOpt = parser.parse(file).getResult();
        if (cuOpt.isEmpty()) continue;

        CompilationUnit cu = cuOpt.get();

        cu.findAll(ClassOrInterfaceDeclaration.class)
            .forEach(
                cls -> {
                  CompletionItem item = new CompletionItem();
                  item.commit = cls.getNameAsString();
                  item.desc = cls.isInterface() ? "interface" : "class";
                  item.label = cls.getNameAsString();
                  classes.add(item);
                });

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return classes.stream()
        .filter(item -> item.label.startsWith(prefix))
        .collect(Collectors.toList());
  }

  public static List<CompletionItem> getPhpLsp(String sub) {
    return PhpFun.getLspPhp(sub);
  }
}
