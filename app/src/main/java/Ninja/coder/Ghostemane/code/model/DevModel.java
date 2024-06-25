package Ninja.coder.Ghostemane.code.model;

public class DevModel {
    protected String name;
    protected String user;

    public DevModel(String name, String user) {
        this.name = name;
        this.user = user;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
