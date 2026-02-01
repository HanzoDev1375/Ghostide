package ir.ninjacoder.ghostide.core.tasks;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.File;
import java.lang.ref.WeakReference;

public class FileChangeReceiver extends BroadcastReceiver {
  private static FileObserver fileObserver;
  private static String currentFilePath;
  private static WeakReference<Activity> activityRef;
  private static FileChangeListener listener;
  private static boolean isDialogShowing = false;
  private static long lastChangeTime = 0;
  private static final long CHANGE_THRESHOLD = 1000;

  public interface FileChangeListener {
    void onFileChanged(String filePath);
  }

  @Nullable
  public static void startWatching(
      Activity activity, String filePath, @Nullable FileChangeListener l) {
    activityRef = new WeakReference<>(activity);
    currentFilePath = filePath;
    listener = l;
    stopWatching();

    fileObserver =
        new FileObserver(new File(filePath), FileObserver.MODIFY | FileObserver.CLOSE_WRITE) {
          private final Handler handler = new Handler(Looper.getMainLooper());

          @Override
          public void onEvent(int event, String path) {
            long currentTime = System.currentTimeMillis();
            if (((event & FileObserver.MODIFY) != 0 || (event & FileObserver.CLOSE_WRITE) != 0)
                && (currentTime - lastChangeTime > CHANGE_THRESHOLD)) {

              lastChangeTime = currentTime;
              handler.post(
                  () -> {
                    Activity activity = activityRef.get();
                    if (listener != null
                        && activity != null
                        && !isDialogShowing
                        && !activity.isFinishing()) {
                      listener.onFileChanged(currentFilePath);
//                      showFileChangedDialog(
//                          activity, currentFilePath, () -> listener.onFileChanged(currentFilePath));
                    }
                  });
            }
          }
        };
    fileObserver.startWatching();
  }

  @Override
  public void onReceive(Context context, Intent intent) {
    // Broadcast handling if needed
  }

  public static void showFileChangedDialog(Activity activity, String filePath, Runnable onReload) {
    if (activity == null || activity.isFinishing() || isDialogShowing) return;

    isDialogShowing = true;

    new MaterialAlertDialogBuilder(activity)
        .setTitle("File Changed")
        .setMessage(
            "The file "
                + Uri.parse(filePath).getLastPathSegment()
                + " has been modified by another app. Do you want to reload it?")
        .setPositiveButton(
            "Reload",
            (dialog, which) -> {
              new Handler(Looper.getMainLooper())
                  .post(
                      () -> {
                        onReload.run();
                        isDialogShowing = false;
                      });
            })
        .setNegativeButton("Cancel", (dialog, which) -> isDialogShowing = false)
        .setOnDismissListener(dialog -> isDialogShowing = false)
        .setCancelable(false)
        .show();
  }

  public static void stopWatching() {
    if (fileObserver != null) {
      fileObserver.stopWatching();
      fileObserver = null;
    }
  }
}
