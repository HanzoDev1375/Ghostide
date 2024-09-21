package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.RequestNetwork;
import Ninja.coder.Ghostemane.code.RequestNetworkController;
import Ninja.coder.Ghostemane.code.adapter.DevAd;
import Ninja.coder.Ghostemane.code.glidecompat.GlideCompat;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AboutActivity extends BaseCompat {
  protected TextView tv_about_name;
  protected RecyclerView rv_about_dev;
  protected DevAd devAd;
  protected List<HashMap<String,Object>> listModel = new ArrayList<>();
  private RequestNetwork sazndeh, DevSazandeh;
  private RequestNetwork.RequestListener devCallBack, DevUser;
  private ImageView appicon;
  public static String ApiURL = "https://api.github.com/users/HanzoDev1375";
  public static String DevList = "https://api.github.com/repos/HanzoDev1375/Ghostide/contributors";

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
    GlideCompat.GlideNormal(appicon, R.mipmap.ghosticon);

    sazndeh = new RequestNetwork(this);
    DevSazandeh = new RequestNetwork(this);
    DevUser =
        new RequestNetwork.RequestListener() {
          @Override
          public void onResponse(String _param1, String respanse, HashMap<String, Object> _param3) {
            listModel = new Gson().fromJson(respanse,new TypeToken<List<HashMap<String,Object>>>(){}.getType());
            devAd = new DevAd(listModel, (v, c) -> {});

            rv_about_dev.setAdapter(devAd);
            rv_about_dev.setLayoutManager(
                new GridLayoutManager(AboutActivity.this,2));
          }

          @Override
          public void onErrorResponse(String _param1, String _param2) {}
        };

    devCallBack =
        new RequestNetwork.RequestListener() {
          @Override
          public void onResponse(String _param1, String respanse, HashMap<String, Object> _param3) {
            getElementUser(respanse);
            // listModel.add(new DevModel(getIconDev(respanse)));
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
    sazndeh.startRequestNetwork(RequestNetworkController.GET, ApiURL, "b", devCallBack);
    DevSazandeh.startRequestNetwork(RequestNetworkController.GET, DevList, "B", DevUser);
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

  public String getIconDev(String input) {
    try {
      JSONArray aar = new JSONArray(input);
      if (aar.length() > 0) {
        JSONObject object = aar.getJSONObject(0);
        return object.getString("avatar_url");
      }
    } catch (JSONException err) {

    }
    return null;
  }
}
