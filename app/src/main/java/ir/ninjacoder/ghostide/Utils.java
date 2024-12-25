package ir.ninjacoder.ghostide;

import android.content.Context;
import android.app.ActivityManager;
import android.os.Process;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

public class Utils {

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

  public static String runCommand(String[] strArr) throws Exception {
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
  }

  public static java.lang.Process runCommandAndGetProcess(String[] strArr) throws Exception {
    return Runtime.getRuntime().exec(strArr);
  }

  public static boolean isProcessExist(Context context, int i) {
    try {
      ActivityManager activityManager =
          (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
      if (activityManager == null) {
        return false;
      }
      Iterator<ActivityManager.RunningAppProcessInfo> it =
          activityManager.getRunningAppProcesses().iterator();
      while (it.hasNext()) {
        if (it.next().pid == i) {
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
        ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE))
            .getRunningServices(Integer.MAX_VALUE);
    int myUid = Process.myUid();
    for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
      if (runningServiceInfo.uid == myUid
          && runningServiceInfo.service.getClassName().equals(str)) {
        return true;
      }
    }
    return false;
  }

  public static String read(File file) {
    try {
      return read(new FileReader(file));
    } catch (Exception err) {

    }
    return null;
  }

  public static String read(InputStreamReader inputStreamReader) throws Exception {
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

  public static void copyDataToSD(Context context, String str, String str2) throws Exception {
    FileOutputStream fileOutputStream = new FileOutputStream(str2);
    InputStream open = context.getAssets().open(str);
    byte[] bArr = new byte[1024];
    for (int read = open.read(bArr); read > 0; read = open.read(bArr)) {
      fileOutputStream.write(bArr, 0, read);
    }
    fileOutputStream.flush();
    open.close();
    fileOutputStream.close();
  }

  public static boolean isConnected(String str, int i) {
    HttpURLConnection httpURLConnection = null;
    try {
      HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
      try {
        httpURLConnection2.setConnectTimeout(i);
        httpURLConnection2.setReadTimeout(i);
        httpURLConnection2.setRequestMethod("GET");
        httpURLConnection2.connect();
        if (httpURLConnection2.getResponseCode() != 200) {
          if (httpURLConnection2.getResponseCode() != 404) {
            httpURLConnection2.disconnect();
            return false;
          }
        }
        httpURLConnection2.disconnect();
        return true;
      } catch (Exception unused) {
        httpURLConnection = httpURLConnection2;
        httpURLConnection.disconnect();
        return false;
      } catch (Throwable th) {
        th = th;
        httpURLConnection = httpURLConnection2;
        httpURLConnection.disconnect();
        throw th;
      }
    } catch (Exception unused2) {
    } catch (Throwable th2) {
    }
    return false;
  }
}
