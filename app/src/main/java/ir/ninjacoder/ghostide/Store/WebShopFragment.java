package ir.ninjacoder.ghostide.Store;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
import android.view.Gravity;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.downloader.Error;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import android.widget.Button;
import android.graphics.Color;
import android.widget.LinearLayout;
import java.io.File;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ir.ninjacoder.ghostide.RequestNetwork;
import androidx.recyclerview.widget.GridLayoutManager;
import ir.ninjacoder.ghostide.utils.FileUtil;
import com.downloader.OnDownloadListener;
import com.downloader.PRDownloader;
import ir.ninjacoder.ghostide.utils.DataUtil;
import java.util.HashMap;
import java.util.List;
import com.ninjacoder.jgit.webstore.WebModel;
import java.util.ArrayList;
import android.app.Activity;
import ir.ninjacoder.ghostide.RequestNetworkController;
import com.ninjacoder.jgit.webstore.WebStoreAdapter;

public class WebShopFragment extends Fragment {

  private RecyclerView view;
  private RequestNetwork network;
  private RequestNetwork.RequestListener call;
  private String callreq =
      "https://raw.githubusercontent.com/HanzoDev1375/Ghostidewebstore/refs/heads/main/model.json";
  private GridLayoutManager layout;
  private WebStoreAdapter adapter;
  private List<WebModel> listModels = new ArrayList<>();

  @Override
  @MainThread
  @Nullable
  public View onCreateView(LayoutInflater arg0, ViewGroup arg1, Bundle arg2) {
    view = new RecyclerView(requireActivity());
    return view;
  }

  @Override
  @MainThread
  public void onViewCreated(View arg0, Bundle arg1) {
    super.onViewCreated(arg0, arg1);
    layout = new GridLayoutManager(requireContext(), 2);
    network = new RequestNetwork((Activity) getContext());
    call =
        new RequestNetwork.RequestListener() {

          @Override
          public void onResponse(
              String tag, String response, HashMap<String, Object> responseHeaders) {
            listModels =
                new Gson().fromJson(response, new TypeToken<List<WebModel>>() {}.getType());
            adapter =
                new WebStoreAdapter(
                    listModels,
                    (views, models) -> {
                      bind(models);
                    });

            view.setLayoutManager(layout);
            view.setAdapter(adapter);
          }

          @Override
          public void onErrorResponse(String tag, String message) {
            DataUtil.showMessage(requireContext(), message);
          }
        };
    network.startRequestNetwork(RequestNetworkController.GET, callreq, "", call);
  }

  public void filter(String data) {
    if (adapter != null) {
      adapter.filter(data);
    }
  }

  void bind(WebModel model) {
    download(model);
  }

  void download(WebModel model) {
    BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
    LinearProgressIndicator progressIndicator = new LinearProgressIndicator(requireContext());
    progressIndicator.setLayoutParams(
        new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    progressIndicator.setMax(100);
    progressIndicator.setProgress(0);
    progressIndicator.setIndeterminate(false);
    TextView statusText = new TextView(requireContext());
    statusText.setLayoutParams(
        new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    statusText.setText("در حال آماده سازی...");
    statusText.setGravity(Gravity.CENTER);
    statusText.setTextSize(16);
    statusText.setPadding(50, 30, 50, 30);
    Button cancelButton = new Button(requireContext());
    LinearLayout.LayoutParams buttonParams =
        new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    buttonParams.gravity = Gravity.CENTER;
    cancelButton.setLayoutParams(buttonParams);
    cancelButton.setText("لغو دانلود");
    cancelButton.setBackgroundColor(Color.RED);
    cancelButton.setTextColor(Color.WHITE);
    LinearLayout layout = new LinearLayout(requireContext());
    layout.setLayoutParams(
        new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    layout.setOrientation(LinearLayout.VERTICAL);
    layout.setPadding(50, 50, 50, 50);
    layout.setGravity(Gravity.CENTER);

    layout.addView(statusText);
    layout.addView(progressIndicator);
    layout.addView(cancelButton);

    bottomSheetDialog.setContentView(layout);
    bottomSheetDialog.setCancelable(false);
    bottomSheetDialog.show();
    String baseDir = "/storage/emulated/0/GhostWebIDE/webstore";
    if (!FileUtil.isDirectory(baseDir)) {
      FileUtil.makeDir(baseDir);
    }

    final String zipFilePath = baseDir + "/" + model.getName() + ".zip";
    final String extractPath = baseDir + "/" + model.getName();

    // شروع دانلود
    int downloadId =
        PRDownloader.download(model.getUrl(), baseDir, model.getName() + ".zip")
            .build()
            .setOnStartOrResumeListener(
                () -> {
                  statusText.setText("در حال دانلود...");
                })
            .setOnProgressListener(
                progress -> {
                  int percent = (int) ((progress.currentBytes * 100) / progress.totalBytes);
                  progressIndicator.setProgress(percent);
                  statusText.setText("در حال دانلود: " + percent + "%");
                })
            .start(
                new OnDownloadListener() {
                  @Override
                  public void onDownloadComplete() {
                    statusText.setText("در حال اکسترکت فایل...");
                    progressIndicator.setIndeterminate(true);
                    new Thread(
                            () -> {
                              boolean success = unzipFile(zipFilePath, extractPath);

                              requireActivity()
                                  .runOnUiThread(
                                      () -> {
                                        if (success) {
                                          // حذف فایل ZIP بعد از extract
                                          new File(zipFilePath).delete();

                                          statusText.setText("دانلود و اکسترکت کامل شد!");
                                          progressIndicator.setIndeterminate(false);
                                          progressIndicator.setProgress(100);
                                          new Handler(Looper.getMainLooper())
                                              .postDelayed(
                                                  () -> {
                                                    if (bottomSheetDialog.isShowing()) {
                                                      bottomSheetDialog.dismiss();
                                                    }
                                                    DataUtil.showMessage(
                                                        requireContext(), "دانلود کامل شد!");
                                                  },
                                                  2000);
                                        } else {
                                          statusText.setText("خطا در اکسترکت فایل");
                                          DataUtil.showMessage(
                                              requireContext(), "خطا در اکسترکت فایل ZIP");
                                        }
                                      });
                            })
                        .start();
                  }

                  @Override
                  public void onError(Error error) {
                    statusText.setText("خطا در دانلود");
                    DataUtil.showMessage(
                        requireContext(), "خطا در دانلود: " + error.getServerErrorMessage());
                  }
                });

    cancelButton.setOnClickListener(
        v -> {
          PRDownloader.cancel(downloadId);
          bottomSheetDialog.dismiss();
          DataUtil.showMessage(requireContext(), "دانلود لغو شد");
        });

    bottomSheetDialog.setOnDismissListener(
        dialog -> {
          PRDownloader.cancel(downloadId);
        });
  }

  private boolean unzipFile(String zipFilePath, String extractPath) {
    try {
      File zipFile = new File(zipFilePath);
      File outputDir = new File(extractPath);

      if (!outputDir.exists()) {
        outputDir.mkdirs();
      }
      java.util.zip.ZipInputStream zipInputStream =
          new java.util.zip.ZipInputStream(new java.io.FileInputStream(zipFile));
      java.util.zip.ZipEntry zipEntry;
      byte[] buffer = new byte[1024];

      while ((zipEntry = zipInputStream.getNextEntry()) != null) {
        File outputFile = new File(outputDir, zipEntry.getName());
        File parentDir = outputFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
          parentDir.mkdirs();
        }

        if (!zipEntry.isDirectory()) {
          java.io.FileOutputStream outputStream = new java.io.FileOutputStream(outputFile);
          int length;
          while ((length = zipInputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
          }
          outputStream.close();
        }

        zipInputStream.closeEntry();
      }

      zipInputStream.close();
      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
