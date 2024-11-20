package io.github.rosemoe.sora.widget;

import Ninja.coder.Ghostemane.code.utils.ObjectUtils;
import android.content.Context;
import android.content.res.ColorStateList;
import android.widget.TextView;
import android.widget.ImageView;
import com.google.android.material.color.MaterialColors;

import java.util.ArrayList;
import java.util.HashMap;

import Ninja.coder.Ghostemane.code.R;
import android.widget.LinearLayout;
import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.view.View;
import android.widget.BaseAdapter;

public class Sp1Adapter extends BaseAdapter {

    ArrayList<HashMap<String, Object>> _data;
    Context context;

    public Sp1Adapter(ArrayList<HashMap<String, Object>> _arr, Context context) {
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
        ObjectUtils.shapeViews(linear1);
        return _view;

    }
}