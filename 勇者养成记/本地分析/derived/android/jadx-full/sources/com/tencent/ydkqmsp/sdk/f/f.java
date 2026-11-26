package com.tencent.ydkqmsp.sdk.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {
    public static android.net.NetworkInfo a(android.content.Context context) {
        try {
            return ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (java.lang.Throwable th) {
            com.tencent.ydkqmsp.sdk.f.g.b("Qp.NU", 0, th.toString());
            return null;
        }
    }

    public static boolean b(android.content.Context context) {
        android.net.NetworkInfo networkInfoA;
        return (context == null || (networkInfoA = a(context)) == null || networkInfoA.getType() != 1) ? false : true;
    }
}
