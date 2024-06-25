package Ninja.coder.Ghostemane.code.adapter;

import Ninja.coder.Ghostemane.code.R;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MyListView110Adapter extends BaseAdapter implements Adapter {

    ArrayList<HashMap<String, Object>> _data;

    public MyListView110Adapter(ArrayList<HashMap<String, Object>> _arr) {
        _data = _arr;
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
        _v =
                LayoutInflater.from(_container.getContext())
                        .inflate(R.layout.onbindecolorsxmlview, _container, false);

        final TextView data = _v.findViewById(R.id.data);
        final TextView title = _v.findViewById(R.id.title);
        final LinearLayout salca = _v.findViewById(R.id.salca);
        try {
            title.setText(_data.get((int) _position).get("mcolor").toString().trim());
        } catch (Exception e) {
            title.setText("null");
        }
        try {
            data.setText(title.getText().toString().substring((int) (1), (int) (2)));
        } catch (Exception e) {
            data.setText("n");
        }
        try {
            salca.setBackground(
                    new GradientDrawable() {
                        public GradientDrawable getIns(int a, int b) {
                            this.setCornerRadius(a);
                            this.setColor(b);
                            return this;
                        }
                    }.getIns(
                            (int) 18, Color.parseColor(_data.get((int) _position).get("mcolor").toString())));
        } catch (Exception e) {
            salca.setBackground(
                    new GradientDrawable() {
                        public GradientDrawable getIns(int a, int b) {
                            this.setCornerRadius(a);
                            this.setColor(b);
                            return this;
                        }
                    }.getIns((int) 18, 0xFFE91E63));
        }
        try {
            int setColor = Color.parseColor(title.getText().toString());
            if (isColorDark(setColor)) {
                data.setTextColor(Color.WHITE);
            } else {
                data.setTextColor(Color.BLACK);
            }
        } catch (Exception e) {
            /// For Error List Map
            throw new RuntimeException("Error ? Add Your Color : ".concat(e.toString()));
        }
        title.setTextColor(Color.WHITE);

        return _v;
    }

    private boolean isColorDark(int color) {
        double darkness =
                1
                        - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color))
                        / 255;
        return darkness >= 0.5;
    }
}
