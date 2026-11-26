package com.tencent.beacon.core.info;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f183a = null;
    private static java.lang.Boolean b = null;
    public static int c = 0;
    public static java.lang.String d = "";
    public static boolean e = false;
    private static boolean f = false;

    public static java.lang.String a() {
        if (!"".equals(d)) {
            return d;
        }
        try {
            if (c == 0) {
                c = android.os.Process.myPid();
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(d);
            sb.append(c);
            sb.append("_");
            d = sb.toString();
            d += new java.util.Date().getTime();
        } catch (java.lang.Exception unused) {
        }
        return d;
    }

    public static java.lang.String a(android.content.Context context) {
        if (f183a == null) {
            f183a = e(context);
        }
        return f183a;
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
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
                com.tencent.beacon.core.e.d.i("[core] no running proc", new java.lang.Object[0]);
                return false;
            } catch (java.lang.Throwable th) {
                com.tencent.beacon.core.e.d.a(th);
                com.tencent.beacon.core.e.d.b("[core] Failed to judge [%s]", th.getLocalizedMessage());
            }
        }
        return false;
    }

    public static int b(android.content.Context context) {
        if (!com.tencent.beacon.upload.UploadStrategy.IS_PROCESS_INFO) {
            com.tencent.beacon.core.e.d.a("[core] current collect ProcessInfo be refused! isCollectProcessInfo: %s", java.lang.Boolean.FALSE);
            return -2;
        }
        try {
            if (c == 0) {
                c = android.os.Process.myPid();
            }
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == c) {
                    return runningAppProcessInfo.importance;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return 0;
    }

    public static boolean b(android.content.Context context, java.lang.String str) {
        if (context == null || str == null) {
            com.tencent.beacon.core.e.d.b("[core] context or permission is null.", new java.lang.Object[0]);
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
                    com.tencent.beacon.core.e.d.a(th);
                } catch (java.lang.Throwable th2) {
                    com.tencent.beacon.core.e.d.a("[core] end", new java.lang.Object[0]);
                    throw th2;
                }
            }
            com.tencent.beacon.core.e.d.a("[core] end", new java.lang.Object[0]);
        }
        return z;
    }

    public static java.lang.String c(android.content.Context context) {
        try {
            return (java.lang.String) java.lang.Class.forName("android.app.ActivityThread").getDeclaredMethod(android.os.Build.VERSION.SDK_INT >= 18 ? "currentProcessName" : "currentPackageName", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            return "";
        }
    }

    public static java.lang.String d(android.content.Context context) {
        if (context == null) {
            return null;
        }
        java.lang.String packageName = context.getPackageName();
        return com.tencent.beacon.core.e.j.b(packageName) ? "" : packageName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static synchronized java.lang.String e(android.content.Context context) {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(d(context), 0);
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
                    com.tencent.beacon.core.e.d.a("[core] add versionCode: %s", java.lang.Integer.valueOf(i));
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(strReplace);
                    sb.append(".");
                    sb.append(i);
                    strReplace = sb.toString();
                }
                com.tencent.beacon.core.e.d.a("[core] final Version: %s", strReplace);
                return strReplace;
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("");
            sb2.append(i);
            return sb2.toString();
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b(th.toString(), new java.lang.Object[0]);
            return "";
        }
    }

    public static void f(android.content.Context context) {
        try {
            com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(context);
            java.lang.String strA = fVarA.a("last_app_version", "");
            java.lang.String strA2 = a(context);
            if (com.tencent.beacon.core.e.j.b(strA) || !strA2.equals(strA)) {
                f = true;
                fVarA.b().a("last_app_version", (java.lang.Object) strA2).a();
            } else {
                f = false;
            }
        } catch (java.lang.Exception e2) {
            com.tencent.beacon.core.e.d.b("[core] app version check fail!", new java.lang.Object[0]);
            com.tencent.beacon.core.e.d.a(e2);
        }
    }

    public static synchronized boolean g(android.content.Context context) {
        boolean z;
        try {
            if (context == null) {
                com.tencent.beacon.core.e.d.b("[core] context is null", new java.lang.Object[0]);
                return false;
            }
            try {
                com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(context);
                java.lang.String strA = fVarA.a("APPVER_DENGTA", (java.lang.String) null);
                java.lang.String strA2 = a(context);
                if (strA == null || !strA.equals(strA2)) {
                    z = true;
                    try {
                        fVarA.b().a("APPVER_DENGTA", (java.lang.Object) strA2).a();
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        com.tencent.beacon.core.e.d.b("[core] updateLocalAPPVER fail!", new java.lang.Object[0]);
                        com.tencent.beacon.core.e.d.a(e);
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

    public static boolean h(android.content.Context context) {
        if (com.tencent.beacon.upload.UploadStrategy.IS_PROCESS_INFO) {
            return a(context, context.getPackageName());
        }
        com.tencent.beacon.core.e.d.a("[core] current collect ProcessInfo be refused! isCollectProcessInfo: %s", java.lang.Boolean.FALSE);
        return true;
    }

    public static synchronized boolean i(android.content.Context context) {
        if (b == null) {
            b = java.lang.Boolean.valueOf(b(context, "android.permission.READ_PHONE_STATE"));
        }
        com.tencent.beacon.core.e.d.a("[core] Read phone state permission: " + b, new java.lang.Object[0]);
        return b.booleanValue();
    }

    public static synchronized boolean j(android.content.Context context) {
        java.lang.Exception e2;
        boolean z;
        try {
            if (context == null) {
                com.tencent.beacon.core.e.d.b("[core] context is null", new java.lang.Object[0]);
                return false;
            }
            try {
                com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(context);
                java.lang.String strA = fVarA.a("[REDACTED]", (java.lang.String) null);
                java.lang.String strA2 = com.tencent.beacon.core.info.b.b;
                if (com.tencent.beacon.core.e.j.b(strA2)) {
                    strA2 = com.tencent.beacon.core.info.b.a(context);
                }
                if (strA == null || !strA.equals(strA2)) {
                    z = true;
                    try {
                        fVarA.b().a("[REDACTED]", (java.lang.Object) strA2).a();
                    } catch (java.lang.Exception e3) {
                        e2 = e3;
                        com.tencent.beacon.core.e.d.b("[REDACTED]", new java.lang.Object[0]);
                        com.tencent.beacon.core.e.d.a(e2);
                    }
                } else {
                    z = false;
                }
            } catch (java.lang.Exception e4) {
                e2 = e4;
                z = false;
            }
            return z;
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    public static boolean k(android.content.Context context) {
        return f;
    }
}
