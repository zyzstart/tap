package com.tencent.hlyyb.common.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f591a = "";
    private static java.lang.String b = "";

    public static int a(android.content.Context context, java.lang.String str) {
        int i;
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                return -407;
            }
            if (applicationInfo.metaData != null && (i = applicationInfo.metaData.getInt("halley_appid", 0)) > 0) {
                return i;
            }
            return -408;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return -407;
        }
    }

    public static com.tencent.hlyyb.common.d.k a(int i, android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            android.content.pm.ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new android.content.ComponentName(str, str2), 128);
            if (serviceInfo != null) {
                return new com.tencent.hlyyb.common.d.k(i, str, serviceInfo.enabled, serviceInfo.exported, serviceInfo.processName, serviceInfo.metaData);
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static java.lang.String a() {
        if (!android.text.TextUtils.isEmpty(b)) {
            return b;
        }
        java.lang.String string = com.tencent.hlyyb.common.a.a().getSharedPreferences(a(false), 0).getString("deviceid", "");
        b = string;
        return string;
    }

    public static java.lang.String a(int i) {
        if (i == 2) {
            return "2g";
        }
        if (i == 3) {
            return "3g";
        }
        if (i == 4) {
            return "4g";
        }
        return i == 1 ? "wifi" : "";
    }

    public static java.lang.String a(android.content.Context context) throws java.lang.Throwable {
        if (!android.text.TextUtils.isEmpty(f591a)) {
            return f591a;
        }
        java.lang.String packageName = context.getPackageName();
        java.lang.String strA = com.tencent.hlyyb.common.f.c.a(android.os.Process.myPid());
        if (android.text.TextUtils.isEmpty(strA) || !strA.startsWith(packageName)) {
            strA = com.tencent.hlyyb.common.f.c.a(context, android.os.Process.myPid());
        }
        f591a = strA;
        return strA;
    }

    private static java.lang.String a(boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("HalleyServicePreferences_");
        sb.append(com.tencent.hlyyb.common.a.c());
        sb.append(com.tencent.hlyyb.common.a.b() ? "_test" : "");
        java.lang.String string = sb.toString();
        if (!z) {
            return string;
        }
        return string + "_" + com.tencent.hlyyb.common.a.j();
    }

    public static void a(java.lang.String str) {
        com.tencent.hlyyb.common.a.a().getSharedPreferences(a(false), 0).edit().putString("deviceid", str).commit();
        b = str;
    }

    public static void a(java.lang.String str, int i, boolean z) {
        com.tencent.hlyyb.common.a.a().getSharedPreferences(a(false), 0).edit().putInt(str, i).commit();
    }

    public static void a(java.lang.String str, long j, boolean z) {
        com.tencent.hlyyb.common.a.a().getSharedPreferences(a(false), 0).edit().putLong(str, j).commit();
    }

    public static void a(java.lang.String str, java.lang.String str2, boolean z) {
        com.tencent.hlyyb.common.a.a().getSharedPreferences(a(z), 0).edit().putString(str, str2).commit();
    }

    public static int b(java.lang.String str, int i, boolean z) {
        return com.tencent.hlyyb.common.a.a().getSharedPreferences(a(false), 0).getInt(str, 0);
    }

    public static long b(java.lang.String str, long j, boolean z) {
        return com.tencent.hlyyb.common.a.a().getSharedPreferences(a(false), 0).getLong(str, 0L);
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2, boolean z) {
        return com.tencent.hlyyb.common.a.a().getSharedPreferences(a(z), 0).getString(str, str2);
    }
}
