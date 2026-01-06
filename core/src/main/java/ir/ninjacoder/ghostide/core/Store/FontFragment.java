package ir.ninjacoder.ghostide.core.Store;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.MainThread;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ThreadUtils;
import com.downloader.databinding.LayoutFontViewBinding;
import com.downloader.databinding.OneRvBinding;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ir.ninjacoder.ghostide.core.RequestNetwork;
import ir.ninjacoder.ghostide.core.RequestNetworkController;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class FontFragment extends BaseFragment {

  private OneRvBinding bin;
  private RequestNetwork network;
  private RequestNetwork.RequestListener call;
  private String key = "font";
  private String link =
      "https://raw.githubusercontent.com/HanzoDev1375/ghostfont/refs/heads/main/github_font.json";
  private List<Map<String, String>> listFont = new ArrayList<>();
  private List<Map<String, String>> originalList = new ArrayList<>();
  private String currentQuery = "";
  private FontAd adapter;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    bin = OneRvBinding.inflate(inflater, container, false);
    return bin.getRoot();
  }

  @Override
  @MainThread
  public void onViewCreated(View arg0, Bundle arg1) {
    super.onViewCreated(arg0, arg1);
    network = new RequestNetwork((Activity) getContext());
    call =
        new RequestNetwork.RequestListener() {
          @Override
          public void onResponse(
              String tag, String response, HashMap<String, Object> responseHeaders) {
            listFont =
                new Gson()
                    .fromJson(response, new TypeToken<List<Map<String, String>>>() {}.getType());

            // پر کردن originalList با داده‌های دریافتی
            originalList.clear();
            originalList.addAll(listFont);

            bin.rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
            adapter = new FontAd(listFont);
            bin.rv.setAdapter(adapter);
          }

          @Override
          public void onErrorResponse(String tag, String message) {
            Toast.makeText(getContext(), "خطا در دریافت فونت‌ها", Toast.LENGTH_SHORT).show();
          }
        };
    network.startRequestNetwork(RequestNetworkController.GET, link, "", call);
  }

  public void filter(String query) {
    currentQuery = query;
    if (adapter != null) {
      adapter.filter(query);
    }
  }

  class FontAd extends RecyclerView.Adapter<FontAd.Holder> {
    private List<Map<String, String>> list;

    public FontAd(List<Map<String, String>> list) {
      this.list = list;
    }

    @Override
    public int getItemCount() {
      return list.size();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
      var binding = LayoutFontViewBinding.inflate(LayoutInflater.from(parent.getContext()));
      return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(Holder holder, int pos) {
      String fontUrl = list.get(pos).get(key);

      // استخراج نام فونت از URL
      String fontName = extractFontNameFromUrl(fontUrl);
      holder.textContent.setText(fontName);

      FontManager.setFontFromUrl(getContext(), holder.textContent, fontUrl);

      // هایلایت کردن متن جستجو
      ObjectUtils.setHighlightSearchText(holder.textContent, fontName, currentQuery);

      holder.itemView.setOnClickListener(
          v -> {
            downloadAndSaveFont(getContext(), fontUrl);
          });
    }

    public void filter(String query) {
      list.clear();
      if (query.isEmpty()) {
        list.addAll(originalList);
      } else {
        for (Map<String, String> item : originalList) {
          String fontUrl = item.get("font");
          String fontName = extractFontNameFromUrl(fontUrl);

          if (fontName.toLowerCase().contains(query.toLowerCase())) {
            list.add(item);
          }
        }
      }
      notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder {
      TextView textContent;

      public Holder(LayoutFontViewBinding v) {
        super(v.getRoot());
        textContent = v.textContent;
      }
    }
  }

  // متد برای استخراج نام فونت از URL
  private String extractFontNameFromUrl(String url) {
    try {
      String fileName = url.substring(url.lastIndexOf('/') + 1);
      // حذف پسوند فایل
      if (fileName.contains(".")) {
        fileName = fileName.substring(0, fileName.lastIndexOf('.'));
      }
      // جایگزینی underline با فاصله
      fileName = fileName.replace("_", " ");
      // حذف اعداد و کاراکترهای خاص (اختیاری)
      fileName = fileName.replaceAll("[0-9]", "");
      return fileName.trim();
    } catch (Exception e) {
      return url; // اگر خطایی رخ داد، خود URL را برگردان
    }
  }

  private void downloadAndSaveFont(Context context, String fontUrl) {
    ThreadUtils.executeByIo(
        new ThreadUtils.SimpleTask<File>() {
          @Override
          public File doInBackground() throws Throwable {
            URL url = new URL(fontUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            File downloadsDir = new File("/storage/emulated/0/GhostWebIDE/font/");
            if (!downloadsDir.exists()) {
              downloadsDir.mkdirs();
            }

            // نام فایل از URL استخراج می‌شود
            String fileName = fontUrl.substring(fontUrl.lastIndexOf('/') + 1);
            File fontFile = new File(downloadsDir, fileName);

            // ذخیره فونت در پوشه Downloads
            try (OutputStream outputStream = new FileOutputStream(fontFile)) {
              byte[] buffer = new byte[4096];
              int bytesRead;
              while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
              }
            } finally {
              inputStream.close();
            }

            return fontFile;
          }

          @Override
          public void onSuccess(File result) {
            // ذخیره مسیر فونت در SharedPreferences
            SharedPreferences prefs =
                context.getSharedPreferences("font_prefs", Context.MODE_PRIVATE);
            prefs.edit().putString("selected_font_path", result.getAbsolutePath()).apply();

            Toast.makeText(
                    context, "فونت با موفقیت ذخیره شد: " + result.getPath(), Toast.LENGTH_SHORT)
                .show();
          }

          @Override
          public void onFail(Throwable t) {
            Toast.makeText(context, "خطا در ذخیره فونت", Toast.LENGTH_SHORT).show();
          }
        });
  }
}
