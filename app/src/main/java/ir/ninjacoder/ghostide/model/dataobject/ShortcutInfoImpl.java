package ir.ninjacoder.ghostide.model.dataobject;

import android.content.Context;
import androidx.core.graphics.drawable.IconCompat;
import ir.ninjacoder.ghostide.model.ShortcutInfo;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import android.content.Intent;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.io.File;

public class ShortcutInfoImpl {

  private Context context;

  public ShortcutInfoImpl(Context context) {
    this.context = context;
  }

  public void createFileShortcut(int icon,String path) {

    List<FileShortcutInfo> info = new ArrayList<>();
	File file = new File(path);
    info.add(new FileShortcutInfo(file.getName(), R.drawable.ic_launcher_background, "/sd"));
    info.forEach(
        it -> {
          requestPinShortcut(it);
        });
  }

  private void requestPinShortcut(@NonNull ShortcutInfo shortcutInfo) {
    CharSequence name = Objects.requireNonNull(shortcutInfo.getName());
    String shortcutId = shortcutInfo.getId();
    if (shortcutId == null) {
      shortcutId = UUID.randomUUID().toString();
    }
    Intent shortcutIntent = shortcutInfo.toShortcutIntent(context);
    // Set action for shortcut
    shortcutIntent.setAction(Intent.ACTION_CREATE_SHORTCUT);

    ShortcutInfoCompat shortcutInfoCompat =
        new ShortcutInfoCompat.Builder(context, shortcutId)
            // Enforce shortcut name to be a String
            .setShortLabel(name.toString())
            .setLongLabel(name)
            .setIcon(IconCompat.createWithResource(context, shortcutInfo.getIcon()))
            .setIntent(shortcutIntent)
            .build();

    if (!ShortcutManagerCompat.requestPinShortcut(context, shortcutInfoCompat, null)) {
      new MaterialAlertDialogBuilder(context)
          .setTitle("Error")
          .setMessage("Error to mame")
          .setPositiveButton(android.R.string.ok, (dialog, which) -> dialog.cancel())
          .show();
    }
  }
}
