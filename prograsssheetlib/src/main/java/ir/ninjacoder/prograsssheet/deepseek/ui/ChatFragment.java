package ir.ninjacoder.prograsssheet.deepseek.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import ir.ninjacoder.prograssheet.deepseek.adapter.ChatAdapter;
import ir.ninjacoder.prograsssheet.R;
import ir.ninjacoder.prograsssheet.databinding.FragmentChatBinding;
import ir.ninjacoder.prograsssheet.deepseek.model.Message;
import ir.ninjacoder.prograsssheet.deepseek.api.DeepSeekApiService;
import ir.ninjacoder.prograsssheet.deepseek.setting.PrefManager;
import ir.ninjacoder.prograsssheet.deepseek.manager.ChatHistoryManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ChatFragment extends Fragment {

  public interface ChatFragmentListener {
    void onChatSaved();

    void onChatLoaded(String chatId, String title);

    void onNewChatStarted();
  }

  private RecyclerView chatRecyclerView;
  private EditText messageInput;
  private ImageButton sendButton;
  private Button clearButton;
  private Button attachFileButton;
  private MaterialButton searchToggleButton;
  private FloatingActionButton settingsFab;
  private ProgressBar loadingIndicator;
  private TextView statusText;
  private ChipGroup fileChipGroup;
  private LinearLayout filePreviewContainer;
  private ChatAdapter chatAdapter;
  private List<Message> messages = new ArrayList<>();
  private DeepSeekApiService apiService;
  private PrefManager prefManager;
  private ChatHistoryManager historyManager;
  private FragmentChatBinding binding;
  private boolean isSearchEnabled = false;
  private List<UploadedFile> uploadedFiles = new ArrayList<>();
  private Map<String, File> tempFileMap = new HashMap<>();
  private ChatFragmentListener listener;
  private String pendingMessage = null;

  public void setChatFragmentListener(ChatFragmentListener listener) {
    this.listener = listener;
  }

  public void setPendingMessage(String text) {
    this.pendingMessage = text;
  }

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentChatBinding.inflate(inflater, container, false);
    initViews();
    initServices();
    setupRecyclerView();
    setupListeners();
    checkApiKey();
    if (savedInstanceState == null) {
      addWelcomeMessage();
    }
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    if (pendingMessage != null && !pendingMessage.isEmpty()) {
      messageInput.setText(pendingMessage);
      pendingMessage = null;
    }
  }

  private void initViews() {
    chatRecyclerView = binding.chatRecyclerView;
    messageInput = binding.messageInput;
    sendButton = binding.sendButton;
    clearButton = binding.clearButton;
    attachFileButton = binding.attachFileButton;
    searchToggleButton = binding.searchToggleButton;
    settingsFab = binding.settingsFab;
    loadingIndicator = binding.loadingIndicator;
    statusText = binding.statusText;
    fileChipGroup = binding.fileChipGroup;
    filePreviewContainer = binding.filePreviewContainer;
    binding.searchToggleButton.setOpticalCenterEnabled(true);
  }

  private void initServices() {
    prefManager = PrefManager.getInstance(requireContext());
    apiService = new DeepSeekApiService();
    String savedApiKey = prefManager.getApiKey();
    if (!TextUtils.isEmpty(savedApiKey)) {
      apiService.setApiKey(savedApiKey);
    }
    historyManager = ChatHistoryManager.getInstance(requireContext());
  }

  private void setupRecyclerView() {
    chatAdapter = new ChatAdapter(messages);
    chatAdapter.setOnRegenerateListener(
        position -> {
          Message message = messages.get(position);
          if ("assistant".equals(message.getRole()) && !message.isStreaming()) {
            messages.remove(position);
            chatAdapter.notifyItemRemoved(position);
            sendMessage();
          }
        });
    chatRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    chatRecyclerView.setAdapter(chatAdapter);
  }

  private void onRegenerateFinished(int position) {
    chatAdapter.stopRegenerateAnimationAt(position);
  }

  private void setupListeners() {
    sendButton.setOnClickListener(v -> sendMessage());

    clearButton.setOnClickListener(
        v -> {
          new MaterialAlertDialogBuilder(requireContext())
              .setTitle("Clear chat")
              .setMessage("Are you sure you want to clear all messages?")
              .setPositiveButton("Yes", (dialog, which) -> clearChat())
              .setNegativeButton("No", null)
              .show();
        });

    settingsFab.setOnClickListener(v -> showSettings());

    searchToggleButton.setOnClickListener(
        v -> {
          isSearchEnabled = !isSearchEnabled;
          searchToggleButton.setSelected(isSearchEnabled);
          Toast.makeText(
                  getContext(),
                  isSearchEnabled ? "Search enabled" : "Search disabled",
                  Toast.LENGTH_SHORT)
              .show();
        });

    attachFileButton.setOnClickListener(v -> showMultiFilePicker());

    messageInput.setOnEditorActionListener(
        (v, actionId, event) -> {
          if (actionId == EditorInfo.IME_ACTION_SEND) {
            sendMessage();
            return true;
          }
          return false;
        });
  }

  private void clearChat() {
    messages.clear();
    clearUploadedFiles();
    addWelcomeMessage();
    chatAdapter.notifyDataSetChanged();
    historyManager.startNewChat();
    if (listener != null) {
      listener.onNewChatStarted();
    }
  }

  public void startNewChat() {
    if (hasMessages()) {
      new MaterialAlertDialogBuilder(requireContext())
          .setTitle("New chat")
          .setMessage("Save current chat?")
          .setPositiveButton(
              "Save",
              (dialog, which) -> {
                saveChatToHistory();
                clearChat();
              })
          .setNegativeButton("Don't save", (dialog, which) -> clearChat())
          .setNeutralButton(
              "exit",
              (c, t) -> {
                requireActivity().finish();
              })
          .show();
    } else {
      getActivity().finish();
    }
  }

  public void loadChat(String chatId) {
    List<Message> loadedMessages = historyManager.loadChat(chatId);
    if (loadedMessages != null && !loadedMessages.isEmpty()) {
      messages.clear();
      messages.addAll(loadedMessages);
      chatAdapter.notifyDataSetChanged();
      chatRecyclerView.scrollToPosition(messages.size() - 1);
      String title = historyManager.getCurrentChatTitle();
      if (listener != null) {
        listener.onChatLoaded(chatId, title);
      }
      Toast.makeText(getContext(), "Chat loaded", Toast.LENGTH_SHORT).show();
    }
  }

  private void showMultiFilePicker() {
    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
    intent.setType("*/*");
    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
    intent.addCategory(Intent.CATEGORY_OPENABLE);
    String[] mimeTypes = {
      "text/x-java-source",
      "text/x-kotlin",
      "text/x-python",
      "application/javascript",
      "application/typescript",
      "application/dart",
      "text/x-go",
      "text/x-rust",
      "text/x-c",
      "text/x-c++",
      "text/x-csharp",
      "application/x-httpd-php",
      "text/x-ruby",
      "text/x-lua",
      "text/html",
      "text/css",
      "text/x-markdown",
      "text/x-yaml",
      "application/json",
      "text/xml",
      "text/x-sh",
      "text/csv",
      "text/xml",
      "text/*"
    };
    intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
    startActivityForResult(intent, 1001);
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 1001 && resultCode == Activity.RESULT_OK && data != null) {
      List<Uri> uris = new ArrayList<>();
      if (data.getClipData() != null) {
        int count = data.getClipData().getItemCount();
        for (int i = 0; i < count; i++) {
          uris.add(data.getClipData().getItemAt(i).getUri());
        }
      } else if (data.getData() != null) {
        uris.add(data.getData());
      }
      if (!uris.isEmpty()) {
        uploadMultipleFiles(uris);
      }
    }
  }

  private void uploadMultipleFiles(List<Uri> uris) {
    setLoading(true);
    filePreviewContainer.setVisibility(View.VISIBLE);
    fileChipGroup.removeAllViews();
    uploadedFiles.clear();
    tempFileMap.values().forEach(File::delete);
    tempFileMap.clear();

    AtomicInteger pendingUploads = new AtomicInteger(uris.size());
    AtomicInteger successCount = new AtomicInteger(0);
    List<String> errors = new ArrayList<>();

    for (int i = 0; i < uris.size(); i++) {
      Uri uri = uris.get(i);
      String fileName = getFileName(uri);
      int index = i;

      Chip chip = new Chip(requireContext());
      chip.setText(fileName);
      chip.setCloseIconVisible(true);
      chip.setTag("pending_" + index);
      chip.setOnCloseIconClickListener(v -> fileChipGroup.removeView(chip));
      fileChipGroup.addView(chip);

      uploadSingleFile(
          uri,
          new DeepSeekApiService.FileUploadCallback() {
            @Override
            public void onSuccess(String fileId) {
              requireActivity()
                  .runOnUiThread(
                      () -> {
                        uploadedFiles.add(new UploadedFile(fileId, fileName));
                        chip.setTag(fileId);
                        chip.setChipBackgroundColorResource(R.color.chip_success);
                        successCount.incrementAndGet();
                        if (pendingUploads.decrementAndGet() == 0) {
                          finishUploads(successCount.get(), uris.size(), errors);
                        }
                      });
            }

            @Override
            public void onError(String error) {
              requireActivity()
                  .runOnUiThread(
                      () -> {
                        chip.setChipBackgroundColorResource(R.color.chip_error);
                        errors.add(fileName + ": " + error);
                        if (pendingUploads.decrementAndGet() == 0) {
                          finishUploads(successCount.get(), uris.size(), errors);
                        }
                      });
            }
          });
    }
  }

  private void finishUploads(int successCount, int totalCount, List<String> errors) {
    setLoading(false);
    if (successCount > 0) {
      Toast.makeText(
              getContext(),
              successCount + " of " + totalCount + " files uploaded",
              Toast.LENGTH_SHORT)
          .show();
    }
    if (!errors.isEmpty()) {
      new MaterialAlertDialogBuilder(requireContext())
          .setTitle("Upload error")
          .setMessage(TextUtils.join("\n", errors))
          .setPositiveButton("OK", null)
          .show();
    }
    if (uploadedFiles.isEmpty()) {
      filePreviewContainer.setVisibility(View.GONE);
    }
  }

  private void uploadSingleFile(Uri uri, DeepSeekApiService.FileUploadCallback callback) {
    try {
      String fileName = getFileName(uri);
      InputStream inputStream = requireContext().getContentResolver().openInputStream(uri);
      File tempFile =
          new File(
              requireContext().getCacheDir(),
              "upload_" + System.currentTimeMillis() + "_" + fileName);
      FileOutputStream outputStream = new FileOutputStream(tempFile);
      byte[] buffer = new byte[4096];
      int bytesRead;
      while ((bytesRead = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, bytesRead);
      }
      outputStream.close();
      inputStream.close();
      tempFileMap.put(tempFile.getAbsolutePath(), tempFile);
      apiService.uploadFile(
          tempFile,
          new DeepSeekApiService.FileUploadCallback() {
            @Override
            public void onSuccess(String fileId) {
              tempFile.delete();
              tempFileMap.remove(tempFile.getAbsolutePath());
              callback.onSuccess(fileId);
            }

            @Override
            public void onError(String error) {
              tempFile.delete();
              tempFileMap.remove(tempFile.getAbsolutePath());
              callback.onError(error);
            }
          });
    } catch (Exception e) {
      callback.onError(e.getMessage());
    }
  }

  private String getFileName(Uri uri) {
    String fileName = "file";
    Cursor cursor = requireContext().getContentResolver().query(uri, null, null, null, null);
    if (cursor != null && cursor.moveToFirst()) {
      int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
      if (nameIndex != -1) {
        fileName = cursor.getString(nameIndex);
      }
      cursor.close();
    }
    return fileName;
  }

  private void clearUploadedFiles() {
    uploadedFiles.clear();
    fileChipGroup.removeAllViews();
    filePreviewContainer.setVisibility(View.GONE);
    tempFileMap.values().forEach(File::delete);
    tempFileMap.clear();
  }

  private void checkApiKey() {
    if (!apiService.hasApiKey()) {
      statusText.setText(getString(R.string.chat_api_key_missing));
      statusText.setVisibility(View.VISIBLE);
      messageInput.setEnabled(false);
      sendButton.setEnabled(false);
      attachFileButton.setEnabled(false);
      searchToggleButton.setEnabled(false);
    } else {
      statusText.setVisibility(View.GONE);
      messageInput.setEnabled(true);
      sendButton.setEnabled(true);
      attachFileButton.setEnabled(true);
      searchToggleButton.setEnabled(true);
    }
  }

  private void addWelcomeMessage() {
    Message welcomeMessage = new Message("assistant", getString(R.string.chat_welcome_message));
    messages.add(welcomeMessage);
  }

  public void showSettings() {
    SettingsBottomSheet bottomSheet = new SettingsBottomSheet();
    bottomSheet.setOnSettingsChangedListener(
        () -> {
          String newApiKey = prefManager.getApiKey();
          if (!TextUtils.isEmpty(newApiKey)) {
            apiService.setApiKey(newApiKey);
            checkApiKey();
          }
          String currentModel =
              prefManager.isExpertMode()
                  ? getString(R.string.chat_model_expert_active)
                  : getString(R.string.chat_model_fast_active);
          Toast.makeText(getContext(), currentModel, Toast.LENGTH_SHORT).show();
        });
    bottomSheet.show(getChildFragmentManager(), "SettingsBottomSheet");
  }

  private void sendMessage() {
    String content = messageInput.getText().toString().trim();
    if (TextUtils.isEmpty(content)) return;
    if (!apiService.hasApiKey()) {
      Toast.makeText(getContext(), getString(R.string.chat_set_api_key_first), Toast.LENGTH_SHORT)
          .show();
      showSettings();
      return;
    }

    Message userMessage = new Message("user", content);
    userMessage.setSearchEnabled(isSearchEnabled);

    if (!uploadedFiles.isEmpty()) {
      List<String> fileIds = new ArrayList<>();
      List<String> fileNames = new ArrayList<>();
      for (UploadedFile file : uploadedFiles) {
        fileIds.add(file.id);
        fileNames.add(file.name);
      }
      userMessage.setFileIds(fileIds);
      userMessage.setFileNames(fileNames);
    }

    messages.add(userMessage);
    chatAdapter.notifyItemInserted(messages.size() - 1);
    chatRecyclerView.scrollToPosition(messages.size() - 1);
    messageInput.setText("");

    setLoading(true);

    String model =
        prefManager.isExpertMode()
            ? DeepSeekApiService.MODEL_EXPERT
            : DeepSeekApiService.MODEL_FAST;
    boolean useStream = prefManager.isStreamEnabled();

    Message assistantMessage = new Message("assistant", "");
    assistantMessage.setStreaming(useStream);
    messages.add(assistantMessage);
    int assistantPosition = messages.size() - 1;
    chatAdapter.notifyItemInserted(assistantPosition);

    List<String> fileIdsToSend =
        uploadedFiles.isEmpty()
            ? null
            : uploadedFiles.stream().map(f -> f.id).collect(Collectors.toList());

    clearUploadedFiles();

    if (useStream) {
      apiService.sendMessage(
          new ArrayList<>(messages.subList(0, messages.size() - 1)),
          model,
          true,
          isSearchEnabled,
          fileIdsToSend,
          new DeepSeekApiService.ChatCallback() {
            @Override
            public void onSuccess(String response, String reasoningContent, int tokensUsed) {}

            @Override
            public void onStreamChunk(String chunk) {
              requireActivity()
                  .runOnUiThread(
                      () -> {
                        assistantMessage.appendContent(chunk);
                        chatAdapter.notifyItemChanged(assistantPosition);
                        chatRecyclerView.scrollToPosition(assistantPosition);
                      });
            }

            @Override
            public void onStreamReasoningChunk(String chunk) {
              requireActivity()
                  .runOnUiThread(
                      () -> {
                        assistantMessage.appendReasoningContent(chunk);
                        chatAdapter.notifyItemChanged(assistantPosition);
                      });
            }

            @Override
            public void onStreamFinished() {
              requireActivity()
                  .runOnUiThread(
                      () -> {
                        assistantMessage.setStreaming(false);
                        chatAdapter.finalizeStreamingAt(assistantPosition);
                        chatAdapter.notifyItemChanged(assistantPosition);
                        setLoading(false);
                        onRegenerateFinished(assistantPosition);
                        saveChatToHistory();
                      });
            }

            @Override
            public void onError(String error) {
              requireActivity()
                  .runOnUiThread(
                      () -> {
                        assistantMessage.setContent(getString(R.string.chat_error_prefix) + error);
                        assistantMessage.setError(true);
                        assistantMessage.setStreaming(false);
                        chatAdapter.notifyItemChanged(assistantPosition);
                        setLoading(false);
                        onRegenerateFinished(assistantPosition);
                        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
                      });
            }
          });
    } else {
      apiService.sendMessage(
          new ArrayList<>(messages.subList(0, messages.size() - 1)),
          model,
          false,
          isSearchEnabled,
          fileIdsToSend,
          new DeepSeekApiService.ChatCallback() {
            @Override
            public void onSuccess(String response, String reasoningContent, int tokensUsed) {
              requireActivity()
                  .runOnUiThread(
                      () -> {
                        assistantMessage.setContent(response);
                        if (reasoningContent != null && !reasoningContent.isEmpty()) {
                          assistantMessage.setReasoningContent(reasoningContent);
                        }
                        assistantMessage.setStreaming(false);
                        chatAdapter.notifyItemChanged(assistantPosition);
                        chatRecyclerView.scrollToPosition(assistantPosition);
                        onRegenerateFinished(assistantPosition);
                        setLoading(false);
                        saveChatToHistory();
                      });
            }

            @Override
            public void onStreamChunk(String chunk) {}

            @Override
            public void onStreamReasoningChunk(String chunk) {}

            @Override
            public void onStreamFinished() {}

            @Override
            public void onError(String error) {
              requireActivity()
                  .runOnUiThread(
                      () -> {
                        assistantMessage.setContent(getString(R.string.chat_error_prefix) + error);
                        assistantMessage.setError(true);
                        chatAdapter.notifyItemChanged(assistantPosition);
                        setLoading(false);
                        onRegenerateFinished(assistantPosition);
                        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
                      });
            }
          });
    }
  }

  public void saveChatToHistory() {
    List<Message> messagesToSave = new ArrayList<>();
    for (Message msg : messages) {
      if (!(messages.indexOf(msg) == 0
          && "assistant".equals(msg.getRole())
          && msg.getContent().equals(getString(R.string.chat_welcome_message)))) {
        messagesToSave.add(msg);
      }
    }
    if (!messagesToSave.isEmpty()) {
      historyManager.saveCurrentChat(messagesToSave);
      if (listener != null) {
        listener.onChatSaved();
      }
    }
  }

  private void setLoading(boolean loading) {
    loadingIndicator.setVisibility(loading ? View.VISIBLE : View.GONE);
    sendButton.setEnabled(!loading);
    messageInput.setEnabled(!loading);
    attachFileButton.setEnabled(!loading);
    searchToggleButton.setEnabled(!loading);
  }

  public boolean hasMessages() {
    return messages.size() > 1;
  }

  public void deleteAllChats() {
    historyManager.deleteAllChats();
    clearChat();
  }

  public void setMessages(CharSequence text) {
    if (messageInput != null && text != null) {
      messageInput.setText(text);

      messageInput.requestFocus();

      messageInput.setSelection(text.length());
    } else {

      pendingMessage = text != null ? text.toString() : null;
    }
  }

  private static class UploadedFile {
    String id;
    String name;

    UploadedFile(String id, String name) {
      this.id = id;
      this.name = name;
    }
  }
}
