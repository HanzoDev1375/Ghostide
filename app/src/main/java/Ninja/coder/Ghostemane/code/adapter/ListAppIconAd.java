package Ninja.coder.Ghostemane.code.adapter;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.databinding.AppsBinding;
import android.view.LayoutInflater;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import java.util.HashMap;
import android.view.View;
import android.view.ViewGroup;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import java.util.List;

public class ListAppIconAd extends BaseAdapter implements Adapter {

  List<HashMap<String, Object>> data;
  

  public ListAppIconAd(List<HashMap<String, Object>> arr) {
    data = arr;
  }

  @Override
  public int getCount() {
    return data.size();
  }

  @Override
  public HashMap<String, Object> getItem(int index) {
    return data.get(index);
  }

  @Override
  public long getItemId(int index) {
    return index;
  }

  @Override
  public View getView(int position, View v, ViewGroup container) {
    
    AppsBinding bin = AppsBinding.inflate(LayoutInflater.from(container.getContext()));
    ObjectAnimator animator =
        ObjectAnimator.ofFloat(bin.imageview1, "translationX", -10f, 10f, -5f, 5f, -2f, 2f, 0f);
    animator.setDuration(1000);
    animator.setInterpolator(new LinearInterpolator());
    animator.setRepeatCount(ObjectAnimator.INFINITE);

    animator.start();

    if (position == 0) {
      
      bin.textview1.setText("پیشفرض");
      bin.imageview1.setImageResource(R.mipmap.ghosticon);
    }
    if (position == 1) {
      bin.textview1.setText("ابی");
      bin.imageview1.setImageResource(R.drawable.ghosticonblue);
    }
    if (position == 2) {
      bin.textview1.setText("سیاه");
      bin.imageview1.setImageResource(R.drawable.ghosticonblack);
    }
    if (position == 3) {
      bin.textview1.setText("قرمز");
      bin.imageview1.setImageResource(R.drawable.ghosticonred);
    }
    if (position == 4) {
      bin.textview1.setText("زرد");
      bin.imageview1.setImageResource(R.drawable.ghosticonyellow);
    }
    if (position == 5) {
      bin.textview1.setText("بنفش یشمی");
      bin.imageview1.setImageResource(R.drawable.ghosticonpapermod);
    }
    if (position == 6) {
      bin.textview1.setText("سبز لجنی");
      bin.imageview1.setImageResource(R.drawable.ghosticongreenhell);
    }
    if (position == 7) {
      bin.textview1.setText("ابی تیره ۲ رنگ");
      bin.imageview1.setImageResource(R.drawable.ghosticonbluemod);
    }
    

    return bin.getRoot();
  }
}
