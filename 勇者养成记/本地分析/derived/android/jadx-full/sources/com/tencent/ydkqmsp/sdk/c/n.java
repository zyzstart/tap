package com.tencent.ydkqmsp.sdk.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.concurrent.atomic.AtomicInteger f1332a = new java.util.concurrent.atomic.AtomicInteger(0);

    public boolean a() {
        int i;
        do {
            i = this.f1332a.get();
            if ((i & 1) != 0) {
                return false;
            }
        } while (!this.f1332a.compareAndSet(i, i + 2));
        return true;
    }

    public void b() {
        int i;
        do {
            i = this.f1332a.get();
            if ((i & (-2)) == 0) {
                return;
            }
            if ((i & 1) != 0) {
                if ((this.f1332a.addAndGet(-2) & (-2)) == 0) {
                    synchronized (this.f1332a) {
                        this.f1332a.notifyAll();
                    }
                    return;
                }
                return;
            }
        } while (!this.f1332a.compareAndSet(i, i - 2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void c() {
        int i;
        if (this.f1332a.compareAndSet(0, 1) || this.f1332a.compareAndSet(1, 1)) {
            return;
        }
        do {
            i = this.f1332a.get();
        } while (!this.f1332a.compareAndSet(i, i | 1));
        synchronized (this.f1332a) {
            try {
                this.f1332a.wait();
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
