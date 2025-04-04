package ir.ninjacoder.ghostide.Store;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayoutMediator;
import ir.ninjacoder.ghostide.activities.BaseCompat;
import ir.ninjacoder.ghostide.databinding.LayoutStoreAcitvityBinding;
import java.util.ArrayList;
import java.util.List;

public class StoreAcitvity extends BaseCompat {
  private LayoutStoreAcitvityBinding bind;
  private StoreAdapter adapter;
  private List<Fragment> mylist = new ArrayList<>();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    bind = LayoutStoreAcitvityBinding.inflate(getLayoutInflater());
    super.onCreate(savedInstanceState);
    setContentView(bind.getRoot());
    adapter= new StoreAdapter(this);
    mylist.add(new WallpaperFragment());
    mylist.add(new FontFragment());
    mylist.add(new ThemeFragment());
    adapter.setList(mylist);
    bind.viewpagerstore.setAdapter(adapter);
    new TabLayoutMediator(
            bind.tabmodel,
            bind.viewpagerstore,
            (tab, pos) -> {
              switch (pos) {
                  case 0 : tab.setText("Wallpapaer"); break;
                  case 1 : tab.setText("Fonts"); break;
                  case 2 : tab.setText("Themes"); break;
              }
            })
        .attach();
  }
}
