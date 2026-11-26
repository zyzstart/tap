package com.tencent.tmselfupdatesdk.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Context f1154a;
    final /* synthetic */ com.tencent.tmselfupdatesdk.b.f b;

    g(com.tencent.tmselfupdatesdk.b.f fVar, android.content.Context context) {
        this.b = fVar;
        this.f1154a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.c(this.f1154a);
    }
}
