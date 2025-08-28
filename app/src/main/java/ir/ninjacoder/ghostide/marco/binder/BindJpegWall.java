package ir.ninjacoder.ghostide.marco.binder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import ir.ninjacoder.ghostide.activities.BaseCompat;
import ir.ninjacoder.ghostide.activities.SetHomeWallpActivity;
import ir.ninjacoder.ghostide.model.ListSheet;

public class BindJpegWall {
  private SharedPreferences getVb;
  private String key = "dir";

  public void bind(String staticString, BaseCompat context) {

    getVb = context.getSharedPreferences("getvb", Context.MODE_PRIVATE);
    if (staticString.endsWith(".jpeg")) {
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
                    i.putExtra("img", staticString);
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
