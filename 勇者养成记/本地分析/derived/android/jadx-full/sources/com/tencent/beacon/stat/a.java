package com.tencent.beacon.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final java.util.concurrent.locks.Lock f214a;
    final java.util.concurrent.locks.Condition b;
    private volatile java.lang.Object c;

    public a() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        this.f214a = reentrantLock;
        this.b = reentrantLock.newCondition();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.lang.Object a() {
        this.f214a.lock();
        while (this.c == null) {
            try {
                this.b.await();
            } catch (java.lang.Throwable th) {
                this.f214a.unlock();
                throw th;
            }
        }
        java.lang.Object obj = this.c;
        this.f214a.unlock();
        return obj;
    }

    public void a(java.lang.Object obj) {
        this.f214a.lock();
        try {
            this.c = obj;
            if (obj != null) {
                this.b.signal();
            }
        } finally {
            this.f214a.unlock();
        }
    }

    public java.lang.Object b() {
        return this.c;
    }
}
