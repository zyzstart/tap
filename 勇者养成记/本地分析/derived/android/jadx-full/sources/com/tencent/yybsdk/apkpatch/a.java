package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends java.util.concurrent.FutureTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.tencent.yybsdk.apkpatch.j f1390a;
    public boolean b;

    public a(com.tencent.yybsdk.apkpatch.j jVar) {
        super(jVar);
        this.b = false;
        this.f1390a = jVar;
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.f1390a.d();
        return super.cancel(z);
    }
}
