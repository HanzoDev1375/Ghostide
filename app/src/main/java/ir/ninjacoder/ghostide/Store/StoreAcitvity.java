package ir.ninjacoder.ghostide.Store;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.color.MaterialColors;
import ir.ninjacoder.ghostide.activities.BaseCompat;
import ir.ninjacoder.ghostide.databinding.LayoutStoreAcitvityBinding;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import java.util.ArrayList;
import java.util.List;
import ir.ninjacoder.ghostide.R;

public class StoreAcitvity extends BaseCompat {
  private LayoutStoreAcitvityBinding bind;
  private StoreAdapter adapter;
  private List<Fragment> mylist = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    bind = LayoutStoreAcitvityBinding.inflate(getLayoutInflater());
    super.onCreate(savedInstanceState);
    setContentView(bind.getRoot());
    bind.bottomNavigation.setBackgroundTintList(
        ColorStateList.valueOf(
            MaterialColors.getColor(bind.bottomNavigation, ObjectUtils.Back, 0)));
    mylist.add(new WallpaperFragment());
    mylist.add(new FontFragment());
    mylist.add(new ThemeFragment());
    mylist.add(new SvgStoreFragment());
    mylist.add(new WebShopFragment());
    adapter = new StoreAdapter(this);
    adapter.setList(mylist);
    bind.viewpagerstore.setAdapter(adapter);
    bind.viewpagerstore.setUserInputEnabled(false);
    bind.toolbarstore
        .getEditText()
        .addTextChangedListener(
            new TextWatcher() {

              @Override
              public void afterTextChanged(Editable arg0) {}

              @Override
              public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

              @Override
              public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
                if (!s.isEmpty()) {
                  bindSearch(s.toString());
                } else clear();
              }
            });
    bind.bottomNavigation.setOnNavigationItemSelectedListener(
        item -> {
          var get = item.getItemId();
          if (get == R.id.nav_wallpaper) {
            bind.viewpagerstore.setCurrentItem(0, false);
            clear();
            return true;
          } else if (get == R.id.nav_fonts) {
            bind.viewpagerstore.setCurrentItem(1, false);
            clear();
            return true;
          } else if (get == R.id.nav_themes) {
            bind.viewpagerstore.setCurrentItem(2, false);
            clear();
            return true;
          } else if (get == R.id.nav_svg) {
            bind.viewpagerstore.setCurrentItem(3, false);
            clear();
            return true;
          } else if (get == R.id.nav_htmlstore) {
            bind.viewpagerstore.setCurrentItem(4, false);
            clear();
            return true;
          }

          return false;
        });

    bind.viewpagerstore.registerOnPageChangeCallback(
        new ViewPager2.OnPageChangeCallback() {
          @Override
          public void onPageSelected(int position) {
            super.onPageSelected(position);
            switch (position) {
              case 0:
                bind.bottomNavigation.setSelectedItemId(R.id.nav_wallpaper);
                clear();
                break;
              case 1:
                bind.bottomNavigation.setSelectedItemId(R.id.nav_fonts);
                clear();
                break;
              case 2:
                bind.bottomNavigation.setSelectedItemId(R.id.nav_themes);
                clear();
                break;
              case 3:
                bind.bottomNavigation.setSelectedItemId(R.id.nav_svg);
                clear();
                break;
              case 4:
                bind.bottomNavigation.setSelectedItemId(R.id.nav_htmlstore);
                clear();
                break;
            }
          }
        });
  }

  private void bindSearch(String newText) {
    var item = bind.viewpagerstore.getCurrentItem();
    var it = adapter.getList().get(item);

    if (it instanceof FontFragment) {
      ((FontFragment) it).filter(newText);
    } else if (it instanceof ThemeFragment) {
      ((ThemeFragment) it).filter(newText);
    } else if (it instanceof WallpaperFragment) {
      ((WallpaperFragment) it).filter(newText);
    } else if (it instanceof SvgStoreFragment) {
      ((SvgStoreFragment) it).filter(newText);
    }
  }

  private void clear() {
    bindSearch("");
  }
}
