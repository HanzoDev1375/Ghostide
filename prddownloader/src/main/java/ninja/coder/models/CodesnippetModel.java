package ninja.coder.models;

import com.google.gson.JsonElement;

public class CodesnippetModel {
  private String description;
  private String prefix;
  private JsonElement body; // تغییر نوع به JsonElement

  public CodesnippetModel(String description, String prefix, JsonElement body) {
    this.description = description;
    this.prefix = prefix;
    this.body = body;
  }

  public String getDescription() {
    return description;
  }

  public String getPrefix() {
    return prefix;
  }

  public JsonElement getBody() {
    return body;
  }

  // متدهای کمکی برای دسترسی به body
  public String getBodyAsString() {
    if (body == null) return "";
    return body.isJsonPrimitive() ? body.getAsString() : body.toString();
  }

  public boolean isBodyArray() {
    return body.isJsonArray();
  }
}
