package lsp4custom.com.ninjacoder.customhtmllsp;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import io.github.rosemoe.sora.data.CompletionItem;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Optional;
import java.util.jar.JarFile;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class CodeSnippet {
  public String jsonPath;

  public CodeSnippet(String jsonPath) {
    this.jsonPath = jsonPath;
  }

  @Deprecated
  public void run(List<CompletionItem> list, String pr) {
    JsonObject jsonObject = JsonParser.parseString(jsonPath).getAsJsonObject();
    Gson gson = new Gson();
    List<CompletionItem> codeSnippets = new ArrayList<>();
    Set<Map.Entry<String, JsonElement>> jsonEntries = jsonObject.entrySet();
    List<CompletionItem> helper =
        jsonEntries.stream()
            .map(
                entry -> {
                  CompletionItem snippet = gson.fromJson(entry.getValue(), CompletionItem.class);
                  JsonObject jsonObj = entry.getValue().getAsJsonObject();
                  snippet.desc = jsonObj.get("description").getAsString();
                  snippet.label = jsonObj.get("prefix").getAsString();
                  snippet.commit = jsonObj.get("body").getAsString();
                  return snippet;
                })
            .collect(Collectors.toList());

    list.addAll(helper);
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
                        // فقط اگر خط شامل placeholder باشد، جایگزینی انجام می‌شود
                        if (lineStr.contains("${")) {
                          lineStr = lineStr.replaceAll("\\$\\{[^}]*:(.*?)\\}", "$1");
                        }
                        bodyBuilder.append(lineStr).append("\n");
                      }
                    }
                    bodyStr = bodyBuilder.toString();
                  } else {
                    bodyStr = bodyElement.getAsString();
                    // فقط اگر متن اصلی شامل placeholder باشد، جایگزینی انجام می‌شود
                    if (bodyStr.contains("${")) {
                      bodyStr = bodyStr.replaceAll("\\$\\{[^}]*:(.*?)\\}", "$1");
                    }
                  }
                  snippet.commit = bodyStr;
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

  //  public static List<CompletionItem> runasList(String language, String prefix) {
  //    String jsonPath = SnippetConfig.getPathForLanguage(language);
  //    if (jsonPath == null) {
  //      return new ArrayList<>();
  //    }
  //
  //    try {
  //      File snippetFile = new File(jsonPath);
  //      JsonObject jsonObject = JsonParser.parseReader(new
  // FileReader(snippetFile)).getAsJsonObject();
  //      Set<Map.Entry<String, JsonElement>> jsonEntries = jsonObject.entrySet();
  //
  //      return jsonEntries.stream()
  //          .map(
  //              entry -> {
  //                JsonObject jsonObj = entry.getValue().getAsJsonObject();
  //                CompletionItem snippet = new CompletionItem();
  //                snippet.desc = jsonObj.get("description").getAsString();
  //                snippet.label = jsonObj.get("prefix").getAsString();
  //                snippet.commit = jsonObj.get("body").getAsString();
  //                return snippet;
  //              })
  //          .filter(item -> item.label.startsWith(prefix))
  //          .collect(Collectors.toList());
  //    } catch (Exception e) {
  //      e.printStackTrace();
  //      return new ArrayList<>();
  //    }
  //  }
  //
  public static List<CompletionItem> analyzeCodeCompletion(
      String jarPath, String code, int cursorPosition) {
    List<CompletionItem> result = new ArrayList<>();

    // استخراج متن قبل از مکان نما (برای تشخیص context)
    String textBeforeCursor = code.substring(0, cursorPosition);

    // اگر آخرین کاراکتر نقطه است (مثل file.)
    if (textBeforeCursor.endsWith(".")) {
      // پیدا کردن نام متغیر قبل از نقطه
      String varName = extractVariableNameBeforeDot(textBeforeCursor);
      String varType = findVariableType(code, varName);

      if (varType != null) {
        result.addAll(getMethodsForClass(jarPath, varType));
      }
    }
    // اگر در حال تایپ کلاس هستیم (مثل new Fil)
    else {
      result.addAll(getClasses(jarPath, textBeforeCursor.trim()));
    }

    return result;
  }

  private static String extractVariableNameBeforeDot(String text) {
    String[] parts = text.split("[^a-zA-Z0-9_]");
    return parts.length > 0 ? parts[parts.length - 1] : "";
  }

  private static String findVariableType(String code, String varName) {

    Pattern pattern = Pattern.compile("\\s+" + varName + "\\s*=\\s*new\\s+(\\w+)");
    Matcher matcher = pattern.matcher(code);
    return matcher.find() ? matcher.group(1) : null;
  }

  private static List<CompletionItem> getMethodsForClass(String jarPath, String className) {
    List<CompletionItem> methods = new ArrayList<>();

    try (JarFile jarFile = new JarFile(new File(jarPath))) {
      Enumeration<JarEntry> entries = jarFile.entries();

      while (entries.hasMoreElements()) {
        JarEntry entry = entries.nextElement();

        if (entry.getName().endsWith(".java")) {
          try (InputStream in = jarFile.getInputStream(entry)) {
            CompilationUnit cu = StaticJavaParser.parse(in);

            cu.findAll(ClassOrInterfaceDeclaration.class).stream()
                .filter(c -> c.getNameAsString().equals(className))
                .findFirst()
                .ifPresent(
                    cls -> {
                      cls.getMethods()
                          .forEach(
                              method -> {
                                CompletionItem item = new CompletionItem();
                                item.commit = method.getNameAsString() + "()";
                                item.desc = "method";
                                item.label = method.getNameAsString();
                                methods.add(item);
                              });
                    });
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return methods;
  }

  private static List<CompletionItem> getClasses(String jarPath, String prefix) {
    List<CompletionItem> classes = new ArrayList<>();

    try (JarFile jarFile = new JarFile(new File(jarPath))) {
      Enumeration<JarEntry> entries = jarFile.entries();

      while (entries.hasMoreElements()) {
        JarEntry entry = entries.nextElement();

        if (entry.getName().endsWith(".java")) {
          try (InputStream in = jarFile.getInputStream(entry)) {
            CompilationUnit cu = StaticJavaParser.parse(in);

            cu.findAll(ClassOrInterfaceDeclaration.class)
                .forEach(
                    cls -> {
                      CompletionItem item = new CompletionItem();
                      item.commit = cls.getNameAsString();
                      item.desc = cls.isInterface() ? "interface" : "class";
                      item.label = cls.getNameAsString();
                      classes.add(item);
                    });
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return classes.stream()
        .filter(item -> item.label.startsWith(prefix))
        .collect(Collectors.toList());
  }
}
