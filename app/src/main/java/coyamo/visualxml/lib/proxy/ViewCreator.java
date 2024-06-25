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

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import coyamo.visualxml.lib.ui.DefaultView;
import coyamo.visualxml.lib.ui.proxy.BlinkLayout;
import coyamo.visualxml.lib.utils.MessageArray;

public class ViewCreator {
    //private static final String TAG_MERGE = "merge";
    private static final String TAG_INCLUDE = "include";
    private static final String TAG_1995 = "blink";
    //private static final String TAG_REQUEST_FOCUS = "requestFocus";
    //private static final String TAG_TAG = "tag";
    private static final String[] sClassPrefixList = {
            "android.widget.",
            "android.view.",
            "android.webkit.",
            "android.app."
    };

    public static View create(@NonNull String name, @NonNull Context ctx) {
        if (name.startsWith("coyamo.visualxml.")) return createDefault(ctx, name);
        View v = null;
        if (isFullPackage(name)) {
            v = _create(name, ctx);
        } else {
            v = createSpecial(name, ctx);
            if (v == null) {
                for (String prefix : sClassPrefixList) {
                    v = _create(prefix + name, ctx);
                    if (v != null) return v;
                }
            }
        }

        if (v == null) return createDefault(ctx, name);
        return v;
    }

    public static View create(@NonNull String name, @NonNull Context ctx, int defStyle) {
        if (name.startsWith("coyamo.visualxml.")) return createDefault(ctx, name);
        View v = null;
        if (isFullPackage(name)) {
            v = _create(name, ctx, defStyle);
        } else {
            v = createSpecial(name, ctx);
            if (v == null) {
                for (String prefix : sClassPrefixList) {
                    v = _create(prefix + name, ctx, defStyle);
                    if (v != null) return v;
                }
            }
        }
        if (v == null) return createDefault(ctx, name);
        return v;
    }

    private static View createDefault(@NonNull Context ctx, String text) {
        DefaultView v = new DefaultView(ctx);
        v.setDisplayText(text);
        return v;
    }

    private static View _create(@NonNull String name, @NonNull Context ctx) {
        try {
            Class<?> clazz = Class.forName(name);
            Constructor<?> con = clazz.getDeclaredConstructor(Context.class);
            con.setAccessible(true);
            return (View) con.newInstance(ctx);
        } catch (ClassNotFoundException e2) {

        } catch (InvocationTargetException e1) {
            //这种情况可能出现在view存在，不过需要特定的Theme才可以使用
            MessageArray.getInstanse().logW("在创建 " + name + " 时：" + e1.getCause().toString());
        } catch (Exception e) {
        }
        return null;
    }

    private static View _create(@NonNull String name, @NonNull Context ctx, int defStyle) {
        try {
            Class<?> clazz = Class.forName(name);
            Constructor<?> con = clazz.getDeclaredConstructor(Context.class, AttributeSet.class, int.class);
            con.setAccessible(true);
            return (View) con.newInstance(ctx, null, defStyle);
        } catch (ClassNotFoundException e2) {

        } catch (InvocationTargetException e1) {
            MessageArray.getInstanse().logW("在创建 " + name + " 时：" + e1.getCause().toString());
        } catch (Exception e) {
        }
        return null;
    }


    private static View createSpecial(@NonNull String tag, @NonNull Context ctx) {
        switch (tag) {
            case TAG_INCLUDE:
                return createDefault(ctx, tag);
            case TAG_1995:
                return new BlinkLayout(ctx, null);
        }
        return null;
    }

    public static boolean isFullPackage(@NonNull String s) {
        return s.contains(".");
    }

    public static String getNameFromTag(@NonNull String s) {
        try {
            if (isFullPackage(s)) return s.substring(s.lastIndexOf(".") + 1);
        } catch (Exception e) {
        }
        return s;
    }
}
