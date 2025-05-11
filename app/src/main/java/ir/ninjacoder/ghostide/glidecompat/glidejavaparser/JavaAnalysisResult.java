package ir.ninjacoder.ghostide.glidecompat.glidejavaparser;

public class JavaAnalysisResult {
  private final boolean isInterface;
  private final boolean isClass;
  private final boolean isAbstract;
  private final boolean isEnum;
  private final boolean isInnerClass;
  private final boolean isAnnotation;
  private final boolean isAbstractException;

  public JavaAnalysisResult(
      boolean isInterface,
      boolean isClass,
      boolean isAbstract,
      boolean isEnum,
      boolean isInnerClass,
      boolean isAnnotation,
      boolean isAbstractException) {

    this.isInterface = isInterface;
    this.isClass = isClass;
    this.isAbstract = isAbstract;
    this.isEnum = isEnum;
    this.isInnerClass = isInnerClass;
    this.isAnnotation = isAnnotation;
    this.isAbstractException = isAbstractException;
  }

  // Getter methods
  public boolean isInterface() {
    return isInterface;
  }

  public boolean isClass() {
    return isClass;
  }

  public boolean isAbstract() {
    return isAbstract;
  }

  public boolean isEnum() {
    return this.isEnum;
  }

  public boolean isInner() {
    return this.isInnerClass;
  }

  public boolean isAnnotation() {
    return this.isAnnotation;
  }

  public boolean isAbstractException() {
    return this.isAbstractException;
  }
}
