package ninja.coder.appuploader.data;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import com.downloader.R;
import java.util.*;
import ninja.coder.models.CodesnippetModel;

public class SnippetsAdapter extends RecyclerView.Adapter<SnippetsAdapter.SnippetViewHolder> {
  private List<Map.Entry<String, CodesnippetModel>> allSnippets = new ArrayList<>();
  private List<Map.Entry<String, CodesnippetModel>> filteredSnippets = new ArrayList<>();
  private OnSnippetClickListener listener;
  private String currentSearchQuery = "";

  public interface OnSnippetClickListener {
    void onEditClick(String key, CodesnippetModel snippet);

    void onDeleteClick(String key);
  }

  public void setSnippets(Map<String, CodesnippetModel> snippetMap) {
    this.allSnippets = new ArrayList<>(snippetMap.entrySet());
    this.filteredSnippets = new ArrayList<>(allSnippets);
    notifyDataSetChanged();
  }

  public void filter(String query) {
    currentSearchQuery = query;
    filteredSnippets.clear();

    if (query.isEmpty()) {
      filteredSnippets.addAll(allSnippets);
    } else {
      String lowerCaseQuery = query.toLowerCase().trim();
      for (Map.Entry<String, CodesnippetModel> entry : allSnippets) {
        if (entry.getValue().getPrefix().toLowerCase().contains(lowerCaseQuery)) {
          filteredSnippets.add(entry);
        }
      }
    }
    notifyDataSetChanged();
  }

  @Override
  public SnippetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_snippet, parent, false);
    return new SnippetViewHolder(view);
  }

  @Override
  public void onBindViewHolder(SnippetViewHolder holder, int position) {
    Map.Entry<String, CodesnippetModel> entry = filteredSnippets.get(position);
    holder.bind(entry.getKey(), entry.getValue(), listener, currentSearchQuery);
  }

  @Override
  public int getItemCount() {
    return filteredSnippets.size();
  }

  public void setOnSnippetClickListener(OnSnippetClickListener listener) {
    this.listener = listener;
  }

  static class SnippetViewHolder extends RecyclerView.ViewHolder {
    private TextView tvPrefix;
    private TextView tvDescription;

    public SnippetViewHolder(View itemView) {
      super(itemView);
      tvPrefix = itemView.findViewById(R.id.tv_prefix);
      tvDescription = itemView.findViewById(R.id.tv_description);
    }

    public void bind(
        String key, CodesnippetModel snippet, OnSnippetClickListener listener, String searchQuery) {

      // هایلایت فقط روی prefix
      setHighlightSearchText(tvPrefix, snippet.getPrefix(), searchQuery);

      // نمایش description بدون هایلایت
      tvDescription.setText(snippet.getDescription());

      itemView.setOnClickListener(
          v -> {
            PopupMenu popup = new PopupMenu(itemView.getContext(), v);
            Menu menu = popup.getMenu();
            menu.add(0, 1, 0, "Edit").setIcon(android.R.drawable.ic_menu_edit);
            menu.add(0, 2, 1, "Delete").setIcon(android.R.drawable.ic_menu_delete);

            popup.setOnMenuItemClickListener(
                item -> {
                  if (item.getItemId() == 1 && listener != null) {
                    listener.onEditClick(key, snippet);
                    return true;
                  } else if (item.getItemId() == 2 && listener != null) {
                    listener.onDeleteClick(key);
                    return true;
                  }
                  return false;
                });
            popup.show();
          });
    }

    private void setHighlightSearchText(TextView textView, String fullText, String searchText) {
      if (searchText == null || searchText.isEmpty()) {
        textView.setText(fullText);
        return;
      }

      SpannableString spannableString = new SpannableString(fullText);
      String lowerFullText = fullText.toLowerCase();
      String lowerSearchText = searchText.toLowerCase();

      int startPos = lowerFullText.indexOf(lowerSearchText);
      if (startPos != -1) {
        int endPos = startPos + searchText.length();
        spannableString.setSpan(
            new ForegroundColorSpan(Color.CYAN),
            startPos,
            endPos,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
      }

      textView.setText(spannableString);
    }
  }
}
