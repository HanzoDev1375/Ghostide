package ir.ninjacoder.ghostide.model;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;

public class HeaderDecoration extends RecyclerView.ItemDecoration {

  protected File path;
  private View fileView;
  private View directoryView;

  public HeaderDecoration(View fileView, View directoryView, File path) {
    this.fileView = fileView;
    this.directoryView = directoryView;
    this.path = path;
  }

  @Override
  public void onDraw(
      @NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
    super.onDraw(c, parent, state);

    if (path.isFile()) {
      showFileView(c, parent);
    } else if (path.isDirectory()) {
      showDirectoryView(c, parent);
    }
  }

  private void showFileView(Canvas c, RecyclerView parent) {
    fileView.setLayoutParams(
        new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    fileView.measure(
        View.MeasureSpec.makeMeasureSpec(parent.getWidth(), View.MeasureSpec.EXACTLY),
        View.MeasureSpec.makeMeasureSpec(parent.getHeight(), View.MeasureSpec.AT_MOST));
    fileView.layout(0, 0, parent.getWidth(), fileView.getMeasuredHeight());

    c.save();
    c.translate(0, 0);
    fileView.draw(c);
    c.restore();
  }

  private void showDirectoryView(Canvas c, RecyclerView parent) {
    directoryView.setLayoutParams(
        new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    directoryView.measure(
        View.MeasureSpec.makeMeasureSpec(parent.getWidth(), View.MeasureSpec.EXACTLY),
        View.MeasureSpec.makeMeasureSpec(parent.getHeight(), View.MeasureSpec.AT_MOST));
    directoryView.layout(0, 0, parent.getWidth(), directoryView.getMeasuredHeight());

    c.save();
    c.translate(0, 0);
    directoryView.draw(c);
    c.restore();
  }
}
