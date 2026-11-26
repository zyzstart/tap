package com.tencent.hlyyb.downloader.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.List f603a = new java.util.ArrayList();

    public final int a() {
        return this.f603a.size();
    }

    public final void a(com.tencent.hlyyb.downloader.a.a.b bVar) {
        boolean z;
        java.util.Iterator it = this.f603a.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (((com.tencent.hlyyb.downloader.a.a.b) it.next()).equals(bVar)) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        this.f603a.add(bVar);
    }

    public final com.tencent.hlyyb.downloader.a.a.b b() {
        if (this.f603a.size() == 0) {
            return null;
        }
        return (com.tencent.hlyyb.downloader.a.a.b) this.f603a.get(0);
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("bytes=");
        for (com.tencent.hlyyb.downloader.a.a.b bVar : this.f603a) {
            sb.append(bVar.f602a);
            sb.append("-");
            long j = bVar.b;
            if (j != -1) {
                sb.append(j);
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
