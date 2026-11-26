package com.tencent.beaconselfupdate.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static java.lang.String f222a = null;
    public static boolean b = false;
    private static java.lang.String c = null;
    private static java.lang.String d = null;
    private static java.lang.Boolean e = null;
    private static int f = 0;
    private static java.lang.String g = "";

    public static java.lang.String a() {
        if (!"".equals(g)) {
            return g;
        }
        try {
            if (f == 0) {
                f = android.os.Process.myPid();
            }
            g += f + "_";
            g += new java.util.Date().getTime();
        } catch (java.lang.Exception unused) {
        }
        return g;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00d5 A[Catch: all -> 0x00da, TRY_LEAVE, TryCatch #4 {all -> 0x00da, blocks: (B:38:0x00bd, B:40:0x00d5), top: B:60:0x00bd, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00bd A[EXC_TOP_SPLITTER, PHI: r1
  0x00bd: PHI (r1v3 java.lang.String) = (r1v1 java.lang.String), (r1v7 java.lang.String), (r1v7 java.lang.String), (r1v8 java.lang.String) binds: [B:33:0x00b3, B:37:0x00ba, B:34:0x00b5, B:25:0x0092] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public static synchronized java.lang.String a(android.content.Context context) {
        java.lang.Object obj;
        if (context == null) {
            return "";
        }
        java.lang.String string = "";
        java.io.InputStream inputStreamOpen = null;
        android.content.res.AssetManager assets = context.getAssets();
        try {
            try {
                java.lang.String string2 = context.getSharedPreferences("DENGTA_META", 0).getString("key_channelpath", "");
                if (string2.equals("")) {
                    string2 = "channel.ini";
                    context.getSharedPreferences("DENGTA_META", 0).edit().putString("key_channelpath", "channel.ini").commit();
                }
                com.tencent.beaconselfupdate.c.a.a("channel path!! " + string2, new java.lang.Object[0]);
                if (!string2.equals("")) {
                    inputStreamOpen = assets.open(string2);
                    java.util.Properties properties = new java.util.Properties();
                    properties.load(inputStreamOpen);
                    string = properties.getProperty("CHANNEL", "");
                    com.tencent.beaconselfupdate.c.a.a("channel !! " + string, new java.lang.Object[0]);
                    if (!"".equals(string)) {
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (java.io.IOException e2) {
                                com.tencent.beaconselfupdate.c.a.a(e2);
                            }
                        }
                        return string;
                    }
                    throw th;
                }
                if (inputStreamOpen == null) {
                    obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                    if (obj != null) {
                        string = obj.toString();
                    }
                    return string;
                }
                try {
                    inputStreamOpen.close();
                } catch (java.io.IOException e3) {
                    com.tencent.beaconselfupdate.c.a.a(e3);
                }
                try {
                    obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                    if (obj != null) {
                        string = obj.toString();
                    }
                } catch (java.lang.Throwable unused) {
                    com.tencent.beaconselfupdate.c.a.a("no channel !!", new java.lang.Object[0]);
                }
                return string;
            } catch (java.lang.Exception unused2) {
                context.getSharedPreferences("DENGTA_META", 0).edit().putString("key_channelpath", "").commit();
                com.tencent.beaconselfupdate.c.a.c("get app channel fail!", new java.lang.Object[0]);
                if (inputStreamOpen == null) {
                    obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                    if (obj != null) {
                        string = obj.toString();
                    }
                    return string;
                }
            }
        } catch (java.lang.Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (java.io.IOException e4) {
                    com.tencent.beaconselfupdate.c.a.a(e4);
                }
            }
            throw th;
        }
        throw th;
    }

    public static void a(android.content.Context context, java.lang.String str) {
        context.getSharedPreferences("DENGTA_META", 0).edit().putString("querytimes", str).commit();
    }

    public static void a(java.lang.String str) {
        synchronized (com.tencent.beaconselfupdate.a.a.class) {
            f222a = str;
        }
        com.tencent.beaconselfupdate.a.c cVarM = com.tencent.beaconselfupdate.a.c.m();
        if (cVarM != null) {
            cVarM.a(str);
        }
    }

    public static boolean a(android.content.Context context, int i) {
        try {
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i && runningAppProcessInfo.processName.split(":")[0].equals(i(context).split(":")[0])) {
                    return true;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return context.getSharedPreferences("DENGTA_META", 0).edit().putString(str, str2).commit();
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return context.getSharedPreferences("DENGTA_META", 0).getString(str, str2);
    }

    public static void b(android.content.Context context, java.lang.String str) {
        context.getSharedPreferences("DENGTA_META", 0).edit().putString("initsdkdate", str).commit();
    }

    public static synchronized boolean b(android.content.Context context) {
        boolean z;
        try {
            if (context == null) {
                com.tencent.beaconselfupdate.c.a.d("context == null return null", new java.lang.Object[0]);
                return false;
            }
            try {
                java.lang.String string = context.getSharedPreferences("[REDACTED]", 4).getString("[REDACTED]", null);
                java.lang.String appkey = com.tencent.beaconselfupdate.event.UserAction.getAppkey();
                if (string == null || !string.equals(appkey)) {
                    z = true;
                    try {
                        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("DENGTA_META", 0).edit();
                        editorEdit.putString("[REDACTED]", appkey);
                        editorEdit.commit();
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        com.tencent.beaconselfupdate.c.a.b("[REDACTED]", new java.lang.Object[0]);
                        com.tencent.beaconselfupdate.c.a.a(e);
                    }
                } else {
                    z = false;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                z = false;
            }
            return z;
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    public static void c(android.content.Context context, java.lang.String str) {
        context.getSharedPreferences("DENGTA_META", 0).edit().putString("pid_stat", str).commit();
    }

    public static boolean c(android.content.Context context) {
        boolean z;
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.d("context == null return null", new java.lang.Object[0]);
            return false;
        }
        try {
            java.lang.String string = context.getSharedPreferences("DENGTA_META", 0).getString("APPVER_DENGTA", null);
            java.lang.String strJ = j(context);
            if (string != null && string.equals(strJ)) {
                return false;
            }
            z = true;
            try {
                android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("DENGTA_META", 0).edit();
                editorEdit.putString("APPVER_DENGTA", strJ);
                editorEdit.commit();
                return true;
            } catch (java.lang.Exception e2) {
                e = e2;
                com.tencent.beaconselfupdate.c.a.b("[REDACTED]", new java.lang.Object[0]);
                com.tencent.beaconselfupdate.c.a.a(e);
                return z;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            z = false;
        }
    }

    public static java.lang.String d(android.content.Context context) {
        if (context == null) {
            return null;
        }
        return context.getPackageName();
    }

    private static boolean d(android.content.Context context, java.lang.String str) {
        if (context == null || str == null) {
            com.tencent.beaconselfupdate.c.a.d("context or permission is null.", new java.lang.Object[0]);
            return false;
        }
        boolean z = context.checkPermission(str, android.os.Process.myPid(), android.os.Process.myUid()) == 0;
        if (!z) {
            try {
                java.lang.String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    for (java.lang.String str2 : strArr) {
                        if (str.equals(str2)) {
                            z = true;
                            break;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                try {
                    com.tencent.beaconselfupdate.c.a.a(th);
                } catch (java.lang.Throwable th2) {
                    com.tencent.beaconselfupdate.c.a.b("AppInfo.isContainReadLogPermission() end", new java.lang.Object[0]);
                    throw th2;
                }
            }
            com.tencent.beaconselfupdate.c.a.b("AppInfo.isContainReadLogPermission() end", new java.lang.Object[0]);
        }
        return z;
    }

    public static java.lang.String e(android.content.Context context) {
        if (c == null) {
            c = j(context);
        }
        return c;
    }

    private static boolean e(android.content.Context context, java.lang.String str) {
        if (context != null && str != null && str.trim().length() > 0) {
            try {
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
                }
                com.tencent.beaconselfupdate.c.a.b("no running proc", new java.lang.Object[0]);
                return false;
            } catch (java.lang.Throwable th) {
                com.tencent.beaconselfupdate.c.a.a(th);
                com.tencent.beaconselfupdate.c.a.d("Failed to judge }[%s]", th.getLocalizedMessage());
            }
        }
        return false;
    }

    public static synchronized boolean f(android.content.Context context) {
        com.tencent.beaconselfupdate.c.a.b("Read phone state permission check! start ", new java.lang.Object[0]);
        if (e == null) {
            e = java.lang.Boolean.valueOf(d(context, "android.permission.READ_PHONE_STATE"));
        }
        return e.booleanValue();
    }

    public static boolean g(android.content.Context context) {
        return e(context, context.getPackageName());
    }

    public static int h(android.content.Context context) {
        try {
            if (f == 0) {
                f = android.os.Process.myPid();
            }
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == f) {
                    return runningAppProcessInfo.importance;
                }
            }
            return 0;
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    public static java.lang.String i(android.content.Context context) {
        java.lang.String str = d;
        if (str != null) {
            return str;
        }
        try {
            if (f == 0) {
                f = android.os.Process.myPid();
            }
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == f) {
                    java.lang.String str2 = runningAppProcessInfo.processName;
                    d = str2;
                    return str2;
                }
            }
            return "";
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static synchronized java.lang.String j(android.content.Context context) {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context == null ? null : context.getPackageName(), 0);
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
                    com.tencent.beaconselfupdate.c.a.a("add versionCode: %s", java.lang.Integer.valueOf(i));
                    strReplace = strReplace + "." + i;
                }
                com.tencent.beaconselfupdate.c.a.a("version: %s", strReplace);
                return strReplace;
            }
            return java.lang.String.valueOf(i);
        } catch (java.lang.Exception e2) {
            com.tencent.beaconselfupdate.c.a.a(e2);
            com.tencent.beaconselfupdate.c.a.d(e2.toString(), new java.lang.Object[0]);
            return "";
        }
    }
}
