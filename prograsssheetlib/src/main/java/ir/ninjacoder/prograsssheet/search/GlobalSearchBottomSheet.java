package ir.ninjacoder.prograsssheet.search;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import ir.ninjacoder.prograsssheet.R;
import ir.ninjacoder.prograsssheet.search.interfaces.SearchListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GlobalSearchBottomSheet extends BottomSheetDialogFragment {

  public interface OnItemClickListener {
    void onItemClick(String filePath);
  }

  private EditText searchInput;
  private Button searchButton;
  private Button stopButton;
  private ProgressBar progressBar;
  private TextView progressText;
  private TextView resultsText;
  private RecyclerView recyclerView;
  private CheckBox regexCheck;
  private CheckBox caseCheck;
  private CheckBox fileCheck;
  private CheckBox folderCheck;
  private CheckBox hiddenCheck;
  private SearchAdapter adapter;
  private GlobalSearchManager manager;
  private OnItemClickListener itemClickListener;
  private String pathInput;

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.item_bottomsheet_search, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    searchInput = view.findViewById(R.id.search_input);
    searchButton = view.findViewById(R.id.search_button);
    stopButton = view.findViewById(R.id.stop_button);
    progressBar = view.findViewById(R.id.progress_bar);
    progressText = view.findViewById(R.id.progress_text);
    resultsText = view.findViewById(R.id.results_text);
    recyclerView = view.findViewById(R.id.results_list);

    regexCheck = view.findViewById(R.id.regex_check);
    caseCheck = view.findViewById(R.id.case_check);
    fileCheck = view.findViewById(R.id.file_check);
    folderCheck = view.findViewById(R.id.folder_check);
    hiddenCheck = view.findViewById(R.id.hidden_check);

    adapter = new SearchAdapter();
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(adapter);

    // تنظیمات پیش‌فرض
    fileCheck.setChecked(true);
    folderCheck.setChecked(true);
    hiddenCheck.setChecked(false);

    // اگر pathInput تنظیم شده باشد، آن را در searchInput نمایش بده
    if (pathInput != null && !pathInput.isEmpty()) {
      searchInput.setText(pathInput);
    }

    searchButton.setOnClickListener(v -> startSearch());
    stopButton.setOnClickListener(v -> stopSearch());

    regexCheck.setOnCheckedChangeListener(
        (buttonView, isChecked) -> {
          caseCheck.setEnabled(!isChecked);
        });
  }

  public void setIcon(int icon) {
    adapter.setIcon(icon);
  }

  public int getIcon() {
    return adapter.getIcon();
  }

  private void startSearch() {
    String query = searchInput.getText().toString().trim();
    if (query.isEmpty()) {
      Toast.makeText(getContext(), "لطفاً عبارت جستجو را وارد کنید", Toast.LENGTH_SHORT).show();
      return;
    }

    adapter.clear();
    setSearching(true);
    resultsText.setText("در حال جستجو...");

    manager = new GlobalSearchManager();

    // تعیین مسیر ریشه جستجو
    File searchRoot;
    File initialFile = new File(pathInput);

    if (initialFile.exists()) {
      if (initialFile.isDirectory()) {
        searchRoot = initialFile;
      } else {
        searchRoot = initialFile.getParentFile();
        if (searchRoot == null) {
          Toast.makeText(getContext(), "مسیر نامعتبر است", Toast.LENGTH_SHORT).show();
          setSearching(false);
          return;
        }
      }
    } else {
      Toast.makeText(getContext(), "مسیر وجود ندارد", Toast.LENGTH_SHORT).show();
      setSearching(false);
      return;
    }

    Log.d("GlobalSearch", "Starting search in: " + searchRoot.getAbsolutePath());
    Log.d("GlobalSearch", "Query: " + query);
    Log.d("GlobalSearch", "Search files: " + fileCheck.isChecked());
    Log.d("GlobalSearch", "Search folders: " + folderCheck.isChecked());

    // اجرای جستجو
    manager.search(
        searchRoot.getAbsolutePath(),
        query,
        regexCheck.isChecked(),
        caseCheck.isChecked(),
        fileCheck.isChecked(),
        folderCheck.isChecked(),
        hiddenCheck.isChecked(),
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
                        progressBar.setMax(total);
                        progressBar.setProgress(current);
                        progressText.setText(current + "/" + total);
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
                        resultsText.setText("نتایج: " + adapter.getItemCount());
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
                          Toast.makeText(getContext(), "نتیجه‌ای یافت نشد", Toast.LENGTH_SHORT)
                              .show();
                          resultsText.setText("نتیجه‌ای یافت نشد");
                        } else {
                          resultsText.setText("تعداد نتایج: " + results.size());
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
                        Toast.makeText(getContext(), "خطا: " + error, Toast.LENGTH_LONG).show();
                        resultsText.setText("خطا در جستجو");
                      });
            }
          }
        });
  }

  private void stopSearch() {
    if (manager != null) {
      manager.stop();
      setSearching(false);
      resultsText.setText("جستجو متوقف شد");
      Toast.makeText(getContext(), "جستجو متوقف شد", Toast.LENGTH_SHORT).show();
    }
  }

  private void setSearching(boolean searching) {
    searchButton.setEnabled(!searching);
    stopButton.setEnabled(searching);
    stopButton.setVisibility(searching ? View.VISIBLE : View.GONE);
    progressBar.setVisibility(searching ? View.VISIBLE : View.GONE);
    progressText.setVisibility(searching ? View.VISIBLE : View.GONE);

    searchInput.setEnabled(!searching);
    regexCheck.setEnabled(!searching);
    caseCheck.setEnabled(!searching && !regexCheck.isChecked());
    fileCheck.setEnabled(!searching);
    folderCheck.setEnabled(!searching);
    hiddenCheck.setEnabled(!searching);
  }

  public void setOnItemClickListener(OnItemClickListener listener) {
    this.itemClickListener = listener;
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    if (manager != null) {
      manager.destroy();
    }
  }

  // Getter و Setter برای pathInput
  public String getPathInput() {
    return this.pathInput;
  }

  public void setPathInput(String pathInput) {
    this.pathInput = pathInput;
    // اگر view ایجاد شده، searchInput را هم آپدیت کن
    if (searchInput != null && pathInput != null) {
      searchInput.setText(pathInput);
    }
  }

  private class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<HashMap<String, Object>> items = new ArrayList<>();
    private int icon = android.R.drawable.ic_menu_search;

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
      boolean isDirectory = (boolean) item.getOrDefault("isDirectory", false);

      holder.icon.setImageResource(icon);

      holder.name.setText(name);
      holder.path.setText(path);

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
  }
}
