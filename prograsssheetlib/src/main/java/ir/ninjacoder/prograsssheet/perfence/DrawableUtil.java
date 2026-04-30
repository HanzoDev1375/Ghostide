package ir.ninjacoder.prograsssheet.perfence;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.color.MaterialColors;
import java.util.List;

public class DrawableUtil {

  /*
   * int normalcolor = R.attr.colorOnSecondary;
   * int normalColorBackground = R.attr.colorSecondary;
   * int lastPosColorBackground = R.attr.colorPrimary;
   * int lastPosColorR.attr.colorOnPrimary;
   */
  private Drawable createRippleDrawable(GradientDrawable f) {
    return new RippleDrawable(ColorStateList.valueOf(Color.WHITE), f, null);
  }

  private Drawable makeShape(int co) {
    var gb = new GradientDrawable();
    gb.setShape(GradientDrawable.RECTANGLE);
    gb.setColor(ColorUtils.setAlphaComponent(co, 120));
    gb.setCornerRadius(15);
    return createRippleDrawable(gb);
  }

  public void setColorByPosition(
      List<?> list,
      int position,
      View v,
      TextView tv,
      int lastPosColor,
      int lastPosBackground,
      int normalColor,
      int normalColorBackground) {
    if (position == list.size() - 1) {
      v.setBackground(makeShape(get(v, lastPosColor)));
      tv.setTextColor(get(tv, lastPosBackground));
    } else {
      v.setBackground(makeShape(get(v, normalColorBackground)));
      tv.setTextColor(get(tv, normalColor));
    }
  }

  int get(View v, int id) {
    return MaterialColors.getColor(v, id);
  }
}