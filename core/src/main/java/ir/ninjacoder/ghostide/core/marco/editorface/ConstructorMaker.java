package ir.ninjacoder.ghostide.core.marco.editorface;

import android.content.Context;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.printer.DefaultPrettyPrinter;
import com.github.javaparser.printer.configuration.DefaultPrinterConfiguration;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.Optional;

import ir.ninjacoder.ghostide.core.IdeEditor;

public class ConstructorMaker {
  private Context context;
  private String path;
  protected IdeEditor editor;
 
  public ConstructorMaker(Context context, String path, IdeEditor editor) {
    this.context = context;
    this.path = path;
    this.editor = editor;
    generateConstructorDialog();
  }

  private boolean doesConstructorExist(ClassOrInterfaceDeclaration classDecl) {
    return classDecl.getMembers().stream()
        .filter(member -> member.isConstructorDeclaration())
        .anyMatch(
            constructor ->
                constructor
                    .asConstructorDeclaration()
                    .getName()
                    .asString()
                    .equals(getClassName(path)));
  }

  private void generateConstructorDialog() {
    ArrayList<String> fields = new ArrayList<>();
    ArrayList<String> types = new ArrayList<>(); // برای ذخیره نوع فیلدها
    try {
      CompilationUnit cu = StaticJavaParser.parse(path);
      cu.findAll(ClassOrInterfaceDeclaration.class)
          .forEach(
              classOrBody -> {
                if (classOrBody.getNameAsString().equals(getClassName(path))) {
                  ClassOrInterfaceDeclaration classDecl = (ClassOrInterfaceDeclaration) classOrBody;
                  // بررسی وجود سازنده
                  if (doesConstructorExist(classDecl)) {
                    // نمایش پیام به کاربر
                    new MaterialAlertDialogBuilder(context)
                        .setTitle("Constructor Exists")
                        .setMessage("A constructor already exists for this class.")
                        .setPositiveButton(android.R.string.ok, (dialog, which) -> dialog.dismiss())
                        .show();
                    return; // خروج از متد، چون سازنده قبلاً وجود دارد
                  } else {
                    for (BodyDeclaration<?> member : classDecl.getMembers()) {
                      if (member.isFieldDeclaration()) {
                        FieldDeclaration field = member.asFieldDeclaration();
                        String fieldType =
                            field.getElementType().asString(); // به دست آوردن نوع فیلد
                        NodeList<VariableDeclarator> variables = field.getVariables();
                        for (VariableDeclarator variable : variables) {
                          fields.add(variable.getNameAsString());
                          types.add(fieldType); // ذخیره‌سازی نوع فیلد
                        }
                      }
                    }
                    String[] fieldArray = fields.toArray(new String[0]);
                    boolean[] checkedFields = new boolean[fieldArray.length];

                    new MaterialAlertDialogBuilder(context)
                        .setTitle("Select Fields for Constructor")
                        .setMultiChoiceItems(
                            fieldArray,
                            checkedFields,
                            (dialog, which, isChecked) -> {
                              // Handle selection
                            })
                        .setPositiveButton(
                            "Generate",
                            (dialog, which) -> {
                              // ایجاد سازنده
                              createConstructor(fieldArray, types, checkedFields);
                            })
                        .setNegativeButton(android.R.string.cancel, (dialog, which) -> dialog.dismiss())
                        .show();
                  }
                }
              });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void createConstructor(
      String[] fieldArray, ArrayList<String> types, boolean[] checkedFields) {
    StringBuilder constructor = new StringBuilder("public " + getClassName(path)).append("(");

    for (int i = 0; i < fieldArray.length; i++) {
      if (checkedFields[i]) {
        if (constructor.length() > 0 && constructor.charAt(constructor.length() - 1) != '(')
          constructor.append(", ");
        constructor.append(types.get(i)).append(" ").append(fieldArray[i]); // نوع و نام
      }
    }

    constructor.append(") {\n");
    for (int i = 0; i < fieldArray.length; i++) {
      if (checkedFields[i]) {
        constructor
            .append("    this.")
            .append(fieldArray[i])
            .append(" = ")
            .append(fieldArray[i])
            .append(";\n");
      }
    }
    constructor.append("}\n");

    // نمایش سازنده ایجاد شده
    showGeneratedConstructor(constructor.toString());
  }

  private void showGeneratedConstructor(String constructor) {

    editor.insertText(format(constructor), constructor.length());
    editor.formatCodeAsync();
  }

  String getClassName(String javaCode) {
    try {
      CompilationUnit cu = StaticJavaParser.parse(javaCode);

      Optional<ClassOrInterfaceDeclaration> firstClass =
          cu.findFirst(ClassOrInterfaceDeclaration.class);

      return firstClass.map(ClassOrInterfaceDeclaration::getNameAsString).orElse("Main");
    } catch (Exception e) {
      e.printStackTrace();
      return "Main";
    }
  }

  String format(String code) {
    try {
      CompilationUnit cu = StaticJavaParser.parse(code);

      DefaultPrinterConfiguration configuration = new DefaultPrinterConfiguration();
      DefaultPrettyPrinter printer = new DefaultPrettyPrinter(configuration);

      String formattedCode = printer.print(cu);
      System.out.println(formattedCode);
      return formattedCode;
    } catch (Throwable t) {
      System.err.println("An error occurred during code formatting: " + t.getMessage());
      return code; // Return the original code if an error occurs
    }
  }
}
