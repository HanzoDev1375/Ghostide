package com.ninjacoder.jgit.apk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.FileUtils;
import io.noties.markwon.Markwon;
import io.noties.markwon.html.HtmlPlugin;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ApkUtilData {
  private Context context;
  private Markwon markwon;

  public ApkUtilData(Context context) {
    this.context = context;
    this.markwon = Markwon.builder(context).usePlugin(HtmlPlugin.create()).build();
  }

  public CharSequence getFormattedAppInfo(String apkPath) {
    StringBuilder builder = new StringBuilder();

    if (apkPath == null || apkPath.isEmpty()) {
      return markwon.toMarkdown("**Error:** APK path is empty");
    }

    File apkFile = new File(apkPath);
    if (!apkFile.exists()) {
      return markwon.toMarkdown("**Error:** APK file not found at: " + apkPath);
    }

    try {
      // Read APK info using PackageManager
      PackageManager pm = context.getPackageManager();
      PackageInfo packageInfo =
          pm.getPackageArchiveInfo(
              apkPath,
              PackageManager.GET_SIGNATURES
                  | PackageManager.GET_PERMISSIONS
                  | PackageManager.GET_META_DATA);

      if (packageInfo == null) {
        return markwon.toMarkdown("**Error:** Cannot read APK information");
      }

      // File Information
      builder.append("**APK Path:** ").append(apkPath).append("\n\n");
      builder.append("**APK Size:** ").append(FileUtils.getSize(apkFile)).append("\n\n");

      // Package Information
      builder.append("**Package Name:** ").append(packageInfo.packageName).append("\n\n");
      builder.append("**Version Name:** ").append(packageInfo.versionName).append("\n\n");
      builder.append("**Version Code:** ").append(packageInfo.versionCode).append("\n\n");

      // SDK Information
      if (packageInfo.applicationInfo != null) {
        builder
            .append("**Target SDK:** ")
            .append(packageInfo.applicationInfo.targetSdkVersion)
            .append("\n\n");
        builder
            .append("**Min SDK:** ")
            .append(packageInfo.applicationInfo.minSdkVersion)
            .append("\n\n");
      }

      // Signatures
      if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
        builder
            .append("**Signatures Count:** ")
            .append(packageInfo.signatures.length)
            .append("\n\n");
        for (int i = 0; i < packageInfo.signatures.length; i++) {
          Signature sig = packageInfo.signatures[i];
          builder
              .append("**Signature ")
              .append(i + 1)
              .append(":** ")
              .append(sig.toCharsString().substring(0, Math.min(50, sig.toCharsString().length())))
              .append("...")
              .append("\n\n");
        }
      }

      // App Info
      if (packageInfo.applicationInfo != null) {
        builder
            .append("**App Name:** ")
            .append(pm.getApplicationLabel(packageInfo.applicationInfo))
            .append("\n\n");

        // Installation dates (for installed apps only)
        try {
          PackageInfo installedInfo = pm.getPackageInfo(packageInfo.packageName, 0);
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

          builder
              .append("**First Install Date:** ")
              .append(sdf.format(new Date(installedInfo.firstInstallTime)))
              .append("\n\n");

          builder
              .append("**Last Update Date:** ")
              .append(sdf.format(new Date(installedInfo.lastUpdateTime)))
              .append("\n\n");

          builder.append("**UID:** ").append(installedInfo.applicationInfo.uid).append("\n\n");
        } catch (PackageManager.NameNotFoundException e) {
          builder.append("**Status:** Not installed\n\n");
        }
      }

      // Directories
      builder
          .append("**Data Directory:** ")
          .append(context.getFilesDir().getParent())
          .append("\n\n");

      builder
          .append("**External Data Directory:** ")
          .append(
              context.getExternalFilesDir(null) != null
                  ? context.getExternalFilesDir(null).getParent()
                  : "Not available")
          .append("\n\n");

      // Debug/System info
      if (packageInfo.applicationInfo != null) {
        builder
            .append("**Is Debug:** ")
            .append((packageInfo.applicationInfo.flags & 0x2) != 0)
            .append("\n\n");

        builder
            .append("**Is System App:** ")
            .append((packageInfo.applicationInfo.flags & 0x1) != 0)
            .append("\n\n");
      }

    } catch (Exception e) {
      builder.append("**Error:** ").append(e.getMessage()).append("\n\n");
    }

    return markwon.toMarkdown(builder.toString());
  }

  // Optional: Get info for currently installed app
  public CharSequence getCurrentAppInfo() {
    return getFormattedAppInfo(AppUtils.getAppPath());
  }
}
