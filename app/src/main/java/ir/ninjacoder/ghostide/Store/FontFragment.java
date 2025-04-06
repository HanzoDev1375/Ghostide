package ir.ninjacoder.ghostide.Store;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
import java.io.File;
import com.blankj.utilcode.util.ThreadUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.downloader.databinding.LayoutFontViewBinding;
import com.downloader.databinding.OneRvBinding;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import ir.ninjacoder.ghostide.RequestNetwork;
import ir.ninjacoder.ghostide.RequestNetworkController;
import ir.ninjacoder.ghostide.Store.FontManager;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FontFragment extends Fragment {

  private OneRvBinding bin;
  private RequestNetwork network;
  private RequestNetwork.RequestListener call;
  private String key = "font";
  private String link =
      "https://raw.githubusercontent.com/HanzoDev1375/ghostfont/refs/heads/main/github_font.json";
  private List<Map<String, String>> listFont = new ArrayList<>();

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
            bin.rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
            bin.rv.setAdapter(new FontAd(listFont));
          }

          @Override
          public void onErrorResponse(String tag, String message) {}
        };
    network.startRequestNetwork(RequestNetworkController.GET, link, "", call);
  }

  class FontAd extends RecyclerView.Adapter<FontAd.Holder> {
    private List<Map<String, String>> list;
    private LayoutFontViewBinding binding;

    public FontAd(List<Map<String, String>> list) {
      this.list = list;
    }

    class Holder extends RecyclerView.ViewHolder {
      public Holder(View v) {
        super(v);
      }
    }

    @Override
    public int getItemCount() {
      return list.size();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
      binding = LayoutFontViewBinding.inflate(LayoutInflater.from(parent.getContext()));
      return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(Holder holder, int pos) {
      String fontUrl = list.get(pos).get(key);
      FontManager.setFontFromUrl(getContext(), binding.textContent, fontUrl);

      holder.itemView.setOnClickListener(
          v -> {   
            downloadAndSaveFont(getContext(), fontUrl);
          });
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
            File downloadsDir = new File("//storage/emulated/0/GhostWebIDE/font/");
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
