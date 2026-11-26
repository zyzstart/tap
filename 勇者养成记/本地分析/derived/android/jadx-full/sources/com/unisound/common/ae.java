package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String f1466a = "Network";
    public static final java.lang.String b = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final java.lang.String c = "cn.yunzhisheng.intent.action.CONNECTIVITY_CHANGE";
    public static final java.lang.String d = "TYPE_NULL_POINT";
    public static final java.lang.String e = "TYPE_UNCONNECT";
    public static final java.lang.String f = "TYPE_WIFI";
    public static final java.lang.String g = "TYPE_GPRS";
    private static final int h = 0;
    private static final int i = 1;
    private static int j = 1;

    private static java.lang.String a(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            int ipAddress = ((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress();
            return ipAddress == 0 ? b() : a(ipAddress);
        } catch (java.lang.Exception unused) {
            com.unisound.common.y.c("Network getIp error");
            return "";
        }
    }

    public static boolean a() {
        return j > 0;
    }

    public static java.lang.String b() {
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.util.Enumeration<java.net.InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    java.net.InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof java.net.Inet4Address)) {
                        return inetAddressNextElement.getHostAddress().toString();
                    }
                }
            }
            return "0.0.0.0";
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "0.0.0.0";
        }
    }

    public static boolean b(android.content.Context context) {
        if (context == null) {
            return false;
        }
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (java.lang.Exception unused) {
            com.unisound.common.y.c("Network:isNetworkConnected error");
            return false;
        }
    }

    public static boolean c(android.content.Context context) {
        int i2 = j;
        if (d(context)) {
            j = 1;
        } else {
            j = 0;
        }
        if (i2 != j && context != null) {
            context.sendBroadcast(new android.content.Intent("cn.yunzhisheng.intent.action.CONNECTIVITY_CHANGE"));
        }
        return j > 0;
    }

    public static boolean d(android.content.Context context) {
        if (context == null) {
            return false;
        }
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (java.lang.Exception unused) {
            com.unisound.common.y.c("Network:isNetworkConnected error");
        }
    }

    public static java.lang.String e(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        java.lang.String str;
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "TYPE_NULL_POINT";
            }
            if (!activeNetworkInfo.isConnected()) {
                return "TYPE_UNCONNECT";
            }
            switch (activeNetworkInfo.getType()) {
                case 0:
                    str = "TYPE_GPRS";
                    break;
                case 1:
                    str = "TYPE_WIFI";
                    break;
                default:
                    return "TYPE_NULL_POINT";
            }
            return str;
        } catch (java.lang.Exception unused) {
            com.unisound.common.y.c("Network:judgeCurrentNetTpe error");
            return "TYPE_NULL_POINT";
        }
    }
}
