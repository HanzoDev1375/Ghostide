package ir.ninjacoder.ghostide.model;

public class ItemSheet {

  protected boolean click;
  private String name;
  private int icon;
  private boolean en;

  public ItemSheet(String name, int icon, boolean en) {
    this.name = name;
    this.icon = icon;
    this.en = en;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getIcon() {
    return this.icon;
  }

  public void setIcon(int icon) {
    this.icon = icon;
  }

  public boolean getClick() {
    return this.click;
  }

  public void setClick(boolean click) {
    this.click = click;
  }

  public boolean getEn() {
    return this.en;
  }

  public void setEn(boolean en) {
    this.en = en;
  }
}
