package ir.ninjacoder.ghostide.model;

public class Season {
  String name;
  int id;

  public Season(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.id;
  }
}
