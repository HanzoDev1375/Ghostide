package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.RequestNetwork;
import Ninja.coder.Ghostemane.code.RequestNetworkController;
import Ninja.coder.Ghostemane.code.adapter.DevAd;
import Ninja.coder.Ghostemane.code.glidecompat.GlideCompat;
import Ninja.coder.Ghostemane.code.model.DevModel;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AboutActivity extends BaseCompat implements DevAd.OnItemClick {
  protected TextView tv_about_name;
  protected RecyclerView rv_about_dev;
  protected DevAd devAd;
  protected List<DevModel> listModel = new ArrayList<>();
  private RequestNetwork sazndeh;
  private RequestNetwork.RequestListener _sazndeh_request_listener;
  private ImageView appicon;
  public static String ApiURL = "https://api.github.com/users/HanzoDev1375";

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.about);
    start();
  }

  private void start() {

    appicon = findViewById(R.id.icon_glide_about);
    tv_about_name = findViewById(R.id.tv_about_name);
    rv_about_dev = findViewById(R.id.rv_about_dev);

    listModel.add(new DevModel("Appt2 ", "main"));
    listModel.add(new DevModel("BlueWhaleYT", "main"));
    listModel.add(new DevModel("Mohammad Taha", "main"));
    listModel.add(new DevModel("Ban Doroid", "marco"));
    listModel.add(new DevModel("Mister Java", "macro"));
    listModel.add(new DevModel("Psi", "Help to adding python"));
    listModel.add(new DevModel("EUP", "marco"));
    listModel.add(new DevModel("timscriptov", "Tanks for Library layout preview"));
    GlideCompat.GlideNormal(appicon, R.mipmap.ghosticon);
    devAd = new DevAd(listModel, this);
    rv_about_dev.setAdapter(devAd);
    rv_about_dev.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    sazndeh = new RequestNetwork(this);
    _sazndeh_request_listener =
        new RequestNetwork.RequestListener() {
          @Override
          public void onResponse(String _param1, String respanse, HashMap<String, Object> _param3) {
            getElementUser(respanse);
          }

          @Override
          public void onErrorResponse(String _param1, String _param2) {}
        };

    getOnBackPressedDispatcher()
        .addCallback(
            this,
            new OnBackPressedCallback(true) {

              @Override
              public void handleOnBackPressed() {
                // TODO: ...
                finish();
                Log.i("Add call", "OnBackPressed");
              }
            });
    runview();
  }

  private void runview() {
    sazndeh.startRequestNetwork(
        RequestNetworkController.GET, ApiURL, "b", _sazndeh_request_listener);
  }

  @Override
  public void onItemChange(View v, int pos) {
    switch (pos) {
      case 0:
        openUrl("https://github.com/appt2");
        break;
      case 1:
        openUrl("https://github.com/BlueWhaleYT");
        break;
      case 2, 4, 6:
        Toast.makeText(getApplicationContext(), "User not found Github page", Toast.LENGTH_SHORT)
            .show();
        break;
      case 3:
        openUrl("https://github.com/BanDroid");
        break;
      case 5:
        openUrl("https://github.com/PsiCodes");
        break;
      case 7:
        openUrl("https://github.com/timscriptov");
        break;
    }
  }

  void openUrl(String link) {
    var get = new Intent();
    get.setAction(Intent.ACTION_VIEW);
    get.setData(Uri.parse(link));
    startActivity(get);
  }

  void getElementUser(String input) {

    try {
      JSONObject object = new JSONObject(input);
      String imageUrl = object.getString("avatar_url");
      String userName = object.getString("login");
      Glide.with(getApplicationContext()).load(Uri.parse(imageUrl)).circleCrop().into(appicon);
      tv_about_name.setText(userName);
    } catch (JSONException err) {

    }
  }
}
