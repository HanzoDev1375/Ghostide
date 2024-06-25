package com.mcal.uidesigner.common;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class ColorMaterial {

  public static void init(ImageView view, TextView v) {
    var text = v.getText().toString();
    filter(view);
  }

  static void filter(ImageView v) {
    v.setColorFilter(colorRandom(), PorterDuff.Mode.SRC_IN);
  }

  static int colorRandom() {

    int[] myColor = {
      Color.parseColor("#fff349"),
      Color.parseColor("#ff8017"),
      Color.parseColor("#ff3916"),
      Color.parseColor("#ff9273"),
      Color.parseColor("#ff1372"),
      Color.parseColor("#ff6dc1")
    };
    Random random = new Random();
    int color = myColor[random.nextInt(myColor.length)];
    return color;
  }

  public static void unserLineTextView(TextView view,String code) {
    view.setPaintFlags(view.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    view.setText(code);
  }
}
