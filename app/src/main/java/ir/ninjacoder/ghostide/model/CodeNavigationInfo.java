package ir.ninjacoder.ghostide.model;

public class CodeNavigationInfo {
  protected int lineIndex;
  protected String methodDesc;
  protected boolean isMethod;

  public CodeNavigationInfo(int lineIndex, String methodDesc, boolean isMethod) {
    this.lineIndex = lineIndex;
    this.methodDesc = methodDesc;
    this.isMethod = isMethod;
  }

  public int getLineIndex() {
    return this.lineIndex;
  }

  public void setLineIndex(int lineIndex) {
    this.lineIndex = lineIndex;
  }

  public String getMethodDesc() {
    return this.methodDesc;
  }

  public void setMethodDesc(String methodDesc) {
    this.methodDesc = methodDesc;
  }

  public boolean getIsMethod() {
    return this.isMethod;
  }

  public void setIsMethod(boolean isMethod) {
    this.isMethod = isMethod;
  }
}
