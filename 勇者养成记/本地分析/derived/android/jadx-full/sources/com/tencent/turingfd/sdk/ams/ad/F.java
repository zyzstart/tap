package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class F extends java.lang.Thread {
    public final /* synthetic */ java.util.concurrent.atomic.AtomicReference nb;
    public final /* synthetic */ java.util.concurrent.atomic.AtomicReference ob;
    public final /* synthetic */ java.util.concurrent.atomic.AtomicReference pb;
    public final /* synthetic */ java.lang.Object qb;
    public final /* synthetic */ android.content.Context za;

    public F(java.util.concurrent.atomic.AtomicReference atomicReference, java.util.concurrent.atomic.AtomicReference atomicReference2, android.content.Context context, java.util.concurrent.atomic.AtomicReference atomicReference3, java.lang.Object obj) {
        this.nb = atomicReference;
        this.ob = atomicReference2;
        this.za = context;
        this.pb = atomicReference3;
        this.qb = obj;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.tencent.turingfd.sdk.ams.ad.D dA;
        try {
            dA = com.tencent.turingfd.sdk.ams.ad.D.a.a((android.os.IBinder) this.nb.get());
        } catch (java.lang.Throwable unused) {
            this.ob.set(java.lang.Integer.valueOf(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_AUTHENTICATION));
            dA = null;
        }
        if (dA != null) {
            try {
                com.tencent.turingfd.sdk.ams.ad.D.a.C0039a c0039a = (com.tencent.turingfd.sdk.ams.ad.D.a.C0039a) dA;
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.tencent.turingfd.sdk.ams.ad.D.a.i);
                    c0039a.na.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    java.lang.String string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    com.tencent.turingfd.sdk.ams.ad.G._a = string;
                } catch (java.lang.Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            } catch (java.lang.Throwable unused2) {
                this.ob.set(java.lang.Integer.valueOf(com.tencent.safecloud.device.openlib.DeviceConfig.ERR_ILLEGAL_ARG));
            }
        }
        try {
            this.za.unbindService((android.content.ServiceConnection) this.pb.get());
        } catch (java.lang.Throwable unused3) {
            this.ob.set(-103);
        }
        synchronized (this.qb) {
            try {
                this.qb.notifyAll();
            } catch (java.lang.Throwable unused4) {
            }
        }
    }
}
