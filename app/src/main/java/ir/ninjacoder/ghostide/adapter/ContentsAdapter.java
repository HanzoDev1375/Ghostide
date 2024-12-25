package ir.ninjacoder.ghostide.adapter;

import ir.ninjacoder.ghostide.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

public class ContentsAdapter extends RecyclerView.Adapter<ContentsAdapter.ViewHolder> {

    private List<String> orderedList = new ArrayList<>();
    private Map<String, Object> source;
    private String currentDirectory = "";
    private List<Integer> checkedItems = new ArrayList<>();
    private boolean longClicked = false;
    private Context context;

    public ContentsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.views, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String key = orderedList.get(position);
        Object obj = source.get(key);

        // Populate your views based on obj and key

        if (!longClicked) {
            holder.chkBox.setVisibility(View.VISIBLE);
        } else {
            holder.chkBox.setVisibility(View.VISIBLE);
        }

        holder.chkBox.setChecked(checkedItems.contains(position));

        if ("..".equals(key)) {
            holder.chkBox.setEnabled(false);
        }

        // Set click listeners or any other view operations here
    }

    @Override
    public int getItemCount() {
        return orderedList.size();
    }

    public Map<String, Object> getSource() {
        return source;
    }

    public void setSource(Map<String, Object> source) {
        this.source = source;
        checkedItems.clear();
        orderedList.clear();
        // Update here to correctly display and access source values
        for (Map.Entry<String, Object> entry : source.entrySet()) {
            if (!"..".equals(entry.getKey())) {
                orderedList.add(entry.getKey());
            }
        }
        Collections.sort(orderedList);
        notifyDataSetChanged();
    }

    // Implement other overridden methods like getItemViewType if needed

    // Implement the rest of the methods like item click listeners, etc.

    public Map<String, Object> getCheckedItems() {
        Map<String, Object> items = new HashMap<>();
        for (Integer position : checkedItems) {
            String key = orderedList.get(position);
            Object value = source.get(key);
            items.put(key, value);
        }
        return items;
    }

    public void uncheckItems() {
        checkedItems.clear();
        notifyDataSetChanged();
    }

    public String getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(String currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView entry;
        TextView desc;
        CheckBox chkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageview1);
            entry = itemView.findViewById(R.id.textview1);
            desc = itemView.findViewById(R.id.textview2);
            chkBox = itemView.findViewById(R.id.checkbox1);

            chkBox.setOnCheckedChangeListener(
                    (button, isChecked) -> {
                        int position = getAdapterPosition();
                        if (isChecked && !checkedItems.contains(position)) {
                            checkedItems.add(position);
                        } else if (!isChecked && checkedItems.contains(position)) {
                            checkedItems.remove(Integer.valueOf(position));
                        }
                    });
        }
    }
}
