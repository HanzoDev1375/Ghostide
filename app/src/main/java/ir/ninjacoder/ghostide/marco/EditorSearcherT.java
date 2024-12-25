package ir.ninjacoder.ghostide.marco;

import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.blankj.utilcode.util.KeyboardUtils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.color.MaterialColors;

public class EditorSearcherT {

  public static void show(IdeEditor editor, View views, String txt) {

    var popupView =
        LayoutInflater.from(views.getContext()).inflate(R.layout.new_layoutsearch, null, false);
    PopupWindow popup =
        new PopupWindow(
            popupView,
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true);
    popup.showAtLocation(views, Gravity.CENTER, 0, 0);

    popupView.setPadding(3, 3, 3, 3);

    popup.setContentView(popupView);

    EditText etSearch = popupView.findViewById(R.id.search_text);
    MaterialButton close = popupView.findViewById(R.id.close);
    MaterialButton next = popupView.findViewById(R.id.goto_next);
    MaterialButton last = popupView.findViewById(R.id.goto_last);
    EditText replaceEt = popupView.findViewById(R.id.replace_text);
    MaterialButton replaceThis = popupView.findViewById(R.id.replace);
    MaterialButton replaceAll = popupView.findViewById(R.id.replace_all);

    next.setOnClickListener(view -> editor.getSearcher().gotoNext());
    last.setOnClickListener(view -> editor.getSearcher().gotoLast());
    etSearch.setText(txt);
    

    replaceThis.setOnClickListener(
        view -> {
          popup.dismiss();
          editor.getSearcher().replaceThis(replaceEt.getText().toString());
        });

    replaceAll.setOnClickListener(
        view -> {
          popup.dismiss();
          editor.getSearcher().replaceAll(replaceEt.getText().toString());
        });

    close.setOnClickListener(view -> popup.dismiss());

    GradientDrawable backgroundDrawable = new GradientDrawable();
    backgroundDrawable.setColor(MaterialColors.getColor(popupView, ObjectUtils.Back, 0));
    backgroundDrawable.setStroke(
        1, MaterialColors.getColor(popupView, ObjectUtils.colorOnSurface, 0));
    popupView.setBackground(backgroundDrawable);

    etSearch.addTextChangedListener(
        new TextWatcher() {
          @Override
          public void afterTextChanged(Editable s) {}

          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (editor != null) {
              if (etSearch.getText().toString().isEmpty()) {
                editor.getSearcher().stopSearch();
              } else {
                editor.getSearcher().search(etSearch.getText().toString());
              }
            }
          }
        });
  }

  public static void show(IdeEditor editor, View views) {
    show(editor, views, "");
  }
}
