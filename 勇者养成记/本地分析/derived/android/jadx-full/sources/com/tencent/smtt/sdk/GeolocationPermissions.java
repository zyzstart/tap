package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GeolocationPermissions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.smtt.sdk.GeolocationPermissions f807a;

    private static synchronized com.tencent.smtt.sdk.GeolocationPermissions a() {
        if (f807a == null) {
            f807a = new com.tencent.smtt.sdk.GeolocationPermissions();
        }
        return f807a;
    }

    public static com.tencent.smtt.sdk.GeolocationPermissions getInstance() {
        return a();
    }

    public void allow(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.GeolocationPermissions.getInstance().allow(str);
        } else {
            uVarA.c().g(str);
        }
    }

    public void clear(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.GeolocationPermissions.getInstance().clear(str);
        } else {
            uVarA.c().f(str);
        }
    }

    public void clearAll() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.GeolocationPermissions.getInstance().clearAll();
        } else {
            uVarA.c().o();
        }
    }

    public void getAllowed(java.lang.String str, com.tencent.smtt.sdk.ValueCallback valueCallback) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
        } else {
            uVarA.c().c(str, valueCallback);
        }
    }

    public void getOrigins(com.tencent.smtt.sdk.ValueCallback valueCallback) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
        } else {
            uVarA.c().b(valueCallback);
        }
    }
}
