package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class u implements java.lang.Runnable {
    u() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.tencent.tmassistantbase.util.TMLog.context == null || !com.tencent.tmassistantbase.util.TMLog.isWriteLogToFile() || com.tencent.tmassistantbase.util.TMLog.isInitLogFileDone.get()) {
            return;
        }
        new com.tencent.tmassistantbase.util.v(this, "TMLogInitThread").start();
    }
}
