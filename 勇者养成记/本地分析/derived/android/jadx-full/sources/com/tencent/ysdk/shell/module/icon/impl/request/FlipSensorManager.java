package com.tencent.ysdk.shell.module.icon.impl.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class FlipSensorManager {
    private static final java.lang.String TAG = "FlipSensorManager";
    private static volatile com.tencent.ysdk.shell.module.icon.impl.request.FlipSensorManager instance;
    private com.tencent.ysdk.shell.module.icon.impl.request.FlipListener mOuterFlipListener;
    private float mZValue;
    private boolean mIsSensorReged = false;
    private long mLastTime = 0;
    private android.hardware.SensorManager mSensorManager = (android.hardware.SensorManager) com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().getSystemService("sensor");
    private com.tencent.ysdk.shell.module.icon.impl.request.FlipSensorManager.FlipSensorListener mFlipSensorListener = new com.tencent.ysdk.shell.module.icon.impl.request.FlipSensorManager.FlipSensorListener();

    class FlipSensorListener implements android.hardware.SensorEventListener {
        private float lastZLocation = 0.0f;
        private long lastSensorTime = 0;

        FlipSensorListener() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float f = sensorEvent.values[2];
                if (this.lastZLocation == 0.0f) {
                    this.lastZLocation = f;
                    this.lastSensorTime = java.lang.System.currentTimeMillis();
                    return;
                }
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                if (java.lang.Math.abs(this.lastZLocation - f) <= 10.0f || jCurrentTimeMillis - this.lastSensorTime > com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.HIDE_BUBBLE_TASK_DELAY) {
                    this.lastZLocation = f;
                    this.lastSensorTime = jCurrentTimeMillis;
                } else {
                    com.tencent.ysdk.shell.module.icon.impl.request.FlipSensorManager.this.judgeIsFlip(f);
                    this.lastZLocation = 0.0f;
                    this.lastSensorTime = 0L;
                }
            }
        }
    }

    private FlipSensorManager() {
    }

    public static com.tencent.ysdk.shell.module.icon.impl.request.FlipSensorManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.icon.impl.request.FlipSensorManager.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.icon.impl.request.FlipSensorManager();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judgeIsFlip(float f) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if ((this.mZValue < 0.0f || f >= 0.0f) && (this.mZValue > 0.0f || f <= 0.0f)) {
            return;
        }
        com.tencent.ysdk.libware.file.Logger.d(TAG, "Phone Flipped");
        if (jCurrentTimeMillis - this.mLastTime < 1500 && this.mOuterFlipListener != null) {
            com.tencent.ysdk.libware.file.Logger.d(TAG, "Phone Flipped active listener");
            this.mOuterFlipListener.onFlip();
        }
        this.mLastTime = jCurrentTimeMillis;
        this.mZValue = f;
    }

    private void regSensor() {
        if (this.mIsSensorReged) {
            return;
        }
        android.hardware.SensorManager sensorManager = this.mSensorManager;
        sensorManager.registerListener(this.mFlipSensorListener, sensorManager.getDefaultSensor(1), 3);
        this.mIsSensorReged = true;
    }

    private void removeSensor() {
        if (this.mIsSensorReged) {
            this.mSensorManager.unregisterListener(this.mFlipSensorListener);
            this.mIsSensorReged = false;
        }
    }

    public void onPause() {
        if (this.mOuterFlipListener != null) {
            removeSensor();
            this.mOuterFlipListener = null;
        }
    }

    public void onResume() {
        if (this.mOuterFlipListener != null) {
            regSensor();
        }
    }

    public void regFlipListener(com.tencent.ysdk.shell.module.icon.impl.request.FlipListener flipListener) {
        this.mOuterFlipListener = flipListener;
        if (this.mOuterFlipListener != null) {
            regSensor();
        }
    }

    public void removeFlipListener() {
        removeSensor();
    }
}
