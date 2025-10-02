package ir.ninjacoder.prograsssheet.perfence;

import android.view.View;
import java.util.List;

public class ShapeList {
  public static void getShapeListStatus(List<?> list, int pos, View view) {
    if (list.size() == 1) {
      view.setBackground(Shape.normal(view));
    } else if (pos == 0) {
      view.setBackground(Shape.middel(view));
    } else if (pos == list.size() - 1) {
      view.setBackground(Shape.bottom(view));
    } else view.setBackground(Shape.middel(view));
  }
}
