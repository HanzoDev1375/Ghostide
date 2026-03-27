package ir.ninjacoder.ghostide.core.mult;

public enum MultiSelectionAction {
  COPY(0, "copy"),
  MOVE(1, "move"),
  DELETE(2, "delete"),
  SHARE(3, "share"),
  ZIP(4, "zip"),
  RENAME(5, "rename"),
  MORE(6, "more");

  private final int id;
  private final String title;

  MultiSelectionAction(int id, String title) {
    this.id = id;
    this.title = title;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public static MultiSelectionAction fromId(int id) {
    for (var action : values()) {
      if (action.getId() == id) {
        return action;
      }
    }
    return COPY;
  }
}
