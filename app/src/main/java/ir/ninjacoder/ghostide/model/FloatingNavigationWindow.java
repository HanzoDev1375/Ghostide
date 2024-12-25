package ir.ninjacoder.ghostide.model;

import ir.ninjacoder.ghostide.utils.ObjectUtils;
import android.graphics.Color;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.widget.CodeEditor;

import io.github.rosemoe.sora.widget.TextSummry.*;

/**
 * This will show when selecting text
 *
 * @author Ninja
 */
public class FloatingNavigationWindow {

  private final CodeEditor mEditor;
  private String text = "";

  /**
   * Create a panel for the given editor
   *
   * @param editor Target editor
   */
  public FloatingNavigationWindow(CodeEditor mEditor) {
    this.mEditor = mEditor;
  }

  private int selectTop(RectF rect) {
    int rowHeight = mEditor.getRowHeight();

    return (int) (rect.bottom + rowHeight / 2);
  }

  public void displayWindow() {
    int top;
    var cursor = mEditor.getCursor();
    if (cursor.isSelected()) {
      var leftRect = mEditor.getLeftHandleDescriptor().position;
      var rightRect = mEditor.getRightHandleDescriptor().position;
      int top1 = selectTop(leftRect);
      int top2 = selectTop(rightRect);
      top = Math.min(top1, top2);
    } else {
      top = selectTop(mEditor.getInsertHandleDescriptor().position);
    }
    top = Math.max(0, Math.min(top, mEditor.getHeight() - 5));
    float handleLeftX =
        mEditor.getOffset(mEditor.getCursor().getLeftLine(), mEditor.getCursor().getLeftColumn());
    float handleRightX =
        mEditor.getOffset(mEditor.getCursor().getRightLine(), mEditor.getCursor().getRightColumn());
    int panelX = (int) ((handleLeftX + handleRightX) / 2f);
    //    setLocationAbsolutely(panelX, top);
    //    show();
    var menu =
        new PowerMenu.Builder(mEditor.getContext())
            .setMenuRadius(25)
            .setShowBackground(false)
            .addItem(new PowerMenuItem(text))
            .setMenuColor(MaterialColors.getColor(mEditor.getContext(), ObjectUtils.Back, 0))
            .setTextColor(MaterialColors.getColor(mEditor.getContext(), ObjectUtils.TvColor, 0))
            .setIsMaterial(true)
            .setMenuShadow(9f)
           // .setSize(0, (int) mEditor.getDpUnit() * 100)
            .setAutoDismiss(true)
            .build();
    menu.showAsDropDown(mEditor, panelX, top);
    
  }
  public void setText(String text){
    this.text = text;
  }
}
