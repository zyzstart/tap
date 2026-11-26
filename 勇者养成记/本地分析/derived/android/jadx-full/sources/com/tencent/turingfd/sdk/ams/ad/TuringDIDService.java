package com.tencent.turingfd.sdk.ams.ad;

import com.tencent.turingfd.sdk.ams.ad.u.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TuringDIDService {

    public static class aa {

        public static class bb implements android.content.ServiceConnection {
            @Override // android.content.ServiceConnection
            public native void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(android.content.ComponentName componentName) {
            }
        }

        public static native android.util.SparseArray<java.lang.Object> a(android.util.SparseArray<java.lang.Object> sparseArray, android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map, int i);

        public static native android.util.SparseArray<java.lang.Object> b(android.util.SparseArray<java.lang.Object> sparseArray, byte[] bArr);

        public static native android.util.SparseArray<java.lang.Object> c(android.util.SparseArray<java.lang.Object> sparseArray, android.content.Context context);

        public static native android.util.SparseArray<java.lang.Object> d(android.util.SparseArray<java.lang.Object> sparseArray);
    }

    public static com.tencent.turingfd.sdk.ams.ad.ITuringDID getTuringDID(android.content.Context context) {
        com.tencent.turingfd.sdk.ams.ad.r rVarE;
        if (!com.tencent.turingfd.sdk.ams.ad.C0088d.q) {
            rVarE = com.tencent.turingfd.sdk.ams.ad.r.a(-10001);
        } else if (com.tencent.turingfd.sdk.ams.ad.C0088d.r) {
            com.tencent.turingfd.sdk.ams.ad.u uVar = com.tencent.turingfd.sdk.ams.ad.u.getInstance();
            int requestType = uVar.Fa.getRequestType();
            if (requestType != 1) {
                rVarE = requestType != 2 ? uVar.e(context) : uVar.a(context, 0, true);
            } else {
                com.tencent.turingfd.sdk.ams.ad.r rVarE2 = uVar.e(context);
                uVar.Ia.a(context, rVarE2.sa);
                rVarE = rVarE2;
            }
        } else {
            rVarE = com.tencent.turingfd.sdk.ams.ad.r.a(-10002);
        }
        return new com.tencent.turingfd.sdk.ams.ad.C0090f(rVarE);
    }

    public static java.lang.String getVersionInfo() {
        return com.tencent.turingfd.sdk.ams.ad.C0088d.getVersionInfo();
    }

    public static void init(com.tencent.turingfd.sdk.ams.ad.TuringDIDConfig turingDIDConfig) {
        boolean z;
        if (!com.tencent.turingfd.sdk.ams.ad.C0088d.q) {
            if (turingDIDConfig.f()) {
                try {
                    java.lang.System.loadLibrary("turingad");
                    z = true;
                } catch (java.lang.Throwable unused) {
                    z = false;
                }
                com.tencent.turingfd.sdk.ams.ad.C0088d.q = z;
                if (!com.tencent.turingfd.sdk.ams.ad.C0088d.q) {
                    return;
                }
            } else {
                com.tencent.turingfd.sdk.ams.ad.C0088d.q = true;
            }
        }
        com.tencent.turingfd.sdk.ams.ad.u uVar = com.tencent.turingfd.sdk.ams.ad.u.getInstance();
        uVar.Fa = turingDIDConfig;
        if (!uVar.Ha) {
            uVar.Ha = true;
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("TuringFdCore");
            handlerThread.start();
            uVar.Ga = uVar.new a(handlerThread.getLooper(), turingDIDConfig.getContext());
            uVar.Ia = new com.tencent.turingfd.sdk.ams.ad.w(uVar.Ga);
            android.content.Context context = turingDIDConfig.getContext();
            if (com.tencent.turingfd.sdk.ams.ad.C.Za.containsKey(com.tencent.turingfd.sdk.ams.ad.C.ab)) {
                new com.tencent.turingfd.sdk.ams.ad.B(com.tencent.turingfd.sdk.ams.ad.C.Za.get(com.tencent.turingfd.sdk.ams.ad.C.ab), context).start();
            }
            if (turingDIDConfig.getRequestType() == 1) {
                new com.tencent.turingfd.sdk.ams.ad.s(uVar).start();
            }
        }
        com.tencent.turingfd.sdk.ams.ad.C0088d.r = true;
    }
}
