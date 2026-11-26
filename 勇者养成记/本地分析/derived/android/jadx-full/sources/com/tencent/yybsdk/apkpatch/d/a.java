package com.tencent.yybsdk.apkpatch.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1404a = true;
    protected static com.tencent.yybsdk.apkpatch.d.a c;
    public final long b = 10000;

    public static synchronized com.tencent.yybsdk.apkpatch.d.a a() {
        if (c == null) {
            c = new com.tencent.yybsdk.apkpatch.d.b();
        }
        return c;
    }

    public abstract void a(java.lang.Runnable runnable);
}
