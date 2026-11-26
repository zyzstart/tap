package com.tencent.beacon.core.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k implements com.tencent.beacon.core.d.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.beacon.core.d.k f155a;
    private android.content.Context e;
    private android.util.SparseArray b = new android.util.SparseArray(5);
    private java.util.List c = new java.util.ArrayList(5);
    private java.util.ArrayList d = new java.util.ArrayList(5);
    private boolean f = true;
    private int g = 0;
    private boolean h = true;

    protected k(android.content.Context context) {
        this.e = null;
        android.content.Context applicationContext = context != null ? context.getApplicationContext() : null;
        if (applicationContext != null) {
            this.e = applicationContext;
        } else {
            this.e = context;
        }
    }

    public static synchronized com.tencent.beacon.core.d.k a(android.content.Context context) {
        if (f155a == null) {
            f155a = new com.tencent.beacon.core.d.k(context);
            com.tencent.beacon.core.e.d.h("[net] create upload handler successfully.", new java.lang.Object[0]);
        }
        return f155a;
    }

    private com.tencent.beacon.core.protocol.common.ResponsePackage a(byte[] bArr, java.lang.String str) {
        com.tencent.beacon.core.d.i iVarA;
        java.lang.String str2;
        java.lang.String str3;
        if (bArr != null) {
            try {
                com.tencent.beacon.core.strategy.g gVarB = com.tencent.beacon.core.strategy.g.b(this.e);
                byte[] bArrA = gVarB != null ? com.tencent.beacon.core.e.b.a(bArr, 2, 3, gVarB.a()) : null;
                if (bArrA != null) {
                    com.tencent.beacon.core.wup.c cVar = new com.tencent.beacon.core.wup.c();
                    cVar.a(bArrA);
                    return (com.tencent.beacon.core.protocol.common.ResponsePackage) cVar.a(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL, new com.tencent.beacon.core.protocol.common.ResponsePackage());
                }
            } catch (java.lang.Throwable th) {
                if (c().a()) {
                    iVarA = com.tencent.beacon.core.d.i.a(this.e);
                    str2 = "[net] parse received data error! url: " + str;
                    str3 = "402";
                } else {
                    iVarA = com.tencent.beacon.core.d.i.a(this.e);
                    str2 = "[net] parse received data error! url: " + str;
                    str3 = "452";
                }
                iVarA.a(str3, str2, th);
                com.tencent.beacon.core.e.d.a(th);
            }
        }
        return null;
    }

    private java.lang.String a(com.tencent.beacon.core.d.a aVar, java.lang.String str) {
        java.lang.String str2;
        java.lang.String strB;
        java.lang.String strD = aVar.d();
        if (strD != null) {
            str2 = "?rid=" + strD;
        } else {
            str2 = null;
        }
        com.tencent.beacon.core.strategy.g gVarB = com.tencent.beacon.core.strategy.g.b(this.e);
        if (gVarB != null && (strB = gVarB.b()) != null && !"".equals(strB)) {
            if (str2 == null) {
                str2 = "?sid=" + strB;
            } else {
                str2 = str2 + "&sid=" + strB;
            }
        }
        if (str2 == null) {
            return str;
        }
        return str + str2;
    }

    private void a(int i, int i2, long j, long j2, boolean z, long j3, int i3, int i4, java.lang.String str, java.lang.String str2, int i5, java.lang.String str3) {
        if (i == 0 || j == 0) {
            return;
        }
        java.util.Iterator it = d().iterator();
        while (it.hasNext()) {
            ((com.tencent.beacon.core.d.l) it.next()).record(i, z, j3, j, i3, i4, str, str2, i5, str3);
        }
    }

    private void a(int i, int i2, long j, long j2, boolean z, java.lang.String str) {
        com.tencent.beacon.upload.UploadHandleListener[] uploadHandleListenerArrB = b();
        if (uploadHandleListenerArrB != null) {
            for (com.tencent.beacon.upload.UploadHandleListener uploadHandleListener : uploadHandleListenerArrB) {
                uploadHandleListener.onUploadEnd(i, i2, j, j2, z, str);
            }
        }
    }

    private void a(com.tencent.beacon.core.protocol.common.SocketResponsePackage socketResponsePackage) {
        java.util.Map map = socketResponsePackage.header;
        if (map.containsKey(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID) && map.containsKey("max_time")) {
            com.tencent.beacon.core.strategy.g.b(this.e).a(this.e, (java.lang.String) map.get(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID), (java.lang.String) map.get("max_time"));
        }
    }

    private boolean a(android.util.SparseArray sparseArray, int i, byte[] bArr) {
        if (sparseArray == null || bArr == null) {
            return true;
        }
        com.tencent.beacon.core.d.g gVar = (com.tencent.beacon.core.d.g) sparseArray.get(i);
        if (gVar == null) {
            com.tencent.beacon.core.e.d.i("[net] no handler key:%d", java.lang.Integer.valueOf(i));
            return false;
        }
        try {
            com.tencent.beacon.core.e.d.a("[net] key:%d  handler: %s", java.lang.Integer.valueOf(i), gVar.getClass().toString());
            gVar.a(i, bArr, true);
            return true;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b("[net] handle error key:%d", java.lang.Integer.valueOf(i));
            return false;
        }
    }

    private byte[] a(com.tencent.beacon.core.d.f fVar, java.lang.String str, byte[] bArr, com.tencent.beacon.core.d.a aVar, com.tencent.beacon.core.d.c cVar) {
        byte[] bArrA = fVar.a(str, bArr, aVar, cVar);
        return (bArrA == null && aVar.c() == 100 && !"http://183.36.108.226:8080/analytics/upload".equals(str)) ? fVar.a("http://183.36.108.226:8080/analytics/upload", bArr, aVar, cVar) : bArrA;
    }

    private byte[] b(com.tencent.beacon.core.d.a aVar) {
        if (aVar == null) {
            return null;
        }
        java.lang.String strD = aVar.d();
        try {
            com.tencent.beacon.core.protocol.common.RequestPackage requestPackageF = aVar.f();
            if (requestPackageF == null) {
                return null;
            }
            com.tencent.beacon.core.e.d.a("[REDACTED]", requestPackageF.appkey, requestPackageF.sdkId, requestPackageF.appVersion, java.lang.Integer.valueOf(requestPackageF.cmd), strD);
            com.tencent.beacon.core.wup.c cVar = new com.tencent.beacon.core.wup.c();
            cVar.a(1);
            cVar.b(com.tencent.midas.api.APMidasPayAPI.ENV_TEST);
            cVar.a(com.tencent.midas.api.APMidasPayAPI.ENV_TEST);
            cVar.b(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL, requestPackageF);
            byte[] bArrA = cVar.a();
            com.tencent.beacon.core.e.d.a("[event] reqPackage to wup byte size: %d  rid:%s", java.lang.Integer.valueOf(bArrA.length), strD);
            com.tencent.beacon.core.strategy.g gVarB = com.tencent.beacon.core.strategy.g.b(this.e);
            if (gVarB == null) {
                return null;
            }
            byte[] bArrB = com.tencent.beacon.core.e.b.b(bArrA, 2, 3, gVarB.a());
            java.lang.Object[] objArr = new java.lang.Object[2];
            objArr[0] = java.lang.Integer.valueOf(bArrB == null ? 0 : bArrB.length);
            objArr[1] = strD;
            com.tencent.beacon.core.e.d.a("[event] wup through zip->encry byte size: %d   rid:%s", objArr);
            return bArrB;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.b("[event] parseSendData error  rid:%s", strD);
            com.tencent.beacon.core.e.d.a(th);
            aVar.a();
            return null;
        }
    }

    private byte[] b(com.tencent.beacon.core.d.f fVar, java.lang.String str, byte[] bArr, com.tencent.beacon.core.d.a aVar, com.tencent.beacon.core.d.c cVar) {
        return fVar.a() ? c(fVar, str, bArr, aVar, cVar) : a(fVar, str, bArr, aVar, cVar);
    }

    private byte[] c(com.tencent.beacon.core.d.f fVar, java.lang.String str, byte[] bArr, com.tencent.beacon.core.d.a aVar, com.tencent.beacon.core.d.c cVar) {
        byte[] bArrA = fVar.a(str, com.tencent.beacon.core.strategy.g.b(this.e).d(), bArr, aVar, cVar);
        if (bArrA == null) {
            return bArrA;
        }
        java.lang.String strD = aVar != null ? aVar.d() : null;
        com.tencent.beacon.core.protocol.common.SocketResponsePackage socketResponsePackageA = a(bArrA);
        com.tencent.beacon.core.e.d.a("[net] received body size:%d |statusCode:%d |header:%s |msg:%s  rid:%s", java.lang.Integer.valueOf(socketResponsePackageA.body.length), java.lang.Integer.valueOf(socketResponsePackageA.statusCode), socketResponsePackageA.header, socketResponsePackageA.msg, strD);
        a(socketResponsePackageA);
        return socketResponsePackageA.body;
    }

    protected synchronized android.util.SparseArray a() {
        android.util.SparseArray sparseArray = this.b;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        return new com.tencent.beacon.core.e.h().a(this.b);
    }

    protected com.tencent.beacon.core.protocol.common.SocketResponsePackage a(byte[] bArr) {
        com.tencent.beacon.core.protocol.common.SocketResponsePackage socketResponsePackage = new com.tencent.beacon.core.protocol.common.SocketResponsePackage();
        socketResponsePackage.readFrom(new com.tencent.beacon.core.wup.a(bArr));
        return socketResponsePackage;
    }

    public void a(com.tencent.beacon.core.d.a aVar, com.tencent.beacon.core.protocol.common.ResponsePackage responsePackage) {
        if (aVar == null || responsePackage == null) {
            return;
        }
        java.lang.String strD = aVar.d();
        com.tencent.beacon.core.info.b bVarB = com.tencent.beacon.core.info.b.b(this.e);
        if (bVarB != null) {
            java.lang.String str = responsePackage.srcGatewayIp;
            if (str != null) {
                bVarB.c(str.trim());
            }
            bVarB.a(responsePackage.serverTime - new java.util.Date().getTime());
            com.tencent.beacon.core.e.d.h("[net] fix ip:%s  tmgap: %d  rid:%s", bVarB.d(), java.lang.Long.valueOf(bVarB.j()), strD);
        }
        byte[] bArr = responsePackage.sBuffer;
        if (bArr == null) {
            com.tencent.beacon.core.e.d.h("[net] no response!  rid:%s", strD);
            return;
        }
        android.util.SparseArray sparseArrayA = a();
        if (sparseArrayA == null || sparseArrayA.size() <= 0) {
            com.tencent.beacon.core.e.d.h("[net] no handler!  rid:%s", strD);
            return;
        }
        int iC = aVar.c();
        int i = responsePackage.cmd;
        if (i == 0) {
            com.tencent.beacon.core.e.d.h("[net] response with no data  rid:%s", strD);
            return;
        }
        if (iC != 4) {
            if (iC != 100) {
                if (iC != 102) {
                    com.tencent.beacon.core.e.d.i("[net] unknown req: %d  rid:%s", java.lang.Integer.valueOf(iC), strD);
                    return;
                } else if (i != 103) {
                    com.tencent.beacon.core.e.d.i("[net] UNMATCH req: %d  , rep: %d   rid:%s", java.lang.Integer.valueOf(iC), java.lang.Integer.valueOf(i), strD);
                    return;
                }
            } else if (i != 101) {
                com.tencent.beacon.core.e.d.i("[net] UNMATCH req: %d , rep: %d   rid:%s", java.lang.Integer.valueOf(iC), java.lang.Integer.valueOf(i), strD);
                return;
            }
        } else if (i != 105) {
            com.tencent.beacon.core.e.d.i("[net] UNMATCH req: %d , rep: %d  rid:%s", java.lang.Integer.valueOf(iC), java.lang.Integer.valueOf(i), strD);
            return;
        }
        a(sparseArrayA, i, bArr);
    }

    public void a(com.tencent.beacon.core.d.l lVar) {
        this.d.add(lVar);
    }

    public synchronized void a(boolean z) {
        this.h = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.beacon.core.d.j
    public synchronized boolean a(int i, com.tencent.beacon.core.d.g gVar) {
        boolean z;
        if (gVar == null) {
            z = false;
        } else {
            this.b.append(i, gVar);
            z = true;
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:83:0x0210 A[Catch: all -> 0x0225, TryCatch #3 {all -> 0x0225, blocks: (B:81:0x0204, B:83:0x0210, B:85:0x0214), top: B:114:0x0204 }] */
    @Override // com.tencent.beacon.core.d.j
    public boolean a(com.tencent.beacon.core.d.a aVar) throws java.lang.Throwable {
        com.tencent.beacon.core.d.a aVar2;
        boolean z;
        int i;
        boolean z2;
        com.tencent.beacon.core.d.a aVar3;
        boolean z3;
        boolean z4;
        boolean z5;
        java.lang.String strValueOf;
        if (aVar == null) {
            com.tencent.beacon.core.e.d.b("[event] data is null.", new java.lang.Object[0]);
            return false;
        }
        java.lang.String strD = aVar.d();
        int iC = aVar.c();
        if (!f() || !e()) {
            if (iC != 2) {
                com.tencent.beacon.core.e.d.h("[event] NotUpProcess, don't upload, return!", new java.lang.Object[0]);
                return false;
            }
            com.tencent.beacon.core.e.d.h("[event] Not UpProc real event sync 2 DB done false", new java.lang.Object[0]);
            aVar.a(false);
            return false;
        }
        if (!com.tencent.beacon.core.e.e.c(this.e)) {
            com.tencent.beacon.core.e.d.i("[net] doUpload network is disabled or qimei is empty, rid: %1$s", strD);
            if (iC == 2) {
                aVar.a(false);
            }
            return false;
        }
        java.lang.String strE = aVar.e();
        if (strE == null || "".equals(strE.trim())) {
            com.tencent.beacon.core.e.d.b("[net] url error, rid: %1$s", strD);
            if (iC == 2) {
                aVar.a(false);
            }
            a(iC, -1, 0L, 0L, false, "url error");
            return false;
        }
        byte[] bArrB = b(aVar);
        if (bArrB == null) {
            com.tencent.beacon.core.e.d.i("[net] sendData is null, rid: %1$s", strD);
            a(iC, -1, 0L, 0L, false, "sendData error");
            return false;
        }
        com.tencent.beacon.core.d.f fVarC = c();
        if (fVarC == null) {
            com.tencent.beacon.core.e.d.b("[net] reqH is null, rid: %1$s", strD);
            a(iC, -1, 0L, 0L, false, "reqHandler error");
            return false;
        }
        if (!fVarC.a()) {
            strE = a(aVar, strE);
        }
        com.tencent.beacon.core.e.d.h("[net] start upload cmd: %d  url:%s  data type:%s,  rid:%s", java.lang.Integer.valueOf(iC), strE, aVar.getClass().getSimpleName(), strD);
        java.lang.String strL = com.tencent.beacon.core.info.e.l(this.e);
        com.tencent.beacon.core.d.c cVar = new com.tencent.beacon.core.d.c();
        long jB = com.tencent.beacon.core.e.b.b(com.tencent.beacon.core.info.b.b(this.e).j()) / 1000;
        try {
            byte[] bArrB2 = b(fVarC, strE, bArrB, aVar, cVar);
            long jF = cVar.f();
            long jD = cVar.d();
            com.tencent.beacon.core.protocol.common.ResponsePackage responsePackageA = a(bArrB2, strE);
            if (responsePackageA != null) {
                int i2 = responsePackageA.cmd;
                try {
                    z5 = responsePackageA.result == 0;
                    try {
                        com.tencent.beacon.core.e.d.a("[net] response cmd:%d result:%d, rid:%s", java.lang.Integer.valueOf(responsePackageA.cmd), java.lang.Byte.valueOf(responsePackageA.result), strD);
                        i = i2;
                        z4 = z5;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        i = i2;
                        aVar2 = aVar;
                        z = z5;
                        try {
                            long jF2 = cVar.f();
                            long jD2 = cVar.d();
                            java.lang.String strReplace = th.toString().replace("java.lang.Exception: ", "");
                            a(iC, i, jF2, jD2, false, strReplace);
                            z3 = z;
                            try {
                                a(iC, i, jF2, jD2, false, jB, (int) cVar.c(), aVar.b(), strL, cVar.b(), cVar.e(), strReplace);
                                com.tencent.beacon.core.e.d.b("[net] req error  %s, rid: %s", th.toString(), strD);
                                try {
                                    if (com.tencent.beacon.core.strategy.g.b(this.e).e()) {
                                        com.tencent.beacon.core.strategy.g.b(this.e).a(false);
                                    }
                                    aVar.a(z3);
                                    return z3;
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    z2 = z3;
                                    aVar3 = aVar;
                                    aVar3.a(z2);
                                    throw th;
                                }
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                z2 = z3;
                                aVar3 = aVar;
                                aVar3.a(z2);
                                throw th;
                            }
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            z2 = z;
                            aVar3 = aVar2;
                        }
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    i = i2;
                    iC = iC;
                    aVar2 = aVar;
                    z = false;
                    long jF3 = cVar.f();
                    long jD3 = cVar.d();
                    java.lang.String strReplace2 = th.toString().replace("java.lang.Exception: ", "");
                    a(iC, i, jF3, jD3, false, strReplace2);
                    z3 = z;
                    a(iC, i, jF3, jD3, false, jB, (int) cVar.c(), aVar.b(), strL, cVar.b(), cVar.e(), strReplace2);
                    com.tencent.beacon.core.e.d.b("[net] req error  %s, rid: %s", th.toString(), strD);
                    if (com.tencent.beacon.core.strategy.g.b(this.e).e()) {
                        com.tencent.beacon.core.strategy.g.b(this.e).a(false);
                    }
                    aVar.a(z3);
                    return z3;
                }
            } else {
                z4 = false;
                i = -1;
            }
            try {
                a(aVar, responsePackageA);
                boolean z6 = z4;
                try {
                    a(iC, i, jF, jD, z4, null);
                    if (responsePackageA != null) {
                        try {
                            strValueOf = java.lang.String.valueOf((int) responsePackageA.result);
                        } catch (java.lang.Throwable th6) {
                            th = th6;
                            iC = iC;
                            aVar2 = aVar;
                            z = z6;
                            long jF4 = cVar.f();
                            long jD4 = cVar.d();
                            java.lang.String strReplace3 = th.toString().replace("java.lang.Exception: ", "");
                            a(iC, i, jF4, jD4, false, strReplace3);
                            z3 = z;
                            a(iC, i, jF4, jD4, false, jB, (int) cVar.c(), aVar.b(), strL, cVar.b(), cVar.e(), strReplace3);
                            com.tencent.beacon.core.e.d.b("[net] req error  %s, rid: %s", th.toString(), strD);
                            if (com.tencent.beacon.core.strategy.g.b(this.e).e() && (th instanceof java.net.ConnectException)) {
                                com.tencent.beacon.core.strategy.g.b(this.e).a(false);
                            }
                            aVar.a(z3);
                            return z3;
                        }
                    } else {
                        strValueOf = "response null";
                    }
                    try {
                        a(iC, i, jF, jD, z6, jB, (int) cVar.c(), aVar.b(), strL, cVar.b(), cVar.e(), strValueOf);
                        aVar.a(z6);
                        return z6;
                    } catch (java.lang.Throwable th7) {
                        th = th7;
                        z5 = z6;
                        aVar2 = aVar;
                        z = z5;
                        long jF5 = cVar.f();
                        long jD5 = cVar.d();
                        java.lang.String strReplace4 = th.toString().replace("java.lang.Exception: ", "");
                        a(iC, i, jF5, jD5, false, strReplace4);
                        z3 = z;
                        a(iC, i, jF5, jD5, false, jB, (int) cVar.c(), aVar.b(), strL, cVar.b(), cVar.e(), strReplace4);
                        com.tencent.beacon.core.e.d.b("[net] req error  %s, rid: %s", th.toString(), strD);
                        if (com.tencent.beacon.core.strategy.g.b(this.e).e()) {
                            com.tencent.beacon.core.strategy.g.b(this.e).a(false);
                        }
                        aVar.a(z3);
                        return z3;
                    }
                } catch (java.lang.Throwable th8) {
                    th = th8;
                    aVar2 = aVar;
                    z5 = z6;
                }
            } catch (java.lang.Throwable th9) {
                th = th9;
                z5 = z4;
                aVar2 = aVar;
                z = z5;
                long jF6 = cVar.f();
                long jD6 = cVar.d();
                java.lang.String strReplace5 = th.toString().replace("java.lang.Exception: ", "");
                a(iC, i, jF6, jD6, false, strReplace5);
                z3 = z;
                a(iC, i, jF6, jD6, false, jB, (int) cVar.c(), aVar.b(), strL, cVar.b(), cVar.e(), strReplace5);
                com.tencent.beacon.core.e.d.b("[net] req error  %s, rid: %s", th.toString(), strD);
                if (com.tencent.beacon.core.strategy.g.b(this.e).e()) {
                    com.tencent.beacon.core.strategy.g.b(this.e).a(false);
                }
                aVar.a(z3);
                return z3;
            }
        } catch (java.lang.Throwable th10) {
            th = th10;
            iC = iC;
            aVar2 = aVar;
            z = false;
            i = -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean a(com.tencent.beacon.upload.UploadHandleListener uploadHandleListener) {
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

    public synchronized void b(boolean z) {
        this.f = z;
    }

    protected synchronized com.tencent.beacon.upload.UploadHandleListener[] b() {
        java.util.List list = this.c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (com.tencent.beacon.upload.UploadHandleListener[]) this.c.toArray(new com.tencent.beacon.upload.UploadHandleListener[0]);
    }

    protected synchronized com.tencent.beacon.core.d.f c() {
        return com.tencent.beacon.core.d.f.a(this.e);
    }

    public java.util.ArrayList d() {
        return this.d;
    }

    public synchronized boolean e() {
        return this.h;
    }

    public synchronized boolean f() {
        return this.f;
    }
}
