package ir.ninjacoder.ghostide.core.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class Recyclerview0Adapter extends RecyclerView.Adapter<Recyclerview0Adapter.ViewHolder> {

  public String text = "";
  protected OnItemClick call;
  private ArrayList<HashMap<String, Object>> _data;
  private CodeEditor editor;
  private Context context;

  public Recyclerview0Adapter(
      ArrayList<HashMap<String, Object>> _arr,
      CodeEditor editor,
      Context context,
      OnItemClick call) {
    this._data = _arr;
    this.editor = editor;
    this.context = context;
    this.call = call;
  }

  private static byte[] xor(byte[] bArr, String str) {
    var length = bArr.length;
    var length2 = str.length();
    var i = 0;
    var i2 = 0;
    while (i2 < length) {
      if (i >= length2) {
        i = 0;
      }
      bArr[i2] = (byte) (bArr[i2] ^ str.charAt(i));
      i2++;
      i++;
    }
    return bArr;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View _v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fogbind, parent, false);
    RecyclerView.LayoutParams _lp =
        new RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    _v.setLayoutParams(_lp);
    return new ViewHolder(_v);
  }

  @Override
  public void onBindViewHolder(ViewHolder _holder, final int _position) {
    View _view = _holder.itemView;

    RecyclerView.LayoutParams _lp =
        new RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    _view.setLayoutParams(_lp);
    final LinearLayout lib = _view.findViewById(R.id.lib);
    final LinearLayout main = _view.findViewById(R.id.main);
    final TextView tv3 = _view.findViewById(R.id.tv3);
    final TextView c1 = _view.findViewById(R.id.c1);
    tv3.setText(_Decrypt(_data.get((int) _position).get("post").toString().trim()));
    try {
      c1.setText(tv3.getText().toString().substring((int) (0), (int) (1)).trim());
    } catch (Exception e) {
      c1.setText("c");
    }
    tv3.setTextColor(MaterialColors.getColor(tv3, ObjectUtils.colorOnSurface, 0));
    text = tv3.getText().toString();
    c1.setTextColor(MaterialColors.getColor(tv3, ObjectUtils.colorOnSurface, 0));
    lib.setBackground(shap());
    main.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            main.setOnTouchListener(
                new View.OnTouchListener() {
                  @Override
                  public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                      case MotionEvent.ACTION_DOWN:
                        {
                          ObjectAnimator scaleX = new ObjectAnimator();
                          scaleX.setTarget(main);
                          scaleX.setPropertyName("scaleX");
                          scaleX.setFloatValues(0.9f);
                          scaleX.setDuration((int) 5);
                          scaleX.start();

                          ObjectAnimator scaleY = new ObjectAnimator();
                          scaleY.setTarget(main);
                          scaleY.setPropertyName("scaleY");
                          scaleY.setFloatValues(0.9f);
                          scaleY.setDuration((int) 5);
                          scaleY.start();
                          break;
                        }
                      case MotionEvent.ACTION_UP:
                        {
                          ObjectAnimator scaleX = new ObjectAnimator();
                          scaleX.setTarget(main);
                          scaleX.setPropertyName("scaleX");
                          scaleX.setFloatValues((float) 1);
                          scaleX.setDuration((int) 5);
                          scaleX.start();

                          ObjectAnimator scaleY = new ObjectAnimator();
                          scaleY.setTarget(main);
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
            call.onItemClick(_position);
          }
        });
    main.setOnLongClickListener(
        new View.OnLongClickListener() {
          @Override
          public boolean onLongClick(View _view) {
            call.onLongItemClick(_position);

            return true;
          }
        });
  }

  @Override
  public int getItemCount() {
    return _data.size();
  }

  public String encrypt(String str, String str2) {
    String encrypted = "";
    try {
      encrypted = new String(Base64.encode(xor(str.getBytes("UTF-8"), str2), 2));
    } catch (UnsupportedEncodingException e) {
      Log.e("Error", e.getLocalizedMessage());
    }
    return encrypted;
  }

  public String decrypt(String str, String str2) {
    var decrypted = "";
    try {
      decrypted = new String(xor(Base64.decode(str, 2), str2), "UTF-8");
    } catch (UnsupportedEncodingException e) {
      Log.e("Error", e.getLocalizedMessage());
    }
    return decrypted;
  }

  public String _Decrypt(final String _text) {
    String decrypted = "";
    try {
      decrypted = decrypt(_text, "UTF-8");
    } catch (Exception e) {
      decrypted = "Error : " + e.toString();
    }
    return decrypted;
  }

  protected MaterialShapeDrawable shap() {
    var shp =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 30f).build());
    shp.setFillColor(ColorStateList.valueOf(MaterialColors.getColor(context, ObjectUtils.Back, 0)));
    shp.setStroke(
        0.5f,
        ColorStateList.valueOf(MaterialColors.getColor(context, ObjectUtils.colorOnSurface, 0)));
    return shp;
  }

  public interface OnItemClick {
    public void onItemClick(int pos);

    public void onLongItemClick(int pos);
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(View v) {
      super(v);
    }
  }
}
