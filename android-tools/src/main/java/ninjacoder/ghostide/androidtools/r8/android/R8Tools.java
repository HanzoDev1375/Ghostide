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
import java.util.ArrayList;
public class R8Tools {

  public void onlyCompile(String input, String output, int api, Context context,OnItemChange item) {
    var dialog = new ProgressDialog(context, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
    dialog.setTitle(" jar to dex");
    dialog.setMessage("It may take a few minutes depending on your DEX");
    dialog.setCancelable(false);
    MaterialShapeDrawable shap = new MaterialShapeDrawable(ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED,20f).build());
    shap.setFillColor(ColorStateList.valueOf(MaterialColors.getColor(context,com.google.android.material.R.attr.colorSurface,0)));
    shap.setStroke(0.5f,MaterialColors.getColor(context,com.google.android.material.R.attr.colorPrimary,0));
    dialog.getWindow().setBackgroundDrawable(shap);
    dialog.show();
    
    ArrayList<String> args = new ArrayList<>();
    new Thread(
            () -> {
              try {
                args.clear();
                args.add("--release");
                args.add("--lib");
                args.add("/storage/emulated/0/GhostWebIDE/android/android.jar");
                args.add("--output");
                args.add(output);
                args.add(input);
                D8.main(args.toArray(new String[0]));

              } catch (Exception err) {
                runOnUiThread(
                    () -> {
                      dialog.setMessage(err.getLocalizedMessage());
                    });
              }
              runOnUiThread(
                  () -> {
                    if (dialog != null) {
                      dialog.setMessage("Done");
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
  public interface OnItemChange{
    public void onItemResult();
  }
}
