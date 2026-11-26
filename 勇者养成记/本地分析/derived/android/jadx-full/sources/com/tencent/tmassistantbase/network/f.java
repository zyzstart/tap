package com.tencent.tmassistantbase.network;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final java.lang.Integer f1048a = 1;
    protected java.net.HttpURLConnection b = null;
    protected java.util.concurrent.Future c = null;

    public synchronized void a() {
        java.util.concurrent.Future future = this.c;
        if (future != null && !future.isCancelled() && !this.c.isDone()) {
            this.c.cancel(true);
        }
        this.c = null;
        java.net.HttpURLConnection httpURLConnection = this.b;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.b = null;
        }
    }

    protected abstract void a(byte[] bArr, byte[] bArr2, int i);

    protected synchronized boolean a(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.b != null) {
            return false;
        }
        this.c = java.util.concurrent.Executors.newSingleThreadExecutor().submit(new com.tencent.tmassistantbase.network.g(this, bArr));
        return false;
    }
}
