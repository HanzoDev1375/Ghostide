package Ninja.coder.Ghostemane.code.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.SymbolChannel;

public class SymbolInputView extends LinearLayout {

    private int TextColor;
    private SymbolChannel channel;

    public SymbolInputView(Context context) {
        super(context);
        setBackgroundColor(Color.TRANSPARENT);
        setOrientation(HORIZONTAL);
    }

    public SymbolInputView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.TRANSPARENT);
        setOrientation(HORIZONTAL);
    }

    public SymbolInputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(Color.TRANSPARENT);
        setOrientation(HORIZONTAL);
    }

    public SymbolInputView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setBackgroundColor(Color.TRANSPARENT);
        setOrientation(HORIZONTAL);
    }

    public void bindEditor(CodeEditor editor) {
        channel = editor.createNewSymbolChannel();
    }


    public void setTextColor(int color12) {

        for (int i = 0; i < getChildCount(); i++) {

            ((Button) getChildAt(i)).setTextColor(color12);
        }
        TextColor = color12;
    }

    public void removeSymbols() {
        removeAllViews();
    }

    public int GetTextColor() {

        return TextColor;
    }

    public void addSymbols(String[] display, final String[] insertText) {
        int count = Math.max(display.length, insertText.length);

        for (int i = 0; i < count; i++) {
            final Button btn = new Button(getContext(), null, android.R.attr.buttonStyleSmall);
            btn.setText(display[i]);
            btn.setTypeface(null, android.graphics.Typeface.BOLD);
            ///  btn.setTypeface(Typeface.createFromAsset(getAssets(),"GhostFont.ttf"));

            ////حالت شب
            btn.setTextColor(TextColor);
            ///end code
            //	btn.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/myfont.ttf"), 0);
            btn.setBackground(new ColorDrawable(0));
            addView(btn, new LinearLayout.LayoutParams(-2, -1));
            final int finalI = i;

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    channel.insertSymbol(btn.getText().toString(), 1);

                }
            });
        }
    }

}
