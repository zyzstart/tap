package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class j implements java.util.concurrent.Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.tencent.yybsdk.apkpatch.u f1432a;
    public com.tencent.yybsdk.apkpatch.d.h b;
    private final java.lang.String c;
    private final com.tencent.yybsdk.apkpatch.r d;
    private boolean e;
    private boolean f;
    private volatile int h;
    private int i;
    private byte[] k;
    private java.nio.ByteBuffer l;
    private final com.tencent.yybsdk.apkpatch.e.b.a m;
    private final com.tencent.yybsdk.apkpatch.v n;
    private final com.tencent.yybsdk.apkpatch.t o;
    private com.tencent.yybsdk.apkpatch.n p;
    private com.tencent.yybsdk.apkpatch.d.e q;
    private boolean g = false;
    private java.lang.String j = "";
    private com.tencent.yybsdk.apkpatch.c.f r = new com.tencent.yybsdk.apkpatch.k(this);
    private com.tencent.yybsdk.apkpatch.bsdiff.b s = new com.tencent.yybsdk.apkpatch.m(this);

    public j(com.tencent.yybsdk.apkpatch.u uVar, com.tencent.yybsdk.apkpatch.r rVar, com.tencent.yybsdk.apkpatch.e.b.a aVar) {
        byte[] bArr = new byte[8196];
        this.k = bArr;
        this.l = java.nio.ByteBuffer.wrap(bArr);
        this.b = null;
        this.q = null;
        this.f1432a = uVar;
        this.d = rVar;
        this.m = aVar;
        this.c = "ApkPatchCallable ~ " + uVar.f1442a;
        this.n = new com.tencent.yybsdk.apkpatch.v(uVar.b, uVar.d.b(), uVar.c, uVar.f);
        this.o = new com.tencent.yybsdk.apkpatch.t(uVar.b, uVar.c);
        com.tencent.yybsdk.apkpatch.d.h hVarA = com.tencent.yybsdk.apkpatch.d.f.a().a(uVar.e);
        this.b = hVarA;
        hVarA.m = uVar.b;
        hVarA.n = uVar.c;
        com.tencent.yybsdk.apkpatch.b.a aVar2 = uVar.d;
        if (aVar2 != null) {
            hVarA.o = aVar2.b();
            uVar.d.c = this.b;
        }
        this.q = new com.tencent.yybsdk.apkpatch.d.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x00d8 A[Catch: UnsupportedEncodingException -> 0x00df, TRY_LEAVE, TryCatch #0 {UnsupportedEncodingException -> 0x00df, blocks: (B:34:0x00be, B:36:0x00c2, B:38:0x00c8, B:39:0x00d8), top: B:63:0x00be }] */
    public void a(com.tencent.yybsdk.apkpatch.n nVar) {
        com.tencent.yybsdk.apkpatch.h hVar;
        com.tencent.yybsdk.apkpatch.d.c cVarC = this.q.c(2);
        if (cVarC != null) {
            this.b.C = cVarC.a();
            this.b.D = cVarC.b();
        }
        com.tencent.yybsdk.apkpatch.d.c cVarC2 = this.q.c(2, com.unisound.client.SpeechConstants.ASR_OPT_ACTIVATE_TOKEN);
        if (cVarC2 != null) {
            this.b.O = cVarC2.c();
        }
        com.tencent.yybsdk.apkpatch.d.c cVarC3 = this.q.c(2, 10001);
        if (cVarC3 != null) {
            this.b.Q = cVarC3.c();
            this.b.P = cVarC3.a();
        }
        com.tencent.yybsdk.apkpatch.d.c cVarC4 = this.q.c(2, com.unisound.client.SpeechConstants.ASR_OPT_SET_COMPILE_MAX_PRONUNCIATION);
        if (cVarC4 != null) {
            this.b.R = cVarC4.c();
        }
        com.tencent.yybsdk.apkpatch.d.c cVarC5 = this.q.c(2, com.unisound.client.SpeechConstants.ASR_OPT_SET_OVER_MAX_PRONUNCIATION_INSERT);
        if (cVarC5 != null) {
            this.b.S = cVarC5.a();
            this.b.T = cVarC5.c();
        }
        com.tencent.yybsdk.apkpatch.d.c cVarC6 = this.q.c(2, com.unisound.client.SpeechConstants.ASR_OPT_GET_COMPILE_ERRORINFO);
        if (cVarC6 != null) {
            this.b.U = cVarC6.c();
        }
        com.tencent.yybsdk.apkpatch.d.h hVar2 = this.b;
        if (hVar2.v <= 0) {
            hVar2.v = hVar2.D;
        }
        com.tencent.yybsdk.apkpatch.d.h hVar3 = this.b;
        if (hVar3.w <= 0) {
            com.tencent.yybsdk.apkpatch.b.a aVar = this.f1432a.d;
            hVar3.w = aVar.b - aVar.d;
        }
        com.tencent.yybsdk.apkpatch.d.h hVar4 = this.b;
        hVar4.F = this.n.h - 1;
        hVar4.G = (nVar == null || (hVar = nVar.f) == null) ? 0L : hVar.m;
        if (nVar != null) {
            try {
                if (nVar.f == null || nVar.f.e == null) {
                    this.b.j = "";
                } else {
                    this.b.j = new java.lang.String(nVar.f.e, "UTF-8");
                }
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            this.b.j = "";
        }
        this.b.z = new java.io.File(this.f1432a.b).length();
        if (this.b.A != new java.io.File(this.f1432a.d.b()).length()) {
            com.tencent.yybsdk.apkpatch.f.a.d(this.c, "mPatchSize: " + this.b.A + " " + new java.io.File(this.f1432a.d.b()).length());
        }
        com.tencent.yybsdk.apkpatch.d.h hVar5 = this.b;
        if (hVar5.A <= 0) {
            hVar5.A = new java.io.File(this.f1432a.d.b()).length();
        }
        com.tencent.yybsdk.apkpatch.d.h hVar6 = this.b;
        if (hVar6.B <= 0) {
            hVar6.B = new java.io.File(this.f1432a.c).length();
        }
        this.b.I = this.h;
        this.b.H = this.h < 0 ? 3 : this.h;
        com.tencent.yybsdk.apkpatch.d.h hVar7 = this.b;
        java.lang.String str = this.j;
        if (str == null) {
            str = "";
        }
        hVar7.J = str;
        com.tencent.yybsdk.apkpatch.f.a.b(this.c, this.b.toString());
        com.tencent.yybsdk.apkpatch.d.f.a().a(this.b);
    }

    private boolean a(java.lang.String str) {
        try {
            this.p.f1436a.a(this.p.i.f1414a);
            if ((this.p.i.f1414a.b & 8) != 8) {
                return true;
            }
            this.p.f1436a.a(this.p.i.b);
            return true;
        } catch (java.lang.Exception e) {
            if (c()) {
                return false;
            }
            this.j = "mergeDirEntry failed, fileName = " + str + " ," + com.tencent.yybsdk.apkpatch.f.a.a(e);
            c(-27);
            e.printStackTrace();
            return false;
        }
    }

    private boolean b(java.lang.String str) {
        try {
            this.p.f1436a.a(this.p.i.f1414a);
            this.p.f1436a.skipBytes((this.p.i.f1414a.b & 8) == 8 ? this.p.i.b.e : this.p.i.f1414a.g);
            if ((this.p.i.f1414a.b & 8) != 8) {
                return true;
            }
            this.p.f1436a.a(this.p.i.b);
            return true;
        } catch (java.lang.Exception e) {
            if (c()) {
                return false;
            }
            e.printStackTrace();
            this.j = "mergeEntryFromPatch failed, innerErrorCode =  fileName = " + str + " ," + com.tencent.yybsdk.apkpatch.f.a.a(e);
            c(-44);
            return false;
        }
    }

    private void c(int i) {
        if (!c()) {
            com.tencent.yybsdk.apkpatch.f.a.a(this.c, "patchFailed errCode = " + i + " errMsg = " + this.j);
        }
        this.h = i;
        a(8);
    }

    private boolean c(java.lang.String str) {
        try {
            this.p.f1436a.a(this.p.i.f1414a);
            int i = (this.p.i.f1414a.b & 8) == 8 ? this.p.i.b.e : this.p.i.f1414a.g;
            int i2 = 0;
            while (i2 < i) {
                int i3 = i - i2;
                if (i3 > 8196) {
                    i3 = 8196;
                }
                int i4 = this.p.c.read(this.k, 0, i3);
                this.l.clear();
                this.l.limit(i4);
                this.p.f1436a.a(this.l);
                i2 += i3;
            }
            if ((this.p.i.f1414a.b & 8) != 8) {
                return true;
            }
            this.p.f1436a.a(this.p.i.b);
            return true;
        } catch (java.lang.Exception e) {
            if (c()) {
                return false;
            }
            e.printStackTrace();
            this.j = "mergeEntryFromPatch failed, innerErrorCode =  fileName = " + str + " ," + com.tencent.yybsdk.apkpatch.f.a.a(e);
            c(-28);
            return false;
        }
    }

    private boolean d(java.lang.String str) {
        try {
            this.p.f1436a.a(this.p.i.f1414a);
            this.p.d.a(this.p.i.d);
            this.p.d.b(this.p.i.e);
            while (true) {
                int i = this.p.d.read(this.k);
                if (i <= 0) {
                    break;
                }
                this.l.clear();
                this.l.limit(i);
                this.p.f1436a.a(this.l);
            }
            if ((this.p.i.f1414a.b & 8) != 8) {
                return true;
            }
            this.p.f1436a.a(this.p.i.b);
            return true;
        } catch (java.lang.Exception e) {
            if (c()) {
                return false;
            }
            c(-34);
            this.j = "mergeEntryFromOldApkV64 failed, innerErrorCode = fileName = " + str + " ," + com.tencent.yybsdk.apkpatch.f.a.a(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!c()) {
            com.tencent.yybsdk.apkpatch.f.a.a(this.c, "patchFailed errCode = " + this.h + " errMsg = " + this.j);
        }
        a(8);
    }

    private boolean e(java.lang.String str) {
        try {
            this.p.f1436a.a(this.p.h.f1423a);
            if ((this.p.h.f1423a.b & 8) != 8) {
                return true;
            }
            this.p.f1436a.a(this.p.h.b);
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            this.j = "mergeDirEntry failed, fileName = " + str + " ," + com.tencent.yybsdk.apkpatch.f.a.a(e);
            return false;
        }
    }

    private void f() {
        this.g = true;
        this.h = 0;
        a(7);
    }

    private boolean f(java.lang.String str) {
        java.lang.String str2;
        int iA;
        int i = -1;
        try {
            this.p.f1436a.a(this.p.h.f1423a);
            i = -2;
            while (!c() && (iA = this.p.c.a(this.k, 0, 8196)) > 0) {
                this.l.clear();
                this.l.limit(iA);
                this.p.f1436a.a(this.l);
                i = -4;
            }
            if ((this.p.h.f1423a.b & 8) != 8) {
                return true;
            }
            this.p.f1436a.a(this.p.h.b);
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            if (e instanceof java.io.EOFException) {
                str2 = "mergeEntryFromPatch EOF,fileName = " + str + ",totalPatchSize=" + this.f1432a.d.f1394a;
            } else {
                str2 = "mergeEntryFromPatch failed, innerErrorCode = " + i + " fileName = " + str + " ," + com.tencent.yybsdk.apkpatch.f.a.a(e);
            }
            this.j = str2;
            c(-28);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:67:0x009d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0003 A[SYNTHETIC] */
    private void g() {
        int i;
        int i2;
        com.tencent.yybsdk.apkpatch.n nVar;
        this.i = 6;
        while (!c()) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            try {
                this.p.h = this.p.c.g();
                if (this.p.h == null) {
                    if (t() && u()) {
                        com.tencent.yybsdk.apkpatch.f.a.b(this.c, "patch succeed");
                        f();
                        return;
                    }
                    return;
                }
                java.lang.String str = "";
                try {
                    str = new java.lang.String(this.p.h.f1423a.k, "UTF-8");
                } catch (java.io.UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                com.tencent.yybsdk.apkpatch.v vVar = this.n;
                if (vVar == null || vVar.h <= 0 || this.p.c.i() > this.n.h) {
                    byte b = this.p.h.c;
                    if (b == 0) {
                        if (!e(str)) {
                            i = -27;
                            c(i);
                            return;
                        }
                        if (!c()) {
                            w();
                            i2 = this.p.c.i();
                            nVar = this.p;
                            if (i2 == nVar.f.m && nVar.c.i() % (this.p.f.m / 4) == 0) {
                                i();
                                l();
                                com.tencent.yybsdk.apkpatch.f.a.a(this.c, "Log when patch 1/4,cost:" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                            }
                        }
                    } else {
                        if (b == 1) {
                            if (!f(str)) {
                                return;
                            }
                        } else {
                            if (b != 2) {
                                this.j = "Unsupport fileDataType: " + ((int) this.p.h.c) + " DataSize: " + this.p.h.d + " HeaderSize: " + this.p.h.a() + " curPosition:" + this.p.c.a() + " " + str;
                                i = -31;
                                c(i);
                                return;
                            }
                            if (!g(str)) {
                                return;
                            }
                        }
                        if (!c()) {
                            w();
                            i2 = this.p.c.i();
                            nVar = this.p;
                            if (i2 == nVar.f.m) {
                            }
                        }
                    }
                } else {
                    v();
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                i = -15;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a1  */
    private boolean g(java.lang.String str) {
        java.lang.Exception e;
        int i;
        int i2;
        try {
            this.p.f1436a.a(this.p.h.f1423a);
            try {
                int iC = this.p.e.c(str);
                if (iC > 0) {
                    try {
                        i = -4;
                        try {
                            this.p.e.e.seek(this.p.e.b(str));
                            int i3 = -4;
                            while (iC > 0) {
                                int i4 = 8196;
                                if (iC <= 8196) {
                                    i4 = iC;
                                }
                                int i5 = this.p.e.e.read(this.k, 0, i4);
                                if (i5 > 0) {
                                    this.l.clear();
                                    this.l.limit(i5);
                                    this.p.f1436a.a(this.l);
                                    iC -= i5;
                                    i3 = -6;
                                } else {
                                    i3 = -5;
                                }
                            }
                            i = i3;
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            if (e instanceof java.io.FileNotFoundException) {
                                i2 = -34;
                            } else {
                                i2 = -34;
                            }
                            c(i2);
                            this.j = "mergeEntryFromOldApkV2 failed, innerErrorCode = " + i + " fileName = " + str + " ," + com.tencent.yybsdk.apkpatch.f.a.a(e);
                            return false;
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        i = -3;
                        e.printStackTrace();
                        if ((e instanceof java.io.FileNotFoundException) || !e.getMessage().contains("base.apk")) {
                            i2 = -34;
                        } else {
                            i2 = -40;
                        }
                        c(i2);
                        this.j = "mergeEntryFromOldApkV2 failed, innerErrorCode = " + i + " fileName = " + str + " ," + com.tencent.yybsdk.apkpatch.f.a.a(e);
                        return false;
                    }
                } else {
                    i = -2;
                }
                if ((this.p.h.f1423a.b & 8) != 8) {
                    return true;
                }
                this.p.f1436a.a(this.p.h.b);
                return true;
            } catch (java.lang.Exception e4) {
                e = e4;
                i = -2;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            i = -1;
        }
    }

    private boolean h() {
        com.tencent.yybsdk.apkpatch.f.a.a(this.c, "begin to patchMergeBsdiffV2()");
        try {
            this.p.j = this.p.c.b();
            com.tencent.yybsdk.apkpatch.n nVar = this.p;
            nVar.l = new com.tencent.yybsdk.apkpatch.c.g(nVar.f.o);
            this.q.a(2, 10001);
            com.tencent.yybsdk.apkpatch.f.a.a("cost analysis", "inflate begin,time = " + this.q.c(2, 10001).a());
            if (!r()) {
                return false;
            }
            try {
                this.p.k = this.p.c.c();
                try {
                    if (this.p.l != null) {
                        if (!this.b.M.equals("0")) {
                            this.p.l.a();
                        } else if (!this.p.l.a(300L, java.util.concurrent.TimeUnit.SECONDS)) {
                            c(-58);
                            return false;
                        }
                        if (c()) {
                            return true;
                        }
                        if (this.h != 0) {
                            e();
                            return false;
                        }
                        this.p.j.clear();
                        this.p.n.g();
                    }
                    this.q.b(2, 10001);
                    com.tencent.yybsdk.apkpatch.f.a.a("cost analysis", "inflate done,cost = " + this.q.c(2, 10001).c());
                    try {
                        int i = this.p.c.readInt();
                        if (i < 0) {
                            this.j = "diffFileLen < 0";
                            c(-1);
                            return false;
                        }
                        this.b.t = i;
                        this.q.a(2, com.unisound.client.SpeechConstants.ASR_OPT_SET_COMPILE_MAX_PRONUNCIATION);
                        int i2 = this.n.g;
                        if (i2 < 2) {
                            com.tencent.yybsdk.apkpatch.n nVar2 = this.p;
                            nVar2.l.a(nVar2.f.o);
                            try {
                                this.p.m = new com.tencent.yybsdk.apkpatch.bsdiff.a();
                                this.p.m.a(this.o.c(), this.o.d(), this.p.b, a(this.p.k), this.s, this.n);
                                if (c()) {
                                    return true;
                                }
                            } catch (java.lang.Exception e) {
                                if (c()) {
                                    com.tencent.yybsdk.apkpatch.f.a.a(this.c, "bspatch exit because of pause");
                                } else {
                                    e.printStackTrace();
                                    this.j = "BspatchError:" + e.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e);
                                    c(-47);
                                }
                                return false;
                            }
                        } else if (i2 == 2) {
                            try {
                                this.p.l.a(this.p.f.o);
                                this.p.b.skip(i);
                                this.s.a(this.p.f.o - 1);
                                com.tencent.yybsdk.apkpatch.f.a.a(this.c, "bspatch has been done,skip it");
                            } catch (java.io.IOException e2) {
                                this.j = "skip bspatch error";
                                c(-1);
                                e2.printStackTrace();
                                return false;
                            }
                        } else if (i2 == 3) {
                            try {
                                com.tencent.yybsdk.apkpatch.f.a.a(this.c, "bspatch has been done,skip it");
                                this.p.b.skip(i);
                                com.tencent.yybsdk.apkpatch.f.a.a(this.c, "deflate has been done,skip it");
                            } catch (java.io.IOException e3) {
                                this.j = "skip deflate error";
                                c(-1);
                                e3.printStackTrace();
                                return false;
                            }
                        }
                        if (this.h != 0) {
                            return false;
                        }
                        try {
                            this.p.d = new com.tencent.yybsdk.apkpatch.a.b(this.f1432a.b);
                            this.q.a(2, com.unisound.client.SpeechConstants.ASR_OPT_GET_COMPILE_ERRORINFO);
                            for (int i3 = 0; i3 < this.p.f.m; i3++) {
                                if (c()) {
                                    return false;
                                }
                                try {
                                    this.p.i = this.p.c.d();
                                    try {
                                        java.lang.String str = new java.lang.String(this.p.i.f1414a.k, "UTF-8");
                                        switch (this.p.i.c) {
                                            case 0:
                                                if (!a(str)) {
                                                    return false;
                                                }
                                                break;
                                                break;
                                            case 1:
                                                if (!c(str)) {
                                                    return false;
                                                }
                                                break;
                                                break;
                                            case 2:
                                                if (!d(str)) {
                                                    return false;
                                                }
                                                break;
                                                break;
                                            case 3:
                                                if (!b(str)) {
                                                    return false;
                                                }
                                                break;
                                                break;
                                            default:
                                                this.j = "Unsupport fileDataType: " + ((int) this.p.i.c) + ",entryFileName=" + str;
                                                c(-31);
                                                return false;
                                        }
                                    } catch (java.io.UnsupportedEncodingException e4) {
                                        e4.printStackTrace();
                                        this.j = "UnsupportedEncodingException when get entryFileName";
                                        c(-1);
                                        return false;
                                    }
                                } catch (java.lang.Exception e5) {
                                    this.j = "getNextEntry64() failed " + e5.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e5);
                                    c(-15);
                                    e5.printStackTrace();
                                    return false;
                                }
                            }
                            if (!s()) {
                                return false;
                            }
                            this.q.b(2, com.unisound.client.SpeechConstants.ASR_OPT_GET_COMPILE_ERRORINFO);
                            com.tencent.yybsdk.apkpatch.f.a.a(this.c, "finish to write new apk except deflated file , cost:" + this.q.c(2, com.unisound.client.SpeechConstants.ASR_OPT_GET_COMPILE_ERRORINFO).c());
                            try {
                                if (this.p.l != null) {
                                    if (!this.b.M.equals("0")) {
                                        this.p.l.a();
                                    } else if (!this.p.l.a(500L, java.util.concurrent.TimeUnit.SECONDS)) {
                                        c(-58);
                                        return false;
                                    }
                                }
                                if (c()) {
                                    return false;
                                }
                                if (this.h != 0) {
                                    e();
                                    return false;
                                }
                                this.p.n.h();
                                if (!u()) {
                                    return false;
                                }
                                f();
                                com.tencent.yybsdk.apkpatch.f.a.b(this.c, "patch succeed");
                                x();
                                return true;
                            } catch (java.lang.InterruptedException e6) {
                                this.j = "deflateTaskExecutor.join() error:" + e6.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e6);
                                c(-1);
                                e6.printStackTrace();
                                return false;
                            }
                        } catch (java.io.IOException e7) {
                            e7.printStackTrace();
                            this.j = "new oldApk RafStream failed " + e7.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e7);
                            this.h = (e7.getMessage() != null && e7.getMessage().contains("base.apk") && e7.getMessage().contains("open failed")) ? -40 : -45;
                            c(this.h);
                            return false;
                        }
                    } catch (java.io.IOException e8) {
                        e8.printStackTrace();
                        this.j = "read diffFileLen error";
                        c(-1);
                        return false;
                    }
                } catch (java.lang.InterruptedException e9) {
                    e9.printStackTrace();
                    this.j = "wait for inflateTaskExecutor error" + e9.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e9);
                    c(-54);
                    return false;
                }
            } catch (java.io.IOException e10) {
                e10.printStackTrace();
                this.h = -53;
                this.j = "get compressRecord error" + e10.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e10);
                c(this.h);
                return false;
            }
        } catch (java.io.IOException e11) {
            e11.printStackTrace();
            this.h = -41;
            this.j = "get bsdiffRecord error" + e11.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e11);
            c(this.h);
            return false;
        }
    }

    private void i() {
        com.tencent.yybsdk.apkpatch.d.a.a().a(new com.tencent.yybsdk.apkpatch.l(this));
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0183  */
    /* JADX WARN: Code duplicated, block: B:55:0x0187  */
    private boolean j() throws java.lang.Throwable {
        java.lang.String str;
        java.lang.String str2;
        boolean z;
        com.tencent.yybsdk.apkpatch.v vVar;
        java.lang.String str3;
        java.lang.String str4;
        com.tencent.yybsdk.apkpatch.v vVarA = this.m.a(this.f1432a);
        if (vVarA != null) {
            short s = vVarA.d;
            if (s == 32) {
                if (vVarA.h > 0) {
                    java.io.File file = new java.io.File(this.o.b());
                    java.io.File file2 = new java.io.File(this.f1432a.b);
                    if (file2.exists() && file2.length() > 0 && file.exists()) {
                        long length = file.length();
                        long j = vVarA.i;
                        if (length >= j) {
                            com.tencent.yybsdk.apkpatch.v vVar2 = this.n;
                            vVar2.h = vVarA.h;
                            vVar2.i = j;
                            vVar2.e = vVarA.e;
                            this.b.E = this.n.h - 1;
                            str3 = this.c;
                            str4 = "loadLastPatchProgress success";
                            com.tencent.yybsdk.apkpatch.f.a.a(str3, str4);
                            z = true;
                        }
                    }
                    com.tencent.yybsdk.apkpatch.f.a.c(this.c, "last newApkFile.exists:" + file.exists() + " length:" + file.length() + " oldApkFile.exists:" + file2.exists() + " length:" + file2.length());
                }
                z = false;
            } else if (s != 64) {
                z = false;
            } else {
                int i = vVarA.g;
                if (i == 0) {
                    if (new java.io.File(this.o.c()).exists()) {
                        this.n.m = vVarA.m;
                        str3 = this.c;
                        str4 = "loadLastPatchProgress success,taskInfo:" + this.n;
                        com.tencent.yybsdk.apkpatch.f.a.a(str3, str4);
                        z = true;
                    }
                    str = this.c;
                    str2 = "load progress info failed,oldEntryFile is not existed";
                } else if (i == 1) {
                    if (new java.io.File(this.o.c()).exists()) {
                        this.n.g = vVarA.g;
                        if (new java.io.File(this.o.d()).exists()) {
                            vVar = this.n;
                            vVar.j = vVarA.j;
                            vVar.k = vVarA.k;
                            vVar.l = vVarA.l;
                            vVar.n = vVarA.n;
                        }
                        str3 = this.c;
                        str4 = "loadLastPatchProgress success,taskInfo:" + this.n;
                        com.tencent.yybsdk.apkpatch.f.a.a(str3, str4);
                        z = true;
                    }
                    str = this.c;
                    str2 = "load progress info failed,oldEntryFile is not existed";
                } else if (i != 2) {
                    if (i == 3) {
                        if (new java.io.File(this.o.b()).exists()) {
                            this.n.g = vVarA.g;
                        } else {
                            str = this.c;
                            str2 = "load progress info failed,newApkMergingFile is not existed";
                        }
                    }
                    str3 = this.c;
                    str4 = "loadLastPatchProgress success,taskInfo:" + this.n;
                    com.tencent.yybsdk.apkpatch.f.a.a(str3, str4);
                    z = true;
                } else if (new java.io.File(this.o.d()).exists()) {
                    this.n.g = vVarA.g;
                    if (new java.io.File(this.o.b()).exists()) {
                        vVar = this.n;
                        vVar.n = vVarA.n;
                    }
                    str3 = this.c;
                    str4 = "loadLastPatchProgress success,taskInfo:" + this.n;
                    com.tencent.yybsdk.apkpatch.f.a.a(str3, str4);
                    z = true;
                } else {
                    str = this.c;
                    str2 = "load progress info failed,newEntryFile is not existed";
                }
            }
            if (z) {
                this.b.V = 1;
            } else {
                x();
            }
            return z;
        }
        str = this.c;
        str2 = "no last patch progress info";
        com.tencent.yybsdk.apkpatch.f.a.a(str, str2);
        z = false;
        if (z) {
            x();
        } else {
            this.b.V = 1;
        }
        return z;
    }

    private void k() {
        this.m.b(this.f1432a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean l() {
        boolean z;
        try {
            if (this.m == null || this.n == null || this.p == null || this.p.f1436a == null || !this.m.a(this.n)) {
                z = false;
            } else {
                if (this.p != null && this.p.f1436a != null) {
                    this.p.f1436a.b();
                }
                if (this.n.d == 32) {
                    com.tencent.yybsdk.apkpatch.f.a.a(this.c, "savePatchProgress success, algorithm=" + ((int) this.n.d) + " successEntryCount:" + this.n.h + " successFilePosition:" + this.n.i);
                } else {
                    short s = this.n.d;
                }
                z = true;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            this.j = "savePatchProgress failed" + th.getClass().getName() + ": " + com.tencent.yybsdk.apkpatch.f.a.a(th);
            c(-57);
        }
        return z;
    }

    private boolean m() {
        long length = new java.io.File(this.f1432a.b).length();
        short s = this.f1432a.f;
        if (s == 32) {
            return ((float) com.tencent.yybsdk.apkpatch.f.a.b.b(this.f1432a.c)) > (((float) length) * 1.5f) - ((float) new java.io.File(this.o.b()).length());
        }
        if (s == 64) {
            return ((float) com.tencent.yybsdk.apkpatch.f.a.b.b(this.f1432a.c)) > (((((float) length) * 3.0f) - ((float) new java.io.File(this.o.b()).length())) - ((float) new java.io.File(this.o.c()).length())) - ((float) new java.io.File(this.o.d()).length());
        }
        return true;
    }

    private boolean n() throws java.lang.Throwable {
        this.p = new com.tencent.yybsdk.apkpatch.n();
        short s = this.f1432a.f;
        if (s == 32 || s == 64) {
            try {
                this.p.b = new com.tencent.yybsdk.apkpatch.b.b(new java.util.zip.GZIPInputStream(this.f1432a.d, 8192));
                this.p.c = new com.tencent.yybsdk.apkpatch.q(this.p.b);
            } catch (java.io.IOException e) {
                e.printStackTrace();
                this.j = "makeGzipIs falied:" + e.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e);
                c(-37);
                return false;
            }
        }
        try {
            this.p.f = this.p.c.e();
            this.b.K = this.p.f.c;
            this.b.q = this.p.f.o;
            this.b.r = this.p.f.p;
            int i = this.b.K;
            if (i == 32 || i == 64) {
                try {
                    this.p.g = this.p.c.f();
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                    this.j = "getPatchFlag() falied:" + e2.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e2);
                    c(-33);
                    return false;
                }
            }
            com.tencent.yybsdk.apkpatch.n nVar = this.p;
            if (nVar.f.c == 32) {
                try {
                    nVar.e = new com.tencent.yybsdk.apkpatch.g.a(this.f1432a.b);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                    this.j = "failed to decode oldApk: " + th.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(th);
                    if (th.getMessage() != null && th.getMessage().contains("base.apk") && th.getMessage().contains("open failed")) {
                        c(-40);
                    } else {
                        c(-4);
                    }
                    return false;
                }
            }
            if (this.p.f.c == 64) {
                this.q.a(2, com.unisound.client.SpeechConstants.ASR_OPT_ACTIVATE_TOKEN);
                try {
                    com.tencent.yybsdk.apkpatch.f.b.a(this.o.b(), this.p.f.n);
                    if (this.n.g < 1) {
                        com.tencent.yybsdk.apkpatch.f.b.a(this.o.c(), this.p.f.p);
                    }
                    this.q.b(2, com.unisound.client.SpeechConstants.ASR_OPT_ACTIVATE_TOKEN);
                    try {
                        this.p.n = new com.tencent.yybsdk.apkpatch.c.b(this.o);
                    } catch (java.lang.Throwable th2) {
                        th2.printStackTrace();
                        if ((th2 instanceof java.io.FileNotFoundException) && th2.getMessage().contains("base.apk")) {
                            c(-40);
                        } else {
                            this.j = "failed to new IOPool: " + th2.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(th2);
                            c(-56);
                        }
                        return false;
                    }
                } catch (java.io.IOException e3) {
                    c(-55);
                    this.j = "failed to create temp file: " + e3.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e3);
                    return false;
                }
            }
            try {
                this.p.f1436a = new com.tencent.yybsdk.apkpatch.b(this.o.b());
            } catch (java.io.FileNotFoundException e4) {
                e4.printStackTrace();
                this.j = "new ApkOutputStream(mergingApkPath) falied, mergingApkPath = " + this.o.b();
                c(-3);
            }
            this.p.o = true;
            return true;
        } catch (java.io.IOException e5) {
            e5.printStackTrace();
            this.j = "getPatchFileHeader() falied:" + e5.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e5);
            c(-5);
            return false;
        }
    }

    private void o() {
        com.tencent.yybsdk.apkpatch.n nVar = this.p;
        if (nVar != null) {
            com.tencent.yybsdk.apkpatch.b bVar = nVar.f1436a;
            if (bVar != null) {
                try {
                    bVar.close();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                this.p.f1436a = null;
            }
            com.tencent.yybsdk.apkpatch.q qVar = this.p.c;
            if (qVar != null) {
                try {
                    qVar.close();
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
                this.p.c = null;
            }
            com.tencent.yybsdk.apkpatch.g.a aVar = this.p.e;
            if (aVar != null) {
                try {
                    aVar.c();
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                }
                this.p.e = null;
            }
            com.tencent.yybsdk.apkpatch.a.b bVar2 = this.p.d;
            if (bVar2 != null) {
                try {
                    bVar2.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
                this.p.d = null;
            }
            com.tencent.yybsdk.apkpatch.c.g gVar = this.p.l;
            if (gVar != null && !gVar.isShutdown()) {
                this.p.l.shutdown();
            }
            com.tencent.yybsdk.apkpatch.c.b bVar3 = this.p.n;
            if (bVar3 != null) {
                bVar3.i();
            }
            this.k = null;
            this.l = null;
        }
    }

    private boolean p() {
        int i;
        com.tencent.yybsdk.apkpatch.h hVar = this.p.f;
        if (hVar.f1430a != 61680) {
            this.j = "patch file signature wrong, pfh.signature = " + this.p.f.f1430a + " HEADSIGNATURE: 61680";
            i = -6;
        } else if (hVar.b > 3) {
            this.j = "patch file version not support, pfh.versionCode = " + this.p.f.b;
            i = -7;
        } else {
            if ((hVar.c & 96) != 0) {
                com.tencent.yybsdk.apkpatch.f.a.a(this.c, "patchAlorithms: " + this.p.f.c);
                return true;
            }
            this.j = "patchAlorithms not support: " + this.p.f.c;
            i = -8;
        }
        c(i);
        return false;
    }

    private boolean q() {
        java.lang.String str;
        java.io.File file = new java.io.File(this.o.b());
        com.tencent.yybsdk.apkpatch.n nVar = this.p;
        if (nVar == null || !nVar.o || file.exists() || file.length() > 0) {
            java.io.File file2 = new java.io.File(this.f1432a.d.b());
            if (file2.exists() || file2.length() > 0) {
                return true;
            }
            str = "patch not exists:" + this.f1432a.d.b + "," + this.i + "," + this.f + "," + this.e + "," + this.j;
        } else {
            str = "newApkFile.exists(): " + file.exists() + " length: " + file.length() + " " + this.o.b();
        }
        this.j = str;
        return false;
    }

    private boolean r() {
        try {
            if (this.n.g >= 1) {
                for (int i = 0; i < this.p.f.o; i++) {
                    this.p.l.c();
                }
                com.tencent.yybsdk.apkpatch.f.a.a(this.c, "assembleOldData has been done,skip it");
                return true;
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.p.f.o) {
                com.tencent.yybsdk.apkpatch.d dVar = (com.tencent.yybsdk.apkpatch.d) this.p.j.get(i2);
                i2++;
                if (i2 > this.n.m) {
                    com.tencent.yybsdk.apkpatch.c.c cVar = new com.tencent.yybsdk.apkpatch.c.c(dVar.f1403a, i3, dVar.d, dVar.b, dVar.c);
                    cVar.a(this.p.n);
                    cVar.a(this.r);
                    this.p.l.execute(cVar);
                } else {
                    this.p.l.c();
                }
                i3 += dVar.c;
            }
            return true;
        } catch (java.lang.Throwable th) {
            if (!(th instanceof java.util.concurrent.RejectedExecutionException)) {
                th.printStackTrace();
                this.j = "assemble old data failed:" + th.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(th);
                c(-42);
            }
            return false;
        }
    }

    private boolean s() {
        while (true) {
            try {
                int i = this.p.c.read(this.k);
                if (i <= 0) {
                    return true;
                }
                this.l.clear();
                this.l.limit(i);
                this.p.f1436a.a(this.l);
            } catch (java.lang.Exception e) {
                if (c()) {
                    return false;
                }
                e.printStackTrace();
                this.j = "mergeCdfhAndEocd64 falied," + e.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e);
                c(-36);
                return false;
            }
        }
    }

    private boolean t() {
        while (true) {
            try {
                int i = this.p.c.read(this.k);
                if (i <= 0) {
                    return true;
                }
                this.l.clear();
                this.l.limit(i);
                this.p.f1436a.a(this.l);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                this.j = "mergeCdfhAndEocdNew falied," + e.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e);
                c(-36);
                return false;
            }
        }
    }

    private boolean u() {
        int i = -21;
        try {
            this.p.f1436a.b();
            i = -22;
            this.p.f1436a.close();
            this.p.f1436a = null;
            for (int i2 = 0; i2 < 4 && !com.tencent.yybsdk.apkpatch.f.b.a(this.o.b(), this.f1432a.c); i2++) {
                if (i2 == 3) {
                    this.j = "finishMerge - rename failed";
                    c(-23);
                    return false;
                }
            }
            return true;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            this.j = "finishMerge falied," + e.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e);
            c(i);
            return false;
        }
    }

    private boolean v() {
        int i = -24;
        try {
            if (this.p.h.c == 1 || this.p.h.c == 3 || this.p.h.c == 4) {
                this.p.c.h();
            }
            if (this.p.c.i() == this.n.h) {
                i = -26;
                if (this.n.i > 0) {
                    this.p.f1436a.a((int) this.n.i);
                }
            }
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            this.j = "skipLastPatchEntryV2 failed: " + e.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(e);
            c(i);
            return false;
        }
    }

    private synchronized void w() {
        this.n.i = this.p.f1436a.a();
        this.n.h = this.p.c.i();
    }

    private void x() {
        com.tencent.yybsdk.apkpatch.f.b.a(this.o.c());
        com.tencent.yybsdk.apkpatch.f.b.a(this.o.d());
        com.tencent.yybsdk.apkpatch.f.b.a(this.o.b());
    }

    public void a() {
        this.d.a(this.f1432a, this.n.e, this.h, this.j);
    }

    public void a(int i) {
        this.n.e = i;
    }

    public int[] a(java.util.List list) {
        int[] iArr = new int[list.size()];
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            i += ((com.tencent.yybsdk.apkpatch.e) list.get(i2)).c;
            iArr[i2] = i;
        }
        return iArr;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00bc A[Catch: all -> 0x0132, TryCatch #1 {all -> 0x0132, blocks: (B:31:0x00b6, B:33:0x00bc, B:34:0x00c5, B:36:0x00c9, B:37:0x00e3, B:39:0x00e7, B:41:0x00f2, B:43:0x00f8, B:44:0x00ff, B:45:0x0108, B:47:0x0110, B:49:0x011a, B:55:0x012b, B:50:0x011e, B:52:0x0122, B:54:0x0128), top: B:149:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00c5 A[Catch: all -> 0x0132, TryCatch #1 {all -> 0x0132, blocks: (B:31:0x00b6, B:33:0x00bc, B:34:0x00c5, B:36:0x00c9, B:37:0x00e3, B:39:0x00e7, B:41:0x00f2, B:43:0x00f8, B:44:0x00ff, B:45:0x0108, B:47:0x0110, B:49:0x011a, B:55:0x012b, B:50:0x011e, B:52:0x0122, B:54:0x0128), top: B:149:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00c9 A[Catch: all -> 0x0132, TryCatch #1 {all -> 0x0132, blocks: (B:31:0x00b6, B:33:0x00bc, B:34:0x00c5, B:36:0x00c9, B:37:0x00e3, B:39:0x00e7, B:41:0x00f2, B:43:0x00f8, B:44:0x00ff, B:45:0x0108, B:47:0x0110, B:49:0x011a, B:55:0x012b, B:50:0x011e, B:52:0x0122, B:54:0x0128), top: B:149:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00e3 A[Catch: all -> 0x0132, TryCatch #1 {all -> 0x0132, blocks: (B:31:0x00b6, B:33:0x00bc, B:34:0x00c5, B:36:0x00c9, B:37:0x00e3, B:39:0x00e7, B:41:0x00f2, B:43:0x00f8, B:44:0x00ff, B:45:0x0108, B:47:0x0110, B:49:0x011a, B:55:0x012b, B:50:0x011e, B:52:0x0122, B:54:0x0128), top: B:149:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e7 A[Catch: all -> 0x0132, TryCatch #1 {all -> 0x0132, blocks: (B:31:0x00b6, B:33:0x00bc, B:34:0x00c5, B:36:0x00c9, B:37:0x00e3, B:39:0x00e7, B:41:0x00f2, B:43:0x00f8, B:44:0x00ff, B:45:0x0108, B:47:0x0110, B:49:0x011a, B:55:0x012b, B:50:0x011e, B:52:0x0122, B:54:0x0128), top: B:149:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0108 A[Catch: all -> 0x0132, TryCatch #1 {all -> 0x0132, blocks: (B:31:0x00b6, B:33:0x00bc, B:34:0x00c5, B:36:0x00c9, B:37:0x00e3, B:39:0x00e7, B:41:0x00f2, B:43:0x00f8, B:44:0x00ff, B:45:0x0108, B:47:0x0110, B:49:0x011a, B:55:0x012b, B:50:0x011e, B:52:0x0122, B:54:0x0128), top: B:149:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x011e A[Catch: all -> 0x0132, TryCatch #1 {all -> 0x0132, blocks: (B:31:0x00b6, B:33:0x00bc, B:34:0x00c5, B:36:0x00c9, B:37:0x00e3, B:39:0x00e7, B:41:0x00f2, B:43:0x00f8, B:44:0x00ff, B:45:0x0108, B:47:0x0110, B:49:0x011a, B:55:0x012b, B:50:0x011e, B:52:0x0122, B:54:0x0128), top: B:149:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0122 A[Catch: all -> 0x0132, TryCatch #1 {all -> 0x0132, blocks: (B:31:0x00b6, B:33:0x00bc, B:34:0x00c5, B:36:0x00c9, B:37:0x00e3, B:39:0x00e7, B:41:0x00f2, B:43:0x00f8, B:44:0x00ff, B:45:0x0108, B:47:0x0110, B:49:0x011a, B:55:0x012b, B:50:0x011e, B:52:0x0122, B:54:0x0128), top: B:149:0x00b6 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public java.lang.Integer call() {
        java.lang.String str;
        java.lang.StringBuilder sb;
        java.lang.String str2;
        java.lang.String str3;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        this.i = 0;
        try {
            try {
                com.tencent.yybsdk.apkpatch.f.a.a(this.c, "start patching");
                a(2);
                a();
                try {
                    try {
                        if (!this.f) {
                            if (this.e) {
                                str2 = this.c;
                                str3 = "pausing";
                            } else {
                                this.q.a(2);
                                this.i = 1;
                                if (m()) {
                                    this.i = 2;
                                    if (!j()) {
                                        k();
                                    }
                                    this.i = 3;
                                    if (!n()) {
                                        str = this.c;
                                        sb = new java.lang.StringBuilder();
                                        sb.append("apkPatchInfoInit() = false, ");
                                        sb.append(this.j);
                                    } else if (p()) {
                                        this.i = 4;
                                        if (this.p.f.c == 32) {
                                            g();
                                        } else if (this.p.f.c == 64) {
                                            h();
                                        } else {
                                            int i = this.p.f.c;
                                        }
                                    } else {
                                        str = this.c;
                                        sb = new java.lang.StringBuilder();
                                        sb.append("apkPatchInfoCheck() = false, ");
                                        sb.append(this.j);
                                    }
                                    com.tencent.yybsdk.apkpatch.f.a.d(str, sb.toString());
                                } else {
                                    com.tencent.yybsdk.apkpatch.f.a.c(this.c, "isEnoughFreeSpace() == false");
                                    c(-2);
                                }
                            }
                            if (this.n.e == 7) {
                                this.m.b(this.f1432a);
                            } else if (this.f) {
                                this.m.b(this.f1432a);
                                com.tencent.yybsdk.apkpatch.f.b.a(this.o.b());
                                x();
                                this.h = 1;
                                a(6);
                            } else if (this.e) {
                                com.tencent.yybsdk.apkpatch.f.a.a(this.c, "finally,join");
                                if (this.p != null && this.p.l != null) {
                                    this.p.l.b();
                                }
                                l();
                                this.h = 2;
                                a(4);
                            } else {
                                if (android.text.TextUtils.isEmpty(this.j) && this.j.contains("No space")) {
                                    c(-59);
                                } else if (this.h != -2 && !q()) {
                                    c(-39);
                                }
                                x();
                                k();
                            }
                            this.q.b(2);
                            com.tencent.yybsdk.apkpatch.d.a.a().a(new com.tencent.yybsdk.apkpatch.o(this, this.p));
                            o();
                            com.tencent.yybsdk.apkpatch.f.a.b(this.c, "[patch finished] cost: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + " status = " + this.n.e + " errCode = " + this.h + " errMsg = " + this.j);
                            return java.lang.Integer.valueOf(this.n.e);
                        }
                        str2 = this.c;
                        str3 = "canceling";
                        this.q.b(2);
                        com.tencent.yybsdk.apkpatch.d.a.a().a(new com.tencent.yybsdk.apkpatch.o(this, this.p));
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                    if (this.n.e == 7) {
                        this.m.b(this.f1432a);
                    } else if (this.f) {
                        this.m.b(this.f1432a);
                        com.tencent.yybsdk.apkpatch.f.b.a(this.o.b());
                        x();
                        this.h = 1;
                        a(6);
                    } else if (this.e) {
                        com.tencent.yybsdk.apkpatch.f.a.a(this.c, "finally,join");
                        if (this.p != null) {
                            this.p.l.b();
                        }
                        l();
                        this.h = 2;
                        a(4);
                    } else {
                        if (android.text.TextUtils.isEmpty(this.j)) {
                            if (this.h != -2) {
                                c(-39);
                            }
                        } else if (this.h != -2) {
                            c(-39);
                        }
                        x();
                        k();
                    }
                } catch (java.lang.Throwable th2) {
                    com.tencent.yybsdk.apkpatch.f.a.d(this.c, th2.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(th2));
                    th2.printStackTrace();
                }
                com.tencent.yybsdk.apkpatch.f.a.a(str2, str3);
            } catch (java.lang.Throwable th3) {
                try {
                    th3.printStackTrace();
                    if (th3.getMessage().contains("No space")) {
                        c(-59);
                    } else {
                        c(-1);
                    }
                    this.j = "proCode = " + this.i + " pause = " + this.e + " cancel = " + this.f + " status: " + this.n.e + " " + th3.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(th3);
                    try {
                        if (this.n.e == 7) {
                            this.m.b(this.f1432a);
                        } else if (this.f) {
                            this.m.b(this.f1432a);
                            com.tencent.yybsdk.apkpatch.f.b.a(this.o.b());
                            x();
                            this.h = 1;
                            a(6);
                        } else if (this.e) {
                            com.tencent.yybsdk.apkpatch.f.a.a(this.c, "finally,join");
                            if (this.p != null && this.p.l != null) {
                                this.p.l.b();
                            }
                            l();
                            this.h = 2;
                            a(4);
                        } else {
                            if (!android.text.TextUtils.isEmpty(this.j) && this.j.contains("No space")) {
                                c(-59);
                            } else if (this.h != -2 && !q()) {
                                c(-39);
                            }
                            x();
                            k();
                        }
                    } catch (java.lang.Throwable th4) {
                        com.tencent.yybsdk.apkpatch.f.a.d(this.c, th4.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(th4));
                        th4.printStackTrace();
                    }
                    try {
                        this.q.b(2);
                        com.tencent.yybsdk.apkpatch.d.a.a().a(new com.tencent.yybsdk.apkpatch.o(this, this.p));
                    } catch (java.lang.Throwable th5) {
                        th5.printStackTrace();
                    }
                } catch (java.lang.Throwable th6) {
                    try {
                        if (this.n.e == 7) {
                            this.m.b(this.f1432a);
                        } else if (this.f) {
                            this.m.b(this.f1432a);
                            com.tencent.yybsdk.apkpatch.f.b.a(this.o.b());
                            x();
                            this.h = 1;
                            a(6);
                        } else if (this.e) {
                            com.tencent.yybsdk.apkpatch.f.a.a(this.c, "finally,join");
                            if (this.p != null && this.p.l != null) {
                                this.p.l.b();
                            }
                            l();
                            this.h = 2;
                            a(4);
                        } else {
                            if (!android.text.TextUtils.isEmpty(this.j) && this.j.contains("No space")) {
                                c(-59);
                            } else if (this.h != -2 && !q()) {
                                c(-39);
                            }
                            x();
                            k();
                        }
                    } catch (java.lang.Throwable th7) {
                        com.tencent.yybsdk.apkpatch.f.a.d(this.c, th7.getClass().getName() + " " + com.tencent.yybsdk.apkpatch.f.a.a(th7));
                        th7.printStackTrace();
                    }
                    try {
                        this.q.b(2);
                        com.tencent.yybsdk.apkpatch.d.a.a().a(new com.tencent.yybsdk.apkpatch.o(this, this.p));
                    } catch (java.lang.Throwable th8) {
                        th8.printStackTrace();
                    }
                    try {
                        o();
                        throw th6;
                    } catch (java.lang.Throwable th9) {
                        th9.printStackTrace();
                        throw th6;
                    }
                }
            }
            o();
        } catch (java.lang.Throwable th10) {
            th10.printStackTrace();
        }
        com.tencent.yybsdk.apkpatch.f.a.b(this.c, "[patch finished] cost: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + " status = " + this.n.e + " errCode = " + this.h + " errMsg = " + this.j);
        return java.lang.Integer.valueOf(this.n.e);
    }

    public void b(int i) {
        if (this.g) {
            return;
        }
        this.b.N = i;
        com.tencent.yybsdk.apkpatch.f.a.a(this.c + "-PatchingTask", "setPatchingTaskCount:" + i);
    }

    public boolean c() {
        return this.e || this.f;
    }

    public void d() {
        com.tencent.yybsdk.apkpatch.bsdiff.a aVar;
        com.tencent.yybsdk.apkpatch.c.g gVar;
        com.tencent.yybsdk.apkpatch.f.a.a(this.c, "pause");
        if (c()) {
            com.tencent.yybsdk.apkpatch.f.a.b(this.c, "ignore pause, stop request is running, status: " + this.n.e);
            return;
        }
        this.e = true;
        a(3);
        a();
        com.tencent.yybsdk.apkpatch.n nVar = this.p;
        if (nVar != null && (gVar = nVar.l) != null) {
            gVar.shutdown();
        }
        com.tencent.yybsdk.apkpatch.n nVar2 = this.p;
        if (nVar2 != null && (aVar = nVar2.m) != null) {
            aVar.a();
        }
        try {
            this.f1432a.d.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            com.tencent.yybsdk.apkpatch.f.a.c(this.c, "pause, task.patchInputStream close failed");
        }
        try {
            if (this.p == null || this.p.e == null) {
                return;
            }
            this.p.e.c();
            this.p.e = null;
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            com.tencent.yybsdk.apkpatch.f.a.c(this.c, "pause, apkPatchInfo.oldApk close failed");
        }
    }
}
