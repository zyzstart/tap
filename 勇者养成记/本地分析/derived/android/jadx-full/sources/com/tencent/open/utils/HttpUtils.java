package com.tencent.open.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HttpUtils {

    public static class HttpStatusException extends java.lang.Exception {
        public static final java.lang.String ERROR_INFO = "http status code error:";

        public HttpStatusException(java.lang.String str) {
            super(str);
        }
    }

    public static class NetworkUnavailableException extends java.lang.Exception {
        public static final java.lang.String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(java.lang.String str) {
            super(str);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final java.lang.String f716a;
        public final int b;

        private a(java.lang.String str, int i) {
            this.f716a = str;
            this.b = i;
        }
    }

    private HttpUtils() {
    }

    private static int a(android.content.Context context) {
        int port;
        if (android.os.Build.VERSION.SDK_INT < 11) {
            return (context == null || (port = android.net.Proxy.getPort(context)) < 0) ? android.net.Proxy.getDefaultPort() : port;
        }
        java.lang.String property = java.lang.System.getProperty("http.proxyPort");
        if (!android.text.TextUtils.isEmpty(property)) {
            try {
                return java.lang.Integer.parseInt(property);
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return -1;
    }

    private static java.lang.String a(org.apache.http.HttpResponse httpResponse) throws java.io.IOException {
        java.io.InputStream content = httpResponse.getEntity().getContent();
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        org.apache.http.Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        java.io.InputStream gZIPInputStream = (firstHeader == null || firstHeader.getValue().toLowerCase().indexOf("gzip") <= -1) ? content : new java.util.zip.GZIPInputStream(content);
        byte[] bArr = new byte[512];
        while (true) {
            int i = gZIPInputStream.read(bArr);
            if (i == -1) {
                java.lang.String str = new java.lang.String(byteArrayOutputStream.toByteArray(), "UTF-8");
                gZIPInputStream.close();
                return str;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    private static void a(android.content.Context context, com.tencent.connect.auth.QQToken qQToken, java.lang.String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            com.tencent.connect.a.a.a(context, qQToken, "[REDACTED]", str);
        }
    }

    private static java.lang.String b(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            return java.lang.System.getProperty("http.proxyHost");
        }
        if (context != null) {
            java.lang.String host = android.net.Proxy.getHost(context);
            if (!android.text.TextUtils.isEmpty(host)) {
                return host;
            }
        }
        return android.net.Proxy.getDefaultHost();
    }

    public static java.lang.String encodePostBody(android.os.Bundle bundle, java.lang.String str) {
        if (bundle == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = -1;
        int size = bundle.size();
        for (java.lang.String str2 : bundle.keySet()) {
            i++;
            java.lang.Object obj = bundle.get(str2);
            if (obj instanceof java.lang.String) {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"" + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE + ((java.lang.String) obj));
                if (i < size - 1) {
                    sb.append("\r\n--" + str + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE);
                }
            }
        }
        return sb.toString();
    }

    public static java.lang.String encodeUrl(android.os.Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = true;
        for (java.lang.String str : bundle.keySet()) {
            java.lang.Object obj = bundle.get(str);
            if ((obj instanceof java.lang.String) || (obj instanceof java.lang.String[])) {
                if (obj instanceof java.lang.String[]) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(java.net.URLEncoder.encode(str) + "=");
                    java.lang.String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        for (int i = 0; i < stringArray.length; i++) {
                            sb.append(java.net.URLEncoder.encode(i == 0 ? stringArray[i] : "," + stringArray[i]));
                        }
                    }
                } else {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(java.net.URLEncoder.encode(str) + "=" + java.net.URLEncoder.encode(bundle.getString(str)));
                }
            }
        }
        return sb.toString();
    }

    public static int getErrorCodeFromException(java.io.IOException iOException) {
        if (iOException instanceof java.io.CharConversionException) {
            return -20;
        }
        if (iOException instanceof java.nio.charset.MalformedInputException) {
            return -21;
        }
        if (iOException instanceof java.nio.charset.UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof org.apache.http.client.HttpResponseException) {
            return -23;
        }
        if (iOException instanceof java.nio.channels.ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof org.apache.http.ConnectionClosedException) {
            return -25;
        }
        if (iOException instanceof java.io.EOFException) {
            return -26;
        }
        if (iOException instanceof java.nio.channels.FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof java.io.FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof java.net.HttpRetryException) {
            return -29;
        }
        if (iOException instanceof org.apache.http.conn.ConnectTimeoutException) {
            return -7;
        }
        if (iOException instanceof java.net.SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof java.util.InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof org.apache.http.MalformedChunkCodingException) {
            return -31;
        }
        if (iOException instanceof java.net.MalformedURLException) {
            return -3;
        }
        if (iOException instanceof org.apache.http.NoHttpResponseException) {
            return -32;
        }
        if (iOException instanceof java.io.InvalidClassException) {
            return -33;
        }
        if (iOException instanceof java.io.InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof java.io.NotActiveException) {
            return -35;
        }
        if (iOException instanceof java.io.NotSerializableException) {
            return -36;
        }
        if (iOException instanceof java.io.OptionalDataException) {
            return -37;
        }
        if (iOException instanceof java.io.StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof java.io.WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof java.net.ProtocolException) {
            return -40;
        }
        if (iOException instanceof javax.net.ssl.SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof javax.net.ssl.SSLKeyException) {
            return -42;
        }
        if (iOException instanceof javax.net.ssl.SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof javax.net.ssl.SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof java.net.BindException) {
            return -45;
        }
        if (iOException instanceof java.net.ConnectException) {
            return -46;
        }
        if (iOException instanceof java.net.NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof java.net.PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof java.io.SyncFailedException) {
            return -49;
        }
        if (iOException instanceof java.io.UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof java.net.UnknownHostException) {
            return -51;
        }
        if (iOException instanceof java.net.UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof java.io.UnsupportedEncodingException) {
            return -53;
        }
        return iOException instanceof java.util.zip.ZipException ? -54 : -2;
    }

    public static org.apache.http.client.HttpClient getHttpClient(android.content.Context context, java.lang.String str, java.lang.String str2) {
        int iA;
        org.apache.http.conn.scheme.Scheme scheme;
        org.apache.http.conn.scheme.SchemeRegistry schemeRegistry = new org.apache.http.conn.scheme.SchemeRegistry();
        schemeRegistry.register(new org.apache.http.conn.scheme.Scheme("http", org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory(), 80));
        try {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                org.apache.http.conn.ssl.SSLSocketFactory socketFactory = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
                socketFactory.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                scheme = new org.apache.http.conn.scheme.Scheme("https", socketFactory, 443);
            } else {
                scheme = new org.apache.http.conn.scheme.Scheme("https", new com.tencent.open.utils.k(), 443);
            }
            schemeRegistry.register(scheme);
        } catch (java.lang.Exception unused) {
            schemeRegistry.register(new org.apache.http.conn.scheme.Scheme("https", org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory(), 443));
        }
        org.apache.http.params.BasicHttpParams basicHttpParams = new org.apache.http.params.BasicHttpParams();
        com.tencent.open.utils.g gVarA = context != null ? com.tencent.open.utils.g.a(context, str) : null;
        int iA2 = 0;
        if (gVarA != null) {
            iA2 = gVarA.a("Common_HttpConnectionTimeout");
            iA = gVarA.a("Common_SocketConnectionTimeout");
        } else {
            iA = 0;
        }
        if (iA2 == 0) {
            iA2 = 15000;
        }
        if (iA == 0) {
            iA = 30000;
        }
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(basicHttpParams, iA2);
        org.apache.http.params.HttpConnectionParams.setSoTimeout(basicHttpParams, iA);
        org.apache.http.params.HttpProtocolParams.setVersion(basicHttpParams, org.apache.http.HttpVersion.HTTP_1_1);
        org.apache.http.params.HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        org.apache.http.params.HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + android.os.Build.VERSION.SDK + "_" + android.os.Build.DEVICE + "_" + android.os.Build.VERSION.RELEASE);
        org.apache.http.impl.client.DefaultHttpClient defaultHttpClient = new org.apache.http.impl.client.DefaultHttpClient(new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        com.tencent.open.utils.HttpUtils.a proxy = getProxy(context);
        if (proxy != null) {
            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new org.apache.http.HttpHost(proxy.f716a, proxy.b));
        }
        return defaultHttpClient;
    }

    public static com.tencent.open.utils.HttpUtils.a getProxy(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        android.net.NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() == 0) {
            java.lang.String strB = b(context);
            int iA = a(context);
            if (!android.text.TextUtils.isEmpty(strB) && iA >= 0) {
                return new com.tencent.open.utils.HttpUtils.a(strB, iA);
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static com.tencent.open.utils.l.a openUrl2(android.content.Context context, java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
        java.lang.StringBuilder sb;
        java.lang.String str3;
        android.net.ConnectivityManager connectivityManager;
        android.net.NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity")) != null && ((activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable())) {
            throw new com.tencent.open.utils.HttpUtils.NetworkUnavailableException(com.tencent.open.utils.HttpUtils.NetworkUnavailableException.ERROR_INFO);
        }
        android.os.Bundle bundle2 = bundle != null ? new android.os.Bundle(bundle) : new android.os.Bundle();
        java.lang.String string = bundle2.getString("appid_for_getting_config");
        bundle2.remove("appid_for_getting_config");
        org.apache.http.client.HttpClient httpClient = getHttpClient(context, string, str);
        org.apache.http.client.methods.HttpUriRequest httpUriRequest = null;
        int length = 0;
        int i = -1;
        if (str2.equals(com.tencent.connect.common.Constants.HTTP_GET)) {
            java.lang.String strEncodeUrl = encodeUrl(bundle2);
            length = 0 + strEncodeUrl.length();
            com.tencent.open.log.SLog.v("openSDK_LOG.HttpUtils", "-->openUrl2 before url =" + str);
            if (str.indexOf(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START) == -1) {
                sb = new java.lang.StringBuilder();
                sb.append(str);
                str3 = com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START;
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(str);
                str3 = "&";
            }
            sb.append(str3);
            java.lang.String string2 = sb.toString();
            android.os.Bundle bundleB = com.tencent.open.log.d.b(bundle2);
            com.tencent.open.log.SLog.i("openSDK_LOG.HttpUtils", bundleB != bundle2 ? "-->openUrl2 encodedParam =" + encodeUrl(bundleB) + " -- url = " + string2 : "-->openUrl2 encodedParam =" + strEncodeUrl + " -- url = " + string2);
            org.apache.http.client.methods.HttpGet httpGet = new org.apache.http.client.methods.HttpGet(string2 + strEncodeUrl);
            httpGet.addHeader("Accept-Encoding", "gzip");
            httpUriRequest = httpGet;
        } else if (str2.equals(com.tencent.connect.common.Constants.HTTP_POST)) {
            org.apache.http.client.methods.HttpPost httpPost = new org.apache.http.client.methods.HttpPost(str);
            httpPost.addHeader("Accept-Encoding", "gzip");
            android.os.Bundle bundle3 = new android.os.Bundle();
            for (java.lang.String str4 : bundle2.keySet()) {
                java.lang.Object obj = bundle2.get(str4);
                if (obj instanceof byte[]) {
                    bundle3.putByteArray(str4, (byte[]) obj);
                }
            }
            if (!bundle2.containsKey("method")) {
                bundle2.putString("method", str2);
            }
            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            httpPost.setHeader("Connection", "Keep-Alive");
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byteArrayOutputStream.write(com.tencent.open.utils.l.i("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            byteArrayOutputStream.write(com.tencent.open.utils.l.i(encodePostBody(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
            if (!bundle3.isEmpty()) {
                int size = bundle3.size();
                byteArrayOutputStream.write(com.tencent.open.utils.l.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                for (java.lang.String str5 : bundle3.keySet()) {
                    i++;
                    byteArrayOutputStream.write(com.tencent.open.utils.l.i("Content-Disposition: form-data; name=\"" + str5 + "\"; filename=\"" + str5 + "\"" + com.tencent.midas.comm.log.util.APLogFileUtil.SEPARATOR_LINE));
                    byteArrayOutputStream.write(com.tencent.open.utils.l.i("Content-Type: content/unknown\r\n\r\n"));
                    byte[] byteArray = bundle3.getByteArray(str5);
                    if (byteArray != null) {
                        byteArrayOutputStream.write(byteArray);
                    }
                    if (i < size - 1) {
                        byteArrayOutputStream.write(com.tencent.open.utils.l.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    }
                }
            }
            byteArrayOutputStream.write(com.tencent.open.utils.l.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            length = 0 + byteArray2.length;
            byteArrayOutputStream.close();
            httpPost.setEntity(new org.apache.http.entity.ByteArrayEntity(byteArray2));
            httpUriRequest = httpPost;
        }
        org.apache.http.HttpResponse httpResponseExecute = httpClient.execute(httpUriRequest);
        int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
        com.tencent.open.log.SLog.i("openSDK_LOG.HttpUtils", "-->openUrl2 response cdoe =" + statusCode);
        if (statusCode == 200) {
            return new com.tencent.open.utils.l.a(a(httpResponseExecute), length);
        }
        throw new com.tencent.open.utils.HttpUtils.HttpStatusException(com.tencent.open.utils.HttpUtils.HttpStatusException.ERROR_INFO + statusCode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static org.json.JSONObject request(com.tencent.connect.auth.QQToken qQToken, android.content.Context context, java.lang.String str, android.os.Bundle bundle, java.lang.String str2) throws org.json.JSONException, java.io.IOException, com.tencent.open.utils.HttpUtils.HttpStatusException, com.tencent.open.utils.HttpUtils.NetworkUnavailableException {
        java.lang.String str3;
        java.lang.String str4;
        int i;
        long j;
        int i2;
        org.json.JSONObject jSONObject;
        long j2;
        int i3;
        com.tencent.open.log.SLog.i("openSDK_LOG.HttpUtils", "OpenApi request");
        if (str.toLowerCase().startsWith("http")) {
            str3 = str;
            str4 = str3;
        } else {
            java.lang.String str5 = com.tencent.open.utils.h.a().a(context, "https://openmobile.qq.com/") + str;
            str3 = com.tencent.open.utils.h.a().a(context, "https://openmobile.qq.com/") + str;
            str4 = str5;
        }
        a(context, qQToken, str);
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        int i4 = 0;
        int iA = com.tencent.open.utils.g.a(context, qQToken.getAppId()).a("[REDACTED]");
        com.tencent.open.log.SLog.v("[REDACTED]", "[REDACTED]" + iA + "[REDACTED]" + qQToken.getAppId() + "[REDACTED]" + str3);
        if (iA == 0) {
            iA = 3;
        }
        com.tencent.open.log.SLog.v("[REDACTED]", "[REDACTED]" + iA + "[REDACTED]" + qQToken.getAppId() + "[REDACTED]" + str3);
        org.json.JSONObject jSONObject2 = null;
        do {
            i4++;
            try {
                try {
                    com.tencent.open.utils.l.a aVarOpenUrl2 = openUrl2(context, str4, str2, bundle);
                    org.json.JSONObject jSONObjectD = com.tencent.open.utils.l.d(aVarOpenUrl2.f734a);
                    try {
                        i2 = jSONObjectD.getInt("ret");
                    } catch (org.json.JSONException unused) {
                        i2 = -4;
                    }
                    j2 = aVarOpenUrl2.b;
                    j = aVarOpenUrl2.c;
                    jSONObject = jSONObjectD;
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                    com.tencent.open.a.g.a().a(str3, jElapsedRealtime, 0L, 0L, -4);
                    throw e;
                }
            } catch (com.tencent.open.utils.HttpUtils.HttpStatusException e2) {
                e2.printStackTrace();
                try {
                    i3 = java.lang.Integer.parseInt(e2.getMessage().replace(com.tencent.open.utils.HttpUtils.HttpStatusException.ERROR_INFO, ""));
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                    i3 = -9;
                }
                com.tencent.open.a.g.a().a(str3, jElapsedRealtime, 0L, 0L, i3);
                throw e2;
            } catch (com.tencent.open.utils.HttpUtils.NetworkUnavailableException e4) {
                e4.printStackTrace();
                throw e4;
            } catch (java.net.MalformedURLException e5) {
                e5.printStackTrace();
                com.tencent.open.a.g.a().a(str3, jElapsedRealtime, 0L, 0L, -3);
                throw e5;
            } catch (java.net.SocketTimeoutException e6) {
                e6.printStackTrace();
                i = -8;
                if (i4 >= iA) {
                    com.tencent.open.a.g.a().a(str3, jElapsedRealtime, 0L, 0L, -8);
                    throw e6;
                }
                jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            } catch (org.apache.http.conn.ConnectTimeoutException e7) {
                e7.printStackTrace();
                i = -7;
                if (i4 >= iA) {
                    com.tencent.open.a.g.a().a(str3, jElapsedRealtime, 0L, 0L, -7);
                    throw e7;
                }
                jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            } catch (java.io.IOException e8) {
                e8.printStackTrace();
                com.tencent.open.a.g.a().a(str3, jElapsedRealtime, 0L, 0L, getErrorCodeFromException(e8));
                throw e8;
            }
            com.tencent.open.a.g.a().a(str3, jElapsedRealtime, j2, j, i2);
            return jSONObject;
        } while (i4 < iA);
        j = 0;
        i2 = i;
        jSONObject = jSONObject2;
        j2 = 0;
        com.tencent.open.a.g.a().a(str3, jElapsedRealtime, j2, j, i2);
        return jSONObject;
    }

    public static void requestAsync(final com.tencent.connect.auth.QQToken qQToken, final android.content.Context context, final java.lang.String str, final android.os.Bundle bundle, final java.lang.String str2, final com.tencent.tauth.IRequestListener iRequestListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        new java.lang.Thread() { // from class: com.tencent.open.utils.HttpUtils.1
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                java.lang.StringBuilder sb;
                java.lang.String str3;
                java.lang.String string;
                java.lang.Exception exc;
                try {
                    org.json.JSONObject jSONObjectRequest = com.tencent.open.utils.HttpUtils.request(qQToken, context, str, bundle, str2);
                    if (iRequestListener != null) {
                        iRequestListener.onComplete(jSONObjectRequest);
                        com.tencent.open.log.SLog.i("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                    }
                } catch (com.tencent.open.utils.HttpUtils.HttpStatusException e) {
                    com.tencent.tauth.IRequestListener iRequestListener2 = iRequestListener;
                    if (iRequestListener2 != null) {
                        iRequestListener2.onHttpStatusException(e);
                        sb = new java.lang.StringBuilder();
                        str3 = "OpenApi requestAsync onHttpStatusException";
                        exc = e;
                        sb.append(str3);
                        string = exc.toString();
                        sb.append(string);
                        com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", sb.toString());
                    }
                } catch (com.tencent.open.utils.HttpUtils.NetworkUnavailableException e2) {
                    com.tencent.tauth.IRequestListener iRequestListener3 = iRequestListener;
                    if (iRequestListener3 != null) {
                        iRequestListener3.onNetworkUnavailableException(e2);
                        sb = new java.lang.StringBuilder();
                        str3 = "OpenApi requestAsync onNetworkUnavailableException";
                        exc = e2;
                        sb.append(str3);
                        string = exc.toString();
                        sb.append(string);
                        com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", sb.toString());
                    }
                } catch (java.net.MalformedURLException e3) {
                    com.tencent.tauth.IRequestListener iRequestListener4 = iRequestListener;
                    if (iRequestListener4 != null) {
                        iRequestListener4.onMalformedURLException(e3);
                        sb = new java.lang.StringBuilder();
                        sb.append("OpenApi requestAsync MalformedURLException");
                        string = e3.toString();
                        sb.append(string);
                        com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", sb.toString());
                    }
                } catch (java.net.SocketTimeoutException e4) {
                    com.tencent.tauth.IRequestListener iRequestListener5 = iRequestListener;
                    if (iRequestListener5 != null) {
                        iRequestListener5.onSocketTimeoutException(e4);
                        sb = new java.lang.StringBuilder();
                        sb.append("OpenApi requestAsync onSocketTimeoutException");
                        string = e4.toString();
                        sb.append(string);
                        com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", sb.toString());
                    }
                } catch (org.apache.http.conn.ConnectTimeoutException e5) {
                    com.tencent.tauth.IRequestListener iRequestListener6 = iRequestListener;
                    if (iRequestListener6 != null) {
                        iRequestListener6.onConnectTimeoutException(e5);
                        sb = new java.lang.StringBuilder();
                        sb.append("OpenApi requestAsync onConnectTimeoutException");
                        string = e5.toString();
                        sb.append(string);
                        com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", sb.toString());
                    }
                } catch (java.io.IOException e6) {
                    com.tencent.tauth.IRequestListener iRequestListener7 = iRequestListener;
                    if (iRequestListener7 != null) {
                        iRequestListener7.onIOException(e6);
                        sb = new java.lang.StringBuilder();
                        sb.append("OpenApi requestAsync IOException");
                        string = e6.toString();
                        sb.append(string);
                        com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", sb.toString());
                    }
                } catch (org.json.JSONException e7) {
                    com.tencent.tauth.IRequestListener iRequestListener8 = iRequestListener;
                    if (iRequestListener8 != null) {
                        iRequestListener8.onJSONException(e7);
                        sb = new java.lang.StringBuilder();
                        sb.append("OpenApi requestAsync JSONException");
                        string = e7.toString();
                        sb.append(string);
                        com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", sb.toString());
                    }
                } catch (java.lang.Exception e8) {
                    com.tencent.tauth.IRequestListener iRequestListener9 = iRequestListener;
                    if (iRequestListener9 != null) {
                        iRequestListener9.onUnknowException(e8);
                        sb = new java.lang.StringBuilder();
                        str3 = "OpenApi requestAsync onUnknowException";
                        exc = e8;
                        sb.append(str3);
                        string = exc.toString();
                        sb.append(string);
                        com.tencent.open.log.SLog.e("openSDK_LOG.HttpUtils", sb.toString());
                    }
                }
            }
        }.start();
    }
}
