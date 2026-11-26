package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WebViewDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.smtt.sdk.WebViewDatabase f899a;
    private android.content.Context b;

    protected WebViewDatabase(android.content.Context context) {
        this.b = context;
    }

    private static synchronized com.tencent.smtt.sdk.WebViewDatabase a(android.content.Context context) {
        if (f899a == null) {
            f899a = new com.tencent.smtt.sdk.WebViewDatabase(context);
        }
        return f899a;
    }

    public static com.tencent.smtt.sdk.WebViewDatabase getInstance(android.content.Context context) {
        return a(context);
    }

    public void clearFormData() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearFormData();
        } else {
            uVarA.c().g(this.b);
        }
    }

    public void clearHttpAuthUsernamePassword() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearHttpAuthUsernamePassword();
        } else {
            uVarA.c().e(this.b);
        }
    }

    @java.lang.Deprecated
    public void clearUsernamePassword() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearUsernamePassword();
        } else {
            uVarA.c().c(this.b);
        }
    }

    public boolean hasFormData() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.WebViewDatabase.getInstance(this.b).hasFormData() : uVarA.c().f(this.b);
    }

    public boolean hasHttpAuthUsernamePassword() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.WebViewDatabase.getInstance(this.b).hasHttpAuthUsernamePassword() : uVarA.c().d(this.b);
    }

    @java.lang.Deprecated
    public boolean hasUsernamePassword() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.WebViewDatabase.getInstance(this.b).hasUsernamePassword() : uVarA.c().b(this.b);
    }
}
