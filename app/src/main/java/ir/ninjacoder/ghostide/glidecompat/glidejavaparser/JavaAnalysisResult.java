package ir.ninjacoder.ghostide.glidecompat.glidejavaparser;

public class JavaAnalysisResult {
  private final boolean isInterface;
  private final boolean isClass;
  private final boolean isAbstract;
  private final boolean isEnum;
  private final boolean isInnerClass;
  public JavaAnalysisResult(
      boolean isInterface, boolean isClass, boolean isAbstract, boolean isEnum,boolean isInnerClass) {

    this.isInterface = isInterface;
    this.isClass = isClass;
    this.isAbstract = isAbstract;
    this.isEnum = isEnum;
    this.isInnerClass = isInnerClass;
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
  public boolean isInner(){
      return this.isInnerClass;
  }
}
