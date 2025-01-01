package com.ninjacoder.jgit.offlinetutorials.basiclogic;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import com.ninjacoder.jgit.databinding.LayoutItViewBinding;
import com.ninjacoder.jgit.offlinetutorials.adapters.LearnAdapter;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OfflineTrainingFactory {

  private Context context;
  private OnItemChangeCallBack itemCall;
  private LayoutItViewBinding viewBind;
  protected List<Map<String, String>> map = new ArrayList<>();
  protected String jsonName = "";

  public OfflineTrainingFactory(Context context, String jsonName) {
    this.jsonName = jsonName;
    this.context = context;
    try {
      viewBind = LayoutItViewBinding.inflate(LayoutInflater.from(context));
      viewBind.holderlist.setLayoutManager(new LinearLayoutManager(context));
      var stream = context.getAssets().open(jsonName);

      map =
          new Gson()
              .fromJson(
                  copyFromInputStream(stream),
                  new TypeToken<List<Map<String, String>>>() {}.getType());
      viewBind.holderlist.setAdapter(new LearnAdapter(itemCall, map));
    } catch (Exception err) {
       Log.e("Error to Parser Json : " , err.getLocalizedMessage());
    }
  }

  public void setCallBack(OnItemChangeCallBack itemCall) {
    this.itemCall = itemCall;
  }

  String copyFromInputStream(InputStream inputStream) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    byte[] buf = new byte[1024];
    int i;
    try {
      while ((i = inputStream.read(buf)) != -1) {
        outputStream.write(buf, 0, i);
      }
      outputStream.close();
      inputStream.close();
    } catch (IOException e) {
    }

    return outputStream.toString();
  }
}
