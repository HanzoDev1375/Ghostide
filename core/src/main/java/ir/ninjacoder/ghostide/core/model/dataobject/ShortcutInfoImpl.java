package ir.ninjacoder.ghostide.core.model.dataobject;

import android.content.Context;
import android.content.Intent;

import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import ir.ninjacoder.ghostide.core.folder.FileIconHelper;
import ir.ninjacoder.ghostide.core.model.ShortcutInfo;
import ir.ninjacoder.ghostide.core.model.dataobject.FileShortcutInfo;

public class ShortcutInfoImpl {

  private Context context;
  private FileShortcutInfo info;
  private String fullpath;

  public ShortcutInfoImpl(Context context, String fullpath) {
    this.context = context;
    this.fullpath = fullpath;
  }

  public void createFileShortcut(int icon, String path, FileShortcutInfo.OnShortcutChange ch) {

    List<FileShortcutInfo> infos = new ArrayList<>();
    File file = new File(path);

    FileIconHelper fileicon = new FileIconHelper(path);
    info =
        new FileShortcutInfo(
            file.isDirectory() ? file.getName() : file.getParentFile().getName(),
            fileicon.getFileIcon(),
            path,
            ch);
    infos.add(info);
    infos.forEach(
        it -> {
          requestPinShortcut(it);
        });
  }

  private void requestPinShortcut(ShortcutInfo shortcutInfo) {
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
