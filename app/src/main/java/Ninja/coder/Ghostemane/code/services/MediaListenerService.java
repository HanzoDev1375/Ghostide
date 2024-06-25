package Ninja.coder.Ghostemane.code.services;

import Ninja.coder.Ghostemane.code.utils.FileUtil;
import Ninja.coder.Ghostemane.code.utils.SetThemeForJson;
import android.app.Service;
import android.content.Intent;
import android.os.FileObserver;
import android.os.IBinder;
import android.widget.Toast;

public class MediaListenerService extends Service {

  public static FileObserver observer;

  public MediaListenerService() {}

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    startWatching();
  }
  
  @Override
  public void onDestroy() {
    super.onDestroy();
    // TODO: Implement this method
    Toast.makeText(this,"EndWork",2).show();
  }
  

  private void startWatching() {
    var pathToWatch = "/storage/emulated/0/GhostWebIDE/theme/";
    observer =
        new FileObserver(
            pathToWatch,
            FileObserver.ALL_EVENTS) { // set up a file observer to watch this directory
          @Override
          public void onEvent(int event, final String file) {
            String eventText = "";
            if (event == FileObserver.DELETE && file.endsWith("ghost")) {
              new Thread(
                      () -> {
                        SetThemeForJson.winterToPath();
                      })
                  .start();
            }
          }
        };
    observer.startWatching();
  }
}
