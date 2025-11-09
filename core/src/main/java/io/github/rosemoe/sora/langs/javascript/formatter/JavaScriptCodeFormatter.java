package io.github.rosemoe.sora.langs.javascript.formatter;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaScriptCodeFormatter {

  public static String formatJavaScriptCode(Context context, String jsCode) {
    try {
      // ذخیره کد موقت در فایل
      File tempFile = createTempFile(context, jsCode);

      // اجرای pythonjsformat روی فایل با همان روش نسخه پایتون
      formatWithPythonScript(context, tempFile);

      // خواندن نتیجه
      String formattedCode = readFile(tempFile);

      // حذف فایل موقت
      tempFile.delete();

      return formattedCode;

    } catch (IOException | InterruptedException e) {
      Log.e("JSFormatter", "خطا در فرمت کردن کد", e);
      return jsCode;
    }
  }

  private static File createTempFile(Context context, String content) throws IOException {
    File tempDir = new File(context.getCacheDir(), "js_temp");
    if (!tempDir.exists()) {
      tempDir.mkdirs();
    }
    File tempFile = File.createTempFile("format_", ".js", tempDir);
    try (FileWriter writer = new FileWriter(tempFile)) {
      writer.write(content);
    }
    return tempFile;
  }

  private static void formatWithPythonScript(Context context, File jsFile)
      throws IOException, InterruptedException {

    String pythonLib = context.getApplicationInfo().nativeLibraryDir + "/libpython3.so";
    String pythonHome = context.getFilesDir().getAbsolutePath() + "/usr";

    // مسیر واقعی فایل pythonjsformat.py
    String scriptPath = context.getFilesDir().getAbsolutePath() + "/pythonjsformat.py";

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
            jsFile.getAbsolutePath() // فایل JS موقت
            );

    Process process = Runtime.getRuntime().exec(new String[] {"sh", "-c", command});

    // خواندن stdout و stderr همانند نسخه پایتون
    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    BufferedReader errReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

    String line;
    while ((line = reader.readLine()) != null) Log.d("JSFormatter", line);
    while ((line = errReader.readLine()) != null) Log.e("JSFormatter", line);

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
