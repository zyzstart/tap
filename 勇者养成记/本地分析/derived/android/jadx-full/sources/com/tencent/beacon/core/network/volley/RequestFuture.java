package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class RequestFuture implements java.util.concurrent.Future, com.tencent.beacon.core.network.volley.Response.Listener, com.tencent.beacon.core.network.volley.Response.ErrorListener {
    private com.tencent.beacon.core.network.volley.VolleyError mException;
    private com.tencent.beacon.core.network.volley.Request mRequest;
    private java.lang.Object mResult;
    private boolean mResultReceived = false;

    private RequestFuture() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized java.lang.Object doGet(java.lang.Long l) {
        com.tencent.beacon.core.network.volley.VolleyError volleyError = this.mException;
        if (volleyError != null) {
            throw new java.util.concurrent.ExecutionException(volleyError);
        }
        if (this.mResultReceived) {
            return this.mResult;
        }
        if (l == null) {
            while (!isDone()) {
                wait(0L);
            }
        } else if (l.longValue() > 0) {
            long jUptimeMillis = android.os.SystemClock.uptimeMillis();
            long jLongValue = l.longValue() + jUptimeMillis;
            while (!isDone() && jUptimeMillis < jLongValue) {
                wait(jLongValue - jUptimeMillis);
                jUptimeMillis = android.os.SystemClock.uptimeMillis();
            }
        }
        com.tencent.beacon.core.network.volley.VolleyError volleyError2 = this.mException;
        if (volleyError2 != null) {
            throw new java.util.concurrent.ExecutionException(volleyError2);
        }
        if (!this.mResultReceived) {
            throw new java.util.concurrent.TimeoutException();
        }
        return this.mResult;
    }

    public static com.tencent.beacon.core.network.volley.RequestFuture newFuture() {
        return new com.tencent.beacon.core.network.volley.RequestFuture();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.mRequest == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.mRequest.cancel();
        return true;
    }

    @Override // java.util.concurrent.Future
    public java.lang.Object get() {
        try {
            return doGet(null);
        } catch (java.util.concurrent.TimeoutException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public java.lang.Object get(long j, java.util.concurrent.TimeUnit timeUnit) {
        return doGet(java.lang.Long.valueOf(java.util.concurrent.TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        com.tencent.beacon.core.network.volley.Request request = this.mRequest;
        if (request == null) {
            return false;
        }
        return request.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        return this.mResultReceived || this.mException != null || isCancelled();
    }

    @Override // com.tencent.beacon.core.network.volley.Response.ErrorListener
    public synchronized void onErrorResponse(com.tencent.beacon.core.network.volley.VolleyError volleyError) {
        this.mException = volleyError;
        notifyAll();
    }

    @Override // com.tencent.beacon.core.network.volley.Response.Listener
    public synchronized void onResponse(java.lang.Object obj) {
        this.mResultReceived = true;
        this.mResult = obj;
        notifyAll();
    }

    public void setRequest(com.tencent.beacon.core.network.volley.Request request) {
        this.mRequest = request;
    }
}
