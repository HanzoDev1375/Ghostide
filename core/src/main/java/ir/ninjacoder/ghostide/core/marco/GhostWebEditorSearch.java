package ir.ninjacoder.ghostide.core.marco;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.switchmaterial.SwitchMaterial;
import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.databinding.LayoutSearcherBinding;
import ir.ninjacoder.ghostide.core.databinding.MakefolderBinding;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;
import io.github.rosemoe.sora.event.PublishSearchResultEvent;

public class GhostWebEditorSearch extends LinearLayout {
  private LayoutSearcherBinding binding;
  private IdeEditor editor;
  protected onViewChange viewChange;
  public boolean isShowing = false;
  private boolean isRegexMode = false;

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
    addView(
        binding.getRoot(), new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

    binding.searchText.addTextChangedListener(
        new TextWatcher() {
          @Override
          public void afterTextChanged(Editable editable) {
            if (editor == null) return;
            performSearch(binding.searchText.getText().toString());
          }

          @Override
          public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

          @Override
          public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
        });

    binding.btnMore.setOnClickListener(this::showPopupMenu);
    binding.gotoLast.setOnClickListener((v) -> gotoLast());
    binding.gotoNext.setOnClickListener((v) -> gotoNext());
    binding.replace.setOnClickListener((v) -> replace());
    binding.btnClose.setOnClickListener((v) -> showAndHide());

    // انیمیشن
    AnimUtils.Worker(binding.gotoLast);
    AnimUtils.Worker(binding.gotoNext);
    AnimUtils.Worker(binding.replace);
    AnimUtils.Worker(binding.btnClose);
    AnimUtils.Worker(binding.btnMore);
  }

  private void showPopupMenu(View view) {
    PopupMenu popupMenu = new PopupMenu(getContext(), view);
    popupMenu.getMenu().add(0, 1, 0, "Regex Mode");

    MenuItem item = popupMenu.getMenu().findItem(1);
    SwitchMaterial switchView = new SwitchMaterial(getContext());
    switchView.setChecked(isRegexMode);
    switchView.setText("Regex Mode");

    item.setActionView(switchView);
    item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

    switchView.setOnCheckedChangeListener(
        (buttonView, isChecked) -> {
          isRegexMode = isChecked;
          String searchText = binding.searchText.getText().toString();
          if (!searchText.isEmpty()) {
            performSearch(searchText);
          }
          Toast.makeText(
                  getContext(),
                  "Regex mode " + (isChecked ? "enabled" : "disabled"),
                  Toast.LENGTH_SHORT)
              .show();
          popupMenu.dismiss();
        });

    popupMenu.show();
  }

  public void bindEditor(@Nullable IdeEditor editor) {
    this.editor = editor;
    if (editor != null) {
      editor.subscribeEvent(
          PublishSearchResultEvent.class,
          (event, unsubscribe) -> {
            post(
                () -> {
                  int count = event.getMatchCount();
                  if (count > 0) {
                    binding.searchText.setHint("Found " + count + " matches");
                    binding.gotoNext.setText("Next " + count);
                  } else {
                    binding.searchText.setHint("No matches found");
                  }
                });
          });
    }
  }

  private void performSearch(String text) {
    if (editor == null) return;

    if (text.isEmpty()) {
      editor.getSearcher().stopSearch();
      binding.searchText.setHint("Search...");
      return;
    }

    if (isRegexMode) {
      editor.getSearcher().searchWithRegex(text);
    } else {
      editor.getSearcher().search(text);
    }
  }

  public void showAndHide() {
    if (isShowing) {
      hide();
      if (viewChange != null) viewChange.onViewHide();
    } else {
      setVisibility(View.VISIBLE);
      isShowing = true;
      if (viewChange != null) viewChange.onViewShow();
    }
    if (editor == null) return;

    editor.getSearcher().stopSearch();
    binding.searchText.setText("");
    binding.searchText.setHint("Search...");
  }

  public void hide() {
    setVisibility(View.GONE);
    isShowing = false;
  }

  private void gotoNext() {
    try {
      if (editor == null) return;

      if (isRegexMode) {
        editor.getSearcher().gotoNextWithRegex();
      } else {
        editor.getSearcher().gotoNext();
      }
    } catch (IllegalStateException e) {
      e.printStackTrace();
      Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }
  }

  private void gotoLast() {
    try {
      if (editor == null) return;

      if (isRegexMode) {
        editor.getSearcher().gotoLastWithRegex();
      } else {
        editor.getSearcher().gotoLast();
      }
    } catch (IllegalStateException e) {
      e.printStackTrace();
      Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }
  }

  private void replace() {
    if (editor == null) return;

    if (!binding.searchText.getText().toString().isEmpty()) {
      MakefolderBinding bind = MakefolderBinding.inflate(LayoutInflater.from(getContext()));

      String dialogTitle = isRegexMode ? "Replace with Regex" : "Replace";

      new MaterialAlertDialogBuilder(getContext())
          .setTitle(dialogTitle)
          .setView(bind.getRoot())
          .setPositiveButton(
              "Replace",
              (c1, c2) -> {
                if (isRegexMode) {
                  gotoNextWithRegex();
                  editor.getSearcher().replaceThisWithRegex(bind.editor.getText().toString());
                } else {
                  gotoNext();
                  editor.getSearcher().replaceThis(bind.editor.getText().toString());
                }
              })
          .setNeutralButton(android.R.string.cancel, null)
          .setNegativeButton(
              "Replace All",
              (f1, f2) -> {
                if (isRegexMode) {
                  editor.getSearcher().replaceAllWithRegex(bind.editor.getText().toString());
                } else {
                  editor.getSearcher().replaceAll(bind.editor.getText().toString());
                }
              })
          .show();
      bind.top.setHint("Replacement");
    } else {
      Toast.makeText(getContext(), "Search text is empty", Toast.LENGTH_SHORT).show();
    }
  }

  private void gotoNextWithRegex() {
    if (editor == null) return;
    try {
      editor.getSearcher().gotoNextWithRegex();
    } catch (IllegalStateException e) {
      e.printStackTrace();
    }
  }

  public void setCallBack(onViewChange viewChange) {
    this.viewChange = viewChange;
  }

  public interface onViewChange {
    void onViewShow();

    void onViewHide();
  }
}
