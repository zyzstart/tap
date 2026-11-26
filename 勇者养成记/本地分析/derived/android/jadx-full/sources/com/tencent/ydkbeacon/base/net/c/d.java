package com.tencent.ydkbeacon.base.net.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.Map f1227a;

    public static com.tencent.ydkbeacon.pack.RequestPackage a(int i, byte[] bArr, java.util.Map map, java.lang.String str) {
        com.tencent.ydkbeacon.a.c.c cVarD = com.tencent.ydkbeacon.a.c.c.d();
        com.tencent.ydkbeacon.a.c.f fVarP = com.tencent.ydkbeacon.a.c.f.p();
        com.tencent.ydkbeacon.pack.RequestPackage requestPackage = new com.tencent.ydkbeacon.pack.RequestPackage();
        requestPackage.model = android.os.Build.MODEL;
        requestPackage.osVersion = fVarP.z();
        requestPackage.platformId = cVarD.g();
        requestPackage.appkey = str;
        requestPackage.appVersion = com.tencent.ydkbeacon.a.c.b.a();
        requestPackage.sdkId = cVarD.h();
        requestPackage.sdkVersion = cVarD.i();
        requestPackage.cmd = i;
        requestPackage.encryType = (byte) 3;
        requestPackage.zipType = (byte) 2;
        requestPackage.sBuffer = bArr;
        requestPackage.reserved = b(map);
        return requestPackage;
    }

    public static synchronized java.util.Map a() {
        if (f1227a == null) {
            java.util.HashMap map = new java.util.HashMap(4);
            f1227a = map;
            map.put("wup_version", "3.0");
            f1227a.put("TYPE_COMPRESS", java.lang.String.valueOf(2));
            f1227a.put("encr_type", "rsapost");
            com.tencent.ydkbeacon.d.g gVarB = com.tencent.ydkbeacon.d.g.b();
            if (gVarB != null) {
                f1227a.put("bea_key", gVarB.d());
            }
        }
        return f1227a;
    }

    @android.support.annotation.Nullable
    public static java.util.Map a(java.lang.String str, java.util.Map map) {
        if (map == null) {
            return null;
        }
        java.util.HashMap map2 = new java.util.HashMap();
        int length = 0;
        for (java.util.Map.Entry entry : map.entrySet()) {
            java.lang.String str2 = (java.lang.String) entry.getKey();
            int length2 = str2.trim().length();
            if (length2 <= 0 || !a(str2)) {
                com.tencent.ydkbeacon.a.e.c.e("[core] '%s' should be ASCII code in 32-126!", str2);
                com.tencent.ydkbeacon.a.b.d.b().a("102", "[event] eventName: " + str + ", key: " + str2 + " should be ASCII code in 32-126!");
            } else {
                java.lang.String strTrim = str2.trim();
                if (length2 > 64) {
                    strTrim = strTrim.substring(0, 64);
                    java.lang.String str3 = "[event] eventName: " + str + ", key: " + strTrim + " should be less than 64!";
                    com.tencent.ydkbeacon.a.b.d.b().a("102", str3);
                    com.tencent.ydkbeacon.a.e.e.a(str3);
                }
                java.lang.String strReplace = strTrim.replace("|", "%7C").replace("&", "%26").replace("=", "%3D");
                java.lang.String str4 = (java.lang.String) entry.getValue();
                java.lang.String strTrim2 = str4 == null ? "" : str4.trim();
                if (strTrim2.length() > 10240) {
                    java.lang.String str5 = "[event] eventName: " + str + ", key: " + strReplace + "'s value > 10K.";
                    com.tencent.ydkbeacon.a.b.d.b().a("103", str5);
                    com.tencent.ydkbeacon.a.e.e.a(str5);
                    strTrim2 = strTrim2.substring(0, 10240);
                }
                java.lang.String strReplace2 = strTrim2.replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D");
                map2.put(strReplace, strReplace2);
                length += strReplace.length() + strReplace2.length();
            }
        }
        if (length <= 46080) {
            return map2;
        }
        java.lang.String str6 = "[event] eventName: " + str + " params > 45K";
        com.tencent.ydkbeacon.a.b.d.b().a("104", str6);
        com.tencent.ydkbeacon.a.e.e.a(str6);
        return null;
    }

    public static void a(long j, java.lang.String str) {
        com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "fixBeaconInfo, serverTime: " + j + ",ip: " + str, new java.lang.Object[0]);
        com.tencent.ydkbeacon.a.c.c cVarD = com.tencent.ydkbeacon.a.c.c.d();
        cVarD.b(str);
        cVarD.a(j - new java.util.Date().getTime());
    }

    private static void a(java.lang.String str, java.lang.String str2) {
        com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "update strategy sid: %s, max_time: %s", str, str2);
        com.tencent.ydkbeacon.d.g.b().a(str, str2);
    }

    public static boolean a(java.lang.String str) {
        int length = str.length();
        boolean z = true;
        while (true) {
            length--;
            if (length < 0) {
                return z;
            }
            char cCharAt = str.charAt(length);
            if (cCharAt < ' ' || cCharAt >= 127) {
                z = false;
            }
        }
    }

    public static boolean a(java.util.Map map) {
        if (map == null) {
            return false;
        }
        if (map.containsKey("encrypt-status")) {
            com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "parse response header fail! cause by svr encrypt error!", new java.lang.Object[0]);
            return false;
        }
        if (!map.containsKey(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID) || !map.containsKey("max_time")) {
            return true;
        }
        java.util.List list = (java.util.List) map.get(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID);
        java.util.List list2 = (java.util.List) map.get("max_time");
        java.lang.String str = list != null ? (java.lang.String) list.get(0) : null;
        java.lang.String str2 = list2 != null ? (java.lang.String) list2.get(0) : null;
        if (str == null || str2 == null) {
            return true;
        }
        a(str, str2);
        return true;
    }

    @android.support.annotation.RequiresPermission(com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE)
    public static android.net.NetworkInfo b() {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) com.tencent.ydkbeacon.a.c.c.d().c().getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static java.lang.String b(java.util.Map map) {
        if (map == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry entry : map.entrySet()) {
            java.lang.String str = (java.lang.String) entry.getKey();
            if (str.trim().length() <= 0 || !a(str)) {
                com.tencent.ydkbeacon.a.e.c.e("[core] '%s' should be ASCII code in 32-126!", str);
            } else {
                java.lang.String strTrim = str.trim();
                sb.append("&");
                sb.append(strTrim.replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                sb.append("=");
                java.lang.String str2 = (java.lang.String) entry.getValue();
                if (str2 != null) {
                    sb.append(str2.trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                }
            }
        }
        return sb.length() > 0 ? sb.substring(1) : "";
    }

    public static java.lang.String c() {
        android.net.NetworkInfo networkInfoB = b();
        if (networkInfoB == null) {
            return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (networkInfoB.getType() == 1) {
            return "wifi";
        }
        java.lang.String extraInfo = networkInfoB.getExtraInfo();
        if (extraInfo != null && extraInfo.length() > 64) {
            extraInfo = extraInfo.substring(0, 64);
        }
        return "" + extraInfo;
    }

    public static void c(java.util.Map map) {
        if (map != null) {
            if (map.containsKey("encrypt-status")) {
                com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "parse response header fail! cause by svr encrypt error!", new java.lang.Object[0]);
            }
            if (map.containsKey(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID) && map.containsKey("max_time")) {
                a((java.lang.String) map.get(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID), (java.lang.String) map.get("max_time"));
            }
        }
    }

    public static boolean d() {
        android.net.NetworkInfo networkInfoB = b();
        return networkInfoB != null && networkInfoB.isConnected();
    }
}
