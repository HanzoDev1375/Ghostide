package com.mcal.uidesigner.common;

import android.annotation.SuppressLint;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.TimeUtils;

import com.mcal.uidesigner.ProxyTextView;

public class KeyStroke {
    private final boolean alt;
    private final char ch;
    private final boolean ctrl;
    private final int keyCode;
    private final boolean shift;

    public KeyStroke(int keyCode, char ch, boolean shift, boolean ctrl, boolean alt) {
        this.ch = ch;
        this.keyCode = keyCode;
        this.shift = shift;
        this.ctrl = ctrl;
        this.alt = alt;
    }

    public KeyStroke(int keyCode, boolean shift, boolean ctrl, boolean alt) {
        this.ch = 65535;
        this.keyCode = keyCode;
        this.shift = shift;
        this.ctrl = ctrl;
        this.alt = alt;
    }

    @Nullable
    public static KeyStroke load(@NonNull String value) {
        String[] split = value.split(",");
        if (split.length != 5) {
            return null;
        }
        return new KeyStroke(
                Integer.parseInt(split[0]),
                (char) Integer.parseInt(split[1]),
                Boolean.parseBoolean(split[2]),
                Boolean.parseBoolean(split[3]),
                Boolean.parseBoolean(split[4]));
    }

    public boolean isChar() {
        return ch != 65535;
    }

    public char getChar() {
        return ch;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public boolean isShift() {
        return shift;
    }

    public boolean isCtrl() {
        return ctrl;
    }

    public boolean isAlt() {
        return alt;
    }

    public boolean matches(@NonNull KeyStroke pressedKeyStroke) {
        if (alt != pressedKeyStroke.alt || ctrl != pressedKeyStroke.ctrl || shift != pressedKeyStroke.shift) {
            return false;
        }
        if (keyCode == -1 || keyCode != pressedKeyStroke.keyCode) {
            return ch != 65535 && ch == pressedKeyStroke.ch;
        }
        return true;
    }

    @NonNull
    public String toString() {
        String str = "";
        if (shift) {
            str = str + "Shift+";
        }
        if (ctrl) {
            str = str + "Ctrl+";
        }
        if (alt) {
            str = str + "Alt+";
        }
        return str + getDisplayLabel();
    }

    @NonNull
    @SuppressLint("RestrictedApi")
    private String getDisplayLabel() {
        switch (keyCode) {
            case -1:
                return Character.toUpperCase(ch) + "";
            case TimeUtils.HUNDRED_DAY_FIELD_LEN:
                return "Up";
            case ProxyTextView.INPUTTYPE_date:
                return "Down";
            case 21:
                return "Left";
            case 22:
                return "Right";
            case 24:
                return "VolUp";
            case 25:
                return "VolDown";
            case 61:
                return "Tab";
            case 62:
                return "Space";
            case 66:
                return "Enter";
            case 67:
                return "Backspace";
            case 92:
                return "PgUp";
            case 93:
                return "PgDown";
            case 122:
                return "Home";
            case 123:
                return "End";
            case 164:
                return "VolMute";
            default:
                String displayLabel = (KeyCharacterMap.load(0).getDisplayLabel(keyCode) + "").trim();
                if (displayLabel.length() > 0) {
                    return displayLabel;
                }
                String name = KeyEvent.keyCodeToString(keyCode).toLowerCase();
                if (name.startsWith("keycode_")) {
                    name = name.substring("keycode_".length());
                }
                name = name.replace("_", " ");
                return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
    }

    public String store() {
        return keyCode + "," + ((int) ch) + "," + shift + "," + ctrl + "," + alt;
    }
}
