package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bc extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Context f1484a;
    final /* synthetic */ com.unisound.common.ba b;

    bc(com.unisound.common.ba baVar, android.content.Context context) {
        this.b = baVar;
        this.f1484a = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.unisound.common.ba baVar;
        android.content.Context context;
        try {
            com.unisound.common.y.c("WakeupWordCacheAndUpload uploadCacheWakeupContent");
            if (!com.unisound.common.ba.b((android.net.ConnectivityManager) this.f1484a.getSystemService("connectivity"))) {
                com.unisound.common.y.a("WakeupWordCacheAndUpload network is not available, do nothing!");
                return;
            }
            for (java.lang.String str : com.unisound.common.ba.c(this.f1484a)) {
                com.unisound.common.bd bdVarG = this.b.g(this.f1484a, str);
                if (bdVarG == null) {
                    baVar = this.b;
                    context = this.f1484a;
                } else {
                    java.util.concurrent.BlockingQueue blockingQueueC = com.unisound.common.ba.c(this.f1484a, str);
                    if (blockingQueueC.isEmpty()) {
                        baVar = this.b;
                        context = this.f1484a;
                    } else if (this.b.c(this.f1484a, bdVarG, blockingQueueC)) {
                        baVar = this.b;
                        context = this.f1484a;
                    }
                }
                baVar.f(context, str);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
