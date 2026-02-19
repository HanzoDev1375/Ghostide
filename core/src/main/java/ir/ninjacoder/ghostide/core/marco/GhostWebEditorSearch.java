package ir.ninjacoder.ghostide.core.marco;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.databinding.LayoutSearcherBinding;
import ir.ninjacoder.ghostide.core.databinding.MakefolderBinding;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;
import io.github.rosemoe.sora.event.PublishSearchResultEvent;
import io.github.rosemoe.sora.widget.EditorSearcher;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.text.Content;
import io.github.rosemoe.sora.text.Cursor;

public class GhostWebEditorSearch extends LinearLayout {
  private LayoutSearcherBinding binding;
  private IdeEditor editor;
  protected onViewChange viewChange;
  public boolean isShowing = false;

  private boolean isRegexMode = false;
  private boolean isCaseSensitive = false;
  private boolean isWholeWord = false;
  
  private int currentMatchIndex = -1;
  private int totalMatches = 0;

  public GhostWebEditorSearch(Context context) {
    this(context, null);
  }

  public GhostWebEditorSearch(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public GhostWebEditorSearch(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    binding = LayoutSearcherBinding.inflate(LayoutInflater.from(getContext()));
    removeAllViews();
    addView(binding.getRoot(), new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

    setupTextWatcher();
    setupClickListeners();
    setupAnimations();
  }

  private void setupTextWatcher() {
    binding.searchText.addTextChangedListener(
        new TextWatcher() {
          @Override
          public void afterTextChanged(Editable editable) {
            if (editor == null) return;
            String text = binding.searchText.getText().toString();
            if (!text.isEmpty()) {
              performSearch(text);
            } else {
              stopSearch();
            }
          }

          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
  }

  private void setupClickListeners() {
    binding.btnMore.setOnClickListener(this::showPopupMenu);
    binding.gotoLast.setOnClickListener(v -> gotoPrevious());
    binding.gotoNext.setOnClickListener(v -> gotoNext());
    binding.replace.setOnClickListener(v -> replace());
    binding.btnClose.setOnClickListener(v -> showAndHide());
  }

  private void setupAnimations() {
    AnimUtils.Worker(binding.gotoLast);
    AnimUtils.Worker(binding.gotoNext);
    AnimUtils.Worker(binding.replace);
    AnimUtils.Worker(binding.btnClose);
    AnimUtils.Worker(binding.btnMore);
  }

  private void showPopupMenu(View view) {
    var popupMenu = new PopupMenu(getContext(), view);

    var regexItem = popupMenu.getMenu().add(0, 1, 0, "Regex Mode");
    var caseItem = popupMenu.getMenu().add(0, 2, 1, "Case Sensitive");
    var wordItem = popupMenu.getMenu().add(0, 3, 2, "Whole Word");

    regexItem.setCheckable(true).setChecked(isRegexMode);
    caseItem.setCheckable(true).setChecked(isCaseSensitive);
    wordItem.setCheckable(true).setChecked(isWholeWord);

    popupMenu.setOnMenuItemClickListener(
        item -> {
          int id = item.getItemId();

          if (id == 1) {
            isRegexMode = !isRegexMode;
            item.setChecked(isRegexMode);
            showToast("Regex mode " + (isRegexMode ? "enabled" : "disabled"));
            if (isRegexMode) {
              isWholeWord = false;
              wordItem.setChecked(false);
            }
          } else if (id == 2) {
            isCaseSensitive = !isCaseSensitive;
            item.setChecked(isCaseSensitive);
            showToast("Case sensitive " + (isCaseSensitive ? "enabled" : "disabled"));
          } else if (id == 3) {
            isWholeWord = !isWholeWord;
            item.setChecked(isWholeWord);
            showToast("Whole word " + (isWholeWord ? "enabled" : "disabled"));
            if (isWholeWord) {
              isRegexMode = false;
              regexItem.setChecked(false);
            }
          }

          String searchText = binding.searchText.getText().toString();
          if (!searchText.isEmpty()) {
            performSearch(searchText);
          }

          return true;
        });

    popupMenu.show();
  }

  private void showToast(String message) {
    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
  }

  public void bindEditor(@Nullable IdeEditor editor) {
    this.editor = editor;
    if (editor == null) return;

    editor.subscribeEvent(
        PublishSearchResultEvent.class,
        (event, unsubscribe) -> {
          post(this::updateSearchResultInfo);
        });
  }
  
  private void updateSearchResultInfo() {
    if (editor == null) return;
    
    try {
      var searcher = editor.getSearcher();
      if (searcher != null && searcher.hasQuery()) {
        totalMatches = searcher.getMatchedPositionCount();
        currentMatchIndex = searcher.getCurrentMatchedPositionIndex();
        
        if (totalMatches > 0) {
          String info;
          if (currentMatchIndex >= 0) {
            info = String.format("%d/%d", currentMatchIndex + 1, totalMatches);
          } else {
            info = totalMatches + " matches";
          }
          binding.searchText.setHint(info);
          
          binding.gotoNext.setEnabled(true);
          binding.gotoLast.setEnabled(true);
        } else {
          binding.searchText.setHint("No matches");
          binding.gotoNext.setEnabled(false);
          binding.gotoLast.setEnabled(false);
        }
      } else {
        binding.searchText.setHint("Search...");
        binding.gotoNext.setEnabled(true);
        binding.gotoLast.setEnabled(true);
        totalMatches = 0;
        currentMatchIndex = -1;
      }
    } catch (Exception e) {
      // خطا نادیده گرفته شود
    }
  }

  private int getSearchType() {
    if (isRegexMode) return EditorSearcher.SearchOptions.TYPE_REGULAR_EXPRESSION;
    if (isWholeWord) return EditorSearcher.SearchOptions.TYPE_WHOLE_WORD;
    return EditorSearcher.SearchOptions.TYPE_NORMAL;
  }

  private void performSearch(String text) {
    if (editor == null) return;

    if (text == null || text.isEmpty()) {
      stopSearch();
      return;
    }

    try {
      var searcher = editor.getSearcher();
      if (searcher == null) {
        showToast("Searcher not available");
        return;
      }

      int searchType = getSearchType();
      
      // caseSensitive = true یعنی حساس به بزرگی کوچکی
      // در SearchOptions، caseInsensitive = false یعنی حساس به بزرگی کوچکی
      var options = new EditorSearcher.SearchOptions(searchType, !isCaseSensitive);

      try {
        searcher.search(text, options);
      } catch (Exception e) {
        showToast("Invalid pattern: " + e.getMessage());
      }
      
    } catch (IllegalArgumentException e) {
      showToast("Invalid pattern: " + e.getMessage());
    } catch (Exception e) {
      showToast("Search error: " + e.getMessage());
    }
  }

  private void stopSearch() {
    try {
      if (editor != null && editor.getSearcher() != null) {
        editor.getSearcher().stopSearch();
      }
    } catch (Exception e) {
      // خطا نادیده گرفته شود
    }
    binding.searchText.setHint("Search...");
    binding.gotoNext.setEnabled(true);
    binding.gotoLast.setEnabled(true);
    totalMatches = 0;
    currentMatchIndex = -1;
  }

  public void showAndHide() {
    if (isShowing) {
      hide();
      if (viewChange != null) viewChange.onViewHide();
    } else {
      setVisibility(View.VISIBLE);
      isShowing = true;
      if (viewChange != null) viewChange.onViewShow();
      binding.searchText.requestFocus();
    }

    if (editor == null) return;
    stopSearch();
    binding.searchText.setText("");
  }

  public void hide() {
    setVisibility(View.GONE);
    isShowing = false;
  }

  private void gotoNext() {
    try {
      if (editor == null) {
        showToast("Editor not available");
        return;
      }

      var searcher = editor.getSearcher();
      if (searcher == null) {
        showToast("Searcher not available");
        return;
      }

      if (!searcher.hasQuery()) {
        showToast("No active search");
        return;
      }

      if (!searcher.isResultValid()) {
        showToast("Searching...");
        return;
      }

      boolean result = searcher.gotoNext();
      
      if (result) {
        updateSearchResultInfo();
      } else {
        showToast("No more matches");
        binding.gotoNext.setEnabled(false);
      }
      
    } catch (Exception e) {
      showToast("Error: " + e.getMessage());
    }
  }

  private void gotoPrevious() {
    try {
      if (editor == null) {
        showToast("Editor not available");
        return;
      }

      var searcher = editor.getSearcher();
      if (searcher == null) {
        showToast("Searcher not available");
        return;
      }

      if (!searcher.hasQuery()) {
        showToast("No active search");
        return;
      }

      if (!searcher.isResultValid()) {
        showToast("Searching...");
        return;
      }

      boolean result = searcher.gotoPrevious();
      
      if (result) {
        updateSearchResultInfo();
      } else {
        showToast("No more matches");
        binding.gotoLast.setEnabled(false);
      }
      
    } catch (Exception e) {
      showToast("Error: " + e.getMessage());
    }
  }

  private void replace() {
    if (editor == null) return;

    String searchText = binding.searchText.getText().toString();
    if (searchText.isEmpty()) {
      showToast("Search text is empty");
      return;
    }

    var bind = MakefolderBinding.inflate(LayoutInflater.from(getContext()));
    String dialogTitle = buildDialogTitle();

    new MaterialAlertDialogBuilder(getContext())
        .setTitle(dialogTitle)
        .setView(bind.getRoot())
        .setPositiveButton(
            "Replace",
            (c1, c2) -> {
              try {
                String replacement = bind.editor.getText().toString();
                var searcher = editor.getSearcher();
                
                if (searcher.isMatchedPositionSelected()) {
                  searcher.replaceCurrentMatch(replacement);
                  // بعد از جایگزینی، به نتیجه بعدی برو
                  editor.postDelayed(() -> {
                    searcher.gotoNext();
                    updateSearchResultInfo();
                  }, 100);
                } else {
                  showToast("No match selected");
                }
              } catch (Exception e) {
                showToast("Replace failed: " + e.getMessage());
              }
            })
        .setNeutralButton(android.R.string.cancel, null)
        .setNegativeButton(
            "Replace All",
            (f1, f2) -> {
              try {
                String replacement = bind.editor.getText().toString();
                editor.getSearcher().replaceAll(replacement, () -> post(() -> {
                  showToast("Replace all completed");
                  performSearch(searchText);
                }));
              } catch (Exception e) {
                showToast("Replace all failed: " + e.getMessage());
              }
            })
        .show();

    bind.top.setHint("Replacement");
  }

  private String buildDialogTitle() {
    String title = isRegexMode ? "Replace with Regex" : "Replace";
    if (isWholeWord) title += " (Whole Word)";
    if (isCaseSensitive) title += " (Case Sensitive)";
    return title;
  }

  public void setCallBack(onViewChange viewChange) {
    this.viewChange = viewChange;
  }

  public interface onViewChange {
    void onViewShow();
    void onViewHide();
  }
}