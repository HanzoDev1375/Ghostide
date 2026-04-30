package ir.ninjacoder.prograsssheet.deepseek.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Spanned;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import ir.ninjacoder.codesnap.markdownpreview.MarkDownTextHelper;

public class TypewriterTextView extends AppCompatTextView {

  private CharSequence fullText;
  private String rawMarkdown;
  private int currentIndex;
  private long delayMillis;
  private Handler handler;
  private Runnable typeRunnable;
  private boolean isTyping;
  private OnTypeCompleteListener listener;
  private boolean useMarkdown = false;

  public interface OnTypeCompleteListener {
    void onComplete();
  }

  public TypewriterTextView(Context context) {
    super(context);
    init();
  }

  public TypewriterTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public TypewriterTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    handler = new Handler(Looper.getMainLooper());
    delayMillis = 30;
  }

  public void setOnTypeCompleteListener(OnTypeCompleteListener listener) {
    this.listener = listener;
  }

  public void setTypingDelay(long millis) {
    this.delayMillis = millis;
  }

  private boolean isContextValid() {
    Context context = getContext();
    if (context instanceof Activity) {
      Activity activity = (Activity) context;
      return !activity.isDestroyed() && !activity.isFinishing();
    }
    return true;
  }

  public void typeText(CharSequence text) {
    this.rawMarkdown = text != null ? text.toString() : "";
    this.fullText = text;
    this.useMarkdown = true;
    currentIndex = 0;
    isTyping = true;
    setText("");

    typeRunnable =
        new Runnable() {
          @Override
          public void run() {
            if (!isContextValid()) {
              isTyping = false;
              return;
            }
            if (currentIndex < rawMarkdown.length() && isTyping) {
              currentIndex++;
              String partial = rawMarkdown.substring(0, currentIndex);
              MarkDownTextHelper.handleMarkDown(TypewriterTextView.this, partial);
              handler.postDelayed(this, delayMillis);
            } else if (currentIndex >= rawMarkdown.length()) {
              isTyping = false;
              MarkDownTextHelper.handleMarkDown(TypewriterTextView.this, rawMarkdown);
              if (listener != null) {
                listener.onComplete();
              }
            }
          }
        };

    handler.post(typeRunnable);
  }

  public void typePlainText(CharSequence text) {
    this.fullText = text;
    this.useMarkdown = false;
    currentIndex = 0;
    isTyping = true;
    setText("");

    typeRunnable =
        new Runnable() {
          @Override
          public void run() {
            if (!isContextValid()) {
              isTyping = false;
              return;
            }
            if (currentIndex < fullText.length() && isTyping) {
              append(String.valueOf(fullText.charAt(currentIndex)));
              currentIndex++;
              handler.postDelayed(this, delayMillis);
            } else if (currentIndex >= fullText.length()) {
              isTyping = false;
              if (listener != null) {
                listener.onComplete();
              }
            }
          }
        };

    handler.post(typeRunnable);
  }

  public void stopTyping() {
    isTyping = false;
    if (typeRunnable != null) {
      handler.removeCallbacks(typeRunnable);
    }
    if (!isContextValid()) {
      return;
    }
    if (fullText != null) {
      if (useMarkdown && rawMarkdown != null) {
        MarkDownTextHelper.handleMarkDown(this, rawMarkdown);
      } else {
        setText(fullText);
      }
    }
    if (listener != null) {
      listener.onComplete();
    }
  }

  public boolean isTyping() {
    return isTyping;
  }

  @Override
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    stopTyping();
  }
}
