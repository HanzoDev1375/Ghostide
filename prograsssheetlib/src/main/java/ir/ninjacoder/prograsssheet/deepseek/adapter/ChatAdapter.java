package ir.ninjacoder.prograssheet.deepseek.adapter;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ClipboardUtils;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import ir.ninjacoder.prograsssheet.R;
import ir.ninjacoder.prograsssheet.deepseek.model.Message;
import ir.ninjacoder.prograssheet.deepseek.widget.TypewriterTextView;
import ir.ninjacoder.codesnap.markdownpreview.MarkDownTextHelper;
import android.widget.LinearLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private static final int VIEW_TYPE_USER = 1;
  private static final int VIEW_TYPE_ASSISTANT = 2;

  private List<Message> messages;
  private OnRegenerateListener regenerateListener;
  private Map<Integer, AssistantMessageViewHolder> viewHolderMap = new HashMap<>();

  public interface OnRegenerateListener {
    void onRegenerate(int position);
  }

  public void setOnRegenerateListener(OnRegenerateListener listener) {
    this.regenerateListener = listener;
  }

  public ChatAdapter(List<Message> messages) {
    this.messages = messages;
  }

  @Override
  public int getItemViewType(int position) {
    Message message = messages.get(position);
    return "user".equals(message.getRole()) ? VIEW_TYPE_USER : VIEW_TYPE_ASSISTANT;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    if (viewType == VIEW_TYPE_USER) {
      View view = inflater.inflate(R.layout.item_message_user, parent, false);
      return new UserMessageViewHolder(view);
    } else {
      View view = inflater.inflate(R.layout.item_message_assistant, parent, false);
      return new AssistantMessageViewHolder(view);
    }
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    Message message = messages.get(position);
    if (holder instanceof UserMessageViewHolder) {
      ((UserMessageViewHolder) holder).bind(message);
    } else if (holder instanceof AssistantMessageViewHolder) {
      viewHolderMap.put(position, (AssistantMessageViewHolder) holder);
      ((AssistantMessageViewHolder) holder).bind(message, position, regenerateListener);
    }
  }

  @Override
  public void onViewRecycled(@NonNull RecyclerView.ViewHolder holder) {
    super.onViewRecycled(holder);
    if (holder instanceof AssistantMessageViewHolder) {
      for (Map.Entry<Integer, AssistantMessageViewHolder> entry : viewHolderMap.entrySet()) {
        if (entry.getValue() == holder) {
          viewHolderMap.remove(entry.getKey());
          break;
        }
      }
    }
  }

  @Override
  public int getItemCount() {
    return messages.size();
  }

  public void stopRegenerateAnimationAt(int position) {
    AssistantMessageViewHolder holder = viewHolderMap.get(position);
    if (holder != null) {
      holder.stopRegenerateAnimation();
    }
  }

  class UserMessageViewHolder extends RecyclerView.ViewHolder {
    TextView timeText;
    ImageView copyButton;
    TextView searchIndicator;
    ChipGroup fileChipGroup;
    TypewriterTextView contentText;

    UserMessageViewHolder(@NonNull View itemView) {
      super(itemView);
      timeText = itemView.findViewById(R.id.timeText);
      copyButton = itemView.findViewById(R.id.copyButton);
      searchIndicator = itemView.findViewById(R.id.searchIndicator);
      fileChipGroup = itemView.findViewById(R.id.fileChipGroup);
      contentText = itemView.findViewById(R.id.contentText);
    }

    void bind(Message message) {
      String content = message.getContent();

      // کاربر همیشه متن کامل رو داره، تایپ افکت نیاز نیست
      MarkDownTextHelper.handleMarkDown(contentText, content);

      timeText.setText(DateFormat.format("HH:mm", message.getTimestamp()));

      if (message.isSearchEnabled()) {
        searchIndicator.setVisibility(View.VISIBLE);
      } else {
        searchIndicator.setVisibility(View.GONE);
      }

      fileChipGroup.removeAllViews();
      if (message.getFileNames() != null && !message.getFileNames().isEmpty()) {
        fileChipGroup.setVisibility(View.VISIBLE);
        for (String fileName : message.getFileNames()) {
          Chip chip = new Chip(itemView.getContext());
          chip.setText(fileName);
          chip.setChipIconResource(R.drawable.ic_file);
          chip.setClickable(false);
          chip.setCheckable(false);
          fileChipGroup.addView(chip);
        }
      } else {
        fileChipGroup.setVisibility(View.GONE);
      }

      copyButton.setOnClickListener(v -> ClipboardUtils.copyText(content));
      itemView.setOnClickListener(c -> bindOfPowerMenu(message, c));
    }
  }

  void bindOfPowerMenu(Message msg, View v) {
    var menu =
        new PowerMenu.Builder(v.getContext())
            .setIsMaterial(true)
            .setShowBackground(false)
            .setMenuColor(MaterialColors.getColor(v.getContext(), R.attr.colorSurface, 0))
            .setTextColor(MaterialColors.getColor(v.getContext(), R.attr.colorOnSurface, 0))
            .setAutoDismiss(true)
            .setAnimation(MenuAnimation.FADE)
            .build();
    menu.addItem(new PowerMenuItem("copy", false, R.drawable.ic_copy));
    menu.setOnMenuItemClickListener(
        (pos, men2u) -> {
          switch (pos) {
            case 0 -> ClipboardUtils.copyText(msg.getContent());
          }
        });
    menu.showAsDropDown(v);
  }

  class AssistantMessageViewHolder extends RecyclerView.ViewHolder {
    TextView timeText;
    ProgressBar typingIndicator;
    ImageView copyButton;
    ImageView regenerateButton;
    ProgressBar regenerateProgress;
    MaterialCardView cardView;
    LinearLayout reasoningContainer;
    TextView reasoningText;
    ImageView toggleReasoningButton;
    TypewriterTextView contentText;

    AssistantMessageViewHolder(@NonNull View itemView) {
      super(itemView);
      timeText = itemView.findViewById(R.id.timeText);
      typingIndicator = itemView.findViewById(R.id.typingIndicator);
      copyButton = itemView.findViewById(R.id.copyButton);
      regenerateButton = itemView.findViewById(R.id.regenerateButton);
      regenerateProgress = itemView.findViewById(R.id.regenerateProgress);
      cardView = itemView.findViewById(R.id.messageCard);
      reasoningContainer = itemView.findViewById(R.id.reasoningContainer);
      reasoningText = itemView.findViewById(R.id.reasoningText);
      toggleReasoningButton = itemView.findViewById(R.id.toggleReasoningButton);
      contentText = itemView.findViewById(R.id.contentText);
    }

    void bind(Message message, int position, OnRegenerateListener listener) {
      timeText.setText(DateFormat.format("HH:mm", message.getTimestamp()));

      if (message.getReasoningContent() != null && !message.getReasoningContent().isEmpty()) {
        reasoningContainer.setVisibility(View.VISIBLE);
        reasoningText.setText(message.getReasoningContent());
        toggleReasoningButton.setOnClickListener(
            v -> {
              if (reasoningText.getVisibility() == View.VISIBLE) {
                reasoningText.setVisibility(View.GONE);
                toggleReasoningButton.setImageResource(R.drawable.ic_expand_more);
              } else {
                reasoningText.setVisibility(View.VISIBLE);
                toggleReasoningButton.setImageResource(R.drawable.ic_expand_less);
              }
            });
      } else {
        reasoningContainer.setVisibility(View.GONE);
      }

      String content = message.getContent();

      if (message.isStreaming()) {
        MarkDownTextHelper.handleMarkDown(contentText, content);
        typingIndicator.setVisibility(View.VISIBLE);
        copyButton.setVisibility(View.GONE);
        regenerateButton.setVisibility(View.GONE);
      } else {
        contentText.typeText(content);
        typingIndicator.setVisibility(View.GONE);
        copyButton.setVisibility(View.VISIBLE);
        regenerateButton.setVisibility(View.VISIBLE);
      }

      itemView.setOnClickListener(c -> bindOfPowerMenu(message, c));
      copyButton.setOnClickListener(v -> ClipboardUtils.copyText(content));
      regenerateButton.setOnClickListener(
          v -> {
            if (listener != null && !message.isStreaming()) {
              startRegenerateAnimation();
              listener.onRegenerate(position);
            }
          });
    }

    private void startRegenerateAnimation() {
      regenerateButton.setVisibility(View.GONE);
      regenerateProgress.setVisibility(View.VISIBLE);
    }

    void stopRegenerateAnimation() {
      regenerateProgress.setVisibility(View.GONE);
      regenerateButton.setVisibility(View.VISIBLE);
    }
  }

  public void finalizeStreamingAt(int position) {
    // Markwon همه چیز رو هندل میکنه
  }
}
