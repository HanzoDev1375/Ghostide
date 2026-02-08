package ir.ninjacoder.prograsssheet.util;

import android.widget.ImageView;
import ir.ninjacoder.prograsssheet.R;
import com.bumptech.glide.Glide;

public class GithubProfileBitMap {

  public void bindIcon(ImageView ic, Object path) {
    Glide.with(ic.getContext())
        .asBitmap()
        .load(path)
        .transform(RoundStrokeTransform.instaStyle(99,4))
        .placeholder(R.drawable.music1)
        .error(R.drawable.music1)
        .into(ic);
  }
}
