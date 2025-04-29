package ir.ninjacoder.ghostide.tasks;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.io.File;

/**
 * Manages the connection between a client and the {@link FileWatcherService}.
 *
 * <p>This class implements {@link ServiceConnection} to handle binding to the file watcher service,
 * register a file change listener, and start monitoring a specified directory. When disconnected,
 * it properly unregisters the listener and stops monitoring.
 *
 * @author EUP tnks for EUP
 */
public class FileWatcherServiceConnection implements ServiceConnection {

  private File fileToWatch;
  private boolean isConnected;
  private FileWatcherService boundService;
  private final FileWatcher.OnFileChangeListener listener;

  /**
   * Constructs a new FileWatcherServiceConnection with a specified file change listener.
   *
   * @param listener The listener that will be notified of file changes.
   */
  public FileWatcherServiceConnection(FileWatcher.OnFileChangeListener listener) {
    this.listener = listener;
  }

  @Override
  public void onServiceConnected(ComponentName name, IBinder service) {
    boundService = ((FileWatcherService.LocalBinder) service).getService();
    boundService.getBinder().addListener(listener);
    if (fileToWatch != null) {
      boundService.getBinder().startMonitoring(fileToWatch);
    }
    isConnected = true;
  }

  @Override
  public void onServiceDisconnected(ComponentName name) {
    if (boundService != null) {
      boundService.getBinder().removeListener(listener);
      boundService.getBinder().stopMonitoring();
      boundService = null;
    }
    isConnected = false;
  }

  public void setFileToWatch(File file) {
    this.fileToWatch = file;
    if (isConnected && boundService != null) {
      boundService.getBinder().startMonitoring(file); // already connected (post-bound)
    }
  }

  public File getMonitoredFile() {
    return this.fileToWatch;
  }

  public boolean isConnected() {
    return this.isConnected;
  }

  /**
   * Gets the bound instance of {@link FileWatcherService}.
   *
   * @return The bound service instance, or {@code null} if not connected.
   */
  public FileWatcherService getBoundService() {
    return this.boundService;
  }
}
