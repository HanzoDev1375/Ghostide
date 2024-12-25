package ir.ninjacoder.ghostide.git;

import ir.ninjacoder.ghostide.model.ListSheet;
import android.content.Context;
import android.widget.ListView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class GitTaskUtils implements ListSheet.OnItemClick {
  protected Context context;
  protected String folder;
  protected boolean enabled;
  protected ListSheet list;

  public GitTaskUtils(Context context, String folder) {
    this.context = context;
    this.folder = folder;
    setListSheet();
  }

  void setListSheet() {
    enabled = true;
     list = new ListSheet();
    list.addItem("init", 0, enabled);
    list.addItem("add", 0, enabled);
    list.addItem("commit ", 0, enabled);
    list.setSheetDialog(context);
    list.setOnItemClickLabe(this);
  }

  @Override
  public void OnItemClick(int pos) {
    switch (pos) {
      case 0 -> {
        enabled = true;
        list.getDismiss(enabled);
        break;
      }
      case 1 ->{
        enabled = true;
        list.getDismiss(enabled);
        break;
      }
      case 2 ->{
        enabled = false;
        list.getDismiss(enabled);
        break;
      }
    }
  }
}
