package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class Request implements java.lang.Comparable {
    private static final java.lang.String DEFAULT_PARAMS_ENCODING = "UTF-8";
    private com.tencent.beacon.core.network.volley.Cache.Entry mCacheEntry;
    private boolean mCanceled;
    private final int mDefaultTrafficStatsTag;
    private com.tencent.beacon.core.network.volley.Response.ErrorListener mErrorListener;
    private final com.tencent.beacon.core.network.volley.VolleyLog.MarkerLog mEventLog;
    private final java.lang.Object mLock;
    private final int mMethod;
    private com.tencent.beacon.core.network.volley.Request.NetworkRequestCompleteListener mRequestCompleteListener;
    private com.tencent.beacon.core.network.volley.RequestQueue mRequestQueue;
    private boolean mResponseDelivered;
    private com.tencent.beacon.core.network.volley.RetryPolicy mRetryPolicy;
    private java.lang.Integer mSequence;
    private boolean mShouldCache;
    private boolean mShouldRetryServerErrors;
    private java.lang.Object mTag;
    private final java.lang.String mUrl;

    public interface Method {
        public static final int DELETE = 3;
        public static final int DEPRECATED_GET_OR_POST = -1;
        public static final int GET = 0;
        public static final int HEAD = 4;
        public static final int OPTIONS = 5;
        public static final int PATCH = 7;
        public static final int POST = 1;
        public static final int PUT = 2;
        public static final int TRACE = 6;
    }

    interface NetworkRequestCompleteListener {
        void onNoUsableResponseReceived(com.tencent.beacon.core.network.volley.Request request);

        void onResponseReceived(com.tencent.beacon.core.network.volley.Request request, com.tencent.beacon.core.network.volley.Response response);
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public Request(int i, java.lang.String str, com.tencent.beacon.core.network.volley.Response.ErrorListener errorListener) {
        this.mEventLog = com.tencent.beacon.core.network.volley.VolleyLog.MarkerLog.ENABLED ? new com.tencent.beacon.core.network.volley.VolleyLog.MarkerLog() : null;
        this.mLock = new java.lang.Object();
        this.mShouldCache = true;
        this.mCanceled = false;
        this.mResponseDelivered = false;
        this.mShouldRetryServerErrors = false;
        this.mCacheEntry = null;
        this.mMethod = i;
        this.mUrl = str;
        this.mErrorListener = errorListener;
        setRetryPolicy(new com.tencent.beacon.core.network.volley.DefaultRetryPolicy());
        this.mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(str);
    }

    @java.lang.Deprecated
    public Request(java.lang.String str, com.tencent.beacon.core.network.volley.Response.ErrorListener errorListener) {
        this(-1, str, errorListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private byte[] encodeParameters(java.util.Map map, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            for (java.util.Map.Entry entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new java.lang.IllegalArgumentException(java.lang.String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
                sb.append(java.net.URLEncoder.encode((java.lang.String) entry.getKey(), str));
                sb.append('=');
                sb.append(java.net.URLEncoder.encode((java.lang.String) entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException("Encoding not supported: " + str, e);
        }
    }

    private static int findDefaultTrafficStatsTag(java.lang.String str) {
        android.net.Uri uri;
        java.lang.String host;
        if (android.text.TextUtils.isEmpty(str) || (uri = android.net.Uri.parse(str)) == null || (host = uri.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public void addMarker(java.lang.String str) {
        if (com.tencent.beacon.core.network.volley.VolleyLog.MarkerLog.ENABLED) {
            this.mEventLog.add(str, java.lang.Thread.currentThread().getId());
        }
    }

    public void cancel() {
        synchronized (this.mLock) {
            this.mCanceled = true;
            this.mErrorListener = null;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(com.tencent.beacon.core.network.volley.Request request) {
        com.tencent.beacon.core.network.volley.Request.Priority priority = getPriority();
        com.tencent.beacon.core.network.volley.Request.Priority priority2 = request.getPriority();
        return priority == priority2 ? this.mSequence.intValue() - request.mSequence.intValue() : priority2.ordinal() - priority.ordinal();
    }

    public void deliverError(com.tencent.beacon.core.network.volley.VolleyError volleyError) {
        com.tencent.beacon.core.network.volley.Response.ErrorListener errorListener;
        synchronized (this.mLock) {
            errorListener = this.mErrorListener;
        }
        if (errorListener != null) {
            errorListener.onErrorResponse(volleyError);
        }
    }

    protected abstract void deliverResponse(java.lang.Object obj);

    void finish(final java.lang.String str) {
        com.tencent.beacon.core.network.volley.RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null) {
            requestQueue.finish(this);
        }
        if (com.tencent.beacon.core.network.volley.VolleyLog.MarkerLog.ENABLED) {
            final long id = java.lang.Thread.currentThread().getId();
            if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
                new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: com.tencent.beacon.core.network.volley.Request.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.beacon.core.network.volley.Request.this.mEventLog.add(str, id);
                        com.tencent.beacon.core.network.volley.Request.this.mEventLog.finish(com.tencent.beacon.core.network.volley.Request.this.toString());
                    }
                });
            } else {
                this.mEventLog.add(str, id);
                this.mEventLog.finish(toString());
            }
        }
    }

    public byte[] getBody() {
        java.util.Map params = getParams();
        if (params == null || params.size() <= 0) {
            return null;
        }
        return encodeParameters(params, getParamsEncoding());
    }

    public java.lang.String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }

    public com.tencent.beacon.core.network.volley.Cache.Entry getCacheEntry() {
        return this.mCacheEntry;
    }

    public java.lang.String getCacheKey() {
        java.lang.String url = getUrl();
        int method = getMethod();
        if (method == 0 || method == -1) {
            return url;
        }
        return java.lang.Integer.toString(method) + '-' + url;
    }

    public com.tencent.beacon.core.network.volley.Response.ErrorListener getErrorListener() {
        com.tencent.beacon.core.network.volley.Response.ErrorListener errorListener;
        synchronized (this.mLock) {
            errorListener = this.mErrorListener;
        }
        return errorListener;
    }

    public java.util.Map getHeaders() {
        return java.util.Collections.emptyMap();
    }

    public int getMethod() {
        return this.mMethod;
    }

    protected java.util.Map getParams() {
        return null;
    }

    protected java.lang.String getParamsEncoding() {
        return DEFAULT_PARAMS_ENCODING;
    }

    @java.lang.Deprecated
    public byte[] getPostBody() {
        java.util.Map postParams = getPostParams();
        if (postParams == null || postParams.size() <= 0) {
            return null;
        }
        return encodeParameters(postParams, getPostParamsEncoding());
    }

    @java.lang.Deprecated
    public java.lang.String getPostBodyContentType() {
        return getBodyContentType();
    }

    @java.lang.Deprecated
    protected java.util.Map getPostParams() {
        return getParams();
    }

    @java.lang.Deprecated
    protected java.lang.String getPostParamsEncoding() {
        return getParamsEncoding();
    }

    public com.tencent.beacon.core.network.volley.Request.Priority getPriority() {
        return com.tencent.beacon.core.network.volley.Request.Priority.NORMAL;
    }

    public com.tencent.beacon.core.network.volley.RetryPolicy getRetryPolicy() {
        return this.mRetryPolicy;
    }

    public final int getSequence() {
        java.lang.Integer num = this.mSequence;
        if (num != null) {
            return num.intValue();
        }
        throw new java.lang.IllegalStateException("getSequence called before setSequence");
    }

    public java.lang.Object getTag() {
        return this.mTag;
    }

    public final int getTimeoutMs() {
        return getRetryPolicy().getCurrentTimeout();
    }

    public int getTrafficStatsTag() {
        return this.mDefaultTrafficStatsTag;
    }

    public java.lang.String getUrl() {
        return this.mUrl;
    }

    public boolean hasHadResponseDelivered() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mResponseDelivered;
        }
        return z;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mCanceled;
        }
        return z;
    }

    public void markDelivered() {
        synchronized (this.mLock) {
            this.mResponseDelivered = true;
        }
    }

    void notifyListenerResponseNotUsable() {
        com.tencent.beacon.core.network.volley.Request.NetworkRequestCompleteListener networkRequestCompleteListener;
        synchronized (this.mLock) {
            networkRequestCompleteListener = this.mRequestCompleteListener;
        }
        if (networkRequestCompleteListener != null) {
            networkRequestCompleteListener.onNoUsableResponseReceived(this);
        }
    }

    void notifyListenerResponseReceived(com.tencent.beacon.core.network.volley.Response response) {
        com.tencent.beacon.core.network.volley.Request.NetworkRequestCompleteListener networkRequestCompleteListener;
        synchronized (this.mLock) {
            networkRequestCompleteListener = this.mRequestCompleteListener;
        }
        if (networkRequestCompleteListener != null) {
            networkRequestCompleteListener.onResponseReceived(this, response);
        }
    }

    protected com.tencent.beacon.core.network.volley.VolleyError parseNetworkError(com.tencent.beacon.core.network.volley.VolleyError volleyError) {
        return volleyError;
    }

    protected abstract com.tencent.beacon.core.network.volley.Response parseNetworkResponse(com.tencent.beacon.core.network.volley.NetworkResponse networkResponse);

    void sendEvent(int i) {
        com.tencent.beacon.core.network.volley.RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null) {
            requestQueue.sendRequestEvent(this, i);
        }
    }

    public com.tencent.beacon.core.network.volley.Request setCacheEntry(com.tencent.beacon.core.network.volley.Cache.Entry entry) {
        this.mCacheEntry = entry;
        return this;
    }

    void setNetworkRequestCompleteListener(com.tencent.beacon.core.network.volley.Request.NetworkRequestCompleteListener networkRequestCompleteListener) {
        synchronized (this.mLock) {
            this.mRequestCompleteListener = networkRequestCompleteListener;
        }
    }

    public com.tencent.beacon.core.network.volley.Request setRequestQueue(com.tencent.beacon.core.network.volley.RequestQueue requestQueue) {
        this.mRequestQueue = requestQueue;
        return this;
    }

    public com.tencent.beacon.core.network.volley.Request setRetryPolicy(com.tencent.beacon.core.network.volley.RetryPolicy retryPolicy) {
        this.mRetryPolicy = retryPolicy;
        return this;
    }

    public final com.tencent.beacon.core.network.volley.Request setSequence(int i) {
        this.mSequence = java.lang.Integer.valueOf(i);
        return this;
    }

    public final com.tencent.beacon.core.network.volley.Request setShouldCache(boolean z) {
        this.mShouldCache = z;
        return this;
    }

    public final com.tencent.beacon.core.network.volley.Request setShouldRetryServerErrors(boolean z) {
        this.mShouldRetryServerErrors = z;
        return this;
    }

    public com.tencent.beacon.core.network.volley.Request setTag(java.lang.Object obj) {
        this.mTag = obj;
        return this;
    }

    public final boolean shouldCache() {
        return this.mShouldCache;
    }

    public final boolean shouldRetryServerErrors() {
        return this.mShouldRetryServerErrors;
    }

    public java.lang.String toString() {
        java.lang.String str = "0x" + java.lang.Integer.toHexString(getTrafficStatsTag());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(isCanceled() ? "[X] " : "[ ] ");
        sb.append(getUrl());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(getPriority());
        sb.append(" ");
        sb.append(this.mSequence);
        return sb.toString();
    }
}
