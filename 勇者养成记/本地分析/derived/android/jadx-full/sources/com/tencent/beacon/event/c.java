package com.tencent.beacon.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements java.lang.Runnable {
    c() {
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.beacon.core.e.d.a("[core] db events to up on app call", new java.lang.Object[0]);
        try {
            com.tencent.beacon.core.event.TunnelModule.doUploadAllEventsData();
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
        }
    }
}
