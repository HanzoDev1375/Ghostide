package ir.ninjacoder.ghostide.core.appupdate;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.blankj.utilcode.util.AppUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.noties.markwon.Markwon;
import io.noties.markwon.html.HtmlPlugin;
import ir.ninjacoder.ghostide.core.RequestNetwork;
import ir.ninjacoder.ghostide.core.RequestNetworkController;
import ir.ninjacoder.ghostide.core.appupdate.model.AppUpdateModel;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import ir.ninjacoder.ghostide.core.widget.ExrtaFab;
import java.util.HashMap;
import java.util.List;
import ninja.coder.appuploader.main.ViewDownloder;

public class UpadteAppView {
  private Context context;
  private String TAG = getClass().getName();
  private ViewDownloder downloder;
  private String version;
  private ExrtaFab fabAdd;
  private AppUpdateCallBack call;
  private final String constLinkGithub =
      "https://raw.githubusercontent.com/HanzoDev1375/HanzoDev1375/main/log.json";
  private RequestNetwork CheckNewVersion;
  private RequestNetwork.RequestListener UpdateCheck;
  private AppUpdateModel model;

  public UpadteAppView(
      Context context, ViewDownloder downloder, ExrtaFab fabAdd, AppUpdateCallBack call) {
    this.context = context;
    this.downloder = downloder;
    this.fabAdd = fabAdd;
    this.call = call;
    CheckNewVersion = new RequestNetwork((Activity) context);
  }

  public void init() {
    UpdateCheck =
        new RequestNetwork.RequestListener() {

          @Override
          public void onResponse(String _param1, String response, HashMap<String, Object> _param3) {

            try {
              model = new Gson().fromJson(response, AppUpdateModel.class);
            } catch (Exception err) {
              Log.e(TAG, err.getMessage());
            }

            if (!model.getVersion().equals(AppUtils.getAppVersionName())) {
              var di = new MaterialAlertDialogBuilder(context);
              di.setTitle(getMarkDownText(model.getTitle()));
              di.setMessage(getMarkDownText(model.getMassges()));
              di.setCancelable(false);

              di.setNeutralButton(
                  "Update",
                  (p, d) -> {
                    downloder.setTitle(model.getTitle());
                    downloder.setSizeTitle(
                        ObjectUtils.hasCpuArm64() ? model.getSizearm64() : model.getSizearm32());
                    downloder.setVisibility(View.VISIBLE);
                    fabAdd.setVisibility(View.GONE);
                    downloder.setOnClick(
                        v -> {
                          downloder.setDownload(
                              ObjectUtils.hasCpuArm64()
                                  ? model.getLinkarm64()
                                  : model.getLinkarm32(),
                              model.getAppname());
                          call.call();
                        });
                  });
              di.setPositiveButton("Ask Later", null);
              di.show();
            } else {
              DataUtil.showMessage(
                  context, getMarkDownText("**Not found** <ins>new version</ins>"));
              /// Empty
            }
          }

          @Override
          public void onErrorResponse(String _param1, String _param2) {
            Log.d(TAG, "You Offline! Whyyyyyyy?");
          }
        };
    CheckNewVersion.startRequestNetwork(
        RequestNetworkController.GET, constLinkGithub, "", UpdateCheck);
  }

  private CharSequence getMarkDownText(String code) {
    var markdown = Markwon.builder(context).usePlugin(HtmlPlugin.create()).build();
    return markdown.toMarkdown(code);
  }
}
