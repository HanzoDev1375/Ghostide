package ir.ninjacoder.ghostide.glidecompat.glidejavaparser;

import com.github.javaparser.ParserConfiguration;
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
    var config = new ParserConfiguration();
    config.setLanguageLevel(ParserConfiguration.LanguageLevel.BLEEDING_EDGE);
    StaticJavaParser.setConfiguration(config);
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
    boolean isException =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream()
            .anyMatch(
                c ->
                    c.getExtendedTypes().stream()
                        .anyMatch(t -> t.getNameAsString().endsWith("Exception")));

    boolean isJavaClass =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream()
            .anyMatch(
                c ->
                    c.getMethods().stream()
                        .anyMatch(
                            m ->
                                m.isPublic()
                                    && m.isStatic()
                                    && m.getNameAsString().equals("main")
                                    && m.getType().toString().equals("void")
                                    && m.getParameters().size() == 1
                                    && m.getParameter(0).getType().toString().equals("String[]")));

    boolean isAndroidClass =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream()
            .anyMatch(
                cs ->
                    cs.getMethods().stream()
                        .anyMatch(
                            m ->
                                m.isAnnotationPresent("Override")
                                    && m.getNameAsString().equals("onCreate")
                                    && m.getParameters().size() == 1
                                    && m.getParameter(0).getType().toString().equals("Bundle")));
    boolean hasFragmentMethod =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream()
            .anyMatch(
                cs ->
                    cs.getMethods().stream()
                        .anyMatch(
                            m ->
                                m.isAnnotationPresent("Override")
                                    && m.getNameAsString().equals("onCreateView")
                                    && m.getParameters().size() == 3
                                    && m.getParameter(0)
                                        .getType()
                                        .toString()
                                        .equals("LayoutInflater")
                                    && m.getParameter(1).getType().toString().equals("ViewGroup")
                                    && m.getParameter(2).getType().toString().equals("Bundle")));
    boolean isGeneric =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream().anyMatch(this::get);

    return new JavaAnalysisResult(
        isInterface,
        isClass,
        isAbstract,
        isEnum,
        isinnerClass,
        isAnnotation,
        isAbstractException,
        isJavaClass,
        isAndroidClass,
        hasFragmentMethod,isGeneric);
  }

  private boolean get(ClassOrInterfaceDeclaration clazz) {
    if (!clazz.getTypeParameters().isEmpty()) {
      return true;
    }
    boolean extendsGeneric =
        clazz.getExtendedTypes().stream().anyMatch(type -> type.toString().contains("<"));

    boolean implementsGeneric =
        clazz.getImplementedTypes().stream().anyMatch(type -> type.toString().contains("<"));

    return extendsGeneric || implementsGeneric;
  }
}
