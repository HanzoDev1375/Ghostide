package coyamo.visualxml.lib.utils;

import android.content.Context;
import android.util.TypedValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Utils {
    public static float dp2px(Context ctx, int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ctx.getResources().getDisplayMetrics());
    }

    public static boolean isColor(String color) {
        return color.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$");
    }

    public static boolean hasMethod(Object v, String name, Class... types) {
        for (Class<?> superClass = v.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                superClass.getDeclaredMethod(name, types);
                return true;
            } catch (NoSuchMethodException e) {
            }
        }
        return false;
    }

    public static Object getFiledValueFromClass(Class<?> o, String name) {
        Field f = getField(o, name);
        try {
            return f.get(o);
        } catch (Exception e) {

        }

        return null;
    }

    public static Object getFiledValue(Object o, String name) {
        return getFiledValueFromClass(o.getClass(), name);
    }

    public static void setField(Object o, String name, Object value) {
        try {
            Class<?> clazz = o.getClass();
            Field field = getField(clazz, name);
            if (field == null) return;
            field.setAccessible(true);
            field.set(o, value);
        } catch (Exception e) {
        }
    }

    public static Object invoke(Object v, String name, Class<?>[] types, Object... params) {
        try {
            Class<?> clazz = v.getClass();
            Method method = getMethod(clazz, name, types);
            if (method == null) return null;
            method.setAccessible(true);
            return method.invoke(v, params);

        } catch (Exception e) {

        }
        return null;
    }

    private static Field getField(Class<?> clazz, String name) {
        for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(name);
            } catch (Exception e) {

            }
        }
        return null;
    }

    private static Method getMethod(Class<?> clazz, String name, Class<?>... types) {
        for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredMethod(name, types);
            } catch (Exception e) {

            }
        }
        return null;
    }
}
