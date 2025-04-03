package ir.ninjacoder.ghostide.Store;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayoutMediator;
import ir.ninjacoder.ghostide.activities.BaseCompat;
import ir.ninjacoder.ghostide.databinding.LayoutStoreAcitvityBinding;

public class StoreAcitvity extends BaseCompat {
  private LayoutStoreAcitvityBinding bind;
  private StoreAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    bind = LayoutStoreAcitvityBinding.inflate(getLayoutInflater());
    super.onCreate(savedInstanceState);
    setContentView(bind.getRoot());
    adapter= new StoreAdapter(this);
    bind.viewpagerstore.setAdapter(adapter);
    new TabLayoutMediator(
            bind.tabmodel,
            bind.viewpagerstore,
            (tab, pos) -> {
              switch (pos) {
                  case 0 : tab.setText("Wallpapaer"); break;
                  case 1 : tab.setText("Themes"); break;
              }
            })
        .attach();
  }
}
