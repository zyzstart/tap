package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.concurrent.ThreadPoolExecutor f533a;

    private k() {
        this.f533a = (java.util.concurrent.ThreadPoolExecutor) java.util.concurrent.Executors.newCachedThreadPool(new com.tencent.hlyyb.common.a.a.a("HalleyBusiTaskPoolHolder"));
    }

    /* synthetic */ k(byte b) {
        this();
    }

    public static com.tencent.hlyyb.common.a.k a() {
        return com.tencent.hlyyb.common.a.l.f534a;
    }

    public final java.util.concurrent.ThreadPoolExecutor b() {
        return this.f533a;
    }
}
