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

  private void downloadAndAnalyze(String src) {
    try {
      String fileName = Uri.parse(src).getLastPathSegment();
      if (fileName == null || fileName.isEmpty()) {
        Log.w(TAG, "Invalid filename from src: " + src);
        onScriptProcessed();
        return;
      }

      processWithJsonCache(src, fileName);
      showToast("Processed: " + fileName);

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

  private String getCacheKey(String src) {
    String fileName = Uri.parse(src).getLastPathSegment();
    return fileName != null ? fileName + ".json" : "cache.json";
  }

  private void processWithJsonCache(String src, String fileName) {
    File jsonCacheFile = new File(CACHE_DIR, getCacheKey(src));
    
    try {
      String jsCode = loadScriptContent(src);
      if (jsCode != null) {
        List<CompletionItem> methods = getJavaScriptMethods(jsCode, fileName, prefix);
        List<CompletionItem> vars = getJavaScriptVariables(jsCode, fileName, prefix);
        allMethods.addAll(methods);
        allVars.addAll(vars);
        
      }
    } catch (Exception err) {
      showError(err.getLocalizedMessage());
    }
  }

  private String loadScriptContent(String src) throws IOException {
    // ۱. بررسی مسیر نسبی
    File localFile = new File(projectDir, src).getCanonicalFile();
    if (localFile.exists()) {
      return readFile(localFile);
    }

    // ۲. بررسی کش
    File cacheFile = new File(CACHE_DIR, Uri.parse(src).getLastPathSegment());
    if (cacheFile.exists()) {
      return readFile(cacheFile);
    }

    // ۳. دانلود اگر آنلاین هست
    if (src.startsWith("http") && isNetworkAvailable()) {
      String content = downloadScript(src);
      if (content != null) {
        saveFile(cacheFile, content);
      }
      return content;
    }

    return null;
  }

  private void processScript(String src) {
    new Thread(
            () -> {
              try {
                String jsCode = loadScriptContent(src);
                if (jsCode == null) return;

                List<CompletionItem> methods = getJavaScriptMethods(jsCode, src, prefix);
                List<CompletionItem> vars = getJavaScriptVariables(jsCode, src, prefix);

                // ذخیره در حافظه موقت
                synchronized (this) {
                  allMethods.addAll(methods);
                  allVars.addAll(vars);
                }

                // ذخیره خودکار در کش
                saveToCache(methods, "methods");
                saveToCache(vars, "vars");

                showToast("Processed: " + src);

              } catch (Exception e) {
                showError("Script processing failed: " + e.getMessage());
              } finally {
                onScriptProcessed();
              }
            })
        .start();
  }

  private File getCacheFile(String type) {
    return new File(CACHE_DIR, "autocomplete_" + type + ".json");
  }

  private void saveToCache(List<CompletionItem> items, String type) {
    new Thread(
            () -> {
              File cacheFile = getCacheFile(type);
              JsonCacheHelper.saveToJson(cacheFile, items);
            })
        .start();
  }

  private List<CompletionItem> loadFromCache(String type) {
    File cacheFile = getCacheFile(type);
    if (cacheFile.exists()) {
      return JsonCacheHelper.loadFromJson(cacheFile);
    }
    return null;
  }

  public void analyzeHtml(String htmlContent) {
    // ابتدا از کش قدیمی بارگذاری کن
    List<CompletionItem> cachedMethods = loadFromCache("methods");
    List<CompletionItem> cachedVars = loadFromCache("vars");

    if (cachedMethods != null && cachedVars != null) {
      allMethods.addAll(cachedMethods);
      allVars.addAll(cachedVars);
      notifyListener();
      showToast("Using cached data");
      return;
    }

    // اگر کش وجود نداشت، پردازش جدید انجام شود
    processHtmlContent(htmlContent);
  }

  private void processHtmlContent(String htmlContent) {
    try {
      Document doc = Jsoup.parse(htmlContent);
      Elements scripts = doc.select("script[src]");

      if (scripts.isEmpty()) {
        showToast("No external scripts");
        return;
      }

      for (Element script : scripts) {
        String src = script.attr("src");
        if (src != null && !src.isEmpty()) {
          processScript(src);
        }
      }
    } catch (Exception e) {
      showError("HTML processing failed: " + e.getMessage());
    }
  }
}
