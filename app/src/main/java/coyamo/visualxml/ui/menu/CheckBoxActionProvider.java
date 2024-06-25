package coyamo.visualxml.ui.menu;

import android.content.Context;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.ActionProvider;

import Ninja.coder.Ghostemane.code.R;

public class CheckBoxActionProvider extends ActionProvider {
    AppCompatImageButton button;
    OnCheckedChangeListener l;
    private boolean isChecked;

    public CheckBoxActionProvider(Context context) {
        super(context);
    }

    @Override
    public View onCreateActionView() {
        button = new AppCompatImageButton(getContext(), null, androidx.appcompat.R.attr.actionButtonStyle);
        //必须要加
        button.setClickable(true);
        button.setImageResource(R.drawable.ic_visible);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isChecked = !isChecked;
                if (isChecked) button.setImageResource(R.drawable.ic_edit);
                else button.setImageResource(R.drawable.ic_visible);
                l.onCheckedChanged(button, isChecked);
            }

        });
        return button;
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener l) {
        this.l = l;
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(View buttonView, boolean isChecked);
    }
}
