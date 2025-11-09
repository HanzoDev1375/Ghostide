package io.github.rosemoe.sora.util;

import android.content.Context;
import android.content.res.Configuration;
import android.view.inputmethod.InputMethodManager;

/**
 * Utility functions for keyboard.
 *
 * @author Akash Yadav
 */
public class KeyboardUtils {

    /**
     * Check if hardware keyboard is connected. Based on default implementation of
     * [InputMethodService.onEvaluateInputViewShown].
     * https://developer.android.com/guide/topics/resources/providing-resources#ImeQualifier
     *
     * @param context The Context for operations.
     * @return Returns true if device has hardware keys for text input or an external hardware
     * keyboard is connected, otherwise false.
     */
    public static boolean isHardKeyboardConnected(Context context) {
        if (context == null) return false;
        Configuration config = context.getResources().getConfiguration();
        return (config.keyboard != Configuration.KEYBOARD_NOKEYS
                || config.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO);
    }

    public static boolean isKeyBoardVisbale(Context context) {
        InputMethodManager manger = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        return manger.isActive();
    }
}