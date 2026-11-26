package com.tencent.ysdk.shell.framework.web;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SensorManagerHelper implements android.hardware.SensorEventListener {
    private static final int SPEED_SHRESHOLD = 5000;
    private static final int UPTATE_INTERVAL_TIME = 50;
    private android.content.Context context;
    private long lastUpdateTime;
    private float lastX;
    private float lastY;
    private float lastZ;
    private com.tencent.ysdk.shell.framework.web.SensorManagerHelper.OnShakeListener onShakeListener;
    private android.hardware.Sensor sensor;
    private android.hardware.SensorManager sensorManager;
    private android.os.Vibrator vibrator;

    public interface OnShakeListener {
        void onShake();
    }

    public SensorManagerHelper(android.content.Context context) {
        this.context = context;
        this.vibrator = (android.os.Vibrator) context.getSystemService("vibrator");
        start();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @android.annotation.SuppressLint({"MissingPermission"})
    public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.lastUpdateTime;
        if (j < 50) {
            return;
        }
        this.lastUpdateTime = jCurrentTimeMillis;
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        float f4 = f - this.lastX;
        float f5 = f2 - this.lastY;
        float f6 = f3 - this.lastZ;
        this.lastX = f;
        this.lastY = f2;
        this.lastZ = f3;
        double dSqrt = java.lang.Math.sqrt((f4 * f4) + (f5 * f5) + (f6 * f6));
        double d = j;
        java.lang.Double.isNaN(d);
        if ((dSqrt / d) * 10000.0d >= 5000.0d) {
            this.onShakeListener.onShake();
            try {
                this.vibrator.vibrate(500L);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public void setOnShakeListener(com.tencent.ysdk.shell.framework.web.SensorManagerHelper.OnShakeListener onShakeListener) {
        this.onShakeListener = onShakeListener;
    }

    public void start() {
        this.sensorManager = (android.hardware.SensorManager) this.context.getSystemService("sensor");
        android.hardware.SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            this.sensor = sensorManager.getDefaultSensor(1);
        }
        android.hardware.Sensor sensor = this.sensor;
        if (sensor != null) {
            this.sensorManager.registerListener(this, sensor, 1);
        }
    }

    public void stop() {
        this.sensorManager.unregisterListener(this);
    }
}
