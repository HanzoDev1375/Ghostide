package ir.ninjacoder.ghostide;

import ir.ninjacoder.ghostide.utils.FileUtil;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.Tool;
import org.antlr.v4.tool.ANTLRMessage;
import org.antlr.v4.tool.ANTLRToolListener;
import java.io.IOException;
import org.antlr.v4.tool.ErrorType;

public class G4Compiler {
  private static String pathOutput;

  public static void compile(String input, String output, String packages) {
    if (input.endsWith(".g4")) {
      String[] args = {
        input, "-package", packages,"-o", output,
      };
      main(args);
      pathOutput = output;
    }
  }

  static void main(String[] args) {
    Tool antlr = new Tool(args);
    StringBuilder b = new StringBuilder();

    if (args.length == 0) {
      antlr.help();
    }

    try {
      antlr.addListener(
          new ANTLRToolListener() {

            @Override
            public void info(String info) {
              b.append(info).append("\n");
              showToast(info);
            }

            @Override
            public void error(ANTLRMessage error) {
              var msg = error.getErrorType().msg;
              int line = error.line;
              int col = error.charPosition;
              var filename = error.fileName;
              StringBuilder builder = new StringBuilder();
              builder.append("Code by ghost ide").append('\n');
              builder.append(msg).append('\n');
              builder.append("Line : ").append(line).append('\n');
              builder.append("Col : ").append(col).append('\n');
              builder.append("FileName : ").append(filename).append('\n');
              showToast(builder.toString());
              FileUtil.writeFile(
                  "/storage/emulated/0/GhostWebIDE/antlrgrammererr.log", builder.toString());
            }

            @Override
            public void warning(ANTLRMessage error) {
              var msg = error.getErrorType().msg;
              int line = error.line;
              int col = error.charPosition;
              var filename = error.fileName;
              StringBuilder builder = new StringBuilder();
              builder.append("Code by ghost ide").append('\n');
              builder.append(msg).append('\n');
              builder.append("Line : ").append(line).append('\n');
              builder.append("Col : ").append(col).append('\n');
              builder.append("FileName : ").append(filename).append('\n');
              showToast(builder.toString());
              FileUtil.writeFile(
                  "/storage/emulated/0/GhostWebIDE/antlrgrammerwar.log", builder.toString());
            }
          });
      antlr.processGrammarsOnCommandLine();
    } finally {

      if (antlr.log) {
        try {
          String logname = antlr.logMgr.save();
          System.out.println("wrote " + logname);
          showToast("wrote " + logname);

        } catch (IOException ioe) {
          antlr.errMgr.toolError(ErrorType.INTERNAL_ERROR, ioe);
        }
      }
    }
  }

  static void showToast(String s) {
    Toast.makeText(GhostIdeAppLoader.getContext(), s, 2).show();
  }
}
