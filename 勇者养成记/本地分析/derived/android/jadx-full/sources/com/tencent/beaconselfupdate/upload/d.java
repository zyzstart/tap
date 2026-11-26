package com.tencent.beaconselfupdate.upload;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.beaconselfupdate.upload.d f270a;

    public final class a extends com.tencent.beaconselfupdate.upload.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private android.content.Context f271a;

        public a(android.content.Context context) {
            this.f271a = context;
        }

        /* JADX WARN: Code duplicated, block: B:33:0x009b  */
        /* JADX WARN: Code duplicated, block: B:35:0x00a4  */
        private static com.tencent.beaconselfupdate.upload.b a(java.lang.String str, byte[] bArr, java.lang.String str2, int i) throws java.lang.Exception {
            org.apache.http.client.HttpClient httpClientA;
            org.apache.http.client.methods.HttpPost httpPost;
            if (str == null) {
                com.tencent.beaconselfupdate.c.a.d("no destUrl!", new java.lang.Object[0]);
                return null;
            }
            try {
                org.apache.http.entity.ByteArrayEntity byteArrayEntity = bArr != null ? new org.apache.http.entity.ByteArrayEntity(bArr) : new org.apache.http.entity.ByteArrayEntity("".getBytes());
                httpClientA = a(str2, i);
                try {
                    if (httpClientA == null) {
                        com.tencent.beaconselfupdate.c.a.d("no httpClient!", new java.lang.Object[0]);
                        return null;
                    }
                    httpPost = new org.apache.http.client.methods.HttpPost(str);
                    try {
                        httpPost.setHeader("wup_version", "3.0");
                        httpPost.setHeader("TYPE_COMPRESS", "2");
                        httpPost.setHeader("encr_type", "rsapost");
                        com.tencent.beaconselfupdate.a.b.d dVarA = com.tencent.beaconselfupdate.a.b.d.a();
                        if (dVarA != null) {
                            httpPost.setHeader("bea_key", dVarA.j());
                        }
                        httpPost.setEntity(byteArrayEntity);
                        org.apache.http.protocol.BasicHttpContext basicHttpContext = new org.apache.http.protocol.BasicHttpContext();
                        org.apache.http.HttpResponse httpResponseExecute = httpClientA.execute(httpPost, basicHttpContext);
                        com.tencent.beaconselfupdate.c.a.h("execute request:\n %s", ((org.apache.http.HttpRequest) basicHttpContext.getAttribute("http.request")).getRequestLine().toString());
                        return new com.tencent.beaconselfupdate.upload.b(httpResponseExecute, httpPost, httpClientA);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        com.tencent.beaconselfupdate.c.a.a(th);
                        com.tencent.beaconselfupdate.c.a.d("execute error:%s", th.toString());
                        if (httpClientA != null) {
                            httpClientA.getConnectionManager().shutdown();
                        }
                        if (httpPost != null) {
                            httpPost.abort();
                        }
                        throw new java.lang.Exception(th.toString());
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    httpPost = null;
                    com.tencent.beaconselfupdate.c.a.a(th);
                    com.tencent.beaconselfupdate.c.a.d("execute error:%s", th.toString());
                    if (httpClientA != null) {
                        httpClientA.getConnectionManager().shutdown();
                    }
                    if (httpPost != null) {
                        httpPost.abort();
                    }
                    throw new java.lang.Exception(th.toString());
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                httpClientA = null;
            }
        }

        private static org.apache.http.client.HttpClient a(java.lang.String str, int i) {
            org.apache.http.impl.client.DefaultHttpClient defaultHttpClient;
            try {
                org.apache.http.params.BasicHttpParams basicHttpParams = new org.apache.http.params.BasicHttpParams();
                org.apache.http.params.HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
                org.apache.http.params.HttpConnectionParams.setSoTimeout(basicHttpParams, cn.yunzhisheng.asr.a.b);
                org.apache.http.params.HttpConnectionParams.setSocketBufferSize(basicHttpParams, 2000);
                basicHttpParams.setBooleanParameter("http.protocol.handle-redirects", false);
                defaultHttpClient = new org.apache.http.impl.client.DefaultHttpClient(basicHttpParams);
                try {
                    org.apache.http.params.HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                    defaultHttpClient.setHttpRequestRetryHandler(new org.apache.http.client.HttpRequestRetryHandler() { // from class: com.tencent.beaconselfupdate.upload.d.a.1
                        @Override // org.apache.http.client.HttpRequestRetryHandler
                        public final boolean retryRequest(java.io.IOException iOException, int i2, org.apache.http.protocol.HttpContext httpContext) {
                            if (i2 >= 3) {
                                return false;
                            }
                            return (iOException instanceof org.apache.http.NoHttpResponseException) || (iOException instanceof org.apache.http.client.ClientProtocolException);
                        }
                    });
                    if (str == null || !str.toLowerCase(java.util.Locale.US).contains("wap") || i == 2) {
                        if (str != null) {
                            com.tencent.beaconselfupdate.c.a.a("Don't use proxy: %s, try time: %s", str, java.lang.Integer.valueOf(i));
                        }
                        defaultHttpClient.getParams().removeParameter("http.route.default-proxy");
                    } else {
                        com.tencent.beaconselfupdate.c.a.a("use proxy: %s, try time: %s", str, java.lang.Integer.valueOf(i));
                        defaultHttpClient.getParams().setParameter("http.route.default-proxy", new org.apache.http.HttpHost(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort()));
                    }
                    return defaultHttpClient;
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.tencent.beaconselfupdate.c.a.a(th);
                    com.tencent.beaconselfupdate.c.a.d("httpclient error!", new java.lang.Object[0]);
                    if (defaultHttpClient != null) {
                        defaultHttpClient.getConnectionManager().shutdown();
                    }
                    return null;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                defaultHttpClient = null;
            }
        }

        private static void a(com.tencent.beaconselfupdate.upload.b bVar) {
            try {
                if (bVar.b != null) {
                    bVar.b.abort();
                }
                if (bVar.c != null) {
                    bVar.c.getConnectionManager().shutdown();
                }
            } catch (java.lang.Exception unused) {
            }
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00b4 A[DONT_GENERATE, PHI: r0
  0x00b4: PHI (r0v3 byte[]) = (r0v0 byte[]), (r0v6 byte[]) binds: [B:42:0x00b2, B:28:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private byte[] a(org.apache.http.HttpResponse httpResponse, org.apache.http.client.methods.HttpPost httpPost) {
            java.io.BufferedInputStream bufferedInputStream;
            byte[] byteArray = null;
            if (httpResponse == null) {
                return null;
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                com.tencent.beaconselfupdate.c.a.c("request failure code:%d , line:%s ", java.lang.Integer.valueOf(statusCode), httpResponse.getStatusLine());
                return null;
            }
            if (httpResponse.containsHeader(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID) && httpResponse.containsHeader("max_time")) {
                com.tencent.beaconselfupdate.a.b.d.a().a(this.f271a, httpResponse.getFirstHeader(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID).getValue(), httpResponse.getFirstHeader("max_time").getValue());
            }
            org.apache.http.HttpEntity entity = httpResponse.getEntity();
            if (entity == null) {
                com.tencent.beaconselfupdate.c.a.d("no response datas!", new java.lang.Object[0]);
                return null;
            }
            try {
                bufferedInputStream = new java.io.BufferedInputStream(new java.io.DataInputStream(entity.getContent()));
                try {
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(128);
                    while (true) {
                        int i = bufferedInputStream.read();
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(i);
                    }
                    byteArrayOutputStream.flush();
                    byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        bufferedInputStream.close();
                    } catch (java.lang.Throwable th) {
                        com.tencent.beaconselfupdate.c.a.a(th);
                    }
                    if (httpPost != null) {
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    try {
                        com.tencent.beaconselfupdate.c.a.a(th);
                        com.tencent.beaconselfupdate.c.a.d("read error %s", th.toString());
                    } finally {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (java.lang.Throwable th3) {
                                com.tencent.beaconselfupdate.c.a.a(th3);
                            }
                        }
                        if (httpPost != null) {
                            httpPost.abort();
                        }
                    }
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
            return byteArray;
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00d8  */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.tencent.beaconselfupdate.upload.d
        public final byte[] a(java.lang.String str, byte[] bArr, com.tencent.beaconselfupdate.upload.a aVar) throws java.lang.Exception {
            java.lang.StringBuilder sb;
            java.lang.String str2;
            long contentLength;
            java.lang.Object obj;
            if (str == null) {
                com.tencent.beaconselfupdate.c.a.d("no destUrl!", new java.lang.Object[0]);
                return null;
            }
            long j = 0;
            int i = 2;
            com.tencent.beaconselfupdate.c.a.h("start req: %s sz:%d", str, java.lang.Long.valueOf(bArr == null ? 0L : bArr.length));
            java.lang.String str3 = str;
            java.lang.String string = "";
            com.tencent.beaconselfupdate.upload.b bVarA = null;
            java.lang.String str4 = "";
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            while (true) {
                int i4 = i2 + 1;
                if (i2 >= 3 || i3 >= i) {
                    break;
                }
                if (z) {
                    throw new java.lang.Exception("net redirect");
                }
                if (i4 > 1) {
                    com.tencent.beaconselfupdate.c.a.h("try time:" + i4, new java.lang.Object[0]);
                    if (i4 == i && aVar.c() == i) {
                        aVar.b(false);
                    }
                    try {
                        java.lang.Thread.sleep(5000L);
                    } catch (java.lang.InterruptedException e) {
                        com.tencent.beaconselfupdate.c.a.a(e);
                    }
                }
                java.lang.String strN = com.tencent.beaconselfupdate.a.e.n(this.f271a);
                new java.util.Date().getTime();
                try {
                    bVarA = a(str3, bArr, strN, i4);
                } catch (java.lang.Exception e2) {
                    java.lang.String string2 = e2.toString();
                    if (str4.equals(string2)) {
                        sb = new java.lang.StringBuilder();
                        sb.append(string);
                        sb.append(i4);
                        str2 = ":same ";
                    } else {
                        sb = new java.lang.StringBuilder();
                        sb.append(string);
                        sb.append(i4);
                        sb.append(":");
                        sb.append(string2);
                        str2 = " ";
                    }
                    sb.append(str2);
                    string = sb.toString();
                    str4 = string2;
                }
                new java.util.Date().getTime();
                if (bVarA != null) {
                    org.apache.http.HttpResponse httpResponse = bVarA.f269a;
                    org.apache.http.HttpEntity entity = httpResponse.getEntity();
                    if (entity != null) {
                        contentLength = entity.getContentLength();
                        if (contentLength < j) {
                            contentLength = j;
                        }
                    } else {
                        contentLength = j;
                    }
                    int statusCode = httpResponse.getStatusLine().getStatusCode();
                    com.tencent.beaconselfupdate.c.a.h("response code:%d ", java.lang.Integer.valueOf(statusCode));
                    com.tencent.beaconselfupdate.c.a.h("contentLength:%d ", java.lang.Long.valueOf(contentLength));
                    if (statusCode == 200) {
                        if (!httpResponse.containsHeader("encrypt-status")) {
                            return a(httpResponse, bVarA.b);
                        }
                        a(bVarA);
                        com.tencent.beaconselfupdate.c.a.d("svr encry failed: " + httpResponse.getFirstHeader("encrypt-status").getValue(), new java.lang.Object[0]);
                        return null;
                    }
                    if (statusCode == 301 || statusCode == 302 || statusCode == 303 || statusCode == 307) {
                        org.apache.http.Header firstHeader = httpResponse.getFirstHeader("Location");
                        if (firstHeader == null) {
                            com.tencent.beaconselfupdate.c.a.d("redirect code:" + statusCode + " Location is null! return", new java.lang.Object[0]);
                            a(bVarA);
                            return null;
                        }
                        obj = null;
                        i3++;
                        java.lang.String value = firstHeader.getValue();
                        i = 2;
                        com.tencent.beaconselfupdate.c.a.h("redirect code:%d , to:%s", java.lang.Integer.valueOf(statusCode), value);
                        str3 = value;
                        i2 = 0;
                        z = true;
                    } else {
                        obj = null;
                        i = 2;
                        i2 = i4;
                    }
                    a(bVarA);
                    j = 0;
                } else {
                    i2 = i4;
                }
            }
            throw new java.lang.Exception(string);
        }
    }

    public static synchronized com.tencent.beaconselfupdate.upload.d a(android.content.Context context) {
        if (f270a == null && context != null) {
            f270a = new com.tencent.beaconselfupdate.upload.d.a(context);
        }
        return f270a;
    }

    public abstract byte[] a(java.lang.String str, byte[] bArr, com.tencent.beaconselfupdate.upload.a aVar);
}
