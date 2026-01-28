package ir.ninjacoder.ghostide.core.marco.search;

import android.view.View;
import com.google.android.material.color.MaterialColors;
import com.ninjacoder.jgit.search.SearchBar;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class SearchBarImpl {
  private SearchBar search;
  private View main;
  private PowerMenu menu;

  public SearchBarImpl(SearchBar search, View main) {
    this.search = search;
    this.main = main;
  }

  public void bindSearch() {
    menu = new PowerMenu.Builder(search.getContext()).setIsMaterial(true).build();
    updateMenuItems();
    menu.setOnMenuItemClickListener(
        (pos, item) -> {
          if (pos == 0) {
            boolean currentlyShowing = search.isShow();
            if (currentlyShowing) {
              search.hide();
            } else {
              search.show();
            }
             menu.dismiss();
            updateMenuItems();
          }
        });
    menu.setShowBackground(false);
    menu.setAnimation(MenuAnimation.DROP_DOWN);
    menu.setMenuRadius(20);
    menu.setMenuColor(MaterialColors.getColor(search.getContext(),ObjectUtils.colorSurface,0));
    menu.setTextColor(MaterialColors.getColor(search.getContext(),ObjectUtils.colorPrimary,0));
    menu.showAsDropDown(main);
  }

  private void updateMenuItems() {
    menu.clearItems();
    boolean currentlyShowing = search.isShow();
    String menuText = currentlyShowing ? "hide Search" : "show search";
    menu.addItem(new PowerMenuItem(menuText));
    if (menu.isShowing()) {
      menu.dismiss();
      menu.showAsDropDown(main);
    }
  }
}
