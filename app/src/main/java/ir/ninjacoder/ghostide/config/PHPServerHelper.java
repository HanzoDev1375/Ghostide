package ir.ninjacoder.ghostide.config;

import ir.ninjacoder.ghostide.PHPProcess;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Process;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import java.io.*;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class PHPServerHelper {
  public static final Companion Companion = new Companion();

  private final Context context;
  private final File errorFile;
  private int errorTryingTimes;
  private final File pidFile;
  private int processPID;
  private final File projectDir;
  private boolean running;

  public PHPServerHelper(Context context, File projectDir) {
    if (context == null) {
      throw new IllegalArgumentException("Parameter 'context' must not be null");
    }
    if (projectDir == null) {
      throw new IllegalArgumentException("Parameter 'projectDir' must not be null");
    }

    this.context = context;
    this.projectDir = projectDir;
    this.errorFile = new File(context.getFilesDir(), "php_error");
    this.pidFile = new File(context.getFilesDir(), "php_pid");
  }

  public Context getContext() {
    return this.context;
  }

  public File getProjectDir() {
    return this.projectDir;
  }

  private Intent getServiceIntent() {
    return new Intent(this.context, PHPProcess.class);
  }

  public int getProcessPID() {
    return this.processPID;
  }

  public void setProcessPID(int processPID) {
    this.processPID = processPID;
  }

  public File getErrorFile() {
    return this.errorFile;
  }

  public File getPidFile() {
    return this.pidFile;
  }

  public boolean getRunning() {
    return this.running;
  }

  public void setRunning(boolean running) {
    this.running = running;
  }

  public int getErrorTryingTimes() {
    return this.errorTryingTimes;
  }

  public void setErrorTryingTimes(int errorTryingTimes) {
    this.errorTryingTimes = errorTryingTimes;
  }

  public void startServer(Handler handler, Runnable runnable) {
    if (!this.running) {
      new Thread(
              () -> {
                while (getRunning()) {
                  if (getPidFile().exists() || read(getPidFile()).equals("")) {
                    startService();
                  } else {
                    PHPServerHelper phpServerHelper = this;
                    String pidFileContent = read(phpServerHelper.getPidFile());

                    phpServerHelper.setProcessPID(Integer.parseInt(pidFileContent));
                    if (getErrorFile().exists()) {
                      if (getErrorTryingTimes() < 3) {
                        setRunning(false);
                        getErrorFile().delete();
                        getPidFile().delete();
                        PHPServerHelper phpServerHelper2 = this;
                        phpServerHelper2.setErrorTryingTimes(
                            phpServerHelper2.getErrorTryingTimes() + 1);
                      } else {
                        handler.post(runnable);
                        stopServer();
                      }
                    } else if (!isProcessExist(getContext(), getProcessPID())
                        && !isServiceExisted(getContext(), PHPProcess.class.getName())) {
                      startService();
                    }
                  }
                  try {
                    Thread.sleep(1000);
                  } catch (InterruptedException e) {
                    // Handle interruption if needed
                  }
                }
              })
          .start();
    }
  }

  private void run(Handler handler, Runnable runnable) {
    File file = new File(this.context.getFilesDir(), "php.ini");
    copyDataToSD(this.context, "php.ini", file.getPath());
    String read = read(file);
    String replace = read.replace("$MEMORY$", String.valueOf("1024"));
    String path = this.context.getFilesDir().getPath();
    try {
      write(replace.replace("$PRIVATE_FILES_PATH$", path), file);
    } catch (Exception err) {
      err.printStackTrace();
    }

    new File(this.context.getFilesDir(), "php/tmp").mkdirs();

    if (this.pidFile.exists() && !read(this.pidFile).equals("")) {
      String readPid = read(this.pidFile);
      this.processPID = Integer.parseInt(readPid);
      stopServer();
    }

    this.running = true;
    this.errorFile.delete();
    this.errorTryingTimes = 0;
  }

  public void stopServer() {
    if (this.processPID != 0) {
      while (isProcessExist(this.context, this.processPID)
          || isServiceExisted(this.context, PHPProcess.class.getName())) {
        this.context.stopService(getServiceIntent());
        Process.killProcess(this.processPID);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      this.errorFile.delete();
      this.pidFile.delete();
    }
  }

  public static final class Companion {

    public String runOffline(Context context, File phpFile) {
      if (context == null) {
        throw new IllegalArgumentException("Parameter 'context' must not be null");
      }
      if (phpFile == null) {
        throw new IllegalArgumentException("Parameter 'phpFile' must not be null");
      }

      File libFile = new File(context.getApplicationInfo().nativeLibraryDir, "libphp-8.2.8.so");
      String libPath = new File(context.getFilesDir().getPath() + "/lib").getPath();
      String libFilePath = libFile.getPath();
      String command =
          runCommand(
              new String[] {
                "/system/bin/sh",
                "-c",
                "export LD_LIBRARY_PATH=\""
                    + libPath
                    + "\" && \""
                    + libFilePath
                    + "\" -f \""
                    + phpFile
                    + "\" -c \""
                    + new File(context.getFilesDir(), "php.ini").getPath()
                    + "\""
              });
      return command;
    }
  }

  public static String runCommand(String[] strArr) {
    try {
      java.lang.Process runCommandAndGetProcess = runCommandAndGetProcess(strArr);
      runCommandAndGetProcess.waitFor();
      BufferedReader bufferedReader =
          new BufferedReader(new InputStreamReader(runCommandAndGetProcess.getInputStream()));
      String str = "";
      while (true) {
        String readLine = bufferedReader.readLine();
        if (readLine == null) {
          break;
        }
        str = str + readLine + "\n";
      }
      if (!str.equals("")) {
        return str;
      }
      BufferedReader bufferedReader2 =
          new BufferedReader(new InputStreamReader(runCommandAndGetProcess.getErrorStream()));
      while (true) {
        String readLine2 = bufferedReader2.readLine();
        if (readLine2 == null) {
          break;
        }
        str = str + readLine2 + "\n";
      }
      return !str.equals("") ? "Error: " + str : str;
    } catch (Exception err) {
      return err.getLocalizedMessage();
    }
  }

  public static java.lang.Process runCommandAndGetProcess(String[] strArr) throws Exception {
    return Runtime.getRuntime().exec(strArr);
  }

  public static boolean isProcessExist(Context context, int i) {
    try {
      ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
      if (activityManager == null) {
        return false;
      }
      for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo :
          activityManager.getRunningAppProcesses()) {
        if (runningAppProcessInfo.pid == i) {
          return true;
        }
      }
      return false;
    } catch (Exception unused) {
      return false;
    }
  }

  public static boolean isServiceExisted(Context context, String str) {
    List<ActivityManager.RunningServiceInfo> runningServices =
        ((ActivityManager) context.getSystemService("activity"))
            .getRunningServices(Integer.MAX_VALUE);
    int myUid = Process.myUid();
    for (ActivityManager.RunningServiceInfo next : runningServices) {
      if (next.uid == myUid && next.service.getClassName().equals(str)) {
        return true;
      }
    }
    return false;
  }

  public static void copyDataToSD(Context context, String str, String str2) {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(str2);
      InputStream open = context.getAssets().open(str);
      byte[] bArr = new byte[1024];
      for (int read = open.read(bArr); read > 0; read = open.read(bArr)) {
        fileOutputStream.write(bArr, 0, read);
      }
      fileOutputStream.flush();
      open.close();
      fileOutputStream.close();
    } catch (IOException err) {
      err.printStackTrace();
    }
  }

  public static String read(File file) {
    try {
      return read((InputStreamReader) new FileReader(file));
    } catch (IOException e) {
      return e.getLocalizedMessage();
    }
  }

  public static String read(InputStreamReader inputStreamReader) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    StringBuilder sb = new StringBuilder();
    int i = 0;
    for (String readLine = bufferedReader.readLine();
        readLine != null;
        readLine = bufferedReader.readLine()) {
      if (i > 0) {
        sb.append("\n");
      }
      sb.append(readLine);
      i++;
    }
    bufferedReader.close();
    return sb.toString();
  }

  public static void write(String str, File file) throws IOException {
    BufferedOutputStream bufferedOutputStream =
        new BufferedOutputStream(new FileOutputStream(file));
    bufferedOutputStream.write(str.getBytes(), 0, str.getBytes().length);
    bufferedOutputStream.flush();
    bufferedOutputStream.close();
  }

  public static void write(InputStream inputStream, File file) throws IOException {
    BufferedOutputStream bufferedOutputStream =
        new BufferedOutputStream(new FileOutputStream(file));
    byte[] readStream = readStream(inputStream);
    bufferedOutputStream.write(readStream, 0, readStream.length);
    bufferedOutputStream.flush();
    bufferedOutputStream.close();
  }

  public static void write(byte[] bArr, File file) throws IOException {
    BufferedOutputStream bufferedOutputStream =
        new BufferedOutputStream(new FileOutputStream(file));
    bufferedOutputStream.write(bArr, 0, bArr.length);
    bufferedOutputStream.flush();
    bufferedOutputStream.close();
  }

  public static byte[] readStream(InputStream inputStream) throws IOException {
    byte[] bArr = new byte[1024];
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    while (true) {
      int read = inputStream.read(bArr);
      if (read != -1) {
        byteArrayOutputStream.write(bArr, 0, read);
      } else {
        inputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
      }
    }
  }

  public final void startService() {
    Intent serviceIntent = getServiceIntent();
    serviceIntent.putExtra("port", "8080");
    serviceIntent.putExtra("projectPath", getProjectDir().getPath());
    try {
      getContext().startService(serviceIntent);
    } catch (Exception ignored) {
      // Handle exception here if needed
    }
  }
}
