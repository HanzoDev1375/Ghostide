package com.mcal.uidesigner.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

public class ActivityStarter {
    public static final String EXTRA_NAVIGATE_FILE = "filePath";
    public static final String EXTRA_NAVIGATE_LINE = "startLine";

    @SuppressLint("WrongConstant")
    public static void navigateTo(Activity activity, String filepath, int line) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(activity, "com.mcal.editor.presentation.EditorActivity"));
        intent.putExtra(EXTRA_NAVIGATE_FILE, filepath);
        intent.putExtra(EXTRA_NAVIGATE_LINE, line);
        activity.startActivity(intent);
        activity.finish();
    }
}
