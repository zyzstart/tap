package com.tencent.hlyyb.downloader.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class j implements com.tencent.hlyyb.downloader.e.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.tencent.hlyyb.downloader.e.b.c f635a;
    com.tencent.hlyyb.downloader.e.b.c b;
    private /* synthetic */ com.tencent.hlyyb.downloader.e.h c;

    private j(com.tencent.hlyyb.downloader.e.h hVar) {
        this.c = hVar;
    }

    /* synthetic */ j(com.tencent.hlyyb.downloader.e.h hVar, byte b) {
        this(hVar);
    }

    private void a(long j, com.tencent.hlyyb.common.f.b bVar) {
        bVar.f595a = -10;
        bVar.b = "knownSize:" + this.c.f + ",rspLength:" + j;
    }

    private void a(com.tencent.hlyyb.downloader.e.b.c cVar, long j, boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.tencent.hlyyb.common.f.b bVar) {
        com.tencent.hlyyb.downloader.e.h hVar = this.c;
        hVar.g = j;
        hVar.k = z;
        hVar.l = str3;
        hVar.m = str4;
        com.tencent.hlyyb.downloader.e.d.a aVar = cVar.b;
        if (aVar != null) {
            hVar.z = aVar.c;
        }
        if (!this.c.k) {
            this.c.M = new com.tencent.hlyyb.downloader.e.g("");
            cVar.f619a = this.c.M.a();
        } else if (this.c.M.f633a > 0) {
            if (this.c.M.f633a != this.c.g) {
                this.c.M = new com.tencent.hlyyb.downloader.e.g("");
                bVar.f595a = 3;
                bVar.b = "can not resume from cfg, start over now";
            }
        }
        this.c.M.f633a = j;
        this.c.M.a(str);
        this.c.M.b(str2);
        com.tencent.hlyyb.downloader.e.b.a aVar2 = cVar.f619a;
        if (aVar2.c == -1 && aVar2.b == -1) {
            this.c.M.b(cVar.f619a);
        }
    }

    private void a(com.tencent.hlyyb.downloader.e.d.a aVar, long j, com.tencent.hlyyb.common.f.b bVar) {
        java.lang.StringBuilder sb;
        if (aVar.b == com.tencent.hlyyb.downloader.e.d.b.j) {
            bVar.f595a = -76;
            sb = new java.lang.StringBuilder("sche size:");
        } else {
            bVar.f595a = -73;
            sb = new java.lang.StringBuilder("sche size:");
        }
        sb.append(this.c.E.a());
        sb.append(",rsp size:");
        sb.append(j);
        bVar.b = sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00d2 A[Catch: all -> 0x01b6, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x0012, B:8:0x001b, B:11:0x0027, B:13:0x002b, B:18:0x0034, B:23:0x0042, B:25:0x0051, B:31:0x0064, B:33:0x006e, B:35:0x0074, B:40:0x007e, B:52:0x00b1, B:56:0x00e8, B:58:0x00ec, B:60:0x00f4, B:62:0x00fc, B:63:0x0109, B:77:0x0168, B:79:0x016c, B:81:0x0172, B:83:0x0178, B:86:0x017d, B:88:0x0181, B:89:0x0191, B:55:0x00d2, B:45:0x008b, B:47:0x0095, B:49:0x009f, B:51:0x00ad, B:54:0x00b7, B:64:0x0115, B:66:0x011e, B:68:0x012c, B:69:0x0130, B:71:0x0138, B:72:0x013c, B:73:0x015a, B:74:0x015d, B:76:0x0163, B:93:0x01a4, B:96:0x01ac), top: B:103:0x000b }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.hlyyb.downloader.e.b.b
    public final synchronized com.tencent.hlyyb.common.f.b a(com.tencent.hlyyb.downloader.e.b.c cVar, com.tencent.hlyyb.downloader.e.d.a aVar, java.lang.String str, long j, boolean z, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        com.tencent.hlyyb.common.f.b bVar;
        java.lang.String str6;
        boolean z2;
        boolean z3 = true;
        if (this.c.C) {
            com.tencent.hlyyb.common.a.f.e();
            if (com.tencent.hlyyb.common.a.f.g()) {
                this.c.pause();
                this.c.D = true;
            }
        }
        if ((cVar != null && (cVar == this.f635a || cVar == this.b)) && !cVar.a() && j > 0) {
            com.tencent.hlyyb.common.f.b bVar2 = new com.tencent.hlyyb.common.f.b(0, "");
            if (this.c.M != null) {
                if (cVar.f619a.i == this.c.M) {
                    if (this.c.g == -1) {
                        com.tencent.hlyyb.downloader.e.h hVar = this.c;
                        if (hVar.B && hVar.ak) {
                            z3 = false;
                        }
                        if (z3) {
                            long j2 = this.c.f;
                            if (j2 <= 0 || j == j2) {
                                z2 = false;
                                bVar = bVar2;
                                a(cVar, j, z, str2, str3, str4, str5, bVar2);
                            } else {
                                a(j, bVar2);
                                bVar = bVar2;
                                z2 = false;
                            }
                        } else if (this.c.ao == -1) {
                            z2 = false;
                            bVar = bVar2;
                            a(cVar, j, z, str2, str3, str4, str5, bVar2);
                        } else if (j != this.c.ao) {
                            if (this.c.E.a() > 0) {
                                a(aVar, j, bVar2);
                            } else {
                                a(j, bVar2);
                            }
                            bVar = bVar2;
                            z2 = false;
                        } else {
                            bVar = bVar2;
                            z2 = false;
                            a(cVar, this.c.ao, z, str2, str3, str4, str5, bVar);
                        }
                        if (bVar.f595a == 0) {
                            if (!this.c.ac && !this.c.A()) {
                                com.tencent.hlyyb.downloader.e.h hVar2 = this.c;
                                hVar2.a(z2, hVar2.r, this.c.s, com.tencent.hlyyb.downloader.DownloaderTaskStatus.FAILED);
                            }
                            this.c.T.a(com.tencent.hlyyb.downloader.e.e.Inform_Detected);
                        }
                    } else {
                        bVar = bVar2;
                        if (j != this.c.g) {
                            if (this.c.E.a() > 0) {
                                a(aVar, j, bVar);
                            } else if (this.c.f > 0) {
                                a(j, bVar);
                            } else {
                                bVar.f595a = -43;
                                str6 = "detectLength:" + this.c.g + ",rspLength:" + j;
                                bVar.b = str6;
                            }
                        } else if (!this.c.k) {
                            bVar.f595a = 1;
                            str6 = "not support range";
                            bVar.b = str6;
                        }
                    }
                    if (bVar.f595a == 0 && !android.text.TextUtils.isEmpty(str)) {
                        int i = aVar.b;
                        if (i == com.tencent.hlyyb.downloader.e.d.b.b || i == com.tencent.hlyyb.downloader.e.d.b.f627a) {
                            this.c.E.a(com.tencent.hlyyb.common.a.f.b(), str);
                        } else if (i == com.tencent.hlyyb.downloader.e.d.b.g) {
                            this.c.E.b(com.tencent.hlyyb.common.a.f.b(), str);
                        }
                    }
                    return bVar;
                }
            }
            bVar2.f595a = 2;
            bVar2.b = "not the same divider";
            return bVar2;
        }
        return new com.tencent.hlyyb.common.f.b(4, "");
    }

    @Override // com.tencent.hlyyb.downloader.e.b.b
    public final com.tencent.hlyyb.downloader.e.b.a a(com.tencent.hlyyb.downloader.e.b.c cVar) {
        if ((cVar != null && (cVar == this.f635a || cVar == this.b)) && this.c.k) {
            return this.c.M.a();
        }
        return null;
    }

    @Override // com.tencent.hlyyb.downloader.e.b.b
    public final boolean a() {
        return this.c.g != -1;
    }

    @Override // com.tencent.hlyyb.downloader.e.b.b
    public final boolean a(com.tencent.hlyyb.downloader.e.b.c cVar, long j, byte[] bArr, int i, boolean z) {
        if (!(cVar != null && (cVar == this.f635a || cVar == this.b))) {
            return false;
        }
        if (i > 0) {
            long j2 = i;
            this.c.o.addAndGet(j2);
            this.c.p.addAndGet(j2);
        }
        if (this.c.M != null) {
            if (cVar.f619a.i == this.c.M) {
                if (z && cVar.f619a.b == -1 && !this.c.M.b(cVar.f619a)) {
                    return false;
                }
                if (i > 0 && !this.c.isPaused()) {
                    try {
                        long j3 = i;
                        this.c.N.a(cVar.f619a.b, j, bArr, j3);
                        cVar.f619a.f += j3;
                        com.tencent.hlyyb.downloader.e.g gVar = this.c.M;
                        long jF = gVar.f();
                        if (jF > 0 && jF == gVar.f633a) {
                            this.c.V.b();
                            com.tencent.hlyyb.downloader.c.b.a().b();
                        }
                        if (com.tencent.hlyyb.downloader.c.b.a().f() > 4194304) {
                            com.tencent.hlyyb.downloader.e.h.a(this.c, true);
                            com.tencent.hlyyb.downloader.c.b.a().b();
                            try {
                                com.tencent.hlyyb.downloader.e.h.b(this.c, true);
                                synchronized (this.c.Z) {
                                    this.c.Z.wait(com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.HIDE_BUBBLE_TASK_DELAY);
                                }
                            } catch (java.lang.Exception unused) {
                            }
                        }
                    } catch (java.lang.OutOfMemoryError e) {
                        e.printStackTrace();
                        this.c.a(false, -19, "append size:" + i + ",buffer size:" + com.tencent.hlyyb.downloader.c.b.a().f(), com.tencent.hlyyb.downloader.DownloaderTaskStatus.FAILED);
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final synchronized com.tencent.hlyyb.common.f.b b() {
        com.tencent.hlyyb.common.f.b bVar;
        try {
            this.c.au = android.os.SystemClock.elapsedRealtime();
            bVar = new com.tencent.hlyyb.common.f.b(0, "");
            com.tencent.hlyyb.downloader.e.d.c cVar = this.c.E;
            com.tencent.hlyyb.downloader.e.h hVar = this.c;
            com.tencent.hlyyb.downloader.e.b.c cVar2 = new com.tencent.hlyyb.downloader.e.b.c(cVar, true, hVar, this, hVar.e, hVar.B);
            this.f635a = cVar2;
            try {
                cVar2.a(this.c.al, this.c.am, this.c.an, this.c, this.c.ap, this.c.aq, this.c.au);
                com.tencent.hlyyb.downloader.f.a.a().a(this.f635a);
            } catch (java.lang.Exception e) {
                this.f635a = null;
                bVar.f595a = -67;
                e.printStackTrace();
            }
            if (bVar.f595a == 0 && !this.c.isEaseTask() && this.c.ak) {
                com.tencent.hlyyb.downloader.e.d.c cVar3 = this.c.E;
                com.tencent.hlyyb.downloader.e.h hVar2 = this.c;
                com.tencent.hlyyb.downloader.e.b.c cVar4 = new com.tencent.hlyyb.downloader.e.b.c(cVar3, false, hVar2, this, hVar2.e, hVar2.B);
                this.b = cVar4;
                try {
                    cVar4.a(this.c.al, this.c.am, this.c.an, this.c, this.c.ap, this.c.aq, this.c.au);
                    com.tencent.hlyyb.downloader.f.a.a().b(this.b);
                } catch (java.lang.Exception unused) {
                    this.b = null;
                }
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
        return bVar;
    }

    @Override // com.tencent.hlyyb.downloader.e.b.b
    public final void b(com.tencent.hlyyb.downloader.e.b.c cVar) {
        com.tencent.hlyyb.downloader.e.b.a aVar;
        if ((cVar != null && (cVar == this.f635a || cVar == this.b)) && (aVar = cVar.f619a) != null) {
            aVar.h = false;
        }
    }

    @Override // com.tencent.hlyyb.downloader.e.b.b
    public final void c(com.tencent.hlyyb.downloader.e.b.c cVar) {
        boolean z;
        if (cVar != null && (cVar == this.f635a || cVar == this.b)) {
            synchronized (this.c.ad) {
                z = (this.f635a == null || this.f635a.g()) && (!this.c.B || this.b == null || this.b.g());
            }
            if (!z || this.c.S) {
                return;
            }
            com.tencent.hlyyb.downloader.e.g gVar = this.c.M;
            long jF = gVar.f();
            if (jF > 0 && jF == gVar.f633a) {
                return;
            }
            this.c.r = cVar.c();
            this.c.s = cVar.d();
            if (this.c.r == 0) {
                com.tencent.hlyyb.downloader.e.h hVar = this.c;
                hVar.r = -69;
                hVar.s = "readLen:" + this.c.M.f();
            }
            this.c.T.a(com.tencent.hlyyb.downloader.DownloaderTaskStatus.FAILED);
        }
    }
}
