package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c {
    protected com.unity3d.player.f b;
    protected java.lang.String e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.unity3d.player.o f1628a = null;
    protected android.content.Context c = null;
    protected java.lang.String d = null;

    c(java.lang.String str, com.unity3d.player.f fVar) {
        this.b = null;
        this.e = "";
        this.e = str;
        this.b = fVar;
    }

    protected void reportError(java.lang.String str) {
        com.unity3d.player.f fVar = this.b;
        if (fVar != null) {
            fVar.reportError(this.e + " Error [" + this.d + "]", str);
            return;
        }
        com.unity3d.player.g.Log(6, this.e + " Error [" + this.d + "]: " + str);
    }

    protected void runOnUiThread(java.lang.Runnable runnable) {
        android.content.Context context = this.c;
        if (context instanceof android.app.Activity) {
            ((android.app.Activity) context).runOnUiThread(runnable);
            return;
        }
        com.unity3d.player.g.Log(5, "Not running " + this.e + " from an Activity; Ignoring execution request...");
    }

    protected boolean runOnUiThreadWithSync(final java.lang.Runnable runnable) {
        if (android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread()) {
            runnable.run();
            return true;
        }
        final java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(0);
        runOnUiThread(new java.lang.Runnable() { // from class: com.unity3d.player.c.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    try {
                        runnable.run();
                    } catch (java.lang.Exception e) {
                        com.unity3d.player.c.this.reportError("Exception unloading Google VR on UI Thread. " + e.getLocalizedMessage());
                    }
                } finally {
                    semaphore.release();
                }
            }
        });
        try {
            if (semaphore.tryAcquire(4L, java.util.concurrent.TimeUnit.SECONDS)) {
                return true;
            }
            reportError("Timeout waiting for vr state change!");
            return false;
        } catch (java.lang.InterruptedException e) {
            reportError("Interrupted while trying to acquire sync lock. " + e.getLocalizedMessage());
            return false;
        }
    }
}
