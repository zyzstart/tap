package com.tencent.ydkqmsp.sdk.g.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    public static java.lang.String a(android.content.Context context) {
        if (com.tencent.ydkqmsp.sdk.g.g.a.f1374a) {
            return com.tencent.ydkqmsp.sdk.g.g.e.f.a(com.tencent.ydkqmsp.sdk.g.g.a.a(context), "AUID");
        }
        throw new java.lang.RuntimeException("SDK Need Init First!");
    }

    public static boolean a() {
        if (com.tencent.ydkqmsp.sdk.g.g.a.f1374a) {
            return com.tencent.ydkqmsp.sdk.g.g.a.b;
        }
        throw new java.lang.RuntimeException("SDK Need Init First!");
    }

    public static java.lang.String b(android.content.Context context) {
        if (com.tencent.ydkqmsp.sdk.g.g.a.f1374a) {
            return com.tencent.ydkqmsp.sdk.g.g.e.f.a(com.tencent.ydkqmsp.sdk.g.g.a.a(context), "OUID");
        }
        throw new java.lang.RuntimeException("SDK Need Init First!");
    }

    public static void c(android.content.Context context) {
        com.tencent.ydkqmsp.sdk.g.g.a.b = com.tencent.ydkqmsp.sdk.g.g.e.f.a(com.tencent.ydkqmsp.sdk.g.g.a.a(context));
        com.tencent.ydkqmsp.sdk.g.g.a.f1374a = true;
    }
}
