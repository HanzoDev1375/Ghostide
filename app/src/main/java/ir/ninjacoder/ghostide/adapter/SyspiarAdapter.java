package ir.ninjacoder.ghostide.adapter;

import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.utils.FileUtil;
import ir.ninjacoder.ghostide.utils.DataUtil;
import android.animation.ObjectAnimator;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class SyspiarAdapter extends RecyclerView.Adapter<SyspiarAdapter.ViewHolder> {

  protected HashMap<String, Object> imap;
  private ArrayList<HashMap<String, Object>> _data;
  private OnTabView tabview;
  private IdeEditor editor;

  public SyspiarAdapter(
      ArrayList<HashMap<String, Object>> _arr, OnTabView tabview, IdeEditor editor) {
    this._data = _arr;
    this.tabview = tabview;
    this.editor = editor;
    imap = new HashMap<>();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View _v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sysset, parent, false);
    RecyclerView.LayoutParams _lp =
        new RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    _v.setLayoutParams(_lp);
    return new ViewHolder(_v);
  }

  @Override
  public void onBindViewHolder(ViewHolder _holder, final int _position) {
    View _view = _holder.itemView;
    LinearLayout linear1 = _view.findViewById(R.id.linear1);
    TextView sysbarInsertId = _view.findViewById(R.id.sysbarInsertId);

    RecyclerView.LayoutParams _lp =
        new RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    _view.setLayoutParams(_lp);
    _clickAnimation(linear1);
    if (_data.get((int) _position).containsKey("Tab")) {
      sysbarInsertId.setText(_data.get((int) _position).get("Tab").toString());
    } else {
      sysbarInsertId.setText(_data.get((int) _position).get("post").toString());
    }
    _view.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            if (_data.get((int) _position).containsKey("Tab")) {
              sysbarInsertId.setText(_data.get((int) _position).get("Tab").toString());
              if (editor.getCursor().isSelected()) {
                editor.indentSelection();
              } else tabview.TAB("\t");

            } else {
              sysbarInsertId.setText(_data.get((int) _position).get("post").toString());
              if (tabview == null) {
                GhostIdeAppLoader.getEditor().appendText("4");
              }
              tabview.POST(sysbarInsertId.getText().toString());
              Log.e("POST", sysbarInsertId.getText().toString());
            }
          }
        });
    try {
      if (GhostIdeAppLoader.getsetFont().contains("mfont")) {
        if (!FileUtil.isFile(GhostIdeAppLoader.getsetFont().getString("mfont", ""))) {
          DataUtil.showMessage(GhostIdeAppLoader.getContext(), "Custom Font Not Found");
          sysbarInsertId.setTypeface(
              Typeface.createFromAsset(
                  GhostIdeAppLoader.getContext().getAssets(), "fonts/ghostfont.ttf"),
              0);
        } else {

          sysbarInsertId.setTypeface(
              Typeface.createFromFile(
                  new File(GhostIdeAppLoader.getsetFont().getString("mfont", ""))));
        }
      } else {
        sysbarInsertId.setTypeface(
            Typeface.createFromAsset(
                GhostIdeAppLoader.getContext().getAssets(), "fonts/ghostfont.ttf"),
            0);
      }
    } catch (Exception e) {
      Log.e("ErrorSymbolBar: ", e.getMessage());
    }
    sysbarInsertId.setOnTouchListener(
        new View.OnTouchListener() {
          @Override
          public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
              case MotionEvent.ACTION_DOWN:
                {
                  ObjectAnimator scaleX = new ObjectAnimator();
                  scaleX.setTarget(sysbarInsertId);
                  scaleX.setPropertyName("scaleX");
                  scaleX.setFloatValues(0.9f);
                  scaleX.setDuration((int) 5);
                  scaleX.start();

                  ObjectAnimator scaleY = new ObjectAnimator();
                  scaleY.setTarget(sysbarInsertId);
                  scaleY.setPropertyName("scaleY");
                  scaleY.setFloatValues(0.9f);
                  scaleY.setDuration((int) 5);
                  scaleY.start();
                  break;
                }
              case MotionEvent.ACTION_UP:
                {
                  ObjectAnimator scaleX = new ObjectAnimator();
                  scaleX.setTarget(sysbarInsertId);
                  scaleX.setPropertyName("scaleX");
                  scaleX.setFloatValues((float) 1);
                  scaleX.setDuration((int) 5);
                  scaleX.start();

                  ObjectAnimator scaleY = new ObjectAnimator();
                  scaleY.setTarget(sysbarInsertId);
                  scaleY.setPropertyName("scaleY");
                  scaleY.setFloatValues((float) 1);
                  scaleY.setDuration((int) 5);
                  scaleY.start();

                  break;
                }
            }
            return false;
          }
        });
    if (GhostIdeAppLoader.getRu().contains("rub")) {
      sysbarInsertId.setTextColor(0xFFC4A68A);
    } else {
    }
  }

  @Override
  public int getItemCount() {
    return _data.size();
  }

  public void _clickAnimation(View _view) {
    ScaleAnimation fade_in =
        new ScaleAnimation(
            0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
    fade_in.setDuration(300);
    fade_in.setFillAfter(true);
    _view.startAnimation(fade_in);
  }

  public interface OnTabView {
    public void TAB(String tab);

    public void POST(String post);
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(View v) {
      super(v);
    }
  }
}
