package ir.ninjacoder.ghostide.core.marco;

import android.content.ClipData;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.io.File;

public class FileShareManager {

  private Context context;

  public FileShareManager(Context context) {
    this.context = context;
  }

  public void shareFile(File file) {
    if (file.isDirectory()) {
      showErrorDialog("Selected file is directory!");
      return;
    }
    String mimeType = getMimeType(file);
    if (mimeType == null) {
      showErrorDialog("Unsupported file type!");
      return;
    }

    Intent intent = new Intent(Intent.ACTION_SEND);
    Uri uri = FileProvider.getUriForFile(context, "ir.ninjacoder.ghostide.core.provider", file);
    intent.setType(mimeType);
    intent.putExtra(Intent.EXTRA_STREAM, uri);

    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      intent.setClipData(ClipData.newRawUri("", uri));
      intent.addFlags(
          Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
    }

    Intent chooserIntent = Intent.createChooser(intent, "Share file using");
    chooserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      chooserIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    }

    try {
      context.startActivity(chooserIntent);
    } catch (ActivityNotFoundException e) {
      showErrorDialog("No app available to share this file!");
    }
  }

  private String getMimeType(File file) {
    String ext = getFileExtension(file.getAbsolutePath());
    String mimeType = null;
    if (ext != null) {
      switch (ext.toLowerCase()) {
        case "pdf":
          mimeType = "application/pdf";
          break;
        case "jpg":
        case "jpeg":
        case "png":
          mimeType = "image/*";
          break;
        case "txt":
          mimeType = "text/plain";
          break;
        case "ghost":
          mimeType = "application/ghost";
          break;
        default:
          mimeType = "*/*";
          break;
      }
    }
    return mimeType;
  }

  private String getFileExtension(String filePath) {
    int dotIndex = filePath.lastIndexOf(".");
    if (dotIndex != -1) {
      return filePath.substring(dotIndex + 1);
    } else {
      return null;
    }
  }

  private void showErrorDialog(String message) {
    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(context);
    dialog.setTitle("Error");
    dialog.setMessage(message);
    dialog.setPositiveButton("Ok", null);
    dialog.show();
  }
}
