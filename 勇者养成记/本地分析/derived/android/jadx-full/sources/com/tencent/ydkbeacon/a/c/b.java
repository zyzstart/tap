package com.tencent.ydkbeacon.a.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f1186a = null;
    private static java.lang.Boolean b = null;
    private static java.lang.String c = null;
    public static int d = 0;
    public static java.lang.String e = "";
    public static boolean f = false;
    private static boolean g = false;
    private static java.lang.String h = "";

    public static java.lang.String a() {
        if (f1186a == null) {
            f1186a = e();
        }
        return f1186a;
    }

    public static synchronized java.lang.String a(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(c)) {
            java.lang.String str = "on_app_first_install_time_" + c(context);
            com.tencent.ydkbeacon.a.d.a aVarA = com.tencent.ydkbeacon.a.d.a.a();
            long time = aVarA.getLong(str, 0L);
            if (time == 0) {
                time = new java.util.Date().getTime();
                com.tencent.ydkbeacon.a.b.a.a().a(new com.tencent.ydkbeacon.a.c.a(aVarA, str, time));
            }
            java.lang.String strValueOf = java.lang.String.valueOf(time);
            c = strValueOf;
            com.tencent.ydkbeacon.a.e.c.a("[appInfo] process: %s, getAppFirstInstallTime: %s", str, strValueOf);
        }
        com.tencent.ydkbeacon.a.e.c.a("[appInfo] getAppFirstInstallTime: %s", c);
        return c;
    }

    public static void a(java.lang.String str) {
        java.lang.Object[] objArr;
        java.lang.String str2;
        if (android.text.TextUtils.isEmpty(str)) {
            objArr = new java.lang.Object[0];
            str2 = "[appInfo] set qq is null !";
        } else {
            try {
                if (java.lang.Long.parseLong(str) > 10000) {
                    h = str;
                    return;
                }
                return;
            } catch (java.lang.Exception unused) {
                objArr = new java.lang.Object[0];
                str2 = "[appInfo] set qq is not available !";
            }
        }
        com.tencent.ydkbeacon.a.e.c.e(str2, objArr);
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        if (context != null && str != null && str.trim().length() > 0) {
            if (!com.tencent.ydkbeacon.d.b.a().j()) {
                com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] current collect Process Info be refused! isCollect Process Info: %s", java.lang.Boolean.FALSE);
                return true;
            }
            java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
                for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.importance == 100) {
                        for (java.lang.String str2 : runningAppProcessInfo.pkgList) {
                            if (str.equals(str2)) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            com.tencent.ydkbeacon.a.e.c.e("[appInfo] no running proc", new java.lang.Object[0]);
        }
        return false;
    }

    public static int b(android.content.Context context) {
        if (d == 0) {
            d = android.os.Process.myPid();
        }
        if (!com.tencent.ydkbeacon.d.b.a().j()) {
            com.tencent.ydkbeacon.a.e.c.a("[DeviceInfo] current collect Process Info be refused! isCollect Process Info: %s", java.lang.Boolean.FALSE);
            return -2;
        }
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        if (activityManager != null && activityManager.getRunningAppProcesses() != null) {
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == d) {
                    return runningAppProcessInfo.importance;
                }
            }
        }
        return 0;
    }

    public static java.lang.String b() {
        android.content.Context contextC = com.tencent.ydkbeacon.a.c.c.d().c();
        if (contextC == null) {
            return null;
        }
        java.lang.String packageName = contextC.getPackageName();
        return android.text.TextUtils.isEmpty(packageName) ? "" : packageName;
    }

    public static boolean b(android.content.Context context, java.lang.String str) {
        java.lang.String[] strArr;
        if (context == null || str == null) {
            com.tencent.ydkbeacon.a.e.c.b("[appInfo] context or permission is null.", new java.lang.Object[0]);
            return false;
        }
        boolean z = context.checkPermission(str, android.os.Process.myPid(), android.os.Process.myUid()) == 0;
        if (!z) {
            try {
                if (android.os.Build.VERSION.SDK_INT < 23 && (strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) != null) {
                    for (java.lang.String str2 : strArr) {
                        if (str.equals(str2)) {
                            z = true;
                            break;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                try {
                    com.tencent.ydkbeacon.a.e.c.a(th);
                } catch (java.lang.Throwable th2) {
                    com.tencent.ydkbeacon.a.e.c.a("[appInfo] end", new java.lang.Object[0]);
                    throw th2;
                }
            }
            com.tencent.ydkbeacon.a.e.c.a("[appInfo] end", new java.lang.Object[0]);
        }
        return z;
    }

    public static java.lang.String c() {
        return h;
    }

    public static java.lang.String c(android.content.Context context) {
        return com.tencent.ydkbeacon.a.e.a.a();
    }

    public static java.lang.String d() {
        if (!"".equals(e)) {
            return e;
        }
        if (d == 0) {
            d = android.os.Process.myPid();
        }
        e += d + "_";
        java.lang.String str = e + new java.util.Date().getTime();
        e = str;
        return str;
    }

    public static synchronized boolean d(android.content.Context context) {
        boolean z = false;
        try {
            if (context == null) {
                com.tencent.ydkbeacon.a.e.c.b("[appInfo] context is null", new java.lang.Object[0]);
                return false;
            }
            com.tencent.ydkbeacon.a.d.a aVarA = com.tencent.ydkbeacon.a.d.a.a();
            java.lang.String string = aVarA.getString("APPVER_DENGTA", "");
            java.lang.String strA = a();
            if (string.isEmpty() || !string.equals(strA)) {
                z = true;
                aVarA.edit().putString("APPVER_DENGTA", strA);
            }
            return z;
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized java.lang.String e() {
        try {
            java.lang.String strB = b();
            if (android.text.TextUtils.isEmpty(strB)) {
                return null;
            }
            try {
                android.content.pm.PackageInfo packageInfo = com.tencent.ydkbeacon.a.c.c.d().c().getPackageManager().getPackageInfo(strB, 0);
                java.lang.String str = packageInfo.versionName;
                int i = packageInfo.versionCode;
                if (str != null && str.trim().length() > 0) {
                    java.lang.String strReplace = str.trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
                    int i2 = 0;
                    for (char c2 : strReplace.toCharArray()) {
                        if (c2 == '.') {
                            i2++;
                        }
                    }
                    if (i2 < 3) {
                        com.tencent.ydkbeacon.a.e.c.a("[appInfo] add versionCode: %s", java.lang.Integer.valueOf(i));
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(strReplace);
                        sb.append(".");
                        sb.append(i);
                        strReplace = sb.toString();
                    }
                    com.tencent.ydkbeacon.a.e.c.a("[appInfo] final Version: %s", strReplace);
                    return strReplace;
                }
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("");
                sb2.append(i);
                return sb2.toString();
            } catch (java.lang.Throwable th) {
                com.tencent.ydkbeacon.a.e.c.a(th);
                com.tencent.ydkbeacon.a.e.c.b(th.toString(), new java.lang.Object[0]);
                return "";
            }
        } catch (java.lang.Throwable th2) {
            throw th2;
        }
    }

    public static boolean e(android.content.Context context) {
        return a(context, context.getPackageName());
    }

    public static void f() {
        i();
    }

    public static synchronized boolean f(android.content.Context context) {
        if (b == null) {
            b = java.lang.Boolean.valueOf(b(context, "android.permission.READ_PHONE_STATE"));
        }
        com.tencent.ydkbeacon.a.e.c.a("[appInfo] Read phone state permission: " + b, new java.lang.Object[0]);
        return b.booleanValue();
    }

    public static synchronized boolean g() {
        boolean z;
        z = false;
        com.tencent.ydkbeacon.a.d.a aVarA = com.tencent.ydkbeacon.a.d.a.a();
        java.lang.String string = aVarA.getString("[REDACTED]", "[REDACTED]");
        java.lang.String strF = com.tencent.ydkbeacon.a.c.c.d().f();
        if (android.text.TextUtils.isEmpty(string) || !strF.equals(string)) {
            z = true;
            aVarA.edit().putString("[REDACTED]", strF);
        }
        return z;
    }

    public static boolean g(android.content.Context context) {
        if (context == null) {
            return true;
        }
        java.lang.String strC = c(context);
        return android.text.TextUtils.isEmpty(strC) || strC.equals(context.getPackageName());
    }

    public static boolean h() {
        return g;
    }

    private static void i() {
        try {
            com.tencent.ydkbeacon.a.d.a aVarA = com.tencent.ydkbeacon.a.d.a.a();
            java.lang.String string = aVarA.getString("APPVER_DENGTA", "");
            java.lang.String strA = a();
            if (android.text.TextUtils.isEmpty(string) || !strA.equals(string)) {
                g = true;
                aVarA.edit().putString("APPVER_DENGTA", strA);
            } else {
                g = false;
            }
        } catch (java.lang.Exception e2) {
            com.tencent.ydkbeacon.a.e.c.b("[core] app version check fail!", new java.lang.Object[0]);
            com.tencent.ydkbeacon.a.e.c.a(e2);
        }
    }
}
