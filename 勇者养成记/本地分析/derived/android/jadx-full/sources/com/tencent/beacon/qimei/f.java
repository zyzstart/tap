package com.tencent.beacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class f implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.qimei.IAsyncQimeiListener f212a;
    final /* synthetic */ com.tencent.beacon.qimei.QimeiSDK b;

    f(com.tencent.beacon.qimei.QimeiSDK qimeiSDK, com.tencent.beacon.qimei.IAsyncQimeiListener iAsyncQimeiListener) {
        this.b = qimeiSDK;
        this.f212a = iAsyncQimeiListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.mContext != null) {
            com.tencent.beacon.qimei.Qimei qimeiB = com.tencent.beacon.qimei.a.a(this.b.mContext).b();
            if (qimeiB.getQimeiMap() != null && !qimeiB.getQimeiMap().isEmpty()) {
                this.f212a.onQimeiDispatch(qimeiB);
                return;
            }
        }
        if (this.b.isInit()) {
            com.tencent.beacon.qimei.e.a(this.b.mContext).a(this.f212a);
        } else {
            this.b.mListener = this.f212a;
        }
    }
}
