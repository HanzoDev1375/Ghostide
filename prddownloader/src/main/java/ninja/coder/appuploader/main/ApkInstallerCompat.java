package ninja.coder.appuploader.main;

import android.os.AsyncTask;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.util.TypedValue;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.progressindicator.CircularProgressIndicator;

import java.io.File;
import java.util.List;

public class ApkInstallerCompat extends AsyncTask<Void, Integer, String> {

  public static String TAG = "Error";
  private final Context mContext;
  private final File mApkFile;
  private AlertDialog mAlertDialog;
  private boolean mIsInstallBlocked = false;

  public ApkInstallerCompat(Context context, File apkFile) {
    mContext = context;
    mApkFile = apkFile;

    CircularProgressIndicator progressBar = new CircularProgressIndicator(context);
    int padding =
        (int)
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 16, context.getResources().getDisplayMetrics());
    progressBar.setPadding(padding, padding, padding, padding);
    progressBar.setIndeterminate(true);

    MaterialAlertDialogBuilder builder =
        new MaterialAlertDialogBuilder(context)
            .setTitle("Installing")
            .setMessage("Please wait...")
            .setCancelable(false)
            .setPositiveButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                    cancel(true);
                    dialog.dismiss();
                  }
                })
            .setView(progressBar);

    mAlertDialog = builder.create();
  }

  @Override
  protected String doInBackground(Void... params) {
    if (!mApkFile.getName().endsWith(".apk")) {
      return "Error: not an APK file";
    }

    if (!isInstallingAppsFromUnknownSourcesAllowed()) { // چک کردن دسترسی به نصب برنامه‌های خارج از
      // منابع Google Play
      mIsInstallBlocked = true;
      return "Installation from unknown sources is blocked";
    }

    Intent intent = new Intent(Intent.ACTION_VIEW);
    Uri apkUri;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
      apkUri =
          FileProvider.getUriForFile(mContext, "ir.ninjacoder.ghostide.core.provider", mApkFile);
    } else {
      apkUri = Uri.fromFile(mApkFile);
    }

    intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

    try {
      mContext.startActivity(intent);
    } catch (Exception e) {
      Log.e(TAG, "Error installing APK:", e);
      return "Error: " + e.getMessage();
    }
    return null;
  }

  @Override
  protected void onPostExecute(String result) {
    super.onPostExecute(result);

    if (mAlertDialog.isShowing()) {
      mAlertDialog.dismiss();
    }

    if (result != null) {
      if (mIsInstallBlocked) {
        showPermissionDialog();
      } else {
        showCustomDialog(result);
      }
    } else if (!isActivityRunning(
        mContext, mContext.getPackageName())) { // اگر فعالیت در حال اجرا نباشد
      Intent launchIntent =
          mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
      if (launchIntent != null) {
        launchIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        mContext.startActivity(launchIntent);
      }
    }
  }

  // یک تابع کمکی برای چک کردن وجود فعالیت در حال اجرا
  private boolean isActivityRunning(Context context, String packageName) {
    ActivityManager activityManager =
        (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    List<ActivityManager.RunningTaskInfo> tasks =
        activityManager.getRunningTasks(Integer.MAX_VALUE);

    for (ActivityManager.RunningTaskInfo task : tasks) {
      if (packageName.equalsIgnoreCase(task.baseActivity.getPackageName())) {
        return true;
      }
    }

    return false;
  }

  @Override
  protected void onProgressUpdate(Integer... values) {
    super.onProgressUpdate(values);
  }

  private void showCustomDialog(String message) {
    new MaterialAlertDialogBuilder(mContext)
        .setTitle("Installation Error")
        .setMessage(message)
        .setCancelable(false)
        .setPositiveButton("OK", null)
        .show();
  }

  private void showPermissionDialog() {
    MaterialAlertDialogBuilder builder =
        new MaterialAlertDialogBuilder(mContext)
            .setTitle("Permission Required")
            .setMessage(
                "Please grant permission to install packages from Unknown Sources to proceed")
            .setCancelable(false)
            .setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    openSettings();
                  }
                })
            .setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                  }
                });
    builder.create().show();
  }

  private void openSettings() {
    Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
    intent.setData(Uri.parse("package:" + mContext.getPackageName()));
    mContext.startActivity(intent);
  }

  private boolean isInstallingAppsFromUnknownSourcesAllowed() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      return mContext.getPackageManager().canRequestPackageInstalls();
    } else {
      int result =
          Settings.Secure.getInt(
              mContext.getContentResolver(), Settings.Secure.INSTALL_NON_MARKET_APPS, 0);
      return result == 1;
    }
  }
}
