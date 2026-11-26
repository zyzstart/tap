package com.tencent.bugly.opengame;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Bugly {
    public static final java.lang.String SDK_IS_DEV = "false";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f324a = false;
    public static android.content.Context applicationContext = null;
    private static java.lang.String[] b = {"BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule"};
    private static java.lang.String[] c = {"BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule"};
    public static boolean enable = true;
    public static java.lang.Boolean isDev;

    public static synchronized java.lang.String getAppChannel() {
        byte[] bArr;
        com.tencent.bugly.opengame.crashreport.common.info.a aVarB = com.tencent.bugly.opengame.crashreport.common.info.a.b();
        if (aVarB == null) {
            return null;
        }
        if (android.text.TextUtils.isEmpty(aVarB.l)) {
            com.tencent.bugly.opengame.proguard.p pVarA = com.tencent.bugly.opengame.proguard.p.a();
            if (pVarA == null) {
                return aVarB.l;
            }
            java.util.Map mapA = pVarA.a(556, (com.tencent.bugly.opengame.proguard.o) null, true);
            if (mapA != null && (bArr = (byte[]) mapA.get("app_channel")) != null) {
                return new java.lang.String(bArr);
            }
        }
        return aVarB.l;
    }

    public static void init(android.content.Context context, java.lang.String str, boolean z) {
        init(context, str, z, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void init(android.content.Context context, java.lang.String str, boolean z, com.tencent.bugly.opengame.BuglyStrategy buglyStrategy) {
        if (f324a) {
            return;
        }
        f324a = true;
        android.content.Context contextA = com.tencent.bugly.opengame.proguard.z.a(context);
        applicationContext = contextA;
        if (contextA == null) {
            android.util.Log.e(com.tencent.bugly.opengame.proguard.x.f412a, "init arg 'context' should not be null!");
            return;
        }
        if (isDev()) {
            b = c;
        }
        for (java.lang.String str2 : b) {
            try {
                if (str2.equals("BuglyCrashModule")) {
                    com.tencent.bugly.opengame.b.a(com.tencent.bugly.opengame.CrashModule.getInstance());
                } else if (!str2.equals("BuglyBetaModule") && !str2.equals("BuglyRqdModule")) {
                    str2.equals("BuglyFeedbackModule");
                }
            } catch (java.lang.Throwable th) {
                com.tencent.bugly.opengame.proguard.x.b(th);
            }
        }
        com.tencent.bugly.opengame.b.f327a = enable;
        com.tencent.bugly.opengame.b.a(applicationContext, str, z, buglyStrategy);
    }

    public static boolean isDev() {
        if (isDev == null) {
            isDev = java.lang.Boolean.valueOf(java.lang.Boolean.parseBoolean("false".replace("@", "")));
        }
        return isDev.booleanValue();
    }
}
