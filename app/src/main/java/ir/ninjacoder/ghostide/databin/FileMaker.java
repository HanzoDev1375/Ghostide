package ir.ninjacoder.ghostide.databin;

import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.interfaces.FileCallBack;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;

import ir.ninjacoder.prograsssheet.LayoutSheetEditText;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMaker {
  protected Context context;
  protected FileCallBack call;
  protected File file;

  public FileMaker(Context context) {
    this.context = context;
  }

  public void setFolderName(String path) {
    var dialog = new LayoutSheetEditText(context);
    var et = dialog.getInputLayout().getEditText();
    var input = dialog.getInputLayout();
    dialog.setTitle("Create a new file");
    dialog.setokClick(
        v -> {
          try {
            String fileName = et.getText().toString();
            file = new File(path, fileName);
            if (!file.exists()) {
              file.createNewFile();
              FileOutputStream fos = new FileOutputStream(file);
              String sampleText = democode(file.getName());
              fos.write(sampleText.getBytes());
              fos.close();

              Toast.makeText(et.getContext(), "فایل با موفقیت ایجاد شد", Toast.LENGTH_SHORT).show();
            } else {
              input.setErrorEnabled(true);
              input.setError("This file already exists");
            }
            input.setErrorEnabled(false);
            dialog.getButtonOk().setEnabled(true);
            call.onDoneMakeFile("");

            dialog.dismiss();
          } catch (IOException err) {
            call.onError(err.getMessage());
          }
        });

    if (et.getText().toString().isEmpty()) {
      dialog.getButtonOk().setEnabled(false);
    } else dialog.getButtonOk().setEnabled(true);

    et.addTextChangedListener(
        new TextWatcher() {

          @Override
          public void onTextChanged(CharSequence c, int arg1, int arg2, int arg3) {

            if (c.toString().isEmpty()) {
              dialog.getButtonOk().setEnabled(false);
              input.setErrorEnabled(false);
            } else dialog.getButtonOk().setEnabled(true);

            file = new File(path, c.toString());
            if (file.exists()) {
              input.setErrorEnabled(true);
              input.setError("This file already exists");
              dialog.getButtonOk().setEnabled(false);
            } else {
              input.setErrorEnabled(false);
              dialog.getButtonOk().setEnabled(true);
            }
            codeHelper(input, c.toString());
          }

          @Override
          public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

          @Override
          public void afterTextChanged(Editable arg0) {}
        });
        dialog.show();
  }

  public void codeHelper(TextInputLayout input, String name) {
    input.setPrefixTextColor(
        ColorStateList.valueOf(MaterialColors.getColor(input, ObjectUtils.colorOnSurface, 0)));
    String text = "";
    if (name.endsWith(".html")) {
      text = "html";
    } else if (name.endsWith(".java")) {
      text = "java";
    } else if (name.endsWith(".py")) {
      text = "python";
    } else if (name.endsWith(".js")) {
      text = "javascript";
    } else if (name.endsWith(".cpp")) {
      text = "c++";
    } else if (name.endsWith(".c")) {
      text = "c";
    } else if (name.endsWith(".cs")) {
      text = "c#";
    } else if (name.endsWith(".php")) {
      text = "php";
    } else if (name.endsWith(".rb")) {
      text = "ruby";
    } else if (name.endsWith(".swift")) {
      text = "swift";
    } else if (name.endsWith(".go")) {
      text = "go";
    } else if (name.endsWith(".kt")) {
      text = "kotlin";
    } else if (name.endsWith(".ts")) {
      text = "typescript";
    } else if (name.endsWith(".pl")) {
      text = "perl";
    } else if (name.endsWith(".lua")) {
      text = "lua";
    } else if (name.endsWith(".r")) {
      text = "r";
    } else if (name.endsWith(".scala")) {
      text = "scala";
    } else if (name.endsWith(".dart")) {
      text = "dart";
    } else if (name.endsWith(".rs")) {
      text = "rust";
    } else if (name.endsWith(".sh")) {
      text = "bash";
    } else if (name.endsWith(".m")) {
      text = "matlab";
    } else if (name.endsWith(".sql")) {
      text = "sql";
    } else if (name.endsWith(".vb")) {
      text = "visual basic";
    } else if (name.endsWith(".asm")) {
      text = "assembly";
    } else if (name.endsWith(".ps1")) {
      text = "powershell";
    } else if (name.endsWith(".groovy")) {
      text = "groovy";
    } else if (name.endsWith(".hs")) {
      text = "haskell";
    } else if (name.endsWith(".erl")) {
      text = "erlang";
    } else if (name.endsWith(".clj")) {
      text = "clojure";
    } else if (name.endsWith(".ex")) {
      text = "elixir";
    } else if (name.endsWith(".fs")) {
      text = "f#";
    } else if (name.endsWith(".jl")) {
      text = "julia";
    } else if (name.endsWith(".scm")) {
      text = "scheme";
    } else if (name.endsWith(".tcl")) {
      text = "tcl";
    } else if (name.endsWith(".vbs")) {
      text = "vbscript";
    } else if (name.endsWith(".coffee")) {
      text = "coffeescript";
    } else if (name.endsWith(".lisp")) {
      text = "lisp";
    } else if (name.endsWith(".pas")) {
      text = "pascal";
    } else if (name.endsWith(".d")) {
      text = "d";
    } else if (name.endsWith(".f90")) {
      text = "fortran";
    } else if (name.endsWith(".adb")) {
      text = "ada";
    } else if (name.endsWith(".pro")) {
      text = "prolog";
    } else if (name.endsWith(".ml")) {
      text = "ocaml";
    } else if (name.endsWith(".elm")) {
      text = "elm";
    } else if (name.endsWith(".ino")) {
      text = "arduino";
    } else if (name.endsWith(".v")) {
      text = "verilog";
    } else if (name.endsWith(".vhdl")) {
      text = "vhdl";
    } else if (name.endsWith(".tex")) {
      text = "latex";
    } else if (name.endsWith(".md")) {
      text = "markdown";
    } else if (name.endsWith(".yaml")) {
      text = "yaml";
    } else if (name.endsWith(".json")) {
      text = "json";
    } else if (name.endsWith(".xml")) {
      text = "xml";
    } else if (name.endsWith(".csv")) {
      text = "csv";
    } else if (name.endsWith(".asm")) {
      text = "assembly";
    } else if (name.endsWith(".h")) {
      text = "c header";
    } else if (name.endsWith(".hpp")) {
      text = "c++ header";
    } else if (name.endsWith(".kt")) {
      text = "kotlin";
    } else if (name.endsWith(".scss")) {
      text = "scss";
    } else if (name.endsWith(".less")) {
      text = "less";
    } else if (name.endsWith(".sass")) {
      text = "sass";
    } else if (name.endsWith(".styl")) {
      text = "stylus";
    } else if (name.endsWith(".ejs")) {
      text = "ejs";
    } else if (name.endsWith(".pug")) {
      text = "pug";
    } else if (name.endsWith(".haml")) {
      text = "haml";
    } else if (name.endsWith(".mustache")) {
      text = "mustache";
    } else if (name.endsWith(".handlebars")) {
      text = "handlebars";
    } else if (name.endsWith(".twig")) {
      text = "twig";
    } else if (name.endsWith(".jade")) {
      text = "jade";
    } else if (name.endsWith(".liquid")) {
      text = "liquid";
    } else if (name.endsWith(".eex")) {
      text = "eex";
    } else if (name.endsWith(".heex")) {
      text = "heex";
    } else if (name.endsWith(".slim")) {
      text = "slim";
    } else if (name.endsWith(".erb")) {
      text = "erb";
    } else if (name.endsWith(".haml")) {
      text = "haml";
    } else if (name.endsWith(".feature")) {
      text = "cucumber";
    } else if (name.endsWith(".gradle")) {
      text = "gradle";
    } else if (name.endsWith(".toml")) {
      text = "toml";
    } else if (name.endsWith(".ini")) {
      text = "ini";
    } else if (name.endsWith(".cfg")) {
      text = "cfg";
    } else if (name.endsWith(".conf")) {
      text = "conf";
    } else if (name.endsWith(".properties")) {
      text = "properties";
    } else if (name.endsWith(".env")) {
      text = "env";
    } else if (name.endsWith(".dockerfile")) {
      text = "dockerfile";
    } else if (name.endsWith(".makefile")) {
      text = "makefile";
    } else if (name.endsWith(".cmake")) {
      text = "cmake";
    } else if (name.endsWith(".rake")) {
      text = "rake";
    } else if (name.endsWith(".nim")) {
      text = "nim";
    } else if (name.endsWith(".zig")) {
      text = "zig";
    } else if (name.endsWith(".v")) {
      text = "v";
    } else if (name.endsWith(".odin")) {
      text = "odin";
    } else if (name.endsWith(".hx")) {
      text = "haxe";
    } else if (name.endsWith(".re")) {
      text = "reason";
    } else if (name.endsWith(".res")) {
      text = "rescript";
    } else if (name.endsWith(".exs")) {
      text = "elixir script";
    } else if (name.endsWith(".lfe")) {
      text = "lisp flavored erlang";
    } else if (name.endsWith(".cl")) {
      text = "common lisp";
    } else if (name.endsWith(".hy")) {
      text = "hy";
    } else if (name.endsWith(".janet")) {
      text = "janet";
    } else if (name.endsWith(".fth")) {
      text = "forth";
    } else if (name.endsWith(".4th")) {
      text = "forth";
    } else if (name.endsWith(".f")) {
      text = "forth";
    } else if (name.endsWith(".factor")) {
      text = "factor";
    } else if (name.endsWith(".io")) {
      text = "io";
    } else if (name.endsWith(".red")) {
      text = "red";
    } else if (name.endsWith(".rebol")) {
      text = "rebol";
    } else if (name.endsWith(".txt")) {
      text = "text";
    } else if (name.endsWith(".log")) {
      text = "log";
    } else if (name.endsWith(".diff")) {
      text = "diff";
    } else if (name.endsWith(".patch")) {
      text = "patch";
    } else if (name.endsWith(".svg")) {
      text = "svg";
    } else if (name.endsWith(".png")) {
      text = "png";
    } else if (name.endsWith(".jpg")) {
      text = "jpg";
    } else if (name.endsWith(".jpeg")) {
      text = "jpeg";
    } else if (name.endsWith(".gif")) {
      text = "gif";
    } else if (name.endsWith(".bmp")) {
      text = "bmp";
    } else if (name.endsWith(".ico")) {
      text = "ico";
    } else if (name.endsWith(".webp")) {
      text = "webp";
    } else if (name.endsWith(".zip")) {
      text = "zip";
    } else if (name.endsWith(".tar")) {
      text = "tar";
    } else if (name.endsWith(".gz")) {
      text = "gzip";
    } else if (name.endsWith(".7z")) {
      text = "7zip";
    } else if (name.endsWith(".rar")) {
      text = "rar";
    } else if (name.endsWith(".pdf")) {
      text = "pdf";
    } else if (name.endsWith(".doc")) {
      text = "word";
    } else if (name.endsWith(".docx")) {
      text = "word";
    } else if (name.endsWith(".xls")) {
      text = "excel";
    } else if (name.endsWith(".xlsx")) {
      text = "excel";
    } else if (name.endsWith(".ppt")) {
      text = "powerpoint";
    } else if (name.endsWith(".pptx")) {
      text = "powerpoint";
    } else if (name.endsWith(".odt")) {
      text = "openoffice text";
    } else if (name.endsWith(".ods")) {
      text = "openoffice spreadsheet";
    } else if (name.endsWith(".odp")) {
      text = "openoffice presentation";
    } else if (name.endsWith(".odg")) {
      text = "openoffice graphics";
    } else if (name.endsWith(".odf")) {
      text = "openoffice formula";
    } else if (name.endsWith(".rtf")) {
      text = "rtf";
    } else if (name.endsWith(".epub")) {
      text = "epub";
    } else if (name.endsWith(".mobi")) {
      text = "mobi";
    } else if (name.endsWith(".azw")) {
      text = "azw";
    } else text = "";
    input.setPrefixText(text);
  }

  public void setCallBack(FileCallBack call) {
    this.call = call;
  }

  String democode(String code) {
    String prf = "";
    if (code.endsWith(".py")) {
      prf = "print('hello')";
    } else if (code.endsWith(".java")) {
      prf =
          "public class Hello {\n    public static void main(String[] args) {\n        System.out.println(\"hello\");\n    }\n}";
    } else if (code.endsWith(".c")) {
      prf = "#include <stdio.h>\nint main() {\n    printf(\"hello\\n\");\n    return 0;\n}";
    } else if (code.endsWith(".cpp")) {
      prf =
          "#include <iostream>\nusing namespace std;\nint main() {\n    cout << \"hello\" << endl;\n    return 0;\n}";
    } else if (code.endsWith(".javascript")) {
      prf = "console.log('hello');";
    } else if (code.endsWith(".ruby")) {
      prf = "puts 'hello'";
    } else if (code.endsWith(".php")) {
      prf = "<?php echo 'hello'; ?>";
    } else if (code.endsWith(".go")) {
      prf = "package main\nimport \"fmt\"\nfunc main() {\n    fmt.Println(\"hello\")\n}";
    } else if (code.endsWith(".swift")) {
      prf = "print(\"hello\")";
    } else if (code.endsWith(".kotlin")) {
      prf = "fun main() {\n    println(\"hello\")\n}";
    } else if (code.endsWith(".bash")) {
      prf = "echo 'hello'";
    } else if (code.endsWith(".r")) {
      prf = "cat('hello')";
    } else if (code.endsWith(".dart")) {
      prf = "void main() {\n    print('hello');\n}";
    } else if (code.endsWith(".sql")) {
      prf = "SELECT 'hello';";
    } else if (code.endsWith(".html")) {
      prf = "<!DOCTYPE html>\n<html>\n<body>\n    <h1>hello</h1>\n</body>\n</html>";
    } else if (code.endsWith(".css")) {
      prf = "body:before { content: 'hello'; }";
    } else if (code.endsWith(".clang")) {
      prf = "#include <stdio.h>\nint main() {\n    printf(\"hello\\n\");\n    return 0;\n}";
    } else if (code.endsWith(".groovy")) {
      prf = "println 'hello'";
    } else if (code.endsWith(".perl")) {
      prf = "print 'hello\\n';";
    } else if (code.endsWith(".scala")) {
      prf = "object Hello extends App {\n    println(\"hello\")\n}";
    } else if (code.endsWith(".clojure")) {
      prf = "(println \"hello\")";
    } else if (code.endsWith(".prolog")) {
      prf = "hello :- write('hello').";
    } else if (code.endsWith(".assembly")) {
      prf =
          "section .data\n    msg db 'hello',0\nsection .text\n    extern printf\n    global main\nmain:\n    mov rdi, msg\n    call printf\n    ret";
    } else if (code.endsWith(".haskell")) {
      prf = "main :: IO ()\nmain = putStrLn \"hello\"";
    } else if (code.endsWith(".objectivec")) {
      prf =
          "#import <Foundation/Foundation.h>\nint main(int argc, const char * argv[]) {\n    @autoreleasepool {\n        NSLog(@\"hello\");\n    }\n    return 0;\n}";
    } else if (code.endsWith(".lua")) {
      prf = "print('hello')";
    } else if (code.endsWith(".v")) {
      prf = "fn main() {\n    println('hello')\n}";
    } else if (code.endsWith(".fsharp")) {
      prf = "printfn \"hello\"";
    } else if (code.endsWith(".elixir")) {
      prf = "IO.puts 'hello'";
    } else if (code.endsWith(".tcl")) {
      prf = "puts 'hello'";
    } else if (code.endsWith(".powershell")) {
      prf = "Write-Host 'hello'";
    } else if (code.endsWith(".jq")) {
      prf = "'hello'";
    } else if (code.endsWith(".cobol")) {
      prf =
          "       IDENTIFICATION DIVISION.\n       PROGRAM-ID. Hello.\n       PROCEDURE DIVISION.\n           DISPLAY \"hello\".\n           STOP RUN.";
    } else if (code.endsWith(".fortran")) {
      prf = "program hello\n    print *, 'hello'\nend program hello";
    } else if (code.endsWith(".pascal")) {
      prf = "program Hello;\nbegin\n  writeln('hello');\nend.";
    } else if (code.endsWith(".d")) {
      prf = "void main() {\n    import std.stdio;\n    writeln(\"hello\");\n}";
    } else if (code.endsWith(".nim")) {
      prf = "echo \"hello\"";
    } else if (code.endsWith(".haxe")) {
      prf = "class Main {\n    static function main() {\n        trace(\"hello\");\n    }\n}";
    }

    return prf;
  }
}
