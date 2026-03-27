package ir.ninjacoder.ghostide.core.widget.component;

import io.github.rosemoe.sora.event.LinkClickEvent;
import ir.ninjacoder.ghostide.core.IdeEditor;

/*
 * author ghost
 * <h1> Don't Use Group Regex </h1>
 */
public class RegexComponent {
  public static String FILE_DIR = "\\.\\/\\w+\\.js"; //./script.js

  public static interface OnFileEvent {
    void onFile(String path);
  }

  public RegexComponent bindListFile(IdeEditor editor, OnFileEvent e) {
    editor.addPattern(FILE_DIR);
    editor.subscribeEvent(
        LinkClickEvent.class,
        (ev, un) -> {
          if (ev.getUrl().matches(FILE_DIR)) {
            e.onFile(ev.getUrl());
          }
        });
    return this;
  }
}
