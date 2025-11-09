package ir.ninjacoder.ghostide.core.config;

import android.util.Log;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ninjacoder.jgit.childer.FuzzySearchHelper;
import io.github.rosemoe.sora.data.CompletionItem;
import ir.ninjacoder.ghostide.core.utils.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaToGsonHelper {
  private final String javacode;
  private final Map<String, String> map = new HashMap<>();

  public JavaToGsonHelper(String javacode) {
    this.javacode = javacode;
    installData();
  }

  private synchronized void installData() {
    try {
      JavaParser parser = new JavaParser();
      ParseResult<CompilationUnit> parseResult = parser.parse(javacode);

      if (!parseResult.isSuccessful() || !parseResult.getResult().isPresent()) {
        Log.w("JavaToGsonHelper", "Code is incomplete or has syntax errors. Skipping...");
        return;
      }

      CompilationUnit cu = parseResult.getResult().get();
      map.clear(); // Clear previous data

      cu.accept(
          new VoidVisitorAdapter<Void>() {
            @Override
            public void visit(ClassOrInterfaceDeclaration decl, Void arg) {
              map.put("classorinterface", decl.getNameAsString());
              super.visit(decl, arg);
            }

            @Override
            public void visit(EnumDeclaration decl, Void arg) {
              map.put("enum", decl.getNameAsString());
              super.visit(decl, arg);
            }

            @Override
            public void visit(MethodDeclaration decl, Void arg) {
              StringBuilder methodSignature = new StringBuilder();
              methodSignature.append(decl.getNameAsString()).append("(");
              methodSignature.append(");");
              map.put("method:" + decl.getNameAsString(), methodSignature.toString());
              super.visit(decl, arg);
            }

            @Override
            public void visit(Parameter decl, Void arg) {
              map.put("param:" + decl.getNameAsString(), decl.getTypeAsString());
              super.visit(decl, arg);
            }

            @Override
            public void visit(TypeParameter decl, Void arg) {
              map.put("typeparam:" + decl.getNameAsString(), decl.getNameAsString());
              super.visit(decl, arg);
            }

            @Override
            public void visit(FieldDeclaration decl, Void arg) {
              decl.getVariables()
                  .forEach(var -> map.put("field:" + var.getNameAsString(), var.getTypeAsString()));
              super.visit(decl, arg);
            }
          },
          null);

      // Save to JSON only if there's valid data
      if (!map.isEmpty()) {
        List<Map<String, String>> dataList = new ArrayList<>();
        dataList.add(map);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dataList);
        FileUtil.writeFile("/sdcard/data.json", json);
      }
    } catch (Exception e) {
      Log.e("JavaToGsonHelper", "Failed to parse Java code: " + e.getMessage());
    }
  }

  public static synchronized void installFormSora(List<CompletionItem> items, String prefix) {
    try {
      String jsonContent = FileUtil.readFile("/sdcard/data.json");
      if (jsonContent == null || jsonContent.isEmpty()) return;

      List<Map<String, String>> dataList =
          new Gson().fromJson(jsonContent, new TypeToken<List<Map<String, String>>>() {}.getType());

      if (dataList == null || dataList.isEmpty()) return;

      for (Map<String, String> data : dataList) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
          String key = entry.getKey();
          String value = entry.getValue();

          // فیلتر)
          if (value != null
              && (value.toLowerCase().contains(prefix.toLowerCase())
                  || FuzzySearchHelper.isFuzzyMatch(prefix, value) // تطابق فازی
              )) {
            CompletionItem item = createCompletionItem(key, value);
            if (item != null) items.add(item);
          }
        }
      }
    } catch (Exception e) {
      Log.e("JavaToGsonHelper", "Error loading completions: " + e.getMessage());
    }
  }

  private static CompletionItem createCompletionItem(String key, String value) {
    if (key.startsWith("classorinterface")) {
      return new CompletionItem(value, "Class");
    } else if (key.startsWith("field:")) {
      return new CompletionItem(key.replace("field:", ""), "Field (" + value + ")");
    } else if (key.startsWith("method:")) {
      return new CompletionItem(value, "Method");
    } else if (key.startsWith("typeparam:")) {
      return new CompletionItem(key.replace("typeparam:", ""), "Type Parameter");
    } else if (key.startsWith("enum")) {
      return new CompletionItem(value, "Enum");
    }
    return null;
  }
}
