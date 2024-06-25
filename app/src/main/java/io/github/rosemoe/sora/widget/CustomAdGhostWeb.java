package io.github.rosemoe.sora.widget;

import Ninja.coder.Ghostemane.code.utils.AnimUtils;
import android.text.Spannable;
import android.widget.*;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.*;
import io.github.rosemoe.sora.widget.TextSummry.HTMLConstants;
import Ninja.coder.Ghostemane.code.R;
import io.github.rosemoe.sora.data.CompletionItem;

@SuppressWarnings("CanBeFinal")
public class CustomAdGhostWeb extends EditorCompletionAdapter {
    protected HTMLConstants htmlconfig;
    protected TextView
            item_icon,
            item_label,
            item_desc,
            item_type;
    private io.github.rosemoe.sora.widget.TextSummry.TextUtils textUtils;

    public CustomAdGhostWeb() {
        htmlconfig = new HTMLConstants();
    }

    @Override
    public int getItemHeight() {
        // 45 dp

        return (int)
                TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 55, getContext().getResources().getDisplayMetrics());
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
        item_icon.setText(item.label.substring(0, 1));

        item_label.setTextColor(getThemeColor(EditorColorScheme.ATTRIBUTE_VALUE));
        item_desc.setTextColor(getThemeColor(EditorColorScheme.ATTRIBUTE_VALUE));
        item_icon.setTextColor(getThemeColor(EditorColorScheme.ATTRIBUTE_VALUE));
        item_type.setTextColor(getThemeColor(EditorColorScheme.ATTRIBUTE_VALUE));
        AnimUtils.Sacla(view);
        if (item.desc.equals(htmlconfig.HTMLTAG)) {
            item_desc.setText(HtmlHelper.code(label.toString()));
        } else if (item.desc.equals(htmlconfig.CssColor)) {
            item_desc.setTextColor(HtmlHelper.cssColor(label.toString()));
        } else if (item.desc.equals(htmlconfig.PhpKeys)) {
            item_desc.setText(HtmlHelper.getHelpPhp(item.label));
        } else {
            item_desc.setText(item.desc);
        }
        view.setTag(pos);
        return view;
    }
}
