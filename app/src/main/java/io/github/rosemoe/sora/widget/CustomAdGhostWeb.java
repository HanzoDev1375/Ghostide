package io.github.rosemoe.sora.widget;

import com.bumptech.glide.Glide;
import com.ninjacoder.jgit.CircleDrawable;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.utils.AnimUtils;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.widget.*;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.*;
import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;
import ir.ninjacoder.ghostide.R;
import io.github.rosemoe.sora.data.CompletionItem;

@SuppressWarnings("CanBeFinal")
public class CustomAdGhostWeb extends EditorCompletionAdapter {
  protected HTMLConstants htmlconfig;
  protected TextView item_label, item_desc, item_type;
  private ImageView item_icon;

  private io.github.rosemoe.sora.widget.TextSummry.TextUtils textUtils;

  public CustomAdGhostWeb() {
    htmlconfig = new HTMLConstants();
  }

  @Override
  public int getItemHeight() {
    // 45 dp

    return (int)
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 45, getContext().getResources().getDisplayMetrics());
  }

  @Override
  public View getView(int pos, View view, ViewGroup parent, boolean isCurrentCursorPosition) {
    if (view == null) {
      view = LayoutInflater.from(getContext()).inflate(R.layout.one_ui, parent, false);
    }
    CompletionItem item = getItem(pos);

    item_label = view.findViewById(R.id.item_label);
    item_desc = view.findViewById(R.id.item_desc);
    item_type = view.findViewById(R.id.item_type);
    item_icon = view.findViewById(R.id.item_icon);
    Spannable label =
        Spannable.Factory.getInstance().newSpannable(item.label != null ? item.label : "None");
    String prefix = getPrefix();
    int index = TextUtils.indexOf(item.label, prefix);
    if (index != -1) {
      label.setSpan(
          new ForegroundColorSpan(getThemeColor(EditorColorScheme.KEYWORD)),
          index,
          index + prefix.length(),
          Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    item_label.setText(label);
    item_type.setText(item.desc);
    item_desc.setText(item.commit);
    ///  item_icon.setText(item.label.substring(0, 1));
    item_icon.setPadding(9, 9, 9, 9);
    item_label.setTextColor(getThemeColor(EditorColorScheme.ATTRIBUTE_VALUE));
    item_desc.setTextColor(getThemeColor(EditorColorScheme.ATTRIBUTE_VALUE));
    //  item_icon.setTextColor(getThemeColor(EditorColorScheme.ATTRIBUTE_VALUE));
    item_type.setTextColor(getThemeColor(EditorColorScheme.ATTRIBUTE_VALUE));
    AnimUtils.Sacla(view);
    if (item.desc.equals(htmlconfig.HTMLTAG)) {
      item_desc.setText(HtmlHelper.code(label.toString()));
    } else if (item.desc.equals(htmlconfig.CssColor)) {
      item_desc.setTextColor(HtmlHelper.cssColor(label.toString()));
    } else if (item.desc.equals(htmlconfig.PhpKeys)) {
      item_desc.setText(HtmlHelper.getHelpPhp(item.label));
    } else if (item.desc.equals(htmlconfig.RandomColor)) {
      item_icon.setBackgroundColor(Color.parseColor(label.toString()));
    } else {
      item_desc.setText(item.desc);
    }
    var editor = getEditor();
    if (isImage(item.label)) {
      Glide.with(item_icon.getContext())
          .load(item.jdir)
          .circleCrop()
          .error(
              new CircleDrawable(
                  getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER), true, item.label))
          .into(item_icon);
    } else
      item_icon.setBackground(
          new CircleDrawable(
              getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER), true, item.label));
    view.setBackgroundColor(
        isCurrentCursorPosition
            ? getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER)
            : Color.TRANSPARENT);

    view.setTag(pos);
    return view;
  }

  private GradientDrawable colorSet(String col) {
    var i = new GradientDrawable();
    i.setColor(ColorStateList.valueOf(Color.parseColor(col)));
    i.setCornerRadius(15);
    return i;
  }

  private boolean isImage(String path) {
    return path.endsWith(".png")
        || path.endsWith(".svg")
        || path.endsWith(".jpg")
        || path.endsWith(".gif");
  }
}
