package ir.ninjacoder.ghostide.PluginManager.ModelPackage;

import android.graphics.drawable.Drawable;

public class AppInfo {
  private String name;
  private Drawable icon;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Drawable getIcon() {
    return this.icon;
  }

  public void setIcon(Drawable icon) {
    this.icon = icon;
  }
}
