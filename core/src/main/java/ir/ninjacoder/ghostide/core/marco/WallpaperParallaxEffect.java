package ir.ninjacoder.ghostide.core.marco;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Surface;
import android.view.WindowManager;

/*
  this code telgram me convert and fix in ghost web ide
  dont using other apps tnks
  ninja coder
  2023
*/

public class WallpaperParallaxEffect implements SensorEventListener {

    public static float density = 1;
    private float[] rollBuffer = new float[3], pitchBuffer = new float[3];
    private int bufferOffset;
    private WindowManager wm;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private boolean enabled;
    private Callback callback;
    private Context context;

    public WallpaperParallaxEffect(Context context) {
        wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        this.context = context;
        density = context.getResources().getDisplayMetrics().density;
    }

    public static int dp(float value) {
        if (value == 0) {
            return 0;
        }
        return (int) Math.ceil(density * value);
    }

    public static float dpf2(float value) {
        if (value == 0) {
            return 0;
        }
        return density * value;
    }

    public void setEnabled(boolean enabled) {
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (accelerometer == null)
                return;
            if (enabled) {
                sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
            } else {
                sensorManager.unregisterListener(this);
            }
        }
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public float getScale(int boundsWidth, int boundsHeight) {
        int offset = dp(16);
        return Math.max(((float) boundsWidth + offset * 2) / (float) boundsWidth,
                ((float) boundsHeight + offset * 2) / (float) boundsHeight);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int rotation = wm.getDefaultDisplay().getRotation();

        float x = event.values[0] / SensorManager.GRAVITY_EARTH;
        float y = event.values[1] / SensorManager.GRAVITY_EARTH;
        float z = event.values[2] / SensorManager.GRAVITY_EARTH;

        float pitch = (float) (Math.atan2(x, Math.sqrt(y * y + z * z)) / Math.PI * 2.0);
        float roll = (float) (Math.atan2(y, Math.sqrt(x * x + z * z)) / Math.PI * 2.0);

        switch (rotation) {
            case Surface.ROTATION_0:
                break;
            case Surface.ROTATION_90: {
                float tmp = pitch;
                pitch = roll;
                roll = tmp;
                break;
            }
            case Surface.ROTATION_180:
                roll = -roll;
                pitch = -pitch;
                break;
            case Surface.ROTATION_270: {
                float tmp = -pitch;
                pitch = roll;
                roll = tmp;
                break;
            }
        }
        rollBuffer[bufferOffset] = roll;
        pitchBuffer[bufferOffset] = pitch;
        bufferOffset = (bufferOffset + 1) % rollBuffer.length;
        roll = pitch = 0;
        for (int i = 0; i < rollBuffer.length; i++) {
            roll += rollBuffer[i];
            pitch += pitchBuffer[i];
        }
        roll /= rollBuffer.length;
        pitch /= rollBuffer.length;
        if (roll > 1f) {
            roll = 2f - roll;
        } else if (roll < -1f) {
            roll = -2f - roll;
        }
        int offsetX = Math.round(pitch * dpf2(16));
        int offsetY = Math.round(roll * dpf2(16));
        float vx = Math.max(-1.0f, Math.min(1.0f, -pitch / 0.45f));
        float vy = Math.max(-1.0f, Math.min(1.0f, -roll / 0.45f));
        float len = (float) Math.sqrt(vx * vx + vy * vy);
        vx /= len;
        vy /= len;
        float y2 = -1;
        float x2 = 0;
        float angle = (float) (Math.atan2(vx * y2 - vy * x2, vx * x2 + vy * y2) / (Math.PI / 180.0f));
        if (angle < 0) {
            angle += 360;
        }
        if (callback != null) {
            callback.onOffsetsChanged(offsetX, offsetY, angle);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public interface Callback {
        void onOffsetsChanged(int offsetX, int offsetY, float angle);
    }
}
