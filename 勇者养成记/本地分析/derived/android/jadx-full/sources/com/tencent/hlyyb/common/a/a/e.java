package com.tencent.hlyyb.common.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class e implements java.util.concurrent.RejectedExecutionHandler {
    private e() {
    }

    /* synthetic */ e(byte b) {
        this();
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
        throw new java.util.concurrent.RejectedExecutionException();
    }
}
