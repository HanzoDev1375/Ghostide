package io.github.rosemoe.sora.langs.java;

import Ninja.coder.Ghostemane.code.ApplicationLoader;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import android.util.*;
import org.antlr.parser.antlr4.java20.Java20Lexer;
import org.antlr.parser.antlr4.java20.Java20Parser;
import org.antlr.parser.antlr4.java20.Java20ParserBaseListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

class JavaCodeA implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      if (ApplicationLoader.getAnalyzercod().getBoolean("Analyzercod", false) == true) {

        ANTLRInputStream input = new ANTLRInputStream(content.toString());
        Java20Lexer lexer = new Java20Lexer(input);
        CommonTokenStream stream = new CommonTokenStream(lexer);
        Java20Parser paser = new Java20Parser(stream);
        Java20ParserBaseListener base =
            new Java20ParserBaseListener() {
              @Override
              public void visitErrorNode(ErrorNode node) {
                super.visitErrorNode(node);
                // TODO: Implement this method
                int line = node.getSymbol().getLine();
                int col = node.getSymbol().getCharPositionInLine();
                int[] errorMatch = Utils.setErrorSpan(result, line, col);
              }
            };
        ParseTreeWalker tree = new ParseTreeWalker();
        tree.walk(base, paser.start_());
      }
      Set<String> un = new HashSet<>();
      Set<String> cun = new HashSet<>();
      Set<String> contextName = new HashSet<>();
      Set<String> paramNameMode = new HashSet<>();

      CompilationUnit it = StaticJavaParser.parse(content.toString());

      it.accept(
          new VoidVisitorAdapter<Void>() {
            @Override
            public void visit(MethodCallExpr n, Void arg) {
              String methodName = n.getNameAsString();
              // اگر نام متد در مجموعه un وجود داشته باشد
              un.add(methodName);
              if (un.contains(methodName)) {
                int line = n.getBegin().get().line;
                int col = n.getBegin().get().column;
                Utils.setSpanEFO(result, line, col, EditorColorScheme.javafield);
                Log.w("MECall", "Line: " + line + " Column: " + col + " Method: " + methodName);
              } else {
                // اخطار برای متدهای غیرتعریف شده
                int line = n.getBegin().get().line;
                int col = n.getBegin().get().column;
                Utils.setWaringSpan(result, line, col);
              }
              super.visit(n, arg);
            }
          },
          null);

      it.accept(
          new VoidVisitorAdapter<Void>() {

            @Override
            public void visit(FieldDeclaration md, Void arg1) {
              for (var it : md.getVariables()) {

                int line = it.getName().getBegin().get().line;
                int col = it.getName().getBegin().get().column + 2; // +2 برای قرار گرفتن پس از نوع
                Utils.setSpanEFO(result, line, col, EditorColorScheme.javafield);
              }
              super.visit(md, arg1);
            }

            @Override
            public void visit(MethodDeclaration n, Void arg) {
              String methodName = n.getNameAsString();

              if (!un.contains(methodName)) {
                int line = n.getBegin().get().line;
                int col = n.getBegin().get().column + 2;
                Utils.setWaringSpan(result, line, col);
              }
              super.visit(n, arg);
            }

          },
          null);

      

      it.accept(
          new VoidVisitorAdapter<Void>() {
            @Override
            public void visit(ClassOrInterfaceDeclaration n, Void arg) {
              var className = n.getNameAsString();
              cun.add(className);

              super.visit(n, arg);
            }

            @Override
            public void visit(ConstructorDeclaration n, Void arg) {
              String constructorName = n.getNameAsString();
              // بررسی کنید که آیا نام کانستراکتور در مجموعه un وجود دارد
              if (cun.contains(constructorName)) {
                int line = n.getBegin().get().line;
                int col = n.getBegin().get().column;
                // تغییر رنگ برای نام کانستراکتور
                Utils.setSpanEFO(result, line, col, EditorColorScheme.javaoprator);
                Log.w(
                    "ConstructorCall",
                    "Line : " + line + " Column: " + col + " " + constructorName);
              }

              super.visit(n, arg);
            }
          },
          null);

    } catch (Exception err) {
      // Handle exception if necessary
    }
  }
}
