package ir.ninjacoder.ghostide.Store;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SvgStoreFragment extends Fragment {
  private TextView view;

  @Override
  @MainThread
  @Nullable
  public View onCreateView(LayoutInflater arg0, ViewGroup arg1, Bundle arg2) {
    view = new TextView(requireActivity());
    return view;
  }

  @Override
  @MainThread
  public void onViewCreated(View arg0, Bundle arg1) {
    super.onViewCreated(arg0, arg1);
    // TODO: Implement this method
    view.setText("Soon to version 2.0.5");
    view.setGravity(Gravity.CENTER);
  }
}
