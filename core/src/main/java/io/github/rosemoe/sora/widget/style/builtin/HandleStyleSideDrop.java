package io.github.rosemoe.sora.widget.style.builtin;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

import androidx.annotation.NonNull;

import ir.ninjacoder.ghostide.core.R;

public class HandleStyleSideDrop extends HandleStyleDrop {

  private int size;
  private Drawable drawable;

  private int width;
  private int height;
  private SharedPreferences prf;
  private Context context; // /local context

  public HandleStyleSideDrop(Context context) {
    super(context);
    this.context = context;

    prf = context.getSharedPreferences("keys", Context.MODE_PRIVATE);

    size =
        (int)
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 30f, context.getResources().getDisplayMetrics());
    if (prf.contains("header")) {
      drawable = Drawable.createFromPath(prf.getString("header", "")).mutate();
    } else {
      drawable = context.getDrawable(R.drawable.ghostcur).mutate();
    }
  }

  @Override
  public void draw(
      @NonNull Canvas canvas,
      int handleType,
      float x,
      float y,
      int rowHeight,
      int color,
      @NonNull HandleDescriptor descriptor) {
    float radius = size / 2;
    if (handleType == HANDLE_TYPE_INSERT || handleType == HANDLE_TYPE_UNDEFINED) {
      super.draw(canvas, handleType, x, y, rowHeight, color, descriptor);
    } else {
      boolean isLeftType = handleType == HANDLE_TYPE_LEFT;
      float cx = isLeftType ? x - radius : x + radius;
      drawable.setBounds((int) (cx - radius), (int) (y), (int) (cx + radius), (int) (y + size));
      drawable.draw(canvas);

      descriptor.set(cx - radius, y, cx + radius, y + size, isLeftType ? ALIGN_LEFT : ALIGN_RIGHT);
    }
  }

}
