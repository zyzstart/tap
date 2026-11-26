package com.tencent.hlyyb.common.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class f implements java.lang.Thread.UncaughtExceptionHandler {
    f(com.tencent.hlyyb.common.a.a.d dVar) {
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        th.printStackTrace();
    }
}
