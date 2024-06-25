package Ninja.coder.Ghostemane.code.adapter;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.layoutmanager.ColorList;
import Ninja.coder.Ghostemane.code.marco.ColorView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class DirAdapter extends RecyclerView.Adapter<DirAdapter.ViewHolder> {

    ArrayList<HashMap<String, Object>> _data;
    CallBackClick click;

    public DirAdapter(ArrayList<HashMap<String, Object>> _arr,CallBackClick click) {
        _data = _arr;
       this.click=click;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View _v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.copyinsterfile, parent, false);
        RecyclerView.LayoutParams _lp =
                new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        _v.setLayoutParams(_lp);
        return new ViewHolder(_v);
    }

    @Override
    public void onBindViewHolder(ViewHolder _holder, final int _position) {
        View _view = _holder.itemView;

        final LinearLayout linear2 = _view.findViewById(R.id.linear2);
        final TextView textview2 = _view.findViewById(R.id.textview2);
        final ImageView imageview1 = _view.findViewById(R.id.imageview1);

        RecyclerView.LayoutParams _lp =
                new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        _view.setLayoutParams(_lp);
        textview2.setText(_data.get((int) _position).get("mo").toString());
        if (_position == (_data.size() - 1)) {
            imageview1.setVisibility(View.GONE);
        }
        ColorList.setColorAsRandom(imageview1, textview2);
        
       String file = _data.get(_position).get("mo").toString();
       
        textview2.setOnClickListener(v ->{
          click.onClick(_position,v);
        });
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
  
  public interface CallBackClick{
    public void onClick(int pos,View v);
  }
}
