package ir.ninjacoder.ghostide.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class ImageViewAnimation extends ImageView {
  public ImageViewAnimation(Context c) {
    super(c);
  }

  public ImageViewAnimation(Context c, AttributeSet set) {
    super(c, set);
  }

  public ImageViewAnimation(Context c, AttributeSet set, int def) {
    super(c, set, def);
  }
  
  public void setOnClickByAnim(OnClickCallBack v) {
    setOnClickListener(
        c -> {
          setEnabled(false);
          animate()
              .rotation(90)
              .setDuration(500)
              .withEndAction(
                  () -> {
                    animate()
                        .rotation(0)
                        .setDuration(500)
                        .withEndAction(
                            () -> {
                              v.click(this);
                            })
                        .start();
                    setEnabled(true);
                  })
              .start();
        });
  }

  public interface OnClickCallBack {
    void click(View v);
  }
}
