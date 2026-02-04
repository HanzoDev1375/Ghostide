package ir.ninjacoder.ghostide.core.model;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import ir.ninjacoder.ghostide.core.fragments.ZipFileFragment;

public class ZipFileShow {

  public static void showAsDialog(AppCompatActivity context, String zippath, String folder) {
    Bundle bl = new Bundle();
    bl.putString("zipPath", zippath);
    bl.putString("folder", folder);
    var zipsheet = new ZipFileFragment();
    zipsheet.setArguments(bl);
    if (zipsheet != null) {
      zipsheet.show(context.getSupportFragmentManager(), "");
    }
  }
}
