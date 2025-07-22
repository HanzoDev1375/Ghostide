package ir.ninjacoder.ghostide.config;

import android.content.DialogInterface;
import android.util.Log;
import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.NullLiteralExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.printer.configuration.DefaultPrinterConfiguration;
import com.github.javaparser.printer.DefaultPrettyPrinter;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.stmt.TryStmt;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.utils.DataUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import com.google.gson.Gson;
import com.google.common.reflect.TypeToken;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class JavaPaserUtils {

  private IdeEditor editor;

  public JavaPaserUtils(IdeEditor editor) {
    this.editor = editor;
  }

  public void addThrowsToMethod() {
    var cu = StaticJavaParser.parse(editor.getText().toString());
    List<String> methodNames = new ArrayList<>();
    cu.findAll(MethodDeclaration.class)
        .forEach(method -> methodNames.add(method.getNameAsString()));
    var checkedItems = new boolean[methodNames.size()];
    var builder = new MaterialAlertDialogBuilder(editor.getContext());
    builder.setTitle("Select Methods");
    builder.setMultiChoiceItems(
        methodNames.toArray(new String[0]),
        checkedItems,
        new DialogInterface.OnMultiChoiceClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            checkedItems[which] = isChecked;
          }
        });

    builder.setPositiveButton(
        android.R.string.ok,
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            for (int i = 0; i < checkedItems.length; i++) {
              if (checkedItems[i]) {
                MethodDeclaration selectedMethod = cu.findAll(MethodDeclaration.class).get(i);
                if (!selectedMethod.getThrownExceptions().isNonEmpty()) {
                  selectedMethod.addThrownException(new ClassOrInterfaceType(null, "Exception"));
                }
              }
            }
            editor.setText(cu.toString());
          }
        });
    builder.setNegativeButton(android.R.string.cancel, null);
    builder.show();
  }

  public void addTrycatch() {
    try {
      BlockStmt tryBlock = new BlockStmt();
      tryBlock.addStatement(editor.getSelectedText());
      Type exceptionType = new ClassOrInterfaceType(null, "Exception");
      CatchClause catchClause =
          new CatchClause(new Parameter(exceptionType, "err"), new BlockStmt());
      catchClause.getBody().addStatement("err.printStackTrace();");
      TryStmt tryStmt = new TryStmt(tryBlock, NodeList.nodeList(catchClause), null);
      editor.insertText(format(tryStmt.toString()), tryStmt.toString().length());
      editor.formatCodeAsync();
    } catch (ParseProblemException err) {
      Log.e("ErrorRunTime", err.getLocalizedMessage());
    }
  }

  public void addIfStatement() {
    try {
      BlockStmt ifBlock = new BlockStmt();
      ifBlock.addStatement(editor.getSelectedText());
      Expression condition = new NameExpr("condition");
      IfStmt ifStmt = new IfStmt(condition, ifBlock, null);
      editor.insertText(format(ifStmt.toString()), ifStmt.toString().length());
      editor.formatCodeAsync();
    } catch (ParseProblemException err) {
      Log.e("ErrorRunTime", err.getLocalizedMessage());
    }
  }

  public void addNullCheck() {
    try {
      var cu = StaticJavaParser.parse(editor.getText().toString());
      List<String> listVar = new ArrayList<>();
      // لیست متغیرها
      List<Boolean> checkedItems = new ArrayList<>();
      cu.findAll(FieldDeclaration.class)
          .forEach(
              its -> {
                its.getVariables()
                    .forEach(
                        cusr -> {
                          listVar.add(cusr.getNameAsString());
                          checkedItems.add(false); // پیش فرض برای انتخاب نشده
                        });

                // تبدیل checkedItems به boolean[]

              });
      boolean[] checked = new boolean[checkedItems.size()];
      for (int i = 0; i < checkedItems.size(); i++) {
        checked[i] = checkedItems.get(i);
      }

      new MaterialAlertDialogBuilder(editor.getContext())
          .setTitle("Select Var")
          .setMultiChoiceItems(
              listVar.toArray(new CharSequence[0]),
              checked,
              (dialog, which, isChecked) -> {
                checkedItems.set(which, isChecked);
              })
          .setPositiveButton(
              "OK",
              (dialog, which) -> {
                for (int i = 0; i < listVar.size(); i++) {
                  if (checkedItems.get(i)) {
                    var name = listVar.get(i);
                    if (name != null && !name.isEmpty()) {
                      BlockStmt ifBlock = new BlockStmt();
                      ifBlock.addStatement("return;");

                      // استفاده از NameExpr برای متغیر ثبت شده در if
                      IfStmt ifStmt =
                          new IfStmt(
                              new BinaryExpr(
                                  new NameExpr(name),
                                  new NullLiteralExpr(),
                                  BinaryExpr.Operator.EQUALS),
                              ifBlock,
                              null);

                      // افزودن "if" در ویرایشگر
                      editor.insertText(format(ifStmt.toString()), ifStmt.toString().length());

                      editor.formatCodeAsync();
                    } else {
                      Log.e("SelectionError", "Please select a valid variable.");
                    }
                  }
                }
              })
          .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
          .show();

    } catch (ParseProblemException err) {
      Log.e("ErrorRunTime", err.getLocalizedMessage());
    }
  }

  public void addInstance() {
    String findClassName = extractFirstClassName(editor.getText().toString());
    StringBuilder bu = new StringBuilder();

    bu.append("private static ").append(findClassName).append(" INSTANCE;\n");
    bu.append("public static ").append(findClassName).append(" getInstance() {\n");
    bu.append("    if (INSTANCE == null) {\n");
    bu.append("        INSTANCE = new ").append(findClassName).append("();\n");
    bu.append("    }\n");
    bu.append("    return INSTANCE;\n");
    bu.append("}\n");

    editor.insertText(bu.toString(), bu.toString().length());
    editor.formatCodeAsync();
  }

  public String extractClassNameWithRegex(String javaCode) {

    Pattern pattern = Pattern.compile("\\bclass\\s+([A-Za-z_$][A-Za-z0-9_$]*)");
    Matcher matcher = pattern.matcher(javaCode);

    if (matcher.find()) {
      return matcher.group(1);
    }
    return null;
  }

  public String addInstanceOf() {
    String findClassName = extractClassNameWithRegex(editor.getTextAsString());
    if (findClassName == null) {
      findClassName = "Class Name Not found";
    }

    StringBuilder bu = new StringBuilder();
    bu.append("private static ").append(findClassName).append(" INSTANCE;\n");
    bu.append("public static ").append(findClassName).append(" getInstance() {\n");
    bu.append("    if (INSTANCE == null) {\n");
    bu.append("        INSTANCE = new ").append(findClassName).append("();\n");
    bu.append("    }\n");
    bu.append("    return INSTANCE;\n");
    bu.append("}\n");
    editor.postDelayed(
        () -> {
          editor.formatCodeAsync();
        },
        1000);
    return bu.toString();
  }

  public String addContractor() {
    String findClassName = extractClassNameWithRegex(editor.getTextAsString());
    StringBuilder builder = new StringBuilder();
    builder.append("public ").append(findClassName).append(" (){").append("\n");
    builder.append("}");
    editor.postDelayed(
        () -> {
          editor.formatCodeAsync();
        },
        1000);

    return builder.toString();
  }

  public String format(String code) {
    try {
      CompilationUnit cu = StaticJavaParser.parse(code);

      DefaultPrinterConfiguration configuration = new DefaultPrinterConfiguration();
      DefaultPrettyPrinter printer = new DefaultPrettyPrinter(configuration);

      String formattedCode = printer.print(cu);
      System.out.println(formattedCode);
      return formattedCode;
    } catch (Throwable t) {
      System.err.println("An error occurred during code formatting: " + t.getMessage());
      return code;
    }
  }

  public String extractFirstClassName(String javaCode) {
    try {
      CompilationUnit cu = StaticJavaParser.parse(javaCode);
      // پیدا کردن اولین کلاس
      Optional<ClassOrInterfaceDeclaration> firstClass =
          cu.findFirst(ClassOrInterfaceDeclaration.class);
      // اگر کلاسی پیدا شد، نام آن را برگردانید
      return firstClass.map(ClassOrInterfaceDeclaration::getNameAsString).orElse("Main");
    } catch (Exception e) {
      e.printStackTrace();
      return "Main"; // در صورت خطا، یک مقدار پیش‌فرض برگردانید
    }
  }

  public static boolean getDeprecated(NodeList<AnnotationExpr> node) {
    return node.stream().anyMatch(a -> a.getNameAsString().equals("Deprecated"));
  }

  public static boolean getCustomAnnotationExpr(NodeList<AnnotationExpr> node, String key) {
    return node.stream().anyMatch(i -> i.getNameAsString().equals(key));
  }

  public static boolean getRegexAnnotation(NodeList<AnnotationExpr> expr) {
    return expr.stream().anyMatch(it -> it.getNameAsString().matches("[a-zA-Z]+"));
  }

  public static String processCode(String code) {
    CompilationUnit cu = StaticJavaParser.parse(code);
    Set<String> typesToImport = new HashSet<>();

    cu.findAll(FieldDeclaration.class)
        .forEach(
            field -> {
              field
                  .getVariables()
                  .forEach(
                      variable -> {
                        String typeName = variable.getType().asString();
                        typeName = getBaseTypeName(typeName);
                        if (!isPrimitiveType(typeName) && !hasImport(cu, typeName)) {
                          typesToImport.add(typeName);
                        }
                      });
            });
    cu.findAll(MethodDeclaration.class)
        .forEach(
            method -> {
              String returnType = method.getType().asString();
              returnType = getBaseTypeName(returnType);
              if (!isPrimitiveType(returnType) && !hasImport(cu, returnType)) {
                typesToImport.add(returnType);
              }

              method
                  .getParameters()
                  .forEach(
                      param -> {
                        String paramType = param.getType().asString();
                        paramType = getBaseTypeName(paramType);
                        if (!isPrimitiveType(paramType) && !hasImport(cu, paramType)) {
                          typesToImport.add(paramType);
                        }
                      });
            });

    for (String type : typesToImport) {
      String fullTypeName = getFullTypeName(type);
      if (!fullTypeName.isEmpty() && !hasImport(cu, fullTypeName)) {
        cu.addImport(fullTypeName);
      }
    }
    return cu.toString();
  }

  private static String getBaseTypeName(String typeName) {
    while (typeName.contains("<")) {
      typeName = typeName.substring(0, typeName.indexOf("<"));
    }
    return typeName;
  }

  private static boolean isPrimitiveType(String typeName) {
    return typeName.equals("int")
        || typeName.equals("long")
        || typeName.equals("short")
        || typeName.equals("byte")
        || typeName.equals("double")
        || typeName.equals("float")
        || typeName.equals("char")
        || typeName.equals("boolean")
        || typeName.equals("void")
		|| typeName.equals("String");
  }

  private static boolean hasImport(CompilationUnit cu, String typeName) {
    return cu.getImports().stream()
        .anyMatch(importDeclaration -> importDeclaration.getNameAsString().equals(typeName));
  }

  static String getFullTypeName(String type) {
    try {
      var stream = GhostIdeAppLoader.getContext().getAssets().open("class_info.json");
      List<Map<String, String>> map = new ArrayList<>();
      map =
          new Gson()
              .fromJson(
                  DataUtil.copyFromInputStream(stream),
                  new TypeToken<List<Map<String, String>>>() {}.getType());
      for (var it : map) {

        if (type.equals(it.get("class_name"))) return it.get("full_package");
      }
    } catch (Exception err) {

    }
    return type;
  }
}
