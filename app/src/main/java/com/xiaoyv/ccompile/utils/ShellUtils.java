package com.xiaoyv.ccompile.utils;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 *
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/08/07
 *     desc  : utils about shell
 * </pre>
 */
public final class ShellUtils {

  public static String shellRed = "\033[0;31m"; // Red
  public static String shellGreen = "\033[0;32m"; // Green
  public static String shellYellow = "\033[0;33m"; // Yellow
  public static String shellBlue = "\033[0;34m"; // Blue
  public static String shellMagenta = "\033[0;35m"; // Magenta
  public static String shellCyan = "\033[0;36m"; // Cyan
  public static String shellWhite = "\033[0;37m"; // White
  public static String shellBlack = "\033[0;30m"; // Black
  public static String shellBrightRed = "\033[1;31m"; // Bright Red
  public static String shellBrightGreen = "\033[1;32m"; // Bright Green
  public static String shellBrightYellow = "\033[1;33m"; // Bright Yellow
  public static String shellBrightBlue = "\033[1;34m"; // Bright Blue
  public static String shellBrightMagenta = "\033[1;35m"; // Bright Magenta
  public static String shellBrightCyan = "\033[1;36m"; // Bright Cyan
  public static String shellBrightWhite = "\033[1;37m"; // Bright White

  private static final String LINE_SEP = System.getProperty("line.separator");

  private ShellUtils() {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }

  /**
   * Execute the command asynchronously.
   *
   * @param command The command.
   * @param isRooted True to use root, false otherwise.
   * @param callback The callback.
   * @return the task
   */
  public static Utils.Task<CommandResult> execCmdAsync(
      final String command, final boolean isRooted, final Utils.Callback<CommandResult> callback) {
    return execCmdAsync(new String[] {command}, isRooted, true, callback);
  }

  /**
   * Execute the command asynchronously.
   *
   * @param commands The commands.
   * @param isRooted True to use root, false otherwise.
   * @param callback The callback.
   * @return the task
   */
  public static Utils.Task<CommandResult> execCmdAsync(
      final List<String> commands,
      final boolean isRooted,
      final Utils.Callback<CommandResult> callback) {
    return execCmdAsync(
        commands == null ? null : commands.toArray(new String[] {}), isRooted, true, callback);
  }

  /**
   * Execute the command asynchronously.
   *
   * @param commands The commands.
   * @param isRooted True to use root, false otherwise.
   * @param callback The callback.
   * @return the task
   */
  public static Utils.Task<CommandResult> execCmdAsync(
      final String[] commands,
      final boolean isRooted,
      final Utils.Callback<CommandResult> callback) {
    return execCmdAsync(commands, isRooted, true, callback);
  }

  /**
   * Execute the command asynchronously.
   *
   * @param command The command.
   * @param isRooted True to use root, false otherwise.
   * @param isNeedResultMsg True to return the message of result, false otherwise.
   * @param callback The callback.
   * @return the task
   */
  public static Utils.Task<CommandResult> execCmdAsync(
      final String command,
      final boolean isRooted,
      final boolean isNeedResultMsg,
      final Utils.Callback<CommandResult> callback) {
    return execCmdAsync(new String[] {command}, isRooted, isNeedResultMsg, callback);
  }

  /**
   * Execute the command asynchronously.
   *
   * @param commands The commands.
   * @param isRooted True to use root, false otherwise.
   * @param isNeedResultMsg True to return the message of result, false otherwise.
   * @param callback The callback.
   * @return the task
   */
  public static Utils.Task<CommandResult> execCmdAsync(
      final List<String> commands,
      final boolean isRooted,
      final boolean isNeedResultMsg,
      final Utils.Callback<CommandResult> callback) {
    return execCmdAsync(
        commands == null ? null : commands.toArray(new String[] {}),
        isRooted,
        isNeedResultMsg,
        callback);
  }

  /**
   * Execute the command asynchronously.
   *
   * @param commands The commands.
   * @param isRooted True to use root, false otherwise.
   * @param isNeedResultMsg True to return the message of result, false otherwise.
   * @param callback The callback.
   * @return the task
   */
  public static Utils.Task<CommandResult> execCmdAsync(
      final String[] commands,
      final boolean isRooted,
      final boolean isNeedResultMsg,
      @NonNull final Utils.Callback<CommandResult> callback) {
    return Utils.doAsync(
        new Utils.Task<CommandResult>(callback) {
          @Override
          public CommandResult doInBackground() {
            return execCmd(commands, isRooted, isNeedResultMsg);
          }
        });
  }

  /**
   * Execute the command.
   *
   * @param command The command.
   * @param isRooted True to use root, false otherwise.
   * @return the single {@link CommandResult} instance
   */
  public static CommandResult execCmd(final String command, final boolean isRooted) {
    return execCmd(new String[] {command}, isRooted, true);
  }

  /**
   * Execute the command.
   *
   * @param commands The commands.
   * @param isRooted True to use root, false otherwise.
   * @return the single {@link CommandResult} instance
   */
  public static CommandResult execCmd(final List<String> commands, final boolean isRooted) {
    return execCmd(commands == null ? null : commands.toArray(new String[] {}), isRooted, true);
  }

  /**
   * Execute the command.
   *
   * @param commands The commands.
   * @param isRooted True to use root, false otherwise.
   * @return the single {@link CommandResult} instance
   */
  public static CommandResult execCmd(final String[] commands, final boolean isRooted) {
    return execCmd(commands, isRooted, true);
  }

  /**
   * Execute the command.
   *
   * @param command The command.
   * @param isRooted True to use root, false otherwise.
   * @param isNeedResultMsg True to return the message of result, false otherwise.
   * @return the single {@link CommandResult} instance
   */
  public static CommandResult execCmd(
      final String command, final boolean isRooted, final boolean isNeedResultMsg) {
    return execCmd(new String[] {command}, isRooted, isNeedResultMsg);
  }

  /**
   * Execute the command.
   *
   * @param commands The commands.
   * @param isRooted True to use root, false otherwise.
   * @param isNeedResultMsg True to return the message of result, false otherwise.
   * @return the single {@link CommandResult} instance
   */
  public static CommandResult execCmd(
      final List<String> commands, final boolean isRooted, final boolean isNeedResultMsg) {
    return execCmd(
        commands == null ? null : commands.toArray(new String[] {}), isRooted, isNeedResultMsg);
  }

  /**
   * Execute the command.
   *
   * @param commands The commands.
   * @param isRooted True to use root, false otherwise.
   * @param isNeedResultMsg True to return the message of result, false otherwise.
   * @return the single {@link CommandResult} instance
   */
  public static CommandResult execCmd(
      final String[] commands, final boolean isRooted, final boolean isNeedResultMsg) {
    int result = -1;
    if (commands == null || commands.length == 0) {
      return new CommandResult(result, "", "");
    }
    Process process = null;
    BufferedReader successResult = null;
    BufferedReader errorResult = null;
    StringBuilder successMsg = null;
    StringBuilder errorMsg = null;
    DataOutputStream os = null;
    try {
      process = Runtime.getRuntime().exec(isRooted ? "su" : "sh");
      os = new DataOutputStream(process.getOutputStream());
      for (String command : commands) {
        if (command == null) continue;
        os.write(command.getBytes());
        os.writeBytes(LINE_SEP);
        os.flush();
      }
      os.writeBytes("exit" + LINE_SEP);
      os.flush();
      result = process.waitFor();
      if (isNeedResultMsg) {
        successMsg = new StringBuilder();
        errorMsg = new StringBuilder();
        successResult =
            new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
        errorResult = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
        String line;
        if ((line = successResult.readLine()) != null) {
          successMsg.append(line);
          while ((line = successResult.readLine()) != null) {
            successMsg.append(LINE_SEP).append(line);
          }
        }
        if ((line = errorResult.readLine()) != null) {
          errorMsg.append(line);
          while ((line = errorResult.readLine()) != null) {
            errorMsg.append(LINE_SEP).append(line);
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (os != null) {
          os.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (successResult != null) {
          successResult.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (errorResult != null) {
          errorResult.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (process != null) {
        process.destroy();
      }
    }
    return new CommandResult(
        result,
        successMsg == null ? "" : successMsg.toString(),
        errorMsg == null ? "" : errorMsg.toString());
  }

  /** The result of command. */
  public static class CommandResult {
    public int result;
    public String successMsg;
    public String errorMsg;

    public CommandResult(final int result, final String successMsg, final String errorMsg) {
      this.result = result;
      this.successMsg = successMsg;
      this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
      return "result: "
          + result
          + "\n"
          + "successMsg: "
          + successMsg
          + "\n"
          + "errorMsg: "
          + errorMsg;
    }
  }
}
