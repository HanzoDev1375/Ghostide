package ir.ninjacoder.ghostide.core.marco.wallpapers;

import androidx.annotation.MainThread;
import com.jsibbold.zoomage.ZoomageView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
import ir.ninjacoder.ghostide.core.Store.BaseFragment;
import ir.ninjacoder.ghostide.core.glidecompat.GlideCompat;
import com.bumptech.glide.Glide;
import ir.ninjacoder.ghostide.core.R;

public class WallpaperFragments extends BaseFragment {

  private static final String ARG_PATH = "path";
  private String imagePath;
  private ZoomageView imageView;

  public static WallpaperFragments newInstance(String path) {
    Bundle b = new Bundle();
    b.putString(ARG_PATH, path);
    WallpaperFragments f = new WallpaperFragments();
    f.setArguments(b);
    return f;
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_wallpaper, container, false);
  }

  @Override
  @MainThread
  public void onViewCreated(View v, Bundle arg1) {
    super.onViewCreated(v, arg1);
    imageView = v.findViewById(R.id.image);
    imagePath = getArguments().getString(ARG_PATH);
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
}
