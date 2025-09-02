package ir.ninjacoder.ghostide.marco;

import android.os.Bundle;
import android.view.View;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ThisExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.printer.PrettyPrinter;
import com.github.javaparser.printer.configuration.PrettyPrinterConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * نویسنده: ninjacoder
 * این کلاس هنوز کامل نیست
 */
public class ActivityToFragmentConverter {

  public static String convertActivityToFragment(String activityCode) {
    try {
      // پارس کردن کد Activity
      StaticJavaParser.getConfiguration()
          .setLanguageLevel(ParserConfiguration.LanguageLevel.BLEEDING_EDGE);
      CompilationUnit cu = StaticJavaParser.parse(activityCode);
      // اضافه کردن ایمپورت‌های لازم برای Fragment
      addFragmentImports(cu);
      // تغییر نام کلاس و ارث‌بری
      modifyClassDeclaration(cu);

      // تبدیل متد onCreate به onCreateView
      convertOnCreateToOnCreateView(cu);

      // حذف متدهای مخصوص Activity
      removeActivitySpecificMethods(cu);

      // حذف ایمپورت‌های اضافی
      removeUnnecessaryImports(cu);
      String activityName = getActivityClassName(cu);
      replaceRunOnUiThreadAndActivityThis(cu);
      replaceThisWithRequireActivity(cu, activityName);

      removeUnnecessaryImports(cu);
      // تولید کد Fragment نهایی
      return generateFragmentCode(cu);

    } catch (Exception e) {
      e.printStackTrace();
      return "خطا در تبدیل کد: " + e.getMessage();
    }
  }

  private static void replaceRunOnUiThreadAndActivityThis(CompilationUnit cu) {
    // 1. runOnUiThread -> requireActivity().runOnUiThread
    cu.findAll(MethodCallExpr.class)
        .forEach(
            call -> {
              if (call.getNameAsString().equals("runOnUiThread") && !call.getScope().isPresent()) {
                call.setScope(new MethodCallExpr("requireActivity"));
              }
            });
    cu.findAll(MethodCallExpr.class)
        .forEach(
            it -> {
              if (it.getNameAsString().equals("getApplicationContext")
                  && !it.getScope().isPresent()) {
                it.setScope(new MethodCallExpr("requireContext"));
                it.setBlockComment(
                    "Convert getApplicationContext to #requireContext.getApplicationContext ");
              }
            });
  }

  private static void modifyClassDeclaration(CompilationUnit cu) {
    cu.findAll(ClassOrInterfaceDeclaration.class)
        .forEach(
            classDecl -> {
              // تغییر extends از Activity به Fragment
              NodeList<ClassOrInterfaceType> extendedTypes = classDecl.getExtendedTypes();
              JavadocComment classComment =
                  new JavadocComment(
                      " * این فرگمنت از Activity تبدیل شده است\n"
                          + " * تاریخ ایجاد: "
                          + new Date()
                          + "\n"
                          + " * توسط ActivityToFragmentConverter ایجاد شده\n"
                          + " * اخطار نیاز است به تغییراتی شاید داشته باشید\n"
                          + " * مانند MainActivity.this \n"
                          + " * "
                          + " ");
              classDecl.setComment(classComment);
              if (extendedTypes != null && !extendedTypes.isEmpty()) {
                ClassOrInterfaceType extendedType = extendedTypes.get(0);
                if (extendedType.getNameAsString().contains("Activity")) {
                  extendedType.setName("Fragment");
                }
              } else {
                // اگر extends نداشت، اضافه کردن Fragment
                classDecl.addExtendedType("Fragment");
              }

              // تغییر نام کلاس
              String className = classDecl.getNameAsString();
              if (className.matches("extends\\s+\\w+\\b")) {
                classDecl.setName(className.replaceAll("extends\\s+\\w+\\b", "$1Fragment"));
              }
            });
  }

  private static void addFragmentImports(CompilationUnit cu) {
    // اضافه کردن ایمپورت‌های Fragment
    cu.addImport("androidx.fragment.app.Fragment");
    cu.addImport("android.view.LayoutInflater");
    cu.addImport("android.view.View");
    cu.addImport("android.view.ViewGroup");

    // حذف ایمپورت‌های Activity
    NodeList<ImportDeclaration> imports = cu.getImports();
    List<ImportDeclaration> toRemove = new ArrayList<>();

    for (ImportDeclaration importDecl : imports) {
      String importName = importDecl.getNameAsString();
      if (importName.matches("extends\\s+\\w+\\b")) {
        toRemove.add(importDecl);
      }
    }
    imports.removeAll(toRemove);
  }

  private static void removeUnnecessaryImports(CompilationUnit cu) {
    NodeList<ImportDeclaration> imports = cu.getImports();
    List<ImportDeclaration> toRemove = new ArrayList<>();

    for (ImportDeclaration importDecl : imports) {
      String importName = importDecl.getNameAsString();
      // حذف ایمپورت‌های مربوط به منو و سایر موارد غیرضروری
      if (importName.contains("menu")
          || importName.contains("onCreateOptionsMenu")
          || importName.contains("onOptionsItemSelected")) {
        toRemove.add(importDecl);
      }
    }
    imports.removeAll(toRemove);
  }

  private static void convertOnCreateToOnCreateView(CompilationUnit cu) {
    cu.findAll(MethodDeclaration.class)
        .forEach(
            method -> {
              if (method.getNameAsString().equals("onCreate")) {
                // تغییر نام و نوع متد
                method.setName("onCreateView");
                method.setType("View");
                method.setModifiers(Modifier.Keyword.PUBLIC); // تغییر به public

                // تغییر پارامترها
                method.getParameters().clear();
                method.addParameter("LayoutInflater", "inflater");
                method.addParameter("ViewGroup", "container");
                method.addParameter("Bundle", "savedInstanceState");

                if (method.getBody().isPresent()) {
                  BlockStmt body = method.getBody().get();

                  // حذف فراخوانی super.onCreate
                  body.findAll(MethodCallExpr.class)
                      .removeIf(
                          call ->
                              call.getNameAsString().equals("onCreate")
                                  && call.getScope().isPresent()
                                  && call.getScope().get().toString().equals("super"));

                  // جایگزینی setContentView با inflate
                  body.findAll(MethodCallExpr.class)
                      .forEach(
                          call -> {
                            if (call.getNameAsString().equals("setContentView")) {
                              if (call.getArguments().size() > 0) {
                                String layoutName = call.getArgument(0).toString();
                                MethodCallExpr inflateCall = new MethodCallExpr();
                                inflateCall.setScope(new NameExpr("inflater"));
                                inflateCall.setName("inflate");
                                inflateCall.addArgument(layoutName);
                                inflateCall.addArgument(new NameExpr("container"));
                                inflateCall.addArgument("false");

                                // اضافه کردن متغیر view
                                VariableDeclarationExpr viewVar =
                                    new VariableDeclarationExpr(
                                        new VariableDeclarator(
                                            new ClassOrInterfaceType("View"), "view", inflateCall));

                                call.replace(viewVar);
                              }
                            }
                          });

                  // تغییر findViewById به view.findViewById
                  body.findAll(MethodCallExpr.class)
                      .forEach(
                          call -> {
                            if (call.getNameAsString().equals("findViewById")
                                && !call.getScope().isPresent()) {
                              call.setScope(new NameExpr("view"));
                            }
                          });

                  // تغییر this به getActivity() در Toast
                  body.findAll(MethodCallExpr.class)
                      .forEach(
                          call -> {
                            if (call.getNameAsString().equals("makeText")) {
                              for (int i = 0; i < call.getArguments().size(); i++) {
                                if (call.getArgument(i).toString().equals("this")) {
                                  call.setArgument(i, new MethodCallExpr("getActivity"));
                                }
                              }
                            }
                          });

                  // اضافه کردن return view
                  boolean hasReturn =
                      body.getStatements().stream().anyMatch(stmt -> stmt instanceof ReturnStmt);

                  if (!hasReturn) {
                    body.addStatement(new ReturnStmt(new NameExpr("view")));
                  }
                }
              }
            });
    //	addOnViewCreatedMethod(cu);
  }

  private static void addOnViewCreatedMethod(CompilationUnit cu) {
    cu.findAll(ClassOrInterfaceDeclaration.class)
        .forEach(
            classDecl -> {
              // ایجاد متد onViewCreated
              MethodDeclaration onViewCreated = new MethodDeclaration();
              onViewCreated.addAnnotation("Override");
              onViewCreated.setType("void");
              onViewCreated.setName("onViewCreated");
              onViewCreated.setModifiers(Modifier.Keyword.PUBLIC);

              // اضافه کردن پارامترها
              onViewCreated.addParameter("View", "view");
              onViewCreated.addParameter("Bundle", "savedInstanceState");

              // ایجاد بدنه متد
              BlockStmt body = new BlockStmt();

              // اضافه کردن فراخوانی super
              MethodCallExpr superCall = new MethodCallExpr();
              superCall.setScope(new NameExpr("super"));
              superCall.setName("onViewCreated");
              superCall.addArgument(new NameExpr("view"));
              superCall.addArgument(new NameExpr("savedInstanceState"));
              body.addStatement(superCall);

              // اضافه کردن کامنت TODO
              body.addStatement("// TODO: Implement this method");

              onViewCreated.setBody(body);

              // اضافه کردن متد به کلاس
              classDecl.addMember(onViewCreated);
            });
  }

  private static void removeActivitySpecificMethods(CompilationUnit cu) {
    List<MethodDeclaration> toRemove = new ArrayList<>();

    cu.findAll(MethodDeclaration.class)
        .forEach(
            method -> {
              String methodName = method.getNameAsString();
              // حذف متدهای مخصوص Activity
              if (methodName.equals("onCreateOptionsMenu")
                  || methodName.equals("onOptionsItemSelected")
                  || methodName.equals("onBackPressed")) {
                toRemove.add(method);
              }
            });

    toRemove.forEach(method -> method.remove());
  }

  private static String generateFragmentCode(CompilationUnit cu) {
    PrettyPrinterConfiguration config = new PrettyPrinterConfiguration();
    config.setOrderImports(true);
    PrettyPrinter prettyPrinter = new PrettyPrinter(config);

    return prettyPrinter.print(cu);
  }

  private static String getActivityClassName(CompilationUnit cu) {
    return cu.findFirst(ClassOrInterfaceDeclaration.class)
        .map(ClassOrInterfaceDeclaration::getNameAsString)
        .orElse(null);
  }

  private static void replaceThisWithRequireActivity(CompilationUnit cu, String activityName) {
    cu.findAll(ThisExpr.class)
        .forEach(
            thisExpr -> {
              // فقط وقتی this بدون qualifier باشه (نه MainActivity.this)
              if (!thisExpr.getTypeName().isPresent()) {
                // بررسی کن ببین در کلاس اصلی Activity هست یا نه
                ClassOrInterfaceDeclaration parentClass =
                    thisExpr.findAncestor(ClassOrInterfaceDeclaration.class).orElse(null);
                if (parentClass != null && parentClass.getNameAsString().equals(activityName)) {
                  thisExpr.replace(new MethodCallExpr("requireActivity"));
                }
              }
            });
  }
}
