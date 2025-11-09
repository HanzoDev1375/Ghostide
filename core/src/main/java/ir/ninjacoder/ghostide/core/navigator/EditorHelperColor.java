package ir.ninjacoder.ghostide.core.navigator;

import static androidx.core.graphics.ColorUtils.calculateLuminance;

import android.graphics.Color;
import android.widget.TextView;

import com.allenliu.badgeview.BadgeView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.rosemoe.sora.event.ContentChangeEvent;
import ir.ninjacoder.ghostide.core.IdeEditor;


public class EditorHelperColor {
  private IdeEditor editor;
  private BadgeView view;
  private static String currentWord = null;
  private static String currentWordPaser = null;
  private static int start = 0;
  private static int end = 0;

  public EditorHelperColor(IdeEditor editor, BadgeView view) {
    this.editor = editor;
    this.view = view;
    init();
  }

  public void init() {
    /**
     * using #OnClickListner from show color 
     */
    editor.setOnClickListener(v ->{
      editor.subscribeEvent(
        ContentChangeEvent.class,
        (cc, dd) -> {
          try {
            String textSpan = editor.getText().toString();
            final int selection = editor.getCursor().getLeft();
            final Pattern pattern = Pattern.compile("(#?)(\\w+)");
            final Matcher matcher = pattern.matcher(textSpan);

            try {
              while (matcher.find()) {
                start = matcher.start();
                end = matcher.end();
                if (start <= selection && selection <= end) {
                  currentWordPaser = textSpan.substring(start, end).toString();
                  currentWord = currentWordPaser;
                }
              }
            } catch (Exception rr) {
              rr.printStackTrace();
            }
            if (!currentWord.isEmpty()) {
              if (currentWord.contains("#")) {
                try {
                  view.setBadgeBackground(Color.parseColor(currentWord));
                } catch (IllegalArgumentException iae) {
                  iae.printStackTrace();
                }
              } else {
                if (currentWord.toLowerCase().contains("0xff")) {
                  try {

                    currentWord = currentWord.replace("0xff", "#");
                    currentWord = currentWord.replace("0xFF", "#");
                    view.setBadgeBackground(Color.parseColor(currentWord));
                    if (calculateLuminance(Color.parseColor(currentWord)) < 0.5) {
                      view.setTextColor(Color.WHITE);
                      view.setBadgeCount("C");

                    } else {
                      if (calculateLuminance(Color.parseColor(currentWord)) >= 0.5) {
                        view.setTextColor(Color.BLACK);
                        view.setBadgeCount("D");
                      }
                    }
                  } catch (IllegalArgumentException iae) {

                  }
                } else {
               //   editor.getSearcher().search(currentWord);
                }
              }
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        });
    });

    
  }

  public static void getChar(TextView v, IdeEditor mEditor) {
    var cursor = mEditor.getCursor();
    
    var text =
        new StringBuilder()
            .append(1 + cursor.getLeftLine())
            .append(":")
            .append(cursor.getLeftColumn());
    if (cursor.isSelected()) {
      text.append(" (").append(cursor.getRight() - cursor.getLeft()).append(" chars)");
    }
    v.setText(text);
  }
}
