package com.tencent.hlyyb.downloader.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class f implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ com.tencent.hlyyb.downloader.e.e f632a;
    private /* synthetic */ com.tencent.hlyyb.downloader.e.c b;

    f(com.tencent.hlyyb.downloader.e.c cVar, com.tencent.hlyyb.downloader.e.e eVar) {
        this.b = cVar;
        this.f632a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (com.tencent.hlyyb.downloader.e.d.b[this.f632a.ordinal()]) {
            case 1:
                com.tencent.hlyyb.downloader.c.b.a().onTaskPendingMainloop(this.b.f620a);
                synchronized (this.b.d) {
                    for (com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener : this.b.d) {
                        if (downloaderTaskListener != null) {
                            downloaderTaskListener.onTaskPendingMainloop(this.b.f620a);
                        }
                    }
                    break;
                }
                return;
            case 2:
                com.tencent.hlyyb.downloader.c.b.a().onTaskStartedMainloop(this.b.f620a);
                synchronized (this.b.d) {
                    for (com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener2 : this.b.d) {
                        if (downloaderTaskListener2 != null) {
                            downloaderTaskListener2.onTaskStartedMainloop(this.b.f620a);
                        }
                    }
                    break;
                }
                return;
            case 3:
                com.tencent.hlyyb.downloader.c.b.a().onTaskDetectedMainloop(this.b.f620a);
                synchronized (this.b.d) {
                    for (com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener3 : this.b.d) {
                        if (downloaderTaskListener3 != null) {
                            downloaderTaskListener3.onTaskDetectedMainloop(this.b.f620a);
                        }
                    }
                    break;
                }
                return;
            case 4:
                com.tencent.hlyyb.downloader.c.b.a().onTaskReceivedMainloop(this.b.f620a);
                synchronized (this.b.d) {
                    for (com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener4 : this.b.d) {
                        if (downloaderTaskListener4 != null) {
                            downloaderTaskListener4.onTaskReceivedMainloop(this.b.f620a);
                        }
                    }
                    break;
                }
                return;
            case 5:
                com.tencent.hlyyb.downloader.c.b.a().onTaskPausedMainloop(this.b.f620a);
                synchronized (this.b.d) {
                    for (com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener5 : this.b.d) {
                        if (downloaderTaskListener5 != null) {
                            downloaderTaskListener5.onTaskPausedMainloop(this.b.f620a);
                        }
                    }
                    break;
                }
                return;
            case 6:
                com.tencent.hlyyb.downloader.c.b.a().onTaskFailedMainloop(this.b.f620a);
                synchronized (this.b.d) {
                    for (com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener6 : this.b.d) {
                        if (downloaderTaskListener6 != null) {
                            downloaderTaskListener6.onTaskFailedMainloop(this.b.f620a);
                        }
                    }
                    break;
                }
                return;
            case 7:
                com.tencent.hlyyb.downloader.c.b.a().onTaskCompletedMainloop(this.b.f620a);
                synchronized (this.b.d) {
                    for (com.tencent.hlyyb.downloader.DownloaderTaskListener downloaderTaskListener7 : this.b.d) {
                        if (downloaderTaskListener7 != null) {
                            downloaderTaskListener7.onTaskCompletedMainloop(this.b.f620a);
                        }
                    }
                    break;
                }
                return;
            default:
                return;
        }
    }
}
