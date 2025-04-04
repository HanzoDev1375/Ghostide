package ir.ninjacoder.ghostide.Store;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;

public class StoreAdapter extends FragmentStateAdapter {

  private List<Fragment> list;

  public StoreAdapter(FragmentActivity ac) {
    super(ac);
  }

  @Override
  public Fragment createFragment(int pos) {
    return list.get(pos);
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  public List<Fragment> getList() {
    return this.list;
  }

  public void setList(List<Fragment> list) {
    this.list = list;
  }
}
