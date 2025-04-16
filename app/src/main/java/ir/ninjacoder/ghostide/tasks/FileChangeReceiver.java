package ir.ninjacoder.ghostide.tasks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class FileChangeReceiver extends BroadcastReceiver {
  private static FileObserver fileObserver;
  private static String currentFilePath;
  private static Context context;
  private static FileChangeListener listener;
  private static boolean isDialogShowing = false;
  private static long lastChangeTime = 0;
  private static final long CHANGE_THRESHOLD = 1000;

  public interface FileChangeListener {
    void onFileChanged(String filePath);
  }

  @Nullable
  public static void startWatching(Context ctx, String filePath, @Nullable FileChangeListener l) {
    context = ctx;
    currentFilePath = filePath;
    listener = l;
    stopWatching();

    fileObserver =
        new FileObserver(filePath, FileObserver.MODIFY | FileObserver.CLOSE_WRITE) {
          private final Handler handler = new Handler(Looper.getMainLooper());

          @Override
          public void onEvent(int event, String path) {
            long currentTime = System.currentTimeMillis();
            if (((event & FileObserver.MODIFY) != 0 || (event & FileObserver.CLOSE_WRITE) != 0)
                && (currentTime - lastChangeTime > CHANGE_THRESHOLD)) {

              lastChangeTime = currentTime;
              handler.post(
                  () -> {
                    if (listener != null && !isDialogShowing) {
                      listener.onFileChanged(currentFilePath);
                      Toast.makeText(ctx, "startWatching: " + currentFilePath, 2).show();
                    }
                  });
            }
          }
        };
    fileObserver.startWatching();
  }

  @Override
  public void onReceive(Context context, Intent intent) {
    // Handle broadcast if needed
  }

  public static void showFileChangedDialog(Context context, String filePath, Runnable onReload) {
    isDialogShowing = true;
    new MaterialAlertDialogBuilder(context)
        .setTitle("فایل تغییر کرد")
        .setMessage(
            "فایل "
                + Uri.parse(filePath).getLastPathSegment()
                + " توسط برنامه دیگری تغییر داده شده است. آیا می‌خواهید محتوا را مجدداً بارگذاری کنید؟")
        .setPositiveButton(
            "بارگذاری مجدد",
            (dialog, which) -> {
              new Handler()
                  .post(
                      () -> {
                        onReload.run();
                        isDialogShowing = false;
                      });
            })
        .setNegativeButton(
            "لغو",
            (dialog, which) -> {
              isDialogShowing = false;
            })
        .setOnDismissListener(
            dialog -> {
              isDialogShowing = false;
            })
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
