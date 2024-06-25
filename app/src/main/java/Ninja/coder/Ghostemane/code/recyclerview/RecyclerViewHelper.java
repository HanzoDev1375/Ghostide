package Ninja.coder.Ghostemane.code.recyclerview;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHelper {
  protected RecyclerView rev;
  protected CallBackHelper helper;

  public RecyclerViewHelper(RecyclerView rev, CallBackHelper helper) {
    this.rev = rev;
    this.helper = helper;
    item();
  }

  public void item() {

    ItemTouchHelper.SimpleCallback callback =
        new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
          @Override
          public boolean onMove(
              RecyclerView recyclerView,
              RecyclerView.ViewHolder viewHolder,
              RecyclerView.ViewHolder target) {
            return false;
          }

          @Override
          public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            View view = viewHolder.itemView;

            if (direction == ItemTouchHelper.LEFT) {
              helper.CallBackLeft(position);
              Toast.makeText(view.getContext(), "left", 2).show();
            } else if (direction == ItemTouchHelper.RIGHT) {
              helper.CallBackRight(position);
              Toast.makeText(view.getContext(), "right", 2).show();
            }
          }

          // You must use @RecyclerViewSwipeDecorator inside the onChildDraw method
          @Override
          public void onChildDraw(
              Canvas c,
              RecyclerView recyclerView,
              RecyclerView.ViewHolder viewHolder,
              float dX,
              float dY,
              int actionState,
              boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(
                    c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                .addSwipeLeftBackgroundColor(Color.BLUE)
                .addSwipeLeftActionIcon(R.drawable.dkplayer_battery_level)
                .addSwipeRightBackgroundColor(ColorAndroid12.getColors(ColorAndroid12.ButtonBack))
                .addSwipeRightActionIcon(R.drawable.delete)
                .addSwipeRightLabel("Delete")
                .setSwipeRightLabelColor(Color.WHITE)
                .addSwipeLeftLabel("Add to Project")
                .setSwipeLeftLabelColor(ColorAndroid12.getColors(ColorAndroid12.TvColorFab))
                // .addCornerRadius(TypedValue.COMPLEX_UNIT_DIP, 16)
                // .addPadding(TypedValue.COMPLEX_UNIT_DIP, 8, 16, 8)
                .create()
                .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
          }
        };
    ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
    itemTouchHelper.attachToRecyclerView(rev);
  }

  public interface CallBackHelper {
    public void CallBackLeft(int pos);

    public void CallBackRight(int pos);
  }
}
