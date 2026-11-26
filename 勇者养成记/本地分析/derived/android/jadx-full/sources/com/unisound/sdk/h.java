package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h extends android.content.BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String f1564a = "ConnectionChangeReceiver";
    private static boolean c = false;
    private static boolean d = false;
    private com.unisound.sdk.bg b;

    h(com.unisound.sdk.bg bgVar) {
        this.b = bgVar;
    }

    public void a(boolean z) {
        c = z;
    }

    public boolean a() {
        return d;
    }

    public void b(boolean z) {
        d = z;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        try {
            com.unisound.common.y.c(com.unisound.common.y.v, "receiver onReceive intent = " + intent.getAction());
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return;
            }
            android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            android.net.NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo2 != null) {
                com.unisound.common.y.a(com.unisound.common.y.v, "network status changed");
                if (networkInfo.isConnected() || networkInfo2.isConnected()) {
                    com.unisound.common.y.c(com.unisound.common.y.v, "network isConnected");
                    if (c) {
                        this.b.refreshActivate();
                        c = false;
                        return;
                    }
                    return;
                }
                return;
            }
            com.unisound.common.y.a(f1564a, "networkinfo is null!");
        } catch (java.lang.Exception unused) {
            com.unisound.common.y.c("ConnectionChangeReceiver onReceive error");
        }
    }
}
