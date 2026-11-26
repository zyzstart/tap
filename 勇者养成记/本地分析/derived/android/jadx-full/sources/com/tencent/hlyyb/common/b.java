package com.tencent.hlyyb.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ java.lang.String f541a;

    b(java.lang.String str) {
        this.f541a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Print SDKBaseInfo on tag:" + this.f541a);
            sb.append("\r\nPlatformProtocalType:2");
            sb.append("\r\nappContext:" + com.tencent.hlyyb.common.a.i);
            sb.append("\r\nbootSessionId:" + com.tencent.hlyyb.common.a.j);
            sb.append("\r\nbootTime:" + com.tencent.hlyyb.common.a.k);
            sb.append("\r\nappId:" + com.tencent.hlyyb.common.a.l);
            sb.append("\r\nisSDKMode:" + com.tencent.hlyyb.common.a.m);
            sb.append("\r\nbundle:" + com.tencent.hlyyb.common.a.n);
            sb.append("\r\nappVersionName:" + com.tencent.hlyyb.common.a.f518a);
            sb.append("\r\nappVersionCode:" + com.tencent.hlyyb.common.a.c);
            sb.append("\r\nappLabelName:" + com.tencent.hlyyb.common.a.b);
            sb.append("\r\nuuid:" + com.tencent.hlyyb.common.a.d);
            sb.append("\r\nchannelId:" + com.tencent.hlyyb.common.a.e);
            sb.append("\r\nsdkVersion:" + com.tencent.hlyyb.common.a.o);
            sb.append("\r\nsProcessName:" + com.tencent.hlyyb.common.a.q);
            sb.append("\r\npid:" + com.tencent.hlyyb.common.a.f);
            sb.append("\r\nsProcessNameSubfix:" + com.tencent.hlyyb.common.a.s);
            sb.append("\r\nsIsMainProcess:" + com.tencent.hlyyb.common.a.r);
            sb.append("\r\npsInRemoteProcess:" + com.tencent.hlyyb.common.a.h);
            sb.append("\r\nisTestMode:" + com.tencent.hlyyb.common.a.u);
            if (com.tencent.hlyyb.common.a.i != null) {
                sb.append("\r\ndeviceid:" + com.tencent.hlyyb.common.d.j.a());
            }
            sb.append("\r\nfinger:" + android.os.Build.FINGERPRINT);
        } catch (java.lang.Throwable unused) {
        }
    }
}
