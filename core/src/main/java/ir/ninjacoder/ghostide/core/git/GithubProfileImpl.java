package ir.ninjacoder.ghostide.core.git;

import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import ir.ninjacoder.ghostide.core.R;
import io.noties.markwon.Markwon;

public class GithubProfileImpl {
  public static void bindByActivity(TextView text, ImageView icon) {
    var md = Markwon.create(text.getContext());

    var githubprofile = new GitHubProfileView(text.getContext());
    if (githubprofile != null) {

      md.setMarkdown(
          text,
          githubprofile.hasLogin()
              ? "**" + GhostDate.getGreeting() + "**" + "<ins>" + githubprofile.getName() + "</ins>"
              : "**"
                  + GhostDate.getGreeting()
                  + "**"
                  + "<ins>"
                  + text.getContext().getString(R.string.app_name)
                  + "</ins>");
      icon.postDelayed(
          () -> {
            try {
              Glide.with(icon.getContext())
                  .load(
                      githubprofile.hasLogin() ? githubprofile.getAvatarUrl() : R.drawable.app_icon)
                  .error(R.drawable.app_icon)
                  .circleCrop()
                  .into(icon);
            } catch (Exception err) {
              icon.setImageResource(R.drawable.app_icon);
            }
          },
          3000);
    }
  }
}
