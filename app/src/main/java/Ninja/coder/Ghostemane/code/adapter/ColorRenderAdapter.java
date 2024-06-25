package Ninja.coder.Ghostemane.code.adapter;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

import java.util.ArrayList;
import java.util.HashMap;

public class ColorRenderAdapter extends BaseAdapter {

    ArrayList<HashMap<String, Object>> _data;
    Context context;

    public ColorRenderAdapter(ArrayList<HashMap<String, Object>> _arr, Context context) {
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

        View _view = LayoutInflater.from(context).inflate(R.layout.lbs, null);

        LinearLayout rooti = _view.findViewById(R.id.rooti);

        LinearLayout getTag = _view.findViewById(R.id.getTag);
        TextView titleview = _view.findViewById(R.id.titleview);
        TextView normaltext = _view.findViewById(R.id.normaltext);

        normaltext.setText(_data.get(_position).get("colorBind").toString());
        titleview.setText(normaltext.getText().toString().substring(0, 1));
        getTag.setBackground(getShape(getTag));
        titleview.setTextColor(Color.parseColor(_data.get(_position).get("colorBind").toString()));
        normaltext.setTextColor(Color.parseColor(_data.get(_position).get("colorBind").toString()));

        return _view;
    }

    private MaterialShapeDrawable getShape(View v) {
        MaterialShapeDrawable shapeDrawable =
                new MaterialShapeDrawable(
                        ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 18).build());
        shapeDrawable.setFillColor(
                ColorStateList.valueOf(MaterialColors.getColor(v, ColorAndroid12.Back, 0)));
        return shapeDrawable;
    }
}
