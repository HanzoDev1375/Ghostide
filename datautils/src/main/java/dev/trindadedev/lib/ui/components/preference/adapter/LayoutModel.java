package dev.trindadedev.lib.ui.components.preference.adapter;

public class LayoutModel {

  protected String name;
  protected String title;

  public LayoutModel(String name, String title) {
    this.name = name;
    this.title = title;
  }

  public String getName() {
    return this.name;
  }

  public String getTitle() {
    return this.title;
  }
}
