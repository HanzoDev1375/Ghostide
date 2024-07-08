package Ninja.coder.Ghostemane.code.model;

import androidx.lifecycle.ViewModel;

public class EditorViewModel extends ViewModel {

  private String Text = "";
  private int Cursor = 0;

  public String getText() {
    return this.Text;
  }

  public void setText(String Text) {
    this.Text = Text;
  }

  public int getCursor() {
    return this.Cursor;
  }

  public void setCursor(int Cursor) {
    this.Cursor = Cursor;
  }
}
