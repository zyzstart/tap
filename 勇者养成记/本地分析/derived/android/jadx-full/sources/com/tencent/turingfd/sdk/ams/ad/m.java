package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class m {
    public static com.tencent.turingfd.sdk.ams.ad.InterfaceC0094j la;
    public static final java.lang.String Q = com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.Q);
    public static final java.lang.String ma = com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.R);

    public static android.os.IBinder c(java.lang.String str) {
        try {
            com.tencent.turingfd.sdk.ams.ad.InterfaceC0094j interfaceC0094j = la;
            if (interfaceC0094j == null) {
                java.lang.Object objA = com.tencent.turingfd.sdk.ams.ad.C0095k.a(Q, ma, null, null, null);
                if (objA instanceof android.os.IBinder) {
                    la = com.tencent.turingfd.sdk.ams.ad.n.a((android.os.IBinder) objA);
                    interfaceC0094j = la;
                } else {
                    interfaceC0094j = null;
                }
            }
            return ((com.tencent.turingfd.sdk.ams.ad.o) interfaceC0094j).c(str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
