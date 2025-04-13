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

  private String linkhost =
      "https://raw.githubusercontent.com/HanzoDev1375/ghosttheme/refs/heads/main/github_theme.json";
  private String image = "image";
  private String theme = "theme";
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
            var type = new TypeToken<List<Map<String, String>>>() {}.getType();
            listAll = new Gson().fromJson(response, type);
            bind.rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
            bind.rv.setAdapter(new ThemeRv(listAll));
          }

          @Override
          public void onErrorResponse(String tag, String message) {}
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
      themebinding.nametheme.setText(extractThemeName(get.get(theme)));
      Glide.with(themebinding.previewicon.getContext())
          .load(list.get(pos).get(image))
          .diskCacheStrategy(DiskCacheStrategy.NONE)
          .into(themebinding.previewicon);
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
      return themeName.substring(0, 1) + themeName.substring(1);
    }

    void setSheet(int pos) {
      bin = LayoutCustomimagepreviewBinding.inflate(LayoutInflater.from(getContext()));

      var sheet = new Sheet(getContext());
      sheet.setFullScreen();
      sheet.show();
      bin.fab1.setVisibility(View.INVISIBLE);
      bin.fab2.setVisibility(View.INVISIBLE);
      bin.fab3.setText("SaveTheme to file");
      bin.fab3.setOnClickListener(
          v -> {
            saveTheme(list.get(pos).get(theme), pos);
          });
      Glide.with(bin.backgroundImage.getContext())
          .load(list.get(pos).get(image))
          .diskCacheStrategy(DiskCacheStrategy.NONE)
          .into(bin.backgroundImage);
    }

    void saveTheme(String fontUrl, int pos) {

      ThreadUtils.executeByIo(
          new ThreadUtils.SimpleTask<File>() {
            @Override
            public File doInBackground() throws Throwable {
              URL url = new URL(fontUrl);
              HttpURLConnection connection = (HttpURLConnection) url.openConnection();
              connection.connect();
              InputStream inputStream = connection.getInputStream();
              File downloadsDir = new File("/storage/emulated/0/GhostWebIDE/theme/");
              if (!downloadsDir.exists()) {
                downloadsDir.mkdirs();
              }
              String fileName = fontUrl.substring(fontUrl.lastIndexOf('/') + 1);
              File fontFile = new File(downloadsDir, fileName);

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
              new MaterialAlertDialogBuilder(getContext())
                  .setTitle("Apply theme in Editor")
                  .setMessage("not try to select in theme for code editor !!!")
                  .setPositiveButton(
                      android.R.string.ok,
                      (e, ee) -> {
                        SharedPreferences prefs =
                            getContext().getSharedPreferences("thememanagersoft", Context.MODE_PRIVATE);
                        prefs.edit().putString("themes", result.getAbsolutePath()).apply();
                      })
                  .setNegativeButton(android.R.string.cancel, null)
                  .show();
              Toast.makeText(
                      getContext(),
                      "تم با موفقیت ذخیره شد: " + result.getPath(),
                      Toast.LENGTH_SHORT)
                  .show();
            }

            @Override
            public void onFail(Throwable t) {
              Toast.makeText(getContext(), "خطا در ذخیره تم", Toast.LENGTH_SHORT).show();
            }
          });
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
