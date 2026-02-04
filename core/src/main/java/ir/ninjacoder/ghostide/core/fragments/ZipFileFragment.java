package ir.ninjacoder.ghostide.core.fragments;

import android.view.LayoutInflater;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import ir.ninjacoder.ghostide.core.adapter.ZipListFileShowAd;
import ir.ninjacoder.ghostide.core.databinding.LayoutZipfragmentBinding;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import java.util.List;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

public class ZipFileFragment extends BottomSheetDialogFragment {
  private LayoutZipfragmentBinding bind;
  private List<FileHeader> fileHeaders = new ArrayList<>();
  private ZipListFileShowAd adapter;

  @Override
  @MainThread
  @Nullable
  public View onCreateView(LayoutInflater arg0, ViewGroup parant, Bundle arg2) {
    bind = LayoutZipfragmentBinding.inflate(LayoutInflater.from(getContext()), parant, false);
    return bind.getRoot();
  }

  @Override
  @MainThread
  public void onViewCreated(View arg0, Bundle arg1) {
    super.onViewCreated(arg0, arg1);

    String zipPath = getArguments().getString("zipPath", "");
    String folder = getArguments().getString("folder", "");

    adapter = new ZipListFileShowAd(requireContext(), fileHeaders, zipPath, folder);

    bind.rvZip.setLayoutManager(
        new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));

    try {
      ZipFile zipFile = new ZipFile(zipPath);
      fileHeaders = zipFile.getFileHeaders();
      adapter.updateAll(zipFile.getFileHeaders());
      bind.rvZip.setAdapter(adapter);

      if (fileHeaders == null || fileHeaders.isEmpty()) {
        DataUtil.showMessage(requireContext(), "Zip file is empty");
        dismiss();
        return;
      }
    } catch (ZipException e) {
      e.printStackTrace();
      DataUtil.showMessage(requireContext(), "Error opening zip file");
      dismiss();
      return;
    }
    new ItemTouchHelper(
            new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
              @Override
              public boolean onMove(
                  @NonNull RecyclerView recyclerView,
                  @NonNull RecyclerView.ViewHolder viewHolder,
                  @NonNull RecyclerView.ViewHolder target) {
                return false;
              }

              @Override
              public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                  if (!adapter.isMultiSelectMode()) {
                    adapter.enableMultiSelectMode();
                  }
                  adapter.toggleSelection(position, (ZipListFileShowAd.Holder) viewHolder);
                  adapter.notifyItemChanged(position);
                }
              }

              @Override
              public void clearView(
                  @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
              }
            })
        .attachToRecyclerView(bind.rvZip);

    bind.back.setOnClickListener(
        v -> {
          if (adapter.isMultiSelectMode()) {
            adapter.disableMultiSelectMode();
          } else if (!adapter.goBack()) {
            dismiss();
          }
        });
  }

  @Override
  @MainThread
  @CallSuper
  public void onDestroyView() {
    super.onDestroyView();
    bind = null;
  }
}
