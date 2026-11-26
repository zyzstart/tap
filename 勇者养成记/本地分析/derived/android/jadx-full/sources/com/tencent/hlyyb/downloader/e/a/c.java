package com.tencent.hlyyb.downloader.e.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.hlyyb.downloader.e.a.d f616a;
    private volatile boolean b = false;
    private java.lang.Object c = new java.lang.Object();
    private java.lang.Object d = new java.lang.Object();
    private volatile boolean e = false;

    public c(com.tencent.hlyyb.downloader.e.a.d dVar) {
        this.f616a = dVar;
        new java.lang.Thread(this, "HalleyDownload-SaveThread").start();
    }

    public final void a() {
        synchronized (this.c) {
            if (!this.b) {
                this.b = true;
                this.c.notify();
            }
        }
    }

    public final void b() {
        synchronized (this.c) {
            if (this.b) {
                this.b = false;
            }
        }
    }

    public final void c() {
        try {
            if (this.e) {
                synchronized (this.d) {
                    try {
                        this.d.notify();
                    } catch (java.lang.Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        boolean zE;
        while (true) {
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            try {
                zE = this.f616a.e();
            } catch (java.lang.Throwable unused) {
                zE = false;
            }
            long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (!zE) {
                int i = com.tencent.hlyyb.downloader.a.a.d;
                if (jElapsedRealtime2 > 0) {
                    long j = i;
                    if (jElapsedRealtime2 < j) {
                        int i2 = (int) (j - jElapsedRealtime2);
                        try {
                            this.e = true;
                            synchronized (this.d) {
                                try {
                                    this.d.wait(i2);
                                } catch (java.lang.Throwable th) {
                                    throw th;
                                }
                            }
                        } catch (java.lang.Exception unused2) {
                        } catch (java.lang.Throwable th2) {
                            this.e = false;
                            throw th2;
                        }
                        this.e = false;
                    }
                }
            }
            synchronized (this.c) {
                if (!this.b) {
                    try {
                        this.c.wait();
                    } catch (java.lang.InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
