package lsp4custom.com.ninjacoder.javapaserdata;

import android.annotation.TargetApi;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

@TargetApi(24)
public class ClassNav {
  protected String text;

  public ClassNav(String text) {
    this.text = text;
    main();
  }

  private List<Row> listRow = new ArrayList<>();

  void main() {
    var cu = StaticJavaParser.parse(text);
    cu.accept(
        new VoidVisitorAdapter<Void>() {

          @Override
          public void visit(FieldDeclaration usedName, Void mvoid) {

            usedName
                .getVariables()
                .forEach(
                    it -> {
                      int line = it.getBegin().get().line;
                      int column = it.getBegin().get().column;
                      String texts = it.getNameAsString();
                      listRow.add(new Row("Var ", texts, line, column));
                    });
            super.visit(usedName, mvoid);
          }

          @Override
          public void visit(MethodDeclaration usedName, Void mvoid) {
            int line = usedName.getBegin().get().line;
            int column = usedName.getBegin().get().column;
            String texts = usedName.getNameAsString();
            listRow.add(new Row("Method ", texts, line, column));
            super.visit(usedName, mvoid);
          }

          @Override
          public void visit(NameExpr usedName, Void mvoid) {
            int line = usedName.getBegin().get().line;
            int column = usedName.getBegin().get().column;
            String texts = usedName.getNameAsString();
            listRow.add(new Row("NameExpr ", texts, line, column));
            super.visit(usedName, mvoid);
          }

          @Override
          public void visit(Parameter usedName, Void mvoid) {
            int line = usedName.getBegin().get().line;
            int column = usedName.getBegin().get().column;
            String texts = usedName.getNameAsString();
            listRow.add(new Row("Paramater ", texts, line, column));
            super.visit(usedName, mvoid);
          }

          @Override
          public void visit(TypeParameter usedName, Void mvoid) {
            int line = usedName.getBegin().get().line;
            int column = usedName.getBegin().get().column;
            String texts = usedName.getNameAsString();
            listRow.add(new Row("TypeParamater ", texts, line, column));
            super.visit(usedName, mvoid);
          }

          @Override
          public void visit(ImportDeclaration usedName, Void mvoid) {
            int line = usedName.getBegin().get().line;
            int column = usedName.getBegin().get().column;
            String texts = usedName.getNameAsString();
            listRow.add(new Row("Import ", texts, line, column));
            super.visit(usedName, mvoid);
          }

          @Override
          public void visit(PackageDeclaration usedName, Void mvoid) {
            int line = usedName.getBegin().get().line;
            int column = usedName.getBegin().get().column;
            String texts = usedName.getNameAsString();
            listRow.add(new Row("Package ", texts, line, column));
            super.visit(usedName, mvoid);
          }

          @Override
          public void visit(ClassOrInterfaceDeclaration usedName, Void mvoid) {
            int line = usedName.getBegin().get().line;
            int column = usedName.getBegin().get().column;
            String texts = usedName.getNameAsString();
            listRow.add(new Row("Class ", texts, line, column));
            super.visit(usedName, mvoid);
          }
        },
        null);
  }

  public List<Row> getListRow() {
    return this.listRow;
  }

  
}
