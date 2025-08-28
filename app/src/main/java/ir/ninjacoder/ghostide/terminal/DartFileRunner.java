package ir.ninjacoder.ghostide.terminal;

import android.content.Context;
import android.util.Log;

import java.io.*;

public class DartFileRunner {

  private static final String TAG = "DartFileRunner";

  /**
   * اجرای یک فایل Dart و گرفتن خروجی آن این کلاس بتا است و ممکن است امرا نشود
   *
   * @param context Context برنامه (برای دسترسی به فایل‌ها)
   * @param dartFile فایل Dart که باید اجرا شود
   * @return خروجی اجرای Dart به صورت String
   */
  public static String runDartFile(Context context, File dartFile) {
    StringBuilder output = new StringBuilder();

    if (!dartFile.exists() || !dartFile.canRead()) {
      return "Error: فایل وجود ندارد یا قابل خواندن نیست";
    }
    dartFile.setExecutable(true);
    try {

      String command =
          context.getFilesDir().getAbsolutePath()
              + File.separator
              + "dart-sdk/dart-sdk/bin/dart run "
              + dartFile.getAbsolutePath();

      ProcessBuilder pb = new ProcessBuilder("sh", "-c", command);
      pb.redirectErrorStream(true);

      Process process = pb.start();

      // خواندن خروجی
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line).append("\n");
      }

      process.waitFor();

    } catch (IOException e) {
      Log.e(TAG, "خطا در اجرای Dart", e);
      output.append("Error: ").append(e.getMessage());
    } catch (InterruptedException e) {
      Log.e(TAG, "فرایند Dart قطع شد", e);
      output.append("Interrupted: ").append(e.getMessage());
    }

    return output.toString().trim();
  }
}
