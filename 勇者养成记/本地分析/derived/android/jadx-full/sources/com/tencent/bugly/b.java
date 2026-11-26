package com.tencent.bugly;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f277a = true;
    public static java.util.List<com.tencent.bugly.a> b = new java.util.ArrayList();
    public static boolean c;
    private static com.tencent.bugly.proguard.p d;
    private static boolean e;

    public static synchronized void a(android.content.Context context) {
        a(context, null);
    }

    public static synchronized void a(android.content.Context context, com.tencent.bugly.BuglyStrategy buglyStrategy) {
        if (e) {
            com.tencent.bugly.proguard.x.d("[init] initial Multi-times, ignore this.", new java.lang.Object[0]);
            return;
        }
        if (context == null) {
            android.util.Log.w(com.tencent.bugly.proguard.x.f454a, "[init] context of init() is null, check it.");
            return;
        }
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
        if (a(aVarA)) {
            f277a = false;
            return;
        }
        java.lang.String strF = aVarA.f();
        if (strF == null) {
            android.util.Log.e(com.tencent.bugly.proguard.x.f454a, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
        } else {
            a(context, strF, aVarA.u, buglyStrategy);
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0201 A[Catch: Throwable -> 0x020d, all -> 0x022f, TRY_LEAVE, TryCatch #0 {Throwable -> 0x020d, blocks: (B:69:0x01f1, B:71:0x0201), top: B:88:0x01f1, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x021c A[Catch: all -> 0x022f, TryCatch #2 {, blocks: (B:4:0x0009, B:6:0x000e, B:10:0x0019, B:14:0x0024, B:18:0x002e, B:20:0x0032, B:21:0x006e, B:23:0x00bb, B:26:0x00bf, B:28:0x00cd, B:30:0x00db, B:32:0x00e1, B:33:0x00f7, B:34:0x0106, B:36:0x010c, B:38:0x0116, B:40:0x011c, B:41:0x0132, B:47:0x0162, B:53:0x0176, B:55:0x0180, B:57:0x0186, B:58:0x019c, B:59:0x01ab, B:61:0x01b1, B:63:0x01b7, B:64:0x01cd, B:65:0x01d9, B:42:0x0146, B:44:0x0151, B:46:0x015b, B:50:0x016f, B:52:0x0173, B:66:0x01e5, B:67:0x01e9, B:69:0x01f1, B:71:0x0201, B:77:0x0217, B:79:0x021c, B:81:0x0223, B:74:0x020e, B:76:0x0214), top: B:92:0x0009, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0221  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void a(android.content.Context context, java.lang.String str, boolean z, com.tencent.bugly.BuglyStrategy buglyStrategy) {
        int i;
        long appReportDelay;
        byte[] bArr;
        if (e) {
            com.tencent.bugly.proguard.x.d("[init] initial Multi-times, ignore this.", new java.lang.Object[0]);
            return;
        }
        if (context == null) {
            android.util.Log.w(com.tencent.bugly.proguard.x.f454a, "[init] context is null, check it.");
            return;
        }
        if (str == null) {
            android.util.Log.e(com.tencent.bugly.proguard.x.f454a, "init arg 'crashReportAppID' should not be null!");
            return;
        }
        e = true;
        if (z) {
            c = true;
            com.tencent.bugly.proguard.x.b = true;
            com.tencent.bugly.proguard.x.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.e("--------------------------------------------------------------------------------------------", new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.e("--------------------------------------------------------------------------------------------", new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.b("[init] Open debug mode of Bugly.", new java.lang.Object[0]);
        }
        com.tencent.bugly.proguard.x.a("[init] Bugly version: v%s", "3.0.0");
        com.tencent.bugly.proguard.x.a(" crash report start initializing...", new java.lang.Object[0]);
        com.tencent.bugly.proguard.x.b("[init] Bugly start initializing...", new java.lang.Object[0]);
        com.tencent.bugly.proguard.x.a("[init] Bugly complete version: v%s", "3.0.0");
        android.content.Context contextA = com.tencent.bugly.proguard.z.a(context);
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(contextA);
        aVarA.t();
        com.tencent.bugly.proguard.y.a(contextA);
        d = com.tencent.bugly.proguard.p.a(contextA, b);
        com.tencent.bugly.proguard.u.a(contextA);
        com.tencent.bugly.crashreport.common.strategy.a aVarA2 = com.tencent.bugly.crashreport.common.strategy.a.a(contextA, b);
        com.tencent.bugly.proguard.n nVarA = com.tencent.bugly.proguard.n.a(contextA);
        if (a(aVarA)) {
            f277a = false;
            return;
        }
        aVarA.a(str);
        com.tencent.bugly.proguard.x.a("[param] Set APP ID:%s", str);
        if (buglyStrategy == null) {
            com.tencent.bugly.crashreport.biz.b.a(contextA, buglyStrategy);
            for (i = 0; i < b.size(); i++) {
                if (nVarA.a(b.get(i).id)) {
                    b.get(i).init(contextA, z, buglyStrategy);
                }
            }
            if (buglyStrategy != null) {
                appReportDelay = buglyStrategy.getAppReportDelay();
            } else {
                appReportDelay = 0;
            }
            aVarA2.a(appReportDelay);
            com.tencent.bugly.proguard.x.b("[init] Bugly initialization finished.", new java.lang.Object[0]);
            return;
        }
        java.lang.String appVersion = buglyStrategy.getAppVersion();
        if (!android.text.TextUtils.isEmpty(appVersion)) {
            if (appVersion.length() > 100) {
                java.lang.String strSubstring = appVersion.substring(0, 100);
                com.tencent.bugly.proguard.x.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, strSubstring);
                appVersion = strSubstring;
            }
            aVarA.j = appVersion;
            com.tencent.bugly.proguard.x.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
        }
        try {
            if (buglyStrategy.isReplaceOldChannel()) {
                java.lang.String appChannel = buglyStrategy.getAppChannel();
                if (!android.text.TextUtils.isEmpty(appChannel)) {
                    if (appChannel.length() > 100) {
                        java.lang.String strSubstring2 = appChannel.substring(0, 100);
                        com.tencent.bugly.proguard.x.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, strSubstring2);
                        appChannel = strSubstring2;
                    }
                    d.a(556, "app_channel", appChannel.getBytes(), (com.tencent.bugly.proguard.o) null, false);
                    aVarA.l = appChannel;
                }
            } else {
                java.util.Map<java.lang.String, byte[]> mapA = d.a(556, (com.tencent.bugly.proguard.o) null, true);
                if (mapA != null && (bArr = mapA.get("app_channel")) != null) {
                    aVarA.l = new java.lang.String(bArr);
                }
            }
            com.tencent.bugly.proguard.x.a("[param] Set App channel: %s", aVarA.l);
        } catch (java.lang.Exception e2) {
            if (c) {
                e2.printStackTrace();
            }
        }
        java.lang.String appPackageName = buglyStrategy.getAppPackageName();
        if (!android.text.TextUtils.isEmpty(appPackageName)) {
            if (appPackageName.length() > 100) {
                java.lang.String strSubstring3 = appPackageName.substring(0, 100);
                com.tencent.bugly.proguard.x.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, strSubstring3);
                appPackageName = strSubstring3;
            }
            aVarA.c = appPackageName;
            com.tencent.bugly.proguard.x.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
        }
        java.lang.String deviceID = buglyStrategy.getDeviceID();
        if (deviceID != null) {
            if (deviceID.length() > 100) {
                java.lang.String strSubstring4 = deviceID.substring(0, 100);
                com.tencent.bugly.proguard.x.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, strSubstring4);
                deviceID = strSubstring4;
            }
            aVarA.c(deviceID);
            com.tencent.bugly.proguard.x.a("[param] Set device ID: %s", deviceID);
        }
        aVarA.e = buglyStrategy.isUploadProcess();
        com.tencent.bugly.proguard.y.f455a = buglyStrategy.isBuglyLogUpload();
        com.tencent.bugly.crashreport.biz.b.a(contextA, buglyStrategy);
        while (i < b.size()) {
            try {
                if (nVarA.a(b.get(i).id)) {
                    b.get(i).init(contextA, z, buglyStrategy);
                }
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.proguard.x.a(th)) {
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
        com.tencent.bugly.proguard.x.b("[init] Bugly initialization finished.", new java.lang.Object[0]);
        return;
        throw th;
    }

    public static synchronized void a(com.tencent.bugly.a aVar) {
        if (!b.contains(aVar)) {
            b.add(aVar);
        }
    }

    private static boolean a(com.tencent.bugly.crashreport.common.info.a aVar) {
        java.util.List<java.lang.String> list = aVar.o;
        aVar.getClass();
        return list != null && list.contains(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_BUGLY);
    }
}
