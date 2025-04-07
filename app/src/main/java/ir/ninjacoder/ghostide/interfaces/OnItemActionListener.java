package ir.ninjacoder.ghostide.interfaces;
import java.util.List;

public interface OnItemActionListener {
  void onItemSelected(int position);

  void onItemDeselected(int position);

  void onDeleteRequested(List<Integer> positions);

  void onCopyRequested(List<Integer> positions);

  void onCutRequested(List<Integer> positions);
}
