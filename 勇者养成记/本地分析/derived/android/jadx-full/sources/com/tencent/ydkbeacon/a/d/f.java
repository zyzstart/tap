package com.tencent.ydkbeacon.a.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class f implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f1195a;
    final /* synthetic */ com.tencent.ydkbeacon.a.d.g b;

    f(com.tencent.ydkbeacon.a.d.g gVar, java.lang.Runnable runnable) {
        this.b = gVar;
        this.f1195a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.b) {
            java.nio.channels.FileLock fileLockLock = null;
            try {
                try {
                    fileLockLock = this.b.f1196a.lock();
                    this.f1195a.run();
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (java.io.IOException unused) {
                        }
                    }
                } catch (java.lang.Exception e) {
                    java.lang.Object[] objArr = new java.lang.Object[1];
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("file get lock error:");
                    sb.append(e.getMessage());
                    objArr[0] = sb.toString();
                    com.tencent.ydkbeacon.a.e.c.b("[properties]", objArr);
                    com.tencent.ydkbeacon.a.b.d.b().a("504", "[properties] File get lock error!", e);
                    if (fileLockLock != null) {
                    }
                }
            } catch (java.lang.Throwable th) {
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (java.io.IOException unused2) {
                    }
                }
                throw th;
            }
        }
    }
}
