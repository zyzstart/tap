package com.tencent.hlyyb.downloader.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.hlyyb.downloader.e.h f620a;
    private volatile com.tencent.hlyyb.downloader.DownloaderTaskStatus b = com.tencent.hlyyb.downloader.DownloaderTaskStatus.PENDING;
    private java.util.Vector c = new java.util.Vector();
    private java.util.Vector d = new java.util.Vector();
    private int e = 0;
    private volatile boolean f = false;
    private java.util.concurrent.LinkedBlockingQueue g = new java.util.concurrent.LinkedBlockingQueue();

    public c(com.tencent.hlyyb.downloader.e.h hVar) {
        this.f620a = hVar;
    }

    private synchronized void a(com.tencent.hlyyb.downloader.DownloaderTaskStatus downloaderTaskStatus, boolean z) {
        if ((this.b == com.tencent.hlyyb.downloader.DownloaderTaskStatus.COMPLETE || this.b == com.tencent.hlyyb.downloader.DownloaderTaskStatus.FAILED || this.b == com.tencent.hlyyb.downloader.DownloaderTaskStatus.PAUSED || this.b == com.tencent.hlyyb.downloader.DownloaderTaskStatus.DELETED) && downloaderTaskStatus != com.tencent.hlyyb.downloader.DownloaderTaskStatus.PENDING) {
            return;
        }
        this.b = downloaderTaskStatus;
        com.tencent.hlyyb.downloader.e.e eVar = null;
        switch (com.tencent.hlyyb.downloader.e.d.f625a[downloaderTaskStatus.ordinal()]) {
            case 1:
                eVar = com.tencent.hlyyb.downloader.e.e.Inform_Pending;
                break;
            case 2:
                eVar = com.tencent.hlyyb.downloader.e.e.Inform_Started;
                break;
            case 3:
                eVar = com.tencent.hlyyb.downloader.e.e.Inform_Received;
                break;
            case 4:
                eVar = com.tencent.hlyyb.downloader.e.e.Inform_Succeed;
                break;
            case 5:
                eVar = com.tencent.hlyyb.downloader.e.e.Inform_Failed;
                break;
            case 6:
                eVar = com.tencent.hlyyb.downloader.e.e.Inform_Paused;
                break;
            case 7:
                eVar = com.tencent.hlyyb.downloader.e.e.Inform_Deleted;
                break;
        }
        a(eVar);
    }

    public final com.tencent.hlyyb.downloader.DownloaderTaskStatus a() {
        return this.b;
    }

    public final void a(com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener) {
        if (downloaderTaskListener == null) {
            return;
        }
        try {
            synchronized (this.c) {
                if (!this.c.contains(downloaderTaskListener)) {
                    this.c.add(downloaderTaskListener);
                }
            }
            synchronized (this.d) {
                if (!this.d.contains(downloaderTaskListener)) {
                    this.d.add(downloaderTaskListener);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final synchronized void a(com.tencent.hlyyb.downloader.DownloaderTaskStatus downloaderTaskStatus) {
        a(downloaderTaskStatus, true);
    }

    public final void a(com.tencent.hlyyb.downloader.e.e eVar) {
        if (eVar != null) {
            if (eVar != null && eVar != com.tencent.hlyyb.downloader.e.e.Inform_Deleted) {
                com.tencent.hlyyb.common.a.i().post(new com.tencent.hlyyb.downloader.e.f(this, eVar));
            }
            if (eVar != null) {
                try {
                    this.g.put(eVar);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void b() {
        synchronized (this.c) {
            this.c.clear();
        }
        synchronized (this.d) {
            this.d.clear();
        }
    }

    public final void b(com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener) {
        if (downloaderTaskListener == null) {
            return;
        }
        try {
            synchronized (this.c) {
                if (this.c.contains(downloaderTaskListener)) {
                    this.c.remove(downloaderTaskListener);
                }
            }
            synchronized (this.d) {
                if (this.d.contains(downloaderTaskListener)) {
                    this.d.remove(downloaderTaskListener);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final synchronized void c() {
        this.g.clear();
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0150  */
    /* JADX WARN: Code duplicated, block: B:124:0x014d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x0003 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        this.f = true;
        while (true) {
            try {
                switch (com.tencent.hlyyb.downloader.e.d.b[((com.tencent.hlyyb.downloader.e.e) this.g.take()).ordinal()]) {
                    case 2:
                        com.tencent.hlyyb.downloader.c.b.a().onTaskStartedSubloop(this.f620a);
                        synchronized (this.c) {
                            for (com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener : this.c) {
                                if (downloaderTaskListener != null) {
                                    downloaderTaskListener.onTaskStartedSubloop(this.f620a);
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                        break;
                    case 3:
                        com.tencent.hlyyb.downloader.c.b.a().onTaskDetectedSubloop(this.f620a);
                        synchronized (this.c) {
                            for (com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener2 : this.c) {
                                if (downloaderTaskListener2 != null) {
                                    downloaderTaskListener2.onTaskDetectedSubloop(this.f620a);
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                        break;
                    case 4:
                        com.tencent.hlyyb.downloader.c.b.a().onTaskReceivedSubloop(this.f620a);
                        synchronized (this.c) {
                            for (com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener3 : this.c) {
                                if (downloaderTaskListener3 != null) {
                                    downloaderTaskListener3.onTaskReceivedSubloop(this.f620a);
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                        break;
                    case 5:
                        com.tencent.hlyyb.downloader.c.b.a().onTaskPausedSubloop(this.f620a);
                        synchronized (this.c) {
                            for (com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener4 : this.c) {
                                if (downloaderTaskListener4 != null) {
                                    downloaderTaskListener4.onTaskPausedSubloop(this.f620a);
                                }
                            }
                        }
                        z2 = true;
                        if (z2) {
                        }
                        break;
                    case 6:
                        com.tencent.hlyyb.downloader.c.b.a().onTaskFailedSubloop(this.f620a);
                        synchronized (this.c) {
                            for (com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener5 : this.c) {
                                if (downloaderTaskListener5 != null) {
                                    downloaderTaskListener5.onTaskFailedSubloop(this.f620a);
                                }
                            }
                        }
                        z2 = true;
                        if (z2) {
                        }
                        break;
                    case 7:
                        try {
                            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                            synchronized (this.c) {
                                for (com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener6 : this.c) {
                                    if (downloaderTaskListener6 != null) {
                                        downloaderTaskListener6.onTaskCompletedSubloop(this.f620a);
                                    }
                                }
                            }
                            this.e = (int) (android.os.SystemClock.elapsedRealtime() - jElapsedRealtime);
                            this.f620a.t();
                            android.os.SystemClock.elapsedRealtime();
                            com.tencent.hlyyb.downloader.c.b.a().onTaskCompletedSubloop(this.f620a);
                            z2 = true;
                            if (z2) {
                            }
                        } catch (java.lang.InterruptedException e) {
                            e = e;
                            z = true;
                            try {
                                e.printStackTrace();
                                if (z) {
                                }
                            } catch (java.lang.Throwable th) {
                                th = th;
                                z3 = z;
                                if (!z3) {
                                    throw th;
                                }
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            if (!z3) {
                                throw th;
                            }
                        }
                        break;
                    case 8:
                        z2 = true;
                        if (z2) {
                        }
                        break;
                    default:
                        z2 = false;
                        if (z2) {
                        }
                        break;
                }
            } catch (java.lang.InterruptedException e2) {
                e = e2;
                z = false;
            } catch (java.lang.Throwable th3) {
                th = th3;
                z3 = false;
            }
        }
        this.f = false;
    }

    public final boolean e() {
        return this.f;
    }

    public final int f() {
        return this.e;
    }
}
