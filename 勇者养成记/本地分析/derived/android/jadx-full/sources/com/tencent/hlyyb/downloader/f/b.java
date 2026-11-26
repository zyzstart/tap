package com.tencent.hlyyb.downloader.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class b implements com.tencent.hlyyb.common.a.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.concurrent.Future f640a;

    public b(java.util.concurrent.Future future) {
        this.f640a = future;
    }

    @Override // com.tencent.hlyyb.common.a.m
    public final boolean a() {
        java.util.concurrent.Future future = this.f640a;
        if (future != null) {
            try {
                return future.cancel(false);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
