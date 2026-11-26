package com.tencent.yybsdk.apkpatch.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class e implements java.lang.Runnable {
    protected com.tencent.yybsdk.apkpatch.c.b f;
    protected com.tencent.yybsdk.apkpatch.c.f g;

    public abstract void a(int i);

    public void a(com.tencent.yybsdk.apkpatch.c.b bVar) {
        this.f = bVar;
    }

    public void a(com.tencent.yybsdk.apkpatch.c.f fVar) {
        this.g = fVar;
    }
}
