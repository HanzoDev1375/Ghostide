package ir.ninjacoder.ghostide.core.terminal;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.color.MaterialColors;
import com.google.android.material.tabs.TabLayout;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import java.util.ArrayList;
import java.util.List;

import ir.ninjacoder.ghostide.core.model.Season;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class TerminalTabSeasonImpl implements TabLayout.OnTabSelectedListener {

  private TabLayout tab;
  private FragmentManager fragmentManager;
  private int containerId;
  public List<TerminalFragment> fragments = new ArrayList<>();

  public TerminalTabSeasonImpl(TabLayout tab, FragmentManager fragmentManager, int containerId) {
    this.tab = tab;
    this.fragmentManager = fragmentManager;
    this.containerId = containerId;
    init();
  }

  void init() {
    List<Season> list = new ArrayList<>();
    list.add(new Season("Tab 1", 0));

    list.forEach(
        it -> {
          tab.addTab(tab.newTab().setText(it.getName()));

          // ایجاد یک فرگمنت جدید برای هر تب
          TerminalFragment fragment = new TerminalFragment();
          fragments.add(fragment);
        });

    tab.addOnTabSelectedListener(this);

    // نمایش اولین تب به صورت پیش‌فرض
    if (!fragments.isEmpty()) {
      showFragment(0);
    }
  }

  private void showFragment(int position) {
    FragmentTransaction transaction = fragmentManager.beginTransaction();

    // مخفی کردن همه فرگمنت‌ها
    for (int i = 0; i < fragments.size(); i++) {
      if (fragments.get(i).isAdded()) {
        transaction.hide(fragments.get(i));
      }
    }

    // نمایش فرگمنت مربوط به تب انتخاب شده
    if (!fragments.get(position).isAdded()) {
      transaction.add(containerId, fragments.get(position), "tab_" + position);
    } else {
      transaction.show(fragments.get(position));
    }

    transaction.commit();
  }

  @Override
  public void onTabSelected(TabLayout.Tab tabs) {
    int position = tabs.getPosition();
    if (position >= 0 && position < fragments.size()) {
      showFragment(position);
    }
  }

  @Override
  public void onTabUnselected(TabLayout.Tab tabs) {}

  @Override
  public void onTabReselected(TabLayout.Tab tabs) {
    int position = tabs.getPosition();
    PowerMenu menu =
        new PowerMenu.Builder(tab.getContext())
            .addItem(new PowerMenuItem("Add Tab"))
            .addItem(new PowerMenuItem("Close This Tab"))
            .addItem(new PowerMenuItem("Close All"))
            .setIsMaterial(true)
            .build();

    menu.setOnMenuItemClickListener(
        (pos, c) -> {
          switch (pos) {
            case 0:
              // افزودن تب جدید
              addNewTab();
              break;
            case 1:
              // بستن تب جاری
              if (position == 0) return; // تب اول را نمی‌توان بست
              closeTab(position);
              break;
            case 2:
              // بستن همه تب‌ها به جز اولی
              closeAllTabs();
              break;
          }
          menu.dismiss();
        });

    menu.setAutoDismiss(true);
    menu.setAnimation(MenuAnimation.FADE);
    menu.setMenuColor(MaterialColors.getColor(tab.getContext(), ObjectUtils.Back, 0));
    menu.setTextColor(MaterialColors.getColor(tab.getContext(), ObjectUtils.TvColor, 0));
    menu.setMenuRadius(10f);
    menu.setShowBackground(false);
    menu.showAsDropDown(tabs.view);
  }

  private void addNewTab() {
    int newPosition = tab.getTabCount();
    tab.addTab(tab.newTab().setText("Tab " + (newPosition + 1)));

    TerminalFragment newFragment = new TerminalFragment();
    fragments.add(newFragment);

    // نمایش تب جدید
    tab.selectTab(tab.getTabAt(newPosition));
  }

  private void closeTab(int position) {
    if (position < fragments.size()) {
      FragmentTransaction transaction = fragmentManager.beginTransaction();
      transaction.remove(fragments.get(position));
      transaction.commit();

      fragments.remove(position);
      tab.removeTabAt(position);

      // انتخاب تب قبلی پس از بستن
      if (tab.getTabCount() > 0) {
        tab.selectTab(tab.getTabAt(Math.max(0, position - 1)));
      }
    }
  }

  private void closeAllTabs() {
    FragmentTransaction transaction = fragmentManager.beginTransaction();

    // بستن همه فرگمنت‌ها به جز اولی
    for (int i = fragments.size() - 1; i > 0; i--) {
      transaction.remove(fragments.get(i));
      fragments.remove(i);
      tab.removeTabAt(i);
    }

    transaction.commit();

    // انتخاب تب اول
    if (tab.getTabCount() > 0) {
      tab.selectTab(tab.getTabAt(0));
    }
  }
}
