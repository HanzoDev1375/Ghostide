package ir.ninjacoder.prograsssheet.deepseek.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.Utils.CodeImpl;
import ir.ninjacoder.codesnap.colorhelper.ColorHelper;
import ir.ninjacoder.codesnap.colorhelper.ThemeManager;
import ir.ninjacoder.prograsssheet.R;
import ir.ninjacoder.prograsssheet.deepseek.model.Message;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private static final int VIEW_TYPE_USER = 1;
  private static final int VIEW_TYPE_ASSISTANT = 2;

  private List<Message> messages;
  private OnRegenerateListener regenerateListener;
  private CodeImpl codeImpl;
  private ColorHelper colorHelper;
  private static final Pattern CODE_BLOCK_PATTERN = Pattern.compile("```(\\w*)\\n([\\s\\S]*?)```");
  private Map<Integer, AssistantMessageViewHolder> viewHolderMap = new HashMap<>();

  public interface OnRegenerateListener {
    void onRegenerate(int position);
  }

  public void setOnRegenerateListener(OnRegenerateListener listener) {
    this.regenerateListener = listener;
  }

  public ChatAdapter(List<Message> messages) {
    this.messages = messages;
    initCodeHighlighter();
  }

  private void initCodeHighlighter() {
    codeImpl = new CodeImpl();
    colorHelper = new ColorHelper();
    colorHelper.setThememanager(ThemeManager.PROGRAMTHRME);
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
    TextView messageText;
    TextView timeText;
    ImageView copyButton;
    TextView searchIndicator;
    ChipGroup fileChipGroup;

    UserMessageViewHolder(@NonNull View itemView) {
      super(itemView);
      messageText = itemView.findViewById(R.id.messageText);
      timeText = itemView.findViewById(R.id.timeText);
      copyButton = itemView.findViewById(R.id.copyButton);
      searchIndicator = itemView.findViewById(R.id.searchIndicator);
      fileChipGroup = itemView.findViewById(R.id.fileChipGroup);
    }

    void bind(Message message) {
      messageText.setText(message.getContent());
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

      copyButton.setOnClickListener(
          v -> {
            copyToClipboard(v.getContext(), message.getContent());
            animateButton(copyButton);
          });
    }
  }

  class AssistantMessageViewHolder extends RecyclerView.ViewHolder {
    TextView messageText;
    TextView timeText;
    View typingIndicator;
    ImageView copyButton;
    ImageView regenerateButton;
    ProgressBar regenerateProgress;
    MaterialCardView cardView;
    LinearLayout reasoningContainer;
    TextView reasoningText;
    ImageView toggleReasoningButton;

    AssistantMessageViewHolder(@NonNull View itemView) {
      super(itemView);
      messageText = itemView.findViewById(R.id.messageText);
      timeText = itemView.findViewById(R.id.timeText);
      typingIndicator = itemView.findViewById(R.id.typingIndicator);
      copyButton = itemView.findViewById(R.id.copyButton);
      regenerateButton = itemView.findViewById(R.id.regenerateButton);
      regenerateProgress = itemView.findViewById(R.id.regenerateProgress);
      cardView = itemView.findViewById(R.id.messageCard);
      reasoningContainer = itemView.findViewById(R.id.reasoningContainer);
      reasoningText = itemView.findViewById(R.id.reasoningText);
      toggleReasoningButton = itemView.findViewById(R.id.toggleReasoningButton);
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

      if (message.isStreaming()) {
        typingIndicator.setVisibility(View.VISIBLE);
        copyButton.setVisibility(View.GONE);
        regenerateButton.setVisibility(View.GONE);
        CharSequence displayText = highlightCodeIfNeeded(message.getContent());
        messageText.setText(displayText);
      } else {
        typingIndicator.setVisibility(View.GONE);
        copyButton.setVisibility(View.VISIBLE);
        regenerateButton.setVisibility(View.VISIBLE);
        CharSequence displayText = highlightCodeIfNeeded(message.getContent());
        messageText.setText(displayText);
      }

      copyButton.setOnClickListener(
          v -> {
            copyToClipboard(v.getContext(), message.getContent());
            animateButton(copyButton);
          });

      regenerateButton.setOnClickListener(
          v -> {
            if (listener != null && !message.isStreaming()) {
              startRegenerateAnimation();
              listener.onRegenerate(position);
            }
          });
    }

    private CharSequence highlightCodeIfNeeded(String text) {
      if (!text.contains("```")) {
        return text;
      }
      try {
        SpannableStringBuilder result = new SpannableStringBuilder();
        Matcher matcher = CODE_BLOCK_PATTERN.matcher(text);
        int lastEnd = 0;
        while (matcher.find()) {
          if (matcher.start() > lastEnd) {
            result.append(text.substring(lastEnd, matcher.start()));
          }
          String language = matcher.group(1);
          String code = matcher.group(2);
          LangType langType = getLangTypeFromString(language);
          if (codeImpl != null && colorHelper != null) {
            try {
              SpannableStringBuilder highlighted = codeImpl.highlight(langType, code, colorHelper);
              if (highlighted != null) {
                result.append(highlighted);
              } else {
                result.append(code);
              }
            } catch (Exception e) {
              result.append(code);
            }
          } else {
            result.append(code);
          }
          lastEnd = matcher.end();
        }
        if (lastEnd < text.length()) {
          result.append(text.substring(lastEnd));
        }
        return result;
      } catch (Exception e) {
        return text;
      }
    }

    private LangType getLangTypeFromString(String lang) {
      if (lang == null || lang.isEmpty()) return LangType.NONE;
      String l = lang.toLowerCase().trim();
      switch (l) {
        case "java":
          return LangType.JAVA;
        case "python":
        case "py":
          return LangType.PYTHON;
        case "javascript":
        case "js":
          return LangType.JAVASCRIPT;
        case "typescript":
        case "ts":
          return LangType.TYPESCRIPT;
        case "kotlin":
        case "kt":
          return LangType.KOTLIN;
        case "dart":
          return LangType.DART;
        case "go":
          return LangType.GO;
        case "rust":
          return LangType.RUST;
        case "c":
          return LangType.C;
        case "cpp":
        case "c++":
          return LangType.CPP;
        case "csharp":
        case "cs":
          return LangType.CSHARP;
        case "html":
          return LangType.HTML;
        case "css":
          return LangType.CSS;
        case "php":
          return LangType.PHP;
        case "json":
          return LangType.JSON;
        case "xml":
          return LangType.XML;
        case "yaml":
        case "yml":
          return LangType.YAML;
        case "ruby":
        case "rb":
          return LangType.RUBY;
        case "gradle":
          return LangType.GRADLE;
        case "lua":
          return LangType.LUA;
        case "zig":
          return LangType.ZIG;
        case "md":
        case "markdown":
          return LangType.MARKDOWN;
        default:
          return LangType.NONE;
      }
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

  private void copyToClipboard(Context context, String text) {
    ClipboardManager clipboard =
        (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
    ClipData clip = ClipData.newPlainText("code", text);
    clipboard.setPrimaryClip(clip);
    Toast.makeText(context, "done", Toast.LENGTH_SHORT).show();
  }

  private void animateButton(ImageView button) {
    button
        .animate()
        .scaleX(0.7f)
        .scaleY(0.7f)
        .setDuration(100)
        .withEndAction(
            () -> {
              button.animate().scaleX(1f).scaleY(1f).setDuration(100).start();
            })
        .start();
  }
}
