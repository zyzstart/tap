package com.tencent.ydkbeacon.base.net.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class h implements com.tencent.ydkbeacon.base.net.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.base.net.a.b f1212a;
    final /* synthetic */ com.tencent.ydkbeacon.base.net.a.i b;

    h(com.tencent.ydkbeacon.base.net.a.i iVar, com.tencent.ydkbeacon.base.net.a.b bVar) {
        this.b = iVar;
        this.f1212a = bVar;
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(com.tencent.ydkbeacon.base.net.e eVar) {
        com.tencent.ydkbeacon.base.net.a.b bVar = this.f1212a;
        if (bVar != null) {
            bVar.a(eVar);
        }
    }

    @Override // com.tencent.ydkbeacon.base.net.a.b
    public void a(byte[] bArr) throws com.tencent.ydkbeacon.base.net.NetException {
        com.tencent.ydkbeacon.pack.ResponseCommon responseCommon;
        byte[] bArr2;
        com.tencent.ydkbeacon.a.e.c.a("[BeaconNet]", "raw response size: " + bArr.length, new java.lang.Object[0]);
        if (this.b.f1213a.g() == com.tencent.ydkbeacon.base.net.RequestType.EVENT) {
            responseCommon = (com.tencent.ydkbeacon.pack.ResponseCommon) com.tencent.ydkbeacon.base.net.d.c().e.b().a(bArr);
            if (responseCommon == null) {
                throw new com.tencent.ydkbeacon.base.net.NetException("ResponsePackageV2 == null");
            }
            bArr2 = null;
        } else {
            responseCommon = (com.tencent.ydkbeacon.pack.ResponseCommon) com.tencent.ydkbeacon.base.net.d.c().d.b().a(bArr);
            if (responseCommon == null) {
                throw new com.tencent.ydkbeacon.base.net.NetException("responsePackage == null");
            }
            com.tencent.ydkbeacon.pack.ResponsePackage responsePackage = (com.tencent.ydkbeacon.pack.ResponsePackage) responseCommon;
            if (responsePackage.cmd != this.b.f1213a.f()) {
                throw new com.tencent.ydkbeacon.base.net.NetException("responsePackage.cmd != requestEntity.responseCmd");
            }
            if (responsePackage.result != 0) {
                throw new com.tencent.ydkbeacon.base.net.NetException("responsePackage.result != OK(0)");
            }
            bArr2 = responsePackage.sBuffer;
            if (bArr2 == null || bArr2.length <= 0) {
                throw new com.tencent.ydkbeacon.base.net.NetException("responsePackage.buffer == null");
            }
        }
        com.tencent.ydkbeacon.base.net.c.d.a(responseCommon.serverTime, responseCommon.srcGatewayIp);
        com.tencent.ydkbeacon.base.net.a.b bVar = this.f1212a;
        if (bVar != null) {
            bVar.a(bArr2);
        }
    }
}
