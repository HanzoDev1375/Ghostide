package ir.ninjacoder.ghostide.adapter;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;

class RvDataObserver extends RecyclerView.AdapterDataObserver {
    RecyclerView rv;

    public RvDataObserver(RecyclerView rv) {
        this.rv = rv;
        showEmpty();
    }

    @Override
    public void onChanged() {
        super.onChanged();
        // TODO: Implement this method
        showEmpty();
    }

    public void showEmpty() {
        if (rv.getAdapter() != null && rv.getAdapter().getItemCount() == 0) {
            Log.e("item reday", "getItemCount()");
        } else {
            Log.e("item not redy", "0");
        }
    }
}
