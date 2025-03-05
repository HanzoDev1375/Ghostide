package ninjacoder.ghostide.androidtools.r8.android;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import com.android.tools.r8.D8;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import java.util.ArrayList;
import java.util.List;

public class R8Tools {
  public static final String ANDROIDJARPATH = "/storage/emulated/0/GhostWebIDE/android/android.jar";

  public void onlyCompile(
      String input, String output, int api, Context context, OnItemChange item) {
    var dialog = new PrograssSheet(context);
    dialog.setTitle("jar to dex using R8 tools");
    dialog.setCancelable(false);
    dialog.show();

    List<String> args = new ArrayList<>();
    new Thread(
            () -> {
              try {
                args.clear();
                args.add("--release");
                args.add("--lib");
                args.add(ANDROIDJARPATH);
                args.add("--output");
                args.add(output);
                args.add(input);
                D8.main(args.toArray(new String[0]));
              } catch (Exception err) {
                runOnUiThread(
                    () -> {
                      dialog.setTitle(err.getLocalizedMessage());
                    });
              }
              runOnUiThread(
                  () -> {
                    if (dialog != null) {
                      dialog.setTitle("Done");
                      dialog.dismiss();
                      item.onItemResult();
                    }
                  });
            })
        .start();
  }

  private void runOnUiThread(Runnable d) {
    var handler = new Handler(Looper.getMainLooper());
    handler.post(d);
  }

  public interface OnItemChange {
    public void onItemResult();
  }
}
