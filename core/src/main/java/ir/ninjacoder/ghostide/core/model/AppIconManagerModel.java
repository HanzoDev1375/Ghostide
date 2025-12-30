package ir.ninjacoder.ghostide.core.model;

public class AppIconManagerModel {
  private final String name;
  private final int iconRes;

  public AppIconManagerModel(String name, int iconRes) {
    this.name = name;
    this.iconRes = iconRes;
  }

  public String getName() {
    return this.name;
  }

  public int getIconRes() {
    return this.iconRes;
  }
}
