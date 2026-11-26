package com.tencent.yybsdk.apkpatch.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b extends com.tencent.yybsdk.apkpatch.d.a {
    java.util.concurrent.ScheduledExecutorService d;
    android.util.SparseArray e;
    final int f = 3;
    boolean g = false;

    public b() {
        this.d = null;
        this.e = null;
        this.d = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();
        this.e = new android.util.SparseArray();
    }

    @Override // com.tencent.yybsdk.apkpatch.d.a
    public synchronized void a(java.lang.Runnable runnable) {
        if (this.g) {
            com.tencent.yybsdk.apkpatch.f.a.b("AsyncTaskHandlerAbs", "ScheduleTaskHandlerImp was closed , should not post!");
        } else if (runnable == null) {
            com.tencent.yybsdk.apkpatch.f.a.b("AsyncTaskHandlerAbs", "task runner should not be null");
        } else {
            this.d.execute(runnable);
        }
    }
}
