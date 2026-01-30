package io.github.rosemoe.sora.widget;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ninjacoder.jgit.CircleDrawable;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;
import ir.ninjacoder.ghostide.core.databinding.OneUiBinding;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;

/**
 * @param class by ninja coder my ghost ide
 */
public class CustomAdGhostWeb extends EditorCompletionAdapter {
  protected HTMLConstants htmlconfig;
  protected TextView item_label, item_desc, item_type;
  private ImageView item_icon;
  private OneUiBinding bind;
  private io.github.rosemoe.sora.widget.TextSummry.TextUtils textUtils;

  public CustomAdGhostWeb() {
    htmlconfig = new HTMLConstants();
  }

  @Override
  public int getItemHeight() {

    return (int)
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 45, getContext().getResources().getDisplayMetrics());
  }

  @Override
  public View getView(int pos, View views, ViewGroup parent, boolean isCurrentCursorPosition) {
    CompletionItem item = getItem(pos);
    View view = views;
    if (view == null) {
      bind = OneUiBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
      view = bind.getRoot();
      view.setTag(bind);
    } else {
      bind = (OneUiBinding) view.getTag();
    }
    item_label = bind.itemLabel;
    item_desc = bind.itemDesc;
    item_type = bind.itemType;
    item_icon = bind.itemIcon;
    Spannable label =
        Spannable.Factory.getInstance().newSpannable(item.label != null ? item.label : "None");
    String prefix = getPrefix();
    if (prefix != null && !prefix.isEmpty()) {
      String userFilter;
      if (prefix.contains(".")) {
        userFilter = prefix.substring(prefix.lastIndexOf('.') + 1);
      } else if (prefix.contains("/")) {
        userFilter = prefix.substring(prefix.lastIndexOf('/') + 1);
      } else {
        userFilter = prefix;
      }
      setStrikeThrough(item_label, item.getDeprecated());
      int index = TextUtils.indexOf(item.label, userFilter);
      if (index != -1) {
        label.setSpan(
            new ForegroundColorSpan(getThemeColor(EditorColorScheme.KEYWORD)),
            index,
            index + userFilter.length(),
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        label.setSpan(
            new StyleSpan(Typeface.BOLD_ITALIC),
            index,
            index + userFilter.length(),
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
      }
    }
    item_label.setText(label);
    item_type.setText(item.desc);
    item_desc.setText(item.commit);
    item_icon.setPadding(9, 9, 9, 9);
    item_label.setTextColor(getThemeColor(EditorColorScheme.ATTRIBUTE_VALUE));
    item_desc.setTextColor(getThemeColor(EditorColorScheme.ATTRIBUTE_VALUE));
    item_type.setTextColor(getThemeColor(EditorColorScheme.ATTRIBUTE_VALUE));
    AnimUtils.Sacla(view);

    if (item.desc.equals(htmlconfig.HTMLTAG)) {
      item_desc.setText(HtmlHelper.code(label.toString()));
    } else if (item.desc.equals(htmlconfig.CssColor)) {
      item_desc.setTextColor(HtmlHelper.cssColor(label.toString()));
    } else if (item.desc.equals(htmlconfig.PhpKeys)) {
      item_desc.setText(HtmlHelper.getHelpPhp(item.label));
    }

    int iconColor = getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER);
    item.setBackground(iconColor);

    boolean isRandomColor = item.desc.equals(htmlconfig.RandomColor);
    if (isRandomColor) {
      try {
        iconColor = Color.parseColor(label.toString());
      } catch (Exception e) {
        iconColor = getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER);
      }
    }

    if (isImage(item.label)) {

      Glide.with(item_icon.getContext())
          .load(item.jdir)
          .circleCrop()
          .error(new CircleDrawable(iconColor, true, item.label))
          .into(item_icon);
    } else if (isRandomColor) {
      item_icon.setBackgroundColor(iconColor);
    } else if (item.desc.equals(htmlconfig.CssColor)) {
      item_icon.setBackground(
          new CircleDrawable(HtmlHelper.cssColor(label.toString()), true, item.label));
    } else {
      item_icon.setBackground(new CircleDrawable(iconColor, true, item.label));
    }

    return bind.getRoot();
  }

  private GradientDrawable colorSet(String col) {
    var i = new GradientDrawable();
    i.setColor(ColorStateList.valueOf(Color.parseColor(col)));
    i.setCornerRadius(30);
    return i;
  }

  private boolean isImage(String path) {
    return path.endsWith(".png")
        || path.endsWith(".svg")
        || path.endsWith(".jpg")
        || path.endsWith(".gif");
  }

  void setStrikeThrough(TextView textView, boolean strikeThrough) {
    if (strikeThrough) {
      textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    } else {
      textView.setPaintFlags(textView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
    }
  }
}
