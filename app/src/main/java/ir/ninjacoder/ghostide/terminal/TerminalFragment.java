package ir.ninjacoder.ghostide.terminal;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.google.android.material.color.MaterialColors;
import com.termux.terminal.TerminalColors;
import com.termux.terminal.TerminalEmulator;
import com.termux.terminal.TerminalSession;
import com.termux.terminal.TerminalSessionClient;
import com.termux.view.TerminalView;
import com.termux.view.TerminalViewClient;
import ir.ninjacoder.ghostide.config.RubyCommandCompat;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.databinding.TerminalBinding;
import ir.ninjacoder.ghostide.marco.CommentList;
import ir.ninjacoder.ghostide.terminal.key.VirtualKeysView;
import ir.ninjacoder.ghostide.terminal.key.VirtualKeyButton;
import ir.ninjacoder.ghostide.terminal.key.VirtualKeysInfo;
import ir.ninjacoder.ghostide.terminal.key.VirtualKeysConstants;
import ir.ninjacoder.ghostide.terminal.key.SpecialButton;
import ir.ninjacoder.ghostide.config.CommandCompat;

public class TerminalFragment extends Fragment implements TerminalViewClient {

  private HashMap<String, Object> imap = new HashMap<>();

  private String pos = "";

  protected SharedPreferences getvb;

  private TerminalView terminals;

  protected VirtualKeysView keys;

  protected KeyListener listener;

  private static final String KEY_FONT_SIZE = "terminal_fontSize";

  private int MIN_FONT_SIZE;

  private int MAX_FONT_SIZE;

  private int DEFAULT_FONT_SIZE;

  private float terminalTextSize = 24f;

  private final float minTextSize = 10.0f;

  private final float maxTextSize = 40.0f;
  public static final String VIRTUAL_KEYS =
      "["
          + "\n  ["
          + "\n    \"ESC\","
          + "\n    {"
          + "\n      \"key\": \"/\","
          + "\n      \"popup\": \"\\\\\""
          + "\n    },"
          + "\n    {"
          + "\n      \"key\": \"-\","
          + "\n      \"popup\": \"|\""
          + "\n    },"
          + "\n    \"HOME\","
          + "\n    \"UP\","
          + "\n    \"END\","
          + "\n    \"PGUP\""
          + "\n  ],"
          + "\n  ["
          + "\n    \"TAB\","
          + "\n    \"CTRL\","
          + "\n    \"ALT\","
          + "\n    \"LEFT\","
          + "\n    \"DOWN\","
          + "\n    \"RIGHT\","
          + "\n    \"PGDN\""
          + "\n  ]"
          + "\n]";
  private TerminalBinding bind;

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    bind = TerminalBinding.inflate(inflater, container, false);
    return bind.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initialize(savedInstanceState);
    initializeLogic();
  }

  private KeyListener getKeyListener() {
    return listener == null ? listener = new KeyListener(terminals) : listener;
  }

  private void initialize(Bundle _savedInstanceState) {
    terminals = bind.term;
    keys = bind.keysterm;
  }

  public View getTermuxActivityBottomSpaceView() {
    return keys;
  }

  private void initializeLogic() {
    getvb = requireActivity().getSharedPreferences("getvb", 0);
    String shell = "/bin/sh";
    if (!new File("/bin/sh").exists()) {
      shell = "/system/bin/sh";
    }
    Map<String, String> maps = new HashMap<>();
    maps.put("HOME", shell);
    var helper = maps.get("HOME");
    bind.getRoot().postDelayed(() -> keys.setVisibility(View.VISIBLE), 30000);
    String[] envVars = null;
    String[] argsList = {};
    bind.keysterm.setButtonColors(
        MaterialColors.getColor(bind.keysterm, ObjectUtils.TvColor, 0),
        MaterialColors.getColor(bind.keysterm, ObjectUtils.ColorNormal, 0),
        Color.TRANSPARENT,
        MaterialColors.getColor(bind.keysterm, ObjectUtils.ColorFilter, 0));
    String dsb = terminals.getContext().getFilesDir().getAbsolutePath();
    terminals.setTerminalViewClient(this);
    requireActivity()
        .getWindow()
        .setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    try {
      keys.setVirtualKeysViewClient(getKeyListener());
      keys.reload(
          new VirtualKeysInfo(VIRTUAL_KEYS, "", VirtualKeysConstants.CONTROL_CHARS_ALIASES));
    } catch (Exception e) {
      Toast.makeText(requireActivity(), e.getLocalizedMessage(), 2).show();
      e.printStackTrace();
    }
    TerminalSession terminalSession =
        new TerminalSession(
            helper,
            dsb,
            argsList,
            envVars,
            TerminalEmulator.DEFAULT_TERMINAL_TRANSCRIPT_ROWS,
            new TerminalSessionClient() {

              @Override
              public void onTextChanged(TerminalSession arg0) {
                terminals.onScreenUpdated();
              }

              @Override
              public void onTitleChanged(TerminalSession terminalSession) {}

              @Override
              public void onSessionFinished(TerminalSession terminalSession) {
                if (!terminalSession.isRunning()) {
                  terminalSession.finishIfRunning();
                  // finish();
                  requireActivity().finish();
                }
              }

              @Override
              public void onBell(TerminalSession arg0) {}

              @Override
              public void onColorsChanged(TerminalSession session) {}

              @Override
              public void onTerminalCursorStateChange(boolean start) {}

              @Override
              public Integer getTerminalCursorStyle() {
                return TerminalEmulator.DEFAULT_TERMINAL_CURSOR_STYLE;
              }

              @Override
              public void logError(String arg0, String arg1) {}

              @Override
              public void logWarn(String arg0, String arg1) {}

              @Override
              public void logInfo(String arg0, String arg1) {}

              @Override
              public void logDebug(String arg0, String arg1) {}

              @Override
              public void logVerbose(String arg0, String arg1) {}

              @Override
              public void logStackTraceWithMessage(String arg0, String arg1, Exception arg2) {}

              @Override
              public void logStackTrace(String arg0, Exception arg1) {}

              @Override
              public void onPasteTextFromClipboard(TerminalSession session) {
                String clips = ClipboardUtils.getText().toString();
                if (clips.trim().length() > 0 && terminals != null && terminals.mEmulator != null) {
                  terminals.mEmulator.paste(clips);
                }
              }

              @Override
              public void onCopyTextToClipboard(TerminalSession session, String text) {
                ClipboardUtils.copyText(text);
              }
            });
    if (terminalSession != null) {
      terminals.attachSession(terminalSession);
    }
    terminals.setTextSize(SizeUtils.dp2px(12f));
    terminals.setKeepScreenOn(true);
    terminalSession.titleChanged("1", shell);
    terminals.post(
        () -> {
          if (getArguments() != null && getArguments().containsKey("path")) {
            var pys =
                CommandCompat.INSTANCE.getInterpreterCommand(
                    requireContext(), getArguments().getString("path"));
            terminals.mTermSession.write(pys + '\r');
          } else if (getArguments() != null && getArguments().containsKey("phpcode")) {
            String php =
                CommentList.getRunPhpCommand(
                    requireContext(), new File(getArguments().getString("phpcode")));
            terminals.mTermSession.write(php + '\r');
            Log.d("run php from : ", php);
          } else if (getArguments() != null && getArguments().containsKey("dart")) {
            terminals.mTermSession.write(
                DartFileRunner.runDartFile(
                        requireContext(), new File(getArguments().getString("dart")))
                    + '\r');
          } else if (getArguments() != null && getArguments().containsKey("java")) {
            String logText = getArguments().getString("java");
            try {
              File pythonFile =
                  new File(
                      requireContext().getFilesDir().getAbsolutePath() + File.separator,
                      "temp_script.py");
              StringBuilder b = new StringBuilder();
              b.append("st = ")
                  .append("\"")
                  .append("\"")
                  .append("\"")
                  .append(logText)
                  .append("\"")
                  .append("\"")
                  .append("\"");
              b.append("\n\n")
                  .append("RED")
                  .append("=")
                  .append("\"")
                  .append("\033[31m")
                  .append("\"")
                  .append("\n");
              b.append("\n\n")
                  .append("RESET")
                  .append("=")
                  .append("\"")
                  .append("\033[0m")
                  .append("\"")
                  .append("\n");
              b.append("\n").append("print(RED + st + RESET)");
              try (FileWriter writer = new FileWriter(pythonFile)) {
                writer.write(b.toString());
              }
              String command = pythonFile.getAbsolutePath();
              terminals.mTermSession.write(
                  CommandCompat.INSTANCE.getInterpreterCommand(requireContext(), command) + '\r');
            } catch (IOException e) {
              e.printStackTrace();
            }
          } else {
            if (getvb.contains("Script")) {
              var code =
                  CommandCompat.INSTANCE.getInterpreterCommand(
                      requireContext(), getvb.getString("Script", ""));
              terminals.mTermSession.write(code + '\r');
            } else {
              var mypath = requireContext().getFilesDir().getAbsolutePath() + "/" + "databins";
              var code = CommandCompat.INSTANCE.getInterpreterCommand(requireContext(), mypath);
              terminals.mTermSession.write(code + '\r');
            }
          }
        });
    try {
      Properties pr = new Properties();
      if (getvb != null) {
        if (getvb.contains("themes")) {
          pr.load(new FileInputStream(getvb.getString("themes", "")));
          String color = pr.getProperty("background");
          requireActivity()
              .getWindow()
              .getDecorView()
              .setBackgroundColor(Color.parseColor(color != null ? color : "#ff000000"));
          var forg = pr.getProperty("foreground");
          if (Build.VERSION.SDK_INT >= 28)
            requireActivity()
                .getWindow()
                .setNavigationBarDividerColor(Color.parseColor(forg != null ? forg : "#ff202820"));
          if (Build.VERSION.SDK_INT >= 21) {
            requireActivity()
                .getWindow()
                .setNavigationBarColor(Color.parseColor(color != null ? color : "#ff000000"));
            requireActivity()
                .getWindow()
                .setStatusBarColor(Color.parseColor(color != null ? color : "#ff000000"));
          }
          TerminalColors.COLOR_SCHEME.updateWith(pr);
        }
      }
    } catch (Exception err) {
      err.printStackTrace();
    }
  }

  @Override
  public float onScale(float scale) {
    float currentTextSize = terminalTextSize;
    float newTextSize = currentTextSize * scale;
    newTextSize = Math.max(minTextSize, Math.min(newTextSize, maxTextSize));
    terminals.setTextSize((int) newTextSize);
    terminalTextSize = newTextSize;
    if (scale < 0.9f || scale > 1.1f) {
      return 1.0f;
    }
    return scale;
  }

  private void changeFontSize(final boolean increase) {
    int fontSize = getFontSize();
    fontSize += (increase ? 1 : -1) * 2;
    fontSize = Math.max(MIN_FONT_SIZE, Math.min(fontSize, MAX_FONT_SIZE));
    setFontSize(fontSize, true);
  }

  public void setFontSize(int value, boolean apply) {
    GhostIdeAppLoader.getPrefManager().getString(KEY_FONT_SIZE, String.valueOf(value));
    if (apply) {
      terminals.setTextSize(getFontSize());
    }
  }

  public int getFontSize() {
    int fontSize;
    try {
      fontSize =
          Integer.parseInt(
              GhostIdeAppLoader.getPrefManager()
                  .getString(KEY_FONT_SIZE, String.valueOf(DEFAULT_FONT_SIZE)));
    } catch (NumberFormatException err) {
      fontSize = DEFAULT_FONT_SIZE;
    }
    return Math.min(Math.max(fontSize, MIN_FONT_SIZE), MAX_FONT_SIZE);
  }

  public void setFontVariables() {
    int[] sizes = getDefaultFontSizes();
    DEFAULT_FONT_SIZE = sizes[0];
    MIN_FONT_SIZE = sizes[1];
    MAX_FONT_SIZE = sizes[2];
  }

  private int[] getDefaultFontSizes() {
    float dipInPixels =
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics());
    int[] sizes = new int[3];
    // min
    sizes[1] = (int) (4f * dipInPixels);
    int defaultFontSize = Math.round(9 * dipInPixels);
    if (defaultFontSize % 2 == 1) defaultFontSize--;
    // default
    sizes[0] = defaultFontSize;
    // max
    sizes[2] = 256;
    setFontSize(16, false);
    if (GhostIdeAppLoader.getPrefManager()
        .getString(KEY_FONT_SIZE, "<not_available>")
        .equals("<not_available>")) {
      setFontSize(defaultFontSize, false);
    }
    return sizes;
  }

  @Override
  public boolean isTerminalViewSelected() {
    return false;
  }

  @Override
  public boolean readShiftKey() {
    return false;
  }

  @Override
  public boolean readFnKey() {
    return false;
  }

  @Override
  public void onSingleTapUp(MotionEvent arg0) {
    terminals.setFocusable(true);
    terminals.setFocusableInTouchMode(true);
    terminals.requestFocus();
    KeyboardUtils.showSoftInput(terminals);
  }

  @Override
  public boolean shouldBackButtonBeMappedToEscape() {
    return false;
  }

  @Override
  public boolean shouldEnforceCharBasedInput() {
    return false;
  }

  @Override
  public boolean shouldUseCtrlSpaceWorkaround() {
    return false;
  }

  @Override
  public void copyModeChanged(boolean arg0) {}

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent e, TerminalSession session) {
    if (keyCode == KeyEvent.KEYCODE_ENTER && !session.isRunning()) {
      System.exit(1);
      return true;
    }
    return false;
  }

  @Override
  public boolean onKeyUp(int arg0, KeyEvent arg1) {
    return false;
  }

  @Override
  public boolean onLongPress(MotionEvent arg0) {
    return false;
  }

  @Override
  public boolean readControlKey() {
    Boolean state = keys.readSpecialButton(SpecialButton.CTRL, true);
    return state != null && state;
  }

  @Override
  public boolean readAltKey() {
    Boolean state = keys.readSpecialButton(SpecialButton.ALT, true);
    return state != null && state;
  }

  @Override
  public boolean onCodePoint(int arg0, boolean arg1, TerminalSession arg2) {
    return false;
  }

  @Override
  public void onEmulatorSet() {}

  @Override
  public void logError(String arg0, String arg1) {}

  @Override
  public void logWarn(String arg0, String arg1) {}

  @Override
  public void logInfo(String arg0, String arg1) {}

  @Override
  public void logDebug(String arg0, String arg1) {}

  @Override
  public void logVerbose(String arg0, String arg1) {}

  @Override
  public void logStackTraceWithMessage(String arg0, String arg1, Exception arg2) {}

  @Override
  public void logStackTrace(String arg0, Exception arg1) {}

  private static final class KeyListener implements VirtualKeysView.IVirtualKeysView {

    private final TerminalView terminal;

    public KeyListener(TerminalView terminal) {
      this.terminal = terminal;
    }

    @Override
    public void onVirtualKeyButtonClick(View view, VirtualKeyButton buttonInfo, Button button) {
      if (terminal == null) {
        return;
      }
      if (buttonInfo.isMacro()) {
        String[] keys = buttonInfo.getKey().split(" ");
        boolean ctrlDown = false;
        boolean altDown = false;
        boolean shiftDown = false;
        boolean fnDown = false;
        for (String key : keys) {
          if (SpecialButton.CTRL.getKey().equals(key)) {
            ctrlDown = true;
          } else if (SpecialButton.ALT.getKey().equals(key)) {
            altDown = true;
          } else if (SpecialButton.SHIFT.getKey().equals(key)) {
            shiftDown = true;
          } else if (SpecialButton.FN.getKey().equals(key)) {
            fnDown = true;
          } else {
            onTerminalExtraKeyButtonClick(key, ctrlDown, altDown, shiftDown, fnDown);
            ctrlDown = false;
            altDown = false;
            shiftDown = false;
            fnDown = false;
          }
        }
      } else {
        onTerminalExtraKeyButtonClick(buttonInfo.getKey(), false, false, false, false);
      }
    }

    private void onTerminalExtraKeyButtonClick(
        String key, boolean ctrlDown, boolean altDown, boolean shiftDown, boolean fnDown) {
      if (VirtualKeysConstants.PRIMARY_KEY_CODES_FOR_STRINGS.containsKey(key)) {
        Integer keyCode = VirtualKeysConstants.PRIMARY_KEY_CODES_FOR_STRINGS.get(key);
        if (keyCode == null) {
          return;
        }
        int metaState = 0;
        if (ctrlDown) {
          metaState |= KeyEvent.META_CTRL_ON | KeyEvent.META_CTRL_LEFT_ON;
        }
        if (altDown) {
          metaState |= KeyEvent.META_ALT_ON | KeyEvent.META_ALT_LEFT_ON;
        }
        if (shiftDown) {
          metaState |= KeyEvent.META_SHIFT_ON | KeyEvent.META_SHIFT_LEFT_ON;
        }
        if (fnDown) {
          metaState |= KeyEvent.META_FUNCTION_ON;
        }
        KeyEvent keyEvent = new KeyEvent(0, 0, KeyEvent.ACTION_UP, keyCode, 0, metaState);
        terminal.onKeyDown(keyCode, keyEvent);
      } else {
        // not a control char
        for (int off = 0; off < key.length(); ) {
          int codePoint = key.codePointAt(off);
          terminal.inputCodePoint(codePoint, ctrlDown, altDown);
          off += Character.charCount(codePoint);
        }
      }
    }

    @Override
    public boolean performVirtualKeyButtonHapticFeedback(
        View view, VirtualKeyButton buttonInfo, Button button) {
      return false;
    }
  }
}
