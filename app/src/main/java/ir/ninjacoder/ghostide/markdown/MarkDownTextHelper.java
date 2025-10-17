package ir.ninjacoder.ghostide.markdown;


import android.graphics.drawable.Animatable;
import android.widget.TextView;
import android.text.SpannableStringBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.Glide;
import android.graphics.Color;
import android.text.style.ForegroundColorSpan;
import android.text.Spanned;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import io.noties.markwon.image.AsyncDrawable;
import com.bumptech.glide.RequestBuilder;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.RequestListener;
import io.noties.markwon.Markwon;
import io.noties.markwon.ext.tasklist.TaskListPlugin;
import io.noties.markwon.html.HtmlPlugin;
import io.noties.markwon.image.ImagesPlugin;
import io.noties.markwon.image.glide.GlideImagesPlugin;
import io.noties.markwon.image.AsyncDrawableScheduler;
import io.noties.markwon.image.svg.SvgPictureMediaDecoder;
import io.noties.markwon.syntax.Prism4jTheme;
import io.noties.markwon.syntax.SyntaxHighlightPlugin;
import io.noties.prism4j.GrammarLocator;
import io.noties.prism4j.Prism4j;
import io.noties.prism4j.Prism4j.Grammar;
import ir.ninjacoder.ghostide.markdown.langs.*;
import ir.ninjacoder.ghostide.markdown.SpanTagHandler;
import java.util.HashSet;
import java.util.Set;
import androidx.annotation.*;
import io.noties.prism4j.annotations.PrismBundle;

@PrismBundle(includeAll = true)
public class MarkDownTextHelper {

  public static void handleMarkDown(TextView t, String md) {
    final Prism4j prism4j = new Prism4j(new MyGrammarLocator());
    var theme = new Theme();

    Markwon markwon =
        Markwon.builder(t.getContext())
            .usePlugin(
                ImagesPlugin.create(
                    it -> {
                      it.addMediaDecoder(SvgPictureMediaDecoder.create());
                    }))
            .usePlugin(HtmlPlugin.create(plugin -> plugin.addHandler(new SpanTagHandler())))
            .usePlugin(GlideImagesPlugin.create(new GifGlideStore(Glide.with(t.getContext()))))
            .usePlugin(TaskListPlugin.create(t.getContext()))
            .usePlugin(SyntaxHighlightPlugin.create(prism4j, theme))
            .build();

    AsyncDrawableScheduler.schedule(t);
    markwon.setMarkdown(t, md);
  }

  static class Theme implements Prism4jTheme {

    @Override
    public int background() {
      return Color.BLACK;
    }

    @Override
    public int textColor() {
      return Color.WHITE;
    }

    @Override
    public void apply(
        @NonNull String language,
        @NonNull Prism4j.Syntax syntax,
        @NonNull SpannableStringBuilder builder,
        int start,
        int end) {

      if (start < 0 || end <= start || end > builder.length()) {
        return;
      }

      int color;
      String type = syntax.type();

      switch (type) {
        case "property":
          color = Color.parseColor("#9CDCFE");
          break;
        case "string":
          color = Color.parseColor("#CE9178");
          break;
        case "number":
          color = Color.parseColor("#B5CEA8");
          break;
        case "boolean":
          color = Color.parseColor("#569CD6");
          break;
        case "null":
          color = Color.parseColor("#C586C0");
          break;
        case "punctuation":
          color = Color.parseColor("#D4D4D4");
          break;
        case "operator":
          color = Color.parseColor("#DCDCAA");
          break;
        case "keyword":
          color = Color.parseColor("#569CD6");
          break;
        case "comment":
          color = Color.parseColor("#6A9955");
          break;
        case "class-name":
          color = Color.parseColor("#4EC9B0");
          break;
        case "function":
          color = Color.parseColor("#DCDCAA");
          break;
        case "annotation":
          color = Color.parseColor("#C586C0");
          break;
        case "tag":
          color = Color.parseColor("#569CD6");
          break;
        case "attr-name":
          color = Color.parseColor("#9CDCFE");
          break;
        case "attr-value":
          color = Color.parseColor("#CE9178");
          break;
        case "selector":
          color = Color.parseColor("#D7BA7D");
          break;
        case "important":
          color = Color.parseColor("#569CD6");
          break;
        case "color":
          color = Color.parseColor("#B5CEA8");
          break;
        case "atrule":
          color = Color.parseColor("#C586C0");
          break;
        case "url":
          color = Color.parseColor("#CE9178");
          break;
        case "entity":
          color = Color.parseColor("#569CD6");
          break;
        case "doctype":
          color = Color.parseColor("#6A9955");
          break;
        case "script":
          color = Color.parseColor("#D4D4D4");
          break;
        case "style":
          color = Color.parseColor("#D4D4D4");
          break;
        case "event-handler":
          color = Color.parseColor("#DCDCAA");
          break;
        case "inline-style":
          color = Color.parseColor("#9CDCFE");
          break;

        case "tag-name":
          color = Color.parseColor("#569CD6");
          break;

        case "js-keyword":
          color = Color.parseColor("#569CD6");
          break;
        case "css-keyword":
          color = Color.parseColor("#C586C0");
          break;
        case "at-rule":
          color = Color.parseColor("#C586C0");
          break;
        case "unit":
          color = Color.parseColor("#B5CEA8");
          break;
        case "cdata":
          color = Color.parseColor("#6A9955");
          break;
        default:
          color = textColor();
          break;
      }

      builder.setSpan(new ForegroundColorSpan(color), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
  }

  static class MyGrammarLocator implements GrammarLocator {

    @Nullable
    @Override
    public Grammar grammar(@NonNull Prism4j prism4j, @NonNull String language) {
      switch (language) {
        case "json":
          return JsonMd.create(prism4j);
        case "java":
          return JavaMd.create(prism4j);
        case "js":
          return JsGrammer.create(prism4j);
        case "css":
          return CssGrammar.create(prism4j);
        case "kt":
        case "kts":
        case "kotlin":
          return KtGrammer.create(prism4j);
        case "html":
        case "htm":
          return WebGrammer.create(prism4j);
        default:
          return null;
      }
    }

    @Override
    public Set<String> languages() {
      Set<String> set = new HashSet<>();
      set.add("json");
      return set;
    }
  }

  private static class GifGlideStore implements GlideImagesPlugin.GlideStore {
    private final RequestManager requestManager;

    GifGlideStore(RequestManager requestManager) {
      this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public RequestBuilder<Drawable> load(@NonNull AsyncDrawable drawable) {
      final String destination = drawable.getDestination();
      return requestManager
          .asDrawable()
          .addListener(
              new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(
                    @Nullable GlideException e,
                    Object model,
                    Target<Drawable> target,
                    boolean isFirstResource) {
                  return false;
                }

                @Override
                public boolean onResourceReady(
                    Drawable resource,
                    Object model,
                    Target<Drawable> target,
                    DataSource dataSource,
                    boolean isFirstResource) {
                  if (resource instanceof Animatable) {
                    ((Animatable) resource).start();
                  }
                  return false;
                }
              })
          .load(destination);
    }

    @Override
    public void cancel(@NonNull Target<?> target) {
      requestManager.clear(target);
    }
  }
}
