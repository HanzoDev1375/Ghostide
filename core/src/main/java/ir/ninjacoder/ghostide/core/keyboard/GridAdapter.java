package ir.ninjacoder.ghostide.core.keyboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;

public class GridAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    Context context;
    int[] imageId;

    public GridAdapter(Context mainActivity, int[] prgmImages) {
        this.context = mainActivity;
        this.imageId = prgmImages;
        inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.imageId.length;
    }

    public Object getItem(int position) {
        return Integer.valueOf(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView = inflater.inflate(R.layout.grid_row, null);
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
        holder.img.setImageResource(this.imageId[position]);
        AnimUtils.Worker(rowView);
        // rowView.setBackgroundResource(R.drawable.listview_selector);
        rowView.setPadding(1, 1, 1, 1);
        return rowView;
    }

    public class Holder {
        ImageView img;
    }
}
