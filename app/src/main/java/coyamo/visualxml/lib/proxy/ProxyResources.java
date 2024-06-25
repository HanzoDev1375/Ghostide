package coyamo.visualxml.lib.proxy;
/**
 * Copyright (C) 2020 Coyamo
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.util.TypedValue;
import android.view.View;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import coyamo.visualxml.lib.utils.MessageArray;
import coyamo.visualxml.lib.utils.Utils;

/*
处理xml中的引用类型的值（不全面）
*/
public class ProxyResources {
    private static ProxyResources instance;
    private MessageArray debug = MessageArray.getInstanse();
    private Map<String, String> drawableMap = new HashMap<>();
    private Map<String, Integer> viewIdMap = new HashMap<>();
    private Map<String, String> colorMap = new HashMap<>();
    private Map<String, String> stringMap = new HashMap<>();
    private Context ctx;

    private ProxyResources(Context ctx) {
        this.ctx = ctx;
    }

    public static void init(Context ctx) {
        instance = new ProxyResources(ctx);
    }

    public static ProxyResources getInstance() {
        return instance;
    }

    public static String parseReferName(String reference) {
        return parseReferName(reference, "/");
    }

    public static String parseReferName(String reference, String sep) {
        return reference.substring(reference.indexOf(sep) + 1);
    }

    public Map<String, String> getDrawableMap() {
        return drawableMap;
    }

    public Map<String, Integer> getViewIdMap() {
        return viewIdMap;
    }

    public Map<String, String> getColorMap() {
        return colorMap;
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public void reset() {
        drawableMap.clear();
        viewIdMap.clear();
        colorMap.clear();
        stringMap.clear();
    }
	/*
	 If true, resource references will be walked; if
	 false, <var>outValue</var> may be a
	 TYPE_REFERENCE.  In either case, it will never
	 be a TYPE_ATTRIBUTE.
	 */

    public void putString(String name, String text) {
        stringMap.put(name, text);
    }

    public String getString(String reference) {
        String name = parseReferName(reference);
        if (reference.startsWith("@android:string/")) {
            int id = getSystemResourceId(android.R.string.class, name);
            if (id != -1) {
                return ctx.getResources().getString(id);
            }
        } else if (reference.startsWith("@string/")) {
            if (stringMap.containsKey(name)) {
                return stringMap.get(name);
            } else {
                debug.logE("找不到string" + reference);
            }
        }
        return reference;
    }

    //不太清楚具体
    //获取套娃引用的最终值
    public int getRes(String attr) {
        if (attr.startsWith("@android:style/")) return getStyle(attr);
        int id = getAttr(attr);
        Resources.Theme theme = ctx.getTheme();
        TypedValue typeValue = new TypedValue();
        if (theme.resolveAttribute(id, typeValue, true)) {
            return typeValue.data;
        }
        debug.logE("getRes err：" + attr);
        return -1;
    }

    public int getStyle(String style) {
        if (style.startsWith("@android:style/")) {
            String name = parseReferName(style);
            return getSystemResourceId(android.R.style.class, name.replace(".", "_"));
        }
        debug.logE("找不到 style 值：" + style);
        return -1;
    }

    public int getAttr(String attr) {
        String name;
        if (attr.startsWith("?android:attr/")) {
            name = parseReferName(attr);
        } else if (attr.startsWith("?android:")) {
            name = parseReferName(attr, ":");
        } else if (attr.startsWith("@android:attr/")) {
            name = parseReferName(attr);
        } else if (attr.startsWith("?attr/android:")) {
            name = parseReferName(attr, ":");
        } else {
            debug.logE("找不到 attr 值：" + attr);
            return -1;
        }
        return getSystemResourceId(android.R.attr.class, name);
    }

    public void registerViewId(View v, String id) {
        String name = parseReferName(id);
        if (!viewIdMap.containsKey(name)) {
            v.setId(View.generateViewId());
            viewIdMap.put(name, v.getId());
        }
    }

    public int getId(String id) {
        if (viewIdMap.containsKey(parseReferName(id))) {
            return viewIdMap.get(parseReferName(id));
        }
        return View.NO_ID;
    }

    public View findViewById(Activity activity, String id) {
        if (viewIdMap.containsKey(parseReferName(id)))
            return activity.findViewById(getId(id));
        debug.logE("找不到 View ：" + id);
        return null;
    }

    public View findViewById(String id) {
        return findViewById((Activity) ctx, id);
    }

    public Drawable getDrawable(String reference) {
        //颜色
        if (Utils.isColor(reference)) {
            ColorDrawable cd = new ColorDrawable();
            cd.setColor(Color.parseColor(reference));
            return cd;
        }
        String name = parseReferName(reference);
        if (reference.startsWith("@android:drawable/")) {
            int id = getSystemResourceId(android.R.drawable.class, name);
            if (id != -1) {
                return ctx.getResources().getDrawable(id);
            }
        } else if (reference.startsWith("@drawable/")) {
            if (drawableMap.containsKey(name)) {
                return DrawableWrapper.createFromPath(drawableMap.get(name));
            }
        } else if (reference.startsWith("@android:color/")) {
            int id = getSystemResourceId(android.R.color.class, name);
            if (id != -1) {
                return new ColorDrawable(ctx.getResources().getColor(id));
            }
        } else if (reference.startsWith("@color/")) {
            if (colorMap.containsKey(name)) {
                return new ColorDrawable(Color.parseColor(colorMap.get(name)));
            }
        } else if (reference.startsWith("?android:attr/")) {
            int i = getAttr(reference);
            TypedArray a = ctx.obtainStyledAttributes(new int[]{i});
            Drawable d = a.getDrawable(a.getIndex(0));
            a.recycle();
            return d;
        }
        debug.logE("找不到 Drawable ：" + reference);
        return null;
    }

    public int getColor(String reference) {
        if (Utils.isColor(reference)) {
            return Color.parseColor(reference);
        }
        String name = parseReferName(reference);
        if (reference.startsWith("@android:color/")) {
            int id = getSystemResourceId(android.R.color.class, name);
            if (id != -1) {
                return ctx.getResources().getColor(id);
            }
        } else if (reference.startsWith("@color/")) {
            if (colorMap.containsKey(name)) {
                return Color.parseColor(colorMap.get(name));
            }
        }
        debug.logE("找不到 Color ：" + reference);
        return Color.TRANSPARENT;
    }

    //图片的路径 只支持普通图片
    public void putDrawable(String name, String drawableFilePath) {
        drawableMap.put(name, drawableFilePath);
    }

    //#ffffff 类型的颜色
    public void putColor(String name, String color) {
        colorMap.put(name, color);
    }

    public int getSystemResourceId(Class clazz, String name) {
        try {
            Field field = clazz.getField(name);
            return field.getInt(clazz);
        } catch (Exception e) {
            debug.logE("找不到系统资源 ：" + clazz + " " + name);
        }
        return -1;
    }
}
