package ir.ninjacoder.ghostide.core.model;

public class CodeEditorModel {

  private String name;
  private String path;
  private String position;
  private Boolean pinmod;
  private Boolean textchange;

  public CodeEditorModel(
      String name, String path, String position, Boolean pinmod, Boolean textchange) {
    this.name = name;
    this.path = path;
    this.position = position;
    this.pinmod = pinmod;
    this.textchange = textchange;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPath() {
    return this.path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getPosition() {
    return this.position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Boolean getPinmod() {
    return this.pinmod != null ? this.pinmod : false;
  }

  public void setPinmod(Boolean pinmod) {
    this.pinmod = pinmod;
  }

  public Boolean getTextchange() {
    return this.textchange != null ? this.textchange : false;
  }

  public void setTextchange(Boolean textchange) {
    this.textchange = textchange;
  }

  @Override
  public String toString() {
    return "CodeEditorModel{"
        + "name='"
        + name
        + '\''
        + ", path='"
        + path
        + '\''
        + ", position='"
        + position
        + '\''
        + ", pinmod="
        + pinmod
        + ", textchange="
        + textchange
        + '}';
  }
}
