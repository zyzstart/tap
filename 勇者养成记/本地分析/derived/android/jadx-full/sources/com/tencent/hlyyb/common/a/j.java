package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class j implements java.lang.Runnable {
    j() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.tencent.hlyyb.common.a.f.e();
            com.tencent.hlyyb.common.a.a().registerReceiver(com.tencent.hlyyb.common.a.f.i, new android.content.IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (java.lang.Throwable unused) {
        }
    }
}
