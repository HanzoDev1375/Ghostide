package ir.ninjacoder.ghostide.Store;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
import androidx.annotation.MainThread;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import ir.ninjacoder.ghostide.RequestNetworkController;
import java.io.File;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
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

  private String linkhost =
      "https://raw.githubusercontent.com/HanzoDev1375/ghosttheme/refs/heads/main/github_theme.json";
  private String imageKey = "image";
  private String themeKey = "theme";
  private String backgroundKey = "background";
  private List<Map<String, String>> listAll = new ArrayList<>();
  private RequestNetwork req;
  private RequestNetwork.RequestListener call;
  private OneRvBinding bind;
  private LayoutCustomimagepreviewBinding bin;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    bind = OneRvBinding.inflate(inflater, container, false);
    return bind.getRoot();
  }

  @Override
  @MainThread
  public void onViewCreated(View arg0, Bundle arg1) {
    super.onViewCreated(arg0, arg1);
    binds();
  }

  void binds() {
    req = new RequestNetwork((Activity) getContext());
    call =
        new RequestNetwork.RequestListener() {
          @Override
          public void onResponse(
              String tag, String response, HashMap<String, Object> responseHeaders) {
            try {
              var type = new TypeToken<List<Map<String, String>>>() {}.getType();
              listAll = new Gson().fromJson(response, type);
              bind.rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
              bind.rv.setAdapter(new ThemeRv(listAll));
            } catch (Exception e) {
              Toast.makeText(getContext(), "Error parsing theme data", Toast.LENGTH_SHORT).show();
            }
          }

          @Override
          public void onErrorResponse(String tag, String message) {
            Toast.makeText(getContext(), "Error loading themes: " + message, Toast.LENGTH_SHORT)
                .show();
          }
        };

    req.startRequestNetwork(RequestNetworkController.GET, linkhost, "", call);
  }

  class ThemeRv extends RecyclerView.Adapter<ThemeRv.Holder> {

    private List<Map<String, String>> list;
    private LayoutThemestoreBinding themebinding;

    public ThemeRv(List<Map<String, String>> list) {
      this.list = list;
    }

    static class Holder extends RecyclerView.ViewHolder {
      public Holder(View view) {
        super(view);
      }
    }

    @Override
    public int getItemCount() {
      return list.size();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup viewgroup, int arg1) {
      themebinding = LayoutThemestoreBinding.inflate(LayoutInflater.from(viewgroup.getContext()));
      return new Holder(themebinding.getRoot());
    }

    @Override
    public void onBindViewHolder(Holder holder, int pos) {
      var get = list.get(pos);

      String themeName = "Default";
      if (get.containsKey(themeKey)) {
        themeName = extractThemeName(get.get(themeKey));
      }
      themebinding.nametheme.setText(themeName);

      if (get.containsKey(imageKey)) {
        Glide.with(themebinding.previewicon.getContext())
            .load(get.get(imageKey))
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(themebinding.previewicon);
      }

      themebinding
          .getRoot()
          .setOnClickListener(
              i -> {
                setSheet(pos);
              });
    }

    String extractThemeName(String themeUrl) {
      if (themeUrl == null || themeUrl.isEmpty()) {
        return "Default";
      }
      String fileName = themeUrl.substring(themeUrl.lastIndexOf('/') + 1);
      String themeName = fileName.split("\\.")[0];
      return themeName.substring(0, 1).toUpperCase() + themeName.substring(1);
    }

    void setSheet(int pos) {
      bin = LayoutCustomimagepreviewBinding.inflate(LayoutInflater.from(getContext()));

      var sheet = new Sheet(getContext());
      sheet.setFullScreen();
      sheet.show();
      bin.fab1.setVisibility(View.INVISIBLE);
      bin.fab2.setVisibility(View.INVISIBLE);
      bin.fab3.setText("Save Theme");

      Map<String, String> selectedTheme = list.get(pos);

      bin.fab3.setOnClickListener(
          v -> {
            saveThemeAndBackground(selectedTheme, pos);
          });

      if (selectedTheme.containsKey(imageKey)) {
        Glide.with(bin.backgroundImage.getContext())
            .load(selectedTheme.get(imageKey))
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(bin.backgroundImage);
      }
    }

    void saveThemeAndBackground(Map<String, String> themeData, int pos) {
      // ایجاد دیالوگ پیشرفت
      MaterialAlertDialogBuilder progressDialog =
          new MaterialAlertDialogBuilder(getContext())
              .setTitle("در حال دانلود تم")
              .setMessage("لطفاً صبر کنید...")
              .setCancelable(false)
              .create();

      AlertDialog dialog = progressDialog.show();

      ThreadUtils.executeByIo(
          new ThreadUtils.SimpleTask<DownloadResult>() {
            @Override
            public DownloadResult doInBackground() throws Throwable {
              File themeDir = new File(THEME_DIR);
              if (!themeDir.exists()) {
                themeDir.mkdirs();
              }

              String themeUrl = themeData.get(themeKey);
              String backgroundUrl = themeData.get(backgroundKey);

              File themeFile = null;
              File backgroundFile = null;

              // دانلود تم
              if (themeUrl != null && !themeUrl.isEmpty()) {
                ThreadUtils.runOnUiThread(
                    () -> {
                      dialog.setMessage("در حال دانلود فایل تم...");
                    });
                String themeFileName = getFileNameFromUrl(themeUrl);
                themeFile = downloadFile(themeUrl, themeDir, themeFileName);
              }

              // دانلود پس‌زمینه
              if (backgroundUrl != null && !backgroundUrl.isEmpty()) {
                ThreadUtils.runOnUiThread(
                    () -> {
                      dialog.setMessage(
                          "در حال دانلود تصویر پس‌زمینه...\n(این ممکن است چند لحظه طول بکشد)");
                    });
                String backgroundFileName = getFileNameFromUrl(backgroundUrl);
                backgroundFile = downloadFile(backgroundUrl, themeDir, backgroundFileName);
              }

              return new DownloadResult(themeFile, backgroundFile);
            }

            @Override
            public void onSuccess(DownloadResult result) {
              dialog.dismiss(); // بستن دیالوگ پیشرفت

              if (result.themeFile == null && result.backgroundFile == null) {
                Toast.makeText(getContext(), "هیچ فایلی دانلود نشد", Toast.LENGTH_SHORT).show();
                return;
              }

              // ایجاد دیالوگ نصب تم
              new MaterialAlertDialogBuilder(getContext())
                  .setTitle("نصب تم")
                  .setMessage("تم با موفقیت دانلود شد.\nآیا می‌خواهید این تم را اعمال کنید؟")
                  .setPositiveButton(
                      "بله",
                      (e, ee) -> {
                        SharedPreferences themePrefs =
                            getContext().getSharedPreferences(THEME_PREFS, Context.MODE_PRIVATE);

                        SharedPreferences backgroundPrefs =
                            getContext()
                                .getSharedPreferences(BACKGROUND_PREFS, Context.MODE_PRIVATE);

                        if (result.themeFile != null) {
                          themePrefs
                              .edit()
                              .putString("themes", result.themeFile.getAbsolutePath())
                              .apply();
                        }

                        if (result.backgroundFile != null) {
                          backgroundPrefs
                              .edit()
                              .putString("dir", result.backgroundFile.getAbsolutePath())
                              .apply();
                        }

                        String successMsg = "تم با موفقیت اعمال شد:\n";
                        if (result.themeFile != null) {
                          successMsg += "تم: " + result.themeFile.getName() + "\n";
                        }
                        if (result.backgroundFile != null) {
                          successMsg += "پس‌زمینه: " + result.backgroundFile.getName();
                        }

                        Toast.makeText(getContext(), successMsg, Toast.LENGTH_LONG).show();
                      })
                  .setNegativeButton("خیر", null)
                  .setNeutralButton("بعداً", null)
                  .show();
            }

            @Override
            public void onFail(Throwable t) {
              dialog.dismiss(); // بستن دیالوگ پیشرفت
              Toast.makeText(getContext(), "خطا در دانلود: " + t.getMessage(), Toast.LENGTH_LONG)
                  .show();
            }
          });
    }

    class DownloadResult {
      File themeFile;
      File backgroundFile;

      DownloadResult(File themeFile, File backgroundFile) {
        this.themeFile = themeFile;
        this.backgroundFile = backgroundFile;
      }
    }
  }

  class Sheet extends CustomSheet {
    public Sheet(Context c) {
      super(c);
    }

    @Override
    public View getView() {
      return bin.getRoot();
    }
  }
}
