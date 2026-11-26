package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class s {
    private static com.tencent.bugly.proguard.s b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.util.Map<java.lang.String, java.lang.String> f447a = null;
    private android.content.Context c;

    private s(android.content.Context context) {
        this.c = context;
    }

    public static com.tencent.bugly.proguard.s a(android.content.Context context) {
        if (b == null) {
            b = new com.tencent.bugly.proguard.s(context);
        }
        return b;
    }

    private static java.net.HttpURLConnection a(java.lang.String str, java.lang.String str2) {
        java.net.HttpURLConnection httpURLConnection;
        try {
            java.net.URL url = new java.net.URL(str2);
            if (com.tencent.bugly.proguard.a.b() != null) {
                httpURLConnection = (java.net.HttpURLConnection) url.openConnection(com.tencent.bugly.proguard.a.b());
            } else if (str == null || !str.toLowerCase(java.util.Locale.US).contains("wap")) {
                httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
            } else {
                httpURLConnection = (java.net.HttpURLConnection) url.openConnection(new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(java.lang.System.getProperty("http.proxyHost"), java.lang.Integer.parseInt(java.lang.System.getProperty("http.proxyPort")))));
            }
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private java.net.HttpURLConnection a(java.lang.String str, byte[] bArr, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        if (str == null) {
            com.tencent.bugly.proguard.x.e("destUrl is null.", new java.lang.Object[0]);
            return null;
        }
        java.net.HttpURLConnection httpURLConnectionA = a(str2, str);
        if (httpURLConnectionA == null) {
            com.tencent.bugly.proguard.x.e("Failed to get HttpURLConnection object.", new java.lang.Object[0]);
            return null;
        }
        try {
            httpURLConnectionA.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                    httpURLConnectionA.setRequestProperty(entry.getKey(), java.net.URLEncoder.encode(entry.getValue(), com.unisound.b.f.b));
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
            if (!com.tencent.bugly.proguard.x.a(th)) {
                th.printStackTrace();
            }
            com.tencent.bugly.proguard.x.e("Failed to upload, please check your network.", new java.lang.Object[0]);
            return null;
        }
    }

    private static java.util.Map<java.lang.String, java.lang.String> a(java.net.HttpURLConnection httpURLConnection) {
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
    private static byte[] b(java.net.HttpURLConnection httpURLConnection) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new java.io.BufferedInputStream(httpURLConnection.getInputStream());
            try {
                try {
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = bufferedInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                        th = th;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (java.lang.Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        bufferedInputStream.close();
                    } catch (java.lang.Throwable th2) {
                        th2.printStackTrace();
                    }
                    return byteArray;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    if (!com.tencent.bugly.proguard.x.a(th)) {
                        th.printStackTrace();
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (java.lang.Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (java.lang.Throwable th5) {
                th = th5;
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
            bufferedInputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x018c A[Catch: all -> 0x017f, TRY_LEAVE, TryCatch #12 {all -> 0x017f, blocks: (B:23:0x009b, B:25:0x00a3, B:29:0x00b4, B:28:0x00b2, B:49:0x00dd, B:51:0x00e5, B:65:0x0118, B:67:0x0122, B:81:0x0141, B:85:0x0164, B:103:0x0186, B:105:0x018c), top: B:139:0x009b }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final byte[] a(java.lang.String str, byte[] bArr, com.tencent.bugly.proguard.v vVar, java.util.Map<java.lang.String, java.lang.String> map) {
        int i;
        int i2;
        byte[] bArr2 = null;
        int i3 = 0;
        if (str == null) {
            com.tencent.bugly.proguard.x.e("Failed for no URL.", new java.lang.Object[0]);
            return null;
        }
        long length = bArr == null ? 0L : bArr.length;
        int i4 = 1;
        com.tencent.bugly.proguard.x.c("request: %s, send: %d (pid=%d | tid=%d)", str, java.lang.Long.valueOf(length), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
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
                    com.tencent.bugly.proguard.x.c("try time: " + i7, new java.lang.Object[i3]);
                    android.os.SystemClock.sleep(((long) new java.util.Random(java.lang.System.currentTimeMillis()).nextInt(10000)) + 10000);
                }
                i = i7;
            }
            java.lang.String strC = com.tencent.bugly.crashreport.common.info.b.c(this.c);
            if (strC == null) {
                com.tencent.bugly.proguard.x.d("Failed to request for network not avail", new java.lang.Object[i3]);
                i5 = i;
                i4 = 1;
            } else {
                vVar.a(length);
                java.net.HttpURLConnection httpURLConnectionA = a(str2, bArr, strC, map);
                if (httpURLConnectionA != null) {
                    try {
                        try {
                            try {
                                int responseCode = httpURLConnectionA.getResponseCode();
                                if (responseCode == 200) {
                                    this.f447a = a(httpURLConnectionA);
                                    byte[] bArrB = b(httpURLConnectionA);
                                    vVar.b(bArrB == null ? 0L : bArrB.length);
                                    try {
                                        httpURLConnectionA.disconnect();
                                    } catch (java.lang.Throwable th) {
                                        if (!com.tencent.bugly.proguard.x.a(th)) {
                                            th.printStackTrace();
                                        }
                                    }
                                    return bArrB;
                                }
                                if (responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307) {
                                    try {
                                        java.lang.String headerField = httpURLConnectionA.getHeaderField("Location");
                                        if (headerField == null) {
                                            try {
                                                com.tencent.bugly.proguard.x.e("Failed to redirect: %d" + responseCode, new java.lang.Object[0]);
                                                try {
                                                    httpURLConnectionA.disconnect();
                                                    return null;
                                                } catch (java.lang.Throwable th2) {
                                                    if (com.tencent.bugly.proguard.x.a(th2)) {
                                                        return null;
                                                    }
                                                    th2.printStackTrace();
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
                                                    com.tencent.bugly.proguard.x.c("redirect code: %d ,to:%s", objArr);
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
                                    com.tencent.bugly.proguard.x.d("response code " + responseCode, new java.lang.Object[0]);
                                    length = length;
                                    long contentLength = httpURLConnectionA.getContentLength();
                                    if (contentLength < 0) {
                                        contentLength = 0;
                                    }
                                    try {
                                        vVar.b(contentLength);
                                        try {
                                            httpURLConnectionA.disconnect();
                                        } catch (java.lang.Throwable th3) {
                                            if (!com.tencent.bugly.proguard.x.a(th3)) {
                                                th3.printStackTrace();
                                            }
                                        }
                                        i5 = i2;
                                    } catch (java.io.IOException e5) {
                                        e = e5;
                                        i = i2;
                                        if (!com.tencent.bugly.proguard.x.a(e)) {
                                            e.printStackTrace();
                                        }
                                        httpURLConnectionA.disconnect();
                                        i5 = i;
                                    }
                                } catch (java.io.IOException e6) {
                                    e = e6;
                                    length = length;
                                }
                                i3 = 0;
                            } catch (java.io.IOException e7) {
                                e = e7;
                            }
                            i3 = 0;
                        } catch (java.lang.Throwable th4) {
                            try {
                                httpURLConnectionA.disconnect();
                                throw th4;
                            } catch (java.lang.Throwable th5) {
                                if (com.tencent.bugly.proguard.x.a(th5)) {
                                    throw th4;
                                }
                                th5.printStackTrace();
                                throw th4;
                            }
                        }
                        httpURLConnectionA.disconnect();
                    } catch (java.lang.Throwable th6) {
                        if (!com.tencent.bugly.proguard.x.a(th6)) {
                            th6.printStackTrace();
                        }
                    }
                    if (!com.tencent.bugly.proguard.x.a(e)) {
                        e.printStackTrace();
                    }
                    i5 = i;
                } else {
                    length = length;
                    i3 = 0;
                    com.tencent.bugly.proguard.x.c("Failed to execute post.", new java.lang.Object[0]);
                    vVar.b(0L);
                    i5 = i;
                }
                length = length;
                bArr2 = null;
                i4 = 1;
            }
        }
        return bArr2;
    }
}
