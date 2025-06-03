package ir.ninjacoder.ghostide.model.dataobject;

import android.content.Context;
import android.content.Intent;
import ir.ninjacoder.ghostide.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.model.ShortcutInfo;

public class FileShortcutInfo extends ShortcutInfo {
  private String filePath;
  public String key = "path";
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
    intent.putExtra(key, filePath);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//	ch.change();
    return intent;
  }

   public String getKey(){
	   return key;
   }
}
