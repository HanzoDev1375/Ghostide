package com.mcal.uidesigner.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

import com.mcal.webview.WebViewActivity;

public class HelpActivityStarter {
    public static final String EXTRA_REFERENCE_URL = "htmlUrl";

    @SuppressLint("WrongConstant")
    public static void showHelp(Activity caller, String referenceUrl) {
        Intent intent = new Intent(caller, WebViewActivity.class);
        intent.putExtra(EXTRA_REFERENCE_URL, referenceUrl);
        caller.startActivity(intent);
    }
}
