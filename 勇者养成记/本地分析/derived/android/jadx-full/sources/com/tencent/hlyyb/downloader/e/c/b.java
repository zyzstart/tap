package com.tencent.hlyyb.downloader.e.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f622a;
    private int b;
    private java.lang.String c;

    public b(long j, int i, java.lang.String str) {
        this.f622a = j;
        this.b = i;
        this.c = android.text.TextUtils.isEmpty(str) ? "" : com.tencent.hlyyb.common.f.c.b(str);
    }

    public final java.lang.String a() {
        return this.f622a + "," + this.b + "," + this.c;
    }
}
