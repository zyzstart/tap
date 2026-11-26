package com.tencent.hlyyb.downloader.e.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c implements com.tencent.hlyyb.downloader.a.a.e, com.tencent.hlyyb.downloader.a.b, com.tencent.hlyyb.downloader.b.d, java.lang.Runnable {
    private boolean A;
    private int B;
    private boolean C;
    private volatile int D;
    private long E;
    private volatile boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.tencent.hlyyb.downloader.e.b.a f619a;
    public com.tencent.hlyyb.downloader.e.d.a b;
    private boolean d;
    private com.tencent.hlyyb.downloader.e.d.c e;
    private com.tencent.hlyyb.downloader.a.b f;
    private com.tencent.hlyyb.downloader.e.b.b g;
    private java.util.Map h;
    private com.tencent.hlyyb.downloader.a.a.f m;
    private java.lang.String p;
    private boolean q;
    private java.util.List r;
    private java.util.Map s;
    private java.util.Map t;
    private com.tencent.hlyyb.downloader.b.a u;
    private java.util.concurrent.atomic.AtomicInteger w;
    private java.util.concurrent.atomic.AtomicInteger x;
    private boolean y;
    private boolean z;
    private int i = 0;
    private java.lang.String j = "";
    private boolean k = false;
    private boolean l = false;
    private java.lang.Object n = new java.lang.Object();
    private com.tencent.hlyyb.downloader.e.c.c o = new com.tencent.hlyyb.downloader.e.c.c();
    public volatile boolean c = false;
    private volatile boolean v = false;

    public c(com.tencent.hlyyb.downloader.e.d.c cVar, boolean z, com.tencent.hlyyb.downloader.a.b bVar, com.tencent.hlyyb.downloader.e.b.b bVar2, java.util.Map map, boolean z2) {
        this.d = true;
        this.h = null;
        this.q = true;
        this.y = com.tencent.hlyyb.common.a.e.a("down_hijack_feature_enable", 0, 1, 1) == 1;
        this.z = com.tencent.hlyyb.common.a.e.a("down_hijack_size_enable", 0, 1, 1) == 1;
        this.A = com.tencent.hlyyb.common.a.e.a("down_hijack_force_feature", 0, 1, 0) == 1;
        this.B = com.tencent.hlyyb.common.a.e.a("hijack_failed_cnt_switch_https", 0, 20, 3);
        this.C = false;
        this.F = true;
        this.e = cVar;
        this.d = z;
        this.o.f623a = z;
        this.f = bVar;
        this.g = bVar2;
        this.h = map;
        this.q = z2;
    }

    private boolean b(com.tencent.hlyyb.downloader.e.d.a aVar) {
        java.util.List listD;
        return this.e.a() > 0 && (listD = this.e.d()) != null && listD.size() > 0 && !android.text.TextUtils.isEmpty(this.e.c()) && aVar != null && this.s.get(aVar) == null && this.F && this.q && this.y;
    }

    @Override // com.tencent.hlyyb.downloader.b.d
    public final void a(com.tencent.hlyyb.downloader.e.d.a aVar) {
        com.tencent.hlyyb.downloader.b.c cVar = (com.tencent.hlyyb.downloader.b.c) this.s.get(aVar);
        if (cVar == null || cVar.e) {
            return;
        }
        this.u.a(aVar, cVar);
    }

    public final void a(java.util.List list, java.util.Map map, java.util.Map map2, com.tencent.hlyyb.downloader.b.a aVar, java.util.concurrent.atomic.AtomicInteger atomicInteger, java.util.concurrent.atomic.AtomicInteger atomicInteger2, long j) {
        this.r = list;
        this.s = map;
        this.t = map2;
        this.u = aVar;
        this.w = atomicInteger;
        this.x = atomicInteger2;
        this.E = j;
    }

    public final void a(boolean z) {
        this.F = false;
    }

    @Override // com.tencent.hlyyb.downloader.a.b
    public final boolean a() {
        com.tencent.hlyyb.downloader.a.b bVar;
        if (this.k || (bVar = this.f) == null) {
            return true;
        }
        return bVar.a();
    }

    @Override // com.tencent.hlyyb.downloader.a.a.e
    public final boolean a(byte[] bArr, int i, boolean z) {
        boolean z2;
        int i2;
        boolean z3 = true;
        if (b(this.b)) {
            com.tencent.hlyyb.downloader.b.c cVar = new com.tencent.hlyyb.downloader.b.c((com.tencent.hlyyb.downloader.e.h) this.f, this.e, this.b, this.r, this.s, this, this.A, this.x, this.w);
            synchronized (this.r) {
                this.r.add(cVar);
            }
            this.s.put(this.b, cVar);
            cVar.h = this.E;
            cVar.f = com.tencent.hlyyb.downloader.f.a.a().c(cVar);
            cVar.a(!this.d ? 1 : 0, this.D);
        }
        com.tencent.hlyyb.downloader.b.c cVar2 = (com.tencent.hlyyb.downloader.b.c) this.s.get(this.b);
        if (cVar2 == null || !cVar2.d || cVar2.e || !this.u.a(this.f619a, cVar2)) {
            z2 = false;
        } else {
            this.v = true;
            z2 = true;
        }
        if (z2) {
            return false;
        }
        if (this.g == null) {
            return true;
        }
        if (this.f619a.f + ((long) i) >= this.f619a.g) {
            i2 = (int) (this.f619a.g - this.f619a.f);
            z3 = false;
        } else {
            i2 = i;
        }
        return z3 & this.g.a(this, this.f619a.f, bArr, i2, z);
    }

    @Override // com.tencent.hlyyb.downloader.b.d
    public final com.tencent.hlyyb.downloader.e.d.a b() {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            synchronized (this.r) {
                java.util.Iterator it = this.r.iterator();
                while (it.hasNext()) {
                    arrayList.add(((com.tencent.hlyyb.downloader.b.c) it.next()).b);
                }
            }
            com.tencent.hlyyb.downloader.e.d.a aVarA = this.e.a(arrayList, this.w.get() >= this.B);
            if (b(aVarA)) {
                com.tencent.hlyyb.downloader.b.c cVar = new com.tencent.hlyyb.downloader.b.c((com.tencent.hlyyb.downloader.e.h) this.f, this.e, aVarA, this.r, this.s, this, this.A, this.x, this.w);
                synchronized (this.r) {
                    this.r.add(cVar);
                }
                this.s.put(aVarA, cVar);
                cVar.h = this.E;
                cVar.f606a = true;
                cVar.f = com.tencent.hlyyb.downloader.f.a.a().c(cVar);
            }
            return aVarA;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final int c() {
        return this.i;
    }

    public final java.lang.String d() {
        return this.j;
    }

    public final void e() {
        com.tencent.hlyyb.downloader.a.a.f fVar = this.m;
        if (fVar != null) {
            fVar.s();
        }
    }

    public final void f() {
        try {
            this.k = true;
            if (this.m != null) {
                this.m.s();
            }
            synchronized (this.n) {
                try {
                    this.n.notifyAll();
                } catch (java.lang.Throwable th) {
                    throw th;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final boolean g() {
        return this.l;
    }

    public final java.lang.String h() {
        com.tencent.hlyyb.downloader.e.c.c cVar = this.o;
        return cVar != null ? cVar.a() : "";
    }

    public final java.lang.String i() {
        com.tencent.hlyyb.downloader.e.c.c cVar = this.o;
        return cVar != null ? cVar.toString() : "";
    }

    public final java.lang.String j() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(!this.d ? 1 : 0);
        sb.append(sb2.toString());
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append(this.p);
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append(",");
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(this.i);
        sb.append(sb3.toString());
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append(";");
        return sb.toString();
    }

    public final int k() {
        return this.D;
    }

    public final java.lang.String l() {
        try {
            return this.m != null ? ((com.tencent.hlyyb.downloader.a.a.a) this.m).e() : "";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0179  */
    /* JADX WARN: Code duplicated, block: B:112:0x017c  */
    /* JADX WARN: Code duplicated, block: B:113:0x017f  */
    /* JADX WARN: Code duplicated, block: B:117:0x018e A[Catch: all -> 0x0174, TRY_ENTER, TryCatch #13 {all -> 0x0174, blocks: (B:105:0x016c, B:117:0x018e, B:119:0x0194, B:120:0x0199, B:122:0x01a3), top: B:386:0x016c }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0194 A[Catch: all -> 0x0174, TryCatch #13 {all -> 0x0174, blocks: (B:105:0x016c, B:117:0x018e, B:119:0x0194, B:120:0x0199, B:122:0x01a3), top: B:386:0x016c }] */
    /* JADX WARN: Code duplicated, block: B:120:0x0199 A[Catch: all -> 0x0174, TryCatch #13 {all -> 0x0174, blocks: (B:105:0x016c, B:117:0x018e, B:119:0x0194, B:120:0x0199, B:122:0x01a3), top: B:386:0x016c }] */
    /* JADX WARN: Code duplicated, block: B:122:0x01a3 A[Catch: all -> 0x0174, TRY_LEAVE, TryCatch #13 {all -> 0x0174, blocks: (B:105:0x016c, B:117:0x018e, B:119:0x0194, B:120:0x0199, B:122:0x01a3), top: B:386:0x016c }] */
    /* JADX WARN: Code duplicated, block: B:124:0x01a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:125:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:126:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:133:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:136:0x01e2 A[Catch: all -> 0x0610, TryCatch #10 {all -> 0x0610, blocks: (B:128:0x01cc, B:130:0x01d2, B:132:0x01d6, B:136:0x01e2, B:138:0x0217, B:140:0x021b, B:146:0x023a, B:149:0x0280, B:151:0x0293, B:153:0x029b, B:183:0x0372, B:191:0x038e, B:211:0x03d0, B:212:0x03d4, B:214:0x03da, B:215:0x03ec, B:220:0x03f9, B:222:0x03fd), top: B:380:0x01cc }] */
    /* JADX WARN: Code duplicated, block: B:142:0x0222  */
    /* JADX WARN: Code duplicated, block: B:146:0x023a A[Catch: all -> 0x0610, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x0610, blocks: (B:128:0x01cc, B:130:0x01d2, B:132:0x01d6, B:136:0x01e2, B:138:0x0217, B:140:0x021b, B:146:0x023a, B:149:0x0280, B:151:0x0293, B:153:0x029b, B:183:0x0372, B:191:0x038e, B:211:0x03d0, B:212:0x03d4, B:214:0x03da, B:215:0x03ec, B:220:0x03f9, B:222:0x03fd), top: B:380:0x01cc }] */
    /* JADX WARN: Code duplicated, block: B:179:0x035f A[PHI: r1 r11
  0x035f: PHI (r1v24 com.tencent.hlyyb.downloader.e.c.d) = 
  (r1v23 com.tencent.hlyyb.downloader.e.c.d)
  (r1v23 com.tencent.hlyyb.downloader.e.c.d)
  (r1v81 com.tencent.hlyyb.downloader.e.c.d)
 binds: [B:150:0x0291, B:152:0x0299, B:174:0x0355] A[DONT_GENERATE, DONT_INLINE]
  0x035f: PHI (r11v10 com.tencent.hlyyb.downloader.a.a.g) = 
  (r11v7 com.tencent.hlyyb.downloader.a.a.g)
  (r11v7 com.tencent.hlyyb.downloader.a.a.g)
  (r11v17 com.tencent.hlyyb.downloader.a.a.g)
 binds: [B:150:0x0291, B:152:0x0299, B:174:0x0355] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:183:0x0372 A[Catch: all -> 0x0610, TRY_ENTER, TryCatch #10 {all -> 0x0610, blocks: (B:128:0x01cc, B:130:0x01d2, B:132:0x01d6, B:136:0x01e2, B:138:0x0217, B:140:0x021b, B:146:0x023a, B:149:0x0280, B:151:0x0293, B:153:0x029b, B:183:0x0372, B:191:0x038e, B:211:0x03d0, B:212:0x03d4, B:214:0x03da, B:215:0x03ec, B:220:0x03f9, B:222:0x03fd), top: B:380:0x01cc }] */
    /* JADX WARN: Code duplicated, block: B:185:0x0378  */
    /* JADX WARN: Code duplicated, block: B:186:0x037b  */
    /* JADX WARN: Code duplicated, block: B:189:0x0381  */
    /* JADX WARN: Code duplicated, block: B:191:0x038e A[Catch: all -> 0x0610, TRY_LEAVE, TryCatch #10 {all -> 0x0610, blocks: (B:128:0x01cc, B:130:0x01d2, B:132:0x01d6, B:136:0x01e2, B:138:0x0217, B:140:0x021b, B:146:0x023a, B:149:0x0280, B:151:0x0293, B:153:0x029b, B:183:0x0372, B:191:0x038e, B:211:0x03d0, B:212:0x03d4, B:214:0x03da, B:215:0x03ec, B:220:0x03f9, B:222:0x03fd), top: B:380:0x01cc }] */
    /* JADX WARN: Code duplicated, block: B:193:0x0392 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:197:0x0399  */
    /* JADX WARN: Code duplicated, block: B:199:0x039c  */
    /* JADX WARN: Code duplicated, block: B:200:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:201:0x03b2 A[Catch: all -> 0x060b, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x060b, blocks: (B:180:0x0360, B:201:0x03b2, B:218:0x03f5, B:227:0x040c), top: B:374:0x0360 }] */
    /* JADX WARN: Code duplicated, block: B:205:0x03bb A[Catch: all -> 0x060e, TRY_ENTER, TryCatch #8 {all -> 0x060e, blocks: (B:148:0x027c, B:205:0x03bb, B:207:0x03c1, B:209:0x03c7), top: B:376:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:217:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:220:0x03f9 A[Catch: all -> 0x0610, TRY_ENTER, TryCatch #10 {all -> 0x0610, blocks: (B:128:0x01cc, B:130:0x01d2, B:132:0x01d6, B:136:0x01e2, B:138:0x0217, B:140:0x021b, B:146:0x023a, B:149:0x0280, B:151:0x0293, B:153:0x029b, B:183:0x0372, B:191:0x038e, B:211:0x03d0, B:212:0x03d4, B:214:0x03da, B:215:0x03ec, B:220:0x03f9, B:222:0x03fd), top: B:380:0x01cc }] */
    /* JADX WARN: Code duplicated, block: B:224:0x0404  */
    /* JADX WARN: Code duplicated, block: B:227:0x040c A[Catch: all -> 0x060b, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x060b, blocks: (B:180:0x0360, B:201:0x03b2, B:218:0x03f5, B:227:0x040c), top: B:374:0x0360 }] */
    /* JADX WARN: Code duplicated, block: B:233:0x044f A[Catch: all -> 0x0456, TRY_LEAVE, TryCatch #14 {all -> 0x0456, blocks: (B:231:0x044b, B:233:0x044f, B:244:0x046d, B:246:0x0471), top: B:388:0x044b }] */
    /* JADX WARN: Code duplicated, block: B:237:0x045b  */
    /* JADX WARN: Code duplicated, block: B:240:0x0461 A[Catch: all -> 0x0605, TRY_ENTER, TryCatch #3 {all -> 0x0605, blocks: (B:229:0x0443, B:240:0x0461, B:242:0x0469, B:251:0x047c), top: B:368:0x0443 }] */
    /* JADX WARN: Code duplicated, block: B:242:0x0469 A[Catch: all -> 0x0605, TRY_LEAVE, TryCatch #3 {all -> 0x0605, blocks: (B:229:0x0443, B:240:0x0461, B:242:0x0469, B:251:0x047c), top: B:368:0x0443 }] */
    /* JADX WARN: Code duplicated, block: B:244:0x046d A[Catch: all -> 0x0456, TRY_ENTER, TryCatch #14 {all -> 0x0456, blocks: (B:231:0x044b, B:233:0x044f, B:244:0x046d, B:246:0x0471), top: B:388:0x044b }] */
    /* JADX WARN: Code duplicated, block: B:248:0x0478  */
    /* JADX WARN: Code duplicated, block: B:251:0x047c A[Catch: all -> 0x0605, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0605, blocks: (B:229:0x0443, B:240:0x0461, B:242:0x0469, B:251:0x047c), top: B:368:0x0443 }] */
    /* JADX WARN: Code duplicated, block: B:255:0x04ac A[Catch: all -> 0x05e4, TryCatch #2 {all -> 0x05e4, blocks: (B:288:0x0556, B:291:0x0563, B:305:0x0580, B:306:0x0582, B:318:0x0599, B:320:0x059d, B:325:0x05bc, B:327:0x05c2, B:329:0x05ca, B:253:0x0484, B:255:0x04ac, B:257:0x04b8, B:258:0x04c8, B:260:0x04d4, B:261:0x04f3, B:263:0x04f7, B:265:0x050d, B:266:0x050f, B:268:0x0513, B:270:0x051d, B:276:0x0526, B:277:0x052c, B:281:0x053c, B:283:0x0541), top: B:367:0x0556 }] */
    /* JADX WARN: Code duplicated, block: B:257:0x04b8 A[Catch: all -> 0x05e4, TryCatch #2 {all -> 0x05e4, blocks: (B:288:0x0556, B:291:0x0563, B:305:0x0580, B:306:0x0582, B:318:0x0599, B:320:0x059d, B:325:0x05bc, B:327:0x05c2, B:329:0x05ca, B:253:0x0484, B:255:0x04ac, B:257:0x04b8, B:258:0x04c8, B:260:0x04d4, B:261:0x04f3, B:263:0x04f7, B:265:0x050d, B:266:0x050f, B:268:0x0513, B:270:0x051d, B:276:0x0526, B:277:0x052c, B:281:0x053c, B:283:0x0541), top: B:367:0x0556 }] */
    /* JADX WARN: Code duplicated, block: B:260:0x04d4 A[Catch: all -> 0x05e4, TryCatch #2 {all -> 0x05e4, blocks: (B:288:0x0556, B:291:0x0563, B:305:0x0580, B:306:0x0582, B:318:0x0599, B:320:0x059d, B:325:0x05bc, B:327:0x05c2, B:329:0x05ca, B:253:0x0484, B:255:0x04ac, B:257:0x04b8, B:258:0x04c8, B:260:0x04d4, B:261:0x04f3, B:263:0x04f7, B:265:0x050d, B:266:0x050f, B:268:0x0513, B:270:0x051d, B:276:0x0526, B:277:0x052c, B:281:0x053c, B:283:0x0541), top: B:367:0x0556 }] */
    /* JADX WARN: Code duplicated, block: B:263:0x04f7 A[Catch: all -> 0x05e4, TryCatch #2 {all -> 0x05e4, blocks: (B:288:0x0556, B:291:0x0563, B:305:0x0580, B:306:0x0582, B:318:0x0599, B:320:0x059d, B:325:0x05bc, B:327:0x05c2, B:329:0x05ca, B:253:0x0484, B:255:0x04ac, B:257:0x04b8, B:258:0x04c8, B:260:0x04d4, B:261:0x04f3, B:263:0x04f7, B:265:0x050d, B:266:0x050f, B:268:0x0513, B:270:0x051d, B:276:0x0526, B:277:0x052c, B:281:0x053c, B:283:0x0541), top: B:367:0x0556 }] */
    /* JADX WARN: Code duplicated, block: B:265:0x050d A[Catch: all -> 0x05e4, TryCatch #2 {all -> 0x05e4, blocks: (B:288:0x0556, B:291:0x0563, B:305:0x0580, B:306:0x0582, B:318:0x0599, B:320:0x059d, B:325:0x05bc, B:327:0x05c2, B:329:0x05ca, B:253:0x0484, B:255:0x04ac, B:257:0x04b8, B:258:0x04c8, B:260:0x04d4, B:261:0x04f3, B:263:0x04f7, B:265:0x050d, B:266:0x050f, B:268:0x0513, B:270:0x051d, B:276:0x0526, B:277:0x052c, B:281:0x053c, B:283:0x0541), top: B:367:0x0556 }] */
    /* JADX WARN: Code duplicated, block: B:268:0x0513 A[Catch: all -> 0x05e4, TryCatch #2 {all -> 0x05e4, blocks: (B:288:0x0556, B:291:0x0563, B:305:0x0580, B:306:0x0582, B:318:0x0599, B:320:0x059d, B:325:0x05bc, B:327:0x05c2, B:329:0x05ca, B:253:0x0484, B:255:0x04ac, B:257:0x04b8, B:258:0x04c8, B:260:0x04d4, B:261:0x04f3, B:263:0x04f7, B:265:0x050d, B:266:0x050f, B:268:0x0513, B:270:0x051d, B:276:0x0526, B:277:0x052c, B:281:0x053c, B:283:0x0541), top: B:367:0x0556 }] */
    /* JADX WARN: Code duplicated, block: B:273:0x0522  */
    /* JADX WARN: Code duplicated, block: B:274:0x0523  */
    /* JADX WARN: Code duplicated, block: B:279:0x0530  */
    /* JADX WARN: Code duplicated, block: B:280:0x0536  */
    /* JADX WARN: Code duplicated, block: B:281:0x053c A[Catch: all -> 0x05e4, TryCatch #2 {all -> 0x05e4, blocks: (B:288:0x0556, B:291:0x0563, B:305:0x0580, B:306:0x0582, B:318:0x0599, B:320:0x059d, B:325:0x05bc, B:327:0x05c2, B:329:0x05ca, B:253:0x0484, B:255:0x04ac, B:257:0x04b8, B:258:0x04c8, B:260:0x04d4, B:261:0x04f3, B:263:0x04f7, B:265:0x050d, B:266:0x050f, B:268:0x0513, B:270:0x051d, B:276:0x0526, B:277:0x052c, B:281:0x053c, B:283:0x0541), top: B:367:0x0556 }] */
    /* JADX WARN: Code duplicated, block: B:283:0x0541 A[Catch: all -> 0x05e4, TryCatch #2 {all -> 0x05e4, blocks: (B:288:0x0556, B:291:0x0563, B:305:0x0580, B:306:0x0582, B:318:0x0599, B:320:0x059d, B:325:0x05bc, B:327:0x05c2, B:329:0x05ca, B:253:0x0484, B:255:0x04ac, B:257:0x04b8, B:258:0x04c8, B:260:0x04d4, B:261:0x04f3, B:263:0x04f7, B:265:0x050d, B:266:0x050f, B:268:0x0513, B:270:0x051d, B:276:0x0526, B:277:0x052c, B:281:0x053c, B:283:0x0541), top: B:367:0x0556 }] */
    /* JADX WARN: Code duplicated, block: B:285:0x054f  */
    /* JADX WARN: Code duplicated, block: B:291:0x0563 A[Catch: all -> 0x05e4, TryCatch #2 {all -> 0x05e4, blocks: (B:288:0x0556, B:291:0x0563, B:305:0x0580, B:306:0x0582, B:318:0x0599, B:320:0x059d, B:325:0x05bc, B:327:0x05c2, B:329:0x05ca, B:253:0x0484, B:255:0x04ac, B:257:0x04b8, B:258:0x04c8, B:260:0x04d4, B:261:0x04f3, B:263:0x04f7, B:265:0x050d, B:266:0x050f, B:268:0x0513, B:270:0x051d, B:276:0x0526, B:277:0x052c, B:281:0x053c, B:283:0x0541), top: B:367:0x0556 }] */
    /* JADX WARN: Code duplicated, block: B:293:0x0569  */
    /* JADX WARN: Code duplicated, block: B:295:0x056d  */
    /* JADX WARN: Code duplicated, block: B:299:0x0574  */
    /* JADX WARN: Code duplicated, block: B:302:0x0579  */
    /* JADX WARN: Code duplicated, block: B:305:0x0580 A[Catch: all -> 0x05e4, TryCatch #2 {all -> 0x05e4, blocks: (B:288:0x0556, B:291:0x0563, B:305:0x0580, B:306:0x0582, B:318:0x0599, B:320:0x059d, B:325:0x05bc, B:327:0x05c2, B:329:0x05ca, B:253:0x0484, B:255:0x04ac, B:257:0x04b8, B:258:0x04c8, B:260:0x04d4, B:261:0x04f3, B:263:0x04f7, B:265:0x050d, B:266:0x050f, B:268:0x0513, B:270:0x051d, B:276:0x0526, B:277:0x052c, B:281:0x053c, B:283:0x0541), top: B:367:0x0556 }] */
    /* JADX WARN: Code duplicated, block: B:307:0x0585  */
    /* JADX WARN: Code duplicated, block: B:308:0x0587  */
    /* JADX WARN: Code duplicated, block: B:312:0x058f A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:315:0x0594  */
    /* JADX WARN: Code duplicated, block: B:320:0x059d A[Catch: all -> 0x05e4, TRY_LEAVE, TryCatch #2 {all -> 0x05e4, blocks: (B:288:0x0556, B:291:0x0563, B:305:0x0580, B:306:0x0582, B:318:0x0599, B:320:0x059d, B:325:0x05bc, B:327:0x05c2, B:329:0x05ca, B:253:0x0484, B:255:0x04ac, B:257:0x04b8, B:258:0x04c8, B:260:0x04d4, B:261:0x04f3, B:263:0x04f7, B:265:0x050d, B:266:0x050f, B:268:0x0513, B:270:0x051d, B:276:0x0526, B:277:0x052c, B:281:0x053c, B:283:0x0541), top: B:367:0x0556 }] */
    /* JADX WARN: Code duplicated, block: B:327:0x05c2 A[Catch: all -> 0x05e4, TryCatch #2 {all -> 0x05e4, blocks: (B:288:0x0556, B:291:0x0563, B:305:0x0580, B:306:0x0582, B:318:0x0599, B:320:0x059d, B:325:0x05bc, B:327:0x05c2, B:329:0x05ca, B:253:0x0484, B:255:0x04ac, B:257:0x04b8, B:258:0x04c8, B:260:0x04d4, B:261:0x04f3, B:263:0x04f7, B:265:0x050d, B:266:0x050f, B:268:0x0513, B:270:0x051d, B:276:0x0526, B:277:0x052c, B:281:0x053c, B:283:0x0541), top: B:367:0x0556 }] */
    /* JADX WARN: Code duplicated, block: B:350:0x0639  */
    /* JADX WARN: Code duplicated, block: B:367:0x0556 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:388:0x044b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:404:0x01e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:405:0x01e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:408:0x0407 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:409:0x045e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:410:0x045e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:411:0x0526 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:412:0x0562 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:260:0x04d4, please report this as an issue */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        boolean z3;
        com.tencent.hlyyb.downloader.a.a.g gVar;
        boolean z4;
        int i;
        com.tencent.hlyyb.downloader.e.b.a aVar;
        boolean zA;
        long j;
        long j2;
        com.tencent.hlyyb.downloader.a.a.b bVar;
        int i2;
        boolean zA2;
        com.tencent.hlyyb.downloader.e.c.d dVar;
        long jElapsedRealtime;
        boolean zA3;
        com.tencent.hlyyb.downloader.e.c.d dVar2;
        long jElapsedRealtime2;
        boolean zA4;
        com.tencent.hlyyb.downloader.a.a.g gVar2;
        com.tencent.hlyyb.common.f.b bVarA;
        boolean zA5;
        boolean z5;
        boolean z6;
        boolean zA6;
        int i3;
        com.tencent.hlyyb.downloader.e.d.c cVar;
        int iG;
        int i4;
        java.util.List listSynchronizedList;
        java.util.List listN;
        com.tencent.hlyyb.downloader.a.a.g gVar3;
        long jElapsedRealtime3;
        int i5;
        int i6;
        boolean z7;
        int i7;
        boolean z8;
        int i8;
        boolean z9;
        long j3;
        com.tencent.hlyyb.downloader.a.b bVar2;
        com.tencent.hlyyb.downloader.a.b bVar3;
        com.tencent.hlyyb.downloader.a.b bVar4;
        this.o.b = java.lang.System.currentTimeMillis();
        long jElapsedRealtime4 = android.os.SystemClock.elapsedRealtime();
        long j4 = 0;
        boolean z10 = false;
        boolean z11 = true;
        long jElapsedRealtime5 = 0;
        boolean z12 = true;
        boolean z13 = false;
        int i9 = 0;
        while (true) {
            try {
                if (!((this.k || (bVar4 = this.f) == null) ? true : bVar4.a())) {
                    try {
                        if (com.tencent.hlyyb.common.a.e.a("down_use_halley_schedule", z10 ? 1 : 0, z11 ? 1 : 0, z11 ? 1 : 0) == z11 && !this.d) {
                            this.e.b(com.tencent.hlyyb.common.a.e.a("down_res_sche_timeout", 1000, com.youme.im.CommonConst.SPEECH_DURATION_MAX, 15000));
                            try {
                                if (this.q && this.z && !this.C) {
                                    this.u.a(this.e.a());
                                    this.C = z11;
                                }
                            } catch (java.lang.Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                    if (!((this.k || (bVar3 = this.f) == null) ? true : bVar3.a()) && (this.d || this.q)) {
                        if (i9 > 0) {
                            synchronized (this.n) {
                                try {
                                    this.n.wait(i9);
                                } catch (java.lang.InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (!((this.k || (bVar2 = this.f) == null) ? true : bVar2.a())) {
                            if (jElapsedRealtime5 == j4) {
                                jElapsedRealtime5 = android.os.SystemClock.elapsedRealtime();
                            }
                            jElapsedRealtime5 = jElapsedRealtime5;
                            if (this.v) {
                                this.v = z10;
                                z2 = true;
                                z12 = true;
                            } else {
                                z2 = false;
                            }
                            if (z12) {
                                int i10 = this.i;
                                this.b = this.e.a(com.tencent.hlyyb.common.a.f.b(), this.b, this.d, false, z2, i10 == 404 || i10 == -10 || i10 == -11 || this.w.get() >= this.B);
                                if (com.tencent.hlyyb.common.a.e.a("down_use_https", z10 ? 1 : 0, z11 ? 1 : 0, z11 ? 1 : 0) != z11 && this.b.b == com.tencent.hlyyb.downloader.e.d.b.j) {
                                    com.tencent.hlyyb.downloader.e.d.a aVarA = this.e.a(com.tencent.hlyyb.common.a.f.b(), this.b, this.d, true, z2, false);
                                    this.b = aVarA;
                                }
                                this.l = z;
                                this.o.c = java.lang.System.currentTimeMillis() - this.o.b;
                                this.g.c(this);
                                return;
                            }
                            int i11 = this.b.b;
                            if ((i11 == com.tencent.hlyyb.downloader.e.d.b.b || i11 == com.tencent.hlyyb.downloader.e.d.b.f627a || i11 == com.tencent.hlyyb.downloader.e.d.b.g) && (aVarA = this.e.a(this.b.b)) != null) {
                                this.b = aVarA;
                            }
                            com.tencent.hlyyb.downloader.e.d.a aVar2 = this.b;
                            aVar2.f = z11;
                            com.tencent.hlyyb.downloader.b.c cVar2 = (com.tencent.hlyyb.downloader.b.c) this.s.get(aVar2);
                            if (cVar2 == null || !cVar2.c || this.e.f() <= 0 || cVar2.e) {
                                com.tencent.hlyyb.downloader.e.b.a aVarA2 = this.g.a(this);
                                this.f619a = aVarA2;
                                if (aVarA2 != null) {
                                    if (z13) {
                                        try {
                                            if (com.tencent.hlyyb.common.a.f.j()) {
                                                z4 = z13;
                                            } else {
                                                z4 = false;
                                            }
                                            if (z4) {
                                                i = 524288;
                                            } else {
                                                i = -1;
                                            }
                                            try {
                                                aVar = this.f619a;
                                                zA = this.g.a();
                                                j = aVar.g;
                                                if (i <= 0) {
                                                    j2 = j;
                                                } else if (aVar.g == -1) {
                                                    j2 = aVar.f + ((long) i);
                                                } else {
                                                    j3 = i;
                                                    if (j3 < aVar.g - aVar.f) {
                                                        j2 = aVar.f + j3;
                                                    } else if (zA) {
                                                        j2 = j;
                                                    } else {
                                                        j2 = -1;
                                                    }
                                                }
                                                bVar = new com.tencent.hlyyb.downloader.a.a.b(aVar.f, j2);
                                                i2 = 1000;
                                                gVar = new com.tencent.hlyyb.downloader.a.a.g(this.b, this.h, bVar, z4, this, this.b.d, this.e, 1);
                                                try {
                                                    this.m = gVar;
                                                    if (!this.k || this.f == null) {
                                                        zA2 = true;
                                                    } else {
                                                        zA2 = this.f.a();
                                                    }
                                                    if (zA2) {
                                                        com.tencent.hlyyb.downloader.e.c.c cVar3 = this.o;
                                                        int i12 = cVar3.d;
                                                        cVar3.d = i12 + 1;
                                                        this.D = i12;
                                                        dVar = new com.tencent.hlyyb.downloader.e.c.d(this.D, this.b);
                                                        dVar.c = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime4;
                                                        dVar.f624a = z4;
                                                        dVar.b = this.f619a.toString();
                                                        dVar.f = bVar.toString();
                                                        jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                                                        gVar.p();
                                                        if (!this.k || this.f == null) {
                                                            zA3 = true;
                                                        } else {
                                                            zA3 = this.f.a();
                                                        }
                                                        if (zA3) {
                                                            this.i = gVar.a();
                                                            this.j = gVar.b();
                                                            dVar.e = this.i;
                                                            dVar.d = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime4;
                                                            dVar.g = gVar.g();
                                                            dVar.i = gVar.i();
                                                            dVar.j = gVar.j();
                                                            dVar.h = gVar.c();
                                                            dVar.k = gVar.h();
                                                            dVar.l = gVar.k();
                                                            dVar.m = gVar.l();
                                                            z3 = false;
                                                            try {
                                                                dVar.r = gVar.a(false);
                                                                dVar.s = gVar.f();
                                                                this.o.a(dVar);
                                                                if (this.i == -53 || this.g.a()) {
                                                                    dVar2 = dVar;
                                                                    try {
                                                                        jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime;
                                                                        if (this.i != 0) {
                                                                            if (this.i == -59) {
                                                                                z12 = false;
                                                                                z6 = true;
                                                                            } else {
                                                                                z6 = z4;
                                                                                z12 = true;
                                                                            }
                                                                            if (jElapsedRealtime2 > 10000) {
                                                                                z3 = false;
                                                                                z5 = true;
                                                                                z = true;
                                                                                i2 = 0;
                                                                            } else {
                                                                                i8 = this.i;
                                                                                if (i8 != -16 || i8 == -15 || i8 == -77) {
                                                                                    z9 = true;
                                                                                } else {
                                                                                    z9 = false;
                                                                                }
                                                                                if (z9) {
                                                                                    z3 = false;
                                                                                    z5 = true;
                                                                                    z = true;
                                                                                    i2 = 3000;
                                                                                } else {
                                                                                    z3 = false;
                                                                                    z5 = true;
                                                                                    z = true;
                                                                                }
                                                                            }
                                                                            gVar2 = gVar;
                                                                        } else {
                                                                            z3 = false;
                                                                            try {
                                                                                if (!this.e.a(false) && (listN = gVar.n()) != null && listN.size() > 0) {
                                                                                    if (com.tencent.hlyyb.common.a.e.a("down_use_jump_schedule", 0, 1, 1) == 1) {
                                                                                        java.util.Iterator it = listN.iterator();
                                                                                        while (it.hasNext()) {
                                                                                            this.e.a(com.tencent.hlyyb.common.a.f.b(), (java.lang.String) it.next(), com.tencent.hlyyb.downloader.e.d.b.e);
                                                                                        }
                                                                                    }
                                                                                    this.e.b(false);
                                                                                }
                                                                                if (!this.k || this.f == null) {
                                                                                    zA4 = true;
                                                                                } else {
                                                                                    zA4 = this.f.a();
                                                                                }
                                                                                if (zA4) {
                                                                                    gVar2 = gVar;
                                                                                    z3 = false;
                                                                                    z = true;
                                                                                } else {
                                                                                    jElapsedRealtime4 = jElapsedRealtime4;
                                                                                    z = true;
                                                                                    gVar2 = gVar;
                                                                                    try {
                                                                                        bVarA = this.g.a(this, this.b, gVar.e(), gVar.c(), gVar.o(), gVar.k(), gVar.l(), gVar.h(), gVar.m());
                                                                                        if (!this.k) {
                                                                                            zA5 = true;
                                                                                        } else {
                                                                                            try {
                                                                                                if (this.f != null) {
                                                                                                    zA5 = this.f.a();
                                                                                                } else {
                                                                                                    zA5 = true;
                                                                                                }
                                                                                            } catch (java.lang.Throwable th2) {
                                                                                                th = th2;
                                                                                                gVar = gVar2;
                                                                                                z3 = false;
                                                                                                try {
                                                                                                    th.printStackTrace();
                                                                                                    this.i = -61;
                                                                                                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                                                                                    sb.append(th);
                                                                                                    this.j = sb.toString();
                                                                                                    this.c = z3;
                                                                                                    this.g.b(this);
                                                                                                    this.m = null;
                                                                                                    if (gVar != null) {
                                                                                                        this.p = gVar.d();
                                                                                                        gVar.r();
                                                                                                    }
                                                                                                } catch (java.lang.Throwable th3) {
                                                                                                    this.c = z3;
                                                                                                    this.g.b(this);
                                                                                                    this.m = null;
                                                                                                    if (gVar != null) {
                                                                                                        this.p = gVar.d();
                                                                                                        gVar.r();
                                                                                                    }
                                                                                                    throw th3;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (zA5) {
                                                                                            dVar2.n = bVarA.f595a;
                                                                                            if (bVarA.f595a == 0) {
                                                                                                if (!this.k || this.f == null) {
                                                                                                    zA6 = true;
                                                                                                } else {
                                                                                                    zA6 = this.f.a();
                                                                                                }
                                                                                                if (zA6) {
                                                                                                    this.c = true;
                                                                                                    gVar2.a(this);
                                                                                                    com.tencent.hlyyb.downloader.e.d.a aVar3 = this.b;
                                                                                                    z3 = false;
                                                                                                    this.c = false;
                                                                                                    aVar3.f = false;
                                                                                                    this.i = gVar2.a();
                                                                                                    this.j = gVar2.b();
                                                                                                    dVar2.o = this.i;
                                                                                                    dVar2.p = this.f619a.toString();
                                                                                                    dVar2.q = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime4;
                                                                                                    if (!this.v) {
                                                                                                        listSynchronizedList = (java.util.List) this.t.get(this.b);
                                                                                                        if (listSynchronizedList == null) {
                                                                                                            listSynchronizedList = java.util.Collections.synchronizedList(new java.util.ArrayList());
                                                                                                            this.t.put(this.b, listSynchronizedList);
                                                                                                        }
                                                                                                        if (this.f619a.f > this.f619a.d) {
                                                                                                            listSynchronizedList.add(this.f619a.d + "," + this.f619a.f);
                                                                                                        }
                                                                                                    }
                                                                                                    if (this.A) {
                                                                                                        i3 = this.w.get();
                                                                                                        cVar = this.e;
                                                                                                        iG = cVar.g();
                                                                                                        if (!android.text.TextUtils.isEmpty(cVar.f628a.e)) {
                                                                                                            iG--;
                                                                                                        }
                                                                                                        if (cVar.b != null && !android.text.TextUtils.isEmpty(cVar.b.e)) {
                                                                                                            iG--;
                                                                                                        }
                                                                                                        i4 = iG;
                                                                                                        if (i4 > 0) {
                                                                                                            i4 = 1;
                                                                                                        }
                                                                                                        if (i3 >= i4) {
                                                                                                            this.i = -75;
                                                                                                        }
                                                                                                    }
                                                                                                    if (this.i != 0) {
                                                                                                        z5 = false;
                                                                                                        i2 = 0;
                                                                                                        jElapsedRealtime5 = 0;
                                                                                                        z6 = z4;
                                                                                                        jElapsedRealtime5 = jElapsedRealtime5;
                                                                                                        z12 = true;
                                                                                                    } else {
                                                                                                        z5 = false;
                                                                                                        i2 = 0;
                                                                                                        jElapsedRealtime5 = 0;
                                                                                                        z6 = z4;
                                                                                                        jElapsedRealtime5 = jElapsedRealtime5;
                                                                                                        z12 = false;
                                                                                                    }
                                                                                                }
                                                                                                gVar = gVar2;
                                                                                                th.printStackTrace();
                                                                                                this.i = -61;
                                                                                                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                                                                                sb2.append(th);
                                                                                                this.j = sb2.toString();
                                                                                                this.c = z3;
                                                                                                this.g.b(this);
                                                                                                this.m = null;
                                                                                                if (gVar != null) {
                                                                                                    this.p = gVar.d();
                                                                                                    gVar.r();
                                                                                                }
                                                                                            } else {
                                                                                                z3 = false;
                                                                                                if (bVarA.f595a < 0) {
                                                                                                    this.i = bVarA.f595a;
                                                                                                    this.j = bVarA.b;
                                                                                                    z5 = true;
                                                                                                    z6 = z4;
                                                                                                    jElapsedRealtime5 = jElapsedRealtime5;
                                                                                                    z12 = true;
                                                                                                } else {
                                                                                                    z5 = true;
                                                                                                    z6 = z4;
                                                                                                    jElapsedRealtime5 = jElapsedRealtime5;
                                                                                                    z12 = false;
                                                                                                }
                                                                                            }
                                                                                            this.c = z3;
                                                                                            this.g.b(this);
                                                                                            this.m = null;
                                                                                            this.p = gVar2.d();
                                                                                            gVar2.r();
                                                                                        }
                                                                                        z3 = false;
                                                                                    } catch (java.lang.Throwable th4) {
                                                                                        th = th4;
                                                                                        z3 = false;
                                                                                    }
                                                                                }
                                                                                gVar3 = gVar2;
                                                                                this.c = z3;
                                                                                this.g.b(this);
                                                                                this.m = null;
                                                                                this.p = gVar3.d();
                                                                                gVar3.r();
                                                                            } catch (java.lang.Throwable th5) {
                                                                                th = th5;
                                                                                z = true;
                                                                            }
                                                                        }
                                                                        if (z5) {
                                                                            try {
                                                                                jElapsedRealtime3 = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime5;
                                                                                if (jElapsedRealtime3 <= 60000) {
                                                                                    i5 = this.i;
                                                                                    if (i5 != -16) {
                                                                                        i6 = -15;
                                                                                        if (i5 == -15 && i5 != -77) {
                                                                                            z7 = false;
                                                                                        }
                                                                                        if (z7 || jElapsedRealtime3 <= 20000) {
                                                                                            i7 = this.i;
                                                                                            switch (i7) {
                                                                                                default:
                                                                                                    if (i7 > 0 || i7 == 200 || i7 == 206) {
                                                                                                        z8 = false;
                                                                                                        break;
                                                                                                    }
                                                                                                case -76:
                                                                                                case -73:
                                                                                                case -71:
                                                                                                case -68:
                                                                                                case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                                                case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                                                case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                                                case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                                                case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                                                case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                                                case -11:
                                                                                                case -10:
                                                                                                    z8 = true;
                                                                                                    break;
                                                                                            }
                                                                                            if (z8 || jElapsedRealtime3 <= 10000) {
                                                                                                if (this.i == i6 || jElapsedRealtime3 <= com.tencent.hlyyb.downloader.a.a.f()) {
                                                                                                    if (this.i == -51 && this.b.b == com.tencent.hlyyb.downloader.e.d.b.b) {
                                                                                                        android.os.SystemClock.sleep(1000L);
                                                                                                        this.c = z3;
                                                                                                        this.g.b(this);
                                                                                                        this.m = null;
                                                                                                        this.p = gVar2.d();
                                                                                                        gVar2.r();
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        gVar3 = gVar2;
                                                                                        this.c = z3;
                                                                                        this.g.b(this);
                                                                                        this.m = null;
                                                                                        this.p = gVar3.d();
                                                                                        gVar3.r();
                                                                                    } else {
                                                                                        i6 = -15;
                                                                                    }
                                                                                    z7 = true;
                                                                                    if (z7) {
                                                                                        i7 = this.i;
                                                                                        switch (i7) {
                                                                                            default:
                                                                                                if (i7 > 0) {
                                                                                                    break;
                                                                                                }
                                                                                                z8 = false;
                                                                                            case -76:
                                                                                            case -73:
                                                                                            case -71:
                                                                                            case -68:
                                                                                            case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                                            case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                                            case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                                            case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                                            case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                                            case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                                            case -11:
                                                                                            case -10:
                                                                                                z8 = true;
                                                                                                break;
                                                                                        }
                                                                                        if (z8) {
                                                                                        }
                                                                                        if (this.i == i6) {
                                                                                        }
                                                                                        if (this.i == -51) {
                                                                                            android.os.SystemClock.sleep(1000L);
                                                                                            this.c = z3;
                                                                                            this.g.b(this);
                                                                                            this.m = null;
                                                                                            this.p = gVar2.d();
                                                                                            gVar2.r();
                                                                                        }
                                                                                    } else {
                                                                                        i7 = this.i;
                                                                                        switch (i7) {
                                                                                            default:
                                                                                                if (i7 > 0) {
                                                                                                    break;
                                                                                                }
                                                                                                z8 = false;
                                                                                            case -76:
                                                                                            case -73:
                                                                                            case -71:
                                                                                            case -68:
                                                                                            case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                                            case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                                            case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                                            case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                                            case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                                            case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                                            case -11:
                                                                                            case -10:
                                                                                                z8 = true;
                                                                                                break;
                                                                                        }
                                                                                        if (z8) {
                                                                                        }
                                                                                        if (this.i == i6) {
                                                                                        }
                                                                                        if (this.i == -51) {
                                                                                            android.os.SystemClock.sleep(1000L);
                                                                                            this.c = z3;
                                                                                            this.g.b(this);
                                                                                            this.m = null;
                                                                                            this.p = gVar2.d();
                                                                                            gVar2.r();
                                                                                        }
                                                                                    }
                                                                                }
                                                                                gVar3 = gVar2;
                                                                                this.c = z3;
                                                                                this.g.b(this);
                                                                                this.m = null;
                                                                                this.p = gVar3.d();
                                                                                gVar3.r();
                                                                            } catch (java.lang.Throwable th6) {
                                                                                th = th6;
                                                                                gVar = gVar2;
                                                                                th.printStackTrace();
                                                                                this.i = -61;
                                                                                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                                                                                sb3.append(th);
                                                                                this.j = sb3.toString();
                                                                                this.c = z3;
                                                                                this.g.b(this);
                                                                                this.m = null;
                                                                                if (gVar != null) {
                                                                                    this.p = gVar.d();
                                                                                    gVar.r();
                                                                                }
                                                                            }
                                                                        }
                                                                        this.c = z3;
                                                                        this.g.b(this);
                                                                        this.m = null;
                                                                        this.p = gVar2.d();
                                                                        gVar2.r();
                                                                        z13 = z6;
                                                                        i9 = i2;
                                                                        jElapsedRealtime4 = jElapsedRealtime4;
                                                                        z11 = true;
                                                                        z10 = false;
                                                                        j4 = 0;
                                                                    } catch (java.lang.Throwable th7) {
                                                                        th = th7;
                                                                        z3 = false;
                                                                        z = true;
                                                                        th.printStackTrace();
                                                                        this.i = -61;
                                                                        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                                                                        sb4.append(th);
                                                                        this.j = sb4.toString();
                                                                        this.c = z3;
                                                                        this.g.b(this);
                                                                        this.m = null;
                                                                        if (gVar != null) {
                                                                            this.p = gVar.d();
                                                                            gVar.r();
                                                                        }
                                                                        this.l = z;
                                                                        this.o.c = java.lang.System.currentTimeMillis() - this.o.b;
                                                                        this.g.c(this);
                                                                        return;
                                                                    }
                                                                } else {
                                                                    gVar3 = new com.tencent.hlyyb.downloader.a.a.g(this.b, this.h, null, z4, this, this.b.d, this.e, 1);
                                                                    try {
                                                                        this.m = gVar3;
                                                                        if (!((this.k || this.f == null) ? true : this.f.a())) {
                                                                            com.tencent.hlyyb.downloader.e.c.c cVar4 = this.o;
                                                                            int i13 = cVar4.d;
                                                                            cVar4.d = i13 + 1;
                                                                            this.D = i13;
                                                                            dVar = new com.tencent.hlyyb.downloader.e.c.d(this.D, this.b);
                                                                            dVar.c = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime4;
                                                                            dVar.f624a = z4;
                                                                            dVar.b = this.f619a.toString();
                                                                            dVar.f = "";
                                                                            gVar3.p();
                                                                            if (!((this.k || this.f == null) ? true : this.f.a())) {
                                                                                this.i = gVar3.a();
                                                                                this.j = gVar3.b();
                                                                                dVar.d = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime4;
                                                                                dVar.g = gVar3.g();
                                                                                dVar.i = gVar3.i();
                                                                                dVar.j = gVar3.j();
                                                                                dVar.h = gVar3.c();
                                                                                dVar.k = gVar3.h();
                                                                                dVar.l = gVar3.k();
                                                                                dVar.m = gVar3.l();
                                                                                z3 = false;
                                                                                try {
                                                                                    dVar.r = gVar3.a(false);
                                                                                    dVar.s = gVar3.f();
                                                                                    this.o.a(dVar);
                                                                                    gVar = gVar3;
                                                                                    dVar2 = dVar;
                                                                                    jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime;
                                                                                    if (this.i != 0) {
                                                                                        if (this.i == -59) {
                                                                                            z12 = false;
                                                                                            z6 = true;
                                                                                        } else {
                                                                                            z6 = z4;
                                                                                            z12 = true;
                                                                                        }
                                                                                        if (jElapsedRealtime2 > 10000) {
                                                                                            z3 = false;
                                                                                            z5 = true;
                                                                                            z = true;
                                                                                            i2 = 0;
                                                                                        } else {
                                                                                            i8 = this.i;
                                                                                            if (i8 != -16) {
                                                                                                z9 = true;
                                                                                            } else {
                                                                                                z9 = true;
                                                                                            }
                                                                                            if (z9) {
                                                                                                z3 = false;
                                                                                                z5 = true;
                                                                                                z = true;
                                                                                                i2 = 3000;
                                                                                            } else {
                                                                                                z3 = false;
                                                                                                z5 = true;
                                                                                                z = true;
                                                                                            }
                                                                                        }
                                                                                        gVar2 = gVar;
                                                                                    } else {
                                                                                        z3 = false;
                                                                                        if (!this.e.a(false)) {
                                                                                        }
                                                                                        if (this.k) {
                                                                                            zA4 = true;
                                                                                        } else {
                                                                                            zA4 = true;
                                                                                        }
                                                                                        if (zA4) {
                                                                                            gVar2 = gVar;
                                                                                            z3 = false;
                                                                                            z = true;
                                                                                        } else {
                                                                                            jElapsedRealtime4 = jElapsedRealtime4;
                                                                                            z = true;
                                                                                            gVar2 = gVar;
                                                                                            bVarA = this.g.a(this, this.b, gVar.e(), gVar.c(), gVar.o(), gVar.k(), gVar.l(), gVar.h(), gVar.m());
                                                                                            if (!this.k) {
                                                                                                zA5 = true;
                                                                                            } else if (this.f != null) {
                                                                                                zA5 = this.f.a();
                                                                                            } else {
                                                                                                zA5 = true;
                                                                                            }
                                                                                            if (zA5) {
                                                                                                dVar2.n = bVarA.f595a;
                                                                                                if (bVarA.f595a == 0) {
                                                                                                    if (this.k) {
                                                                                                        zA6 = true;
                                                                                                    } else {
                                                                                                        zA6 = true;
                                                                                                    }
                                                                                                    if (zA6) {
                                                                                                        this.c = true;
                                                                                                        gVar2.a(this);
                                                                                                        com.tencent.hlyyb.downloader.e.d.a aVar4 = this.b;
                                                                                                        z3 = false;
                                                                                                        this.c = false;
                                                                                                        aVar4.f = false;
                                                                                                        this.i = gVar2.a();
                                                                                                        this.j = gVar2.b();
                                                                                                        dVar2.o = this.i;
                                                                                                        dVar2.p = this.f619a.toString();
                                                                                                        dVar2.q = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime4;
                                                                                                        if (!this.v) {
                                                                                                            listSynchronizedList = (java.util.List) this.t.get(this.b);
                                                                                                            if (listSynchronizedList == null) {
                                                                                                                listSynchronizedList = java.util.Collections.synchronizedList(new java.util.ArrayList());
                                                                                                                this.t.put(this.b, listSynchronizedList);
                                                                                                            }
                                                                                                            if (this.f619a.f > this.f619a.d) {
                                                                                                                listSynchronizedList.add(this.f619a.d + "," + this.f619a.f);
                                                                                                            }
                                                                                                        }
                                                                                                        if (this.A) {
                                                                                                            i3 = this.w.get();
                                                                                                            cVar = this.e;
                                                                                                            iG = cVar.g();
                                                                                                            if (!android.text.TextUtils.isEmpty(cVar.f628a.e)) {
                                                                                                                iG--;
                                                                                                            }
                                                                                                            if (cVar.b != null) {
                                                                                                                iG--;
                                                                                                            }
                                                                                                            i4 = iG;
                                                                                                            if (i4 > 0) {
                                                                                                                i4 = 1;
                                                                                                            }
                                                                                                            if (i3 >= i4) {
                                                                                                                this.i = -75;
                                                                                                            }
                                                                                                        }
                                                                                                        if (this.i != 0) {
                                                                                                            z5 = false;
                                                                                                            i2 = 0;
                                                                                                            jElapsedRealtime5 = 0;
                                                                                                            z6 = z4;
                                                                                                            jElapsedRealtime5 = jElapsedRealtime5;
                                                                                                            z12 = true;
                                                                                                        } else {
                                                                                                            z5 = false;
                                                                                                            i2 = 0;
                                                                                                            jElapsedRealtime5 = 0;
                                                                                                            z6 = z4;
                                                                                                            jElapsedRealtime5 = jElapsedRealtime5;
                                                                                                            z12 = false;
                                                                                                        }
                                                                                                    }
                                                                                                    gVar = gVar2;
                                                                                                    th.printStackTrace();
                                                                                                    this.i = -61;
                                                                                                    java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                                                                                                    sb5.append(th);
                                                                                                    this.j = sb5.toString();
                                                                                                    this.c = z3;
                                                                                                    this.g.b(this);
                                                                                                    this.m = null;
                                                                                                    if (gVar != null) {
                                                                                                        this.p = gVar.d();
                                                                                                        gVar.r();
                                                                                                    }
                                                                                                } else {
                                                                                                    z3 = false;
                                                                                                    if (bVarA.f595a < 0) {
                                                                                                        this.i = bVarA.f595a;
                                                                                                        this.j = bVarA.b;
                                                                                                        z5 = true;
                                                                                                        z6 = z4;
                                                                                                        jElapsedRealtime5 = jElapsedRealtime5;
                                                                                                        z12 = true;
                                                                                                    } else {
                                                                                                        z5 = true;
                                                                                                        z6 = z4;
                                                                                                        jElapsedRealtime5 = jElapsedRealtime5;
                                                                                                        z12 = false;
                                                                                                    }
                                                                                                }
                                                                                                this.c = z3;
                                                                                                this.g.b(this);
                                                                                                this.m = null;
                                                                                                this.p = gVar2.d();
                                                                                                gVar2.r();
                                                                                            }
                                                                                            z3 = false;
                                                                                        }
                                                                                        gVar3 = gVar2;
                                                                                        this.c = z3;
                                                                                        this.g.b(this);
                                                                                        this.m = null;
                                                                                        this.p = gVar3.d();
                                                                                        gVar3.r();
                                                                                    }
                                                                                    if (z5) {
                                                                                        jElapsedRealtime3 = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime5;
                                                                                        if (jElapsedRealtime3 <= 60000) {
                                                                                            i5 = this.i;
                                                                                            if (i5 != -16) {
                                                                                                i6 = -15;
                                                                                                if (i5 == -15) {
                                                                                                }
                                                                                                if (z7) {
                                                                                                    i7 = this.i;
                                                                                                    switch (i7) {
                                                                                                        default:
                                                                                                            if (i7 > 0) {
                                                                                                                break;
                                                                                                            }
                                                                                                            z8 = false;
                                                                                                        case -76:
                                                                                                        case -73:
                                                                                                        case -71:
                                                                                                        case -68:
                                                                                                        case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                                                        case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                                                        case -11:
                                                                                                        case -10:
                                                                                                            z8 = true;
                                                                                                            break;
                                                                                                    }
                                                                                                    if (z8) {
                                                                                                    }
                                                                                                    if (this.i == i6) {
                                                                                                    }
                                                                                                    if (this.i == -51) {
                                                                                                        android.os.SystemClock.sleep(1000L);
                                                                                                        this.c = z3;
                                                                                                        this.g.b(this);
                                                                                                        this.m = null;
                                                                                                        this.p = gVar2.d();
                                                                                                        gVar2.r();
                                                                                                    }
                                                                                                } else {
                                                                                                    i7 = this.i;
                                                                                                    switch (i7) {
                                                                                                        default:
                                                                                                            if (i7 > 0) {
                                                                                                                break;
                                                                                                            }
                                                                                                            z8 = false;
                                                                                                        case -76:
                                                                                                        case -73:
                                                                                                        case -71:
                                                                                                        case -68:
                                                                                                        case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                                                        case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                                                        case -11:
                                                                                                        case -10:
                                                                                                            z8 = true;
                                                                                                            break;
                                                                                                    }
                                                                                                    if (z8) {
                                                                                                    }
                                                                                                    if (this.i == i6) {
                                                                                                    }
                                                                                                    if (this.i == -51) {
                                                                                                        android.os.SystemClock.sleep(1000L);
                                                                                                        this.c = z3;
                                                                                                        this.g.b(this);
                                                                                                        this.m = null;
                                                                                                        this.p = gVar2.d();
                                                                                                        gVar2.r();
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                i6 = -15;
                                                                                            }
                                                                                            z7 = true;
                                                                                            if (z7) {
                                                                                                i7 = this.i;
                                                                                                switch (i7) {
                                                                                                    default:
                                                                                                        if (i7 > 0) {
                                                                                                            break;
                                                                                                        }
                                                                                                        z8 = false;
                                                                                                    case -76:
                                                                                                    case -73:
                                                                                                    case -71:
                                                                                                    case -68:
                                                                                                    case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                                                    case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                                                    case -11:
                                                                                                    case -10:
                                                                                                        z8 = true;
                                                                                                        break;
                                                                                                }
                                                                                                if (z8) {
                                                                                                }
                                                                                                if (this.i == i6) {
                                                                                                }
                                                                                                if (this.i == -51) {
                                                                                                    android.os.SystemClock.sleep(1000L);
                                                                                                    this.c = z3;
                                                                                                    this.g.b(this);
                                                                                                    this.m = null;
                                                                                                    this.p = gVar2.d();
                                                                                                    gVar2.r();
                                                                                                }
                                                                                            } else {
                                                                                                i7 = this.i;
                                                                                                switch (i7) {
                                                                                                    default:
                                                                                                        if (i7 > 0) {
                                                                                                            break;
                                                                                                        }
                                                                                                        z8 = false;
                                                                                                    case -76:
                                                                                                    case -73:
                                                                                                    case -71:
                                                                                                    case -68:
                                                                                                    case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                                                    case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                                                    case -11:
                                                                                                    case -10:
                                                                                                        z8 = true;
                                                                                                        break;
                                                                                                }
                                                                                                if (z8) {
                                                                                                }
                                                                                                if (this.i == i6) {
                                                                                                }
                                                                                                if (this.i == -51) {
                                                                                                    android.os.SystemClock.sleep(1000L);
                                                                                                    this.c = z3;
                                                                                                    this.g.b(this);
                                                                                                    this.m = null;
                                                                                                    this.p = gVar2.d();
                                                                                                    gVar2.r();
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        gVar3 = gVar2;
                                                                                        this.c = z3;
                                                                                        this.g.b(this);
                                                                                        this.m = null;
                                                                                        this.p = gVar3.d();
                                                                                        gVar3.r();
                                                                                    }
                                                                                    this.c = z3;
                                                                                    this.g.b(this);
                                                                                    this.m = null;
                                                                                    this.p = gVar2.d();
                                                                                    gVar2.r();
                                                                                    z13 = z6;
                                                                                    i9 = i2;
                                                                                    jElapsedRealtime4 = jElapsedRealtime4;
                                                                                    z11 = true;
                                                                                    z10 = false;
                                                                                    j4 = 0;
                                                                                } catch (java.lang.Throwable th8) {
                                                                                    th = th8;
                                                                                    gVar = gVar3;
                                                                                    z = true;
                                                                                    th.printStackTrace();
                                                                                    this.i = -61;
                                                                                    java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                                                                                    sb6.append(th);
                                                                                    this.j = sb6.toString();
                                                                                    this.c = z3;
                                                                                    this.g.b(this);
                                                                                    this.m = null;
                                                                                    if (gVar != null) {
                                                                                        this.p = gVar.d();
                                                                                        gVar.r();
                                                                                    }
                                                                                    this.l = z;
                                                                                    this.o.c = java.lang.System.currentTimeMillis() - this.o.b;
                                                                                    this.g.c(this);
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                        z3 = false;
                                                                        z = true;
                                                                        this.c = z3;
                                                                        this.g.b(this);
                                                                        this.m = null;
                                                                        this.p = gVar3.d();
                                                                        gVar3.r();
                                                                    } catch (java.lang.Throwable th9) {
                                                                        th = th9;
                                                                        gVar = gVar3;
                                                                        z3 = false;
                                                                        z = true;
                                                                        th.printStackTrace();
                                                                        this.i = -61;
                                                                        java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
                                                                        sb7.append(th);
                                                                        this.j = sb7.toString();
                                                                        this.c = z3;
                                                                        this.g.b(this);
                                                                        this.m = null;
                                                                        if (gVar != null) {
                                                                            this.p = gVar.d();
                                                                            gVar.r();
                                                                        }
                                                                        this.l = z;
                                                                        this.o.c = java.lang.System.currentTimeMillis() - this.o.b;
                                                                        this.g.c(this);
                                                                        return;
                                                                    }
                                                                }
                                                            } catch (java.lang.Throwable th10) {
                                                                th = th10;
                                                            }
                                                        }
                                                    }
                                                    this.c = false;
                                                    this.g.b(this);
                                                    this.m = null;
                                                    this.p = gVar.d();
                                                    gVar.r();
                                                } catch (java.lang.Throwable th11) {
                                                    th = th11;
                                                }
                                            } catch (java.lang.Throwable th12) {
                                                th = th12;
                                                z3 = false;
                                                z = true;
                                                gVar = null;
                                            }
                                        } catch (java.lang.Throwable th13) {
                                            th = th13;
                                            z3 = false;
                                            gVar = null;
                                            z = true;
                                            th.printStackTrace();
                                            this.i = -61;
                                            java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
                                            sb8.append(th);
                                            this.j = sb8.toString();
                                            this.c = z3;
                                            this.g.b(this);
                                            this.m = null;
                                            if (gVar != null) {
                                                this.p = gVar.d();
                                                gVar.r();
                                            }
                                            this.l = z;
                                            this.o.c = java.lang.System.currentTimeMillis() - this.o.b;
                                            this.g.c(this);
                                            return;
                                        }
                                    } else {
                                        z4 = z13;
                                        if (z4) {
                                            i = 524288;
                                        } else {
                                            i = -1;
                                        }
                                        aVar = this.f619a;
                                        zA = this.g.a();
                                        j = aVar.g;
                                        if (i <= 0) {
                                            j2 = j;
                                        } else if (aVar.g == -1) {
                                            j2 = aVar.f + ((long) i);
                                        } else {
                                            j3 = i;
                                            if (j3 < aVar.g - aVar.f) {
                                                j2 = aVar.f + j3;
                                            } else if (zA) {
                                                j2 = -1;
                                            } else {
                                                j2 = j;
                                            }
                                        }
                                        bVar = new com.tencent.hlyyb.downloader.a.a.b(aVar.f, j2);
                                        i2 = 1000;
                                        gVar = new com.tencent.hlyyb.downloader.a.a.g(this.b, this.h, bVar, z4, this, this.b.d, this.e, 1);
                                        this.m = gVar;
                                        if (this.k) {
                                            zA2 = true;
                                        } else {
                                            zA2 = true;
                                        }
                                        if (zA2) {
                                            com.tencent.hlyyb.downloader.e.c.c cVar5 = this.o;
                                            int i14 = cVar5.d;
                                            cVar5.d = i14 + 1;
                                            this.D = i14;
                                            dVar = new com.tencent.hlyyb.downloader.e.c.d(this.D, this.b);
                                            dVar.c = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime4;
                                            dVar.f624a = z4;
                                            dVar.b = this.f619a.toString();
                                            dVar.f = bVar.toString();
                                            jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                                            gVar.p();
                                            if (this.k) {
                                                zA3 = true;
                                            } else {
                                                zA3 = true;
                                            }
                                            if (zA3) {
                                                this.i = gVar.a();
                                                this.j = gVar.b();
                                                dVar.e = this.i;
                                                dVar.d = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime4;
                                                dVar.g = gVar.g();
                                                dVar.i = gVar.i();
                                                dVar.j = gVar.j();
                                                dVar.h = gVar.c();
                                                dVar.k = gVar.h();
                                                dVar.l = gVar.k();
                                                dVar.m = gVar.l();
                                                z3 = false;
                                                dVar.r = gVar.a(false);
                                                dVar.s = gVar.f();
                                                this.o.a(dVar);
                                                if (this.i == -53) {
                                                    dVar2 = dVar;
                                                    jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime;
                                                    if (this.i != 0) {
                                                        if (this.i == -59) {
                                                            z12 = false;
                                                            z6 = true;
                                                        } else {
                                                            z6 = z4;
                                                            z12 = true;
                                                        }
                                                        if (jElapsedRealtime2 > 10000) {
                                                            z3 = false;
                                                            z5 = true;
                                                            z = true;
                                                            i2 = 0;
                                                        } else {
                                                            i8 = this.i;
                                                            if (i8 != -16) {
                                                                z9 = true;
                                                            } else {
                                                                z9 = true;
                                                            }
                                                            if (z9) {
                                                                z3 = false;
                                                                z5 = true;
                                                                z = true;
                                                                i2 = 3000;
                                                            } else {
                                                                z3 = false;
                                                                z5 = true;
                                                                z = true;
                                                            }
                                                        }
                                                        gVar2 = gVar;
                                                    } else {
                                                        z3 = false;
                                                        if (!this.e.a(false)) {
                                                        }
                                                        if (this.k) {
                                                            zA4 = true;
                                                        } else {
                                                            zA4 = true;
                                                        }
                                                        if (zA4) {
                                                            gVar2 = gVar;
                                                            z3 = false;
                                                            z = true;
                                                        } else {
                                                            jElapsedRealtime4 = jElapsedRealtime4;
                                                            z = true;
                                                            gVar2 = gVar;
                                                            bVarA = this.g.a(this, this.b, gVar.e(), gVar.c(), gVar.o(), gVar.k(), gVar.l(), gVar.h(), gVar.m());
                                                            if (!this.k) {
                                                                zA5 = true;
                                                            } else if (this.f != null) {
                                                                zA5 = this.f.a();
                                                            } else {
                                                                zA5 = true;
                                                            }
                                                            if (zA5) {
                                                                dVar2.n = bVarA.f595a;
                                                                if (bVarA.f595a == 0) {
                                                                    if (this.k) {
                                                                        zA6 = true;
                                                                    } else {
                                                                        zA6 = true;
                                                                    }
                                                                    if (zA6) {
                                                                        this.c = true;
                                                                        gVar2.a(this);
                                                                        com.tencent.hlyyb.downloader.e.d.a aVar5 = this.b;
                                                                        z3 = false;
                                                                        this.c = false;
                                                                        aVar5.f = false;
                                                                        this.i = gVar2.a();
                                                                        this.j = gVar2.b();
                                                                        dVar2.o = this.i;
                                                                        dVar2.p = this.f619a.toString();
                                                                        dVar2.q = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime4;
                                                                        if (!this.v) {
                                                                            listSynchronizedList = (java.util.List) this.t.get(this.b);
                                                                            if (listSynchronizedList == null) {
                                                                                listSynchronizedList = java.util.Collections.synchronizedList(new java.util.ArrayList());
                                                                                this.t.put(this.b, listSynchronizedList);
                                                                            }
                                                                            if (this.f619a.f > this.f619a.d) {
                                                                                listSynchronizedList.add(this.f619a.d + "," + this.f619a.f);
                                                                            }
                                                                        }
                                                                        if (this.A) {
                                                                            i3 = this.w.get();
                                                                            cVar = this.e;
                                                                            iG = cVar.g();
                                                                            if (!android.text.TextUtils.isEmpty(cVar.f628a.e)) {
                                                                                iG--;
                                                                            }
                                                                            if (cVar.b != null) {
                                                                                iG--;
                                                                            }
                                                                            i4 = iG;
                                                                            if (i4 > 0) {
                                                                                i4 = 1;
                                                                            }
                                                                            if (i3 >= i4) {
                                                                                this.i = -75;
                                                                            }
                                                                        }
                                                                        if (this.i != 0) {
                                                                            z5 = false;
                                                                            i2 = 0;
                                                                            jElapsedRealtime5 = 0;
                                                                            z6 = z4;
                                                                            jElapsedRealtime5 = jElapsedRealtime5;
                                                                            z12 = true;
                                                                        } else {
                                                                            z5 = false;
                                                                            i2 = 0;
                                                                            jElapsedRealtime5 = 0;
                                                                            z6 = z4;
                                                                            jElapsedRealtime5 = jElapsedRealtime5;
                                                                            z12 = false;
                                                                        }
                                                                    }
                                                                    gVar = gVar2;
                                                                    th.printStackTrace();
                                                                    this.i = -61;
                                                                    java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
                                                                    sb9.append(th);
                                                                    this.j = sb9.toString();
                                                                    this.c = z3;
                                                                    this.g.b(this);
                                                                    this.m = null;
                                                                    if (gVar != null) {
                                                                        this.p = gVar.d();
                                                                        gVar.r();
                                                                    }
                                                                } else {
                                                                    z3 = false;
                                                                    if (bVarA.f595a < 0) {
                                                                        this.i = bVarA.f595a;
                                                                        this.j = bVarA.b;
                                                                        z5 = true;
                                                                        z6 = z4;
                                                                        jElapsedRealtime5 = jElapsedRealtime5;
                                                                        z12 = true;
                                                                    } else {
                                                                        z5 = true;
                                                                        z6 = z4;
                                                                        jElapsedRealtime5 = jElapsedRealtime5;
                                                                        z12 = false;
                                                                    }
                                                                }
                                                                this.c = z3;
                                                                this.g.b(this);
                                                                this.m = null;
                                                                this.p = gVar2.d();
                                                                gVar2.r();
                                                            }
                                                            z3 = false;
                                                        }
                                                        gVar3 = gVar2;
                                                        this.c = z3;
                                                        this.g.b(this);
                                                        this.m = null;
                                                        this.p = gVar3.d();
                                                        gVar3.r();
                                                    }
                                                    if (z5) {
                                                        jElapsedRealtime3 = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime5;
                                                        if (jElapsedRealtime3 <= 60000) {
                                                            i5 = this.i;
                                                            if (i5 != -16) {
                                                                i6 = -15;
                                                                if (i5 == -15) {
                                                                }
                                                                if (z7) {
                                                                    i7 = this.i;
                                                                    switch (i7) {
                                                                        default:
                                                                            if (i7 > 0) {
                                                                                break;
                                                                            }
                                                                            z8 = false;
                                                                        case -76:
                                                                        case -73:
                                                                        case -71:
                                                                        case -68:
                                                                        case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                        case -11:
                                                                        case -10:
                                                                            z8 = true;
                                                                            break;
                                                                    }
                                                                    if (z8) {
                                                                    }
                                                                    if (this.i == i6) {
                                                                    }
                                                                    if (this.i == -51) {
                                                                        android.os.SystemClock.sleep(1000L);
                                                                        this.c = z3;
                                                                        this.g.b(this);
                                                                        this.m = null;
                                                                        this.p = gVar2.d();
                                                                        gVar2.r();
                                                                    }
                                                                } else {
                                                                    i7 = this.i;
                                                                    switch (i7) {
                                                                        default:
                                                                            if (i7 > 0) {
                                                                                break;
                                                                            }
                                                                            z8 = false;
                                                                        case -76:
                                                                        case -73:
                                                                        case -71:
                                                                        case -68:
                                                                        case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                        case -11:
                                                                        case -10:
                                                                            z8 = true;
                                                                            break;
                                                                    }
                                                                    if (z8) {
                                                                    }
                                                                    if (this.i == i6) {
                                                                    }
                                                                    if (this.i == -51) {
                                                                        android.os.SystemClock.sleep(1000L);
                                                                        this.c = z3;
                                                                        this.g.b(this);
                                                                        this.m = null;
                                                                        this.p = gVar2.d();
                                                                        gVar2.r();
                                                                    }
                                                                }
                                                            } else {
                                                                i6 = -15;
                                                            }
                                                            z7 = true;
                                                            if (z7) {
                                                                i7 = this.i;
                                                                switch (i7) {
                                                                    default:
                                                                        if (i7 > 0) {
                                                                            break;
                                                                        }
                                                                        z8 = false;
                                                                    case -76:
                                                                    case -73:
                                                                    case -71:
                                                                    case -68:
                                                                    case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                    case -11:
                                                                    case -10:
                                                                        z8 = true;
                                                                        break;
                                                                }
                                                                if (z8) {
                                                                }
                                                                if (this.i == i6) {
                                                                }
                                                                if (this.i == -51) {
                                                                    android.os.SystemClock.sleep(1000L);
                                                                    this.c = z3;
                                                                    this.g.b(this);
                                                                    this.m = null;
                                                                    this.p = gVar2.d();
                                                                    gVar2.r();
                                                                }
                                                            } else {
                                                                i7 = this.i;
                                                                switch (i7) {
                                                                    default:
                                                                        if (i7 > 0) {
                                                                            break;
                                                                        }
                                                                        z8 = false;
                                                                    case -76:
                                                                    case -73:
                                                                    case -71:
                                                                    case -68:
                                                                    case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                    case -11:
                                                                    case -10:
                                                                        z8 = true;
                                                                        break;
                                                                }
                                                                if (z8) {
                                                                }
                                                                if (this.i == i6) {
                                                                }
                                                                if (this.i == -51) {
                                                                    android.os.SystemClock.sleep(1000L);
                                                                    this.c = z3;
                                                                    this.g.b(this);
                                                                    this.m = null;
                                                                    this.p = gVar2.d();
                                                                    gVar2.r();
                                                                }
                                                            }
                                                        }
                                                        gVar3 = gVar2;
                                                        this.c = z3;
                                                        this.g.b(this);
                                                        this.m = null;
                                                        this.p = gVar3.d();
                                                        gVar3.r();
                                                    }
                                                    this.c = z3;
                                                    this.g.b(this);
                                                    this.m = null;
                                                    this.p = gVar2.d();
                                                    gVar2.r();
                                                    z13 = z6;
                                                    i9 = i2;
                                                    jElapsedRealtime4 = jElapsedRealtime4;
                                                    z11 = true;
                                                    z10 = false;
                                                    j4 = 0;
                                                } else {
                                                    dVar2 = dVar;
                                                    jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime;
                                                    if (this.i != 0) {
                                                        if (this.i == -59) {
                                                            z12 = false;
                                                            z6 = true;
                                                        } else {
                                                            z6 = z4;
                                                            z12 = true;
                                                        }
                                                        if (jElapsedRealtime2 > 10000) {
                                                            z3 = false;
                                                            z5 = true;
                                                            z = true;
                                                            i2 = 0;
                                                        } else {
                                                            i8 = this.i;
                                                            if (i8 != -16) {
                                                                z9 = true;
                                                            } else {
                                                                z9 = true;
                                                            }
                                                            if (z9) {
                                                                z3 = false;
                                                                z5 = true;
                                                                z = true;
                                                                i2 = 3000;
                                                            } else {
                                                                z3 = false;
                                                                z5 = true;
                                                                z = true;
                                                            }
                                                        }
                                                        gVar2 = gVar;
                                                    } else {
                                                        z3 = false;
                                                        if (!this.e.a(false)) {
                                                        }
                                                        if (this.k) {
                                                            zA4 = true;
                                                        } else {
                                                            zA4 = true;
                                                        }
                                                        if (zA4) {
                                                            gVar2 = gVar;
                                                            z3 = false;
                                                            z = true;
                                                        } else {
                                                            jElapsedRealtime4 = jElapsedRealtime4;
                                                            z = true;
                                                            gVar2 = gVar;
                                                            bVarA = this.g.a(this, this.b, gVar.e(), gVar.c(), gVar.o(), gVar.k(), gVar.l(), gVar.h(), gVar.m());
                                                            if (!this.k) {
                                                                zA5 = true;
                                                            } else if (this.f != null) {
                                                                zA5 = this.f.a();
                                                            } else {
                                                                zA5 = true;
                                                            }
                                                            if (zA5) {
                                                                dVar2.n = bVarA.f595a;
                                                                if (bVarA.f595a == 0) {
                                                                    if (this.k) {
                                                                        zA6 = true;
                                                                    } else {
                                                                        zA6 = true;
                                                                    }
                                                                    if (zA6) {
                                                                        this.c = true;
                                                                        gVar2.a(this);
                                                                        com.tencent.hlyyb.downloader.e.d.a aVar6 = this.b;
                                                                        z3 = false;
                                                                        this.c = false;
                                                                        aVar6.f = false;
                                                                        this.i = gVar2.a();
                                                                        this.j = gVar2.b();
                                                                        dVar2.o = this.i;
                                                                        dVar2.p = this.f619a.toString();
                                                                        dVar2.q = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime4;
                                                                        if (!this.v) {
                                                                            listSynchronizedList = (java.util.List) this.t.get(this.b);
                                                                            if (listSynchronizedList == null) {
                                                                                listSynchronizedList = java.util.Collections.synchronizedList(new java.util.ArrayList());
                                                                                this.t.put(this.b, listSynchronizedList);
                                                                            }
                                                                            if (this.f619a.f > this.f619a.d) {
                                                                                listSynchronizedList.add(this.f619a.d + "," + this.f619a.f);
                                                                            }
                                                                        }
                                                                        if (this.A) {
                                                                            i3 = this.w.get();
                                                                            cVar = this.e;
                                                                            iG = cVar.g();
                                                                            if (!android.text.TextUtils.isEmpty(cVar.f628a.e)) {
                                                                                iG--;
                                                                            }
                                                                            if (cVar.b != null) {
                                                                                iG--;
                                                                            }
                                                                            i4 = iG;
                                                                            if (i4 > 0) {
                                                                                i4 = 1;
                                                                            }
                                                                            if (i3 >= i4) {
                                                                                this.i = -75;
                                                                            }
                                                                        }
                                                                        if (this.i != 0) {
                                                                            z5 = false;
                                                                            i2 = 0;
                                                                            jElapsedRealtime5 = 0;
                                                                            z6 = z4;
                                                                            jElapsedRealtime5 = jElapsedRealtime5;
                                                                            z12 = true;
                                                                        } else {
                                                                            z5 = false;
                                                                            i2 = 0;
                                                                            jElapsedRealtime5 = 0;
                                                                            z6 = z4;
                                                                            jElapsedRealtime5 = jElapsedRealtime5;
                                                                            z12 = false;
                                                                        }
                                                                    }
                                                                    gVar = gVar2;
                                                                    th.printStackTrace();
                                                                    this.i = -61;
                                                                    java.lang.StringBuilder sb10 = new java.lang.StringBuilder();
                                                                    sb10.append(th);
                                                                    this.j = sb10.toString();
                                                                    this.c = z3;
                                                                    this.g.b(this);
                                                                    this.m = null;
                                                                    if (gVar != null) {
                                                                        this.p = gVar.d();
                                                                        gVar.r();
                                                                    }
                                                                } else {
                                                                    z3 = false;
                                                                    if (bVarA.f595a < 0) {
                                                                        this.i = bVarA.f595a;
                                                                        this.j = bVarA.b;
                                                                        z5 = true;
                                                                        z6 = z4;
                                                                        jElapsedRealtime5 = jElapsedRealtime5;
                                                                        z12 = true;
                                                                    } else {
                                                                        z5 = true;
                                                                        z6 = z4;
                                                                        jElapsedRealtime5 = jElapsedRealtime5;
                                                                        z12 = false;
                                                                    }
                                                                }
                                                                this.c = z3;
                                                                this.g.b(this);
                                                                this.m = null;
                                                                this.p = gVar2.d();
                                                                gVar2.r();
                                                            }
                                                            z3 = false;
                                                        }
                                                        gVar3 = gVar2;
                                                        this.c = z3;
                                                        this.g.b(this);
                                                        this.m = null;
                                                        this.p = gVar3.d();
                                                        gVar3.r();
                                                    }
                                                    if (z5) {
                                                        jElapsedRealtime3 = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime5;
                                                        if (jElapsedRealtime3 <= 60000) {
                                                            i5 = this.i;
                                                            if (i5 != -16) {
                                                                i6 = -15;
                                                                if (i5 == -15) {
                                                                }
                                                                if (z7) {
                                                                    i7 = this.i;
                                                                    switch (i7) {
                                                                        default:
                                                                            if (i7 > 0) {
                                                                                break;
                                                                            }
                                                                            z8 = false;
                                                                        case -76:
                                                                        case -73:
                                                                        case -71:
                                                                        case -68:
                                                                        case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                        case -11:
                                                                        case -10:
                                                                            z8 = true;
                                                                            break;
                                                                    }
                                                                    if (z8) {
                                                                    }
                                                                    if (this.i == i6) {
                                                                    }
                                                                    if (this.i == -51) {
                                                                        android.os.SystemClock.sleep(1000L);
                                                                        this.c = z3;
                                                                        this.g.b(this);
                                                                        this.m = null;
                                                                        this.p = gVar2.d();
                                                                        gVar2.r();
                                                                    }
                                                                } else {
                                                                    i7 = this.i;
                                                                    switch (i7) {
                                                                        default:
                                                                            if (i7 > 0) {
                                                                                break;
                                                                            }
                                                                            z8 = false;
                                                                        case -76:
                                                                        case -73:
                                                                        case -71:
                                                                        case -68:
                                                                        case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                        case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                        case -11:
                                                                        case -10:
                                                                            z8 = true;
                                                                            break;
                                                                    }
                                                                    if (z8) {
                                                                    }
                                                                    if (this.i == i6) {
                                                                    }
                                                                    if (this.i == -51) {
                                                                        android.os.SystemClock.sleep(1000L);
                                                                        this.c = z3;
                                                                        this.g.b(this);
                                                                        this.m = null;
                                                                        this.p = gVar2.d();
                                                                        gVar2.r();
                                                                    }
                                                                }
                                                            } else {
                                                                i6 = -15;
                                                            }
                                                            z7 = true;
                                                            if (z7) {
                                                                i7 = this.i;
                                                                switch (i7) {
                                                                    default:
                                                                        if (i7 > 0) {
                                                                            break;
                                                                        }
                                                                        z8 = false;
                                                                    case -76:
                                                                    case -73:
                                                                    case -71:
                                                                    case -68:
                                                                    case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                    case -11:
                                                                    case -10:
                                                                        z8 = true;
                                                                        break;
                                                                }
                                                                if (z8) {
                                                                }
                                                                if (this.i == i6) {
                                                                }
                                                                if (this.i == -51) {
                                                                    android.os.SystemClock.sleep(1000L);
                                                                    this.c = z3;
                                                                    this.g.b(this);
                                                                    this.m = null;
                                                                    this.p = gVar2.d();
                                                                    gVar2.r();
                                                                }
                                                            } else {
                                                                i7 = this.i;
                                                                switch (i7) {
                                                                    default:
                                                                        if (i7 > 0) {
                                                                            break;
                                                                        }
                                                                        z8 = false;
                                                                    case -76:
                                                                    case -73:
                                                                    case -71:
                                                                    case -68:
                                                                    case com.pay.tool.APPluginConstants.ERROR_UNZIP_RESOURCE /* -56 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_JSON_RESULTCODE /* -55 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_ZipException /* -54 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_UnknownHostException /* -51 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLProtocolException /* -44 */:
                                                                    case com.pay.tool.APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException /* -43 */:
                                                                    case -11:
                                                                    case -10:
                                                                        z8 = true;
                                                                        break;
                                                                }
                                                                if (z8) {
                                                                }
                                                                if (this.i == i6) {
                                                                }
                                                                if (this.i == -51) {
                                                                    android.os.SystemClock.sleep(1000L);
                                                                    this.c = z3;
                                                                    this.g.b(this);
                                                                    this.m = null;
                                                                    this.p = gVar2.d();
                                                                    gVar2.r();
                                                                }
                                                            }
                                                        }
                                                        gVar3 = gVar2;
                                                        this.c = z3;
                                                        this.g.b(this);
                                                        this.m = null;
                                                        this.p = gVar3.d();
                                                        gVar3.r();
                                                    }
                                                    this.c = z3;
                                                    this.g.b(this);
                                                    this.m = null;
                                                    this.p = gVar2.d();
                                                    gVar2.r();
                                                    z13 = z6;
                                                    i9 = i2;
                                                    jElapsedRealtime4 = jElapsedRealtime4;
                                                    z11 = true;
                                                    z10 = false;
                                                    j4 = 0;
                                                }
                                            }
                                        }
                                        this.c = false;
                                        this.g.b(this);
                                        this.m = null;
                                        this.p = gVar.d();
                                        gVar.r();
                                    }
                                    this.l = z;
                                    this.o.c = java.lang.System.currentTimeMillis() - this.o.b;
                                    this.g.c(this);
                                    return;
                                }
                            } else {
                                this.v = z11;
                                jElapsedRealtime5 = jElapsedRealtime5;
                            }
                        }
                    }
                }
                this.g.c(this);
                return;
            } catch (java.lang.Throwable th14) {
                th14.printStackTrace();
                return;
            }
            z = true;
            this.l = z;
            this.o.c = java.lang.System.currentTimeMillis() - this.o.b;
        }
    }
}
