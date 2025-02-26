package ir.ninjacoder.ghostide.terminal;

import com.google.android.material.color.MaterialColors;
import com.google.android.material.tabs.TabLayout;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import ir.ninjacoder.ghostide.model.Season;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import java.util.ArrayList;
import java.util.List;

public class TerminalTabSeasonImpl implements TabLayout.OnTabSelectedListener {

  private TabLayout tab;

  public TerminalTabSeasonImpl(TabLayout tab) {
    this.tab = tab;
    init();
  }

  void init() {
    List<Season> list = new ArrayList<>();
    list.add(new Season("season1", 0));
    list.add(new Season("season2", 1));
    list.add(new Season("season3", 2));
    list.add(new Season("season4", 3));
    list.add(new Season("season5", 4));
    list.forEach(
        it -> {
          tab.addTab(tab.newTab().setText(it.getName()));
        });
    tab.addOnTabSelectedListener(this);
  }

  @Override
  public void onTabSelected(TabLayout.Tab tabs) {}

  @Override
  public void onTabUnselected(TabLayout.Tab tabs) {}

  @Override
  public void onTabReselected(TabLayout.Tab tabs) {

    int position = tabs.getPosition();
    PowerMenu menu =
        new PowerMenu.Builder(tab.getContext())
            .addItem(new PowerMenuItem("addTab"))
            .addItem(new PowerMenuItem("CloseThis Tab"))
            .addItem(new PowerMenuItem("Close All"))
            .setIsMaterial(true)
            .build();
    menu.setOnMenuItemClickListener(
        (pos, c) -> {
          switch (pos) {
            case 0:
              break;
            case 1:
              if (position == 0) {
                return;
              }
              tab.removeTabAt(position);
              break;
            case 2:
              tab.removeAllTabs();
              break;
          }
        });

    menu.setAutoDismiss(true);
    menu.setAnimation(MenuAnimation.FADE);
    menu.setMenuColor(MaterialColors.getColor(tab.getContext(),ObjectUtils.Back,0));
    menu.setTextColor(MaterialColors.getColor(tab.getContext(),ObjectUtils.TvColor,0));
    menu.setMenuRadius(10f);
    menu.setShowBackground(false);
    menu.showAsDropDown(tabs.view);
  }
}
