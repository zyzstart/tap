package com.tencent.hlyyb.downloader.e.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.List f621a = new java.util.ArrayList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final java.lang.String a() {
        synchronized (this.f621a) {
            if (this.f621a.size() == 0) {
                return "";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.Iterator it = this.f621a.iterator();
            while (it.hasNext()) {
                sb.append(((com.tencent.hlyyb.downloader.e.c.b) it.next()).a());
                sb.append(";");
            }
            return sb.toString();
        }
    }

    public final void a(com.tencent.hlyyb.downloader.e.c.b bVar) {
        synchronized (this.f621a) {
            if (this.f621a.size() < 20) {
                this.f621a.add(bVar);
            }
        }
    }
}
