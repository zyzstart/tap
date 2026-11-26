package com.tencent.open.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {
    public static int a() {
        int iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (java.lang.String) null).a("Common_HttpRetryCount");
        if (iA == 0) {
            return 2;
        }
        return iA;
    }

    public static int a(java.lang.String str) {
        int iA;
        if (com.tencent.open.utils.f.a() == null || (iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), str).a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return iA;
    }
}
