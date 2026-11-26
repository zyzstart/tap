package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class RequestQueue {
    private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;
    private final com.tencent.beacon.core.network.volley.Cache mCache;
    private com.tencent.beacon.core.network.volley.CacheDispatcher mCacheDispatcher;
    private final java.util.concurrent.PriorityBlockingQueue mCacheQueue;
    private final java.util.Set mCurrentRequests;
    private final com.tencent.beacon.core.network.volley.ResponseDelivery mDelivery;
    private final com.tencent.beacon.core.network.volley.NetworkDispatcher[] mDispatchers;
    private final java.util.List mEventListeners;
    private final java.util.List mFinishedListeners;
    private final com.tencent.beacon.core.network.volley.Network mNetwork;
    private final java.util.concurrent.PriorityBlockingQueue mNetworkQueue;
    private final java.util.concurrent.atomic.AtomicInteger mSequenceGenerator;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface RequestEvent {
        public static final int REQUEST_CACHE_LOOKUP_FINISHED = 2;
        public static final int REQUEST_CACHE_LOOKUP_STARTED = 1;
        public static final int REQUEST_FINISHED = 5;
        public static final int REQUEST_NETWORK_DISPATCH_FINISHED = 4;
        public static final int REQUEST_NETWORK_DISPATCH_STARTED = 3;
        public static final int REQUEST_QUEUED = 0;
    }

    public interface RequestEventListener {
        void onRequestEvent(com.tencent.beacon.core.network.volley.Request request, int i);
    }

    public interface RequestFilter {
        boolean apply(com.tencent.beacon.core.network.volley.Request request);
    }

    @java.lang.Deprecated
    public interface RequestFinishedListener {
        void onRequestFinished(com.tencent.beacon.core.network.volley.Request request);
    }

    public RequestQueue(com.tencent.beacon.core.network.volley.Cache cache, com.tencent.beacon.core.network.volley.Network network) {
        this(cache, network, 4);
    }

    public RequestQueue(com.tencent.beacon.core.network.volley.Cache cache, com.tencent.beacon.core.network.volley.Network network, int i) {
        this(cache, network, i, new com.tencent.beacon.core.network.volley.ExecutorDelivery(new android.os.Handler(android.os.Looper.getMainLooper())));
    }

    public RequestQueue(com.tencent.beacon.core.network.volley.Cache cache, com.tencent.beacon.core.network.volley.Network network, int i, com.tencent.beacon.core.network.volley.ResponseDelivery responseDelivery) {
        this.mSequenceGenerator = new java.util.concurrent.atomic.AtomicInteger();
        this.mCurrentRequests = new java.util.HashSet();
        this.mCacheQueue = new java.util.concurrent.PriorityBlockingQueue();
        this.mNetworkQueue = new java.util.concurrent.PriorityBlockingQueue();
        this.mFinishedListeners = new java.util.ArrayList();
        this.mEventListeners = new java.util.ArrayList();
        this.mCache = cache;
        this.mNetwork = network;
        this.mDispatchers = new com.tencent.beacon.core.network.volley.NetworkDispatcher[i];
        this.mDelivery = responseDelivery;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public com.tencent.beacon.core.network.volley.Request add(com.tencent.beacon.core.network.volley.Request request) {
        request.setRequestQueue(this);
        synchronized (this.mCurrentRequests) {
            this.mCurrentRequests.add(request);
        }
        request.setSequence(getSequenceNumber());
        request.addMarker("add-to-queue");
        sendRequestEvent(request, 0);
        (!request.shouldCache() ? this.mNetworkQueue : this.mCacheQueue).add(request);
        return request;
    }

    public void addRequestEventListener(com.tencent.beacon.core.network.volley.RequestQueue.RequestEventListener requestEventListener) {
        synchronized (this.mEventListeners) {
            this.mEventListeners.add(requestEventListener);
        }
    }

    @java.lang.Deprecated
    public void addRequestFinishedListener(com.tencent.beacon.core.network.volley.RequestQueue.RequestFinishedListener requestFinishedListener) {
        synchronized (this.mFinishedListeners) {
            this.mFinishedListeners.add(requestFinishedListener);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancelAll(com.tencent.beacon.core.network.volley.RequestQueue.RequestFilter requestFilter) {
        synchronized (this.mCurrentRequests) {
            for (com.tencent.beacon.core.network.volley.Request request : this.mCurrentRequests) {
                if (requestFilter.apply(request)) {
                    request.cancel();
                }
            }
        }
    }

    public void cancelAll(final java.lang.Object obj) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        cancelAll(new com.tencent.beacon.core.network.volley.RequestQueue.RequestFilter() { // from class: com.tencent.beacon.core.network.volley.RequestQueue.1
            @Override // com.tencent.beacon.core.network.volley.RequestQueue.RequestFilter
            public boolean apply(com.tencent.beacon.core.network.volley.Request request) {
                return request.getTag() == obj;
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void finish(com.tencent.beacon.core.network.volley.Request request) {
        synchronized (this.mCurrentRequests) {
            this.mCurrentRequests.remove(request);
        }
        synchronized (this.mFinishedListeners) {
            java.util.Iterator it = this.mFinishedListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.beacon.core.network.volley.RequestQueue.RequestFinishedListener) it.next()).onRequestFinished(request);
            }
        }
        sendRequestEvent(request, 5);
    }

    public com.tencent.beacon.core.network.volley.Cache getCache() {
        return this.mCache;
    }

    public int getSequenceNumber() {
        return this.mSequenceGenerator.incrementAndGet();
    }

    public void removeRequestEventListener(com.tencent.beacon.core.network.volley.RequestQueue.RequestEventListener requestEventListener) {
        synchronized (this.mEventListeners) {
            this.mEventListeners.remove(requestEventListener);
        }
    }

    @java.lang.Deprecated
    public void removeRequestFinishedListener(com.tencent.beacon.core.network.volley.RequestQueue.RequestFinishedListener requestFinishedListener) {
        synchronized (this.mFinishedListeners) {
            this.mFinishedListeners.remove(requestFinishedListener);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void sendRequestEvent(com.tencent.beacon.core.network.volley.Request request, int i) {
        synchronized (this.mEventListeners) {
            java.util.Iterator it = this.mEventListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.beacon.core.network.volley.RequestQueue.RequestEventListener) it.next()).onRequestEvent(request, i);
            }
        }
    }

    public void start() {
        stop();
        com.tencent.beacon.core.network.volley.CacheDispatcher cacheDispatcher = new com.tencent.beacon.core.network.volley.CacheDispatcher(this.mCacheQueue, this.mNetworkQueue, this.mCache, this.mDelivery);
        this.mCacheDispatcher = cacheDispatcher;
        cacheDispatcher.start();
        for (int i = 0; i < this.mDispatchers.length; i++) {
            com.tencent.beacon.core.network.volley.NetworkDispatcher networkDispatcher = new com.tencent.beacon.core.network.volley.NetworkDispatcher(this.mNetworkQueue, this.mNetwork, this.mCache, this.mDelivery);
            this.mDispatchers[i] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void stop() {
        com.tencent.beacon.core.network.volley.CacheDispatcher cacheDispatcher = this.mCacheDispatcher;
        if (cacheDispatcher != null) {
            cacheDispatcher.quit();
        }
        for (com.tencent.beacon.core.network.volley.NetworkDispatcher networkDispatcher : this.mDispatchers) {
            if (networkDispatcher != null) {
                networkDispatcher.quit();
            }
        }
    }
}
