package ir.ninjacoder.prograsssheet.search;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.snackbar.Snackbar;
import io.noties.markwon.Markwon;
import io.noties.markwon.html.HtmlPlugin;
import ir.ninjacoder.prograsssheet.R;
import ir.ninjacoder.prograsssheet.databinding.ItemBottomsheetSearchBinding;
import ir.ninjacoder.prograsssheet.search.interfaces.SearchListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GlobalSearchBottomSheet extends BottomSheetDialogFragment {
  private ItemBottomsheetSearchBinding bind;

  public interface OnItemClickListener {
    void onItemClick(String filePath);
  }

  private SearchAdapter adapter;
  private GlobalSearchManager manager;
  private OnItemClickListener itemClickListener;
  private String pathInput;
  private int pendingIcon = -1;
  private String currentQuery = "";

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    bind =
        ItemBottomsheetSearchBinding.inflate(LayoutInflater.from(getContext()), container, false);
    return bind.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    adapter = new SearchAdapter();
    bind.resultsList.setLayoutManager(new LinearLayoutManager(getContext()));
    bind.resultsList.setAdapter(adapter);

    if (pendingIcon != -1) {
      adapter.setIcon(pendingIcon);
      pendingIcon = -1;
    }

    bind.fileCheck.setChecked(true);
    bind.folderCheck.setChecked(true);
    bind.hiddenCheck.setChecked(false);
    bind.searchButton.setOnClickListener(v -> startSearch());
    bind.stopButton.setOnClickListener(v -> stopSearch());

    bind.regexCheck.setOnCheckedChangeListener(
        (buttonView, isChecked) -> {
          bind.caseCheck.setEnabled(!isChecked);
          updateTextColor();
        });
    bind.caseCheck.setOnCheckedChangeListener(
        (buttonView, isChecked) -> {
          bind.regexCheck.setEnabled(!isChecked);
          updateTextColor();
        });

    bind.progressBar.setWaveAmplitude(3);
    bind.progressBar.setWavelength(99);
  }

  void updateTextColor() {
    var statecolor = MaterialColors.getColor(bind.searchInput, getColorOnSurface());
    if (bind.regexCheck.isChecked()) {
      statecolor = Color.parseColor("#FFFFA749");
    } else if (bind.caseCheck.isChecked()) {
      statecolor = Color.parseColor("#FFAAFF49");
    } else {
      statecolor = MaterialColors.getColor(bind.searchInput, getColorOnSurface());
    }
    bind.searchInput.setTextColor(statecolor);
  }

  public void setIcon(int icon) {
    if (adapter != null) {
      adapter.setIcon(icon);
    } else {
      this.pendingIcon = icon;
    }
  }

  public int getIcon() {
    if (adapter != null) {
      return adapter.getIcon();
    }
    return pendingIcon != -1 ? pendingIcon : android.R.drawable.ic_menu_search;
  }

  private void startSearch() {
    String query = bind.searchInput.getText().toString().trim();
    if (query.isEmpty()) {
      showMarkdownMessage("_Please enter data_");
      return;
    }
    currentQuery = query;
    adapter.setSearchQuery(query);
    adapter.setSearchMode(bind.regexCheck.isChecked(), bind.caseCheck.isChecked());
    adapter.clear();
    setSearching(true);
    bind.resultsText.setText(getMarkDown("_Start Search..._"));

    manager = new GlobalSearchManager();

    File searchRoot;
    File initialFile = new File(pathInput);

    if (initialFile.exists()) {
      if (initialFile.isDirectory()) {
        searchRoot = initialFile;
      } else {
        searchRoot = initialFile.getParentFile();
        if (searchRoot == null) {
          showMarkdownMessage("_The entered path is not valid_");
          setSearching(false);
          return;
        }
      }
    } else {
      showMarkdownMessage("_Directory not found_");
      setSearching(false);
      return;
    }

    Log.d("GlobalSearch", "Starting search in: " + searchRoot.getAbsolutePath());
    Log.d("GlobalSearch", "Query: " + query);
    Log.d("GlobalSearch", "Search files: " + bind.fileCheck.isChecked());
    Log.d("GlobalSearch", "Search folders: " + bind.folderCheck.isChecked());

    manager.search(
        searchRoot.getAbsolutePath(),
        query,
        bind.regexCheck.isChecked(),
        bind.caseCheck.isChecked(),
        bind.fileCheck.isChecked(),
        bind.folderCheck.isChecked(),
        bind.hiddenCheck.isChecked(),
        new SearchListener() {
          @Override
          public void onSearchStarted() {
            Log.d("GlobalSearch", "Search started");
          }

          @Override
          public void onProgress(int current, int total) {
            if (getActivity() != null) {
              getActivity()
                  .runOnUiThread(
                      () -> {
                        bind.progressBar.setMax(total);
                        bind.progressBar.setProgressCompat(current, false);
                        bind.progressText.setText(current + "/" + total);
                      });
            }
          }

          @Override
          public void onFileFound(HashMap<String, Object> file) {
            if (getActivity() != null) {
              getActivity()
                  .runOnUiThread(
                      () -> {
                        String filePath = (String) file.get("path");
                        Log.d("GlobalSearch", "Found: " + filePath);
                        adapter.add(file);
                        bind.resultsText.setText(
                            getMarkDown(
                                adapter.getItemCount()
                                    + "_Results:_"
                                    + "## "
                                    + adapter.getItemCount()));
                      });
            }
          }

          @Override
          public void onSearchCompleted(List<HashMap<String, Object>> results) {
            if (getActivity() != null) {
              getActivity()
                  .runOnUiThread(
                      () -> {
                        setSearching(false);
                        Log.d(
                            "GlobalSearch",
                            "Search completed. Found " + results.size() + " results");

                        if (results.isEmpty()) {
                          showMarkdownMessage("_No data found_");
                        } else {
                          bind.resultsText.setText(
                              getMarkDown("_Result count:_ " + results.size()));
                        }
                      });
            }
          }

          @Override
          public void onError(String error) {
            if (getActivity() != null) {
              getActivity()
                  .runOnUiThread(
                      () -> {
                        setSearching(false);
                        Log.e("GlobalSearch", "Error: " + error);
                        showMarkdownMessage(error + "_Error in search:_ " + error);
                        bind.resultsText.setText(getMarkDown("_Error searching..._"));
                      });
            }
          }
        });
  }

  private void stopSearch() {
    if (manager != null) {
      manager.stop();
      setSearching(false);
      bind.resultsText.setText(getMarkDown("_Search stopped!_"));
      showMarkdownMessage("_Search stopped_");
    }
  }

  private void setSearching(boolean searching) {
    bind.searchButton.setEnabled(!searching);
    bind.stopButton.setEnabled(searching);
    bind.stopButton.setVisibility(searching ? View.VISIBLE : View.GONE);
    bind.progressBar.setVisibility(searching ? View.VISIBLE : View.GONE);
    bind.progressText.setVisibility(searching ? View.VISIBLE : View.GONE);

    bind.searchInput.setEnabled(!searching);
    bind.regexCheck.setEnabled(!searching);
    bind.caseCheck.setEnabled(!searching && !bind.regexCheck.isChecked());
    bind.fileCheck.setEnabled(!searching);
    bind.folderCheck.setEnabled(!searching);
    bind.hiddenCheck.setEnabled(!searching);
  }

  public void setOnItemClickListener(OnItemClickListener listener) {
    this.itemClickListener = listener;
  }

  private void showMarkdownMessage(String markdownText) {
    Snackbar.make(bind.getRoot(), getMarkDown(markdownText), Snackbar.LENGTH_SHORT).show();
  }

  private CharSequence getMarkDown(String code) {
    var md = Markwon.builder(getContext()).usePlugin(HtmlPlugin.create()).build();
    return md.toMarkdown(code);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    if (manager != null) {
      manager.destroy();
    }
  }

  public String getPathInput() {
    return this.pathInput;
  }

  public void setPathInput(String pathInput) {
    this.pathInput = pathInput;
  }

  private class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<HashMap<String, Object>> items = new ArrayList<>();
    private int icon = android.R.drawable.ic_menu_search;
    private String searchQuery = "";
    private boolean isRegexMode = false;
    private boolean isCaseSensitive = false;

    class ViewHolder extends RecyclerView.ViewHolder {
      ImageView icon;
      TextView name;
      TextView path;

      ViewHolder(View itemView) {
        super(itemView);
        icon = itemView.findViewById(R.id.item_icon);
        name = itemView.findViewById(R.id.item_name);
        path = itemView.findViewById(R.id.item_path);
      }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view =
          LayoutInflater.from(parent.getContext())
              .inflate(R.layout.item_search_result, parent, false);
      return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      HashMap<String, Object> item = items.get(position);
      String path = (String) item.get("path");
      String name = (String) item.get("name");

      if (icon != 0) holder.icon.setImageResource(icon);

      if (path.endsWith(".gif")) {
        Glide.with(holder.icon.getContext())
            .asGif()
            .load(path)
            .placeholder(icon)
            .centerCrop()
            .error(new ColorDrawable(Color.parseColor("#720110")))
            .into(holder.icon);
      } else if (getPath(path)) {
        Glide.with(holder.icon.getContext())
            .load(path)
            .placeholder(icon)
            .circleCrop()
            .error(new ColorDrawable(Color.parseColor("#720110")))
            .into(holder.icon);
      }

      holder.path.setText(path);
      setHighlightSearchText(holder.name, name, searchQuery);
      holder.itemView.setOnClickListener(
          v -> {
            if (itemClickListener != null) {
              itemClickListener.onItemClick(path);
            }
            dismiss();
          });
    }

    @Override
    public int getItemCount() {
      return items.size();
    }

    public void add(HashMap<String, Object> item) {
      items.add(item);
      notifyItemInserted(items.size() - 1);
    }

    public void clear() {
      items.clear();
      notifyDataSetChanged();
    }

    public int getIcon() {
      return icon;
    }

    public void setIcon(int icon) {
      this.icon = icon;
    }

    public void setSearchQuery(String query) {
      this.searchQuery = query;
    }

    public void setSearchMode(boolean regexMode, boolean caseSensitive) {
      this.isRegexMode = regexMode;
      this.isCaseSensitive = caseSensitive;
    }

    void setHighlightSearchText(TextView textView, String fullText, String searchText) {
      if (searchText.isEmpty()) {
        textView.setText(fullText);
        return;
      }

      textView.setTextColor(MaterialColors.getColor(textView, getColorOnSurface()));

      var spannableString = new SpannableString(fullText);
      int startPos = -1;
      int endPos = -1;

      if (isRegexMode) {
        try {
          int flags = isCaseSensitive ? 0 : Pattern.CASE_INSENSITIVE;
          Pattern pattern = Pattern.compile(searchText, flags);
          Matcher matcher = pattern.matcher(fullText);
          if (matcher.find()) {
            startPos = matcher.start();
            endPos = matcher.end();
          }
        } catch (Exception e) {
          textView.setText(fullText);
          return;
        }
      } else {
        if (isCaseSensitive) {
          startPos = fullText.indexOf(searchText);
        } else {
          startPos = fullText.toLowerCase().indexOf(searchText.toLowerCase());
        }
        endPos = startPos + searchText.length();
      }

      if (startPos != -1 && startPos < fullText.length()) {
        spannableString.setSpan(
            new ForegroundColorSpan(Color.BLACK),
            startPos,
            endPos,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(
            new BackgroundColorSpan(Color.parseColor("#FFFFE0B2")),
            startPos,
            endPos,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(
            new RelativeSizeSpan(0.95f),
            startPos,
            endPos,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
      }

      textView.setText(spannableString);
    }

    boolean getPath(String path) {
      List<String> extensions =
          Arrays.asList(
              ".png", ".jpg", ".jpeg", ".gif", ".bmp", ".tiff", ".tif", ".webp", ".svg", ".ico",
              ".heic", ".heif", ".raw", ".cr2", ".nef", ".arw", ".psd", ".ai", ".eps", ".mp4",
              ".avi", ".mov", ".wmv", ".flv", ".mkv", ".webm", ".m4v", ".mpg", ".mpeg", ".3gp",
              ".mts", ".m2ts", ".vob", ".ogv", ".divx", ".f4v", ".h264", ".264", ".hevc", ".265",
              ".rm", ".rmvb", ".asf", ".mxf");

      for (var ext : extensions) {
        if (path.endsWith(ext)) {
          return true;
        }
      }
      return false;
    }
  }

  int getColorOnSurface() {
    return com.google.android.material.R.attr.colorOnSurface;
  }
}
