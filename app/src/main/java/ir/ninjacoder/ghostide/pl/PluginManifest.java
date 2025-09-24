package ir.ninjacoder.ghostide.pl;

public class PluginManifest {
  private String dexpath;
  private String dexname;
  private String pkgname;

  // getters and setters
  public String getDexpath() {
    return dexpath;
  }

  public void setDexpath(String dexpath) {
    this.dexpath = dexpath;
  }

  public String getDexname() {
    return dexname;
  }

  public void setDexname(String dexname) {
    this.dexname = dexname;
  }

  public String getPkgname() {
    return pkgname;
  }

  public void setPkgname(String pkgname) {
    this.pkgname = pkgname;
  }
}
