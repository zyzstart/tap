package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class CacheManager {
    @java.lang.Deprecated
    public static boolean cacheDisabled() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA != null && uVarA.b()) {
            return ((java.lang.Boolean) uVarA.c().c()).booleanValue();
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a("android.webkit.CacheManager", "cacheDisabled");
        if (objA == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    public static java.io.InputStream getCacheFile(java.lang.String str, boolean z) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            return null;
        }
        return uVarA.c().a(str, z);
    }

    public static java.lang.Object getCacheFile(java.lang.String str, java.util.Map map) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA != null && uVarA.b()) {
            return uVarA.c().g();
        }
        try {
            return com.tencent.smtt.utils.k.a((java.lang.Class) java.lang.Class.forName("android.webkit.CacheManager"), "getCacheFile", new java.lang.Class[]{java.lang.String.class, java.util.Map.class}, str, map);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @java.lang.Deprecated
    public static java.io.File getCacheFileBaseDir() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (java.io.File) ((uVarA == null || !uVarA.b()) ? com.tencent.smtt.utils.k.a("android.webkit.CacheManager", "getCacheFileBaseDir") : uVarA.c().g());
    }
}
