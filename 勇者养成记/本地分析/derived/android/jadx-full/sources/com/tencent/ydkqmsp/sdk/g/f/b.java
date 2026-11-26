package com.tencent.ydkqmsp.sdk.g.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final android.net.Uri f1373a = android.net.Uri.parse("content://cn.nubia.identity/identity");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.StringBuilder] */
    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        java.lang.Exception e;
        android.os.Bundle bundleCall;
        java.lang.String str2;
        ?? sb;
        ?? r0 = 0;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                android.content.ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f1373a);
                bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("getAAID", str, null);
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    if (android.os.Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    } else {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                bundleCall = context.getContentResolver().call(f1373a, "getAAID", str, (android.os.Bundle) null);
            }
            ?? string = bundleCall.getInt("code", -1);
            try {
                if (string == 0) {
                    str2 = "NubiaLog succeed:";
                    string = bundleCall.getString("id");
                    sb = new java.lang.StringBuilder();
                } else {
                    str2 = "NubiaLog failed:";
                    string = bundleCall.getString("message");
                    sb = new java.lang.StringBuilder();
                }
                sb.append(str2);
                sb.append(string);
                com.tencent.ydkqmsp.sdk.base.c.c(sb.toString());
                return string;
            } catch (java.lang.Exception e2) {
                e = e2;
                r0 = string;
                ?? r3 = r0;
                e.printStackTrace();
                return r3;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
        }
    }

    public static boolean a(android.content.Context context) {
        android.os.Bundle bundleCall;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                android.content.ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f1373a);
                bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("isSupport", null, null);
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    if (android.os.Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    } else {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                bundleCall = context.getContentResolver().call(f1373a, "isSupport", (java.lang.String) null, (android.os.Bundle) null);
            }
            if (bundleCall.getInt("code", -1) == 0) {
                com.tencent.ydkqmsp.sdk.base.c.c("NubiaLog succeed");
                return bundleCall.getBoolean("issupport", true);
            }
            java.lang.String string = bundleCall.getString("message");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("NubiaLog failed:");
            sb.append(string);
            com.tencent.ydkqmsp.sdk.base.c.c(sb.toString());
            return false;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v6, types: [int] */
    /* JADX WARN: Type inference failed for: r5v7 */
    public static java.lang.String b(android.content.Context context) {
        android.os.Bundle bundleCall;
        java.lang.String str;
        ?? sb;
        ?? r0 = 0;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                android.content.ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f1373a);
                bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("getOAID", null, null);
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    if (android.os.Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    } else {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                bundleCall = context.getContentResolver().call(f1373a, "getOAID", (java.lang.String) null, (android.os.Bundle) null);
            }
            ?? r5 = bundleCall.getInt("code", -1);
            try {
                if (r5 == 0) {
                    java.lang.String string = bundleCall.getString("id");
                    str = "NubiaLog succeed:";
                    sb = new java.lang.StringBuilder();
                    r5 = string;
                } else {
                    java.lang.String string2 = bundleCall.getString("message");
                    str = "NubiaLog failed:";
                    sb = new java.lang.StringBuilder();
                    r5 = string2;
                }
                sb.append(str);
                sb.append(r5);
                com.tencent.ydkqmsp.sdk.base.c.c(sb.toString());
                return r5;
            } catch (java.lang.Exception e) {
                r0 = r5;
                e = e;
                e.printStackTrace();
                return r0;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }
}
