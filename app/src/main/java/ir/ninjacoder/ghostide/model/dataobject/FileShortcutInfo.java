package ir.ninjacoder.ghostide.model.dataobject;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.example.formatter.MainActivity;
import ir.ninjacoder.ghostide.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.model.ShortcutInfo;
import java.io.File;
import android.net.Uri;
import androidx.core.content.FileProvider;
import android.webkit.MimeTypeMap;

public class FileShortcutInfo extends ShortcutInfo {
  private String filePath;
  public static final String key = "path";	

  public FileShortcutInfo(String name, int icon, String filePath) {
    setName(name);
    setIcon(icon);
    this.filePath = filePath;
  }

  @Override
  public Intent toShortcutIntent(@NonNull Context context) {
    Intent intent = new Intent(context,FileManagerActivity.class );
    intent.putExtra(key, filePath); 
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    return intent;
  }
}
