package ir.ninjacoder.ghostide.model;

public class ListitemModel {
    private String id;
    private int icon;

    public ListitemModel(String id, int icon) {
        this.id = id;
        this.icon = icon;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
