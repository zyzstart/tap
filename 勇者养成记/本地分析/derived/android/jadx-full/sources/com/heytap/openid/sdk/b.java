package com.heytap.openid.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class b implements android.content.ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    public final /* synthetic */ com.heytap.openid.sdk.c f54a;

    @android.support.annotation.Keep
    public b(com.heytap.openid.sdk.c cVar) {
        this.f54a = cVar;
    }

    @Override // android.content.ServiceConnection
    @android.support.annotation.Keep
    public native void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

    @Override // android.content.ServiceConnection
    @android.support.annotation.Keep
    public native void onServiceDisconnected(android.content.ComponentName componentName);
}
