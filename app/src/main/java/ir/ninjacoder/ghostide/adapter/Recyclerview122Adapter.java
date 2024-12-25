package ir.ninjacoder.ghostide.adapter;

import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.utils.FileUtil;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class Recyclerview122Adapter
        extends RecyclerView.Adapter<Recyclerview122Adapter.ViewHolder> {

    private ArrayList<HashMap<String, Object>> _data;
    private Context context;

    public Recyclerview122Adapter(ArrayList<HashMap<String, Object>> _arr, Context context) {
        _data = _arr;
        context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View _v = LayoutInflater.from(parent.getContext()).inflate(R.layout.editor_pop_layout, parent, false);
        RecyclerView.LayoutParams _lp =
                new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        _v.setLayoutParams(_lp);
        return new ViewHolder(_v);
    }

    @Override
    public void onBindViewHolder(ViewHolder _holder, final int _position) {
        View _view = _holder.itemView;
        Animation animation =
                AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        _view.startAnimation(animation);

        final TextView tv100 = _view.findViewById(R.id.tv100);
        final ImageView img100 = _view.findViewById(R.id.img100);
        RecyclerView.LayoutParams _lp =
                new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        _view.setLayoutParams(_lp);
        tv100.setText(
                Uri.parse(_data.get((int) _position).get("files").toString()).getLastPathSegment());
        if (FileUtil.isDirectory(_data.get((int) _position).get("files").toString())) {
            img100.setImageResource(R.drawable.folderhome);
        } else {
            img100.setImageResource(R.drawable.folders_0_5);
        }
    }

    @Override
    public int getItemCount() {
        return _data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }
}
