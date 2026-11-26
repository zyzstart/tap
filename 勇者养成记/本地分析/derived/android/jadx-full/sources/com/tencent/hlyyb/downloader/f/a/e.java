package com.tencent.hlyyb.downloader.f.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class e implements java.lang.Thread.UncaughtExceptionHandler {
    e(com.tencent.hlyyb.downloader.f.a.b bVar) {
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        th.printStackTrace();
    }
}
