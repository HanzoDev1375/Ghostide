package Ninja.coder.Ghostemane.code.config;

import Ninja.coder.Ghostemane.code.IdeEditor;
import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.glidecompat.GlideCompat;
import Ninja.coder.Ghostemane.code.marco.RegexUtilCompat;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
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

                } else {

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
                ColorAndroid12.runOnUiThread(
                    () -> {
                      GlideCompat.GlideNormal(imageView, R.drawable.antlr4_grammer_normal);
                    });
              }

              if (RegexUtilCompat.RegexSelect("(lexer\\sgrammar\\s\\w+)\\;", code)) {
                ColorAndroid12.runOnUiThread(
                    () -> {
                      GlideCompat.GlideNormal(imageView, R.drawable.antlr4_lexer);
                    });
              }
              if (RegexUtilCompat.RegexSelect("(parser\\sgrammar\\s\\w+)\\;", code)) {
                ColorAndroid12.runOnUiThread(
                    () -> {
                      GlideCompat.GlideNormal(imageView, R.drawable.antlr_parser);
                    });
              }
            })
        .start();
  }

  public static void getFileJavaAsChild(ImageView imageView, String file) {
    new Thread(
            new Runnable() {
              public void run() {
                String code = FileUtil.readFile(file);
                if (code != null) {
                  try {
                    CompilationUnit cu = StaticJavaParser.parse(code);
                    ClassOrInterfaceDeclaration classOrInterface =
                        cu.findFirst(ClassOrInterfaceDeclaration.class).orElse(null);
                    if (classOrInterface != null) {
                      if (classOrInterface.isInterface()) {
                        // Code that runs when it's an interface
                        ColorAndroid12.runOnUiThread(
                            () -> {
                              GlideCompat.LoadSvgInAsster("myface.svg", imageView);
                            });

                      } else if (classOrInterface.isAbstract()) {
                        ColorAndroid12.runOnUiThread(
                            () -> {
                              GlideCompat.LoadSvgInAsster("absclass.svg", imageView);
                            });

                      } else if (classOrInterface.isEnumDeclaration()) {
                        ColorAndroid12.runOnUiThread(
                            () -> {
                              GlideCompat.LoadSvgInAsster("enummodel.svg", imageView);
                            });

                      } else if (classOrInterface.isInnerClass()) {
                        ColorAndroid12.runOnUiThread(
                            () -> {
                              GlideCompat.LoadSvgInAsster("ennerclass.svg", imageView);
                            });
                      } else if (classOrInterface.isAnnotationDeclaration()) {
                        ColorAndroid12.runOnUiThread(
                            () -> {
                              GlideCompat.LoadSvgInAsster("ann.svg", imageView);
                            });
                      } else if (classOrInterface.isEmpty()) {
                        ColorAndroid12.runOnUiThread(
                            () -> {
                              GlideCompat.LoadSvgInAsster("emptyclass.svg", imageView);
                            });
                      } else {
                        ColorAndroid12.runOnUiThread(
                            () -> {
                              GlideCompat.LoadSvgInAsster("myclas.svg", imageView);
                            });
                      }
                    }

                  } catch (ParseProblemException e) {
                    e.printStackTrace();
                  }
                }
              }
            })
        .start();
  }

  public static void getAuthors(IdeEditor editor, ImageView img, TextView tv) {
    
  }

  public static boolean isHtml(String code) {
    try {
      var doc = Jsoup.parse(code);
      return doc != null && doc.text().isEmpty();
    } catch (Exception err) {
      return false;
    }
  }

  /**
   * using like in comment
   *
   * @author Ninja
   */
  
}
