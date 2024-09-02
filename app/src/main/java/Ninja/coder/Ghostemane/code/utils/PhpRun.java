package Ninja.coder.Ghostemane.code.utils;

import android.content.Context;

import java.io.*;

public class PhpRun {
  public static String runCommand(String[] strArr) throws Exception {
    Process runCommandAndGetProcess = runCommandAndGetProcess(strArr);
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

  public static Process runCommandAndGetProcess(String[] strArr) throws Exception {
    return Runtime.getRuntime().exec(strArr);
  }

  public String runInTermux(Context c, String path) {
    String nativeLibrary = c.getApplicationInfo().nativeLibraryDir + "libphp-8.2.8.so";
    String appDirPath = c.getFilesDir().getAbsolutePath() + "/lib";
    String phpFilesDirini = c.getFilesDir().getAbsolutePath() + "php.ini";
    String command =
        "export LD_LIBRARY_PATH=\""
            + appDirPath
            + "\" && \""
            + nativeLibrary
            + "\" -f \""
            + path
            + "\" -c \""
            + phpFilesDirini
            + "\"";
    return command;
  }

  public String runOffline(Context context, File file) {
    try {
      File file2 = new File(context.getApplicationInfo().nativeLibraryDir, "libphp-8.2.8.so");
      String path = new File(context.getFilesDir().getPath() + "/lib").getPath();
      String path2 = file2.getPath();
      // Build the command to execute PHP script
      String runCommandStr =
          runCommand(
              new String[] {
                "/system/bin/sh",
                "-c",
                "export LD_LIBRARY_PATH=\""
                    + path
                    + "\" && \""
                    + path2
                    + "\" -f \""
                    + file
                    + "\" -c \""
                    + new File(context.getFilesDir(), "php.ini").getPath()
                    + "\""
              });
      return runCommandStr;
    } catch (Exception err) {
      return err.toString();
    }
  }

  public void runPhp(Context c, String path) {
    try {
      File file = new File(c.getApplicationInfo().nativeLibraryDir, "libphp-8.2.8.so");
      File file2 = new File(c.getFilesDir().getPath() + "/lib");
      File file3 = new File(c.getFilesDir(), "php_error");
      File file4 = new File(c.getFilesDir(), "php_pid");
      File file5 = new File(c.getFilesDir(), "php.ini");
      file3.delete();
      file4.createNewFile();
      runPHPProcess(file2, new File(path), file5, file3, 1375820, null);
    } catch (IOException err) {

    }
  }

  public void runPHPProcess(
      File lib, File php, File phpIni, File errorFile, int port, String docRoot) {
    String libPath = lib.getPath();
    String phpPath = php.getPath();
    String[] cmd = {
      "/system/bin/sh",
      "-c",
      "export LD_LIBRARY_PATH=\""
          + libPath
          + "\""
          + " && "
          + "\""
          + phpPath
          + "\""
          + " -S 0.0.0.0:"
          + port
          + " -t \""
          + docRoot
          + "\""
          + " -c \""
          + phpIni.getPath()
          + "\""
    };
    try {
      Process process = Runtime.getRuntime().exec(cmd);
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
      int exitCode = process.waitFor();
      if (exitCode != 0) {
        errorFile.createNewFile();
        FileWriter writer = new FileWriter(errorFile);
        writer.write("Process exited with non-zero code: " + exitCode);
        writer.close();
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
