package io.github.rosemoe.sora.langs.ninjalang;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import java.util.ArrayList;
import java.util.List;

import ir.ninjacoder.ghostide.core.GhostIdeAppLoader;


public class ImportList {
    private static List<String> imports = new ArrayList<>();

    public static List<String> getImports() {
        try {
            PackageManager packageManager = GhostIdeAppLoader.getContext().getPackageManager();
            PackageInfo packageInfo =
                    packageManager.getPackageInfo(
                            GhostIdeAppLoader.getContext().getPackageName(), PackageManager.GET_META_DATA);
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
