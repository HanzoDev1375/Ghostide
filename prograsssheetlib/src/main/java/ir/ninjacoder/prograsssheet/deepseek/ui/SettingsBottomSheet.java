package ir.ninjacoder.prograsssheet.deepseek.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import ir.ninjacoder.prograsssheet.R;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import ir.ninjacoder.prograsssheet.databinding.BottomSheetSettingsBinding;
import ir.ninjacoder.prograsssheet.deepseek.setting.PrefManager;

public class SettingsBottomSheet extends BottomSheetDialogFragment {

  private TextInputEditText apiKeyInput;
  private TextInputLayout apiKeyLayout;
  private MaterialSwitch modeSwitch;
  private MaterialSwitch streamSwitch;
  private MaterialButton saveButton;
  private TextView currentModelText;
  private BottomSheetSettingsBinding binding;
  private PrefManager prefManager;
  private OnSettingsChangedListener listener;

  public interface OnSettingsChangedListener {
    void onSettingsChanged();
  }

  public void setOnSettingsChangedListener(OnSettingsChangedListener listener) {
    this.listener = listener;
  }

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = BottomSheetSettingsBinding.inflate(inflater, container, false);

    prefManager = PrefManager.getInstance(requireContext());

    initViews();
    loadSettings();
    setupListeners();

    return binding.getRoot();
  }

  private void initViews() {
    apiKeyLayout = binding.apiKeyLayout;
    apiKeyInput = binding.apiKeyInput;
    modeSwitch = binding.modeSwitch;
    streamSwitch = binding.streamSwitch;
    saveButton = binding.saveButton;
    currentModelText = binding.currentModelText;
  }

  private void loadSettings() {
    String savedApiKey = prefManager.getApiKey();
    if (!TextUtils.isEmpty(savedApiKey)) {
      apiKeyInput.setText(savedApiKey);
    }

    boolean isExpert = prefManager.isExpertMode();
    modeSwitch.setChecked(isExpert);
    boolean streamEnabled = prefManager.isStreamEnabled();
    streamSwitch.setChecked(streamEnabled);

    updateModelText();
  }

  private void setupListeners() {
    modeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> updateModelText());

    saveButton.setOnClickListener(
        v -> {
          String apiKey = apiKeyInput.getText().toString().trim();

          if (TextUtils.isEmpty(apiKey)) {
            apiKeyLayout.setError(getString(R.string.settings_api_key_required));
            return;
          }
          apiKeyLayout.setError(null);
          prefManager.saveApiKey(apiKey);
          prefManager.saveModelMode(modeSwitch.isChecked());
          prefManager.saveStreamEnabled(streamSwitch.isChecked());

          Toast.makeText(getContext(), getString(R.string.settings_saved), Toast.LENGTH_SHORT)
              .show();

          if (listener != null) {
            listener.onSettingsChanged();
          }

          dismiss();
        });
  }

  private void updateModelText() {
    String modelName =
        modeSwitch.isChecked()
            ? getString(R.string.settings_model_expert)
            : getString(R.string.settings_model_fast);
    currentModelText.setText(getString(R.string.settings_current_model) + modelName);
  }
}
