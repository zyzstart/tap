package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HurlStack extends com.tencent.beacon.core.network.volley.BaseHttpStack {
    private static final int HTTP_CONTINUE = 100;
    private final javax.net.ssl.SSLSocketFactory mSslSocketFactory;
    private final com.tencent.beacon.core.network.volley.HurlStack.UrlRewriter mUrlRewriter;

    static class UrlConnectionInputStream extends java.io.FilterInputStream {
        private final java.net.HttpURLConnection mConnection;

        UrlConnectionInputStream(java.net.HttpURLConnection httpURLConnection) {
            super(com.tencent.beacon.core.network.volley.HurlStack.inputStreamFromConnection(httpURLConnection));
            this.mConnection = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            super.close();
            this.mConnection.disconnect();
        }
    }

    public interface UrlRewriter {
        java.lang.String rewriteUrl(java.lang.String str);
    }

    public HurlStack() {
        this(null);
    }

    public HurlStack(com.tencent.beacon.core.network.volley.HurlStack.UrlRewriter urlRewriter) {
        this(urlRewriter, null);
    }

    public HurlStack(com.tencent.beacon.core.network.volley.HurlStack.UrlRewriter urlRewriter, javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        this.mUrlRewriter = urlRewriter;
        this.mSslSocketFactory = sSLSocketFactory;
    }

    private static void addBody(java.net.HttpURLConnection httpURLConnection, com.tencent.beacon.core.network.volley.Request request, byte[] bArr) {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", request.getBodyContentType());
        }
        java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    private static void addBodyIfExists(java.net.HttpURLConnection httpURLConnection, com.tencent.beacon.core.network.volley.Request request) {
        byte[] body = request.getBody();
        if (body != null) {
            addBody(httpURLConnection, request, body);
        }
    }

    static java.util.List convertHeaders(java.util.Map map) {
        java.util.ArrayList arrayList = new java.util.ArrayList(map.size());
        for (java.util.Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                java.util.Iterator it = ((java.util.List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.tencent.beacon.core.network.volley.Header((java.lang.String) entry.getKey(), (java.lang.String) it.next()));
                }
            }
        }
        return arrayList;
    }

    private static boolean hasResponseBody(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.io.InputStream inputStreamFromConnection(java.net.HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (java.io.IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private java.net.HttpURLConnection openConnection(java.net.URL url, com.tencent.beacon.core.network.volley.Request request) {
        javax.net.ssl.SSLSocketFactory sSLSocketFactory;
        java.net.HttpURLConnection httpURLConnectionCreateConnection = createConnection(url);
        int timeoutMs = request.getTimeoutMs();
        httpURLConnectionCreateConnection.setConnectTimeout(timeoutMs);
        httpURLConnectionCreateConnection.setReadTimeout(timeoutMs);
        httpURLConnectionCreateConnection.setUseCaches(false);
        httpURLConnectionCreateConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.mSslSocketFactory) != null) {
            ((javax.net.ssl.HttpsURLConnection) httpURLConnectionCreateConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        return httpURLConnectionCreateConnection;
    }

    static void setConnectionParametersForRequest(java.net.HttpURLConnection httpURLConnection, com.tencent.beacon.core.network.volley.Request request) throws java.net.ProtocolException {
        java.lang.String str;
        java.lang.String str2;
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                    addBody(httpURLConnection, request, postBody);
                    return;
                }
                return;
            case 0:
                str = com.tencent.connect.common.Constants.HTTP_GET;
                httpURLConnection.setRequestMethod(str);
                return;
            case 1:
                str2 = com.tencent.connect.common.Constants.HTTP_POST;
                httpURLConnection.setRequestMethod(str2);
                addBodyIfExists(httpURLConnection, request);
                return;
            case 2:
                str2 = "PUT";
                httpURLConnection.setRequestMethod(str2);
                addBodyIfExists(httpURLConnection, request);
                return;
            case 3:
                str = "DELETE";
                httpURLConnection.setRequestMethod(str);
                return;
            case 4:
                str = "HEAD";
                httpURLConnection.setRequestMethod(str);
                return;
            case 5:
                str = "OPTIONS";
                httpURLConnection.setRequestMethod(str);
                return;
            case 6:
                str = "TRACE";
                httpURLConnection.setRequestMethod(str);
                return;
            case 7:
                str2 = "PATCH";
                httpURLConnection.setRequestMethod(str2);
                addBodyIfExists(httpURLConnection, request);
                return;
            default:
                throw new java.lang.IllegalStateException("Unknown method type.");
        }
    }

    protected java.net.HttpURLConnection createConnection(java.net.URL url) {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(java.net.HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.beacon.core.network.volley.BaseHttpStack
    public com.tencent.beacon.core.network.volley.HttpResponse executeRequest(com.tencent.beacon.core.network.volley.Request request, java.util.Map map) throws java.io.IOException {
        java.lang.String strRewriteUrl;
        java.lang.String url = request.getUrl();
        java.util.HashMap map2 = new java.util.HashMap();
        map2.putAll(map);
        map2.putAll(request.getHeaders());
        com.tencent.beacon.core.network.volley.HurlStack.UrlRewriter urlRewriter = this.mUrlRewriter;
        if (urlRewriter != null) {
            strRewriteUrl = urlRewriter.rewriteUrl(url);
            if (strRewriteUrl == null) {
                throw new java.io.IOException("URL blocked by rewriter: " + url);
            }
        } else {
            strRewriteUrl = url;
        }
        java.net.HttpURLConnection httpURLConnectionOpenConnection = openConnection(new java.net.URL(strRewriteUrl), request);
        try {
            for (java.lang.String str : map2.keySet()) {
                httpURLConnectionOpenConnection.setRequestProperty(str, (java.lang.String) map2.get(str));
            }
            setConnectionParametersForRequest(httpURLConnectionOpenConnection, request);
            int responseCode = httpURLConnectionOpenConnection.getResponseCode();
            if (responseCode == -1) {
                throw new java.io.IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (hasResponseBody(request.getMethod(), responseCode)) {
                return new com.tencent.beacon.core.network.volley.HttpResponse(responseCode, convertHeaders(httpURLConnectionOpenConnection.getHeaderFields()), httpURLConnectionOpenConnection.getContentLength(), new com.tencent.beacon.core.network.volley.HurlStack.UrlConnectionInputStream(httpURLConnectionOpenConnection));
            }
            com.tencent.beacon.core.network.volley.HttpResponse httpResponse = new com.tencent.beacon.core.network.volley.HttpResponse(responseCode, convertHeaders(httpURLConnectionOpenConnection.getHeaderFields()));
            httpURLConnectionOpenConnection.disconnect();
            return httpResponse;
        } catch (java.lang.Throwable th) {
            if (0 == 0) {
                httpURLConnectionOpenConnection.disconnect();
            }
            throw th;
        }
    }
}
