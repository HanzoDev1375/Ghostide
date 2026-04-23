package ir.ninjacoder.prograsssheet.deepseek.adapter;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import ir.ninjacoder.prograsssheet.R;
import ir.ninjacoder.prograsssheet.deepseek.database.ChatDatabaseHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatHistoryDrawerAdapter
    extends RecyclerView.Adapter<ChatHistoryDrawerAdapter.ViewHolder> {

  private List<ChatDatabaseHelper.ChatInfo> chats = new ArrayList<>();
  private OnChatClickListener listener;
  private String selectedChatId = null;

  public interface OnChatClickListener {
    void onChatClick(ChatDatabaseHelper.ChatInfo chat);

    void onChatDelete(ChatDatabaseHelper.ChatInfo chat);
  }

  public void setOnChatClickListener(OnChatClickListener listener) {
    this.listener = listener;
  }

  public void setChats(List<ChatDatabaseHelper.ChatInfo> newChats) {
    this.chats = newChats != null ? newChats : new ArrayList<>();
    notifyDataSetChanged();
  }

  public void setSelectedChat(String chatId) {
    String oldSelectedId = this.selectedChatId;
    this.selectedChatId = chatId;

    if (oldSelectedId != null) {
      int oldIndex = findChatPosition(oldSelectedId);
      if (oldIndex != -1) {
        notifyItemChanged(oldIndex);
      }
    }

    if (chatId != null) {
      int newIndex = findChatPosition(chatId);
      if (newIndex != -1) {
        notifyItemChanged(newIndex);
      }
    }
  }

  private int findChatPosition(String chatId) {
    for (int i = 0; i < chats.size(); i++) {
      if (chats.get(i).id.equals(chatId)) {
        return i;
      }
    }
    return -1;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_chat, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    ChatDatabaseHelper.ChatInfo chat = chats.get(position);
    holder.bind(chat, chat.id.equals(selectedChatId));
  }

  @Override
  public int getItemCount() {
    return chats.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    TextView titleText;
    TextView dateText;
    TextView previewText;
    ImageButton deleteButton;
    View selectedIndicator;

    ViewHolder(@NonNull View itemView) {
      super(itemView);
      titleText = itemView.findViewById(R.id.chatTitleText);
      dateText = itemView.findViewById(R.id.chatDateText);
      previewText = itemView.findViewById(R.id.chatPreviewText);
      deleteButton = itemView.findViewById(R.id.deleteChatButton);
      selectedIndicator = itemView.findViewById(R.id.selectedIndicator);
    }

    void bind(ChatDatabaseHelper.ChatInfo chat, boolean isSelected) {
      titleText.setText(chat.getDisplayTitle());

      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm", Locale.getDefault());
      String dateStr = sdf.format(new Date(chat.updatedAt));
      dateText.setText(dateStr);
      previewText.setText("برای ادامه چت کلیک کنید");
      selectedIndicator.setVisibility(isSelected ? View.VISIBLE : View.GONE);
      if (isSelected) {
        itemView.setBackgroundColor(
            ContextCompat.getColor(itemView.getContext(), android.R.color.transparent));
        itemView.setAlpha(1.0f);
      } else {
        itemView.setBackgroundColor(
            ContextCompat.getColor(itemView.getContext(), android.R.color.transparent));
        itemView.setAlpha(0.8f);
      }

      itemView.setOnClickListener(
          v -> {
            if (listener != null) {
              listener.onChatClick(chat);
            }
          });

      deleteButton.setOnClickListener(
          vd -> {
            if (listener != null) listener.onChatDelete(chat);
          });
    }
  }
}
