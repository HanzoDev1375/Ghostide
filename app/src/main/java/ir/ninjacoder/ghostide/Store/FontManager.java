package ir.ninjacoder.ghostide.Store;

import com.blankj.utilcode.util.ThreadUtils;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import android.graphics.Typeface;
import android.content.Context;
import android.widget.TextView;
import java.util.HashMap;
import java.io.*;

public class FontManager {
  private static final Map<String, Typeface> fontCache = new HashMap<>();

  public static void setFontFromUrl(Context context, TextView textView, String fontUrl) {
    if (fontCache.containsKey(fontUrl)) {
      textView.setTypeface(fontCache.get(fontUrl));
      return;
    }

    ThreadUtils.executeByIo(
        new ThreadUtils.SimpleTask<Typeface>() {
          @Override
          public Typeface doInBackground() throws Throwable {
            URL url = new URL(fontUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();

            File tempFile = File.createTempFile("font", ".ttf", context.getCacheDir());

            // Write the input stream to the temp file
            try (OutputStream outputStream = new FileOutputStream(tempFile)) {
              byte[] buffer = new byte[4096];
              int bytesRead;
              while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
              }
            } finally {
              inputStream.close();
            }

            return Typeface.createFromFile(tempFile);
          }

          @Override
          public void onSuccess(Typeface result) {
            fontCache.put(fontUrl, result);
            textView.setTypeface(result);
          }
        });
  }
}
