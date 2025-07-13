package io.github.rosemoe.sora.langs.python.formatter;

import android.content.Context;
import android.util.Log;
import java.io.*;

public class PythonCodeFormatter {

  public static String formatPythonCode(Context context, String pythonCode) {
    try {
      // ذخیره کد موقت در فایل
      File tempFile = createTempFile(context, pythonCode);

      // اجرای black روی فایل
      formatWithBlack(context, tempFile);

      // خواندن نتیجه
      String formattedCode = readFile(tempFile);

      // حذف فایل موقت
      tempFile.delete();

      return formattedCode;

    } catch (IOException | InterruptedException e) {
      Log.e("PythonFormatter", "خطا در فرمت کردن کد", e);
      return pythonCode; // در صورت خطا کد اصلی را برگردان
    }
  }

  private static File createTempFile(Context context, String content) throws IOException {
    // استفاده از دایرکتوری cache برنامه به جای مسیرهای سیستمی
    File tempDir = new File(context.getCacheDir(), "python_temp");
    if (!tempDir.exists()) {
      tempDir.mkdirs();
    }
    File tempFile = File.createTempFile("format_", ".py", tempDir);
    try (FileWriter writer = new FileWriter(tempFile)) {
      writer.write(content);
    }
    return tempFile;
  }

  private static void formatWithBlack(Context context, File pythonFile)
      throws IOException, InterruptedException {
    String pythonPath = context.getApplicationInfo().nativeLibraryDir;
    String pythonHome = context.getFilesDir().getAbsolutePath() + "/usr";

    String command =
        String.format(
            "export PYTHONHOME=%s && "
                + "export PYTHONPATH=%s && "
                + "export LD_LIBRARY_PATH=%s/lib && "
                + "cd %s && "
                + // تغییر دایرکتوری کار به محل فایل
                "%s/libpython3.so -m black -q --config=/dev/null %s",
            pythonHome,
            pythonPath,
            pythonHome,
            pythonFile.getParent(),
            pythonPath,
            pythonFile.getName() // استفاده از نام فایل به جای مسیر کامل
            );

    Process process = Runtime.getRuntime().exec(new String[] {"sh", "-c", command});
    process.waitFor();
  }

  private static String readFile(File file) throws IOException {
    StringBuilder content = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");
      }
    }
    return content.toString().trim();
  }
}
