package com.tencent.hlyyb.downloader.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a implements com.tencent.hlyyb.downloader.a.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f601a;
    protected com.tencent.hlyyb.downloader.e.d.a b;
    protected boolean c;
    public com.tencent.hlyyb.downloader.a.b f;
    protected java.lang.String g;
    protected java.util.Map h;
    private java.lang.String j;
    private java.util.List i = null;
    private com.tencent.hlyyb.downloader.a.a.c k = new com.tencent.hlyyb.downloader.a.a.c();
    protected java.util.Map d = null;
    private int l = 0;
    private java.lang.String m = "";
    private int n = 4096;
    public boolean e = false;
    private int o = 8;
    private java.lang.String p = "";
    private java.net.URL q = null;
    private java.net.HttpURLConnection r = null;
    private java.io.InputStream s = null;
    private java.lang.String t = "";
    private java.lang.String u = "";
    private java.lang.String v = "";
    private java.lang.String w = "";
    private java.lang.String x = "";
    private java.lang.String y = "";
    private long z = -1;
    private java.util.List A = null;
    private volatile boolean B = false;
    private boolean C = false;

    private void a(java.lang.String str) {
        int iIndexOf;
        java.net.HttpURLConnection httpURLConnection = this.r;
        java.lang.String headerField = httpURLConnection != null ? httpURLConnection.getHeaderField("X-Extra-Servers") : "";
        if (android.text.TextUtils.isEmpty(headerField)) {
            return;
        }
        try {
            if ("http".equals(new java.net.URL(str).getProtocol()) && str.startsWith("http://") && (iIndexOf = str.indexOf("/", 7)) != -1) {
                str.substring(7, iIndexOf);
                java.lang.String strSubstring = str.substring(iIndexOf);
                java.lang.String[] strArrSplit = headerField.split(";");
                if (strArrSplit == null || strArrSplit.length <= 0) {
                    return;
                }
                this.A = new java.util.ArrayList();
                for (java.lang.String str2 : strArrSplit) {
                    this.A.add("http://" + str2 + strSubstring);
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    private void a(java.lang.Throwable th) {
        int iB;
        th.printStackTrace();
        this.m = th.getClass().getName() + "|" + th;
        if (this.B) {
            iB = -66;
        } else if (com.tencent.hlyyb.common.a.f.m()) {
            iB = -77;
        } else if (com.tencent.hlyyb.common.a.f.i()) {
            iB = !com.tencent.hlyyb.common.a.n.a() ? -16 : b(th);
        } else {
            iB = -15;
        }
        this.l = iB;
    }

    private static int b(java.lang.Throwable th) {
        try {
            if (th.getMessage().contains("Permission")) {
                return -71;
            }
        } catch (java.lang.Throwable unused) {
        }
        if (!(th instanceof java.lang.Exception)) {
            return -70;
        }
        if (th != null) {
            if (th instanceof java.net.SocketTimeoutException) {
                return -25;
            }
            if (th instanceof java.net.UnknownHostException) {
                return -29;
            }
            if (th instanceof java.net.ConnectException) {
                return -24;
            }
            if (th instanceof java.net.SocketException) {
                return -26;
            }
            if (th instanceof java.io.IOException) {
                return -27;
            }
        }
        return -48;
    }

    private static long b(java.lang.String str) {
        java.lang.String[] strArrSplit;
        if (android.text.TextUtils.isEmpty(str) || (strArrSplit = str.split("/")) == null || strArrSplit.length != 2) {
            return -1L;
        }
        try {
            return java.lang.Long.valueOf(strArrSplit[1]).longValue();
        } catch (java.lang.NumberFormatException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    private static long c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return java.lang.Long.valueOf(str).longValue();
        } catch (java.lang.NumberFormatException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    private void t() {
        boolean z;
        if (this.k.f603a.size() > 0) {
            this.r.addRequestProperty("Range", this.k.toString());
        }
        this.r.addRequestProperty("Connection", cn.yunzhisheng.asr.JniUscClient.s);
        java.util.Map map = this.d;
        boolean z2 = false;
        if (map != null) {
            z = false;
            for (java.lang.String str : map.keySet()) {
                this.r.addRequestProperty(str, (java.lang.String) this.d.get(str));
                if ("User-Agent".equalsIgnoreCase(str)) {
                    z2 = true;
                }
                if (str.equalsIgnoreCase("host")) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        if (!z2) {
            this.r.addRequestProperty("User-Agent", "HalleyService/3.0");
        }
        java.util.Map map2 = this.h;
        if (map2 != null && map2.size() > 0) {
            for (java.lang.String str2 : this.h.keySet()) {
                if (str2.equalsIgnoreCase("host")) {
                    z = true;
                }
                if (!str2.equalsIgnoreCase("range")) {
                    this.r.addRequestProperty(str2, (java.lang.String) this.h.get(str2));
                }
            }
        }
        if (z || android.text.TextUtils.isEmpty(this.g) || this.b.b != com.tencent.hlyyb.downloader.e.d.b.f) {
            return;
        }
        this.r.addRequestProperty("Host", this.g);
    }

    public final int a() {
        return this.l;
    }

    public final java.lang.String a(boolean z) {
        java.util.List list = this.i;
        if (list == null || list.size() == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int size = this.i.size() - 1;
        for (int i = 0; i < size; i++) {
            sb.append(com.tencent.hlyyb.common.f.c.a((java.lang.String) this.i.get(i), false));
            sb.append("-");
        }
        return sb.toString();
    }

    public final void a(com.tencent.hlyyb.downloader.a.a.b bVar) {
        this.k.a(bVar);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x003f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x0043  */
    /* JADX WARN: Code duplicated, block: B:20:0x0049  */
    /* JADX WARN: Code duplicated, block: B:22:0x0052 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:28:0x005e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0067 A[Catch: all -> 0x00e9, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x00e9, blocks: (B:13:0x0037, B:30:0x0067), top: B:102:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0079 A[Catch: all -> 0x00e5, TRY_LEAVE, TryCatch #2 {all -> 0x00e5, blocks: (B:32:0x006e, B:34:0x0079), top: B:100:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:36:0x007e  */
    /* JADX WARN: Code duplicated, block: B:39:0x008b A[Catch: all -> 0x00e3, TryCatch #1 {all -> 0x00e3, blocks: (B:37:0x0080, B:39:0x008b, B:43:0x0095, B:45:0x009d, B:51:0x00ad, B:52:0x00b2), top: B:98:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0093 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0095 A[Catch: all -> 0x00e3, TryCatch #1 {all -> 0x00e3, blocks: (B:37:0x0080, B:39:0x008b, B:43:0x0095, B:45:0x009d, B:51:0x00ad, B:52:0x00b2), top: B:98:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x009d A[Catch: all -> 0x00e3, TryCatch #1 {all -> 0x00e3, blocks: (B:37:0x0080, B:39:0x008b, B:43:0x0095, B:45:0x009d, B:51:0x00ad, B:52:0x00b2), top: B:98:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00da  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:82:0x011b A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:85:0x0123 A[DONT_GENERATE] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(com.tencent.hlyyb.downloader.a.a.e eVar) {
        long jElapsedRealtime;
        long jElapsedRealtime2;
        java.net.HttpURLConnection httpURLConnection;
        long j;
        byte[] bArr;
        long j2;
        boolean z;
        boolean z2;
        long j3;
        boolean z3;
        int i;
        boolean zA;
        int i2 = -66;
        try {
            this.s = this.r.getInputStream();
            com.tencent.hlyyb.downloader.a.a.b bVarB = this.k.b();
            if (bVarB != null) {
                j = bVarB.b - bVarB.f602a;
                if (bVarB.b == -1) {
                }
                bArr = new byte[this.n];
                j2 = 0;
                z = true;
                z2 = true;
                jElapsedRealtime = 0;
                jElapsedRealtime2 = 0;
                while (j2 < j) {
                    try {
                        if (this.f.a()) {
                            if (this.B) {
                                this.l = i2;
                            }
                            if (this.r != null) {
                                com.tencent.hlyyb.downloader.a.a.d.a();
                                com.tencent.hlyyb.downloader.a.a.d.a(this.r);
                                return;
                            }
                            return;
                        }
                        if (!z) {
                            if (this.B) {
                                this.l = i2;
                            }
                            if (this.r != null) {
                                com.tencent.hlyyb.downloader.a.a.d.a();
                                com.tencent.hlyyb.downloader.a.a.d.a(this.r);
                                return;
                            }
                            return;
                        }
                        j3 = jElapsedRealtime;
                        try {
                            int iMin = (int) java.lang.Math.min(this.n, j - j2);
                            if (j2 == 0) {
                                jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                            } else {
                                jElapsedRealtime = j3;
                            }
                            try {
                                z3 = z;
                                i = this.s.read(bArr, 0, iMin);
                                if (j2 == 0) {
                                    jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
                                }
                                if (i != -1) {
                                    this.l = -62;
                                    this.m = "readLen:" + j2 + ",dataLen:" + j;
                                    if (this.B) {
                                        this.l = -66;
                                    }
                                    if (this.r != null) {
                                        com.tencent.hlyyb.downloader.a.a.d.a();
                                        com.tencent.hlyyb.downloader.a.a.d.a(this.r);
                                        return;
                                    }
                                    return;
                                }
                                if (eVar != null) {
                                    if (this.f.a()) {
                                        zA = z3;
                                    } else {
                                        zA = eVar.a(bArr, i, z2);
                                    }
                                    if (z2) {
                                        z = zA;
                                        z2 = false;
                                    } else {
                                        z = zA;
                                    }
                                } else {
                                    z = z3;
                                }
                                j2 += (long) i;
                                i2 = -66;
                            } catch (java.lang.Throwable th) {
                                th = th;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            jElapsedRealtime = j3;
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                    }
                    try {
                        a(th);
                        if (jElapsedRealtime != 0 && jElapsedRealtime2 == 0) {
                            android.os.SystemClock.elapsedRealtime();
                        }
                        if (httpURLConnection != null) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (this.B) {
                            this.l = -66;
                        }
                        if (this.r != null) {
                            com.tencent.hlyyb.downloader.a.a.d.a();
                            com.tencent.hlyyb.downloader.a.a.d.a(this.r);
                        }
                    }
                }
                if (this.B) {
                    this.l = -66;
                }
                if (this.r != null) {
                    com.tencent.hlyyb.downloader.a.a.d.a();
                    com.tencent.hlyyb.downloader.a.a.d.a(this.r);
                }
            }
            j = this.z;
            bArr = new byte[this.n];
            j2 = 0;
            z = true;
            z2 = true;
            jElapsedRealtime = 0;
            jElapsedRealtime2 = 0;
            while (j2 < j) {
                if (this.f.a()) {
                    if (this.B) {
                        this.l = i2;
                    }
                    if (this.r != null) {
                        com.tencent.hlyyb.downloader.a.a.d.a();
                        com.tencent.hlyyb.downloader.a.a.d.a(this.r);
                        return;
                    }
                    return;
                }
                if (!z) {
                    if (this.B) {
                        this.l = i2;
                    }
                    if (this.r != null) {
                        com.tencent.hlyyb.downloader.a.a.d.a();
                        com.tencent.hlyyb.downloader.a.a.d.a(this.r);
                        return;
                    }
                    return;
                }
                j3 = jElapsedRealtime;
                int iMin2 = (int) java.lang.Math.min(this.n, j - j2);
                if (j2 == 0) {
                    jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                } else {
                    jElapsedRealtime = j3;
                }
                z3 = z;
                i = this.s.read(bArr, 0, iMin2);
                if (j2 == 0) {
                    jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
                }
                if (i != -1) {
                    this.l = -62;
                    this.m = "readLen:" + j2 + ",dataLen:" + j;
                    if (this.B) {
                        this.l = -66;
                    }
                    if (this.r != null) {
                        com.tencent.hlyyb.downloader.a.a.d.a();
                        com.tencent.hlyyb.downloader.a.a.d.a(this.r);
                        return;
                    }
                    return;
                }
                if (eVar != null) {
                    if (this.f.a()) {
                        zA = eVar.a(bArr, i, z2);
                    } else {
                        zA = z3;
                    }
                    if (z2) {
                        z = zA;
                        z2 = false;
                    } else {
                        z = zA;
                    }
                } else {
                    z = z3;
                }
                j2 += (long) i;
                i2 = -66;
                a(th);
                if (jElapsedRealtime != 0) {
                    android.os.SystemClock.elapsedRealtime();
                }
                if (httpURLConnection != null) {
                    return;
                } else {
                    return;
                }
            }
            if (this.B) {
                this.l = -66;
            }
            if (this.r != null) {
                com.tencent.hlyyb.downloader.a.a.d.a();
                com.tencent.hlyyb.downloader.a.a.d.a(this.r);
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            jElapsedRealtime = 0;
            jElapsedRealtime2 = 0;
        }
    }

    public final java.lang.String b() {
        return this.m;
    }

    public final long c() {
        return this.z;
    }

    public final java.lang.String d() {
        return com.tencent.hlyyb.common.f.c.a(this.j, false);
    }

    public final java.lang.String e() {
        java.util.List list = this.i;
        if (list == null || list.size() <= 0) {
            return null;
        }
        java.util.List list2 = this.i;
        return (java.lang.String) list2.get(list2.size() - 1);
    }

    public final java.lang.String f() {
        java.lang.String str = "";
        java.util.List list = this.i;
        if (list != null && list.size() > 0) {
            java.util.List list2 = this.i;
            str = (java.lang.String) list2.get(list2.size() - 1);
        }
        return com.tencent.hlyyb.common.f.c.a(str, false);
    }

    public final java.lang.String g() {
        return this.p;
    }

    public final java.lang.String h() {
        return this.t;
    }

    public final java.lang.String i() {
        return this.u;
    }

    public final java.lang.String j() {
        return this.v;
    }

    public final java.lang.String k() {
        return this.x;
    }

    public final java.lang.String l() {
        return this.y;
    }

    public final java.lang.String m() {
        return this.w;
    }

    public final java.util.List n() {
        return this.A;
    }

    public final boolean o() {
        return this.k.a() > 0;
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0248 A[Catch: Exception -> 0x0260, TryCatch #0 {Exception -> 0x0260, blocks: (B:119:0x023e, B:121:0x0248, B:123:0x0252, B:124:0x0257), top: B:129:0x023e }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0252 A[Catch: Exception -> 0x0260, TryCatch #0 {Exception -> 0x0260, blocks: (B:119:0x023e, B:121:0x0248, B:123:0x0252, B:124:0x0257), top: B:129:0x023e }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0257 A[Catch: Exception -> 0x0260, TRY_LEAVE, TryCatch #0 {Exception -> 0x0260, blocks: (B:119:0x023e, B:121:0x0248, B:123:0x0252, B:124:0x0257), top: B:129:0x023e }] */
    /* JADX WARN: Code duplicated, block: B:129:0x023e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:13:0x0026 A[PHI: r0
  0x0026: PHI (r0v20 com.tencent.hlyyb.downloader.e.d.a) = (r0v19 com.tencent.hlyyb.downloader.e.d.a), (r0v25 com.tencent.hlyyb.downloader.e.d.a) binds: [B:12:0x0024, B:7:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0029 A[PHI: r0
  0x0029: PHI (r0v23 com.tencent.hlyyb.downloader.e.d.a) = 
  (r0v19 com.tencent.hlyyb.downloader.e.d.a)
  (r0v19 com.tencent.hlyyb.downloader.e.d.a)
  (r0v25 com.tencent.hlyyb.downloader.e.d.a)
 binds: [B:10:0x001c, B:12:0x0024, B:7:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c4 A[Catch: all -> 0x01d6, TryCatch #1 {all -> 0x01d6, blocks: (B:29:0x0084, B:39:0x00a0, B:51:0x00c0, B:41:0x00a4, B:43:0x00aa, B:45:0x00ae, B:50:0x00ba, B:52:0x00c4, B:54:0x00d2, B:89:0x01af, B:55:0x00e6, B:57:0x00ec, B:58:0x00f3, B:59:0x0101, B:61:0x0111, B:63:0x011d, B:65:0x0125, B:70:0x0132, B:71:0x013a, B:77:0x015c, B:79:0x0164, B:81:0x0170, B:82:0x0180, B:90:0x01b2, B:83:0x0185, B:84:0x018a, B:86:0x0192, B:88:0x019e, B:91:0x01d1), top: B:130:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d2 A[Catch: all -> 0x01d6, TryCatch #1 {all -> 0x01d6, blocks: (B:29:0x0084, B:39:0x00a0, B:51:0x00c0, B:41:0x00a4, B:43:0x00aa, B:45:0x00ae, B:50:0x00ba, B:52:0x00c4, B:54:0x00d2, B:89:0x01af, B:55:0x00e6, B:57:0x00ec, B:58:0x00f3, B:59:0x0101, B:61:0x0111, B:63:0x011d, B:65:0x0125, B:70:0x0132, B:71:0x013a, B:77:0x015c, B:79:0x0164, B:81:0x0170, B:82:0x0180, B:90:0x01b2, B:83:0x0185, B:84:0x018a, B:86:0x0192, B:88:0x019e, B:91:0x01d1), top: B:130:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00e6 A[Catch: all -> 0x01d6, TryCatch #1 {all -> 0x01d6, blocks: (B:29:0x0084, B:39:0x00a0, B:51:0x00c0, B:41:0x00a4, B:43:0x00aa, B:45:0x00ae, B:50:0x00ba, B:52:0x00c4, B:54:0x00d2, B:89:0x01af, B:55:0x00e6, B:57:0x00ec, B:58:0x00f3, B:59:0x0101, B:61:0x0111, B:63:0x011d, B:65:0x0125, B:70:0x0132, B:71:0x013a, B:77:0x015c, B:79:0x0164, B:81:0x0170, B:82:0x0180, B:90:0x01b2, B:83:0x0185, B:84:0x018a, B:86:0x0192, B:88:0x019e, B:91:0x01d1), top: B:130:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ec A[Catch: all -> 0x01d6, TryCatch #1 {all -> 0x01d6, blocks: (B:29:0x0084, B:39:0x00a0, B:51:0x00c0, B:41:0x00a4, B:43:0x00aa, B:45:0x00ae, B:50:0x00ba, B:52:0x00c4, B:54:0x00d2, B:89:0x01af, B:55:0x00e6, B:57:0x00ec, B:58:0x00f3, B:59:0x0101, B:61:0x0111, B:63:0x011d, B:65:0x0125, B:70:0x0132, B:71:0x013a, B:77:0x015c, B:79:0x0164, B:81:0x0170, B:82:0x0180, B:90:0x01b2, B:83:0x0185, B:84:0x018a, B:86:0x0192, B:88:0x019e, B:91:0x01d1), top: B:130:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x012f  */
    /* JADX WARN: Code duplicated, block: B:90:0x01b2 A[Catch: all -> 0x01d6, TryCatch #1 {all -> 0x01d6, blocks: (B:29:0x0084, B:39:0x00a0, B:51:0x00c0, B:41:0x00a4, B:43:0x00aa, B:45:0x00ae, B:50:0x00ba, B:52:0x00c4, B:54:0x00d2, B:89:0x01af, B:55:0x00e6, B:57:0x00ec, B:58:0x00f3, B:59:0x0101, B:61:0x0111, B:63:0x011d, B:65:0x0125, B:70:0x0132, B:71:0x013a, B:77:0x015c, B:79:0x0164, B:81:0x0170, B:82:0x0180, B:90:0x01b2, B:83:0x0185, B:84:0x018a, B:86:0x0192, B:88:0x019e, B:91:0x01d1), top: B:130:0x0084 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:54:0x00d2, please report this as an issue */
    public final void p() {
        java.lang.String strE;
        boolean z;
        java.lang.StringBuilder sb;
        java.lang.String string;
        java.lang.String headerField;
        com.tencent.hlyyb.downloader.e.d.a aVar;
        java.lang.String str;
        if (android.text.TextUtils.isEmpty(this.j)) {
            if (this.f601a == 2) {
                aVar = this.b;
                if (android.text.TextUtils.isEmpty(aVar.e)) {
                    str = aVar.f626a;
                } else {
                    str = aVar.e;
                }
            } else {
                aVar = this.b;
                if (!aVar.d || android.text.TextUtils.isEmpty(aVar.e)) {
                    str = aVar.f626a;
                } else {
                    str = aVar.e;
                }
            }
            this.j = str;
        }
        if (this.r != null) {
            com.tencent.hlyyb.downloader.a.a.d.a();
            com.tencent.hlyyb.downloader.a.a.d.a(this.r);
        }
        for (int i = 0; i < this.o; i++) {
            if (this.f.a()) {
                return;
            }
            this.l = 0;
            this.m = "";
            try {
                java.net.URL url = new java.net.URL(this.j);
                this.q = url;
                try {
                    java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
                    this.r = httpURLConnection;
                    httpURLConnection.setConnectTimeout(com.tencent.hlyyb.downloader.a.a.a());
                    this.r.setReadTimeout(com.tencent.hlyyb.downloader.a.a.b());
                    this.r.setUseCaches(false);
                    boolean z2 = true;
                    this.r.setDoInput(true);
                    this.r.setInstanceFollowRedirects(false);
                    t();
                    try {
                        int responseCode = this.r.getResponseCode();
                        this.C = true;
                        if (responseCode == 200 || responseCode == 206) {
                            java.lang.String headerField2 = this.r.getHeaderField("Content-Type");
                            this.t = headerField2;
                            if (android.text.TextUtils.isEmpty(headerField2)) {
                                z = false;
                            } else {
                                java.lang.String lowerCase = headerField2.toLowerCase();
                                if (lowerCase.startsWith("text/html") || lowerCase.startsWith("text/vnd.wap.wml") || lowerCase.startsWith("text/webviewhtml")) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            }
                            if (z) {
                                this.l = -11;
                                string = this.j;
                            } else {
                                this.u = this.r.getHeaderField("Content-Range");
                                this.v = this.r.getHeaderField("Content-Length");
                                if (this.k.a() <= 0) {
                                    z2 = false;
                                }
                                if (z2) {
                                    if (android.text.TextUtils.isEmpty(this.u)) {
                                        this.l = -53;
                                    } else {
                                        long jB = b(this.u);
                                        this.z = jB;
                                        if (jB == -1) {
                                            this.l = -54;
                                            sb = new java.lang.StringBuilder("content-range header:");
                                            sb.append(this.u);
                                            string = sb.toString();
                                        } else {
                                            this.x = this.r.getHeaderField("etag");
                                            this.y = this.r.getHeaderField("Last-Modified");
                                            this.w = this.r.getHeaderField("Content-Disposition");
                                        }
                                    }
                                } else if (android.text.TextUtils.isEmpty(this.v)) {
                                    this.l = -55;
                                } else {
                                    long jC = c(this.v);
                                    this.z = jC;
                                    if (jC == -1) {
                                        this.l = -56;
                                        sb = new java.lang.StringBuilder("content-range header:");
                                        sb.append(this.v);
                                        string = sb.toString();
                                    } else {
                                        this.x = this.r.getHeaderField("etag");
                                        this.y = this.r.getHeaderField("Last-Modified");
                                        this.w = this.r.getHeaderField("Content-Disposition");
                                    }
                                }
                            }
                            this.m = string;
                        } else if (responseCode == 307) {
                            headerField = this.r.getHeaderField("location");
                            if (android.text.TextUtils.isEmpty(headerField)) {
                                this.l = -58;
                                string = "location:" + headerField;
                                this.m = string;
                            } else {
                                this.j = headerField;
                                if (this.i == null) {
                                    this.i = new java.util.ArrayList();
                                }
                                this.i.add(headerField);
                                this.j = headerField;
                                a(headerField);
                                this.l = -57;
                            }
                        } else {
                            if (responseCode != 413 && responseCode != 500) {
                                switch (responseCode) {
                                    case com.tencent.pipe.IPipeInterface.EVENT_PAY_IS_LOGIN /* 301 */:
                                    case 302:
                                    case 303:
                                        headerField = this.r.getHeaderField("location");
                                        if (android.text.TextUtils.isEmpty(headerField)) {
                                            this.l = -58;
                                            string = "location:" + headerField;
                                            this.m = string;
                                        } else {
                                            this.j = headerField;
                                            if (this.i == null) {
                                                this.i = new java.util.ArrayList();
                                            }
                                            this.i.add(headerField);
                                            this.j = headerField;
                                            a(headerField);
                                            this.l = -57;
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            } else if (com.tencent.hlyyb.common.a.f.j() && !this.e) {
                                if (this.k.a() <= 0) {
                                    z2 = false;
                                }
                                if (z2) {
                                    this.l = -59;
                                }
                            }
                            this.l = responseCode;
                        }
                    } catch (java.lang.Throwable th) {
                        a(th);
                    }
                } catch (java.io.IOException e) {
                    a(e);
                    e.printStackTrace();
                }
            } catch (java.net.MalformedURLException e2) {
                this.l = -51;
                this.m = e2.getMessage();
                e2.printStackTrace();
            }
            if (i == 0 && this.C) {
                try {
                    this.p = java.net.InetAddress.getByName(this.q.getHost()).getHostAddress();
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (this.l == -57) {
                if (this.c) {
                    this.l = -74;
                    this.m = "location:" + this.j;
                }
            }
            if (i >= this.o && this.l == -57) {
                this.l = -1;
            }
            if (this.l == 0) {
                try {
                    if (android.text.TextUtils.isEmpty(this.b.e)) {
                        strE = e();
                        if (!android.text.TextUtils.isEmpty(strE)) {
                            this.b.e = strE;
                        } else {
                            this.b.e = this.b.f626a;
                        }
                    }
                } catch (java.lang.Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
        }
        if (i >= this.o) {
            this.l = -1;
        }
        if (this.l == 0) {
            if (android.text.TextUtils.isEmpty(this.b.e)) {
                strE = e();
                if (!android.text.TextUtils.isEmpty(strE)) {
                    this.b.e = strE;
                } else {
                    this.b.e = this.b.f626a;
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] q() {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        byte[] byteArray = null;
        try {
            this.s = this.r.getInputStream();
            byte[] bArr = new byte[256];
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            while (true) {
                try {
                    int i = this.s.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        a(th);
                        return byteArray;
                    } finally {
                        if (this.r != null) {
                            com.tencent.hlyyb.downloader.a.a.d.a();
                            com.tencent.hlyyb.downloader.a.a.d.a(this.r);
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.io.IOException unused) {
                            }
                        }
                    }
                }
            }
            byteArray = byteArrayOutputStream.toByteArray();
            if (this.r != null) {
                com.tencent.hlyyb.downloader.a.a.d.a();
                com.tencent.hlyyb.downloader.a.a.d.a(this.r);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        return byteArray;
    }

    public final void r() {
        if (this.r != null) {
            com.tencent.hlyyb.downloader.a.a.d.a();
            com.tencent.hlyyb.downloader.a.a.d.a(this.r);
        }
    }

    @Override // com.tencent.hlyyb.downloader.a.a.f
    public final void s() {
        this.B = true;
    }
}
