package Ninja.coder.Ghostemane.code.tasks.app;


import Ninja.coder.Ghostemane.code.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;

import java.text.NumberFormat;

/**
 * A dialog showing a progress indicator and an optional text message or view.
 * Only a text message or a view can be used at the same time.
 *
 * <p>The dialog can be made cancelable on back key press.</p>
 *
 * <p>The progress range is 0 to {@link #getMax() max}.</p>
 *
 * @deprecated <code>ProgressDialogCompat</code> is a modal dialog, which prevents the
 * user from interacting with the app. Instead of using this class, you should
 * use a progress indicator like {@link android.widget.ProgressBar}, which can
 * be embedded in your app's UI. Alternatively, you can use a
 * <a href="/guide/topics/ui/notifiers/notifications.html">notification</a>
 * to inform the user of the task's progress.
 */

public class ProgressDialogCompat extends AlertDialog {

    /**
     * Creates a ProgressDialogCompat with a circular, spinning progress
     * bar. This is the default.
     */
    public static final int STYLE_SPINNER = 0;

    /**
     * Creates a ProgressDialogCompat with a horizontal progress bar.
     */
    public static final int STYLE_HORIZONTAL = 1;


    private ProgressBar mProgress;

    private TextView mMessageView;

    private int mProgressStyle = STYLE_SPINNER;

    private TextView mProgressNumber;
    private String mProgressNumberFormat;
    private TextView mProgressPercent;
    private NumberFormat mProgressPercentFormat;

    private int mMax;
    private int mProgressVal;
    private int mSecondaryProgressVal;
    private int mIncrementBy;
    private int mIncrementSecondaryBy;
    private Drawable mProgressDrawable;
    private Drawable mIndeterminateDrawable;
    private CharSequence mMessage;
    private boolean mIndeterminate;
    private Context context;
    private boolean mHasStarted;
    private Handler mViewUpdateHandler;

    /**
     * Creates a Progress dialog.
     *
     * @param context the parent context
     */
    public ProgressDialogCompat(Context context) {
        super(context);
        initFormats();
        this.context = context;
    }

    /**
     * Creates a Progress dialog.
     *
     * @param context the parent context
     * @param theme   the resource ID of the theme against which to inflate
     *                this dialog, or {@code 0} to use the parent
     *                {@code context}'s default alert dialog theme
     */
    public ProgressDialogCompat(Context context, int theme) {
        super(context, theme);
        initFormats();
        this.context = context;
    }

    /**
     * Creates and shows a ProgressDialogCompat.
     *
     * @param context the parent context
     * @param title   the title text for the dialog's window
     * @param message the text to be displayed in the dialog
     * @return the ProgressDialogCompat
     */
    public static ProgressDialogCompat show(Context context, CharSequence title,
                                            CharSequence message) {
        return show(context, title, message, false);
    }

    /**
     * Creates and shows a ProgressDialogCompat.
     *
     * @param context       the parent context
     * @param title         the title text for the dialog's window
     * @param message       the text to be displayed in the dialog
     * @param indeterminate true if the dialog should be {@link #setIndeterminate(boolean)
     *                      indeterminate}, false otherwise
     * @return the ProgressDialogCompat
     */
    public static ProgressDialogCompat show(Context context, CharSequence title,
                                            CharSequence message, boolean indeterminate) {
        return show(context, title, message, indeterminate, false, null);
    }

    /**
     * Creates and shows a ProgressDialogCompat.
     *
     * @param context       the parent context
     * @param title         the title text for the dialog's window
     * @param message       the text to be displayed in the dialog
     * @param indeterminate true if the dialog should be {@link #setIndeterminate(boolean)
     *                      indeterminate}, false otherwise
     * @param cancelable    true if the dialog is {@link #setCancelable(boolean) cancelable},
     *                      false otherwise
     * @return the ProgressDialogCompat
     */
    public static ProgressDialogCompat show(Context context, CharSequence title,
                                            CharSequence message, boolean indeterminate, boolean cancelable) {
        return show(context, title, message, indeterminate, cancelable, null);
    }

    /**
     * Creates and shows a ProgressDialogCompat.
     *
     * @param context        the parent context
     * @param title          the title text for the dialog's window
     * @param message        the text to be displayed in the dialog
     * @param indeterminate  true if the dialog should be {@link #setIndeterminate(boolean)
     *                       indeterminate}, false otherwise
     * @param cancelable     true if the dialog is {@link #setCancelable(boolean) cancelable},
     *                       false otherwise
     * @param cancelListener the {@link #setOnCancelListener(OnCancelListener) listener}
     *                       to be invoked when the dialog is canceled
     * @return the ProgressDialogCompat
     */
    public static ProgressDialogCompat show(Context context, CharSequence title,
                                            CharSequence message, boolean indeterminate,
                                            boolean cancelable, OnCancelListener cancelListener) {
        ProgressDialogCompat dialog = new ProgressDialogCompat(context);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setIndeterminate(indeterminate);
        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);
        dialog.show();
        return dialog;
    }

    private void initFormats() {
        mProgressNumberFormat = "%1d/%2d";
        mProgressPercentFormat = NumberFormat.getPercentInstance();
        mProgressPercentFormat.setMaximumFractionDigits(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (mProgressStyle == STYLE_HORIZONTAL) {

            /* Use a separate handler to update the text views as they
             * must be updated on the same thread that created them.
             */
            mViewUpdateHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);

                    /* Update the number and percent */
                    int progress = mProgress.getProgress();
                    int max = mProgress.getMax();
                    if (mProgressNumberFormat != null) {
                        String format = mProgressNumberFormat;
                        mProgressNumber.setText(String.format(format, progress, max));
                    } else {
                        mProgressNumber.setText("");
                    }
                    if (mProgressPercentFormat != null) {
                        double percent = (double) progress / (double) max;
                        SpannableString tmp = new SpannableString(mProgressPercentFormat.format(percent));
                        tmp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD),
                                0, tmp.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        mProgressPercent.setText(tmp);
                    } else {
                        mProgressPercent.setText("");
                    }
                }
            };

            View view = inflater.inflate(
                    R.layout.alert_dialog_progress, null);
            mProgress = (ProgressBar) view.findViewById(R.id.progress);
            mProgressNumber = (TextView) view.findViewById(R.id.progress_number);
            mProgressPercent = (TextView) view.findViewById(R.id.progress_percent);
            setView(view);
        } else {
            View view = inflater.inflate(R.layout.progress_dialog2, null);
            mProgress = (ProgressBar) view.findViewById(android.R.id.progress);
            mMessageView = (TextView) view.findViewById(R.id.message);
            setView(view);
        }
        if (mMax > 0) {
            setMax(mMax);
        }
        if (mProgressVal > 0) {
            setProgress(mProgressVal);
        }
        if (mSecondaryProgressVal > 0) {
            setSecondaryProgress(mSecondaryProgressVal);
        }
        if (mIncrementBy > 0) {
            incrementProgressBy(mIncrementBy);
        }
        if (mIncrementSecondaryBy > 0) {
            incrementSecondaryProgressBy(mIncrementSecondaryBy);
        }
        if (mProgressDrawable != null) {
            setProgressDrawable(mProgressDrawable);
        }
        if (mIndeterminateDrawable != null) {
            setIndeterminateDrawable(mIndeterminateDrawable);
        }
        if (mMessage != null) {
            setMessage(mMessage);
        }
        setIndeterminate(mIndeterminate);
        onProgressChanged();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        mHasStarted = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHasStarted = false;
    }

    /**
     * Gets the current progress.
     *
     * @return the current progress, a value between 0 and {@link #getMax()}
     */
    public int getProgress() {
        if (mProgress != null) {
            return mProgress.getProgress();
        }
        return mProgressVal;
    }

    /**
     * Sets the current progress.
     *
     * @param value the current progress, a value between 0 and {@link #getMax()}
     * @see ProgressBar#setProgress(int)
     */
    public void setProgress(int value) {
        if (mHasStarted) {
            mProgress.setProgress(value);
            onProgressChanged();
        } else {
            mProgressVal = value;
        }
    }

    /**
     * Gets the current secondary progress.
     *
     * @return the current secondary progress, a value between 0 and {@link #getMax()}
     */
    public int getSecondaryProgress() {
        if (mProgress != null) {
            return mProgress.getSecondaryProgress();
        }
        return mSecondaryProgressVal;
    }

    /**
     * Sets the secondary progress.
     *
     * @param secondaryProgress the current secondary progress, a value between 0 and
     *                          {@link #getMax()}
     * @see ProgressBar#setSecondaryProgress(int)
     */
    public void setSecondaryProgress(int secondaryProgress) {
        if (mProgress != null) {
            mProgress.setSecondaryProgress(secondaryProgress);
            onProgressChanged();
        } else {
            mSecondaryProgressVal = secondaryProgress;
        }
    }

    /**
     * Gets the maximum allowed progress value. The default value is 100.
     *
     * @return the maximum value
     */
    public int getMax() {
        if (mProgress != null) {
            return mProgress.getMax();
        }
        return mMax;
    }

    /**
     * Sets the maximum allowed progress value.
     */
    public void setMax(int max) {
        if (mProgress != null) {
            mProgress.setMax(max);
            onProgressChanged();
        } else {
            mMax = max;
        }
    }

    /**
     * Increments the current progress value.
     *
     * @param diff the amount by which the current progress will be incremented,
     *             up to {@link #getMax()}
     */
    public void incrementProgressBy(int diff) {
        if (mProgress != null) {
            mProgress.incrementProgressBy(diff);
            onProgressChanged();
        } else {
            mIncrementBy += diff;
        }
    }

    /**
     * Increments the current secondary progress value.
     *
     * @param diff the amount by which the current secondary progress will be incremented,
     *             up to {@link #getMax()}
     */
    public void incrementSecondaryProgressBy(int diff) {
        if (mProgress != null) {
            mProgress.incrementSecondaryProgressBy(diff);
            onProgressChanged();
        } else {
            mIncrementSecondaryBy += diff;
        }
    }

    /**
     * Sets the drawable to be used to display the progress value.
     *
     * @param d the drawable to be used
     * @see ProgressBar#setProgressDrawable(Drawable)
     */
    public void setProgressDrawable(Drawable d) {
        if (mProgress != null) {
            mProgress.setProgressDrawable(d);
        } else {
            mProgressDrawable = d;
        }
    }

    /**
     * Sets the drawable to be used to display the indeterminate progress value.
     *
     * @param d the drawable to be used
     * @see ProgressBar#setProgressDrawable(Drawable)
     * @see #setIndeterminate(boolean)
     */
    public void setIndeterminateDrawable(Drawable d) {
        if (mProgress != null) {
            mProgress.setIndeterminateDrawable(d);
        } else {
            mIndeterminateDrawable = d;
        }
    }

    /**
     * Whether this ProgressDialogCompat is in indeterminate mode.
     *
     * @return true if the dialog is in indeterminate mode, false otherwise
     */
    public boolean isIndeterminate() {
        if (mProgress != null) {
            return mProgress.isIndeterminate();
        }
        return mIndeterminate;
    }

    /**
     * Change the indeterminate mode for this ProgressDialogCompat. In indeterminate
     * mode, the progress is ignored and the dialog shows an infinite
     * animation instead.
     *
     * <p><strong>Note:</strong> A ProgressDialogCompat with style {@link #STYLE_SPINNER}
     * is always indeterminate and will ignore this setting.</p>
     *
     * @param indeterminate true to enable indeterminate mode, false otherwise
     * @see #setProgressStyle(int)
     */
    public void setIndeterminate(boolean indeterminate) {
        if (mProgress != null) {
            mProgress.setIndeterminate(indeterminate);
        } else {
            mIndeterminate = indeterminate;
        }
    }

    @Override
    public void setMessage(CharSequence message) {
        if (mProgress != null) {
            if (mProgressStyle == STYLE_HORIZONTAL) {
                super.setMessage(message);
            } else {
                mMessageView.setText(message);
            }
        } else {
            mMessage = message;
        }
    }

    /**
     * Sets the style of this ProgressDialogCompat, either {@link #STYLE_SPINNER} or
     * {@link #STYLE_HORIZONTAL}. The default is {@link #STYLE_SPINNER}.
     *
     * <p><strong>Note:</strong> A ProgressDialogCompat with style {@link #STYLE_SPINNER}
     * is always indeterminate and will ignore the {@link #setIndeterminate(boolean)
     * indeterminate} setting.</p>
     *
     * @param style the style of this ProgressDialogCompat, either {@link #STYLE_SPINNER} or
     *              {@link #STYLE_HORIZONTAL}
     */
    public void setProgressStyle(int style) {
        mProgressStyle = style;
    }

    /**
     * Change the format of the small text showing current and maximum units
     * of progress.  The default is "%1d/%2d".
     * Should not be called during the number is progressing.
     *
     * @param format A string passed to {@link String#format String.format()};
     *               use "%1d" for the current number and "%2d" for the maximum.  If null,
     *               nothing will be shown.
     */
    public void setProgressNumberFormat(String format) {
        mProgressNumberFormat = format;
        onProgressChanged();
    }

    /**
     * Change the format of the small text showing the percentage of progress.
     * The default is
     * {@link NumberFormat#getPercentInstance() NumberFormat.getPercentageInstnace().}
     * Should not be called during the number is progressing.
     *
     * @param format An instance of a {@link NumberFormat} to generate the
     *               percentage text.  If null, nothing will be shown.
     */
    public void setProgressPercentFormat(NumberFormat format) {
        mProgressPercentFormat = format;
        onProgressChanged();
    }

    private void onProgressChanged() {
        if (mProgressStyle == STYLE_HORIZONTAL) {
            if (mViewUpdateHandler != null && !mViewUpdateHandler.hasMessages(0)) {
                mViewUpdateHandler.sendEmptyMessage(0);
            }
        }
    }
}
