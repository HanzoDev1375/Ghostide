package ir.ninjacoder.ghostide.model;

public class CursorIconModel {
  private int icon;
  private int headericon;
  private String nameicon;
  private String iconhader;
  private boolean isPremium;

  /**
   * using in class like me main icon -> ghost icon header icon -> nife icon from ghost name icon ->
   * ghost icon name header -> nife icon isPremium -> true (ghost ide this free in version 2.0.1j)
   */
  public CursorIconModel(
      int icon, int headericon, String nameicon, String iconhader, boolean isPremium) {
    this.icon = icon;
    this.headericon = headericon;
    this.nameicon = nameicon;
    this.iconhader = iconhader;
    this.isPremium = isPremium;
  }

  public int getIcon() {
    return this.icon;
  }

  public int getHeadericon() {
    return this.headericon;
  }

  public String getNameicon() {
    return this.nameicon;
  }

  public String getIconhader() {
    return this.iconhader;
  }

  public boolean getIsPremium() {
    return this.isPremium;
  }
}
