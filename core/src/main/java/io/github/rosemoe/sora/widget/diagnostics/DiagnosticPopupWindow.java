package io.github.rosemoe.sora.widget.diagnostics;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ClipboardUtils;
import com.google.android.material.card.MaterialCardView;

import com.google.android.material.color.MaterialColors;
import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import io.github.rosemoe.sora.widget.EditorPopupWindow;
import io.github.rosemoe.sora.diagnostics.Diagnostic;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import java.util.List;
import java.util.ArrayList;

public class DiagnosticPopupWindow extends EditorPopupWindow {

  private final CodeEditor mEditor;
  private final Handler uiHandler;

  private MaterialCardView card;
  private LinearLayout container;
  private ImageView btnCopy;
  private View rootView;
  private List<Diagnostic> currentDiagnostics = new ArrayList<>();
  private boolean isViewPrepared = false;

  public DiagnosticPopupWindow(CodeEditor mEditor) {
    super(mEditor, FEATURE_SCROLL_AS_CONTENT | FEATURE_SHOW_OUTSIDE_VIEW_ALLOWED);

    this.mEditor = mEditor;
    this.uiHandler = new Handler(Looper.getMainLooper());
    subscribeEditorEvents();
    getPopup().setOutsideTouchable(true);
    getPopup().setFocusable(false);
    getPopup().setElevation(mEditor.getDpUnit() * 8);
    getPopup().setClippingEnabled(false);
  }

  private void prepareViewIfNeeded() {
    if (isViewPrepared) return;

    if (Looper.myLooper() != Looper.getMainLooper()) {
      uiHandler.post(this::prepareViewIfNeeded);
      return;
    }

    rootView =
        LayoutInflater.from(mEditor.getContext())
            .inflate(R.layout.diagnostic_popup_layout, null, false);

    setContentView(rootView);
    card = rootView.findViewById(R.id.diagnostic_card);
    container = rootView.findViewById(R.id.diagnostic_container);
    btnCopy = rootView.findViewById(R.id.btn_copy);

    applyColorScheme();
    setupCopyButton();

    isViewPrepared = true;
  }

  private void setupCopyButton() {
    btnCopy.setOnClickListener(
        v -> {
          if (!currentDiagnostics.isEmpty()) {
            ClipboardUtils.copyText(currentDiagnostics.get(0).getText());
          }
        });
  }

  public void showAtPosition(List<Diagnostic> diagnostics, float screenX, float screenY) {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      uiHandler.post(() -> showAtPosition(diagnostics, screenX, screenY));
      return;
    }

    if (diagnostics == null || diagnostics.isEmpty()) {
      dismiss();
      return;
    }

    currentDiagnostics.clear();
    currentDiagnostics.addAll(diagnostics);

    prepareViewIfNeeded();
    if (!isViewPrepared || container == null || rootView == null) return;
    if (getPopup().getContentView() != rootView) {
      setContentView(rootView);
    }
    container.removeAllViews();
    addDiagnosticView(diagnostics.get(0));
    applyColorScheme();
    rootView.measure(
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

    int width = rootView.getMeasuredWidth();
    int height = rootView.getMeasuredHeight();
    int maxWidth = (int) (mEditor.getWidth() * 0.8);
    int maxHeight = (int) (mEditor.getHeight() * 0.6);
    width = Math.min(Math.max(width, (int) (mEditor.getDpUnit() * 200)), maxWidth);
    height = Math.min(Math.max(height, (int) (mEditor.getDpUnit() * 80)), maxHeight);
    setSize(width, height);
    float finalX, finalY;
    if (screenX + width > mEditor.getWidth()) {
      finalX = screenX - width;
    } else {
      finalX = screenX;
    }
    finalX = Math.max(0, finalX);
    finalY = screenY + mEditor.getRowHeight() * 1.5f;
    if (finalY + height > mEditor.getHeight()) {
      finalY = screenY - height - mEditor.getRowHeight() * 0.5f;
    }
    finalY = Math.max(mEditor.getRowHeight() * 0.5f, finalY);
    if (mEditor.getTextActionWindow().isShowing() || mEditor.getAutoCompleteWindow().isShowing()) {
      dismiss();
      return;
    }

    setLocationAbsolutely((int) finalX, (int) finalY);
    show();
  }

  private void addDiagnosticView(Diagnostic diagnostic) {
    TextView tvMessage = new TextView(mEditor.getContext());
    tvMessage.setText(diagnostic.getText());
    tvMessage.setTextColor(MaterialColors.getColor(tvMessage, ObjectUtils.colorOnSurface));
    tvMessage.setTextSize(14);
    tvMessage.setPadding(
        (int) (mEditor.getDpUnit() * 8),
        (int) (mEditor.getDpUnit() * 6),
        (int) (mEditor.getDpUnit() * 8),
        (int) (mEditor.getDpUnit() * 6));
    tvMessage.setMaxWidth((int) (mEditor.getDpUnit() * 250));
    tvMessage.setMaxLines(3);
    tvMessage.setEllipsize(android.text.TextUtils.TruncateAt.END);
    if (container.getChildCount() > 0) {
      View divider = new View(mEditor.getContext());
      divider.setLayoutParams(
          new LinearLayout.LayoutParams(
              ViewGroup.LayoutParams.MATCH_PARENT, (int) mEditor.getDpUnit()));
      divider.setBackgroundColor(0x1A000000);
      container.addView(divider);
    }

    container.addView(tvMessage);
  }

  public void applyColorScheme() {
    if (card == null) return;
    int colorNormal;
    int colorStroke;
    switch (currentDiagnostics.get(0).getState()) {
      case ERROR:
        {
          colorNormal = Color.parseColor("#ffff0023");
          colorStroke = Color.parseColor("#FFFF8C8C");
          break;
        }
      case WARNING:
        {
          colorNormal = Color.parseColor("#FFFFDD00");
          colorStroke = Color.parseColor("#FFFFE883");
          break;
        }
      case TYPO:
        {
          colorNormal = Color.parseColor("#FF11FF00");
          colorStroke = Color.parseColor("#FF8BFF83");
          break;
        }
      case NONE:
      default:
        {
          colorNormal = mEditor.getColorScheme().getColor(EditorColorScheme.AUTO_COMP_PANEL_BG);
          colorStroke = mEditor.getColorScheme().getColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER);
          break;
        }
    }
    card.setCardBackgroundColor(colorNormal);
    card.setStrokeColor(colorStroke);
    card.setStrokeWidth((int) mEditor.getDpUnit());
    card.setRadius(mEditor.getDpUnit() * 8);
  }

  private void subscribeEditorEvents() {
    mEditor.subscribeEvent(
        ContentChangeEvent.class,
        (event, v) -> {
          if (event.getAction() == ContentChangeEvent.ACTION_SET_NEW_TEXT) {
            dismiss();
          }
        });
  }

  @Override
  public void dismiss() {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      uiHandler.post(this::dismiss);
      return;
    }
    super.dismiss();
    currentDiagnostics.clear();
  }

  public List<Diagnostic> getCurrentDiagnostics() {
    return new ArrayList<>(currentDiagnostics);
  }

  public Diagnostic getCurrentDiagnostic() {
    return currentDiagnostics.isEmpty() ? null : currentDiagnostics.get(0);
  }
}
