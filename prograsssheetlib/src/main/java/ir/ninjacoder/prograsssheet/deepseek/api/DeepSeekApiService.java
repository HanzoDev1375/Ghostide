package ir.ninjacoder.prograsssheet.deepseek.api;

import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import ir.ninjacoder.prograsssheet.deepseek.model.Message;
import ir.ninjacoder.prograsssheet.deepseek.model.ChatRequest;
import ir.ninjacoder.prograsssheet.deepseek.model.ChatResponse;
import okhttp3.*;
import okio.BufferedSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeepSeekApiService {
  private static final String BASE_URL = "https://api.deepseek.com/v1/chat/completions";
  private static final String FILE_UPLOAD_URL = "https://api.deepseek.com/v1/files";
  public static final String MODEL_FAST = "deepseek-chat";
  public static final String MODEL_EXPERT = "deepseek-reasoner";

  private final OkHttpClient client;
  private final Gson gson;
  private String apiKey;
  private final Handler mainHandler;

  public interface ChatCallback {
    void onSuccess(String response, String reasoningContent, int tokensUsed);

    void onStreamChunk(String chunk);

    void onStreamReasoningChunk(String chunk);

    void onStreamFinished();

    void onError(String error);
  }

  public interface FileUploadCallback {
    void onSuccess(String fileId);

    void onError(String error);
  }

  public DeepSeekApiService() {
    this.gson = new GsonBuilder().create();
    this.mainHandler = new Handler(Looper.getMainLooper());

    this.client =
        new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public boolean hasApiKey() {
    return apiKey != null && !apiKey.isEmpty();
  }

  public void uploadFile(File file, FileUploadCallback callback) {
    if (!hasApiKey()) {
      mainHandler.post(() -> callback.onError("API Key تنظیم نشده است"));
      return;
    }

    RequestBody fileBody = RequestBody.create(file, MediaType.parse("application/octet-stream"));
    MultipartBody body =
        new MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("file", file.getName(), fileBody)
            .addFormDataPart("purpose", "file-extract")
            .build();

    Request request =
        new Request.Builder()
            .url(FILE_UPLOAD_URL)
            .addHeader("Authorization", "Bearer " + apiKey)
            .post(body)
            .build();

    client
        .newCall(request)
        .enqueue(
            new Callback() {
              @Override
              public void onFailure(Call call, IOException e) {
                mainHandler.post(() -> callback.onError("خطای آپلود: " + e.getMessage()));
              }

              @Override
              public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                  String errorBody = response.body() != null ? response.body().string() : "";
                  mainHandler.post(
                      () -> callback.onError("خطای آپلود (" + response.code() + "): " + errorBody));
                  return;
                }

                try {
                  String responseBody = response.body().string();
                  FileUploadResponse uploadResponse =
                      gson.fromJson(responseBody, FileUploadResponse.class);
                  mainHandler.post(() -> callback.onSuccess(uploadResponse.id));
                } catch (Exception e) {
                  mainHandler.post(() -> callback.onError("خطای پردازش پاسخ: " + e.getMessage()));
                }
              }
            });
  }

  public void sendMessage(
      List<Message> conversation,
      String model,
      boolean stream,
      boolean enableSearch,
      List<String> fileIds,
      ChatCallback callback) {
    if (!hasApiKey()) {
      mainHandler.post(() -> callback.onError("API Key تنظیم نشده است"));
      return;
    }

    List<ChatRequest.MessageDTO> messages = new ArrayList<>();
    for (Message msg : conversation) {
      if (!msg.isError()) {
        messages.add(new ChatRequest.MessageDTO(msg.getRole(), msg.getContent()));
      }
    }

    double temperature = MODEL_EXPERT.equals(model) ? 0.3 : 0.7;
    int maxTokens = MODEL_EXPERT.equals(model) ? 4096 : 2048;

    ChatRequest request =
        new ChatRequest.Builder()
            .model(model).messages(messages).stream(stream)
                .temperature(temperature)
                .maxTokens(maxTokens)
                .enableSearch(enableSearch ? true : null)
                .fileIds(fileIds != null && !fileIds.isEmpty() ? fileIds : null)
                .build();

    String jsonBody = gson.toJson(request);

    RequestBody body =
        RequestBody.create(jsonBody, MediaType.parse("application/json; charset=utf-8"));

    Request httpRequest =
        new Request.Builder()
            .url(BASE_URL)
            .addHeader("Authorization", "Bearer " + apiKey)
            .addHeader("Content-Type", "application/json")
            .post(body)
            .build();

    if (stream) {
      handleStreamRequest(httpRequest, callback);
    } else {
      handleNormalRequest(httpRequest, callback);
    }
  }

  private void handleNormalRequest(Request request, ChatCallback callback) {
    client
        .newCall(request)
        .enqueue(
            new Callback() {
              @Override
              public void onFailure(Call call, IOException e) {
                mainHandler.post(() -> callback.onError("خطای شبکه: " + e.getMessage()));
              }

              @Override
              public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                  String errorBody = response.body() != null ? response.body().string() : "";
                  mainHandler.post(
                      () -> callback.onError("خطای API (" + response.code() + "): " + errorBody));
                  return;
                }

                try {
                  String responseBody = response.body().string();
                  ChatResponse chatResponse = gson.fromJson(responseBody, ChatResponse.class);
                  String content = chatResponse.getContent();
                  String reasoningContent = chatResponse.getReasoningContent();
                  int tokens = chatResponse.usage != null ? chatResponse.usage.getTotalTokens() : 0;

                  mainHandler.post(() -> callback.onSuccess(content, reasoningContent, tokens));
                } catch (Exception e) {
                  mainHandler.post(() -> callback.onError("خطای پردازش پاسخ: " + e.getMessage()));
                }
              }
            });
  }

  private void handleStreamRequest(Request request, ChatCallback callback) {
    client
        .newCall(request)
        .enqueue(
            new Callback() {
              @Override
              public void onFailure(Call call, IOException e) {
                mainHandler.post(() -> callback.onError("خطای استریم: " + e.getMessage()));
              }

              @Override
              public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                  String errorBody = response.body() != null ? response.body().string() : "";
                  mainHandler.post(
                      () -> callback.onError("خطای API (" + response.code() + "): " + errorBody));
                  return;
                }

                ResponseBody responseBody = response.body();
                if (responseBody == null) {
                  mainHandler.post(() -> callback.onError("پاسخ خالی است"));
                  return;
                }

                try {
                  BufferedSource source = responseBody.source();
                  while (!source.exhausted()) {
                    String line = source.readUtf8Line();
                    if (line != null && line.startsWith("data: ")) {
                      String jsonData = line.substring(6);
                      if (!jsonData.equals("[DONE]")) {
                        try {
                          ChatResponse chunk = gson.fromJson(jsonData, ChatResponse.class);
                          String content = chunk.getStreamContent();
                          String reasoningContent = chunk.getStreamReasoningContent();

                          if (content != null && !content.isEmpty()) {
                            mainHandler.post(() -> callback.onStreamChunk(content));
                          }
                          if (reasoningContent != null && !reasoningContent.isEmpty()) {
                            mainHandler.post(
                                () -> callback.onStreamReasoningChunk(reasoningContent));
                          }
                          if (chunk.isFinished()) {
                            mainHandler.post(() -> callback.onStreamFinished());
                          }
                        } catch (Exception e) {
                        }
                      } else {
                        mainHandler.post(() -> callback.onStreamFinished());
                      }
                    }
                  }
                } finally {
                  responseBody.close();
                }
              }
            });
  }

  private static class FileUploadResponse {
    String id;
    String object;
    int bytes;

    @SerializedName("created_at")
    long createdAt;

    String filename;
    String purpose;
  }
}
