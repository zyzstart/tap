package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bb extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.util.concurrent.BlockingQueue f1483a;
    final /* synthetic */ android.content.Context b;
    final /* synthetic */ com.unisound.common.bd c;
    final /* synthetic */ com.unisound.common.ba d;

    bb(com.unisound.common.ba baVar, java.util.concurrent.BlockingQueue blockingQueue, android.content.Context context, com.unisound.common.bd bdVar) {
        this.d = baVar;
        this.f1483a = blockingQueue;
        this.b = context;
        this.c = bdVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.unisound.common.y.c("WakeupWordCacheAndUpload uploadWakeup");
        try {
            java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue();
            linkedBlockingQueue.addAll(this.f1483a);
            if (this.d.c(this.b, this.c, this.f1483a)) {
                com.unisound.common.y.c("WakeupWordCacheAndUpload uploadWakeup success!");
            } else {
                com.unisound.common.y.a("WakeupWordCacheAndUpload uploadWakeup error occur,save to cache!");
                this.d.b(this.b, this.c, (java.util.concurrent.BlockingQueue<byte[]>) linkedBlockingQueue);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
