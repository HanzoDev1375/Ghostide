package ir.ninjacoder.ghostide.core.fragments;

import android.view.LayoutInflater;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import ir.ninjacoder.ghostide.core.adapter.ZipListFileShowAd;
import ir.ninjacoder.ghostide.core.databinding.LayoutZipfragmentBinding;
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
    private OnBackPressedCallback call;
    private List<FileHeader> fileHeaders = new ArrayList<>();
    private ZipListFileShowAd adapter;

    @Override
    @MainThread
    @Nullable
    public View onCreateView(LayoutInflater arg0, ViewGroup parant, Bundle arg2) {
        // TODO: Implement this method
        bind = LayoutZipfragmentBinding.inflate(LayoutInflater.from(getContext()), parant, false);
        return bind.getRoot();
    }

    @Override
    @MainThread
    public void onViewCreated(View arg0, Bundle arg1) {
        super.onViewCreated(arg0, arg1);
        setCancelable(false);
        adapter = new ZipListFileShowAd(
        requireContext(),
        fileHeaders,
        getArguments().getString("zipPath", ""),
        getArguments().getString("folder"));
        bind.rvZip.setLayoutManager(
                new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));

        try {
            ZipFile zipFile = new ZipFile(getArguments().getString("zipPath", ""));
            fileHeaders = zipFile.getFileHeaders();
            adapter.updateAll(zipFile.getFileHeaders());
            bind.rvZip.setAdapter(adapter);
            if (fileHeaders == null || fileHeaders.isEmpty()) {
                Toast.makeText(requireContext(), "Zip file is empty", Toast.LENGTH_SHORT).show();
                dismiss();
                return;
            }
        } catch (ZipException e) {
            e.printStackTrace();
        }
        adapter.setOnListStateListener(new ZipListFileShowAd.OnListStateListener() {
            @Override
            public void onListEmpty() {

                dismiss();
            }

            @Override
            public void onGoBackRequested(boolean canGoBack) {

                adapter.goBack();
            }
        });
        bind.back.setOnClickListener(
                v -> {
                    adapter.goBack();
                });

        call = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (!adapter.goBack()) {
                    dismiss();
                }
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this, call);
    }

    @Override
    @MainThread
    @CallSuper
    public void onDestroyView() {
        super.onDestroyView();
        if (call != null) {
            call.remove();
        }
        bind = null;
    }
}
