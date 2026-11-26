package com.tencent.open.log;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class Tracer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f707a;
    private volatile boolean b;
    private com.tencent.open.log.g c;

    public Tracer() {
        this(com.tencent.open.log.c.f710a, true, com.tencent.open.log.g.f714a);
    }

    public Tracer(int i, boolean z, com.tencent.open.log.g gVar) {
        this.f707a = com.tencent.open.log.c.f710a;
        this.b = true;
        this.c = com.tencent.open.log.g.f714a;
        a(i);
        a(z);
        a(gVar);
    }

    public void a(int i) {
        this.f707a = i;
    }

    public void a(int i, java.lang.Thread thread, long j, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (d() && com.tencent.open.log.d.a.a(this.f707a, i)) {
            doTrace(i, thread, j, str, str2, th);
        }
    }

    public void a(com.tencent.open.log.g gVar) {
        this.c = gVar;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean d() {
        return this.b;
    }

    protected abstract void doTrace(int i, java.lang.Thread thread, long j, java.lang.String str, java.lang.String str2, java.lang.Throwable th);

    public com.tencent.open.log.g e() {
        return this.c;
    }
}
