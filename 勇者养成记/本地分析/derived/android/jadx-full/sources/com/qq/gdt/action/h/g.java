package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f119a;
    private static final java.util.Map<java.lang.String, java.lang.Integer> b = new java.util.HashMap<java.lang.String, java.lang.Integer>() { // from class: com.qq.gdt.action.h.g.1
        {
            put("46000", 1);
            put("46002", 1);
            put("46007", 1);
            put("46008", 1);
            put("46001", 2);
            put("46006", 2);
            put("46009", 2);
            put("46003", 3);
            put("46005", 3);
            put("46011", 3);
        }
    };
    private static java.util.List<java.lang.String> c = null;
    private static java.util.List<java.lang.String> d = null;

    public static java.lang.String a() {
        java.lang.String strB = b();
        return com.qq.gdt.action.h.t.a(strB) ? strB : com.qq.gdt.action.h.r.a(strB.toLowerCase());
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.util.List<java.lang.String> a(android.telephony.TelephonyManager telephonyManager, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.lang.reflect.Method method = android.telephony.TelephonyManager.class.getMethod(str, java.lang.Integer.TYPE);
            for (int i = 0; i < 2; i++) {
                java.lang.Object objInvoke = method.invoke(telephonyManager, java.lang.Integer.valueOf(i));
                com.qq.gdt.action.h.l.a(str + "(" + i + ") return:" + objInvoke, new java.lang.Object[0]);
                arrayList.add(objInvoke != null ? java.lang.String.valueOf(objInvoke) : "");
            }
        } catch (java.lang.Throwable unused) {
            com.qq.gdt.action.h.l.a("exception while call " + str + "reflected", new java.lang.Object[0]);
        }
        return arrayList;
    }

    public static int b(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (java.lang.Throwable unused) {
            return 0;
        }
    }

    public static java.lang.String b() {
        java.lang.String deviceId;
        if (!com.qq.gdt.action.h.t.a(f119a)) {
            return f119a;
        }
        android.content.Context contextC = com.qq.gdt.action.e.a().c();
        if (!com.qq.gdt.action.h.n.a(contextC, "android.permission.READ_PHONE_STATE")) {
            return f119a;
        }
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) contextC.getSystemService("phone");
            if (telephonyManager != null) {
                if (android.os.Build.VERSION.SDK_INT <= 28) {
                    deviceId = telephonyManager.getDeviceId();
                } else if (telephonyManager.hasCarrierPrivileges()) {
                    deviceId = telephonyManager.getImei();
                } else {
                    com.qq.gdt.action.h.l.a("Hasn't carrier privileges.", new java.lang.Object[0]);
                }
                f119a = deviceId;
            }
        } catch (java.lang.Exception e) {
            com.qq.gdt.action.h.l.a("Exception while get imei: " + e.getMessage(), new java.lang.Object[0]);
        }
        return f119a;
    }

    public static java.lang.String c() {
        try {
            return com.qq.gdt.action.e.a().c().getPackageName();
        } catch (java.lang.Throwable th) {
            com.qq.gdt.action.h.l.a("Get package name encountered exception: " + th.getMessage(), new java.lang.Object[0]);
            return null;
        }
    }

    public static java.lang.String c(android.content.Context context) {
        try {
            android.content.pm.PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (java.lang.String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String d() {
        try {
            return android.provider.Settings.System.getString(com.qq.gdt.action.e.a().c().getApplicationContext().getContentResolver(), com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_ANDROID_ID_PHONE);
        } catch (java.lang.Throwable th) {
            com.qq.gdt.action.h.l.a("Get Android id encounter exception: " + th.getMessage(), new java.lang.Object[0]);
            return null;
        }
    }

    public static java.lang.String e() {
        java.lang.String strD = d();
        if (com.qq.gdt.action.h.t.a(strD)) {
            return null;
        }
        return com.qq.gdt.action.h.r.a(strD).toLowerCase();
    }

    public static java.lang.String f() {
        try {
            java.lang.String strL = l();
            return (com.qq.gdt.action.h.t.a(strL) || "02:00:00:00:00:00".equals(strL)) ? m() : strL;
        } catch (java.lang.Throwable th) {
            com.qq.gdt.action.h.l.a("Get Android id encounter exception: " + th.getMessage(), new java.lang.Object[0]);
            return null;
        }
    }

    public static java.lang.String g() {
        java.lang.String strF = f();
        if (com.qq.gdt.action.h.t.a(strF)) {
            return null;
        }
        return com.qq.gdt.action.h.r.a(strF.replace(":", "").toUpperCase()).toLowerCase();
    }

    public static java.lang.Integer h() {
        try {
            java.lang.String strN = n();
            if (com.qq.gdt.action.h.t.a(strN)) {
                return 0;
            }
            for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry : b.entrySet()) {
                if (strN.startsWith(entry.getKey())) {
                    return entry.getValue();
                }
            }
        } catch (java.lang.Throwable th) {
            com.qq.gdt.action.h.l.a("Get carrier encounter exception: " + th.getMessage(), new java.lang.Object[0]);
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.util.List<java.lang.String> i() {
        java.util.List<java.lang.String> list;
        java.util.List<java.lang.String> list2 = c;
        if (list2 != null) {
            return list2;
        }
        synchronized (com.qq.gdt.action.h.g.class) {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) com.qq.gdt.action.e.a().c().getSystemService("phone");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.String strA : a(telephonyManager, "getImei")) {
                if (!com.qq.gdt.action.h.t.a(strA)) {
                    strA = com.qq.gdt.action.h.r.a(strA.toLowerCase());
                }
                arrayList.add(strA);
            }
            c = java.util.Collections.unmodifiableList(arrayList);
            list = c;
        }
        return list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.util.List<java.lang.String> j() {
        java.util.List<java.lang.String> list;
        java.util.List<java.lang.String> list2 = d;
        if (list2 != null) {
            return list2;
        }
        synchronized (com.qq.gdt.action.h.g.class) {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) com.qq.gdt.action.e.a().c().getSystemService("phone");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.String strA : a(telephonyManager, "getMeid")) {
                if (!com.qq.gdt.action.h.t.a(strA)) {
                    strA = com.qq.gdt.action.h.r.a(strA.toLowerCase());
                }
                arrayList.add(strA);
            }
            d = java.util.Collections.unmodifiableList(arrayList);
            list = d;
        }
        return list;
    }

    public static java.lang.String k() {
        try {
            return java.util.TimeZone.getDefault().getDisplayName(false, 0);
        } catch (java.lang.AssertionError | java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String l() {
        android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) com.qq.gdt.action.e.a().c().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo != null) {
            return connectionInfo.getMacAddress();
        }
        return null;
    }

    private static java.lang.String m() {
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.net.NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return null;
                    }
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(java.lang.String.format("%02X:", java.lang.Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.String n() {
        try {
            return ((android.telephony.TelephonyManager) com.qq.gdt.action.e.a().c().getSystemService("phone")).getSubscriberId();
        } catch (java.lang.Throwable th) {
            com.qq.gdt.action.h.l.a("Get operator encounter exception: " + th.getMessage(), new java.lang.Object[0]);
            return null;
        }
    }
}
