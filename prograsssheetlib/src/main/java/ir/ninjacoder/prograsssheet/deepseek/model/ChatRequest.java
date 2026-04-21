package ir.ninjacoder.prograsssheet.deepseek.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class ChatRequest {
  private String model;
  private List<MessageDTO> messages;
  private boolean stream;

  @SerializedName("temperature")
  private double temperature;

  @SerializedName("max_tokens")
  private int maxTokens;

  @SerializedName("top_p")
  private double topP = 1.0;

  @SerializedName("frequency_penalty")
  private double frequencyPenalty = 0.0;

  @SerializedName("presence_penalty")
  private double presencePenalty = 0.0;

  @SerializedName("enable_search")
  private Boolean enableSearch;

  @SerializedName("file_ids")
  private List<String> fileIds;

  public ChatRequest(
      String model, 
      List<MessageDTO> messages, 
      boolean stream, 
      double temperature, 
      int maxTokens,
      Boolean enableSearch,
      List<String> fileIds) {
    this.model = model;
    this.messages = messages;
    this.stream = stream;
    this.temperature = temperature;
    this.maxTokens = maxTokens;
    this.enableSearch = enableSearch;
    this.fileIds = fileIds;
  }

  public static class MessageDTO {
    private String role;
    private String content;

    public MessageDTO(String role, String content) {
      this.role = role;
      this.content = content;
    }

    public String getRole() {
      return role;
    }

    public String getContent() {
      return content;
    }
  }

  public static class Builder {
    private String model;
    private List<MessageDTO> messages = new ArrayList<>();
    private boolean stream = false;
    private double temperature = 0.7;
    private int maxTokens = 2048;
    private double topP = 1.0;
    private double frequencyPenalty = 0.0;
    private double presencePenalty = 0.0;
    private Boolean enableSearch;
    private List<String> fileIds;

    public Builder model(String model) {
      this.model = model;
      return this;
    }

    public Builder addMessage(String role, String content) {
      this.messages.add(new MessageDTO(role, content));
      return this;
    }

    public Builder messages(List<MessageDTO> messages) {
      this.messages = messages;
      return this;
    }

    public Builder stream(boolean stream) {
      this.stream = stream;
      return this;
    }

    public Builder temperature(double temperature) {
      this.temperature = temperature;
      return this;
    }

    public Builder maxTokens(int maxTokens) {
      this.maxTokens = maxTokens;
      return this;
    }

    public Builder topP(double topP) {
      this.topP = topP;
      return this;
    }

    public Builder frequencyPenalty(double frequencyPenalty) {
      this.frequencyPenalty = frequencyPenalty;
      return this;
    }

    public Builder presencePenalty(double presencePenalty) {
      this.presencePenalty = presencePenalty;
      return this;
    }

    public Builder enableSearch(Boolean enableSearch) {
      this.enableSearch = enableSearch;
      return this;
    }

    public Builder fileIds(List<String> fileIds) {
      this.fileIds = fileIds;
      return this;
    }

    public ChatRequest build() {
      ChatRequest request = new ChatRequest(
          model, messages, stream, temperature, maxTokens, enableSearch, fileIds);
      request.topP = this.topP;
      request.frequencyPenalty = this.frequencyPenalty;
      request.presencePenalty = this.presencePenalty;
      return request;
    }
  }
}