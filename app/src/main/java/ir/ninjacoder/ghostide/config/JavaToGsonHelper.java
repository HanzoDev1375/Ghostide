package ir.ninjacoder.ghostide.config;

import ir.ninjacoder.ghostide.ApplicationLoader;
import ir.ninjacoder.ghostide.utils.FileUtil;
import android.util.Log;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.rosemoe.sora.data.CompletionItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaToGsonHelper {
  private String javacode;
  private Map<String, String> map = new HashMap<>();

  public JavaToGsonHelper(String javacode) {
    this.javacode = javacode;
    try {
      installData();
    } catch (Exception err) {
      Log.e("ErrorJsonNotFound ", err.getLocalizedMessage());
    }
  }

  void installData() throws Exception {
    var cu = StaticJavaParser.parse(javacode);
    cu.accept(
        new VoidVisitorAdapter<Void>() {

          @Override
          public void visit(ClassOrInterfaceDeclaration name, Void objects) {
            map.put("classorinterface", name.getNameAsString());
            super.visit(name, objects);
          }

          @Override
          public void visit(EnumDeclaration name, Void objects) {
            map.put("enumde", name.getNameAsString());
            super.visit(name, objects);
          }

          @Override
          public void visit(MethodDeclaration name, Void objects) {
            map.put("methods", name.getNameAsString());
            super.visit(name, objects);
          }

          @Override
          public void visit(Parameter name, Void objects) {
            map.put("parament", name.getNameAsString());
            super.visit(name, objects);
          }

          @Override
          public void visit(TypeParameter name, Void objects) {
            map.put("typeparameter", name.getNameAsString());
            super.visit(name, objects);
          }

          @Override
          public void visit(FieldDeclaration name, Void arg1) {
            name.getVariables().forEach(it -> map.put("var", it.getNameAsString()));
            super.visit(name, arg1);
          }
        },
        null);
    List<Map<String, String>> listItem = new ArrayList<>();
    listItem.add(map);
    var context = ApplicationLoader.getContext().getDataDir() + "/";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    FileUtil.writeFile(context + "data.json", gson.toJson(listItem));
  }

  public static void installFormSora(List<CompletionItem> item) {
    // item.add(new CompletionItem("classorinterface",map.get("classorinterface")));
    var path = ApplicationLoader.getContext().getDataDir() + "/" + "data.json";
    List<Map<String, String>> listasMap = new ArrayList<>();
    new Gson()
        .fromJson(FileUtil.readFile(path), new TypeToken<List<Map<String, String>>>() {}.getType());
    if (!listasMap.isEmpty()) {
      listasMap.forEach(
          it -> {
            List<CompletionItem> listvars = new ArrayList<>();
            List<CompletionItem> listclassorinterface = new ArrayList<>();
            listclassorinterface.add(new CompletionItem("classorinterface", it.get("classorinterface")));
            listvars.add(new CompletionItem("var", it.get("var")));
            item.addAll(listvars);
            item.addAll(listclassorinterface);
          });
    }
  }
}
