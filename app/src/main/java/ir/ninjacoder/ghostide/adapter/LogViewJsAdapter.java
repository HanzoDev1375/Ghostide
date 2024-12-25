package ir.ninjacoder.ghostide.adapter;

import ir.ninjacoder.ghostide.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.HashMap;

public class LogViewJsAdapter extends RecyclerView.Adapter<LogViewJsAdapter.VH> {
    ArrayList<HashMap<String, Object>> map = new ArrayList<>();

    public LogViewJsAdapter(ArrayList<HashMap<String, Object>> map) {
        this.map = map;
    }

    @Override
    public int getItemCount() {
        return map.size();
    }

    @Override
    public void onBindViewHolder(LogViewJsAdapter.VH viewholder, int pos) {
        //   viewholder.namelog.setText()
        var view = viewholder.itemView;
        RecyclerView.LayoutParams _lp =
                new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(_lp);
        viewholder.namelog.setText(map.get(pos).get("message").toString());
        if (map.get(pos).get("type").equals("warning")) {
            viewholder.taglog.setText("W");
        } else if (map.get(pos).get("type").equals("error")) {
            viewholder.taglog.setText("E");
        } else if (map.get(pos).get("type").equals("debug")) {
            viewholder.taglog.setText("D");
        } else if (map.get(pos).get("type").equals("tip")) {
            viewholder.taglog.setText("T");
        } else if (map.get(pos).get("type").equals("log")) {
            viewholder.taglog.setText("L");
        } else {
            viewholder.taglog.setText("U");
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup viewgr, int arg1) {
        // fake layout
        View views =
                LayoutInflater.from(viewgr.getContext()).inflate(R.layout.z_layout_js, viewgr, false);
//    RecyclerView.LayoutParams lp =
//        new RecyclerView.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//    views.setLayoutParams(lp);
        return new VH(views);
    }

    public class VH extends RecyclerView.ViewHolder {
        // taglog substring kon
        private MaterialCardView cardview;
        private TextView taglog, namelog;
        private ImageView img;

        public VH(View view) {
            super(view);
            cardview = view.findViewById(R.id.mcard_log);
            taglog = view.findViewById(R.id.taglog);
            namelog = view.findViewById(R.id.namelog);
            img = view.findViewById(R.id.iconcopy);
        }
    }
}
