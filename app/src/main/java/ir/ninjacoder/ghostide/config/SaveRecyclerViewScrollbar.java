package ir.ninjacoder.ghostide.config;

import ir.ninjacoder.ghostide.ApplicationLoader;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SaveRecyclerViewScrollbar implements LifecycleObserver {

  public static String key = "SAVEPOS";
  private SharedPreferences prefs;
  private GridLayoutManager grid;
  protected RecyclerView recyclerView;

  public SaveRecyclerViewScrollbar(
      GridLayoutManager grid, Lifecycle lifecycle, RecyclerView recyclerView) {
    this.prefs = ApplicationLoader.getContext().getSharedPreferences(key, Activity.MODE_PRIVATE);
    this.grid = grid;
    this.recyclerView = recyclerView;
    lifecycle.addObserver(this);
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void saveScrollPosition() {
    if (prefs != null && grid != null) {
      Editor editor = prefs.edit();
      int firstVisibleItemPosition = grid.findFirstCompletelyVisibleItemPosition();
      editor.putInt(key, firstVisibleItemPosition);
      editor.apply();
    }
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public void restoreScrollPosition() {
    if (prefs != null && grid != null) {
      int savedPosition = prefs.getInt(key, 0);
      if (recyclerView != null) {
        recyclerView.post(
            () -> {
              recyclerView.smoothScrollToPosition(savedPosition != RecyclerView.NO_POSITION ? savedPosition : 1);
            });
      }
    }
  }
}
