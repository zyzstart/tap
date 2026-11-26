package com.tencent.msdk.dns.base.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {
    private static int a(android.net.NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return 0;
        }
        switch (networkInfo.getSubtype()) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 2;
            case 13:
            default:
                return 3;
        }
    }

    public static java.lang.String a(int i) {
        switch (i) {
            case 1:
                return "2G";
            case 2:
                return "3G";
            case 3:
                return "4G";
            case 4:
                return "wifi";
            case 5:
                return "ethernet";
            default:
                return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static java.lang.String a(android.content.Context context) {
        return a(b(context));
    }

    public static int b(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        if (context == null) {
            return 0;
        }
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                return a(activeNetworkInfo);
            }
            if (type != 1) {
                return type != 9 ? 0 : 5;
            }
            return 4;
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    public static java.lang.String c(android.content.Context context) {
        android.net.wifi.WifiManager wifiManager;
        android.net.wifi.WifiInfo connectionInfo;
        return (context == null || (wifiManager = (android.net.wifi.WifiManager) context.getApplicationContext().getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "" : connectionInfo.getSSID();
    }
}
