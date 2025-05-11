package ir.ninjacoder.ghostide.glidecompat.glidejavaparser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
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

    boolean isinnerClass =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream()
            .anyMatch(ClassOrInterfaceDeclaration::isInnerClass);
    boolean toplevel =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream()
            .anyMatch(ClassOrInterfaceDeclaration::isTopLevelType);
    boolean isEnum =
        cu.findAll(EnumDeclaration.class).stream().anyMatch(c -> c.isEnumDeclaration());
    boolean isAnnotation =
        cu.findAll(AnnotationDeclaration.class).stream().anyMatch(c -> c.isAnnotationDeclaration());
    // test
    boolean isAbstractException =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream()
            .filter(ClassOrInterfaceDeclaration::isAbstract)
            .anyMatch(
                c ->
                    c.getExtendedTypes().stream()
                        .anyMatch(t -> t.getNameAsString().endsWith("Exception")));
    return new JavaAnalysisResult(
        isInterface, isClass, isAbstract, isEnum, isinnerClass, isAnnotation, isAbstractException);
  }
}
