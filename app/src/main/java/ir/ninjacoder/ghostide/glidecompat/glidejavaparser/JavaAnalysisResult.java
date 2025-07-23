package ir.ninjacoder.ghostide.glidecompat.glidejavaparser;

public class JavaAnalysisResult {
  private final boolean isInterface;
  private final boolean isClass;
  private final boolean isAbstract;
  private final boolean isEnum;
  private final boolean isInnerClass;
  private final boolean isAnnotation;
  private final boolean isAbstractException;
  private final boolean isJavaClass;
  private final boolean isAndroidClass;
  private final boolean isFragmentClass;
  private final boolean isGenericClass;
  private final boolean isJavaStandardClass;
  private final boolean isAndroidViews;
  public JavaAnalysisResult(
      boolean isInterface,
      boolean isClass,
      boolean isAbstract,
      boolean isEnum,
      boolean isInnerClass,
      boolean isAnnotation,
      boolean isAbstractException,
      boolean isJavaClass,
      boolean isAndroidClass,
      boolean isFragmentClass,
      boolean isGenericClass,
      boolean isJavaStandardClass,boolean isAndroidViews) {

    this.isInterface = isInterface;
    this.isClass = isClass;
    this.isAbstract = isAbstract;
    this.isEnum = isEnum;
    this.isInnerClass = isInnerClass;
    this.isAnnotation = isAnnotation;
    this.isAbstractException = isAbstractException;
    this.isJavaClass = isJavaClass;
    this.isAndroidClass = isAndroidClass;
    this.isFragmentClass = isFragmentClass;
    this.isGenericClass = isGenericClass;
    this.isJavaStandardClass = isJavaStandardClass;
	this.isAndroidViews=isAndroidViews;
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

  public boolean isJavaClass() {
    return this.isJavaClass;
  }

  public boolean isAndroidClass() {
    return this.isAndroidClass;
  }

  public boolean isFragmentClass() {
    return this.isFragmentClass;
  }

  public boolean isGenericClass() {
    return isGenericClass;
  }

  public boolean isJavaStandardClass() {
    return isJavaStandardClass;
  }
  public boolean isAndroidViews(){
	  return this.isAndroidViews;
  }
}
