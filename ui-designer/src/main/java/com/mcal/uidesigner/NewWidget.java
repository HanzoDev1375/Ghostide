package com.mcal.uidesigner;

import java.util.Map;

public class NewWidget {
    public Map<String, String> attributes;
    public String elementName;

    public NewWidget(String elementName, Map<String, String> attributes) {
        this.elementName = elementName;
        this.attributes = attributes;
    }
}
