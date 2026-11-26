package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WebStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.smtt.sdk.WebStorage f886a;

    @java.lang.Deprecated
    public interface QuotaUpdater {
        void updateQuota(long j);
    }

    private static synchronized com.tencent.smtt.sdk.WebStorage a() {
        if (f886a == null) {
            f886a = new com.tencent.smtt.sdk.WebStorage();
        }
        return f886a;
    }

    public static com.tencent.smtt.sdk.WebStorage getInstance() {
        return a();
    }

    public void deleteAllData() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebStorage.getInstance().deleteAllData();
        } else {
            uVarA.c().n();
        }
    }

    public void deleteOrigin(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebStorage.getInstance().deleteOrigin(str);
        } else {
            uVarA.c().e(str);
        }
    }

    public void getOrigins(com.tencent.smtt.sdk.ValueCallback valueCallback) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
        } else {
            uVarA.c().a(valueCallback);
        }
    }

    public void getQuotaForOrigin(java.lang.String str, com.tencent.smtt.sdk.ValueCallback valueCallback) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
        } else {
            uVarA.c().b(str, valueCallback);
        }
    }

    public void getUsageForOrigin(java.lang.String str, com.tencent.smtt.sdk.ValueCallback valueCallback) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
        } else {
            uVarA.c().a(str, valueCallback);
        }
    }

    @java.lang.Deprecated
    public void setQuotaForOrigin(java.lang.String str, long j) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j);
        } else {
            uVarA.c().a(str, j);
        }
    }
}
