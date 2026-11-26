package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MimeTypeMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.smtt.sdk.MimeTypeMap f817a;

    private MimeTypeMap() {
    }

    public static java.lang.String getFileExtensionFromUrl(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.MimeTypeMap.getFileExtensionFromUrl(str) : uVarA.c().h(str);
    }

    public static synchronized com.tencent.smtt.sdk.MimeTypeMap getSingleton() {
        if (f817a == null) {
            f817a = new com.tencent.smtt.sdk.MimeTypeMap();
        }
        return f817a;
    }

    public java.lang.String getExtensionFromMimeType(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str) : uVarA.c().l(str);
    }

    public java.lang.String getMimeTypeFromExtension(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str) : uVarA.c().j(str);
    }

    public boolean hasExtension(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.MimeTypeMap.getSingleton().hasExtension(str) : uVarA.c().k(str);
    }

    public boolean hasMimeType(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.MimeTypeMap.getSingleton().hasMimeType(str) : uVarA.c().i(str);
    }
}
