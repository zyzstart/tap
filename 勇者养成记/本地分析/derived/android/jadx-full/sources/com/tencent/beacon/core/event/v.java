package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class v implements android.hardware.SensorEventListener, java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.util.Map f178a;
    private com.tencent.beacon.core.event.u c;
    protected android.content.Context f;
    private android.hardware.SensorManager g;
    private long b = 0;
    private int d = 0;
    private long e = 0;

    static {
        java.util.HashMap map = new java.util.HashMap();
        f178a = map;
        map.put(1, "A126");
        f178a.put(4, "A127");
        f178a.put(2, "A128");
    }

    private void a() {
        android.hardware.SensorManager sensorManager = this.g;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public void a(android.content.Context context) {
        android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) context.getSystemService("sensor");
        this.g = sensorManager;
        if (sensorManager == null) {
            return;
        }
        com.tencent.beacon.core.event.EventStrategyBean eventStrategyBean = com.tencent.beacon.core.event.EventStrategyBean.getInstance();
        int hertzCount = 1000000 / eventStrategyBean.getHertzCount();
        if (eventStrategyBean.isAcceleEnable()) {
            com.tencent.beacon.core.e.d.d("[sensor] AcceleEnable", new java.lang.Object[0]);
            android.hardware.SensorManager sensorManager2 = this.g;
            sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(1), hertzCount);
        }
        if (eventStrategyBean.isGyroEnable()) {
            com.tencent.beacon.core.e.d.d("[sensor] GyroEnable", new java.lang.Object[0]);
            android.hardware.SensorManager sensorManager3 = this.g;
            sensorManager3.registerListener(this, sensorManager3.getDefaultSensor(4), hertzCount);
        }
        if (eventStrategyBean.isMagneticEnable()) {
            com.tencent.beacon.core.e.d.d("[sensor] MagneticEnable", new java.lang.Object[0]);
            android.hardware.SensorManager sensorManager4 = this.g;
            sensorManager4.registerListener(this, sensorManager4.getDefaultSensor(2), hertzCount);
        }
    }

    public void b(android.content.Context context) {
        if (com.tencent.beacon.core.event.EventStrategyBean.getInstance().isSensorEnable()) {
            this.f = context;
            int consuming = com.tencent.beacon.core.event.EventStrategyBean.getInstance().getConsuming();
            com.tencent.beacon.core.e.d.d("[sensor] startEvent consuming : %d", java.lang.Integer.valueOf(consuming));
            this.e = com.tencent.beacon.core.event.EventStrategyBean.getInstance().getGatherDur();
            com.tencent.beacon.core.a.d.a().a(111, this, 10000L, consuming * 1000);
        }
    }

    public void c(android.content.Context context) {
        com.tencent.beacon.core.a.d.a().a(111, true);
        com.tencent.beacon.core.e.d.d("[sensor] cancel next record", new java.lang.Object[0]);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        com.tencent.beacon.core.event.u uVar;
        if (this.d <= 0) {
            this.c = null;
            com.tencent.beacon.core.e.d.d("[sensor] unregisterSensorListener", new java.lang.Object[0]);
            a();
            return;
        }
        if (java.lang.System.currentTimeMillis() - this.b >= this.e && (uVar = this.c) != null) {
            uVar.a();
            this.b = java.lang.System.currentTimeMillis();
            this.c = null;
            int i = this.d - 1;
            this.d = i;
            com.tencent.beacon.core.e.d.d("[sensor] report sensor event and %d times left ", java.lang.Integer.valueOf(i));
        }
        if (this.c == null) {
            this.c = new com.tencent.beacon.core.event.u();
        }
        this.c.a((java.lang.String) f178a.get(java.lang.Integer.valueOf(sensorEvent.sensor.getType())), sensorEvent.values);
    }

    @Override // java.lang.Runnable
    public void run() {
        a(this.f);
        this.b = java.lang.System.currentTimeMillis();
        this.d = com.tencent.beacon.core.event.EventStrategyBean.getInstance().getGatherCount();
        com.tencent.beacon.core.e.d.d("[sensor] start a record", new java.lang.Object[0]);
    }
}
