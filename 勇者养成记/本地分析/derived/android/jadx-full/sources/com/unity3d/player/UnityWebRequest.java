package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class UnityWebRequest implements java.lang.Runnable {
    private static final javax.net.ssl.HostnameVerifier k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1618a;
    private java.lang.String b;
    private java.lang.String c;
    private java.util.Map d;
    private boolean e;
    private int f;
    private long g;
    private long h;
    private boolean i;
    private boolean j;

    static {
        if (java.net.CookieHandler.getDefault() == null) {
            java.net.CookieHandler.setDefault(new java.net.CookieManager());
        }
        k = new javax.net.ssl.HostnameVerifier() { // from class: com.unity3d.player.UnityWebRequest.1
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
                return true;
            }
        };
    }

    UnityWebRequest(long j, java.lang.String str, java.util.Map map, java.lang.String str2, boolean z, int i) {
        this.f1618a = j;
        this.b = str2;
        this.c = str;
        this.d = map;
        this.e = z;
        this.f = i;
    }

    static void clearCookieCache(java.lang.String str, java.lang.String str2) {
        java.net.CookieStore cookieStore;
        java.net.CookieHandler cookieHandler = java.net.CookieHandler.getDefault();
        if (cookieHandler == null || !(cookieHandler instanceof java.net.CookieManager) || (cookieStore = ((java.net.CookieManager) cookieHandler).getCookieStore()) == null) {
            return;
        }
        if (str == null) {
            cookieStore.removeAll();
            return;
        }
        try {
            java.net.URI uri = new java.net.URI(null, str, str2, null);
            java.util.List<java.net.HttpCookie> list = cookieStore.get(uri);
            if (list != null) {
                java.util.Iterator<java.net.HttpCookie> it = list.iterator();
                while (it.hasNext()) {
                    cookieStore.remove(uri, it.next());
                }
            }
        } catch (java.net.URISyntaxException unused) {
        }
    }

    private static native void contentLengthCallback(long j, int i);

    private static native boolean downloadCallback(long j, java.nio.ByteBuffer byteBuffer, int i);

    private static native void errorCallback(long j, int i, java.lang.String str);

    private boolean hasTimedOut() {
        return this.f > 0 && java.lang.System.currentTimeMillis() - this.g >= ((long) this.f);
    }

    private static native void headerCallback(long j, java.lang.String str, java.lang.String str2);

    private static native void responseCodeCallback(long j, int i);

    private void runSafe() {
        com.unity3d.player.b.AbstractC0073b abstractC0073b;
        this.g = java.lang.System.currentTimeMillis();
        try {
            java.net.URL url = new java.net.URL(this.b);
            java.net.URLConnection uRLConnectionOpenConnection = url.openConnection();
            uRLConnectionOpenConnection.setConnectTimeout(this.f);
            uRLConnectionOpenConnection.setReadTimeout(this.f);
            java.io.InputStream inputStream = null;
            if (uRLConnectionOpenConnection instanceof javax.net.ssl.HttpsURLConnection) {
                javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) uRLConnectionOpenConnection;
                if (this.e) {
                    abstractC0073b = new com.unity3d.player.b.AbstractC0073b() { // from class: com.unity3d.player.UnityWebRequest.2
                        @Override // com.unity3d.player.b.AbstractC0073b, javax.net.ssl.X509TrustManager
                        public final void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
                            if (!com.unity3d.player.UnityWebRequest.this.validateCertificateCallback((x509CertificateArr == null || x509CertificateArr.length <= 0) ? new byte[0] : x509CertificateArr[0].getEncoded())) {
                                throw new java.security.cert.CertificateException();
                            }
                        }
                    };
                    httpsURLConnection.setHostnameVerifier(k);
                } else {
                    abstractC0073b = null;
                }
                javax.net.ssl.SSLSocketFactory sSLSocketFactoryA = com.unity3d.player.b.a(abstractC0073b);
                if (sSLSocketFactoryA != null) {
                    httpsURLConnection.setSSLSocketFactory(sSLSocketFactoryA);
                }
            }
            if (url.getProtocol().equalsIgnoreCase("file") && !url.getHost().isEmpty()) {
                malformattedUrlCallback("file:// must use an absolute path");
                return;
            }
            boolean z = uRLConnectionOpenConnection instanceof java.net.HttpURLConnection;
            if (z) {
                try {
                    java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) uRLConnectionOpenConnection;
                    httpURLConnection.setRequestMethod(this.c);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    if (this.h > 0) {
                        if (this.j) {
                            httpURLConnection.setChunkedStreamingMode(0);
                        } else {
                            httpURLConnection.setFixedLengthStreamingMode((int) this.h);
                        }
                        if (this.i) {
                            httpURLConnection.addRequestProperty("Expect", "100-continue");
                        }
                    }
                } catch (java.net.ProtocolException e) {
                    badProtocolCallback(e.toString());
                    return;
                }
            }
            java.util.Map map = this.d;
            if (map != null) {
                for (java.util.Map.Entry entry : map.entrySet()) {
                    uRLConnectionOpenConnection.addRequestProperty((java.lang.String) entry.getKey(), (java.lang.String) entry.getValue());
                }
            }
            java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(131072);
            if (uploadCallback(null) > 0) {
                uRLConnectionOpenConnection.setDoOutput(true);
                try {
                    java.io.OutputStream outputStream = uRLConnectionOpenConnection.getOutputStream();
                    while (true) {
                        int iUploadCallback = uploadCallback(byteBufferAllocateDirect);
                        if (iUploadCallback <= 0) {
                            break;
                        }
                        if (hasTimedOut()) {
                            outputStream.close();
                            errorCallback(this.f1618a, 14, "WebRequest timed out.");
                            return;
                        }
                        outputStream.write(byteBufferAllocateDirect.array(), byteBufferAllocateDirect.arrayOffset(), iUploadCallback);
                    }
                } catch (java.lang.Exception e2) {
                    errorCallback(e2.toString());
                    return;
                }
            }
            if (z) {
                try {
                    responseCodeCallback(((java.net.HttpURLConnection) uRLConnectionOpenConnection).getResponseCode());
                } catch (java.net.SocketTimeoutException e3) {
                    errorCallback(this.f1618a, 14, e3.toString());
                    return;
                } catch (java.net.UnknownHostException e4) {
                    unknownHostCallback(e4.toString());
                    return;
                } catch (javax.net.ssl.SSLException e5) {
                    sslCannotConnectCallback(e5);
                    return;
                } catch (java.io.IOException e6) {
                    errorCallback(e6.toString());
                    return;
                }
            }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = uRLConnectionOpenConnection.getHeaderFields();
            headerCallback(headerFields);
            if ((headerFields == null || !headerFields.containsKey("content-length")) && uRLConnectionOpenConnection.getContentLength() != -1) {
                headerCallback("content-length", java.lang.String.valueOf(uRLConnectionOpenConnection.getContentLength()));
            }
            if ((headerFields == null || !headerFields.containsKey("content-type")) && uRLConnectionOpenConnection.getContentType() != null) {
                headerCallback("content-type", uRLConnectionOpenConnection.getContentType());
            }
            if (headerFields != null && headerFields.containsKey("Set-Cookie") && java.net.CookieHandler.getDefault() != null && (java.net.CookieHandler.getDefault() instanceof java.net.CookieManager)) {
                java.net.CookieStore cookieStore = ((java.net.CookieManager) java.net.CookieHandler.getDefault()).getCookieStore();
                java.util.Iterator<java.lang.String> it = headerFields.get("Set-Cookie").iterator();
                while (it.hasNext()) {
                    try {
                        java.net.HttpCookie httpCookie = java.net.HttpCookie.parse(it.next()).get(0);
                        if (httpCookie.getPath() != null && !httpCookie.getPath().equals("") && (httpCookie.getDomain() == null || httpCookie.getDomain().equals(url.getHost()))) {
                            java.net.URI uri = new java.net.URI(url.getProtocol(), url.getHost(), httpCookie.getPath(), null);
                            httpCookie.setDomain(url.getHost());
                            cookieStore.add(uri, httpCookie);
                        }
                    } catch (java.net.URISyntaxException e7) {
                        com.unity3d.player.g.Log(6, "UnityWebRequest: error constructing URI: " + e7.getMessage());
                    }
                }
            }
            contentLengthCallback(uRLConnectionOpenConnection.getContentLength());
            try {
                if (uRLConnectionOpenConnection instanceof java.net.HttpURLConnection) {
                    java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) uRLConnectionOpenConnection;
                    responseCodeCallback(httpURLConnection2.getResponseCode());
                    inputStream = httpURLConnection2.getErrorStream();
                }
                if (inputStream == null) {
                    inputStream = uRLConnectionOpenConnection.getInputStream();
                }
                java.nio.channels.ReadableByteChannel readableByteChannelNewChannel = java.nio.channels.Channels.newChannel(inputStream);
                while (true) {
                    int i = readableByteChannelNewChannel.read(byteBufferAllocateDirect);
                    if (i == -1) {
                        break;
                    }
                    if (hasTimedOut()) {
                        readableByteChannelNewChannel.close();
                        errorCallback(this.f1618a, 14, "WebRequest timed out.");
                        return;
                    } else if (!downloadCallback(byteBufferAllocateDirect, i)) {
                        break;
                    } else {
                        byteBufferAllocateDirect.clear();
                    }
                }
                readableByteChannelNewChannel.close();
            } catch (java.net.SocketTimeoutException e8) {
                errorCallback(this.f1618a, 14, e8.toString());
            } catch (java.net.UnknownHostException e9) {
                unknownHostCallback(e9.toString());
            } catch (javax.net.ssl.SSLException e10) {
                sslCannotConnectCallback(e10);
            } catch (java.io.IOException e11) {
                errorCallback(this.f1618a, 12, e11.toString());
            } catch (java.lang.Exception e12) {
                errorCallback(e12.toString());
            }
        } catch (java.net.MalformedURLException e13) {
            malformattedUrlCallback(e13.toString());
        } catch (java.io.IOException e14) {
            errorCallback(e14.toString());
        }
    }

    private static native int uploadCallback(long j, java.nio.ByteBuffer byteBuffer);

    private static native boolean validateCertificateCallback(long j, byte[] bArr);

    protected void badProtocolCallback(java.lang.String str) {
        errorCallback(this.f1618a, 4, str);
    }

    protected void contentLengthCallback(int i) {
        contentLengthCallback(this.f1618a, i);
    }

    protected boolean downloadCallback(java.nio.ByteBuffer byteBuffer, int i) {
        return downloadCallback(this.f1618a, byteBuffer, i);
    }

    protected void errorCallback(java.lang.String str) {
        errorCallback(this.f1618a, 2, str);
    }

    protected void headerCallback(java.lang.String str, java.lang.String str2) {
        headerCallback(this.f1618a, str, str2);
    }

    protected void headerCallback(java.util.Map map) {
        if (map == null || map.size() == 0) {
            return;
        }
        for (java.util.Map.Entry entry : map.entrySet()) {
            java.lang.String str = (java.lang.String) entry.getKey();
            if (str == null) {
                str = "Status";
            }
            java.util.Iterator it = ((java.util.List) entry.getValue()).iterator();
            while (it.hasNext()) {
                headerCallback(str, (java.lang.String) it.next());
            }
        }
    }

    protected void malformattedUrlCallback(java.lang.String str) {
        errorCallback(this.f1618a, 5, str);
    }

    protected void responseCodeCallback(int i) {
        responseCodeCallback(this.f1618a, i);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            runSafe();
        } catch (java.lang.Exception e) {
            errorCallback(e.toString());
        }
    }

    void setupTransferSettings(long j, boolean z, boolean z2) {
        this.h = j;
        this.i = z;
        this.j = z2;
    }

    protected void sslCannotConnectCallback(javax.net.ssl.SSLException sSLException) {
        int i;
        java.lang.String string = sSLException.toString();
        for (java.lang.Throwable cause = sSLException; cause != null; cause = cause.getCause()) {
            if (cause instanceof javax.net.ssl.SSLKeyException) {
                i = 23;
            } else if ((cause instanceof javax.net.ssl.SSLPeerUnverifiedException) || (cause instanceof java.security.cert.CertPathValidatorException)) {
                i = 25;
            }
            errorCallback(this.f1618a, i, string);
        }
        i = 16;
        errorCallback(this.f1618a, i, string);
    }

    protected void unknownHostCallback(java.lang.String str) {
        errorCallback(this.f1618a, 7, str);
    }

    protected int uploadCallback(java.nio.ByteBuffer byteBuffer) {
        return uploadCallback(this.f1618a, byteBuffer);
    }

    protected boolean validateCertificateCallback(byte[] bArr) {
        return validateCertificateCallback(this.f1618a, bArr);
    }
}
