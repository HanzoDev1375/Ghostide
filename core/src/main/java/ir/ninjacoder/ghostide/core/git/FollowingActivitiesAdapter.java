package ir.ninjacoder.ghostide.core.git;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.IntentUtils;
import com.bumptech.glide.Glide;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.glidecompat.RoundedCornersTransformation;
import ir.ninjacoder.prograsssheet.perfence.ListItemView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FollowingActivitiesAdapter
    extends RecyclerView.Adapter<FollowingActivitiesAdapter.ViewHolder> {

  private final List<GitHubFollowingActivity.ActivityEvent> events;
  private final SimpleDateFormat dateFormat;
  private final SimpleDateFormat timeFormat;

  public FollowingActivitiesAdapter(List<GitHubFollowingActivity.ActivityEvent> events) {
    this.events = events;
    this.dateFormat = new SimpleDateFormat("MMM d", Locale.getDefault());
    this.timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_github_activity, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    GitHubFollowingActivity.ActivityEvent event = events.get(position);

    // تنظیم آواتار کاربر
    if (event.avatarUrl != null && !event.avatarUrl.isEmpty()) {
      Glide.with(holder.itemView.getContext())
          .load(event.avatarUrl)
          .placeholder(R.drawable.avatar_circle_24px)
          .transform(new RoundedCornersTransformation(19))
          .error(R.drawable.avatar_circle_24px)
          .into(holder.userAvatar);
    }

    // تنظیم نام کاربری
    holder.username.setText(event.username);
    setActivityIconAndText(holder, event);
    holder.repoName.setText(event.repoName);

    // تنظیم زمان
    try {
      Date eventDate =
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault()).parse(event.time);
      if (eventDate != null) {
        holder.eventDate.setText(dateFormat.format(eventDate));
        holder.eventTime.setText(timeFormat.format(eventDate));
      }
    } catch (Exception e) {
      holder.eventTime.setText("Just now");
    }
    holder.root.setBackground(holder.root.get(events,position));
    holder.itemView.setOnClickListener(v -> {});
  }

  private void setActivityIconAndText(
      ViewHolder holder, GitHubFollowingActivity.ActivityEvent event) {
    switch (event.type) {
      case "WatchEvent":
        holder.activityIcon.setImageResource(R.drawable.ic_star_24px);
        holder.activityText.setText("starred");
        break;

      case "ForkEvent":
        holder.activityIcon.setImageResource(R.drawable.fork_24px);
        holder.activityText.setText("forked");
        break;

      case "PushEvent":
        holder.activityIcon.setImageResource(R.drawable.commit_24px);
        holder.activityText.setText("pushed to");
        break;

      case "CreateEvent":
        holder.activityIcon.setImageResource(R.drawable.repository_24px);
        holder.activityText.setText("created");
        break;

      case "IssuesEvent":
        holder.activityIcon.setImageResource(R.drawable.ic_issue_24px);
        holder.activityText.setText("issue");
        break;

      case "PullRequestEvent":
        holder.activityIcon.setImageResource(R.drawable.ic_issue_24px);
        holder.activityIcon.setColorFilter(Color.CYAN, PorterDuff.Mode.SRC_IN);
        holder.activityText.setText("pull request");
        break;

      default:
        holder.activityIcon.setImageResource(R.drawable.merge_24px);
        holder.activityText.setText("activity");
    }
  }

  @Override
  public int getItemCount() {
    return events.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    ImageView userAvatar, activityIcon;
    TextView username, activityText, repoName, eventDate, eventTime;
    ListItemView root;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      root = itemView.findViewById(R.id.root);
      userAvatar = itemView.findViewById(R.id.user_avatar);
      activityIcon = itemView.findViewById(R.id.activity_icon);
      username = itemView.findViewById(R.id.username);
      activityText = itemView.findViewById(R.id.activity_text);
      repoName = itemView.findViewById(R.id.repo_name);
      eventDate = itemView.findViewById(R.id.event_date);
      eventTime = itemView.findViewById(R.id.event_time);
    }
  }
}
