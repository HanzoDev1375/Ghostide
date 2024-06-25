package Ninja.coder.Ghostemane.code.utils;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.skydoves.powermenu.PowerMenu;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;

import java.util.HashMap;

import static com.google.android.material.R.attr.*;

public class MapObjectData {
    public static String ToolbarTextColor = "";
    public static String BLOCK_LINE_CURRENT;
    public static String LINE_DIVIDER;
    public static String SyombolBarTextColor;
    public static String HTML_TAG;
    public static String FabColorStroker;
    public static String LINE_NUMBER;
    public static String KEYWORD;
    public static String AUTO_COMP_PANEL_CORNER;
    public static String SELECTION_HANDLE;
    public static String TabImageColorFilter;
    public static String AUTO_COMP_PANEL_BG;
    public static String COMMENT;
    public static String ToolbarColor;
    public static String IDENTIFIER_NAME;
    public static String DisplayTextColorTab;
    public static String NON_PRINTABLE_CHAR;
    public static String SELECTION_INSERT;
    public static String Ninja;
    public static String TEXTCOLORHDER;
    public static String TabTextColor;
    public static String BLOCK_LINE;
    public static String MenuBackground;
    public static String LITERAL;
    public static String FabBackgroundColorColor;
    public static String ATTRIBUTE_VALUE;
    public static String TabBack;
    public static String TEXTCOLORFORGRAND;
    public static String ImageColor;
    public static String TEXT_NORMAL;
    public static String ATTRIBUTE_NAME;
    public static String print;
    public static String OPERATOR;
    public static String CURRENT_LINE;
    public static String WHOLE_BACKGROUND;
    public static String BackgroundColorLinear;
    public static String FabImageColor;
    public static String LINE_NUMBER_BACKGROUND;

    public static void setObjectColor(View view, HashMap<String, Object> map, String key, int defaultColor) {
        if (map.containsKey(key)) {
            setColor(key, map, view);
        } else {
            view.setBackgroundColor(Color.BLACK);
        }
    }

    protected static final synchronized void setColor(String colorAcsent, HashMap<String, Object> map, View view) {
        MaterialShapeDrawable color = new MaterialShapeDrawable(
                ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 200).build());
        try {
            color.setFillColor(ColorStateList.valueOf(Color.parseColor(map.get(colorAcsent).toString())));
        } catch (Exception e) {
            Log.e("Color", e.getMessage());
        }

        view.setBackground(color);

    }

    public static void setMatetialThemeCodeEditor(CodeEditor editor) {

        editor.getColorScheme().setColor(EditorColorScheme.OPERATOR, MaterialColors.getColor(editor, colorPrimaryFixed));
        editor.getColorScheme().setColor(EditorColorScheme.BLOCK_LINE, MaterialColors.getColor(editor, colorErrorContainer));
        editor.getColorScheme().setColor(EditorColorScheme.BLOCK_LINE_CURRENT, MaterialColors.getColor(editor, colorErrorContainer));
        editor.getColorScheme().setColor(EditorColorScheme.NON_PRINTABLE_CHAR, MaterialColors.getColor(editor, colorTertiary));
        editor.getColorScheme().setColor(EditorColorScheme.CURRENT_LINE, Color.parseColor("#20171717"));
        editor.getColorScheme().setColor(EditorColorScheme.SELECTION_INSERT, MaterialColors.getColor(editor, colorTertiaryContainer));
        editor.getColorScheme().setColor(EditorColorScheme.SELECTION_HANDLE, MaterialColors.getColor(editor, colorTertiaryContainer));
        editor.getColorScheme().setColor(EditorColorScheme.LINE_NUMBER, MaterialColors.getColor(editor, colorSecondary));
        editor.getColorScheme().setColor(EditorColorScheme.LINE_DIVIDER, MaterialColors.getColor(editor, colorSurface));
        editor.getColorScheme().setColor(EditorColorScheme.ATTRIBUTE_VALUE, MaterialColors.getColor(editor, colorPrimary));
        editor.getColorScheme().setColor(EditorColorScheme.ATTRIBUTE_NAME, MaterialColors.getColor(editor, colorTertiaryFixed));
        editor.getColorScheme().setColor(EditorColorScheme.HTML_TAG, MaterialColors.getColor(editor, colorOnPrimaryContainer));
        editor.getColorScheme().setColor(EditorColorScheme.TEXT_NORMAL, MaterialColors.getColor(editor, colorTertiary));
        editor.getColorScheme().setColor(EditorColorScheme.IDENTIFIER_NAME, Color.parseColor("#626262"));
        editor.getColorScheme().setColor(EditorColorScheme.COMMENT, MaterialColors.getColor(editor, colorOnSurfaceInverse));
        editor.getColorScheme().setColor(EditorColorScheme.KEYWORD, MaterialColors.getColor(editor, colorPrimaryFixedDim));
        editor.getColorScheme().setColor(EditorColorScheme.print, MaterialColors.getColor(editor, colorTertiaryContainer));
        editor.getColorScheme().setColor(EditorColorScheme.Ninja, MaterialColors.getColor(editor, colorPrimary));
        editor.getColorScheme().setColor(EditorColorScheme.LITERAL, MaterialColors.getColor(editor, colorTertiary));
        editor.getColorScheme().setColor(EditorColorScheme.AUTO_COMP_PANEL_BG, MaterialColors.getColor(editor, colorSurface));
        editor.getColorScheme().setColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER, MaterialColors.getColor(editor, colorPrimary));
        editor.getColorScheme().setColor(EditorColorScheme.LINE_NUMBER_BACKGROUND, MaterialColors.getColor(editor, colorSurface));
        editor.getColorScheme().setColor(EditorColorScheme.WHOLE_BACKGROUND, MaterialColors.getColor(editor, colorSurface));

    }

    public static void setPowerMenu(PowerMenu menu, AppCompatActivity context) {
        if (menu != null) {
            menu.setMenuColor(MaterialColors.getColor(context, colorSurface, 0));
            menu.setIconColor(MaterialColors.getColor(context, colorPrimary, 0));
            menu.setTextColor(MaterialColors.getColor(context, colorPrimary, 0));
            menu.setSelectedMenuColor(MaterialColors.getColor(context, colorPrimaryFixed, 0));
        }
    }

    public static void setWindows(AppCompatActivity compat) {
        var windows = compat.getWindow();
        if (windows != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                windows.setStatusBarColor(MaterialColors.getColor(windows.getContext(), colorSurface, 0));
                windows.setNavigationBarColor(MaterialColors.getColor(windows.getContext(), colorSurface, 0));
                windows.getDecorView().setBackgroundColor(MaterialColors.getColor(windows.getContext(), colorSurface, 0));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                windows.setNavigationBarDividerColor(MaterialColors.getColor(windows.getContext(), colorPrimary, 0));
            }
        }

    }

}