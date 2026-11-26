package com.unisound.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String f1457a = "Network";
    public static final java.lang.String b = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final java.lang.String c = "cn.yunzhisheng.intent.action.CONNECTIVITY_CHANGE";
    public static final java.lang.String d = "TYPE_NULL_POINT";
    public static final java.lang.String e = "TYPE_UNCONNECT";
    public static final java.lang.String f = "TYPE_WIFI";
    public static final java.lang.String g = "TYPE_GPRS";
    private static final int h = 0;
    private static final int i = 1;
    private static int j = 1;

    public static long a(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", java.util.Locale.ENGLISH);
            java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("GMT+8"));
            try {
                return simpleDateFormat.parse(str).getTime();
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                com.unisound.b.i.a("getServerTime exception");
            }
        }
        return 0L;
    }

    private static java.lang.String a(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            return a(((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress());
        } catch (java.lang.Exception unused) {
            com.unisound.b.i.c("Activate getIp error");
            return "";
        }
    }

    public static boolean a() {
        return j > 0;
    }

    public static boolean b(android.content.Context context) {
        int i2 = j;
        if (c(context)) {
            j = 1;
        } else {
            j = 0;
        }
        if (i2 != j && context != null) {
            context.sendBroadcast(new android.content.Intent("cn.yunzhisheng.intent.action.CONNECTIVITY_CHANGE"));
        }
        return j > 0;
    }

    public static boolean c(android.content.Context context) {
        if (context == null) {
            return false;
        }
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (java.lang.Exception unused) {
            com.unisound.b.i.d("activate isNetworkConnected error");
        }
    }

    public static java.lang.String d(android.content.Context context) {
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
            com.unisound.b.i.d("Activate Network judgeCurrentNetTpe error");
            return "TYPE_NULL_POINT";
        }
    }
}
