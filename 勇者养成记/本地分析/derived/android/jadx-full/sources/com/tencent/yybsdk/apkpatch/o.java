package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class o implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.yybsdk.apkpatch.j f1437a;
    private com.tencent.yybsdk.apkpatch.n b;

    o(com.tencent.yybsdk.apkpatch.j jVar, com.tencent.yybsdk.apkpatch.n nVar) {
        this.f1437a = jVar;
        this.b = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1437a.a(this.b);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
