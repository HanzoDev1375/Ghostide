package ir.ninjacoder.ghostide.markdown;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.html.HtmlTag;
import io.noties.markwon.html.tag.SimpleTagHandler;
import java.util.Collection;
import android.text.TextUtils;
import io.noties.markwon.html.CssInlineStyleParser;
import io.noties.markwon.html.CssProperty;
import android.graphics.Color;
import java.util.List;
import java.util.ArrayList;
import android.text.style.ForegroundColorSpan;
import android.text.style.BackgroundColorSpan;
import java.util.Collections;

// توجه این کد من نیست اما من رفع باگ و بهتر از نسخه اصلیش کردم

public class SpanTagHandler extends SimpleTagHandler {

  @Nullable
  @Override
  public Object getSpans(
      @NonNull MarkwonConfiguration configuration,
      @NonNull RenderProps renderProps,
      @NonNull HtmlTag tag) {
    final String style = tag.attributes().get("style");
    if (TextUtils.isEmpty(style)) {
      return null;
    }

    int color = 0;
    int backgroundColor = 0;
    int bordercolor = 0;
    for (CssProperty property : CssInlineStyleParser.create().parse(style)) {
      switch (property.key()) {
        case "color":
          color = Color.parseColor(property.value());
          break;

        case "background-color":
          backgroundColor = Color.parseColor(property.value());
          break;
        case "border-color":
          bordercolor = Color.parseColor(property.value());
          break;
        default:
          Log.e("unexpected CSS property: %s", property.toString());
      }
    }

    final List<Object> spans = new ArrayList<>(3);

    if (color != 0) {
      spans.add(new ForegroundColorSpan(color));
    }
    if (backgroundColor != 0) {
      spans.add(new BackgroundColorSpan(backgroundColor));
    }
    if (bordercolor != 0) {
      spans.add(new BackgroundColorSpan(bordercolor));
    }

    return spans.toArray();
  }

  @NonNull
  @Override
  public Collection<String> supportedTags() {
    return Collections.singleton("span");
  }
}
