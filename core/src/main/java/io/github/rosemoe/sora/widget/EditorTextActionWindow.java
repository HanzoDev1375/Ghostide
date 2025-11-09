/*
 *    sora-editor - the awesome code editor for Android
 *    https://github.com/Rosemoe/sora-editor
 *    Copyright (C) 2020-2022  Rosemoe
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *     USA
 *
 *     Please contact Rosemoe by email 2073412493@qq.com if you need
 *     additional information or have any questions
 */
package io.github.rosemoe.sora.widget;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.github.rosemoe.sora.event.EventReceiver;
import io.github.rosemoe.sora.event.HandleStateChangeEvent;
import io.github.rosemoe.sora.event.ScrollEvent;
import io.github.rosemoe.sora.event.SelectionChangeEvent;
import io.github.rosemoe.sora.event.Unsubscribe;
import io.github.rosemoe.sora.langs.css3.CSS3Language;
import io.github.rosemoe.sora.langs.dart.DartLang;
import io.github.rosemoe.sora.langs.groovy.lang.GroovyLanguage;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.langs.javascript.JavaScriptLanguage;
import io.github.rosemoe.sora.langs.json.JsonLanguage;
import io.github.rosemoe.sora.langs.kotlin.KotlinLanguage;
import io.github.rosemoe.sora.langs.ninjalang.NinjaLang;
import io.github.rosemoe.sora.langs.python.PythonLang;
import io.github.rosemoe.sora.langs.smali.SMLang;
import io.github.rosemoe.sora.langs.xml.XMLLanguage;
import io.github.rosemoe.sora.text.Cursor;
import io.github.rosemoe.sora.widget.AndroidClassHelper.helper;
import io.github.rosemoe.sora.widget.TextSummry.GradleTools;
import io.github.rosemoe.sora.widget.TextSummry.HtmlTool;
import io.github.rosemoe.sora.widget.TextSummry.JavaTools;
import io.github.rosemoe.sora.widget.TextSummry.JsonTools;
import io.github.rosemoe.sora.widget.TextSummry.KotlinTools;
import io.github.rosemoe.sora.widget.TextSummry.OtherLangs;
import io.github.rosemoe.sora.widget.TextSummry.PythonTools;
import io.github.rosemoe.sora.widget.TextSummry.ToolItem;
import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.adapter.TextActionAd;
import ir.ninjacoder.ghostide.core.databinding.TextComposePopupWindowBinding;
import ir.ninjacoder.ghostide.core.model.TextActionModel;

/**
 * This will show when selecting text
 *
 * @author Rosemoe
 */
public class EditorTextActionWindow extends EditorPopupWindow
    implements EventReceiver<SelectionChangeEvent> {
  private static final long DELAY = 200;
  private final CodeEditor mEditor;
  private final EditorTouchEventHandler mHandler;
  protected List<TextActionModel> model = new ArrayList<>();
  protected TextActionAd adptor;
  private long mLastScroll;
  private int mLastPosition;
  private helper helpers;
  private TextComposePopupWindowBinding bin;
  private boolean isShow = true;
  private boolean showItems = false;

  /**
   * Create a panel for the given editor
   *
   * @param editor Target editor
   */
  public EditorTextActionWindow(CodeEditor editor) {
    super(editor, FEATURE_SHOW_OUTSIDE_VIEW_ALLOWED);
    mEditor = editor;
    mHandler = editor.getEventHandler();
    setShowItems(true);
    if (showItems) {

      // Since popup window does provide decor view, we have to pass null to this method
      model.add(new TextActionModel("Format Code", R.drawable.codeformat));
      model.add(new TextActionModel("SetAll", R.drawable.dkplayer_ic_action_fullscreen));
      model.add(new TextActionModel("copy", R.mipmap.mpcopy));
      model.add(new TextActionModel("cut", R.mipmap.mpcut));
      model.add(new TextActionModel("past", R.mipmap.mppaste));
      model.add(new TextActionModel("Duplicate", R.drawable.dkplayer_ic_action_autorenew));
      model.add(new TextActionModel("delete", R.drawable.delete));
      model.add(new TextActionModel("tools", R.drawable.cog));
      bin = TextComposePopupWindowBinding.inflate(LayoutInflater.from(editor.getContext()));
      adptor =
          new TextActionAd(
              model,
              new TextActionAd.OnItemClick() {

                @Override
                public void onItemClickChange(int posNow, View myview, ImageView img) {
                  View v = myview;
                  switch (posNow) {
                    case 0:
                      {
                        editor.formatCodeAsync();
                        dismiss();
                        break;
                      }
                    case 1:
                      {
                        editor.selectAll();
                        show();
                        break;
                      }
                    case 2:
                      {
                        editor.copyText();
                        img.setEnabled(editor.hasClip() && editor.isEditable());
                        dismiss();
                        break;
                      }
                    case 3:
                      editor.cutText();
                      dismiss();
                      break;
                    case 4:
                      editor.pasteText();
                      dismiss();
                      break;
                    case 5:
                      editor.setDuplicateLine();
                      dismiss();
                      break;
                    case 6:
                      RomvedText();
                      dismiss();
                      break;
                    case 7:
                      {
                        if (editor.getEditorLanguage() instanceof NinjaLang) {
                          ToolItem item = new ToolItem();
                          item.BindViewsNinja(v.getContext(), v, editor);
                        } else if (editor.getEditorLanguage() instanceof HTMLLanguage) {
                          HtmlTool tool = new HtmlTool();
                          tool.Tool(v.getContext(), v, editor);
                        } else if (editor.getEditorLanguage() instanceof JavaLanguage) {
                          JavaTools toolss = new JavaTools();
                          var l = "java";
                          toolss.runs(v.getContext(), v, editor, l);
                        } else if (editor.getEditorLanguage() instanceof PythonLang) {
                          PythonTools toolpy = new PythonTools();
                          toolpy.Tool(v.getContext(), v, editor);
                        } else if (editor.getEditorLanguage() instanceof JavaScriptLanguage) {
                          JavaTools toolss = new JavaTools();
                          var l = "js";
                          toolss.runs(v.getContext(), v, editor, l);
                        } else if (editor.getEditorLanguage() instanceof CSS3Language) {
                          OtherLangs toolss = new OtherLangs();
                          toolss.run(v.getContext(), editor, v);
                        } else if (editor.getEditorLanguage() instanceof DartLang) {
                          OtherLangs toolss = new OtherLangs();
                          toolss.run(v.getContext(), editor, v);
                        } else if (editor.getEditorLanguage() instanceof KotlinLanguage) {
                          KotlinTools tools = new KotlinTools();
                          tools.run(v.getContext(), editor, v);
                        } else if (editor.getEditorLanguage() instanceof SMLang) {
                          new ToolItem().bindSmail(v.getContext(), editor, v);
                        } else if (editor.getEditorLanguage() instanceof JsonLanguage) {
                          JsonTools.run((IdeEditor) editor, v, v.getContext());
                        } else if (editor.getEditorLanguage() instanceof XMLLanguage) {
                          new ToolItem().bindXml(v.getContext(), editor, v);
                        } else if (editor.getEditorLanguage() instanceof GroovyLanguage) {
                          var gr = new GradleTools(v.getContext(), (IdeEditor) editor, v);
                          gr.get();
                        } else {
                          Toast.makeText(editor.getContext(), "Tools your lang not found", 2)
                              .show();
                        }
                      }
                      break;
                  }
                }
              },editor);
      bin.rvEditor.setAdapter(adptor);
      bin.rvEditor.setLayoutManager(
          new LinearLayoutManager(editor.getContext(), RecyclerView.HORIZONTAL, false));
      helpers = new helper(editor);
      setContentView(bin.getRoot());
    }
    setSize(0, (int) (mEditor.getDpUnit() * 50));
    apply();
    editor.subscribeEvent(SelectionChangeEvent.class, this);
    editor.subscribeEvent(
        ScrollEvent.class,
        ((event, unsubscribe) -> {
          var last = mLastScroll;
          mLastScroll = System.currentTimeMillis();
          if (mLastScroll - last < DELAY) {
            postDisplay();
          }
        }));
    editor.subscribeEvent(
        HandleStateChangeEvent.class,
        ((event, unsubscribe) -> {
          if (event.isHeld()) {
            postDisplay();
          }
        }));
  }

  private void postDisplay() {
    if (!isShowing()) {
      return;
    }
    dismiss();
    if (!mEditor.getCursor().isSelected()) {
      return;
    }
    mEditor.postDelayed(
        new Runnable() {
          @Override
          public void run() {
            if (!mHandler.hasAnyHeldHandle()
                && System.currentTimeMillis() - mLastScroll > DELAY
                && mEditor.getScroller().isFinished()) {
              displayWindow();
            } else {
              mEditor.postDelayed(this, DELAY);
            }
          }
        },
        DELAY);
  }

  @Override
  public void onReceive(SelectionChangeEvent event, Unsubscribe unsubscribe) {
    if (mHandler.hasAnyHeldHandle()) {
      return;
    }
    if (event.isSelected()) {
      if (!isShowing()) {
        mEditor.post(this::displayWindow);
      }
      mLastPosition = -1;
    } else {
      if (event.getLeft().index == mLastPosition && !isShowing()) {
        mEditor.post(this::displayWindow);
      } else {
        dismiss();
      }
      mLastPosition = event.getLeft().index;
    }
  }

  private int selectTop(RectF rect) {
    int rowHeight = mEditor.getRowHeight();
    if (rect.top - rowHeight * 3 / 2F > getHeight()) {
      return (int) (rect.top - rowHeight * 3 / 2 - getHeight());
    } else {
      return (int) (rect.bottom + rowHeight / 2);
    }
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
    top = Math.max(0, Math.min(top, mEditor.getHeight() - getHeight() - 5));
    float handleLeftX =
        mEditor.getOffset(mEditor.getCursor().getLeftLine(), mEditor.getCursor().getLeftColumn());
    float handleRightX =
        mEditor.getOffset(mEditor.getCursor().getRightLine(), mEditor.getCursor().getRightColumn());
    int panelX = (int) ((handleLeftX + handleRightX) / 2f);
    setLocationAbsolutely(panelX, top);
    show();
  }

  /** Update the state of paste button */
  private void updateBtnState() {
    bin.getRoot()
        .measure(
            View.MeasureSpec.makeMeasureSpec(1000000, View.MeasureSpec.AT_MOST),
            View.MeasureSpec.makeMeasureSpec(100000, View.MeasureSpec.AT_MOST));
    setSize(
        Math.min(bin.getRoot().getMeasuredWidth(), (int) (mEditor.getDpUnit() * 230)), getHeight());
  }

  @Override
  public void show() {
    updateBtnState();
    super.show();
  }

  private void KeyBoardUtil() {
    try {
      if (isShow()) {
        mEditor.showSoftInput();
      } else {
        mEditor.hideSoftInput();
      }
    } catch (Exception e) {
      throw new RuntimeException("Keyboard show Error see Log" + " " + e.toString());
    }
  }

  private boolean isShow() {
    InputMethodManager imm =
        (InputMethodManager) mEditor.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    return imm.isAcceptingText();
  }

  private EditorTextActionWindow KeyBoardShow() {
    InputMethodManager show =
        (InputMethodManager) mEditor.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    show.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    return this;
  }

  private EditorTextActionWindow KeyBoardHiden() {
    InputMethodManager hiden =
        (InputMethodManager) mEditor.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    hiden.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    return this;
  }

  protected void RomvedText() {
    if (mEditor.getCursor().isSelected()) mEditor.getCursor().onDeleteKeyPressed();
  }

  private GradientDrawable post() {
    var gr = new GradientDrawable();
    gr.setColor(getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_BG));
    gr.setStroke(2, getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER));
    gr.setCornerRadius(45);
    return gr;
  }

  void runOnPost() {
    Handler handler = new Handler();
    handler.postDelayed(
        () -> {
          Transilt.Start(mEditor);
        },
        2000);
  }

  @NonNull
  protected EditorColorScheme getColorScheme() {
    return getEditor().getColorScheme();
  }

  protected int getThemeColor(int type) {
    return getColorScheme().getColor(type);
  }

  public void getShow(boolean isShow) {
    isShow = isShow;
  }

  public void setLowerCase() {
    if (mEditor.getCursor().isSelected()) {
      try {
        mEditor.getCursor().onCommitText(getSelectedText().toLowerCase());
      } catch (Exception err) {
        Toast.makeText(mEditor.getContext(), err.getMessage(), 2).show();
      }
    } else {
      Toast.makeText(mEditor.getContext(), "Text not selected", Toast.LENGTH_SHORT).show();
    }
  }

  public void setUpperCase() {
    if (mEditor.getCursor().isSelected()) {
      try {
        mEditor.getCursor().onCommitText(getSelectedText().toUpperCase());
      } catch (Exception err) {
        Toast.makeText(mEditor.getContext(), err.getMessage(), 2).show();
      }
    } else {
      Toast.makeText(mEditor.getContext(), "Text not selected", Toast.LENGTH_SHORT).show();
    }
  }

  public String getSelectedText() {
    Cursor cursor = mEditor.getCursor();
    return mEditor
        .getText()
        .subContent(
            cursor.getLeftLine(),
            cursor.getLeftColumn(),
            cursor.getRightLine(),
            cursor.getRightColumn())
        .toString();
  }

  public void setText(String text) {
    bin.tooltiem.setVisibility(View.VISIBLE);
    bin.rvEditor.setVisibility(View.GONE);
    bin.tooltiem.setText(text);
    postDisplay();
  }

  public void showMassges(String text) {
    TextView txt = new TextView(mEditor.getContext());
    txt.setText(text);
    setContentView(txt);
  }

  public void setShowItems(boolean showItems) {
    this.showItems = showItems;
  }
  public void apply(){
    getPopup().setBackgroundDrawable(post());
  }
}
