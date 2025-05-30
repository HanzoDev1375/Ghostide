package ir.ninjacoder.ghostide.marco;

import android.view.LayoutInflater;
import static android.view.View.GONE;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.ninjacoder.jgit.databinding.LayoutGitpullBinding;
import com.ninjacoder.jgit.license.utils.LicenseManager;
import com.ninjacoder.jgit.license.utils.LicenseSelectionDialog;
import ir.ninjacoder.ghostide.IdeEditor;

public class LicenseManagerImpl {
  private LayoutGitpullBinding binding;

  public void run(IdeEditor editor) {
    binding = LayoutGitpullBinding.inflate(LayoutInflater.from(editor.getContext()));
    binding.userName.setHint("author name");
    binding.remote.setHint("company name");
    binding.token.setVisibility(GONE);

    LicenseSelectionDialog.show(
        editor.getContext(),
        lis -> {
          String licensedCode =
              LicenseManager.addLicenseToCode(
                  editor.getText().toString(),
                  lis,
                  binding.remote.getEditText().getText().toString(),
                  binding.userName.getEditText().getText().toString());
          new MaterialAlertDialogBuilder(editor.getContext())
              .setView(binding.getRoot())
              .setPositiveButton("past", (r, e) -> {
				  editor.setText(licensedCode);
			  })
              .show();
        });
  }
}
