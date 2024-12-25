package ir.ninjacoder.ghostide.adapter;

import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.utils.FileUtil;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ListSearchAd extends BaseAdapter implements Adapter {

    ArrayList<HashMap<String, Object>> _data;

    public ListSearchAd(ArrayList<HashMap<String, Object>> _arr) {
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
    public View getView(int position, View _v, ViewGroup parant) {

        View mview = LayoutInflater.from(parant.getContext()).inflate(R.layout.aaa, parant, false);

        final LinearLayout main = mview.findViewById(R.id.main);
        final TextView tv = mview.findViewById(R.id.tv);
        final TextView tvnull = mview.findViewById(R.id.tvnull);
        final ImageView img = mview.findViewById(R.id.img);
        tv.setText(Uri.parse(_data.get((int) position).get("path").toString()).getLastPathSegment());
        var sodocerListMapRemainder = _data.get((int) position).get("path").toString();
        if (FileUtil.isDirectory(sodocerListMapRemainder)) {
            img.setImageResource(R.drawable.folder);
        } else {
            img.setImageResource(R.drawable.file);
        }

        return mview;
    }
}
