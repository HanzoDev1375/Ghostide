package ir.ninjacoder.ghostide.core.model;

import ir.ninjacoder.ghostide.core.R;
import java.util.ArrayList;
import java.util.List;

public class AppIconManagerImpl {
  private List<AppIconManagerModel> model = new ArrayList<>();

  public void bind() {
    model.clear();

    add(R.mipmap.ghosticon, "Icon Default");
    add(R.drawable.ghosticonblue, "Icon Blue");
    add(R.drawable.ghosticonblack, "Icon Black");
    add(R.drawable.ghosticonred, "Icon Red");
    add(R.drawable.ghosticonyellow, "Icon Yellow");
    add(R.drawable.ghosticonpapermod, "Icon Jade Purple");
    add(R.drawable.ghosticongreenhell, "Icon Slime Green");
    add(R.drawable.ghosticonbluemod, "Dark Blue 2");
    add(R.drawable.ghosticons, "Ghost");
    add(R.drawable.greendraw, "Material Green");
    add(R.drawable.paperdraw, "Material Paper");
    add(R.drawable.reddraw, "Material Red");
    add(R.drawable.fourseasons, "Fourseasons");
    add(R.drawable.ghosticonice, "Ghost Icon Ice");
    add(R.drawable.ghosticonglass, "Ghost Icon Glass");
    add(R.drawable.ghosticonfire, "Ghost Icon Fire");
  }

  public void add(int icon, String name) {
    model.add(new AppIconManagerModel(name, icon));
  }

  public List<AppIconManagerModel> getModel() {
    return this.model;
  }
}
