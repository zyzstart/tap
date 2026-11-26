package com.tencent.hlyyb.downloader.e.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.tencent.hlyyb.downloader.e.d.a f628a;
    public com.tencent.hlyyb.downloader.e.d.a b;
    private long d;
    private java.util.List i;
    private java.util.Map m;
    private java.lang.String n;
    private java.util.Map e = new java.util.concurrent.ConcurrentHashMap();
    private java.util.concurrent.atomic.AtomicInteger f = new java.util.concurrent.atomic.AtomicInteger(0);
    private volatile long g = -1;
    private java.lang.String h = "";
    private java.lang.String j = "";
    private volatile boolean k = false;
    public int c = 0;
    private long l = -1;
    private final java.util.List o = new java.util.ArrayList();

    public c(java.lang.String str, long j) {
        this.d = -1L;
        com.tencent.hlyyb.downloader.e.d.a aVar = new com.tencent.hlyyb.downloader.e.d.a(str, com.tencent.hlyyb.downloader.e.d.b.b);
        this.f628a = aVar;
        aVar.c = this.f.getAndIncrement();
        this.d = j;
        try {
            this.n = new java.net.URL(str).getHost();
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private com.tencent.hlyyb.downloader.e.d.a a(java.lang.String str, com.tencent.hlyyb.downloader.e.d.a aVar) {
        com.tencent.hlyyb.downloader.e.d.d dVar = (com.tencent.hlyyb.downloader.e.d.d) this.e.get(str);
        if (dVar == null) {
            return null;
        }
        synchronized (dVar) {
            java.util.List list = dVar.b;
            if (list == null || list.size() <= 0) {
                return null;
            }
            int iIndexOf = list.indexOf(aVar);
            if (iIndexOf == -1) {
                return (com.tencent.hlyyb.downloader.e.d.a) list.get(0);
            }
            if (iIndexOf == list.size() - 1) {
                return null;
            }
            return (com.tencent.hlyyb.downloader.e.d.a) list.get(iIndexOf + 1);
        }
    }

    static /* synthetic */ boolean a(com.tencent.hlyyb.downloader.e.d.c cVar, boolean z) {
        cVar.k = true;
        return true;
    }

    private com.tencent.hlyyb.downloader.e.d.a b(com.tencent.hlyyb.downloader.e.d.a aVar) {
        synchronized (this.o) {
            if (this.o.size() <= 0) {
                return null;
            }
            int iIndexOf = this.o.indexOf(aVar);
            if (iIndexOf == -1) {
                return (com.tencent.hlyyb.downloader.e.d.a) this.o.get(0);
            }
            if (iIndexOf == this.o.size() - 1) {
                return null;
            }
            return (com.tencent.hlyyb.downloader.e.d.a) this.o.get(iIndexOf + 1);
        }
    }

    private com.tencent.hlyyb.downloader.e.d.d b(java.lang.String str) {
        com.tencent.hlyyb.downloader.e.d.d dVar;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.e) {
            dVar = (com.tencent.hlyyb.downloader.e.d.d) this.e.get(str);
            if (dVar == null) {
                dVar = new com.tencent.hlyyb.downloader.e.d.d(this, str);
                this.e.put(str, dVar);
            }
        }
        return dVar;
    }

    public final long a() {
        return this.g;
    }

    public final com.tencent.hlyyb.downloader.e.d.a a(int i) {
        com.tencent.hlyyb.downloader.e.d.d dVarB = b(com.tencent.hlyyb.common.a.f.b());
        if (dVarB != null) {
            return (i == com.tencent.hlyyb.downloader.e.d.b.b || i == com.tencent.hlyyb.downloader.e.d.b.f627a) ? dVarB.c : dVarB.d;
        }
        return null;
    }

    public final com.tencent.hlyyb.downloader.e.d.a a(java.lang.String str, com.tencent.hlyyb.downloader.e.d.a aVar, boolean z, boolean z2, boolean z3, boolean z4) {
        com.tencent.hlyyb.downloader.e.d.a aVarA;
        com.tencent.hlyyb.downloader.e.d.a aVarA2;
        com.tencent.hlyyb.downloader.e.d.d dVar;
        if (z4) {
            aVarA = a(str, aVar);
            if (aVarA != null) {
                return aVarA;
            }
        } else {
            aVarA = null;
        }
        if (z3 && (aVarA = b(aVar)) != null) {
            return aVarA;
        }
        int iA = 0;
        if (aVar != null) {
            iA = aVar.b;
            if (!z2 && com.tencent.hlyyb.downloader.e.d.a.b(iA) && (dVar = (com.tencent.hlyyb.downloader.e.d.d) this.e.get(str)) != null && (aVarA = dVar.a(aVar)) != null) {
                return aVarA;
            }
        }
        com.tencent.hlyyb.downloader.e.d.b.a();
        for (int i = 10; aVarA == null && i > 0; i--) {
            iA = com.tencent.hlyyb.downloader.e.d.a.a(iA, z);
            if (com.tencent.hlyyb.downloader.e.d.a.a(iA)) {
                com.tencent.hlyyb.downloader.e.d.d dVar2 = (com.tencent.hlyyb.downloader.e.d.d) this.e.get(str);
                if (dVar2 != null) {
                    aVarA2 = dVar2.a(iA);
                }
            } else {
                aVarA2 = iA == com.tencent.hlyyb.downloader.e.d.b.g ? this.b : this.f628a;
            }
            aVarA = aVarA2;
        }
        return aVarA == null ? this.f628a : aVarA;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized com.tencent.hlyyb.downloader.e.d.a a(java.util.List list, boolean z) {
        com.tencent.hlyyb.downloader.e.d.d dVar = (com.tencent.hlyyb.downloader.e.d.d) this.e.get(com.tencent.hlyyb.common.a.f.b());
        if (dVar != null) {
            java.util.List<com.tencent.hlyyb.downloader.e.d.a> listA = dVar.a();
            if (z) {
                for (com.tencent.hlyyb.downloader.e.d.a aVar : listA) {
                    if (aVar.b == com.tencent.hlyyb.downloader.e.d.b.j && !list.contains(aVar)) {
                        return aVar;
                    }
                }
            }
            for (com.tencent.hlyyb.downloader.e.d.a aVar2 : listA) {
                if (!list.contains(aVar2) && !aVar2.f) {
                    return aVar2;
                }
            }
        }
        return null;
    }

    public final void a(com.tencent.hlyyb.downloader.e.d.a aVar) {
        synchronized (this.o) {
            aVar.d = true;
            this.o.add(aVar);
        }
    }

    public final void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.hlyyb.downloader.e.d.a aVar = new com.tencent.hlyyb.downloader.e.d.a(str, com.tencent.hlyyb.downloader.e.d.b.g);
        this.b = aVar;
        aVar.c = this.f.getAndIncrement();
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        com.tencent.hlyyb.downloader.e.d.d dVarB;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || (dVarB = b(str)) == null) {
            return;
        }
        dVarB.a(str2);
    }

    public final void a(java.lang.String str, java.lang.String str2, int i) {
        com.tencent.hlyyb.downloader.e.d.d dVarB;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || (dVarB = b(str)) == null) {
            return;
        }
        dVarB.a(str2, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(boolean r4) {
        /*
            r3 = this;
            com.tencent.hlyyb.common.a.f.e()
            java.lang.String r0 = com.tencent.hlyyb.common.a.f.b()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto Lf
            return r2
        Lf:
            java.util.Map r1 = r3.e
            java.lang.Object r0 = r1.get(r0)
            com.tencent.hlyyb.downloader.e.d.d r0 = (com.tencent.hlyyb.downloader.e.d.d) r0
            r1 = 1
            if (r0 == 0) goto L2c
            if (r4 == 0) goto L21
            boolean r4 = r0.e
            if (r4 != 0) goto L27
            goto L25
        L21:
            boolean r4 = r0.f
            if (r4 != 0) goto L27
        L25:
            r4 = 1
            goto L28
        L27:
            r4 = 0
        L28:
            if (r4 == 0) goto L2b
            goto L2c
        L2b:
            return r2
        L2c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hlyyb.downloader.e.d.c.a(boolean):boolean");
    }

    public final java.lang.String b() {
        return this.h;
    }

    public final void b(int i) {
        if (this.l == -1) {
            this.l = android.os.SystemClock.elapsedRealtime();
        }
        if (a(true)) {
            java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
            com.tencent.hlyyb.downloader.e.d.e eVar = new com.tencent.hlyyb.downloader.e.d.e(this, countDownLatch);
            int i2 = 1 ^ (this.k ? 1 : 0);
            java.lang.String str = this.f628a.f626a;
            long j = this.d;
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            com.tencent.hlyyb.common.d.b.b.a aVar = new com.tencent.hlyyb.common.d.b.b.a();
            com.tencent.hlyyb.common.d.b.b.a.d dVar = new com.tencent.hlyyb.common.d.b.b.a.d();
            dVar.f575a = str;
            dVar.c = j;
            dVar.b = i2;
            aVar.f571a.put("resScheduleInfo", dVar.a());
            com.tencent.hlyyb.common.b.a.c cVarA = com.tencent.hlyyb.common.b.a.c.a("https://yun-hl.3g.qq.com/halleycloud", false, null, aVar.a(), i, com.tencent.hlyyb.common.f.c.f(), true, com.tencent.hlyyb.common.d.f.d().f());
            cVarA.a("res_sche");
            com.tencent.hlyyb.common.b.a.f fVarB = cVarA.b();
            if (fVarB.c == 200 && fVarB.f547a == 0) {
                byte[] bArr = fVarB.d;
                if (!com.tencent.hlyyb.common.f.c.a(bArr)) {
                    try {
                        com.tencent.hlyyb.downloader.d.a.a aVar2 = new com.tencent.hlyyb.downloader.d.a.a(new org.json.JSONObject(new java.lang.String(bArr)).optJSONObject("ResDispatch"), str);
                        if (aVar2.f611a) {
                            eVar.a(aVar2.g, aVar2.b, aVar2.c, aVar2.f, aVar2.e, aVar2.h);
                        } else {
                            eVar.a();
                        }
                    } catch (java.lang.Throwable th) {
                        eVar.a();
                        th.printStackTrace();
                    }
                }
            } else {
                eVar.a();
            }
            cVarA.j = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime;
            cVarA.a(false);
            com.tencent.hlyyb.common.d.f.d().a(2);
            try {
                android.os.SystemClock.elapsedRealtime();
                countDownLatch.await(20000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                android.os.SystemClock.elapsedRealtime();
            } catch (java.lang.InterruptedException unused) {
            }
        }
    }

    public final void b(java.lang.String str, java.lang.String str2) {
        com.tencent.hlyyb.downloader.e.d.d dVarB;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || (dVarB = b(str)) == null) {
            return;
        }
        dVarB.b(str2);
    }

    public final void b(boolean z) {
        com.tencent.hlyyb.downloader.e.d.d dVarB;
        com.tencent.hlyyb.common.a.f.e();
        java.lang.String strB = com.tencent.hlyyb.common.a.f.b();
        if (android.text.TextUtils.isEmpty(strB) || (dVarB = b(strB)) == null) {
            return;
        }
        if (z) {
            dVarB.e = true;
        } else {
            dVarB.f = true;
        }
    }

    public final java.lang.String c() {
        return this.j;
    }

    public final java.util.Map c(int i) {
        java.util.Map map;
        int i2;
        java.util.Map map2 = this.m;
        if (map2 == null || map2.size() <= 0) {
            return null;
        }
        if (i == com.tencent.hlyyb.downloader.e.d.b.f) {
            map = this.m;
            i2 = 0;
        } else {
            if (i != com.tencent.hlyyb.downloader.e.d.b.j) {
                return null;
            }
            map = this.m;
            i2 = 1;
        }
        return (java.util.Map) map.get(java.lang.Integer.valueOf(i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final java.util.List d() {
        java.util.ArrayList arrayList;
        java.util.List list = this.i;
        if (list == null) {
            return null;
        }
        synchronized (list) {
            arrayList = new java.util.ArrayList();
            for (com.tencent.hlyyb.downloader.d.a aVar : this.i) {
                arrayList.add(new com.tencent.hlyyb.downloader.d.a(aVar.f610a, aVar.b));
            }
        }
        return arrayList;
    }

    public final java.lang.String e() {
        return this.n;
    }

    public final int f() {
        int size;
        synchronized (this.o) {
            size = this.o.size();
        }
        return size;
    }

    public final int g() {
        com.tencent.hlyyb.downloader.e.d.d dVar = (com.tencent.hlyyb.downloader.e.d.d) this.e.get(com.tencent.hlyyb.common.a.f.b());
        if (dVar != null) {
            return dVar.a().size();
        }
        return 1;
    }

    public final boolean h() {
        com.tencent.hlyyb.downloader.e.d.d dVar = (com.tencent.hlyyb.downloader.e.d.d) this.e.get(com.tencent.hlyyb.common.a.f.b());
        if (dVar == null) {
            return false;
        }
        java.util.List list = dVar.f629a;
        boolean z = list != null && list.size() > 0;
        if (z) {
            return z;
        }
        java.util.List list2 = dVar.b;
        return list2 != null && list2.size() > 0;
    }

    public final java.lang.String i() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.f628a != null) {
            sb.append("0,");
            sb.append(this.f628a);
            sb.append(";");
        }
        if (this.b != null) {
            sb.append("1,");
            sb.append(this.b);
            sb.append(";");
        }
        java.util.Iterator it = this.e.keySet().iterator();
        while (it.hasNext()) {
            com.tencent.hlyyb.downloader.e.d.d dVar = (com.tencent.hlyyb.downloader.e.d.d) this.e.get((java.lang.String) it.next());
            if (dVar != null) {
                sb.append(dVar);
                sb.append(";");
            }
        }
        return sb.toString();
    }
}
