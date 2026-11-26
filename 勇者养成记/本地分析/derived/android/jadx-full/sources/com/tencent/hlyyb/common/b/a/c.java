package com.tencent.hlyyb.common.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c extends com.tencent.hlyyb.common.b.a.a {
    private static boolean o = false;
    private java.lang.String A;
    private boolean p;
    private int r;
    private com.tencent.hlyyb.common.b.a.g s;
    private com.tencent.hlyyb.common.b.a.f t;
    private com.tencent.hlyyb.common.b.a.b u;
    private boolean w;
    private java.lang.String x;
    private com.tencent.hlyyb.common.a.a y;
    private java.lang.String z;
    public boolean n = true;
    private boolean q = false;
    private com.tencent.hlyyb.common.b.a v = com.tencent.hlyyb.common.b.a.a();

    private c(java.lang.String str, boolean z, java.util.Map map, byte[] bArr, int i, java.lang.String str2, boolean z2, int i2, boolean z3, com.tencent.hlyyb.common.a.c.c cVar, java.lang.String str3) {
        this.p = false;
        this.f543a = str;
        this.b = z;
        this.c = map;
        this.d = bArr;
        this.e = i;
        this.f = str2;
        this.p = false;
        this.r = 0;
        this.w = z3;
        this.z = str3;
    }

    public static com.tencent.hlyyb.common.b.a.c a(java.lang.String str, boolean z, java.util.Map map, byte[] bArr, int i, java.lang.String str2, boolean z2, com.tencent.hlyyb.common.a.c.c cVar) {
        return new com.tencent.hlyyb.common.b.a.c(str, false, map, bArr, i, str2, false, 0, true, cVar, "");
    }

    public final void a(java.lang.String str) {
        this.x = str;
    }

    public final void a(boolean z) {
        com.tencent.hlyyb.common.b.a.g gVar = this.s;
        if (gVar != null) {
            if (this.h) {
                gVar.h = true;
            }
            java.util.HashMap map = new java.util.HashMap();
            if (z) {
                map.put("B46", "1");
            } else {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(this.j);
                map.put("B22", sb.toString());
            }
            if (!com.tencent.hlyyb.common.f.c.a(this.x)) {
                map.put("B15", this.x);
            }
            if (!com.tencent.hlyyb.common.f.c.a(this.z)) {
                map.put("B54", this.z);
            }
            java.util.HashMap map2 = new java.util.HashMap();
            map2.put("B82", this.f);
            if (this.p) {
                map.put("B52", "1");
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(this.r);
                map.put("B58", sb2.toString());
            }
            java.lang.String str = null;
            map2.put("B44", com.tencent.hlyyb.common.f.c.b(null));
            if (!android.text.TextUtils.isEmpty(null) && !str.equals(this.A)) {
                map2.put("B49", com.tencent.hlyyb.common.f.c.b(this.A));
            }
            com.tencent.hlyyb.common.a.a aVar = this.y;
            if (aVar != null) {
                if (!aVar.e()) {
                    map2.put("B10", this.y.d());
                }
                if (this.y.f519a != -1) {
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append(this.y.f519a);
                    map2.put("B45", sb3.toString());
                }
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append((int) this.y.b());
                map2.put("B202", sb4.toString());
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                sb5.append(this.y.b);
                map2.put("B204", sb5.toString());
                java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                sb6.append(this.q ? 1 : 0);
                map2.put("B203", sb6.toString());
            }
            java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
            sb7.append(this.m.get());
            map2.put("B53", sb7.toString());
            if (!android.text.TextUtils.isEmpty(this.u.f544a)) {
                map2.put("B26", this.u.f544a);
            }
            this.s.a(map, map2);
        }
    }

    @Override // com.tencent.hlyyb.common.a.m
    public final boolean a() {
        this.l = true;
        com.tencent.hlyyb.common.b.a.g gVar = this.s;
        if (gVar == null) {
            return false;
        }
        gVar.a();
        return false;
    }

    public final com.tencent.hlyyb.common.b.a.f b() {
        int i;
        int i2;
        if (!o) {
            o = true;
            try {
                if (android.os.Build.VERSION.SDK != null && android.os.Build.VERSION.SDK_INT < 8) {
                    java.lang.System.setProperty("http.keepAlive", "false");
                }
            } catch (java.lang.Exception unused) {
            }
        }
        this.t = new com.tencent.hlyyb.common.b.a.f(0, "", 0);
        try {
            java.net.URL url = new java.net.URL(this.f543a);
            java.lang.String host = url.getHost();
            this.u = new com.tencent.hlyyb.common.b.a.b(url, this.f543a);
            java.util.List listA = this.u.a(this.v, this.w, url.getProtocol().toLowerCase().startsWith("https"));
            int size = listA.size();
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            int iElapsedRealtime = this.e;
            int i3 = 0;
            while (i3 < size) {
                this.m.incrementAndGet();
                com.tencent.hlyyb.common.a.a aVar = (com.tencent.hlyyb.common.a.a) listA.get(i3);
                this.y = aVar;
                if (aVar.b() < 3) {
                    this.q = true;
                }
                java.lang.String strA = this.u.a(this.y);
                this.A = strA;
                int i4 = i3;
                this.s = new com.tencent.hlyyb.common.b.a.g(host, strA, this.b, this.c, this.d, iElapsedRealtime, this.f);
                if (i4 != 0 || this.p) {
                    this.s.q = true;
                }
                if (com.tencent.hlyyb.common.a.f.j() && i4 != 0) {
                    this.s.o = true;
                }
                this.s.p = this.m.get();
                com.tencent.hlyyb.common.b.a.f fVarB = this.s.b();
                this.t = fVarB;
                com.tencent.hlyyb.common.b.a.a(host, this.y, fVarB.f547a);
                iElapsedRealtime = (int) (((long) this.e) - (android.os.SystemClock.elapsedRealtime() - jElapsedRealtime));
                com.tencent.hlyyb.common.b.a.f fVar = this.t;
                boolean z = (fVar.f547a == 0 && (i2 = fVar.c) >= 200 && i2 < 400) || (i = this.t.f547a) == -20 || i == -300 || i == -306 || i4 == size + (-1) || iElapsedRealtime <= 200;
                if (!z && this.t.f547a == -4) {
                    int iA = com.tencent.hlyyb.common.a.e.a("direct_nonet_retry_gap", 0, 10000, 3000);
                    long j = this.s.n;
                    long j2 = iA;
                    if (j >= j2) {
                        z = true;
                    } else {
                        android.os.SystemClock.sleep(com.tencent.hlyyb.common.f.c.a((int) (j2 - j), 200, iA, 200));
                    }
                }
                if (z) {
                    break;
                }
                a(true);
                i3 = i4 + 1;
            }
            return this.t;
        } catch (java.net.MalformedURLException unused2) {
            com.tencent.hlyyb.common.b.a.f fVar2 = this.t;
            fVar2.f547a = com.unisound.sdk.ab.l;
            return fVar2;
        }
    }
}
