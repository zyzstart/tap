package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class m implements java.util.concurrent.Callable<java.lang.Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.common.l f1495a;

    m(com.unisound.common.l lVar) {
        this.f1495a = lVar;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.Void call() {
        synchronized (this.f1495a) {
            if (this.f1495a.s == null) {
                return null;
            }
            this.f1495a.n();
            if (this.f1495a.l()) {
                this.f1495a.k();
                this.f1495a.u = 0;
            }
            return null;
        }
    }
}
