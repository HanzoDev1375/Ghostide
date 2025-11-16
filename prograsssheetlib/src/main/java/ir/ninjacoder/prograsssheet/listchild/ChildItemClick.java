package ir.ninjacoder.prograsssheet.listchild;

import android.view.View;

public interface ChildItemClick {
  void click(View v /*View from click*/, int pos, int id, boolean isusing);
}
