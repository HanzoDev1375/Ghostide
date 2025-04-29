package ir.ninjacoder.ghostide.tasks;

import android.content.pm.ServiceInfo;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static ir.ninjacoder.ghostide.tasks.FileWatcher.OnFileChangeListener;
import ir.ninjacoder.ghostide.R;
/**
 * A foreground service that monitors file changes in a specified directory.
 *
 * <p>Uses {@link FileWatcher} to observe file events and notifies registered {@link
 * OnFileChangeListener} instances.
 *
 * <p>To ensure the service stops when the app is removed from recent tasks, {@code stopWithTask} is
 * set to {@code true}.
 *
 * <p>Manifest declaration:
 *
 * <pre>{@code
 * <service
 *     android:name=".service.FileWatcherService"
 *     android:enabled="true"
 *     android:stopWithTask="true"
 *     android:exported="false" />
 * }</pre>
 *
 * @author EUP
 */
public class FileWatcherService extends Service implements FileWatcher.OnFileChangeListener {

  private static final String TAG = "FileMonitorService";

  private FileWatcher fileWatcher;
  public static final String FILE_WATCHER_NOTIFICATION_CHANNEL_ID =
      "file_watcher_notification_channel";

  public static final int APP_NOTIFICATION_ID = 1101;
  private boolean isMonitoring = false;
  private List<OnFileChangeListener> listeners = new ArrayList<>();

  /**
   * Binder class for clients to interact with the FileWatcherService.
   *
   * <p>It provides methods to add or remove file change listeners and to start/stop monitoring a
   * specified directory.
   */
  public class LocalBinder extends Binder {
    public void addListener(OnFileChangeListener listener) {
      listeners.add(listener);
    }

    public void removeListener(OnFileChangeListener listener) {
      listeners.remove(listener);
    }

    public void startMonitoring(File file) {
      if (!isMonitoring && file != null) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
          fileWatcher = new FileWatcher(file, FileWatcherService.this);
        } else {
          fileWatcher = new FileWatcher(file.getAbsolutePath(), FileWatcherService.this);
        }

        fileWatcher.startWatching();
        isMonitoring = true;
      }
    }

    public void stopMonitoring() {
      if (fileWatcher != null) {
        fileWatcher.stopWatching();
        fileWatcher = null;
        isMonitoring = false;
      }
    }

    public FileWatcherService getService() {
      return FileWatcherService.this;
    }
  }

  private final IBinder binder = new LocalBinder();

  public FileWatcherService() {
    // Default
  }

  @Override
  public void onCreate() {
    super.onCreate();
    performStartForeground();
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    performStartForeground();
    return START_STICKY; // restart if killed.
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return binder;
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    stopWatching();
    performStopService();
  }

  @Override
  public void onFileChanged(int event, String path) {
    for (OnFileChangeListener listener : listeners) {
      listener.onFileChanged(event, path);
    }
  }

  private void stopWatching() {
    if (fileWatcher != null) {
      fileWatcher.stopWatching();
      fileWatcher = null;
    }
  }

  private void createNotificationChannel() {
    // Notification channels are supported on Android API 26+.
    if (!(Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO)) return;

    final String channelId = FILE_WATCHER_NOTIFICATION_CHANNEL_ID;
    final CharSequence channelName = "ch";
    String description = "ch1";
    final int importance = NotificationManager.IMPORTANCE_LOW;

    NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
    channel.setDescription(description);
    NotificationManager notificationManager = getSystemService(NotificationManager.class);
    if (notificationManager != null) {
      notificationManager.createNotificationChannel(channel);
    }
  }

  private Notification buildNotification() {
    return new NotificationCompat.Builder(this, FILE_WATCHER_NOTIFICATION_CHANNEL_ID)
        .setContentTitle("Start Service")
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentText("Start FileWatcher")
        .setPriority(NotificationCompat.PRIORITY_LOW)
        .build();
  }

  /**
   * Puts the service into the foreground state with a persistent notification.
   *
   * <p><b>Note:</b> This method does not start the service. To start the service, call {@link
   * #startService(Intent)}.
   */
  private void performStartForeground() {
    createNotificationChannel();
    Notification notification = buildNotification();

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
      startForeground(
          APP_NOTIFICATION_ID, notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC);
    } else {
      startForeground(APP_NOTIFICATION_ID, notification);
    }
  }

  /**
   * Removes the service from the foreground state, which allows it to be killed if the system needs
   * memory.
   *
   * <p>This method does not stop the service; it only removes the persistent foreground
   * notification.
   */
  private void performStopForeground() {
    stopForeground(STOP_FOREGROUND_REMOVE);
  }

  /**
   * Stops the service completely.
   *
   * <p>This method first removes the service from the foreground state and then stops it.
   */
  private void performStopService() {
    performStopForeground();
    stopSelf();
  }

  public LocalBinder getBinder() {
    return (LocalBinder) this.binder;
  }
}
