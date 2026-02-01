package ir.ninjacoder.ghostide.core.marco.wallpapers;

import android.util.SparseArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class WallpaperPagerAdapter extends FragmentStateAdapter {

  private final List<String> images;
  private final SparseArray<WallpaperFragments> fragmentMap = new SparseArray<>();
  private OnItemClickListener onItemClickListener;

  public WallpaperPagerAdapter(@NonNull FragmentActivity fa, List<String> list) {
    super(fa);
    images = list;
  }

  @NonNull
  @Override
  public Fragment createFragment(int position) {
    WallpaperFragments fragment = WallpaperFragments.newInstance(images.get(position), position);
    fragment.setClick(
        (view, pos) -> {
          if (onItemClickListener != null) {
            onItemClickListener.onItemClick(pos, view);
          }
        });
    fragmentMap.put(position, fragment);
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


  public void changeCurrentScale(int position) {
    WallpaperFragments f = fragmentMap.get(position);
    if (f != null) f.changeScaleType();
  }
  public void rotateCurrent(int position) {
    WallpaperFragments f = fragmentMap.get(position);
    if (f != null) f.rotateImage();
  }

  public void resetCurrent(int position) {
    WallpaperFragments f = fragmentMap.get(position);
    if (f != null) f.resetFromOutside();
  }
}
