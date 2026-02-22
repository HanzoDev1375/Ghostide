package com.ninjacoder.jgit.search;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.android.material.shape.ShapeAppearanceModel;
import static com.google.android.material.R.*;
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
    setShowAvatar(false);
    setHint(getMarkdowntext("**Search File...**"));
    binding.etSearch.addTextChangedListener(this);
    binding.btnClear.setVisibility(View.INVISIBLE);
    clear();
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
          animChange(binding.btnClear, false);
        });
  }

  void animChange(View v, boolean show) {
    if (show) {
      v.animate()
          .scaleX(1)
          .scaleY(1)
          .alpha(1)
          .setDuration(500)
          .withStartAction(() -> v.setVisibility(View.VISIBLE)) // StartAction
          .start();
    } else {
      v.animate()
          .scaleX(0)
          .scaleY(0)
          .alpha(0)
          .setDuration(500)
          .withEndAction(() -> v.setVisibility(View.INVISIBLE))
          .start();
    }
  }

  /**
   * @param #showAvatarUser
   */
  public void setShowAvatar(boolean show) {
    this.showAvatar = show;
    animChange(binding.imgAvatar, show ? true : false);
  }

  public void setAvatarOnClickListener(View.OnClickListener c) {
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
    animChange(binding.btnClear, s.length() > 0 ? true : false);
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
    if (getVisibility() == VISIBLE) return;

    setAlpha(0f);
    setScaleX(0.8f);
    setScaleY(0.8f);
    setVisibility(VISIBLE);

    animate()
        .alpha(1f)
        .scaleX(1f)
        .scaleY(1f)
        .setDuration(500)
        .setInterpolator(new OvershootInterpolator())
        .start();
  }

  public void hide() {
    if (getVisibility() != VISIBLE) return;

    animate()
        .alpha(0f)
        .scaleX(0.5f)
        .scaleY(0.5f)
        .setDuration(400)
        .setInterpolator(new AccelerateInterpolator())
        .withEndAction(
            () -> {
              setVisibility(GONE);
              setAlpha(1f);
              setScaleX(1f);
              setScaleY(1f);
            })
        .start();
  }
}
