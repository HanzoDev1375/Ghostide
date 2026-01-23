package ir.ninjacoder.ghostide.core.model;

public class PluginMetaData {
  private final String pluginPath;
  private final String pluginName;
  private final String pluginIcon;
  private final Boolean pluginUsing;
  private final String pluginType; // .json,.kt
  private final String dexName;
  private final String dexPath;
  private final String dexPackage;

  public PluginMetaData(
      String pluginPath,
      String pluginName,
      String pluginIcon,
      Boolean pluginUsing,
      String pluginType,
      String dexName,
      String dexPath,
      String dexPackage) {
    this.pluginPath = pluginPath;
    this.pluginName = pluginName;
    this.pluginIcon = pluginIcon;
    this.pluginUsing = pluginUsing;
    this.pluginType = pluginType;
    this.dexName = dexName;
    this.dexPath = dexPath;
    this.dexPackage = dexPackage;
  }

  public String getPluginPath() {
    return this.pluginPath;
  }

  public String getPluginName() {
    return this.pluginName;
  }

  public String getPluginIcon() {
    return this.pluginIcon;
  }

  public Boolean getPluginUsing() {
    return this.pluginUsing;
  }

  public String getPluginType() {
    return this.pluginType;
  }

  public String getDexName() {
    return this.dexName;
  }

  public String getDexPath() {
    return this.dexPath;
  }

  public String getDexPackage() {
    return this.dexPackage;
  }
}
