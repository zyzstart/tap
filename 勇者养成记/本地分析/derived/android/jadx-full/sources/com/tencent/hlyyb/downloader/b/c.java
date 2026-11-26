package com.tencent.hlyyb.downloader.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements java.lang.Runnable {
    private static java.util.concurrent.atomic.AtomicInteger j = new java.util.concurrent.atomic.AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f606a;
    public com.tencent.hlyyb.downloader.e.d.a b;
    public com.tencent.hlyyb.common.a.m f;
    private java.util.List k;
    private com.tencent.hlyyb.downloader.e.h l;
    private com.tencent.hlyyb.downloader.b.d m;
    private com.tencent.hlyyb.downloader.e.d.c n;
    private com.tencent.hlyyb.downloader.a.a.g o;
    private java.util.List p;
    private boolean r;
    private java.util.concurrent.atomic.AtomicInteger s;
    private java.util.concurrent.atomic.AtomicInteger t;
    public volatile boolean c = false;
    public volatile boolean d = false;
    public volatile boolean e = false;
    private int q = -88;
    private int u = -1;
    private int v = -1;
    public com.tencent.hlyyb.downloader.b.e g = new com.tencent.hlyyb.downloader.b.e();
    public long h = 0;
    public java.lang.String i = "";

    public c(com.tencent.hlyyb.downloader.e.h hVar, com.tencent.hlyyb.downloader.e.d.c cVar, com.tencent.hlyyb.downloader.e.d.a aVar, java.util.List list, java.util.Map map, com.tencent.hlyyb.downloader.b.d dVar, boolean z, java.util.concurrent.atomic.AtomicInteger atomicInteger, java.util.concurrent.atomic.AtomicInteger atomicInteger2) {
        this.r = false;
        this.l = hVar;
        this.n = cVar;
        this.p = cVar.d();
        this.b = aVar;
        this.k = list;
        this.m = dVar;
        this.r = z;
        this.t = atomicInteger;
        this.s = atomicInteger2;
    }

    private void a(java.util.List list, java.lang.String str) {
        if (list.size() <= 0) {
            this.q = 3;
            return;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            byteArrayOutputStream.write(bArr, 0, bArr.length);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (java.io.IOException unused) {
        }
        if (com.tencent.hlyyb.common.f.c.a(byteArray)) {
            this.q = 6;
            return;
        }
        if (str.toLowerCase().equals(com.tencent.hlyyb.common.f.a.a(byteArray).toLowerCase())) {
            this.q = 0;
            return;
        }
        this.q = -1;
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("(?<=channelId=).*(?=\r\n)").matcher(new java.lang.String(byteArray));
        java.lang.String strGroup = matcher.find() ? matcher.group() : "";
        if (android.text.TextUtils.isEmpty(strGroup)) {
            return;
        }
        this.i = strGroup;
    }

    private byte[] a(com.tencent.hlyyb.downloader.e.d.a aVar, com.tencent.hlyyb.downloader.a.a.b bVar) {
        byte[] bArrQ = null;
        for (int i = 0; i < 2; i++) {
            boolean z = true;
            com.tencent.hlyyb.downloader.a.a.g gVar = new com.tencent.hlyyb.downloader.a.a.g(aVar, null, bVar, false, this.l, !this.f606a, this.n, 2);
            this.o = gVar;
            gVar.p();
            int iA = this.o.a();
            java.util.List list = this.g.e;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(iA);
            list.add(sb.toString());
            if (iA == 0) {
                bArrQ = this.o.q();
            } else if (iA == -74) {
                this.q = 7;
                bArrQ = null;
            }
            if (iA != 0 && iA != -66 && iA != -15 && iA != -16) {
                z = false;
            }
            if (z) {
                break;
            }
            android.os.SystemClock.sleep(50L);
        }
        return bArrQ;
    }

    private void d() {
        if (this.b.b == com.tencent.hlyyb.downloader.e.d.b.j) {
            this.q = 0;
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List listF = f();
        if (listF == null) {
            this.q = 2;
            return;
        }
        java.lang.String strC = this.n.c();
        for (int i = 0; i < listF.size(); i++) {
            byte[] bArrA = a(this.b, (com.tencent.hlyyb.downloader.a.a.b) listF.get(i));
            if (bArrA == null) {
                if (this.q != 7) {
                    this.q = 4;
                    return;
                }
                return;
            }
            arrayList.add(bArrA);
        }
        a(arrayList, strC);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.util.List e() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this.k) {
            for (com.tencent.hlyyb.downloader.b.c cVar : this.k) {
                if (cVar.c) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    private java.util.List f() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < this.p.size(); i++) {
            com.tencent.hlyyb.downloader.d.a aVar = (com.tencent.hlyyb.downloader.d.a) this.p.get(i);
            long j2 = aVar.f610a;
            long j3 = (((long) aVar.b) + j2) - 1;
            if (j2 < 0 || j2 > j3) {
                return null;
            }
            arrayList.add(new com.tencent.hlyyb.downloader.a.a.b(j2, j3));
        }
        return arrayList;
    }

    public final void a() {
        this.e = true;
        try {
            if (this.o != null) {
                this.o.s();
            }
            if (this.f != null) {
                this.f.a();
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public final void a(int i, int i2) {
        this.u = i;
        this.v = i2;
        com.tencent.hlyyb.downloader.b.e eVar = this.g;
        eVar.b = i;
        eVar.d = i2;
    }

    public final void a(java.lang.String str) {
        this.g.j.add(str);
    }

    public final java.lang.String b() {
        if (!(this.q == -1) && this.q != 7) {
            return "";
        }
        return "" + this.q + "," + this.u + "," + this.b.c + "," + this.v + "," + com.tencent.hlyyb.common.f.c.b(this.o.e());
    }

    public final void b(java.lang.String str) {
        this.g.l.add(str);
    }

    public final void c() {
        this.g.k = -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        new java.lang.StringBuilder("-").append(j.getAndIncrement());
        java.lang.String str = "";
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        try {
            if (this.e) {
                if (this.e && this.q == -88) {
                    this.q = 5;
                    str = "";
                }
                com.tencent.hlyyb.downloader.b.e eVar = this.g;
                eVar.c = this.b.c;
                eVar.f = this.q;
                eVar.g = str;
                eVar.h = (int) (android.os.SystemClock.elapsedRealtime() - jElapsedRealtime);
                this.g.i = (int) (android.os.SystemClock.elapsedRealtime() - this.h);
                this.g.f607a = this.t.incrementAndGet();
                com.tencent.hlyyb.downloader.e.d.a aVar = this.b;
                if (aVar.f626a.equals(!android.text.TextUtils.isEmpty(aVar.e) ? aVar.e : aVar.f626a)) {
                    return;
                }
                com.tencent.hlyyb.downloader.b.e eVar2 = this.g;
                com.tencent.hlyyb.downloader.e.d.a aVar2 = this.b;
                eVar2.m = !android.text.TextUtils.isEmpty(aVar2.e) ? aVar2.e : aVar2.f626a;
                return;
            }
            d();
            if (!this.e) {
                if (this.q == 0) {
                    this.n.a(this.b);
                } else if (this.q == -1) {
                    this.c = true;
                    this.s.incrementAndGet();
                }
                if (this.r) {
                    if (this.q == -1) {
                        this.d = true;
                        this.m.a(this.b);
                    }
                } else if (this.n.f() > 0) {
                    java.util.List<com.tencent.hlyyb.downloader.b.c> listE = e();
                    synchronized (com.tencent.hlyyb.downloader.b.c.class) {
                        for (com.tencent.hlyyb.downloader.b.c cVar : listE) {
                            cVar.d = true;
                            this.m.a(cVar.b);
                        }
                    }
                } else {
                    this.m.b();
                }
            }
            if (this.e && this.q == -88) {
                this.q = 5;
                str = "";
            }
            com.tencent.hlyyb.downloader.b.e eVar3 = this.g;
            eVar3.c = this.b.c;
            eVar3.f = this.q;
            eVar3.g = str;
            eVar3.h = (int) (android.os.SystemClock.elapsedRealtime() - jElapsedRealtime);
            this.g.i = (int) (android.os.SystemClock.elapsedRealtime() - this.h);
            this.g.f607a = this.t.incrementAndGet();
            com.tencent.hlyyb.downloader.e.d.a aVar3 = this.b;
            if (aVar3.f626a.equals(!android.text.TextUtils.isEmpty(aVar3.e) ? aVar3.e : aVar3.f626a)) {
                return;
            }
            com.tencent.hlyyb.downloader.b.e eVar4 = this.g;
            com.tencent.hlyyb.downloader.e.d.a aVar4 = this.b;
            eVar4.m = !android.text.TextUtils.isEmpty(aVar4.e) ? aVar4.e : aVar4.f626a;
        } catch (java.lang.Throwable th) {
            try {
                this.q = 1;
                java.lang.String str2 = th.getClass().getSimpleName() + "(" + th.getLocalizedMessage() + ")";
            } finally {
                if (this.e && this.q == -88) {
                    this.q = 5;
                    str = "";
                }
                com.tencent.hlyyb.downloader.b.e eVar5 = this.g;
                eVar5.c = this.b.c;
                eVar5.f = this.q;
                eVar5.g = str;
                eVar5.h = (int) (android.os.SystemClock.elapsedRealtime() - jElapsedRealtime);
                this.g.i = (int) (android.os.SystemClock.elapsedRealtime() - this.h);
                this.g.f607a = this.t.incrementAndGet();
                com.tencent.hlyyb.downloader.e.d.a aVar5 = this.b;
                if (!aVar5.f626a.equals(!android.text.TextUtils.isEmpty(aVar5.e) ? aVar5.e : aVar5.f626a)) {
                    com.tencent.hlyyb.downloader.b.e eVar6 = this.g;
                    com.tencent.hlyyb.downloader.e.d.a aVar6 = this.b;
                    eVar6.m = !android.text.TextUtils.isEmpty(aVar6.e) ? aVar6.e : aVar6.f626a;
                }
            }
        }
    }
}
