package com.tencent.hlyyb.downloader.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f602a;
    public long b;

    public b(long j, long j2) {
        this.f602a = 0L;
        this.b = 0L;
        this.f602a = j;
        this.b = j2;
    }

    public final boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.tencent.hlyyb.downloader.a.a.b)) {
            return false;
        }
        com.tencent.hlyyb.downloader.a.a.b bVar = (com.tencent.hlyyb.downloader.a.a.b) obj;
        return this.f602a == bVar.f602a && this.b == bVar.b;
    }

    public final java.lang.String toString() {
        return "[" + this.f602a + "," + this.b + "]";
    }
}
