package ir.ninjacoder.prograsssheet.view;

import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;

public class RenameDialogFragmentImpl {
  public interface OnRenameChange {
    void onRename(String newName);
  }

  public static void impl(String file, AppCompatActivity app, OnRenameChange ch) {
    RenameDialogFragment dialog =
        RenameDialogFragment.getInstance(
            file,
            (prefix, extension) -> {
              String displayName;
              if (!TextUtils.isEmpty(extension)) {
                displayName = prefix + "." + extension;
              } else {
                displayName = prefix;
              }
              ch.onRename(displayName);
            });
    dialog.show(app.getSupportFragmentManager(), RenameDialogFragment.TAG);
  }
}
