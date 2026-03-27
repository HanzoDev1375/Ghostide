package ir.ninjacoder.prograsssheet.filemanagerwindows;

import android.view.View;
import android.widget.ImageView;

public interface FileHandlerModel {
  void onFileClickHanlder(int pos, FileModel model, View v);
  void onFileIconBind(FileModel model,ImageView ic);
}
