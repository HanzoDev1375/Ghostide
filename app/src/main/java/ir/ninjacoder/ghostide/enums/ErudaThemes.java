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
  NIGHT_OWL("Night Owl"),
  AMOLED("AMOLED"),
  // custom
  GHOST("Custom theme"),
  MATERIALTHEMES("material3 theme android");

  private final String themeName;

  ErudaThemes(String themeName) {
    this.themeName = themeName;
  }

  public String getThemeName() {
    return themeName;
  }

  public static ErudaThemes fromString(String text) {
    for (ErudaThemes theme : ErudaThemes.values()) {
      if (theme.themeName.equalsIgnoreCase(text)) {
        return theme;
      }
    }
    return DARK;
  }

  public static String[] getAllThemeNames() {
    ErudaThemes[] themes = values();
    String[] names = new String[themes.length];
    for (int i = 0; i < themes.length; i++) {
      names[i] = themes[i].getThemeName();
    }
    return names;
  }

}
