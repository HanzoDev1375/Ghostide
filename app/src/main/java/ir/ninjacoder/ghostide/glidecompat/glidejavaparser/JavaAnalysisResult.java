package ir.ninjacoder.ghostide.glidecompat.glidejavaparser;

public class JavaAnalysisResult {
  private final boolean isInterface;
  private final boolean isClass;
  private final boolean isAbstract;
  private final boolean isEnum;

  public JavaAnalysisResult(
      boolean isInterface, boolean isClass, boolean isAbstract, boolean isEnum) {

    this.isInterface = isInterface;
    this.isClass = isClass;
    this.isAbstract = isAbstract;
    this.isEnum = isEnum; 
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
}
