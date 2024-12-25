package ir.ninjacoder.ghostide.marco;

import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.databinding.LayoutSearcherBinding;
import ir.ninjacoder.ghostide.databinding.MakefolderBinding;
import ir.ninjacoder.ghostide.utils.AnimUtils;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;


public class GhostWebEditorSearch extends LinearLayout {
  private LayoutSearcherBinding binding;

  private IdeEditor editor;
  protected onViewChange viewChange;

  public boolean isShowing = false;

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
            if (editor == null) {
              return;
            }
            search(binding.searchText.getText().toString());
          }

          @Override
          public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

          @Override
          public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
        });

    binding.gotoLast.setOnClickListener(
        (v) -> {
          gotoLast();
        });

    binding.gotoNext.setOnClickListener(
        (v) -> {
          gotoNext();
        });

    binding.replace.setOnClickListener(
        (v) -> {
          replace();
        });
    binding.btnClose.setOnClickListener((v) -> showAndHide());
    AnimUtils.Worker(binding.gotoLast);
    AnimUtils.Worker(binding.gotoNext);
    AnimUtils.Worker(binding.replace);
    AnimUtils.Worker(binding.btnClose);
  }

  public void bindEditor(@Nullable IdeEditor editor) {
    this.editor = editor;
    
  }

  public void showAndHide() {
    if (isShowing) {
      hide();
      viewChange.onViewHide();
    } else {
      setVisibility(View.VISIBLE);
      isShowing = true;
      viewChange.onViewShow();
    }
    if (editor == null) {
      return;
    }
    editor.getSearcher().stopSearch();

    binding.searchText.setText("");
  }

  public void hide() {
    setVisibility(View.GONE);
    isShowing = false;
  }

  private void search(String text) {
    if (!binding.searchText.getText().toString().isEmpty()) {
      editor.getSearcher().search(text);
    } else {
      editor.getSearcher().stopSearch();
    }
  }

  private void gotoLast() {
    try {
      //test regex
      editor.getSearcher().gotoLast();
    } catch (IllegalStateException e) {
      e.printStackTrace();
    }
  }

  private void gotoNext() {
    try {
      editor.getSearcher().gotoNext();
    } catch (IllegalStateException e) {
      e.printStackTrace();
    }
  }

  private void replace() {

    if (!binding.searchText.getText().toString().isEmpty()) {
      MakefolderBinding bind = MakefolderBinding.inflate(LayoutInflater.from(getContext()));
      new MaterialAlertDialogBuilder(getContext())
          .setTitle("Replace")
          .setView(bind.getRoot())
          .setPositiveButton(
              "replace",
              (c1, c2) -> {
                gotoNext();
                editor.getSearcher().replaceThis(bind.editor.getText().toString());
              })
          .setNeutralButton(android.R.string.cancel, null)
          .setNegativeButton(
              "replaceAll",
              (f1, f2) -> {
                editor.getSearcher().replaceAll(bind.editor.getText().toString());
              })
          .show();
      bind.top.setHint("Replcement");
    } else Toast.makeText(getContext(), "Searcher text replace isEmpty ", 1).show();
  }

  
  public void setCallBack(onViewChange viewChange){
    this.viewChange = viewChange;
  }
  public interface onViewChange{
    public void onViewShow();
    public void onViewHide();
  }
}
