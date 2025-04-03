package ir.ninjacoder.ghostide.Store;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class StoreAdapter extends FragmentStateAdapter {

  public StoreAdapter(FragmentActivity ac) {
    super(ac);
  }

  @Override
  public Fragment createFragment(int pos) {

    return new WallpaperFragment();
  }

  @Override
  public int getItemCount() {
    return 2;
  }
}
