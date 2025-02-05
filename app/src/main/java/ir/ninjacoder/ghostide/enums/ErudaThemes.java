package ir.ninjacoder.ghostide.enums;

public enum ErudaThemes {
  DARK("Dark"),
  MATERIAL_OCEANIC("Material Oceanic"),
  MATERIAL_DARKER("Material Darker"),
  MATERIAL_PALENIGHT("Material Palenight"),
  MATERIAL_DEEP_OCEAN("Material Deep Ocean"),
  MONOKAI_PRO("Monokai Pro"),
  DRACULA("Dracula"),
  ARC_DARK("Arc Dark"),
  ATOM_ONE_DARK("Atom One Dark"),
  SOLARIZED_DARK("Solarized Dark"),
  NIGHT_OWL("Night Owl");

  private String themeName = "Dark";

  ErudaThemes(String themeName) {
    this.themeName = themeName;
  }

  public String getThemeName() {
    return themeName;
  }
}
