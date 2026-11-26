package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class BaseHttpStack implements com.tencent.beacon.core.network.volley.HttpStack {
    public abstract com.tencent.beacon.core.network.volley.HttpResponse executeRequest(com.tencent.beacon.core.network.volley.Request request, java.util.Map map);

    @Override // com.tencent.beacon.core.network.volley.HttpStack
    @java.lang.Deprecated
    public final org.apache.http.HttpResponse performRequest(com.tencent.beacon.core.network.volley.Request request, java.util.Map map) {
        com.tencent.beacon.core.network.volley.HttpResponse httpResponseExecuteRequest = executeRequest(request, map);
        org.apache.http.message.BasicHttpResponse basicHttpResponse = new org.apache.http.message.BasicHttpResponse(new org.apache.http.message.BasicStatusLine(new org.apache.http.ProtocolVersion("HTTP", 1, 1), httpResponseExecuteRequest.getStatusCode(), ""));
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.tencent.beacon.core.network.volley.Header header : httpResponseExecuteRequest.getHeaders()) {
            arrayList.add(new org.apache.http.message.BasicHeader(header.getName(), header.getValue()));
        }
        basicHttpResponse.setHeaders((org.apache.http.Header[]) arrayList.toArray(new org.apache.http.Header[0]));
        java.io.InputStream content = httpResponseExecuteRequest.getContent();
        if (content != null) {
            org.apache.http.entity.BasicHttpEntity basicHttpEntity = new org.apache.http.entity.BasicHttpEntity();
            basicHttpEntity.setContent(content);
            basicHttpEntity.setContentLength(httpResponseExecuteRequest.getContentLength());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }
}
