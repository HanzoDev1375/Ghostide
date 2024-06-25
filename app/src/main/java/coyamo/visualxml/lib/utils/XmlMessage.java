package coyamo.visualxml.lib.utils;

public class XmlMessage {
    public static final int TYPE_DEBUG = 0;
    public static final int TYPE_ERROR = 1;
    public static final int TYPE_WARN = 2;

    private int type = TYPE_DEBUG;
    private String message;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
