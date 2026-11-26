package com.tencent.beacon.core.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {
    public static android.net.NetworkInfo a(android.content.Context context) {
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            return null;
        }
    }

    public static java.lang.String b(android.content.Context context) {
        android.net.NetworkInfo networkInfoA = a(context);
        if (networkInfoA == null) {
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (networkInfoA.getType() == 1) {
            return "wifi";
        }
        java.lang.String extraInfo = networkInfoA.getExtraInfo();
        if (extraInfo != null && extraInfo.length() > 64) {
            extraInfo = extraInfo.substring(0, 64);
        }
        return "" + extraInfo;
    }

    public static boolean c(android.content.Context context) {
        android.net.NetworkInfo networkInfoA = a(context);
        return networkInfoA != null && networkInfoA.isConnected();
    }

    public static boolean d(android.content.Context context) {
        android.net.NetworkInfo networkInfoA = a(context);
        return networkInfoA != null && networkInfoA.getType() == 1;
    }
}
