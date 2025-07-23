package ir.ninjacoder.ghostide.glidecompat.glidejavaparser;

import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.AnnotationDeclaration;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
    boolean isGeneric = cu.findAll(ClassOrInterfaceDeclaration.class).stream().anyMatch(this::get);
    boolean isJavaStandardClass =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream().anyMatch(this::isStandardJavaClass);
    boolean isAndroidViews =
        cu.findAll(ClassOrInterfaceDeclaration.class).stream()
            .anyMatch(this::isStandardAndroidViews);

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
        hasFragmentMethod,
        isGeneric,
        isJavaStandardClass,
        isAndroidViews);
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

  private boolean isStandardJavaClass(ClassOrInterfaceDeclaration clazz) {
    try {
      InputStream jsonFile = GhostIdeAppLoader.getContext().getAssets().open("javaclass.json");
      List<JavaModel> javaClasses =
          new Gson()
              .fromJson(
                  new InputStreamReader(jsonFile), new TypeToken<List<JavaModel>>() {}.getType());

      // Check extended types
      boolean extendsJavaClass =
          clazz.getExtendedTypes().stream()
              .anyMatch(
                  extendedType ->
                      javaClasses.stream()
                          .anyMatch(
                              model ->
                                  model.getJavaClassName().equals(extendedType.getNameAsString())));
      boolean implementsJavaClass =
          clazz.getImplementedTypes().stream()
              .anyMatch(
                  implementedType ->
                      javaClasses.stream()
                          .anyMatch(
                              model ->
                                  model
                                      .getJavaClassName()
                                      .equals(implementedType.getNameAsString())));

      return extendsJavaClass || implementsJavaClass;
    } catch (Exception err) {
      err.printStackTrace();
      return false;
    }
  }

  private boolean isStandardAndroidViews(ClassOrInterfaceDeclaration clazz) {
    try {
      InputStream jsonFile = GhostIdeAppLoader.getContext().getAssets().open("androidviews.json");
      List<AndroidView> androidViews =
          new Gson()
              .fromJson(
                  new InputStreamReader(jsonFile), new TypeToken<List<AndroidView>>() {}.getType());

      // Check extended types
      boolean extendsAndroidView =
          clazz.getExtendedTypes().stream()
              .anyMatch(
                  extendedType ->
                      androidViews.stream()
                          .anyMatch(
                              view ->
                                  view.getAndroidViews().equals(extendedType.getNameAsString())));

      // Check implemented types
      boolean implementsAndroidView =
          clazz.getImplementedTypes().stream()
              .anyMatch(
                  implementedType ->
                      androidViews.stream()
                          .anyMatch(
                              view ->
                                  view.getAndroidViews()
                                      .equals(implementedType.getNameAsString())));

      return extendsAndroidView || implementsAndroidView;
    } catch (Exception err) {
      err.printStackTrace();
      return false;
    }
  }

  class JavaModel {
    private String JavaClassName;

    public String getJavaClassName() {
      return this.JavaClassName;
    }
  }

  class AndroidView {
    private String androidViews;

    public String getAndroidViews() {
      return this.androidViews;
    }
  }
}
