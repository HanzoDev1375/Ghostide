package coyamo.visualxml.ui.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Ninja.coder.Ghostemane.code.R;
import coyamo.visualxml.lib.proxy.ProxyResources;
import coyamo.visualxml.lib.utils.Utils;
import coyamo.visualxml.ui.AlphaPatternDrawable;

public class ResourceListAdapter extends RecyclerView.Adapter<ResourceListAdapter.ViewHolder> {
    private Map<String, String> map;
    private int type;
    private Context ctx;

    public ResourceListAdapter(Context ctx, int type) {
        this.ctx = ctx;
        this.type = type;
        switch (type) {
            case 0:
                map = ProxyResources.getInstance().getStringMap();
                break;
            case 1:
                map = ProxyResources.getInstance().getDrawableMap();
                break;
            case 2:
                map = ProxyResources.getInstance().getColorMap();
                break;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.resource_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.icon.setBackground(new AlphaPatternDrawable(16));
        holder.item.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new AlertDialog.Builder(parent.getContext())
                                .setTitle("删除")
                                .setMessage("删除数据")
                                .setPositiveButton(
                                        "确定",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                map.remove(new ArrayList(map.keySet()).get(holder.getAdapterPosition()));
                                                notifyDataSetChanged();
                                            }
                                        })
                                .show();
                    }
                });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<String> names = new ArrayList<>(map.keySet());
        String value = map.get(names.get(position));
        holder.name.setText(names.get(position));
        holder.value.setText(value);
        holder.icon.setVisibility(View.VISIBLE);
        switch (type) {
            case 0: // str
                holder.icon.setVisibility(View.GONE);
                break;
            case 1: // drawable
                Drawable drawable = DrawableWrapper.createFromPath(value);
                if (drawable != null) {
                    holder.icon.setImageDrawable(drawable);
                } else Toast.makeText(holder.item.getContext(), "不是图片的路径", Toast.LENGTH_SHORT).show();
                break;
            case 2: // color
                if (Utils.isColor(value)) {
                    ColorDrawable cd = new ColorDrawable();
                    cd.setColor(Color.parseColor(value));
                    cd.setBounds(0, 0, 64, 64);
                    holder.icon.setImageDrawable(cd);
                } else Toast.makeText(holder.item.getContext(), "颜色格式错误", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public int getItemCount() {
        return map.size();
    }

    public void addData() {
        final int p = (int) Utils.dp2px(ctx, 24);
        final int pt = (int) Utils.dp2px(ctx, 16);
        final int pb = (int) Utils.dp2px(ctx, 20);
        LinearLayout ll = new LinearLayout(ctx);
        ll.setPadding(p, pt, p, pb);
        ll.setOrientation(LinearLayout.VERTICAL);

        final TextInputEditText n = new TextInputEditText(ctx);
        n.setHint("名字");

        final TextInputEditText va = new TextInputEditText(ctx);
        ll.addView(n);
        ll.addView(va);
        va.setHint("值");
        new AlertDialog.Builder(ctx)
                .setTitle("添加")
                .setView(ll)
                .setPositiveButton(
                        "确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String _key = n.getText().toString().trim();
                                String _value = va.getText().toString().trim();
                                if (!_key.isEmpty() && !_value.isEmpty()) {
                                    map.put(_key, _value);
                                    notifyDataSetChanged();
                                }
                            }
                        })
                .show();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView value;
        ImageView icon;
        View item;

        ViewHolder(View view) {
            super(view);
            item = view;
            icon = view.findViewById(R.id.resource_item_icon);
            name = view.findViewById(R.id.name);
            value = view.findViewById(R.id.value);
        }
    }
}
