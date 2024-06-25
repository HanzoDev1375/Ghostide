package com.mcal.uidesigner;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class PropertyObject {
    private final Map<Class<?>, Object> setterObjects = new HashMap<>();
    public Object obj;

    public PropertyObject(Object obj) {
        this.obj = obj;
    }

    public void setProperty(XmlLayoutProperties.PropertySpec property, Object value) {
        if (value != null) {
            try {
                Object setterObj = obj;
                if (property.setterProxyClass != null && (setterObj = setterObjects.get(property.setterProxyClass)) == null) {
                    setterObj = property.setterProxyClass.getConstructor(new Class[]{Object.class}).newInstance(this.obj);
                    setterObjects.put(property.setterProxyClass, setterObj);
                }
                if (property.setterName.endsWith("()")) {
                    Class<?> valueType = property.type.valueType;
                    if (valueType == Enum.class) {
                        valueType = property.constantClass;
                    }
                    String methodName = property.setterName.substring(0, property.setterName.length() - 2);
                    setterObj.getClass().getMethod(methodName, new Class[]{valueType}).invoke(setterObj, value);
                    return;
                }
                setterObj.getClass().getField(property.setterName).set(setterObj, value);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean hasProperty(@NonNull XmlLayoutProperties.PropertySpec property) {
        return property.targetClass != null && property.targetClass.isInstance(this.obj);
    }
}
