package com.mcal.uidesigner;

import androidx.annotation.NonNull;

import org.w3c.dom.Attr;

public class AttributeValue {
    public final Attr attr;
    public final XmlLayoutProperties.PropertySpec property;
    public final String value;

    public AttributeValue(XmlLayoutProperties.PropertySpec property, String value) {
        this.property = property;
        this.value = value;
        this.attr = null;
    }

    public AttributeValue(XmlLayoutProperties.PropertySpec property, @NonNull Attr attr) {
        this.property = property;
        this.value = attr.getValue();
        this.attr = attr;
    }

    public AttributeValue(XmlLayoutProperties.PropertySpec property) {
        this.property = property;
        this.value = null;
        this.attr = null;
    }

    public static String getDisplayValue(String value) {
        if (value == null || value.length() == 0) {
            return value;
        }
        if (value.startsWith("@id/")) {
            return value.substring("@id/".length());
        }
        if (value.startsWith("?android:attr/")) {
            value = "Android_" + value.substring("?android:attr/".length());
        }
        if (!Character.isLetter(value.charAt(0))) {
            return value;
        }
        StringBuilder result = new StringBuilder();
        result.append(Character.toUpperCase(value.charAt(0)));
        boolean nextUpper = false;
        for (int i = 1; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (nextUpper) {
                result.append(Character.toUpperCase(ch));
                nextUpper = false;
            } else if (ch == '|') {
                nextUpper = true;
                result.append(" | ");
            } else if (ch == '_') {
                nextUpper = true;
                result.append(" ");
            } else {
                if (Character.isUpperCase(ch)) {
                    result.append(" ");
                }
                result.append(ch);
            }
        }
        return result.toString();
    }

    public String getDisplayValue() {
        if (this.property.type == XmlLayoutProperties.PropertyType.Text) {
            return "&quot;" + this.value + "&quot;";
        }
        return getDisplayValue(this.value);
    }

    public boolean hasValue() {
        return this.value != null;
    }

    public boolean isStyled() {
        return hasValue() && this.attr == null;
    }
}
