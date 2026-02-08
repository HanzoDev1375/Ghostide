package ir.ninjacoder.ghostide.core.git;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import io.noties.markwon.Markwon;
import io.noties.markwon.html.HtmlPlugin;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.glidecompat.RoundedCornersTransformation;
import java.util.List;

public class StarredReposAdapter extends RecyclerView.Adapter<StarredReposAdapter.ViewHolder> {

  private final List<GithubStarView.StarredRepo> repos;

  public StarredReposAdapter(List<GithubStarView.StarredRepo> repos) {
    this.repos = repos;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.githubstarview, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    GithubStarView.StarredRepo repo = repos.get(position);

    holder.repoName.setText(repo.full_name != null ? repo.full_name : "Unknown");
    holder.repoDescription.setText(repo.description != null ? repo.description : "No description");
    holder.starsCount.setText(
        get("#### " + String.valueOf(repo.stargazers_count) + "", holder.starsCount));
    holder.forksCount.setText(
        get("#### " + String.valueOf(repo.forks_count) + "", holder.forksCount));
    holder.language.setText(
        repo.language != null ? repo.language : get("**N/A**", holder.language));

    if (repo.owner != null) {
      holder.ownerName.setText(repo.owner.login);
      if (repo.owner.avatar_url != null) {
        Glide.with(holder.itemView.getContext())
            .load(repo.owner.avatar_url)
            .placeholder(R.drawable.avatar_circle_24px)
            .transform(new RoundedCornersTransformation(19))
            .error(R.drawable.avatar_circle_24px)
            .into(holder.ownerAvatar);
      }
    } else {
      holder.ownerName.setText("Unknown");
      holder.ownerAvatar.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
      holder.ownerAvatar.setImageResource(R.drawable.avatar_circle_24px);
    }
  }

  @Override
  public int getItemCount() {
    return repos.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView repoName, repoDescription, starsCount, forksCount, language, ownerName;
    ImageView ownerAvatar;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      repoName = itemView.findViewById(R.id.repo_name);
      repoDescription = itemView.findViewById(R.id.repo_description);
      starsCount = itemView.findViewById(R.id.stars_count);
      forksCount = itemView.findViewById(R.id.forks_count);
      language = itemView.findViewById(R.id.language);
      ownerName = itemView.findViewById(R.id.owner_name);
      ownerAvatar = itemView.findViewById(R.id.owner_avatar);
    }
  }

  private Spanned get(String code, View c) {
    var mark = Markwon.builder(c.getContext()).usePlugin(HtmlPlugin.create()).build();
    return mark.toMarkdown(code);
  }
}
