package lsp4custom.com.ninjacoder.customhtmllsp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import io.github.rosemoe.sora.data.CompletionItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ScriptAnalyzer {

  private static final String TAG = "ScriptAnalyzer";
  private static final String CACHE_DIR = "/sdcard/apk/";
  private final File projectDir;
  private final Context context;
  private final OkHttpClient httpClient;
  private final String prefix;
  private AnalysisListener listener;
  private int scriptsPending = 0;
  private final List<CompletionItem> allMethods = new ArrayList<>();
  private final List<CompletionItem> allVars = new ArrayList<>();

  public ScriptAnalyzer(Context context, String prefix, File projectDir) {
    this.context = context;
    this.prefix = prefix;
    this.projectDir = projectDir;
    this.httpClient =
        new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();
  }

  public void setListener(AnalysisListener listener) {
    this.listener = listener;
  }

  public void analyzeHtml(String htmlContent) {
    if (htmlContent == null) {
      showError("HTML content is NULL!");
      return;
    }

    allMethods.clear();
    allVars.clear();

    try {
      Document doc = Jsoup.parse(htmlContent);
      Elements scripts = doc.select("script[src]");

      if (scripts.isEmpty()) {
        showToast("No external scripts found");
        notifyListener();
        return;
      }

      List<String> scriptSrcs =
          scripts.stream()
              .map(script -> script.attr("src"))
              .filter(src -> src != null && !src.isEmpty())
              .collect(Collectors.toList());

      if (scriptSrcs.isEmpty()) {
        showToast("No valid script src found");
        notifyListener();
        return;
      }

      scriptsPending = scriptSrcs.size();

      for (String src : scriptSrcs) {
        downloadAndAnalyze(src);
      }

    } catch (Exception e) {
      showError("Parser crashed: " + e.getClass().getSimpleName() + " - " + e.getMessage());
      Log.e(TAG, "Parsing error", e);
      notifyListener();
    }
  }

  private void downloadAndAnalyze(String src) {
    try {
      String fileName = Uri.parse(src).getLastPathSegment();
      if (fileName == null || fileName.isEmpty()) {
        Log.w(TAG, "Invalid filename from src: " + src);
        onScriptProcessed();
        return;
      }

      String jsCode = null;

      // ۱. بررسی مسیر نسبی نسبت به مسیر پروژه (projectDir)
      try {
        File resolvedProjectFile = new File(projectDir, src).getCanonicalFile();
        if (resolvedProjectFile.exists() && resolvedProjectFile.isFile()) {
          jsCode = readFile(resolvedProjectFile);
          Log.i(
              TAG,
              "📂 Loaded from relative project path: " + resolvedProjectFile.getAbsolutePath());
        }
      } catch (IOException ioEx) {
        Log.w(TAG, "⚠️ Failed to resolve relative path: " + src + " → " + ioEx.getMessage());
      }

      // ۲. بررسی فایل در کش (CACHE_DIR)
      if (jsCode == null) {
        File cacheFile = new File(CACHE_DIR, fileName);
        if (cacheFile.exists()) {
          jsCode = readFile(cacheFile);
          Log.i(TAG, "📁 Loaded from cache: " + cacheFile.getAbsolutePath());
        }

        // ۳. در صورت آنلاین بودن، دانلود کن
        else if (src.startsWith("http") && isNetworkAvailable()) {
          jsCode = downloadScript(src);
          if (jsCode == null || jsCode.trim().isEmpty()) {
            onScriptProcessed();
            return;
          }
          saveFile(cacheFile, jsCode);
          Log.i(TAG, "⬇️ Downloaded and cached: " + cacheFile.getAbsolutePath());
        }

        // ۴. هیچ منبعی پیدا نشد
        else {
          Log.w(TAG, "❌ Not found locally or online: " + src);
          onScriptProcessed();
          return;
        }
      }

      // ۵. تحلیل کد JS و اضافه‌کردن به لیست
      List<CompletionItem> methods = getJavaScriptMethods(jsCode, fileName, prefix);
      List<CompletionItem> vars = getJavaScriptVariables(jsCode, fileName, prefix);
      allMethods.addAll(methods);
      allVars.addAll(vars);

      showToast("✅ Parsed: " + fileName);

    } catch (Exception e) {
      showError("Error processing: " + src + " → " + e.getMessage());
    } finally {
      onScriptProcessed();
    }
  }

  private void onScriptProcessed() {
    scriptsPending--;
    if (scriptsPending == 0) {
      notifyListener();
    }
  }

  private void notifyListener() {
    if (listener != null) {
      listener.onAnalysisComplete(allMethods, allVars);
    }
  }

  private static List<CompletionItem> getJavaScriptMethods(
      String jsCode, String fileName, String prefix) {
    List<CompletionItem> completionItems = new ArrayList<>();
    try {
      for (String methodName : JavaScriptParserHelper.extractJavaScriptMethods(jsCode)) {
        CompletionItem item = new CompletionItem();
        item.label = methodName;
        item.desc = "Method in " + fileName;
        item.commit = methodName + "()";
        completionItems.add(item);
      }
      if (prefix != null && !prefix.isEmpty()) {
        completionItems =
            completionItems.stream()
                .filter(item -> item.label.startsWith(prefix))
                .collect(Collectors.toList());
      }
    } catch (Exception err) {
      Log.e(TAG, "Error extracting methods", err);
    }
    return completionItems;
  }

  private static List<CompletionItem> getJavaScriptVariables(
      String jsCode, String fileName, String prefix) {
    List<CompletionItem> completionItems = new ArrayList<>();
    try {
      for (String varName : JavaScriptParserHelper.extractJavaScriptVariables(jsCode)) {
        CompletionItem item = new CompletionItem();
        item.label = varName;
        item.desc = "Variable in " + fileName;
        item.commit = varName;
        completionItems.add(item);
      }
      if (prefix != null && !prefix.isEmpty()) {
        completionItems =
            completionItems.stream()
                .filter(item -> item.label.startsWith(prefix))
                .collect(Collectors.toList());
      }
    } catch (Exception err) {
      Log.e(TAG, "Error extracting variables", err);
    }
    return completionItems;
  }

  private String downloadScript(String url) throws IOException {
    Request request = new Request.Builder().url(url).addHeader("User-Agent", "Mozilla/5.0").build();

    try (Response response = httpClient.newCall(request).execute()) {
      if (!response.isSuccessful()) {
        throw new IOException("HTTP " + response.code());
      }
      return response.body() != null ? response.body().string() : null;
    }
  }

  private void saveFile(File file, String content) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
      writer.write(content);
      Log.i(TAG, "Saved script to cache: " + file.getAbsolutePath());
    }
  }

  private String readFile(File file) throws IOException {
    StringBuilder builder = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        builder.append(line).append("\n");
      }
    }
    return builder.toString();
  }

  private boolean isNetworkAvailable() {
    ConnectivityManager cm =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    if (cm != null) {
      NetworkInfo netInfo = cm.getActiveNetworkInfo();
      return netInfo != null && netInfo.isConnected();
    }
    return false;
  }

  private void showToast(String message) {
    Log.i(TAG, message);
  }

  private void showError(String error) {
    Log.e(TAG, error);
  }

  public interface AnalysisListener {
    void onAnalysisComplete(List<CompletionItem> methods, List<CompletionItem> vars);
  }
}
