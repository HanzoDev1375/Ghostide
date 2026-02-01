package ir.ninjacoder.ghostide.core.tasks;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import java.io.File;

/**
 * Manages the connection between a client and the {@link FileWatcherService}.
 *
 * <p>This class implements {@link ServiceConnection} to handle binding to the file watcher service,
 * register a file change listener, and launchWithLocalHost monitoring a specified directory. When
 * disconnected, it properly unregisters the listener and stops monitoring.
 */
public class FileWatcherServiceConnection implements ServiceConnection {

  private final FileWatcher.OnFileChangeListener listener;

  private File fileToWatch;
  private boolean isConnected;
  private FileWatcherService.LocalBinder binder;

  /**
   * Constructs a new FileWatcherServiceConnection with a specified file change listener.
   *
   * @param listener The listener that will be notified of file changes.
   */
  public FileWatcherServiceConnection(FileWatcher.OnFileChangeListener listener) {
    this.listener = listener;
  }

  @Override
  public void onServiceConnected(ComponentName name, IBinder iBinder) {
    binder = ((FileWatcherService.LocalBinder) iBinder);
    binder.addListener(listener);
    if (fileToWatch != null) {
      binder.startMonitoring(fileToWatch);
    }
    isConnected = true;
  }

  @Override
  public void onServiceDisconnected(ComponentName name) {
    if (binder != null) {
      binder.removeListener(listener);
      binder.stopMonitoring();
      binder = null;
    }
    isConnected = false;
  }

  public File getMonitoredFile() {
    return this.fileToWatch;
  }

  public boolean isConnected() {
    return this.isConnected;
  }

  public void setFileToWatch(File file) {
    this.fileToWatch = file;
    if (isConnected && binder != null) {
      binder.startMonitoring(file); // already connected (post-bound)
    }
  }

  public void removeListenerFromService() {
    if (binder != null && listener != null) {
      binder.removeListener(listener);
      binder.stopMonitoring();
    }
  }
}
