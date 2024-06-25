package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.databinding.DialogjavacodeviewDialogFragmentBinding;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class DialogJavaCodeViewDialogFragmentActivity extends DialogFragment {

  protected DialogjavacodeviewDialogFragmentBinding bin;
  private SharedPreferences sp;

  @NonNull
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup _container,
      @Nullable Bundle _savedInstanceState) {
    bin = DialogjavacodeviewDialogFragmentBinding.inflate(LayoutInflater.from(getContext()));
    bindid();
    reqApp();
    return bin.getRoot();
  }

  private void bindid() {

    sp = getContext().getSharedPreferences("sp", Activity.MODE_PRIVATE);

    bin.imageview1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            bin.editor.formatCodeAsync();
          }
        });

    bin.Fab.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            ((ClipboardManager)
                    getContext()
                        .getSystemService(getContext().getApplicationContext().CLIPBOARD_SERVICE))
                .setPrimaryClip(
                    ClipData.newPlainText("clipboard", bin.editor.getText().toString()));
            Toast.makeText(requireActivity(), "done", Toast.LENGTH_SHORT).show();
          }
        });
  }

  @SuppressLint("ClickableViewAccessibility")
  private void reqApp() {
    
    _clickAnimation(bin.editor);
    if (sp.contains("bin")) {
      bin.editor.setText(sp.getString("bin", ""));
    }

    bin.editor.getColorScheme().setColor(EditorColorScheme.OPERATOR, Color.parseColor("#ff869e"));
    bin.editor.getColorScheme().setColor(EditorColorScheme.BLOCK_LINE, Color.parseColor("#ff314d"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.BLOCK_LINE_CURRENT, Color.parseColor("#ff314d"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.NON_PRINTABLE_CHAR, Color.parseColor("#ffb9ffcb"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.CURRENT_LINE, Color.parseColor("#20171717"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.SELECTION_INSERT, Color.parseColor("#c06dff"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.SELECTION_HANDLE, Color.parseColor("#c06dff"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.LINE_NUMBER, Color.parseColor("#d9d9d9"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.LINE_DIVIDER, Color.parseColor("#FF2B2122"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.ATTRIBUTE_VALUE, Color.parseColor("#ffffdcb9"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.ATTRIBUTE_NAME, Color.parseColor("#FF1B4AD7"));
    bin.editor.getColorScheme().setColor(EditorColorScheme.HTML_TAG, Color.parseColor("#ff92dc"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.TEXT_NORMAL, Color.parseColor("#ffebffd7"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.IDENTIFIER_NAME, Color.parseColor("#626262"));
    bin.editor.getColorScheme().setColor(EditorColorScheme.COMMENT, Color.parseColor("#fff0be4b"));
    bin.editor.getColorScheme().setColor(EditorColorScheme.KEYWORD, Color.parseColor("#ffffa1a1"));
    bin.editor.getColorScheme().setColor(EditorColorScheme.print, Color.parseColor("#ffb4a1ff"));
    bin.editor.getColorScheme().setColor(EditorColorScheme.Ninja, Color.parseColor("#ffffac94"));
    bin.editor.getColorScheme().setColor(EditorColorScheme.LITERAL, Color.parseColor("#ffdea1ff"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.AUTO_COMP_PANEL_BG, Color.parseColor("#FF2B2122"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER, Color.parseColor("#ff94ffe7"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.LINE_NUMBER_BACKGROUND, Color.parseColor("#FF2B2122"));
    bin.editor
        .getColorScheme()
        .setColor(EditorColorScheme.WHOLE_BACKGROUND, Color.parseColor("#FF2B2122"));
    bin.Fab.setText("Copy code!");
    bin.pro.setVisibility(View.GONE);

    bin.editor.setEditable(false);
    bin.editor.setEditorLanguage(new JavaLanguage());
    ColorAndroid12.setColorFilter(bin.imageview1);
  }

  @Override
  public void onStart() {
    super.onStart();
    if (getDialog() != null) {
      int width = ViewGroup.LayoutParams.MATCH_PARENT;
      int height = ViewGroup.LayoutParams.MATCH_PARENT;
      getDialog().getWindow().setLayout(width, height);
      getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0xFF2B2122));
    }
  }

  public void _clickAnimation(final View _view) {
    ScaleAnimation fade_in =
        new ScaleAnimation(
            0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
    fade_in.setDuration(300);
    fade_in.setFillAfter(true);
    _view.startAnimation(fade_in);
  }
}
