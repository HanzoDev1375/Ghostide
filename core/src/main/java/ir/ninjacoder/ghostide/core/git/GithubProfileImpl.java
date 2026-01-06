package ir.ninjacoder.ghostide.core.git;

import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import ir.ninjacoder.ghostide.core.R;

public class GithubProfileImpl {
  public static void bindByActivity(TextView text, ImageView icon) {
    
    var githubprofile = new GitHubProfileView(text.getContext());
    if (githubprofile != null) {
      text.setText(
          githubprofile.hasLogin()
              ? GhostDate.getGreetingWithName(githubprofile.getName())
              : text.getContext().getString(R.string.app_name));
      Glide.with(icon.getContext())
          .load(githubprofile.hasLogin() ? githubprofile.getAvatarUrl() : R.drawable.app_icon)
          .into(icon);
    }
  }
}
