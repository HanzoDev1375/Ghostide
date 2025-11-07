package ir.ninjacoder.prograsssheet.perfence;

import android.view.View;
import java.util.List;
import ir.ninjacoder.prograsssheet.R;

public class ShapeList {
  public static void getShapeListStatus(List<?> list, int pos, View view) {
    if (list.isEmpty()) {
      view.setBackground(Shape.normal(view));
    } else if (list.size() == 1) {
      view.setBackground(Shape.top(view));
    } else if (pos == 0) {
      view.setBackground(Shape.top(view));
    } else if (pos == list.size() - 1) {
      view.setBackground(Shape.bottom(view));
    } else {
      view.setBackground(Shape.middel(view));
    }
  }

  public static <T> int get(List<T> list, int position) {
    if (list.size() == 1) {
      return R.drawable.shape_normal;
    } else if (position == 0) {
      return R.drawable.shape_top;
    } else if (position == list.size() - 1) {
      return R.drawable.shape_bottom;
    } else {

      return R.drawable.shape_middle;
    }
  }
}
