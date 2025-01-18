package ir.ninjacoder.ghostide.model;

public class JavaModel {
  private String name;
  private String code;
  private int color;

  public JavaModel(String name, String code, int color) {
    this.name = name;
    this.code = code;
    this.color = color;
  }

  public int getColor() {
    return this.color;
  }

  public String getName() {
    return this.name;
  }

  public String getCode() {
    return this.code;
  }
}
