package Ninja.coder.Ghostemane.code.adapter;

import Ninja.coder.Ghostemane.code.R;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemeAdpter extends BaseAdapter implements Adapter {
    protected HashMap<String, Object> map = new HashMap<>();
    private ArrayList<HashMap<String, Object>> listMap = new ArrayList<>();

    public ThemeAdpter(ArrayList<HashMap<String, Object>> listMap) {
        this.listMap = listMap;
    }

    @Override
    public int getCount() {
        return listMap.size();
    }

    @Override
    public Object getItem(int id) {
        return listMap.get(id);
    }

    @Override
    public long getItemId(int index) {
        return index;
    }

    @Override
    public View getView(int pos, View view, ViewGroup prant) {
        view =
                LayoutInflater.from(prant.getContext()).inflate(R.layout.layout_colorselect, prant, false);
        LinearLayout sub = view.findViewById(R.id.colorviews);
        TextView tv = view.findViewById(R.id.name);
        ImageView image = view.findViewById(R.id.viewcolor);
        TextView id = view.findViewById(R.id.idcolor);
        id.setText(listMap.get(pos).get("key").toString());
        sub.setBackground(db(listMap.get(pos).get("hex").toString()));
        tv.setText(listMap.get(pos).get("hex").toString());
        view.setOnClickListener(
                v -> {
                    ColorPickerDialogBuilder.with(tv.getContext())
                            .setTitle("Colors")
                            .initialColor(Color.parseColor(tv.getText().toString()))
                            .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                            .density(12)
                            .setOnColorSelectedListener((colorviews) -> {
                            })
                            .setPositiveButton(
                                    "ok",
                                    (in, colorview, allcolos) -> {
                                        var colors = Integer.toHexString(colorview);
                                        tv.setText("#" + colors);
                                        sub.setBackground(db("#" + colors));
                                        var hand = new Handler(Looper.getMainLooper());
                                        hand.postDelayed(
                                                () -> {
                                                    listMap.get(pos).put("hex", tv.getText().toString());
                                                    notifyDataSetChanged();
                                                },
                                                2000);
                                    })
                            .build()
                            .show();
                });
        return view;
    }

    protected GradientDrawable db(String color) {
        var colors = new GradientDrawable();
        colors.setColor(Color.parseColor(color));
        colors.setCornerRadius(15);
        return colors;
    }
}
