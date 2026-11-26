package com.tencent.hlyyb.downloader.e.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f623a;
    public long b;
    public long c;
    public int d = 0;
    private java.util.List e = new java.util.ArrayList();

    public final java.lang.String a() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator it = this.e.iterator();
        while (it.hasNext()) {
            sb.append((com.tencent.hlyyb.downloader.e.c.d) it.next());
            sb.append(";");
        }
        return sb.toString();
    }

    public final void a(com.tencent.hlyyb.downloader.e.c.d dVar) {
        if (this.e.size() < 20) {
            this.e.add(dVar);
        }
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(!this.f623a ? 1 : 0);
        sb.append(sb2.toString());
        sb.append(",");
        sb.append(this.b);
        sb.append(",");
        sb.append(this.c);
        sb.append(",");
        sb.append(this.d);
        sb.append(";");
        return sb.toString();
    }
}
