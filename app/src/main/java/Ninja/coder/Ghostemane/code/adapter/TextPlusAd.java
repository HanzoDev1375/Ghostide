package Ninja.coder.Ghostemane.code.adapter;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.model.TextPlus;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TextPlusAd extends RecyclerView.Adapter<TextPlusAd.VH> {
    private List<TextPlus> listPlus;
    private OnItemClick click;

    public TextPlusAd(List<TextPlus> listPlus, OnItemClick click) {
        this.listPlus = listPlus;
        this.click = click;
    }

    @Override
    public int getItemCount() {
        return listPlus.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parant, int typeview) {
        View view =
                LayoutInflater.from(parant.getContext()).inflate(R.layout.a_filelayouth, parant, false);
        RecyclerView.LayoutParams _lp =
                new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(_lp);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH viewmodel, int pos) {
        var view = viewmodel.itemView;
        RecyclerView.LayoutParams _lp =
                new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(_lp);
        TextPlus plus = listPlus.get(pos);
        viewmodel.icon.setImageResource(plus.getIcon());
        viewmodel.txt.setText(plus.getName());
        viewmodel.itemView.setOnClickListener(v -> click.onClick(pos));
    }

    public interface OnItemClick {
        public void onClick(int pos);
    }

    public class VH extends RecyclerView.ViewHolder {
        protected ImageView icon;
        protected TextView txt;

        public VH(View view) {
            super(view);
            icon = view.findViewById(R.id.img_param);
            txt = view.findViewById(R.id.textplus);
        }
    }
}
