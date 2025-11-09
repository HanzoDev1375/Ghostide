package ir.ninjacoder.prograsssheet.listchild;

public class Child {
  public String typeExz = "";
  private String iconFile;
  protected boolean showfab;
  protected Runnable languageProvider;

  public Child(String typeExz, String iconFile) {
    this.typeExz = typeExz;
    this.iconFile = iconFile;
  }

  public Child(boolean showfab, Runnable languageProvider,int id) {
    this.showfab = showfab;
    this.languageProvider = languageProvider;
  }

  public String getTypeExz() {
    return this.typeExz;
  }

  public String getIconFile() {
    return this.iconFile;
  }

  public boolean getShowfab() {
    return this.showfab;
  }

  public Runnable getLanguageProvider() {
    return languageProvider;
  }
}
