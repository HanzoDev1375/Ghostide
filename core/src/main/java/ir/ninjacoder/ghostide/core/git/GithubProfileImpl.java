package ir.ninjacoder.ghostide.core.git;

import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import io.noties.markwon.html.HtmlPlugin;
import ir.ninjacoder.ghostide.core.R;
import io.noties.markwon.Markwon;
import ir.ninjacoder.ghostide.core.glidecompat.RoundedCornersTransformation;

public class GithubProfileImpl {
  public static void bindByActivity(TextView text, ImageView icon) {
    var md = Markwon.builder(text.getContext()).usePlugin(HtmlPlugin.create()).build();

    var githubprofile = new GitHubProfileView(text.getContext());
    if (githubprofile != null) {

      md.setMarkdown(
          text,
          githubprofile.hasLogin()
              ? "**" + GhostDate.getGreeting() + "**" + " <ins>" + githubprofile.getName() + "</ins>"
              : "**"
                  + GhostDate.getGreeting()
                  + "** "
                  + " <ins>"
                  + text.getContext().getString(R.string.app_name)
                  + "</ins>");
      icon.postDelayed(
          () -> {
            try {
              Glide.with(icon.getContext())
                  .load(
                      githubprofile.hasLogin() ? githubprofile.getAvatarUrl() : R.drawable.app_icon)
                  .error(R.drawable.app_icon)
                  .centerInside()
                  .transform(new RoundedCornersTransformation(19))
                  .into(icon);
            } catch (Exception err) {
              icon.setImageResource(R.drawable.app_icon);
            }
          },
          3000);
    }
  }
}
