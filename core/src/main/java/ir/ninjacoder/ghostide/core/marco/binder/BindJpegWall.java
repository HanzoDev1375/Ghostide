package ir.ninjacoder.ghostide.core.marco.binder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import ir.ninjacoder.ghostide.core.activities.BaseCompat;
import ir.ninjacoder.ghostide.core.activities.SetHomeWallpActivity;
import ir.ninjacoder.ghostide.core.marco.binder.BinderRecyclerview1;
import ir.ninjacoder.ghostide.core.model.ListSheet;

public class BindJpegWall {
  private SharedPreferences getVb;
  private String key = "dir";

  public void bind(String staticString, BaseCompat context) {

    getVb = context.getSharedPreferences("getvb", Context.MODE_PRIVATE);
    if (BinderRecyclerview1.PhotoView(staticString)) {
      if (getVb != null) {
        var sheet = new ListSheet();
        sheet.setSheetDialog(context);
        sheet.addItem("Add to Wallpaper");
        sheet.addItem("Show");
        sheet.setOnItemClickLabe(
            (pos) -> {
              switch (pos) {
                case 0:
                  {
                    getVb.edit().putString(key, staticString).apply();
                    sheet.dissmiss();
                    break;
                  }
                case 1:
                  {
                    var i = new Intent();
                    i.setClass(context, SetHomeWallpActivity.class);
                    i.putExtra("path", staticString);
                    context.loadAnim(i);
                    sheet.dissmiss();
                    break;
                  }
              }
            });
      }
    }
  }
}
