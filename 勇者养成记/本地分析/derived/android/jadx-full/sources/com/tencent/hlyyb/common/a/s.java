package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class s extends java.util.TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ java.lang.Runnable f540a;

    s(com.tencent.hlyyb.common.a.r rVar, java.lang.Runnable runnable) {
        this.f540a = runnable;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f540a.run();
    }
}
