package io.github.rosemoe.sora.widget.schemes;

import android.graphics.Color;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class GhostThemeDark extends EditorColorScheme {

  @Override
  public void applyDefault() {
    super.applyDefault();

    setColor(WHOLE_BACKGROUND, 0);
    setColor(SELECTION_INSERT, Color.BLACK);
    setColor(SELECTION_HANDLE, 0);
    setColor(LINE_NUMBER, Color.BLACK);
    setColor(LINE_DIVIDER, 0);
    setColor(LINE_NUMBER_BACKGROUND, 0);
    setColor(TEXT_NORMAL, Color.parseColor("#ffffff"));
    setColor(COMMENT, Color.GREEN);
    setColor(javakeyword, Color.parseColor("#E97CFF"));
    setColor(javaoprator, Color.parseColor("#FFB57C"));
    setColor(javafun, Color.parseColor("#FF897C"));
    setColor(javafield, Color.parseColor("#FF7CFFF4"));
    setColor(javatype, Color.parseColor("#FFCFFFFB"));
    setColor(javaparament, Color.parseColor("#FFFFB4CF"));
    setColor(javanumber, Color.GREEN);
    setColor(javastring, Color.CYAN);
    setColor(ATTRIBUTE_VALUE,Color.parseColor("#FFB590FF"));
    setColor(ATTRIBUTE_NAME,Color.parseColor("#ff08a2"));
    setColor(Ninja,Color.parseColor("#FFA5ACD3"));
    setColor(LITERAL,Color.parseColor("#FF89D5C6"));
    setColor(HTML_TAG,Color.parseColor("#ff2822"));
    
    
  }
}
