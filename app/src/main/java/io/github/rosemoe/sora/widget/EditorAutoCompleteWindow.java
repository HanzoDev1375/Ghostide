package io.github.rosemoe.sora.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.*;
import android.widget.ListView;
import android.widget.Toast;
import android.animation.LayoutTransition;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.MaterialShapeDrawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ir.ninjacoder.ghostide.R;
import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.text.CharPosition;
import io.github.rosemoe.sora.text.Cursor;
import io.github.rosemoe.sora.text.TextAnalyzeResult;

/**
 * Auto complete window for editing code quicker
 *
 * @author Ninja
 */
public class EditorAutoCompleteWindow extends EditorPopupWindow {
  private final CodeEditor mEditor;
  private final ListView listview1;
  private final LinearProgressIndicator circularProgressIndicator;
  protected boolean mCancelShowUp = false;
  private CoordinatorLayout roots;
  private int mCurrent = 0;
  private MaterialCardView mcard;
  private long mRequestTime;
  private String mLastPrefix;
  private AutoCompleteProvider mProvider;
  private boolean mLoading;
  private int mMaxHeight;
  private HashMap<String, Object> imap = new HashMap<>();
  private EditorCompletionAdapter mAdapter;
  private long requestShow = 0;
  private long requestHide = -1;
  private GradientDrawable gd;

  /**
   * Create a panel instance for the given editor
   *
   * @param editor Target editor
   */
  public EditorAutoCompleteWindow(CodeEditor editor) {
    // super(editor, FEATURE_HIDE_WHEN_FAST_SCROLL | FEATURE_SCROLL_AS_CONTENT);
    super(editor, FEATURE_SCROLL_AS_CONTENT | FEATURE_SHOW_OUTSIDE_VIEW_ALLOWED);
    mEditor = editor;
    mAdapter = new CustomAdGhostWeb();
    var vis =
        LayoutInflater.from(editor.getContext()).inflate(R.layout.auto_textlayout, null, false);
    setContentView(vis);
    gd = new GradientDrawable();

    roots = vis.findViewById(R.id.rootcoordinator);
    circularProgressIndicator = vis.findViewById(R.id.barText);
    mcard = vis.findViewById(R.id.auto_card_view);
    listview1 = vis.findViewById(R.id.auto_listiviewHelper);
    listview1.setEmptyView(circularProgressIndicator);
    circularProgressIndicator.setTrackColor(
        getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER));
    circularProgressIndicator.setTrackCornerRadius(20);
    // listview1.setSelector(colorAcsentDialog());
    applyColorScheme();
    roots.setBackground(gd);
    EditorColorScheme colors = editor.getColorScheme();
    mcard.setCardBackgroundColor(Color.TRANSPARENT);
    mcard.setStrokeWidth(0);
    listview1.setHorizontalScrollBarEnabled(false);
    listview1.setVerticalScrollBarEnabled(false);
    listview1.setSelector(colorAcsentDialog());
    listview1.setOverScrollMode(ListView.OVER_SCROLL_NEVER);

    LayoutTransition transition = new LayoutTransition();
    transition.enableTransitionType(LayoutTransition.CHANGING);
    transition.enableTransitionType(LayoutTransition.APPEARING);
    transition.enableTransitionType(LayoutTransition.DISAPPEARING);
    transition.enableTransitionType(LayoutTransition.CHANGE_APPEARING);
    transition.enableTransitionType(LayoutTransition.CHANGE_DISAPPEARING);
    transition.addTransitionListener(
        new LayoutTransition.TransitionListener() {
          @Override
          public void startTransition(
              LayoutTransition transition, ViewGroup container, View view, int transitionType) {}

          @Override
          public void endTransition(
              LayoutTransition transition, ViewGroup container, View view, int transitionType) {
            if (view != roots) {
              return;
            }
            view.requestLayout();
          }
        });

    //	layout.setLayoutTransition(transition);
    listview1.setLayoutTransition(transition);
    getPopup().setAnimationStyle(R.style.hso);
    listview1.setDividerHeight(0);
    setLoading(true);

    listview1.setOnItemClickListener(
        (parent, view, position, id) -> {
          try {
            select(position);
            listview1.setSelector(colorAcsentDialog());
          } catch (Exception e) {
            Toast.makeText(mEditor.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
          }
        });
  }

  public void setItemClick() {
    listview1.setOnItemClickListener(
        (parent, view, position, id) -> {
          try {
            select(position);
            listview1.setSelector(colorAcsentDialog());
          } catch (Exception e) {
            Toast.makeText(mEditor.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
          }
        });
  }

  protected void setAdapter(EditorCompletionAdapter adapter) {
    mAdapter = adapter;
    if (adapter == null) {
      mAdapter = new CustomAdGhostWeb();
    }
  }

  public void setCancelShowUp(boolean val) {
    mCancelShowUp = val;
  }

  public void applyColorScheme() {
    gd.setShape(GradientDrawable.RECTANGLE);
    gd.setCornerRadius(55);
    gd.setColor(getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_BG));
    gd.setStroke(2, getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER));
  }

  @Override
  public void show() {
    if (mCancelShowUp) {
      return;
    }
    requestShow = System.currentTimeMillis();
    final var requireRequest = mRequestTime;
    mEditor.postDelayed(
        () -> {
          if (requestHide < requestShow && mRequestTime == requireRequest) {
            super.show();
          }
        },
        100);
  }

  public void hide() {
    super.dismiss();
    requestHide = System.currentTimeMillis();
  }

  public Context getContext() {
    return mEditor.getContext();
  }

  public int getCurrentPosition() {
    return mCurrent;
  }

  /**
   * Set a auto completion items provider
   *
   * @param provider New provider.can not be null
   */
  public void setProvider(AutoCompleteProvider provider) {
    mProvider = provider;
  }

  /**
   * Change layout to loading/idle
   *
   * @param state Whether loading
   */
  public void setLoading(boolean state) {
    mLoading = state;
    if (state) {
      mEditor.postDelayed(
          () -> {
            if (mLoading) {
              circularProgressIndicator.setVisibility(View.VISIBLE);
            }
          },
          100);
    } else {
      circularProgressIndicator.setVisibility(View.GONE);
    }
  }

  /** Move selection down */
  public void moveDown() {
    if (mCurrent + 1 >= listview1.getAdapter().getCount()) {
      return;
    }
    mCurrent++;
    ((EditorCompletionAdapter) listview1.getAdapter()).notifyDataSetChanged();
    ensurePosition();
  }

  /** Move selection up */
  public void moveUp() {
    if (mCurrent - 1 < 0) {
      return;
    }
    mCurrent--;
    ((EditorCompletionAdapter) listview1.getAdapter()).notifyDataSetChanged();
    ensurePosition();
  }

  /** Perform motion events */
  private void performScrollList(int offset) {
    long down = SystemClock.uptimeMillis();
    var ev = MotionEvent.obtain(down, down, MotionEvent.ACTION_DOWN, 0, 0, 0);
    listview1.onTouchEvent(ev);
    ev.recycle();

    ev = MotionEvent.obtain(down, down, MotionEvent.ACTION_MOVE, 0, offset, 0);
    listview1.onTouchEvent(ev);
    ev.recycle();

    ev = MotionEvent.obtain(down, down, MotionEvent.ACTION_CANCEL, 0, offset, 0);
    listview1.onTouchEvent(ev);
    ev.recycle();
  }

  /** Make current selection visible */
  private void ensurePosition() {
    listview1.post(
        () -> {
          while (listview1.getFirstVisiblePosition() + 1 > mCurrent
              && listview1.canScrollList(-1)) {
            performScrollList(mAdapter.getItemHeight() / 2);
          }
          while (listview1.getLastVisiblePosition() - 1 < mCurrent && listview1.canScrollList(1)) {
            performScrollList(-mAdapter.getItemHeight() / 2);
          }
        });
  }

  /** Select current position */
  public void select() {
    select(mCurrent);
  }

  /**
   * Select the given position
   *
   * @param pos Index of auto complete item
   */
  public void select(int pos) {
    if (pos == -1) {
      mEditor.getCursor().onCommitText("\n");
      return;
    }
    CompletionItem item = ((EditorCompletionAdapter) listview1.getAdapter()).getItem(pos);
    Cursor cursor = mEditor.getCursor();
    if (!cursor.isSelected()) {
      mCancelShowUp = true;
      int length = mLastPrefix.length();

      if (mLastPrefix.contains(".")) {
        length -= mLastPrefix.lastIndexOf(".") + 1;
      }
      mEditor
          .getText()
          .delete(
              cursor.getLeftLine(),
              cursor.getLeftColumn() - length,
              cursor.getLeftLine(),
              cursor.getLeftColumn());

      cursor.onCommitText(item.commit);
      if (item.cursorOffset != item.commit.length()) {
        int delta = (item.commit.length() - item.cursorOffset);
        int newSel = Math.max(mEditor.getCursor().getLeft() - delta, 0);
        CharPosition charPosition = mEditor.getCursor().getIndexer().getCharPosition(newSel);
        mEditor.setSelection(charPosition.line, charPosition.column);
      }
      mCancelShowUp = false;
    }
    mEditor.hideCompletionWindow();
  }

  /**
   * Get prefix set
   *
   * @return The previous prefix
   */
  public String getPrefix() {
    return mLastPrefix;
  }

  /**
   * Set prefix for auto complete analysis
   *
   * @param prefix The user's input code's prefix
   */
  public void setPrefix(String prefix) {
    if (mCancelShowUp) {
      return;
    }
    setLoading(true);
    mLastPrefix = prefix;
    mRequestTime = System.currentTimeMillis();
    new MatchThread(mRequestTime, prefix).start();
  }

  public void setMaxHeight(int height) {
    mMaxHeight = height;
  }

  /**
   * Display result of analysis
   *
   * @param results Items of analysis
   * @param requestTime The time that this thread starts
   */
  private synchronized void displayResults(final List<CompletionItem> results, long requestTime) {
    if (mRequestTime != requestTime) {
      return;
    }
    mEditor.post(
        () -> {
          setLoading(false);
          if (results == null || results.isEmpty()) {
            hide();
            return;
          }
          mAdapter.attachValues(this, results);
          listview1.setAdapter(mAdapter);
          mCurrent = -1;
          float newHeight = mAdapter.getItemHeight() * results.size();
          setSize(getWidth(), (int) Math.min(newHeight, mMaxHeight));
        });
  }

  protected MaterialShapeDrawable colorAcsentDialog() {
    MaterialShapeDrawable materialShapeDrawable =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 20f).build());

    materialShapeDrawable.setFillColor(
        ColorStateList.valueOf(getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_BG)));
    materialShapeDrawable.setStroke(
        2f, ColorStateList.valueOf(getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER)));
    return materialShapeDrawable;
  }

  @NonNull
  protected EditorColorScheme getColorScheme() {
    return getEditor().getColorScheme();
  }

  protected int getThemeColor(int type) {
    return getColorScheme().getColor(type);
  }

  public boolean trySelect() {
    if (mAdapter.getCount() <= 0) {
      return false;
    }

    if (getCurrentPosition() == -1) {
      // select the first position
      select(0);
    } else {
      setItemClick();
    }

    return true;
  }

  /**
   * Analysis thread
   *
   * @author Rose
   */
  private class MatchThread extends Thread {

    private final long mTime;
    private final String mPrefix;
    private final TextAnalyzeResult mColors;
    private final int mLine;
    private final int mColumn;
    private final AutoCompleteProvider mLocalProvider = mProvider;

    public MatchThread(long requestTime, String prefix) {
      mTime = requestTime;
      mPrefix = prefix;
      mColors = mEditor.getTextAnalyzeResult();
      mLine = mEditor.getCursor().getLeftLine();
      mColumn = mEditor.getCursor().getLeftColumn();
    }

    @Override
    public void run() {
      try {
        displayResults(
            mLocalProvider.getAutoCompleteItems(mPrefix, mColors, mLine, mColumn), mTime);

      } catch (Exception e) {
        e.printStackTrace();
        displayResults(new ArrayList<>(), mTime);
      }
    }
  }
}
