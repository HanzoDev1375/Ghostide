package Ninja.coder.Ghostemane.code.layoutmanager;

import Ninja.coder.Ghostemane.code.widget.GhostWebMaterialDialog;
import Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat.FastScrollWebView;
import Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat.FastScroller;
import Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat.FastScrollerBuilder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.NestedScrollingChildHelper;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import fi.iki.elonen.NanoHTTPD;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;


public class WebViewCompatGhostWeb extends FastScrollWebView {
    private final int[] mScrollOffset = new int[2];
    private final int[] mScrollConsumed = new int[2];
    private int mLastY;
    private int mNestedOffsetY;
    private NestedScrollingChildHelper mChildHelper;


    public WebViewCompatGhostWeb(Context context) {
        super(context);
        init();
    }

    public WebViewCompatGhostWeb(Context context, AttributeSet ab) {
        super(context, ab);
        init();
    }

    private void init() {
        setCustomDialog();
        setOnApplyWindowInsetsListener(
                new FastUtils() {

                    @Override
                    public WindowInsets onApplyWindowInsets(
                            @androidx.annotation.NonNull View view,
                            @androidx.annotation.NonNull WindowInsets insets) {
                        insets = super.onApplyWindowInsets(view, insets);

                        return insets;
                    }
                });
        FastScrollerBuilder fastScrollerBuilder = new FastScrollerBuilder(this);
        fastScrollerBuilder.useMd2Style();
        fastScrollerBuilder.build();
        WebSettings webSettings = getSettings();
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
    }

    public void setCustomDialog() {
        setWebChromeClient(
                new WebChromeClient() {
                    @Override
                    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                        showAlertDialog(url, message, result);
                        return true;
                    }

                    @Override
                    public boolean onJsPrompt(
                            WebView view,
                            String url,
                            String message,
                            String defaultValue,
                            JsPromptResult result) {
                        jsApp(url, message, defaultValue, result);
                        return true;
                    }
                });
    }

    private void showAlertDialog(String url, String message, JsResult result) {
        GhostWebMaterialDialog dialogBuilder = new GhostWebMaterialDialog(getContext());
        dialogBuilder.setTitle(url);
        dialogBuilder.setMessage(message);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton(android.R.string.ok, (witch, di) -> result.confirm());
        dialogBuilder.setNegativeButton(android.R.string.cancel, (witch, di) -> result.cancel());
        AlertDialog dialog = dialogBuilder.show();
        View view = dialog.getWindow().getDecorView();
        view.setScaleX(0f);
        view.setScaleY(0f);
        ObjectAnimator alertAnim = new ObjectAnimator();
        ObjectAnimator alertAnim1 = new ObjectAnimator();
        alertAnim.setTarget(view);
        alertAnim.setPropertyName("scaleX");
        alertAnim.setFloatValues((float) (1));
        alertAnim.setDuration((int) (250));
        alertAnim.start();
        alertAnim1.setTarget(view);
        alertAnim1.setPropertyName("scaleY");
        alertAnim1.setFloatValues((float) (1));
        alertAnim1.setDuration((int) (250));
        alertAnim1.start();
        dialog.show();
    }

    private void jsApp(String url, String message, String defaultValue, JsPromptResult result) {
        TextInputLayout input = new TextInputLayout(getContext());
        EditText editor = new EditText(getContext());
        input.setOrientation(LinearLayout.VERTICAL);
        MaterialShapeDrawable shapeDrawable =
                new MaterialShapeDrawable(
                        ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 23f).build());
        shapeDrawable.setFillColor(ColorStateList.valueOf(0xFFFFAF7A));
        input.setBackground(shapeDrawable);
        editor.setPadding(8, 8, 8, 8);
        editor.setTextColor(Color.parseColor("#FFFFFF"));
        editor.setHintTextColor(0xFDB69A);
        editor.setTextSize(16f);
        input.addView(editor);
        AlertDialog dialog =
                new GhostWebMaterialDialog(getContext())
                        .setView(input)
                        .setTitle(url)
                        .setCancelable(false)
                        .setPositiveButton(android.R.string.ok, null)
                        .setNegativeButton(android.R.string.cancel, null)
                        .create();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        dialog.setOnShowListener(
                (var) -> {
                    editor.setHint(message);
                    editor.setText(defaultValue);
                    Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                    editor.requestFocus();
                    positiveButton.setOnClickListener(
                            view -> {
                                result.confirm(editor.getText().toString());
                                dialog.dismiss();
                            });

                    negativeButton.setOnClickListener(
                            view -> {
                                result.cancel();
                                dialog.dismiss();
                            });
                });
        dialog.show();
        final View view = dialog.getWindow().getDecorView();
        view.setScaleX(0f);
        view.setScaleY(0f);
        final ObjectAnimator alertAnim = new ObjectAnimator();
        final ObjectAnimator alertAnim1 = new ObjectAnimator();
        alertAnim.setTarget(view);
        alertAnim.setPropertyName("scaleX");
        alertAnim.setFloatValues((float) (1));
        alertAnim.setDuration((int) (250));
        alertAnim.start();
        alertAnim1.setTarget(view);
        alertAnim1.setPropertyName("scaleY");
        alertAnim1.setFloatValues((float) (1));
        alertAnim1.setDuration((int) (250));
        alertAnim1.start();
    }

    public void openInBrowser() {
        String url = getUrl();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        getContext().startActivity(i);
    }

    public void setDesktopMode(boolean enabled) {
        WebSettings webSettings = getSettings();
        if (enabled) {
            webSettings.setUserAgentString(
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
            webSettings.setUseWideViewPort(true);
            webSettings.setLoadWithOverviewMode(true);
        } else {

            webSettings.setUserAgentString(null);
            webSettings.setUseWideViewPort(false);
            webSettings.setLoadWithOverviewMode(false);
        }
    }

    public void Host(String path) {
        SimpleHttpServer httpServer =
                new SimpleHttpServer(
                        8080,
                        (String) path.subSequence(0, path.lastIndexOf("/")),
                        path.substring(path.lastIndexOf("/") + 1));
        httpServer.startServer();
        loadUrl(httpServer.getLocalIpAddress());
    }

    public static class SimpleHttpServer {
        public WebServer server;

        private int port;

        private String rootFolder;
        private String indexName;

        public SimpleHttpServer(int port, String rootFolder, String indexName) {
            this.port = port;
            this.rootFolder = rootFolder;
            this.indexName = indexName;
        }

        public void startServer() {
            try {
                server = new WebServer(port);
                server.start();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        public void stopServer() {
            if (server != null) {
                server.stop();
            }
        }

        public String getLocalIpAddress() {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface networkInterface = networkInterfaces.nextElement();
                    Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = inetAddresses.nextElement();
                        if (!inetAddress.isLoopbackAddress() && inetAddress.getAddress().length == 4) {
                            return inetAddress.getHostAddress() + ":" + port;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        private class WebServer extends NanoHTTPD {

            public WebServer(int port) {
                super(port);
            }

            @Override
            public Response serve(IHTTPSession session) {
                String uri = session.getUri();
                if (uri.endsWith("/")) {
                    uri += indexName;
                }
                String filePath = rootFolder + uri;

                try {
                    if (new File(filePath).exists()) {
                        FileInputStream fis = new FileInputStream(filePath);

                        int contentLength = fis.available();

                        return newFixedLengthResponse(
                                NanoHTTPD.Response.Status.OK, getMimeTypeForFile(filePath), fis, contentLength);
                    } else {
                        return newFixedLengthResponse(
                                NanoHTTPD.Response.Status.NOT_FOUND, NanoHTTPD.MIME_PLAINTEXT, "File not found.");
                    }
                } catch (IOException e) {

                    e.printStackTrace();
                    return newFixedLengthResponse(
                            NanoHTTPD.Response.Status.INTERNAL_ERROR,
                            NanoHTTPD.MIME_PLAINTEXT,
                            "Internal server error.");
                }
            }
        }
    }

    public class FastUtils implements View.OnApplyWindowInsetsListener {

        @NonNull
        private final Rect mPadding = new Rect();
        @Nullable
        private final FastScroller mFastScroller;

        public FastUtils(@Nullable View view, @Nullable FastScroller fastScroller) {
            if (view != null) {
                mPadding.set(
                        view.getPaddingLeft(),
                        view.getPaddingTop(),
                        view.getPaddingRight(),
                        view.getPaddingBottom());
            }
            mFastScroller = fastScroller;
        }

        public FastUtils() {
            this(null, null);
        }

        @NonNull
        @Override
        public WindowInsets onApplyWindowInsets(@NonNull View view, @NonNull WindowInsets insets) {
            view.setPadding(
                    mPadding.left + insets.getSystemWindowInsetLeft(),
                    mPadding.top,
                    mPadding.right + insets.getSystemWindowInsetRight(),
                    mPadding.bottom + insets.getSystemWindowInsetBottom());
            if (mFastScroller != null) {
                mFastScroller.setPadding(
                        insets.getSystemWindowInsetLeft(),
                        0,
                        insets.getSystemWindowInsetRight(),
                        insets.getSystemWindowInsetBottom());
            }
            return insets;
        }
    }
}
