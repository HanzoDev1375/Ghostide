package ir.ninjacoder.ghostide.core;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Process;
import android.provider.Telephony;

import java.io.File;

import ir.ninjacoder.ghostide.core.Utils;

public class PHPServerHelper {
  private final Context context;
  private final File errorFile;
  private final File pidFile, projectDir;
  private int errorTryingTimes;
  private int processPID;
  private boolean running;
  private boolean autoRestartPHP = true;

  public PHPServerHelper(Context context, File projectDir) {
    this.context = context;
    this.projectDir = projectDir;
    this.errorFile = new File(context.getFilesDir(), "php_error");
    this.pidFile = new File(context.getFilesDir(), "php_pid");
  }

  public Context getContext() {
    return context;
  }

  public File getProjectDir() {
    return projectDir;
  }

  private Intent getServiceIntent() {
    return new Intent(context, PHPProcess.class);
  }

  public int getProcessPID() {
    return processPID;
  }

  public void setProcessPID(int i) {
    processPID = i;
  }

  public File getErrorFile() {
    return errorFile;
  }

  public File getPidFile() {
    return pidFile;
  }

  public boolean getRunning() {
    return running;
  }

  public void setRunning(boolean z) {
    running = z;
  }

  public int getErrorTryingTimes() {
    return errorTryingTimes;
  }

  public void setErrorTryingTimes(int i) {
    errorTryingTimes = i;
  }

  public void startServer(final Handler handler, final Runnable runnable) {
    if (running) {
      return;
    }
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  startServerInternal(handler, runnable);
                } catch (Exception err) {

                }
              }
            })
        .start();
  }

  private void startServerInternal(final Handler handler, final Runnable runnable) {
    try {

      File file = new File(context.getFilesDir(), "php.ini");
      Utils.copyDataToSD(context, "php.ini", file.getPath());
      String read = Utils.read(file);
      read = read.replace("$MEMORY$", String.valueOf("1024"));
      String path = context.getFilesDir().getPath();
      String replaced = read.replace("$PRIVATE_FILES_PATH$", path);
      Utils.write(replaced, file);
      new File(context.getFilesDir(), "php/tmp").mkdirs();
      if (pidFile.exists() && !Utils.read(pidFile).equals("")) {
        processPID = Integer.parseInt(Utils.read(pidFile));
        stopServer();
      }
      running = true;
      errorFile.delete();
      errorTryingTimes = 0;
      new Thread(
              new Runnable() {
                @Override
                public void run() {
                  while (running) {
                    if (!pidFile.exists() || Utils.read(pidFile).equals("")) {
                      startService();
                    } else {
                      processPID = Integer.parseInt(Utils.read(pidFile));
                      if (errorFile.exists()) {
                        if (errorTryingTimes < 3) {
                          running = false;
                          errorFile.delete();
                          pidFile.delete();
                          errorTryingTimes++;
                        } else {
                          handler.post(runnable);
                          stopServer();
                        }
                      } else if (!Utils.isProcessExist(context, processPID)
                          && !Utils.isServiceExisted(context, PHPProcess.class.getName())) {
                        startService();
                      } else if (autoRestartPHP) {
                        if (!Utils.isConnected(
                            "http://0.0.0.0:" + "8080" + "/hopweb_test_is_php_is_alive.php",
                            3000)) {
                          stopServer();
                          startService();
                        }
                      }
                    }
                    try {
                      Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                      e.printStackTrace();
                    }
                  }
                }
              })
          .start();
    } catch (Exception err) {

    }
  }

  private void startService() {
    Intent serviceIntent = getServiceIntent();
    serviceIntent.putExtra(Telephony.Carriers.PORT, 8080);
    serviceIntent.putExtra("projectPath", projectDir.getPath());
    try {
      context.startService(serviceIntent);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void stopServer() {
    if (processPID == 0) {
      return;
    }
    while (Utils.isProcessExist(context, processPID)
        || Utils.isServiceExisted(context, PHPProcess.class.getName())) {
      context.stopService(getServiceIntent());
      Process.killProcess(processPID);
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    errorFile.delete();
    pidFile.delete();
  }

  public static String runOffline(Context context, File phpFile) throws Exception {
    File file = new File(context.getApplicationInfo().nativeLibraryDir, "libphp-8.2.8.so");
    String command =
        Utils.runCommand(
            new String[] {
              "/system/bin/sh",
              "-c",
              "export LD_LIBRARY_PATH=\""
                  + new File(context.getFilesDir().getPath() + "/lib").getPath()
                  + "\" && \""
                  + file.getPath()
                  + "\" -f \""
                  + phpFile
                  + "\" -c \""
                  + new File(context.getFilesDir(), "php.ini").getPath()
                  + "\""
            });
    
    return command != null ? command : "";
  }
}
