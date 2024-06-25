package coyamo.visualxml.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import coyamo.visualxml.lib.utils.Utils;

public class SignAdapter extends RecyclerView.Adapter<SignAdapter.ViewHolder> {
    private String sign[] = {"\t", "<", ">", "/", "=", "\"", ":", "@", "+", "(", ")", ";", ",", ".", "?", "|", "\\", "&", "!", "[", "]", "{", "}", "_", "-"};

    private EditText editor;

    public SignAdapter(EditText editor) {
        this.editor = editor;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv = new TextView(parent.getContext());
        int size = (int) Utils.dp2px(parent.getContext(), 5);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.MATCH_PARENT);
        lp.setMargins(size, size, size, size);
        tv.setLayoutParams(lp);
        //tv.setPadding(size,size,size,size);
        tv.setTextSize(20);
        tv.setMinWidth(size * 8);
        tv.setMinHeight(size * 4);
        final ViewHolder holder = new ViewHolder(tv);
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.getText().insert(editor.getSelectionStart(), (sign[holder.getPosition()]));
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(position == 0 ? "TAB" : sign[position]);
    }

    @Override
    public int getItemCount() {
        return sign.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public ViewHolder(View view) {
            super(view);

            text = (TextView) view;
        }
    }

}

