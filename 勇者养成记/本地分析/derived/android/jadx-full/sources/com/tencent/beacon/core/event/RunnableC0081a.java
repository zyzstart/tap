package com.tencent.beacon.core.event;

/* JADX INFO: renamed from: com.tencent.beacon.core.event.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class RunnableC0081a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.core.event.C0083c f164a;

    RunnableC0081a(com.tencent.beacon.core.event.C0083c c0083c) {
        this.f164a = c0083c;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f164a.b();
    }
}
