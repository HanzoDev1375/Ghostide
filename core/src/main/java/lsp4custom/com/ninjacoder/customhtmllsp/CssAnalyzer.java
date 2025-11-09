package lsp4custom.com.ninjacoder.customhtmllsp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;

import com.helger.css.ECSSVersion;
import com.helger.css.decl.CSSSelector;
import com.helger.css.decl.CSSStyleRule;
import com.helger.css.decl.CascadingStyleSheet;
import com.helger.css.reader.CSSReader;
import com.helger.css.reader.CSSReaderSettings;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import io.github.rosemoe.sora.data.CompletionItem;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CssAnalyzer {

  private static final String TAG = "CssAnalyzer";
  private static final String CACHE_DIR = "/sdcard/apk/";

  private final Context context;
  private final OkHttpClient httpClient;
  private final File projectDir;
  private final String prefix;
  private CssAnalysisListener listener;
  private int stylesPending = 0;
  private final List<CompletionItem> allSelectors = new ArrayList<>();

  public CssAnalyzer(Context context, String prefix, File projectDir) {
    this.context = context;
    this.prefix = prefix;
    this.projectDir = projectDir;
    this.httpClient =
        new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();
  }

  public void setListener(CssAnalysisListener listener) {
    this.listener = listener;
  }

  public void analyzeHtml(String htmlContent) {
    if (htmlContent == null) {
      showError("HTML content is NULL!");
      return;
    }

    allSelectors.clear();

    try {
      Document doc = Jsoup.parse(htmlContent);
      Elements links = doc.select("link[rel=stylesheet][href]");

      List<String> cssLinks =
          links.stream()
              .map(link -> link.attr("href"))
              .filter(href -> href != null && !href.isEmpty())
              .collect(Collectors.toList());

      if (cssLinks.isEmpty()) {
        showToast("No external CSS found");
        notifyListener();
        return;
      }

      stylesPending = cssLinks.size();

      for (String href : cssLinks) {
        loadAndAnalyzeCss(href);
      }

    } catch (Exception e) {
      showError("Parser error: " + e.getMessage());
      notifyListener();
    }
  }

  private void loadAndAnalyzeCss(String href) {
    try {
      String fileName = Uri.parse(href).getLastPathSegment();
      if (fileName == null || fileName.isEmpty()) {
        onStyleProcessed();
        return;
      }

      String cssCode = null;

      try {
        File resolved = new File(projectDir, href).getCanonicalFile();
        if (resolved.exists()) {
          cssCode = readFile(resolved);
          Log.i(TAG, "📂 CSS from project: " + resolved.getAbsolutePath());
        }
      } catch (IOException e) {
        Log.w(TAG, "⚠️ Relative path failed: " + href);
      }

      File cacheFile = new File(CACHE_DIR, fileName);
      if (cssCode == null && cacheFile.exists()) {
        cssCode = readFile(cacheFile);
        Log.i(TAG, "📁 CSS from cache: " + cacheFile.getAbsolutePath());
      } else if (cssCode == null && href.startsWith("http") && isNetworkAvailable()) {
        cssCode = downloadCss(href);
        if (cssCode != null) {
          saveFile(cacheFile, cssCode);
          Log.i(TAG, "⬇️ CSS downloaded and cached: " + cacheFile.getAbsolutePath());
        }
      }

      if (cssCode == null) {
        Log.w(TAG, "❌ Could not load CSS: " + href);
        onStyleProcessed();
        return;
      }

      List<CompletionItem> selectors = extractCssSelectors(cssCode, fileName);
      allSelectors.addAll(selectors);

      showToast("✅ Parsed CSS: " + fileName);

    } catch (Exception e) {
      showError("Error loading CSS: " + e.getMessage());
    } finally {
      onStyleProcessed();
    }
  }

  private List<CompletionItem> extractCssSelectors(String cssCode, String fileName) {
    List<CompletionItem> items = new ArrayList<>();
    try {
      CSSReaderSettings settings =
          new CSSReaderSettings().setCSSVersion(ECSSVersion.CSS30).setBrowserCompliantMode(true);

      CascadingStyleSheet css = CSSReader.readFromStringReader(cssCode, settings);
      if (css != null) {
        for (CSSStyleRule rule : css.getAllStyleRules()) {
          for (CSSSelector sel : rule.getAllSelectors()) {
            String selText = sel.getAsCSSString().trim();
            if (prefix != null && !prefix.isEmpty() && !selText.startsWith(prefix)) {
              continue;
            }
            CompletionItem item = new CompletionItem();
            item.label = selText;
            item.desc = "Selector in " + fileName;
            item.commit = selText;
            items.add(item);
          }
        }
      }
    } catch (Exception e) {
      Log.e(TAG, "CSS parsing error", e);
    }
    return items;
  }

  private void onStyleProcessed() {
    stylesPending--;
    if (stylesPending == 0) {
      notifyListener();
    }
  }

  private void notifyListener() {
    if (listener != null) {
      listener.onCssAnalysisComplete(allSelectors);
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

  private void saveFile(File file, String content) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
      writer.write(content);
    }
  }

  private String downloadCss(String url) throws IOException {
    Request request = new Request.Builder().url(url).addHeader("User-Agent", "Mozilla/5.0").build();
    try (Response response = httpClient.newCall(request).execute()) {
      if (!response.isSuccessful()) throw new IOException("HTTP " + response.code());
      return response.body() != null ? response.body().string() : null;
    }
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

  private void showToast(String msg) {
    Log.i(TAG, msg);
  }

  private void showError(String err) {
    Log.e(TAG, err);
  }

  public interface CssAnalysisListener {
    void onCssAnalysisComplete(List<CompletionItem> selectors);
  }
}
