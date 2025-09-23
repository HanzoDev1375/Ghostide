package ir.ninjacoder.ghostide.Store;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
import androidx.annotation.MainThread;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import ir.ninjacoder.ghostide.RequestNetworkController;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import java.io.File;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.app.*;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ThreadUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.downloader.databinding.LayoutCustomimagepreviewBinding;
import com.downloader.databinding.LayoutThemestoreBinding;
import com.downloader.databinding.OneRvBinding;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import ir.ninjacoder.ghostide.RequestNetwork;
import ir.ninjacoder.prograsssheet.CustomSheet;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThemeFragment extends Fragment {

  private static final String THEME_DIR = "/storage/emulated/0/GhostWebIDE/theme/";
  private static final String THEME_PREFS = "thememanagersoft";
  private static final String BACKGROUND_PREFS = "getvb";

  private final String linkhost =
      "https://raw.githubusercontent.com/HanzoDev1375/ghosttheme/refs/heads/main/github_theme.json";
  private final String imageKey = "image";
  private final String themeKey = "theme";
  private final String backgroundKey = "background";

  private List<Map<String, String>> listAll = new ArrayList<>();
  private RequestNetwork req;
  private OneRvBinding bind;
  private LayoutCustomimagepreviewBinding previewBinding;
  private ThemeAdapter adapter;
  private List<Map<String, String>> originalList = new ArrayList<>();
  private String currentQuery = "";

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    bind = OneRvBinding.inflate(inflater, container, false);
    return bind.getRoot();
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    binds();
  }

  public void filter(String query) {
    currentQuery = query;
    if (adapter != null) {
      adapter.filter(query);
    }
  }

  void binds() {
    req = new RequestNetwork((Activity) getContext());
    var call =
        new RequestNetwork.RequestListener() {
          @Override
          public void onResponse(
              String tag, String response, HashMap<String, Object> responseHeaders) {
            var type = new TypeToken<List<Map<String, String>>>() {}.getType();
            listAll = new Gson().fromJson(response, type);
            bind.rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
            adapter = new ThemeAdapter(listAll);
            bind.rv.setAdapter(adapter);
          }

          @Override
          public void onErrorResponse(String tag, String message) {}
        };

    req.startRequestNetwork(RequestNetworkController.GET, linkhost, "", call);
  }

  private class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ThemeViewHolder> {

    private List<Map<String, String>> filteredList;

    public ThemeAdapter(List<Map<String, String>> themes) {
      this.filteredList = themes;
      originalList = new ArrayList<>(themes);
    }

    public void filter(String query) {
      filteredList.clear();
      if (query.isEmpty()) {
        filteredList.addAll(originalList);
      } else {
        for (Map<String, String> item : originalList) {
          String themeName = item.get(themeKey);
          if (themeName.toLowerCase().contains(query.toLowerCase())) {
            filteredList.add(item);
          }
        }
      }
      notifyDataSetChanged();
    }

    @Override
    public ThemeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutThemestoreBinding binding =
          LayoutThemestoreBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
      return new ThemeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ThemeViewHolder holder, int position) {
      Map<String, String> themeData = filteredList.get(position);
      String themeName = getThemeName(themeData.get(themeKey));

      ObjectUtils.setHighlightSearchText(holder.binding.nametheme, themeName, currentQuery);

      holder.bind(filteredList.get(position));
    }

    @Override
    public int getItemCount() {
      return filteredList.size();
    }

    class ThemeViewHolder extends RecyclerView.ViewHolder {
      private final LayoutThemestoreBinding binding;

      public ThemeViewHolder(LayoutThemestoreBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
      }

      void bind(Map<String, String> themeData) {
        binding.nametheme.setText(getThemeName(themeData.get(themeKey)));

        if (themeData.containsKey(imageKey)) {
          Glide.with(binding.previewicon.getContext())
              .load(themeData.get(imageKey))
              .fitCenter()
              .diskCacheStrategy(DiskCacheStrategy.ALL)
              .into(binding.previewicon);
        }

        binding.getRoot().setOnClickListener(v -> showThemePreview(themeData));
      }
    }
  }

  class Sheet extends CustomSheet {
    public Sheet(Context c) {
      super(c);
    }

    @Override
    public View getView() {
      return previewBinding.getRoot();
    }
  }

  private void showThemePreview(Map<String, String> themeData) {
    previewBinding = LayoutCustomimagepreviewBinding.inflate(LayoutInflater.from(getContext()));

    Sheet sheet = new Sheet(getContext());
    sheet.setFullScreen();
    sheet.show();

    previewBinding.fab1.setVisibility(View.INVISIBLE);
    previewBinding.fab2.setVisibility(View.INVISIBLE);
    previewBinding.fab3.setText("ذخیره تم");

    if (themeData.containsKey(imageKey)) {
      Glide.with(previewBinding.backgroundImage.getContext())
          .load(themeData.get(imageKey))
          .diskCacheStrategy(DiskCacheStrategy.NONE)
          .into(previewBinding.backgroundImage);
    }

    previewBinding.fab3.setOnClickListener(
        v -> {
          sheet.dismiss();
          downloadAndSaveTheme(themeData);
        });
  }

  private void downloadAndSaveTheme(Map<String, String> themeData) {
    var progressDialog = new PrograssSheet(getContext());
    progressDialog.setTitle("Loading download Background");
    progressDialog.setPrograss(100, true);
    progressDialog.show();

    ThreadUtils.executeByIo(
        new ThreadUtils.SimpleTask<Boolean>() {
          @Override
          public Boolean doInBackground() throws Throwable {
            var themename = getThemeName(themeData.get(themeKey));
            File themeDir = new File(THEME_DIR + themename + File.separator);
            if (!themeDir.exists()) {
              themeDir.mkdirs();
            }

            boolean success = true;

            // Download theme file if exists
            if (themeData.containsKey(themeKey)) {
              String themeUrl = themeData.get(themeKey);
              if (themeUrl != null && !themeUrl.isEmpty()) {
                success &= downloadFile(themeUrl, themeDir, extractFileName(themeUrl));
              }
            }

            // Download background file if exists
            if (themeData.containsKey(backgroundKey)) {
              String bgUrl = themeData.get(backgroundKey);
              if (bgUrl != null && !bgUrl.isEmpty()) {
                success &= downloadFile(bgUrl, themeDir, extractFileName(bgUrl));
              }
            }

            return success;
          }

          @Override
          public void onSuccess(Boolean success) {
            progressDialog.dismiss();
            if (success) {
              showInstallDialog(themeData);
            } else {
              showToast("خطا در ذخیره برخی فایل ها");
            }
          }

          @Override
          public void onFail(Throwable t) {
            progressDialog.dismiss();
            showToast("خطا در دانلود: " + t.getMessage());
          }
        });
  }

  private void saveThemePaths(Map<String, String> themeData) {
    SharedPreferences themePrefs =
        getContext().getSharedPreferences(THEME_PREFS, Context.MODE_PRIVATE);
    SharedPreferences bgPrefs =
        getContext().getSharedPreferences(BACKGROUND_PREFS, Context.MODE_PRIVATE);

    SharedPreferences.Editor themeEditor = themePrefs.edit();
    SharedPreferences.Editor bgEditor = bgPrefs.edit();

    String themeName = getThemeName(themeData.get(themeKey));
    File themeDir = new File(THEME_DIR + themeName + "/");

    // ذخیره مسیر فایل تم
    if (themeData.containsKey(themeKey)) {
      String themeUrl = themeData.get(themeKey);
      if (themeUrl != null && !themeUrl.isEmpty()) {
        String fileName = extractFileName(themeUrl);
        themeEditor.putString("themes", new File(themeDir, fileName).getAbsolutePath());
      }
    }

    // ذخیره مسیر فایل پس‌زمینه
    if (themeData.containsKey(backgroundKey)) {
      String bgUrl = themeData.get(backgroundKey);
      if (bgUrl != null && !bgUrl.isEmpty()) {
        String fileName = extractFileName(bgUrl);
        bgEditor.putString("dir", new File(themeDir, fileName).getAbsolutePath());
      }
    }

    themeEditor.apply();
    bgEditor.apply();
  }

  private boolean downloadFile(String url, File directory, String fileName) throws Exception {
    if (url == null || url.isEmpty()) return false;

    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
    connection.connect();

    try (InputStream input = connection.getInputStream();
        OutputStream output = new FileOutputStream(new File(directory, fileName))) {

      byte[] buffer = new byte[4096];
      int bytesRead;
      while ((bytesRead = input.read(buffer)) != -1) {
        output.write(buffer, 0, bytesRead);
      }
    } finally {
      connection.disconnect();
    }

    return true;
  }

  private void showInstallDialog(Map<String, String> themeData) {
    new MaterialAlertDialogBuilder(getContext())
        .setTitle("install theme?")
        .setMessage("Do you want to install this theme?")
        .setPositiveButton(
            "install",
            (dialog, which) -> {
              saveThemePaths(themeData);
              showToast("Theme installed successfully");
            })
        .setNegativeButton("no", null)
        .show();
  }

  private String extractFileName(String url) {
    if (url == null) return "";
    return url.substring(url.lastIndexOf('/') + 1);
  }

  private String getThemeName(String themeUrl) {
    if (themeUrl == null || themeUrl.isEmpty()) return "No name";
    String fileName = extractFileName(themeUrl);
    return fileName.split("\\.")[0];
  }

  private void showToast(String message) {
    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
  }
}
