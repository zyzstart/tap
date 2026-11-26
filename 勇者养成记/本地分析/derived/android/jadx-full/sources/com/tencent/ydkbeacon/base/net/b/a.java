package com.tencent.ydkbeacon.base.net.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a extends com.tencent.ydkbeacon.base.net.b.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tencent.ydkbeacon.base.net.b.a.C0042a f1223a = new com.tencent.ydkbeacon.base.net.b.a.C0042a();
    private final com.tencent.ydkbeacon.base.net.b.a.b b = new com.tencent.ydkbeacon.base.net.b.a.b();

    /* JADX INFO: renamed from: com.tencent.ydkbeacon.base.net.b.a$a, reason: collision with other inner class name */
    static final class C0042a implements com.tencent.ydkbeacon.base.net.b.c {
        C0042a() {
        }

        private byte[] a(byte[] bArr) {
            com.tencent.ydkbeacon.d.g gVarB = com.tencent.ydkbeacon.d.g.b();
            return gVarB != null ? com.tencent.ydkbeacon.a.e.b.b(bArr, 2, 3, gVarB.a()) : bArr;
        }

        private byte[] b(com.tencent.ydkbeacon.pack.RequestPackage requestPackage) {
            com.tencent.ydkbeacon.pack.c cVar = new com.tencent.ydkbeacon.pack.c();
            cVar.a(1);
            cVar.b(com.tencent.midas.api.APMidasPayAPI.ENV_TEST);
            cVar.a(com.tencent.midas.api.APMidasPayAPI.ENV_TEST);
            cVar.b(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL, requestPackage);
            return cVar.a();
        }

        @Override // com.tencent.ydkbeacon.base.net.b.c
        public byte[] a(com.tencent.ydkbeacon.pack.RequestPackage requestPackage) {
            if (requestPackage == null) {
                return null;
            }
            com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "RequestPackage: " + requestPackage.toString(), new java.lang.Object[0]);
            byte[] bArrA = a(b(requestPackage));
            if (bArrA != null) {
                com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "request package after processing size: " + bArrA.length, new java.lang.Object[0]);
            }
            return bArrA;
        }
    }

    static final class b implements com.tencent.ydkbeacon.base.net.b.c {
        b() {
        }

        private com.tencent.ydkbeacon.pack.ResponsePackage b(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            try {
                if (bArr.length <= 0) {
                    return null;
                }
                com.tencent.ydkbeacon.pack.c cVar = new com.tencent.ydkbeacon.pack.c();
                cVar.a(bArr);
                return (com.tencent.ydkbeacon.pack.ResponsePackage) cVar.a(com.tencent.ysdk.shell.module.report.impl.ReportComm.DETAIL, new com.tencent.ydkbeacon.pack.ResponsePackage());
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }

        private byte[] c(byte[] bArr) {
            return com.tencent.ydkbeacon.a.e.b.a(bArr, 2, 3, com.tencent.ydkbeacon.d.g.b().a());
        }

        @Override // com.tencent.ydkbeacon.base.net.b.c
        public com.tencent.ydkbeacon.pack.ResponsePackage a(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            return b(c(bArr));
        }
    }

    public static com.tencent.ydkbeacon.base.net.b.a a() {
        return new com.tencent.ydkbeacon.base.net.b.a();
    }

    public com.tencent.ydkbeacon.base.net.b.c b() {
        return this.b;
    }

    public com.tencent.ydkbeacon.base.net.b.c c() {
        return this.f1223a;
    }
}
