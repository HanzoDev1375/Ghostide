package io.github.rosemoe.sora.widget.style.builtin;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import ir.ninjacoder.ghostide.R;
import io.github.rosemoe.sora.widget.style.SelectionHandleStyle;

public class HandleStyleDrop implements SelectionHandleStyle {

  private Drawable drawable;
  private int width;
  private int height;
  private int lastColor = 0;
  private SharedPreferences prf;
  private Context context; // local context

  public HandleStyleDrop(Context context) {
    this.context = context;
    // drawable = context.getDrawable(R.drawable.ic_sora_handle_drop).mutate();
    prf = context.getSharedPreferences("keys", Context.MODE_PRIVATE);
    if (prf.contains("name")) {

      // drawable = Drawable.createFromPath(prf.getString("name", "")).mutate();
      loadimgFromGlide(prf.getString("name", ""));
    } else {
      drawable = context.getDrawable(R.drawable.ghostcur).mutate();
    }

    width =
        (int)
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 30f, context.getResources().getDisplayMetrics());
    height =
        (int)
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 30f, context.getResources().getDisplayMetrics());
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
    if (lastColor != color) {
      lastColor = color;
      //  drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
    }
    var cx = (int) x;
    var ty = (int) y;
    drawable.setBounds(cx - width / 2, ty, cx + width / 2, ty + height);
    drawable.draw(canvas);
    descriptor.set(cx - width / 2, ty, cx + width / 2, ty + height, ALIGN_CENTER);
  }

  void loadimgFromGlide(String path) {
    Glide.with(context)
        .load(path)
        .error(R.drawable.ghostcur)
        .into(
            new CustomTarget<Drawable>() {

              @Override
              public void onResourceReady(Drawable arg0, Transition<? super Drawable> arg1) {
                drawable = arg0.mutate();
              }

              @Override
              public void onLoadCleared(Drawable arg0) {}
            });
  }
}
