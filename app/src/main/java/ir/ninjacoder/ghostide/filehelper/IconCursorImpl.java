package ir.ninjacoder.ghostide.filehelper;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import ir.ninjacoder.ghostide.adapter.CursorIconAd;

public class IconCursorImpl {

  private Context context;

  public IconCursorImpl(Context context) {
    this.context = context;
    RecyclerView rv = new RecyclerView(context);
    rv.setPadding(8, 8, 8, 8);

    AlertDialog dialog =
        new MaterialAlertDialogBuilder(context)
            .setTitle("set icon")
            .setView(rv)
            .setPositiveButton(android.R.string.cancel, null)
            .create();
    dialog.show();
    rv.setLayoutManager(new LinearLayoutManager(context));
    rv.setAdapter(
        new CursorIconAd(
            context,
            visit -> {
              dialog.dismiss();
            }));
  }
}
