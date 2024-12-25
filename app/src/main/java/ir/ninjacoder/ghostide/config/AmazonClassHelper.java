package ir.ninjacoder.ghostide.config;

import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.glidecompat.GlideCompat;
import ir.ninjacoder.ghostide.marco.RegexUtilCompat;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.utils.FileUtil;
import android.util.Log;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import java.util.List;
import com.github.javaparser.ast.body.MethodDeclaration;
import java.util.stream.Collectors;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import org.jsoup.Jsoup;

public class AmazonClassHelper {

  public static void getKtClass(ImageView imageView, String file) {
    new Thread(
            () -> {
              String code = FileUtil.readFile(file);
              if (code != null) {
                if (RegexUtilCompat.RegexSelect("(data\\s*class\\s)", code)) {
                  // addImage
                } else if (RegexUtilCompat.RegexSelect("(open\\s*class\\s)", code)) {
                  // addImage
                } else if (RegexUtilCompat.RegexSelect("(interface\\s)", code)) {

                } else if (RegexUtilCompat.RegexSelect("(object\\s)", code)) {

                }
              }
            })
        .start();
  }

  public static void getScanAntlr4Grammer(ImageView imageView, String file) {
    new Thread(
            () -> {
              String code = FileUtil.readFile(file);
              if (RegexUtilCompat.RegexSelect("(grammar\\s\\w+)", code)) {
                ObjectUtils.runOnUiThread(
                    () -> {
                      GlideCompat.GlideNormal(imageView, R.drawable.antlr4_grammer_normal);
                    });
              }

              if (RegexUtilCompat.RegexSelect("(lexer\\sgrammar\\s\\w+)\\;", code)) {
                ObjectUtils.runOnUiThread(
                    () -> {
                      GlideCompat.GlideNormal(imageView, R.drawable.antlr4_lexer);
                    });
              }
              if (RegexUtilCompat.RegexSelect("(parser\\sgrammar\\s\\w+)\\;", code)) {
                ObjectUtils.runOnUiThread(
                    () -> {
                      GlideCompat.GlideNormal(imageView, R.drawable.antlr_parser);
                    });
              }
            })
        .start();
  }

  @Deprecated
  public static void getFileJavaAsChild(ImageView imageView, String file) {

    String code = FileUtil.readFile(file);
    if (code != null) {
      try {
        CompilationUnit cu = StaticJavaParser.parse(code);
        ClassOrInterfaceDeclaration classOrInterface =
            cu.findFirst(ClassOrInterfaceDeclaration.class).orElse(null);
        if (classOrInterface != null) {
          if (classOrInterface.isInterface()) {
            // Code that runs when it's an interface
            GlideCompat.LoadSvgInAsster("myface.svg", imageView);
          } else if (classOrInterface.isAbstract()) {
            GlideCompat.LoadSvgInAsster("absclass.svg", imageView);
          } else if (classOrInterface.isEnumDeclaration() || code.matches("(public\\s+enum)")) {
            GlideCompat.LoadSvgInAsster("enummodel.svg", imageView);
          } else if (hasInnerClass(code)) {
            GlideCompat.LoadSvgInAsster("ennerclass.svg", imageView);
          } else if (classOrInterface.isAnnotationDeclaration()) {
            GlideCompat.LoadSvgInAsster("ann.svg", imageView);
          } else if (classOrInterface.isEmpty()) {
            GlideCompat.LoadSvgInAsster("emptyclass.svg", imageView);
          } else if (isModelClass(code)) {
            GlideCompat.LoadSvgInAsster("modelclass.svg", imageView);
          } else {
            GlideCompat.LoadSvgInAsster("myclas.svg", imageView);
          }
        }

      } catch (ParseProblemException e) {
        e.printStackTrace();
      }
    }
  }

  public static void getAuthors(IdeEditor editor, ImageView img, TextView tv) {}

  public static boolean isHtml(String code) {
    try {
      var doc = Jsoup.parse(code);
      return doc != null && doc.text().isEmpty();
    } catch (Exception err) {
      return false;
    }
  }

  @Deprecated
  public static boolean isModelClass(String javaCode) {
    CompilationUnit cu;

    try {
      cu = StaticJavaParser.parse(javaCode); // parse java code
    } catch (ParseProblemException err) {
      Log.e("Error Code 0", "Java code is invalid: " + err.getMessage());
      return false; // return false, invalid java code
    }

    // Check all classes for model classes
    return cu.findAll(ClassOrInterfaceDeclaration.class).stream()
        .anyMatch(
            classDecl -> {
              // Initialize model class check
              boolean hasPublicFields =
                  classDecl.getFields().stream()
                      .anyMatch(
                          field ->
                              field.getModifiers().stream()
                                  .anyMatch(modifier -> modifier.equals("public")));

              if (hasPublicFields) {
                return false; // Not a model class due to public fields
              }

              List<String> methodNames =
                  classDecl.getMethods().stream()
                      .map(MethodDeclaration::getNameAsString)
                      .collect(Collectors.toList());

              // Check for getters and setters
              return classDecl.getFields().stream()
                  .allMatch(
                      field -> {
                        return field.getVariables().stream()
                            .allMatch(
                                variable -> {
                                  String getter = "get" + capitalize(variable.getNameAsString());
                                  String setter = "set" + capitalize(variable.getNameAsString());
                                  // Check if both getter and setter exist
                                  return methodNames.contains(getter)
                                      && methodNames.contains(setter);
                                });
                      });
            });
  }

  // Utility method to capitalize field names
  private static String capitalize(String str) {
    if (str == null || str.isEmpty()) {
      return str;
    }
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }

  public static boolean hasInnerClass(String filePath) {
    CompilationUnit cu;
    try {
      cu = StaticJavaParser.parse(filePath);
      InnerClassVisitor visitor = new InnerClassVisitor();
      visitor.visit(cu, null);
      return visitor.hasInnerClass();
    } catch (ParseProblemException e) {
      e.printStackTrace();
      return false;
    }
  }

  private static class InnerClassVisitor extends VoidVisitorAdapter<Void> {
    private boolean innerClassFound = false;

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {
      if (n.isInnerClass()) {
        innerClassFound = true;
      }

      super.visit(n, arg);
    }

    public boolean hasInnerClass() {
      return innerClassFound;
    }
  }

  /**
   * using like in comment
   *
   * @author Ninja
   */
}
