package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NetworkDispatcher extends java.lang.Thread {
    private final com.tencent.beacon.core.network.volley.Cache mCache;
    private final com.tencent.beacon.core.network.volley.ResponseDelivery mDelivery;
    private final com.tencent.beacon.core.network.volley.Network mNetwork;
    private final java.util.concurrent.BlockingQueue mQueue;
    private volatile boolean mQuit = false;

    public NetworkDispatcher(java.util.concurrent.BlockingQueue blockingQueue, com.tencent.beacon.core.network.volley.Network network, com.tencent.beacon.core.network.volley.Cache cache, com.tencent.beacon.core.network.volley.ResponseDelivery responseDelivery) {
        this.mQueue = blockingQueue;
        this.mNetwork = network;
        this.mCache = cache;
        this.mDelivery = responseDelivery;
    }

    @android.annotation.TargetApi(14)
    private void addTrafficStatsTag(com.tencent.beacon.core.network.volley.Request request) {
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            android.net.TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
        }
    }

    private void parseAndDeliverNetworkError(com.tencent.beacon.core.network.volley.Request request, com.tencent.beacon.core.network.volley.VolleyError volleyError) {
        this.mDelivery.postError(request, request.parseNetworkError(volleyError));
    }

    private void processRequest() {
        processRequest((com.tencent.beacon.core.network.volley.Request) this.mQueue.take());
    }

    void processRequest(com.tencent.beacon.core.network.volley.Request request) {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        request.sendEvent(3);
        try {
            try {
                try {
                    request.addMarker("network-queue-take");
                    if (request.isCanceled()) {
                        request.finish("network-discard-cancelled");
                        request.notifyListenerResponseNotUsable();
                        request.sendEvent(4);
                        return;
                    }
                    addTrafficStatsTag(request);
                    com.tencent.beacon.core.network.volley.NetworkResponse networkResponsePerformRequest = this.mNetwork.performRequest(request);
                    request.addMarker("network-http-complete");
                    if (networkResponsePerformRequest.notModified && request.hasHadResponseDelivered()) {
                        request.finish("not-modified");
                        request.notifyListenerResponseNotUsable();
                        request.sendEvent(4);
                        return;
                    }
                    com.tencent.beacon.core.network.volley.Response networkResponse = request.parseNetworkResponse(networkResponsePerformRequest);
                    request.addMarker("network-parse-complete");
                    if (request.shouldCache() && networkResponse.cacheEntry != null) {
                        this.mCache.put(request.getCacheKey(), networkResponse.cacheEntry);
                        request.addMarker("network-cache-written");
                    }
                    request.markDelivered();
                    this.mDelivery.postResponse(request, networkResponse);
                    request.notifyListenerResponseReceived(networkResponse);
                    request.sendEvent(4);
                } catch (java.lang.Exception e) {
                    com.tencent.beacon.core.network.volley.VolleyLog.e(e, "Unhandled exception %s", e.toString());
                    com.tencent.beacon.core.network.volley.VolleyError volleyError = new com.tencent.beacon.core.network.volley.VolleyError(e);
                    volleyError.setNetworkTimeMs(android.os.SystemClock.elapsedRealtime() - jElapsedRealtime);
                    this.mDelivery.postError(request, volleyError);
                    request.notifyListenerResponseNotUsable();
                }
            } catch (com.tencent.beacon.core.network.volley.VolleyError e2) {
                e2.setNetworkTimeMs(android.os.SystemClock.elapsedRealtime() - jElapsedRealtime);
                parseAndDeliverNetworkError(request, e2);
                request.notifyListenerResponseNotUsable();
            }
        } catch (java.lang.Throwable th) {
            request.sendEvent(4);
            throw th;
        }
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        android.os.Process.setThreadPriority(10);
        while (true) {
            try {
                processRequest();
            } catch (java.lang.InterruptedException unused) {
                if (this.mQuit) {
                    java.lang.Thread.currentThread().interrupt();
                    return;
                }
                com.tencent.beacon.core.network.volley.VolleyLog.e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new java.lang.Object[0]);
            }
        }
    }
}
