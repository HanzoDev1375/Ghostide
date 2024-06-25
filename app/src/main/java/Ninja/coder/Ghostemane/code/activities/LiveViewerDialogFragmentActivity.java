package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.Naitivae;
import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.widget.PraramnetLayoutNinja;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class LiveViewerDialogFragmentActivity extends DialogFragment {

    private PraramnetLayoutNinja param;
    private LinearLayout linear2;
    private WebView mweb;
    private ImageView imageview1;
    private TextView textview1;

    private SharedPreferences shp;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
        View _view = _inflater.inflate(R.layout.liveviewer_dialog_fragment, _container, false);
        initialize(_savedInstanceState, _view);
        initializeLogic();
        return _view;
    }

    private void initialize(Bundle _savedInstanceState, View _view) {
        param = _view.findViewById(R.id.param);
        linear2 = _view.findViewById(R.id.linear2);
        mweb = _view.findViewById(R.id.mweb);
        mweb.getSettings().setJavaScriptEnabled(true);
        mweb.getSettings().setSupportZoom(true);
        imageview1 = _view.findViewById(R.id.imageview1);
        textview1 = _view.findViewById(R.id.textview1);
        shp = getContext().getSharedPreferences("shp", Activity.MODE_PRIVATE);

        //no listener code

        //no listener code

        //webviewOnProgressChanged
        mweb.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int _newProgress) {

            }
        });

        mweb.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
                final String _url = _param2;

                super.onPageStarted(_param1, _param2, _param3);
            }

            @Override
            public void onPageFinished(WebView _param1, String _param2) {
                final String _url = _param2;

                super.onPageFinished(_param1, _param2);
            }
        });

        imageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                dismiss();
            }
        });
    }

    private void initializeLogic() {
        if (shp.contains("pos_path")) {
            mweb.loadUrl("file:///".concat(shp.getString("pos_path", "")));
        }
        mweb.getSettings().setJavaScriptEnabled(true);
        mweb.getSettings().setBuiltInZoomControls(true);
        mweb.getSettings().setDisplayZoomControls(false);
        Naitivae.FragmentStatusAndNativeView(this, "#FF2B2122");
        Naitivae.FragmentModeAnim(this, android.R.anim.fade_in);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            getDialog().getWindow().setLayout(width, height);
            getDialog().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0xFF2B2122));
        }
    }
}
