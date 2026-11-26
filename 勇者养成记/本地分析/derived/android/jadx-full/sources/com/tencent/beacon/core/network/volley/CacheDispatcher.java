package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CacheDispatcher extends java.lang.Thread {
    private static final boolean DEBUG = com.tencent.beacon.core.network.volley.VolleyLog.DEBUG;
    private final com.tencent.beacon.core.network.volley.Cache mCache;
    private final java.util.concurrent.BlockingQueue mCacheQueue;
    private final com.tencent.beacon.core.network.volley.ResponseDelivery mDelivery;
    private final java.util.concurrent.BlockingQueue mNetworkQueue;
    private volatile boolean mQuit = false;
    private final com.tencent.beacon.core.network.volley.CacheDispatcher.WaitingRequestManager mWaitingRequestManager = new com.tencent.beacon.core.network.volley.CacheDispatcher.WaitingRequestManager(this);

    private static class WaitingRequestManager implements com.tencent.beacon.core.network.volley.Request.NetworkRequestCompleteListener {
        private final com.tencent.beacon.core.network.volley.CacheDispatcher mCacheDispatcher;
        private final java.util.Map mWaitingRequests = new java.util.HashMap();

        WaitingRequestManager(com.tencent.beacon.core.network.volley.CacheDispatcher cacheDispatcher) {
            this.mCacheDispatcher = cacheDispatcher;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean maybeAddToWaitingRequests(com.tencent.beacon.core.network.volley.Request request) {
            java.lang.String cacheKey = request.getCacheKey();
            if (!this.mWaitingRequests.containsKey(cacheKey)) {
                this.mWaitingRequests.put(cacheKey, null);
                request.setNetworkRequestCompleteListener(this);
                if (com.tencent.beacon.core.network.volley.VolleyLog.DEBUG) {
                    com.tencent.beacon.core.network.volley.VolleyLog.d("new request, sending to network %s", cacheKey);
                }
                return false;
            }
            java.util.List arrayList = (java.util.List) this.mWaitingRequests.get(cacheKey);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList();
            }
            request.addMarker("waiting-for-response");
            arrayList.add(request);
            this.mWaitingRequests.put(cacheKey, arrayList);
            if (com.tencent.beacon.core.network.volley.VolleyLog.DEBUG) {
                com.tencent.beacon.core.network.volley.VolleyLog.d("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
            }
            return true;
        }

        @Override // com.tencent.beacon.core.network.volley.Request.NetworkRequestCompleteListener
        public synchronized void onNoUsableResponseReceived(com.tencent.beacon.core.network.volley.Request request) {
            java.lang.String cacheKey = request.getCacheKey();
            java.util.List list = (java.util.List) this.mWaitingRequests.remove(cacheKey);
            if (list != null && !list.isEmpty()) {
                if (com.tencent.beacon.core.network.volley.VolleyLog.DEBUG) {
                    com.tencent.beacon.core.network.volley.VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", java.lang.Integer.valueOf(list.size()), cacheKey);
                }
                com.tencent.beacon.core.network.volley.Request request2 = (com.tencent.beacon.core.network.volley.Request) list.remove(0);
                this.mWaitingRequests.put(cacheKey, list);
                request2.setNetworkRequestCompleteListener(this);
                try {
                    this.mCacheDispatcher.mNetworkQueue.put(request2);
                } catch (java.lang.InterruptedException e) {
                    com.tencent.beacon.core.network.volley.VolleyLog.e("Couldn't add request to queue. %s", e.toString());
                    java.lang.Thread.currentThread().interrupt();
                    this.mCacheDispatcher.quit();
                }
            }
        }

        @Override // com.tencent.beacon.core.network.volley.Request.NetworkRequestCompleteListener
        public void onResponseReceived(com.tencent.beacon.core.network.volley.Request request, com.tencent.beacon.core.network.volley.Response response) {
            java.util.List list;
            com.tencent.beacon.core.network.volley.Cache.Entry entry = response.cacheEntry;
            if (entry == null || entry.isExpired()) {
                onNoUsableResponseReceived(request);
                return;
            }
            java.lang.String cacheKey = request.getCacheKey();
            synchronized (this) {
                list = (java.util.List) this.mWaitingRequests.remove(cacheKey);
            }
            if (list != null) {
                if (com.tencent.beacon.core.network.volley.VolleyLog.DEBUG) {
                    com.tencent.beacon.core.network.volley.VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", java.lang.Integer.valueOf(list.size()), cacheKey);
                }
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    this.mCacheDispatcher.mDelivery.postResponse((com.tencent.beacon.core.network.volley.Request) it.next(), response);
                }
            }
        }
    }

    public CacheDispatcher(java.util.concurrent.BlockingQueue blockingQueue, java.util.concurrent.BlockingQueue blockingQueue2, com.tencent.beacon.core.network.volley.Cache cache, com.tencent.beacon.core.network.volley.ResponseDelivery responseDelivery) {
        this.mCacheQueue = blockingQueue;
        this.mNetworkQueue = blockingQueue2;
        this.mCache = cache;
        this.mDelivery = responseDelivery;
    }

    private void processRequest() {
        processRequest((com.tencent.beacon.core.network.volley.Request) this.mCacheQueue.take());
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0077 A[Catch: all -> 0x009e, TRY_LEAVE, TryCatch #0 {all -> 0x009e, blocks: (B:3:0x000a, B:6:0x0012, B:9:0x0019, B:12:0x0027, B:14:0x0032, B:17:0x003b, B:20:0x0043, B:22:0x0051, B:26:0x005c, B:28:0x006e, B:30:0x0077, B:36:0x0097, B:33:0x007c, B:35:0x008c), top: B:43:0x000a }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void processRequest(final com.tencent.beacon.core.network.volley.Request request) {
        request.addMarker("cache-queue-take");
        request.sendEvent(1);
        try {
            if (request.isCanceled()) {
                request.finish("cache-discard-canceled");
                return;
            }
            com.tencent.beacon.core.network.volley.Cache.Entry entry = this.mCache.get(request.getCacheKey());
            if (entry == null) {
                request.addMarker("cache-miss");
                if (!this.mWaitingRequestManager.maybeAddToWaitingRequests(request)) {
                    this.mNetworkQueue.put(request);
                }
                return;
            }
            if (entry.isExpired()) {
                request.addMarker("cache-hit-expired");
                request.setCacheEntry(entry);
                if (!this.mWaitingRequestManager.maybeAddToWaitingRequests(request)) {
                    this.mNetworkQueue.put(request);
                }
                return;
            }
            request.addMarker("cache-hit");
            com.tencent.beacon.core.network.volley.Response networkResponse = request.parseNetworkResponse(new com.tencent.beacon.core.network.volley.NetworkResponse(entry.data, entry.responseHeaders));
            request.addMarker("cache-hit-parsed");
            if (entry.refreshNeeded()) {
                request.addMarker("cache-hit-refresh-needed");
                request.setCacheEntry(entry);
                networkResponse.intermediate = true;
                if (this.mWaitingRequestManager.maybeAddToWaitingRequests(request)) {
                    this.mDelivery.postResponse(request, networkResponse);
                } else {
                    this.mDelivery.postResponse(request, networkResponse, new java.lang.Runnable() { // from class: com.tencent.beacon.core.network.volley.CacheDispatcher.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                com.tencent.beacon.core.network.volley.CacheDispatcher.this.mNetworkQueue.put(request);
                            } catch (java.lang.InterruptedException unused) {
                                java.lang.Thread.currentThread().interrupt();
                            }
                        }
                    });
                }
            } else {
                this.mDelivery.postResponse(request, networkResponse);
            }
        } finally {
            request.sendEvent(2);
        }
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (DEBUG) {
            com.tencent.beacon.core.network.volley.VolleyLog.v("start new dispatcher", new java.lang.Object[0]);
        }
        android.os.Process.setThreadPriority(10);
        this.mCache.initialize();
        while (true) {
            try {
                processRequest();
            } catch (java.lang.InterruptedException unused) {
                if (this.mQuit) {
                    java.lang.Thread.currentThread().interrupt();
                    return;
                }
                com.tencent.beacon.core.network.volley.VolleyLog.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new java.lang.Object[0]);
            }
        }
    }
}
