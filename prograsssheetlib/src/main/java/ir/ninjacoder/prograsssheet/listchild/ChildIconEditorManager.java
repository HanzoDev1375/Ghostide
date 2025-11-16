package ir.ninjacoder.prograsssheet.listchild;

public class ChildIconEditorManager {
  private final String iconFile;
  protected final ChildItemClick click;

  public ChildIconEditorManager(String iconFile, ChildItemClick click) {
    this.iconFile = iconFile;
    this.click = click;
  }

  public String getIconFile() {
    return this.iconFile;
  }

  public ChildItemClick getClick() {
    return this.click;
  }
}
