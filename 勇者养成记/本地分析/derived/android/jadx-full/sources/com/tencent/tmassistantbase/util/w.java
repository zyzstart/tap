package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class w extends java.lang.Thread {
    w() {
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x000e */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
    
        return;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r5 = this;
        L0:
            java.util.concurrent.LinkedBlockingQueue r0 = com.tencent.tmassistantbase.util.TMLog.f1050a     // Catch: java.lang.Throwable -> Le java.lang.InterruptedException -> L3c
            java.lang.Object r0 = r0.take()     // Catch: java.lang.Throwable -> Le java.lang.InterruptedException -> L3c
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> Le java.lang.InterruptedException -> L3c
            if (r0 == 0) goto L0
            com.tencent.tmassistantbase.util.TMLog.a(r0)     // Catch: java.lang.Throwable -> Le java.lang.InterruptedException -> L3c
            goto L0
        Le:
            r0 = move-exception
            boolean r1 = r0 instanceof java.io.IOException
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2d
            java.lang.String r1 = r0.getMessage()
            java.lang.String r4 = "ENOSPC"
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L2d
            java.util.concurrent.atomic.AtomicBoolean r1 = com.tencent.tmassistantbase.util.TMLog.isPreExceptionEnospc
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L3b
        L29:
            r0.printStackTrace()
            goto L3b
        L2d:
            java.util.concurrent.atomic.AtomicBoolean r1 = com.tencent.tmassistantbase.util.TMLog.isPreExceptionEnospc
            r1.compareAndSet(r3, r2)
            r0.printStackTrace()
            com.tencent.tmassistantbase.util.TMLog.b()     // Catch: java.lang.Throwable -> L39
            goto L3b
        L39:
            r0 = move-exception
            goto L29
        L3b:
            return
        L3c:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "write log file error."
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "TMLog"
            android.util.Log.d(r1, r0)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantbase.util.w.run():void");
    }
}
