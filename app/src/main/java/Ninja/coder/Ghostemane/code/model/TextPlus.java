package Ninja.coder.Ghostemane.code.model;

public class TextPlus {
    private String name;
    private int icon;

    public TextPlus(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
