package ir.ninjacoder.ghostide.model;

public class JavaModel {
  private String name;
  private String code;

  public JavaModel(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return this.name;
  }

  public String getCode() {
    return this.code;
  }
}
