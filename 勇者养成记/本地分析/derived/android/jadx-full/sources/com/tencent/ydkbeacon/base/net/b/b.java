package com.tencent.ydkbeacon.base.net.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends com.tencent.ydkbeacon.base.net.b.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tencent.ydkbeacon.base.net.b.b.a f1224a = new com.tencent.ydkbeacon.base.net.b.b.a();
    private final com.tencent.ydkbeacon.base.net.b.b.C0043b b = new com.tencent.ydkbeacon.base.net.b.b.C0043b();

    static final class a implements com.tencent.ydkbeacon.base.net.b.c {
        a() {
        }

        private byte[] a(byte[] bArr) {
            com.tencent.ydkbeacon.d.g gVarB = com.tencent.ydkbeacon.d.g.b();
            return gVarB != null ? com.tencent.ydkbeacon.a.e.b.b(bArr, 2, 3, gVarB.a()) : bArr;
        }

        @Override // com.tencent.ydkbeacon.base.net.b.c
        public byte[] a(com.tencent.ydkbeacon.pack.RequestPackageV2 requestPackageV2) {
            if (requestPackageV2 == null) {
                return null;
            }
            com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "RequestPackageV2: " + requestPackageV2.toString(), new java.lang.Object[0]);
            com.tencent.ydkbeacon.pack.b bVar = new com.tencent.ydkbeacon.pack.b();
            requestPackageV2.writeTo(bVar);
            byte[] bArrA = a(bVar.b());
            if (bArrA != null) {
                com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "request package after processing size: " + bArrA.length, new java.lang.Object[0]);
            }
            return bArrA;
        }
    }

    /* JADX INFO: renamed from: com.tencent.ydkbeacon.base.net.b.b$b, reason: collision with other inner class name */
    static final class C0043b implements com.tencent.ydkbeacon.base.net.b.c {
        C0043b() {
        }

        private byte[] b(byte[] bArr) {
            return com.tencent.ydkbeacon.a.e.b.a(bArr, 2, 3, com.tencent.ydkbeacon.d.g.b().a());
        }

        @Override // com.tencent.ydkbeacon.base.net.b.c
        public com.tencent.ydkbeacon.pack.ResponsePackageV2 a(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            byte[] bArrB = b(bArr);
            com.tencent.ydkbeacon.pack.ResponsePackageV2 responsePackageV2 = new com.tencent.ydkbeacon.pack.ResponsePackageV2();
            responsePackageV2.readFrom(new com.tencent.ydkbeacon.pack.a(bArrB));
            return responsePackageV2;
        }
    }

    public static com.tencent.ydkbeacon.base.net.b.b a() {
        return new com.tencent.ydkbeacon.base.net.b.b();
    }

    public com.tencent.ydkbeacon.base.net.b.c b() {
        return this.b;
    }

    public com.tencent.ydkbeacon.base.net.b.c c() {
        return this.f1224a;
    }
}
