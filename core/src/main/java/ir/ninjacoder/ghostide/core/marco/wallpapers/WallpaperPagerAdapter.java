package ir.ninjacoder.ghostide.core.marco.wallpapers;

import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.Fragment;

public class WallpaperPagerAdapter extends FragmentStateAdapter {

  private final List<String> images;

  public WallpaperPagerAdapter( FragmentActivity fa, List<String> list) {
    super(fa);
    images = list;
  }
  @Override
  public Fragment createFragment(int position) {
    return WallpaperFragments.newInstance(images.get(position));
  }

  @Override
  public int getItemCount() {
    return images.size();
  }
}
