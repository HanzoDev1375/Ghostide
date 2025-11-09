package ir.ninjacoder.ghostide.core.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import ir.ninjacoder.ghostide.core.R;

public class ColorFromJsonAdapter extends BaseAdapter {
    private ArrayList<HashMap<String, Object>> map = new ArrayList<>();

    public ColorFromJsonAdapter(ArrayList<HashMap<String, Object>> map) {
        this.map = map;
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public Object getItem(int is) {
        return map.get(is);

    }

    @Override
    public int getCount() {
        return map.size();
    }


    @Override
    public View getView(int pos, View views, ViewGroup parant) {
        views = LayoutInflater.from(parant.getContext()).inflate(R.layout.getcolors, parant, false);
        ImageView moreitem = views.findViewById(R.id.viewcolor);
        TextView nameColors = views.findViewById(R.id.name);
        TextView idcolor = views.findViewById(R.id.idcolor);
        LinearLayout colorviews = views.findViewById(R.id.colorviews);
        try {
            nameColors.setText(map.get(pos).get("ColorName").toString());
            idcolor.setText(map.get(pos).get("mycolors").toString());
            colorviews.setBackgroundColor(Color.parseColor(map.get(pos).get("mycolors").toString()));
        } catch (Exception err) {

        }
        return views;
    }
}
