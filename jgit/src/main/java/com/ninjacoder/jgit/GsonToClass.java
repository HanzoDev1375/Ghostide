package com.ninjacoder.jgit;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.blankj.utilcode.util.FileIOUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.Gson;
import com.ninjacoder.jgit.databinding.JsonconvertLayoutBinding;
import java.io.File;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;

public class GsonToClass {

  private MaterialAlertDialogBuilder dialog;
  private OnCallBackChange call;
  protected Context context;
  protected String output;
  private Call calls = Call.JAVA;

  public GsonToClass(Context context, String output, OnCallBackChange call) {
    this.call = call;
    this.context = context;
    this.output = output;
  }

  enum Call {
    JAVA("Make Java class"),
    KT("Make Kt class"),
    NONE("None");

    private String item;

    Call(String item) {
      this.item = item;
    }

    public String getItem() {
      return item;
    }
  }

  public void run() {
    var mydialog = new MaterialAlertDialogBuilder(context);
    mydialog.setTitle("Select Work?");
    List<Call> list = new ArrayList<>();
    list.add(Call.JAVA);
    list.add(Call.KT);
    list.add(Call.NONE);
    mydialog.setAdapter(
        new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list),
        (db, sw) -> {
          switch (sw) {
            case 0 -> {
              makeJsontoJava(false, Call.JAVA);
              break;
            }
            case 1 -> {
              makeJsontoJava(true, Call.KT);
              break;
            }
            case 2 -> {
              Toast.makeText(context, Call.NONE.getItem(), 2).show();
              break;
            }
          }
        });

    mydialog.show();
  }

  private void makeJsontoJava(boolean isKt, Call mod) {
    JsonconvertLayoutBinding bind = JsonconvertLayoutBinding.inflate(LayoutInflater.from(context));
    var inputClassName = bind.inputClassName;
    var jsonCode = bind.inputJsonCode;
    jsonCode.getEditText().setSingleLine(true);

    dialog = new MaterialAlertDialogBuilder(context);
    dialog.setTitle("Make Json to " + mod.getItem() + " code");
    dialog.setView(bind.getRoot());
    dialog.setPositiveButton(
        android.R.string.ok,
        (c, d) -> {
          if (!isKt) {
            var result =
                convertJsonToJava(
                    jsonCode.getEditText().getText().toString(),
                    inputClassName.getEditText().getText().toString());
            FileIOUtils.writeFileFromString(
                output
                    + File.separator
                    + inputClassName.getEditText().getText().toString()
                    + ".java",
                result);
          } else {
            var result1 =
                setConvertToDataClass(
                    jsonCode.getEditText().getText().toString(),
                    inputClassName.getEditText().getText().toString());
            FileIOUtils.writeFileFromString(
                output + File.separator + inputClassName.getEditText().getText().toString() + ".kt",
                result1);
          }

          if (call != null) {
            call.onChange();
          }
        });

    if (dialog != null) {
      dialog.show();
    }
  }

  private String convertJsonToJava(String jsonInput, String nameClass) {
    if (isJsonVilad(jsonInput)) {
      try {

        // تبدیل رشته JSON به Map
        /// سریع تر تبدیل کنید
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> map = gson.fromJson(jsonInput, type);

        // تولید کد Java بر اساس داده‌های موجود در Map
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("package yourApp").append("\n");
        javaCode.append("import com.google.gson.annotations.SerializedName;").append("\n");

        javaCode.append("public class ").append(nameClass).append("{\n");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
          String key = entry.getKey();
          Object value = entry.getValue();
          javaCode.append("\t@SerializedName("+ key +")").append('\n');
          javaCode.append("\tprivate " + convertType(value) + " " + key + ";\n");
        }

        for (Map.Entry<String, Object> entry : map.entrySet()) {
          String key = entry.getKey();
          Object value = entry.getValue();
          // setNot usimg

          javaCode.append(
              "\n\npublic void set"
                  + capitalize(key)
                  + "("
                  + convertType(value)
                  + " "
                  + key
                  + ") {\n");
          javaCode.append("\tthis." + key + " = " + key + ";\n");
          javaCode.append("}\n");
          javaCode.append("\npublic " + convertType(value) + " get" + capitalize(key) + "() {\n");
          javaCode.append("\treturn " + key + ";\n");
          javaCode.append("}\n");
        }

        javaCode.append("}");

        return javaCode.toString();
      } catch (Exception e) {
        e.printStackTrace();
        return "خطا در تبدیل JSON به کد جاوا.";
      }
    } else {
      return "Json از جنس ارایه ساپورت نمیشود ";
    }
  }

  private String setConvertToDataClass(String code, String className) {
    if (isJsonVilad(code)) {
      var gson = new Gson();
      var type = new TypeToken<Map<String, Object>>() {}.getType();
      Map<String, Object> map = gson.fromJson(code, type);
      var builder = new StringBuilder();
      builder.append("package yourapp").append("\n\n");
      builder.append("import kotlinx.serialization.Serializable").append("\n\n");
      builder.append("@Serializable\n");
      builder.append("data class ").append(className).append("(\n");
      Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry<String, Object> entry = iterator.next();
        String key = entry.getKey();
        Object value = entry.getValue();
        builder.append("\tvar ").append(key).append(": ").append(convertTypekt(value));
        if (iterator.hasNext()) {
          builder.append(",\n");
        }
      }
      builder.append("\n)");
      return builder.toString();
    }

    return null;
  }

  private String convertTypekt(Object value) {
    if (value instanceof String) {
      return "String";
      // not work int in Json
    } else if (value instanceof Integer) {
      return "Int";
      // make facke Doublue
    } else if (value instanceof Double) {
      return "Int";
    } else if (value instanceof Boolean) {
      return "Boolean";
    } else {
      return "Object";
    }
  }

  private String convertType(Object value) {
    if (value instanceof String) {
      return "String";
      // not work int in Json
    } else if (value instanceof Integer) {
      return "int";
    } else if (value instanceof Double) {
      return "double";
    } else if (value instanceof Boolean) {
      return "boolean";
    } else {
      return "Object"; // A generic type for unknown types
    }
  }

  private String capitalize(String str) {
    if (str == null || str.isEmpty()) {
      return str;
    }
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }

  public static boolean isJsonVilad(String code) {
    JsonParser jsonPaser = new JsonParser();
    JsonElement jsonElment = jsonPaser.parse(code);
    if (jsonElment.isJsonObject()) {
      return true;
    } else {
      return false;
    }
  }

  public interface OnCallBackChange {
    void onChange();
  }
}
