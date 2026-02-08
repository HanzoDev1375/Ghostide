package ir.ninjacoder.ghostide.core.layoutmanager;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.git.FollowingActivitiesAdapter;
import ir.ninjacoder.ghostide.core.git.GitHubFollowingActivity;
import androidx.appcompat.app.AlertDialog;
import ir.ninjacoder.ghostide.core.git.GitHubProfileView;
import ir.ninjacoder.ghostide.core.git.GithubStarView;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import ir.ninjacoder.prograsssheet.util.RoundStrokeTransform;
import java.util.List;
import ir.ninjacoder.ghostide.core.git.StarredReposAdapter;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class NavigationViewCompnet extends NavigationView {
  protected int Cut = CornerFamily.ROUNDED;
  private ImageView starview, logout, issue;
  private Handler handler = new Handler(Looper.getMainLooper());
  private DrawerLayout layout;

  public NavigationViewCompnet(Context context) {
    super(context);
  }

  public NavigationViewCompnet(Context context, AttributeSet set) {
    super(context, set);
    init();
  }

  public void bindView(DrawerLayout layout) {
    this.layout = layout;
  }

  public NavigationViewCompnet init() {
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    disableNavScroll(this);
    setBackground(getBackground());
    issue = getHeaderView(0).findViewById(R.id.issue);
    starview = getHeaderView(0).findViewById(R.id.starview);
    logout = getHeaderView(0).findViewById(R.id.logout);

    ImageView icon = getHeaderView(0).findViewById(R.id.iconHeader);
    TextView title = getHeaderView(0).findViewById(R.id.headertitle);
    TextView subtitle = getHeaderView(0).findViewById(R.id.hedersubtitle);
    TextView followers = getHeaderView(0).findViewById(R.id.leftTextView);
    TextView following = getHeaderView(0).findViewById(R.id.rightTextView);
    TextView bio = getHeaderView(0).findViewById(R.id.biogithub);
    try {
      var it = new GitHubProfileView(getContext());
      if (it != null) {
        boolean haslogin = it.hasLogin();
        starview.setEnabled(haslogin ? true : false);
        issue.setEnabled(haslogin ? true : false);
        AnimUtils.Sacla(starview);
        starview.setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.SRC_IN);
        issue.setColorFilter(Color.parseColor("#2fdcf7"));
        logout.setColorFilter(MaterialColors.getColor(logout,ObjectUtils.colorError));
        AnimUtils.Sacla(issue);
        AnimUtils.Sacla(logout);
        Glide.with(icon.getContext())
            .load(it.hasLogin() ? it.getAvatarUrl() : R.drawable.app_icon)
            .transform(RoundStrokeTransform.instaStyle(99, 4))
            .error(R.drawable.app_icon)
            .into(icon);
        title.setText(it.hasLogin() ? it.getUsername() : getContext().getString(R.string.app_name));
        starview.setOnClickListener(
            v -> {
              showExploreDialog();
              layout.closeDrawer(GravityCompat.START);
            });
        issue.setOnClickListener(
            v -> {
              showFollowingActivitiesDialog();
              layout.closeDrawer(GravityCompat.START);
            });
        logout.setPadding(9, 9, 9, 9);
        logout.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        logout.setOnClickListener(
            v -> {
              it.logout();
              icon.setImageResource(R.drawable.app_icon);
              title.setText("Ghost ide App");
              subtitle.setText("User not login in github");
              followers.setText("0");
              following.setText("0");
              bio.setText("not login");
              starview.clearColorFilter();
              logout.clearColorFilter();
              issue.clearColorFilter();
              starview.setEnabled(false);
              issue.setEnabled(false);
              layout.closeDrawer(GravityCompat.START);
            });
        followers.setText(it.hasFollowers() ? "follwers " + it.getFollowers() : "0");
        following.setText(it.hasFollowing() ? "following " + it.getFollowing() : "0");
        bio.setText(it.hasBio() ? it.getBio() : "user not login...");
        subtitle.setText(it.hasUsername() ? it.getUsername() : "User not login ");
        icon.setOnLongClickListener(
            v33 -> {
              new MaterialAlertDialogBuilder(getContext())
                  .setTitle("Log out??")
                  .setPositiveButton(
                      "yes",
                      (r, __) -> {
                        it.logout();
                        icon.setImageResource(R.drawable.app_icon);
                        title.setText("Ghost ide App");
                        subtitle.setText("User not login in github");
                        followers.setText("0");
                        following.setText("0");
                        bio.setText("not login");
                      })
                  .setNeutralButton("no", null)
                  .show();

              return false;
            });
      }
    } catch (Exception err) {
      Log.e("Error ", err.getMessage());
    }

    return this;
  }

  /* برای پلاگین باید باشه*/
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

  private void showExploreDialog() {
    new Thread(
            () -> {
              try {
                GithubStarView githubStar = new GithubStarView(getContext());
                List<GithubStarView.StarredRepo> repos = githubStar.getStarredRepos();

                post(
                    () -> {
                      RecyclerView recyclerView = new RecyclerView(getContext());
                      recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                      StarredReposAdapter adapter = new StarredReposAdapter(repos);
                      recyclerView.setAdapter(adapter);

                      new MaterialAlertDialogBuilder(getContext())
                          .setTitle("Starred Repositories (" + repos.size() + ")")
                          .setView(recyclerView)
                          .setPositiveButton("Close", null)
                          .show();
                    });

              } catch (Exception e) {
                post(
                    () -> {
                      DataUtil.showMessage(getContext(), "Error: " + e.getMessage());
                    });
              }
            })
        .start();
  }

  private void showFollowingActivitiesDialog() {
    GitHubFollowingActivity followingActivity = new GitHubFollowingActivity(getContext());

    MaterialAlertDialogBuilder progressDialog =
        new MaterialAlertDialogBuilder(getContext())
            .setTitle("Loading GitHub Feed")
            .setMessage("Fetching your activity feed...")
            .setCancelable(false);

    AlertDialog dialog = progressDialog.show();
    Runnable timeoutTask =
        () -> {
          if (dialog.isShowing()) {
            dialog.dismiss();
            DataUtil.showMessage(getContext(), "Request timeout. Please try again.");
          }
        };
    handler.postDelayed(timeoutTask, 30000);

    followingActivity.getFollowingActivities(
        new GitHubFollowingActivity.FollowingActivitiesCallback() {
          @Override
          public void onSuccess(List<GitHubFollowingActivity.ActivityEvent> events) {
            handler.removeCallbacks(timeoutTask);
            if (dialog.isShowing()) {
              dialog.dismiss();
            }

            if (events.isEmpty()) {
              new MaterialAlertDialogBuilder(getContext())
                  .setTitle("No Recent Activity")
                  .setMessage("No recent activity in your feed")
                  .setPositiveButton("Ok", null)
                  .show();
              return;
            }
            RecyclerView recyclerView = new RecyclerView(getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            FollowingActivitiesAdapter adapter = new FollowingActivitiesAdapter(events);
            recyclerView.setAdapter(adapter);

            new MaterialAlertDialogBuilder(getContext())
                .setTitle("Your GitHub Feed (" + events.size() + ")")
                .setView(recyclerView)
                .setPositiveButton("Close", null)
                .show();
          }

          @Override
          public void onError(String error) {
            handler.removeCallbacks(timeoutTask);
            if (dialog.isShowing()) {
              dialog.dismiss();
            }
            DataUtil.showMessage(getContext(), "Error: " + error);
          }
        });
  }
}
