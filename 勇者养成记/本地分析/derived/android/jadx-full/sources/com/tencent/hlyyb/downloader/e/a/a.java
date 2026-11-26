package com.tencent.hlyyb.downloader.e.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f614a = 0;
    private volatile java.util.LinkedList b = new java.util.LinkedList();
    private java.lang.Object c = new java.lang.Object();

    public final long a() {
        return this.f614a;
    }

    public final void a(int i, long j, byte[] bArr, long j2) {
        synchronized (this.c) {
            java.util.LinkedList linkedList = this.b;
            int i2 = (int) j2;
            byte[] bArr2 = new byte[i2];
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, i2);
            linkedList.addLast(new com.tencent.hlyyb.downloader.e.a.b(i, j, bArr2, j2));
            this.f614a += j2;
        }
    }

    public final com.tencent.hlyyb.downloader.e.a.b b() {
        synchronized (this.c) {
            if (this.b.size() <= 0) {
                return null;
            }
            com.tencent.hlyyb.downloader.e.a.b bVar = (com.tencent.hlyyb.downloader.e.a.b) this.b.removeFirst();
            this.f614a -= bVar.d;
            return bVar;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c() {
        synchronized (this.c) {
            do {
            } while (b() != null);
        }
    }
}
