package com.tencent.tmassistantbase.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1010a = true;
    private static com.tencent.tmassistantbase.b.c b = new com.tencent.tmassistantbase.b.c();
    private static boolean c = false;

    public static int a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.equals("46000") || str.equals("46002") || str.equals("46007")) {
            return 0;
        }
        if (str.equals("46001")) {
            return 1;
        }
        return str.equals("46003") ? 2 : -1;
    }

    private static com.tencent.tmassistantbase.b.c a(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        com.tencent.tmassistantbase.b.c cVar = new com.tencent.tmassistantbase.b.c();
        android.net.NetworkInfo activeNetworkInfo = null;
        if (context != null) {
            try {
                connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            } catch (java.lang.Throwable unused) {
            }
        } else {
            connectivityManager = null;
        }
        activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            f1010a = false;
            cVar.f1009a = com.tencent.tmassistantbase.b.a.NO_NETWORK;
            return cVar;
        }
        f1010a = true;
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            return b(context);
        }
        cVar.f1009a = com.tencent.tmassistantbase.b.a.WIFI;
        android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) com.tencent.tmassistantbase.util.k.a().b().getSystemService("wifi");
        if (wifiManager != null) {
            try {
                android.net.wifi.WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    cVar.e = connectionInfo.getBSSID();
                    cVar.f = connectionInfo.getSSID();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return cVar;
    }

    public static boolean a() {
        if (b.f1009a == com.tencent.tmassistantbase.b.a.UN_DETECT) {
            f();
        }
        return f1010a;
    }

    private static com.tencent.tmassistantbase.b.c b(android.content.Context context) {
        com.tencent.tmassistantbase.b.c cVar = new com.tencent.tmassistantbase.b.c();
        boolean zB = b();
        cVar.d = zB;
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
        java.lang.String networkOperator = telephonyManager.getNetworkOperator();
        cVar.b = networkOperator;
        int networkType = telephonyManager.getNetworkType();
        cVar.c = networkType;
        int iA = a(networkOperator);
        if (iA == 0) {
            if (networkType == 1 || networkType == 2) {
                cVar.f1009a = zB ? com.tencent.tmassistantbase.b.a.CMWAP : com.tencent.tmassistantbase.b.a.CMNET;
                return cVar;
            }
            if (networkType == 13) {
                cVar.f1009a = zB ? com.tencent.tmassistantbase.b.a.WAP4G : com.tencent.tmassistantbase.b.a.NET4G;
                return cVar;
            }
            if (networkType != 16) {
                cVar.f1009a = zB ? com.tencent.tmassistantbase.b.a.UNKNOW_WAP : com.tencent.tmassistantbase.b.a.UNKNOWN;
                return cVar;
            }
            cVar.f1009a = zB ? com.tencent.tmassistantbase.b.a.CMWAP : com.tencent.tmassistantbase.b.a.CMNET;
            return cVar;
        }
        if (iA != 1) {
            if (iA != 2) {
                cVar.f1009a = zB ? com.tencent.tmassistantbase.b.a.UNKNOW_WAP : com.tencent.tmassistantbase.b.a.UNKNOWN;
                return cVar;
            }
            if (networkType != 13) {
                cVar.f1009a = zB ? com.tencent.tmassistantbase.b.a.CTWAP : com.tencent.tmassistantbase.b.a.CTNET;
                return cVar;
            }
            cVar.f1009a = zB ? com.tencent.tmassistantbase.b.a.WAP4G : com.tencent.tmassistantbase.b.a.NET4G;
            return cVar;
        }
        if (networkType == 1 || networkType == 2) {
            cVar.f1009a = zB ? com.tencent.tmassistantbase.b.a.UNIWAP : com.tencent.tmassistantbase.b.a.UNINET;
            return cVar;
        }
        if (networkType != 3 && networkType != 8 && networkType != 10) {
            if (networkType == 13) {
                cVar.f1009a = zB ? com.tencent.tmassistantbase.b.a.WAP4G : com.tencent.tmassistantbase.b.a.NET4G;
                return cVar;
            }
            if (networkType != 15) {
                cVar.f1009a = zB ? com.tencent.tmassistantbase.b.a.UNKNOW_WAP : com.tencent.tmassistantbase.b.a.UNKNOWN;
                return cVar;
            }
        }
        cVar.f1009a = zB ? com.tencent.tmassistantbase.b.a.WAP3G : com.tencent.tmassistantbase.b.a.NET3G;
        return cVar;
    }

    public static boolean b() {
        return !android.text.TextUtils.isEmpty(android.net.Proxy.getDefaultHost());
    }

    public static boolean c() {
        return e() == com.tencent.tmassistantbase.b.a.WIFI;
    }

    public static com.tencent.tmassistantbase.b.c d() {
        if (b.f1009a == com.tencent.tmassistantbase.b.a.UN_DETECT) {
            f();
        }
        return b;
    }

    public static com.tencent.tmassistantbase.b.a e() {
        return d().f1009a;
    }

    public static void f() {
        b = a(com.tencent.tmassistantbase.util.k.a().b());
    }
}
