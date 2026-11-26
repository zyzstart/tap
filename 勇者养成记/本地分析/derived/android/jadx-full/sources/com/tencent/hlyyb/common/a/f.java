package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f532a = true;
    private static java.lang.String b = "";
    private static java.lang.String c = "";
    private static java.lang.String d = "";
    private static volatile int e = 0;
    private static volatile boolean f = false;
    private static volatile int g = -1;
    private static java.util.Map h = new java.util.concurrent.ConcurrentHashMap();
    private static android.content.BroadcastReceiver i = new com.tencent.hlyyb.common.a.h();
    private static java.lang.String j = "";
    private static java.lang.String k = "cmwap";
    private static java.lang.String l = "3gwap";
    private static java.lang.String m = "uniwap";
    private static java.lang.String n = "ctwap";

    public static void a() {
        com.tencent.hlyyb.common.a.k().post(new com.tencent.hlyyb.common.a.j());
    }

    public static void a(java.lang.String str, com.tencent.hlyyb.common.a.g gVar) {
        synchronized (h) {
            h.put(str, gVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized java.lang.String b() {
        java.lang.StringBuilder sb;
        java.lang.String string;
        switch (e) {
            case 1:
                sb = new java.lang.StringBuilder("ssid_");
                sb.append(c);
                sb.append(d);
                break;
            case 2:
            case 3:
            case 4:
                sb = new java.lang.StringBuilder("apn_");
                sb.append(b);
                break;
            default:
                string = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                break;
        }
        string = sb.toString();
        return string;
    }

    public static java.lang.String c() {
        switch (e) {
            case 1:
                return "wifi";
            case 2:
                return "2g";
            case 3:
                return "3g";
            case 4:
                return "4g";
            default:
                return "";
        }
    }

    public static synchronized java.lang.String d() {
        java.lang.String str;
        switch (e) {
            case 1:
                str = "wifi";
                break;
            case 2:
            case 3:
            case 4:
                str = b;
                break;
            default:
                str = "null";
                break;
        }
        throw th;
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void e() {
        int i2 = e;
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) com.tencent.hlyyb.common.a.a().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                f532a = true;
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    e = 1;
                    g = 0;
                    f = false;
                    android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) com.tencent.hlyyb.common.a.a().getSystemService("wifi")).getConnectionInfo();
                    c = connectionInfo.getSSID();
                    d = connectionInfo.getBSSID();
                } else {
                    java.lang.String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (extraInfo != null) {
                        b = extraInfo.trim().toLowerCase();
                        if (type == 0) {
                            int subtype = activeNetworkInfo.getSubtype();
                            g = subtype;
                            if (subtype == 1 || subtype == 2 || subtype == 4) {
                                e = 2;
                            } else if (subtype == 13 || subtype == 19) {
                                e = 4;
                            } else {
                                e = 3;
                            }
                            boolean zContains = b.contains("wap");
                            f = zContains;
                            if (zContains) {
                                j = (b.contains(l) || b.contains(k) || b.contains(m)) ? "10.0.0.172" : b.contains(n) ? "10.0.0.200" : "";
                            }
                        } else {
                            b = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                            e = 0;
                        }
                    } else {
                        b = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                        e = 0;
                    }
                    g = -1;
                    f = false;
                }
            } else {
                b = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
                e = 0;
                g = -1;
                f = false;
                f532a = false;
            }
            if (i2 != e) {
                synchronized (h) {
                    for (com.tencent.hlyyb.common.a.g gVar : h.values()) {
                        if (gVar != null) {
                            gVar.a(e, b());
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            try {
                th.printStackTrace();
                if (i2 != e) {
                    synchronized (h) {
                        for (com.tencent.hlyyb.common.a.g gVar2 : h.values()) {
                            if (gVar2 != null) {
                                gVar2.a(e, b());
                            }
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                if (i2 != e) {
                    synchronized (h) {
                        for (com.tencent.hlyyb.common.a.g gVar3 : h.values()) {
                            if (gVar3 != null) {
                                gVar3.a(e, b());
                            }
                        }
                    }
                }
                throw th2;
            }
        }
    }

    public static java.lang.String f() {
        if (g == -1) {
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        switch (g) {
            case 0:
                return "wifi";
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDen";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static boolean g() {
        return e == 2 || e == 3 || e == 4;
    }

    public static int h() {
        return e;
    }

    public static boolean i() {
        return f532a;
    }

    public static boolean j() {
        return f;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0060  */
    /* JADX WARN: Code duplicated, block: B:32:0x006c  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b0  */
    public static java.lang.Integer k() {
        java.lang.Integer num;
        java.lang.String lowerCase;
        e();
        int iIntValue = 0;
        if (e == 2 || e == 3 || e == 4) {
            android.content.Context contextA = com.tencent.hlyyb.common.a.a();
            java.lang.String str = b;
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) contextA.getSystemService("phone");
            if (telephonyManager == null || telephonyManager.getSimState() != 5) {
                if (str != null) {
                    lowerCase = str.toLowerCase();
                    if (!lowerCase.contains("cmnet") || lowerCase.contains("cmwap")) {
                        num = 1;
                    } else if (lowerCase.contains("uninet") || lowerCase.contains("uniwap") || lowerCase.contains("3gnet") || lowerCase.contains("3gwap")) {
                        num = 2;
                    } else if (lowerCase.contains("ctnet") || lowerCase.contains("ctwap")) {
                        num = 3;
                    }
                }
                num = 0;
            } else {
                java.lang.String simOperator = telephonyManager.getSimOperator();
                if (simOperator.length() <= 0) {
                    if (str != null) {
                        lowerCase = str.toLowerCase();
                        if (lowerCase.contains("cmnet")) {
                        }
                        num = 1;
                    }
                    num = 0;
                } else if (simOperator.equals("46000") || simOperator.equals("46002")) {
                    num = 1;
                } else if (simOperator.equals("46001")) {
                    num = 2;
                } else if (simOperator.equals("46003")) {
                    num = 3;
                } else {
                    if (str != null) {
                        lowerCase = str.toLowerCase();
                        if (lowerCase.contains("cmnet")) {
                        }
                        num = 1;
                    }
                    num = 0;
                }
            }
            iIntValue = num.intValue();
        }
        return java.lang.Integer.valueOf(iIntValue);
    }

    public static java.net.Proxy l() {
        if (!f || android.text.TextUtils.isEmpty(j)) {
            return null;
        }
        return new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(j, 80));
    }

    public static boolean m() {
        try {
            android.os.PowerManager powerManager = (android.os.PowerManager) com.tencent.hlyyb.common.a.a().getSystemService("power");
            if (android.os.Build.VERSION.SDK_INT < 23 || powerManager == null) {
                return false;
            }
            return ((java.lang.Boolean) android.os.PowerManager.class.getDeclaredMethod("isDeviceIdleMode", new java.lang.Class[0]).invoke(powerManager, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
