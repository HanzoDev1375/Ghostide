package ir.ninjacoder.prograsssheet.deepseek.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ChatResponse {
  private String id;
  private String object;
  private long created;
  private String model;
  private List<Choice> choices;
  public Usage usage;

  public static class Choice {
    private int index;
    private MessageDTO message;
    private MessageDTO delta;
    private String finishReason;

    public static class MessageDTO {
      private String role;
      private String content;

      @SerializedName("reasoning_content")
      private String reasoningContent;

      public String getRole() {
        return role;
      }

      public String getContent() {
        return content;
      }

      public String getReasoningContent() {
        return reasoningContent;
      }
    }

    public MessageDTO getMessage() {
      return message;
    }

    public MessageDTO getDelta() {
      return delta;
    }

    public String getFinishReason() {
      return finishReason;
    }
  }

  public static class Usage {
    @SerializedName("prompt_tokens")
    private int promptTokens;

    @SerializedName("completion_tokens")
    private int completionTokens;

    @SerializedName("total_tokens")
    private int totalTokens;

    public int getTotalTokens() {
      return totalTokens;
    }
  }

  public String getContent() {
    if (choices != null && !choices.isEmpty()) {
      Choice choice = choices.get(0);
      if (choice.message != null) {
        return choice.message.content;
      }
    }
    return "";
  }

  public String getReasoningContent() {
    if (choices != null && !choices.isEmpty()) {
      Choice choice = choices.get(0);
      if (choice.message != null) {
        return choice.message.reasoningContent;
      }
    }
    return "";
  }

  public String getStreamContent() {
    if (choices != null && !choices.isEmpty()) {
      Choice choice = choices.get(0);
      if (choice.delta != null) {
        return choice.delta.content;
      }
    }
    return "";
  }

  public String getStreamReasoningContent() {
    if (choices != null && !choices.isEmpty()) {
      Choice choice = choices.get(0);
      if (choice.delta != null) {
        return choice.delta.reasoningContent;
      }
    }
    return "";
  }

  public boolean isFinished() {
    if (choices != null && !choices.isEmpty()) {
      Choice choice = choices.get(0);
      return "stop".equals(choice.finishReason);
    }
    return false;
  }
}