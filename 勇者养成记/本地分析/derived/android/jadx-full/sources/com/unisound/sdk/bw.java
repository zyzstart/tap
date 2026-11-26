package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bw extends java.util.TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ cn.yunzhisheng.tts.JniClient f1544a;
    final /* synthetic */ com.unisound.sdk.bv b;

    bw(com.unisound.sdk.bv bvVar, cn.yunzhisheng.tts.JniClient jniClient) {
        this.b = bvVar;
        this.f1544a = jniClient;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.b.c == null) {
            this.f1544a.c();
            this.b.k();
            this.b.j();
        }
    }
}
