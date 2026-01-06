package com.mcal.uidesigner.utils;

import android.content.Context;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;

public class MaterialColorStatic {
  public static int getBackgroundColor(Context c) {
    return MaterialColors.getColor(c,R.attr.colorSurface,0);
  }
}
