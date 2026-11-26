package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class m {
    public static java.lang.String a() {
        android.content.Context contextC = com.qq.gdt.action.e.a().c();
        try {
            if (!com.qq.gdt.action.h.n.a(contextC, com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE)) {
                return "UNKNOWN";
            }
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) contextC.getSystemService("connectivity");
            if (connectivityManager != null) {
                if (android.os.Build.VERSION.SDK_INT < 23) {
                    android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                            return "WIFI";
                        }
                    }
                    return "UNKNOWN";
                }
                android.net.Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork == null) {
                    return "UNKNOWN";
                }
                android.net.NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities != null) {
                    if (networkCapabilities.hasTransport(1)) {
                        return "WIFI";
                    }
                    if (!networkCapabilities.hasTransport(0) && !networkCapabilities.hasTransport(3) && !networkCapabilities.hasTransport(4)) {
                        return "UNKNOWN";
                    }
                }
            }
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) contextC.getSystemService("phone");
            if (telephonyManager == null) {
                return "UNKNOWN";
            }
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return "2G";
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
                    return "3G";
                case 13:
                case 18:
                    return "4G";
                case 19:
                default:
                    return "UNKNOWN";
                case 20:
                    return "5G";
            }
        } catch (java.lang.Exception unused) {
            return "UNKNOWN";
        }
    }

    public static boolean a(android.content.Context context) {
        android.net.NetworkCapabilities networkCapabilities;
        if (!com.qq.gdt.action.h.n.a(context, com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE)) {
            return false;
        }
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (android.os.Build.VERSION.SDK_INT < 23) {
                android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }
            android.net.Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(4);
        } catch (java.lang.Exception e) {
            com.qq.gdt.action.h.l.a("Check network available exception", e);
            return false;
        }
    }
}
