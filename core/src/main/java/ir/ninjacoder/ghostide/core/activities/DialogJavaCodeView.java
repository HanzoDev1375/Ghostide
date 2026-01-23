package ir.ninjacoder.ghostide.core.activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.blankj.utilcode.util.ClipboardUtils;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import java.io.StringReader;
import java.util.HashMap;
import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.core.databinding.DialogjavacodeviewDialogFragmentBinding;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import ir.ninjacoder.ghostide.core.utils.ThemeUtils;

public class DialogJavaCodeView extends DialogFragment {

  protected DialogjavacodeviewDialogFragmentBinding bin;

  @NonNull
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle _savedInstanceState) {
    bin =
        DialogjavacodeviewDialogFragmentBinding.inflate(
            LayoutInflater.from(getContext()), container, false);
    bindid();
    reqApp();
    return bin.getRoot();
  }

  private void bindid() {
    bin.imageview1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            bin.editor.formatCodeAsync();
          }
        });
    bin.Fab.setOnClickListener(
        v -> {
          ClipboardUtils.copyText(bin.editor.getTextAsString());
          DataUtil.showMessage(requireActivity(), "Done!");
        });
  }

  @SuppressLint("ClickableViewAccessibility")
  private void reqApp() {
    bin.editor.setText(getArguments().getString("code", "Empty"));
    try {
      var theme = new ThemeUtils();
      HashMap<String,Object> map = new HashMap<>();
      map =
          new Gson()
              .fromJson(
                  new StringReader(ThemeUtils.themeAsString()),
                  new TypeToken<HashMap<String, Object>>() {}.getType());

      theme.setThemeCodeEditor((CodeEditor) bin.editor, map, false, requireActivity());
    } catch (Exception err) {
      DataUtil.showMessage(requireActivity(), err.getMessage());
    }
    bin.Fab.setText("Copy code!");
    bin.pro.setVisibility(View.GONE);
    bin.editor.setEditable(false);
    ObjectUtils.setColorFilter(bin.imageview1);
  }

  @Override
  public void onStart() {
    super.onStart();
    if (getDialog() != null) {
      int width = ViewGroup.LayoutParams.MATCH_PARENT;
      int height = ViewGroup.LayoutParams.MATCH_PARENT;
      getDialog().getWindow().setLayout(width, height);
      getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
    }
  }
}
