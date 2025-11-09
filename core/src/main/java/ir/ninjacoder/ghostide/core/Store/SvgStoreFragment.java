package ir.ninjacoder.ghostide.core.Store;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.downloader.PRDownloader;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ninjacoder.jgit.svgstore.svgadapter.SvgShopAdapter;
import com.ninjacoder.jgit.svgstore.svgmodel.SvgShopModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ir.ninjacoder.ghostide.core.RequestNetwork;
import ir.ninjacoder.ghostide.core.RequestNetworkController;
import ir.ninjacoder.ghostide.core.glidecompat.GlideCompat;
import ir.ninjacoder.ghostide.core.model.ListSheet;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import ir.ninjacoder.ghostide.core.utils.FileUtil;

public class SvgStoreFragment extends Fragment {
  private RecyclerView view;
  private RequestNetwork network;
  private RequestNetwork.RequestListener call;
  private String callreq =
      "https://raw.githubusercontent.com/HanzoDev1375/svg-icon/refs/heads/main/icons.json";
  private GridLayoutManager layout;
  private SvgShopAdapter adapter;
  private List<SvgShopModel> listModels = new ArrayList<>();

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
    // TODO: Implement this method
    layout = new GridLayoutManager(requireContext(), 2);
    network = new RequestNetwork((Activity) getContext());
    call =
        new RequestNetwork.RequestListener() {

          @Override
          public void onResponse(
              String tag, String response, HashMap<String, Object> responseHeaders) {
            listModels =
                new Gson().fromJson(response, new TypeToken<List<SvgShopModel>>() {}.getType());
            adapter =
                new SvgShopAdapter(
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

  void bind(SvgShopModel model) {
    var listSheet = new ListSheet();
    listSheet.setSheetDialog(requireContext());
    listSheet.addItem("download");
    listSheet.addItem("View svg");
    listSheet.setOnItemClickLabe(
        pos -> {
          switch (pos) {
            case 0:
              download(model);
              listSheet.dissmiss();
              break;
            case 1:
              showInBottomSheet(model);
              listSheet.dissmiss();
              break;
          }
        });
  }

  void download(SvgShopModel model) {
    if (!FileUtil.isDirectory("/storage/emulated/0/GhostWebIDE/svg")) {
      FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/svg");
    } else {
      var prd =
          PRDownloader.download(
                  model.getIcon(), "/storage/emulated/0/GhostWebIDE/svg", model.getName())
              .build()
              .setOnStartOrResumeListener(
                  () -> {
                    DataUtil.showMessage(requireContext(), "start download");
                  })
              .setOnProgressListener(
                  pro -> {
                    DataUtil.showMessage(requireContext(), "start download" + pro.currentBytes);
                  })
              .start(
                  new OnDownloadListener() {

                    @Override
                    public void onDownloadComplete() {
                      DataUtil.showMessage(requireContext(), "done");
                    }

                    @Override
                    public void onError(Error error) {
                      DataUtil.showMessage(requireContext(), error.getServerErrorMessage());
                    }
                  });
    }
  }

  void showInBottomSheet(SvgShopModel model) {
    var bottomsheet = new BottomSheetDialog(requireContext());
    ImageView img = new ImageView(requireContext());
    img.setLayoutParams(
        new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        img.setColorFilter(Color.WHITE,PorterDuff.Mode.SRC_IN);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
    img.setPadding(10, 10, 10, 10);
    Glide.with(img.getContext())
        .load(model.getIcon())
        .placeholder(GlideCompat.CircelPrograssBar())
        .error(Color.RED)
        .into(img);
      img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      
    bottomsheet.setContentView(img);
    if (bottomsheet != null) {
      bottomsheet.show();
    }
  }
}
