package Ninja.coder.Ghostemane.code;

import Ninja.coder.Ghostemane.code.utils.FileUtil;
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
        input, "-package", packages, "-Werror", "-Xlog", "-o", output,
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
              b.append(error.getErrorType().msg).append("\n");
              showToast(error.getErrorType().msg);
              FileUtil.writeFile(
                  error.getErrorType().msg + "\n line: " + String.valueOf(error.line),
                  pathOutput + "/error.txt");
            }

            @Override
            public void warning(ANTLRMessage war) {
              //    b.append().append("\n");
              showToast(war.getErrorType().msg);
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
    Toast.makeText(ApplicationLoader.getContext(), s, 2).show();
  }
}
