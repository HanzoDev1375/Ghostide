package ir.ninjacoder.ghostide.core.marco.wallpapers;

import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bumptech.glide.Glide;
import com.jsibbold.zoomage.ZoomageView;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.Store.BaseFragment;
import ir.ninjacoder.ghostide.core.glidecompat.GlideCompat;
import ir.ninjacoder.ghostide.core.interfaces.OnItemClickListener;

public class WallpaperFragments extends BaseFragment {

  private static final String ARG_PATH = "path";
  private static final String ARG_POSITION = "POSITION";

  private String imagePath;
  private int position;

  private ZoomageView imageView;
  private FrameLayout container;
  private OnItemClickListener click;

  public static WallpaperFragments newInstance(String path, int pos) {
    Bundle b = new Bundle();
    b.putString(ARG_PATH, path);
    b.putInt(ARG_POSITION, pos);
    WallpaperFragments f = new WallpaperFragments();
    f.setArguments(b);
    return f;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle state) {
    return inflater.inflate(R.layout.fragment_wallpaper, parent, false);
  }

  @Override
  @MainThread
  public void onViewCreated(View v, Bundle state) {
    super.onViewCreated(v, state);

    container = v.findViewById(R.id.container);
    imageView = v.findViewById(R.id.image);

    imagePath = getArguments().getString(ARG_PATH);
    position = getArguments().getInt(ARG_POSITION, -1);

    setupImage();
    setupClickWithoutBreakingZoom();
  }

  private void setupImage() {
    if (imagePath == null) return;

    if (imagePath.endsWith(".gif")) {
      Glide.with(imageView.getContext())
          .asGif()
          .load(imagePath)
          .placeholder(GlideCompat.CircelPrograssBar())
          .error(R.drawable.ic_image)
          .into(imageView);
    } else {
      Glide.with(imageView.getContext())
          .load(imagePath)
          .placeholder(GlideCompat.CircelPrograssBar())
          .error(R.drawable.ic_image)
          .into(imageView);
    }
  }

  /** این متد کلیک را تشخیص می‌دهد بدون اینکه ZoomageView از کار بیفتد */
  private void setupClickWithoutBreakingZoom() {

    imageView.setClickable(false); // خیلی مهم

    imageView.setOnTouchListener(
        new View.OnTouchListener() {

          private long downTime = 0;
          private float downX = 0, downY = 0;
          private static final int CLICK_TIME = 200; // حداکثر زمان برای کلیک
          private static final int CLICK_DISTANCE = 25; // حداکثر حرکت برای کلیک

          @Override
          public boolean onTouch(View v, MotionEvent event) {

            switch (event.getActionMasked()) {
              case MotionEvent.ACTION_DOWN:
                downTime = System.currentTimeMillis();
                downX = event.getX();
                downY = event.getY();
                break;

              case MotionEvent.ACTION_UP:
                long upTime = System.currentTimeMillis();
                float dx = Math.abs(event.getX() - downX);
                float dy = Math.abs(event.getY() - downY);

                boolean isClick =
                    (upTime - downTime) < CLICK_TIME && dx < CLICK_DISTANCE && dy < CLICK_DISTANCE;

                if (isClick && click != null) {
                  click.onClick(imageView, position);
                }
                break;
            }

            // FALSE = بگذار ZoomageView خودش زوم و درگ را هندل کند
            return false;
          }
        });
  }

  public void setClick(OnItemClickListener click) {
    this.click = click;
  }
}
