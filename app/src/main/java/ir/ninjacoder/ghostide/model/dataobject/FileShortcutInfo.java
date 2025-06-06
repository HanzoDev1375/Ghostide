package ir.ninjacoder.ghostide.model.dataobject;

import android.content.Context;
import android.content.Intent;
import ir.ninjacoder.ghostide.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.model.ShortcutInfo;

public class FileShortcutInfo extends ShortcutInfo {
  private String filePath;
  private OnShortcutChange ch;

  public interface OnShortcutChange {
    void change();
  }

  public FileShortcutInfo(String name, int icon, String filePath, OnShortcutChange ch) {
    setName(name);
    setIcon(icon);
    this.ch = ch;
    this.filePath = filePath;
  }

  @Override
  public Intent toShortcutIntent(Context context) {
    Intent intent = new Intent(context, FileManagerActivity.class);
    intent.putExtra("filePath", filePath);
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

    return intent;
  }
}
