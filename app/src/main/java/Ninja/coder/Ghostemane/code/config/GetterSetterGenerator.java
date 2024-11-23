package Ninja.coder.Ghostemane.code.config;

import Ninja.coder.Ghostemane.code.IdeEditor;
import android.content.Context;
import android.util.Log;
import android.widget.*;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.util.*;

public class GetterSetterGenerator {
  private static List<FieldDeclaration> fields = new ArrayList<>();

  public static void main(Context context, String code, IdeEditor outputText) {
    try {
      fields.clear(); // پاک کردن لیست فیلدها قبل از پر کردن مجدد
      CompilationUnit cu = StaticJavaParser.parse(code);

      List<String> existingMethods = new ArrayList<>();

      // جمع‌آوری متدهای موجود (getter و setter)
      cu.accept(
          new VoidVisitorAdapter<Void>() {
            @Override
            public void visit(MethodDeclaration method, Void arg) {
              super.visit(method, arg);
              if (method.getNameAsString().startsWith("get")
                  || method.getNameAsString().startsWith("set")) {
                existingMethods.add(method.getNameAsString());
              }
            }
          },
          null);

      // جمع‌آوری فیلدها و بررسی وجود getter و setter
      cu.accept(
          new VoidVisitorAdapter<Void>() {
            @Override
            public void visit(FieldDeclaration declaration, Void arg) {
              super.visit(declaration, arg);
              for (VariableDeclarator variable : declaration.getVariables()) {
                String fieldName = variable.getNameAsString();
                String capitalizedFieldName = capitalize(fieldName);

                // بررسی وجود getter و setter
                if (!existingMethods.contains("get" + capitalizedFieldName)
                    && !existingMethods.contains("set" + capitalizedFieldName)) {
                  fields.add(declaration);
                }
              }
            }
          },
          null);

      // نمایش دیالوگ برای انتخاب فیلدها
      showFieldSelectionDialog(context, cu, outputText);
    } catch (Exception e) {
      e.printStackTrace(); // برای عیب‌یابی
    }
  }

  private static void showFieldSelectionDialog(
      Context context, CompilationUnit cu, IdeEditor outputText) {
    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
    builder.setTitle("Select Fields for Getter/Setter");
    ScrollView scrollView = new ScrollView(context);
    LinearLayout layout = new LinearLayout(context);

    layout.setPadding(8, 8, 8, 8);
    layout.setOrientation(LinearLayout.VERTICAL);
    List<CheckBox> checkBoxes = new ArrayList<>();

    for (FieldDeclaration field : fields) {
      CheckBox checkBox = new CheckBox(context);
      checkBox.setText(field.getVariables().get(0).getNameAsString());
      layout.addView(checkBox);
      checkBoxes.add(checkBox);
    }
    scrollView.addView(layout);
    builder.setView(scrollView);

    builder.setPositiveButton(
        "Generate",
        (dialog, which) -> {
          // ایجاد گتر و ستر برای فیلدهای انتخاب شده
          for (int i = 0; i < checkBoxes.size(); i++) {
            if (checkBoxes.get(i).isChecked()) {
              FieldDeclaration selectedField = fields.get(i);
              // استفاده از نوع کلی
              selectedField.accept(new ClassVisitor(cu), null);
            }
          }
          displayGeneratedMethods(cu.toString(), outputText);
        });
    builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
    builder.show();
  }

  private static class ClassVisitor extends VoidVisitorAdapter<Void> {
    private CompilationUnit cu; // مرجع به CompilationUnit

    public ClassVisitor(CompilationUnit cu) {
      this.cu = cu;
    }

    @Override
    public void visit(FieldDeclaration declaration, Void arg) {
      super.visit(declaration, arg);

      TypeDeclaration<?> typeDeclaration =
          (TypeDeclaration<?>) declaration.getParentNode().orElse(null);
      if (typeDeclaration != null) {
        BodyDeclaration<?> getter = createGetter(declaration);
        BodyDeclaration<?> setter = createSetter(declaration);
        typeDeclaration.getMembers().add(getter);
        typeDeclaration.getMembers().add(setter);
      } else {
        // اگر typeDeclaration null است
        Log.e("ClassVisitor", "TypeDeclaration is null for field: " + declaration);
      }
    }

    private BodyDeclaration<?> createGetter(FieldDeclaration field) {
      String fieldName = field.getVariables().get(0).getNameAsString();
      String fieldType = field.getVariables().get(0).getTypeAsString();
      return StaticJavaParser.parseBodyDeclaration(
          "public "
              + fieldType
              + " get"
              + capitalize(fieldName)
              + "() {\n"
              + "    return this."
              + fieldName
              + ";\n"
              + "}");
    }

    private BodyDeclaration<?> createSetter(FieldDeclaration field) {
      String fieldName = field.getVariables().get(0).getNameAsString();
      String fieldType = field.getVariables().get(0).getTypeAsString();
      return StaticJavaParser.parseBodyDeclaration(
          "public void set"
              + capitalize(fieldName)
              + "("
              + fieldType
              + " "
              + fieldName
              + ") {\n"
              + "    this."
              + fieldName
              + " = "
              + fieldName
              + ";\n"
              + "}");
    }

    private String capitalize(String str) {
      if (str == null || str.isEmpty()) {
        return str;
      }
      return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
  }

  private static void displayGeneratedMethods(String modifiedCode, IdeEditor outputText) {
    // نمایش نتیجه در IdeEditor
    outputText.setText(modifiedCode);
  }

  private static String capitalize(String str) {
    if (str == null || str.isEmpty()) {
      return str;
    }
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }
}
