package com.tencent.hlyyb.common.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class g extends com.tencent.hlyyb.common.b.a.a {
    private java.lang.String B;
    private com.tencent.hlyyb.common.b.a.e E;
    long n;
    private java.net.HttpURLConnection r;
    private java.io.DataOutputStream s;
    private java.io.DataInputStream t;
    private com.tencent.hlyyb.common.b.a.f u;
    private java.lang.String v;
    private boolean w;
    private boolean x;
    private int z;
    private java.lang.String y = "";
    private long A = 0;
    private com.tencent.hlyyb.common.b.a.h C = new com.tencent.hlyyb.common.b.a.h((byte) 0);
    boolean o = false;
    private boolean D = false;
    int p = 0;
    boolean q = false;

    public g(java.lang.String str, java.lang.String str2, boolean z, java.util.Map map, byte[] bArr, int i, java.lang.String str3) {
        this.v = str;
        this.f543a = str2;
        this.b = z;
        this.c = map;
        this.d = bArr;
        int iA = com.tencent.hlyyb.common.a.f.h() == 2 ? com.tencent.hlyyb.common.a.e.a("direct_access_time_out", 1000, com.youme.im.CommonConst.SPEECH_DURATION_MAX, 15000) : com.tencent.hlyyb.common.a.e.a("direct_access_time_out", 1000, com.youme.im.CommonConst.SPEECH_DURATION_MAX, 10000);
        this.e = com.tencent.hlyyb.common.f.c.a(i < iA ? i : iA, 200, com.youme.im.CommonConst.SPEECH_DURATION_MAX, 10000);
        this.f = str3;
    }

    private void a(int i) {
        int i2;
        boolean z = false;
        try {
            try {
                java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(this.r.getInputStream());
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                i2 = 0;
                while (true) {
                    try {
                        int i3 = bufferedInputStream.read(bArr);
                        if (i3 == -1) {
                            z = true;
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i3);
                        i2 += i3;
                        if (i2 > i) {
                            this.u.f547a = -303;
                            this.u.b = "no-content-length";
                            break;
                        }
                    } catch (java.lang.OutOfMemoryError unused) {
                        com.tencent.hlyyb.common.b.a.f fVar = this.u;
                        fVar.f547a = -306;
                        fVar.b = "no-content-length:" + i2;
                        return;
                    }
                }
                if (z) {
                    this.u.d = byteArrayOutputStream.toByteArray();
                    this.C.f = android.os.SystemClock.elapsedRealtime();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Exception unused2) {
                }
            } catch (java.lang.OutOfMemoryError unused3) {
                i2 = 0;
            }
        } catch (java.lang.Exception unused4) {
            com.tencent.hlyyb.common.b.a.f fVar2 = this.u;
            fVar2.f547a = -287;
            fVar2.b = "read without content-length error";
        }
    }

    private void c() {
        java.util.Map map = this.c;
        boolean z = false;
        if (map != null && map.size() > 0) {
            for (java.lang.String str : this.c.keySet()) {
                this.r.addRequestProperty(str, (java.lang.String) this.c.get(str));
                if (str.toLowerCase().contains("host")) {
                    z = true;
                }
            }
        }
        if (!z) {
            this.r.setRequestProperty("Host", this.v);
        }
        this.r.setRequestProperty("Halley", this.f + "-" + this.p + "-" + java.lang.System.currentTimeMillis());
        if (this.o) {
            this.r.setRequestProperty("X-Online-Host", this.v);
            this.r.setRequestProperty("x-tx-host", this.v);
        }
    }

    private boolean d() {
        if (!this.l) {
            return false;
        }
        this.u.f547a = -20;
        this.n = android.os.SystemClock.elapsedRealtime() - this.n;
        this.C.a();
        return true;
    }

    private void e() {
        try {
            if (this.r != null) {
                this.r.disconnect();
            }
            if (this.s != null) {
                this.s.close();
            }
            if (this.t != null) {
                this.t.close();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(java.util.Map map, java.util.Map map2) {
        int i;
        java.util.HashMap map3 = new java.util.HashMap();
        map3.putAll(map);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.n);
        map3.put("B59", sb.toString());
        if (this.w) {
            map3.put("B85", "1");
        }
        if (this.b) {
            map3.put("B95", "1");
        } else {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(this.A);
            map3.put("B96", sb2.toString());
        }
        if (!this.x) {
            map3.put("B23", "1");
        }
        java.util.HashMap map4 = new java.util.HashMap();
        map4.putAll(map2);
        if (this.k != 0) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(this.k);
            map4.put("B84", sb3.toString());
        }
        map4.put("B87", this.y);
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append(this.z);
        map4.put("B88", sb4.toString());
        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
        sb5.append(this.C.g);
        map4.put("B90", sb5.toString());
        java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
        sb6.append(this.C.h);
        map4.put("B91", sb6.toString());
        java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
        sb7.append(this.C.i);
        map4.put("B92", sb7.toString());
        java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
        sb8.append(this.C.j);
        map4.put("B93", sb8.toString());
        java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
        sb9.append(this.C.k);
        map4.put("B94", sb9.toString());
        if (!android.text.TextUtils.isEmpty(this.g)) {
            map4.put("B47", com.tencent.hlyyb.common.f.c.b(this.g));
        }
        if (!android.text.TextUtils.isEmpty(this.B)) {
            map4.put("B41", this.B);
        }
        com.tencent.hlyyb.common.b.a.f fVar = this.u;
        int i2 = fVar.f547a;
        if (i2 != 0) {
            i = i2;
        } else {
            int i3 = fVar.c;
            i = i3 == 200 ? 0 : i3;
        }
        if (this.q) {
            com.tencent.hlyyb.common.e.a.a("HLHttpDirect", com.tencent.hlyyb.common.a.c(), i, this.u.b, map3, map4, this.h);
        } else {
            com.tencent.hlyyb.common.e.a.b("HLHttpDirect", com.tencent.hlyyb.common.a.c(), i, this.u.b, map3, map4, this.h);
        }
    }

    @Override // com.tencent.hlyyb.common.a.m
    public final boolean a() {
        this.l = true;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:141:0x038c  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final com.tencent.hlyyb.common.b.a.f b() {
        java.net.HttpURLConnection httpURLConnection;
        com.tencent.hlyyb.common.b.a.f fVar;
        java.lang.StringBuilder sb;
        this.k = java.lang.System.currentTimeMillis();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        this.n = jElapsedRealtime;
        this.C.f548a = jElapsedRealtime;
        boolean z = false;
        this.u = new com.tencent.hlyyb.common.b.a.f(0, "", 0);
        try {
            try {
                try {
                    if (d()) {
                        com.tencent.hlyyb.common.b.a.f fVar2 = this.u;
                        e();
                        if (this.u.f547a != 0) {
                            this.B = com.tencent.hlyyb.common.f.c.c(this.v);
                        }
                        this.n = android.os.SystemClock.elapsedRealtime() - this.n;
                        this.C.a();
                        return fVar2;
                    }
                    java.net.URL url = new java.net.URL(this.f543a);
                    this.w = url.getProtocol().toLowerCase().startsWith("https");
                    this.x = com.tencent.hlyyb.common.f.c.d(url.getHost());
                    if (this.w) {
                        javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) url.openConnection((!this.o || com.tencent.hlyyb.common.a.f.l() == null) ? java.net.Proxy.NO_PROXY : com.tencent.hlyyb.common.a.f.l());
                        httpURLConnection = httpsURLConnection;
                        if (this.x) {
                            com.tencent.hlyyb.common.b.a.e eVar = new com.tencent.hlyyb.common.b.a.e(this.v);
                            this.E = eVar;
                            httpsURLConnection.setSSLSocketFactory(eVar);
                            httpsURLConnection.setHostnameVerifier(new com.tencent.hlyyb.common.b.a.d(this.v));
                            httpURLConnection = httpsURLConnection;
                        }
                    } else {
                        httpURLConnection = (java.net.HttpURLConnection) url.openConnection((!this.o || com.tencent.hlyyb.common.a.f.l() == null) ? java.net.Proxy.NO_PROXY : com.tencent.hlyyb.common.a.f.l());
                    }
                    this.r = httpURLConnection;
                    httpURLConnection.setRequestMethod(this.b ? com.tencent.connect.common.Constants.HTTP_GET : com.tencent.connect.common.Constants.HTTP_POST);
                    this.r.setConnectTimeout(this.e);
                    this.r.setReadTimeout(this.e);
                    this.r.setUseCaches(false);
                    this.r.setDoInput(true);
                    this.r.setInstanceFollowRedirects(false);
                    c();
                    if (!this.b && !com.tencent.hlyyb.common.f.c.a(this.d)) {
                        this.r.setDoOutput(true);
                        this.A = this.d.length;
                    }
                    this.C.b = android.os.SystemClock.elapsedRealtime();
                    this.r.connect();
                    this.C.c = android.os.SystemClock.elapsedRealtime();
                    if (d()) {
                        com.tencent.hlyyb.common.b.a.f fVar3 = this.u;
                        e();
                        if (this.u.f547a != 0) {
                            this.B = com.tencent.hlyyb.common.f.c.c(this.v);
                        }
                        this.n = android.os.SystemClock.elapsedRealtime() - this.n;
                        this.C.a();
                        return fVar3;
                    }
                    if (!this.b && !com.tencent.hlyyb.common.f.c.a(this.d)) {
                        java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(this.r.getOutputStream());
                        this.s = dataOutputStream;
                        dataOutputStream.write(this.d);
                        this.s.flush();
                    }
                    this.C.d = android.os.SystemClock.elapsedRealtime();
                    int responseCode = this.r.getResponseCode();
                    this.C.e = android.os.SystemClock.elapsedRealtime();
                    this.u.c = responseCode;
                    this.y = this.r.getContentType();
                    java.util.HashMap map = new java.util.HashMap();
                    for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : this.r.getHeaderFields().entrySet()) {
                        if (entry.getKey() != null) {
                            map.put(entry.getKey(), entry.getValue().get(0));
                        }
                    }
                    this.u.a(map);
                    if (this.u.c >= 200 && this.u.c < 300) {
                        this.z = this.r.getContentLength();
                        int iA = com.tencent.hlyyb.common.a.e.a("app_receive_pack_size", 524288, 10485760, 2097152);
                        if (this.z < 0) {
                            a(iA);
                        } else if (this.z == 0) {
                            this.u.d = null;
                            this.C.f = android.os.SystemClock.elapsedRealtime();
                        } else {
                            if (this.z > iA) {
                                this.u.f547a = -303;
                                fVar = this.u;
                                sb = new java.lang.StringBuilder();
                                sb.append(this.z);
                            } else {
                                try {
                                    byte[] bArr = new byte[this.z];
                                    java.io.DataInputStream dataInputStream = new java.io.DataInputStream(this.r.getInputStream());
                                    this.t = dataInputStream;
                                    dataInputStream.readFully(bArr);
                                    this.u.d = bArr;
                                    this.C.f = android.os.SystemClock.elapsedRealtime();
                                } catch (java.lang.OutOfMemoryError unused) {
                                    this.u.f547a = -306;
                                    fVar = this.u;
                                    sb = new java.lang.StringBuilder();
                                    sb.append(this.z);
                                    fVar.b = sb.toString();
                                }
                            }
                            fVar.b = sb.toString();
                        }
                    } else if (this.u.c >= 300 && this.u.c < 400) {
                        this.g = this.u.a("location");
                    }
                    e();
                    if (this.u.f547a != 0) {
                        this.B = com.tencent.hlyyb.common.f.c.c(this.v);
                    }
                    this.n = android.os.SystemClock.elapsedRealtime() - this.n;
                    this.C.a();
                    return this.u;
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                    this.u.f547a = -287;
                    this.u.b = th.getClass().getSimpleName() + "(" + th.getLocalizedMessage() + ")";
                    if ((this.E != null && this.E.f546a) || ((this.w && this.u.b.toLowerCase().contains("cannot verify hostname")) || (this.w && this.u.b.toLowerCase().contains("not verified")))) {
                        z = true;
                    }
                    if (!com.tencent.hlyyb.common.a.f.i()) {
                        this.u.f547a = -4;
                    } else if (this.l) {
                        this.u.f547a = -20;
                    } else if (z) {
                        this.u.f547a = -289;
                    } else {
                        this.h = true;
                        if (th.getMessage() != null && th.getMessage().toLowerCase().contains("permission")) {
                            this.u.f547a = -281;
                            this.u.b = "no permission";
                        } else if (th instanceof java.net.UnknownHostException) {
                            this.u.f547a = -284;
                        } else if (th instanceof java.net.ConnectException) {
                            this.u.f547a = -42;
                        } else if (th instanceof java.net.SocketTimeoutException) {
                            java.lang.String localizedMessage = th.getLocalizedMessage();
                            if (localizedMessage == null || !(localizedMessage.toLowerCase().contains("connect") || localizedMessage.toLowerCase().contains("connection"))) {
                                this.u.f547a = -13;
                            } else {
                                this.u.f547a = -10;
                            }
                        } else if (th instanceof java.net.SocketException) {
                            this.u.f547a = -41;
                        } else if (th instanceof java.io.IOException) {
                            this.u.f547a = -286;
                        }
                    }
                    e();
                    if (this.u.f547a != 0) {
                        this.B = com.tencent.hlyyb.common.f.c.c(this.v);
                    }
                }
            } catch (java.net.MalformedURLException unused2) {
                this.u.f547a = com.unisound.sdk.ab.l;
                e();
                if (this.u.f547a != 0) {
                    this.B = com.tencent.hlyyb.common.f.c.c(this.v);
                }
            }
        } catch (java.lang.Throwable th2) {
            e();
            if (this.u.f547a != 0) {
                this.B = com.tencent.hlyyb.common.f.c.c(this.v);
            }
            this.n = android.os.SystemClock.elapsedRealtime() - this.n;
            this.C.a();
            throw th2;
        }
    }
}
