package coyamo.visualxml.ui.adapter;

import Ninja.coder.Ghostemane.code.R;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import coyamo.visualxml.lib.utils.MessageArray;
import coyamo.visualxml.lib.utils.XmlMessage;

public class ErrorMessageAdapter extends RecyclerView.Adapter<ErrorMessageAdapter.ViewHolder> {
    private List<XmlMessage> msglist = new ArrayList<>();
    private MessageArray ma;

    public ErrorMessageAdapter() {
        ma = MessageArray.getInstanse();
        ma.setListener(new MessageArray.OnNewMessageListener() {
            @Override
            public void onNew(List<XmlMessage> list, XmlMessage m) {
                msglist.clear();
                msglist.addAll(list);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.error_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        XmlMessage fruit = msglist.get(position);
        switch (fruit.getType()) {
            case XmlMessage.TYPE_DEBUG:
                holder.text.setTextColor(Color.BLACK);
                holder.icon.setImageResource(R.drawable.ic_issue);
                break;
            case XmlMessage.TYPE_ERROR:
                holder.text.setTextColor(Color.RED);
                holder.icon.setImageResource(R.drawable.ic_error);
                break;
            case XmlMessage.TYPE_WARN:
                holder.text.setTextColor(Color.GRAY);
                holder.icon.setImageResource(R.drawable.ic_warning);
                break;
        }

        holder.text.setText(fruit.getMessage());
    }

    @Override
    public int getItemCount() {
        return msglist.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View item;
        ImageView icon;
        TextView text;

        public ViewHolder(View view) {
            super(view);
            item = view;
            icon = view.findViewById(R.id.icon);
            text = view.findViewById(R.id.text);
        }
    }

}