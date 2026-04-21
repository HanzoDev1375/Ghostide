package ir.ninjacoder.prograsssheet.deepseek.model;

import java.util.ArrayList;
import java.util.List;

public class Message {
  private String role;
  private String content;
  private String reasoningContent;
  private long timestamp;
  private boolean isStreaming;
  private boolean isError;
  private boolean isSearchEnabled;
  private List<String> fileIds;
  private List<String> fileNames;

  public Message(String role, String content) {
    this.role = role;
    this.content = content;
    this.timestamp = System.currentTimeMillis();
    this.isStreaming = false;
    this.isError = false;
    this.isSearchEnabled = false;
    this.fileIds = new ArrayList<>();
    this.fileNames = new ArrayList<>();
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getReasoningContent() {
    return reasoningContent;
  }

  public void setReasoningContent(String reasoningContent) {
    this.reasoningContent = reasoningContent;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public boolean isStreaming() {
    return isStreaming;
  }

  public void setStreaming(boolean streaming) {
    isStreaming = streaming;
  }

  public boolean isError() {
    return isError;
  }

  public void setError(boolean error) {
    isError = error;
  }

  public boolean isSearchEnabled() {
    return isSearchEnabled;
  }

  public void setSearchEnabled(boolean searchEnabled) {
    isSearchEnabled = searchEnabled;
  }

  public List<String> getFileIds() {
    return fileIds;
  }

  public void setFileIds(List<String> fileIds) {
    this.fileIds = fileIds;
  }

  public List<String> getFileNames() {
    return fileNames;
  }

  public void setFileNames(List<String> fileNames) {
    this.fileNames = fileNames;
  }

  public void appendContent(String chunk) {
    this.content += chunk;
  }

  public void appendReasoningContent(String chunk) {
    if (this.reasoningContent == null) {
      this.reasoningContent = "";
    }
    this.reasoningContent += chunk;
  }
}