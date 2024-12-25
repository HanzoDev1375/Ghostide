package ir.ninjacoder.ghostide.PluginManager.ModelPackage;

public class PackageModels {

  private String packageName;
  private String packageComponet; // like in ninjacoder.app.Main#nameClass
  private boolean isWorkable;
  private boolean isUinstall;

  public PackageModels(
      String packageName, String packageComponet, boolean isWorkable, boolean isUinstall) {
    this.packageName = packageName;
    this.packageComponet = packageComponet;
    this.isWorkable = isWorkable;
    this.isUinstall = isUinstall;
  }

  public String getPackageName() {
    return this.packageName;
  }

  

  public String getPackageComponet() {
    return this.packageComponet;
  }


  public boolean getIsWorkable() {
    return this.isWorkable;
  }

  public boolean getIsUinstall() {
    return this.isUinstall;
  }
}
