package ir.ninjacoder.ghostide.core.layoutmanager;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.git.GitHubProfileView;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class NavigationViewCompnet extends NavigationView {
  protected int Cut = CornerFamily.ROUNDED;

  public NavigationViewCompnet(Context context) {
    super(context);
  }

  public NavigationViewCompnet(Context context, AttributeSet set) {
    super(context, set);
    init();
  }

  public NavigationViewCompnet init() {

    /* setItemTextColor(ColorStateList.valueOf(MaterialColors.getColor(this, ObjectUtils.TvColor)));
    setItemIconTintList(
            ColorStateList.valueOf(MaterialColors.getColor(this, ObjectUtils.ColorFilter)));
    setItemMaxLines(1);
    setItemIconSize(50);*/
    setBackground(getBackground());

    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    /*getHeaderView(0)
    .findViewById(R.id.mcardClick)
    .setOnClickListener(
            v -> {
                Toast.makeText(getContext(), R.string.app_name, 3).show();
            });*/
    disableNavScroll(this);
    ImageView icon = getHeaderView(0).findViewById(R.id.iconHeader);
    TextView title = getHeaderView(0).findViewById(R.id.headertitle);
    TextView subtitle = getHeaderView(0).findViewById(R.id.hedersubtitle);
    TextView followers = getHeaderView(0).findViewById(R.id.leftTextView);
    TextView following = getHeaderView(0).findViewById(R.id.rightTextView);
    TextView bio = getHeaderView(0).findViewById(R.id.biogithub);
    try {
      var it = new GitHubProfileView(getContext());
      followers.setText(it.hasFollowers() ? "follwers " + it.getFollowers() : "");
      following.setText(it.hasFollowing() ? "following " + it.getFollowing() : "");
      bio.setText(it.hasBio() ? it.getBio() : "");
      Glide.with(icon.getContext())
          .load(it.hasAvatarUrl() ? it.getAvatarUrl() : R.drawable.app_icon)
          .circleCrop()
          .error(R.drawable.app_icon)
          .into(icon);
      title.setText(it.hasName() ? it.getName() : "");
      subtitle.setText(it.hasUsername() ? it.getUsername() : "");
      icon.setOnLongClickListener(
          v33 -> {
            new MaterialAlertDialogBuilder(getContext())
                .setTitle("Log out??")
                .setPositiveButton(
                    "yes",
                    (r, __) -> {
                      it.logout();
                      icon.setImageResource(R.drawable.app_icon);
                      title.setText("");
                      subtitle.setText("");
                      followers.setText("");
                      following.setText("");
                      bio.setText("");
                    })
                .show();

            return false;
          });
    } catch (Exception err) {
      Log.e("Error ", err.getMessage());
    }

    return this;
  }

  public void setClick(OnClick clicks) {
    setNavigationItemSelectedListener(
        new OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(MenuItem menuItem) {
            clicks.Click(menuItem);

            return false;
          }
        });
  }

  public MaterialShapeDrawable getBackground() {
    MaterialShapeDrawable shapeDrawable =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder()
                .setTopRightCorner(Cut, 13f)
                .setBottomRightCorner(Cut, 13f)
                .build());

    shapeDrawable.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(getContext(), ObjectUtils.Back, 0)));

    return shapeDrawable;
  }

  private void disableNavScroll(NavigationView navView) {
    NavigationMenuView navMenu = (NavigationMenuView) navView.getChildAt(0);
    navMenu.setLayoutManager(
        new LinearLayoutManager(getContext()) {
          @Override
          public boolean canScrollVertically() {
            return true;
          }
        });
    navMenu.setScrollBarSize(0);
  }

  public interface OnClick {
    public boolean Click(MenuItem item);
  }
}
