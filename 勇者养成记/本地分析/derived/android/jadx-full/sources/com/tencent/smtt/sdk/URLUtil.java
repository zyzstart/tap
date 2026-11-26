package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class URLUtil {
    public static java.lang.String composeSearchUrl(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.composeSearchUrl(str, str2, str3) : uVarA.c().a(str, str2, str3);
    }

    public static byte[] decode(byte[] bArr) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.decode(bArr) : uVarA.c().a(bArr);
    }

    public static final java.lang.String guessFileName(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.guessFileName(str, str2, str3) : uVarA.c().b(str, str2, str3);
    }

    public static java.lang.String guessUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.guessUrl(str) : uVarA.c().m(str);
    }

    public static boolean isAboutUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.isAboutUrl(str) : uVarA.c().q(str);
    }

    public static boolean isAssetUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.isAssetUrl(str) : uVarA.c().n(str);
    }

    public static boolean isContentUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.isContentUrl(str) : uVarA.c().w(str);
    }

    @java.lang.Deprecated
    public static boolean isCookielessProxyUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.isCookielessProxyUrl(str) : uVarA.c().o(str);
    }

    public static boolean isDataUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.isDataUrl(str) : uVarA.c().r(str);
    }

    public static boolean isFileUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.isFileUrl(str) : uVarA.c().p(str);
    }

    public static boolean isHttpUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.isHttpUrl(str) : uVarA.c().t(str);
    }

    public static boolean isHttpsUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.isHttpsUrl(str) : uVarA.c().u(str);
    }

    public static boolean isJavaScriptUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.isJavaScriptUrl(str) : uVarA.c().s(str);
    }

    public static boolean isNetworkUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.isNetworkUrl(str) : uVarA.c().v(str);
    }

    public static boolean isValidUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.isValidUrl(str) : uVarA.c().x(str);
    }

    public static java.lang.String stripAnchor(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.URLUtil.stripAnchor(str) : uVarA.c().y(str);
    }
}
