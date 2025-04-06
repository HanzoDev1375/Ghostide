package ir.ninjacoder.ghostide.Store;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import android.graphics.Typeface;
import android.content.Context;
import android.widget.TextView;
import java.util.HashMap;
import com.blankj.utilcode.util.ThreadUtils;
import android.content.SharedPreferences;
import java.io.*;

public class FontManager {
    private static final Map<String, Typeface> fontCache = new HashMap<>();

    public static void setFontFromUrl(Context context, TextView textView, String fontUrl) {
        if (fontUrl == null || fontUrl.isEmpty()) {
            // اگر فونتی انتخاب نشده، از فونت ذخیره شده استفاده کنید
            setSavedFont(context, textView);
            return;
        }

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

    public static void setSavedFont(Context context, TextView textView) {
        SharedPreferences prefs = context.getSharedPreferences("font_prefs", Context.MODE_PRIVATE);
        String fontPath = prefs.getString("selected_font_path", null);

        if (fontPath != null && new File(fontPath).exists()) {
            Typeface typeface = Typeface.createFromFile(fontPath);
            textView.setTypeface(typeface);
        }
    }
}