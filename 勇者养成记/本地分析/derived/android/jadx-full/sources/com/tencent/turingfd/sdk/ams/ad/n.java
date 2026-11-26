package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class n extends android.os.Binder implements com.tencent.turingfd.sdk.ams.ad.InterfaceC0094j {
    public static com.tencent.turingfd.sdk.ams.ad.InterfaceC0094j a(android.os.IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        com.tencent.turingfd.sdk.ams.ad.InterfaceC0094j interfaceC0094j = (com.tencent.turingfd.sdk.ams.ad.InterfaceC0094j) iBinder.queryLocalInterface("android.os.IServiceManager");
        return interfaceC0094j != null ? interfaceC0094j : new com.tencent.turingfd.sdk.ams.ad.o(iBinder);
    }
}
