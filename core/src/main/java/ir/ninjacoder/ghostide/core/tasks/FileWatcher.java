package ir.ninjacoder.ghostide.core.tasks;

import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;

import java.io.File;

/**
 * FileObserver subclass to monitor file changes
 *
 * @author EUP
 */
public class FileWatcher extends FileObserver {

  /**
   *<table>
   * <tbody>
   *  <tr>
   *    <th>Event</th>
   *    <th>Description</th>
   *  </tr>
   *  <tr>
   *    <td>FileObserver.CREATE</td>
   *    <td>A new file or subdirectory was created under the monitored directory</td>
   *  </tr>
   *  <tr>
   *    <td>FileObserver.DELETE</td>
   *    <td>A file was deleted from the monitored directory</td>
   *  </tr>
   *  <tr>
   *    <td>FileObserver.DELETE_SELF</td>
   *    <td>The monitored file or directory was deleted; monitoring effectively stops</td>
   *  </tr>
   *  <tr>
   *    <td>FileObserver.MOVE_SELF</td>
   *    <td>The monitored file or directory was moved; monitoring continues</td>
   *  </tr>
   *  <tr>
   *    <td>FileObserver.MOVED_FROM</td>
   *    <td>A file or subdirectory was moved from the monitored directory</td>
   *  </tr>
   *   <tr>
   *    <td>FileObserver.MOVED_TO</td>
   *    <td>A file or subdirectory was moved to the monitored directory</td>
   *  </tr>
   *  <tr>
   *    <td>FileObserver.MODIFY</td>
   *    <td>Data was written to a file</td>
   *  </tr>
   */
  private static final int NOTIFY_EVENTS =
      FileObserver.CREATE
          | FileObserver.DELETE
          | FileObserver.DELETE_SELF
          | FileObserver.MOVE_SELF
          | FileObserver.MOVED_FROM
          | FileObserver.MOVED_TO
          | FileObserver.MODIFY;

  private final OnFileChangeListener listener;
  private final Runnable eventRunnable;

  private volatile int lastEvent;
  private volatile String lastPath;

  /**
   * Constructor for FileWatcher
   *
   * <p>Although deprecated it is available on devices below Android 10
   *
   * @param path the file or directory to monitor
   * @param listener the event callback for file changes
   */
  public FileWatcher(String path, OnFileChangeListener listener) {
    super(path, NOTIFY_EVENTS);
    this.listener = listener;
    this.eventRunnable = this::handleEvent;
  }

  /**
   * Constructor for FileWatcher
   *
   * @param file the file or directory to monitor
   * @param listener the event callback for file changes
   */
  public FileWatcher(File file, OnFileChangeListener listener) {
    super(file, NOTIFY_EVENTS);
    this.listener = listener;
    this.eventRunnable = this::handleEvent;
  }

  @Override
  public void onEvent(int event, @Nullable String path) {
    if ((event & NOTIFY_EVENTS) == 0) return;

    lastEvent = event;
    lastPath = path;

    new Handler(Looper.getMainLooper()).post(eventRunnable);
  }

  private void handleEvent() {
    if (listener != null && lastEvent != 0) {
      listener.onFileChanged(lastEvent, lastPath);
    }
    lastEvent = 0;
    lastPath = null;
  }

  public interface OnFileChangeListener {
    void onFileChanged(int event, String path);
  }
}
