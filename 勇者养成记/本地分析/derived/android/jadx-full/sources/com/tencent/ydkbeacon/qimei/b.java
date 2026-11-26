package com.tencent.ydkbeacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.qimei.c f1281a;

    b(com.tencent.ydkbeacon.qimei.c cVar) {
        this.f1281a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.ydkbeacon.qimei.f.d();
        java.lang.String strA = com.tencent.ydkbeacon.qimei.f.a(this.f1281a.b);
        com.tencent.ydkbeacon.a.e.c.a(com.tencent.ydkbeacon.qimei.QimeiSDK.TAG, "non-main process check local qimei: " + strA, new java.lang.Object[0]);
        if (android.text.TextUtils.isEmpty(strA)) {
            if (this.f1281a.f1282a.getAndIncrement() > 30) {
                return;
            }
            this.f1281a.c();
        } else {
            this.f1281a.a(strA);
            com.tencent.ydkbeacon.qimei.f.a(java.lang.System.currentTimeMillis());
            this.f1281a.d();
        }
    }
}
