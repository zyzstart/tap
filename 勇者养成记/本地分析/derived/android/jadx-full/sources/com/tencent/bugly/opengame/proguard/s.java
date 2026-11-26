package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class s {
    private static com.tencent.bugly.opengame.proguard.s b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.util.Map f405a = null;
    private android.content.Context c;

    private s(android.content.Context context) {
        this.c = context;
    }

    public static com.tencent.bugly.opengame.proguard.s a(android.content.Context context) {
        if (b == null) {
            b = new com.tencent.bugly.opengame.proguard.s(context);
        }
        return b;
    }

    private static java.net.HttpURLConnection a(java.lang.String str, java.lang.String str2) {
        java.net.URLConnection uRLConnectionOpenConnection;
        java.net.Proxy proxy;
        try {
            java.net.URL url = new java.net.URL(str2);
            if (com.tencent.bugly.opengame.proguard.a.b() == null) {
                if (str == null || !str.toLowerCase(java.util.Locale.US).contains("wap")) {
                    uRLConnectionOpenConnection = url.openConnection();
                } else {
                    proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(java.lang.System.getProperty("http.proxyHost"), java.lang.Integer.parseInt(java.lang.System.getProperty("http.proxyPort"))));
                }
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) uRLConnectionOpenConnection;
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(false);
                return httpURLConnection;
            }
            proxy = com.tencent.bugly.opengame.proguard.a.b();
            uRLConnectionOpenConnection = url.openConnection(proxy);
            java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection2.setConnectTimeout(30000);
            httpURLConnection2.setReadTimeout(10000);
            httpURLConnection2.setDoOutput(true);
            httpURLConnection2.setDoInput(true);
            httpURLConnection2.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
            httpURLConnection2.setUseCaches(false);
            httpURLConnection2.setInstanceFollowRedirects(false);
            return httpURLConnection2;
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.opengame.proguard.x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private java.net.HttpURLConnection a(java.lang.String str, byte[] bArr, java.lang.String str2, java.util.Map map) {
        java.lang.Object[] objArr;
        java.lang.String str3;
        if (str == null) {
            objArr = new java.lang.Object[0];
            str3 = "destUrl is null.";
        } else {
            java.net.HttpURLConnection httpURLConnectionA = a(str2, str);
            if (httpURLConnectionA == null) {
                objArr = new java.lang.Object[0];
                str3 = "Failed to get HttpURLConnection object.";
            } else {
                try {
                    httpURLConnectionA.setRequestProperty("wup_version", "3.0");
                    if (map != null && map.size() > 0) {
                        for (java.util.Map.Entry entry : map.entrySet()) {
                            httpURLConnectionA.setRequestProperty((java.lang.String) entry.getKey(), java.net.URLEncoder.encode((java.lang.String) entry.getValue(), com.unisound.b.f.b));
                        }
                    }
                    httpURLConnectionA.setRequestProperty("A37", java.net.URLEncoder.encode(str2, com.unisound.b.f.b));
                    httpURLConnectionA.setRequestProperty("A38", java.net.URLEncoder.encode(str2, com.unisound.b.f.b));
                    java.io.OutputStream outputStream = httpURLConnectionA.getOutputStream();
                    if (bArr == null) {
                        outputStream.write(0);
                    } else {
                        outputStream.write(bArr);
                    }
                    return httpURLConnectionA;
                } catch (java.lang.Throwable th) {
                    if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                        th.printStackTrace();
                    }
                    objArr = new java.lang.Object[0];
                    str3 = "Failed to upload, please check your network.";
                }
            }
        }
        com.tencent.bugly.opengame.proguard.x.e(str3, objArr);
        return null;
    }

    private static java.util.Map a(java.net.HttpURLConnection httpURLConnection) {
        java.util.HashMap map = new java.util.HashMap();
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (java.lang.String str : headerFields.keySet()) {
            java.util.List<java.lang.String> list = headerFields.get(str);
            if (list.size() > 0) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] b(java.net.HttpURLConnection httpURLConnection) {
        java.io.BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new java.io.BufferedInputStream(httpURLConnection.getInputStream());
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    bufferedInputStream.close();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                return byteArray;
            } catch (java.lang.Throwable th2) {
                th = th2;
                try {
                    if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                        th.printStackTrace();
                    }
                    return null;
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (java.lang.Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0184 A[Catch: all -> 0x0176, TRY_LEAVE, TryCatch #3 {all -> 0x0176, blocks: (B:24:0x009b, B:26:0x00a3, B:30:0x00b4, B:29:0x00b2, B:50:0x00dd, B:52:0x00e5, B:63:0x0116, B:65:0x0120, B:76:0x013c, B:80:0x015f, B:98:0x017e, B:100:0x0184), top: B:121:0x009b }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0193 A[PHI: r5 r6 r10 r13 r14 r20
  0x0193: PHI (r5v3 int) = (r5v2 int), (r5v10 int) binds: [B:105:0x0191, B:85:0x016c] A[DONT_GENERATE, DONT_INLINE]
  0x0193: PHI (r6v9 java.lang.Throwable) = (r6v8 java.lang.Throwable), (r6v16 java.lang.Throwable) binds: [B:105:0x0191, B:85:0x016c] A[DONT_GENERATE, DONT_INLINE]
  0x0193: PHI (r10v9 int) = (r10v8 int), (r10v13 int) binds: [B:105:0x0191, B:85:0x016c] A[DONT_GENERATE, DONT_INLINE]
  0x0193: PHI (r13v6 boolean) = (r13v5 boolean), (r13v12 boolean) binds: [B:105:0x0191, B:85:0x016c] A[DONT_GENERATE, DONT_INLINE]
  0x0193: PHI (r14v3 java.lang.String) = (r14v2 java.lang.String), (r14v9 java.lang.String) binds: [B:105:0x0191, B:85:0x016c] A[DONT_GENERATE, DONT_INLINE]
  0x0193: PHI (r20v3 long) = (r20v2 long), (r20v11 long) binds: [B:105:0x0191, B:85:0x016c] A[DONT_GENERATE, DONT_INLINE]] */
    public final byte[] a(java.lang.String str, byte[] bArr, com.tencent.bugly.opengame.proguard.v vVar, java.util.Map map) {
        int i;
        int i2;
        java.lang.Throwable th;
        byte[] bArr2 = null;
        int i3 = 0;
        if (str == null) {
            com.tencent.bugly.opengame.proguard.x.e("Failed for no URL.", new java.lang.Object[0]);
            return null;
        }
        long length = bArr == null ? 0L : bArr.length;
        int i4 = 1;
        com.tencent.bugly.opengame.proguard.x.c("request: %s, send: %d (pid=%d | tid=%d)", str, java.lang.Long.valueOf(length), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
        java.lang.String str2 = str;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        while (i5 <= 0 && i6 <= 0) {
            if (z) {
                i = i5;
                z = false;
            } else {
                int i7 = i5 + 1;
                if (i7 > i4) {
                    com.tencent.bugly.opengame.proguard.x.c("try time: " + i7, new java.lang.Object[i3]);
                    android.os.SystemClock.sleep(((long) new java.util.Random(java.lang.System.currentTimeMillis()).nextInt(10000)) + 10000);
                }
                i = i7;
            }
            java.lang.String strC = com.tencent.bugly.opengame.crashreport.common.info.b.c(this.c);
            if (strC == null) {
                com.tencent.bugly.opengame.proguard.x.d("Failed to request for network not avail", new java.lang.Object[i3]);
                i5 = i;
            } else {
                vVar.a(length);
                java.net.HttpURLConnection httpURLConnectionA = a(str2, bArr, strC, map);
                if (httpURLConnectionA != null) {
                    try {
                        try {
                            int responseCode = httpURLConnectionA.getResponseCode();
                            try {
                                if (responseCode == 200) {
                                    this.f405a = a(httpURLConnectionA);
                                    byte[] bArrB = b(httpURLConnectionA);
                                    vVar.b(bArrB == null ? 0L : bArrB.length);
                                    try {
                                        httpURLConnectionA.disconnect();
                                    } catch (java.lang.Throwable th2) {
                                        if (!com.tencent.bugly.opengame.proguard.x.a(th2)) {
                                            th2.printStackTrace();
                                        }
                                    }
                                    return bArrB;
                                }
                                if (responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307) {
                                    try {
                                        java.lang.String headerField = httpURLConnectionA.getHeaderField("Location");
                                        if (headerField == null) {
                                            try {
                                                com.tencent.bugly.opengame.proguard.x.e("Failed to redirect: %d" + responseCode, new java.lang.Object[0]);
                                                try {
                                                    httpURLConnectionA.disconnect();
                                                    return null;
                                                } catch (java.lang.Throwable th3) {
                                                    if (com.tencent.bugly.opengame.proguard.x.a(th3)) {
                                                        return null;
                                                    }
                                                    th3.printStackTrace();
                                                    return null;
                                                }
                                            } catch (java.io.IOException e) {
                                                e = e;
                                                z = true;
                                            }
                                        } else {
                                            i6++;
                                            try {
                                                java.lang.Object[] objArr = new java.lang.Object[2];
                                                objArr[0] = java.lang.Integer.valueOf(responseCode);
                                                try {
                                                    objArr[1] = headerField;
                                                    com.tencent.bugly.opengame.proguard.x.c("redirect code: %d ,to:%s", objArr);
                                                    str2 = headerField;
                                                    i2 = 0;
                                                    z = true;
                                                } catch (java.io.IOException e2) {
                                                    e = e2;
                                                    str2 = headerField;
                                                    i = 0;
                                                    z = true;
                                                }
                                            } catch (java.io.IOException e3) {
                                                e = e3;
                                            }
                                        }
                                    } catch (java.io.IOException e4) {
                                        e = e4;
                                    }
                                } else {
                                    i2 = i;
                                }
                                try {
                                    com.tencent.bugly.opengame.proguard.x.d("response code " + responseCode, new java.lang.Object[0]);
                                    length = length;
                                    long contentLength = httpURLConnectionA.getContentLength();
                                    if (contentLength < 0) {
                                        contentLength = 0;
                                    }
                                    try {
                                        vVar.b(contentLength);
                                        try {
                                            httpURLConnectionA.disconnect();
                                        } catch (java.lang.Throwable th4) {
                                            th = th4;
                                            if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                                                th.printStackTrace();
                                            }
                                        }
                                    } catch (java.io.IOException e5) {
                                        e = e5;
                                        i = i2;
                                        i2 = i;
                                        if (!com.tencent.bugly.opengame.proguard.x.a(e)) {
                                            e.printStackTrace();
                                        }
                                        httpURLConnectionA.disconnect();
                                    }
                                } catch (java.io.IOException e6) {
                                    e = e6;
                                    length = length;
                                }
                                i5 = i2;
                                i3 = 0;
                                httpURLConnectionA.disconnect();
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                                if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                                    th.printStackTrace();
                                }
                            }
                        } catch (java.io.IOException e7) {
                            e = e7;
                        }
                        i5 = i2;
                        i3 = 0;
                    } catch (java.lang.Throwable th6) {
                        try {
                            httpURLConnectionA.disconnect();
                            throw th6;
                        } catch (java.lang.Throwable th7) {
                            if (com.tencent.bugly.opengame.proguard.x.a(th7)) {
                                throw th6;
                            }
                            th7.printStackTrace();
                            throw th6;
                        }
                    }
                    i2 = i;
                    if (!com.tencent.bugly.opengame.proguard.x.a(e)) {
                        e.printStackTrace();
                    }
                } else {
                    length = length;
                    com.tencent.bugly.opengame.proguard.x.c("Failed to execute post.", new java.lang.Object[i3]);
                    vVar.b(0L);
                    i5 = i;
                }
                length = length;
                bArr2 = null;
            }
            i4 = 1;
        }
        return bArr2;
    }
}
