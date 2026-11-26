package com.huawei.android.hms.pps.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public final class a implements android.content.ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    public boolean f57a = false;

    @android.support.annotation.Keep
    public final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b = new java.util.concurrent.LinkedBlockingQueue<>(1);

    @android.support.annotation.Keep
    public a() {
    }

    @Override // android.content.ServiceConnection
    @android.support.annotation.Keep
    public final native void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

    @Override // android.content.ServiceConnection
    @android.support.annotation.Keep
    public final native void onServiceDisconnected(android.content.ComponentName componentName);
}
