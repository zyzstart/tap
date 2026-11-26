package com.tencent.bugly.crashreport.crash;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a implements java.lang.Comparable<com.tencent.bugly.crashreport.crash.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f300a = -1;
    public long b = -1;
    public java.lang.String c = null;
    public boolean d = false;
    public boolean e = false;
    public int f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(com.tencent.bugly.crashreport.crash.a aVar) {
        com.tencent.bugly.crashreport.crash.a aVar2 = aVar;
        if (aVar2 == null) {
            return 1;
        }
        long j = this.b - aVar2.b;
        if (j <= 0) {
            return j < 0 ? -1 : 0;
        }
        return 1;
    }
}
