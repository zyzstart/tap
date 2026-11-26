package com.tencent.bugly;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Bugly {
    public static final java.lang.String SDK_IS_DEV = "false";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f274a = false;
    public static android.content.Context applicationContext = null;
    private static java.lang.String[] b = {"BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule"};
    private static java.lang.String[] c = {"BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule"};
    public static boolean enable = true;
    public static java.lang.Boolean isDev;

    public static synchronized java.lang.String getAppChannel() {
        byte[] bArr;
        com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
        if (aVarB == null) {
            return null;
        }
        if (android.text.TextUtils.isEmpty(aVarB.l)) {
            com.tencent.bugly.proguard.p pVarA = com.tencent.bugly.proguard.p.a();
            if (pVarA == null) {
                return aVarB.l;
            }
            java.util.Map<java.lang.String, byte[]> mapA = pVarA.a(556, (com.tencent.bugly.proguard.o) null, true);
            if (mapA != null && (bArr = mapA.get("app_channel")) != null) {
                return new java.lang.String(bArr);
            }
        }
        return aVarB.l;
    }

    public static void init(android.content.Context context, java.lang.String str, boolean z) {
        init(context, str, z, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void init(android.content.Context context, java.lang.String str, boolean z, com.tencent.bugly.BuglyStrategy buglyStrategy) {
        if (f274a) {
            return;
        }
        f274a = true;
        android.content.Context contextA = com.tencent.bugly.proguard.z.a(context);
        applicationContext = contextA;
        if (contextA == null) {
            android.util.Log.e(com.tencent.bugly.proguard.x.f454a, "init arg 'context' should not be null!");
            return;
        }
        if (isDev()) {
            b = c;
        }
        for (java.lang.String str2 : b) {
            try {
                if (str2.equals("BuglyCrashModule")) {
                    com.tencent.bugly.b.a(com.tencent.bugly.CrashModule.getInstance());
                } else if (!str2.equals("BuglyBetaModule") && !str2.equals("BuglyRqdModule")) {
                    str2.equals("BuglyFeedbackModule");
                }
            } catch (java.lang.Throwable th) {
                com.tencent.bugly.proguard.x.b(th);
            }
        }
        com.tencent.bugly.b.f277a = enable;
        com.tencent.bugly.b.a(applicationContext, str, z, buglyStrategy);
    }

    public static boolean isDev() {
        if (isDev == null) {
            isDev = java.lang.Boolean.valueOf(java.lang.Boolean.parseBoolean("false".replace("@", "")));
        }
        return isDev.booleanValue();
    }
}
