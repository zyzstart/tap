package com.tencent.ydkqmsp.sdk.g.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b implements android.content.ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1355a = false;
    public final java.util.concurrent.LinkedBlockingQueue b = new java.util.concurrent.LinkedBlockingQueue(1);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onServiceConnected ");
            sb.append(java.lang.System.currentTimeMillis());
            android.util.Log.d("PPSSerivceConnection", sb.toString());
            this.b.put(iBinder);
        } catch (java.lang.InterruptedException unused) {
            android.util.Log.w("PPSSerivceConnection", "onServiceConnected InterruptedException " + java.lang.System.currentTimeMillis());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(android.content.ComponentName componentName) {
        android.util.Log.d("PPSSerivceConnection", "onServiceDisconnected " + java.lang.System.currentTimeMillis());
    }
}
