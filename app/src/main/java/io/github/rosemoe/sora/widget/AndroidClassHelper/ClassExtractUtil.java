package io.github.rosemoe.sora.widget.AndroidClassHelper;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import ir.ninjacoder.ghostide.R;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Toast;
import android.widget.ListView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ClassExtractUtil {

    private final int CLASS = 0;
    private final int CLASS_DECLARED = 1;
    private final int METHOD = 2;
    private final int METHOD_DECLARED = 3;
    private final int CONSTRUCTOR = 4;
    private final int CONSTRUCTOR_DECLARED = 5;
    private final int FIELD = 6;
    private final int FIELD_DECLARED = 7;
    private String className;
    private ArrayList<String> list = new ArrayList<>();

    public ClassExtractUtil(String className) {
        this.className = className;
    }

    public ClassExtractUtil() {
    }

    public ArrayList<String> getList() {
        return list;
    }

    public String getStringArray() {
        return Arrays.toString(list.toArray());
    }

    public Class<?> getClassName() throws ClassNotFoundException {
        return Class.forName(className);
    }

    public String getSimpleName() throws ClassNotFoundException {
        return getClassName().getSimpleName();
    }

    public String getCanonicalName() throws ClassNotFoundException {
        return getClassName().getCanonicalName();
    }

    public String getPackageName() throws ClassNotFoundException {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            return getClassName().getPackageName();
        }
        return null;
    }

    public String getTypeName() throws ClassNotFoundException {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return getClassName().getTypeName();
        }
        return null;
    }

    public ArrayList<String> getClasses() throws ClassNotFoundException {
        extract(CLASS);
        return list;
    }

    public ArrayList<String> getDeclaredClasses() throws ClassNotFoundException {
        extract(CLASS_DECLARED);
        return list;
    }

    public ArrayList<String> getMethods() throws ClassNotFoundException {
        extract(METHOD);
        return list;
    }

    public ArrayList<String> getDeclaredMethods() throws ClassNotFoundException {
        extract(METHOD_DECLARED);
        return list;
    }

    public ArrayList<String> getConstructors() throws ClassNotFoundException {
        extract(CONSTRUCTOR);
        return list;
    }

    public ArrayList<String> getDeclaredConstructors() throws ClassNotFoundException {
        extract(CONSTRUCTOR_DECLARED);
        return list;
    }

    public ArrayList<String> getFields() throws ClassNotFoundException {
        extract(FIELD);
        return list;
    }

    public ArrayList<String> getDeclaredFields() throws ClassNotFoundException {
        extract(FIELD_DECLARED);
        return list;
    }

    private void extract(int cls) throws ClassNotFoundException {
        switch (cls) {
            case CLASS:
                for (Class<?> m : getClassName().getClasses()) {
                    list.add(m.getName());
                }
                break;
            case CLASS_DECLARED:
                for (Class<?> m : getClassName().getDeclaredClasses()) {
                    list.add(m.getName());
                }
                break;
            case METHOD:
                for (Method m : getClassName().getMethods()) {
                    list.add(m.getName());
                }
                break;
            case METHOD_DECLARED:
                for (Method m : getClassName().getDeclaredMethods()) {
                    list.add(m.getName());
                }
                break;
            case CONSTRUCTOR:
                for (Constructor<?> m : getClassName().getConstructors()) {
                    list.add(m.getName());
                }
                break;
            case CONSTRUCTOR_DECLARED:
                for (Constructor<?> m : getClassName().getDeclaredConstructors()) {
                    list.add(m.getName());
                }
                break;
            case FIELD:
                for (Field m : getClassName().getFields()) {
                    list.add(m.getName());
                }
                break;
            case FIELD_DECLARED:
                for (Field m : getClassName().getDeclaredFields()) {
                    list.add(m.getName());
                }
                break;
        }
    }

    public void init(Context context, String txt) {
        ArrayList<HashMap<String, Object>> lists = new ArrayList<>();
        MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(context);
        dialogBuilder.setTitle("CLassView");

        dialogBuilder.setPositiveButton("ok", null);
        ListView view = new ListView(context);
        view.setLayoutParams(
                new ListView.LayoutParams(ListView.LayoutParams.WRAP_CONTENT, ListView.LayoutParams.WRAP_CONTENT));
        dialogBuilder.setView(view);
        dialogBuilder.show();
        ClassExtractUtil util = new ClassExtractUtil(txt);

        try {
            ArrayList<String> list = util.getDeclaredMethods();
            for (int _repeat26 = 0; _repeat26 < (list.size()); _repeat26++) {
                {
                    HashMap<String, Object> _item = new HashMap<>();
                    _item.put("key", list.get((_repeat26)));
                    lists.add(_item);
                }

            }

            view.setAdapter(new Listview2Adapter(lists, context));
            ((BaseAdapter) view.getAdapter()).notifyDataSetChanged();
            //view.setAdapter(new ArrayAdapter<String>(getBaseContext(), R.layout.test, list));
            view.setDividerHeight(0);
            view.setOnItemClickListener((parent, mview, position, id) -> {
                Toast.makeText(context.getApplicationContext(), list.get(position), 2).show();
            });
        } catch (Exception e) {

        }
    }

    private MaterialShapeDrawable shapeDrawable() {
        MaterialShapeDrawable shape = new MaterialShapeDrawable(
                ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 76).build());
        shape.setFillColor(ColorStateList.valueOf(Color.parseColor("#ff693c00")));
        shape.setElevation(1);
        return shape;
    }

    public class Listview2Adapter extends BaseAdapter {

        ArrayList<HashMap<String, Object>> _data;
        Context context;

        public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr, Context context) {
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
                _view = _inflater.inflate(R.layout.lbs, null);
            }
            final LinearLayout rooti = _view.findViewById(R.id.rooti);
            final LinearLayout linear2 = _view.findViewById(R.id.linear2);
            final LinearLayout linear3 = _view.findViewById(R.id.linear3);
            final LinearLayout getTag = _view.findViewById(R.id.getTag);
            final TextView titleview = _view.findViewById(R.id.titleview);
            final TextView normaltext = _view.findViewById(R.id.normaltext);

            normaltext.setText(_data.get(_position).get("key").toString());
            titleview.setText(normaltext.getText().toString().substring(0, 1));
            getTag.setBackground(shapeDrawable());
            return _view;
        }

    }

}
