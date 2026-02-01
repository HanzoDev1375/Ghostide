package ir.ninjacoder.prograsssheet.datalist;

public class DataListModel {
  private final String title;
  private final String subtitle;
  private final boolean isCopyLabel;

  public DataListModel(String title, String subtitle, boolean isCopyLabel) {
    this.title = title;
    this.subtitle = subtitle;
    this.isCopyLabel = isCopyLabel;
  }

  public String getTitle() {
    return this.title;
  }

  public String getSubtitle() {
    return this.subtitle;
  }

  public boolean getIsCopyLabel() {
    return this.isCopyLabel;
  }
}
