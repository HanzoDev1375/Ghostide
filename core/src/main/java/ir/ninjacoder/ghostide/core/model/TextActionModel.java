package ir.ninjacoder.ghostide.core.model;

public class TextActionModel {
    public String name;
    public int icomName;

    public TextActionModel(String name, int icomName) {
        this.name = name;
        this.icomName = icomName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcomName() {
        return this.icomName;
    }

    public void setIcomName(int icomName) {
        this.icomName = icomName;
    }
}
