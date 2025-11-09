package lsp4custom.com.ninjacoder.javapaserdata;

public class Row {
  protected String name;
  protected String title;
  protected int line;
  protected int column;

  public Row(String name, String title, int line, int column) {
    this.name = name;
    this.title = title;
    this.line = line;
    this.column = column;
  }

  public String getName() {
    return this.name;
  }

  public String getTitle() {
    return this.title;
  }

  public int getLine() {
    return this.line;
  }

  public int getColumn() {
    return this.column;
  }
}
