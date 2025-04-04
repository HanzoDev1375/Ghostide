package ir.ninjacoder.ghostide.Store;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class FontFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    TextView textView = new TextView(getContext());
    textView.setPadding(8,8,8,8);
    textView.setGravity(Gravity.CENTER);
    textView.setText("Font Soon!!");
    return textView;
  }
}
