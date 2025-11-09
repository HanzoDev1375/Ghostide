package io.github.rosemoe.sora.langs.python.formatter;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyUnImp {

  public static String runObject(Context context, String pycode) {
    try {
      File tempFile = createTempFile(context, pycode);
      uningWithPythonScript(context, tempFile);
      String readCodes = readFile(tempFile);
      tempFile.delete();
      return readCodes;
    } catch (IOException | InterruptedException e) {
      Log.e("PythonUnImpoter", "خطا در حذف کردن کد های اضافی", e);
      return pycode;
    }
  }

  private static File createTempFile(Context context, String content) throws IOException {
    File tempDir = new File(context.getCacheDir(), "pyunim_temp");
    if (!tempDir.exists()) {
      tempDir.mkdirs();
    }
    File tempFile = File.createTempFile("unusing", ".py", tempDir);
    try (FileWriter writer = new FileWriter(tempFile)) {
      writer.write(content);
    }
    return tempFile;
  }

  private static void uningWithPythonScript(Context context, File jsFile)
      throws IOException, InterruptedException {
    String pythonLib = context.getApplicationInfo().nativeLibraryDir + "/libpython3.so";
    String pythonHome = context.getFilesDir().getAbsolutePath() + "/usr";
    String scriptPath = context.getFilesDir().getAbsolutePath() + "/unsingimport.py";
    String command =
        String.format(
            "export PYTHONHOME=%s && "
                + "export PYTHONPATH=%s && "
                + "export LD_LIBRARY_PATH=%s/lib && "
                + "cd %s && "
                + "%s %s %s",
            pythonHome,
            context.getApplicationInfo().nativeLibraryDir,
            pythonHome,
            jsFile.getParent(),
            pythonLib,
            scriptPath,
            jsFile.getAbsolutePath());
    Process process = Runtime.getRuntime().exec(new String[] {"sh", "-c", command});
    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    BufferedReader errReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
    String line;
    while ((line = reader.readLine()) != null) Log.d("PythonUnImpoter", line);
    while ((line = errReader.readLine()) != null) Log.e("PythonUnImpoter", line);
    process.waitFor();
  }

  private static String readFile(File file) throws IOException {
    StringBuilder content = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) content.append(line).append("\n");
    }
    return content.toString().trim();
  }
}
