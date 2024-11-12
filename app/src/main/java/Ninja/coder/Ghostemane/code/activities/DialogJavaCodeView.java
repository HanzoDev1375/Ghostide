package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.databinding.DialogjavacodeviewDialogFragmentBinding;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.utils.ThemeUtils;
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
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class DialogJavaCodeView extends DialogFragment {

  protected DialogjavacodeviewDialogFragmentBinding bin;
  private SharedPreferences sp;
  private HashMap<String, Object> map ;

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

    try {
      var theme = new ThemeUtils();
      map = new HashMap<>();
      map =
          new Gson()
              .fromJson(
                  new StringReader(ThemeUtils.themeAsString()),
                  new TypeToken<HashMap<String, Object>>() {}.getType());

      theme.setThemeCodeEditor(bin.editor, map, false, requireActivity());
      theme.setFabColorHint(bin.Fab, map);
    } catch (Exception err) {

    }

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
