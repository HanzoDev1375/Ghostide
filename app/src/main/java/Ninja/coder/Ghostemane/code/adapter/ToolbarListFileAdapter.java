package Ninja.coder.Ghostemane.code.adapter;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.color.MaterialColors;

import java.io.File;
import java.util.List;

public class ToolbarListFileAdapter extends RecyclerView.Adapter<ToolbarListFileAdapter.VH> {

  public String Folder = "";
  protected CallBack back;
  protected boolean isClickNot = false;
  List<String> _data;
  Context context;

  public ToolbarListFileAdapter(List<String> _arr, Context context, CallBack back) {
    this._data = _arr;
    this.context = context;
    this.back = back;
  }

  @Override
  public VH onCreateViewHolder(ViewGroup parent, int viewType) {
    View _v = LayoutInflater.from(parent.getContext()).inflate(R.layout.instettab, parent, false);
    RecyclerView.LayoutParams _lp =
        new RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    _v.setLayoutParams(_lp);
    return new VH(_v);
  }

  @Override
  public void onBindViewHolder(VH holder, int _position) {
    View _view = holder.itemView;

    RecyclerView.LayoutParams _lp =
        new RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    _view.setLayoutParams(_lp);
    holder.textview2.setText(_data.get(_position));

    if (holder.textview2 != null) {
      File file = new File(_data.get(_position).toString());

      holder.textview2.setAlpha(file.isHidden() ? 0.5f : 1f);
    }
    holder.itemView.setOnClickListener(
        v -> {
          Log.e("This pos : ", _data.get(_position));
        });
    holder.textview2.setTextColor(
        MaterialColors.getColor(holder.textview2, ColorAndroid12.colorOnSurface));
    holder.imageview1.setColorFilter(
        MaterialColors.getColor(holder.imageview1, ColorAndroid12.colorOnSurface, 0),
        PorterDuff.Mode.SRC_IN);
    holder.textview2.setOnLongClickListener(
        longClick -> {
          isClickNot = true;
          if (isClickNot) {
            if (back != null) {
              back.GoToDir(holder.textview2);
            }
          }

          return false;
        });
    holder.textview2.setOnClickListener(
        v -> {
          if (back != null) {
            back.GoToTreeFile(v);
          }
        });
    if (_position == 0) {
      holder.textview2.setTextColor(
          MaterialColors.getColor(
              holder.textview2, com.google.android.material.R.attr.colorOutline, 0));
    }
  }

  @Override
  public int getItemCount() {
    return _data.size();
  }

  public File getFileFromBreadcrumb(List<String> items) {
    String filePath = String.join("/", items);
    return new File(filePath);
  }

  public interface CallBack {
    public void GoToDir(View view);

    public void GoToTreeFile(View view);
  }

  public class VH extends RecyclerView.ViewHolder {
    protected LinearLayout linear2;
    protected TextView textview2;
    protected ImageView imageview1;
    protected View bindview;

    public VH(View v) {
      super(v);
      linear2 = v.findViewById(R.id.linear2);
      textview2 = v.findViewById(R.id.textview2);
      imageview1 = v.findViewById(R.id.imageview1);
      bindview = v;
    }
  }
}
