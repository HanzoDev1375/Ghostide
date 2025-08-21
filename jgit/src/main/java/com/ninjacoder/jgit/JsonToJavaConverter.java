package com.ninjacoder.jgit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class JsonToJavaConverter {

  private static final Gson GSON = new Gson();

  public String convertJsonToJava(String jsonInput, String className) {
    try {
      var type = new TypeToken<Map<String, Object>>() {}.getType();
      Map<String, Object> map = GSON.fromJson(jsonInput, type);

      StringBuilder sb = new StringBuilder();
      sb.append("package yourApp;\n\n");
      sb.append("import com.google.gson.annotations.SerializedName;\n\n");
      sb.append("public class ").append(className).append(" {\n\n");

      // فیلدها
      for (Map.Entry<String, Object> entry : map.entrySet()) {
        String fieldName = entry.getKey();
        String fieldType = getJavaType(entry.getValue());

        sb.append("    @SerializedName(\"").append(fieldName).append("\")\n");
        sb.append("    private ").append(fieldType).append(" ").append(fieldName).append(";\n\n");
      }

      // Getter و Setterها
      for (Map.Entry<String, Object> entry : map.entrySet()) {
        String fieldName = entry.getKey();
        String fieldType = getJavaType(entry.getValue());
        String capitalized = capitalize(fieldName);

        // Setter
        sb.append("    public void set")
            .append(capitalized)
            .append("(")
            .append(fieldType)
            .append(" ")
            .append(fieldName)
            .append(") {\n");
        sb.append("        this.").append(fieldName).append(" = ").append(fieldName).append(";\n");
        sb.append("    }\n\n");

        // Getter
        sb.append("    public ")
            .append(fieldType)
            .append(" get")
            .append(capitalized)
            .append("() {\n");
        sb.append("        return this.").append(fieldName).append(";\n");
        sb.append("    }\n\n");
      }

      // toString
      sb.append("    @Override\n");
      sb.append("    public String toString() {\n");
      sb.append("        return \"").append(className).append(" [");

      boolean first = true;
      for (String fieldName : map.keySet()) {
        if (!first) sb.append(", ");
        sb.append(fieldName).append("=\" + ").append(fieldName).append(" + \"");
        first = false;
      }
      sb.append("]\";\n");
      sb.append("    }\n");

      sb.append("}\n");
      return sb.toString();

    } catch (Exception e) {
      return "خطا در تبدیل: " + e.getMessage();
    }
  }

  private String getJavaType(Object value) {
    if (value instanceof String) return "String";
    if (value instanceof Integer) return "Integer";
    if (value instanceof Double) return "Double";
    if (value instanceof Boolean) return "Boolean";
    if (value instanceof Map) return "java.util.Map<String, Object>";
    if (value instanceof java.util.List) return "java.util.List<Object>";
    return "Object";
  }

  private String capitalize(String str) {
    return Character.toUpperCase(str.charAt(0)) + str.substring(1);
  }
}
