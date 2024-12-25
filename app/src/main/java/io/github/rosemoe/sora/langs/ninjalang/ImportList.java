package io.github.rosemoe.sora.langs.ninjalang;

import ir.ninjacoder.ghostide.ApplicationLoader;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ImportList {
    private static List<String> imports = new ArrayList<>();

    public static List<String> getImports() {
        try {
            PackageManager packageManager = ApplicationLoader.getContext().getPackageManager();
            PackageInfo packageInfo =
                    packageManager.getPackageInfo(
                            ApplicationLoader.getContext().getPackageName(), PackageManager.GET_META_DATA);
            ActivityInfo[] activities = packageInfo.activities;
            if (activities != null) {
                for (ActivityInfo activity : activities) {
                    try {
                        String activityName = activity.name;
                        Class<?> activityClass = Class.forName(activityName);
                        Package activityPackage = activityClass.getPackage();
                        if (activityPackage != null) {
                            String packageName = activityPackage.getName();
                            if (!imports.contains(packageName)) {
                                imports.add(packageName);
                            }
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }

        return imports;
    }
}
