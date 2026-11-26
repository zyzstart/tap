package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BasicNetwork implements com.tencent.beacon.core.network.volley.Network {
    protected static final boolean DEBUG = com.tencent.beacon.core.network.volley.VolleyLog.DEBUG;
    private static final int DEFAULT_POOL_SIZE = 4096;
    private static final int SLOW_REQUEST_THRESHOLD_MS = 3000;
    private final com.tencent.beacon.core.network.volley.BaseHttpStack mBaseHttpStack;

    @java.lang.Deprecated
    protected final com.tencent.beacon.core.network.volley.HttpStack mHttpStack;
    protected final com.tencent.beacon.core.network.volley.ByteArrayPool mPool;

    public BasicNetwork(com.tencent.beacon.core.network.volley.BaseHttpStack baseHttpStack) {
        this(baseHttpStack, new com.tencent.beacon.core.network.volley.ByteArrayPool(4096));
    }

    public BasicNetwork(com.tencent.beacon.core.network.volley.BaseHttpStack baseHttpStack, com.tencent.beacon.core.network.volley.ByteArrayPool byteArrayPool) {
        this.mBaseHttpStack = baseHttpStack;
        this.mHttpStack = baseHttpStack;
        this.mPool = byteArrayPool;
    }

    @java.lang.Deprecated
    public BasicNetwork(com.tencent.beacon.core.network.volley.HttpStack httpStack) {
        this(httpStack, new com.tencent.beacon.core.network.volley.ByteArrayPool(4096));
    }

    @java.lang.Deprecated
    public BasicNetwork(com.tencent.beacon.core.network.volley.HttpStack httpStack, com.tencent.beacon.core.network.volley.ByteArrayPool byteArrayPool) {
        this.mHttpStack = httpStack;
        this.mBaseHttpStack = new com.tencent.beacon.core.network.volley.AdaptedHttpStack(httpStack);
        this.mPool = byteArrayPool;
    }

    private static void attemptRetryOnException(java.lang.String str, com.tencent.beacon.core.network.volley.Request request, com.tencent.beacon.core.network.volley.VolleyError volleyError) throws com.tencent.beacon.core.network.volley.VolleyError {
        com.tencent.beacon.core.network.volley.RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(java.lang.String.format("%s-retry [timeout=%s]", str, java.lang.Integer.valueOf(timeoutMs)));
        } catch (com.tencent.beacon.core.network.volley.VolleyError e) {
            request.addMarker(java.lang.String.format("%s-timeout-giveup [timeout=%s]", str, java.lang.Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    private static java.util.List combineHeaders(java.util.List list, com.tencent.beacon.core.network.volley.Cache.Entry entry) {
        java.util.TreeSet treeSet = new java.util.TreeSet(java.lang.String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(((com.tencent.beacon.core.network.volley.Header) it.next()).getName());
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        java.util.List list2 = entry.allResponseHeaders;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (com.tencent.beacon.core.network.volley.Header header : entry.allResponseHeaders) {
                    if (!treeSet.contains(header.getName())) {
                        arrayList.add(header);
                    }
                }
            }
        } else if (!entry.responseHeaders.isEmpty()) {
            for (java.util.Map.Entry entry2 : entry.responseHeaders.entrySet()) {
                if (!treeSet.contains(entry2.getKey())) {
                    arrayList.add(new com.tencent.beacon.core.network.volley.Header((java.lang.String) entry2.getKey(), (java.lang.String) entry2.getValue()));
                }
            }
        }
        return arrayList;
    }

    @java.lang.Deprecated
    protected static java.util.Map convertHeaders(com.tencent.beacon.core.network.volley.Header[] headerArr) {
        java.util.TreeMap treeMap = new java.util.TreeMap(java.lang.String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private java.util.Map getCacheHeaders(com.tencent.beacon.core.network.volley.Cache.Entry entry) {
        if (entry == null) {
            return java.util.Collections.emptyMap();
        }
        java.util.HashMap map = new java.util.HashMap();
        java.lang.String str = entry.etag;
        if (str != null) {
            map.put("If-None-Match", str);
        }
        long j = entry.lastModified;
        if (j > 0) {
            map.put("If-Modified-Since", com.tencent.beacon.core.network.volley.HttpHeaderParser.formatEpochAsRfc1123(j));
        }
        return map;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private byte[] inputStreamToBytes(java.io.InputStream inputStream, int i) throws java.io.IOException {
        com.tencent.beacon.core.network.volley.PoolingByteArrayOutputStream poolingByteArrayOutputStream = new com.tencent.beacon.core.network.volley.PoolingByteArrayOutputStream(this.mPool, i);
        try {
            if (inputStream == null) {
                throw new com.tencent.beacon.core.network.volley.ServerError();
            }
            byte[] buf = this.mPool.getBuf(1024);
            while (true) {
                int i2 = inputStream.read(buf);
                if (i2 == -1) {
                    break;
                }
                poolingByteArrayOutputStream.write(buf, 0, i2);
            }
            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (java.io.IOException unused) {
                    com.tencent.beacon.core.network.volley.VolleyLog.v("Error occurred when closing InputStream", new java.lang.Object[0]);
                }
            }
            this.mPool.returnBuf(buf);
            poolingByteArrayOutputStream.close();
            return byteArray;
        } catch (java.lang.Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (java.io.IOException unused2) {
                    com.tencent.beacon.core.network.volley.VolleyLog.v("Error occurred when closing InputStream", new java.lang.Object[0]);
                }
            }
            this.mPool.returnBuf(null);
            poolingByteArrayOutputStream.close();
            throw th;
        }
    }

    private void logSlowRequests(long j, com.tencent.beacon.core.network.volley.Request request, byte[] bArr, int i) {
        if (DEBUG || j > 3000) {
            java.lang.Object[] objArr = new java.lang.Object[5];
            objArr[0] = request;
            objArr[1] = java.lang.Long.valueOf(j);
            objArr[2] = bArr != null ? java.lang.Integer.valueOf(bArr.length) : "null";
            objArr[3] = java.lang.Integer.valueOf(i);
            objArr[4] = java.lang.Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            com.tencent.beacon.core.network.volley.VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    protected void logError(java.lang.String str, java.lang.String str2, long j) {
        com.tencent.beacon.core.network.volley.VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", str, java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime() - j), str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [com.tencent.beacon.core.network.volley.BasicNetwork] */
    @Override // com.tencent.beacon.core.network.volley.Network
    public com.tencent.beacon.core.network.volley.NetworkResponse performRequest(com.tencent.beacon.core.network.volley.Request request) throws com.tencent.beacon.core.network.volley.VolleyError {
        com.tencent.beacon.core.network.volley.VolleyError timeoutError;
        java.lang.String str;
        ?? r19;
        com.tencent.beacon.core.network.volley.HttpResponse httpResponseExecuteRequest;
        byte[] bArr;
        byte[] bArrInputStreamToBytes;
        ?? r1;
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        while (true) {
            java.util.List listEmptyList = java.util.Collections.emptyList();
            try {
                try {
                    httpResponseExecuteRequest = this.mBaseHttpStack.executeRequest(request, getCacheHeaders(request.getCacheEntry()));
                    try {
                        int statusCode = httpResponseExecuteRequest.getStatusCode();
                        java.util.List headers = httpResponseExecuteRequest.getHeaders();
                        if (statusCode == 304) {
                            com.tencent.beacon.core.network.volley.Cache.Entry cacheEntry = request.getCacheEntry();
                            return cacheEntry == null ? new com.tencent.beacon.core.network.volley.NetworkResponse(304, (byte[]) null, true, android.os.SystemClock.elapsedRealtime() - jElapsedRealtime, headers) : new com.tencent.beacon.core.network.volley.NetworkResponse(304, cacheEntry.data, true, android.os.SystemClock.elapsedRealtime() - jElapsedRealtime, combineHeaders(headers, cacheEntry));
                        }
                        try {
                            java.io.InputStream content = httpResponseExecuteRequest.getContent();
                            if (content != null) {
                                try {
                                    bArrInputStreamToBytes = inputStreamToBytes(content, httpResponseExecuteRequest.getContentLength());
                                } catch (java.io.IOException e) {
                                    e = e;
                                    bArr = null;
                                    r19 = headers;
                                }
                            } else {
                                bArrInputStreamToBytes = new byte[0];
                            }
                            byte[] bArr2 = bArrInputStreamToBytes;
                            try {
                                r1 = this;
                                r1.logSlowRequests(android.os.SystemClock.elapsedRealtime() - jElapsedRealtime, request, bArr2, statusCode);
                                try {
                                    if (statusCode < 200 || statusCode > 299) {
                                        throw new java.io.IOException();
                                    }
                                    return new com.tencent.beacon.core.network.volley.NetworkResponse(statusCode, bArr2, false, android.os.SystemClock.elapsedRealtime() - jElapsedRealtime, headers);
                                } catch (java.io.IOException e2) {
                                    e = e2;
                                }
                            } catch (java.io.IOException e3) {
                                e = e3;
                                r1 = headers;
                            }
                            r19 = r1;
                            bArr = bArr2;
                        } catch (java.io.IOException e4) {
                            e = e4;
                            listEmptyList = headers;
                            r19 = listEmptyList;
                            bArr = null;
                        }
                        if (httpResponseExecuteRequest == null) {
                            throw new com.tencent.beacon.core.network.volley.NoConnectionError(e);
                        }
                        int statusCode2 = httpResponseExecuteRequest.getStatusCode();
                        com.tencent.beacon.core.network.volley.VolleyLog.e("Unexpected response code %d for %s", java.lang.Integer.valueOf(statusCode2), request.getUrl());
                        if (bArr != null) {
                            com.tencent.beacon.core.network.volley.NetworkResponse networkResponse = new com.tencent.beacon.core.network.volley.NetworkResponse(statusCode2, bArr, false, android.os.SystemClock.elapsedRealtime() - jElapsedRealtime, (java.util.List) r19);
                            if (statusCode2 == 401 || statusCode2 == 403) {
                                timeoutError = new com.tencent.beacon.core.network.volley.AuthFailureError(networkResponse);
                                str = "auth";
                            } else {
                                if (statusCode2 >= 400 && statusCode2 <= 499) {
                                    throw new com.tencent.beacon.core.network.volley.ClientError(networkResponse);
                                }
                                if (statusCode2 < 500 || statusCode2 > 599) {
                                    throw new com.tencent.beacon.core.network.volley.ServerError(networkResponse);
                                }
                                if (!request.shouldRetryServerErrors()) {
                                    throw new com.tencent.beacon.core.network.volley.ServerError(networkResponse);
                                }
                                timeoutError = new com.tencent.beacon.core.network.volley.ServerError(networkResponse);
                                str = "server";
                            }
                        } else {
                            timeoutError = new com.tencent.beacon.core.network.volley.NetworkError();
                            str = "network";
                        }
                        attemptRetryOnException(str, request, timeoutError);
                    } catch (java.io.IOException e5) {
                        e = e5;
                    }
                } catch (java.io.IOException e6) {
                    e = e6;
                    r19 = listEmptyList;
                    httpResponseExecuteRequest = null;
                    bArr = null;
                }
            } catch (java.net.MalformedURLException e7) {
                throw new java.lang.RuntimeException("Bad URL " + request.getUrl(), e7);
            } catch (java.net.SocketTimeoutException unused) {
                timeoutError = new com.tencent.beacon.core.network.volley.TimeoutError();
                str = "socket";
            }
        }
    }
}
