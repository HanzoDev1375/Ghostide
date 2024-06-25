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

import Ninja.coder.Ghostemane.code.IdeEditor;
import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.adapter.TextActionAd;
import Ninja.coder.Ghostemane.code.databinding.TextComposePopupWindowBinding;
import Ninja.coder.Ghostemane.code.marco.EditorSearcherT;
import Ninja.coder.Ghostemane.code.marco.SmaliHelper;
import Ninja.coder.Ghostemane.code.model.TextActionModel;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.annotation.SuppressLint;
import android.graphics.*;
import android.content.res.*;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.os.*;
import android.widget.*;
import com.google.android.material.color.MaterialColors;
import androidx.annotation.NonNull;
import android.view.inputmethod.InputMethodManager;
import io.github.rosemoe.sora.event.EventReceiver;
import io.github.rosemoe.sora.event.HandleStateChangeEvent;
import io.github.rosemoe.sora.event.ScrollEvent;
import io.github.rosemoe.sora.event.SelectionChangeEvent;
import io.github.rosemoe.sora.event.Unsubscribe;
import io.github.rosemoe.sora.langs.css3.CSS3Language;
import io.github.rosemoe.sora.langs.dart.DartLang;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.langs.javascript.JavaScriptLanguage;
import io.github.rosemoe.sora.langs.kotlin.KotlinLanguage;
import io.github.rosemoe.sora.langs.ninjalang.NinjaLang;
import io.github.rosemoe.sora.langs.python.PythonLang;
import io.github.rosemoe.sora.langs.smali.SMLang;
import io.github.rosemoe.sora.text.Cursor;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import io.github.rosemoe.sora.widget.TextSummry.*;
import java.util.ArrayList;

import io.github.rosemoe.sora.widget.AndroidClassHelper.helper;

import java.util.List;

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

  /**
   * Create a panel for the given editor
   *
   * @param editor Target editor
   */
  public EditorTextActionWindow(CodeEditor editor) {
    super(editor, FEATURE_SHOW_OUTSIDE_VIEW_ALLOWED);
    mEditor = editor;
    mHandler = editor.getEventHandler();
    // Since popup window does provide decor view, we have to pass null to this method
    model.add(new TextActionModel("Format Code", R.drawable.codeformat));
    model.add(new TextActionModel("SetAll", R.drawable.dkplayer_ic_action_fullscreen));
    model.add(new TextActionModel("copy", R.mipmap.mpcopy));
    model.add(new TextActionModel("cut", R.mipmap.mpcut));
    model.add(new TextActionModel("past", R.mipmap.mppaste));
    model.add(new TextActionModel("search", R.drawable.textsearch));
    model.add(new TextActionModel("delete", R.drawable.delete));
    model.add(new TextActionModel("tools", R.drawable.textfile));
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
                    EditorSearcherT.show((IdeEditor) editor, editor, editor.getSelectedText());
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
                        SmaliHelper.run(editor, v.getContext());
                       
                      }
                      break;
                    }
                }
              }
            });
    bin.rvEditor.setAdapter(adptor);
    bin.rvEditor.setClickable(true);
    helpers = new helper(editor);

    MaterialShapeDrawable materialShapeDrawable =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.CUT, 20f).build());
    EditorColorScheme editorColorScheme = editor.getColorScheme();
    materialShapeDrawable.setFillColor(
        ColorStateList.valueOf(editorColorScheme.getColor(EditorColorScheme.AUTO_COMP_PANEL_BG)));
    materialShapeDrawable.setStroke(
        2f,
        ColorStateList.valueOf(
            editorColorScheme.getColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER)));
    // cardview1.setBackground(materialShapeDrawable);
    setContentView(bin.getRoot());
    getPopup().setAnimationStyle(R.style.hso);
    setSize(0, (int) (mEditor.getDpUnit() * 190));
    
    getPopup().setBackgroundDrawable(post());
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
    bin.getRoot().measure(
        View.MeasureSpec.makeMeasureSpec(1000000, View.MeasureSpec.AT_MOST),
        View.MeasureSpec.makeMeasureSpec(100000, View.MeasureSpec.AT_MOST));
    setSize(Math.min(bin.getRoot().getMeasuredWidth(), (int) (mEditor.getDpUnit() * 180)), getHeight());
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

  private MaterialShapeDrawable post() {
    MaterialShapeDrawable shap =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.CUT, 20f).build());
    shap.setFillColor(
        ColorStateList.valueOf(
            MaterialColors.getColor(mEditor.getContext(), ColorAndroid12.Back, 0)));
    shap.setStroke(
        2f,
        ColorStateList.valueOf(
            MaterialColors.getColor(mEditor.getContext(), ColorAndroid12.TvColor, 0)));
    return shap;
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
}
