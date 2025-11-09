package io.github.rosemoe.sora.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.color.MaterialColors;

import java.util.ArrayList;
import java.util.HashMap;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class Sp2Adapter extends BaseAdapter {

    ArrayList<HashMap<String, Object>> _data;
    Context context;

    public Sp2Adapter(ArrayList<HashMap<String, Object>> _arr, Context context) {
        _data = _arr;
        this.context = context;
    }

    @Override
    public int getCount() {
        return _data.size();
    }

    @Override
    public HashMap<String, Object> getItem(int _index) {
        return _data.get(_index);
    }

    @Override
    public long getItemId(int _index) {
        return _index;
    }

    @Override
    public View getView(final int _position, View _v, ViewGroup _container) {
        LayoutInflater _inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View _view = _v;
        if (_view == null) {
            _view = _inflater.inflate(R.layout.kth, null);
        }

        final LinearLayout linear1 = _view.findViewById(R.id.linear1);
        final ImageView imageview1 = _view.findViewById(R.id.imageview1);
        final TextView textview1 = _view.findViewById(R.id.textview1);

        textview1.setText(_data.get((int) _position).get("key").toString());
        textview1.setTextColor(ColorStateList.valueOf(MaterialColors.getColor(textview1, ObjectUtils.TvColor)));
        ObjectUtils.setColorFilter(imageview1);
        return _view;

    }
}
