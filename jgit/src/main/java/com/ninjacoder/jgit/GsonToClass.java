package com.ninjacoder.jgit;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
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
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import wu.seal.jsontokotlin.library.JsonToKotlinBuilder;

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
    JS("javaScript"),
    PHP("php"),
    PYTHON("python"),
    RUST("rust"),
    CPP("c++"),
    TYPESCRIPT("typescript"),
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
    List<String> list = new ArrayList<>();
    list.add(Call.JAVA.name());
    list.add(Call.KT.name());
    list.add(Call.JS.name());
    list.add(Call.PHP.name());
    list.add(Call.PYTHON.name());
    list.add(Call.RUST.name());
    list.add(Call.CPP.name());
    mydialog.setAdapter(
        new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list),
        (db, sw) -> {
          switch (sw) {
            case 0 -> {
              makeJsontoJava(Call.JAVA);
              break;
            }
            case 1 -> {
              makeJsontoJava(Call.KT);
              break;
            }
            case 2 -> {
              makeJsontoJava(Call.JS);
              break;
            }
            case 3 -> {
              makeJsontoJava(Call.PHP);
              break;
            }
            case 4 -> {
              makeJsontoJava(Call.PYTHON);
              break;
            }
            case 5 -> {
              makeJsontoJava(Call.RUST);
              break;
            }
            case 6 -> {
              makeJsontoJava(Call.CPP);
              break;
            }
            case 7 -> {
              makeJsontoJava(Call.TYPESCRIPT);
              break;
            }
          }
        });

    mydialog.show();
  }

  private void makeJsontoJava(Call mod) {
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
          if (mod == Call.JAVA) {
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
          } else if (mod == Call.KT) {
            var result1 =
                setConvertToDataClass(
                    jsonCode.getEditText().getText().toString(),
                    inputClassName.getEditText().getText().toString());
            FileIOUtils.writeFileFromString(
                output + File.separator + inputClassName.getEditText().getText().toString() + ".kt",
                result1);
          } else if (mod == Call.JS) {
            var result2 =
                convertJsonToJavaScript(
                    jsonCode.getEditText().getText().toString(),
                    inputClassName.getEditText().getText().toString());
            FileIOUtils.writeFileFromString(
                output + File.separator + inputClassName.getEditText().getText().toString() + ".js",
                result2);
          } else if (mod == Call.PHP) {
            var result2 =
                convertJsonToPhp(
                    jsonCode.getEditText().getText().toString(),
                    inputClassName.getEditText().getText().toString());
            FileIOUtils.writeFileFromString(
                output
                    + File.separator
                    + inputClassName.getEditText().getText().toString()
                    + ".php",
                result2);
          } else if (mod == Call.PYTHON) {
            var result2 =
                convertJsonToPython(
                    jsonCode.getEditText().getText().toString(),
                    inputClassName.getEditText().getText().toString());
            FileIOUtils.writeFileFromString(
                output + File.separator + inputClassName.getEditText().getText().toString() + ".py",
                result2);
          } else if (mod == Call.RUST) {
            var result2 =
                convertJsonToRust(
                    jsonCode.getEditText().getText().toString(),
                    inputClassName.getEditText().getText().toString());
            FileIOUtils.writeFileFromString(
                output + File.separator + inputClassName.getEditText().getText().toString() + ".rs",
                result2);
          } else if (mod == Call.CPP) {
            var result2 =
                convertJsonToCpp(
                    jsonCode.getEditText().getText().toString(),
                    inputClassName.getEditText().getText().toString());
            FileIOUtils.writeFileFromString(
                output
                    + File.separator
                    + inputClassName.getEditText().getText().toString()
                    + ".cpp",
                result2);
          } else if (mod == Call.TYPESCRIPT) {
            var result2 =
                convertJsonToTypeScript(
                    jsonCode.getEditText().getText().toString(),
                    inputClassName.getEditText().getText().toString());
            FileIOUtils.writeFileFromString(
                output
                    + File.separator
                    + inputClassName.getEditText().getText().toString()
                    + ".cpp",
                result2);
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
   return new JsonToJavaConverter().convertJsonToJava(jsonInput,nameClass);
  }


  private String setConvertToDataClass(String code, String className) {
    return new JsonToKotlinBuilder().build(code, className);
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
    } else if (value instanceof List) {
      return "List<?>";
    } else {
      return "Object";
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

  private String convertJsonToJavaScript(String jsonInput, String nameClass) {
    if (isJsonVilad(jsonInput)) {
      try {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> map = gson.fromJson(jsonInput, type);

        StringBuilder jsCode = new StringBuilder();
        jsCode.append("class ").append(nameClass).append(" {\n");
        jsCode.append("    constructor(data) {\n");

        // Add properties
        for (Map.Entry<String, Object> entry : map.entrySet()) {
          String key = entry.getKey();
          jsCode.append("        this.").append(key).append(" = data.").append(key).append(";\n");
        }

        jsCode.append("    }\n\n");

        // Add toObject method
        jsCode.append("    toObject() {\n");
        jsCode.append("        return {\n");
        boolean first = true;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
          if (!first) {
            jsCode.append(",\n");
          }
          String key = entry.getKey();
          jsCode.append("            ").append(key).append(": this.").append(key);
          first = false;
        }
        jsCode.append("\n        };\n");
        jsCode.append("    }\n");

        // Add static fromJson method
        jsCode.append("\n    static fromJson(json) {\n");
        jsCode.append("        const data = JSON.parse(json);\n");
        jsCode.append("        return new ").append(nameClass).append("(data);\n");
        jsCode.append("    }\n");

        jsCode.append("}\n\n");
        jsCode.append("// Usage example:\n");
        jsCode.append("// const obj = ").append(nameClass).append(".fromJson(jsonString);\n");
        jsCode.append("// const json = JSON.stringify(obj.toObject());\n");

        return jsCode.toString();
      } catch (Exception e) {
        e.printStackTrace();
        return "Error converting JSON to JavaScript class.";
      }
    } else {
      return "Array JSON is not supported";
    }
  }

  private String convertJsonToPhp(String jsonInput, String nameClass) {
    if (isJsonVilad(jsonInput)) {
      try {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> map = gson.fromJson(jsonInput, type);

        StringBuilder phpCode = new StringBuilder();
        phpCode.append("<?php\n\n");
        phpCode.append("class ").append(nameClass).append(" {\n");

        // Properties
        for (Map.Entry<String, Object> entry : map.entrySet()) {
          String key = entry.getKey();
          phpCode.append("    public $").append(key).append(";\n");
        }

        // Constructor
        phpCode.append("\n    public function __construct(array \\$data = []) {\n");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
          String key = entry.getKey();
          phpCode
              .append("        \\$this->")
              .append(key)
              .append(" = \\$data['")
              .append(key)
              .append("'] ?? null;\n");
        }
        phpCode.append("    }\n");

        // toArray method
        phpCode.append("\n    public function toArray(): array {\n");
        phpCode.append("        return [\n");
        boolean first = true;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
          if (!first) {
            phpCode.append(",\n");
          }
          String key = entry.getKey();
          phpCode.append("            '").append(key).append("' => \\$this->").append(key);
          first = false;
        }
        phpCode.append("\n        ];\n");
        phpCode.append("    }\n");

        // Static fromJson method
        phpCode.append("\n    public static function fromJson(string \\$json): self {\n");
        phpCode.append("        \\$data = json_decode(\\$json, true);\n");
        phpCode.append("        return new self(\\$data);\n");
        phpCode.append("    }\n");

        phpCode.append("}\n\n");
        phpCode.append("// Usage example:\n");
        phpCode.append("// $obj = ").append(nameClass).append("::fromJson($jsonString);\n");
        phpCode.append("// $array = $obj->toArray();\n");
        phpCode.append("// $json = json_encode($obj->toArray());\n");

        return phpCode.toString().replaceAll("\\", "");
      } catch (Exception e) {
        e.printStackTrace();
        return "Error converting JSON to PHP class.";
      }
    } else {
      return "Array JSON is not supported";
    }
  }

  private String convertJsonToPython(String jsonInput, String nameClass) {
    if (isJsonVilad(jsonInput)) {
      try {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> map = gson.fromJson(jsonInput, type);

        StringBuilder pythonCode = new StringBuilder();
        pythonCode.append("import json\n\n");
        pythonCode.append("class ").append(nameClass).append(":\n");

        // Constructor
        pythonCode.append("    def __init__(self, data=None):\n");
        pythonCode.append("        if data is None:\n");
        pythonCode.append("            data = {}\n");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
          String key = entry.getKey();
          pythonCode
              .append("        self.")
              .append(key)
              .append(" = data.get('")
              .append(key)
              .append("')\n");
        }

        // to_dict method
        pythonCode.append("\n    def to_dict(self):\n");
        pythonCode.append("        return {\n");
        boolean first = true;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
          if (!first) {
            pythonCode.append(",\n");
          }
          String key = entry.getKey();
          pythonCode.append("            '").append(key).append("': self.").append(key);
          first = false;
        }
        pythonCode.append("\n        }\n");

        // from_json method
        pythonCode.append("\n    @classmethod\n");
        pythonCode.append("    def from_json(cls, json_str):\n");
        pythonCode.append("        data = json.loads(json_str)\n");
        pythonCode.append("        return cls(data)\n");

        pythonCode.append("\n\n# Usage example:\n");
        pythonCode.append("# obj = ").append(nameClass).append(".from_json(json_str)\n");
        pythonCode.append("# json_str = json.dumps(obj.to_dict())\n");

        return pythonCode.toString();
      } catch (Exception e) {
        e.printStackTrace();
        return "Error converting JSON to Python class.";
      }
    } else {
      return "Array JSON is not supported";
    }
  }

  // im not dev rust tnks for deepseek
  private String convertJsonToRust(String jsonInput, String nameClass) {
    if (isJsonVilad(jsonInput)) {
      try {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> map = gson.fromJson(jsonInput, type);

        StringBuilder rustCode = new StringBuilder();
        rustCode.append("use serde::{Deserialize, Serialize};\n");
        rustCode.append("use serde_json;\n\n");
        rustCode.append("#[derive(Debug, Serialize, Deserialize)]\n");
        rustCode.append("pub struct ").append(nameClass).append(" {\n");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
          String key = entry.getKey();
          Object value = entry.getValue();
          rustCode
              .append("    pub ")
              .append(key)
              .append(": ")
              .append(convertRustType(value))
              .append(",\n");
        }

        rustCode.append("}\n\n");
        rustCode.append("impl ").append(nameClass).append(" {\n");
        rustCode.append(
            "    pub fn from_json(json_str: &str) -> Result<Self, serde_json::Error> {\n");
        rustCode.append("        serde_json::from_str(json_str)\n");
        rustCode.append("    }\n\n");
        rustCode.append("    pub fn to_json(&self) -> Result<String, serde_json::Error> {\n");
        rustCode.append("        serde_json::to_string(self)\n");
        rustCode.append("    }\n");
        rustCode.append("}\n\n");
        rustCode.append("// Usage example:\n");
        rustCode
            .append("// let obj: ")
            .append(nameClass)
            .append(" = ")
            .append(nameClass)
            .append("::from_json(json_str)?;\n");
        rustCode.append("// let json_str = obj.to_json()?;\n");

        return rustCode.toString();
      } catch (Exception e) {
        e.printStackTrace();
        return "Error converting JSON to Rust struct.";
      }
    } else {
      return "Array JSON is not supported";
    }
  }

  private String convertRustType(Object value) {
    if (value instanceof String) {
      return "String";
    } else if (value instanceof Integer) {
      return "i32";
    } else if (value instanceof Double) {
      return "f64";
    } else if (value instanceof Boolean) {
      return "bool";
    } else {
      return "serde_json::Value"; // For complex/unknown types
    }
  }

  private String convertJsonToCpp(String jsonInput, String nameClass) {
    if (isJsonVilad(jsonInput)) {
      try {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> map = gson.fromJson(jsonInput, type);

        StringBuilder cppCode = new StringBuilder();
        cppCode.append("#include <string>\n");
        cppCode.append("#include <map>\n");
        cppCode.append("#include <nlohmann/json.hpp>\n\n");
        cppCode.append("using json = nlohmann::json;\n\n");
        cppCode.append("class ").append(nameClass).append(" {\n");
        cppCode.append("public:\n");

        // Fields
        for (Map.Entry<String, Object> entry : map.entrySet()) {
          String key = entry.getKey();
          Object value = entry.getValue();
          cppCode
              .append("    ")
              .append(convertCppType(value))
              .append(" ")
              .append(key)
              .append(";\n");
        }
        cppCode
            .append("\n    static ")
            .append(nameClass)
            .append(" from_json(const std::string& json_str) {\n");
        cppCode.append("        auto j = json::parse(json_str);\n");
        cppCode.append("        ").append(nameClass).append(" obj;\n");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
          String key = entry.getKey();
          cppCode.append("        obj.").append(key).append(" = j[\"").append(key).append("\"];\n");
        }
        cppCode.append("        return obj;\n");
        cppCode.append("    }\n");

        // to_json method
        cppCode.append("\n    std::string to_json() const {\n");
        cppCode.append("        json j;\n");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
          String key = entry.getKey();
          cppCode.append("        j[\"").append(key).append("\"] = ").append(key).append(";\n");
        }
        cppCode.append("        return j.dump();\n");
        cppCode.append("    }\n");

        cppCode.append("};\n\n");
        cppCode.append("// Usage example:\n");
        cppCode.append("// auto obj = ").append(nameClass).append("::from_json(json_str);\n");
        cppCode.append("// std::string json_str = obj.to_json();\n");

        return cppCode.toString();
      } catch (Exception e) {
        e.printStackTrace();
        return "Error converting JSON to C++ class.";
      }
    } else {
      return "Array JSON is not supported";
    }
  }

  private String convertCppType(Object value) {
    if (value instanceof String) {
      return "std::string";
    } else if (value instanceof Integer) {
      return "int";
    } else if (value instanceof Double) {
      return "double";
    } else if (value instanceof Boolean) {
      return "bool";
    } else {
      return "json";
    }
  }

  private String convertJsonToTypeScript(String jsonInput, String nameClass) {
    if (isJsonVilad(jsonInput)) {
      try {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> map = gson.fromJson(jsonInput, type);

        StringBuilder tsCode = new StringBuilder();
        tsCode.append("interface ").append(nameClass).append(" {\n");

        // Add properties with TypeScript types
        for (Map.Entry<String, Object> entry : map.entrySet()) {
          String key = entry.getKey();
          Object value = entry.getValue();
          tsCode
              .append("    ")
              .append(key)
              .append(": ")
              .append(convertTypeScriptType(value))
              .append(";\n");
        }

        tsCode.append("}\n\n");
        tsCode
            .append("export function parse")
            .append(nameClass)
            .append("(json: string): ")
            .append(nameClass)
            .append(" {\n");
        tsCode.append("    return JSON.parse(json) as ").append(nameClass).append(";\n");
        tsCode.append("}\n\n");
        tsCode
            .append("export function stringify")
            .append(nameClass)
            .append("(obj: ")
            .append(nameClass)
            .append("): string {\n");
        tsCode.append("    return JSON.stringify(obj);\n");
        tsCode.append("}\n\n");

        tsCode.append("// Usage example:\n");
        tsCode.append("// const obj = parse").append(nameClass).append("(jsonString);\n");
        tsCode.append("// const json = stringify").append(nameClass).append("(obj);\n");

        return tsCode.toString();
      } catch (Exception e) {
        e.printStackTrace();
        return "Error converting JSON to TypeScript interface.";
      }
    } else {
      return "Array JSON is not supported";
    }
  }

  private String convertTypeScriptType(Object value) {
    if (value instanceof String) {
      return "string";
    } else if (value instanceof Integer) {
      return "number";
    } else if (value instanceof Double) {
      return "number";
    } else if (value instanceof Boolean) {
      return "boolean";
    } else if (value instanceof List) {
      return "any[]";
    } else if (value instanceof Map) {
      return "any";
    } else {
      return "any";
    }
  }

  private boolean isJsonValid(String json) {
    try {
      new Gson().fromJson(json, Object.class);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
