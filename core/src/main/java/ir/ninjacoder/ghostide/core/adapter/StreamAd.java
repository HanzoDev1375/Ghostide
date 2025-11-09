package ir.ninjacoder.ghostide.core.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.color.MaterialColors;

import java.util.List;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.model.ListitemModel;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class StreamAd extends RecyclerView.Adapter<StreamAd.VH> {

    protected List<ListitemModel> modelz;
    protected OnItemClick click;

    public StreamAd(List<ListitemModel> modelz, OnItemClick click) {
        this.modelz = modelz;
        this.click = click;
    }

    @Override
    public int getItemCount() {
        return modelz.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parant, int viewType) {
        return new VH(
                LayoutInflater.from(parant.getContext()).inflate(R.layout.stream_list_ad, parant, false));
    }

    @Override
    public void onBindViewHolder(VH holder, int pos) {
        ListitemModel model = modelz.get(pos);
        holder.tvid.setText(model.getId());
        holder.icon.setImageResource(model.getIcon());
        ObjectUtils.setColorFilter(holder.icon);
        holder.tvid.setTextColor(MaterialColors.getColor(holder.tvid, ObjectUtils.colorOnSurface, 0));

    }

    public interface OnItemClick {
        public void onClick(int pos, View c);
    }

    class VH extends RecyclerView.ViewHolder {
        protected TextView tvid;
        protected ImageView icon;

        public VH(View view) {
            super(view);
            tvid = view.findViewById(R.id.id_tv);
            icon = view.findViewById(R.id.icon_icons);
            if (click instanceof OnItemClick) {
                view.setOnClickListener(c -> click.onClick(getAdapterPosition(), c));
            }
        }
    }
}
