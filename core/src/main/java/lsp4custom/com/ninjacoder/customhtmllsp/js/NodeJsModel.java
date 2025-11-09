package lsp4custom.com.ninjacoder.customhtmllsp.js;

public class NodeJsModel {
  private String name;
  private JsKind kind;

  public NodeJsModel(String name, JsKind kind) {
    this.name = name;
    this.kind = kind;
  }

  public String getName() {
    return this.name;
  }

  public JsKind getKind() {
    return this.kind;
  }

  @Override
  public String toString() {
    return "NodeJsModel[name=" + name + ", kind=" + kind.name() + "]";
  }
}
