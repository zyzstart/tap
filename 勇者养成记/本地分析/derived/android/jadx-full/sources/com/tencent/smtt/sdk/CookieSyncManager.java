package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CookieSyncManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static android.webkit.CookieSyncManager f805a = null;
    private static com.tencent.smtt.sdk.CookieSyncManager b = null;
    private static boolean c = false;

    private CookieSyncManager(android.content.Context context) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            return;
        }
        uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new java.lang.Class[]{android.content.Context.class}, context);
        c = true;
    }

    public static synchronized com.tencent.smtt.sdk.CookieSyncManager createInstance(android.content.Context context) {
        f805a = android.webkit.CookieSyncManager.createInstance(context);
        if (b == null || !c) {
            b = new com.tencent.smtt.sdk.CookieSyncManager(context.getApplicationContext());
        }
        return b;
    }

    public static synchronized com.tencent.smtt.sdk.CookieSyncManager getInstance() {
        com.tencent.smtt.sdk.CookieSyncManager cookieSyncManager;
        cookieSyncManager = b;
        if (cookieSyncManager == null) {
            throw new java.lang.IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        }
        return cookieSyncManager;
    }

    public void startSync() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA != null && uVarA.b()) {
            uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new java.lang.Class[0], new java.lang.Object[0]);
            return;
        }
        f805a.startSync();
        try {
            java.lang.reflect.Field declaredField = java.lang.Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
            declaredField.setAccessible(true);
            ((java.lang.Thread) declaredField.get(f805a)).setUncaughtExceptionHandler(new com.tencent.smtt.sdk.e());
        } catch (java.lang.Exception unused) {
        }
    }

    public void stopSync() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            f805a.stopSync();
        } else {
            uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new java.lang.Class[0], new java.lang.Object[0]);
        }
    }

    public void sync() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            f805a.sync();
        } else {
            uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new java.lang.Class[0], new java.lang.Object[0]);
        }
    }
}
