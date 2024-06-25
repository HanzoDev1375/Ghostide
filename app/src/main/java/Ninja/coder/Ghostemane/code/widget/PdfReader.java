package Ninja.coder.Ghostemane.code.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

public class PdfReader extends LinearLayout {
    int pageCount = 0;
    int pageNumber;
    OpenPdf open;
    TextView pagenumber;
    Window window;
    String path = "";

    public PdfReader(Context context, String file) {
        super(context);
        this.path = file;
        File pdf = new File(file);
        if (pdf.exists()) {
            initialize(context);
        }
    }

    public PdfReader(Context context, String file, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.path = file;
        File pdf = new File(file);
        if (pdf.exists()) {
            initialize(context);

        }
    }

    public void initialize(Context ctx) {

        pageNumber = 0;
        window = ((Activity) getContext()).getWindow();

        this.setOrientation(LinearLayout.VERTICAL);
        this.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

        TouchImageView imageView = new TouchImageView(ctx);
        imageView.setLayoutParams(
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1));
        imageView.setBackgroundColor(Color.WHITE);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        final SeekBar seekBar = new SeekBar(ctx);

        pagenumber = new TextView(ctx);
        //  pagenumber.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ghostfont.ttf"), 0);
        //pagenumber.setTypeface(Typeface.createFromAsset());

        LinearLayout bottomPanel = new LinearLayout(ctx);
        bottomPanel.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        bottomPanel.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout linPages = new LinearLayout(ctx);
        linPages.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        linPages.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        p.bottomMargin = 4;
        p.topMargin = 4;
        p.rightMargin = 8;
        p.leftMargin = 8;

        LinearLayout.LayoutParams p2 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

        // button next
        final Button boutonNext = new Button(ctx);
        boutonNext.setLayoutParams(p2);
        boutonNext.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        boutonNext.setPadding(0, 0, 0, 0);
        boutonNext.setTextSize(16);
        boutonNext.setTextColor(Color.parseColor("#FFFFBE9E"));
        boutonNext.setText("بعدی");

        // button previous
        final Button boutonPrevious = new Button(ctx);
        boutonPrevious.setLayoutParams(p2);
        boutonPrevious.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        boutonPrevious.setPadding(0, 0, 0, 0);
        boutonPrevious.setTextSize(16);
        boutonPrevious.setTextColor(Color.parseColor("#FFFFBE9E"));
        boutonPrevious.setText("قبلی");

        int color = Color.parseColor("#FF1F1B1C");
        Drawable border = boutonPrevious.getBackground(); // get current EditText drawable
        border.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);

        Drawable border2 = boutonNext.getBackground(); // get current EditText drawable
        border2.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            boutonPrevious.setBackgroundDrawable(border);
            boutonNext.setBackgroundDrawable(border2);
        } else {
            boutonPrevious.setBackground(border);
            boutonNext.setBackground(border2);
        }

        bottomPanel.setPadding(10, 3, 10, 3);
        bottomPanel.setLayoutParams(p);
        linPages.setLayoutParams(p);

        open = new OpenPdf(ctx, imageView, path, pageNumber);
        imageView.setParameters(ctx, open, pageNumber, seekBar);
        pageCount = open.pdfRenderer.getPageCount();

        pagenumber.setText("1/" + String.valueOf(pageCount));

        boutonNext.setOnClickListener(v -> {

            open.showNext();
            seekBar.setProgress(open.getindexPages());
            pagenumber.setText(String.valueOf(open.getindexPages() + 1) + "/" + (pageCount));


        });

        boutonPrevious.setOnClickListener(v -> {


            open.showPrevious();
            seekBar.setProgress(open.getindexPages());
            pagenumber.setText(String.valueOf(open.getindexPages() + 1) + "/" + (pageCount));


        });

        seekBar.setMax(pageCount - 1);
        seekBar.setProgress(pageNumber);
        seekBar.setPadding(8, 8, 8, 8);
        seekBar.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));

        bottomPanel.addView(boutonPrevious);
        bottomPanel.addView(seekBar);
        bottomPanel.addView(boutonNext);
        linPages.addView(pagenumber);

        this.addView(imageView);
        this.addView(bottomPanel);
        this.addView(linPages);

        Toast.makeText(ctx, "working", Toast.LENGTH_LONG).show();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pageNumber = progress;
                pagenumber.setText((pageNumber + 1) + "/" + (pageCount));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(final SeekBar seekBar) {
                open.showPage(pageNumber);
            }
        });

    }

    public void setPdfPath(String path) {
        this.path = path;
    }

    public String getPdfFromPath() {
        return this.path;
    }

    static class TouchImageView extends AppCompatImageView {

        private static final String DEBUG = "DEBUG";


        private static final float SUPER_MIN_MULTIPLIER = .75f;
        private static final float SUPER_MAX_MULTIPLIER = 1.25f;
        Context context;
        private float normalizedScale;
        private Matrix matrix, prevMatrix;

        ;
        private State state;

        private float minScale;
        private float maxScale;
        private float superMinScale;
        private float superMaxScale;
        private float[] m;
        private Fling fling;
        private int pageNumber;
        private OpenPdf openPdf;
        private SeekBar seekBar;
        private ScaleType mScaleType;
        private boolean imageRenderedAtLeastOnce;
        private boolean onDrawReady;
        private ZoomVariables delayedZoomVariables;
        //
        // Size of view and previous view size (ie before rotation)
        //
        private int viewWidth, viewHeight, prevViewWidth, prevViewHeight;
        //
        // Size of image when it is stretched to fit view. Before and After rotation.
        //
        private float matchViewWidth, matchViewHeight, prevMatchViewWidth, prevMatchViewHeight;
        private ScaleGestureDetector mScaleDetector;
        private GestureDetector mGestureDetector;
        private GestureDetector.OnDoubleTapListener doubleTapListener = null;
        private OnTouchListener userTouchListener = null;
        private OnTouchImageViewListener touchImageViewListener = null;

        public TouchImageView(Context context) {
            super(context);
            sharedConstructing(context);
        }

        public TouchImageView(Context context, AttributeSet attrs) {
            super(context, attrs);
            sharedConstructing(context);
        }

        public TouchImageView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            sharedConstructing(context);
        }

        private void sharedConstructing(Context context) {
            super.setClickable(true);
            this.context = context;
            mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
            mGestureDetector = new GestureDetector(context, new GestureListener());
            matrix = new Matrix();
            prevMatrix = new Matrix();
            m = new float[9];
            normalizedScale = 1;
            if (mScaleType == null) {
                mScaleType = ScaleType.FIT_CENTER;
            }
            minScale = 1;
            maxScale = 3;
            superMinScale = SUPER_MIN_MULTIPLIER * minScale;
            superMaxScale = SUPER_MAX_MULTIPLIER * maxScale;
            setImageMatrix(matrix);
            setScaleType(ScaleType.MATRIX);
            setState(State.NONE);
            onDrawReady = false;
            super.setOnTouchListener(new PrivateOnTouchListener());
        }

        @Override
        public void setOnTouchListener(View.OnTouchListener l) {
            userTouchListener = l;
        }

        public void setOnTouchImageViewListener(OnTouchImageViewListener l) {
            touchImageViewListener = l;
        }

        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener l) {
            doubleTapListener = l;
        }

        @Override
        public void setImageResource(int resId) {
            super.setImageResource(resId);
            savePreviousImageValues();
            fitImageToView();
        }

        @Override
        public void setImageBitmap(Bitmap bm) {
            super.setImageBitmap(bm);
            savePreviousImageValues();
            fitImageToView();
        }

        @Override
        public void setImageDrawable(Drawable drawable) {
            super.setImageDrawable(drawable);
            savePreviousImageValues();
            fitImageToView();
        }

        @Override
        public void setImageURI(Uri uri) {
            super.setImageURI(uri);
            savePreviousImageValues();
            fitImageToView();
        }

        @Override
        public ScaleType getScaleType() {
            return mScaleType;
        }

        @Override
        public void setScaleType(ScaleType type) {
            if (type == ScaleType.FIT_START || type == ScaleType.FIT_END) {
                throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
            }
            if (type == ScaleType.MATRIX) {
                super.setScaleType(ScaleType.MATRIX);

            } else {
                mScaleType = type;
                if (onDrawReady) {
                    //
                    // If the image is already rendered, scaleType has been called programmatically
                    // and the TouchImageView should be updated with the new scaleType.
                    //
                    setZoom(this);
                }
            }
        }

        /**
         * Returns false if image is in initial, unzoomed state. False, otherwise.
         *
         * @return true if image is zoomed
         */
        public boolean isZoomed() {
            return normalizedScale != 1;
        }

        /**
         * Return a Rect representing the zoomed image.
         *
         * @return rect representing zoomed image
         */
        public RectF getZoomedRect() {
            if (mScaleType == ScaleType.FIT_XY) {
                throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
            }
            PointF topLeft = transformCoordTouchToBitmap(0, 0, true);
            PointF bottomRight = transformCoordTouchToBitmap(viewWidth, viewHeight, true);

            float w = getDrawable().getIntrinsicWidth();
            float h = getDrawable().getIntrinsicHeight();
            return new RectF(topLeft.x / w, topLeft.y / h, bottomRight.x / w, bottomRight.y / h);
        }

        /**
         * Save the current matrix and view dimensions
         * in the prevMatrix and prevView variables.
         */
        private void savePreviousImageValues() {
            if (matrix != null && viewHeight != 0 && viewWidth != 0) {
                matrix.getValues(m);
                prevMatrix.setValues(m);
                prevMatchViewHeight = matchViewHeight;
                prevMatchViewWidth = matchViewWidth;
                prevViewHeight = viewHeight;
                prevViewWidth = viewWidth;
            }
        }

        @Override
        public Parcelable onSaveInstanceState() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("instanceState", super.onSaveInstanceState());
            bundle.putFloat("saveScale", normalizedScale);
            bundle.putFloat("matchViewHeight", matchViewHeight);
            bundle.putFloat("matchViewWidth", matchViewWidth);
            bundle.putInt("viewWidth", viewWidth);
            bundle.putInt("viewHeight", viewHeight);
            matrix.getValues(m);
            bundle.putFloatArray("matrix", m);
            bundle.putBoolean("imageRendered", imageRenderedAtLeastOnce);
            return bundle;
        }

        @Override
        public void onRestoreInstanceState(Parcelable state) {
            if (state instanceof Bundle) {
                Bundle bundle = (Bundle) state;
                normalizedScale = bundle.getFloat("saveScale");
                m = bundle.getFloatArray("matrix");
                prevMatrix.setValues(m);
                prevMatchViewHeight = bundle.getFloat("matchViewHeight");
                prevMatchViewWidth = bundle.getFloat("matchViewWidth");
                prevViewHeight = bundle.getInt("viewHeight");
                prevViewWidth = bundle.getInt("viewWidth");
                imageRenderedAtLeastOnce = bundle.getBoolean("imageRendered");
                super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
                return;
            }

            super.onRestoreInstanceState(state);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            onDrawReady = true;
            imageRenderedAtLeastOnce = true;
            if (delayedZoomVariables != null) {
                setZoom(delayedZoomVariables.scale, delayedZoomVariables.focusX, delayedZoomVariables.focusY,
                        delayedZoomVariables.scaleType);
                delayedZoomVariables = null;
            }
            super.onDraw(canvas);
        }

        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
            savePreviousImageValues();
        }

        /**
         * Get the max zoom multiplier.
         *
         * @return max zoom multiplier.
         */
        public float getMaxZoom() {
            return maxScale;
        }

        /**
         * Set the max zoom multiplier. Default value: 3.
         *
         * @param max max zoom multiplier.
         */
        public void setMaxZoom(float max) {
            maxScale = max;
            superMaxScale = SUPER_MAX_MULTIPLIER * maxScale;
        }

        public float getMinZoom() {
            return minScale;
        }

        public void setMinZoom(float min) {
            minScale = min;
            superMinScale = SUPER_MIN_MULTIPLIER * minScale;
        }

        public float getCurrentZoom() {
            return normalizedScale;
        }

        public void resetZoom() {
            normalizedScale = 1;
            fitImageToView();
        }

        public void setZoom(float scale) {
            setZoom(scale, 0.5f, 0.5f);
        }

        public void setZoom(float scale, float focusX, float focusY) {
            setZoom(scale, focusX, focusY, mScaleType);
        }

        public void setZoom(float scale, float focusX, float focusY, ScaleType scaleType) {
            //
            // setZoom can be called before the image is on the screen, but at this point,
            // image and view sizes have not yet been calculated in onMeasure. Thus, we should
            // delay calling setZoom until the view has been measured.
            //
            if (!onDrawReady) {
                delayedZoomVariables = new ZoomVariables(scale, focusX, focusY, scaleType);
                return;
            }

            if (scaleType != mScaleType) {
                setScaleType(scaleType);
            }
            resetZoom();
            scaleImage(scale, viewWidth / 2, viewHeight / 2, true);
            matrix.getValues(m);
            m[Matrix.MTRANS_X] = -((focusX * getImageWidth()) - (viewWidth * 0.5f));
            m[Matrix.MTRANS_Y] = -((focusY * getImageHeight()) - (viewHeight * 0.5f));
            matrix.setValues(m);
            fixTrans();
            setImageMatrix(matrix);
        }

        public void setZoom(TouchImageView img) {
            PointF center = img.getScrollPosition();
            setZoom(img.getCurrentZoom(), center.x, center.y, img.getScaleType());
        }

        public PointF getScrollPosition() {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                return null;
            }
            int drawableWidth = drawable.getIntrinsicWidth();
            int drawableHeight = drawable.getIntrinsicHeight();

            PointF point = transformCoordTouchToBitmap(viewWidth / 2, viewHeight / 2, true);
            point.x /= drawableWidth;
            point.y /= drawableHeight;
            return point;
        }

        public void setScrollPosition(float focusX, float focusY) {
            setZoom(normalizedScale, focusX, focusY);
        }

        private void fixTrans() {
            matrix.getValues(m);
            float transX = m[Matrix.MTRANS_X];
            float transY = m[Matrix.MTRANS_Y];

            float fixTransX = getFixTrans(transX, viewWidth, getImageWidth());
            float fixTransY = getFixTrans(transY, viewHeight, getImageHeight());

            if (fixTransX != 0 || fixTransY != 0) {
                matrix.postTranslate(fixTransX, fixTransY);
            }
        }

        private void fixScaleTrans() {
            fixTrans();
            matrix.getValues(m);
            if (getImageWidth() < viewWidth) {
                m[Matrix.MTRANS_X] = (viewWidth - getImageWidth()) / 2;
            }

            if (getImageHeight() < viewHeight) {
                m[Matrix.MTRANS_Y] = (viewHeight - getImageHeight()) / 2;
            }
            matrix.setValues(m);
        }

        private float getFixTrans(float trans, float viewSize, float contentSize) {
            float minTrans, maxTrans;

            if (contentSize <= viewSize) {
                minTrans = 0;
                maxTrans = viewSize - contentSize;

            } else {
                minTrans = viewSize - contentSize;
                maxTrans = 0;
            }

            if (trans < minTrans)
                return -trans + minTrans;
            if (trans > maxTrans)
                return -trans + maxTrans;
            return 0;
        }

        private float getFixDragTrans(float delta, float viewSize, float contentSize) {
            if (contentSize <= viewSize) {
                return 0;
            }
            return delta;
        }

        private float getImageWidth() {
            return matchViewWidth * normalizedScale;
        }

        private float getImageHeight() {
            return matchViewHeight * normalizedScale;
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            Drawable drawable = getDrawable();
            if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
                setMeasuredDimension(0, 0);
                return;
            }

            int drawableWidth = drawable.getIntrinsicWidth();
            int drawableHeight = drawable.getIntrinsicHeight();
            int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            int widthMode = MeasureSpec.getMode(widthMeasureSpec);
            int heightSize = MeasureSpec.getSize(heightMeasureSpec);
            int heightMode = MeasureSpec.getMode(heightMeasureSpec);
            viewWidth = setViewSize(widthMode, widthSize, drawableWidth);
            viewHeight = setViewSize(heightMode, heightSize, drawableHeight);

            //
            // Set view dimensions
            //
            setMeasuredDimension(viewWidth, viewHeight);

            //
            // Fit content within view
            //
            fitImageToView();
        }

        private void fitImageToView() {
            Drawable drawable = getDrawable();
            if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
                return;
            }
            if (matrix == null || prevMatrix == null) {
                return;
            }

            int drawableWidth = drawable.getIntrinsicWidth();
            int drawableHeight = drawable.getIntrinsicHeight();

            //
            // Scale image for view
            //
            float scaleX = (float) viewWidth / drawableWidth;
            float scaleY = (float) viewHeight / drawableHeight;

            switch (mScaleType) {
                case CENTER:
                    scaleX = scaleY = 1;
                    break;

                case CENTER_CROP:
                    scaleX = scaleY = Math.max(scaleX, scaleY);
                    break;

                case CENTER_INSIDE:
                    scaleX = scaleY = Math.min(1, Math.min(scaleX, scaleY));

                case FIT_CENTER:
                    scaleX = scaleY = Math.min(scaleX, scaleY);
                    break;

                case FIT_XY:
                    break;

                default:
                    //
                    // FIT_START and FIT_END not supported
                    //
                    throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");

            }

            //
            // Center the image
            //
            float redundantXSpace = viewWidth - (scaleX * drawableWidth);
            float redundantYSpace = viewHeight - (scaleY * drawableHeight);
            matchViewWidth = viewWidth - redundantXSpace;
            matchViewHeight = viewHeight - redundantYSpace;
            if (!isZoomed() && !imageRenderedAtLeastOnce) {
                //
                // Stretch and center image to fit view
                //
                matrix.setScale(scaleX, scaleY);
                matrix.postTranslate(redundantXSpace / 2, redundantYSpace / 2);
                normalizedScale = 1;

            } else {
                //
                // These values should never be 0 or we will set viewWidth and viewHeight
                // to NaN in translateMatrixAfterRotate. To avoid this, call savePreviousImageValues
                // to set them equal to the current values.
                //
                if (prevMatchViewWidth == 0 || prevMatchViewHeight == 0) {
                    savePreviousImageValues();
                }

                prevMatrix.getValues(m);

                //
                // Rescale Matrix after rotation
                //
                m[Matrix.MSCALE_X] = matchViewWidth / drawableWidth * normalizedScale;
                m[Matrix.MSCALE_Y] = matchViewHeight / drawableHeight * normalizedScale;

                //
                // TransX and TransY from previous matrix
                //
                float transX = m[Matrix.MTRANS_X];
                float transY = m[Matrix.MTRANS_Y];

                //
                // Width
                //
                float prevActualWidth = prevMatchViewWidth * normalizedScale;
                float actualWidth = getImageWidth();
                translateMatrixAfterRotate(Matrix.MTRANS_X, transX, prevActualWidth, actualWidth, prevViewWidth,
                        viewWidth, drawableWidth);

                //
                // Height
                //
                float prevActualHeight = prevMatchViewHeight * normalizedScale;
                float actualHeight = getImageHeight();
                translateMatrixAfterRotate(Matrix.MTRANS_Y, transY, prevActualHeight, actualHeight, prevViewHeight,
                        viewHeight, drawableHeight);

                //
                // Set the matrix to the adjusted scale and translate values.
                //
                matrix.setValues(m);
            }
            fixTrans();
            setImageMatrix(matrix);
        }

        private int setViewSize(int mode, int size, int drawableWidth) {
            int viewSize;
            switch (mode) {
                case MeasureSpec.EXACTLY:
                    viewSize = size;
                    break;

                case MeasureSpec.AT_MOST:
                    viewSize = Math.min(drawableWidth, size);
                    break;

                case MeasureSpec.UNSPECIFIED:
                    viewSize = drawableWidth;
                    break;

                default:
                    viewSize = size;
                    break;
            }
            return viewSize;
        }

        private void translateMatrixAfterRotate(int axis, float trans, float prevImageSize, float imageSize,
                                                int prevViewSize, int viewSize, int drawableSize) {
            if (imageSize < viewSize) {
                //
                // The width/height of image is less than the view's width/height. Center it.
                //
                m[axis] = (viewSize - (drawableSize * m[Matrix.MSCALE_X])) * 0.5f;

            } else if (trans > 0) {
                //
                // The image is larger than the view, but was not before rotation. Center it.
                //
                m[axis] = -((imageSize - viewSize) * 0.5f);

            } else {
                //
                // Find the area of the image which was previously centered in the view. Determine its distance
                // from the left/top side of the view as a fraction of the entire image's width/height. Use that percentage
                // to calculate the trans in the new view width/height.
                //
                float percentage = (Math.abs(trans) + (0.5f * prevViewSize)) / prevImageSize;
                m[axis] = -((percentage * imageSize) - (viewSize * 0.5f));
            }
        }

        private void setState(State state) {
            this.state = state;
        }

        public boolean canScrollHorizontallyFroyo(int direction) {
            return canScrollHorizontally(direction);
        }

        @Override
        public boolean canScrollHorizontally(int direction) {
            matrix.getValues(m);
            float x = m[Matrix.MTRANS_X];

            if (getImageWidth() < viewWidth) {
                return false;

            } else if (x >= -1 && direction < 0) {
                return false;

            } else if (Math.abs(x) + viewWidth + 1 >= getImageWidth() && direction > 0) {
                return false;
            }

            return true;
        }

        public void setParameters(Context context, OpenPdf openPdf, int pageNumber, SeekBar seekBar) {
            this.context = context;
            this.openPdf = openPdf;
            this.pageNumber = pageNumber;
            this.seekBar = seekBar;
        }

        private void scaleImage(double deltaScale, float focusX, float focusY, boolean stretchImageToSuper) {

            float lowerScale, upperScale;
            if (stretchImageToSuper) {
                lowerScale = superMinScale;
                upperScale = superMaxScale;

            } else {
                lowerScale = minScale;
                upperScale = maxScale;
            }

            float origScale = normalizedScale;
            normalizedScale *= deltaScale;
            if (normalizedScale > upperScale) {
                normalizedScale = upperScale;
                deltaScale = upperScale / origScale;
            } else if (normalizedScale < lowerScale) {
                normalizedScale = lowerScale;
                deltaScale = lowerScale / origScale;
            }

            matrix.postScale((float) deltaScale, (float) deltaScale, focusX, focusY);
            fixScaleTrans();
        }

        private PointF transformCoordTouchToBitmap(float x, float y, boolean clipToBitmap) {
            matrix.getValues(m);
            float origW = getDrawable().getIntrinsicWidth();
            float origH = getDrawable().getIntrinsicHeight();
            float transX = m[Matrix.MTRANS_X];
            float transY = m[Matrix.MTRANS_Y];
            float finalX = ((x - transX) * origW) / getImageWidth();
            float finalY = ((y - transY) * origH) / getImageHeight();

            if (clipToBitmap) {
                finalX = Math.min(Math.max(finalX, 0), origW);
                finalY = Math.min(Math.max(finalY, 0), origH);
            }

            return new PointF(finalX, finalY);
        }

        private PointF transformCoordBitmapToTouch(float bx, float by) {
            matrix.getValues(m);
            float origW = getDrawable().getIntrinsicWidth();
            float origH = getDrawable().getIntrinsicHeight();
            float px = bx / origW;
            float py = by / origH;
            float finalX = m[Matrix.MTRANS_X] + getImageWidth() * px;
            float finalY = m[Matrix.MTRANS_Y] + getImageHeight() * py;
            return new PointF(finalX, finalY);
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        private void compatPostOnAnimation(Runnable runnable) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                postOnAnimation(runnable);

            } else {
                postDelayed(runnable, 1000 / 60);
            }
        }

        private void printMatrixInfo() {
            float[] n = new float[9];
            matrix.getValues(n);
            Log.d(DEBUG, "Scale: " + n[Matrix.MSCALE_X] + " TransX: " + n[Matrix.MTRANS_X] + " TransY: "
                    + n[Matrix.MTRANS_Y]);
        }

        private enum State {
            NONE, DRAG, ZOOM, FLING, ANIMATE_ZOOM
        }

        public interface OnTouchImageViewListener {
            public void onMove();
        }

        private class GestureListener extends GestureDetector.SimpleOnGestureListener {

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                if (doubleTapListener != null) {
                    return doubleTapListener.onSingleTapConfirmed(e);
                }
                return performClick();
            }

            @Override
            public void onLongPress(MotionEvent e) {
                performLongClick();
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (fling != null) {
                    //
                    // If a previous fling is still active, it should be cancelled so that two flings
                    // are not run simultaenously.
                    //
                    fling.cancelFling();
                }
                fling = new Fling((int) velocityX, (int) velocityY);
                compatPostOnAnimation(fling);
                return super.onFling(e1, e2, velocityX, velocityY);
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                boolean consumed = false;
                if (doubleTapListener != null) {
                    consumed = doubleTapListener.onDoubleTap(e);
                }
                if (state == State.NONE) {
                    float targetZoom = (normalizedScale == minScale) ? maxScale : minScale;
                    DoubleTapZoom doubleTap = new DoubleTapZoom(targetZoom, e.getX(), e.getY(), false);
                    compatPostOnAnimation(doubleTap);
                    consumed = true;
                }
                return consumed;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                if (doubleTapListener != null) {
                    return doubleTapListener.onDoubleTapEvent(e);
                }
                return false;
            }
        }

        private class PrivateOnTouchListener implements OnTouchListener {

            //
            // Remember last point position for dragging
            //
            private PointF last = new PointF();

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mScaleDetector.onTouchEvent(event);
                mGestureDetector.onTouchEvent(event);
                float downX = 0;
                float upX;
                long startClickTime = 0;
                PointF curr = new PointF(event.getX(), event.getY());

                if (state == State.NONE || state == State.DRAG || state == State.FLING) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            startClickTime = Calendar.getInstance().getTimeInMillis();
                            downX = event.getX();
                            last.set(curr);
                            if (fling != null)
                                fling.cancelFling();
                            setState(State.DRAG);
                            break;

                        case MotionEvent.ACTION_MOVE:
                            if (state == State.DRAG) {
                                float deltaX = curr.x - last.x;
                                float deltaY = curr.y - last.y;
                                float fixTransX = getFixDragTrans(deltaX, viewWidth, getImageWidth());
                                float fixTransY = getFixDragTrans(deltaY, viewHeight, getImageHeight());
                                matrix.postTranslate(fixTransX, fixTransY);
                                fixTrans();
                                last.set(curr.x, curr.y);
                            }
                            break;

                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_POINTER_UP:
                            setState(State.NONE);
                            break;
                    }
                }

                setImageMatrix(matrix);

                //
                // User-defined OnTouchListener
                //
                if (userTouchListener != null) {
                    userTouchListener.onTouch(v, event);
                }

                //
                // OnTouchImageViewListener is set: TouchImageView dragged by user.
                //
                if (touchImageViewListener != null) {
                    touchImageViewListener.onMove();
                }

                //
                // indicate event was handled
                //
                return true;
            }
        }

        private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
            float downX;
            float upX;
            private long startClickTime;

            @Override
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                setState(State.ZOOM);
                return true;
            }

            public boolean onDown(MotionEvent e) {

                return true;
            }

            public void onSwipeRight() {

            }

            public void onSwipeLeft() {

            }

            public void onSwipeTop() {

            }

            public void onSwipeBottom() {

            }

            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                scaleImage(detector.getScaleFactor(), detector.getFocusX(), detector.getFocusY(), true);

                //
                // OnTouchImageViewListener is set: TouchImageView pinch zoomed by user.
                //
                if (touchImageViewListener != null) {
                    touchImageViewListener.onMove();
                }
                return true;
            }

            @Override
            public void onScaleEnd(ScaleGestureDetector detector) {
                super.onScaleEnd(detector);
                setState(State.NONE);
                boolean animateToZoomBoundary = false;
                float targetZoom = normalizedScale;
                if (normalizedScale > maxScale) {
                    targetZoom = maxScale;
                    animateToZoomBoundary = true;

                } else if (normalizedScale < minScale) {
                    targetZoom = minScale;
                    animateToZoomBoundary = true;
                }

                if (animateToZoomBoundary) {
                    DoubleTapZoom doubleTap = new DoubleTapZoom(targetZoom, viewWidth / 2, viewHeight / 2, true);
                    compatPostOnAnimation(doubleTap);
                }
            }
        }

        private class DoubleTapZoom implements Runnable {

            private static final float ZOOM_TIME = 500;
            private long startTime;
            private float startZoom, targetZoom;
            private float bitmapX, bitmapY;
            private boolean stretchImageToSuper;
            private AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
            private PointF startTouch;
            private PointF endTouch;

            DoubleTapZoom(float targetZoom, float focusX, float focusY, boolean stretchImageToSuper) {
                setState(State.ANIMATE_ZOOM);
                startTime = System.currentTimeMillis();
                this.startZoom = normalizedScale;
                this.targetZoom = targetZoom;
                this.stretchImageToSuper = stretchImageToSuper;
                PointF bitmapPoint = transformCoordTouchToBitmap(focusX, focusY, false);
                this.bitmapX = bitmapPoint.x;
                this.bitmapY = bitmapPoint.y;

                //
                // Used for translating image during scaling
                //
                startTouch = transformCoordBitmapToTouch(bitmapX, bitmapY);
                endTouch = new PointF(viewWidth / 2, viewHeight / 2);
            }

            @Override
            public void run() {
                float t = interpolate();
                double deltaScale = calculateDeltaScale(t);
                scaleImage(deltaScale, bitmapX, bitmapY, stretchImageToSuper);
                translateImageToCenterTouchPosition(t);
                fixScaleTrans();
                setImageMatrix(matrix);

                //
                // OnTouchImageViewListener is set: double tap runnable updates listener
                // with every frame.
                //
                if (touchImageViewListener != null) {
                    touchImageViewListener.onMove();
                }

                if (t < 1f) {
                    //
                    // We haven't finished zooming
                    //
                    compatPostOnAnimation(this);

                } else {
                    //
                    // Finished zooming
                    //
                    setState(State.NONE);
                }
            }

            private void translateImageToCenterTouchPosition(float t) {
                float targetX = startTouch.x + t * (endTouch.x - startTouch.x);
                float targetY = startTouch.y + t * (endTouch.y - startTouch.y);
                PointF curr = transformCoordBitmapToTouch(bitmapX, bitmapY);
                matrix.postTranslate(targetX - curr.x, targetY - curr.y);
            }

            private float interpolate() {
                long currTime = System.currentTimeMillis();
                float elapsed = (currTime - startTime) / ZOOM_TIME;
                elapsed = Math.min(1f, elapsed);
                return interpolator.getInterpolation(elapsed);
            }

            private double calculateDeltaScale(float t) {
                double zoom = startZoom + t * (targetZoom - startZoom);
                return zoom / normalizedScale;
            }
        }

        private class Fling implements Runnable {

            CompatScroller scroller;
            int currX, currY;

            Fling(int velocityX, int velocityY) {
                setState(State.FLING);
                scroller = new CompatScroller(context);
                matrix.getValues(m);

                int startX = (int) m[Matrix.MTRANS_X];
                int startY = (int) m[Matrix.MTRANS_Y];
                int minX, maxX, minY, maxY;

                if (getImageWidth() > viewWidth) {
                    minX = viewWidth - (int) getImageWidth();
                    maxX = 0;

                } else {
                    minX = maxX = startX;
                }

                if (getImageHeight() > viewHeight) {
                    minY = viewHeight - (int) getImageHeight();
                    maxY = 0;

                } else {
                    minY = maxY = startY;
                }

                scroller.fling(startX, startY, (int) velocityX, (int) velocityY, minX, maxX, minY, maxY);
                currX = startX;
                currY = startY;
            }

            public void cancelFling() {
                if (scroller != null) {
                    setState(State.NONE);
                    scroller.forceFinished(true);
                }
            }

            @Override
            public void run() {

                //
                // OnTouchImageViewListener is set: TouchImageView listener has been flung by user.
                // Listener runnable updated with each frame of fling animation.
                //
                if (touchImageViewListener != null) {
                    touchImageViewListener.onMove();
                }

                if (scroller.isFinished()) {
                    scroller = null;
                    return;
                }

                if (scroller.computeScrollOffset()) {
                    int newX = scroller.getCurrX();
                    int newY = scroller.getCurrY();
                    int transX = newX - currX;
                    int transY = newY - currY;
                    currX = newX;
                    currY = newY;
                    matrix.postTranslate(transX, transY);
                    fixTrans();
                    setImageMatrix(matrix);
                    compatPostOnAnimation(this);
                }
            }
        }

        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        private class CompatScroller {
            Scroller scroller;
            OverScroller overScroller;
            boolean isPreGingerbread;

            public CompatScroller(Context context) {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
                    isPreGingerbread = true;
                    scroller = new Scroller(context);

                } else {
                    isPreGingerbread = false;
                    overScroller = new OverScroller(context);
                }
            }

            public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY,
                              int maxY) {
                if (isPreGingerbread) {
                    scroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
                } else {
                    overScroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
                }
            }

            public void forceFinished(boolean finished) {
                if (isPreGingerbread) {
                    scroller.forceFinished(finished);
                } else {
                    overScroller.forceFinished(finished);
                }
            }

            public boolean isFinished() {
                if (isPreGingerbread) {
                    return scroller.isFinished();
                } else {
                    return overScroller.isFinished();
                }
            }

            public boolean computeScrollOffset() {
                if (isPreGingerbread) {
                    return scroller.computeScrollOffset();
                } else {
                    overScroller.computeScrollOffset();
                    return overScroller.computeScrollOffset();
                }
            }

            public int getCurrX() {
                if (isPreGingerbread) {
                    return scroller.getCurrX();
                } else {
                    return overScroller.getCurrX();
                }
            }

            public int getCurrY() {
                if (isPreGingerbread) {
                    return scroller.getCurrY();
                } else {
                    return overScroller.getCurrY();
                }
            }
        }

        private class ZoomVariables {
            public float scale;
            public float focusX;
            public float focusY;
            public ScaleType scaleType;

            public ZoomVariables(float scale, float focusX, float focusY, ScaleType scaleType) {
                this.scale = scale;
                this.focusX = focusX;
                this.focusY = focusY;
                this.scaleType = scaleType;
            }
        }
    }

    class OpenPdf {

        Context context;
        ImageView imageView;
        String pdfPath;
        int pageNumber;
        ParcelFileDescriptor parcelFileDescriptor;
        PdfRenderer pdfRenderer;
        PdfRenderer.Page pdfRendererPage;
        private int indexPages;

        public OpenPdf(Context context, ImageView imageView, String pdfPath, int pageNumber) {
            this.context = context;
            this.imageView = imageView;
            this.pdfPath = pdfPath;
            this.pageNumber = pageNumber;

            try {
                openPdfRenderer();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(context, "Unable to open - " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            showPage(pageNumber);
        }

        public void openPdfRenderer() throws IOException {
            File file = new File(pdfPath);
            if (!file.exists()) {
                InputStream asset = context.getAssets().open(pdfPath);
                FileOutputStream output = new FileOutputStream(file);
                final byte[] buffer = new byte[1024];
                int size;
                while ((size = asset.read(buffer)) != -1) {
                    output.write(buffer, 0, size);
                }
                asset.close();
                output.close();
            }
            parcelFileDescriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);
            if (parcelFileDescriptor != null) {
                pdfRenderer = new PdfRenderer(parcelFileDescriptor);
            }
        }

        public void closePdfRenderer() throws IOException {
            if (pdfRendererPage != null) {
                pdfRendererPage.close();
            }
            if (pdfRenderer != null) {
                pdfRenderer.close();
            }
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
        }

        public void showPrevious() {
            if (pdfRenderer == null || pdfRendererPage == null) {
                return;
            }
            final int index = pdfRendererPage.getIndex();
            if (index > 0) {
                showPage(index - 1);
                indexPages = index - 1;
            }
        }

        public void showNext() {
            if (pdfRenderer == null || pdfRendererPage == null) {
                return;
            }
            final int index = pdfRendererPage.getIndex();
            if (index + 1 < pdfRenderer.getPageCount()) {
                showPage(index + 1);
                indexPages = index + 1;
            }
        }

        public int getindexPages() {
            return this.indexPages;
        }

        public void showPage(int index) {
            if (pdfRendererPage != null) {
                pdfRendererPage.close();
            }
            pdfRendererPage = pdfRenderer.openPage(index);
            Bitmap bitmap = Bitmap.createBitmap(
                    context.getResources().getDisplayMetrics().densityDpi * pdfRendererPage.getWidth() / 144,
                    context.getResources().getDisplayMetrics().densityDpi * pdfRendererPage.getHeight() / 144,
                    Bitmap.Config.ARGB_8888);
            pdfRendererPage.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
            imageView.setImageBitmap(bitmap);
        }
    }

    class CustomImageView extends AppCompatImageView {

        static final int NONE = 0;
        static final int DRAG = 1;
        static final int ZOOM = 2;
        static final int CLICK = 3;
        protected float origWidth, origHeight;
        Matrix matrix;
        int mode = NONE;
        PointF last = new PointF();
        PointF start = new PointF();
        float minScale = 1f;
        float maxScale = 3f;
        float[] m;
        int viewWidth, viewHeight;
        float saveScale = 1f;
        int oldMeasuredWidth, oldMeasuredHeight;

        ScaleGestureDetector mScaleDetector;

        Context context;
        Window window;
        LinearLayout linear;
        OpenPdf openPdf;
        int pageNumber;
        SeekBar seekBar;

        public CustomImageView(Context ctx) {
            super(ctx);
            sharedConstructing(ctx);
        }

        public CustomImageView(Context context, AttributeSet attrs) {
            super(context, attrs);
            sharedConstructing(context);
        }

        private void sharedConstructing(Context context) {
            super.setClickable(true);
            this.context = context;
            mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
            matrix = new Matrix();
            m = new float[9];
            setImageMatrix(matrix);
            setScaleType(ScaleType.MATRIX);
            setOnTouchListener(new OnTouchListener() {
                private static final int MAX_CLICK_DURATION = 60;
                float downX;
                float upX;
                private long startClickTime;

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    mScaleDetector.onTouchEvent(event);
                    PointF curr = new PointF(event.getX(), event.getY());

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            startClickTime = Calendar.getInstance().getTimeInMillis();

                            downX = event.getX();

                            last.set(curr);
                            start.set(last);
                            mode = DRAG;
                            break;

                        case MotionEvent.ACTION_MOVE:
                            if (mode == DRAG) {
                                float deltaX = curr.x - last.x;
                                float deltaY = curr.y - last.y;
                                float fixTransX = getFixDragTrans(deltaX, viewWidth, origWidth * saveScale);
                                float fixTransY = getFixDragTrans(deltaY, viewHeight, origHeight * saveScale);
                                matrix.postTranslate(fixTransX, fixTransY);
                                fixTrans();
                                last.set(curr.x, curr.y);
                            }
                            break;

                        case MotionEvent.ACTION_UP:
                            long clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                            if (clickDuration < MAX_CLICK_DURATION) {
                                if (linear.getVisibility() == View.VISIBLE) {
                                    linear.setVisibility(View.GONE);
                                } else if (linear.getVisibility() == View.GONE) {
                                    linear.setVisibility(View.VISIBLE);
                                }

                            }

                            upX = event.getX();
                            float deltaX = downX - upX;
                            if (Math.abs(deltaX) > 0) {
                                if (deltaX >= 250 && clickDuration < 300) {
                                    openPdf.showNext();
                                } else if (deltaX <= -250 && clickDuration < 300) {
                                    openPdf.showPrevious();
                                }
                                pageNumber = openPdf.pdfRendererPage.getIndex();
                                seekBar.setProgress(pageNumber);
                            }

                            mode = NONE;
                            int xDiff = (int) Math.abs(curr.x - start.x);
                            int yDiff = (int) Math.abs(curr.y - start.y);
                            if (xDiff < CLICK && yDiff < CLICK) {
                                performClick();
                            }
                            break;

                        case MotionEvent.ACTION_POINTER_UP:
                            mode = NONE;
                            break;
                    }

                    setImageMatrix(matrix);
                    invalidate();
                    return true;
                }

            });
        }

        public void setParameters(Context context, Window window, LinearLayout lin, OpenPdf openPdf, int pageNumber,
                                  SeekBar seekBar) {
            this.context = context;

            this.window = window;
            this.linear = lin;
            this.openPdf = openPdf;
            this.pageNumber = pageNumber;
            this.seekBar = seekBar;
        }

        public void setMaxZoom(float x) {
            maxScale = x;
        }

        void fixTrans() {
            matrix.getValues(m);
            float transX = m[Matrix.MTRANS_X];
            float transY = m[Matrix.MTRANS_Y];

            float fixTransX = getFixTrans(transX, viewWidth, origWidth * saveScale);
            float fixTransY = getFixTrans(transY, viewHeight, origHeight * saveScale);

            if (fixTransX != 0 || fixTransY != 0) {
                matrix.postTranslate(fixTransX, fixTransY);
            }
        }

        float getFixTrans(float trans, float viewSize, float contentSize) {
            float minTrans, maxTrans;

            if (contentSize <= viewSize) {
                minTrans = 0;
                maxTrans = viewSize - contentSize;
            } else {
                minTrans = viewSize - contentSize;
                maxTrans = 0;
            }

            if (trans < minTrans) {
                return -trans + minTrans;
            }
            if (trans > maxTrans) {
                return -trans + maxTrans;
            }

            return 0;
        }

        float getFixDragTrans(float delta, float viewSize, float contentSize) {
            if (contentSize <= viewSize) {
                return 0;
            }
            return delta;
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            viewWidth = MeasureSpec.getSize(widthMeasureSpec);
            viewHeight = MeasureSpec.getSize(heightMeasureSpec);

            if (oldMeasuredHeight == viewWidth && oldMeasuredHeight == viewHeight || viewWidth == 0
                    || viewHeight == 0) {
                return;
            }

            oldMeasuredHeight = viewHeight;
            oldMeasuredWidth = viewWidth;

            if (saveScale == 1) {
                float scale;

                Drawable drawable = getDrawable();
                if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
                    return;
                }
                int bmWidth = drawable.getIntrinsicWidth();
                int bmHeight = drawable.getIntrinsicHeight();

                float scaleX = (float) viewWidth / (float) bmWidth;
                float scaleY = (float) viewHeight / (float) bmHeight;
                scale = Math.min(scaleX, scaleY);
                matrix.setScale(scale, scale);

                float redundantYSpace = (float) viewHeight - (scale * (float) bmHeight);
                float redundantXSpace = (float) viewWidth - (scale * (float) bmWidth);
                redundantYSpace /= (float) 2;
                redundantXSpace /= (float) 2;

                matrix.postTranslate(redundantXSpace, redundantYSpace);

                origWidth = viewWidth - 2 * redundantXSpace;
                origHeight = viewHeight - 2 * redundantYSpace;
                setImageMatrix(matrix);
            }
            fixTrans();
        }

        private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
            @Override
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                mode = ZOOM;
                return true;
            }

            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                float mScaleFactor = detector.getScaleFactor();
                float origScale = saveScale;
                saveScale *= mScaleFactor;
                if (saveScale > maxScale) {
                    saveScale = maxScale;
                    mScaleFactor = maxScale / origScale;
                } else if (saveScale < minScale) {
                    saveScale = minScale;
                    mScaleFactor = minScale / origScale;
                }

                if (origWidth * saveScale <= viewWidth || origHeight * saveScale <= viewHeight) {
                    matrix.postScale(mScaleFactor, mScaleFactor, viewWidth / 2, viewHeight / 2);
                } else {
                    matrix.postScale(mScaleFactor, mScaleFactor, detector.getFocusX(), detector.getFocusY());
                }

                fixTrans();
                return true;
            }
        }

    }

}
