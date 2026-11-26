package com.tencent.beacon.core.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.beacon.core.d.f f152a;

    /* JADX INFO: Access modifiers changed from: private */
    static class a extends com.tencent.beacon.core.d.f {
        protected android.content.Context b;

        public a(android.content.Context context) {
            this.b = context;
        }

        com.tencent.beacon.core.d.b a(java.lang.String str, byte[] bArr, java.lang.String str2, int i) throws java.lang.Exception {
            org.apache.http.client.methods.HttpPost httpPost;
            if (str == null) {
                com.tencent.beacon.core.e.d.b("[net] destUrl is null.", new java.lang.Object[0]);
                return null;
            }
            try {
                org.apache.http.entity.ByteArrayEntity byteArrayEntity = bArr != null ? new org.apache.http.entity.ByteArrayEntity(bArr) : new org.apache.http.entity.ByteArrayEntity("".getBytes(java.nio.charset.Charset.forName("UTF-8")));
                org.apache.http.client.HttpClient httpClientA = a(str2, i);
                if (httpClientA == null) {
                    com.tencent.beacon.core.e.d.b("[net] no httpClient!", new java.lang.Object[0]);
                    return null;
                }
                httpPost = new org.apache.http.client.methods.HttpPost(str);
                try {
                    httpPost.setHeader("wup_version", "3.0");
                    httpPost.setHeader("TYPE_COMPRESS", java.lang.String.valueOf(2));
                    httpPost.setHeader("encr_type", "rsapost");
                    com.tencent.beacon.core.strategy.g gVarB = com.tencent.beacon.core.strategy.g.b(this.b);
                    if (gVarB != null) {
                        httpPost.setHeader("bea_key", gVarB.c());
                    }
                    httpPost.setEntity(byteArrayEntity);
                    org.apache.http.protocol.BasicHttpContext basicHttpContext = new org.apache.http.protocol.BasicHttpContext();
                    org.apache.http.HttpResponse httpResponseExecute = httpClientA.execute(httpPost, basicHttpContext);
                    org.apache.http.HttpRequest httpRequest = (org.apache.http.HttpRequest) basicHttpContext.getAttribute("http.request");
                    if (httpRequest != null) {
                        com.tencent.beacon.core.e.d.h("[net] execute request:\n %s", httpRequest.getRequestLine().toString());
                    }
                    return new com.tencent.beacon.core.d.b(httpResponseExecute, httpPost);
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.tencent.beacon.core.d.i.a(this.b).a("499", "[net] http execute error!", th);
                    com.tencent.beacon.core.e.d.a(th);
                    com.tencent.beacon.core.e.d.b("[net] execute error:%s", th.toString());
                    if (httpPost != null) {
                        httpPost.abort();
                    }
                    throw new java.lang.Exception(th.toString());
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                httpPost = null;
            }
        }

        org.apache.http.client.HttpClient a(java.lang.String str, int i) {
            try {
                org.apache.http.params.BasicHttpParams basicHttpParams = new org.apache.http.params.BasicHttpParams();
                org.apache.http.params.HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
                org.apache.http.params.HttpConnectionParams.setSoTimeout(basicHttpParams, cn.yunzhisheng.asr.a.b);
                org.apache.http.params.HttpConnectionParams.setSocketBufferSize(basicHttpParams, 2000);
                basicHttpParams.setBooleanParameter("http.protocol.handle-redirects", false);
                org.apache.http.impl.client.DefaultHttpClient defaultHttpClient = new org.apache.http.impl.client.DefaultHttpClient(basicHttpParams);
                org.apache.http.params.HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                defaultHttpClient.setHttpRequestRetryHandler(new com.tencent.beacon.core.d.e(this));
                if (str == null || !str.toLowerCase(java.util.Locale.US).contains("wap") || i == 2) {
                    if (str != null) {
                        com.tencent.beacon.core.e.d.d("[net] Don't use proxy: %s, try time: %s", str, java.lang.Integer.valueOf(i));
                    }
                    defaultHttpClient.getParams().removeParameter("http.route.default-proxy");
                } else {
                    com.tencent.beacon.core.e.d.d("[net] use proxy: %s, try time: %s", str, java.lang.Integer.valueOf(i));
                    java.lang.String defaultHost = android.net.Proxy.getDefaultHost();
                    int defaultPort = android.net.Proxy.getDefaultPort();
                    if (defaultHost != null) {
                        defaultHttpClient.getParams().setParameter("http.route.default-proxy", new org.apache.http.HttpHost(defaultHost, defaultPort));
                    }
                }
                return defaultHttpClient;
            } catch (java.lang.Throwable th) {
                com.tencent.beacon.core.d.i.a(this.b).a("499", "[net] http getClient error!", th);
                com.tencent.beacon.core.e.d.a(th);
                com.tencent.beacon.core.e.d.b("[net] httpclient error!", new java.lang.Object[0]);
                return null;
            }
        }

        @Override // com.tencent.beacon.core.d.f
        public boolean a() {
            return false;
        }

        boolean a(int i) {
            return i == 301 || i == 302 || i == 303 || i == 307;
        }

        /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:48:0x012e  */
        /* JADX WARN: Code duplicated, block: B:50:0x0151  */
        /* JADX WARN: Code duplicated, block: B:52:0x015b A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:53:0x015d  */
        /* JADX WARN: Code duplicated, block: B:54:0x0160  */
        /* JADX WARN: Code duplicated, block: B:57:0x0166  */
        /* JADX WARN: Code duplicated, block: B:59:0x016e  */
        /* JADX WARN: Code duplicated, block: B:64:0x01b7 A[Catch: Exception -> 0x01bc, TRY_LEAVE, TryCatch #0 {Exception -> 0x01bc, blocks: (B:62:0x01b3, B:64:0x01b7), top: B:89:0x01b3 }] */
        /* JADX WARN: Code duplicated, block: B:67:0x01be  */
        /* JADX WARN: Code duplicated, block: B:70:0x01dc A[Catch: Exception -> 0x01e1, TRY_LEAVE, TryCatch #2 {Exception -> 0x01e1, blocks: (B:68:0x01d8, B:70:0x01dc), top: B:93:0x01d8 }] */
        /* JADX WARN: Code duplicated, block: B:72:0x01e9  */
        /* JADX WARN: Code duplicated, block: B:74:0x01ef  */
        /* JADX WARN: Code duplicated, block: B:98:0x0126 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:99:0x0176 A[SYNTHETIC] */
        /* JADX WARN: Instruction removed from duplicated block: B:48:0x012e, please report this as an issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r12v6 */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.tencent.beacon.core.d.f
        public byte[] a(java.lang.String str, byte[] bArr, com.tencent.beacon.core.d.a aVar, com.tencent.beacon.core.d.d dVar) throws java.lang.Exception {
            java.lang.String str2;
            java.lang.String str3;
            java.lang.String str4;
            long j;
            long contentLength;
            int statusCode;
            byte[] bArrA;
            long length;
            java.lang.String str5;
            org.apache.http.Header firstHeader;
            int i = 0;
            if (str == null) {
                com.tencent.beacon.core.e.d.b("[net] destUrl is null.", new java.lang.Object[0]);
                return null;
            }
            int i2 = 3;
            int i3 = 1;
            int i4 = 2;
            com.tencent.beacon.core.e.d.a("[net] HTTP requestCmd(%d) moduleId(%d) eventCnt(%d)", java.lang.Integer.valueOf(aVar.f148a), java.lang.Integer.valueOf(aVar.b), java.lang.Integer.valueOf(aVar.e));
            long length2 = bArr == null ? 0L : bArr.length;
            com.tencent.beacon.core.e.d.h("[net] request url:%s sz:%d", str, java.lang.Long.valueOf(length2));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str6 = str;
            java.lang.String str7 = "";
            com.tencent.beacon.core.d.b bVarA = null;
            int i5 = 0;
            int i6 = 0;
            boolean z = false;
            while (true) {
                int i7 = i5 + 1;
                if (i5 >= i2 || i6 >= i4) {
                    break;
                }
                if (z) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("net redirect");
                    com.tencent.beacon.core.d.i.a(this.b).a("499", "[net] http redirect ! url: " + str6 + ", tryTime: " + i7);
                    throw new java.lang.Exception(sb2.toString());
                }
                if (i7 > i3) {
                    com.tencent.beacon.core.e.d.h("[net] try time:" + i7, new java.lang.Object[i]);
                    if (i7 == i4 && aVar.c() == i4) {
                        aVar.a(i);
                    }
                    a(5000L);
                }
                java.lang.String strB = com.tencent.beacon.core.e.e.b(this.b);
                if (dVar != null) {
                    str2 = str6;
                    str7 = str7;
                    dVar.a(str6, length2, strB, i7);
                } else {
                    str7 = str7;
                    str2 = str6;
                }
                long time = new java.util.Date().getTime();
                try {
                    bVarA = a(str2, bArr, strB, i7);
                } catch (java.lang.Exception e) {
                    java.lang.String string = e.toString();
                    if (str7.equals(string)) {
                        sb.append(i7);
                        sb.append(":");
                        str3 = "same ";
                    } else {
                        sb.append(i7);
                        sb.append(":");
                        sb.append(string);
                        str3 = " ";
                    }
                    sb.append(str3);
                    str7 = string;
                    bVarA = bVarA;
                }
                long time2 = new java.util.Date().getTime() - time;
                if (bVarA != null) {
                    org.apache.http.HttpResponse httpResponse = bVarA.f149a;
                    org.apache.http.HttpEntity entity = httpResponse.getEntity();
                    if (entity != null) {
                        contentLength = entity.getContentLength();
                        str4 = str2;
                        j = 0;
                        if (contentLength < 0) {
                        }
                        statusCode = httpResponse.getStatusLine().getStatusCode();
                        com.tencent.beacon.core.e.d.h("[net] response code:%d ", java.lang.Integer.valueOf(statusCode));
                        if (statusCode == 200) {
                            if (httpResponse.containsHeader("encrypt-status")) {
                                com.tencent.beacon.core.e.d.b("[net] svr encry failed: " + httpResponse.getFirstHeader("encrypt-status").getValue(), new java.lang.Object[0]);
                                return null;
                            }
                            bArrA = a(httpResponse, bVarA.b, str4, i7);
                            if (dVar != null) {
                                if (bArrA == null) {
                                    length = 0;
                                } else {
                                    length = bArrA.length;
                                }
                                dVar.a(length, time2);
                            }
                            return bArrA;
                        }
                        str5 = str4;
                        if (a(statusCode)) {
                            firstHeader = httpResponse.getFirstHeader("Location");
                            if (firstHeader == null) {
                                com.tencent.beacon.core.e.d.b("[net] redirect code:" + statusCode + " Location is null! return", new java.lang.Object[0]);
                                com.tencent.beacon.core.d.i.a(this.b).a("499", "[net] http redirect code: " + statusCode + ", location is null!");
                                try {
                                    if (bVarA.b != null) {
                                        return null;
                                    }
                                    bVarA.b.abort();
                                    return null;
                                } catch (java.lang.Exception unused) {
                                    return null;
                                }
                            }
                            int i8 = i6 + 1;
                            java.lang.String value = firstHeader.getValue();
                            com.tencent.beacon.core.e.d.h("[net] redirect code:%d , to:%s", java.lang.Integer.valueOf(statusCode), value);
                            try {
                                if (bVarA.b != null) {
                                    bVarA.b.abort();
                                }
                            } catch (java.lang.Exception unused2) {
                            }
                            str6 = value;
                            i6 = i8;
                            i7 = 0;
                            z = true;
                        } else {
                            str6 = str5;
                        }
                        if (dVar != null) {
                            dVar.a(contentLength, time2);
                        }
                        i5 = i7;
                    } else {
                        str4 = str2;
                        j = 0;
                    }
                    contentLength = j;
                    statusCode = httpResponse.getStatusLine().getStatusCode();
                    com.tencent.beacon.core.e.d.h("[net] response code:%d ", java.lang.Integer.valueOf(statusCode));
                    if (statusCode == 200) {
                        if (httpResponse.containsHeader("encrypt-status")) {
                            com.tencent.beacon.core.e.d.b("[net] svr encry failed: " + httpResponse.getFirstHeader("encrypt-status").getValue(), new java.lang.Object[0]);
                            return null;
                        }
                        bArrA = a(httpResponse, bVarA.b, str4, i7);
                        if (dVar != null) {
                            if (bArrA == null) {
                                length = 0;
                            } else {
                                length = bArrA.length;
                            }
                            dVar.a(length, time2);
                        }
                        return bArrA;
                    }
                    str5 = str4;
                    if (a(statusCode)) {
                        firstHeader = httpResponse.getFirstHeader("Location");
                        if (firstHeader == null) {
                            com.tencent.beacon.core.e.d.b("[net] redirect code:" + statusCode + " Location is null! return", new java.lang.Object[0]);
                            com.tencent.beacon.core.d.i.a(this.b).a("499", "[net] http redirect code: " + statusCode + ", location is null!");
                            if (bVarA.b != null) {
                                return null;
                            }
                            bVarA.b.abort();
                            return null;
                        }
                        int i9 = i6 + 1;
                        java.lang.String value2 = firstHeader.getValue();
                        com.tencent.beacon.core.e.d.h("[net] redirect code:%d , to:%s", java.lang.Integer.valueOf(statusCode), value2);
                        if (bVarA.b != null) {
                            bVarA.b.abort();
                        }
                        str6 = value2;
                        i6 = i9;
                        i7 = 0;
                        z = true;
                    } else {
                        str6 = str5;
                    }
                    if (dVar != null) {
                        dVar.a(contentLength, time2);
                    }
                    i5 = i7;
                } else {
                    java.lang.String str8 = str2;
                    if (dVar != null) {
                        dVar.a(0L, time2);
                    }
                    i5 = i7;
                    str6 = str8;
                }
                i6 = i6;
                i = 0;
                i2 = 3;
                i3 = 1;
                i4 = 2;
            }
            throw new java.lang.Exception(sb.toString());
        }

        /* JADX WARN: Code duplicated, block: B:49:0x00d8 A[DONT_GENERATE, PHI: r0
  0x00d8: PHI (r0v2 byte[]) = (r0v0 byte[]), (r0v5 byte[]) binds: [B:48:0x00d6, B:28:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        byte[] a(org.apache.http.HttpResponse httpResponse, org.apache.http.client.methods.HttpPost httpPost, java.lang.String str, int i) {
            java.io.BufferedInputStream bufferedInputStream;
            byte[] byteArray = null;
            if (httpResponse == null) {
                return null;
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                com.tencent.beacon.core.e.d.i("[net] request failure code:%d , line:%s ", java.lang.Integer.valueOf(statusCode), httpResponse.getStatusLine());
                return null;
            }
            if (httpResponse.containsHeader(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID) && httpResponse.containsHeader("max_time")) {
                com.tencent.beacon.core.strategy.g.b(this.b).a(this.b, httpResponse.getFirstHeader(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID).getValue(), httpResponse.getFirstHeader("max_time").getValue());
            }
            org.apache.http.HttpEntity entity = httpResponse.getEntity();
            if (entity == null) {
                com.tencent.beacon.core.e.d.b("[net] no response data", new java.lang.Object[0]);
                return null;
            }
            try {
                bufferedInputStream = new java.io.BufferedInputStream(new java.io.DataInputStream(entity.getContent()));
                try {
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    while (true) {
                        int i2 = bufferedInputStream.read();
                        if (i2 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(i2);
                    }
                    byteArrayOutputStream.flush();
                    byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        bufferedInputStream.close();
                    } catch (java.lang.Throwable th) {
                        com.tencent.beacon.core.e.d.a(th);
                    }
                    if (httpPost != null) {
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    try {
                        com.tencent.beacon.core.d.i iVarA = com.tencent.beacon.core.d.i.a(this.b);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("[net] http read response error! url: ");
                        sb.append(str);
                        sb.append(",tryTime: ");
                        sb.append(i);
                        iVarA.a("452", sb.toString(), th);
                        com.tencent.beacon.core.e.d.a(th);
                        com.tencent.beacon.core.e.d.b("[net] read error %s", th.toString());
                    } finally {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (java.lang.Throwable th3) {
                                com.tencent.beacon.core.e.d.a(th3);
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
    }

    private static class b extends com.tencent.beacon.core.d.f {
        protected android.content.Context b;

        public b(android.content.Context context) {
            this.b = context;
        }

        private java.util.Map a(com.tencent.beacon.core.d.a aVar) {
            java.util.HashMap map = new java.util.HashMap();
            java.lang.String strD = aVar.d();
            if (strD != null && !"".equals(strD)) {
                map.put("rid", aVar.d());
            }
            java.lang.String strB = com.tencent.beacon.core.strategy.g.b(this.b).b();
            if (strB != null && !"".equals(strB)) {
                map.put("sid", strB);
            }
            map.put("wup_version", "3.0");
            map.put("TYPE_COMPRESS", java.lang.String.valueOf(2));
            map.put("encr_type", "rsapost");
            com.tencent.beacon.core.strategy.g gVarB = com.tencent.beacon.core.strategy.g.b(this.b);
            if (gVarB != null) {
                map.put("bea_key", gVarB.c());
            }
            return map;
        }

        private void a(com.tencent.beacon.core.d.d dVar, long j, int i) {
            long time = new java.util.Date().getTime() - j;
            if (dVar != null) {
                dVar.a(i, time);
            }
        }

        private void a(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.Throwable th) {
            com.tencent.beacon.core.d.i.a(this.b).a(str3, str2 + ", url: " + str + ", tryTime: " + i, th);
        }

        private void a(java.lang.String str, com.tencent.beacon.core.d.d dVar, int i, long j) {
            if (dVar != null) {
                dVar.a(str, j, com.tencent.beacon.core.e.e.b(this.b), i);
            }
        }

        private void a(byte[] bArr, java.net.Socket socket, com.tencent.beacon.core.d.a aVar) throws java.io.IOException {
            java.lang.String strD = aVar.d();
            com.tencent.beacon.core.e.d.a("[net] %s:%d send data[%d] to server.  rid:%s", socket.getLocalAddress().getHostName(), java.lang.Integer.valueOf(socket.getLocalPort()), java.lang.Integer.valueOf(bArr.length), strD);
            com.tencent.beacon.core.protocol.common.SocketRequestPackage socketRequestPackage = new com.tencent.beacon.core.protocol.common.SocketRequestPackage(a(aVar), bArr);
            com.tencent.beacon.core.wup.b bVar = new com.tencent.beacon.core.wup.b();
            socketRequestPackage.writeTo(bVar);
            java.io.OutputStream outputStream = socket.getOutputStream();
            byte[] bArrB = bVar.b();
            int length = bArrB.length;
            com.tencent.beacon.core.e.d.a("[net] send header + data[%d] = %d   rid:%s", java.lang.Integer.valueOf(bArr.length), java.lang.Integer.valueOf(length), strD);
            outputStream.write(a(bArrB, length));
            outputStream.flush();
        }

        private byte[] a(java.net.Socket socket, java.lang.String str) throws java.io.IOException {
            com.tencent.beacon.core.e.d.a("[net] begin waiting server response.  rid:%s", str);
            java.io.InputStream inputStream = socket.getInputStream();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bArr = new byte[2048];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    com.tencent.beacon.core.e.d.a("[net] server response length: %d [need >= 4]   rid: %s", java.lang.Integer.valueOf(byteArray.length), str);
                    java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(byteArray.length - 4);
                    byteBufferAllocate.put(byteArray, 2, byteArray.length - 4);
                    byte[] bArrArray = byteBufferAllocate.array();
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return bArrArray;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        }

        private byte[] a(byte[] bArr, int i) {
            int i2 = i + 4;
            java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(i2);
            byteBufferAllocate.order(java.nio.ByteOrder.BIG_ENDIAN);
            byteBufferAllocate.putShort((short) (i2 & android.support.v4.internal.view.SupportMenu.USER_MASK));
            byteBufferAllocate.put(bArr);
            byteBufferAllocate.put((byte) 13);
            byteBufferAllocate.put((byte) 10);
            if (i >= 65532) {
                com.tencent.beacon.core.e.d.b("[Error] send bytes exceed 64kB will failure!", new java.lang.Object[0]);
            }
            return byteBufferAllocate.array();
        }

        @Override // com.tencent.beacon.core.d.f
        public boolean a() {
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:83:0x01b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.tencent.beacon.core.d.f
        public byte[] a(java.lang.String str, int i, byte[] bArr, com.tencent.beacon.core.d.a aVar, com.tencent.beacon.core.d.d dVar) throws java.lang.Throwable {
            int i2;
            java.net.Socket socket;
            java.net.Socket socket2;
            int i3;
            java.lang.String str2;
            java.lang.String str3;
            int i4;
            byte[] bArrA;
            char c = 0;
            if (str == null || i <= 0) {
                com.tencent.beacon.core.e.d.b("[net] Request domain or port illegal!!!", new java.lang.Object[0]);
                return null;
            }
            java.lang.String strD = aVar.d();
            int i5 = 1;
            int i6 = 2;
            int i7 = 3;
            com.tencent.beacon.core.e.d.a("[net] TCP requestCmd:%d moduleId:%d eventCnt:%d rid:%s", java.lang.Integer.valueOf(aVar.f148a), java.lang.Integer.valueOf(aVar.b), java.lang.Integer.valueOf(aVar.e), strD);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i8 = 0;
            while (true) {
                int i9 = i8 + 1;
                if (i8 > i7) {
                    throw new java.net.ConnectException(sb.toString());
                }
                java.lang.Object[] objArr = new java.lang.Object[i6];
                objArr[c] = java.lang.Integer.valueOf(i9);
                objArr[i5] = strD;
                com.tencent.beacon.core.e.d.h("[net] Request try time:%d  rid:%s", objArr);
                if (i9 > i5) {
                    a(1000L);
                }
                java.lang.String str4 = str + ":" + i;
                java.lang.StringBuilder sb2 = sb;
                a(str4, dVar, i9, bArr.length);
                long time = new java.util.Date().getTime();
                java.net.InetAddress byName = java.net.InetAddress.getByName(str);
                com.tencent.beacon.core.e.d.a("[net] ip:port [%s:%d]  rid: %s", byName.getHostAddress(), java.lang.Integer.valueOf(i), strD);
                try {
                    java.net.Socket socket3 = new java.net.Socket(byName.getHostAddress(), i);
                    try {
                        socket3.setSoTimeout(30000);
                        a(bArr, socket3, aVar);
                        bArrA = a(socket3, strD);
                        com.tencent.beacon.core.e.d.a("[net] close client socket.  rid:%s", strD);
                        try {
                            socket3.close();
                        } catch (java.io.IOException unused) {
                        }
                        time = time;
                        i4 = i9;
                    } catch (java.net.ConnectException unused2) {
                        socket2 = socket3;
                        i3 = 1;
                        sb2.append(r20);
                        sb2.append(":connectExp ");
                        java.lang.Object[] objArr2 = new java.lang.Object[i3];
                        objArr2[0] = strD;
                        com.tencent.beacon.core.e.d.a("[net] close client socket.  rid:%s", objArr2);
                        if (socket2 != null) {
                            i4 = i9;
                            try {
                                socket2.close();
                            } catch (java.io.IOException unused3) {
                            }
                        } else {
                            i4 = r20;
                        }
                        bArrA = null;
                    } catch (java.net.SocketTimeoutException e) {
                        e = e;
                        socket2 = socket3;
                        if (dVar != null) {
                            dVar.a();
                        }
                        i4 = i9;
                        a(str4, r20, "[net] Socket connect timeout", "401", e);
                        sb2.append(i4);
                        sb2.append(":timeout ");
                        com.tencent.beacon.core.e.d.a("[net] close client socket.  rid:%s", strD);
                        if (socket2 != null) {
                            socket2.close();
                        }
                        bArrA = null;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        socket2 = socket3;
                        try {
                            if (e instanceof java.io.IOException) {
                                str2 = "[net] Socket sendClientData or handleResponseData error!";
                                str3 = "402";
                            } else {
                                str2 = "[net] Socket other error!";
                                str3 = "449";
                            }
                            time = time;
                            a(str4, i9, str2, str3, e);
                            sb2.append(":");
                            sb2.append(e.getMessage());
                            com.tencent.beacon.core.e.d.a("[net] close client socket.  rid:%s", strD);
                            if (socket2 != null) {
                                i4 = i9;
                                socket2.close();
                            } else {
                                i4 = i9;
                            }
                            bArrA = null;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            socket = socket2;
                            i2 = 1;
                            java.lang.Object[] objArr3 = new java.lang.Object[i2];
                            objArr3[0] = strD;
                            com.tencent.beacon.core.e.d.a("[net] close client socket.  rid:%s", objArr3);
                            if (socket != null) {
                                try {
                                    socket.close();
                                } catch (java.io.IOException unused4) {
                                }
                            }
                            throw th;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        socket = socket3;
                        i2 = 1;
                        java.lang.Object[] objArr4 = new java.lang.Object[i2];
                        objArr4[0] = strD;
                        com.tencent.beacon.core.e.d.a("[net] close client socket.  rid:%s", objArr4);
                        if (socket != null) {
                            socket.close();
                        }
                        throw th;
                    }
                } catch (java.net.ConnectException unused5) {
                    i3 = 1;
                    socket2 = null;
                } catch (java.net.SocketTimeoutException e3) {
                    e = e3;
                    socket2 = null;
                } catch (java.lang.Exception e4) {
                    e = e4;
                    socket2 = null;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    i2 = 1;
                    socket = null;
                    java.lang.Object[] objArr5 = new java.lang.Object[i2];
                    objArr5[0] = strD;
                    com.tencent.beacon.core.e.d.a("[net] close client socket.  rid:%s", objArr5);
                    if (socket != null) {
                        socket.close();
                    }
                    throw th;
                }
                a(dVar, time, bArrA == null ? 0 : bArrA.length);
                if (bArrA != null) {
                    return bArrA;
                }
                sb = sb2;
                i8 = i4;
                i7 = 3;
                i5 = 1;
                i6 = 2;
                c = 0;
            }
        }
    }

    public static synchronized com.tencent.beacon.core.d.f a(android.content.Context context) {
        com.tencent.beacon.core.d.f fVar;
        boolean zE = com.tencent.beacon.core.strategy.g.b(context).e();
        if ((f152a == null && context != null) || ((fVar = f152a) != null && fVar.a() != zE)) {
            a(context, zE);
        }
        return f152a;
    }

    private static void a(android.content.Context context, boolean z) {
        f152a = z ? new com.tencent.beacon.core.d.f.b(context) : new com.tencent.beacon.core.d.f.a(context);
    }

    protected void a(long j) {
        try {
            java.lang.Thread.sleep(j);
        } catch (java.lang.InterruptedException e) {
            com.tencent.beacon.core.e.d.a(e);
        }
    }

    public abstract boolean a();

    public byte[] a(java.lang.String str, int i, byte[] bArr, com.tencent.beacon.core.d.a aVar, com.tencent.beacon.core.d.d dVar) {
        return null;
    }

    public byte[] a(java.lang.String str, byte[] bArr, com.tencent.beacon.core.d.a aVar, com.tencent.beacon.core.d.d dVar) {
        return null;
    }
}
