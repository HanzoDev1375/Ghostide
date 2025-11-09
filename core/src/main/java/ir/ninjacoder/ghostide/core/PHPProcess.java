package ir.ninjacoder.ghostide.core;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.provider.Telephony;

import java.io.File;

import ir.ninjacoder.ghostide.core.Utils;

public class PHPProcess extends Service {
  private boolean isStarted = false;

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  public boolean isStarted() {
    return isStarted;
  }

  public void setStarted(boolean z) {
    isStarted = z;
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    if (isStarted) {
      return super.onStartCommand(intent, flags, startId);
    }
    isStarted = true;
    int intExtra = intent.getIntExtra(Telephony.Carriers.PORT, -1);
    String stringExtra = intent.getStringExtra("projectPath");
    File file = new File(getApplicationInfo().nativeLibraryDir, "libphp-8.2.8.so");
    File filesDir = getFilesDir();
    File file2 = new File(filesDir, "lib");
    File file3 = new File(filesDir, "php_error");
    File file4 = new File(filesDir, "php_pid");
    File file5 = new File(filesDir, "php.ini");
    file3.delete();
    try {
      file4.createNewFile();
      Utils.write(String.valueOf(Process.myPid()), file4);

      Thread thread =
          new Thread(
              new Runnable() {
                @Override
                public void run() {
                  onStartCommandLambda(
                      file, file2, intExtra, stringExtra, file5, file3, PHPProcess.this);
                }
              });
      thread.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return super.onStartCommand(intent, flags, startId);
  }

  private void onStartCommandLambda(
      File lib, File php, int i, String path, File phpIni, File errorFile, PHPProcess process) {
    try {
      String processOutput =
          Utils.runCommand(
              new String[] {
                "/system/bin/sh",
                "-c",
                "export LD_LIBRARY_PATH=\""
                    + lib.getPath()
                    + "\" && \""
                    + php.getPath()
                    + "\" -S 0.0.0.0:"
                    + i
                    + " -t \""
                    + path
                    + "\" -c \""
                    + phpIni.getPath()
                    + "\""
              });
      if (processOutput != null && processOutput.startsWith("Error: ")) {
        errorFile.createNewFile();
        Utils.write(processOutput, errorFile);
        process.stopSelf();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
