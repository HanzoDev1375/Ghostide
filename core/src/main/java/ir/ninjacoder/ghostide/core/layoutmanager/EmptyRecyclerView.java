package ir.ninjacoder.ghostide.core.layoutmanager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;

import androidx.recyclerview.widget.RecyclerView;

public class EmptyRecyclerView extends RecyclerView {
  protected View emptyView;
  protected AdapterDataObserver observer =
      new AdapterDataObserver() {
        @Override
        public void onChanged() {
          checkIfEmpty();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
          checkIfEmpty();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
          checkIfEmpty();
        }
      };

  public EmptyRecyclerView(Context context) {
    super(context);
  }

  public EmptyRecyclerView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public EmptyRecyclerView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  void checkIfEmpty() {
    if (emptyView != null && getAdapter() != null) {
      final boolean emptyViewVisible = getAdapter().getItemCount() == 0;
      emptyView.setVisibility(emptyViewVisible ? VISIBLE : GONE);
      setVisibility(emptyViewVisible ? GONE : VISIBLE);
    }
  }

  @Override
  public void setAdapter(Adapter adapter) {
    final Adapter oldAdapter = getAdapter();
    if (oldAdapter != null) {
      oldAdapter.unregisterAdapterDataObserver(observer);
    }
    super.setAdapter(adapter);
    if (adapter != null) {
      adapter.registerAdapterDataObserver(observer);
    }

    checkIfEmpty();
  }

  public void setEmptyView(View emptyView) {
    this.emptyView = emptyView;
    checkIfEmpty();
  }
}
