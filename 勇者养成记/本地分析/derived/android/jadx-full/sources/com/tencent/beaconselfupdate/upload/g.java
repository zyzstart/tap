package com.tencent.beaconselfupdate.upload;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class g implements com.tencent.beaconselfupdate.upload.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.beaconselfupdate.upload.g f273a;
    private com.tencent.beaconselfupdate.upload.d d;
    private android.content.Context e;
    private boolean f;
    private android.util.SparseArray b = new android.util.SparseArray(5);
    private java.util.List c = new java.util.ArrayList(5);
    private boolean g = true;

    private g(android.content.Context context, boolean z) {
        this.e = null;
        this.f = true;
        android.content.Context applicationContext = context != null ? context.getApplicationContext() : null;
        if (applicationContext != null) {
            this.e = applicationContext;
        } else {
            this.e = context;
        }
        this.f = z;
        this.d = com.tencent.beaconselfupdate.upload.d.a(this.e);
    }

    private static com.tencent.beaconselfupdate.b.a.c a(byte[] bArr) {
        byte[] bArrB;
        if (bArr != null) {
            try {
                com.tencent.beaconselfupdate.a.b.d dVarA = com.tencent.beaconselfupdate.a.b.d.a();
                if (dVarA != null) {
                    bArrB = com.tencent.beaconselfupdate.a.e.b(bArr, dVarA.i(), dVarA.h(), dVarA.k());
                } else {
                    bArrB = null;
                }
                if (bArrB != null) {
                    com.tencent.beaconselfupdate.d.d dVar = new com.tencent.beaconselfupdate.d.d();
                    dVar.a(bArrB);
                    com.tencent.beaconselfupdate.b.a.c cVar = new com.tencent.beaconselfupdate.b.a.c();
                    com.tencent.beaconselfupdate.c.a.b(" covert to ResponsePackage ", new java.lang.Object[0]);
                    return (com.tencent.beaconselfupdate.b.a.c) dVar.b(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL, cVar);
                }
            } catch (java.lang.Throwable th) {
                com.tencent.beaconselfupdate.c.a.a(th);
            }
        }
        return null;
    }

    public static synchronized com.tencent.beaconselfupdate.upload.g a(android.content.Context context) {
        if (f273a == null) {
            f273a = new com.tencent.beaconselfupdate.upload.g(context, true);
            com.tencent.beaconselfupdate.c.a.h(" create uphandler up:true", new java.lang.Object[0]);
        }
        return f273a;
    }

    public static synchronized com.tencent.beaconselfupdate.upload.g a(android.content.Context context, boolean z) {
        if (f273a == null) {
            f273a = new com.tencent.beaconselfupdate.upload.g(context, z);
            com.tencent.beaconselfupdate.c.a.h(" create uphandler up: %b", java.lang.Boolean.valueOf(z));
        }
        com.tencent.beaconselfupdate.upload.g gVar = f273a;
        if (gVar.f != z) {
            gVar.f = z;
            com.tencent.beaconselfupdate.c.a.h(" change uphandler up: %b", java.lang.Boolean.valueOf(z));
        }
        return f273a;
    }

    private void a(int i, int i2, boolean z, java.lang.String str) {
        com.tencent.beaconselfupdate.upload.UploadHandleListener[] uploadHandleListenerArrC = c();
        if (uploadHandleListenerArrC != null) {
            for (com.tencent.beaconselfupdate.upload.UploadHandleListener uploadHandleListener : uploadHandleListenerArrC) {
                uploadHandleListener.onUploadEnd(i, i2, 0L, 0L, z, str);
            }
        }
    }

    private static boolean a(android.util.SparseArray sparseArray, int i, byte[] bArr) {
        if (sparseArray == null || bArr == null || i == 103) {
            return true;
        }
        com.tencent.beaconselfupdate.upload.e eVar = (com.tencent.beaconselfupdate.upload.e) sparseArray.get(i);
        if (eVar == null) {
            com.tencent.beaconselfupdate.c.a.c(" no handler key:%d", java.lang.Integer.valueOf(i));
            return false;
        }
        try {
            com.tencent.beaconselfupdate.c.a.b(" key:%d  handler: %s", java.lang.Integer.valueOf(i), eVar.getClass().toString());
            eVar.a(i, bArr, true);
            return true;
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.a(th);
            com.tencent.beaconselfupdate.c.a.d(" handle error key:%d", java.lang.Integer.valueOf(i));
            return false;
        }
    }

    private static byte[] b(com.tencent.beaconselfupdate.upload.a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            com.tencent.beaconselfupdate.b.a.b bVarA = aVar.a();
            if (bVarA == null) {
                return null;
            }
            com.tencent.beaconselfupdate.c.a.b("[REDACTED]", bVarA.b, bVarA.d, bVarA.c, java.lang.Integer.valueOf(bVarA.f));
            com.tencent.beaconselfupdate.d.d dVar = new com.tencent.beaconselfupdate.d.d();
            dVar.a();
            dVar.b(com.tencent.midas.api.APMidasPayAPI.ENV_TEST);
            dVar.a(com.tencent.midas.api.APMidasPayAPI.ENV_TEST);
            dVar.a(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL, bVarA);
            byte[] bArrB = dVar.b();
            com.tencent.beaconselfupdate.a.b.d dVarA = com.tencent.beaconselfupdate.a.b.d.a();
            if (dVarA != null) {
                return com.tencent.beaconselfupdate.a.e.a(bArrB, dVarA.i(), dVarA.h(), dVarA.k());
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.tencent.beaconselfupdate.c.a.d(" parseSendDatas error", new java.lang.Object[0]);
            com.tencent.beaconselfupdate.c.a.a(th);
            aVar.b();
            return null;
        }
    }

    private synchronized com.tencent.beaconselfupdate.upload.UploadHandleListener[] c() {
        java.util.List list = this.c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (com.tencent.beaconselfupdate.upload.UploadHandleListener[]) this.c.toArray(new com.tencent.beaconselfupdate.upload.UploadHandleListener[0]);
    }

    private synchronized com.tencent.beaconselfupdate.upload.d d() {
        return this.d;
    }

    private synchronized android.util.SparseArray e() {
        android.util.SparseArray sparseArray = this.b;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        new com.tencent.beaconselfupdate.c.b();
        return com.tencent.beaconselfupdate.c.b.a(this.b);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0244 A[Catch: all -> 0x0255, TRY_LEAVE, TryCatch #1 {all -> 0x0255, blocks: (B:65:0x0157, B:70:0x0174, B:72:0x017a, B:74:0x017e, B:75:0x0187, B:77:0x0198, B:78:0x01ad, B:80:0x01b7, B:82:0x01bb, B:85:0x01c8, B:88:0x01ce, B:89:0x01d0, B:90:0x01d5, B:92:0x01db, B:95:0x01e2, B:98:0x01ec, B:106:0x01fa, B:110:0x020a, B:111:0x0218, B:121:0x0244, B:115:0x0220, B:120:0x0235, B:124:0x024a, B:84:0x01bf, B:125:0x024d), top: B:147:0x0157 }] */
    @Override // com.tencent.beaconselfupdate.upload.f
    public final void a(com.tencent.beaconselfupdate.upload.a aVar) {
        java.lang.String str;
        boolean z;
        java.lang.String str2;
        java.lang.Object[] objArr;
        java.lang.String str3;
        java.lang.Object[] objArr2;
        java.lang.String strL;
        if (!this.f || !b()) {
            if (aVar.c() == 2) {
                com.tencent.beaconselfupdate.c.a.h("  Not UpProc real event sync 2 DB done false", new java.lang.Object[0]);
                aVar.b(false);
            }
            if (aVar.b != 0) {
                com.tencent.beaconselfupdate.c.a.h("  Not UpProc not req: %d", java.lang.Integer.valueOf(aVar.c()));
                return;
            }
            com.tencent.beaconselfupdate.c.a.h("  NotUpProc com req start ", new java.lang.Object[0]);
        }
        if (!com.tencent.beaconselfupdate.a.e.m(this.e)) {
            com.tencent.beaconselfupdate.c.a.c(" doUpload network is disabled!", new java.lang.Object[0]);
            if (aVar.c() == 2) {
                aVar.b(false);
                return;
            }
            return;
        }
        if (aVar == null) {
            com.tencent.beaconselfupdate.c.a.d(" upData == null ", new java.lang.Object[0]);
            return;
        }
        int iC = aVar.c();
        java.lang.String strE = aVar.e();
        int i = -1;
        if (strE == null || "".equals(strE.trim())) {
            com.tencent.beaconselfupdate.c.a.d(" url error", new java.lang.Object[0]);
            if (aVar.c() == 2) {
                aVar.b(false);
            }
            a(iC, -1, false, "url error");
            return;
        }
        byte[] bArrB = b(aVar);
        java.lang.String strD = aVar.d();
        if (strD != null) {
            str = "?rid=" + strD;
        } else {
            str = null;
        }
        com.tencent.beaconselfupdate.a.b.d dVarA = com.tencent.beaconselfupdate.a.b.d.a();
        if (dVarA != null && (strL = dVarA.l()) != null && !"".equals(strL)) {
            if (str == null) {
                str = "?sid=" + strL;
            } else {
                str = str + "&sid=" + strL;
            }
        }
        if (str != null) {
            strE = strE + str;
        }
        com.tencent.beaconselfupdate.c.a.h(" start upload cmd: %d  url:%s  datas:%s", java.lang.Integer.valueOf(iC), strE, aVar.getClass().toString());
        if (bArrB == null) {
            com.tencent.beaconselfupdate.c.a.c(" sendData is null", new java.lang.Object[0]);
            a(iC, -1, false, "sendData error");
            return;
        }
        com.tencent.beaconselfupdate.upload.d dVarD = d();
        if (dVarD == null) {
            com.tencent.beaconselfupdate.c.a.d(" reqH error", new java.lang.Object[0]);
            a(iC, -1, false, "reqHandler error");
            return;
        }
        com.tencent.beaconselfupdate.a.e.f(this.e);
        com.tencent.beaconselfupdate.a.c.m().h();
        new java.util.Date().getTime();
        try {
            byte[] bArrA = dVarD.a(strE, bArrB, aVar);
            if (bArrA == null && iC == 100 && !"http://strategy.beacon.qq.com/analytics/upload?[REDACTED]".equals(strE)) {
                bArrA = dVarD.a("http://strategy.beacon.qq.com/analytics/upload?[REDACTED]", bArrB, aVar);
            }
            com.tencent.beaconselfupdate.b.a.c cVarA = a(bArrA);
            if (cVarA != null) {
                i = cVarA.b;
                z = cVarA.f242a == 0;
                try {
                    com.tencent.beaconselfupdate.c.a.b("response.cmd:%d response.result:%d", java.lang.Integer.valueOf(cVarA.b), java.lang.Byte.valueOf(cVarA.f242a));
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        a(iC, i, false, th.toString());
                        com.tencent.beaconselfupdate.c.a.d(" req error  %s", th.toString());
                        return;
                    } finally {
                        aVar.b(z);
                    }
                }
            } else {
                z = false;
            }
            if (aVar != null && cVarA != null) {
                com.tencent.beaconselfupdate.a.c cVarM = com.tencent.beaconselfupdate.a.c.m();
                if (cVarM != null) {
                    if (cVarA.d != null) {
                        cVarM.b(cVarA.d.trim());
                    }
                    cVarM.a(cVarA.e - new java.util.Date().getTime());
                    com.tencent.beaconselfupdate.c.a.h(" fix ip:%s  tmgap: %d", cVarM.g(), java.lang.Long.valueOf(cVarM.h()));
                }
                if (cVarA.b == 101 || cVarA.b == 103 || cVarA.b == 105) {
                    com.tencent.beaconselfupdate.a.b.b.a(this.e).e();
                }
                byte[] bArr = cVarA.c;
                if (bArr == null) {
                    str2 = " no response! ";
                    objArr = new java.lang.Object[0];
                } else {
                    android.util.SparseArray sparseArrayE = e();
                    if (sparseArrayE == null || sparseArrayE.size() <= 0) {
                        str2 = " no handler! ";
                        objArr = new java.lang.Object[0];
                    } else {
                        int iC2 = aVar.c();
                        int i2 = cVarA.b;
                        if (i2 == 0) {
                            str2 = " response no datas ";
                            objArr = new java.lang.Object[0];
                        } else if (iC2 != 4) {
                            if (iC2 != 100) {
                                if (iC2 != 102) {
                                    com.tencent.beaconselfupdate.c.a.c(" unknown req: %d ", java.lang.Integer.valueOf(iC2));
                                } else if (i2 != 103) {
                                    str3 = " UNMATCH req: %d  , rep: %d";
                                    objArr2 = new java.lang.Object[]{java.lang.Integer.valueOf(iC2), java.lang.Integer.valueOf(i2)};
                                    com.tencent.beaconselfupdate.c.a.c(str3, objArr2);
                                } else {
                                    a(sparseArrayE, i2, bArr);
                                }
                            } else if (i2 != 101) {
                                str3 = " UNMATCH req: %d , rep: %d";
                                objArr2 = new java.lang.Object[]{java.lang.Integer.valueOf(iC2), java.lang.Integer.valueOf(i2)};
                                com.tencent.beaconselfupdate.c.a.c(str3, objArr2);
                            } else {
                                a(sparseArrayE, i2, bArr);
                            }
                        } else if (i2 != 105) {
                            str3 = " UNMATCH req: %d , rep: %d";
                            objArr2 = new java.lang.Object[]{java.lang.Integer.valueOf(iC2), java.lang.Integer.valueOf(i2)};
                            com.tencent.beaconselfupdate.c.a.c(str3, objArr2);
                        } else {
                            a(sparseArrayE, i2, bArr);
                        }
                    }
                }
                com.tencent.beaconselfupdate.c.a.h(str2, objArr);
            }
            a(iC, i, z, null);
            aVar.b(z);
        } catch (java.lang.Throwable th2) {
            th = th2;
            z = false;
        }
    }

    public final synchronized void a(boolean z) {
        this.g = z;
    }

    public final boolean a() {
        return this.f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.beaconselfupdate.upload.f
    public final synchronized boolean a(com.tencent.beaconselfupdate.upload.UploadHandleListener uploadHandleListener) {
        boolean z;
        if (uploadHandleListener == null) {
            z = false;
        } else {
            if (!this.c.contains(uploadHandleListener)) {
                this.c.add(uploadHandleListener);
            }
            z = true;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.beaconselfupdate.upload.f
    public final synchronized boolean a(com.tencent.beaconselfupdate.upload.e eVar) {
        boolean z;
        if (eVar == null) {
            z = false;
        } else {
            this.b.append(101, eVar);
            z = true;
        }
        return z;
    }

    public final synchronized boolean b() {
        if (com.tencent.beaconselfupdate.a.e.l(this.e)) {
            return true;
        }
        return this.g;
    }
}
