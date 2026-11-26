package com.tencent.bugly.opengame;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f327a = true;
    public static java.util.List b = new java.util.ArrayList();
    public static boolean c;
    private static com.tencent.bugly.opengame.proguard.p d;
    private static boolean e;

    public static synchronized void a(android.content.Context context) {
        a(context, null);
    }

    public static synchronized void a(android.content.Context context, com.tencent.bugly.opengame.BuglyStrategy buglyStrategy) {
        if (e) {
            com.tencent.bugly.opengame.proguard.x.d("[init] initial Multi-times, ignore this.", new java.lang.Object[0]);
            return;
        }
        if (context == null) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "[init] context of init() is null, check it.");
            return;
        }
        com.tencent.bugly.opengame.crashreport.common.info.a aVarA = com.tencent.bugly.opengame.crashreport.common.info.a.a(context);
        if (a(aVarA)) {
            f327a = false;
            return;
        }
        java.lang.String strF = aVarA.f();
        if (strF == null) {
            android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
        } else {
            a(context, strF, aVarA.u, buglyStrategy);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0216 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x0200 A[Catch: all -> 0x020c, TRY_LEAVE, TryCatch #1 {all -> 0x020c, blocks: (B:76:0x01f0, B:78:0x0200), top: B:97:0x01f0, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x021b A[Catch: all -> 0x022e, TryCatch #2 {, blocks: (B:4:0x0009, B:6:0x000e, B:10:0x0019, B:14:0x0024, B:18:0x002e, B:20:0x0032, B:21:0x006e, B:23:0x00bb, B:26:0x00bf, B:28:0x00cd, B:30:0x00db, B:32:0x00e1, B:33:0x00f7, B:34:0x0106, B:36:0x010c, B:38:0x0116, B:40:0x011c, B:42:0x0122, B:43:0x0132, B:46:0x0138, B:52:0x015f, B:54:0x0163, B:60:0x0175, B:62:0x017f, B:64:0x0185, B:65:0x019b, B:66:0x01aa, B:68:0x01b0, B:70:0x01b6, B:71:0x01cc, B:72:0x01d8, B:47:0x0144, B:49:0x014f, B:51:0x0159, B:57:0x016e, B:59:0x0172, B:73:0x01e4, B:74:0x01e8, B:84:0x0216, B:86:0x021b, B:88:0x0222, B:81:0x020d, B:83:0x0213, B:76:0x01f0, B:78:0x0200), top: B:99:0x0009, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0220  */
    /* JADX WARN: Code duplicated, block: B:97:0x01f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void a(android.content.Context context, java.lang.String str, boolean z, com.tencent.bugly.opengame.BuglyStrategy buglyStrategy) {
        int i;
        long appReportDelay;
        byte[] bArr;
        java.lang.String str2;
        if (e) {
            com.tencent.bugly.opengame.proguard.x.d("[init] initial Multi-times, ignore this.", new java.lang.Object[0]);
            return;
        }
        if (context == null) {
            android.util.Log.w(com.tencent.bugly.opengame.proguard.x.f412a, "[init] context is null, check it.");
            return;
        }
        if (str == null) {
            android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "init arg 'crashReportAppID' should not be null!");
            return;
        }
        e = true;
        if (z) {
            c = true;
            com.tencent.bugly.opengame.proguard.x.b = true;
            com.tencent.bugly.opengame.proguard.x.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new java.lang.Object[0]);
            com.tencent.bugly.opengame.proguard.x.e("--------------------------------------------------------------------------------------------", new java.lang.Object[0]);
            com.tencent.bugly.opengame.proguard.x.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new java.lang.Object[0]);
            com.tencent.bugly.opengame.proguard.x.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new java.lang.Object[0]);
            com.tencent.bugly.opengame.proguard.x.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new java.lang.Object[0]);
            com.tencent.bugly.opengame.proguard.x.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new java.lang.Object[0]);
            com.tencent.bugly.opengame.proguard.x.e("--------------------------------------------------------------------------------------------", new java.lang.Object[0]);
            com.tencent.bugly.opengame.proguard.x.b("[init] Open debug mode of Bugly.", new java.lang.Object[0]);
        }
        com.tencent.bugly.opengame.proguard.x.a("[init] Bugly version: v%s", "3.0.0");
        com.tencent.bugly.opengame.proguard.x.a("opengame crash report start initializing...", new java.lang.Object[0]);
        com.tencent.bugly.opengame.proguard.x.b("[init] Bugly start initializing...", new java.lang.Object[0]);
        com.tencent.bugly.opengame.proguard.x.a("[init] Bugly complete version: v%s", "3.0.0");
        android.content.Context contextA = com.tencent.bugly.opengame.proguard.z.a(context);
        com.tencent.bugly.opengame.crashreport.common.info.a aVarA = com.tencent.bugly.opengame.crashreport.common.info.a.a(contextA);
        aVarA.t();
        com.tencent.bugly.opengame.proguard.y.a(contextA);
        d = com.tencent.bugly.opengame.proguard.p.a(contextA, b);
        com.tencent.bugly.opengame.proguard.u.a(contextA);
        com.tencent.bugly.opengame.crashreport.common.strategy.a aVarA2 = com.tencent.bugly.opengame.crashreport.common.strategy.a.a(contextA, b);
        com.tencent.bugly.opengame.proguard.n nVarA = com.tencent.bugly.opengame.proguard.n.a(contextA);
        if (a(aVarA)) {
            f327a = false;
            return;
        }
        aVarA.a(str);
        com.tencent.bugly.opengame.proguard.x.a("[param] Set APP ID:%s", str);
        if (buglyStrategy == null) {
            com.tencent.bugly.opengame.crashreport.biz.b.a(contextA, buglyStrategy);
            for (i = 0; i < b.size(); i++) {
                if (nVarA.a(((com.tencent.bugly.opengame.a) b.get(i)).id)) {
                    ((com.tencent.bugly.opengame.a) b.get(i)).init(contextA, z, buglyStrategy);
                }
            }
            if (buglyStrategy != null) {
                appReportDelay = buglyStrategy.getAppReportDelay();
            } else {
                appReportDelay = 0;
            }
            aVarA2.a(appReportDelay);
            com.tencent.bugly.opengame.proguard.x.b("[init] Bugly initialization finished.", new java.lang.Object[0]);
            return;
        }
        java.lang.String appVersion = buglyStrategy.getAppVersion();
        if (!android.text.TextUtils.isEmpty(appVersion)) {
            if (appVersion.length() > 100) {
                java.lang.String strSubstring = appVersion.substring(0, 100);
                com.tencent.bugly.opengame.proguard.x.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, strSubstring);
                appVersion = strSubstring;
            }
            aVarA.j = appVersion;
            com.tencent.bugly.opengame.proguard.x.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
        }
        try {
            if (buglyStrategy.isReplaceOldChannel()) {
                str2 = buglyStrategy.getAppChannel();
                if (!android.text.TextUtils.isEmpty(str2)) {
                    if (str2.length() > 100) {
                        java.lang.String strSubstring2 = str2.substring(0, 100);
                        com.tencent.bugly.opengame.proguard.x.d("appChannel %s length is over limit %d substring to %s", str2, 100, strSubstring2);
                        str2 = strSubstring2;
                    }
                    d.a(556, "app_channel", str2.getBytes(), (com.tencent.bugly.opengame.proguard.o) null, false);
                    aVarA.l = str2;
                }
            } else {
                java.util.Map mapA = d.a(556, (com.tencent.bugly.opengame.proguard.o) null, true);
                if (mapA != null && (bArr = (byte[]) mapA.get("app_channel")) != null) {
                    str2 = new java.lang.String(bArr);
                    aVarA.l = str2;
                }
            }
            com.tencent.bugly.opengame.proguard.x.a("[param] Set App channel: %s", aVarA.l);
        } catch (java.lang.Exception e2) {
            if (c) {
                e2.printStackTrace();
            }
        }
        java.lang.String appPackageName = buglyStrategy.getAppPackageName();
        if (!android.text.TextUtils.isEmpty(appPackageName)) {
            if (appPackageName.length() > 100) {
                java.lang.String strSubstring3 = appPackageName.substring(0, 100);
                com.tencent.bugly.opengame.proguard.x.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, strSubstring3);
                appPackageName = strSubstring3;
            }
            aVarA.c = appPackageName;
            com.tencent.bugly.opengame.proguard.x.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
        }
        java.lang.String deviceID = buglyStrategy.getDeviceID();
        if (deviceID != null) {
            if (deviceID.length() > 100) {
                java.lang.String strSubstring4 = deviceID.substring(0, 100);
                com.tencent.bugly.opengame.proguard.x.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, strSubstring4);
                deviceID = strSubstring4;
            }
            aVarA.c(deviceID);
            com.tencent.bugly.opengame.proguard.x.a("[param] Set device ID: %s", deviceID);
        }
        aVarA.e = buglyStrategy.isUploadProcess();
        com.tencent.bugly.opengame.proguard.y.f413a = buglyStrategy.isBuglyLogUpload();
        com.tencent.bugly.opengame.crashreport.biz.b.a(contextA, buglyStrategy);
        while (i < b.size()) {
            try {
                if (nVarA.a(((com.tencent.bugly.opengame.a) b.get(i)).id)) {
                    ((com.tencent.bugly.opengame.a) b.get(i)).init(contextA, z, buglyStrategy);
                }
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        if (buglyStrategy != null) {
            appReportDelay = buglyStrategy.getAppReportDelay();
        } else {
            appReportDelay = 0;
        }
        aVarA2.a(appReportDelay);
        com.tencent.bugly.opengame.proguard.x.b("[init] Bugly initialization finished.", new java.lang.Object[0]);
        return;
        throw th;
    }

    public static synchronized void a(com.tencent.bugly.opengame.a aVar) {
        if (!b.contains(aVar)) {
            b.add(aVar);
        }
    }

    private static boolean a(com.tencent.bugly.opengame.crashreport.common.info.a aVar) {
        java.util.List list = aVar.o;
        aVar.getClass();
        aVar.getClass();
        return list != null && list.contains("opengame");
    }
}
