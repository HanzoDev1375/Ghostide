package io.github.rosemoe.sora.widget.diagnostics;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import io.github.rosemoe.sora.widget.EditorPopupWindow;
import io.github.rosemoe.sora.diagnostics.Diagnostic;

import ir.ninjacoder.ghostide.core.R;

public class DiagnosticPopupWindow extends EditorPopupWindow {

  private final CodeEditor mEditor;
  private final Handler uiHandler;

  private MaterialCardView card;
  private LinearLayout container;
  private TextView tvMessage;
  private ImageView btnCopy;
  private View rootView;
  private Diagnostic currentDiagnostic;
  private boolean isViewPrepared = false;

  public DiagnosticPopupWindow(CodeEditor mEditor) {
    super(mEditor, FEATURE_SCROLL_AS_CONTENT | FEATURE_SHOW_OUTSIDE_VIEW_ALLOWED);

    this.mEditor = mEditor;
    this.uiHandler = new Handler(Looper.getMainLooper());
    subscribemEditorEvents();
    getPopup().setOutsideTouchable(true);
    getPopup().setFocusable(false);
    getPopup().setElevation(mEditor.getDpUnit() * 8);
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
    tvMessage = rootView.findViewById(R.id.tv_diagnostic_message);
    btnCopy = rootView.findViewById(R.id.btn_copy);

    applyColorScheme();
    setupCopyButton();

    isViewPrepared = true;
    //   rootView.measure(
    //      View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
    //        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    //  );

    rootView.measure(
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

    int width = rootView.getMeasuredWidth();
    int height = rootView.getMeasuredHeight();
    setSize(width, height);

    var selection = mEditor.getCursor().left();
    float charX = mEditor.getCharOffsetX(selection.getLine(), selection.getColumn());
    float charY =
        mEditor.getCharOffsetY(selection.getLine(), selection.getColumn()) - mEditor.getRowHeight();

    var locationBuffer = new int[2];
    mEditor.getLocationInWindow(locationBuffer);
    float restAbove = charY + locationBuffer[1];
    float restBottom = mEditor.getHeight() - charY - mEditor.getRowHeight();

    boolean completionShowing = mEditor.getAutoCompleteWindow().isShowing();
    float windowY;
    if (restAbove > restBottom || completionShowing) {
      windowY = charY - getHeight();
    } else {
      windowY = charY + mEditor.getRowHeight() * 1.5f;
    }

    float windowX = Math.max(charX - getWidth() / 2f, 0f);
    setLocationAbsolutely((int) windowX, (int) windowY);
    show();

    if (completionShowing && windowY < 0) {
      dismiss();
    }
  }

  private void setupCopyButton() {
    btnCopy.setOnClickListener(
        v -> {
          if (currentDiagnostic != null) {
            android.content.ClipboardManager clipboard =
                (android.content.ClipboardManager)
                    mEditor
                        .getContext()
                        .getSystemService(android.content.Context.CLIPBOARD_SERVICE);
            clipboard.setPrimaryClip(
                android.content.ClipData.newPlainText("diagnostic", currentDiagnostic.getText()));
          }
        });
  }

  public void showAtPosition(Diagnostic diagnostic, float screenX, float screenY) {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      uiHandler.post(() -> showAtPosition(diagnostic, screenX, screenY));
      return;
    }

    if (diagnostic == null) {
      dismiss();
      return;
    }

    currentDiagnostic = diagnostic;

    prepareViewIfNeeded();
    if (!isViewPrepared || container == null || rootView == null) return;
    if (getPopup().getContentView() != rootView) {
      setContentView(rootView);
    }

    tvMessage.setText(diagnostic.getText());
    tvMessage.setTextColor(diagnostic.getState().getColor());
    applyColorScheme();

    if (mEditor.getTextActionWindow().isShowing()
        || mEditor.getAutoCompleteWindow().isShowing()) {
      dismiss();
      return;
    }
  }

  public void applyColorScheme() {
    if (card == null) return;
    card.setCardBackgroundColor(
        mEditor.getColorScheme().getColor(EditorColorScheme.AUTO_COMP_PANEL_BG));
    card.setStrokeColor(
        mEditor.getColorScheme().getColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER));
    card.setStrokeWidth((int) mEditor.getDpUnit());
    card.setRadius(mEditor.getDpUnit() * 8);
  }

  private void subscribemEditorEvents() {
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
  }

  public Diagnostic getCurrentDiagnostic() {
    return currentDiagnostic;
  }
}
