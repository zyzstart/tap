package com.tencent.tmdownloader.internal.downloadservice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmdownloader.internal.downloadservice.f f1135a;
    protected final java.util.ArrayList b = new java.util.ArrayList();

    protected f() {
    }

    public static com.tencent.tmdownloader.internal.downloadservice.f a() {
        if (f1135a == null) {
            f1135a = new com.tencent.tmdownloader.internal.downloadservice.f();
        }
        return f1135a;
    }

    public synchronized void a(com.tencent.tmdownloader.internal.downloadservice.h hVar) {
        if (!this.b.contains(hVar)) {
            this.b.add(hVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void a(java.lang.String str, int i, int i2, java.lang.String str2) {
        java.util.Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((com.tencent.tmdownloader.internal.downloadservice.h) it.next()).a(str, i, i2, str2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void a(java.lang.String str, long j, long j2) {
        java.util.Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((com.tencent.tmdownloader.internal.downloadservice.h) it.next()).a(str, j, j2);
        }
    }

    public synchronized void b(com.tencent.tmdownloader.internal.downloadservice.h hVar) {
        this.b.remove(hVar);
    }
}
