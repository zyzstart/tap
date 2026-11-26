package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DateSorter {
    public static int DAY_COUNT;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.webkit.DateSorter f806a;
    private com.tencent.smtt.export.external.interfaces.IX5DateSorter b;

    static {
        a();
        DAY_COUNT = 5;
    }

    public DateSorter(android.content.Context context) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            this.f806a = new android.webkit.DateSorter(context);
        } else {
            this.b = uVarA.c().h(context);
        }
    }

    private static boolean a() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return uVarA != null && uVarA.b();
    }

    public long getBoundary(int i) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? this.f806a.getBoundary(i) : this.b.getBoundary(i);
    }

    public int getIndex(long j) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? this.f806a.getIndex(j) : this.b.getIndex(j);
    }

    public java.lang.String getLabel(int i) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? this.f806a.getLabel(i) : this.b.getLabel(i);
    }
}
