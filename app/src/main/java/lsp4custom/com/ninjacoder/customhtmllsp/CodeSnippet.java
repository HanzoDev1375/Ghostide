package lsp4custom.com.ninjacoder.customhtmllsp;

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
import com.google.gson.Gson;
import io.github.rosemoe.sora.data.CompletionItem;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

  public static List<CompletionItem> getJar(String pre) {
    List<CompletionItem> completionItems = new ArrayList<>();

    try {
      var input = GhostIdeAppLoader.getContext().getAssets().open("class_info.json");
      JsonArray jsonArray = JsonParser.parseReader(new InputStreamReader(input)).getAsJsonArray();

      for (JsonElement element : jsonArray) {
        JsonObject jsonObj = element.getAsJsonObject();
        CompletionItem item = new CompletionItem();
        // تنظیم label با نام کلاس
        item.label = jsonObj.get("class_name").getAsString();
        // تنظیم desc با نام کامل پکیج
        item.desc = jsonObj.get("full_package").getAsString();
        // تنظیم commitبا نام کلاس (می‌توانید این را تغییر دهید)
        item.commit = jsonObj.get("class_name").getAsString();
        completionItems.add(item);
      }

      // فیلتر کردن بر اساس پیشوند
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

  public static List<CompletionItem> analyzeCodeCompletion(String sourcePath, String code,int f) {
    List<CompletionItem> result = new ArrayList<>();

    // بررسی اولیه برای جلوگیری از NullPointerException
    if (code == null || code.isEmpty() || sourcePath == null) {
      return result;
    }

    try {
      configureSymbolSolver(sourcePath);

      // پیدا کردن آخرین نقطه در کد به عنوان موقعیت احتمالی کرسر
      int lastDotIndex = code.lastIndexOf('.');

      if (lastDotIndex != -1 && lastDotIndex < code.length() - 1) {
        // حالت متغیر با نقطه (مثل var.)
        String textBeforeDot = code.substring(0, lastDotIndex);
        String varName = extractVariableNameBeforeDot(textBeforeDot);

        if (!varName.isEmpty()) {
          String varType = resolveVariableTypeWithSymbolSolver(code, varName);
          if (varType != null) {
            result.addAll(getMethodsForClassFromSource(sourcePath, varType));
          }
        }
      } else {
        // حالت معمولی - جستجوی کلاس‌ها
        // پیدا کردن آخرین کلمه در کد به عنوان پیشوند
        String[] words = code.split("[^a-zA-Z0-9_]");
        String prefix = words.length > 0 ? words[words.length - 1] : "";

        if (!prefix.isEmpty()) {
          result.addAll(getClasses(sourcePath, prefix));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      return new ArrayList<>();
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

  private static String findVariableType(String code, String varName) {

    Pattern pattern = Pattern.compile("\\s+" + varName + "\\s*=\\s*new\\s+(\\w+)");
    Matcher matcher = pattern.matcher(code);
    return matcher.find() ? matcher.group(1) : null;
  }

  private static List<CompletionItem> getMethodsForClassFromSource(String sourcePath, String fqcn) {
    List<CompletionItem> methods = new ArrayList<>();

    String className = fqcn.substring(fqcn.lastIndexOf(".") + 1);

    File dir = new File(sourcePath);
    for (File file : dir.listFiles((d, name) -> name.endsWith(".java"))) {
      try {
        CompilationUnit cu = StaticJavaParser.parse(file);
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

  public static List<CompletionItem> getListFile(String currentPath, String prefix) {
    return PathCompleter.getPathCompletions(currentPath, prefix);
  }
}
