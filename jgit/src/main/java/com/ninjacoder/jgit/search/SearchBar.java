package com.ninjacoder.jgit.search;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import static com.google.android.material.R.*;
import com.ninjacoder.jgit.databinding.LayoutSearchsBinding;

public class SearchBar extends FrameLayout implements TextWatcher {

  private LayoutSearchsBinding binding;
  private boolean showAvatar = true;
  private int background;
  private SearchCallBack call;

  public SearchBar(Context context) {
    super(context);
    init();
  }

  public SearchBar(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  private void init() {
    binding = LayoutSearchsBinding.inflate(LayoutInflater.from(getContext()), this, true);
    float radius = 20;
    background = attr.colorSurfaceContainerHigh;
    ShapeAppearanceModel shape = ShapeAppearanceModel.builder().setAllCornerSizes(radius).build();
    MaterialShapeDrawable bg = new MaterialShapeDrawable(shape);
	bg.setCornerSize(17);
    bg.setFillColor(MaterialColors.getColorStateListOrNull(getContext(), background));
    setBackground(bg);
    setShowAvatar(false);
	setHint("Search File ...");
    binding.etSearch.addTextChangedListener(this);
    binding.btnClear.setVisibility(View.INVISIBLE);
    binding.btnClear.setOnClickListener(v -> binding.etSearch.setText(""));
  }

  public void setHint(CharSequence hint) {
    binding.etSearch.setHint(hint);
  }

  public void setText(CharSequence text) {
    binding.etSearch.setText(text);
  }

  public CharSequence getText() {
    return binding.etSearch.getText();
  }

  public void setShowAvatar(boolean show) {
    this.showAvatar = show;
    binding.imgAvatar.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
  }

  public void setAvatarOnClick(View.OnClickListener c) {
    binding.imgAvatar.setOnClickListener(c);
  }

  @Override
  public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

  @Override
  public void onTextChanged(CharSequence s, int start, int before, int count) {
	  call.onTextChange(s.toString());
  }

  @Override
  public void afterTextChanged(Editable s) {
    call.onafterTextChanged(s,s.toString());
    binding.btnClear.setVisibility(s.length() > 0 ? View.VISIBLE : View.INVISIBLE);
  }


  public void setCallBack(SearchCallBack call) {
    this.call = call;
  }
}
