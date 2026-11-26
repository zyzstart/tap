package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class G implements com.tencent.turingfd.sdk.ams.ad.A {
    public static java.lang.String _a = "";
    public static long fb = -1;
    public static long gb = -1;
    public static int hb = -1;

    public static int a(android.content.Context context, java.util.concurrent.atomic.AtomicReference<android.os.IBinder> atomicReference, java.util.concurrent.atomic.AtomicReference<android.content.ServiceConnection> atomicReference2) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.Object obj = new java.lang.Object();
        android.content.Intent intent = new android.content.Intent(com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.t));
        intent.setPackage(com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.u));
        if (!context.bindService(intent, new com.tencent.turingfd.sdk.ams.ad.E(jCurrentTimeMillis, atomicReference, atomicReference2, obj), 1)) {
            return -100;
        }
        if (atomicReference.get() == null) {
            synchronized (obj) {
                try {
                    obj.wait(1000L);
                } catch (java.lang.Throwable unused) {
                }
            }
        }
        if (atomicReference.get() == null) {
            return com.tencent.safecloud.device.openlib.DeviceConfig.ERR_INIT;
        }
        return 0;
    }

    public static int b(android.content.Context context, java.util.concurrent.atomic.AtomicReference<android.os.IBinder> atomicReference, java.util.concurrent.atomic.AtomicReference<android.content.ServiceConnection> atomicReference2) {
        java.lang.Object obj = new java.lang.Object();
        java.util.concurrent.atomic.AtomicReference atomicReference3 = new java.util.concurrent.atomic.AtomicReference(0);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        new com.tencent.turingfd.sdk.ams.ad.F(atomicReference, atomicReference3, context, atomicReference2, obj).start();
        synchronized (obj) {
            try {
                obj.wait(1000L);
            } catch (java.lang.Throwable unused) {
            }
        }
        gb = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
        return ((java.lang.Integer) atomicReference3.get()).intValue();
    }

    public static java.lang.String l(android.content.Context context) {
        try {
            hb = 0;
            java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
            java.util.concurrent.atomic.AtomicReference atomicReference2 = new java.util.concurrent.atomic.AtomicReference();
            hb = a(context, atomicReference, atomicReference2);
            if (hb == 0) {
                hb = b(context, atomicReference, atomicReference2);
            }
            return _a;
        } catch (java.lang.Throwable unused) {
            hb = com.tencent.safecloud.device.openlib.DeviceConfig.ERR_NOT_INIT;
            return _a;
        }
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.A
    public java.lang.String a(android.content.Context context) {
        return hb + "_" + fb + "_" + gb;
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.A
    public void b(android.content.Context context) {
        l(context);
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.A
    public java.lang.String c(android.content.Context context) {
        return android.text.TextUtils.isEmpty(_a) ? l(context) : _a;
    }
}
