package ir.ninjacoder.ghostide.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

public interface OnClickFileSlideSheetCallBack {
  void onClickEvent(ArrayList<HashMap<String, Object>> map, int pos);

  void onLongClick(ArrayList<HashMap<String, Object>> map, int pos);
}
