package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class bp extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.bg f1540a;

    bp(com.unisound.sdk.bg bgVar) {
        this.f1540a = bgVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (!this.f1540a.aB.a(this.f1540a.f.f1512a) || this.f1540a.aq == null) {
            return;
        }
        this.f1540a.aq.sendEmptyMessage(24);
    }
}
