package com.tencent.ydkbeacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.qimei.IAsyncQimeiListener f1283a;
    final /* synthetic */ com.tencent.ydkbeacon.qimei.QimeiSDK b;

    d(com.tencent.ydkbeacon.qimei.QimeiSDK qimeiSDK, com.tencent.ydkbeacon.qimei.IAsyncQimeiListener iAsyncQimeiListener) {
        this.b = qimeiSDK;
        this.f1283a = iAsyncQimeiListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.b.qimeiListeners) {
            com.tencent.ydkbeacon.qimei.Qimei qimei = this.b.getQimei();
            if (qimei == null || qimei.isEmpty()) {
                this.b.qimeiListeners.add(this.f1283a);
                return;
            }
            try {
                this.f1283a.onQimeiDispatch(qimei);
            } catch (java.lang.Throwable th) {
                this.b.logQimeiCallbackError(th);
            }
        }
    }
}
