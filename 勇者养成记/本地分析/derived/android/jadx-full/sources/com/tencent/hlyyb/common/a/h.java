package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class h extends android.content.BroadcastReceiver {
    h() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        com.tencent.hlyyb.common.a.k().post(new com.tencent.hlyyb.common.a.i(this));
    }
}
