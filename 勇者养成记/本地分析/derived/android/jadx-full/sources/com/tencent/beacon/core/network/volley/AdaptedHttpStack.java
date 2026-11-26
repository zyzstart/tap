package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class AdaptedHttpStack extends com.tencent.beacon.core.network.volley.BaseHttpStack {
    private final com.tencent.beacon.core.network.volley.HttpStack mHttpStack;

    AdaptedHttpStack(com.tencent.beacon.core.network.volley.HttpStack httpStack) {
        this.mHttpStack = httpStack;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.beacon.core.network.volley.BaseHttpStack
    public com.tencent.beacon.core.network.volley.HttpResponse executeRequest(com.tencent.beacon.core.network.volley.Request request, java.util.Map map) throws java.io.IOException {
        try {
            org.apache.http.HttpResponse httpResponsePerformRequest = this.mHttpStack.performRequest(request, map);
            int statusCode = httpResponsePerformRequest.getStatusLine().getStatusCode();
            org.apache.http.Header[] allHeaders = httpResponsePerformRequest.getAllHeaders();
            java.util.ArrayList arrayList = new java.util.ArrayList(allHeaders.length);
            for (org.apache.http.Header header : allHeaders) {
                arrayList.add(new com.tencent.beacon.core.network.volley.Header(header.getName(), header.getValue()));
            }
            if (httpResponsePerformRequest.getEntity() == null) {
                return new com.tencent.beacon.core.network.volley.HttpResponse(statusCode, arrayList);
            }
            long contentLength = httpResponsePerformRequest.getEntity().getContentLength();
            if (((int) contentLength) == contentLength) {
                return new com.tencent.beacon.core.network.volley.HttpResponse(statusCode, arrayList, (int) httpResponsePerformRequest.getEntity().getContentLength(), httpResponsePerformRequest.getEntity().getContent());
            }
            throw new java.io.IOException("Response too large: " + contentLength);
        } catch (org.apache.http.conn.ConnectTimeoutException e) {
            throw new java.net.SocketTimeoutException(e.getMessage());
        }
    }
}
