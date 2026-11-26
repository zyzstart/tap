package com.tencent.hlyyb.downloader.f.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class d implements java.util.concurrent.RejectedExecutionHandler {
    private d() {
    }

    /* synthetic */ d(byte b) {
        this();
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
        throw new java.util.concurrent.RejectedExecutionException();
    }
}
