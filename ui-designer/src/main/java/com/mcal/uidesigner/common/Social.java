package com.mcal.uidesigner.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.text.ClipboardManager;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.List;

public class Social {
    private static boolean searchActivity(Context context, String pakage, Intent intent) {
        try {
            List<ResolveInfo> launchables = context.getPackageManager().queryIntentActivities(intent, 0);
            if (launchables != null && launchables.size() > 1) {
                for (ResolveInfo launchable : launchables) {
                    if (pakage.equals(launchable.activityInfo.applicationInfo.packageName)) {
                        intent.setPackage(pakage);
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static void shareWithTwitter(Context context, String text, String link) {
        Intent tweetIntent = new Intent("android.intent.action.VIEW");
        tweetIntent.setData(Uri.parse("http://www.twitter.com/intent/tweet?url=" + link + "&text=" + text));
        searchActivity(context, "com.twitter.android", tweetIntent);
        context.startActivity(tweetIntent);
    }

    public static void shareWithGooglePlus(Context context, String text, String link) {
        Intent plusIntent = new Intent("android.intent.action.SEND");
        plusIntent.setType("text/plain");
        plusIntent.putExtra("android.intent.extra.TEXT", text + "\n\n" + link);
        if (!searchActivity(context, "com.google.android.apps.plus", plusIntent)) {
            plusIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://plus.google.com/share?url=" + link + "&text=" + text));
        }
        context.startActivity(plusIntent);
    }

    @SuppressLint("WrongConstant")
    public static void shareWithFacebook(final Context context, final String text, String link) {
        Intent facebookIntent = new Intent("android.intent.action.SEND");
        facebookIntent.setType("text/plain");
        facebookIntent.putExtra("android.intent.extra.SUBJECT", text);
        facebookIntent.putExtra("android.intent.extra.TEXT", link);
        if (!searchActivity(context, "com.facebook.katana", facebookIntent)) {
            facebookIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/sharer/sharer.php?u=" + link));
        } else {
            ((ClipboardManager) context.getSystemService("clipboard")).setText(text);
            new Handler().postDelayed(() -> {
                Toast.makeText(context, "Long press to paste: \"" + text + "\"", Toast.LENGTH_LONG).show();
            }, 1000);
        }
        context.startActivity(facebookIntent);
    }

    @SuppressLint("WrongConstant")
    public static void openFacebookPage(Context context, String pageId) {
        Intent facebookIntent = new Intent("android.intent.action.VIEW", Uri.parse("fb://profile/" + pageId));
        if (!searchActivity(context, "com.facebook.katana", facebookIntent)) {
            facebookIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/" + pageId));
        }
        facebookIntent.setFlags(1074266112);
        context.startActivity(facebookIntent);
    }

    @SuppressLint("WrongConstant")
    public static void openTwitterPage(Context context, String twitterId) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://twitter.com/#!/" + twitterId));
        intent.setFlags(1074266112);
        searchActivity(context, "com.twitter.android", intent);
        context.startActivity(intent);
    }

    @SuppressLint("WrongConstant")
    public static void openGooglePlusPage(Context context, String gplusId) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://plus.google.com/" + gplusId + "/posts"));
        intent.setFlags(1074266112);
        searchActivity(context, "com.google.android.apps.plus", intent);
        context.startActivity(intent);
    }

    @SuppressLint("WrongConstant")
    public static void openGooglePlusCommunity(Context context, String gplusId) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://plus.google.com/communities/" + gplusId));
        intent.setFlags(1074266112);
        if (!searchActivity(context, "com.google.android.apps.plus", intent)) {
        }
        context.startActivity(intent);
    }

    @SuppressLint("WrongConstant")
    public static void openGoogleGroup(@NonNull Context context, String groupId) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://groups.google.com/group/" + groupId));
        intent.setFlags(1074266112);
        context.startActivity(intent);
    }

    @SuppressLint("WrongConstant")
    public static void openPlayPage(@NonNull Context context, String packageName, String linkId) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + packageName + "&referrer=utm_source%3D" + packageName + "%26utm_medium%3Dinapplink%26utm_campaign%3D" + linkId));
        intent.setFlags(1074266112);
        context.startActivity(intent);
    }

    public static void sendEmail(@NonNull Context context, String receipient, String subject, String message) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{receipient});
        intent.putExtra("android.intent.extra.SUBJECT", "App UI Designer Feedback");
        intent.putExtra("android.intent.extra.TEXT", message);
        context.startActivity(intent);
    }
}
