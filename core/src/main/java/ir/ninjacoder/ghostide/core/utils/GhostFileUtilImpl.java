package ir.ninjacoder.ghostide.core.utils;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.core.enums.FileConentChange;
import ir.ninjacoder.ghostide.core.marco.binder.bindchilder.GhostToast;
import ir.ninjacoder.ghostide.core.widget.ExrtaFab;
import java.io.File;
import androidx.annotation.MainThread;

public class GhostFileUtilImpl {
  public static void impl(
      FileConentChange content,
      String destinationDirectory,
      String sourceFilePath,
      FileManagerActivity context) {
    try {
      File sourceFile = new File(sourceFilePath);
      File destFile = new File(destinationDirectory, sourceFile.getName());
      FileUtil.moveFileOrDirByGhostide(
          sourceFile.toString(),
          destFile.toString(),
          new FileUtil.OnFileChangeCall() {

            @MainThread
            @Override
            public void onFileDone() {
              context.reLoadFile();
            }

            @MainThread
            @Override
            public void onFileError(String error) {
              GhostToast.showError(context, error);
            }
          },
          content == FileConentChange.COPYING,
          context);
    } catch (Exception err) {
      GhostToast.showError(context, err.getLocalizedMessage());
    }
  }

  public static void changeIconFab(ExrtaFab fab, FileConentChange cont) {
    switch (cont) {
      case COPYING:
        fab.setIconResource(FileConentChange.COPYING.getValue());
        break;
      case MOVEING:
        fab.setIconResource(FileConentChange.MOVEING.getValue());
        break;
      case NONE:
        fab.setIconResource(FileConentChange.NONE.getValue());
        break;
    }
  }
}
