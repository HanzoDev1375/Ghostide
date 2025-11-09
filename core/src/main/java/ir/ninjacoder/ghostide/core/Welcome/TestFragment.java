package ir.ninjacoder.ghostide.core.Welcome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

import ir.ninjacoder.ghostide.core.R;

public class TestFragment extends Fragment {
  protected LottieAnimationView icon;
  protected TextView titles, Massges;
  protected Button itemClick;
  protected OnItemClickListener click;

  @Override
  public void onViewCreated(View arg0, Bundle arg1) {
    super.onViewCreated(arg0, arg1);
    // TODO: Implement this method
    icon = arg0.findViewById(R.id.ic);
    itemClick = arg0.findViewById(R.id.itemClick);
    titles = arg0.findViewById(R.id.titleMode);
    Massges = arg0.findViewById(R.id.Massges);
    icon.setAnimation(getArguments().getString("color"));
    titles.setText(getArguments().getString("title"));
    Massges.setText(getArguments().getString("text"));
    itemClick.setVisibility(getArguments().getBoolean("show") ? View.VISIBLE : View.INVISIBLE);
    if (click != null) {
      itemClick.setOnClickListener(c -> click.onItemClick());
    }
  }

  @Override
  public View onCreateView(LayoutInflater info, ViewGroup arg1, Bundle arg2) {
    // TODO: Implement this method
    return info.inflate(R.layout.fragment_test, arg1, false);
  }

  public static TestFragment newIns(String color, String text, String title, boolean isShow) {

    Bundle bl = new Bundle();
    bl.putString("color", color);
    bl.putString("text", text);
    bl.putString("title", title);
    bl.putBoolean("show", isShow);
    TestFragment test = new TestFragment();
    test.setArguments(bl);
    return test;
  }

  public TestFragment newIns1(String color, String text, String title) {

    Bundle bl = new Bundle();
    bl.putString("color", color);
    bl.putString("text", text);
    bl.putString("title", title);
    TestFragment test = new TestFragment();
    test.setArguments(bl);
    return test;
  }

  public interface OnItemClickListener {
    void onItemClick();
  }

  public void setCallBack(OnItemClickListener click) {
    this.click = click;
  }
}
