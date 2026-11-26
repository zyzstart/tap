package com.tencent.msdk.dns.core;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a extends android.content.BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.tencent.msdk.dns.base.log.DnsLog.d("Network change.", new java.lang.Object[0]);
        if (com.tencent.msdk.dns.core.e.f672a) {
            com.tencent.msdk.dns.core.d.a();
        }
    }
}
