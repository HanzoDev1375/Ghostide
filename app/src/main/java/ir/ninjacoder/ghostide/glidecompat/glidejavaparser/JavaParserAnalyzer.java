package ir.ninjacoder.ghostide.glidecompat.glidejavaparser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.AnnotationDeclaration;
import java.io.File;
import java.io.IOException;

public class JavaParserAnalyzer implements JavaCodeAnalyzer {
  @Override
  public JavaAnalysisResult analyze(File javaFile) throws IOException {
    CompilationUnit cu = StaticJavaParser.parse(javaFile);

    boolean isInterface =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream()
            .anyMatch(ClassOrInterfaceDeclaration::isInterface);

    boolean isClass =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream().anyMatch(c -> !c.isInterface());

    boolean isAbstract =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream()
            .anyMatch(ClassOrInterfaceDeclaration::isAbstract);

    boolean isEnum =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream().anyMatch(c -> c.isEnumDeclaration());

    return new JavaAnalysisResult(isInterface, isClass, isAbstract, isEnum);
  }
}
