package com.ninjacoder.jgit.search;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import static com.google.android.material.R.*;
import com.google.android.material.transition.platform.MaterialSharedAxis;
import com.ninjacoder.jgit.databinding.LayoutSearchsBinding;
import io.noties.markwon.Markwon;
import io.noties.markwon.html.HtmlPlugin;

public class SearchBar extends FrameLayout implements TextWatcher {
  @NonNull private LayoutSearchsBinding binding;
  private boolean showAvatar = true;
  private int background;
  @NonNull private SearchCallBack call;

  public SearchBar(@Nullable Context context) {
    super(context);
    init();
  }

  public SearchBar(@Nullable Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  private void init() {
    binding = LayoutSearchsBinding.inflate(LayoutInflater.from(getContext()), this, true);
    float radius = 20;
    background = attr.colorSurfaceContainerHigh;
    ShapeAppearanceModel shape = ShapeAppearanceModel.builder().setAllCornerSizes(radius).build();
    MaterialShapeDrawable bg = new MaterialShapeDrawable(shape);
    bg.setCornerSize(20);
    bg.setFillColor(MaterialColors.getColorStateListOrNull(getContext(), background));
    setBackground(bg);
    setShowAvatar(false);
    setHint(getMarkdowntext("**Search File...**"));
    binding.etSearch.addTextChangedListener(this);
    binding.btnClear.setVisibility(View.INVISIBLE);
  }

  public void setHint(@NonNull CharSequence hint) {
    binding.etSearch.setHint(getMarkdowntext(hint.toString()));
  }

  public void setText(@NonNull CharSequence texts) {
    binding.etSearch.setText(getMarkdowntext(texts.toString()));
  }

  /**
   * @param #getText
   */
  public CharSequence getText() {
    return binding.etSearch.getText();
  }

  /**
   * @param clear text
   */
  public void clear() {
    binding.btnClear.setOnClickListener(
        v -> {
          binding.etSearch.setText("");
          binding.btnClear.setVisibility(GONE);
        });
  }

  /**
   * @param #showAvatarUser
   */
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
    call.onafterTextChanged(s, s.toString());
    binding.btnClear.setVisibility(s.length() > 0 ? View.VISIBLE : View.INVISIBLE);
  }

  /**
   * @param setCallBack textChange
   */
  public void setCallBack(@NonNull SearchCallBack call) {
    this.call = call;
  }

  /**
   * @param add showAvatarByGlidePath
   */
  public void showAvatarByGlidePath(@NonNull String path) {
    Glide.with(binding.imgAvatar.getContext())
        .load(path)
        .circleCrop()
        .error(new ColorDrawable(Color.TRANSPARENT))
        .into(binding.imgAvatar);
  }

  /**
   * @param add showAvatarByGlideres
   */
  public void showAvatarByGlideRes(@NonNull int res) {
    Glide.with(binding.imgAvatar.getContext())
        .load(res)
        .circleCrop()
        .error(new ColorDrawable(Color.TRANSPARENT))
        .into(binding.imgAvatar);
  }

  private CharSequence getMarkdowntext(String code) {
    var markdown = Markwon.builder(getContext()).usePlugin(HtmlPlugin.create()).build();
    return markdown.toMarkdown(code);
  }

  public boolean isShow() {
    return getVisibility() == VISIBLE;
  }

  public void show() {
    Transition sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.Z, true);
    TransitionManager.beginDelayedTransition(this, sharedAxis);
    if (getVisibility() != VISIBLE) {
      setVisibility(VISIBLE);
    }
  }

  public void hide() {
    Transition sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.Z, false);
    TransitionManager.beginDelayedTransition(this, sharedAxis);
    if (getVisibility() == VISIBLE) {
      setVisibility(GONE);
    }
  }
}
