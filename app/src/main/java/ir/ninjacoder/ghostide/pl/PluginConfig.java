package ir.ninjacoder.ghostide.pl;

import java.util.List;

public class PluginConfig {
  private List<PluginInfo> plugins;

  public List<PluginInfo> getPlugins() {
    return plugins;
  }

  public void setPlugins(List<PluginInfo> plugins) {
    this.plugins = plugins;
  }

  public static class PluginInfo {
    private String name;
    private String dir;
    private String dev;

    // getters and setters
    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getDir() {
      return dir;
    }

    public void setDir(String dir) {
      this.dir = dir;
    }

    public String getDev() {
      return dev;
    }

    public void setDev(String dev) {
      this.dev = dev;
    }
  }
}
