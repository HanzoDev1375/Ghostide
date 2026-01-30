// WallpaperPagerAdapter.java
package ir.ninjacoder.ghostide.core.marco.wallpapers;

import android.view.View;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.Fragment;

public class WallpaperPagerAdapter extends FragmentStateAdapter {

  private final List<String> images;
  private OnItemClickListener onItemClickListener;

  public WallpaperPagerAdapter(FragmentActivity fa, List<String> list) {
    super(fa);
    images = list;
  }

  @Override
  public Fragment createFragment(int position) {
    WallpaperFragments fragment = WallpaperFragments.newInstance(images.get(position), position);
    fragment.setClick(
        (view, pos) -> {
          if (onItemClickListener != null) {
            onItemClickListener.onItemClick(pos, view);
          }
        });

    return fragment;
  }

  @Override
  public int getItemCount() {
    return images.size();
  }

  public interface OnItemClickListener {
    void onItemClick(int position, View view);
  }

  public void setOnItemClickListener(OnItemClickListener listener) {
    this.onItemClickListener = listener;
  }
}
