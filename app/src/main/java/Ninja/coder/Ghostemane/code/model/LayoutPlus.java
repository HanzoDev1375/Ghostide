package Ninja.coder.Ghostemane.code.model;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.adapter.TextPlusAd;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LayoutPlus extends LinearLayout {
    private RecyclerView rv;
    private TextPlusAd adptor;
    private List<TextPlus> itemview = new ArrayList<>();

    public LayoutPlus(Context context) {
        super(context);
        init();
    }

    public LayoutPlus(Context context, AttributeSet set) {
        super(context, set);
        init();
    }

    public void init() {
        rv = new RecyclerView(getContext());
        itemview.add(new TextPlus("Test", R.drawable.filemultiple));
        adptor = new TextPlusAd(itemview, (pos) -> {

        });
        rv.setAdapter(adptor);
        rv.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        if (rv != null) {
            addView(rv);
        }
    }

    public void addItem(String name, int icon) {
        itemview.add(new TextPlus(name, icon));
        adptor.notifyDataSetChanged();
    }
}
