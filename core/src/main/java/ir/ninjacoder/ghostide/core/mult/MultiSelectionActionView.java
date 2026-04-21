package ir.ninjacoder.ghostide.core.mult;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View.OnClickListener;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.transition.MaterialSharedAxis;
import androidx.transition.TransitionManager;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.databinding.MultiSelectionActionsBinding;
import java.util.ArrayList;
import java.util.List;

public class MultiSelectionActionView extends MaterialCardView {

  private OnActionClickListener actionClickListener;
  private MultiSelectionActionsBinding bind;
  private boolean isShowing = false;
  private List<MultiSelectionAction> actions = new ArrayList<>();

  public interface OnActionClickListener {
    void onActionClick(MultiSelectionAction action);

    void onCloseClick();

    void onSelectAllClick(boolean isChecked);
  }

  public MultiSelectionActionView(@NonNull Context context) {
    super(context);
    init(context);
  }

  public MultiSelectionActionView(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public MultiSelectionActionView(
      @NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  private void init(Context context) {
    bind = MultiSelectionActionsBinding.inflate(LayoutInflater.from(context), this, true);
    setupActionViews();
    setCardBackgroundColor(null);
    setStrokeWidth(0);
    setStrokeColor(null);
    
    bind.btnClose.setOnClickListener(v -> {
        if (actionClickListener != null) {
            actionClickListener.onCloseClick();
        }
        hide();
    });

    bind.checkboxSelectAll.setOnCheckedChangeListener((buttonView, isChecked) -> {
        if (actionClickListener != null) actionClickListener.onSelectAllClick(isChecked);
    });

    bind.actionCopy.setOnClickListener(v -> {
        if (actionClickListener != null)
            actionClickListener.onActionClick(MultiSelectionAction.COPY);
    });

    bind.actionMove.setOnClickListener(v -> {
        if (actionClickListener != null)
            actionClickListener.onActionClick(MultiSelectionAction.MOVE);
    });

    bind.actionDelete.setOnClickListener(v -> {
        if (actionClickListener != null)
            actionClickListener.onActionClick(MultiSelectionAction.DELETE);
    });

    bind.actionMore.setOnClickListener(v -> {
        if (actionClickListener != null)
            actionClickListener.onActionClick(MultiSelectionAction.MORE);
    });
}

  private void setupActionViews() {
    bind.ivCopy.setImageResource(R.drawable.ic_copy_black_24px);
    bind.ivDelete.setImageResource(R.drawable.ic_delete);
    bind.ivMore.setImageResource(R.drawable.ic_more_vert_white);
    bind.ivMove.setImageResource(R.drawable.ic_move_black_24px);
  }

  public void setSelectedCount(int count) {
    if (bind.tvSelectedCount != null) {
      bind.tvSelectedCount.setText(count + " انتخاب شده");
    }
  }

  public void addAction(MultiSelectionAction action) {
    if (!actions.contains(action)) {
      actions.add(action);
    }
    updateActionVisibility();
  }

  public void addActions(List<MultiSelectionAction> actions) {
    this.actions.addAll(actions);
    updateActionVisibility();
  }

  public void removeAllActions() {
    actions.clear();
    hide();
  }

  public void updateActionVisibility() {
    if (getVisibility() == GONE) setVisibility(VISIBLE);
  }

  public void setOnActionClickListener(OnActionClickListener listener) {
    this.actionClickListener = listener;
  }

  public void setSelectAllChecked(boolean checked) {
    if (bind.checkboxSelectAll != null) {
      bind.checkboxSelectAll.setChecked(checked);
      setVisibility(VISIBLE);
    }
  }

  public boolean isSelectAllChecked() {
    return bind.checkboxSelectAll != null && bind.checkboxSelectAll.isChecked();
  }

  @Override
  public void setVisibility(int visibility) {
    super.setVisibility(visibility);
    isShowing = (visibility == VISIBLE);
    if (visibility == VISIBLE) {
      bringToFront();
      requestLayout();
    }
  }

  public boolean isShowing() {
    return isShowing;
  }

  @MainThread
  public void show() {
    var trans = new MaterialSharedAxis(MaterialSharedAxis.Z, true);
    trans.setDuration(1000);
    TransitionManager.beginDelayedTransition(this, trans);
    setVisibility(VISIBLE);
  }

  @MainThread
  public void hide() {
    var trans = new MaterialSharedAxis(MaterialSharedAxis.Z, false);
    trans.setDuration(1000);
    TransitionManager.beginDelayedTransition(this, trans);
    setVisibility(GONE);
  }

  public void showProgress(boolean show) {
    // TODO: implements soon
  }

  @NonNull
  public void setActionCopyLayout(
      @Nullable CharSequence newText, int iconRes, OnClickListener click) {
    bind.ivCopy.setImageResource(iconRes);
    bind.tvCopy.setText(newText);
    bind.actionCopy.setOnClickListener(click);
    if (!isShowing) {
      setVisibility(VISIBLE);
    }
  }

  @NonNull
  public void setActionMoveLayout(@Nullable CharSequence text, int iconRes, OnClickListener click) {
    bind.ivMove.setImageResource(iconRes);
    bind.tvCopy.setText(text);
    bind.actionMove.setOnClickListener(click);
    if (!isShowing) {
      setVisibility(VISIBLE);
    }
  }

  @NonNull
  public void setResetActionCopyLayout() {
    bind.ivCopy.setImageResource(R.drawable.ic_copy_black_24px);
    bind.tvCopy.setText("copy");
  }

  @NonNull
  public void setResetActionMoveLayout() {
    bind.ivMove.setImageResource(R.drawable.ic_move_black_24px);
    bind.tvCopy.setText("move");
  }
}
